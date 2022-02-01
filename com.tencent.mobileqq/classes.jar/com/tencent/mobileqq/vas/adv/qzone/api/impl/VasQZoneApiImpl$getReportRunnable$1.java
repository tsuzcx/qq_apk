package com.tencent.mobileqq.vas.adv.qzone.api.impl;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vas.adv.base.VasAdvBizCallback;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport.Companion;
import com.tencent.mobileqq.vas.adv.common.pb.adv_report.MobileAdvReportReq;
import com.tencent.mobileqq.vas.adv.common.pb.adv_report.SubscribeInfo;
import com.tencent.mobileqq.vas.adv.qzone.data.VasAdMetaReportParam;
import kotlin.Metadata;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class VasQZoneApiImpl$getReportRunnable$1
  implements Runnable
{
  VasQZoneApiImpl$getReportRunnable$1(VasQZoneApiImpl paramVasQZoneApiImpl, VasAdMetaReportParam paramVasAdMetaReportParam, VasAdvBizCallback paramVasAdvBizCallback) {}
  
  public final void run()
  {
    adv_report.MobileAdvReportReq localMobileAdvReportReq = new adv_report.MobileAdvReportReq();
    localMobileAdvReportReq.recomm_cookie.set(this.a.getRecommendCookie());
    localMobileAdvReportReq.adv_pos.set(this.a.getAdvPos());
    localMobileAdvReportReq.action_type.set(this.a.getActionType());
    localMobileAdvReportReq.action_value.set(this.a.getActionValue());
    localMobileAdvReportReq.feed_index.set(this.a.getFeedIndex());
    localMobileAdvReportReq.qq.set(this.a.getUin());
    Object localObject = VasAdvSupport.a.a().b("1018ec");
    if (localObject != null) {
      localMobileAdvReportReq.device_info.set((MessageMicro)localObject);
    }
    localObject = this.a.getSubscribeId();
    if (localObject != null)
    {
      adv_report.SubscribeInfo localSubscribeInfo1 = localMobileAdvReportReq.subscribe_info;
      adv_report.SubscribeInfo localSubscribeInfo2 = new adv_report.SubscribeInfo();
      localSubscribeInfo2.id.set((String)localObject);
      localSubscribeInfo1.set((MessageMicro)localSubscribeInfo2);
    }
    VasQZoneApiImpl.access$reportAd(this.this$0, localMobileAdvReportReq, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.qzone.api.impl.VasQZoneApiImpl.getReportRunnable.1
 * JD-Core Version:    0.7.0.1
 */