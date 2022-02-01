package com.tencent.rmonitor.memory;

import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.DumpResult;
import com.tencent.rmonitor.base.meta.UserMeta;
import com.tencent.rmonitor.base.plugin.listener.IMemoryDumpListener;
import com.tencent.rmonitor.common.logcat.ILogcat;
import com.tencent.rmonitor.common.logcat.LogcatManager;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.network.NetworkWatcher;
import com.tencent.rmonitor.common.util.AppInfo;
import com.tencent.rmonitor.common.util.AsyncSPEditor;
import com.tencent.rmonitor.heapdump.HeapDumpConfig;
import com.tencent.rmonitor.heapdump.HeapDumperProvider;
import com.tencent.rmonitor.heapdump.IHeapDumper;
import com.tencent.rmonitor.memory.ceil.MemoryCeilingMonitor;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MemoryDumpHelper
{
  private static final IHeapDumper a = ;
  
  public static Pair<Boolean, String> a(String paramString, IHeapDumper paramIHeapDumper)
  {
    try
    {
      Object localObject1 = Logger.b;
      boolean bool2 = false;
      boolean bool1 = false;
      ((Logger)localObject1).d(new String[] { "RMonitor_memory_MemoryDumpHelper", "ReportLog dumpHprof: ", paramString });
      String str = MemoryUtils.a(System.currentTimeMillis(), "yy-MM-dd_HH.mm.ss");
      if ("mounted".equals(Environment.getExternalStorageState()))
      {
        localObject1 = new File(MemoryUtils.a());
        if (!((File)localObject1).exists()) {
          ((File)localObject1).mkdirs();
        }
        Object localObject2 = ((File)localObject1).getAbsolutePath();
        localObject1 = localObject2;
        if (!((String)localObject2).endsWith("/"))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append("/");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("dump_");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(".hprof");
        localObject1 = ((StringBuilder)localObject2).toString();
        try
        {
          long l = System.currentTimeMillis();
          if (paramIHeapDumper != null)
          {
            int i = paramIHeapDumper.a((String)localObject1, new HeapDumpConfig(false));
            if (i == 0)
            {
              bool1 = true;
              break label236;
            }
          }
          bool1 = false;
          try
          {
            label236:
            Logger.b.d(new String[] { "RMonitor_memory_MemoryDumpHelper", "dump used ", String.valueOf(System.currentTimeMillis() - l), " ms" });
            paramString = (String)localObject1;
          }
          catch (Throwable paramString) {}
          Logger.b.a("RMonitor_memory_MemoryDumpHelper", paramString);
        }
        catch (Throwable paramString) {}
        paramString = (String)localObject1;
      }
      else
      {
        paramString = "";
        bool1 = bool2;
      }
      paramString = new Pair(Boolean.valueOf(bool1), paramString);
      return paramString;
    }
    finally {}
  }
  
  public static DumpResult a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, IMemoryDumpListener paramIMemoryDumpListener)
  {
    if (paramIMemoryDumpListener != null) {
      localObject1 = paramIMemoryDumpListener.onPrepareDump(paramString1);
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new ArrayList();
    }
    Object localObject1 = new DumpResult();
    if (paramBoolean1)
    {
      Object localObject3 = a(paramString1, a);
      if (paramIMemoryDumpListener != null) {
        paramIMemoryDumpListener.onHprofDumped(paramString1);
      }
      ((DumpResult)localObject1).success = ((Boolean)((Pair)localObject3).first).booleanValue();
      if ((((DumpResult)localObject1).success) && (((Pair)localObject3).second != null))
      {
        localObject3 = (String)((Pair)localObject3).second;
        ((List)localObject2).add(localObject3);
        ((DumpResult)localObject1).hprofFileSize = new File((String)localObject3).length();
      }
      else
      {
        if (paramIMemoryDumpListener != null) {
          paramIMemoryDumpListener.onFinishDump(false, paramString1, "");
        }
        Logger.b.e(new String[] { "RMonitor_memory_MemoryDumpHelper", "generateHprof error ", paramString1 });
        return localObject1;
      }
    }
    if (paramBoolean2) {
      a((List)localObject2);
    }
    a(paramString1, paramString2, paramIMemoryDumpListener, (List)localObject2, (DumpResult)localObject1);
    return localObject1;
  }
  
  private static void a(String paramString1, String paramString2, IMemoryDumpListener paramIMemoryDumpListener, List<String> paramList, DumpResult paramDumpResult)
  {
    paramString2 = MemoryUtils.a(paramList, paramString2);
    paramDumpResult.success = ((Boolean)paramString2.first).booleanValue();
    paramDumpResult.zipFilePath = ((String)paramString2.second);
    Logger.b.d(new String[] { "RMonitor_memory_MemoryDumpHelper", "leakFlag=true", ",ZipFile=", String.valueOf(paramDumpResult.success), ",leakName=", paramString1, ",dumpPath=", paramDumpResult.zipFilePath });
    if (paramIMemoryDumpListener != null) {
      paramIMemoryDumpListener.onFinishDump(paramDumpResult.success, paramString1, paramDumpResult.zipFilePath);
    }
    paramString1 = paramList.iterator();
    while (paramString1.hasNext())
    {
      paramString2 = new File((String)paramString1.next());
      if ((paramString2.isFile()) && (paramString2.exists())) {
        paramString2.delete();
      }
    }
  }
  
  private static void a(List<String> paramList)
  {
    if (Build.VERSION.SDK_INT < 16)
    {
      if (!AppInfo.a(BaseInfo.app, new String[] { "android.permission.READ_LOGS" })) {}
    }
    else
    {
      Object localObject = LogcatManager.a(1);
      ((ILogcat)localObject).a(new String[] { "-t", "100", "-v", "threadtime" });
      localObject = ((ILogcat)localObject).a();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramList.add(localObject);
      }
    }
  }
  
  public static boolean a()
  {
    if (!NetworkWatcher.a.b())
    {
      Logger.b.d(new String[] { "RMonitor_memory_MemoryDumpHelper", "network is not wifi, don't dump" });
      return false;
    }
    if ((BaseInfo.sharePreference != null) && (BaseInfo.editor != null))
    {
      int i = BaseInfo.sharePreference.getInt(BaseInfo.userMeta.version, 0);
      if ((i < 1) || (MemoryCeilingMonitor.a))
      {
        BaseInfo.editor.a(BaseInfo.userMeta.version, i + 1).b();
        Logger.b.d(new String[] { "RMonitor_memory_MemoryDumpHelper", "this user don't have dumped" });
        return true;
      }
    }
    Logger.b.d(new String[] { "RMonitor_memory_MemoryDumpHelper", "this user have dumped." });
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.memory.MemoryDumpHelper
 * JD-Core Version:    0.7.0.1
 */