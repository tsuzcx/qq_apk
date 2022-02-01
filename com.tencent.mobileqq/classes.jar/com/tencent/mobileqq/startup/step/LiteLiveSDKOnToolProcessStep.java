package com.tencent.mobileqq.startup.step;

import com.tencent.mobileqq.litelivesdk.sdkimpl.ipc.LiteLiveSDKClientIPCModule;
import com.tencent.qphone.base.util.QLog;

public class LiteLiveSDKOnToolProcessStep
  extends Step
{
  public boolean step()
  {
    QLog.e("LIteLiveSDKOnToolProcessStep", 1, "LIteLiveSDKOnToolProcessStep-----run");
    LiteLiveSDKClientIPCModule.a();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.LiteLiveSDKOnToolProcessStep
 * JD-Core Version:    0.7.0.1
 */