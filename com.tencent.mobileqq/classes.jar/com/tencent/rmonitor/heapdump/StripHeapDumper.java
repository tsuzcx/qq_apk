package com.tencent.rmonitor.heapdump;

import android.os.Debug;
import android.os.Handler;
import com.tencent.rmonitor.common.thread.ThreadManager;
import com.tencent.rmonitor.common.util.FileUtil;
import com.tencent.rmonitor.fd.utils.LogUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

abstract class StripHeapDumper
  implements IHeapDumper
{
  protected static boolean a = FileUtil.e("rmonitor_memory_dump");
  private static final String[] c = { ".*/librmonitor_memory_dump.so$", ".*/libBugly-rqd.so$" };
  private static final Map<String, String[]> d = new HashMap(2);
  private Handler b;
  
  static
  {
    d.put("open", new String[] { "libart.so" });
    d.put("write", new String[] { "libc.so", "libart.so", "libbase.so", "libartbase.so" });
  }
  
  private StripHeapDumper.HeapDumpResult a(String paramString)
  {
    try
    {
      Debug.dumpHprofData(paramString);
      paramString = new StripHeapDumper.HeapDumpResult(true, null);
      return paramString;
    }
    catch (IOException paramString)
    {
      LogUtils.a("StripHeapDumper", "dump hprof failed. ", paramString);
    }
    return new StripHeapDumper.HeapDumpResult(false, paramString);
  }
  
  private void a(int paramInt)
  {
    if (a) {
      nSetHprofStripConfig(paramInt);
    }
  }
  
  private void b(String paramString)
  {
    Object localObject = d.keySet().iterator();
    int j;
    for (;;)
    {
      boolean bool = ((Iterator)localObject).hasNext();
      j = 0;
      i = 0;
      if (!bool) {
        break;
      }
      String str = (String)((Iterator)localObject).next();
      String[] arrayOfString = (String[])d.get(str);
      j = arrayOfString.length;
      while (i < j)
      {
        nSetRegisterHookSo(arrayOfString[i], str);
        i += 1;
      }
    }
    localObject = c;
    int k = localObject.length;
    int i = j;
    while (i < k)
    {
      nSetIgnoreHookSo(localObject[i]);
      i += 1;
    }
    nEnableHprofStrip(paramString);
  }
  
  private boolean c()
  {
    return (a) && (DumpEnableChecker.c());
  }
  
  private static native void nDisableHprofStrip();
  
  private static native void nEnableHprofStrip(String paramString);
  
  private static native void nSetHprofStripConfig(int paramInt);
  
  private static native void nSetIgnoreHookSo(String paramString);
  
  private static native void nSetRegisterHookSo(String paramString1, String paramString2);
  
  protected void a(HeapDumpConfig paramHeapDumpConfig, Exception paramException)
  {
    paramHeapDumpConfig = paramHeapDumpConfig.c();
    if (paramHeapDumpConfig != null) {
      paramHeapDumpConfig.a(paramException);
    }
  }
  
  protected Handler b()
  {
    if (this.b == null) {
      this.b = new Handler(ThreadManager.g());
    }
    return this.b;
  }
  
  protected StripHeapDumper.HeapDumpResult b(String paramString, HeapDumpConfig paramHeapDumpConfig)
  {
    if ((paramHeapDumpConfig.a()) && (c()))
    {
      b(paramString);
      a(paramHeapDumpConfig.b());
    }
    paramString = a(paramString);
    if ((paramHeapDumpConfig.a()) && (c()))
    {
      nDisableHprofStrip();
      a(0);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.heapdump.StripHeapDumper
 * JD-Core Version:    0.7.0.1
 */