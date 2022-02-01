package com.tencent.mobileqq.qwallet.hb.grap.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.ImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.qphone.base.util.QLog;

class RedPacketKSongFragment$8
  extends BroadcastReceiver
{
  RedPacketKSongFragment$8(RedPacketKSongFragment paramRedPacketKSongFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      boolean bool = "tencent.av.v2q.StartVideoChat".equals(paramContext);
      int j = 1;
      int i;
      if (bool)
      {
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("RedPacketKSongFragment", 2, "receive action_recv_video_request");
          i = j;
        }
      }
      else
      {
        if ("android.intent.action.PHONE_STATE".equals(paramContext))
        {
          paramContext = (TelephonyManager)this.a.getQBaseActivity().getSystemService("phone");
          if (QLog.isColorLevel())
          {
            paramIntent = new StringBuilder();
            paramIntent.append("receive action_phone_state_changed|call_state_ringing");
            paramIntent.append(paramContext.getCallState());
            QLog.d("RedPacketKSongFragment", 2, paramIntent.toString());
          }
          if (paramContext.getCallState() == 1)
          {
            i = j;
            break label129;
          }
        }
        i = 0;
      }
      label129:
      if (i != 0)
      {
        if ((this.a.b) && (this.a.c) && (this.a.a.getVisibility() == 0))
        {
          this.a.a();
          return;
        }
        if (this.a.d)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RedPacketKSongFragment", 2, "receive pause action");
          }
          this.a.b(HardCodeUtil.a(R.string.cB));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.impl.RedPacketKSongFragment.8
 * JD-Core Version:    0.7.0.1
 */