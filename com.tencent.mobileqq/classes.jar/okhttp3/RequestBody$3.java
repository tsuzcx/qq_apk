package okhttp3;

import java.io.File;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

class RequestBody$3
  extends RequestBody
{
  RequestBody$3(MediaType paramMediaType, File paramFile) {}
  
  public long contentLength()
  {
    return this.val$file.length();
  }
  
  @Nullable
  public MediaType contentType()
  {
    return this.val$contentType;
  }
  
  public void writeTo(BufferedSink paramBufferedSink)
  {
    Object localObject = null;
    try
    {
      Source localSource = Okio.source(this.val$file);
      localObject = localSource;
      paramBufferedSink.writeAll(localSource);
      return;
    }
    finally
    {
      Util.closeQuietly(localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.RequestBody.3
 * JD-Core Version:    0.7.0.1
 */