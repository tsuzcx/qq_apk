package com.tencent.qapmsdk.common.resource;

import android.annotation.SuppressLint;
import com.tencent.qapmsdk.common.logger.Logger;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/resource/ResourceCollector;", "", "()V", "bufferBytes", "", "getBufferBytes", "()[B", "canReadPid", "", "getCanReadPid", "()Z", "setCanReadPid", "(Z)V", "canReadStat", "getCanReadStat", "setCanReadStat", "canReadSys", "getCanReadSys", "setCanReadSys", "curChar", "", "curIndex", "getCurIndex", "()I", "setCurIndex", "(I)V", "hasPeeked", "isValid", "setValid", "reachedEof", "getReachedEof", "setReachedEof", "closeFile", "", "files", "", "Ljava/io/RandomAccessFile;", "continueSkipPast", "checkChar", "", "count", "openFile", "path", "", "peek", "read", "readHash", "readNumber", "", "skipPast", "ch", "softAssert", "test", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public class ResourceCollector
{
  private static final int BUFFER_LEN = 1536;
  public static final ResourceCollector.Companion Companion = new ResourceCollector.Companion(null);
  private static final String TAG = "QAPM_common_ResourceCollector";
  @NotNull
  private final byte[] bufferBytes = new byte[1536];
  private boolean canReadPid = new File(ResourceConstant.Companion.getPID_STATS_PATH()).canRead();
  private boolean canReadStat = new File("/proc/net/xt_qtaguid/stats").canRead();
  private boolean canReadSys = new File("/proc/stat").canRead();
  private int curChar;
  private int curIndex;
  private boolean hasPeeked;
  private boolean isValid = true;
  private boolean reachedEof;
  
  protected final void closeFile(@NotNull List<? extends RandomAccessFile> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "files");
    this.isValid = false;
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
        Logger localLogger = Logger.INSTANCE;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localIOException);
        localStringBuilder.append(": can not close file.");
        localLogger.d(new String[] { "QAPM_common_ResourceCollector", localStringBuilder.toString() });
      }
    }
  }
  
  protected final void continueSkipPast(char paramChar, int paramInt)
  {
    int i = 0;
    while ((!this.reachedEof) && (this.isValid) && (peek()) && (i < paramInt))
    {
      skipPast(paramChar);
      i += 1;
    }
  }
  
  @NotNull
  protected final byte[] getBufferBytes()
  {
    return this.bufferBytes;
  }
  
  protected final boolean getCanReadPid()
  {
    return this.canReadPid;
  }
  
  protected final boolean getCanReadStat()
  {
    return this.canReadStat;
  }
  
  protected final boolean getCanReadSys()
  {
    return this.canReadSys;
  }
  
  protected final int getCurIndex()
  {
    return this.curIndex;
  }
  
  protected final boolean getReachedEof()
  {
    return this.reachedEof;
  }
  
  protected final boolean isValid()
  {
    return this.isValid;
  }
  
  @SuppressLint({"InstanceMethodCanBeStatic"})
  @NotNull
  protected final RandomAccessFile openFile(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    return new RandomAccessFile(paramString, "r");
  }
  
  protected final boolean peek()
  {
    read();
    this.hasPeeked = true;
    return true ^ this.reachedEof;
  }
  
  protected final boolean read()
  {
    boolean bool2 = this.hasPeeked;
    boolean bool1 = false;
    if (bool2)
    {
      this.hasPeeked = false;
      return this.reachedEof ^ true;
    }
    int i = this.curIndex;
    if (i >= 1536) {
      return false;
    }
    byte[] arrayOfByte = this.bufferBytes;
    if (arrayOfByte[i] != -1) {
      i = arrayOfByte[i] & 0xFF;
    } else {
      i = -1;
    }
    this.curChar = i;
    this.curIndex += 1;
    if (this.curChar == -1) {
      bool1 = true;
    }
    this.reachedEof = bool1;
    return this.reachedEof ^ true;
  }
  
  protected final int readHash()
  {
    int j = 0;
    boolean bool = false;
    int i = 0;
    while ((j == 0) && (read()))
    {
      int k = this.curChar;
      if (k != 32)
      {
        i = i * 31 + k;
        bool = true;
      }
      else
      {
        j = 1;
      }
    }
    softAssert(bool);
    return i;
  }
  
  protected final long readNumber()
  {
    int i = 0;
    long l = 0L;
    boolean bool = false;
    while ((i == 0) && (read())) {
      if (Character.isDigit(this.curChar))
      {
        l = l * 10 + (this.curChar - 48);
        bool = true;
      }
      else
      {
        i = 1;
      }
    }
    softAssert(bool);
    return l;
  }
  
  protected final void setCanReadPid(boolean paramBoolean)
  {
    this.canReadPid = paramBoolean;
  }
  
  protected final void setCanReadStat(boolean paramBoolean)
  {
    this.canReadStat = paramBoolean;
  }
  
  protected final void setCanReadSys(boolean paramBoolean)
  {
    this.canReadSys = paramBoolean;
  }
  
  protected final void setCurIndex(int paramInt)
  {
    this.curIndex = paramInt;
  }
  
  protected final void setReachedEof(boolean paramBoolean)
  {
    this.reachedEof = paramBoolean;
  }
  
  protected final void setValid(boolean paramBoolean)
  {
    this.isValid = paramBoolean;
  }
  
  protected final void skipPast(char paramChar)
  {
    boolean bool = false;
    while ((!bool) && (read())) {
      if (this.curChar == paramChar) {
        bool = true;
      }
    }
    softAssert(bool);
  }
  
  protected final boolean softAssert(boolean paramBoolean)
  {
    this.isValid = (paramBoolean & this.isValid);
    return this.isValid;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.common.resource.ResourceCollector
 * JD-Core Version:    0.7.0.1
 */