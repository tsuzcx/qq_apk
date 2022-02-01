package com.tencent.mobileqq.vas.adv.base.support.gdt;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.vas.adv.common.callback.VasResultCallback;
import com.tencent.mobileqq.vas.adv.common.data.LandingPageParams;
import com.tencent.mobileqq.vas.adv.reward.VasProfitableCallback;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/base/support/gdt/VasAdvGdtInterface;", "", "convertPbToJson", "", "T", "Lcom/tencent/mobileqq/pb/PBField;", "pbField", "(Lcom/tencent/mobileqq/pb/PBField;)Ljava/lang/String;", "doCgiReport", "", "exposureUrl", "doExposure", "adView", "Landroid/view/View;", "pbAdInfo", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "resultCallback", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasResultCallback;", "", "doOriginalExposure", "context", "Landroid/content/Context;", "jsonGdtAdInfo", "getDeviceInfo", "Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;", "gdtBizId", "getDeviceInfoAsJson", "getGdtCountdownTime", "", "gdtTangramAdJson", "getGdtDanmakuStrContents", "", "(Ljava/lang/String;)[Ljava/lang/String;", "getIndustryLabels", "", "getMarketPendantImgUrl", "initGdtContext", "showMotiveAd", "activity", "Landroid/app/Activity;", "adInfo", "profitableCallback", "Lcom/tencent/mobileqq/vas/adv/reward/VasProfitableCallback;", "rewardText", "bizSrc", "toLandingPage", "params", "Lcom/tencent/mobileqq/vas/adv/common/data/LandingPageParams;", "unregisterAppReceiver", "vasGdtBizId", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface VasAdvGdtInterface
{
  public abstract int a(@Nullable String paramString);
  
  @NotNull
  public abstract String a();
  
  @Nullable
  public abstract <T extends PBField<T>> String a(@NotNull T paramT);
  
  @Nullable
  public abstract String a(@NotNull String paramString);
  
  @Nullable
  public abstract List<String> a(@Nullable qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo);
  
  @Nullable
  public abstract qq_ad_get.QQAdGet.DeviceInfo a(@NotNull String paramString);
  
  public abstract void a(@NotNull Activity paramActivity, @NotNull LandingPageParams paramLandingPageParams);
  
  public abstract void a(@NotNull Activity paramActivity, @NotNull qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, @NotNull VasProfitableCallback paramVasProfitableCallback, @Nullable String paramString1, @NotNull String paramString2);
  
  public abstract void a(@NotNull String paramString, @NotNull View paramView, @Nullable qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, @NotNull VasResultCallback<Boolean> paramVasResultCallback);
  
  public abstract boolean a(@NotNull Context paramContext, @Nullable String paramString, @Nullable qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo);
  
  @Nullable
  public abstract String[] a(@Nullable String paramString);
  
  @Nullable
  public abstract String b(@Nullable String paramString);
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.base.support.gdt.VasAdvGdtInterface
 * JD-Core Version:    0.7.0.1
 */