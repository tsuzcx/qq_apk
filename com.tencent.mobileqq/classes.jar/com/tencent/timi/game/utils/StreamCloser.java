package com.tencent.timi.game.utils;

import com.tencent.qphone.base.util.QLog;
import java.io.Closeable;

public class StreamCloser
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
    catch (Exception paramCloseable)
    {
      QLog.d("StreamCloser", 4, "ignore", paramCloseable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.utils.StreamCloser
 * JD-Core Version:    0.7.0.1
 */