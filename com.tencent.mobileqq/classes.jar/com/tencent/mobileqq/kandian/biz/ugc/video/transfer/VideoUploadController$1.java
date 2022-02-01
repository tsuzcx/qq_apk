package com.tencent.mobileqq.kandian.biz.ugc.video.transfer;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class VideoUploadController$1
  implements Runnable
{
  VideoUploadController$1(VideoUploadController paramVideoUploadController) {}
  
  public void run()
  {
    if ((!TextUtils.isEmpty(VideoUploadController.a(this.this$0))) && (!TextUtils.isEmpty(VideoUploadController.b(this.this$0))) && (!VideoUploadController.a(this.this$0).equals(VideoUploadController.b(this.this$0))))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("clearTempFile(video), origin:");
        ((StringBuilder)localObject).append(VideoUploadController.a(this.this$0));
        ((StringBuilder)localObject).append(", compress:");
        ((StringBuilder)localObject).append(VideoUploadController.b(this.this$0));
        QLog.d("VideoUploadController", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new File(VideoUploadController.b(this.this$0));
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.video.transfer.VideoUploadController.1
 * JD-Core Version:    0.7.0.1
 */