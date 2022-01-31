package com.tencent.mobileqq.msgbackup.fragment;

import android.os.Message;
import bbfj;
import mqq.os.MqqHandler;

class MsgBackupBaseFragment$1
  implements Runnable
{
  MsgBackupBaseFragment$1(MsgBackupBaseFragment paramMsgBackupBaseFragment) {}
  
  public void run()
  {
    int j = 1;
    Message localMessage;
    if (bbfj.a(this.this$0.getActivity()) == 1)
    {
      i = 1;
      localMessage = this.this$0.a.obtainMessage(10012);
      if (i == 0) {
        break label76;
      }
    }
    label76:
    for (int i = j;; i = 0)
    {
      localMessage.arg1 = i;
      this.this$0.a.sendMessage(localMessage);
      this.this$0.b.postDelayed(this, 800L);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment.1
 * JD-Core Version:    0.7.0.1
 */