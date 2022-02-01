package com.tencent.mobileqq.location.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnHoverListener;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.statistics.ReportController;

class LocationPickFragment$6
  implements View.OnHoverListener
{
  LocationPickFragment$6(LocationPickFragment paramLocationPickFragment) {}
  
  public boolean onHover(View paramView, MotionEvent paramMotionEvent)
  {
    paramMotionEvent = (AccessibilityManager)this.a.getActivity().getSystemService("accessibility");
    if ((paramMotionEvent != null) && (paramMotionEvent.isTouchExplorationEnabled()))
    {
      if (paramView.requestFocus()) {
        ((InputMethodManager)this.a.getActivity().getSystemService("input_method")).showSoftInput(paramView, 1);
      }
      if (!LocationPickFragment.a(this.a).b())
      {
        LocationPickFragment.a(this.a).setDisplayFromType(3);
        LocationPickFragment.a(this.a).a();
      }
      ReportController.b(null, "CliOper", "", "", "0X800A95E", "0X800A95E", 0, 0, "", "0", "0", "");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPickFragment.6
 * JD-Core Version:    0.7.0.1
 */