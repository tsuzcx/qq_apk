package com.tencent.mobileqq.kandian.biz.pts.listeners;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.qphone.base.util.QLog;

public class OnJumpChannelListener
  implements ViewBase.OnClickListener
{
  AbsBaseArticleInfo a;
  Context b;
  
  public OnJumpChannelListener(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext, int paramInt)
  {
    this.a = paramAbsBaseArticleInfo;
    this.b = paramContext;
  }
  
  private void a()
  {
    PublicAccountReportUtils.a(null, null, "0X80097D7", "0X80097D7", 0, 0, "", "", "", "", false);
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    if (this.b != null)
    {
      paramViewBase = this.a;
      if ((paramViewBase != null) && (paramViewBase.mSocialFeedInfo != null) && (this.a.mSocialFeedInfo.H != null))
      {
        paramViewBase = this.a.mSocialFeedInfo.H;
        RIJJumpUtils.c(this.b, paramViewBase);
        break label62;
      }
    }
    paramViewBase = "";
    label62:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("jump channel,  context:");
    localStringBuilder.append(this.b);
    localStringBuilder.append("  url:");
    localStringBuilder.append(paramViewBase);
    QLog.d("OnFriendsBiuClickListener", 1, localStringBuilder.toString());
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnJumpChannelListener
 * JD-Core Version:    0.7.0.1
 */