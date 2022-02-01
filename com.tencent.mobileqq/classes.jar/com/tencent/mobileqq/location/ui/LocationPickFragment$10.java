package com.tencent.mobileqq.location.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LocationPickFragment$10
  implements View.OnClickListener
{
  LocationPickFragment$10(LocationPickFragment paramLocationPickFragment) {}
  
  public void onClick(View paramView)
  {
    if (LocationPickFragment.d(this.a).h()) {
      LocationPickFragment.d(this.a).b();
    } else {
      LocationPickFragment.d(this.a).a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPickFragment.10
 * JD-Core Version:    0.7.0.1
 */