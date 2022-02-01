package com.tencent.mobileqq.uftransfer.task;

import android.os.Bundle;
import com.tencent.mobileqq.uftransfer.UFTLogicThread;
import com.tencent.mobileqq.uftransfer.api.impl.UFTTransferKey;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTBaseTaskInfo;
import mqq.app.AppRuntime;

public abstract class UFTBaseTask
{
  private final IUFTTaskCallback a;
  protected final AppRuntime f;
  protected final UFTTransferKey g;
  protected final UFTBaseTaskInfo h;
  protected boolean i = true;
  
  protected UFTBaseTask(AppRuntime paramAppRuntime, UFTTransferKey paramUFTTransferKey, UFTBaseTaskInfo paramUFTBaseTaskInfo, IUFTTaskCallback paramIUFTTaskCallback)
  {
    this.f = paramAppRuntime;
    this.g = paramUFTTransferKey;
    this.h = paramUFTBaseTaskInfo;
    this.a = paramIUFTTaskCallback;
  }
  
  public static boolean a(AppRuntime paramAppRuntime, UFTTransferKey paramUFTTransferKey, UFTBaseTaskInfo paramUFTBaseTaskInfo, IUFTTaskCallback paramIUFTTaskCallback, String paramString)
  {
    if (paramAppRuntime == null)
    {
      UFTLog.d(paramString, 1, "task.app is null");
      return false;
    }
    if (paramUFTTransferKey == null)
    {
      UFTLog.d(paramString, 1, "task.transfer key is null");
      return false;
    }
    if (paramUFTBaseTaskInfo == null)
    {
      UFTLog.d(paramString, 1, "task.task info is null");
      return false;
    }
    if (paramIUFTTaskCallback == null)
    {
      UFTLog.d(paramString, 1, "task.task callback is null");
      return false;
    }
    return true;
  }
  
  public void a(Bundle paramBundle)
  {
    this.i = true;
    c(3);
  }
  
  public abstract boolean a(UFTBaseTask paramUFTBaseTask);
  
  protected final void b(int paramInt)
  {
    this.i = true;
    c(3);
    UFTLogicThread.a().b(new UFTBaseTask.1(this, paramInt));
  }
  
  public void c(int paramInt)
  {
    UFTBaseTaskInfo localUFTBaseTaskInfo = this.h;
    if (localUFTBaseTaskInfo != null) {
      localUFTBaseTaskInfo.a(paramInt);
    }
  }
  
  protected abstract boolean dy_();
  
  public boolean k()
  {
    this.i = false;
    c(2);
    return dy_();
  }
  
  protected UFTBaseTask l()
  {
    return this;
  }
  
  public long m()
  {
    UFTBaseTaskInfo localUFTBaseTaskInfo = this.h;
    if (localUFTBaseTaskInfo != null) {
      return localUFTBaseTaskInfo.n();
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.UFTBaseTask
 * JD-Core Version:    0.7.0.1
 */