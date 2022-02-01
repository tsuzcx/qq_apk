package com.tencent.qapmsdk;

import android.app.Application;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.config.PluginCombination.Companion;
import com.tencent.qapmsdk.base.listener.IAnrConfigListener;
import com.tencent.qapmsdk.base.listener.IDropFrameListener;
import com.tencent.qapmsdk.base.listener.IExtraDataListener;
import com.tencent.qapmsdk.base.listener.IInspectorListener;
import com.tencent.qapmsdk.base.listener.ILooperListener;
import com.tencent.qapmsdk.base.listener.IMemoryCellingListener;
import com.tencent.qapmsdk.base.listener.IResourceListener;
import com.tencent.qapmsdk.base.listener.IWebViewBreadCrumbListener;
import com.tencent.qapmsdk.common.logger.LogState;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.dropframe.DropFrameMonitor;
import com.tencent.qapmsdk.qapmmanager.QAPMConfigureWizard;
import com.tencent.qapmsdk.resource.ResourceMonitor;
import java.lang.ref.WeakReference;

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
  public static final int PropertyAnrConfigListener = 117;
  public static final int PropertyDropFrameListener = 113;
  public static final int PropertyExtraDataListener = 115;
  public static final int PropertyInspectorListener = 110;
  public static final int PropertyKeyAppId = 101;
  public static final int PropertyKeyAppInstance = 109;
  public static final int PropertyKeyAppVersion = 103;
  public static final int PropertyKeyAthenaHost = 107;
  public static final int PropertyKeyDeviceId = 108;
  public static final int PropertyKeyHost = 106;
  public static final int PropertyKeyLogLevel = 105;
  public static final int PropertyKeySymbolId = 104;
  public static final int PropertyKeyUserId = 102;
  public static final int PropertyLooperListener = 116;
  public static final int PropertyMemoryCellingListener = 111;
  public static final int PropertyResourceListener = 114;
  public static final int PropertyWebViewBreadCrumbListener = 112;
  public static final String SCENE_ALL = "SCENE_ALL";
  private static final String TAG = "QAPM_QAPM";
  @NonNull
  private static QAPM apm = new QAPM();
  private static int userMode = PluginCombination.Companion.getModeStable();
  
  static
  {
    ModeFileIO = PluginCombination.ioPlugin.mode;
    ModeDBIO = PluginCombination.dbPlugin.mode;
    ModeLooper = PluginCombination.loopStackPlugin.mode;
    ModeCeiling = PluginCombination.ceilingValuePlugin.mode;
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
    if (paramInt == ModeResource)
    {
      if ("RESOURCEMONITOR".equals(str)) {
        ResourceMonitor.getInstance().start();
      } else {
        ResourceMonitor.getInstance().start(paramString1, str);
      }
    }
    else if (paramInt == ModeDropFrame)
    {
      if ("RESOURCEMONITOR".equals(str)) {
        ResourceMonitor.getInstance().stop();
      } else {
        DropFrameMonitor.getInstance().beginDropFrameScene(paramString1);
      }
    }
    else
    {
      userMode = paramInt;
      a.a(paramInt, false);
    }
    return true;
  }
  
  public static boolean endScene(String paramString, int paramInt)
  {
    String str;
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals("QAPM_APPLAUNCH"))) {
      str = "QAPM_APPLAUNCH_END";
    } else {
      str = "";
    }
    return endScene(paramString, str, paramInt);
  }
  
  public static boolean endScene(String paramString1, @Nullable String paramString2, int paramInt)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    if (paramInt == ModeResource)
    {
      if ("RESOURCEMONITOR".equals(str))
      {
        ResourceMonitor.getInstance().stop();
        return true;
      }
      ResourceMonitor.getInstance().stop(paramString1, str);
      return true;
    }
    if (paramInt == ModeDropFrame)
    {
      DropFrameMonitor.getInstance().stopDropFrameScene();
      return true;
    }
    userMode = paramInt;
    a.a(paramInt, false);
    return true;
  }
  
  @NonNull
  public static QAPM setProperty(int paramInt, @Nullable Object paramObject)
  {
    if (paramObject != null) {
      if (paramInt != 105) {
        switch (paramInt)
        {
        default: 
          Logger.INSTANCE.w(new String[] { "QAPM_QAPM", "set invalid property by object type, key = ", String.valueOf(paramInt), ", value = ", paramObject.toString() });
          break;
        case 117: 
          try
          {
            com.tencent.qapmsdk.base.listener.ListenerManager.anrConfigListener = (IAnrConfigListener)paramObject;
          }
          catch (Throwable paramObject)
          {
            Logger.INSTANCE.exception("QAPM_QAPM", paramObject);
          }
        case 116: 
          try
          {
            com.tencent.qapmsdk.base.listener.ListenerManager.looperListener = (ILooperListener)paramObject;
          }
          catch (Throwable paramObject)
          {
            Logger.INSTANCE.exception("QAPM_QAPM", paramObject);
          }
        case 115: 
          try
          {
            com.tencent.qapmsdk.base.listener.ListenerManager.extraDataListener = (IExtraDataListener)paramObject;
          }
          catch (Throwable paramObject)
          {
            Logger.INSTANCE.exception("QAPM_QAPM", paramObject);
          }
        case 114: 
          try
          {
            com.tencent.qapmsdk.base.listener.ListenerManager.resourceListener = (IResourceListener)paramObject;
          }
          catch (Throwable paramObject)
          {
            Logger.INSTANCE.exception("QAPM_QAPM", paramObject);
          }
        case 113: 
          try
          {
            com.tencent.qapmsdk.base.listener.ListenerManager.dropFrameListener = (IDropFrameListener)paramObject;
          }
          catch (Throwable paramObject)
          {
            Logger.INSTANCE.exception("QAPM_QAPM", paramObject);
          }
        case 112: 
          try
          {
            com.tencent.qapmsdk.base.listener.ListenerManager.webViewBreadCrumbListener = new WeakReference((IWebViewBreadCrumbListener)paramObject);
          }
          catch (Throwable paramObject)
          {
            Logger.INSTANCE.exception("QAPM_QAPM", paramObject);
          }
        case 111: 
          try
          {
            com.tencent.qapmsdk.base.listener.ListenerManager.memoryCellingListener = (IMemoryCellingListener)paramObject;
          }
          catch (Throwable paramObject)
          {
            Logger.INSTANCE.exception("QAPM_QAPM", paramObject);
          }
        case 110: 
          try
          {
            com.tencent.qapmsdk.base.listener.ListenerManager.inspectorListener = (IInspectorListener)paramObject;
          }
          catch (Throwable paramObject)
          {
            Logger.INSTANCE.exception("QAPM_QAPM", paramObject);
          }
        case 109: 
          QAPMConfigureWizard.setApplication((Application)paramObject);
          break;
        }
      } else {
        try
        {
          Logger.INSTANCE.resetLogLevel(((Integer)paramObject).intValue());
        }
        catch (Throwable paramObject)
        {
          Logger.INSTANCE.exception("QAPM_QAPM", paramObject);
        }
      }
    }
    return apm;
  }
  
  @NonNull
  public static QAPM setProperty(int paramInt, @NonNull String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      switch (paramInt)
      {
      default: 
        Logger.INSTANCE.w(new String[] { "QAPM_QAPM", "set invalid property by string type, key = ", String.valueOf(paramInt), ", value = ", paramString });
        break;
      case 108: 
        QAPMConfigureWizard.setDeviceId(paramString);
        break;
      case 107: 
        QAPMConfigureWizard.setAthenaHost(paramString);
        break;
      case 106: 
        QAPMConfigureWizard.setAPMHost(paramString);
        break;
      case 105: 
        try
        {
          QAPMConfigureWizard.setLogLevel(Integer.parseInt(paramString));
        }
        catch (Throwable paramString)
        {
          Logger.INSTANCE.exception("QAPM_QAPM", paramString);
        }
      case 104: 
        QAPMConfigureWizard.setUuid(paramString);
        break;
      case 103: 
        QAPMConfigureWizard.setVersion(paramString);
        break;
      case 102: 
        if (QAPMConfigureWizard.setUin(paramString)) {
          a.a(userMode, true);
        }
        break;
      case 101: 
        try
        {
          paramString = paramString.split("-");
          if (paramString.length >= 2)
          {
            QAPMConfigureWizard.setAppKey(paramString[0]);
            QAPMConfigureWizard.setAppId(Integer.valueOf(paramString[1]).intValue());
          }
        }
        catch (Throwable paramString)
        {
          Logger.INSTANCE.exception("QAPM_QAPM", paramString);
        }
      }
    }
    return apm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.QAPM
 * JD-Core Version:    0.7.0.1
 */