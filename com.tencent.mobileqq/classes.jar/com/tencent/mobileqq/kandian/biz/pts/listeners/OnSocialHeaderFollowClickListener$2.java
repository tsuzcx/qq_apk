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
      if ((OnSocialHeaderFollowClickListener.a(this.b) != null) && (OnSocialHeaderFollowClickListener.a(this.b).mSocialFeedInfo != null))
      {
        OnSocialHeaderFollowClickListener.a(this.b).mSocialFeedInfo.o = paramInt;
        ReadInJoyLogicEngine.a().c(OnSocialHeaderFollowClickListener.b(OnSocialHeaderFollowClickListener.a(this.b)), paramInt);
        if (this.a) {
          OnSocialHeaderFollowClickListener.b(this.b);
        }
        ThreadManager.getUIHandler().post(new OnSocialHeaderFollowClickListener.2.1(this));
      }
    }
    else {
      QQToast.makeText(OnSocialHeaderFollowClickListener.c(this.b), HardCodeUtil.a(2131905660), 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnSocialHeaderFollowClickListener.2
 * JD-Core Version:    0.7.0.1
 */