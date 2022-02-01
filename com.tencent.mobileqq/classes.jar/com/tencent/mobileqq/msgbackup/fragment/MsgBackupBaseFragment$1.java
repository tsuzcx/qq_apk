package com.tencent.mobileqq.msgbackup.fragment;

import android.os.Message;
import com.tencent.mobileqq.utils.NetworkUtil;
import mqq.os.MqqHandler;

class MsgBackupBaseFragment$1
  implements Runnable
{
  MsgBackupBaseFragment$1(MsgBackupBaseFragment paramMsgBackupBaseFragment) {}
  
  public void run()
  {
    int j = NetworkUtil.getSystemNetwork(this.this$0.getContext());
    int i = 1;
    if (j != 1) {
      i = 0;
    }
    Message localMessage = this.this$0.a.obtainMessage(10012);
    localMessage.arg1 = i;
    this.this$0.a.sendMessage(localMessage);
    this.this$0.b.postDelayed(this, 800L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment.1
 * JD-Core Version:    0.7.0.1
 */