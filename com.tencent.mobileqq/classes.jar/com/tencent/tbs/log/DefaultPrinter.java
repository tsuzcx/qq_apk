package com.tencent.tbs.log;

import android.util.Log;

public class DefaultPrinter
  implements LogPrinter
{
  static final int DEFAULT_MAX_CHUNK_SIZE = 2048;
  private int maxChunkSize;
  
  public DefaultPrinter()
  {
    this(2048);
  }
  
  public DefaultPrinter(int paramInt)
  {
    this.maxChunkSize = paramInt;
  }
  
  static int adjustEnd(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt2 == paramString.length()) {
      return paramInt2;
    }
    if (paramString.charAt(paramInt2) == '\n') {
      return paramInt2;
    }
    int i = paramInt2 - 1;
    while (paramInt1 < i)
    {
      if (paramString.charAt(i) == '\n') {
        return i + 1;
      }
      i -= 1;
    }
    return paramInt2;
  }
  
  public void close() {}
  
  public void println(LogItem paramLogItem)
  {
    if (paramLogItem == null) {
      return;
    }
    if (paramLogItem.msg.length() <= this.maxChunkSize)
    {
      Log.println(paramLogItem.level.getValue(), paramLogItem.tag, paramLogItem.msg);
      return;
    }
    int k = paramLogItem.msg.length();
    int j;
    for (int i = 0; i < k; i = j)
    {
      j = adjustEnd(paramLogItem.msg, i, Math.min(this.maxChunkSize + i, k));
      Log.println(paramLogItem.level.getValue(), paramLogItem.tag, paramLogItem.msg.substring(i, j));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.log.DefaultPrinter
 * JD-Core Version:    0.7.0.1
 */