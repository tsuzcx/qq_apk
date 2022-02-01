package com.tencent.mtt.hippy.uimanager;

import android.view.View;
import com.tencent.mtt.hippy.HippyInstanceContext;

class NativeGestureDispatcher$1$1
  implements Runnable
{
  NativeGestureDispatcher$1$1(NativeGestureDispatcher.1 param1, View paramView) {}
  
  public void run()
  {
    int i = this.a.getId();
    View localView = this.a;
    NativeGestureDispatcher.handleClick(localView, ((HippyInstanceContext)localView.getContext()).getEngineContext(), i, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher.1.1
 * JD-Core Version:    0.7.0.1
 */