package com.tencent.qapmsdk.impl.instrumentation;

import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.impl.g.b;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

public class QAPMInstrumentation
{
  private static final String TAG = "QAPM_Impl_QAPMInstrumentation";
  
  @QAPMWrapReturn
  public static URLConnection openConnection(URLConnection paramURLConnection)
  {
    if (paramURLConnection == null) {
      return paramURLConnection;
    }
    try
    {
      if (!b.c()) {
        return paramURLConnection;
      }
      Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMInstrumentation", "URLConnection openConnection gather  begin !!" });
      if ((paramURLConnection instanceof HttpsURLConnection)) {
        return new e((HttpsURLConnection)paramURLConnection);
      }
      Object localObject = paramURLConnection;
      if ((paramURLConnection instanceof HttpURLConnection)) {
        localObject = new d((HttpURLConnection)paramURLConnection);
      }
      return localObject;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMInstrumentation", "QAPMInstrumentation openConnection() has an error : ", localException.toString() });
    }
    return paramURLConnection;
  }
  
  @QAPMWrapReturn
  public static URLConnection openConnectionWithProxy(URLConnection paramURLConnection)
  {
    if (paramURLConnection == null) {
      return paramURLConnection;
    }
    try
    {
      if (!b.c()) {
        return paramURLConnection;
      }
      Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMInstrumentation", "URLConnection openConnectionWithProxy gather  begin !!" });
      if ((paramURLConnection instanceof HttpsURLConnection)) {
        return new e((HttpsURLConnection)paramURLConnection);
      }
      Object localObject = paramURLConnection;
      if ((paramURLConnection instanceof HttpURLConnection)) {
        localObject = new d((HttpURLConnection)paramURLConnection);
      }
      return localObject;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMInstrumentation", "QAPMInstrumentation openConnectionWithProxy() has an error : ", localException.toString() });
    }
    return paramURLConnection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMInstrumentation
 * JD-Core Version:    0.7.0.1
 */