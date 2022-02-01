package com.tencent.mobileqq.location.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.location.LocationShareViewModel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LocationShareController$2
  implements View.OnClickListener
{
  LocationShareController$2(LocationShareController paramLocationShareController) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.d())
    {
      this.a.a.a(true);
      LocationShareController.b(this.a).c();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationShareController.2
 * JD-Core Version:    0.7.0.1
 */