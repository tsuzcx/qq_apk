package com.tencent.rmonitor.heapdump;

import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.fd.report.FdLeakAttaReporter;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

public class StandardHeapDumper
  extends StripHeapDumper
{
  public int a(String paramString, @NotNull HeapDumpConfig paramHeapDumpConfig)
  {
    Logger.b.i(new String[] { "StandardHeapDumper", "standard dumper dump start." });
    paramString = b(paramString, paramHeapDumpConfig);
    Logger localLogger = Logger.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("standard dumper dump result: ");
    localStringBuilder.append(paramString);
    localLogger.i(new String[] { "StandardHeapDumper", localStringBuilder.toString() });
    if (!paramString.a)
    {
      a(paramHeapDumpConfig, paramString.b);
      FdLeakAttaReporter.a(107, false, paramString.b.getMessage());
      return 107;
    }
    return 0;
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.heapdump.StandardHeapDumper
 * JD-Core Version:    0.7.0.1
 */