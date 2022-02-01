package com.tencent.mobileqq.vas.adv.base.support;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.vas.adv.base.support.app.VasAdvAppInterface;
import com.tencent.mobileqq.vas.adv.base.support.app.VasAdvAppInterface.DefaultImpls;
import com.tencent.mobileqq.vas.adv.base.support.app.VasAdvCallback;
import com.tencent.mobileqq.vas.adv.base.support.gdt.VasAdvGdtInterface;
import com.tencent.mobileqq.vas.adv.common.callback.VasResultCallback;
import com.tencent.mobileqq.vas.adv.common.data.LandingPageParams;
import com.tencent.mobileqq.vas.adv.reward.VasProfitableCallback;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/base/support/VasAdvSupport;", "Lcom/tencent/mobileqq/vas/adv/base/support/app/VasAdvAppInterface;", "Lcom/tencent/mobileqq/vas/adv/base/support/gdt/VasAdvGdtInterface;", "app", "gdt", "(Lcom/tencent/mobileqq/vas/adv/base/support/app/VasAdvAppInterface;Lcom/tencent/mobileqq/vas/adv/base/support/gdt/VasAdvGdtInterface;)V", "account", "", "context", "Landroid/content/Context;", "convertPbToJson", "", "T", "Lcom/tencent/mobileqq/pb/PBField;", "pbField", "(Lcom/tencent/mobileqq/pb/PBField;)Ljava/lang/String;", "doCgiReport", "", "exposureUrl", "doExposure", "adView", "Landroid/view/View;", "pbAdInfo", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "resultCallback", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasResultCallback;", "", "doOriginalExposure", "jsonGdtAdInfo", "position", "", "execute", "runnable", "Ljava/lang/Runnable;", "networkJob", "autoRetrieve", "getDeviceInfo", "Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;", "gdtBizId", "getDeviceInfoAsJson", "getGdtCountdownTime", "gdtTangramAdJson", "getGdtDanmakuStrContents", "", "(Ljava/lang/String;)[Ljava/lang/String;", "getIndustryLabels", "", "getMarketPendantImgUrl", "initDeviceInfo", "initGdtContext", "initTbsEnvironment", "isAppInstalled", "pkgName", "postDelayed", "delay", "preloadWebView", "runOnUiThread", "sendCmd", "cmd", "cmdKey", "reqBytes", "", "callback", "Lcom/tencent/mobileqq/vas/adv/base/support/app/VasAdvCallback;", "showMotiveAd", "activity", "Landroid/app/Activity;", "adInfo", "profitableCallback", "Lcom/tencent/mobileqq/vas/adv/reward/VasProfitableCallback;", "rewardText", "bizSrc", "toLandingPage", "params", "Lcom/tencent/mobileqq/vas/adv/common/data/LandingPageParams;", "unregisterAppReceiver", "vasGdtBizId", "Companion", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public final class VasAdvSupport
  implements VasAdvAppInterface, VasAdvGdtInterface
{
  public static final VasAdvSupport.Companion a = new VasAdvSupport.Companion(null);
  private static final Lazy d = LazyKt.lazy((Function0)VasAdvSupport.Companion.instance.2.INSTANCE);
  private final VasAdvAppInterface b;
  private final VasAdvGdtInterface c;
  
  private VasAdvSupport(VasAdvAppInterface paramVasAdvAppInterface, VasAdvGdtInterface paramVasAdvGdtInterface)
  {
    this.b = paramVasAdvAppInterface;
    this.c = paramVasAdvGdtInterface;
    a(f());
  }
  
  @JvmStatic
  @NotNull
  public static final VasAdvSupport h()
  {
    return a.a();
  }
  
  public long a()
  {
    return this.b.a();
  }
  
  @Nullable
  public <T extends PBField<T>> String a(@NotNull T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramT, "pbField");
    return this.c.a(paramT);
  }
  
  @Nullable
  public List<String> a(@Nullable qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    return this.c.a(paramAdInfo);
  }
  
  public void a(@NotNull Activity paramActivity, @NotNull LandingPageParams paramLandingPageParams)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramLandingPageParams, "params");
    this.c.a(paramActivity, paramLandingPageParams);
  }
  
  public void a(@NotNull Activity paramActivity, @NotNull qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, @NotNull VasProfitableCallback paramVasProfitableCallback, @Nullable String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramAdInfo, "adInfo");
    Intrinsics.checkParameterIsNotNull(paramVasProfitableCallback, "profitableCallback");
    Intrinsics.checkParameterIsNotNull(paramString2, "bizSrc");
    this.c.a(paramActivity, paramAdInfo, paramVasProfitableCallback, paramString1, paramString2);
  }
  
  public void a(@NotNull Runnable paramRunnable, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramRunnable, "runnable");
    this.b.a(paramRunnable, paramLong);
  }
  
  public void a(@NotNull Runnable paramRunnable, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramRunnable, "runnable");
    this.b.a(paramRunnable, paramBoolean1, paramBoolean2);
  }
  
  public final void a(@Nullable String paramString)
  {
    VasAdvAppInterface.DefaultImpls.a(this.b, (Runnable)new VasAdvSupport.initDeviceInfo.1(this, paramString), false, false, 6, null);
  }
  
  public void a(@NotNull String paramString, @NotNull View paramView, @Nullable qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, @NotNull VasResultCallback<Boolean> paramVasResultCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "exposureUrl");
    Intrinsics.checkParameterIsNotNull(paramView, "adView");
    Intrinsics.checkParameterIsNotNull(paramVasResultCallback, "resultCallback");
    this.c.a(paramString, paramView, paramAdInfo, paramVasResultCallback);
  }
  
  public void a(@NotNull String paramString1, @NotNull String paramString2, @NotNull byte[] paramArrayOfByte, @NotNull VasAdvCallback paramVasAdvCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "cmd");
    Intrinsics.checkParameterIsNotNull(paramString2, "cmdKey");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "reqBytes");
    Intrinsics.checkParameterIsNotNull(paramVasAdvCallback, "callback");
    this.b.a(paramString1, paramString2, paramArrayOfByte, paramVasAdvCallback);
  }
  
  public boolean a(@NotNull Context paramContext, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return this.b.a(paramContext, paramString);
  }
  
  public boolean a(@NotNull Context paramContext, @Nullable String paramString, @Nullable qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return this.c.a(paramContext, paramString, paramAdInfo, paramInt);
  }
  
  @NotNull
  public Context b()
  {
    return this.b.b();
  }
  
  @Nullable
  public qq_ad_get.QQAdGet.DeviceInfo b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "gdtBizId");
    return this.c.b(paramString);
  }
  
  @Nullable
  public String c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "gdtBizId");
    return this.c.c(paramString);
  }
  
  public void c()
  {
    this.b.c();
  }
  
  public int d(@Nullable String paramString)
  {
    return this.c.d(paramString);
  }
  
  @Nullable
  public View d()
  {
    return this.b.d();
  }
  
  public void e()
  {
    this.c.e();
  }
  
  @Nullable
  public String[] e(@Nullable String paramString)
  {
    return this.c.e(paramString);
  }
  
  @NotNull
  public String f()
  {
    return this.c.f();
  }
  
  @Nullable
  public String f(@Nullable String paramString)
  {
    return this.c.f(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport
 * JD-Core Version:    0.7.0.1
 */