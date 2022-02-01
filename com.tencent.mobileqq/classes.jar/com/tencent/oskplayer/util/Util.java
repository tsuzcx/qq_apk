package com.tencent.oskplayer.util;

import android.os.Build.VERSION;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;

public final class Util
{
  private static final long MAX_BYTES_TO_DRAIN = 2048L;
  public static final int SDK_INT = Build.VERSION.SDK_INT;
  
  public static void maybeTerminateInputStream(HttpURLConnection paramHttpURLConnection, long paramLong)
  {
    int i = SDK_INT;
    if ((i != 19) && (i != 20)) {
      return;
    }
    do
    {
      try
      {
        paramHttpURLConnection = paramHttpURLConnection.getInputStream();
        if (paramLong == -1L)
        {
          if (paramHttpURLConnection.read() == -1) {
            return;
          }
          Object localObject = paramHttpURLConnection.getClass().getName();
          if ((((String)localObject).equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream")) || (((String)localObject).equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")))
          {
            localObject = paramHttpURLConnection.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
            ((Method)localObject).setAccessible(true);
            ((Method)localObject).invoke(paramHttpURLConnection, new Object[0]);
          }
          return;
        }
      }
      catch (IOException|Exception paramHttpURLConnection)
      {
        return;
      }
    } while (paramLong > 2048L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.util.Util
 * JD-Core Version:    0.7.0.1
 */