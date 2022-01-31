package com.tencent.mobileqq.intervideo;

import android.app.Activity;
import android.os.Bundle;

public abstract interface IVPluginEvtListener
{
  public abstract void a(Activity paramActivity);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract void a(String paramString1, int paramInt, String paramString2);
  
  public abstract void a(String paramString1, String paramString2, Bundle paramBundle);
  
  public abstract void b(String paramString);
  
  public abstract void c(String paramString);
  
  public abstract void d(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.IVPluginEvtListener
 * JD-Core Version:    0.7.0.1
 */