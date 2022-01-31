package cooperation.weiyun;

import bieh;
import bifz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.weiyun.channel.pb.WeiyunPB.WeiyunTrialCouponUseMsgReq;
import mqq.app.AppRuntime;

public final class TransmissionHelper$5
  implements Runnable
{
  public TransmissionHelper$5(int paramInt) {}
  
  public void run()
  {
    WeiyunPB.WeiyunTrialCouponUseMsgReq localWeiyunTrialCouponUseMsgReq = new WeiyunPB.WeiyunTrialCouponUseMsgReq();
    localWeiyunTrialCouponUseMsgReq.business_id.set("upload_speed_up");
    bieh.a(localWeiyunTrialCouponUseMsgReq, null);
    if (this.a > 0)
    {
      int i = this.a;
      bifz.a(BaseApplicationImpl.getApplication().getApplicationContext(), String.valueOf(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()), "upload_coupon_count", String.valueOf(i - 1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.weiyun.TransmissionHelper.5
 * JD-Core Version:    0.7.0.1
 */