import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

public class jbw
  extends HttpEntityWrapper
{
  public jbw(HttpEntity paramHttpEntity)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     jbw
 * JD-Core Version:    0.7.0.1
 */