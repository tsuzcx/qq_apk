package com.tencent.mobileqq.fragment;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.qqprotect.qsec.QSecFramework;

class NearbyHybridFragment$6
  implements View.OnTouchListener
{
  NearbyHybridFragment$6(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) && (QSecFramework.a().a(1001).booleanValue())) {
      QSecFramework.a().a(5, 0, 2, new Object[] { Integer.valueOf(83), Integer.valueOf(1), Integer.valueOf(6), "clickWeb", null }, null);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyHybridFragment.6
 * JD-Core Version:    0.7.0.1
 */