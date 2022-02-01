package com.tencent.mobileqq.kandian.base.image;

import com.tencent.mobileqq.kandian.base.image.imageloader.RIJImageOptReport;
import java.util.concurrent.ThreadPoolExecutor;

class ImageManager$1
  implements Runnable
{
  ImageManager$1(ImageManager paramImageManager, ImageRequest paramImageRequest, RunningJob paramRunningJob) {}
  
  public void run()
  {
    RIJImageOptReport.a(3, this.a);
    this.this$0.mExcutor.execute(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.ImageManager.1
 * JD-Core Version:    0.7.0.1
 */