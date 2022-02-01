package com.tencent.mobileqq.kandian.glue.report.api.impl;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.glue.report.GalleryReportedUtils;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils.CoreReport;
import com.tencent.mobileqq.kandian.glue.report.api.IReadInJoyReportUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import java.util.HashMap;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/report/api/impl/ReadInJoyReportUtilsImpl;", "Lcom/tencent/mobileqq/kandian/glue/report/api/IReadInJoyReportUtils;", "()V", "doArticleClickEvent64Report", "", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "channelID", "", "getClickT", "", "channelId", "", "getNetWord", "context", "Landroid/content/Context;", "getReportSessionID", "isKanDianSubscribe", "", "newKanDianOidbReport", "structMsgRerord", "", "operation", "reportDelete", "uin", "reportKanDianDelete", "reportMsgExposure", "data", "reportQualityDataDimension", "resultCode", "eventId", "cost", "params", "Ljava/util/HashMap;", "reportSetTopOrCancelSetTop", "uinType", "isSetTop", "menuItem", "res", "Landroid/content/res/Resources;", "reportSlowImageRequest", "imageRequest", "Lcom/tencent/mobileqq/kandian/base/image/ImageRequest;", "reset68bRespArticlePosReportInfo", "app", "Lmqq/app/AppRuntime;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyReportUtilsImpl
  implements IReadInJoyReportUtils
{
  public void doArticleClickEvent64Report(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    ReadinjoyReportUtils.CoreReport.a(paramAbsBaseArticleInfo, paramInt);
  }
  
  @Nullable
  public String getClickT(long paramLong)
  {
    return ReadinjoyReportUtils.e(paramLong);
  }
  
  @Nullable
  public String getNetWord(@Nullable Context paramContext)
  {
    return GalleryReportedUtils.a(paramContext);
  }
  
  @Nullable
  public String getReportSessionID()
  {
    return ReadinjoyReportUtils.i;
  }
  
  public boolean isKanDianSubscribe(long paramLong)
  {
    return ReadinjoyReportUtils.d(paramLong);
  }
  
  public void newKanDianOidbReport(@Nullable Object paramObject, int paramInt)
  {
    ReadinjoyReportUtils.a((AppInterface)RIJQQAppInterfaceUtil.a(), (MessageForStructing)paramObject, paramInt);
  }
  
  public void reportDelete(@Nullable String paramString)
  {
    ReadinjoyReportUtils.a(paramString);
  }
  
  public void reportKanDianDelete() {}
  
  public void reportMsgExposure(@Nullable Object paramObject)
  {
    if ((paramObject instanceof RecentItemChatMsgData)) {
      ReadinjoyReportUtils.a((RecentItemChatMsgData)paramObject);
    }
  }
  
  public void reportQualityDataDimension(int paramInt1, int paramInt2, long paramLong, @Nullable HashMap<String, Object> paramHashMap)
  {
    RIJImageOptReportImpl.a.reportQualityDataDimension(paramInt1, paramInt2, paramLong, paramHashMap);
  }
  
  public void reportSetTopOrCancelSetTop(int paramInt, @Nullable String paramString1, @Nullable String paramString2, @Nullable Resources paramResources)
  {
    ReadinjoyReportUtils.a(paramInt, paramString1, paramString2, paramResources);
  }
  
  public void reportSetTopOrCancelSetTop(int paramInt, @Nullable String paramString, boolean paramBoolean)
  {
    ReadinjoyReportUtils.a(paramInt, paramString, paramBoolean);
  }
  
  public void reportSlowImageRequest(@Nullable ImageRequest paramImageRequest)
  {
    RIJImageOptReportImpl.a.reportSlowImageRequest(paramImageRequest);
  }
  
  public void reset68bRespArticlePosReportInfo(@Nullable AppRuntime paramAppRuntime)
  {
    ReadinjoyReportUtils.a(paramAppRuntime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.api.impl.ReadInJoyReportUtilsImpl
 * JD-Core Version:    0.7.0.1
 */