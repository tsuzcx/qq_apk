package com.tencent.mobileqq.identification;

import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.GetLiveStyleResult;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester.YTLiveStyleReq;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleResponse;
import java.util.concurrent.atomic.AtomicBoolean;

final class FaceLoginHelper$1
  implements YTAGReflectLiveCheckInterface.GetLiveStyleResult
{
  FaceLoginHelper$1(AtomicBoolean paramAtomicBoolean, FaceConf paramFaceConf, FaceLoginHelper.IConfInterface paramIConfInterface) {}
  
  public void onFailed(int paramInt, String paramString1, String paramString2)
  {
    QLog.d("FaceLoginHelper", 1, new Object[] { "getLightInfo Failed code=", Integer.valueOf(paramInt), " tips=", paramString1, " howtofix=", paramString2 });
    this.a.set(true);
    FaceLoginHelper.a(this.b, this.c);
  }
  
  public void onSuccess(LiveStyleRequester.YTLiveStyleReq paramYTLiveStyleReq, LiveStyleResponse paramLiveStyleResponse)
  {
    QLog.d("FaceLoginHelper", 1, "getLightInfo success");
    if (this.a.compareAndSet(true, true))
    {
      QLog.d("FaceLoginHelper", 1, "sendPacket isLoading now");
      return;
    }
    FaceLoginHelper.a(paramYTLiveStyleReq, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.identification.FaceLoginHelper.1
 * JD-Core Version:    0.7.0.1
 */