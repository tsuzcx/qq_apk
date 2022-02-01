package com.tencent.mobileqq.profilecard.bussiness.circle;

import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;

class ProfileCircleComponent$FeedVsRspCallBack$1
  implements Runnable
{
  ProfileCircleComponent$FeedVsRspCallBack$1(ProfileCircleComponent.FeedVsRspCallBack paramFeedVsRspCallBack, ProfileCircleComponent paramProfileCircleComponent) {}
  
  public void run()
  {
    ProfileCircleComponent localProfileCircleComponent = this.val$circleComponent;
    localProfileCircleComponent.makeOrRefreshQQCircle(((ProfileCardInfo)ProfileCircleComponent.access$600(localProfileCircleComponent)).card);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.circle.ProfileCircleComponent.FeedVsRspCallBack.1
 * JD-Core Version:    0.7.0.1
 */