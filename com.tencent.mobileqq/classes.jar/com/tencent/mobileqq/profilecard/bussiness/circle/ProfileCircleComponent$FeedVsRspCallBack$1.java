package com.tencent.mobileqq.profilecard.bussiness.circle;

import com.tencent.mobileqq.profile.ProfileCardInfo;

class ProfileCircleComponent$FeedVsRspCallBack$1
  implements Runnable
{
  ProfileCircleComponent$FeedVsRspCallBack$1(ProfileCircleComponent.FeedVsRspCallBack paramFeedVsRspCallBack, ProfileCircleComponent paramProfileCircleComponent) {}
  
  public void run()
  {
    this.val$circleComponent.makeOrRefreshQQCircle(((ProfileCardInfo)ProfileCircleComponent.access$600(this.val$circleComponent)).a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.circle.ProfileCircleComponent.FeedVsRspCallBack.1
 * JD-Core Version:    0.7.0.1
 */