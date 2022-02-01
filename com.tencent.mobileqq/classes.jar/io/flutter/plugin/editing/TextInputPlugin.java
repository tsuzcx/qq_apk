package io.flutter.plugin.editing;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.Selection;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
import io.flutter.embedding.engine.systemchannels.TextInputChannel.Configuration;
import io.flutter.embedding.engine.systemchannels.TextInputChannel.InputType;
import io.flutter.embedding.engine.systemchannels.TextInputChannel.TextCapitalization;
import io.flutter.embedding.engine.systemchannels.TextInputChannel.TextEditState;
import io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputType;
import io.flutter.plugin.platform.PlatformViewsController;

public class TextInputPlugin
{
  @Nullable
  private TextInputChannel.Configuration configuration;
  @NonNull
  private TextInputPlugin.InputTarget inputTarget = new TextInputPlugin.InputTarget(TextInputPlugin.InputTarget.Type.NO_TARGET, 0);
  private boolean isInputConnectionLocked;
  @Nullable
  private InputConnection lastInputConnection;
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
  
  public TextInputPlugin(View paramView, @NonNull DartExecutor paramDartExecutor, @NonNull PlatformViewsController paramPlatformViewsController)
  {
    this.mView = paramView;
    this.mImm = ((InputMethodManager)paramView.getContext().getSystemService("input_method"));
    this.textInputChannel = new TextInputChannel(paramDartExecutor);
    this.textInputChannel.setTextInputMethodHandler(new TextInputPlugin.1(this));
    this.textInputChannel.requestExistingInputState();
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
  }
  
  private void hideTextInput(View paramView)
  {
    this.mImm.hideSoftInputFromWindow(paramView.getApplicationWindowToken(), 0);
  }
  
  private static int inputTypeFromTextInputType(TextInputChannel.InputType paramInputType, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, TextInputChannel.TextCapitalization paramTextCapitalization)
  {
    int j;
    if (paramInputType.type == TextInputChannel.TextInputType.DATETIME) {
      j = 4;
    }
    int i;
    label170:
    label203:
    do
    {
      do
      {
        return j;
        if (paramInputType.type != TextInputChannel.TextInputType.NUMBER) {
          break;
        }
        i = 2;
        if (paramInputType.isSigned) {
          i = 4098;
        }
        j = i;
      } while (!paramInputType.isDecimal);
      return i | 0x2000;
      if (paramInputType.type == TextInputChannel.TextInputType.PHONE) {
        return 3;
      }
      i = 1;
      if (paramInputType.type == TextInputChannel.TextInputType.MULTILINE)
      {
        i = 131073;
        if (!paramBoolean1) {
          break label170;
        }
        i = i | 0x80000 | 0x80;
      }
      for (;;)
      {
        if (paramTextCapitalization != TextInputChannel.TextCapitalization.CHARACTERS) {
          break label203;
        }
        return i | 0x1000;
        if (paramInputType.type == TextInputChannel.TextInputType.EMAIL_ADDRESS)
        {
          i = 33;
          break;
        }
        if (paramInputType.type == TextInputChannel.TextInputType.URL)
        {
          i = 17;
          break;
        }
        if (paramInputType.type != TextInputChannel.TextInputType.VISIBLE_PASSWORD) {
          break;
        }
        i = 145;
        break;
        j = i;
        if (paramBoolean2) {
          j = i | 0x8000;
        }
        i = j;
        if (!paramBoolean3) {
          i = j | 0x80000;
        }
      }
      if (paramTextCapitalization == TextInputChannel.TextCapitalization.WORDS) {
        return i | 0x2000;
      }
      j = i;
    } while (paramTextCapitalization != TextInputChannel.TextCapitalization.SENTENCES);
    return i | 0x4000;
  }
  
  @SuppressLint({"NewApi"})
  private boolean isRestartAlwaysRequired()
  {
    if ((this.mImm.getCurrentInputMethodSubtype() == null) || (Build.VERSION.SDK_INT < 21) || (!Build.MANUFACTURER.equals("samsung"))) {
      return false;
    }
    return Settings.Secure.getString(this.mView.getContext().getContentResolver(), "default_input_method").contains("Samsung");
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
    if (this.configuration.inputAction == null) {
      if ((0x20000 & paramEditorInfo.inputType) != 0) {
        i = 1;
      }
    }
    for (;;)
    {
      if (this.configuration.actionLabel != null)
      {
        paramEditorInfo.actionLabel = this.configuration.actionLabel;
        paramEditorInfo.actionId = i;
      }
      paramEditorInfo.imeOptions = (i | paramEditorInfo.imeOptions);
      paramView = new InputConnectionAdaptor(paramView, this.inputTarget.id, this.textInputChannel, this.mEditable);
      paramEditorInfo.initialSelStart = Selection.getSelectionStart(this.mEditable);
      paramEditorInfo.initialSelEnd = Selection.getSelectionEnd(this.mEditable);
      this.lastInputConnection = paramView;
      return this.lastInputConnection;
      i = 6;
      continue;
      i = this.configuration.inputAction.intValue();
    }
  }
  
  public void destroy()
  {
    this.platformViewsController.detachTextInputPlugin();
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
  
  @VisibleForTesting
  void setTextInputClient(int paramInt, TextInputChannel.Configuration paramConfiguration)
  {
    this.inputTarget = new TextInputPlugin.InputTarget(TextInputPlugin.InputTarget.Type.FRAMEWORK_CLIENT, paramInt);
    this.configuration = paramConfiguration;
    this.mEditable = Editable.Factory.getInstance().newEditable("");
    this.mRestartInputPending = true;
    unlockPlatformViewInputConnection();
  }
  
  @VisibleForTesting
  void setTextInputEditingState(View paramView, TextInputChannel.TextEditState paramTextEditState)
  {
    if ((!this.restartAlwaysRequired) && (!this.mRestartInputPending) && (paramTextEditState.text.equals(this.mEditable.toString())))
    {
      applyStateToSelection(paramTextEditState);
      this.mImm.updateSelection(this.mView, Math.max(Selection.getSelectionStart(this.mEditable), 0), Math.max(Selection.getSelectionEnd(this.mEditable), 0), BaseInputConnection.getComposingSpanStart(this.mEditable), BaseInputConnection.getComposingSpanEnd(this.mEditable));
      return;
    }
    this.mEditable.replace(0, this.mEditable.length(), paramTextEditState.text);
    applyStateToSelection(paramTextEditState);
    this.mImm.restartInput(paramView);
    this.mRestartInputPending = false;
  }
  
  public void unlockPlatformViewInputConnection()
  {
    this.isInputConnectionLocked = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.plugin.editing.TextInputPlugin
 * JD-Core Version:    0.7.0.1
 */