package com.tencent.mtt.hippy.uimanager;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mtt.hippy.HippyInstanceContext;

final class NativeGestureDispatcher$2
  implements View.OnLongClickListener
{
  public boolean onLongClick(View paramView)
  {
    if ((paramView != null) && ((paramView.getContext() instanceof HippyInstanceContext))) {
      paramView.postDelayed(new NativeGestureDispatcher.2.1(this, paramView), NativeGestureDispatcher.access$000());
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher.2
 * JD-Core Version:    0.7.0.1
 */