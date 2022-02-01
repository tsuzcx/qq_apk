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
    if ((SDK_INT != 19) && (SDK_INT != 20)) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          paramHttpURLConnection = paramHttpURLConnection.getInputStream();
          if (paramLong != -1L) {
            break label99;
          }
          if (paramHttpURLConnection.read() == -1) {}
        }
        catch (IOException paramHttpURLConnection)
        {
          do
          {
            Object localObject;
            return;
          } while (paramLong > 2048L);
          return;
        }
        catch (Exception paramHttpURLConnection) {}
      }
      localObject = paramHttpURLConnection.getClass().getName();
    } while ((!((String)localObject).equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream")) && (!((String)localObject).equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")));
    localObject = paramHttpURLConnection.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
    ((Method)localObject).setAccessible(true);
    ((Method)localObject).invoke(paramHttpURLConnection, new Object[0]);
    return;
    label99:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.util.Util
 * JD-Core Version:    0.7.0.1
 */