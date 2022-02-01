package okhttp3;

import java.io.File;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.ByteString;

public abstract class RequestBody
{
  public static RequestBody create(@Nullable MediaType paramMediaType, File paramFile)
  {
    if (paramFile != null) {
      return new RequestBody.3(paramMediaType, paramFile);
    }
    throw new NullPointerException("file == null");
  }
  
  public static RequestBody create(@Nullable MediaType paramMediaType, String paramString)
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
    return create((MediaType)localObject2, paramString.getBytes((Charset)localObject1));
  }
  
  public static RequestBody create(@Nullable MediaType paramMediaType, ByteString paramByteString)
  {
    return new RequestBody.1(paramMediaType, paramByteString);
  }
  
  public static RequestBody create(@Nullable MediaType paramMediaType, byte[] paramArrayOfByte)
  {
    return create(paramMediaType, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static RequestBody create(@Nullable MediaType paramMediaType, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte != null)
    {
      Util.checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
      return new RequestBody.2(paramMediaType, paramInt2, paramArrayOfByte, paramInt1);
    }
    throw new NullPointerException("content == null");
  }
  
  public long contentLength()
  {
    return -1L;
  }
  
  @Nullable
  public abstract MediaType contentType();
  
  public abstract void writeTo(BufferedSink paramBufferedSink);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.RequestBody
 * JD-Core Version:    0.7.0.1
 */