package com.tencent.mobileqq.hotpic;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class HotVideoMongoliaRelativeLayout$2
  implements View.OnClickListener
{
  HotVideoMongoliaRelativeLayout$2(HotVideoMongoliaRelativeLayout paramHotVideoMongoliaRelativeLayout) {}
  
  public void onClick(View paramView)
  {
    HotPicPageView.z = true;
    if (this.a.k != null)
    {
      if (HotVideoMongoliaRelativeLayout.a(this.a) != null) {
        HotVideoMongoliaRelativeLayout.a(this.a).b(HotVideoMongoliaRelativeLayout.b(this.a));
      }
      QLog.d("HotVideoRelativeLayout", 2, "click round rect send view");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotVideoMongoliaRelativeLayout.2
 * JD-Core Version:    0.7.0.1
 */