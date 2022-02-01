package com.tencent.mobileqq.nearby.now.view.viewmodel.impl;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class PlayOperationViewModelImpl$1
  implements View.OnTouchListener
{
  PlayOperationViewModelImpl$1(PlayOperationViewModelImpl paramPlayOperationViewModelImpl) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.a.reshowOperaView();
    PlayOperationViewModelImpl.access$300(this.a).onTouchEvent(paramMotionEvent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.impl.PlayOperationViewModelImpl.1
 * JD-Core Version:    0.7.0.1
 */