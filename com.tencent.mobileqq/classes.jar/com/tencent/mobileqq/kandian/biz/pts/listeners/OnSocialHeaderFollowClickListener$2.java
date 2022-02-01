package com.tencent.mobileqq.kandian.biz.pts.listeners;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.account.api.Ox978RespCallBack;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class OnSocialHeaderFollowClickListener$2
  implements Ox978RespCallBack
{
  OnSocialHeaderFollowClickListener$2(OnSocialHeaderFollowClickListener paramOnSocialHeaderFollowClickListener, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("978 resp, result : ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", data : ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", distUin : ");
    localStringBuilder.append(paramString);
    QLog.d("OnSocialHeaderFollowClickListener", 1, localStringBuilder.toString());
    if (paramBoolean)
    {
      if ((OnSocialHeaderFollowClickListener.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsListenersOnSocialHeaderFollowClickListener) != null) && (OnSocialHeaderFollowClickListener.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsListenersOnSocialHeaderFollowClickListener).mSocialFeedInfo != null))
      {
        OnSocialHeaderFollowClickListener.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsListenersOnSocialHeaderFollowClickListener).mSocialFeedInfo.h = paramInt;
        ReadInJoyLogicEngine.a().c(OnSocialHeaderFollowClickListener.a(OnSocialHeaderFollowClickListener.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsListenersOnSocialHeaderFollowClickListener)), paramInt);
        if (this.jdField_a_of_type_Boolean) {
          OnSocialHeaderFollowClickListener.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsListenersOnSocialHeaderFollowClickListener);
        }
        ThreadManager.getUIHandler().post(new OnSocialHeaderFollowClickListener.2.1(this));
      }
    }
    else {
      QQToast.a(OnSocialHeaderFollowClickListener.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsListenersOnSocialHeaderFollowClickListener), HardCodeUtil.a(2131707846), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnSocialHeaderFollowClickListener.2
 * JD-Core Version:    0.7.0.1
 */