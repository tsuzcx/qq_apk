import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

class kzn
  extends HttpEntityWrapper
{
  public kzn(HttpEntity paramHttpEntity)
  {
    super(paramHttpEntity);
  }
  
  public InputStream getContent()
  {
    return new GZIPInputStream(this.wrappedEntity.getContent());
  }
  
  public long getContentLength()
  {
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kzn
 * JD-Core Version:    0.7.0.1
 */