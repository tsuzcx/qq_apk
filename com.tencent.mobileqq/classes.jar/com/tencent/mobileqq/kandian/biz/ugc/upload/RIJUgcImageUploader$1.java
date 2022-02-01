package com.tencent.mobileqq.kandian.biz.ugc.upload;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.biz.ugc.video.transfer.ImageUploadController;

class RIJUgcImageUploader$1
  implements Runnable
{
  RIJUgcImageUploader$1(RIJUgcImageUploader paramRIJUgcImageUploader) {}
  
  public void run()
  {
    RIJUgcImageUploader localRIJUgcImageUploader = this.this$0;
    RIJUgcImageUploader.a(localRIJUgcImageUploader, new ImageUploadController(RIJUgcImageUploader.a(localRIJUgcImageUploader), RIJUgcImageUploader.b(this.this$0), new RIJUgcImageUploader.1.1(this)));
    ThreadManagerV2.excute(new RIJUgcImageUploader.1.2(this), 128, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.upload.RIJUgcImageUploader.1
 * JD-Core Version:    0.7.0.1
 */