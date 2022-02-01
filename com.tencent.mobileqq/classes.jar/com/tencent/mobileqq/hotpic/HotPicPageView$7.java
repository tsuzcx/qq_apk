package com.tencent.mobileqq.hotpic;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToastNotifier;

class HotPicPageView$7
  implements HotVideoData.HotVideoGetUrlCallBack
{
  HotPicPageView$7(HotPicPageView paramHotPicPageView, HotVideoData paramHotVideoData, HotPicPageView.MyVideoViewHolder paramMyVideoViewHolder) {}
  
  public void a(HotVideoData.HotVideoGetUrlResult paramHotVideoGetUrlResult)
  {
    if (paramHotVideoGetUrlResult.a)
    {
      this.a.originalUrl = paramHotVideoGetUrlResult.a();
      if (this.b.n != 1) {
        return;
      }
      this.c.e.runOnUiThread(new HotPicPageView.7.1(this));
      return;
    }
    if (this.b.n != 1) {
      return;
    }
    this.b.a(-11);
    new QQToastNotifier(this.c.b).notifyUser(HotVideoMongoliaRelativeLayout.a, 100, 0, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView.7
 * JD-Core Version:    0.7.0.1
 */