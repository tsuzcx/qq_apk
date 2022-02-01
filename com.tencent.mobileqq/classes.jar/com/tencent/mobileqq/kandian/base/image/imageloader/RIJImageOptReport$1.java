package com.tencent.mobileqq.kandian.base.image.imageloader;

import com.tencent.mobileqq.kandian.base.image.ImageRequest;

final class RIJImageOptReport$1
  implements Runnable
{
  RIJImageOptReport$1(ImageRequest paramImageRequest, String paramString) {}
  
  public void run()
  {
    if (RIJImageOptReport.b(this.a))
    {
      ImageRequest localImageRequest = this.a;
      localImageRequest.r = this.b;
      RIJImageOptReport.c(localImageRequest);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.imageloader.RIJImageOptReport.1
 * JD-Core Version:    0.7.0.1
 */