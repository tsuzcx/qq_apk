package com.tencent.mobileqq.vas.qvip.fragment;

import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
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
      paramView = new ActivityURIRequest(this.a.getBaseActivity(), "/pubaccount/detail");
      paramView.extra().putString("uin", AppConstants.QQ_VIP_UIN);
      paramView.extra().putBoolean("fromQGamePub", true);
      QRoute.startUri(paramView, null);
      return;
    }
    if (paramInt == 1) {
      this.a.getBaseActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.fragment.QQVipFeedWedFragment.2
 * JD-Core Version:    0.7.0.1
 */