package com.tencent.mobileqq.vas.adv.api;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vas.adv.common.callback.VasResultCallback;
import com.tencent.mobileqq.vas.adv.common.data.LandingPageParams;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/api/IVasAdvApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "convertPbToJson", "", "T", "Lcom/tencent/mobileqq/pb/PBField;", "pbField", "(Lcom/tencent/mobileqq/pb/PBField;)Ljava/lang/String;", "doExposure", "", "exposureUrl", "adView", "Landroid/view/View;", "pbAdInfo", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "resultCallback", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasResultCallback;", "", "doOriginalExposure", "context", "Landroid/content/Context;", "jsonGdtAdInfo", "position", "", "getDeviceInfoAsJson", "gdtBizId", "getGdtCountdownTime", "gdtTangramAdJson", "getGdtDanmakuStrContents", "", "(Ljava/lang/String;)[Ljava/lang/String;", "getIndustryLabels", "", "getMarketPendantImgUrl", "initTbsEnvironment", "isAppInstalled", "pkgName", "requestPublicAccountAd", "toLandingPage", "activity", "Landroid/app/Activity;", "params", "Lcom/tencent/mobileqq/vas/adv/common/data/LandingPageParams;", "unregisterAppReceiver", "vas-adv-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVasAdvApi
  extends QRouteApi
{
  @Nullable
  public abstract <T extends PBField<T>> String convertPbToJson(@NotNull T paramT);
  
  public abstract void doExposure(@NotNull String paramString, @NotNull View paramView, @Nullable qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, @NotNull VasResultCallback<Boolean> paramVasResultCallback);
  
  public abstract boolean doOriginalExposure(@NotNull Context paramContext, @Nullable String paramString, @Nullable qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, int paramInt);
  
  @Nullable
  public abstract String getDeviceInfoAsJson(@NotNull String paramString);
  
  public abstract int getGdtCountdownTime(@Nullable String paramString);
  
  @Nullable
  public abstract String[] getGdtDanmakuStrContents(@Nullable String paramString);
  
  @Nullable
  public abstract List<String> getIndustryLabels(@Nullable qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo);
  
  @Nullable
  public abstract String getMarketPendantImgUrl(@Nullable String paramString);
  
  public abstract void initTbsEnvironment();
  
  public abstract boolean isAppInstalled(@NotNull Context paramContext, @Nullable String paramString);
  
  public abstract void requestPublicAccountAd();
  
  public abstract void toLandingPage(@NotNull Activity paramActivity, @NotNull LandingPageParams paramLandingPageParams);
  
  public abstract void unregisterAppReceiver();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.api.IVasAdvApi
 * JD-Core Version:    0.7.0.1
 */