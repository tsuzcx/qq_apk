package com.tencent.youtu.ytagreflectlivecheck;

import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester.YTLiveStyleReq;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleResponse;
import com.tencent.youtu.ytagreflectlivecheck.worker.SensorManagerWorker;
import com.tencent.youtu.ytagreflectlivecheck.worker.SensorManagerWorker.OnGetValue;
import com.tencent.youtu.ytagreflectlivecheck.worker.TimerWorker;
import com.tencent.youtu.ytcommon.tools.YTLogger;

final class YTAGReflectLiveCheckInterface$1
  implements SensorManagerWorker.OnGetValue
{
  YTAGReflectLiveCheckInterface$1(YTAGReflectLiveCheckInterface.GetLiveStyleResult paramGetLiveStyleResult) {}
  
  public void onGetValue(float paramFloat)
  {
    YTAGReflectLiveCheckInterface.access$008();
    YTLogger.d("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.getLiveCheckType.onGetValue] get value: " + paramFloat + " mOnGetValueCount: " + YTAGReflectLiveCheckInterface.access$000());
    if (YTAGReflectLiveCheckInterface.access$000() > 1)
    {
      YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.getLiveCheckType.onGetValue] get value: " + paramFloat);
      if (YTAGReflectLiveCheckInterface.access$100() != null)
      {
        YTAGReflectLiveCheckInterface.access$100().cancel();
        YTAGReflectLiveCheckInterface.access$102(null);
      }
      this.val$getLiveStyleResult.onSuccess(new LiveStyleRequester.YTLiveStyleReq(paramFloat), new LiveStyleResponse());
      SensorManagerWorker.getInstance().stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.1
 * JD-Core Version:    0.7.0.1
 */