package com.tencent.mobileqq.msgbackup.fragment;

import android.os.Message;
import mqq.os.MqqHandler;

class MsgBackupBaseFragment$3
  implements Runnable
{
  MsgBackupBaseFragment$3(MsgBackupBaseFragment paramMsgBackupBaseFragment) {}
  
  public void run()
  {
    if (this.this$0.g() < 102400L)
    {
      this.this$0.J.removeCallbacks(this);
      Message localMessage = this.this$0.I.obtainMessage(10010);
      this.this$0.I.sendMessage(localMessage);
      return;
    }
    this.this$0.J.postDelayed(this, 15000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment.3
 * JD-Core Version:    0.7.0.1
 */