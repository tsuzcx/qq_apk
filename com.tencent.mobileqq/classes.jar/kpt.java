import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

class kpt
  implements HttpRequestInterceptor
{
  kpt(kpr paramkpr) {}
  
  public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    if (!paramHttpRequest.containsHeader("Accept-Encoding")) {
      paramHttpRequest.addHeader("Accept-Encoding", "gzip");
    }
    paramHttpContext = kpr.a(this.a).keySet().iterator();
    while (paramHttpContext.hasNext())
    {
      String str = (String)paramHttpContext.next();
      paramHttpRequest.addHeader(str, (String)kpr.a(this.a).get(str));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     kpt
 * JD-Core Version:    0.7.0.1
 */