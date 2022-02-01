package io.flutter.plugin.editing;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Selection;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.CursorAnchorInfo.Builder;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;

class InputConnectionAdaptor
  extends BaseInputConnection
{
  private FlutterTextUtils flutterTextUtils;
  private final boolean isSamsung;
  private int mBatchCount;
  private final int mClient;
  private final Editable mEditable;
  private final EditorInfo mEditorInfo;
  private final View mFlutterView;
  private InputMethodManager mImm;
  private InputConnectionAdaptor.TextEditingValue mLastSentTextEditngValue;
  private final Layout mLayout;
  private boolean mRepeatCheckNeeded = false;
  private final TextInputChannel textInputChannel;
  
  public InputConnectionAdaptor(View paramView, int paramInt, TextInputChannel paramTextInputChannel, Editable paramEditable, EditorInfo paramEditorInfo)
  {
    this(paramView, paramInt, paramTextInputChannel, paramEditable, paramEditorInfo, new FlutterJNI());
  }
  
  public InputConnectionAdaptor(View paramView, int paramInt, TextInputChannel paramTextInputChannel, Editable paramEditable, EditorInfo paramEditorInfo, FlutterJNI paramFlutterJNI)
  {
    super(paramView, true);
    this.mFlutterView = paramView;
    this.mClient = paramInt;
    this.textInputChannel = paramTextInputChannel;
    this.mEditable = paramEditable;
    this.mEditorInfo = paramEditorInfo;
    this.mBatchCount = 0;
    this.flutterTextUtils = new FlutterTextUtils(paramFlutterJNI);
    this.mLayout = new DynamicLayout(this.mEditable, new TextPaint(), 2147483647, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    this.mImm = ((InputMethodManager)paramView.getContext().getSystemService("input_method"));
    this.isSamsung = isSamsung();
  }
  
  private static int clampIndexToEditable(int paramInt, Editable paramEditable)
  {
    int i = Math.max(0, Math.min(paramEditable.length(), paramInt));
    if (i != paramInt)
    {
      paramEditable = new StringBuilder();
      paramEditable.append("Text selection index was clamped (");
      paramEditable.append(paramInt);
      paramEditable.append("->");
      paramEditable.append(i);
      paramEditable.append(") to remain in bounds. This may not be your fault, as some keyboards may select outside of bounds.");
      Log.d("flutter", paramEditable.toString());
    }
    return i;
  }
  
  @SuppressLint({"NewApi"})
  private boolean isSamsung()
  {
    if ((this.mImm.getCurrentInputMethodSubtype() != null) && (Build.VERSION.SDK_INT >= 21) && (Build.MANUFACTURER.equals("samsung"))) {
      return Settings.Secure.getString(this.mFlutterView.getContext().getContentResolver(), "default_input_method").contains("Samsung");
    }
    return false;
  }
  
  private void updateEditingState()
  {
    if (this.mBatchCount > 0) {
      return;
    }
    InputConnectionAdaptor.TextEditingValue localTextEditingValue = new InputConnectionAdaptor.TextEditingValue(this, this.mEditable);
    if ((this.mRepeatCheckNeeded) && (localTextEditingValue.equals(this.mLastSentTextEditngValue))) {
      return;
    }
    this.mImm.updateSelection(this.mFlutterView, localTextEditingValue.selectionStart, localTextEditingValue.selectionEnd, localTextEditingValue.composingStart, localTextEditingValue.composingEnd);
    this.textInputChannel.updateEditingState(this.mClient, localTextEditingValue.text, localTextEditingValue.selectionStart, localTextEditingValue.selectionEnd, localTextEditingValue.composingStart, localTextEditingValue.composingEnd);
    this.mRepeatCheckNeeded = true;
    this.mLastSentTextEditngValue = localTextEditingValue;
  }
  
  public boolean beginBatchEdit()
  {
    this.mBatchCount += 1;
    return super.beginBatchEdit();
  }
  
  public boolean clearMetaKeyStates(int paramInt)
  {
    boolean bool = super.clearMetaKeyStates(paramInt);
    markDirty();
    return bool;
  }
  
  public boolean commitText(CharSequence paramCharSequence, int paramInt)
  {
    boolean bool = super.commitText(paramCharSequence, paramInt);
    markDirty();
    return bool;
  }
  
  public boolean deleteSurroundingText(int paramInt1, int paramInt2)
  {
    if (Selection.getSelectionStart(this.mEditable) == -1) {
      return true;
    }
    boolean bool = super.deleteSurroundingText(paramInt1, paramInt2);
    markDirty();
    return bool;
  }
  
  public boolean deleteSurroundingTextInCodePoints(int paramInt1, int paramInt2)
  {
    boolean bool = super.deleteSurroundingTextInCodePoints(paramInt1, paramInt2);
    markDirty();
    return bool;
  }
  
  public boolean endBatchEdit()
  {
    boolean bool = super.endBatchEdit();
    this.mBatchCount -= 1;
    updateEditingState();
    return bool;
  }
  
  public boolean finishComposingText()
  {
    boolean bool = super.finishComposingText();
    if ((this.isSamsung) && (Build.VERSION.SDK_INT >= 21))
    {
      Object localObject = new CursorAnchorInfo.Builder();
      ((CursorAnchorInfo.Builder)localObject).setComposingText(-1, "");
      localObject = ((CursorAnchorInfo.Builder)localObject).build();
      this.mImm.updateCursorAnchorInfo(this.mFlutterView, (CursorAnchorInfo)localObject);
    }
    markDirty();
    return bool;
  }
  
  public Editable getEditable()
  {
    return this.mEditable;
  }
  
  public ExtractedText getExtractedText(ExtractedTextRequest paramExtractedTextRequest, int paramInt)
  {
    paramExtractedTextRequest = new ExtractedText();
    paramExtractedTextRequest.selectionStart = Selection.getSelectionStart(this.mEditable);
    paramExtractedTextRequest.selectionEnd = Selection.getSelectionEnd(this.mEditable);
    paramExtractedTextRequest.text = this.mEditable.toString();
    return paramExtractedTextRequest;
  }
  
  public void markDirty()
  {
    this.mRepeatCheckNeeded = false;
  }
  
  public boolean performContextMenuAction(int paramInt)
  {
    markDirty();
    if (paramInt == 16908319)
    {
      setSelection(0, this.mEditable.length());
      return true;
    }
    int i;
    int j;
    Object localObject2;
    Object localObject1;
    if (paramInt == 16908320)
    {
      i = Selection.getSelectionStart(this.mEditable);
      j = Selection.getSelectionEnd(this.mEditable);
      if (i != j)
      {
        paramInt = Math.min(i, j);
        i = Math.max(i, j);
        localObject2 = this.mEditable.subSequence(paramInt, i);
        localObject1 = (ClipboardManager)this.mFlutterView.getContext().getSystemService("clipboard");
        localObject2 = ClipData.newPlainText("text label?", (CharSequence)localObject2);
        ClipboardMonitor.setPrimaryClip((ClipboardManager)localObject1, (ClipData)localObject2);
        ((ClipboardManager)localObject1).setPrimaryClip((ClipData)localObject2);
        this.mEditable.delete(paramInt, i);
        setSelection(paramInt, paramInt);
      }
      return true;
    }
    if (paramInt == 16908321)
    {
      paramInt = Selection.getSelectionStart(this.mEditable);
      i = Selection.getSelectionEnd(this.mEditable);
      if (paramInt != i)
      {
        localObject2 = this.mEditable.subSequence(Math.min(paramInt, i), Math.max(paramInt, i));
        localObject1 = (ClipboardManager)this.mFlutterView.getContext().getSystemService("clipboard");
        localObject2 = ClipData.newPlainText("text label?", (CharSequence)localObject2);
        ClipboardMonitor.setPrimaryClip((ClipboardManager)localObject1, (ClipData)localObject2);
        ((ClipboardManager)localObject1).setPrimaryClip((ClipData)localObject2);
      }
      return true;
    }
    if (paramInt == 16908322)
    {
      localObject1 = (ClipboardManager)this.mFlutterView.getContext().getSystemService("clipboard");
      ClipboardMonitor.getPrimaryClip((ClipboardManager)localObject1);
      localObject1 = ((ClipboardManager)localObject1).getPrimaryClip();
      if (localObject1 != null)
      {
        localObject1 = ((ClipData)localObject1).getItemAt(0).coerceToText(this.mFlutterView.getContext());
        i = Math.max(0, Selection.getSelectionStart(this.mEditable));
        j = Math.max(0, Selection.getSelectionEnd(this.mEditable));
        paramInt = Math.min(i, j);
        i = Math.max(i, j);
        if (paramInt != i) {
          this.mEditable.delete(paramInt, i);
        }
        this.mEditable.insert(paramInt, (CharSequence)localObject1);
        paramInt += ((CharSequence)localObject1).length();
        setSelection(paramInt, paramInt);
      }
      return true;
    }
    return false;
  }
  
  public boolean performEditorAction(int paramInt)
  {
    markDirty();
    if (paramInt != 7)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3)
            {
              if (paramInt != 4)
              {
                if (paramInt != 5)
                {
                  this.textInputChannel.done(this.mClient);
                  return true;
                }
                this.textInputChannel.next(this.mClient);
                return true;
              }
              this.textInputChannel.send(this.mClient);
              return true;
            }
            this.textInputChannel.search(this.mClient);
            return true;
          }
          this.textInputChannel.go(this.mClient);
          return true;
        }
        this.textInputChannel.newline(this.mClient);
        return true;
      }
      this.textInputChannel.unspecifiedAction(this.mClient);
      return true;
    }
    this.textInputChannel.previous(this.mClient);
    return true;
  }
  
  public boolean performPrivateCommand(String paramString, Bundle paramBundle)
  {
    this.textInputChannel.performPrivateCommand(this.mClient, paramString, paramBundle);
    return true;
  }
  
  public boolean sendKeyEvent(KeyEvent paramKeyEvent)
  {
    markDirty();
    int i;
    if (paramKeyEvent.getAction() == 0)
    {
      if (paramKeyEvent.getKeyCode() == 67)
      {
        j = clampIndexToEditable(Selection.getSelectionStart(this.mEditable), this.mEditable);
        k = clampIndexToEditable(Selection.getSelectionEnd(this.mEditable), this.mEditable);
        i = j;
        if (j == k)
        {
          i = j;
          if (j > 0) {
            i = this.flutterTextUtils.getOffsetBefore(this.mEditable, j);
          }
        }
        if (k > i)
        {
          Selection.setSelection(this.mEditable, i);
          this.mEditable.delete(i, k);
          updateEditingState();
          return true;
        }
        return false;
      }
      if (paramKeyEvent.getKeyCode() == 21)
      {
        i = Selection.getSelectionStart(this.mEditable);
        j = Selection.getSelectionEnd(this.mEditable);
        if ((i == j) && (!paramKeyEvent.isShiftPressed()))
        {
          i = Math.max(this.flutterTextUtils.getOffsetBefore(this.mEditable, i), 0);
          setSelection(i, i);
          return true;
        }
        setSelection(i, Math.max(this.flutterTextUtils.getOffsetBefore(this.mEditable, j), 0));
        return true;
      }
      if (paramKeyEvent.getKeyCode() == 22)
      {
        i = Selection.getSelectionStart(this.mEditable);
        j = Selection.getSelectionEnd(this.mEditable);
        if ((i == j) && (!paramKeyEvent.isShiftPressed()))
        {
          i = Math.min(this.flutterTextUtils.getOffsetAfter(this.mEditable, i), this.mEditable.length());
          setSelection(i, i);
          return true;
        }
        setSelection(i, Math.min(this.flutterTextUtils.getOffsetAfter(this.mEditable, j), this.mEditable.length()));
        return true;
      }
      if (paramKeyEvent.getKeyCode() == 19)
      {
        if ((Selection.getSelectionStart(this.mEditable) == Selection.getSelectionEnd(this.mEditable)) && (!paramKeyEvent.isShiftPressed()))
        {
          Selection.moveUp(this.mEditable, this.mLayout);
          i = Selection.getSelectionStart(this.mEditable);
          setSelection(i, i);
          return true;
        }
        Selection.extendUp(this.mEditable, this.mLayout);
        setSelection(Selection.getSelectionStart(this.mEditable), Selection.getSelectionEnd(this.mEditable));
        return true;
      }
      if (paramKeyEvent.getKeyCode() == 20)
      {
        if ((Selection.getSelectionStart(this.mEditable) == Selection.getSelectionEnd(this.mEditable)) && (!paramKeyEvent.isShiftPressed()))
        {
          Selection.moveDown(this.mEditable, this.mLayout);
          i = Selection.getSelectionStart(this.mEditable);
          setSelection(i, i);
          return true;
        }
        Selection.extendDown(this.mEditable, this.mLayout);
        setSelection(Selection.getSelectionStart(this.mEditable), Selection.getSelectionEnd(this.mEditable));
        return true;
      }
      if (((paramKeyEvent.getKeyCode() == 66) || (paramKeyEvent.getKeyCode() == 160)) && ((0x20000 & this.mEditorInfo.inputType) == 0))
      {
        performEditorAction(this.mEditorInfo.imeOptions & 0xFF);
        return true;
      }
      i = paramKeyEvent.getUnicodeChar();
      if (i == 0) {
        return false;
      }
      int k = Math.max(0, Selection.getSelectionStart(this.mEditable));
      int m = Math.max(0, Selection.getSelectionEnd(this.mEditable));
      int j = Math.min(k, m);
      k = Math.max(k, m);
      if (j != k) {
        this.mEditable.delete(j, k);
      }
      this.mEditable.insert(j, String.valueOf((char)i));
      i = j + 1;
      setSelection(i, i);
      return true;
    }
    if ((paramKeyEvent.getAction() == 1) && ((paramKeyEvent.getKeyCode() == 59) || (paramKeyEvent.getKeyCode() == 60)))
    {
      i = Selection.getSelectionEnd(this.mEditable);
      setSelection(i, i);
      return true;
    }
    return false;
  }
  
  public boolean setComposingRegion(int paramInt1, int paramInt2)
  {
    boolean bool = super.setComposingRegion(paramInt1, paramInt2);
    markDirty();
    return bool;
  }
  
  public boolean setComposingText(CharSequence paramCharSequence, int paramInt)
  {
    boolean bool;
    if (paramCharSequence.length() == 0) {
      bool = super.commitText(paramCharSequence, paramInt);
    } else {
      bool = super.setComposingText(paramCharSequence, paramInt);
    }
    markDirty();
    return bool;
  }
  
  public boolean setSelection(int paramInt1, int paramInt2)
  {
    boolean bool = super.setSelection(paramInt1, paramInt2);
    markDirty();
    updateEditingState();
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.plugin.editing.InputConnectionAdaptor
 * JD-Core Version:    0.7.0.1
 */