package com.tencent.mobileqq.hotpic;

import com.tencent.mobileqq.widget.QQToastNotifier;

class HotPicPageView$4$1$1
  implements Runnable
{
  HotPicPageView$4$1$1(HotPicPageView.4.1 param1) {}
  
  public void run()
  {
    HotVideoData localHotVideoData = this.a.a.a.a();
    if ((localHotVideoData != null) && (this.a.a.a.n == 1) && (localHotVideoData.picIndex == this.a.a.b))
    {
      this.a.a.c.c(this.a.a.a, this.a.a.b);
      return;
    }
    new QQToastNotifier(this.a.a.c.b).notifyUser(HotVideoMongoliaRelativeLayout.d, 100, 0, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView.4.1.1
 * JD-Core Version:    0.7.0.1
 */