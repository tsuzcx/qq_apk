package com.tencent.mobileqq.kandian.biz.pts.listeners;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;

class OnSocialHeaderFollowClickListener$1
  implements IReadInJoyUserInfoModule.RefreshUserInfoCallBack
{
  OnSocialHeaderFollowClickListener$1(OnSocialHeaderFollowClickListener paramOnSocialHeaderFollowClickListener, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    OnSocialHeaderFollowClickListener.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsListenersOnSocialHeaderFollowClickListener, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, "", true);
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsListenersOnSocialHeaderFollowClickListener;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramReadInJoyUserInfo.faceUrl);
    localStringBuilder.append("140");
    OnSocialHeaderFollowClickListener.a(paramString, localQQAppInterface, str, localStringBuilder.toString(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnSocialHeaderFollowClickListener.1
 * JD-Core Version:    0.7.0.1
 */