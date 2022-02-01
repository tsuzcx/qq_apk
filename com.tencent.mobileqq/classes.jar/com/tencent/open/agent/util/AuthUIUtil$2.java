package com.tencent.open.agent.util;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.open.widget.MaxHeightScrollView;

final class AuthUIUtil$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  AuthUIUtil$2(Activity paramActivity, MaxHeightScrollView paramMaxHeightScrollView) {}
  
  public void onGlobalLayout()
  {
    if ((DisplayUtils.b(this.a)) && (ScreenUtil.isNavigationBarExist(this.a)))
    {
      i = this.b.getMaxHeight();
      int j = DisplayUtils.d(this.a);
      this.b.setMaxHeight(i - j);
    }
    int i = ((View)this.a.findViewById(2131445137).getParent()).getTop();
    if (i > 0)
    {
      MaxHeightScrollView localMaxHeightScrollView = this.b;
      localMaxHeightScrollView.setMaxHeight(localMaxHeightScrollView.getMaxHeight() - i);
    }
    this.b.getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.util.AuthUIUtil.2
 * JD-Core Version:    0.7.0.1
 */