package com.tencent.youtu.ytagreflectlivecheck.manager;

import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytagreflectlivecheck.requester.LightDiffResponse;

final class ProcessManager$3
  implements ProcessManager.ProcessFinishResult
{
  public void onFailed(int paramInt, String paramString1, String paramString2, long paramLong)
  {
    YTAGReflectLiveCheckInterface.noticeFailed(paramInt + 300, paramString1, paramString2, paramLong);
    ProcessManager.mProcessState = 0;
  }
  
  public void onSuccess(boolean paramBoolean, LightDiffResponse paramLightDiffResponse, String paramString, long paramLong)
  {
    YTAGReflectLiveCheckInterface.noticeSuccess(paramBoolean, paramLightDiffResponse, paramString, paramLong);
    ProcessManager.mProcessState = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager.3
 * JD-Core Version:    0.7.0.1
 */