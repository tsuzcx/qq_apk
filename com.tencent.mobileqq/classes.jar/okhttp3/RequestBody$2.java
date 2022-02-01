package okhttp3;

import javax.annotation.Nullable;
import okio.BufferedSink;

class RequestBody$2
  extends RequestBody
{
  RequestBody$2(MediaType paramMediaType, int paramInt1, byte[] paramArrayOfByte, int paramInt2) {}
  
  public long contentLength()
  {
    return this.val$byteCount;
  }
  
  @Nullable
  public MediaType contentType()
  {
    return this.val$contentType;
  }
  
  public void writeTo(BufferedSink paramBufferedSink)
  {
    paramBufferedSink.write(this.val$content, this.val$offset, this.val$byteCount);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.RequestBody.2
 * JD-Core Version:    0.7.0.1
 */