package com.tencent.qapmsdk.common.resource;

import com.tencent.qapmsdk.common.logger.Logger;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/resource/NetworkCollector;", "Lcom/tencent/qapmsdk/common/resource/ResourceCollector;", "()V", "networkStatsFile", "Ljava/io/RandomAccessFile;", "getTotalBytes", "", "initFile", "", "filePath", "", "isLocalInterface", "", "ifaceHash", "", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public final class NetworkCollector
  extends ResourceCollector
{
  public static final NetworkCollector.Companion Companion = new NetworkCollector.Companion(null);
  private static final String TAG = "QAPM_common_NetworkCollector";
  private RandomAccessFile networkStatsFile;
  
  private final void initFile(String paramString)
  {
    Arrays.fill(getBufferBytes(), (byte)-1);
    RandomAccessFile localRandomAccessFile = this.networkStatsFile;
    if (localRandomAccessFile != null) {
      paramString = localRandomAccessFile;
    } else {
      paramString = openFile(paramString);
    }
    paramString.seek(0L);
    if (paramString.read(getBufferBytes(), 0, getBufferBytes().length) != -1)
    {
      this.networkStatsFile = paramString;
      setCurIndex(0);
      setReachedEof(false);
      setValid(true);
      return;
    }
    throw ((Throwable)new IOException("read sys stats error"));
  }
  
  private final boolean isLocalInterface(int paramInt)
  {
    int j = ResourceConstant.Companion.getLOCAL_IFACE_HASHES().length;
    int i = 0;
    while (i < j)
    {
      if (paramInt == ResourceConstant.Companion.getLOCAL_IFACE_HASHES()[i]) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  @Nullable
  public final long[] getTotalBytes()
  {
    for (;;)
    {
      try
      {
        if ((!isValid()) || (!getCanReadStat())) {
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
        initFile("/proc/net/xt_qtaguid/stats");
        skipPast('\n');
        if ((!getReachedEof()) && (isValid()) && (peek()))
        {
          skipPast(' ');
          j = readHash();
          skipPast(' ');
          long l = readNumber();
          if (j != ResourceConstant.Companion.getWLAN0_HASH()) {
            continue;
          }
          i = 1;
          if ((i != 0) || (isLocalInterface(j))) {
            continue;
          }
          j = 1;
          if ((l == ResourceConstant.Companion.getUID()) && ((i != 0) || (j != 0)))
          {
            skipPast(' ');
            arrayOfLong[0] += readNumber();
            arrayOfLong[1] += readNumber();
            arrayOfLong[2] += readNumber();
            arrayOfLong[3] += readNumber();
            setCurIndex(getCurIndex() + 23);
            skipPast('\n');
          }
          else
          {
            skipPast('\n');
          }
        }
        else
        {
          setValid(true);
          return arrayOfLong;
        }
      }
      catch (Exception localException)
      {
        setValid(true);
        closeFile(CollectionsKt.listOf(this.networkStatsFile));
        localLogger = Logger.INSTANCE;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localException);
        localStringBuilder.append(": read stat file error.");
        localLogger.d(new String[] { "QAPM_common_NetworkCollector", localStringBuilder.toString() });
        return null;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.common.resource.NetworkCollector
 * JD-Core Version:    0.7.0.1
 */