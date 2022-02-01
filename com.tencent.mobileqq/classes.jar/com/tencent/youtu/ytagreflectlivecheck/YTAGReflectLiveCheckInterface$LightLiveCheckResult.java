package com.tencent.youtu.ytagreflectlivecheck;

import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.FullPack;

public abstract interface YTAGReflectLiveCheckInterface$LightLiveCheckResult
{
  public static final int AUTH_FAILED = 1;
  public static final int FINISH_ERRORBASE = 300;
  public static final int INIT_ERRORBASE = 100;
  public static final int NOT_INIT_MODEL = 2;
  public static final int NOT_SET_RGBREQUEST = 4;
  public static final int NOT_SET_UPLOADREQUEST = 5;
  public static final int REFLECT_ERRORBASE = 200;
  public static final int SUCCESS = 0;
  public static final int USER_CANCEL = 3;
  
  public abstract void onFailed(int paramInt, String paramString1, String paramString2);
  
  public abstract void onSuccess(FullPack paramFullPack);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.LightLiveCheckResult
 * JD-Core Version:    0.7.0.1
 */