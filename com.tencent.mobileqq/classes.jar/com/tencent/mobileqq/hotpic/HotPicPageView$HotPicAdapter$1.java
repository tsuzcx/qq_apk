package com.tencent.mobileqq.hotpic;

import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;

class HotPicPageView$HotPicAdapter$1
  implements HotVideoData.HotVideoGetUrlCallBack
{
  HotPicPageView$HotPicAdapter$1(HotPicPageView.HotPicAdapter paramHotPicAdapter, HotVideoData paramHotVideoData, HotPicPageView.MyVideoViewHolder paramMyVideoViewHolder, URLDrawable paramURLDrawable) {}
  
  public void a(HotVideoData.HotVideoGetUrlResult paramHotVideoGetUrlResult)
  {
    if (paramHotVideoGetUrlResult.a)
    {
      this.a.url = paramHotVideoGetUrlResult.a();
      if (this.b.a() == this.a)
      {
        this.b.a(this.c);
        this.c.setAutoDownload(true);
        this.c.restartDownload();
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onFileDownloadFailed:");
        localStringBuilder.append(this.a.picIndex);
        localStringBuilder.append(" GetUrlFailed msg:");
        localStringBuilder.append(paramHotVideoGetUrlResult.b);
        QLog.d("HotPicManagerHotPicPageView", 2, localStringBuilder.toString());
      }
      if (this.b.a() == this.a) {
        this.b.a(-10);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView.HotPicAdapter.1
 * JD-Core Version:    0.7.0.1
 */