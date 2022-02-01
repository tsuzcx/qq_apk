package com.tencent.turingfd.sdk.xq;

public abstract interface IteApkInfoResp
  extends continue
{
  public static final int SL_HIGH = 1;
  public static final int SL_LOW = 3;
  public static final int SL_MID = 2;
  public static final int SL_SAFE = 0;
  public static final int SL_UNKNOW = 4;
  
  public abstract long getErrorCode();
  
  public abstract String getFileMd5();
  
  public abstract String getFileName();
  
  public abstract String getFileSha1();
  
  public abstract String getHandleUrl();
  
  public abstract String getPkgName();
  
  public abstract int getRiskCategory();
  
  public abstract String getRiskTips();
  
  public abstract int getSafeLevel();
  
  public abstract boolean isSucceed();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.IteApkInfoResp
 * JD-Core Version:    0.7.0.1
 */