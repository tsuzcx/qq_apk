package dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class HorizontalSelectColorLayout$3
  implements View.OnClickListener
{
  HorizontalSelectColorLayout$3(HorizontalSelectColorLayout paramHorizontalSelectColorLayout) {}
  
  public void onClick(View paramView)
  {
    if (HorizontalSelectColorLayout.a(this.a) > System.currentTimeMillis()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.a != null) {
        this.a.a.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout.3
 * JD-Core Version:    0.7.0.1
 */