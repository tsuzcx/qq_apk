package cooperation.vip.reward;

import android.app.Activity;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.vip.VasAdvService;
import cooperation.vip.VasAdvService.ServiceCode;
import cooperation.vip.VasAdvService.ShowAdCallback;
import cooperation.vip.VasAdvSupport;
import cooperation.vip.VasAdvSupport.Companion;
import cooperation.vip.pb.adv_report.MobileAdvReportReq;
import cooperation.vip.pb.adv_report.MobileAdvReportRsp;
import cooperation.vip.pb.adv_report.RewardReportInfo;
import cooperation.vip.pb.vac_adv_get.RewardReqInfo;
import cooperation.vip.pb.vac_adv_get.RewardRspInfo;
import cooperation.vip.pb.vac_adv_get.VacAdvMetaMsg;
import cooperation.vip.pb.vac_adv_get.VacAdvReq;
import cooperation.vip.pb.vac_adv_get.VacAdvRsp;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcooperation/vip/reward/VasRewardAdService;", "Lcooperation/vip/VasAdvService;", "activity", "Landroid/app/Activity;", "rewardParams", "Lcooperation/vip/reward/VasRewardAdParams;", "callback", "Lcooperation/vip/reward/VasRewardAdCallback;", "(Landroid/app/Activity;Lcooperation/vip/reward/VasRewardAdParams;Lcooperation/vip/reward/VasRewardAdCallback;)V", "activityRef", "Ljava/lang/ref/WeakReference;", "adInfo", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "getCallback", "()Lcooperation/vip/reward/VasRewardAdCallback;", "setCallback", "(Lcooperation/vip/reward/VasRewardAdCallback;)V", "deviceInfo", "Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;", "isAdConsumed", "", "reportBizBuff", "", "requestBizBuff", "getRewardParams", "()Lcooperation/vip/reward/VasRewardAdParams;", "setRewardParams", "(Lcooperation/vip/reward/VasRewardAdParams;)V", "rewardRspInfo", "Lcooperation/vip/pb/vac_adv_get$RewardRspInfo;", "beforeReportAd", "beforeRequestAd", "beforeShowAd", "callRewardResult", "", "retCode", "", "createReportAdReq", "Lcooperation/vip/pb/adv_report$MobileAdvReportReq;", "createRequestAdReq", "Lcooperation/vip/pb/vac_adv_get$VacAdvReq;", "ensureDeviceInfoValid", "onError", "serviceCode", "Lcooperation/vip/VasAdvService$ServiceCode;", "errMsg", "", "onReportAdSuccess", "rsp", "Lcooperation/vip/pb/adv_report$MobileAdvReportRsp;", "onRequestAdSuccess", "Lcooperation/vip/pb/vac_adv_get$VacAdvRsp;", "realShowAd", "showAdCallback", "Lcooperation/vip/VasAdvService$ShowAdCallback;", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VasRewardAdService
  extends VasAdvService
{
  public static final VasRewardAdService.Companion a;
  private vac_adv_get.RewardRspInfo jdField_a_of_type_CooperationVipPbVac_adv_get$RewardRspInfo;
  @NotNull
  private VasRewardAdCallback jdField_a_of_type_CooperationVipRewardVasRewardAdCallback;
  @NotNull
  private VasRewardAdParams jdField_a_of_type_CooperationVipRewardVasRewardAdParams;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private qq_ad_get.QQAdGet.DeviceInfo jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo;
  private qq_ad_get.QQAdGetRsp.AdInfo jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo;
  private volatile boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private byte[] b;
  
  static
  {
    jdField_a_of_type_CooperationVipRewardVasRewardAdService$Companion = new VasRewardAdService.Companion(null);
  }
  
  public VasRewardAdService(@NotNull Activity paramActivity, @NotNull VasRewardAdParams paramVasRewardAdParams, @NotNull VasRewardAdCallback paramVasRewardAdCallback)
  {
    this.jdField_a_of_type_CooperationVipRewardVasRewardAdParams = paramVasRewardAdParams;
    this.jdField_a_of_type_CooperationVipRewardVasRewardAdCallback = paramVasRewardAdCallback;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private final void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasRewardAdService", 0, "callRewardResult retCode:" + paramInt);
    }
    this.jdField_a_of_type_CooperationVipRewardVasRewardAdCallback.a(paramInt, this.jdField_a_of_type_ArrayOfByte, this.b);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private final void d()
  {
    if (this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo == null) {
      this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo = a(this.jdField_a_of_type_CooperationVipRewardVasRewardAdParams.c());
    }
  }
  
  @NotNull
  public adv_report.MobileAdvReportReq a()
  {
    adv_report.MobileAdvReportReq localMobileAdvReportReq = new adv_report.MobileAdvReportReq();
    localMobileAdvReportReq.qq.set(this.jdField_a_of_type_CooperationVipRewardVasRewardAdParams.a());
    localMobileAdvReportReq.adv_pos.set(this.jdField_a_of_type_CooperationVipRewardVasRewardAdParams.a());
    Object localObject1 = localMobileAdvReportReq.device_info;
    Object localObject2 = this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo;
    if (localObject2 != null)
    {
      ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).set((MessageMicro)localObject2);
      localMobileAdvReportReq.action_type.set(4);
      localObject1 = localMobileAdvReportReq.reward_report_info;
      localObject2 = new adv_report.RewardReportInfo();
      ((adv_report.RewardReportInfo)localObject2).reward_type.set(this.jdField_a_of_type_CooperationVipRewardVasRewardAdParams.b());
      ((adv_report.RewardReportInfo)localObject2).reward_item.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_CooperationVipRewardVasRewardAdParams.a()));
      vac_adv_get.RewardRspInfo localRewardRspInfo = this.jdField_a_of_type_CooperationVipPbVac_adv_get$RewardRspInfo;
      if (localRewardRspInfo != null)
      {
        ((adv_report.RewardReportInfo)localObject2).time.set(localRewardRspInfo.time.get());
        ((adv_report.RewardReportInfo)localObject2).nonce.set(localRewardRspInfo.nonce.get());
        ((adv_report.RewardReportInfo)localObject2).signature.set(localRewardRspInfo.signature.get());
      }
      ((adv_report.RewardReportInfo)localObject1).set((MessageMicro)localObject2);
      return localMobileAdvReportReq;
    }
    throw ((Throwable)new IllegalArgumentException("device info is null, report ad abort"));
  }
  
  @NotNull
  public vac_adv_get.VacAdvReq a()
  {
    vac_adv_get.VacAdvReq localVacAdvReq = new vac_adv_get.VacAdvReq();
    localVacAdvReq.qq.set(this.jdField_a_of_type_CooperationVipRewardVasRewardAdParams.a());
    localVacAdvReq.adv_pos.set(this.jdField_a_of_type_CooperationVipRewardVasRewardAdParams.a());
    Object localObject1 = localVacAdvReq.device_info;
    Object localObject2 = this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo;
    if (localObject2 != null)
    {
      ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).set((MessageMicro)localObject2);
      localObject1 = localVacAdvReq.reward_req_info;
      localObject2 = new vac_adv_get.RewardReqInfo();
      ((vac_adv_get.RewardReqInfo)localObject2).reward_type.set(this.jdField_a_of_type_CooperationVipRewardVasRewardAdParams.b());
      ((vac_adv_get.RewardReqInfo)localObject2).reward_item.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_CooperationVipRewardVasRewardAdParams.a()));
      ((vac_adv_get.RewardReqInfo)localObject1).set((MessageMicro)localObject2);
      return localVacAdvReq;
    }
    throw ((Throwable)new IllegalArgumentException("device info is null, request ad abort"));
  }
  
  public void a(@NotNull VasAdvService.ServiceCode paramServiceCode, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramServiceCode, "serviceCode");
    Intrinsics.checkParameterIsNotNull(paramString, "errMsg");
    int i;
    switch (VasRewardAdService.WhenMappings.a[paramServiceCode.ordinal()])
    {
    default: 
      throw new NoWhenBranchMatchedException();
    case 1: 
    case 2: 
      i = 5;
    }
    for (;;)
    {
      a(i);
      if (QLog.isColorLevel()) {
        QLog.d("VasRewardAdService", 0, "onError errMsg:" + paramString);
      }
      return;
      i = 2;
      continue;
      i = 6;
      continue;
      i = 3;
      continue;
      i = 7;
    }
  }
  
  public void a(@NotNull VasAdvService.ShowAdCallback paramShowAdCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramShowAdCallback, "showAdCallback");
    Object localObject2 = new VasRewardAdService.realShowAd.profitableCallback.1(this, paramShowAdCallback);
    Object localObject1 = this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo;
    if (localObject1 != null)
    {
      Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localActivity != null)
      {
        VasAdvSupport localVasAdvSupport = VasAdvSupport.a.a();
        Intrinsics.checkExpressionValueIsNotNull(localActivity, "activity");
        localVasAdvSupport.a(localActivity, (qq_ad_get.QQAdGetRsp.AdInfo)localObject1, (VasProfitableCallback)localObject2, this.jdField_a_of_type_CooperationVipRewardVasRewardAdParams.b(), this.jdField_a_of_type_CooperationVipRewardVasRewardAdParams.d());
        if (localActivity == null) {}
      }
      while (localObject1 != null)
      {
        return;
        localObject2 = (VasRewardAdService)this;
        paramShowAdCallback.a(false);
        ((VasRewardAdService)localObject2).a(8);
        localObject2 = Unit.INSTANCE;
      }
    }
    localObject1 = (VasRewardAdService)this;
    paramShowAdCallback.a(false);
    ((VasRewardAdService)localObject1).a(1);
    paramShowAdCallback = Unit.INSTANCE;
  }
  
  public void a(@NotNull adv_report.MobileAdvReportRsp paramMobileAdvReportRsp)
  {
    Intrinsics.checkParameterIsNotNull(paramMobileAdvReportRsp, "rsp");
    this.b = paramMobileAdvReportRsp.busi_buffer.get().toByteArray();
    a(0);
  }
  
  public void a(@NotNull vac_adv_get.VacAdvRsp paramVacAdvRsp)
  {
    Intrinsics.checkParameterIsNotNull(paramVacAdvRsp, "rsp");
    Object localObject = paramVacAdvRsp.vac_adv_msgs.get();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "rsp.vac_adv_msgs.get()");
    localObject = (vac_adv_get.VacAdvMetaMsg)CollectionsKt.firstOrNull((List)localObject);
    if (localObject != null) {}
    for (localObject = ((vac_adv_get.VacAdvMetaMsg)localObject).adv_rsp;; localObject = null)
    {
      this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject);
      this.jdField_a_of_type_CooperationVipPbVac_adv_get$RewardRspInfo = paramVacAdvRsp.reward_rsp_info;
      this.jdField_a_of_type_ArrayOfByte = paramVacAdvRsp.busi_buffer.get().toByteArray();
      b();
      return;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      d();
      this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo = ((qq_ad_get.QQAdGetRsp.AdInfo)null);
      this.jdField_a_of_type_CooperationVipPbVac_adv_get$RewardRspInfo = ((vac_adv_get.RewardRspInfo)null);
      this.jdField_a_of_type_ArrayOfByte = ((byte[])null);
      this.b = ((byte[])null);
      this.jdField_a_of_type_Boolean = false;
      return true;
    }
    a(9);
    return false;
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo != null) && (this.jdField_a_of_type_CooperationVipPbVac_adv_get$RewardRspInfo != null)) {
      return true;
    }
    a(1);
    return false;
  }
  
  public boolean c()
  {
    d();
    return this.jdField_a_of_type_CooperationVipPbVac_adv_get$RewardRspInfo != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.reward.VasRewardAdService
 * JD-Core Version:    0.7.0.1
 */