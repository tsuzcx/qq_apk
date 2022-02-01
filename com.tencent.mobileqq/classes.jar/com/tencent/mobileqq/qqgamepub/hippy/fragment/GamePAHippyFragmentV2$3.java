package com.tencent.mobileqq.qqgamepub.hippy.fragment;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GamePAHippyFragmentV2$3
  implements View.OnClickListener
{
  GamePAHippyFragmentV2$3(GamePAHippyFragmentV2 paramGamePAHippyFragmentV2) {}
  
  public void onClick(View paramView)
  {
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.a.getActivity(), "/pubaccount/detail");
    localActivityURIRequest.extra().putString("uin", "2747277822");
    localActivityURIRequest.extra().putBoolean("fromQGamePub", true);
    QRoute.startUri(localActivityURIRequest, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyFragmentV2.3
 * JD-Core Version:    0.7.0.1
 */