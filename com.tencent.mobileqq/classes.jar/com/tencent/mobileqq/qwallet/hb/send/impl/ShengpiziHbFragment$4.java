package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class ShengpiziHbFragment$4
  implements View.OnClickListener
{
  ShengpiziHbFragment$4(ShengpiziHbFragment paramShengpiziHbFragment) {}
  
  public void onClick(View paramView)
  {
    QLog.i("ShengPiZiHbFragment", 2, "change others...");
    if (this.a.i == 65536) {
      paramView = "yyhongbao.word.change";
    } else {
      paramView = "klhongbao.word.change";
    }
    this.a.a(paramView, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.ShengpiziHbFragment.4
 * JD-Core Version:    0.7.0.1
 */