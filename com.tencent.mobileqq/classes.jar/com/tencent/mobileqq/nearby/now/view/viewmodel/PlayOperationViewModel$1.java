package com.tencent.mobileqq.nearby.now.view.viewmodel;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class PlayOperationViewModel$1
  implements View.OnTouchListener
{
  PlayOperationViewModel$1(PlayOperationViewModel paramPlayOperationViewModel) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.a.c();
    PlayOperationViewModel.a(this.a).onTouchEvent(paramMotionEvent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel.1
 * JD-Core Version:    0.7.0.1
 */