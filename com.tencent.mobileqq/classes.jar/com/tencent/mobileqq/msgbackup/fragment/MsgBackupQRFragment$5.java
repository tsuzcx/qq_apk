package com.tencent.mobileqq.msgbackup.fragment;

import android.graphics.Bitmap;
import com.tencent.mobileqq.msgbackup.data.MsgBackupGetQrRsp;

class MsgBackupQRFragment$5
  implements Runnable
{
  MsgBackupQRFragment$5(MsgBackupQRFragment paramMsgBackupQRFragment, MsgBackupGetQrRsp paramMsgBackupGetQrRsp) {}
  
  public void run()
  {
    Bitmap localBitmap = this.this$0.b(this.a);
    MsgBackupQRFragment.b(this.this$0, localBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupQRFragment.5
 * JD-Core Version:    0.7.0.1
 */