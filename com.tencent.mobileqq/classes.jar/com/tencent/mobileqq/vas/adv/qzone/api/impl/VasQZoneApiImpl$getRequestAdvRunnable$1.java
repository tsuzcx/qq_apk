package com.tencent.mobileqq.vas.adv.qzone.api.impl;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vas.adv.base.VasAdvBizCallback;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport.Companion;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get.QzoneBusiMsg;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get.VacAdvReq;
import com.tencent.mobileqq.vas.adv.qzone.callback.VasAdMetaCallback;
import com.tencent.mobileqq.vas.adv.qzone.data.VasAdMetaParam;
import kotlin.Metadata;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class VasQZoneApiImpl$getRequestAdvRunnable$1
  implements Runnable
{
  VasQZoneApiImpl$getRequestAdvRunnable$1(VasQZoneApiImpl paramVasQZoneApiImpl, VasAdMetaParam paramVasAdMetaParam, VasAdMetaCallback paramVasAdMetaCallback, VasAdvBizCallback paramVasAdvBizCallback) {}
  
  public final void run()
  {
    vac_adv_get.VacAdvReq localVacAdvReq = new vac_adv_get.VacAdvReq();
    localVacAdvReq.qq.set(this.jdField_a_of_type_ComTencentMobileqqVasAdvQzoneDataVasAdMetaParam.getUin());
    localVacAdvReq.adv_pos.set(this.jdField_a_of_type_ComTencentMobileqqVasAdvQzoneDataVasAdMetaParam.getAdvPos());
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVasAdvQzoneDataVasAdMetaParam.getQzoneBusiInfo();
    if (localObject != null) {
      localVacAdvReq.qzone_busi_info.set((MessageMicro)localObject);
    }
    localObject = VasAdvSupport.a.a().a("1018ec");
    if (localObject != null) {
      localVacAdvReq.device_info.set((MessageMicro)localObject);
    }
    if (localVacAdvReq.device_info.get() == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVasAdvQzoneCallbackVasAdMetaCallback.onGetAdInfoResponse(VasAdvServiceCode.CREATE_REQUEST_ERR, null, null);
      return;
    }
    VasQZoneApiImpl.access$requestAd(this.this$0, localVacAdvReq, this.jdField_a_of_type_ComTencentMobileqqVasAdvBaseVasAdvBizCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.qzone.api.impl.VasQZoneApiImpl.getRequestAdvRunnable.1
 * JD-Core Version:    0.7.0.1
 */