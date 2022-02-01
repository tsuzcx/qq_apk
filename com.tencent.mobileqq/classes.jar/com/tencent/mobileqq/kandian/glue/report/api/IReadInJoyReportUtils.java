package com.tencent.mobileqq.kandian.glue.report.api;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.kandian.base.image.imageloader.IRIJImageOptReport;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/report/api/IReadInJoyReportUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/kandian/base/image/imageloader/IRIJImageOptReport;", "doArticleClickEvent64Report", "", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "channelID", "", "getClickT", "", "channelId", "", "getNetWord", "context", "Landroid/content/Context;", "getReportSessionID", "isKanDianSubscribe", "", "newKanDianOidbReport", "structMsgRerord", "", "operation", "reportDelete", "uin", "reportKanDianDelete", "reportMsgExposure", "data", "reportSetTopOrCancelSetTop", "uinType", "isSetTop", "menuItem", "res", "Landroid/content/res/Resources;", "reset68bRespArticlePosReportInfo", "app", "Lmqq/app/AppRuntime;", "Companion", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyReportUtils
  extends IRIJImageOptReport, QRouteApi
{
  public static final IReadInJoyReportUtils.Companion Companion = IReadInJoyReportUtils.Companion.a;
  public static final int MOVE_CHANNEL_FRONT_SOURCE_UNKNOWN = 0;
  
  public abstract void doArticleClickEvent64Report(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt);
  
  @Nullable
  public abstract String getClickT(long paramLong);
  
  @Nullable
  public abstract String getNetWord(@Nullable Context paramContext);
  
  @Nullable
  public abstract String getReportSessionID();
  
  public abstract boolean isKanDianSubscribe(long paramLong);
  
  public abstract void newKanDianOidbReport(@Nullable Object paramObject, int paramInt);
  
  public abstract void reportDelete(@Nullable String paramString);
  
  public abstract void reportKanDianDelete();
  
  public abstract void reportMsgExposure(@Nullable Object paramObject);
  
  public abstract void reportSetTopOrCancelSetTop(int paramInt, @Nullable String paramString1, @Nullable String paramString2, @Nullable Resources paramResources);
  
  public abstract void reportSetTopOrCancelSetTop(int paramInt, @Nullable String paramString, boolean paramBoolean);
  
  public abstract void reset68bRespArticlePosReportInfo(@Nullable AppRuntime paramAppRuntime);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.api.IReadInJoyReportUtils
 * JD-Core Version:    0.7.0.1
 */