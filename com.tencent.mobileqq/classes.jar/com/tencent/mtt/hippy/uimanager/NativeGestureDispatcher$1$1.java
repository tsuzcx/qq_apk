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
    NativeGestureDispatcher.handleClick(((HippyInstanceContext)this.a.getContext()).getEngineContext(), i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher.1.1
 * JD-Core Version:    0.7.0.1
 */