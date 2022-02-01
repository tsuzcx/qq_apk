package com.tencent.mobileqq.vas.adv.reward;

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
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport.Companion;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import com.tencent.mobileqq.vas.adv.common.pb.adv_report.MobileAdvReportReq;
import com.tencent.mobileqq.vas.adv.common.pb.adv_report.MobileAdvReportRsp;
import com.tencent.mobileqq.vas.adv.common.pb.adv_report.RewardReportInfo;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get.RewardReqInfo;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get.RewardRspInfo;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get.VacAdvMetaMsg;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get.VacAdvReq;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get.VacAdvRsp;
import com.tencent.mobileqq.vas.adv.reward.callback.VasRewardAdCallback;
import com.tencent.mobileqq.vas.adv.reward.data.VasRewardAdParams;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/reward/VasRewardAdService;", "Lcom/tencent/mobileqq/vas/adv/reward/VasRewardAdBaseService;", "activity", "Landroid/app/Activity;", "rewardParams", "Lcom/tencent/mobileqq/vas/adv/reward/data/VasRewardAdParams;", "callback", "Lcom/tencent/mobileqq/vas/adv/reward/callback/VasRewardAdCallback;", "(Landroid/app/Activity;Lcom/tencent/mobileqq/vas/adv/reward/data/VasRewardAdParams;Lcom/tencent/mobileqq/vas/adv/reward/callback/VasRewardAdCallback;)V", "activityRef", "Ljava/lang/ref/WeakReference;", "adInfo", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "getCallback", "()Lcom/tencent/mobileqq/vas/adv/reward/callback/VasRewardAdCallback;", "setCallback", "(Lcom/tencent/mobileqq/vas/adv/reward/callback/VasRewardAdCallback;)V", "deviceInfo", "Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;", "isAdConsumed", "", "reportBizBuff", "", "requestBizBuff", "getRewardParams", "()Lcom/tencent/mobileqq/vas/adv/reward/data/VasRewardAdParams;", "setRewardParams", "(Lcom/tencent/mobileqq/vas/adv/reward/data/VasRewardAdParams;)V", "rewardRspInfo", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$RewardRspInfo;", "beforeReportAd", "beforeRequestAd", "beforeShowAd", "callRewardResult", "", "retCode", "", "convertAdServiceCode", "serviceCode", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "createReportAdReq", "Lcom/tencent/mobileqq/vas/adv/common/pb/adv_report$MobileAdvReportReq;", "createRequestAdReq", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$VacAdvReq;", "ensureDeviceInfoValid", "getProfitableCallback", "Lcom/tencent/mobileqq/vas/adv/reward/VasProfitableCallback;", "showAdCallback", "Lcom/tencent/mobileqq/vas/adv/reward/VasRewardAdBaseService$ShowAdCallback;", "onError", "errMsg", "", "onReportAdSuccess", "rsp", "Lcom/tencent/mobileqq/vas/adv/common/pb/adv_report$MobileAdvReportRsp;", "onRequestAdSuccess", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$VacAdvRsp;", "realShowAd", "showMotiveAd", "profitableCallback", "rewardText", "bizSrc", "Companion", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public final class VasRewardAdService
  extends VasRewardAdBaseService
{
  public static final VasRewardAdService.Companion a;
  private vac_adv_get.RewardRspInfo jdField_a_of_type_ComTencentMobileqqVasAdvCommonPbVac_adv_get$RewardRspInfo;
  @NotNull
  private VasRewardAdCallback jdField_a_of_type_ComTencentMobileqqVasAdvRewardCallbackVasRewardAdCallback;
  @NotNull
  private VasRewardAdParams jdField_a_of_type_ComTencentMobileqqVasAdvRewardDataVasRewardAdParams;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private qq_ad_get.QQAdGet.DeviceInfo jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo;
  private qq_ad_get.QQAdGetRsp.AdInfo jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo;
  private volatile boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private byte[] b;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqVasAdvRewardVasRewardAdService$Companion = new VasRewardAdService.Companion(null);
  }
  
  public VasRewardAdService(@NotNull Activity paramActivity, @NotNull VasRewardAdParams paramVasRewardAdParams, @NotNull VasRewardAdCallback paramVasRewardAdCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasAdvRewardDataVasRewardAdParams = paramVasRewardAdParams;
    this.jdField_a_of_type_ComTencentMobileqqVasAdvRewardCallbackVasRewardAdCallback = paramVasRewardAdCallback;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private final int a(VasAdvServiceCode paramVasAdvServiceCode)
  {
    switch (VasRewardAdService.WhenMappings.a[paramVasAdvServiceCode.ordinal()])
    {
    default: 
      throw new NoWhenBranchMatchedException();
    case 8: 
    case 9: 
      return 7;
    case 7: 
      return 3;
    case 5: 
    case 6: 
      return 6;
    case 4: 
      return 2;
    case 2: 
    case 3: 
      return 5;
    }
    return 0;
  }
  
  private final VasProfitableCallback a(VasRewardAdBaseService.ShowAdCallback paramShowAdCallback)
  {
    return (VasProfitableCallback)new VasRewardAdService.getProfitableCallback.1(this, paramShowAdCallback);
  }
  
  private final void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("callRewardResult retCode:");
      localStringBuilder.append(paramInt);
      QLog.d("VasRewardAdService", 0, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqVasAdvRewardCallbackVasRewardAdCallback.onReward(paramInt, this.jdField_a_of_type_ArrayOfByte, this.b);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private final void a(Activity paramActivity, qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, VasProfitableCallback paramVasProfitableCallback, String paramString1, String paramString2)
  {
    VasAdvSupport.a.a().a(paramActivity, paramAdInfo, paramVasProfitableCallback, paramString1, paramString2);
  }
  
  private final void d()
  {
    if (this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo == null) {
      this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo = a(this.jdField_a_of_type_ComTencentMobileqqVasAdvRewardDataVasRewardAdParams.getGdtBizId());
    }
  }
  
  @NotNull
  protected adv_report.MobileAdvReportReq a()
  {
    adv_report.MobileAdvReportReq localMobileAdvReportReq = new adv_report.MobileAdvReportReq();
    localMobileAdvReportReq.qq.set(this.jdField_a_of_type_ComTencentMobileqqVasAdvRewardDataVasRewardAdParams.getUin());
    localMobileAdvReportReq.adv_pos.set(this.jdField_a_of_type_ComTencentMobileqqVasAdvRewardDataVasRewardAdParams.getAdvPos());
    Object localObject1 = localMobileAdvReportReq.device_info;
    Object localObject2 = this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo;
    if (localObject2 != null)
    {
      ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).set((MessageMicro)localObject2);
      localMobileAdvReportReq.action_type.set(4);
      localObject1 = localMobileAdvReportReq.reward_report_info;
      localObject2 = new adv_report.RewardReportInfo();
      ((adv_report.RewardReportInfo)localObject2).reward_type.set(this.jdField_a_of_type_ComTencentMobileqqVasAdvRewardDataVasRewardAdParams.getRewardType());
      ((adv_report.RewardReportInfo)localObject2).reward_item.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentMobileqqVasAdvRewardDataVasRewardAdParams.getRewardItem()));
      vac_adv_get.RewardRspInfo localRewardRspInfo = this.jdField_a_of_type_ComTencentMobileqqVasAdvCommonPbVac_adv_get$RewardRspInfo;
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
  protected vac_adv_get.VacAdvReq a()
  {
    vac_adv_get.VacAdvReq localVacAdvReq = new vac_adv_get.VacAdvReq();
    localVacAdvReq.qq.set(this.jdField_a_of_type_ComTencentMobileqqVasAdvRewardDataVasRewardAdParams.getUin());
    localVacAdvReq.adv_pos.set(this.jdField_a_of_type_ComTencentMobileqqVasAdvRewardDataVasRewardAdParams.getAdvPos());
    Object localObject1 = localVacAdvReq.device_info;
    Object localObject2 = this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo;
    if (localObject2 != null)
    {
      ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).set((MessageMicro)localObject2);
      localObject1 = localVacAdvReq.reward_req_info;
      localObject2 = new vac_adv_get.RewardReqInfo();
      ((vac_adv_get.RewardReqInfo)localObject2).reward_type.set(this.jdField_a_of_type_ComTencentMobileqqVasAdvRewardDataVasRewardAdParams.getRewardType());
      ((vac_adv_get.RewardReqInfo)localObject2).reward_item.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentMobileqqVasAdvRewardDataVasRewardAdParams.getRewardItem()));
      ((vac_adv_get.RewardReqInfo)localObject1).set((MessageMicro)localObject2);
      return localVacAdvReq;
    }
    throw ((Throwable)new IllegalArgumentException("device info is null, request ad abort"));
  }
  
  protected void a(@NotNull VasAdvServiceCode paramVasAdvServiceCode, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramVasAdvServiceCode, "serviceCode");
    Intrinsics.checkParameterIsNotNull(paramString, "errMsg");
    a(a(paramVasAdvServiceCode));
    if (QLog.isColorLevel())
    {
      paramVasAdvServiceCode = new StringBuilder();
      paramVasAdvServiceCode.append("onError errMsg:");
      paramVasAdvServiceCode.append(paramString);
      QLog.d("VasRewardAdService", 0, paramVasAdvServiceCode.toString());
    }
  }
  
  protected void a(@NotNull adv_report.MobileAdvReportRsp paramMobileAdvReportRsp)
  {
    Intrinsics.checkParameterIsNotNull(paramMobileAdvReportRsp, "rsp");
    this.b = paramMobileAdvReportRsp.busi_buffer.get().toByteArray();
    a(0);
  }
  
  protected void a(@NotNull vac_adv_get.VacAdvRsp paramVacAdvRsp)
  {
    Intrinsics.checkParameterIsNotNull(paramVacAdvRsp, "rsp");
    Object localObject = paramVacAdvRsp.vac_adv_msgs.get();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "rsp.vac_adv_msgs.get()");
    localObject = (vac_adv_get.VacAdvMetaMsg)CollectionsKt.firstOrNull((List)localObject);
    if (localObject != null) {
      localObject = ((vac_adv_get.VacAdvMetaMsg)localObject).adv_rsp;
    } else {
      localObject = null;
    }
    this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject);
    this.jdField_a_of_type_ComTencentMobileqqVasAdvCommonPbVac_adv_get$RewardRspInfo = paramVacAdvRsp.reward_rsp_info;
    this.jdField_a_of_type_ArrayOfByte = paramVacAdvRsp.busi_buffer.get().toByteArray();
    b();
  }
  
  protected void a(@NotNull VasRewardAdBaseService.ShowAdCallback paramShowAdCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramShowAdCallback, "showAdCallback");
    Object localObject2 = a(paramShowAdCallback);
    Object localObject1 = this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo;
    if (localObject1 != null)
    {
      Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localActivity != null)
      {
        Intrinsics.checkExpressionValueIsNotNull(localActivity, "activity");
        a(localActivity, (qq_ad_get.QQAdGetRsp.AdInfo)localObject1, (VasProfitableCallback)localObject2, this.jdField_a_of_type_ComTencentMobileqqVasAdvRewardDataVasRewardAdParams.getRewardText(), this.jdField_a_of_type_ComTencentMobileqqVasAdvRewardDataVasRewardAdParams.getBizSrcId());
        if (localActivity != null) {}
      }
      else
      {
        localObject2 = (VasRewardAdService)this;
        paramShowAdCallback.a(false);
        ((VasRewardAdService)localObject2).a(8);
        localObject2 = Unit.INSTANCE;
      }
      if (localObject1 != null) {
        return;
      }
    }
    localObject1 = (VasRewardAdService)this;
    paramShowAdCallback.a(false);
    ((VasRewardAdService)localObject1).a(1);
    paramShowAdCallback = Unit.INSTANCE;
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      d();
      this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo = ((qq_ad_get.QQAdGetRsp.AdInfo)null);
      this.jdField_a_of_type_ComTencentMobileqqVasAdvCommonPbVac_adv_get$RewardRspInfo = ((vac_adv_get.RewardRspInfo)null);
      byte[] arrayOfByte = (byte[])null;
      this.jdField_a_of_type_ArrayOfByte = arrayOfByte;
      this.b = arrayOfByte;
      this.jdField_a_of_type_Boolean = false;
      return true;
    }
    a(9);
    return false;
  }
  
  protected boolean b()
  {
    if ((this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqVasAdvCommonPbVac_adv_get$RewardRspInfo != null)) {
      return true;
    }
    a(1);
    return false;
  }
  
  protected boolean c()
  {
    d();
    return this.jdField_a_of_type_ComTencentMobileqqVasAdvCommonPbVac_adv_get$RewardRspInfo != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.reward.VasRewardAdService
 * JD-Core Version:    0.7.0.1
 */