package com.tencent.mtt.hippy.uimanager;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.mtt.hippy.HippyInstanceContext;

final class NativeGestureDispatcher$4
  implements View.OnAttachStateChangeListener
{
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if ((paramView != null) && ((paramView.getContext() instanceof HippyInstanceContext)))
    {
      int i = paramView.getId();
      NativeGestureDispatcher.handleDetachedFromWindow(((HippyInstanceContext)paramView.getContext()).getEngineContext(), i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher.4
 * JD-Core Version:    0.7.0.1
 */