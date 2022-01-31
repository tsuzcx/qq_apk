package com.tencent.youtu.ytagreflectlivecheck;

import com.tencent.youtu.ytagreflectlivecheck.worker.TimerWorker;
import com.tencent.youtu.ytcommon.tools.YTLogger;

final class YTAGReflectLiveCheckInterface$2
  extends TimerWorker
{
  YTAGReflectLiveCheckInterface$2(long paramLong1, long paramLong2, YTAGReflectLiveCheckInterface.GetLiveStyleResult paramGetLiveStyleResult)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.getLiveCheckType.onFinish] ");
    this.val$getLiveStyleResult.onFailed(3, "Get light from sensor overtime.", "Maybe try again will work. if have tryed times, please record the device and report to server.");
  }
  
  public void onTick(long paramLong)
  {
    YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.getLiveCheckType.onTick] onTick");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.2
 * JD-Core Version:    0.7.0.1
 */