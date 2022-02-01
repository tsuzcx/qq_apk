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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMediaType);
    localStringBuilder.append("; boundary=");
    localStringBuilder.append(paramByteString.utf8());
    this.contentType = MediaType.get(localStringBuilder.toString());
    this.parts = Util.immutableList(paramList);
  }
  
  static StringBuilder appendQuotedString(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append('"');
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      char c = paramString.charAt(i);
      if (c != '\n')
      {
        if (c != '\r')
        {
          if (c != '"') {
            paramStringBuilder.append(c);
          } else {
            paramStringBuilder.append("%22");
          }
        }
        else {
          paramStringBuilder.append("%0D");
        }
      }
      else {
        paramStringBuilder.append("%0A");
      }
      i += 1;
    }
    paramStringBuilder.append('"');
    return paramStringBuilder;
  }
  
  private long writeOrCountBytes(@Nullable BufferedSink paramBufferedSink, boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    if (paramBoolean)
    {
      localObject1 = new Buffer();
      paramBufferedSink = (BufferedSink)localObject1;
    }
    else
    {
      localObject2 = null;
      localObject1 = paramBufferedSink;
      paramBufferedSink = (BufferedSink)localObject2;
    }
    int k = this.parts.size();
    long l1 = 0L;
    int i = 0;
    while (i < k)
    {
      Object localObject3 = (MultipartBody.Part)this.parts.get(i);
      localObject2 = ((MultipartBody.Part)localObject3).headers;
      localObject3 = ((MultipartBody.Part)localObject3).body;
      ((BufferedSink)localObject1).write(DASHDASH);
      ((BufferedSink)localObject1).write(this.boundary);
      ((BufferedSink)localObject1).write(CRLF);
      if (localObject2 != null)
      {
        int m = ((Headers)localObject2).size();
        int j = 0;
        while (j < m)
        {
          ((BufferedSink)localObject1).writeUtf8(((Headers)localObject2).name(j)).write(COLONSPACE).writeUtf8(((Headers)localObject2).value(j)).write(CRLF);
          j += 1;
        }
      }
      localObject2 = ((RequestBody)localObject3).contentType();
      if (localObject2 != null) {
        ((BufferedSink)localObject1).writeUtf8("Content-Type: ").writeUtf8(((MediaType)localObject2).toString()).write(CRLF);
      }
      l2 = ((RequestBody)localObject3).contentLength();
      if (l2 != -1L)
      {
        ((BufferedSink)localObject1).writeUtf8("Content-Length: ").writeDecimalLong(l2).write(CRLF);
      }
      else if (paramBoolean)
      {
        paramBufferedSink.clear();
        return -1L;
      }
      ((BufferedSink)localObject1).write(CRLF);
      if (paramBoolean) {
        l1 += l2;
      } else {
        ((RequestBody)localObject3).writeTo((BufferedSink)localObject1);
      }
      ((BufferedSink)localObject1).write(CRLF);
      i += 1;
    }
    ((BufferedSink)localObject1).write(DASHDASH);
    ((BufferedSink)localObject1).write(this.boundary);
    ((BufferedSink)localObject1).write(DASHDASH);
    ((BufferedSink)localObject1).write(CRLF);
    long l2 = l1;
    if (paramBoolean)
    {
      l2 = l1 + paramBufferedSink.size();
      paramBufferedSink.clear();
    }
    return l2;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.MultipartBody
 * JD-Core Version:    0.7.0.1
 */