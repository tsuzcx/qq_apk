package com.tencent.mobileqq.writetogetherui;

import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import com.tencent.mobileqq.writetogether.WriteTogetherUtils;

class WriteTogetherEditorView$WtInputConnectionWrapper
  extends InputConnectionWrapper
{
  public WriteTogetherEditorView$WtInputConnectionWrapper(WriteTogetherEditorView paramWriteTogetherEditorView, InputConnection paramInputConnection, boolean paramBoolean)
  {
    super(paramInputConnection, paramBoolean);
  }
  
  public boolean commitText(CharSequence paramCharSequence, int paramInt)
  {
    return super.commitText(WriteTogetherUtils.a(paramCharSequence), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.WriteTogetherEditorView.WtInputConnectionWrapper
 * JD-Core Version:    0.7.0.1
 */