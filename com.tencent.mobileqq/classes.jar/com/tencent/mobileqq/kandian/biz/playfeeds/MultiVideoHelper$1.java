package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.api.IBitmapCallback;
import com.tencent.mobileqq.kandian.base.image.api.ICloseableBitmap;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

final class MultiVideoHelper$1
  implements IBitmapCallback
{
  MultiVideoHelper$1(AbsBaseArticleInfo paramAbsBaseArticleInfo, URL paramURL) {}
  
  public void a(ImageRequest paramImageRequest, int paramInt) {}
  
  public void a(ImageRequest paramImageRequest, ICloseableBitmap paramICloseableBitmap)
  {
    this.a.setHasFirstFramePreload(true);
    if (QLog.isColorLevel())
    {
      paramImageRequest = MultiVideoHelper.a;
      paramICloseableBitmap = new StringBuilder();
      paramICloseableBitmap.append("preload success width: ");
      paramICloseableBitmap.append(this.a.getFirstFrameWidth());
      paramICloseableBitmap.append(", height: ");
      paramICloseableBitmap.append(this.a.getFirstFrameHeight());
      paramICloseableBitmap.append(", ");
      paramICloseableBitmap.append(this.b);
      paramICloseableBitmap.append(", title: ");
      paramICloseableBitmap.append(this.a.mTitle);
      QLog.d(paramImageRequest, 2, paramICloseableBitmap.toString());
    }
  }
  
  public void a(ImageRequest paramImageRequest, Throwable paramThrowable)
  {
    paramImageRequest = MultiVideoHelper.a;
    paramThrowable = new StringBuilder();
    paramThrowable.append("preload failed ");
    paramThrowable.append(this.b);
    QLog.e(paramImageRequest, 2, paramThrowable.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.MultiVideoHelper.1
 * JD-Core Version:    0.7.0.1
 */