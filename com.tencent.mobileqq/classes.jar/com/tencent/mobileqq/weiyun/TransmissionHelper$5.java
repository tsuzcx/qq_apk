package com.tencent.mobileqq.weiyun;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weiyun.api.IWeiyunApi;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.WeiyunTrialCouponUseMsgReq;
import com.tencent.mobileqq.weiyun.utils.PreferenceUtils;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

final class TransmissionHelper$5
  implements Runnable
{
  TransmissionHelper$5(int paramInt) {}
  
  public void run()
  {
    WeiyunPB.WeiyunTrialCouponUseMsgReq localWeiyunTrialCouponUseMsgReq = new WeiyunPB.WeiyunTrialCouponUseMsgReq();
    localWeiyunTrialCouponUseMsgReq.business_id.set("upload_speed_up");
    ((IWeiyunApi)QRoute.api(IWeiyunApi.class)).trialTransferCoupon(localWeiyunTrialCouponUseMsgReq, null);
    int i = this.a;
    if (i > 0) {
      PreferenceUtils.a(MobileQQ.sMobileQQ, String.valueOf(MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin()), "upload_coupon_count", String.valueOf(i - 1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.TransmissionHelper.5
 * JD-Core Version:    0.7.0.1
 */