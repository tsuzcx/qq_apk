package dov.com.qq.im.aeeditor.module.text;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tavcut.bean.TextEditorData;

class AEEditorTextEditDialog$4
  implements TextWatcher
{
  AEEditorTextEditDialog$4(AEEditorTextEditDialog paramAEEditorTextEditDialog) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable == null) {
      return;
    }
    String str = paramEditable.toString();
    if (paramEditable.length() > 20)
    {
      QQToast.a(this.a.getContext(), AEEditorTextEditDialog.a(this.a), 0).a();
      str = paramEditable.subSequence(0, 20).toString();
      AEEditorTextEditDialog.a(this.a).setText(str);
      AEEditorTextEditDialog.a(this.a).setSelection(str.length());
    }
    if (TextUtils.isEmpty(str.trim())) {
      AEEditorTextEditDialog.a(this.a).setContent("");
    }
    for (;;)
    {
      AEEditorTextEditDialog.b(this.a);
      return;
      AEEditorTextEditDialog.a(this.a).setContent(str);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AEEditorTextEditDialog.4
 * JD-Core Version:    0.7.0.1
 */