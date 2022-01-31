import android.content.Context;
import android.os.Build.VERSION;
import android.util.Pair;
import com.rookery.asyncHttpClient.AsyncHttpRequest;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.security.KeyStore;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpVersion;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;

public class lce
{
  private static int jdField_a_of_type_Int = 6;
  private static String jdField_a_of_type_JavaLangString = "UTF-8";
  private static int jdField_b_of_type_Int = 10000;
  private final Map<Context, List<WeakReference<Future<?>>>> jdField_a_of_type_JavaUtilMap;
  private ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor;
  private final DefaultHttpClient jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient;
  private final HttpContext jdField_a_of_type_OrgApacheHttpProtocolHttpContext;
  private final Map<String, String> jdField_b_of_type_JavaUtilMap;
  
  public lce()
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    ConnManagerParams.setTimeout(localBasicHttpParams, jdField_b_of_type_Int);
    try
    {
      ConnManagerParams.setMaxConnectionsPerRoute(localBasicHttpParams, new ConnPerRouteBean(jdField_a_of_type_Int));
      ConnManagerParams.setMaxTotalConnections(localBasicHttpParams, 6);
      try
      {
        label40:
        HttpConnectionParams.setSoTimeout(localBasicHttpParams, jdField_b_of_type_Int);
        HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, jdField_b_of_type_Int);
        HttpConnectionParams.setTcpNoDelay(localBasicHttpParams, true);
        HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
        HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
        label73:
        Object localObject1 = new SchemeRegistry();
        ((SchemeRegistry)localObject1).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        if (Build.VERSION.SDK_INT < 11) {}
        for (;;)
        {
          try
          {
            Object localObject2 = KeyStore.getInstance(KeyStore.getDefaultType());
            ((KeyStore)localObject2).load(null, null);
            localObject2 = new lci((KeyStore)localObject2);
            ((SSLSocketFactory)localObject2).setHostnameVerifier(new lcf(this));
            ((SchemeRegistry)localObject1).register(new Scheme("https", (SocketFactory)localObject2, 443));
            localObject1 = new ThreadSafeClientConnManager(localBasicHttpParams, (SchemeRegistry)localObject1);
            this.jdField_a_of_type_OrgApacheHttpProtocolHttpContext = new SyncBasicHttpContext(new BasicHttpContext());
            this.jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient = new DefaultHttpClient((ClientConnectionManager)localObject1, localBasicHttpParams);
            this.jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient.addRequestInterceptor(new lcg(this));
            this.jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient.addResponseInterceptor(new lch(this));
            this.jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient.setHttpRequestRetryHandler(new lco(3));
            this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = ((ThreadPoolExecutor)Executors.newCachedThreadPool());
            this.jdField_a_of_type_JavaUtilMap = new WeakHashMap();
            this.jdField_b_of_type_JavaUtilMap = new HashMap();
            return;
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Translator", 2, "accept all ssl factory error" + localException);
            }
            ((SchemeRegistry)localObject1).register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
            continue;
          }
          ((SchemeRegistry)localObject1).register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        }
      }
      catch (NoSuchMethodError localNoSuchMethodError1)
      {
        break label73;
      }
    }
    catch (NoSuchMethodError localNoSuchMethodError2)
    {
      break label40;
    }
  }
  
  public static String a(String paramString, List<Pair<String, String>> paramList)
  {
    Object localObject = paramString;
    if (paramList != null)
    {
      localObject = new LinkedList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Pair localPair = (Pair)paramList.next();
        ((List)localObject).add(new BasicNameValuePair((String)localPair.first, (String)localPair.second));
      }
      paramList = URLEncodedUtils.format((List)localObject, jdField_a_of_type_JavaLangString);
      if (paramString.indexOf("?") == -1) {
        localObject = paramString + "?" + paramList;
      }
    }
    else
    {
      return localObject;
    }
    return paramString + "&" + paramList;
  }
  
  public void a(Context paramContext, String paramString, Header[] paramArrayOfHeader, List<Pair<String, String>> paramList, lcl paramlcl)
  {
    paramString = new HttpGet(a(paramString, paramList));
    if (paramArrayOfHeader != null) {
      paramString.setHeaders(paramArrayOfHeader);
    }
    a(this.jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient, this.jdField_a_of_type_OrgApacheHttpProtocolHttpContext, paramString, null, paramlcl, paramContext);
  }
  
  public void a(Context paramContext, String paramString1, Header[] paramArrayOfHeader, HttpEntity paramHttpEntity, String paramString2, lcl paramlcl)
  {
    paramString1 = new HttpPost(paramString1);
    if ((paramHttpEntity != null) && (paramString1 != null)) {
      paramString1.setEntity(paramHttpEntity);
    }
    if ((paramArrayOfHeader != null) && (paramString1 != null)) {
      paramString1.setHeaders(paramArrayOfHeader);
    }
    a(this.jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient, this.jdField_a_of_type_OrgApacheHttpProtocolHttpContext, paramString1, paramString2, paramlcl, paramContext);
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    Object localObject = (List)this.jdField_a_of_type_JavaUtilMap.get(paramContext);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Future localFuture = (Future)((WeakReference)((Iterator)localObject).next()).get();
        if (localFuture != null)
        {
          localFuture.cancel(paramBoolean);
          if (QLog.isColorLevel()) {
            QLog.e("Translator", 2, "[cancel] cancel task" + localFuture.toString());
          }
        }
      }
    }
    this.jdField_a_of_type_JavaUtilMap.remove(paramContext);
  }
  
  protected void a(DefaultHttpClient paramDefaultHttpClient, HttpContext paramHttpContext, HttpUriRequest paramHttpUriRequest, String paramString, lcl paramlcl, Context paramContext)
  {
    if (paramString != null) {
      paramHttpUriRequest.addHeader("Content-Type", paramString);
    }
    paramHttpUriRequest = this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.submit(new AsyncHttpRequest(paramDefaultHttpClient, paramHttpContext, paramHttpUriRequest, paramlcl));
    if (paramContext != null)
    {
      paramHttpContext = (List)this.jdField_a_of_type_JavaUtilMap.get(paramContext);
      paramDefaultHttpClient = paramHttpContext;
      if (paramHttpContext == null)
      {
        paramDefaultHttpClient = new LinkedList();
        this.jdField_a_of_type_JavaUtilMap.put(paramContext, paramDefaultHttpClient);
      }
      paramDefaultHttpClient.add(new WeakReference(paramHttpUriRequest));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lce
 * JD-Core Version:    0.7.0.1
 */