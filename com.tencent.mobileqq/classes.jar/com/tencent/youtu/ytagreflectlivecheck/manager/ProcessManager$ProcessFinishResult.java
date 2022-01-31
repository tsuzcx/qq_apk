package com.tencent.youtu.ytagreflectlivecheck.manager;

import com.tencent.youtu.ytagreflectlivecheck.requester.LightDiffResponse;

public abstract interface ProcessManager$ProcessFinishResult
{
  public abstract void onFailed(int paramInt, String paramString1, String paramString2, long paramLong);
  
  public abstract void onSuccess(boolean paramBoolean, LightDiffResponse paramLightDiffResponse, String paramString, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager.ProcessFinishResult
 * JD-Core Version:    0.7.0.1
 */