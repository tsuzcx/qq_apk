package com.tencent.mobileqq.nearby.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NearbyPublishMenu$1
  implements View.OnClickListener
{
  NearbyPublishMenu$1(NearbyPublishMenu paramNearbyPublishMenu) {}
  
  public void onClick(View paramView)
  {
    if (((paramView.getTag() instanceof NearbyPublishMenu.MenuItem)) && (this.a.a != null))
    {
      NearbyPublishMenu.MenuItem localMenuItem = (NearbyPublishMenu.MenuItem)paramView.getTag();
      this.a.a.a(this.a, paramView, localMenuItem);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.NearbyPublishMenu.1
 * JD-Core Version:    0.7.0.1
 */