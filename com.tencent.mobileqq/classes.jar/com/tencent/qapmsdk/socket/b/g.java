package com.tencent.qapmsdk.socket.b;

import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;
import okhttp3.Headers;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.ByteString;
import okio.Options;

public final class g
{
  public static final byte[] a;
  public static final String[] b;
  public static final Headers c;
  public static final ResponseBody d;
  public static final RequestBody e;
  public static final TimeZone f;
  private static final Options g;
  private static final Charset h;
  private static final Charset i;
  private static final Method j;
  private static final Pattern k;
  
  static
  {
    Object localObject = null;
    a = new byte[0];
    b = new String[0];
    c = Headers.of(new String[0]);
    d = ResponseBody.create(null, a);
    e = RequestBody.create(null, a);
    f = TimeZone.getTimeZone("GMT");
    g = Options.of(new ByteString[] { ByteString.decodeHex("efbbbf"), ByteString.decodeHex("feff"), ByteString.decodeHex("fffe"), ByteString.decodeHex("0000ffff"), ByteString.decodeHex("ffff0000") });
    h = Charset.forName("UTF-32BE");
    i = Charset.forName("UTF-32LE");
    k = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    try
    {
      Method localMethod = Throwable.class.getDeclaredMethod("addSuppressed", new Class[] { Throwable.class });
      localObject = localMethod;
    }
    catch (Exception localException)
    {
      label146:
      break label146;
    }
    j = localObject;
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