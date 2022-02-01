package com.tencent.mobileqq.qwallet.hb.grap.impl;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PayBridgeActivity;

class RedPacketVoiceFragment$1
  implements View.OnClickListener
{
  RedPacketVoiceFragment$1(RedPacketVoiceFragment paramRedPacketVoiceFragment) {}
  
  public void onClick(View paramView)
  {
    if ((!this.a.d()) && (RedPacketVoiceFragment.a(this.a) != null) && (paramView != null))
    {
      Intent localIntent = new Intent(paramView.getContext(), PayBridgeActivity.class);
      localIntent.putExtras(RedPacketVoiceFragment.a(this.a));
      localIntent.putExtra("pay_requestcode", 5);
      paramView.getContext().startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.impl.RedPacketVoiceFragment.1
 * JD-Core Version:    0.7.0.1
 */