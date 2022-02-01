package com.tencent.mobileqq.fragment;

import android.text.TextUtils;
import android.view.Window;
import android.widget.EditText;
import com.tencent.mobileqq.app.BaseActivity;

class UnitedVerifyMsgEditFragment$1$1
  implements Runnable
{
  UnitedVerifyMsgEditFragment$1$1(UnitedVerifyMsgEditFragment.1 param1, String paramString1, String paramString2) {}
  
  public void run()
  {
    this.c.this$0.c.setText(this.a);
    try
    {
      if (!TextUtils.isEmpty(this.b)) {
        this.c.this$0.c.setSelection(this.a.lastIndexOf(this.b), this.a.length());
      } else if (!TextUtils.isEmpty(this.a)) {
        this.c.this$0.c.setSelection(this.a.length());
      }
    }
    catch (Throwable localThrowable)
    {
      label91:
      break label91;
    }
    this.c.this$0.a.getWindow().setSoftInputMode(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.UnitedVerifyMsgEditFragment.1.1
 * JD-Core Version:    0.7.0.1
 */