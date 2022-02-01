package com.tencent.qqperf.monitor.memory;

import com.tencent.qapmsdk.base.listener.IMemoryCellingListener;
import com.tencent.qapmsdk.memory.DumpMemInfoHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.MagnifierSDK;
import com.tencent.qqperf.monitor.base.IAPMModuleLeak;
import com.tencent.qqperf.opt.clearmemory.MemoryReporter;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class QAPMMemCellingListener
  implements IMemoryCellingListener
{
  static void a(long paramLong)
  {
    MagnifierSDK.b().c().a("LowMemory", null, paramLong);
  }
  
  public void onBeforeUpload()
  {
    QLog.i("QAPM_QQ_Impl", 1, "Celling onBeforeUploadJson");
  }
  
  public boolean onCanDump(long paramLong)
  {
    a(paramLong);
    return false;
  }
  
  public void onFinishDump(boolean paramBoolean, @NotNull String paramString1, @NotNull String paramString2) {}
  
  public void onHprofDumped(@NotNull String paramString) {}
  
  public void onLowMemory(long paramLong)
  {
    MemoryReporter.a().a(paramLong);
  }
  
  @NotNull
  public List<String> onPrepareDump(@NotNull String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = DumpMemInfoHandler.generateHprof(paramString, null);
    boolean bool = ((Boolean)paramString[0]).booleanValue();
    if ((bool) && (paramString[1] != null)) {
      localArrayList.add((String)paramString[1]);
    }
    paramString = new StringBuilder();
    paramString.append("Celling onBeforeDump ");
    paramString.append(bool);
    QLog.i("QAPM_QQ_Impl", 1, paramString.toString());
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.memory.QAPMMemCellingListener
 * JD-Core Version:    0.7.0.1
 */