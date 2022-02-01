package com.tencent.mobileqq.kandian.biz.common.baseui.api;

import android.app.Activity;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.glue.businesshandler.api.IBaseHandler;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/baseui/api/IBaseUiBridge;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "checkAndReportAdExposure", "", "adapter", "Lcom/tencent/mobileqq/kandian/biz/common/baseui/IReadInJoyBaseAdapter;", "destroyDataFromFeeds", "doOnFeedsPause", "activity", "Landroid/app/Activity;", "doOnFeedsResume", "getReadInJoyAdapter", "baseHandler", "Lcom/tencent/mobileqq/kandian/glue/businesshandler/api/IBaseHandler;", "kanDianPopupWindowDismiss", "reportAnd1Px", "adInfo", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IBaseUiBridge
  extends QRouteApi
{
  public abstract void checkAndReportAdExposure(@Nullable IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter);
  
  public abstract void destroyDataFromFeeds(@Nullable IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter);
  
  public abstract void doOnFeedsPause(@Nullable IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, @Nullable Activity paramActivity);
  
  public abstract void doOnFeedsResume(@Nullable IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter);
  
  @Nullable
  public abstract IReadInJoyBaseAdapter getReadInJoyAdapter(@NotNull IBaseHandler paramIBaseHandler);
  
  public abstract void kanDianPopupWindowDismiss(@Nullable IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter);
  
  public abstract void reportAnd1Px(@NotNull Object paramObject, @Nullable IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.baseui.api.IBaseUiBridge
 * JD-Core Version:    0.7.0.1
 */