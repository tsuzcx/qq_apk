package com.tencent.mobileqq.kandian.biz.common.baseui.api.impl;

import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.kandian.biz.ad.entity.IExposureSupplementManager;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.common.baseui.api.IBaseUiBridge;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.glue.businesshandler.api.IBaseHandler;
import com.tencent.widget.KandianNegativeWindowForAd;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/baseui/api/impl/BaseUiBridgeImpl;", "Lcom/tencent/mobileqq/kandian/biz/common/baseui/api/IBaseUiBridge;", "()V", "checkAndReportAdExposure", "", "adapter", "Lcom/tencent/mobileqq/kandian/biz/common/baseui/IReadInJoyBaseAdapter;", "destroyDataFromFeeds", "doOnFeedsPause", "activity", "Landroid/app/Activity;", "doOnFeedsResume", "getReadInJoyAdapter", "baseHandler", "Lcom/tencent/mobileqq/kandian/glue/businesshandler/api/IBaseHandler;", "kanDianPopupWindowDismiss", "reportAnd1Px", "adInfo", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class BaseUiBridgeImpl
  implements IBaseUiBridge
{
  public void checkAndReportAdExposure(@Nullable IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter)
  {
    if ((paramIReadInJoyBaseAdapter instanceof ReadInJoyBaseAdapter))
    {
      IExposureSupplementManager localIExposureSupplementManager = paramIReadInJoyBaseAdapter.a();
      if (localIExposureSupplementManager != null) {
        localIExposureSupplementManager.a(paramIReadInJoyBaseAdapter, paramIReadInJoyBaseAdapter.a());
      }
    }
  }
  
  public void destroyDataFromFeeds(@Nullable IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter)
  {
    if ((paramIReadInJoyBaseAdapter instanceof ReadInJoyBaseAdapter))
    {
      paramIReadInJoyBaseAdapter = paramIReadInJoyBaseAdapter.a();
      if (paramIReadInJoyBaseAdapter != null) {
        paramIReadInJoyBaseAdapter.b();
      }
    }
  }
  
  public void doOnFeedsPause(@Nullable IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, @Nullable Activity paramActivity)
  {
    if ((paramIReadInJoyBaseAdapter instanceof ReadInJoyBaseAdapter))
    {
      paramIReadInJoyBaseAdapter = paramIReadInJoyBaseAdapter.a();
      if (paramIReadInJoyBaseAdapter != null) {
        paramIReadInJoyBaseAdapter.b(paramActivity);
      }
    }
  }
  
  public void doOnFeedsResume(@Nullable IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter)
  {
    if ((paramIReadInJoyBaseAdapter instanceof ReadInJoyBaseAdapter))
    {
      paramIReadInJoyBaseAdapter = paramIReadInJoyBaseAdapter.a();
      if (paramIReadInJoyBaseAdapter != null) {
        paramIReadInJoyBaseAdapter.a();
      }
    }
  }
  
  @Nullable
  public IReadInJoyBaseAdapter getReadInJoyAdapter(@NotNull IBaseHandler paramIBaseHandler)
  {
    Intrinsics.checkParameterIsNotNull(paramIBaseHandler, "baseHandler");
    return paramIBaseHandler.a();
  }
  
  public void kanDianPopupWindowDismiss(@Nullable IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter)
  {
    if ((paramIReadInJoyBaseAdapter instanceof ReadInJoyBaseAdapter))
    {
      paramIReadInJoyBaseAdapter = ((ReadInJoyBaseAdapter)paramIReadInJoyBaseAdapter).a();
      if ((paramIReadInJoyBaseAdapter != null) && (paramIReadInJoyBaseAdapter.isShowing())) {
        paramIReadInJoyBaseAdapter.dismiss();
      }
    }
  }
  
  public void reportAnd1Px(@NotNull Object paramObject, @Nullable IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "adInfo");
    if (((paramIReadInJoyBaseAdapter instanceof ReadInJoyBaseAdapter)) && ((paramObject instanceof AdvertisementInfo)))
    {
      IExposureSupplementManager localIExposureSupplementManager = paramIReadInJoyBaseAdapter.a();
      if (localIExposureSupplementManager != null) {
        localIExposureSupplementManager.a(paramObject, paramIReadInJoyBaseAdapter.a());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.baseui.api.impl.BaseUiBridgeImpl
 * JD-Core Version:    0.7.0.1
 */