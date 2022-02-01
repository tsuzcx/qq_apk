package cooperation.vip;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.pb.PBField;
import cooperation.vip.reward.VasProfitableCallback;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcooperation/vip/VasAdvSupport;", "Lcooperation/vip/VasAdvAppInterface;", "Lcooperation/vip/VasAdvGdtInterface;", "app", "gdt", "(Lcooperation/vip/VasAdvAppInterface;Lcooperation/vip/VasAdvGdtInterface;)V", "account", "", "context", "Landroid/content/Context;", "convertPbToJson", "", "T", "Lcom/tencent/mobileqq/pb/PBField;", "pbField", "(Lcom/tencent/mobileqq/pb/PBField;)Ljava/lang/String;", "doCgiReport", "", "exposureUrl", "doExposure", "adView", "Landroid/view/View;", "pbAdInfo", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "resultCallback", "Lcooperation/vip/VasResultCallback;", "", "doOriginalExposure", "jsonGdtAdInfo", "execute", "runnable", "Ljava/lang/Runnable;", "networkJob", "autoRetrieve", "getDeviceInfo", "Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;", "gdtBizId", "getDeviceInfoAsJson", "getGdtCountdownTime", "", "gdtTangramAdJson", "getIndustryLabels", "", "getMarketPendantImgUrl", "initDeviceInfo", "initGdtContext", "initTbsEnvironment", "isAppInstalled", "pkgName", "postDelayed", "delay", "preloadWebView", "runOnUiThread", "sendCmd", "cmd", "cmdKey", "reqBytes", "", "callback", "Lcooperation/vip/VasAdvCallback;", "showMotiveAd", "activity", "Landroid/app/Activity;", "adInfo", "profitableCallback", "Lcooperation/vip/reward/VasProfitableCallback;", "rewardText", "bizSrc", "toLandingPage", "params", "Lcooperation/vip/LandingPageParams;", "unregisterAppReceiver", "vasGdtBizId", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VasAdvSupport
  implements VasAdvAppInterface, VasAdvGdtInterface
{
  public static final VasAdvSupport.Companion a;
  private static final Lazy jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)VasAdvSupport.Companion.instance.2.INSTANCE);
  private final VasAdvAppInterface jdField_a_of_type_CooperationVipVasAdvAppInterface;
  private final VasAdvGdtInterface jdField_a_of_type_CooperationVipVasAdvGdtInterface;
  
  static
  {
    jdField_a_of_type_CooperationVipVasAdvSupport$Companion = new VasAdvSupport.Companion(null);
  }
  
  private VasAdvSupport(VasAdvAppInterface paramVasAdvAppInterface, VasAdvGdtInterface paramVasAdvGdtInterface)
  {
    this.jdField_a_of_type_CooperationVipVasAdvAppInterface = paramVasAdvAppInterface;
    this.jdField_a_of_type_CooperationVipVasAdvGdtInterface = paramVasAdvGdtInterface;
    a(a());
  }
  
  @JvmStatic
  @NotNull
  public static final VasAdvSupport a()
  {
    return jdField_a_of_type_CooperationVipVasAdvSupport$Companion.a();
  }
  
  public int a(@Nullable String paramString)
  {
    return this.jdField_a_of_type_CooperationVipVasAdvGdtInterface.a(paramString);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_CooperationVipVasAdvAppInterface.a();
  }
  
  @NotNull
  public Context a()
  {
    return this.jdField_a_of_type_CooperationVipVasAdvAppInterface.a();
  }
  
  @Nullable
  public View a()
  {
    return this.jdField_a_of_type_CooperationVipVasAdvAppInterface.a();
  }
  
  @NotNull
  public String a()
  {
    return this.jdField_a_of_type_CooperationVipVasAdvGdtInterface.a();
  }
  
  @Nullable
  public <T extends PBField<T>> String a(@NotNull T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramT, "pbField");
    return this.jdField_a_of_type_CooperationVipVasAdvGdtInterface.a(paramT);
  }
  
  @Nullable
  public String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "gdtBizId");
    return this.jdField_a_of_type_CooperationVipVasAdvGdtInterface.a(paramString);
  }
  
  @Nullable
  public List<String> a(@Nullable qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    return this.jdField_a_of_type_CooperationVipVasAdvGdtInterface.a(paramAdInfo);
  }
  
  @Nullable
  public qq_ad_get.QQAdGet.DeviceInfo a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "gdtBizId");
    return this.jdField_a_of_type_CooperationVipVasAdvGdtInterface.a(paramString);
  }
  
  public void a()
  {
    this.jdField_a_of_type_CooperationVipVasAdvAppInterface.a();
  }
  
  public void a(@NotNull Activity paramActivity, @NotNull LandingPageParams paramLandingPageParams)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramLandingPageParams, "params");
    this.jdField_a_of_type_CooperationVipVasAdvGdtInterface.a(paramActivity, paramLandingPageParams);
  }
  
  public void a(@NotNull Activity paramActivity, @NotNull qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, @NotNull VasProfitableCallback paramVasProfitableCallback, @Nullable String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramAdInfo, "adInfo");
    Intrinsics.checkParameterIsNotNull(paramVasProfitableCallback, "profitableCallback");
    Intrinsics.checkParameterIsNotNull(paramString2, "bizSrc");
    this.jdField_a_of_type_CooperationVipVasAdvGdtInterface.a(paramActivity, paramAdInfo, paramVasProfitableCallback, paramString1, paramString2);
  }
  
  public void a(@NotNull Runnable paramRunnable, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramRunnable, "runnable");
    this.jdField_a_of_type_CooperationVipVasAdvAppInterface.a(paramRunnable, paramLong);
  }
  
  public void a(@NotNull Runnable paramRunnable, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramRunnable, "runnable");
    this.jdField_a_of_type_CooperationVipVasAdvAppInterface.a(paramRunnable, paramBoolean1, paramBoolean2);
  }
  
  public final void a(@Nullable String paramString)
  {
    VasAdvAppInterface.DefaultImpls.a(this.jdField_a_of_type_CooperationVipVasAdvAppInterface, (Runnable)new VasAdvSupport.initDeviceInfo.1(this, paramString), false, false, 6, null);
  }
  
  public void a(@NotNull String paramString, @NotNull View paramView, @Nullable qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, @NotNull VasResultCallback<Boolean> paramVasResultCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "exposureUrl");
    Intrinsics.checkParameterIsNotNull(paramView, "adView");
    Intrinsics.checkParameterIsNotNull(paramVasResultCallback, "resultCallback");
    this.jdField_a_of_type_CooperationVipVasAdvGdtInterface.a(paramString, paramView, paramAdInfo, paramVasResultCallback);
  }
  
  public void a(@NotNull String paramString1, @NotNull String paramString2, @NotNull byte[] paramArrayOfByte, @NotNull VasAdvCallback paramVasAdvCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "cmd");
    Intrinsics.checkParameterIsNotNull(paramString2, "cmdKey");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "reqBytes");
    Intrinsics.checkParameterIsNotNull(paramVasAdvCallback, "callback");
    this.jdField_a_of_type_CooperationVipVasAdvAppInterface.a(paramString1, paramString2, paramArrayOfByte, paramVasAdvCallback);
  }
  
  public boolean a(@NotNull Context paramContext, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return this.jdField_a_of_type_CooperationVipVasAdvAppInterface.a(paramContext, paramString);
  }
  
  public boolean a(@NotNull Context paramContext, @Nullable String paramString, @Nullable qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return this.jdField_a_of_type_CooperationVipVasAdvGdtInterface.a(paramContext, paramString, paramAdInfo);
  }
  
  @Nullable
  public String b(@Nullable String paramString)
  {
    return this.jdField_a_of_type_CooperationVipVasAdvGdtInterface.b(paramString);
  }
  
  public void b()
  {
    this.jdField_a_of_type_CooperationVipVasAdvGdtInterface.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.VasAdvSupport
 * JD-Core Version:    0.7.0.1
 */