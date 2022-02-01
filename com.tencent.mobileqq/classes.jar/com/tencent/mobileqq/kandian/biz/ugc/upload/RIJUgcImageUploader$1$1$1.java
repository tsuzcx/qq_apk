package com.tencent.mobileqq.kandian.biz.ugc.upload;

import com.tencent.qphone.base.util.QLog;

class RIJUgcImageUploader$1$1$1
  implements Runnable
{
  RIJUgcImageUploader$1$1$1(RIJUgcImageUploader.1.1 param1, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.a == 0)
    {
      QLog.i(RIJUgcImageUploader.a, 1, "uploadImage success");
      RIJUgcImageUploader.c(this.c.a.this$0).a(this.b);
      return;
    }
    String str = RIJUgcImageUploader.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uploadImage failed, errCode=");
    localStringBuilder.append(this.a);
    QLog.i(str, 1, localStringBuilder.toString());
    RIJUgcImageUploader.c(this.c.a.this$0).a(this.a, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.upload.RIJUgcImageUploader.1.1.1
 * JD-Core Version:    0.7.0.1
 */