package com.tencent.open.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import mqq.app.AppRuntime;

public abstract interface IWebViewOpenSdkApi
{
  public abstract Object a(Activity paramActivity, AppRuntime paramAppRuntime, Object paramObject, Intent paramIntent);
  
  public abstract Object a(String paramString);
  
  public abstract void a(Activity paramActivity, Bundle paramBundle);
  
  public abstract void a(Context paramContext, Object paramObject);
  
  public abstract void a(Bundle paramBundle, Activity paramActivity, String paramString1, String paramString2);
  
  public abstract void a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, Activity paramActivity, String paramString5);
  
  public abstract void a(String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract boolean b(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.api.IWebViewOpenSdkApi
 * JD-Core Version:    0.7.0.1
 */