package com.tencent.rmonitor.fd.dump.dumpers;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.rmonitor.base.config.data.FdLeakPluginConfig;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.fd.FdLeakConfigHelper;
import com.tencent.rmonitor.fd.dump.FdLeakDumpResult;
import com.tencent.rmonitor.fd.utils.LogUtils;
import com.tencent.rmonitor.heapdump.HeapDumpConfig;
import com.tencent.rmonitor.heapdump.HeapDumperProvider;
import com.tencent.rmonitor.heapdump.IHeapDumpExceptionListener;
import com.tencent.rmonitor.heapdump.IHeapDumper;

public class FdHeapDumper
  extends BaseFdDumper
  implements IHeapDumpExceptionListener
{
  private final IHeapDumper a = HeapDumperProvider.a();
  
  private void c()
  {
    SharedPreferences localSharedPreferences = BaseInfo.sharePreference;
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putInt("fd_dump_exception_count", 0).apply();
    }
  }
  
  public int a()
  {
    return 3;
  }
  
  public void a(Exception paramException)
  {
    paramException = BaseInfo.sharePreference;
    if (paramException != null)
    {
      int i = paramException.getInt("fd_dump_exception_count", 0);
      paramException = paramException.edit();
      i += 1;
      paramException.putInt("fd_dump_exception_count", i).apply();
      paramException = new StringBuilder();
      paramException.append("onHeapDumpException count=");
      paramException.append(i);
      LogUtils.c("FdHeapDumper", paramException.toString());
    }
  }
  
  protected FdLeakDumpResult b(String paramString)
  {
    HeapDumpConfig localHeapDumpConfig = new HeapDumpConfig(FdLeakConfigHelper.a(), FdLeakConfigHelper.g().b);
    localHeapDumpConfig.a(this);
    int i = this.a.a(paramString, localHeapDumpConfig);
    if (i == 0)
    {
      c();
      return a(paramString, null);
    }
    return a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.dump.dumpers.FdHeapDumper
 * JD-Core Version:    0.7.0.1
 */