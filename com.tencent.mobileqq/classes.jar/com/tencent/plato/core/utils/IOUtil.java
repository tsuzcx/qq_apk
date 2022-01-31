package com.tencent.plato.core.utils;

import java.io.Closeable;

public class IOUtil
{
  public static void close(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Exception paramCloseable)
    {
      PLog.e("IOUtil", "IOUtil close Exception: " + paramCloseable.getMessage(), paramCloseable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.core.utils.IOUtil
 * JD-Core Version:    0.7.0.1
 */