package com.tencent.mobileqq.webview.util;

import android.content.Context;
import android.content.Intent;
import mqq.app.AppRuntime;

public abstract interface IWebProcessReceiverInjector
{
  public abstract void a(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent);
  
  public abstract void a(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent, int paramInt);
  
  public abstract void a(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.util.IWebProcessReceiverInjector
 * JD-Core Version:    0.7.0.1
 */