package com.vivo.push.sdk.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.vivo.push.sdk.a;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.o;

public class CommandService
  extends Service
{
  protected boolean a(String paramString)
  {
    return "com.vivo.pushservice.action.RECEIVE".equals(paramString);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    o.c("CommandService", "onBind initSuc: ");
    return null;
  }
  
  public void onCreate()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getClass().getSimpleName());
    ((StringBuilder)localObject).append(" -- oncreate ");
    ((StringBuilder)localObject).append(getPackageName());
    o.c("CommandService", ((StringBuilder)localObject).toString());
    super.onCreate();
    localObject = ContextDelegate.getContext(getApplicationContext());
    a.a().a((Context)localObject);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append(" -- onStartCommand ");
    localStringBuilder.append(getPackageName());
    o.c("CommandService", localStringBuilder.toString());
    if (paramIntent == null)
    {
      stopSelf();
      return 2;
    }
    if (!a(paramIntent.getAction()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getPackageName());
      localStringBuilder.append(" receive invalid action ");
      localStringBuilder.append(paramIntent.getAction());
      o.a("CommandService", localStringBuilder.toString());
      stopSelf();
      return 2;
    }
    try
    {
      a.a().a(getClass().getName());
      a.a().a(paramIntent);
    }
    catch (Exception paramIntent)
    {
      o.a("CommandService", "onStartCommand -- error", paramIntent);
    }
    stopSelf();
    return 2;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.sdk.service.CommandService
 * JD-Core Version:    0.7.0.1
 */