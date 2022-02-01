package com.tencent.mtt.hippy.uimanager;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class NativeGestureDispatcher$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if ((paramView != null) && ((paramView.getContext() instanceof HippyInstanceContext))) {
      paramView.postDelayed(new NativeGestureDispatcher.1.1(this, paramView), NativeGestureDispatcher.access$000());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher.1
 * JD-Core Version:    0.7.0.1
 */