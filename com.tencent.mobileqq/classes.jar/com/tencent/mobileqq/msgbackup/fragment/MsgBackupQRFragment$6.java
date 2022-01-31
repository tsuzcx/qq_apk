package com.tencent.mobileqq.msgbackup.fragment;

import arop;
import arpa;
import mqq.os.MqqHandler;

class MsgBackupQRFragment$6
  implements Runnable
{
  MsgBackupQRFragment$6(MsgBackupQRFragment paramMsgBackupQRFragment) {}
  
  public void run()
  {
    arpa localarpa = arpa.a();
    String str = localarpa.a().a();
    if (str != null)
    {
      localarpa.a(str);
      this.this$0.b.postDelayed(this, 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupQRFragment.6
 * JD-Core Version:    0.7.0.1
 */