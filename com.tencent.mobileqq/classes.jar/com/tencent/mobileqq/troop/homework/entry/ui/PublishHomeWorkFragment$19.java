package com.tencent.mobileqq.troop.homework.entry.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.qphone.base.util.QLog;

class PublishHomeWorkFragment$19
  extends BroadcastReceiver
{
  PublishHomeWorkFragment$19(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.a.K != null)
    {
      paramContext = paramIntent.getAction();
      if ("tencent.av.v2q.StartVideoChat".equals(paramContext))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PublishHomeWorkFragment", 2, "receive action_recv_video_request");
        }
        this.a.K.a(102);
        return;
      }
      if ("android.intent.action.PHONE_STATE".equals(paramContext))
      {
        if ((((TelephonyManager)this.a.getActivity().getSystemService("phone")).getCallState() == 1) && (QLog.isColorLevel())) {
          QLog.d("PublishHomeWorkFragment", 2, "receive action_phone_state_changed|call_state_ringing");
        }
        this.a.K.a(102);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment.19
 * JD-Core Version:    0.7.0.1
 */