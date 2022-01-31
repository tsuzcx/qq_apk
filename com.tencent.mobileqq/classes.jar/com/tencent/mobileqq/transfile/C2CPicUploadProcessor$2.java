package com.tencent.mobileqq.transfile;

import aypj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.HwEngine;

public class C2CPicUploadProcessor$2
  implements Runnable
{
  public C2CPicUploadProcessor$2(aypj paramaypj) {}
  
  public void run()
  {
    if (this.this$0.b != null)
    {
      this.this$0.d("<BDH_LOG> sendFileNotBlockCallThread() resume BDH channel");
      this.this$0.a.getHwEngine().resumeTransactionTask(this.this$0.b);
      return;
    }
    this.this$0.d("<BDH_LOG> sendFileNotBlockCallThread() resume BDH channel, but trans == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.C2CPicUploadProcessor.2
 * JD-Core Version:    0.7.0.1
 */