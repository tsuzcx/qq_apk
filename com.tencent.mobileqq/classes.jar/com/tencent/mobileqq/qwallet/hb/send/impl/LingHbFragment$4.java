package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class LingHbFragment$4
  implements View.OnClickListener
{
  LingHbFragment$4(LingHbFragment paramLingHbFragment) {}
  
  public void onClick(View paramView)
  {
    QLog.i("LingHbFragment", 2, "change others...");
    if (this.a.i == 65536) {
      paramView = "yyhongbao.word.change";
    } else {
      paramView = "klhongbao.word.change";
    }
    this.a.a(paramView, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.LingHbFragment.4
 * JD-Core Version:    0.7.0.1
 */