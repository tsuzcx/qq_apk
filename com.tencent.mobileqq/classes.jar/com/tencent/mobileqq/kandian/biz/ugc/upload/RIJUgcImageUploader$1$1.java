package com.tencent.mobileqq.kandian.biz.ugc.upload;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.biz.ugc.video.transfer.FileUploadController.FileUploadListener;
import com.tencent.mobileqq.kandian.biz.ugc.video.transfer.ImageUploadController;
import com.tencent.qphone.base.util.QLog;

class RIJUgcImageUploader$1$1
  implements FileUploadController.FileUploadListener
{
  RIJUgcImageUploader$1$1(RIJUgcImageUploader.1 param1) {}
  
  public void a() {}
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      paramString2 = RIJUgcImageUploader.a;
      paramString3 = new StringBuilder();
      paramString3.append("uploadImage finish, url=");
      paramString3.append(paramString1);
      QLog.i(paramString2, 2, paramString3.toString());
    }
    RIJUgcImageUploader.a(this.a.this$0, false);
    ThreadManagerV2.getUIHandlerV2().post(new RIJUgcImageUploader.1.1.1(this, paramInt, paramString1));
    RIJUgcImageUploader.a(this.a.this$0).b();
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    RIJUgcImageUploader.a(this.a.this$0).a(paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.upload.RIJUgcImageUploader.1.1
 * JD-Core Version:    0.7.0.1
 */