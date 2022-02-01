package com.tencent.youtu.ytagreflectlivecheck.manager;

import com.tencent.youtu.ytagreflectlivecheck.requester.LightDiffResponseV3;

public abstract interface ProcessManager$ProcessFinishResultV3
{
  public abstract void onFailed(int paramInt, String paramString1, String paramString2, long paramLong);
  
  public abstract void onSuccess(boolean paramBoolean, LightDiffResponseV3 paramLightDiffResponseV3, String paramString, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager.ProcessFinishResultV3
 * JD-Core Version:    0.7.0.1
 */