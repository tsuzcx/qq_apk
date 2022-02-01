package com.tencent.qapmsdk.memory.leakdetect;

import android.os.Build.VERSION;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.listener.IInspectorListener;
import com.tencent.qapmsdk.base.listener.IMemoryDumpListener;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.DumpResult;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.base.monitorplugin.PluginController;
import com.tencent.qapmsdk.base.reporter.ReporterMachine;
import com.tencent.qapmsdk.base.reporter.uploaddata.data.ResultObject;
import com.tencent.qapmsdk.common.logcat.ILogcat;
import com.tencent.qapmsdk.common.logcat.LogcatManager;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.AppInfo;
import com.tencent.qapmsdk.common.util.InspectUUID;
import com.tencent.qapmsdk.common.util.RecyclablePool;
import com.tencent.qapmsdk.memory.DumpMemInfoHandler;
import com.tencent.qapmsdk.memory.memorydump.IHeapDumper;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

public class LeakInspector
{
  private static final int CHECK_PIVOT = 5000;
  private static final String TAG = "QAPM_memory_LeakInspector";
  private static final int TIME_UNIT = 1000;
  private static boolean autoDump = false;
  private static IHeapDumper dumper = null;
  private static boolean keepUuidWhenLeaked;
  private static long lastTimeGC;
  private static LeakInspector leakInspector;
  private static int loopMaxCount = 100;
  private static RecyclablePool sPool;
  private IInspectorListener inspectorListener;
  private Handler leakHandler;
  
  static
  {
    lastTimeGC = 0L;
    keepUuidWhenLeaked = false;
  }
  
  private LeakInspector(Handler paramHandler, IInspectorListener paramIInspectorListener)
  {
    this.leakHandler = paramHandler;
    this.inspectorListener = paramIInspectorListener;
  }
  
  private static void addLogcat(List<String> paramList)
  {
    if (Build.VERSION.SDK_INT < 16)
    {
      if (!AppInfo.hasPermissions(BaseInfo.app, new String[] { "android.permission.READ_LOGS" })) {}
    }
    else
    {
      Object localObject = LogcatManager.initLogcat(1);
      ((ILogcat)localObject).setArgs(new String[] { "-t", "100", "-v", "threadtime" });
      localObject = ((ILogcat)localObject).getLogcatFile();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramList.add(localObject);
      }
    }
  }
  
  private static void doGc()
  {
    long l = System.currentTimeMillis();
    if (l - lastTimeGC >= 5000L)
    {
      System.runFinalization();
      Runtime.getRuntime().gc();
      lastTimeGC = l;
    }
  }
  
  public static DumpResult dumpMemory(String paramString, boolean paramBoolean, IMemoryDumpListener paramIMemoryDumpListener)
  {
    int i = 0;
    DumpResult localDumpResult = new DumpResult();
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramIMemoryDumpListener.onPrepareDump(paramString);
    String str = paramString + "_leak";
    if (paramBoolean)
    {
      Object localObject2 = DumpMemInfoHandler.generateHprof(paramString, dumper);
      paramIMemoryDumpListener.onHprofDumped(paramString);
      localDumpResult.success = ((Boolean)localObject2[0]).booleanValue();
      if (!localDumpResult.success) {
        break label327;
      }
      localObject2 = (String)localObject2[1];
      localDumpResult.hprofFileSize = new File((String)localObject2).length();
      localArrayList.add(localObject2);
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        localArrayList.addAll((Collection)localObject1);
      }
    }
    addLogcat(localArrayList);
    localObject1 = DumpMemInfoHandler.zipFiles(localArrayList, str);
    localDumpResult.success = ((Boolean)localObject1[0]).booleanValue();
    localObject1 = (String)localObject1[1];
    localDumpResult.zipFilePath = ((String)localObject1);
    Logger.INSTANCE.d(new String[] { "QAPM_memory_LeakInspector", "leakFlag=true", ",ZipFile=", String.valueOf(localDumpResult.success), ",leakName=", paramString, ",dumpPath=", localObject1 });
    paramIMemoryDumpListener.onFinishDump(localDumpResult.success, paramString, (String)localObject1);
    while (i < localArrayList.size())
    {
      paramString = new File((String)localArrayList.get(i));
      if ((paramString.isFile()) && (paramString.exists())) {
        paramString.delete();
      }
      i += 1;
    }
    label327:
    paramIMemoryDumpListener.onFinishDump(false, paramString, "");
    Logger.INSTANCE.e(new String[] { "QAPM_memory_LeakInspector", "generateHprof error ", paramString });
    return localDumpResult;
    return localDumpResult;
  }
  
  public static void enableAutoDump(boolean paramBoolean)
  {
    autoDump = paramBoolean;
  }
  
  @Nullable
  private InspectUUID generateInspectUuid(@NonNull Object paramObject, String paramString)
  {
    try
    {
      InspectUUID localInspectUUID = (InspectUUID)sPool.obtain(InspectUUID.class);
      if (localInspectUUID == null) {
        return null;
      }
      localInspectUUID.weakObj = new WeakReference(paramObject);
      localInspectUUID.uuid = UUID.randomUUID().toString().toCharArray();
      localInspectUUID.digest = paramString;
      localInspectUUID.className = paramObject.getClass().getSimpleName();
      return localInspectUUID;
    }
    catch (Exception paramObject) {}
    return null;
  }
  
  public static void initInspector(Handler paramHandler, IInspectorListener paramIInspectorListener)
  {
    if (leakInspector != null) {
      return;
    }
    leakInspector = new LeakInspector(paramHandler, paramIInspectorListener);
    sPool = new RecyclablePool(InspectUUID.class, 20);
  }
  
  private void newInspect(@NonNull Object paramObject, String paramString)
  {
    if (leakInspector.inspectorListener.onFilter(paramObject)) {}
    do
    {
      return;
      paramObject = generateInspectUuid(paramObject, paramString);
    } while (paramObject == null);
    paramObject = new LeakInspector.InspectorRunner(this, paramObject, 0);
    this.leakHandler.post(paramObject);
  }
  
  public static void report(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("processname", AppInfo.obtainProcessName(BaseInfo.app));
    localJSONObject.put("event_time", System.currentTimeMillis());
    localJSONObject.put("stage", paramString1);
    localJSONObject.put("fileObj", paramString2);
    localJSONObject.put("plugin", PluginCombination.leakPlugin.plugin);
    paramString1 = new ResultObject(0, "MemoryLeak single", true, 1L, 1L, localJSONObject, true, true, BaseInfo.userMeta.uin);
    ReporterMachine.INSTANCE.addResultObj(paramString1, null, false);
  }
  
  public static void setDumper(IHeapDumper paramIHeapDumper)
  {
    dumper = paramIHeapDumper;
  }
  
  public static void setKeepUuidWhenLeak(boolean paramBoolean)
  {
    keepUuidWhenLeaked = paramBoolean;
  }
  
  public static void setLooperMaxCount(int paramInt)
  {
    loopMaxCount = paramInt;
  }
  
  public static void startInspect(@NonNull Object paramObject, String paramString)
  {
    if (leakInspector == null)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_memory_LeakInspector", "Please call initInspector before this" });
      return;
    }
    if (leakInspector.inspectorListener == null)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_memory_LeakInspector", "Please init a listener first!" });
      return;
    }
    if (!PluginController.INSTANCE.whetherPluginSampling(PluginCombination.leakPlugin.plugin))
    {
      Logger.INSTANCE.i(new String[] { "QAPM_memory_LeakInspector", "leakSampleLost" });
      return;
    }
    leakInspector.newInspect(paramObject, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.memory.leakdetect.LeakInspector
 * JD-Core Version:    0.7.0.1
 */