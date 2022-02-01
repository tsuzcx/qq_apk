package com.tencent.mobileqq.qqlive.prepare;

import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;

class QQLivePrepareFragment$5
  implements TextWatcher
{
  QQLivePrepareFragment$5(QQLivePrepareFragment paramQQLivePrepareFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (!TextUtils.isEmpty(paramEditable.toString()))
    {
      QQLivePrepareFragment.l(this.a).setVisibility(8);
      return;
    }
    QQLivePrepareFragment.l(this.a).setVisibility(0);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    Editable localEditable = QQLivePrepareFragment.k(this.a).getText();
    paramCharSequence = localEditable;
    if (localEditable.length() > 15)
    {
      paramInt2 = Selection.getSelectionEnd(localEditable);
      paramCharSequence = localEditable.toString().substring(0, 15);
      QQLivePrepareFragment.k(this.a).setText(paramCharSequence);
      paramCharSequence = QQLivePrepareFragment.k(this.a).getText();
      paramInt1 = paramInt2;
      if (paramInt2 > paramCharSequence.length()) {
        paramInt1 = paramCharSequence.length();
      }
      Selection.setSelection(paramCharSequence, paramInt1);
    }
    QQLivePrepareFragment.b(this.a).a(paramCharSequence.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.prepare.QQLivePrepareFragment.5
 * JD-Core Version:    0.7.0.1
 */