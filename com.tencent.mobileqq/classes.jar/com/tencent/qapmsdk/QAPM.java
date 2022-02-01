package com.tencent.qapmsdk;

import android.app.Application;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.config.PluginCombination.Companion;
import com.tencent.qapmsdk.base.listener.IExtraDataListener;
import com.tencent.qapmsdk.base.listener.IInspectorListener;
import com.tencent.qapmsdk.base.listener.IMemoryCellingListener;
import com.tencent.qapmsdk.base.listener.IWebViewBreadCrumbListener;
import com.tencent.qapmsdk.base.reporter.ab.AbProviderSingleton;
import com.tencent.qapmsdk.base.reporter.ab.AbType;
import com.tencent.qapmsdk.common.logger.LogState;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.dropframe.DropFrameMonitor;
import com.tencent.qapmsdk.qapmmanager.QAPMConfigureWizard;
import com.tencent.qapmsdk.resource.ResourceMonitor;
import java.lang.ref.WeakReference;
import org.jetbrains.annotations.NotNull;

public class QAPM
{
  public static final int LevelDebug = LogState.DEBUG.getValue();
  public static final int LevelError;
  public static final int LevelInfo;
  public static final int LevelOff;
  public static final int LevelVerbos = LogState.VERBOS.getValue();
  public static final int LevelWarn;
  public static final int ModeANR;
  public static final int ModeAll;
  public static final int ModeBattery;
  public static final int ModeCeiling;
  public static final int ModeCrash;
  public static final int ModeDBIO;
  public static final int ModeDropFrame;
  public static final int ModeFileIO;
  public static final int ModeHTTP;
  public static final int ModeJsError;
  public static final int ModeLeakInspector = PluginCombination.leakPlugin.mode;
  public static final int ModeLooper;
  public static final int ModeResource;
  public static final int ModeStable;
  public static final int ModeWebView;
  public static final int PropertyExtraDataListener = 202;
  public static final int PropertyInspectorListener = 107;
  public static final int PropertyKeyAppId = 101;
  public static final int PropertyKeyAppInstance = 201;
  public static final int PropertyKeyAppVersion = 103;
  public static final int PropertyKeyAthenaHost = 111;
  public static final int PropertyKeyDeviceId = 109;
  public static final int PropertyKeyHost = 106;
  public static final int PropertyKeyLogLevel = 105;
  public static final int PropertyKeySymbolId = 104;
  public static final int PropertyKeyUserId = 102;
  public static final int PropertyMemoryCellingListener = 108;
  public static final int PropertyWebViewBreadCrumbListener = 110;
  public static final String SCENE_ALL = "SCENE_ALL";
  private static final String TAG = "QAPM_QAPM";
  @NonNull
  private static QAPM apm = new QAPM();
  private static int userMode = 0;
  
  static
  {
    ModeFileIO = PluginCombination.ioPlugin.mode;
    ModeDBIO = PluginCombination.dbPlugin.mode;
    ModeLooper = PluginCombination.loopStackPlugin.mode;
    ModeCeiling = PluginCombination.ceilingValuePlugin.mode;
    ModeBattery = PluginCombination.batteryPlugin.mode;
    ModeResource = PluginCombination.resourcePlugin.mode;
    ModeDropFrame = PluginCombination.dropFramePlugin.mode;
    ModeANR = PluginCombination.anrPlugin.mode;
    ModeCrash = PluginCombination.crashPlugin.mode;
    ModeWebView = PluginCombination.webViewPlugin.mode;
    ModeHTTP = PluginCombination.httpPlugin.mode;
    ModeJsError = PluginCombination.jsErrorPlugin.mode;
    ModeAll = PluginCombination.Companion.getModeAll();
    ModeStable = PluginCombination.Companion.getModeStable();
    LevelOff = LogState.OFF.getValue();
    LevelError = LogState.ERROR.getValue();
    LevelWarn = LogState.WARN.getValue();
    LevelInfo = LogState.INFO.getValue();
  }
  
  public static boolean beginScene(String paramString, int paramInt)
  {
    return beginScene(paramString, "", paramInt);
  }
  
  public static boolean beginScene(String paramString1, @Nullable String paramString2, int paramInt)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    if ((userMode & paramInt) != paramInt)
    {
      userMode |= paramInt;
      a.a(paramInt, false);
    }
    if (paramInt == ModeResource) {
      if ("RESOURCEMONITOR".equals(str)) {
        ResourceMonitor.getInstance().start();
      }
    }
    for (;;)
    {
      return true;
      ResourceMonitor.getInstance().start(paramString1, str);
      continue;
      if (paramInt == ModeDropFrame) {
        if ("RESOURCEMONITOR".equals(str)) {
          ResourceMonitor.getInstance().stop();
        } else {
          DropFrameMonitor.getInstance().beginDropFrameScene(paramString1);
        }
      }
    }
  }
  
  public static boolean endScene(String paramString, int paramInt)
  {
    return endScene(paramString, "", paramInt);
  }
  
  public static boolean endScene(String paramString1, @Nullable String paramString2, int paramInt)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    if ((userMode & paramInt) != paramInt)
    {
      userMode |= paramInt;
      a.a(paramInt, false);
    }
    if (paramInt == ModeResource) {
      if ("RESOURCEMONITOR".equals(str)) {
        ResourceMonitor.getInstance().stop();
      }
    }
    while (paramInt != ModeDropFrame)
    {
      return true;
      ResourceMonitor.getInstance().stop(paramString1, str);
      return true;
    }
    DropFrameMonitor.getInstance().stopDropFrameScene();
    return true;
  }
  
  public static String getAbFactorByQapmPlugin(int paramInt)
  {
    return AbProviderSingleton.getInstance().getAbFactors(paramInt);
  }
  
  public static void setAbFactor(@NotNull String paramString1, @NotNull String paramString2, @NotNull Class<? extends AbType> paramClass)
  {
    Logger.INSTANCE.i(new String[] { "QAPM_QAPM", "setABFactor:" + paramClass + " val " + paramString2 });
    paramClass = AbProviderSingleton.getInstance().getAbType(paramClass);
    if (paramClass != null)
    {
      paramClass.initValue(paramString2, paramString1);
      paramClass.active();
      return;
    }
    Logger.INSTANCE.e(new String[] { "QAPM_QAPM", "setABFactor not found" });
  }
  
  public static void setAbTypes(Class<? extends AbType>[] paramArrayOfClass)
  {
    AbProviderSingleton.getInstance().abTypeArr = paramArrayOfClass;
  }
  
  @NonNull
  public static QAPM setProperty(int paramInt, @Nullable Object paramObject)
  {
    if (paramObject != null) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      return apm;
      QAPMConfigureWizard.setApplication((Application)paramObject);
      continue;
      try
      {
        Logger.INSTANCE.resetLogLevel(((Integer)paramObject).intValue());
      }
      catch (Throwable paramObject)
      {
        Logger.INSTANCE.exception("QAPM_QAPM", paramObject);
      }
      continue;
      try
      {
        com.tencent.qapmsdk.base.listener.ListenerManager.inspectorListener = (IInspectorListener)paramObject;
      }
      catch (Throwable paramObject)
      {
        Logger.INSTANCE.exception("QAPM_QAPM", paramObject);
      }
      continue;
      try
      {
        com.tencent.qapmsdk.base.listener.ListenerManager.memoryCellingListener = (IMemoryCellingListener)paramObject;
      }
      catch (Throwable paramObject)
      {
        Logger.INSTANCE.exception("QAPM_QAPM", paramObject);
      }
      continue;
      try
      {
        com.tencent.qapmsdk.base.listener.ListenerManager.webViewBreadCrumbListener = new WeakReference((IWebViewBreadCrumbListener)paramObject);
      }
      catch (Throwable paramObject)
      {
        Logger.INSTANCE.exception("QAPM_QAPM", paramObject);
      }
      continue;
      try
      {
        com.tencent.qapmsdk.base.listener.ListenerManager.extraDataListener = (IExtraDataListener)paramObject;
      }
      catch (Throwable paramObject)
      {
        Logger.INSTANCE.exception("QAPM_QAPM", paramObject);
      }
    }
  }
  
  @NonNull
  public static QAPM setProperty(int paramInt, @NonNull String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      return apm;
      QAPMConfigureWizard.setUuid(paramString);
      continue;
      if (QAPMConfigureWizard.setUin(paramString))
      {
        a.a(userMode, true);
        continue;
        QAPMConfigureWizard.setAPMHost(paramString);
        continue;
        QAPMConfigureWizard.setAthenaHost(paramString);
        continue;
        try
        {
          QAPMConfigureWizard.setLogLevel(Integer.parseInt(paramString));
        }
        catch (Throwable paramString)
        {
          Logger.INSTANCE.exception("QAPM_QAPM", paramString);
        }
        continue;
        try
        {
          paramString = paramString.split("-");
          if (paramString.length < 2) {
            continue;
          }
          QAPMConfigureWizard.setAppKey(paramString[0]);
          QAPMConfigureWizard.setAppId(Integer.valueOf(paramString[1]).intValue());
        }
        catch (Throwable paramString)
        {
          Logger.INSTANCE.exception("QAPM_QAPM", paramString);
        }
        continue;
        QAPMConfigureWizard.setVersion(paramString);
        continue;
        QAPMConfigureWizard.setDeviceId(paramString);
      }
    }
  }
  
  public static void unSetAbFactor(Class<? extends AbType> paramClass)
  {
    Logger.INSTANCE.i(new String[] { "QAPM_QAPM", "unSetABFactor:" + paramClass });
    paramClass = AbProviderSingleton.getInstance().getAbType(paramClass);
    if (paramClass != null)
    {
      paramClass.unActive();
      return;
    }
    Logger.INSTANCE.e(new String[] { "QAPM_QAPM", "setABFactor not found" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.QAPM
 * JD-Core Version:    0.7.0.1
 */