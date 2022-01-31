package com.tencent.mobileqq.transfile;

import axqk;
import axqq;
import axqr;
import com.tencent.qphone.base.util.QLog;

class ForwardSdkShareProcessor$ImageUploadStep$1$1
  implements Runnable
{
  ForwardSdkShareProcessor$ImageUploadStep$1$1(ForwardSdkShareProcessor.ImageUploadStep.1 param1) {}
  
  public void run()
  {
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "ImageUploadStep|changeImgUrl,need rich since invalid url=" + axqk.a(this.a.a.b));
    axqk.c(this.a.a.b, null);
    axqk.a(this.a.a.b).g();
    axqk.a(this.a.a.b).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ImageUploadStep.1.1
 * JD-Core Version:    0.7.0.1
 */