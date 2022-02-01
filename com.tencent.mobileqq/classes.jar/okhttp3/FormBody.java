package okhttp3;

import java.util.List;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;

public final class FormBody
  extends RequestBody
{
  private static final MediaType CONTENT_TYPE = MediaType.get("application/x-www-form-urlencoded");
  private final List<String> encodedNames;
  private final List<String> encodedValues;
  
  FormBody(List<String> paramList1, List<String> paramList2)
  {
    this.encodedNames = Util.immutableList(paramList1);
    this.encodedValues = Util.immutableList(paramList2);
  }
  
  private long writeOrCountBytes(@Nullable BufferedSink paramBufferedSink, boolean paramBoolean)
  {
    long l = 0L;
    if (paramBoolean) {}
    for (paramBufferedSink = new Buffer();; paramBufferedSink = paramBufferedSink.buffer())
    {
      int j = this.encodedNames.size();
      int i = 0;
      while (i < j)
      {
        if (i > 0) {
          paramBufferedSink.writeByte(38);
        }
        paramBufferedSink.writeUtf8((String)this.encodedNames.get(i));
        paramBufferedSink.writeByte(61);
        paramBufferedSink.writeUtf8((String)this.encodedValues.get(i));
        i += 1;
      }
    }
    if (paramBoolean)
    {
      l = paramBufferedSink.size();
      paramBufferedSink.clear();
    }
    return l;
  }
  
  public long contentLength()
  {
    return writeOrCountBytes(null, true);
  }
  
  public MediaType contentType()
  {
    return CONTENT_TYPE;
  }
  
  public String encodedName(int paramInt)
  {
    return (String)this.encodedNames.get(paramInt);
  }
  
  public String encodedValue(int paramInt)
  {
    return (String)this.encodedValues.get(paramInt);
  }
  
  public String name(int paramInt)
  {
    return HttpUrl.percentDecode(encodedName(paramInt), true);
  }
  
  public int size()
  {
    return this.encodedNames.size();
  }
  
  public String value(int paramInt)
  {
    return HttpUrl.percentDecode(encodedValue(paramInt), true);
  }
  
  public void writeTo(BufferedSink paramBufferedSink)
  {
    writeOrCountBytes(paramBufferedSink, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     okhttp3.FormBody
 * JD-Core Version:    0.7.0.1
 */