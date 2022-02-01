package okhttp3;

import java.nio.charset.Charset;
import okhttp3.internal.Util;
import okio.ByteString;

public final class Credentials
{
  public static String basic(String paramString1, String paramString2)
  {
    return basic(paramString1, paramString2, Util.ISO_8859_1);
  }
  
  public static String basic(String paramString1, String paramString2, Charset paramCharset)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(":");
    localStringBuilder.append(paramString2);
    paramString1 = ByteString.encodeString(localStringBuilder.toString(), paramCharset).base64();
    paramString2 = new StringBuilder();
    paramString2.append("Basic ");
    paramString2.append(paramString1);
    return paramString2.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.Credentials
 * JD-Core Version:    0.7.0.1
 */