package com.tencent.mobileqq.kandian.biz.video.api.impl;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseToolAppInterface;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsAppInterface;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsAppInterfaceFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/api/impl/VideoFeedsAppInterfaceFactoryImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoFeedsAppInterfaceFactory;", "()V", "create", "Lcom/tencent/common/app/business/BaseToolAppInterface;", "app", "Lmqq/app/MobileQQ;", "procname", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoFeedsAppInterfaceFactoryImpl
  implements IVideoFeedsAppInterfaceFactory
{
  @Nullable
  public BaseToolAppInterface create(@NotNull MobileQQ paramMobileQQ, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMobileQQ, "app");
    Intrinsics.checkParameterIsNotNull(paramString, "procname");
    if ((paramMobileQQ instanceof BaseApplicationImpl)) {
      return (BaseToolAppInterface)new VideoFeedsAppInterface((BaseApplicationImpl)paramMobileQQ, MobileQQ.processName);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.impl.VideoFeedsAppInterfaceFactoryImpl
 * JD-Core Version:    0.7.0.1
 */