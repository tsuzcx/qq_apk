package com.tencent.rmonitor.resource.collector;

import com.tencent.rmonitor.common.logger.Logger;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/resource/collector/NetworkCollector;", "Lcom/tencent/rmonitor/resource/collector/ResourceCollector;", "()V", "networkStatsFile", "Ljava/io/RandomAccessFile;", "getTotalBytes", "", "initFile", "", "filePath", "", "isLocalInterface", "", "ifaceHash", "", "Companion", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class NetworkCollector
  extends ResourceCollector
{
  public static final NetworkCollector.Companion a = new NetworkCollector.Companion(null);
  private RandomAccessFile c;
  
  private final void b(String paramString)
  {
    Arrays.fill(h(), (byte)-1);
    RandomAccessFile localRandomAccessFile = this.c;
    if (localRandomAccessFile != null) {
      paramString = localRandomAccessFile;
    } else {
      paramString = a(paramString);
    }
    paramString.seek(0L);
    if (paramString.read(h(), 0, h().length) != -1)
    {
      this.c = paramString;
      a(0);
      b(false);
      a(true);
      return;
    }
    throw ((Throwable)new IOException("read sys stats error"));
  }
  
  private final boolean b(int paramInt)
  {
    int j = ResourceConstant.a.c().length;
    int i = 0;
    while (i < j)
    {
      if (paramInt == ResourceConstant.a.c()[i]) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  @Nullable
  public final long[] a()
  {
    for (;;)
    {
      try
      {
        if ((!c()) || (!e())) {
          continue;
        }
        arrayOfLong = new long[4];
        Arrays.fill(arrayOfLong, 0L);
      }
      finally
      {
        long[] arrayOfLong;
        Logger localLogger;
        StringBuilder localStringBuilder;
        continue;
        throw localObject;
        continue;
        int i = 0;
        continue;
        int j = 0;
        continue;
      }
      try
      {
        b("/proc/net/xt_qtaguid/stats");
        a('\n');
        if ((!d()) && (c()) && (k()))
        {
          a(' ');
          j = j();
          a(' ');
          long l = i();
          if (j != ResourceConstant.a.b()) {
            continue;
          }
          i = 1;
          if ((i != 0) || (b(j))) {
            continue;
          }
          j = 1;
          if ((l == ResourceConstant.a.d()) && ((i != 0) || (j != 0)))
          {
            a(' ');
            arrayOfLong[0] += i();
            arrayOfLong[1] += i();
            arrayOfLong[2] += i();
            arrayOfLong[3] += i();
            a(b() + 23);
            a('\n');
          }
          else
          {
            a('\n');
          }
        }
        else
        {
          a(true);
          return arrayOfLong;
        }
      }
      catch (Exception localException)
      {
        a(true);
        a(CollectionsKt.listOf(this.c));
        localLogger = Logger.b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localException);
        localStringBuilder.append(": read stat file error.");
        localLogger.d(new String[] { "RMonitor_common_NetworkCollector", localStringBuilder.toString() });
        return null;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.resource.collector.NetworkCollector
 * JD-Core Version:    0.7.0.1
 */