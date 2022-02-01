package com.tencent.youtu.ytagreflectlivecheck.manager;

import android.os.Handler;
import android.os.Looper;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;

final class ProcessManager$1
  implements ProcessManager.ProcessResult
{
  public void onFailed(int paramInt, String paramString1, String paramString2, long paramLong)
  {
    YTAGReflectLiveCheckInterface.noticeFailed(paramInt + 100, paramString1, paramString2, paramLong);
    ProcessManager.mProcessState = 0;
  }
  
  public void onSuccess(long paramLong)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ProcessManager.access$000(paramLong);
      return;
    }
    new Handler(Looper.getMainLooper()).post(new ProcessManager.1.1(this, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager.1
 * JD-Core Version:    0.7.0.1
 */