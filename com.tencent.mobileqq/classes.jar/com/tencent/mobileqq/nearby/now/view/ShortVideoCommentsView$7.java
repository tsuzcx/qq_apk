package com.tencent.mobileqq.nearby.now.view;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.nearby.now.utils.CommentsUtil;

class ShortVideoCommentsView$7
  implements TextWatcher
{
  ShortVideoCommentsView$7(ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (ShortVideoCommentsView.access$400(this.a) == null) {
      return;
    }
    if (CommentsUtil.a(paramEditable.toString()) > 140)
    {
      int j = Selection.getSelectionEnd(paramEditable);
      paramEditable = CommentsUtil.a(paramEditable.toString(), 0, 140).toString();
      ShortVideoCommentsView.access$400(this.a).setText(paramEditable);
      paramEditable = ShortVideoCommentsView.access$400(this.a).getText();
      int i = j;
      if (j > paramEditable.length()) {
        i = paramEditable.length();
      }
      Selection.setSelection(paramEditable, i);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.7
 * JD-Core Version:    0.7.0.1
 */