package com.tencent.mobileqq.microapp.appbrand.page;

public abstract interface AppBrandServiceEventInterface
{
  public abstract void onServiceEvent(String paramString1, String paramString2, int[] paramArrayOfInt);
  
  public abstract String onServiceNativeRequest(String paramString1, String paramString2, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.page.AppBrandServiceEventInterface
 * JD-Core Version:    0.7.0.1
 */