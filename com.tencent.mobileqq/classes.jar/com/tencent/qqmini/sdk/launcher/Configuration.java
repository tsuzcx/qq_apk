package com.tencent.qqmini.sdk.launcher;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.tencent.qqmini.sdk.launcher.dynamic.Reflect;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.ProcessType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Configuration
{
  private static final String CLASS_CUSTOM_CONFIG = "com.tencent.qqmini.sdk.core.generated.CustomConfiguration";
  private static final String FIELD_DEXLOADER_ENABLED = "DEXLOADER_ENABLED";
  private static final String FIELD_DEX_CONFIG = "DEX_CONFIG";
  private static final String FIELD_FLUTTER_ENABLED = "FLUTTER_ENABLED";
  private static final String FIELD_MINI_PROCESS_LIST = "MINI_PROCESS_LIST";
  private static final String TAG = "Configuration";
  public String dexConfig;
  public boolean dexLoaderEnable = true;
  public boolean flutterEnabled;
  public List<Configuration.ProcessInfo> processInfoList = new ArrayList();
  
  private Configuration(Context paramContext)
  {
    if (isCustomConfigurationExist())
    {
      initCustomConfiguration(paramContext);
      return;
    }
    QMLog.i("Configuration", "OK with CustomConfiguration not found. Use default configuration");
    initDefaultConfiguration(paramContext);
  }
  
  private void addProcessInfo(String paramString, Class paramClass1, Class paramClass2, Class paramClass3, ProcessType paramProcessType, int paramInt)
  {
    Configuration.ProcessInfo localProcessInfo = new Configuration.ProcessInfo();
    localProcessInfo.name = paramString;
    localProcessInfo.uiClass = paramClass1;
    localProcessInfo.internalUIClass = paramClass2;
    localProcessInfo.receiverClass = paramClass3;
    localProcessInfo.processType = paramProcessType;
    localProcessInfo.supportRuntimeType = paramInt;
    this.processInfoList.add(localProcessInfo);
  }
  
  private void ensureProcessInfo(Context paramContext)
  {
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      int i = this.processInfoList.size() - 1;
      while (i >= 0)
      {
        Configuration.ProcessInfo localProcessInfo = (Configuration.ProcessInfo)this.processInfoList.get(i);
        Object localObject = new Intent();
        ((Intent)localObject).setClassName(paramContext.getPackageName(), localProcessInfo.uiClass.getName());
        if (localPackageManager.resolveActivity((Intent)localObject, 0) == null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Not registered manifest. uiClass:");
          ((StringBuilder)localObject).append(localProcessInfo.uiClass.getName());
          QMLog.e("Configuration", ((StringBuilder)localObject).toString());
          this.processInfoList.remove(i);
        }
        i -= 1;
      }
      return;
    }
    catch (Throwable paramContext)
    {
      QMLog.e("Configuration", "getDefaultConfiguration exception. ", paramContext);
    }
  }
  
  private Class findClass(String paramString)
  {
    return AppLoaderFactory.g().findClass(paramString);
  }
  
  private void initCustomConfiguration(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    paramContext = paramContext.getPackageName();
    this.flutterEnabled = ((Boolean)Reflect.on("com.tencent.qqmini.sdk.core.generated.CustomConfiguration").get("FLUTTER_ENABLED")).booleanValue();
    this.dexLoaderEnable = ((Boolean)Reflect.on("com.tencent.qqmini.sdk.core.generated.CustomConfiguration").get("DEXLOADER_ENABLED")).booleanValue();
    this.dexConfig = ((String)Reflect.on("com.tencent.qqmini.sdk.core.generated.CustomConfiguration").get("DEX_CONFIG"));
    Iterator localIterator = ((List)Reflect.on("com.tencent.qqmini.sdk.core.generated.CustomConfiguration").get("MINI_PROCESS_LIST")).iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      if ((localObject1 instanceof Map))
      {
        localObject1 = (Map)localObject1;
        Configuration.ProcessInfo localProcessInfo = new Configuration.ProcessInfo();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramContext);
        ((StringBuilder)localObject2).append(":");
        ((StringBuilder)localObject2).append(((Map)localObject1).get("name").toString());
        localProcessInfo.name = ((StringBuilder)localObject2).toString();
        localObject2 = ((Map)localObject1).get("processType").toString();
        if ("MINI_GAME".equals(localObject2)) {
          localProcessInfo.processType = ProcessType.MINI_GAME;
        } else if ("MINI_APP".equals(localObject2)) {
          localProcessInfo.processType = ProcessType.MINI_APP;
        } else if ("MINI_INTERNAL".equals(localObject2)) {
          localProcessInfo.processType = ProcessType.MINI_INTERNAL;
        }
        if (((Map)localObject1).get("internalUI") != null)
        {
          localObject2 = findClass(((Map)localObject1).get("internalUI").toString());
          if ((localObject2 != null) && (Activity.class.isAssignableFrom((Class)localObject2))) {
            localProcessInfo.internalUIClass = ((Class)localObject2);
          }
        }
        localProcessInfo.supportRuntimeType = ((Integer)((Map)localObject1).get("supportRuntimeType")).intValue();
        localProcessInfo.uiClass = ((Class)((Map)localObject1).get("ui"));
        localProcessInfo.receiverClass = ((Class)((Map)localObject1).get("receiver"));
        this.processInfoList.add(localProcessInfo);
      }
    }
  }
  
  private void initDefaultConfiguration(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    this.flutterEnabled = false;
    this.dexLoaderEnable = true;
    this.dexConfig = "";
    paramContext = paramContext.getPackageName();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext);
    localStringBuilder.append(":mini1");
    addProcessInfo(localStringBuilder.toString(), findClass("com.tencent.qqmini.sdk.ui.MiniActivity1"), null, findClass("com.tencent.qqmini.sdk.receiver.AppBrandMainReceiver1"), ProcessType.MINI_GAME, 4);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext);
    localStringBuilder.append(":mini2");
    addProcessInfo(localStringBuilder.toString(), findClass("com.tencent.qqmini.sdk.ui.MiniActivity2"), null, findClass("com.tencent.qqmini.sdk.receiver.AppBrandMainReceiver2"), ProcessType.MINI_GAME, 4);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext);
    localStringBuilder.append(":mini3");
    addProcessInfo(localStringBuilder.toString(), findClass("com.tencent.qqmini.sdk.ui.MiniActivity3"), null, findClass("com.tencent.qqmini.sdk.receiver.AppBrandMainReceiver3"), ProcessType.MINI_GAME, 4);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext);
    localStringBuilder.append(":mini4");
    addProcessInfo(localStringBuilder.toString(), findClass("com.tencent.qqmini.sdk.ui.MiniActivity4"), null, findClass("com.tencent.qqmini.sdk.receiver.AppBrandMainReceiver4"), ProcessType.MINI_APP, 1);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext);
    localStringBuilder.append(":mini5");
    addProcessInfo(localStringBuilder.toString(), findClass("com.tencent.qqmini.sdk.ui.MiniActivity5"), null, findClass("com.tencent.qqmini.sdk.receiver.AppBrandMainReceiver5"), ProcessType.MINI_APP, 1);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext);
    localStringBuilder.append(":mini_internal");
    addProcessInfo(localStringBuilder.toString(), findClass("com.tencent.qqmini.sdk.ui.InternalMiniActivity"), null, findClass("com.tencent.qqmini.sdk.receiver.InternalAppBrandMainReceiver"), ProcessType.MINI_INTERNAL, 1);
  }
  
  private boolean isCustomConfigurationExist()
  {
    return findClass("com.tencent.qqmini.sdk.core.generated.CustomConfiguration") != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.Configuration
 * JD-Core Version:    0.7.0.1
 */