package com.tencent.mobileqq.kandian.biz.pts.component;

import android.graphics.Color;
import android.text.TextPaint;
import android.widget.Button;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.account.api.Ox978RespCallBack;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

class ComponentHeaderRecommend$2
  implements Ox978RespCallBack
{
  ComponentHeaderRecommend$2(ComponentHeaderRecommend paramComponentHeaderRecommend) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    ComponentHeaderRecommend.a(this.a).setText(HardCodeUtil.a(2131702486));
    ComponentHeaderRecommend.a(this.a).setTextColor(Color.parseColor("#BBBBBB"));
    ComponentHeaderRecommend.a(this.a).setEnabled(false);
    ComponentHeaderRecommend.a(this.a).getPaint().setFakeBoldText(false);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("followPubAccount() onFollowPublicAccount uin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", isSuccess=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("ComponentHeaderRecommend", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.a.a.a != null) && (this.a.a.a.a() != null))
    {
      localObject = this.a.a.a.a();
      long l = ((AbsBaseArticleInfo)localObject).mAlgorithmID;
      paramInt = RIJFeedsType.a((AbsBaseArticleInfo)localObject);
      int i = this.a.a.a.c();
      paramBoolean = NetworkUtil.isWifiConnected(this.a.getContext());
      paramString = new StringBuilder();
      paramString.append(ComponentHeaderRecommend.a(this.a));
      paramString.append("");
      String str = RIJTransMergeKanDianReport.a(l, paramInt, i, 0, 0, paramBoolean, paramString.toString(), null, ((AbsBaseArticleInfo)localObject).innerUniqueID, null, (AbsBaseArticleInfo)localObject);
      if (ReadinjoyReportUtils.a(this.a.a.a.c())) {
        paramString = "0X800941D";
      } else {
        paramString = "0X80080EC";
      }
      IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ComponentHeaderRecommend.a(this.a));
      localStringBuilder.append("");
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, localStringBuilder.toString(), paramString, paramString, 0, 0, String.valueOf(((AbsBaseArticleInfo)localObject).mFeedId), String.valueOf(((AbsBaseArticleInfo)localObject).mArticleID), Integer.toString(((AbsBaseArticleInfo)localObject).mStrategyId), str, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderRecommend.2
 * JD-Core Version:    0.7.0.1
 */