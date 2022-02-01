package com.tencent.qapmsdk.base.reporter.authorization;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.reporter.uploaddata.QAPMUpload;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.AsyncSPEditor;
import com.tencent.qapmsdk.common.util.FileUtil;
import com.tencent.qapmsdk.common.util.FileUtil.Companion;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/reporter/authorization/Authorization;", "Lcom/tencent/qapmsdk/base/reporter/uploaddata/QAPMUpload;", "url", "Ljava/net/URL;", "(Ljava/net/URL;)V", "appKey", "", "getAppKey", "()Ljava/lang/String;", "setAppKey", "(Ljava/lang/String;)V", "getToken", "", "local", "readTokenFromLocal", "readTokenFromServer", "request", "", "writeTokenToLocal", "token", "Companion", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class Authorization
  extends QAPMUpload
{
  public static final Authorization.Companion Companion = new Authorization.Companion(null);
  private static final String TAG = "QAPM_base_Authorization";
  @NotNull
  private String appKey = "";
  
  public Authorization(@NotNull URL paramURL)
  {
    super(paramURL);
  }
  
  private final boolean readTokenFromLocal(boolean paramBoolean)
  {
    if ((!paramBoolean) || (BaseInfo.sharePreference == null)) {
      return false;
    }
    try
    {
      Object localObject = BaseInfo.sharePreference;
      if (localObject != null)
      {
        localObject = ((SharedPreferences)localObject).getString("token", "");
        if (localObject == null) {}
      }
      for (;;)
      {
        BaseInfo.token = (String)localObject;
        if (((CharSequence)BaseInfo.token).length() <= 0) {
          break;
        }
        return true;
        localObject = "";
      }
      return false;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.exception("QAPM_base_Authorization", (Throwable)localException);
    }
    return false;
  }
  
  private final boolean readTokenFromServer(String paramString)
  {
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool2 = bool3;
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      paramString = getUrl().toString();
      Intrinsics.checkExpressionValueIsNotNull(paramString, "url.toString()");
      if (((CharSequence)paramString).length() != 0) {
        break label58;
      }
    }
    label58:
    for (int i = 1; i != 0; i = 0)
    {
      bool2 = bool3;
      return bool2;
    }
    paramString = new HashMap();
    ((Map)paramString).put("Content-Type", "application/x-www-form-urlencoded");
    HttpURLConnection localHttpURLConnection = connectionBuilder(paramString);
    if (localHttpURLConnection != null)
    {
      Object localObject4;
      Object localObject5;
      DataOutputStream localDataOutputStream;
      Charset localCharset;
      for (;;)
      {
        try
        {
          paramString = BaseInfo.pubJson;
          localObject1 = new StringBuffer(1024);
          localObject4 = paramString.keys();
          Intrinsics.checkExpressionValueIsNotNull(localObject4, "params.keys()");
          if (((Iterator)localObject4).hasNext())
          {
            localObject5 = (String)((Iterator)localObject4).next();
            ((StringBuffer)localObject1).append("&").append((String)localObject5).append("=").append(URLEncoder.encode(paramString.getString((String)localObject5), "UTF-8"));
            continue;
          }
        }
        catch (Exception paramString)
        {
          Object localObject1;
          Logger.INSTANCE.exception("QAPM_base_Authorization", (Throwable)paramString);
          bool2 = bool3;
          return false;
          if (((CharSequence)localObject1).length() == 0)
          {
            i = 1;
            if (i == 0) {
              break label344;
            }
            localObject1 = ((StringBuffer)localObject1).toString();
            localObject5 = (Closeable)new DataOutputStream(localHttpURLConnection.getOutputStream());
            localObject4 = (Throwable)null;
            paramString = (String)localObject4;
            try
            {
              localDataOutputStream = (DataOutputStream)localObject5;
              paramString = (String)localObject4;
              Intrinsics.checkExpressionValueIsNotNull(localObject1, "urlQuery");
              paramString = (String)localObject4;
              localCharset = Charsets.UTF_8;
              if (localObject1 != null) {
                break label360;
              }
              paramString = (String)localObject4;
              throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            catch (Throwable localThrowable)
            {
              paramString = localThrowable;
              throw localThrowable;
            }
            finally
            {
              CloseableKt.closeFinally((Closeable)localObject5, paramString);
            }
          }
        }
        finally
        {
          if (localHttpURLConnection != null) {
            localHttpURLConnection.disconnect();
          }
        }
        i = 0;
        continue;
        label344:
        localObject3 = localObject2.substring(1, localObject2.length());
      }
      label360:
      paramString = (String)localObject4;
      Object localObject3 = ((String)localObject3).getBytes(localCharset);
      paramString = (String)localObject4;
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "(this as java.lang.String).getBytes(charset)");
      paramString = (String)localObject4;
      localDataOutputStream.write((byte[])localObject3);
      paramString = (String)localObject4;
      localDataOutputStream.flush();
      paramString = (String)localObject4;
      localObject3 = Unit.INSTANCE;
      CloseableKt.closeFinally((Closeable)localObject5, (Throwable)localObject4);
      if (localHttpURLConnection.getResponseCode() != 200) {
        break label544;
      }
      paramString = new JSONObject(FileUtil.Companion.readStream((InputStream)new BufferedInputStream(localHttpURLConnection.getInputStream()), 8192)).getString("token");
      Intrinsics.checkExpressionValueIsNotNull(paramString, "JSONObject(httpResult).getString(\"token\")");
      BaseInfo.token = paramString;
      Logger.INSTANCE.i(new String[] { "QAPM_base_Authorization", "GetTokenFromServer url:" + getUrl() + " ,token:" + BaseInfo.token });
    }
    label544:
    for (bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (localHttpURLConnection == null) {
        break;
      }
      localHttpURLConnection.disconnect();
      return bool1;
    }
  }
  
  private final void writeTokenToLocal(String paramString)
  {
    if (BaseInfo.sharePreference != null) {
      BaseInfo.editor.putString("token", paramString).apply();
    }
  }
  
  @NotNull
  public final String getAppKey()
  {
    return this.appKey;
  }
  
  public final boolean getToken(@NotNull String paramString, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "appKey");
    if (!readTokenFromLocal(paramBoolean)) {}
    try
    {
      if (!readTokenFromServer(paramString)) {
        return false;
      }
      writeTokenToLocal(BaseInfo.token);
      return true;
    }
    catch (Exception paramString)
    {
      Logger.INSTANCE.exception("QAPM_base_Authorization", (Throwable)paramString);
    }
    return false;
  }
  
  public void request()
  {
    getToken(this.appKey, true);
  }
  
  public final void setAppKey(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.appKey = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.authorization.Authorization
 * JD-Core Version:    0.7.0.1
 */