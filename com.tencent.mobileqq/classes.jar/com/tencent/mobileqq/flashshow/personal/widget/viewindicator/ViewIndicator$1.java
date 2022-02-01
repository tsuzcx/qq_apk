package com.tencent.mobileqq.flashshow.personal.widget.viewindicator;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.Set;

class ViewIndicator$1
  implements View.OnClickListener
{
  ViewIndicator$1(ViewIndicator paramViewIndicator, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (!ViewIndicator.a(this.b))
    {
      ViewIndicator.a(this.b, this.a);
      Iterator localIterator = ViewIndicator.b(this.b).iterator();
      while (localIterator.hasNext()) {
        ((ViewIndicator.TextItemClickListener)localIterator.next()).a(this.a);
      }
      localIterator = ViewIndicator.c(this.b).iterator();
      while (localIterator.hasNext()) {
        ((ViewPager)localIterator.next()).setCurrentItem(this.a, false);
      }
      localIterator = ViewIndicator.d(this.b).iterator();
      while (localIterator.hasNext()) {
        ((ViewPager2)localIterator.next()).setCurrentItem(this.a, false);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.personal.widget.viewindicator.ViewIndicator.1
 * JD-Core Version:    0.7.0.1
 */