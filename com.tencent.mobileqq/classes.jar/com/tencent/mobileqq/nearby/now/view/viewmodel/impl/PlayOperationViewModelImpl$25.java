package com.tencent.mobileqq.nearby.now.view.viewmodel.impl;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class PlayOperationViewModelImpl$25
  implements View.OnTouchListener
{
  PlayOperationViewModelImpl$25(PlayOperationViewModelImpl paramPlayOperationViewModelImpl) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() != 0) && (paramMotionEvent.getAction() != 2)) {
      this.a.mBinding.findViewById(2131377374).setAlpha(1.0F);
    } else {
      this.a.mBinding.findViewById(2131377374).setAlpha(0.5F);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.impl.PlayOperationViewModelImpl.25
 * JD-Core Version:    0.7.0.1
 */