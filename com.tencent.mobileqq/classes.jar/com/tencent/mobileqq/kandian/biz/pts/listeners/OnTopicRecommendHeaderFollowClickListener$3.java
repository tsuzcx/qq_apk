package com.tencent.mobileqq.kandian.biz.pts.listeners;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.repo.account.api.Ox978RespCallBack;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.qphone.base.util.QLog;

class OnTopicRecommendHeaderFollowClickListener$3
  implements Ox978RespCallBack
{
  OnTopicRecommendHeaderFollowClickListener$3(OnTopicRecommendHeaderFollowClickListener paramOnTopicRecommendHeaderFollowClickListener, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("取消关注 handleResp request businessID = ");
      localStringBuilder.append(OnTopicRecommendHeaderFollowClickListener.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsListenersOnTopicRecommendHeaderFollowClickListener).a);
      localStringBuilder.append(" requestFollowType = ");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append(" isSuccess = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" distUin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" data = ");
      localStringBuilder.append(paramInt);
      QLog.d("OnTopicRecommendHeaderFollowClickListener", 2, localStringBuilder.toString());
    }
    int i = OnTopicRecommendHeaderFollowClickListener.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsListenersOnTopicRecommendHeaderFollowClickListener).a;
    if ((paramBoolean) && (paramInt == 2) && (String.valueOf(i).equals(paramString)))
    {
      ThreadManager.post(new OnTopicRecommendHeaderFollowClickListener.3.1(this), 5, null, true);
      return;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("取消关注失败 isSuccess =");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" distUin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" data = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" isfollow ");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append(" businessId = ");
      localStringBuilder.append(OnTopicRecommendHeaderFollowClickListener.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsListenersOnTopicRecommendHeaderFollowClickListener).a);
      QLog.e("OnTopicRecommendHeaderFollowClickListener", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnTopicRecommendHeaderFollowClickListener.3
 * JD-Core Version:    0.7.0.1
 */