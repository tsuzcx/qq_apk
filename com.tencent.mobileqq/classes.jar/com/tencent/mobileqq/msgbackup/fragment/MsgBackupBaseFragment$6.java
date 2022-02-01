package com.tencent.mobileqq.msgbackup.fragment;

import android.os.Message;
import android.os.SystemClock;
import awql;
import mqq.os.MqqHandler;

class MsgBackupBaseFragment$6
  implements Runnable
{
  MsgBackupBaseFragment$6(MsgBackupBaseFragment paramMsgBackupBaseFragment) {}
  
  public void run()
  {
    if (!awql.a().b())
    {
      if (SystemClock.elapsedRealtime() - this.this$0.jdField_b_of_type_Long > 30000L)
      {
        Message localMessage = this.this$0.a.obtainMessage(10009);
        this.this$0.a.sendMessage(localMessage);
        this.this$0.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this);
        return;
      }
      this.this$0.jdField_b_of_type_MqqOsMqqHandler.postDelayed(this, 1000L);
      return;
    }
    this.this$0.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment.6
 * JD-Core Version:    0.7.0.1
 */