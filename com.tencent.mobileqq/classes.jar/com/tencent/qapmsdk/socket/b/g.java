package com.tencent.qapmsdk.socket.b;

import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;
import okio.ByteString;
import okio.Options;

public final class g
{
  public static final TimeZone a = TimeZone.getTimeZone("GMT");
  private static final Options b = Options.of(new ByteString[] { ByteString.decodeHex("efbbbf"), ByteString.decodeHex("feff"), ByteString.decodeHex("fffe"), ByteString.decodeHex("0000ffff"), ByteString.decodeHex("ffff0000") });
  private static final Charset c = Charset.forName("UTF-32BE");
  private static final Charset d = Charset.forName("UTF-32LE");
  private static final Method e;
  private static final Pattern f = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
  
  static
  {
    try
    {
      Method localMethod = Throwable.class.getDeclaredMethod("addSuppressed", new Class[] { Throwable.class });
      e = localMethod;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
  
  public static String a(String paramString, Object... paramVarArgs)
  {
    return String.format(Locale.US, paramString, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.b.g
 * JD-Core Version:    0.7.0.1
 */