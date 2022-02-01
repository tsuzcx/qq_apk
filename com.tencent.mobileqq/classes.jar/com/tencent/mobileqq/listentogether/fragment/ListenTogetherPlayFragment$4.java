package com.tencent.mobileqq.listentogether.fragment;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ListenTogetherPlayFragment$4
  implements View.OnTouchListener
{
  float a = 0.0F;
  
  ListenTogetherPlayFragment$4(ListenTogetherPlayFragment paramListenTogetherPlayFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.a = paramView.getAlpha();
      paramView.setAlpha(this.a * 0.5F);
    }
    else if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
    {
      paramView.setAlpha(this.a);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.fragment.ListenTogetherPlayFragment.4
 * JD-Core Version:    0.7.0.1
 */