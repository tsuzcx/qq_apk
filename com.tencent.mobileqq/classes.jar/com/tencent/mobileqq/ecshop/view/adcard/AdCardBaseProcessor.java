package com.tencent.mobileqq.ecshop.view.adcard;

import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ecshop.report.api.IEcshopReportApi;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopMessageApi;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DestInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/view/adcard/AdCardBaseProcessor;", "", "()V", "getBtnText", "", "adInfo", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "getCorporateIconUrl", "getCorporateName", "getDisType", "message", "Lcom/tencent/mobileqq/data/MessageRecord;", "getImageUrl", "getLandingUrl", "getReportClick", "", "getTitle", "isVideoMsg", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public class AdCardBaseProcessor
{
  @NotNull
  public String a(@NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "message");
    QRouteApi localQRouteApi = QRoute.api(IEcshopMessageApi.class);
    Intrinsics.checkExpressionValueIsNotNull(localQRouteApi, "QRoute.api(IEcshopMessageApi::class.java)");
    paramMessageRecord = ((IEcshopMessageApi)localQRouteApi).getDisType(paramMessageRecord);
    Intrinsics.checkExpressionValueIsNotNull(paramMessageRecord, "ecshopMessageApi.getDisType(message)");
    return paramMessageRecord;
  }
  
  @NotNull
  public String a(@NotNull qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAdInfo, "adInfo");
    try
    {
      paramAdInfo = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)paramAdInfo.display_info.button_info.get(0)).txt.get();
      Intrinsics.checkExpressionValueIsNotNull(paramAdInfo, "adInfo.display_info.button_info[0].txt.get()");
      return paramAdInfo;
    }
    catch (Exception paramAdInfo)
    {
      label35:
      break label35;
    }
    return "";
  }
  
  @NotNull
  public String a(@Nullable qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, @NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "message");
    if (paramAdInfo != null)
    {
      paramAdInfo = paramAdInfo.display_info.basic_info.img.get();
      Intrinsics.checkExpressionValueIsNotNull(paramAdInfo, "adInfo.display_info.basic_info.img.get()");
      return paramAdInfo;
    }
    return "";
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(@NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "message");
    Object localObject = QRoute.api(IEcshopMessageApi.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "QRoute.api(IEcshopMessageApi::class.java)");
    localObject = (IEcshopMessageApi)localObject;
    if (((IEcshopMessageApi)localObject).isMessageForStructing(paramMessageRecord))
    {
      paramMessageRecord = ((IEcshopMessageApi)localObject).getStructMsgReportClick(paramMessageRecord);
      return ((IEcshopReportApi)QRoute.api(IEcshopReportApi.class)).isReportForClick(paramMessageRecord);
    }
    if (((IEcshopMessageApi)localObject).isMessageForArkApp(paramMessageRecord)) {
      return ((IEcshopMessageApi)localObject).getArkMsgReportClick(paramMessageRecord);
    }
    return false;
  }
  
  @NotNull
  public String b(@NotNull qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAdInfo, "adInfo");
    String str2 = paramAdInfo.display_info.advertiser_info.corporate_image_name.get();
    String str1 = str2;
    if (TextUtils.isEmpty((CharSequence)str2)) {
      str1 = paramAdInfo.display_info.advertiser_info.corporation_name.get();
    }
    Intrinsics.checkExpressionValueIsNotNull(str1, "corporateName");
    return str1;
  }
  
  @NotNull
  public String b(@Nullable qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, @NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "message");
    if (paramAdInfo != null)
    {
      paramAdInfo = paramAdInfo.dest_info.landing_page.get();
      Intrinsics.checkExpressionValueIsNotNull(paramAdInfo, "adInfo.dest_info.landing_page.get()");
      return paramAdInfo;
    }
    return "";
  }
  
  @NotNull
  public String c(@NotNull qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAdInfo, "adInfo");
    paramAdInfo = paramAdInfo.display_info.advertiser_info.corporate_logo.get();
    Intrinsics.checkExpressionValueIsNotNull(paramAdInfo, "adInfo.display_info.adve…info.corporate_logo.get()");
    return paramAdInfo;
  }
  
  @NotNull
  public String c(@Nullable qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, @NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "message");
    if (paramAdInfo != null)
    {
      paramAdInfo = paramAdInfo.display_info.basic_info.txt.get();
      Intrinsics.checkExpressionValueIsNotNull(paramAdInfo, "adInfo.display_info.basic_info.txt.get()");
      return paramAdInfo;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.adcard.AdCardBaseProcessor
 * JD-Core Version:    0.7.0.1
 */