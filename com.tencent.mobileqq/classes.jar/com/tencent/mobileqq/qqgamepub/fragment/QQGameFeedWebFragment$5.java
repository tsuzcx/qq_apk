package com.tencent.mobileqq.qqgamepub.fragment;

import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqgamepub.web.GameWebCostLogic;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;

class QQGameFeedWebFragment$5
  implements OnItemSelectListener
{
  QQGameFeedWebFragment$5(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    if (paramInt == 5)
    {
      paramView = new ActivityURIRequest(this.a.l(), "/pubaccount/detail");
      paramView.extra().putString("uin", "2747277822");
      paramView.extra().putBoolean("fromQGamePub", true);
      QRoute.startUri(paramView, null);
      return;
    }
    if (paramInt == 1)
    {
      this.a.j().i();
      this.a.l().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.fragment.QQGameFeedWebFragment.5
 * JD-Core Version:    0.7.0.1
 */