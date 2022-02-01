package com.tencent.mobileqq.hotpic;

import android.view.View;
import com.tencent.qphone.base.util.QLog;

class HotVideoMongoliaRelativeLayout$1
  implements HotVideoMongoliaRelativeLayout.InnerOnClickListener
{
  HotVideoMongoliaRelativeLayout$1(HotVideoMongoliaRelativeLayout paramHotVideoMongoliaRelativeLayout) {}
  
  public void onClick(View paramView)
  {
    HotPicPageView.z = true;
    if ((this.a.j == 2) && (this.a.k != null))
    {
      this.a.k.a(0, paramView);
      return;
    }
    if ((this.a.j == 3) && (this.a.k != null)) {
      this.a.k.a(4, paramView);
    } else if ((this.a.j == 4) && (this.a.k != null)) {
      this.a.k.a(1, paramView);
    } else if ((this.a.j == 6) && (this.a.k != null)) {
      this.a.k.a(2, paramView);
    }
    QLog.d("HotVideoRelativeLayout", 2, "click base view");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotVideoMongoliaRelativeLayout.1
 * JD-Core Version:    0.7.0.1
 */