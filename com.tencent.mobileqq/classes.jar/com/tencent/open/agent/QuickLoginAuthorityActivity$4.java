package com.tencent.open.agent;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.open.widget.MaxHeightScrollView;

class QuickLoginAuthorityActivity$4
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  QuickLoginAuthorityActivity$4(QuickLoginAuthorityActivity paramQuickLoginAuthorityActivity) {}
  
  public void onGlobalLayout()
  {
    if ((DisplayUtils.b(this.a)) && (ScreenUtil.isNavigationBarExist(this.a)))
    {
      int i = QuickLoginAuthorityActivity.d(this.a).getMaxHeight();
      int j = DisplayUtils.d(this.a);
      QuickLoginAuthorityActivity.d(this.a).setMaxHeight(i - j);
    }
    QuickLoginAuthorityActivity.d(this.a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.QuickLoginAuthorityActivity.4
 * JD-Core Version:    0.7.0.1
 */