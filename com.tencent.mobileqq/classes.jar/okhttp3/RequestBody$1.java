package okhttp3;

import javax.annotation.Nullable;
import okio.BufferedSink;
import okio.ByteString;

class RequestBody$1
  extends RequestBody
{
  RequestBody$1(MediaType paramMediaType, ByteString paramByteString) {}
  
  public long contentLength()
  {
    return this.val$content.size();
  }
  
  @Nullable
  public MediaType contentType()
  {
    return this.val$contentType;
  }
  
  public void writeTo(BufferedSink paramBufferedSink)
  {
    paramBufferedSink.write(this.val$content);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okhttp3.RequestBody.1
 * JD-Core Version:    0.7.0.1
 */