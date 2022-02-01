package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

class KuaKuaHbFragment$5
  implements View.OnClickListener
{
  KuaKuaHbFragment$5(KuaKuaHbFragment paramKuaKuaHbFragment) {}
  
  public void onClick(View paramView)
  {
    if ((paramView instanceof TextView)) {
      KuaKuaHbFragment.a(this.a).setText(((TextView)paramView).getText().toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.KuaKuaHbFragment.5
 * JD-Core Version:    0.7.0.1
 */