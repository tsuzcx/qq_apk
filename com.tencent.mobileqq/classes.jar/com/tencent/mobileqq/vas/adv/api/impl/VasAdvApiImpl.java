package com.tencent.mobileqq.vas.adv.api.impl;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport.Companion;
import com.tencent.mobileqq.vas.adv.base.support.app.VasAdvAppInterface.DefaultImpls;
import com.tencent.mobileqq.vas.adv.common.callback.VasResultCallback;
import com.tencent.mobileqq.vas.adv.common.data.LandingPageParams;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/api/impl/VasAdvApiImpl;", "Lcom/tencent/mobileqq/vas/adv/api/IVasAdvApi;", "()V", "nextRequestAdTime", "", "convertPbToJson", "", "T", "Lcom/tencent/mobileqq/pb/PBField;", "pbField", "(Lcom/tencent/mobileqq/pb/PBField;)Ljava/lang/String;", "doExposure", "", "exposureUrl", "adView", "Landroid/view/View;", "pbAdInfo", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "resultCallback", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasResultCallback;", "", "doOriginalExposure", "context", "Landroid/content/Context;", "jsonGdtAdInfo", "getDeviceInfoAsJson", "gdtBizId", "getGdtCountdownTime", "", "gdtTangramAdJson", "getGdtDanmakuStrContents", "", "(Ljava/lang/String;)[Ljava/lang/String;", "getIndustryLabels", "", "getMarketPendantImgUrl", "initTbsEnvironment", "isAppInstalled", "pkgName", "requestPublicAccountAd", "toLandingPage", "activity", "Landroid/app/Activity;", "params", "Lcom/tencent/mobileqq/vas/adv/common/data/LandingPageParams;", "unregisterAppReceiver", "Companion", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public final class VasAdvApiImpl
  implements IVasAdvApi
{
  public static final VasAdvApiImpl.Companion Companion = new VasAdvApiImpl.Companion(null);
  private static final long REQUEST_INTERVAL = 600000L;
  private static final String TAG = "VasAdvApiImpl";
  private static boolean isForegroundRegistered;
  private long nextRequestAdTime;
  
  @Nullable
  public <T extends PBField<T>> String convertPbToJson(@NotNull T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramT, "pbField");
    return VasAdvSupport.a.a().a(paramT);
  }
  
  public void doExposure(@NotNull String paramString, @NotNull View paramView, @Nullable qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, @NotNull VasResultCallback<Boolean> paramVasResultCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "exposureUrl");
    Intrinsics.checkParameterIsNotNull(paramView, "adView");
    Intrinsics.checkParameterIsNotNull(paramVasResultCallback, "resultCallback");
    VasAdvSupport.a.a().a(paramString, paramView, paramAdInfo, paramVasResultCallback);
  }
  
  public boolean doOriginalExposure(@NotNull Context paramContext, @Nullable String paramString, @Nullable qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return VasAdvSupport.a.a().a(paramContext, paramString, paramAdInfo);
  }
  
  @Nullable
  public String getDeviceInfoAsJson(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "gdtBizId");
    return VasAdvSupport.a.a().a(paramString);
  }
  
  public int getGdtCountdownTime(@Nullable String paramString)
  {
    return VasAdvSupport.a.a().a(paramString);
  }
  
  @Nullable
  public String[] getGdtDanmakuStrContents(@Nullable String paramString)
  {
    return VasAdvSupport.a.a().a(paramString);
  }
  
  @Nullable
  public List<String> getIndustryLabels(@Nullable qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    return VasAdvSupport.a.a().a(paramAdInfo);
  }
  
  @Nullable
  public String getMarketPendantImgUrl(@Nullable String paramString)
  {
    return VasAdvSupport.a.a().b(paramString);
  }
  
  public void initTbsEnvironment()
  {
    VasAdvSupport.a.a().a();
  }
  
  public boolean isAppInstalled(@NotNull Context paramContext, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return VasAdvSupport.a.a().a(paramContext, paramString);
  }
  
  public void requestPublicAccountAd()
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    if (this.nextRequestAdTime > l)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("next request public account ad time is:");
        localStringBuilder.append(this.nextRequestAdTime);
        localStringBuilder.append(", current: ");
        localStringBuilder.append(l);
        QLog.d("VasAdvApiImpl", 2, localStringBuilder.toString());
      }
      return;
    }
    VasAdvAppInterface.DefaultImpls.a(VasAdvSupport.a.a(), (Runnable)new VasAdvApiImpl.requestPublicAccountAd.1(this, l), false, false, 6, null);
    if ((!isForegroundRegistered) && (GuardManager.a != null))
    {
      isForegroundRegistered = true;
      GuardManager.a.a((IGuardInterface)new VasAdvApiImpl.requestPublicAccountAd.2(this));
    }
  }
  
  public void toLandingPage(@NotNull Activity paramActivity, @NotNull LandingPageParams paramLandingPageParams)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramLandingPageParams, "params");
    VasAdvSupport.a.a().a(paramActivity, paramLandingPageParams);
  }
  
  public void unregisterAppReceiver()
  {
    VasAdvSupport.a.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.api.impl.VasAdvApiImpl
 * JD-Core Version:    0.7.0.1
 */