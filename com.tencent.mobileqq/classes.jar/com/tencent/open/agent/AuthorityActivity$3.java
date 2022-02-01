package com.tencent.open.agent;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.open.widget.MaxHeightScrollView;

class AuthorityActivity$3
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  AuthorityActivity$3(AuthorityActivity paramAuthorityActivity) {}
  
  public void onGlobalLayout()
  {
    if ((DisplayUtil.hasNavBar(this.a)) && (DisplayUtil.isNavigationBarExist(this.a)))
    {
      i = AuthorityActivity.a(this.a).a();
      int j = DisplayUtil.getNavigationBarHeight(this.a);
      AuthorityActivity.a(this.a).setMaxHeight(i - j);
    }
    int i = ((View)this.a.findViewById(2131377356).getParent()).getTop();
    if (i > 0) {
      AuthorityActivity.a(this.a).setMaxHeight(AuthorityActivity.a(this.a).a() - i);
    }
    AuthorityActivity.a(this.a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityActivity.3
 * JD-Core Version:    0.7.0.1
 */