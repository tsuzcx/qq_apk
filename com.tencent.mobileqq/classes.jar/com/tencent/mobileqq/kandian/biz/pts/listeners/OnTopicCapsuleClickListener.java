package com.tencent.mobileqq.kandian.biz.pts.listeners;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.qphone.base.util.QLog;

public class OnTopicCapsuleClickListener
  implements ViewBase.OnClickListener
{
  private AbsBaseArticleInfo a;
  private Context b;
  
  public OnTopicCapsuleClickListener(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext)
  {
    this.a = paramAbsBaseArticleInfo;
    this.b = paramContext;
  }
  
  private void a()
  {
    Object localObject1 = this.a;
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((AbsBaseArticleInfo)localObject1).businessUrl;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("business url is ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("OnTopicCapsuleClickListener", 2, ((StringBuilder)localObject2).toString());
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = this.b;
      if (localObject2 == null) {
        return;
      }
      localObject2 = new ActivityURIRequest((Context)localObject2, "/pubaccount/browser");
      ((ActivityURIRequest)localObject2).extra().putString("url", (String)localObject1);
      QRoute.startUri((URIRequest)localObject2, null);
      PublicAccountReportUtils.a(this.a);
      localObject1 = this.a;
      RIJFrameworkReportManager.b((AbsBaseArticleInfo)localObject1, (int)((AbsBaseArticleInfo)localObject1).mChannelID);
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnTopicCapsuleClickListener
 * JD-Core Version:    0.7.0.1
 */