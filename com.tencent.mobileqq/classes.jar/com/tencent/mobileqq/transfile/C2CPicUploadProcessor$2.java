package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.HwEngine;

class C2CPicUploadProcessor$2
  implements Runnable
{
  C2CPicUploadProcessor$2(C2CPicUploadProcessor paramC2CPicUploadProcessor) {}
  
  public void run()
  {
    if (this.this$0.mTrans != null)
    {
      this.this$0.log("<BDH_LOG> sendFileNotBlockCallThread() resume BDH channel");
      this.this$0.app.getHwEngine().resumeTransactionTask(this.this$0.mTrans);
      return;
    }
    this.this$0.log("<BDH_LOG> sendFileNotBlockCallThread() resume BDH channel, but trans == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.C2CPicUploadProcessor.2
 * JD-Core Version:    0.7.0.1
 */