package com.tencent.open.agent;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.open.widget.MaxHeightScrollView;

class QuickLoginAuthorityActivity$4
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  QuickLoginAuthorityActivity$4(QuickLoginAuthorityActivity paramQuickLoginAuthorityActivity) {}
  
  public void onGlobalLayout()
  {
    if ((DisplayUtil.hasNavBar(this.a)) && (DisplayUtil.isNavigationBarExist(this.a)))
    {
      int i = QuickLoginAuthorityActivity.a(this.a).a();
      int j = DisplayUtil.getNavigationBarHeight(this.a);
      QuickLoginAuthorityActivity.a(this.a).setMaxHeight(i - j);
    }
    QuickLoginAuthorityActivity.a(this.a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.QuickLoginAuthorityActivity.4
 * JD-Core Version:    0.7.0.1
 */