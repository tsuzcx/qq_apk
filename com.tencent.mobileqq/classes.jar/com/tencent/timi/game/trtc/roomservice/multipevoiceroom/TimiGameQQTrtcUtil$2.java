package com.tencent.timi.game.trtc.roomservice.multipevoiceroom;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.utils.IResultListener;
import trpc.yes.common.TcloudServerOuterClass.GetUserTCloudSignRsp;

final class TimiGameQQTrtcUtil$2
  implements IResultListener<TcloudServerOuterClass.GetUserTCloudSignRsp>
{
  TimiGameQQTrtcUtil$2(TimiGameQQTrtcUtil.ITrtcCheckResult paramITrtcCheckResult) {}
  
  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("errCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(paramString);
    QLog.e("TimiGameQQTrtcCheckUtil", 2, localStringBuilder.toString());
    this.a.a(-3, paramString);
  }
  
  public void a(TcloudServerOuterClass.GetUserTCloudSignRsp paramGetUserTCloudSignRsp)
  {
    QLog.i("TimiGameQQTrtcCheckUtil", 2, "checkTrtcUserSig[Success]");
    TimiGameQQTrtcUtil.c = paramGetUserTCloudSignRsp.trtc_sign.get();
    TimiGameQQTrtcUtil.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.roomservice.multipevoiceroom.TimiGameQQTrtcUtil.2
 * JD-Core Version:    0.7.0.1
 */