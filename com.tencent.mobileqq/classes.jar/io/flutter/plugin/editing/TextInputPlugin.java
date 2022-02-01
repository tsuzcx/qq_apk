package io.flutter.plugin.editing;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.Selection;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewStructure;
import android.view.WindowInsets.Type;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
import io.flutter.embedding.engine.systemchannels.TextInputChannel.Configuration;
import io.flutter.embedding.engine.systemchannels.TextInputChannel.Configuration.Autofill;
import io.flutter.embedding.engine.systemchannels.TextInputChannel.InputType;
import io.flutter.embedding.engine.systemchannels.TextInputChannel.TextCapitalization;
import io.flutter.embedding.engine.systemchannels.TextInputChannel.TextEditState;
import io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputType;
import io.flutter.plugin.platform.PlatformViewsController;
import java.util.HashMap;

public class TextInputPlugin
{
  @NonNull
  private final AutofillManager afm;
  @Nullable
  private TextInputChannel.Configuration configuration;
  private ImeSyncDeferringInsetsCallback imeSyncCallback;
  @NonNull
  private TextInputPlugin.InputTarget inputTarget;
  private boolean isInputConnectionLocked;
  @Nullable
  private Rect lastClientRect;
  @Nullable
  private InputConnection lastInputConnection;
  @Nullable
  private SparseArray<TextInputChannel.Configuration> mAutofillConfigurations;
  @Nullable
  private Editable mEditable;
  @NonNull
  private final InputMethodManager mImm;
  private boolean mRestartInputPending;
  @NonNull
  private final View mView;
  @NonNull
  private PlatformViewsController platformViewsController;
  private final boolean restartAlwaysRequired;
  @NonNull
  private final TextInputChannel textInputChannel;
  
  @SuppressLint({"NewApi"})
  public TextInputPlugin(View paramView, @NonNull TextInputChannel paramTextInputChannel, @NonNull PlatformViewsController paramPlatformViewsController)
  {
    Object localObject = TextInputPlugin.InputTarget.Type.NO_TARGET;
    int i = 0;
    this.inputTarget = new TextInputPlugin.InputTarget((TextInputPlugin.InputTarget.Type)localObject, 0);
    this.mView = paramView;
    this.mImm = ((InputMethodManager)paramView.getContext().getSystemService("input_method"));
    if (Build.VERSION.SDK_INT >= 26) {
      localObject = (AutofillManager)paramView.getContext().getSystemService(AutofillManager.class);
    } else {
      localObject = null;
    }
    this.afm = ((AutofillManager)localObject);
    if (Build.VERSION.SDK_INT >= 30)
    {
      if ((this.mView.getWindowSystemUiVisibility() & 0x2) == 0) {
        i = 0x0 | WindowInsets.Type.navigationBars();
      }
      int j = i;
      if ((this.mView.getWindowSystemUiVisibility() & 0x4) == 0) {
        j = i | WindowInsets.Type.statusBars();
      }
      this.imeSyncCallback = new ImeSyncDeferringInsetsCallback(paramView, j, WindowInsets.Type.ime());
      this.imeSyncCallback.install();
    }
    this.textInputChannel = paramTextInputChannel;
    paramTextInputChannel.setTextInputMethodHandler(new TextInputPlugin.1(this));
    paramTextInputChannel.requestExistingInputState();
    this.platformViewsController = paramPlatformViewsController;
    this.platformViewsController.attachTextInputPlugin(this);
    this.restartAlwaysRequired = isRestartAlwaysRequired();
  }
  
  private void applyStateToSelection(TextInputChannel.TextEditState paramTextEditState)
  {
    int i = paramTextEditState.selectionStart;
    int j = paramTextEditState.selectionEnd;
    if ((i >= 0) && (i <= this.mEditable.length()) && (j >= 0) && (j <= this.mEditable.length()))
    {
      Selection.setSelection(this.mEditable, i, j);
      return;
    }
    Selection.removeSelection(this.mEditable);
  }
  
  private void clearTextInputClient()
  {
    if (this.inputTarget.type == TextInputPlugin.InputTarget.Type.PLATFORM_VIEW) {
      return;
    }
    this.inputTarget = new TextInputPlugin.InputTarget(TextInputPlugin.InputTarget.Type.NO_TARGET, 0);
    unlockPlatformViewInputConnection();
    notifyViewExited();
    this.lastClientRect = null;
  }
  
  private void hideTextInput(View paramView)
  {
    notifyViewExited();
    this.mImm.hideSoftInputFromWindow(paramView.getApplicationWindowToken(), 0);
  }
  
  private static int inputTypeFromTextInputType(TextInputChannel.InputType paramInputType, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, TextInputChannel.TextCapitalization paramTextCapitalization)
  {
    if (paramInputType.type == TextInputChannel.TextInputType.DATETIME) {
      return 4;
    }
    if (paramInputType.type == TextInputChannel.TextInputType.NUMBER)
    {
      i = 2;
      if (paramInputType.isSigned) {
        i = 4098;
      }
      j = i;
      if (paramInputType.isDecimal) {
        j = i | 0x2000;
      }
      return j;
    }
    if (paramInputType.type == TextInputChannel.TextInputType.PHONE) {
      return 3;
    }
    int i = 1;
    if (paramInputType.type == TextInputChannel.TextInputType.MULTILINE) {
      i = 131073;
    } else if (paramInputType.type == TextInputChannel.TextInputType.EMAIL_ADDRESS) {
      i = 33;
    } else if (paramInputType.type == TextInputChannel.TextInputType.URL) {
      i = 17;
    } else if (paramInputType.type == TextInputChannel.TextInputType.VISIBLE_PASSWORD) {
      i = 145;
    } else if (paramInputType.type == TextInputChannel.TextInputType.NAME) {
      i = 97;
    } else if (paramInputType.type == TextInputChannel.TextInputType.POSTAL_ADDRESS) {
      i = 113;
    }
    if (paramBoolean1)
    {
      i = 0x80000 | i | 0x80;
    }
    else
    {
      j = i;
      if (paramBoolean2) {
        j = i | 0x8000;
      }
      if (!paramBoolean3) {
        i = 0x80000 | j;
      } else {
        i = j;
      }
    }
    if (paramTextCapitalization == TextInputChannel.TextCapitalization.CHARACTERS) {
      return i | 0x1000;
    }
    if (paramTextCapitalization == TextInputChannel.TextCapitalization.WORDS) {
      return i | 0x2000;
    }
    int j = i;
    if (paramTextCapitalization == TextInputChannel.TextCapitalization.SENTENCES) {
      j = i | 0x4000;
    }
    return j;
  }
  
  @SuppressLint({"NewApi"})
  private boolean isRestartAlwaysRequired()
  {
    if ((this.mImm.getCurrentInputMethodSubtype() != null) && (Build.VERSION.SDK_INT >= 21))
    {
      if (!Build.MANUFACTURER.equals("samsung")) {
        return false;
      }
      String str = Settings.Secure.getString(this.mView.getContext().getContentResolver(), "default_input_method");
      if (str == null) {
        return false;
      }
      return str.contains("Samsung");
    }
    return false;
  }
  
  private boolean needsAutofill()
  {
    return this.mAutofillConfigurations != null;
  }
  
  private void notifyValueChanged(String paramString)
  {
    if ((Build.VERSION.SDK_INT >= 26) && (this.afm != null))
    {
      if (!needsAutofill()) {
        return;
      }
      String str = this.configuration.autofill.uniqueIdentifier;
      this.afm.notifyValueChanged(this.mView, str.hashCode(), AutofillValue.forText(paramString));
    }
  }
  
  private void notifyViewEntered()
  {
    if ((Build.VERSION.SDK_INT >= 26) && (this.afm != null))
    {
      if (!needsAutofill()) {
        return;
      }
      String str = this.configuration.autofill.uniqueIdentifier;
      int[] arrayOfInt = new int[2];
      this.mView.getLocationOnScreen(arrayOfInt);
      Rect localRect = new Rect(this.lastClientRect);
      localRect.offset(arrayOfInt[0], arrayOfInt[1]);
      this.afm.notifyViewEntered(this.mView, str.hashCode(), localRect);
    }
  }
  
  private void notifyViewExited()
  {
    if ((Build.VERSION.SDK_INT >= 26) && (this.afm != null))
    {
      Object localObject = this.configuration;
      if (localObject != null)
      {
        if (((TextInputChannel.Configuration)localObject).autofill == null) {
          return;
        }
        localObject = this.configuration.autofill.uniqueIdentifier;
        this.afm.notifyViewExited(this.mView, ((String)localObject).hashCode());
      }
    }
  }
  
  private void saveEditableSizeAndTransform(double paramDouble1, double paramDouble2, double[] paramArrayOfDouble)
  {
    double[] arrayOfDouble = new double[4];
    boolean bool;
    if ((paramArrayOfDouble[3] == 0.0D) && (paramArrayOfDouble[7] == 0.0D) && (paramArrayOfDouble[15] == 1.0D)) {
      bool = true;
    } else {
      bool = false;
    }
    double d = paramArrayOfDouble[12] / paramArrayOfDouble[15];
    arrayOfDouble[1] = d;
    arrayOfDouble[0] = d;
    d = paramArrayOfDouble[13] / paramArrayOfDouble[15];
    arrayOfDouble[3] = d;
    arrayOfDouble[2] = d;
    paramArrayOfDouble = new TextInputPlugin.2(this, bool, paramArrayOfDouble, arrayOfDouble);
    paramArrayOfDouble.inspect(paramDouble1, 0.0D);
    paramArrayOfDouble.inspect(paramDouble1, paramDouble2);
    paramArrayOfDouble.inspect(0.0D, paramDouble2);
    paramArrayOfDouble = Float.valueOf(this.mView.getContext().getResources().getDisplayMetrics().density);
    paramDouble1 = arrayOfDouble[0];
    paramDouble2 = paramArrayOfDouble.floatValue();
    Double.isNaN(paramDouble2);
    Double.isNaN(paramDouble2);
    int i = (int)(paramDouble1 * paramDouble2);
    paramDouble1 = arrayOfDouble[2];
    paramDouble2 = paramArrayOfDouble.floatValue();
    Double.isNaN(paramDouble2);
    Double.isNaN(paramDouble2);
    int j = (int)(paramDouble1 * paramDouble2);
    paramDouble1 = arrayOfDouble[1];
    paramDouble2 = paramArrayOfDouble.floatValue();
    Double.isNaN(paramDouble2);
    Double.isNaN(paramDouble2);
    int k = (int)Math.ceil(paramDouble1 * paramDouble2);
    paramDouble1 = arrayOfDouble[3];
    paramDouble2 = paramArrayOfDouble.floatValue();
    Double.isNaN(paramDouble2);
    Double.isNaN(paramDouble2);
    this.lastClientRect = new Rect(i, j, k, (int)Math.ceil(paramDouble1 * paramDouble2));
  }
  
  private void setPlatformViewTextInputClient(int paramInt)
  {
    this.mView.requestFocus();
    this.inputTarget = new TextInputPlugin.InputTarget(TextInputPlugin.InputTarget.Type.PLATFORM_VIEW, paramInt);
    this.mImm.restartInput(this.mView);
    this.mRestartInputPending = false;
  }
  
  private void showTextInput(View paramView)
  {
    paramView.requestFocus();
    this.mImm.showSoftInput(paramView, 0);
  }
  
  private void updateAutofillConfigurationIfNeeded(TextInputChannel.Configuration paramConfiguration)
  {
    notifyViewExited();
    this.configuration = paramConfiguration;
    TextInputChannel.Configuration[] arrayOfConfiguration = paramConfiguration.fields;
    if (paramConfiguration.autofill == null)
    {
      this.mAutofillConfigurations = null;
      return;
    }
    this.mAutofillConfigurations = new SparseArray();
    if (arrayOfConfiguration == null)
    {
      this.mAutofillConfigurations.put(paramConfiguration.autofill.uniqueIdentifier.hashCode(), paramConfiguration);
      return;
    }
    int j = arrayOfConfiguration.length;
    int i = 0;
    while (i < j)
    {
      paramConfiguration = arrayOfConfiguration[i];
      TextInputChannel.Configuration.Autofill localAutofill = paramConfiguration.autofill;
      if (localAutofill != null) {
        this.mAutofillConfigurations.put(localAutofill.uniqueIdentifier.hashCode(), paramConfiguration);
      }
      i += 1;
    }
  }
  
  public void autofill(SparseArray<AutofillValue> paramSparseArray)
  {
    if (Build.VERSION.SDK_INT < 26) {
      return;
    }
    TextInputChannel.Configuration.Autofill localAutofill = this.configuration.autofill;
    if (localAutofill == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramSparseArray.size())
    {
      int j = paramSparseArray.keyAt(i);
      Object localObject1 = (TextInputChannel.Configuration)this.mAutofillConfigurations.get(j);
      if ((localObject1 != null) && (((TextInputChannel.Configuration)localObject1).autofill != null))
      {
        localObject1 = ((TextInputChannel.Configuration)localObject1).autofill;
        Object localObject2 = ((AutofillValue)paramSparseArray.valueAt(i)).getTextValue().toString();
        localObject2 = new TextInputChannel.TextEditState((String)localObject2, ((String)localObject2).length(), ((String)localObject2).length());
        if (((TextInputChannel.Configuration.Autofill)localObject1).uniqueIdentifier.equals(localAutofill.uniqueIdentifier)) {
          setTextInputEditingState(this.mView, (TextInputChannel.TextEditState)localObject2);
        }
        localHashMap.put(((TextInputChannel.Configuration.Autofill)localObject1).uniqueIdentifier, localObject2);
      }
      i += 1;
    }
    this.textInputChannel.updateEditingStateWithTag(this.inputTarget.id, localHashMap);
  }
  
  public void clearPlatformViewClient(int paramInt)
  {
    if ((this.inputTarget.type == TextInputPlugin.InputTarget.Type.PLATFORM_VIEW) && (this.inputTarget.id == paramInt))
    {
      this.inputTarget = new TextInputPlugin.InputTarget(TextInputPlugin.InputTarget.Type.NO_TARGET, 0);
      hideTextInput(this.mView);
      this.mImm.restartInput(this.mView);
      this.mRestartInputPending = false;
    }
  }
  
  public InputConnection createInputConnection(View paramView, EditorInfo paramEditorInfo)
  {
    if (this.inputTarget.type == TextInputPlugin.InputTarget.Type.NO_TARGET)
    {
      this.lastInputConnection = null;
      return null;
    }
    if (this.inputTarget.type == TextInputPlugin.InputTarget.Type.PLATFORM_VIEW)
    {
      if (this.isInputConnectionLocked) {
        return this.lastInputConnection;
      }
      this.lastInputConnection = this.platformViewsController.getPlatformViewById(Integer.valueOf(this.inputTarget.id)).onCreateInputConnection(paramEditorInfo);
      return this.lastInputConnection;
    }
    paramEditorInfo.inputType = inputTypeFromTextInputType(this.configuration.inputType, this.configuration.obscureText, this.configuration.autocorrect, this.configuration.enableSuggestions, this.configuration.textCapitalization);
    paramEditorInfo.imeOptions = 33554432;
    int i;
    if (this.configuration.inputAction == null)
    {
      if ((0x20000 & paramEditorInfo.inputType) != 0) {
        i = 1;
      } else {
        i = 6;
      }
    }
    else {
      i = this.configuration.inputAction.intValue();
    }
    if (this.configuration.actionLabel != null)
    {
      paramEditorInfo.actionLabel = this.configuration.actionLabel;
      paramEditorInfo.actionId = i;
    }
    paramEditorInfo.imeOptions = (i | paramEditorInfo.imeOptions);
    paramView = new InputConnectionAdaptor(paramView, this.inputTarget.id, this.textInputChannel, this.mEditable, paramEditorInfo);
    paramEditorInfo.initialSelStart = Selection.getSelectionStart(this.mEditable);
    paramEditorInfo.initialSelEnd = Selection.getSelectionEnd(this.mEditable);
    this.lastInputConnection = paramView;
    return this.lastInputConnection;
  }
  
  @SuppressLint({"NewApi"})
  public void destroy()
  {
    this.platformViewsController.detachTextInputPlugin();
    this.textInputChannel.setTextInputMethodHandler(null);
    ImeSyncDeferringInsetsCallback localImeSyncDeferringInsetsCallback = this.imeSyncCallback;
    if (localImeSyncDeferringInsetsCallback != null) {
      localImeSyncDeferringInsetsCallback.remove();
    }
  }
  
  @VisibleForTesting
  Editable getEditable()
  {
    return this.mEditable;
  }
  
  @VisibleForTesting
  ImeSyncDeferringInsetsCallback getImeSyncCallback()
  {
    return this.imeSyncCallback;
  }
  
  @NonNull
  public InputMethodManager getInputMethodManager()
  {
    return this.mImm;
  }
  
  @Nullable
  public InputConnection getLastInputConnection()
  {
    return this.lastInputConnection;
  }
  
  public void lockPlatformViewInputConnection()
  {
    if (this.inputTarget.type == TextInputPlugin.InputTarget.Type.PLATFORM_VIEW) {
      this.isInputConnectionLocked = true;
    }
  }
  
  public void onProvideAutofillVirtualStructure(ViewStructure paramViewStructure, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      if (!needsAutofill()) {
        return;
      }
      String str = this.configuration.autofill.uniqueIdentifier;
      AutofillId localAutofillId = paramViewStructure.getAutofillId();
      paramInt = 0;
      while (paramInt < this.mAutofillConfigurations.size())
      {
        int i = this.mAutofillConfigurations.keyAt(paramInt);
        Object localObject = ((TextInputChannel.Configuration)this.mAutofillConfigurations.valueAt(paramInt)).autofill;
        if (localObject != null)
        {
          paramViewStructure.addChildCount(1);
          ViewStructure localViewStructure = paramViewStructure.newChild(paramInt);
          localViewStructure.setAutofillId(localAutofillId, i);
          localViewStructure.setAutofillValue(AutofillValue.forText(((TextInputChannel.Configuration.Autofill)localObject).editState.text));
          localViewStructure.setAutofillHints(((TextInputChannel.Configuration.Autofill)localObject).hints);
          localViewStructure.setAutofillType(1);
          localViewStructure.setVisibility(0);
          if (str.hashCode() == i)
          {
            localObject = this.lastClientRect;
            if (localObject != null)
            {
              i = ((Rect)localObject).left;
              j = this.lastClientRect.top;
              k = this.lastClientRect.width();
              m = this.lastClientRect.height();
              break label206;
            }
          }
          i = 0;
          int j = 0;
          int k = 1;
          int m = 1;
          label206:
          localViewStructure.setDimens(i, j, 0, 0, k, m);
        }
        paramInt += 1;
      }
    }
  }
  
  public void sendTextInputAppPrivateCommand(String paramString, Bundle paramBundle)
  {
    this.mImm.sendAppPrivateCommand(this.mView, paramString, paramBundle);
  }
  
  @VisibleForTesting
  void setTextInputClient(int paramInt, TextInputChannel.Configuration paramConfiguration)
  {
    this.inputTarget = new TextInputPlugin.InputTarget(TextInputPlugin.InputTarget.Type.FRAMEWORK_CLIENT, paramInt);
    updateAutofillConfigurationIfNeeded(paramConfiguration);
    this.mEditable = Editable.Factory.getInstance().newEditable("");
    this.mRestartInputPending = true;
    unlockPlatformViewInputConnection();
    this.lastClientRect = null;
  }
  
  @VisibleForTesting
  void setTextInputEditingState(View paramView, TextInputChannel.TextEditState paramTextEditState)
  {
    if (!paramTextEditState.text.equals(this.mEditable.toString()))
    {
      Editable localEditable = this.mEditable;
      localEditable.replace(0, localEditable.length(), paramTextEditState.text);
    }
    notifyValueChanged(this.mEditable.toString());
    applyStateToSelection(paramTextEditState);
    paramTextEditState = getLastInputConnection();
    if ((paramTextEditState != null) && ((paramTextEditState instanceof InputConnectionAdaptor))) {
      ((InputConnectionAdaptor)paramTextEditState).markDirty();
    }
    if ((!this.restartAlwaysRequired) && (!this.mRestartInputPending))
    {
      this.mImm.updateSelection(this.mView, Math.max(Selection.getSelectionStart(this.mEditable), 0), Math.max(Selection.getSelectionEnd(this.mEditable), 0), BaseInputConnection.getComposingSpanStart(this.mEditable), BaseInputConnection.getComposingSpanEnd(this.mEditable));
      return;
    }
    this.mImm.restartInput(paramView);
    this.mRestartInputPending = false;
  }
  
  public void unlockPlatformViewInputConnection()
  {
    this.isInputConnectionLocked = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.plugin.editing.TextInputPlugin
 * JD-Core Version:    0.7.0.1
 */