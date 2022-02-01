package com.tencent.smtt.sdk;

public abstract interface TbsListener
{
  public static final String tag_load_error = "loaderror";
  
  public abstract void onDownloadFinish(int paramInt);
  
  public abstract void onDownloadProgress(int paramInt);
  
  public abstract void onInstallFinish(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsListener
 * JD-Core Version:    0.7.0.1
 */