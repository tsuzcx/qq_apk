package com.tencent.qg.sdk.doraemon;

public abstract interface DoraemonApiWrapper$ApiCallback
{
  public abstract void onComplete();
  
  public abstract void onFailure(int paramInt, String paramString);
  
  public abstract void onPermission(int paramInt);
  
  public abstract void onSuccess(String paramString);
  
  public abstract void onTrigger(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qg.sdk.doraemon.DoraemonApiWrapper.ApiCallback
 * JD-Core Version:    0.7.0.1
 */