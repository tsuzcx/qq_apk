package com.tencent.mobileqq.kandian.biz.framework.click;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class RIJFrameworkHandleClick$2
  implements ClickHandler
{
  RIJFrameworkHandleClick$2(RIJFrameworkHandleClick paramRIJFrameworkHandleClick) {}
  
  public void onClick(View paramView)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramView.getTag();
    String str1;
    if ((!TextUtils.isEmpty(localAbsBaseArticleInfo.getSubscribeUin())) && (!"16888".equals(localAbsBaseArticleInfo.getSubscribeUin()))) {
      str1 = localAbsBaseArticleInfo.getSubscribeUin();
    } else if ((!TextUtils.isEmpty(localAbsBaseArticleInfo.thirdUin)) && (!"16888".equals(localAbsBaseArticleInfo.thirdUin))) {
      str1 = localAbsBaseArticleInfo.thirdUin;
    } else {
      str1 = null;
    }
    if ((str1 != null) && (!localAbsBaseArticleInfo.unowned))
    {
      localObject = this.a;
      RIJFrameworkHandleClick.a((RIJFrameworkHandleClick)localObject, str1, RIJFrameworkHandleClick.a((RIJFrameworkHandleClick)localObject).a().a());
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onClick: handleAccountViewGroupClick articleinfo unowned = ");
      ((StringBuilder)localObject).append(localAbsBaseArticleInfo.unowned);
      QLog.d("RIJFrameworkHandleClick", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = localAbsBaseArticleInfo.mVideoVid;
    String str2 = String.valueOf(localAbsBaseArticleInfo.innerUniqueID);
    long l;
    if (RIJFrameworkHandleClick.a(this.a).a().a() == null) {
      l = 0L;
    } else {
      l = RIJFrameworkHandleClick.a(this.a).a().a().b();
    }
    str2 = new VideoR5.Builder(null, str1, (String)localObject, str2, l, localAbsBaseArticleInfo.mVideoDuration * 1000).a(RIJFrameworkHandleClick.a(this.a).a().b()).a().a();
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    if (!TextUtils.isEmpty(localAbsBaseArticleInfo.innerUniqueID)) {
      localObject = String.valueOf(localAbsBaseArticleInfo.innerUniqueID);
    } else {
      localObject = "0";
    }
    localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str1, "0X8007410", "0X8007410", 0, 0, "2", "", (String)localObject, str2, false);
    ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).setAdapterMonitorClickAdParams(RIJFrameworkHandleClick.a(this.a).a().a(), localAbsBaseArticleInfo, RIJFrameworkHandleClick.a(this.a).a().a(), 56);
    ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).doActionAndReport((Activity)RIJFrameworkHandleClick.a(this.a).a().a(), localAbsBaseArticleInfo, RIJFrameworkHandleClick.a(this.a).a().a(), 56, false, null);
    if (paramView.getId() == 2131361884) {
      VideoHandler.a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.click.RIJFrameworkHandleClick.2
 * JD-Core Version:    0.7.0.1
 */