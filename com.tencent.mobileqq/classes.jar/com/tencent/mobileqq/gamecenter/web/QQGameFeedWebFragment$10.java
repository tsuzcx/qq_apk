package com.tencent.mobileqq.gamecenter.web;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;

class QQGameFeedWebFragment$10
  implements OnItemSelectListener
{
  QQGameFeedWebFragment$10(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    if (paramInt == 5)
    {
      paramView = new ActivityURIRequest(this.a.getActivity(), "/pubaccount/detail");
      paramView.extra().putString("uin", "2747277822");
      paramView.extra().putBoolean("fromQGamePub", true);
      QRoute.startUri(paramView, null);
    }
    while (paramInt != 1) {
      return;
    }
    QQGameFeedWebFragment.a(this.a, this.a.a);
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment.10
 * JD-Core Version:    0.7.0.1
 */