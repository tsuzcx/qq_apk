package com.tencent.mobileqq.uniformdownload.util;

import android.os.Bundle;

public abstract interface IUniformDownloaderListener
{
  public abstract void a(int paramInt, Bundle paramBundle);
  
  public abstract void a(int paramInt, String paramString, Bundle paramBundle);
  
  public abstract void a(String paramString, long paramLong, Bundle paramBundle);
  
  public abstract void b(int paramInt, Bundle paramBundle);
  
  public abstract void c(int paramInt, Bundle paramBundle);
  
  public abstract void d(int paramInt, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.util.IUniformDownloaderListener
 * JD-Core Version:    0.7.0.1
 */