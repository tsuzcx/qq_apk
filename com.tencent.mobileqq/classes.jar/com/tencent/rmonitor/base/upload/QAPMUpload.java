package com.tencent.rmonitor.base.upload;

import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.network.ssl.NameVerifierFactory;
import com.tencent.rmonitor.common.network.ssl.SslFactory;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.String;Ljava.lang.String;>;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/upload/QAPMUpload;", "Lcom/tencent/rmonitor/base/upload/BaseUpload;", "url", "Ljava/net/URL;", "(Ljava/net/URL;)V", "protocol", "", "getProtocol", "()I", "setProtocol", "(I)V", "getUrl", "()Ljava/net/URL;", "setUrl", "connectionBuilder", "Ljava/net/HttpURLConnection;", "headers", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Companion", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public abstract class QAPMUpload
  extends BaseUpload
{
  public static final QAPMUpload.Companion d = new QAPMUpload.Companion(null);
  private int a;
  @NotNull
  private URL b;
  
  public QAPMUpload(@NotNull URL paramURL)
  {
    this.b = paramURL;
    this.a = a(this.b);
  }
  
  @Nullable
  public final HttpURLConnection a(@NotNull HashMap<String, String> paramHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramHashMap, "headers");
    for (;;)
    {
      Object localObject1;
      try
      {
        Object localObject2 = this.b.openConnection();
        localObject1 = localObject2;
        if (!(localObject2 instanceof HttpURLConnection)) {
          localObject1 = null;
        }
        localObject1 = (HttpURLConnection)localObject1;
        if (localObject1 != null)
        {
          ((HttpURLConnection)localObject1).setConnectTimeout(30000);
          ((HttpURLConnection)localObject1).setReadTimeout(30000);
          ((HttpURLConnection)localObject1).setDoOutput(true);
          ((HttpURLConnection)localObject1).setDoInput(true);
          ((HttpURLConnection)localObject1).setUseCaches(false);
          ((HttpURLConnection)localObject1).setRequestMethod("POST");
          ((HttpURLConnection)localObject1).setChunkedStreamingMode(1048576);
          ((HttpURLConnection)localObject1).setRequestProperty("Connection", "close");
          paramHashMap = ((Map)paramHashMap).entrySet().iterator();
          if (paramHashMap.hasNext())
          {
            localObject2 = (Map.Entry)paramHashMap.next();
            ((HttpURLConnection)localObject1).setRequestProperty((String)((Map.Entry)localObject2).getKey(), (String)((Map.Entry)localObject2).getValue());
            continue;
          }
          if (this.a == 1)
          {
            if ((localObject1 instanceof HttpsURLConnection)) {
              break label212;
            }
            paramHashMap = null;
            paramHashMap = (HttpsURLConnection)paramHashMap;
            if (paramHashMap != null)
            {
              paramHashMap.setSSLSocketFactory(SslFactory.b.a());
              paramHashMap.setHostnameVerifier(NameVerifierFactory.b.a());
              paramHashMap.connect();
            }
          }
        }
        return localObject1;
      }
      catch (Exception paramHashMap)
      {
        Logger.b.a("RMonitor_base_QAPMUpload", (Throwable)paramHashMap);
        return null;
      }
      label212:
      paramHashMap = (HashMap<String, String>)localObject1;
    }
  }
  
  @NotNull
  public final URL e()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.upload.QAPMUpload
 * JD-Core Version:    0.7.0.1
 */