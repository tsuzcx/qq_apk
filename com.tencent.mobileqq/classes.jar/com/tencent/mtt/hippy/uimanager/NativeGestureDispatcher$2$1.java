package com.tencent.mtt.hippy.uimanager;

import android.view.View;
import com.tencent.mtt.hippy.HippyInstanceContext;

class NativeGestureDispatcher$2$1
  implements Runnable
{
  NativeGestureDispatcher$2$1(NativeGestureDispatcher.2 param2, View paramView) {}
  
  public void run()
  {
    int i = this.a.getId();
    NativeGestureDispatcher.handleLongClick(((HippyInstanceContext)this.a.getContext()).getEngineContext(), i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher.2.1
 * JD-Core Version:    0.7.0.1
 */