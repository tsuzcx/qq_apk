package com.tencent.mobileqq.qcircle.tempapi.api;

public abstract interface IQCirclrModuleDownloadListener
{
  public abstract void onDownloadCanceled(String paramString);
  
  public abstract void onDownloadFailed(String paramString);
  
  public abstract void onDownloadProgress(String paramString, float paramFloat);
  
  public abstract void onDownloadSucceed(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.tempapi.api.IQCirclrModuleDownloadListener
 * JD-Core Version:    0.7.0.1
 */