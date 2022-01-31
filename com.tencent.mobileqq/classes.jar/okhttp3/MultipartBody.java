package okhttp3;

import java.util.List;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

public final class MultipartBody
  extends RequestBody
{
  public static final MediaType ALTERNATIVE;
  private static final byte[] COLONSPACE = { 58, 32 };
  private static final byte[] CRLF = { 13, 10 };
  private static final byte[] DASHDASH = { 45, 45 };
  public static final MediaType DIGEST;
  public static final MediaType FORM;
  public static final MediaType MIXED = MediaType.get("multipart/mixed");
  public static final MediaType PARALLEL;
  private final ByteString boundary;
  private long contentLength = -1L;
  private final MediaType contentType;
  private final MediaType originalType;
  private final List<MultipartBody.Part> parts;
  
  static
  {
    ALTERNATIVE = MediaType.get("multipart/alternative");
    DIGEST = MediaType.get("multipart/digest");
    PARALLEL = MediaType.get("multipart/parallel");
    FORM = MediaType.get("multipart/form-data");
  }
  
  MultipartBody(ByteString paramByteString, MediaType paramMediaType, List<MultipartBody.Part> paramList)
  {
    this.boundary = paramByteString;
    this.originalType = paramMediaType;
    this.contentType = MediaType.get(paramMediaType + "; boundary=" + paramByteString.utf8());
    this.parts = Util.immutableList(paramList);
  }
  
  static StringBuilder appendQuotedString(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append('"');
    int i = 0;
    int j = paramString.length();
    if (i < j)
    {
      char c = paramString.charAt(i);
      switch (c)
      {
      default: 
        paramStringBuilder.append(c);
      }
      for (;;)
      {
        i += 1;
        break;
        paramStringBuilder.append("%0A");
        continue;
        paramStringBuilder.append("%0D");
        continue;
        paramStringBuilder.append("%22");
      }
    }
    paramStringBuilder.append('"');
    return paramStringBuilder;
  }
  
  private long writeOrCountBytes(@Nullable BufferedSink paramBufferedSink, boolean paramBoolean)
  {
    long l1 = 0L;
    if (paramBoolean) {
      paramBufferedSink = new Buffer();
    }
    for (BufferedSink localBufferedSink = paramBufferedSink;; localBufferedSink = null)
    {
      int k = this.parts.size();
      int i = 0;
      Object localObject2;
      if (i < k)
      {
        localObject2 = (MultipartBody.Part)this.parts.get(i);
        Object localObject1 = ((MultipartBody.Part)localObject2).headers;
        localObject2 = ((MultipartBody.Part)localObject2).body;
        paramBufferedSink.write(DASHDASH);
        paramBufferedSink.write(this.boundary);
        paramBufferedSink.write(CRLF);
        if (localObject1 != null)
        {
          int j = 0;
          int m = ((Headers)localObject1).size();
          while (j < m)
          {
            paramBufferedSink.writeUtf8(((Headers)localObject1).name(j)).write(COLONSPACE).writeUtf8(((Headers)localObject1).value(j)).write(CRLF);
            j += 1;
          }
        }
        localObject1 = ((RequestBody)localObject2).contentType();
        if (localObject1 != null) {
          paramBufferedSink.writeUtf8("Content-Type: ").writeUtf8(((MediaType)localObject1).toString()).write(CRLF);
        }
        l2 = ((RequestBody)localObject2).contentLength();
        if (l2 != -1L) {
          paramBufferedSink.writeUtf8("Content-Length: ").writeDecimalLong(l2).write(CRLF);
        }
        while (!paramBoolean)
        {
          paramBufferedSink.write(CRLF);
          if (!paramBoolean) {
            break label304;
          }
          l1 += l2;
          paramBufferedSink.write(CRLF);
          i += 1;
          break;
        }
        localBufferedSink.clear();
        l2 = -1L;
      }
      label304:
      do
      {
        return l2;
        ((RequestBody)localObject2).writeTo(paramBufferedSink);
        break;
        paramBufferedSink.write(DASHDASH);
        paramBufferedSink.write(this.boundary);
        paramBufferedSink.write(DASHDASH);
        paramBufferedSink.write(CRLF);
        l2 = l1;
      } while (!paramBoolean);
      long l2 = localBufferedSink.size();
      localBufferedSink.clear();
      return l1 + l2;
    }
  }
  
  public String boundary()
  {
    return this.boundary.utf8();
  }
  
  public long contentLength()
  {
    long l = this.contentLength;
    if (l != -1L) {
      return l;
    }
    l = writeOrCountBytes(null, true);
    this.contentLength = l;
    return l;
  }
  
  public MediaType contentType()
  {
    return this.contentType;
  }
  
  public MultipartBody.Part part(int paramInt)
  {
    return (MultipartBody.Part)this.parts.get(paramInt);
  }
  
  public List<MultipartBody.Part> parts()
  {
    return this.parts;
  }
  
  public int size()
  {
    return this.parts.size();
  }
  
  public MediaType type()
  {
    return this.originalType;
  }
  
  public void writeTo(BufferedSink paramBufferedSink)
  {
    writeOrCountBytes(paramBufferedSink, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okhttp3.MultipartBody
 * JD-Core Version:    0.7.0.1
 */