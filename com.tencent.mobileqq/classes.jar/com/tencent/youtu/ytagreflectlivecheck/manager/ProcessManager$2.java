package com.tencent.youtu.ytagreflectlivecheck.manager;

import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;

final class ProcessManager$2
  implements ProcessManager.ProcessResult
{
  public void onFailed(int paramInt, String paramString1, String paramString2, long paramLong)
  {
    YTAGReflectLiveCheckInterface.noticeFailed(paramInt + 200, paramString1, paramString2, paramLong);
    ProcessManager.mProcessState = 0;
  }
  
  public void onSuccess(long paramLong)
  {
    ProcessManager.access$100(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager.2
 * JD-Core Version:    0.7.0.1
 */