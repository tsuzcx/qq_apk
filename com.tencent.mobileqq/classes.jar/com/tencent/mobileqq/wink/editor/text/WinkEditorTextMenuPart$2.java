package com.tencent.mobileqq.wink.editor.text;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.widget.QQToast;

class WinkEditorTextMenuPart$2
  implements TextWatcher
{
  WinkEditorTextMenuPart$2(WinkEditorTextMenuPart paramWinkEditorTextMenuPart) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable == null) {
      return;
    }
    String str = paramEditable.toString();
    if (paramEditable.length() > 120)
    {
      QQToast.makeText(this.a.g(), WinkEditorTextMenuPart.c(this.a), 0).show();
      str = paramEditable.subSequence(0, 120).toString();
      WinkEditorTextMenuPart.d(this.a).setText(str);
      WinkEditorTextMenuPart.d(this.a).setSelection(str.length());
    }
    WinkEditorTextMenuPart.a(this.a).a(str);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.text.WinkEditorTextMenuPart.2
 * JD-Core Version:    0.7.0.1
 */