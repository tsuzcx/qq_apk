package com.tencent.mobileqq.minigame.api.report;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;

@QAPI(process={"all"})
public abstract interface IMiniGameReport
  extends QRouteApi
{
  public abstract void clickReportMiniGameFromLeba(@Nullable BusinessInfoCheckUpdate.AppInfo paramAppInfo);
  
  public abstract void exposeReportMiniGameFromLeba(@Nullable BusinessInfoCheckUpdate.AppInfo paramAppInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.api.report.IMiniGameReport
 * JD-Core Version:    0.7.0.1
 */