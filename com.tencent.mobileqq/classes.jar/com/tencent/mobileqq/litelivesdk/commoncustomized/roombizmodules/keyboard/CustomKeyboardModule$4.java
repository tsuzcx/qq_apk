package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.keyboard;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.falco.utils.EditorUtil;
import com.tencent.open.base.ToastUtil;

class CustomKeyboardModule$4
  implements TextWatcher
{
  CustomKeyboardModule$4(CustomKeyboardModule paramCustomKeyboardModule) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (CustomKeyboardModule.a(this.a) == null) {
      return;
    }
    if (EditorUtil.getLength(paramEditable.toString()) > 140)
    {
      ToastUtil.a().a("小主评论字数已达上限，请精简");
      int j = Selection.getSelectionEnd(paramEditable);
      paramEditable = EditorUtil.clip(paramEditable.toString(), 0, 140).toString();
      CustomKeyboardModule.a(this.a).setText(paramEditable);
      paramEditable = CustomKeyboardModule.a(this.a).getText();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.keyboard.CustomKeyboardModule.4
 * JD-Core Version:    0.7.0.1
 */