package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.qwallet.hb.send.view.impl.BirthdayHbAdapter.CallBack;
import com.tencent.mobileqq.qwallet.hb.send.view.impl.BirthdayHbAdapter.DataInfo;

class BirthdayHbFragment$5
  implements BirthdayHbAdapter.CallBack
{
  BirthdayHbFragment$5(BirthdayHbFragment paramBirthdayHbFragment) {}
  
  public void a(BirthdayHbAdapter.DataInfo paramDataInfo)
  {
    String str = paramDataInfo.b();
    if (!TextUtils.isEmpty(str))
    {
      BirthdayHbFragment.b(this.a).setText(str);
      BirthdayHbFragment.b(this.a).setSelection(str.length());
      this.a.d.setText(str);
    }
    if (!TextUtils.isEmpty(paramDataInfo.d()))
    {
      BirthdayHbFragment.f(this.a).setText(paramDataInfo.d());
      BirthdayHbFragment.f(this.a).setSelection(paramDataInfo.d().length());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.BirthdayHbFragment.5
 * JD-Core Version:    0.7.0.1
 */