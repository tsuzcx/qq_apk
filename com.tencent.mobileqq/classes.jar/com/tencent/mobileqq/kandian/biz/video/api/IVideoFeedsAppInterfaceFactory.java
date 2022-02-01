package com.tencent.mobileqq.kandian.biz.video.api;

import com.tencent.common.app.business.BaseToolAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoFeedsAppInterfaceFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "create", "Lcom/tencent/common/app/business/BaseToolAppInterface;", "app", "Lmqq/app/MobileQQ;", "procname", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVideoFeedsAppInterfaceFactory
  extends QRouteApi
{
  @Nullable
  public abstract BaseToolAppInterface create(@NotNull MobileQQ paramMobileQQ, @NotNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsAppInterfaceFactory
 * JD-Core Version:    0.7.0.1
 */