package com.tencent.qapmsdk.memory;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.listener.IMemoryDumpListener;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.DumpResult;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.base.monitorplugin.PluginController;
import com.tencent.qapmsdk.base.reporter.ReporterMachine;
import com.tencent.qapmsdk.base.reporter.uploaddata.data.ResultObject;
import com.tencent.qapmsdk.common.activty.ActivityInfo;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.network.NetworkWatcher;
import com.tencent.qapmsdk.common.util.AppInfo;
import com.tencent.qapmsdk.common.util.AsyncSPEditor;
import com.tencent.qapmsdk.memory.memorydump.IHeapDumper;
import java.io.File;
import java.util.ArrayList;
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
  private static IHeapDumper dumper = null;
  @NonNull
  private static HashMap<String, String> extraInfoMap = new HashMap();
  @Nullable
  private static volatile MemoryDumpHelper sInstance;
  
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
      if ((i < 1) || (MemoryCeilingMonitor.debug))
      {
        BaseInfo.editor.putInt(BaseInfo.userMeta.version, i + 1).apply();
        Logger.INSTANCE.d(new String[] { "QAPM_memory_MemoryDumpHelper", "this user don't have dumped" });
        return true;
      }
    }
    Logger.INSTANCE.d(new String[] { "QAPM_memory_MemoryDumpHelper", "this user have dumped." });
    return false;
  }
  
  static DumpResult dump(String paramString, IMemoryDumpListener paramIMemoryDumpListener)
  {
    if (paramIMemoryDumpListener != null) {
      localObject1 = paramIMemoryDumpListener.onPrepareDump(paramString);
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new ArrayList();
    }
    Object localObject3 = DumpMemInfoHandler.generateHprof(paramString, dumper);
    if (paramIMemoryDumpListener != null) {
      paramIMemoryDumpListener.onHprofDumped(paramString);
    }
    Object localObject1 = new DumpResult();
    ((DumpResult)localObject1).success = ((Boolean)localObject3[0]).booleanValue();
    if ((((DumpResult)localObject1).success) && (localObject3[1] != null))
    {
      localObject3 = (String)localObject3[1];
      if (((List)localObject2).isEmpty()) {
        Logger.INSTANCE.e(new String[] { "QAPM_memory_MemoryDumpHelper", "prepareFiles is none" });
      }
      ((List)localObject2).add(localObject3);
      ((DumpResult)localObject1).hprofFileSize = new File((String)localObject3).length();
    }
    else
    {
      Logger.INSTANCE.d(new String[] { "QAPM_memory_MemoryDumpHelper", "failed dump memory" });
    }
    localObject2 = DumpMemInfoHandler.zipFiles((List)localObject2, paramString);
    ((DumpResult)localObject1).zipFilePath = ((String)localObject2[1]);
    ((DumpResult)localObject1).success = ((Boolean)localObject2[0]).booleanValue();
    if (paramIMemoryDumpListener != null) {
      paramIMemoryDumpListener.onFinishDump(((DumpResult)localObject1).success, paramString, ((DumpResult)localObject1).zipFilePath);
    }
    return localObject1;
  }
  
  public static MemoryDumpHelper getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new MemoryDumpHelper();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  static void reportHprofFile(DumpResult paramDumpResult)
  {
    String str = ActivityInfo.getCurrentActivityName();
    if (!paramDumpResult.success)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_memory_MemoryDumpHelper", "dump other file failed!" });
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("fileObj", paramDumpResult.zipFilePath);
      localJSONObject.put("stage", str);
      localJSONObject.put("Activity", str);
      localJSONObject.put("UIN", BaseInfo.userMeta.uin);
      localJSONObject.put("Model", Build.MODEL);
      localJSONObject.put("OS", Build.VERSION.RELEASE);
      localJSONObject.put("Threshold", PluginCombination.ceilingHprofPlugin.threshold * Runtime.getRuntime().maxMemory() / 100L);
      localJSONObject.put("plugin", PluginCombination.ceilingHprofPlugin.plugin);
      paramDumpResult = new ResultObject(0, "MemoryCelling single", true, 1L, 1L, localJSONObject, true, true, BaseInfo.userMeta.uin);
      ReporterMachine.INSTANCE.addResultObj(paramDumpResult);
      return;
    }
    catch (JSONException paramDumpResult)
    {
      Logger.INSTANCE.exception("QAPM_memory_MemoryDumpHelper", paramDumpResult);
    }
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
      ReporterMachine.INSTANCE.addResultObj(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      Logger.INSTANCE.exception("QAPM_memory_MemoryDumpHelper", paramString);
    }
  }
  
  public void setDumper(IHeapDumper paramIHeapDumper)
  {
    dumper = paramIHeapDumper;
  }
  
  public void setExtraInfo(@Nullable String paramString1, @Nullable String paramString2)
  {
    HashMap localHashMap = extraInfoMap;
    if (localHashMap == null)
    {
      Logger.INSTANCE.d(new String[] { "QAPM_memory_MemoryDumpHelper", "extraInfoMap need init" });
      return;
    }
    if ((paramString1 != null) && (paramString2 != null))
    {
      localHashMap.put(paramString1, paramString2);
      return;
    }
    Logger.INSTANCE.d(new String[] { "QAPM_memory_MemoryDumpHelper", "field and content must be not null" });
  }
  
  public void startDumpingMemory(String paramString, IMemoryDumpListener paramIMemoryDumpListener)
  {
    try
    {
      if (!canDumpMemory()) {
        return;
      }
      reportHprofFile(dump(paramString, paramIMemoryDumpListener));
      return;
    }
    catch (Exception paramString)
    {
      Logger.INSTANCE.exception("QAPM_memory_MemoryDumpHelper", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.memory.MemoryDumpHelper
 * JD-Core Version:    0.7.0.1
 */