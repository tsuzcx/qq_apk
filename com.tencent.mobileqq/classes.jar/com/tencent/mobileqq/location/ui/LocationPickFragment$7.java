package com.tencent.mobileqq.location.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.statistics.ReportController;

class LocationPickFragment$7
  implements View.OnTouchListener
{
  LocationPickFragment$7(LocationPickFragment paramLocationPickFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (1 == paramMotionEvent.getAction())
    {
      if (!LocationPickFragment.d(this.a).h())
      {
        LocationPickFragment.d(this.a).setDisplayFromType(3);
        LocationPickFragment.d(this.a).a();
      }
      ReportController.b(null, "CliOper", "", "", "0X800A95E", "0X800A95E", 0, 0, "", "0", "0", "");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPickFragment.7
 * JD-Core Version:    0.7.0.1
 */