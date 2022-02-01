package com.tencent.rmonitor.resource.collector;

import android.annotation.SuppressLint;
import com.tencent.rmonitor.common.logger.Logger;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/resource/collector/ResourceCollector;", "", "()V", "bufferBytes", "", "getBufferBytes", "()[B", "canReadPid", "", "getCanReadPid", "()Z", "setCanReadPid", "(Z)V", "canReadStat", "getCanReadStat", "setCanReadStat", "canReadSys", "getCanReadSys", "setCanReadSys", "curChar", "", "curIndex", "getCurIndex", "()I", "setCurIndex", "(I)V", "hasPeeked", "isValid", "setValid", "reachedEof", "getReachedEof", "setReachedEof", "closeFile", "", "files", "", "Ljava/io/RandomAccessFile;", "continueSkipPast", "checkChar", "", "count", "openFile", "path", "", "peek", "read", "readHash", "readNumber", "", "skipPast", "ch", "softAssert", "test", "Companion", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public class ResourceCollector
{
  public static final ResourceCollector.Companion b = new ResourceCollector.Companion(null);
  private boolean a;
  private int c;
  private int d;
  private boolean e = true;
  private boolean f;
  private boolean g = new File("/proc/net/xt_qtaguid/stats").canRead();
  private boolean h = new File("/proc/stat").canRead();
  private boolean i = new File(ResourceConstant.a.a()).canRead();
  @NotNull
  private final byte[] j = new byte[1536];
  
  @SuppressLint({"InstanceMethodCanBeStatic"})
  @NotNull
  protected final RandomAccessFile a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    return new RandomAccessFile(paramString, "r");
  }
  
  protected final void a(char paramChar)
  {
    boolean bool = false;
    while ((!bool) && (l())) {
      if (this.c == paramChar) {
        bool = true;
      }
    }
    c(bool);
  }
  
  protected final void a(char paramChar, int paramInt)
  {
    int k = 0;
    while ((!this.f) && (this.e) && (k()) && (k < paramInt))
    {
      a(paramChar);
      k += 1;
    }
  }
  
  protected final void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  protected final void a(@NotNull List<? extends RandomAccessFile> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "files");
    this.e = false;
    paramList = ((Iterable)CollectionsKt.filterNotNull((Iterable)paramList)).iterator();
    while (paramList.hasNext())
    {
      RandomAccessFile localRandomAccessFile = (RandomAccessFile)paramList.next();
      try
      {
        localRandomAccessFile.close();
      }
      catch (IOException localIOException)
      {
        Logger localLogger = Logger.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localIOException);
        localStringBuilder.append(": can not close file.");
        localLogger.d(new String[] { "RMonitor_common_ResourceCollector", localStringBuilder.toString() });
      }
    }
  }
  
  protected final void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  protected final int b()
  {
    return this.d;
  }
  
  protected final void b(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  protected final boolean c()
  {
    return this.e;
  }
  
  protected final boolean c(boolean paramBoolean)
  {
    this.e = (paramBoolean & this.e);
    return this.e;
  }
  
  protected final boolean d()
  {
    return this.f;
  }
  
  protected final boolean e()
  {
    return this.g;
  }
  
  protected final boolean f()
  {
    return this.h;
  }
  
  protected final boolean g()
  {
    return this.i;
  }
  
  @NotNull
  protected final byte[] h()
  {
    return this.j;
  }
  
  protected final long i()
  {
    int k = 0;
    long l = 0L;
    boolean bool = false;
    while ((k == 0) && (l())) {
      if (Character.isDigit(this.c))
      {
        l = l * 10 + (this.c - 48);
        bool = true;
      }
      else
      {
        k = 1;
      }
    }
    c(bool);
    return l;
  }
  
  protected final int j()
  {
    int m = 0;
    boolean bool = false;
    int k = 0;
    while ((m == 0) && (l()))
    {
      int n = this.c;
      if (n != 32)
      {
        k = k * 31 + n;
        bool = true;
      }
      else
      {
        m = 1;
      }
    }
    c(bool);
    return k;
  }
  
  protected final boolean k()
  {
    l();
    this.a = true;
    return true ^ this.f;
  }
  
  protected final boolean l()
  {
    boolean bool2 = this.a;
    boolean bool1 = false;
    if (bool2)
    {
      this.a = false;
      return this.f ^ true;
    }
    int k = this.d;
    if (k >= 1536) {
      return false;
    }
    byte[] arrayOfByte = this.j;
    if (arrayOfByte[k] != -1) {
      k = arrayOfByte[k] & 0xFF;
    } else {
      k = -1;
    }
    this.c = k;
    this.d += 1;
    if (this.c == -1) {
      bool1 = true;
    }
    this.f = bool1;
    return this.f ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.resource.collector.ResourceCollector
 * JD-Core Version:    0.7.0.1
 */