package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.banner.TipsBar;

class SendHbMainFragment$2
  implements View.OnClickListener
{
  SendHbMainFragment$2(SendHbMainFragment paramSendHbMainFragment, TipsBar paramTipsBar, SharedPreferences paramSharedPreferences, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.a.setVisibility(8);
    this.b.edit().putInt("red_packet_bulletin", this.c).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.SendHbMainFragment.2
 * JD-Core Version:    0.7.0.1
 */