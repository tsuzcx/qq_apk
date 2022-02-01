package com.tencent.mobileqq.ecshop.view.adcard;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopMessageApi;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/view/adcard/AdCardParseFactory;", "", "()V", "QQShopCreativeSize1659", "", "QQShopCreativeSize1660", "QQShopCreativeSize1662", "QQShopCreativeSize1663", "QQShopCreativeSize185", "QQShopCreativeSize276", "QQShopCreativeSize433", "QQShopCreativeSize494", "QQShopCreativeSize495", "QQShopCreativeSize585", "QQShopCreativeSize65", "QQShopCreativeSize703", "QQShopCreativeSize710", "QQShopCreativeSize861", "QQShopCreativeSize876", "QQShopCreativeSize899", "QQShopCreativeSizeDefault", "QQShopCreativeSizeError", "QQShopCreativeSizeQGG", "TAG", "", "baseProcessor", "Lcom/tencent/mobileqq/ecshop/view/adcard/AdCardBaseProcessor;", "processorMap", "", "getAdCardProcessor", "adInfo", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "messageRecord", "Lcom/tencent/mobileqq/data/MessageRecord;", "getAdCreativeSize", "getAdMsgType", "", "message", "getQggMsgType", "parse", "Lcom/tencent/mobileqq/ecshop/view/adcard/AdCardModel;", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class AdCardParseFactory
{
  public static final AdCardParseFactory a;
  private static final Map<Integer, AdCardBaseProcessor> b;
  private static final AdCardBaseProcessor c = new AdCardBaseProcessor();
  
  static
  {
    AdCardParseFactory localAdCardParseFactory = new AdCardParseFactory();
    a = localAdCardParseFactory;
    b = (Map)new AdCardParseFactory.processorMap.1(localAdCardParseFactory);
  }
  
  @NotNull
  public final AdCardModel a(@Nullable qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, @NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "messageRecord");
    AdCardModel localAdCardModel = new AdCardModel();
    AdCardBaseProcessor localAdCardBaseProcessor = c(paramAdInfo, paramMessageRecord);
    localAdCardModel.a(paramAdInfo);
    localAdCardModel.a(paramMessageRecord);
    try
    {
      localAdCardModel.a(localAdCardBaseProcessor.a(paramAdInfo, paramMessageRecord));
      localAdCardModel.b(localAdCardBaseProcessor.b(paramAdInfo, paramMessageRecord));
      localAdCardModel.c(localAdCardBaseProcessor.c(paramAdInfo, paramMessageRecord));
      if (paramAdInfo != null)
      {
        localAdCardModel.d(localAdCardBaseProcessor.a(paramAdInfo));
        localAdCardModel.e(localAdCardBaseProcessor.b(paramAdInfo));
        localAdCardModel.f(localAdCardBaseProcessor.c(paramAdInfo));
        localAdCardModel.m().addAll((Collection)localAdCardBaseProcessor.d(paramAdInfo));
      }
    }
    catch (Exception paramAdInfo)
    {
      QLog.e("AdCardParseFactory", 1, (Throwable)paramAdInfo, new Object[0]);
    }
    localAdCardModel.a(localAdCardBaseProcessor.a(paramMessageRecord));
    localAdCardModel.g(localAdCardBaseProcessor.b(paramMessageRecord));
    localAdCardModel.c(localAdCardBaseProcessor.a());
    localAdCardModel.b(a.a(paramMessageRecord));
    return localAdCardModel;
  }
  
  public final boolean a(@NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "message");
    int i;
    try
    {
      paramMessageRecord = ((IEcshopMessageApi)QRoute.api(IEcshopMessageApi.class)).getLastMsgType(paramMessageRecord);
      Intrinsics.checkExpressionValueIsNotNull(paramMessageRecord, "QRoute.api(IEcshopMessag…).getLastMsgType(message)");
      i = Integer.parseInt(paramMessageRecord);
    }
    catch (Exception paramMessageRecord)
    {
      QLog.e("AdCardParseFactory", 1, (Throwable)paramMessageRecord, new Object[0]);
      i = 0;
    }
    return i < 100;
  }
  
  public int b(@Nullable qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, @NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "messageRecord");
    if (a(paramMessageRecord))
    {
      if (paramAdInfo != null)
      {
        paramAdInfo = paramAdInfo.display_info;
        if (paramAdInfo != null)
        {
          paramAdInfo = paramAdInfo.creative_size;
          if (paramAdInfo != null) {
            return paramAdInfo.get();
          }
        }
      }
      return 0;
    }
    if (b(paramMessageRecord)) {
      return -1;
    }
    return -2;
  }
  
  public final boolean b(@NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "message");
    int k = 1;
    int i;
    try
    {
      paramMessageRecord = ((IEcshopMessageApi)QRoute.api(IEcshopMessageApi.class)).getLastMsgType(paramMessageRecord);
      Intrinsics.checkExpressionValueIsNotNull(paramMessageRecord, "QRoute.api(IEcshopMessag…).getLastMsgType(message)");
      i = Integer.parseInt(paramMessageRecord);
    }
    catch (Exception paramMessageRecord)
    {
      QLog.e("AdCardParseFactory", 1, (Throwable)paramMessageRecord, new Object[0]);
      i = 0;
    }
    int j;
    if (i == 100) {
      j = 1;
    } else {
      j = 0;
    }
    if (i == 101) {
      i = k;
    } else {
      i = 0;
    }
    return j | i;
  }
  
  @NotNull
  public final AdCardBaseProcessor c(@Nullable qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, @NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "messageRecord");
    paramAdInfo = (AdCardBaseProcessor)b.get(Integer.valueOf(b(paramAdInfo, paramMessageRecord)));
    if (paramAdInfo != null) {
      return paramAdInfo;
    }
    return c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.adcard.AdCardParseFactory
 * JD-Core Version:    0.7.0.1
 */