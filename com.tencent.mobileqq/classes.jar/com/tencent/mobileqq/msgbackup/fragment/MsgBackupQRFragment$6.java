package com.tencent.mobileqq.msgbackup.fragment;

import awzh;
import awzs;
import mqq.os.MqqHandler;

class MsgBackupQRFragment$6
  implements Runnable
{
  MsgBackupQRFragment$6(MsgBackupQRFragment paramMsgBackupQRFragment) {}
  
  public void run()
  {
    awzs localawzs = awzs.a();
    String str = localawzs.a().a();
    if (str != null)
    {
      localawzs.a(str);
      this.this$0.b.postDelayed(this, 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupQRFragment.6
 * JD-Core Version:    0.7.0.1
 */