package com.tencent.mobileqq.kandian.base.image;

import com.tencent.mobileqq.kandian.base.image.imageloader.RIJImageOptReport;
import java.util.concurrent.ThreadPoolExecutor;

class ImageManager$1
  implements Runnable
{
  ImageManager$1(ImageManager paramImageManager, ImageRequest paramImageRequest, RunningJob paramRunningJob) {}
  
  public void run()
  {
    RIJImageOptReport.a(3, this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest);
    this.this$0.mExcutor.execute(this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageRunningJob);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.ImageManager.1
 * JD-Core Version:    0.7.0.1
 */