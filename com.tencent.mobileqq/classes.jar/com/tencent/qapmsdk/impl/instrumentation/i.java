package com.tencent.qapmsdk.impl.instrumentation;

import android.text.TextUtils;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.network.NetworkWatcher;
import com.tencent.qapmsdk.impl.b.d;
import com.tencent.qapmsdk.impl.g.b;
import java.io.IOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;

public class i
{
  public static d a(String paramString)
  {
    if (paramString.toUpperCase().equals("OPTIONS")) {
      return d.g;
    }
    if (paramString.toUpperCase().equals("GET")) {
      return d.a;
    }
    if (paramString.toUpperCase().equals("HEAD")) {
      return d.e;
    }
    if (paramString.toUpperCase().equals("POST")) {
      return d.b;
    }
    if (paramString.toUpperCase().equals("PUT")) {
      return d.c;
    }
    if (paramString.toUpperCase().equals("DELETE")) {
      return d.d;
    }
    if (paramString.toUpperCase().equals("TRACE")) {
      return d.f;
    }
    if (paramString.toUpperCase().equals("CONNECT")) {
      return d.h;
    }
    return d.a;
  }
  
  public static void a(h paramh, Exception paramException)
  {
    if ((paramException instanceof IOException))
    {
      if (a(paramException))
      {
        paramh.a(911, paramException.toString());
        paramh.c(911);
        return;
      }
      String str = paramException.getMessage();
      if ((paramException != null) && (str != null) && (str.contains("ftruncate failed: ENOENT (No such file or directory)")))
      {
        paramh.a(917, paramException.toString());
        paramh.c(917);
        return;
      }
    }
    if ((paramException instanceof UnknownHostException))
    {
      paramh.a(901, paramException.toString());
      paramh.c(901);
      return;
    }
    if ((paramException instanceof SocketTimeoutException))
    {
      paramh.a(903, paramException.toString());
      paramh.c(903);
      return;
    }
    if ((paramException instanceof ConnectException))
    {
      paramh.a(902, paramException.toString());
      paramh.c(902);
      return;
    }
    if ((paramException instanceof MalformedURLException))
    {
      paramh.a(900, paramException.toString());
      paramh.c(900);
      return;
    }
    if ((paramException instanceof SSLException))
    {
      paramh.a(908, paramException.toString());
      paramh.c(908);
      return;
    }
    paramh.a(-1, paramException.toString());
    paramh.c(-1);
  }
  
  public static void a(h paramh, String paramString)
  {
    paramh.a(a(paramString));
  }
  
  public static void a(h paramh, HttpURLConnection paramHttpURLConnection)
  {
    Object localObject = paramHttpURLConnection.getURL().toString();
    paramHttpURLConnection = null;
    if (((String)localObject).contains("?"))
    {
      int i = ((String)localObject).indexOf("?");
      paramHttpURLConnection = ((String)localObject).substring(0, i);
      String str = ((String)localObject).substring(i + 1);
      localObject = paramHttpURLConnection;
      paramHttpURLConnection = str;
    }
    for (;;)
    {
      paramh.f((String)localObject);
      paramh.b(paramHttpURLConnection);
      paramh.a(paramHttpURLConnection);
      paramh.a(paramHttpURLConnection);
      paramh.c(NetworkWatcher.INSTANCE.activeNetworkCarrier());
      return;
    }
  }
  
  public static void a(String paramString, f paramf, h paramh)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramh != null) && (paramf != null)) {}
  }
  
  public static boolean a(Exception paramException)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramException != null) {
      bool1 = bool2;
    }
    try
    {
      if ((paramException instanceof SocketException))
      {
        boolean bool3 = paramException.getMessage().contains("recvfrom failed: ECONNRESET (Connection reset by peer)");
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramException)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMTransactionStateUtil", "isSocketECONNRESET error", paramException);
    }
    return false;
  }
  
  public static String b(h paramh, String paramString)
  {
    if ((!TextUtils.isEmpty(paramh.d())) && (!TextUtils.isEmpty(paramString))) {
      return "";
    }
    paramh.b("");
    return "";
  }
  
  public static void b(h paramh, HttpURLConnection paramHttpURLConnection)
  {
    b(paramh, paramh.b());
    paramHttpURLConnection = new i.1(paramHttpURLConnection);
    a(paramh.d(), paramHttpURLConnection, paramh);
  }
  
  public static void c(h paramh, HttpURLConnection paramHttpURLConnection)
  {
    try
    {
      if (!b.c()) {
        return;
      }
      String str = paramHttpURLConnection.getHeaderField("X-QAPM-Tx-Data");
      if ((str != null) && (!"".equals(str)))
      {
        Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMTransactionStateUtil", "header:", str });
        paramh.d(str);
      }
      b(paramh, paramHttpURLConnection);
      i = paramHttpURLConnection.getContentLength();
      if (i >= 0) {
        paramh.d(i);
      }
      Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMTransactionStateUtil", "content length:", String.valueOf(i) });
      i = paramh.g();
    }
    catch (Exception paramh)
    {
      int i;
      int j;
      label120:
      Logger.INSTANCE.exception("QAPM_Impl_QAPMTransactionStateUtil", "Failed to retrieve response code due to underlying (Harmony?) NPE", paramh);
      return;
    }
    try
    {
      j = paramHttpURLConnection.getResponseCode();
      i = j;
    }
    catch (IOException paramHttpURLConnection)
    {
      break label120;
    }
    catch (NullPointerException paramHttpURLConnection)
    {
      break label120;
    }
    catch (Exception paramHttpURLConnection)
    {
      break label120;
    }
    paramh.c(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.i
 * JD-Core Version:    0.7.0.1
 */