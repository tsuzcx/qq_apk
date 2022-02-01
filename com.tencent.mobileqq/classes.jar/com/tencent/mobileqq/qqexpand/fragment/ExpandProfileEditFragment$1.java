package com.tencent.mobileqq.qqexpand.fragment;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XEditTextEx;

class ExpandProfileEditFragment$1
  implements TextWatcher
{
  int a = 0;
  String b;
  
  ExpandProfileEditFragment$1(ExpandProfileEditFragment paramExpandProfileEditFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i = this.c.b.getLineCount();
    if (i > 30)
    {
      if (this.b != null)
      {
        this.c.b.setText(this.b);
        this.c.b.setSelection(this.a);
      }
      else
      {
        this.c.b.setText("");
        this.c.b.setSelection(0);
      }
      if (ExpandProfileEditFragment.a(this.c) == null)
      {
        paramEditable = this.c;
        ExpandProfileEditFragment.a(paramEditable, QQToast.makeText(paramEditable.getActivity(), "输入文字不要超过30行", 0));
      }
      if (!ExpandProfileEditFragment.a(this.c).isShowing()) {
        ExpandProfileEditFragment.a(this.c).show();
      }
    }
    if (i != ExpandProfileEditFragment.b(this.c))
    {
      ExpandProfileEditFragment.a(this.c, i);
      this.c.f = true;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.c.b.getLineCount() <= 30)
    {
      this.b = this.c.b.getText().toString();
      this.a = this.c.b.getSelectionStart();
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.c.i == null) {
      this.c.i = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExpandProfileEditFragment.1
 * JD-Core Version:    0.7.0.1
 */