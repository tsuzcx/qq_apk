package com.tencent.turingfd.sdk.xq;

public abstract interface continue
{
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
 * Qualified Name:     com.tencent.turingfd.sdk.xq.continue
 * JD-Core Version:    0.7.0.1
 */