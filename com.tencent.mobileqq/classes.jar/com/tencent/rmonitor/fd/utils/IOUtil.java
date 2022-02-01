package com.tencent.rmonitor.fd.utils;

import java.io.Closeable;
import java.io.IOException;

public final class IOUtil
{
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        return;
      }
      catch (IOException paramCloseable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("close silently failed: ");
        localStringBuilder.append(paramCloseable.getMessage());
        LogUtils.d("IOUtil", localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.utils.IOUtil
 * JD-Core Version:    0.7.0.1
 */