package com.tencent.mtt.hippy.uimanager;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.mtt.hippy.HippyInstanceContext;

final class NativeGestureDispatcher$3
  implements View.OnAttachStateChangeListener
{
  public void onViewAttachedToWindow(View paramView)
  {
    if ((paramView != null) && ((paramView.getContext() instanceof HippyInstanceContext)))
    {
      int i = paramView.getId();
      NativeGestureDispatcher.handleAttachedToWindow(((HippyInstanceContext)paramView.getContext()).getEngineContext(), i);
    }
  }
  
  public void onViewDetachedFromWindow(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher.3
 * JD-Core Version:    0.7.0.1
 */