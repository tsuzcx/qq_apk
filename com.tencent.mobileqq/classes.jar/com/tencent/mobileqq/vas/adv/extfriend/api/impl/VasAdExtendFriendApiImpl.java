package com.tencent.mobileqq.vas.adv.extfriend.api.impl;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport.Companion;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get.VacFeedsAdvMetaReq;
import com.tencent.mobileqq.vas.adv.extfriend.api.IVasAdExtendFriendApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/extfriend/api/impl/VasAdExtendFriendApiImpl;", "Lcom/tencent/mobileqq/vas/adv/extfriend/api/IVasAdExtendFriendApi;", "()V", "generateVacFeedsAdvMetaReq", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$VacFeedsAdvMetaReq;", "gdtDeviceInfo", "Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;", "getDeviceInfo", "getDeviceInfoByteArray", "", "initDeviceInfo", "", "setParamsToDeviceInfo", "deviceInfo", "Companion", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public final class VasAdExtendFriendApiImpl
  implements IVasAdExtendFriendApi
{
  public static final VasAdExtendFriendApiImpl.Companion Companion = new VasAdExtendFriendApiImpl.Companion(null);
  private static final String MAC = "35e972";
  
  private final vac_adv_get.VacFeedsAdvMetaReq generateVacFeedsAdvMetaReq(qq_ad_get.QQAdGet.DeviceInfo paramDeviceInfo)
  {
    vac_adv_get.VacFeedsAdvMetaReq localVacFeedsAdvMetaReq = new vac_adv_get.VacFeedsAdvMetaReq();
    if (paramDeviceInfo != null) {
      localVacFeedsAdvMetaReq.device_info.set((MessageMicro)paramDeviceInfo);
    }
    return localVacFeedsAdvMetaReq;
  }
  
  private final qq_ad_get.QQAdGet.DeviceInfo getDeviceInfo()
  {
    return VasAdvSupport.a.a().b("1018ec");
  }
  
  private final qq_ad_get.QQAdGet.DeviceInfo setParamsToDeviceInfo(qq_ad_get.QQAdGet.DeviceInfo paramDeviceInfo)
  {
    if (paramDeviceInfo != null)
    {
      paramDeviceInfo.mac.set("35e972");
      paramDeviceInfo.imei.set("35e972");
      return paramDeviceInfo;
    }
    return null;
  }
  
  @NotNull
  public byte[] getDeviceInfoByteArray()
  {
    byte[] arrayOfByte = generateVacFeedsAdvMetaReq(setParamsToDeviceInfo(getDeviceInfo())).toByteArray();
    Intrinsics.checkExpressionValueIsNotNull(arrayOfByte, "generateVacFeedsAdvMetaR…DeviceInfo).toByteArray()");
    return arrayOfByte;
  }
  
  public void initDeviceInfo()
  {
    VasAdvSupport.a.a().a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.extfriend.api.impl.VasAdExtendFriendApiImpl
 * JD-Core Version:    0.7.0.1
 */