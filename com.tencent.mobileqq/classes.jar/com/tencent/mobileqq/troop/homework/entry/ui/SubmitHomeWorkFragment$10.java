package com.tencent.mobileqq.troop.homework.entry.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.qphone.base.util.QLog;

class SubmitHomeWorkFragment$10
  extends BroadcastReceiver
{
  SubmitHomeWorkFragment$10(SubmitHomeWorkFragment paramSubmitHomeWorkFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.a.a != null)
    {
      paramContext = paramIntent.getAction();
      if (!"tencent.av.v2q.StartVideoChat".equals(paramContext)) {
        break label51;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SubmitHomeWorkFragment", 2, "receive action_recv_video_request");
      }
      this.a.a.a(102);
    }
    label51:
    while (!"android.intent.action.PHONE_STATE".equals(paramContext)) {
      return;
    }
    if ((((TelephonyManager)this.a.getActivity().getSystemService("phone")).getCallState() == 1) && (QLog.isColorLevel())) {
      QLog.d("SubmitHomeWorkFragment", 2, "receive action_phone_state_changed|call_state_ringing");
    }
    this.a.a.a(102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.SubmitHomeWorkFragment.10
 * JD-Core Version:    0.7.0.1
 */