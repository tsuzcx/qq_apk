package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

public abstract class ResponseBody
  implements Closeable
{
  @Nullable
  private Reader reader;
  
  private Charset charset()
  {
    MediaType localMediaType = contentType();
    if (localMediaType != null) {
      return localMediaType.charset(Util.UTF_8);
    }
    return Util.UTF_8;
  }
  
  public static ResponseBody create(@Nullable MediaType paramMediaType, long paramLong, BufferedSource paramBufferedSource)
  {
    if (paramBufferedSource == null) {
      throw new NullPointerException("source == null");
    }
    return new ResponseBody.1(paramMediaType, paramLong, paramBufferedSource);
  }
  
  public static ResponseBody create(@Nullable MediaType paramMediaType, String paramString)
  {
    Object localObject = Util.UTF_8;
    MediaType localMediaType = paramMediaType;
    if (paramMediaType != null)
    {
      Charset localCharset = paramMediaType.charset();
      localObject = localCharset;
      localMediaType = paramMediaType;
      if (localCharset == null)
      {
        localObject = Util.UTF_8;
        localMediaType = MediaType.parse(paramMediaType + "; charset=utf-8");
      }
    }
    paramMediaType = new Buffer().writeString(paramString, (Charset)localObject);
    return create(localMediaType, paramMediaType.size(), paramMediaType);
  }
  
  public static ResponseBody create(@Nullable MediaType paramMediaType, ByteString paramByteString)
  {
    Buffer localBuffer = new Buffer().write(paramByteString);
    return create(paramMediaType, paramByteString.size(), localBuffer);
  }
  
  public static ResponseBody create(@Nullable MediaType paramMediaType, byte[] paramArrayOfByte)
  {
    Buffer localBuffer = new Buffer().write(paramArrayOfByte);
    return create(paramMediaType, paramArrayOfByte.length, localBuffer);
  }
  
  public final InputStream byteStream()
  {
    return source().inputStream();
  }
  
  public final byte[] bytes()
  {
    long l = contentLength();
    if (l > 2147483647L) {
      throw new IOException("Cannot buffer entire body for content length: " + l);
    }
    BufferedSource localBufferedSource = source();
    try
    {
      byte[] arrayOfByte1 = localBufferedSource.readByteArray();
      Util.closeQuietly(localBufferedSource);
      if ((l != -1L) && (l != arrayOfByte1.length)) {
        throw new IOException("Content-Length (" + l + ") and stream length (" + arrayOfByte1.length + ") disagree");
      }
    }
    finally
    {
      Util.closeQuietly(localBufferedSource);
    }
    return arrayOfByte2;
  }
  
  public final Reader charStream()
  {
    Object localObject = this.reader;
    if (localObject != null) {
      return localObject;
    }
    localObject = new ResponseBody.BomAwareReader(source(), charset());
    this.reader = ((Reader)localObject);
    return localObject;
  }
  
  public void close()
  {
    Util.closeQuietly(source());
  }
  
  public abstract long contentLength();
  
  @Nullable
  public abstract MediaType contentType();
  
  public abstract BufferedSource source();
  
  public final String string()
  {
    BufferedSource localBufferedSource = source();
    try
    {
      String str = localBufferedSource.readString(Util.bomAwareCharset(localBufferedSource, charset()));
      return str;
    }
    finally
    {
      Util.closeQuietly(localBufferedSource);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okhttp3.ResponseBody
 * JD-Core Version:    0.7.0.1
 */