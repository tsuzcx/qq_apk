package com.tencent.mobileqq.vas.qvip.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;

class QQVipFeedWedFragment$2
  implements OnItemSelectListener
{
  QQVipFeedWedFragment$2(QQVipFeedWedFragment paramQQVipFeedWedFragment) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    if (paramInt == 5)
    {
      paramView = new ActivityURIRequest(this.a.getActivity(), "/pubaccount/detail");
      paramView.extra().putString("uin", AppConstants.QQ_VIP_UIN);
      paramView.extra().putBoolean("fromQGamePub", true);
      QRoute.startUri(paramView, null);
    }
    while (paramInt != 1) {
      return;
    }
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.fragment.QQVipFeedWedFragment.2
 * JD-Core Version:    0.7.0.1
 */