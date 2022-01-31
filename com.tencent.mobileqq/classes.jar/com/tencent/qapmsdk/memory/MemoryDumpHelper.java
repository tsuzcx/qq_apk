package com.tencent.qapmsdk.memory;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.listener.IMemoryCellingListener;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.base.monitorplugin.PluginController;
import com.tencent.qapmsdk.base.reporter.ReporterMachine;
import com.tencent.qapmsdk.base.reporter.uploaddata.data.ResultObject;
import com.tencent.qapmsdk.common.activty.ActivityInfo;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.network.NetworkWatcher;
import com.tencent.qapmsdk.common.util.AppInfo;
import com.tencent.qapmsdk.common.util.AsyncSPEditor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class MemoryDumpHelper
{
  private static final int MAX_THRESHOLD = 100;
  private static final String TAG = "QAPM_memory_MemoryDumpHelper";
  @NonNull
  private static HashMap<String, String> extraInfoMap = new HashMap();
  @Nullable
  private static volatile MemoryDumpHelper sInstance = null;
  
  private boolean canDumpMemory()
  {
    if (!NetworkWatcher.INSTANCE.isWifiAvailable())
    {
      Logger.INSTANCE.d(new String[] { "QAPM_memory_MemoryDumpHelper", "network is not wifi, don't dump" });
      return false;
    }
    if ((BaseInfo.sharePreference != null) && (BaseInfo.editor != null))
    {
      int i = BaseInfo.sharePreference.getInt(BaseInfo.userMeta.version, 0);
      if ((i < 1) || (MemoryCeilingMonitor.sDebug))
      {
        BaseInfo.editor.putInt(BaseInfo.userMeta.version, i + 1).apply();
        Logger.INSTANCE.d(new String[] { "QAPM_memory_MemoryDumpHelper", "this user don't have dumped" });
        return true;
      }
    }
    Logger.INSTANCE.d(new String[] { "QAPM_memory_MemoryDumpHelper", "this user have dumped." });
    return false;
  }
  
  private void dump(String paramString)
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = MemoryCeilingMonitor.getInstance().memoryCellingListener.onBeforeDump(paramString);
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      ((List)localObject1).addAll((Collection)localObject2);
      paramString = DumpMemInfoHandler.zipFiles((List)localObject1, paramString);
      localObject1 = ActivityInfo.getCurrentActivityName();
      if (((Boolean)paramString[0]).booleanValue()) {
        break label106;
      }
      Logger.INSTANCE.e(new String[] { "QAPM_memory_MemoryDumpHelper", "dump other file failed!" });
    }
    label106:
    do
    {
      return;
      Logger.INSTANCE.e(new String[] { "QAPM_memory_MemoryDumpHelper", "prepareFiles is none" });
      return;
      MemoryCeilingMonitor.getInstance().memoryCellingListener.onAfterDump();
    } while (!PluginController.INSTANCE.canCollect(PluginCombination.ceilingHprofPlugin.plugin));
    try
    {
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("fileObj", paramString[1]);
      ((JSONObject)localObject2).put("stage", localObject1);
      ((JSONObject)localObject2).put("Activity", localObject1);
      ((JSONObject)localObject2).put("UIN", BaseInfo.userMeta.uin);
      ((JSONObject)localObject2).put("Model", Build.MODEL);
      ((JSONObject)localObject2).put("OS", Build.VERSION.RELEASE);
      ((JSONObject)localObject2).put("Threshold", PluginCombination.ceilingHprofPlugin.threshold * Runtime.getRuntime().maxMemory() / 100L);
      ((JSONObject)localObject2).put("plugin", PluginCombination.ceilingHprofPlugin.plugin);
      paramString = new ResultObject(0, "MemoryCelling single", true, 1L, 1L, (JSONObject)localObject2, true, true, BaseInfo.userMeta.uin);
      ReporterMachine.INSTANCE.addResultObj(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      Logger.INSTANCE.exception("QAPM_memory_MemoryDumpHelper", paramString);
    }
  }
  
  @Nullable
  public static MemoryDumpHelper getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new MemoryDumpHelper();
      }
      return sInstance;
    }
    finally {}
  }
  
  public void onReport(long paramLong1, long paramLong2, String paramString)
  {
    if (!PluginController.INSTANCE.canCollect(PluginCombination.ceilingValuePlugin.plugin)) {
      return;
    }
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("vcname", paramString);
      ((JSONObject)localObject).put("singleMemory", paramLong1);
      ((JSONObject)localObject).put("threshold", paramLong2);
      paramString = new JSONObject();
      paramString.put("processname", AppInfo.obtainProcessName(BaseInfo.app));
      paramString.put("minidumpdata", localObject);
      paramString.put("plugin", PluginCombination.ceilingValuePlugin.plugin);
      if ((extraInfoMap != null) && (!extraInfoMap.isEmpty()))
      {
        localObject = extraInfoMap.keySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          paramString.put(str, extraInfoMap.get(str));
        }
      }
      paramString = new ResultObject(0, "MemoryCelling target", true, 1L, 1L, paramString, true, true, BaseInfo.userMeta.uin);
    }
    catch (JSONException paramString)
    {
      Logger.INSTANCE.exception("QAPM_memory_MemoryDumpHelper", paramString);
      return;
    }
    ReporterMachine.INSTANCE.addResultObj(paramString);
  }
  
  public void setExtraInfo(@Nullable String paramString1, @Nullable String paramString2)
  {
    if (extraInfoMap == null)
    {
      Logger.INSTANCE.d(new String[] { "QAPM_memory_MemoryDumpHelper", "extraInfoMap need init" });
      return;
    }
    if ((paramString1 == null) || (paramString2 == null))
    {
      Logger.INSTANCE.d(new String[] { "QAPM_memory_MemoryDumpHelper", "field and content must be not null" });
      return;
    }
    extraInfoMap.put(paramString1, paramString2);
  }
  
  public void startDumpingMemory(String paramString)
  {
    try
    {
      if (!canDumpMemory()) {
        return;
      }
      dump(paramString);
      return;
    }
    catch (Exception paramString)
    {
      Logger.INSTANCE.exception("QAPM_memory_MemoryDumpHelper", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.memory.MemoryDumpHelper
 * JD-Core Version:    0.7.0.1
 */