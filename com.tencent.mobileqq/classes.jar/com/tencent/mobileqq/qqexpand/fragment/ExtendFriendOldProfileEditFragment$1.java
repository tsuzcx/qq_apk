package com.tencent.mobileqq.qqexpand.fragment;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XEditTextEx;

class ExtendFriendOldProfileEditFragment$1
  implements TextWatcher
{
  int a = 0;
  String b;
  
  ExtendFriendOldProfileEditFragment$1(ExtendFriendOldProfileEditFragment paramExtendFriendOldProfileEditFragment) {}
  
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
      if (ExtendFriendOldProfileEditFragment.d(this.c) == null)
      {
        paramEditable = this.c;
        ExtendFriendOldProfileEditFragment.a(paramEditable, QQToast.makeText(paramEditable.getActivity(), "输入文字不要超过30行", 0));
      }
      if (!ExtendFriendOldProfileEditFragment.d(this.c).isShowing()) {
        ExtendFriendOldProfileEditFragment.d(this.c).show();
      }
    }
    if (i != ExtendFriendOldProfileEditFragment.e(this.c))
    {
      ExtendFriendOldProfileEditFragment.a(this.c, i);
      this.c.h = true;
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
    if (this.c.k == null) {
      this.c.k = "";
    }
    if ((this.c.k.equals(paramCharSequence.toString())) && (!ExtendFriendOldProfileEditFragment.a(this.c)))
    {
      ExtendFriendOldProfileEditFragment.b(this.c);
      return;
    }
    ExtendFriendOldProfileEditFragment.c(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendOldProfileEditFragment.1
 * JD-Core Version:    0.7.0.1
 */