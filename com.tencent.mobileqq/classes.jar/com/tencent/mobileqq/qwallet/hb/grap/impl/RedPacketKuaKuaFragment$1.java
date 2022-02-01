package com.tencent.mobileqq.qwallet.hb.grap.impl;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.app.QBaseActivity;

class RedPacketKuaKuaFragment$1
  implements View.OnClickListener
{
  RedPacketKuaKuaFragment$1(RedPacketKuaKuaFragment paramRedPacketKuaKuaFragment) {}
  
  public void onClick(View paramView)
  {
    if (RedPacketKuaKuaFragment.a(this.a) != null) {
      RedPacketKuaKuaFragment.a(this.a).hideSoftInputFromWindow(this.a.getQBaseActivity().getWindow().getDecorView().getWindowToken(), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.impl.RedPacketKuaKuaFragment.1
 * JD-Core Version:    0.7.0.1
 */