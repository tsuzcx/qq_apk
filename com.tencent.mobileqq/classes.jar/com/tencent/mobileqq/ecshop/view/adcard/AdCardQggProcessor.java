package com.tencent.mobileqq.ecshop.view.adcard;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopMessageApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/view/adcard/AdCardQggProcessor;", "Lcom/tencent/mobileqq/ecshop/view/adcard/AdCardBaseProcessor;", "()V", "getImageUrl", "", "adInfo", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "message", "Lcom/tencent/mobileqq/data/MessageRecord;", "getLandingUrl", "getTitle", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class AdCardQggProcessor
  extends AdCardBaseProcessor
{
  @NotNull
  public String a(@Nullable qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, @NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "message");
    paramAdInfo = ((IEcshopMessageApi)QRoute.api(IEcshopMessageApi.class)).getMessageImageUrl(paramMessageRecord);
    Intrinsics.checkExpressionValueIsNotNull(paramAdInfo, "QRoute.api(IEcshopMessag…tMessageImageUrl(message)");
    return paramAdInfo;
  }
  
  @NotNull
  public String b(@Nullable qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, @NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "message");
    paramAdInfo = ((IEcshopMessageApi)QRoute.api(IEcshopMessageApi.class)).getMessageLandingUrl(paramMessageRecord);
    Intrinsics.checkExpressionValueIsNotNull(paramAdInfo, "QRoute.api(IEcshopMessag…essageLandingUrl(message)");
    return paramAdInfo;
  }
  
  @NotNull
  public String c(@Nullable qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, @NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "message");
    paramAdInfo = ((IEcshopMessageApi)QRoute.api(IEcshopMessageApi.class)).getMessageTitleText(paramMessageRecord);
    Intrinsics.checkExpressionValueIsNotNull(paramAdInfo, "QRoute.api(IEcshopMessag…MessageTitleText(message)");
    return paramAdInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.adcard.AdCardQggProcessor
 * JD-Core Version:    0.7.0.1
 */