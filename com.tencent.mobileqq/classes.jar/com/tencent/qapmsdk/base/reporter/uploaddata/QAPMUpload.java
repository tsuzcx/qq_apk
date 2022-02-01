package com.tencent.qapmsdk.base.reporter.uploaddata;

import android.text.TextUtils;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.base.reporter.authorization.Authorization;
import com.tencent.qapmsdk.base.reporter.proxy.AuthorizationProxy;
import com.tencent.qapmsdk.base.statistics.ErrorStatistics;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.reporter.BaseUpload;
import com.tencent.qapmsdk.common.ssl.NameVerifierFactory;
import com.tencent.qapmsdk.common.ssl.SslFactory;
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
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/reporter/uploaddata/QAPMUpload;", "Lcom/tencent/qapmsdk/common/reporter/BaseUpload;", "url", "Ljava/net/URL;", "(Ljava/net/URL;)V", "protocol", "", "getProtocol", "()I", "setProtocol", "(I)V", "retry", "getRetry", "setRetry", "getUrl", "()Ljava/net/URL;", "setUrl", "addLost", "", "plugin", "code", "resp", "", "category", "connectionBuilder", "Ljava/net/HttpURLConnection;", "headers", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "isSucceeded", "", "Companion", "qapmbase_release"}, k=1, mv={1, 1, 15})
public abstract class QAPMUpload
  extends BaseUpload
{
  public static final int CHUNK_SIZE = 1048576;
  public static final QAPMUpload.Companion Companion = new QAPMUpload.Companion(null);
  public static final int ERROR_CLIENT = 400;
  public static final int ERROR_FILE_NOT_EXIT = 601;
  public static final int ERROR_OOM = 600;
  public static final int ERROR_OTHER = 700;
  public static final int ERROR_SERVICE = 500;
  public static final int SOCKET_TIMEOUT_MILLI = 30000;
  private static final String TAG = "QAPM_base_QAPMUpload";
  private int protocol;
  private int retry;
  @NotNull
  private URL url;
  
  public QAPMUpload(@NotNull URL paramURL)
  {
    this.url = paramURL;
    this.protocol = getProtocol(this.url);
  }
  
  public void addLost(int paramInt1, int paramInt2, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "resp");
    Intrinsics.checkParameterIsNotNull(paramString2, "category");
    try
    {
      if (Intrinsics.areEqual(paramString2, "Error")) {
        return;
      }
      localObject = "0";
      if (paramInt2 == 200) {
        localObject = String.valueOf(new JSONObject(paramString1).getInt("status"));
      }
      ErrorStatistics.INSTANCE.addLost(paramInt1, String.valueOf(paramInt2), (String)localObject, paramString2);
      return;
    }
    catch (JSONException paramString1)
    {
      paramString2 = Logger.INSTANCE;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(": add lost data may be error");
      paramString2.e(new String[] { "QAPM_base_QAPMUpload", ((StringBuilder)localObject).toString() });
    }
  }
  
  @Nullable
  public final HttpURLConnection connectionBuilder(@NotNull HashMap<String, String> paramHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramHashMap, "headers");
    for (;;)
    {
      Object localObject1;
      try
      {
        Object localObject2 = this.url.openConnection();
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
          if (this.protocol == 1)
          {
            if ((localObject1 instanceof HttpsURLConnection)) {
              break label212;
            }
            paramHashMap = null;
            paramHashMap = (HttpsURLConnection)paramHashMap;
            if (paramHashMap != null)
            {
              paramHashMap.setSSLSocketFactory(SslFactory.INSTANCE.getSslSocketFactory());
              paramHashMap.setHostnameVerifier(NameVerifierFactory.INSTANCE.getNameVerifier());
              paramHashMap.connect();
            }
          }
        }
        return localObject1;
      }
      catch (Exception paramHashMap)
      {
        Logger.INSTANCE.exception("QAPM_base_QAPMUpload", (Throwable)paramHashMap);
        return null;
      }
      label212:
      paramHashMap = (HashMap<String, String>)localObject1;
    }
  }
  
  public final int getProtocol()
  {
    return this.protocol;
  }
  
  public final int getRetry()
  {
    return this.retry;
  }
  
  @NotNull
  public final URL getUrl()
  {
    return this.url;
  }
  
  public boolean isSucceeded(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "resp");
    boolean bool = false;
    try
    {
      if (TextUtils.isEmpty((CharSequence)paramString)) {
        return true;
      }
      int i = new JSONObject(paramString).getInt("status");
      if ((i != 1000) && (i != 1495))
      {
        if (i == 1408)
        {
          AuthorizationProxy.INSTANCE.getAuthorization().getToken(BaseInfo.userMeta.appKey, false);
          return false;
        }
      }
      else {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramString)
    {
      Logger localLogger = Logger.INSTANCE;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(": response parameter json error");
      localLogger.e(new String[] { "QAPM_base_QAPMUpload", localStringBuilder.toString() });
    }
    return false;
  }
  
  public final void setProtocol(int paramInt)
  {
    this.protocol = paramInt;
  }
  
  public final void setRetry(int paramInt)
  {
    this.retry = paramInt;
  }
  
  public final void setUrl(@NotNull URL paramURL)
  {
    Intrinsics.checkParameterIsNotNull(paramURL, "<set-?>");
    this.url = paramURL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.uploaddata.QAPMUpload
 * JD-Core Version:    0.7.0.1
 */