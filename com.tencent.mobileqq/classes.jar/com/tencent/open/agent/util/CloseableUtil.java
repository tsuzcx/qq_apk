package com.tencent.open.agent.util;

import java.io.Closeable;
import java.io.IOException;

public class CloseableUtil
{
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable == null) {
      return;
    }
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      SSOLog.c("CloseableUtil", "IOException", paramCloseable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.util.CloseableUtil
 * JD-Core Version:    0.7.0.1
 */