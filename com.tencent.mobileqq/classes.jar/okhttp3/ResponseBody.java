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
    if (paramBufferedSource != null) {
      return new ResponseBody.1(paramMediaType, paramLong, paramBufferedSource);
    }
    throw new NullPointerException("source == null");
  }
  
  public static ResponseBody create(@Nullable MediaType paramMediaType, String paramString)
  {
    Object localObject1 = Util.UTF_8;
    Object localObject2 = paramMediaType;
    if (paramMediaType != null)
    {
      Charset localCharset = paramMediaType.charset();
      localObject1 = localCharset;
      localObject2 = paramMediaType;
      if (localCharset == null)
      {
        localObject1 = Util.UTF_8;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramMediaType);
        ((StringBuilder)localObject2).append("; charset=utf-8");
        localObject2 = MediaType.parse(((StringBuilder)localObject2).toString());
      }
    }
    paramMediaType = new Buffer().writeString(paramString, (Charset)localObject1);
    return create((MediaType)localObject2, paramMediaType.size(), paramMediaType);
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
    if (l <= 2147483647L)
    {
      localObject1 = source();
      try
      {
        byte[] arrayOfByte = ((BufferedSource)localObject1).readByteArray();
        Util.closeQuietly((Closeable)localObject1);
        if (l != -1L)
        {
          if (l == arrayOfByte.length) {
            return arrayOfByte;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Content-Length (");
          ((StringBuilder)localObject1).append(l);
          ((StringBuilder)localObject1).append(") and stream length (");
          ((StringBuilder)localObject1).append(arrayOfByte.length);
          ((StringBuilder)localObject1).append(") disagree");
          throw new IOException(((StringBuilder)localObject1).toString());
        }
        return arrayOfByte;
      }
      finally
      {
        Util.closeQuietly((Closeable)localObject1);
      }
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Cannot buffer entire body for content length: ");
    ((StringBuilder)localObject1).append(l);
    throw new IOException(((StringBuilder)localObject1).toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.ResponseBody
 * JD-Core Version:    0.7.0.1
 */