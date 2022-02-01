package okhttp3;

import javax.annotation.Nullable;
import okio.BufferedSource;

class ResponseBody$1
  extends ResponseBody
{
  ResponseBody$1(MediaType paramMediaType, long paramLong, BufferedSource paramBufferedSource) {}
  
  public long contentLength()
  {
    return this.val$contentLength;
  }
  
  @Nullable
  public MediaType contentType()
  {
    return this.val$contentType;
  }
  
  public BufferedSource source()
  {
    return this.val$content;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     okhttp3.ResponseBody.1
 * JD-Core Version:    0.7.0.1
 */