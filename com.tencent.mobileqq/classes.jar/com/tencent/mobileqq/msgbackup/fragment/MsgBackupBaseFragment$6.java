package com.tencent.mobileqq.msgbackup.fragment;

import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor;
import mqq.os.MqqHandler;

class MsgBackupBaseFragment$6
  implements Runnable
{
  MsgBackupBaseFragment$6(MsgBackupBaseFragment paramMsgBackupBaseFragment) {}
  
  public void run()
  {
    if (!MsgBackupTransportProcessor.a().l())
    {
      if (SystemClock.elapsedRealtime() - this.this$0.V > 30000L)
      {
        Message localMessage = this.this$0.I.obtainMessage(10009);
        this.this$0.I.sendMessage(localMessage);
        this.this$0.J.removeCallbacks(this);
        return;
      }
      this.this$0.J.postDelayed(this, 1000L);
      return;
    }
    this.this$0.J.removeCallbacks(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment.6
 * JD-Core Version:    0.7.0.1
 */