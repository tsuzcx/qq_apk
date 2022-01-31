import android.net.Proxy;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.DefaultHttpRoutePlanner;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class ec
{
  private static final Uri a = Uri.parse("content://telephony/carriers/preferapn");
  
  private static int a()
  {
    int i = -1;
    if (ds.a() < 11) {
      i = Proxy.getDefaultPort();
    }
    String str;
    do
    {
      return i;
      str = System.getProperty("http.proxyPort");
    } while (TextUtils.isEmpty(str));
    try
    {
      i = Integer.parseInt(str);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
    }
    return -1;
  }
  
  public static ee a()
  {
    String str;
    if (a())
    {
      str = a();
      if (str != null)
      {
        if (str.equalsIgnoreCase("cmwap")) {
          return new ee("10.0.0.172", 80, null);
        }
        if (str.equalsIgnoreCase("3gwap")) {
          return new ee("10.0.0.172", 80, null);
        }
        if (str.equalsIgnoreCase("uniwap")) {
          return new ee("10.0.0.172", 80, null);
        }
        if (str.equalsIgnoreCase("ctwap")) {
          return new ee("10.0.0.200", 80, null);
        }
      }
    }
    else
    {
      str = b();
      int i = a();
      if ((!TextUtils.isEmpty(str)) && (!"10.0.0.172".equals(str)) && (!"10.0.0.200".equals(str)) && (i >= 0)) {
        return new ee(str, i, null);
      }
    }
    return null;
  }
  
  public static String a()
  {
    if (AppNetConnInfo.getRecentNetworkInfo() == null) {}
    do
    {
      return null;
      if (AppNetConnInfo.isWifiConn()) {
        return "wifi";
      }
    } while ((!AppNetConnInfo.isMobileConn()) || (AppNetConnInfo.getCurrentAPN() == null));
    return AppNetConnInfo.getCurrentAPN().toLowerCase();
  }
  
  public static HttpClient a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject2 = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout((HttpParams)localObject2, paramInt2);
    HttpConnectionParams.setSoTimeout((HttpParams)localObject2, paramInt3);
    Object localObject1 = new SchemeRegistry();
    ((SchemeRegistry)localObject1).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), paramInt1));
    if (paramBoolean) {}
    for (localObject1 = new ThreadSafeClientConnManager((HttpParams)localObject2, (SchemeRegistry)localObject1);; localObject1 = new SingleClientConnManager((HttpParams)localObject2, (SchemeRegistry)localObject1))
    {
      localObject2 = new DefaultHttpClient((ClientConnectionManager)localObject1, (HttpParams)localObject2);
      ((DefaultHttpClient)localObject2).setRoutePlanner(new DefaultHttpRoutePlanner(((ClientConnectionManager)localObject1).getSchemeRegistry()));
      return localObject2;
    }
  }
  
  public static HttpClient a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    Object localObject2 = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout((HttpParams)localObject2, paramInt1);
    HttpConnectionParams.setSoTimeout((HttpParams)localObject2, paramInt2);
    if (paramBoolean2 == true) {
      return new DefaultHttpClient((HttpParams)localObject2);
    }
    Object localObject1 = new SchemeRegistry();
    ((SchemeRegistry)localObject1).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    try
    {
      ((SchemeRegistry)localObject1).register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
      if (paramBoolean1)
      {
        localObject1 = new ThreadSafeClientConnManager((HttpParams)localObject2, (SchemeRegistry)localObject1);
        localObject2 = new DefaultHttpClient((ClientConnectionManager)localObject1, (HttpParams)localObject2);
        ((DefaultHttpClient)localObject2).setRoutePlanner(new DefaultHttpRoutePlanner(((ClientConnectionManager)localObject1).getSchemeRegistry()));
        return localObject2;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        localObject1 = new SingleClientConnManager((HttpParams)localObject2, (SchemeRegistry)localObject1);
      }
    }
  }
  
  public static boolean a()
  {
    return AppNetConnInfo.isMobileConn();
  }
  
  private static String b()
  {
    if (ds.a() < 11) {
      return Proxy.getDefaultHost();
    }
    return System.getProperty("http.proxyHost");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ec
 * JD-Core Version:    0.7.0.1
 */