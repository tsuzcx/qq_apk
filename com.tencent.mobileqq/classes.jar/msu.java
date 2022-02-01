import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.DefaultHttpRoutePlanner;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;

public class msu
{
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = null;
    try
    {
      HttpClient localHttpClient = a(false);
      localObject = localHttpClient;
      paramString1 = new HttpPost(paramString1);
      localObject = localHttpClient;
      paramString1.setEntity(new StringEntity(paramString2, "utf8"));
      localObject = localHttpClient;
      paramString1.setHeader("Content-Type", "application/text");
      if (paramString3 != null)
      {
        localObject = localHttpClient;
        paramString1.setHeader("Cookie", paramString3);
      }
      localObject = localHttpClient;
      paramString1 = EntityUtils.toString(localHttpClient.execute(paramString1).getEntity());
      return paramString1;
    }
    finally
    {
      if (localObject != null) {
        localObject.getConnectionManager().shutdown();
      }
    }
  }
  
  public static HttpClient a(boolean paramBoolean)
  {
    Object localObject2 = new BasicHttpParams();
    HttpConnectionParams.setStaleCheckingEnabled((HttpParams)localObject2, false);
    HttpConnectionParams.setConnectionTimeout((HttpParams)localObject2, 5000);
    HttpConnectionParams.setTcpNoDelay((HttpParams)localObject2, true);
    HttpConnectionParams.setSoTimeout((HttpParams)localObject2, 10000);
    HttpConnectionParams.setSocketBufferSize((HttpParams)localObject2, 8192);
    HttpProtocolParams.setVersion((HttpParams)localObject2, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setUserAgent((HttpParams)localObject2, "randchat");
    Object localObject1 = new SchemeRegistry();
    ((SchemeRegistry)localObject1).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    try
    {
      ((SchemeRegistry)localObject1).register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
      label99:
      if (paramBoolean) {}
      for (localObject1 = new ThreadSafeClientConnManager((HttpParams)localObject2, (SchemeRegistry)localObject1);; localObject1 = new SingleClientConnManager((HttpParams)localObject2, (SchemeRegistry)localObject1))
      {
        localObject2 = new DefaultHttpClient((ClientConnectionManager)localObject1, (HttpParams)localObject2);
        ((DefaultHttpClient)localObject2).setRoutePlanner(new DefaultHttpRoutePlanner(((ClientConnectionManager)localObject1).getSchemeRegistry()));
        return localObject2;
      }
    }
    catch (Exception localException)
    {
      break label99;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     msu
 * JD-Core Version:    0.7.0.1
 */