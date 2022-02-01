package com.tencent.tkd.weibo.richEditText;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/weibo/richEditText/RichEditText$onCreateInputConnection$1", "Landroid/view/inputmethod/InputConnectionWrapper;", "deleteSurroundingText", "", "beforeLength", "", "afterLength", "setSelection", "start", "end", "tkd-weibo-richtext_release"}, k=1, mv={1, 1, 16})
public final class RichEditText$onCreateInputConnection$1
  extends InputConnectionWrapper
{
  RichEditText$onCreateInputConnection$1(InputConnection paramInputConnection1, InputConnection paramInputConnection2, boolean paramBoolean)
  {
    super(paramBoolean, bool);
  }
  
  public boolean deleteSurroundingText(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (!RichEditText.a(this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText, new KeyEvent(0, 67), 67)) {
      bool = super.deleteSurroundingText(paramInt1, paramInt2);
    }
    return bool;
  }
  
  public boolean setSelection(int paramInt1, int paramInt2)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.richEditText.RichEditText.onCreateInputConnection.1
 * JD-Core Version:    0.7.0.1
 */