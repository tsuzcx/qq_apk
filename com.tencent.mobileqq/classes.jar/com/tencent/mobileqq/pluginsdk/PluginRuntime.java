package com.tencent.mobileqq.pluginsdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.WtloginManagerImpl;
import mqq.manager.Manager;

public class PluginRuntime
  extends AppRuntime
{
  private static final String CRASH_ACTION = "com.tencent.mobileqq.ACTION_PLUGIN_CRASH";
  private static final String INDEX_PLUGINID = "pluginsdk_carsh_pluginID";
  private static final String INDEX_THROWABLE = "pluginsdk_carsh_throwable";
  private static final boolean SUPPORT_CRASH_REPORT = true;
  private PluginRuntime.IClickEventReportor mReportor;
  
  public static PluginRuntime getRuntime()
  {
    Object localObject1 = MobileQQ.getMobileQQ();
    Object localObject2 = null;
    AppRuntime localAppRuntime = ((MobileQQ)localObject1).waitAppRuntime(null);
    localObject1 = localObject2;
    if (localAppRuntime != null)
    {
      localObject1 = localObject2;
      if ((localAppRuntime instanceof PluginRuntime)) {
        localObject1 = (PluginRuntime)localAppRuntime;
      }
    }
    return localObject1;
  }
  
  public static void handleCrash(Throwable paramThrowable, String paramString, Context paramContext)
  {
    Intent localIntent = new Intent("com.tencent.mobileqq.ACTION_PLUGIN_CRASH");
    localIntent.putExtra("pluginsdk_carsh_pluginID", paramString);
    localIntent.putExtra("pluginsdk_carsh_throwable", paramThrowable);
    localIntent.setPackage(MobileQQ.getContext().getPackageName());
    paramContext.sendBroadcast(localIntent);
  }
  
  public BaseApplication getApp()
  {
    return null;
  }
  
  public String getCurrentAccountUin()
  {
    return getAccount();
  }
  
  public Manager getManager(int paramInt)
  {
    Object localObject = super.getManager(paramInt);
    if (localObject != null) {
      return localObject;
    }
    if (paramInt == 1) {
      localObject = new WtloginManagerImpl(this);
    }
    if (localObject != null) {
      addManager(paramInt, (Manager)localObject);
    }
    return localObject;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.parentRuntime == null) {
      PluginRecoverReceiver.register(getApplication(), new PluginRecoverReceiver());
    }
  }
  
  public void reportClickEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    PluginRuntime.IClickEventReportor localIClickEventReportor = this.mReportor;
    if (localIClickEventReportor != null) {
      localIClickEventReportor.reportClickEvent(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
    }
  }
  
  public void reportClickEventRuntime(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    PluginRuntime.IClickEventReportor localIClickEventReportor = this.mReportor;
    if (localIClickEventReportor != null) {
      localIClickEventReportor.reportClickEventRuntime(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
    }
  }
  
  public void sendAppDataIncerment(String paramString, String[] paramArrayOfString, long paramLong)
  {
    if (DebugHelper.sDebug)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PluginRuntime.sendAppDataIncerment:");
      localStringBuilder.append(paramArrayOfString);
      DebugHelper.log(localStringBuilder.toString());
    }
    super.sendAppDataIncermentMsg(paramString, paramArrayOfString, paramLong);
  }
  
  public void setClickEventReportor(PluginRuntime.IClickEventReportor paramIClickEventReportor)
  {
    this.mReportor = paramIClickEventReportor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginRuntime
 * JD-Core Version:    0.7.0.1
 */