package com.tencent.open.base.http;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.OpenConfig;
import com.tencent.open.business.cgireport.ReportManager;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.io.CharConversionException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.NotActiveException;
import java.io.NotSerializableException;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.io.SyncFailedException;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.io.WriteAbortedException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileLockInterruptionException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.UnmappableCharacterException;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.concurrent.Executor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import mqq.app.MobileQQ;
import org.apache.http.ConnectionClosedException;
import org.apache.http.MalformedChunkCodingException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpCgiAsyncTask
  extends HttpAsyncTask<Bundle, Void, HashMap<String, Object>>
{
  protected Handler a = new Handler(Looper.getMainLooper());
  protected HttpCgiAsyncTask.Callback b = null;
  private boolean c;
  
  public HttpCgiAsyncTask(String paramString1, String paramString2, HttpCgiAsyncTask.Callback paramCallback)
  {
    super(paramString1, paramString2);
    this.b = paramCallback;
  }
  
  public HttpCgiAsyncTask(String paramString1, String paramString2, HttpCgiAsyncTask.Callback paramCallback, boolean paramBoolean)
  {
    super(paramString1, paramString2);
    this.b = paramCallback;
    this.c = paramBoolean;
  }
  
  public static int a(IOException paramIOException)
  {
    if ((paramIOException instanceof CharConversionException)) {
      return -20;
    }
    if ((paramIOException instanceof MalformedInputException)) {
      return -21;
    }
    if ((paramIOException instanceof UnmappableCharacterException)) {
      return -22;
    }
    if ((paramIOException instanceof HttpResponseException)) {
      return -23;
    }
    if ((paramIOException instanceof ClosedChannelException)) {
      return -24;
    }
    if ((paramIOException instanceof ConnectionClosedException)) {
      return -25;
    }
    if ((paramIOException instanceof EOFException)) {
      return -26;
    }
    if ((paramIOException instanceof FileLockInterruptionException)) {
      return -27;
    }
    if ((paramIOException instanceof FileNotFoundException)) {
      return -28;
    }
    if ((paramIOException instanceof HttpRetryException)) {
      return -29;
    }
    if ((paramIOException instanceof ConnectTimeoutException)) {
      return -7;
    }
    if ((paramIOException instanceof SocketTimeoutException)) {
      return -8;
    }
    if ((paramIOException instanceof InvalidPropertiesFormatException)) {
      return -30;
    }
    if ((paramIOException instanceof MalformedChunkCodingException)) {
      return -31;
    }
    if ((paramIOException instanceof MalformedURLException)) {
      return -3;
    }
    if ((paramIOException instanceof NoHttpResponseException)) {
      return -32;
    }
    if ((paramIOException instanceof InvalidClassException)) {
      return -33;
    }
    if ((paramIOException instanceof InvalidObjectException)) {
      return -34;
    }
    if ((paramIOException instanceof NotActiveException)) {
      return -35;
    }
    if ((paramIOException instanceof NotSerializableException)) {
      return -36;
    }
    if ((paramIOException instanceof OptionalDataException)) {
      return -37;
    }
    if ((paramIOException instanceof StreamCorruptedException)) {
      return -38;
    }
    if ((paramIOException instanceof WriteAbortedException)) {
      return -39;
    }
    if ((paramIOException instanceof ProtocolException)) {
      return -40;
    }
    if ((paramIOException instanceof SSLHandshakeException)) {
      return -41;
    }
    if ((paramIOException instanceof SSLKeyException)) {
      return -42;
    }
    if ((paramIOException instanceof SSLPeerUnverifiedException)) {
      return -43;
    }
    if ((paramIOException instanceof SSLProtocolException)) {
      return -44;
    }
    if ((paramIOException instanceof BindException)) {
      return -45;
    }
    if ((paramIOException instanceof ConnectException)) {
      return -46;
    }
    if ((paramIOException instanceof NoRouteToHostException)) {
      return -47;
    }
    if ((paramIOException instanceof PortUnreachableException)) {
      return -48;
    }
    if ((paramIOException instanceof SyncFailedException)) {
      return -49;
    }
    if ((paramIOException instanceof UTFDataFormatException)) {
      return -50;
    }
    if ((paramIOException instanceof UnknownHostException)) {
      return -51;
    }
    if ((paramIOException instanceof UnknownServiceException)) {
      return -52;
    }
    if ((paramIOException instanceof UnsupportedEncodingException)) {
      return -53;
    }
    if ((paramIOException instanceof ZipException)) {
      return -54;
    }
    return -2;
  }
  
  public HttpBaseUtil.Statistic a(String paramString1, String paramString2, Bundle paramBundle)
  {
    return HttpBaseUtil.a(paramString1, paramString2, paramBundle);
  }
  
  protected HashMap<String, Object> a(Bundle... paramVarArgs)
  {
    return b(paramVarArgs);
  }
  
  @SuppressLint({"InlinedApi", "NewApi"})
  public void a(Bundle paramBundle)
  {
    Executor localExecutor = a();
    if (localExecutor != null)
    {
      executeOnExecutor(localExecutor, new Bundle[] { paramBundle });
      return;
    }
    execute(new Bundle[] { paramBundle });
  }
  
  protected void a(HashMap<String, Object> paramHashMap)
  {
    if (!isCancelled()) {
      this.a.post(new HttpCgiAsyncTask.1(this, paramHashMap));
    }
  }
  
  public HashMap<String, Object> b(Bundle... paramVarArgs)
  {
    HashMap localHashMap = new HashMap();
    if (isCancelled()) {
      return localHashMap;
    }
    long l1 = SystemClock.elapsedRealtime();
    String str3 = MsfSdkUtils.insertMtype("yingyongbao", this.e);
    String str1 = paramVarArgs[0].getString("appid_for_getting_config");
    try
    {
      bool = paramVarArgs[0].getBoolean("from_h5", false);
    }
    catch (Exception localException)
    {
      boolean bool;
      label59:
      int i;
      Object localObject1;
      int j;
      int k;
      break label59;
    }
    bool = false;
    i = OpenConfig.a(CommonDataAdapter.a().b(), str1).d("Common_HttpRetryCount");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("config 1:Common_HttpRetryCount            config_value:");
    ((StringBuilder)localObject1).append(i);
    ((StringBuilder)localObject1).append("   appid:");
    ((StringBuilder)localObject1).append(str1);
    ((StringBuilder)localObject1).append("     url:");
    ((StringBuilder)localObject1).append(str3);
    LogUtility.c("OpenConfig_agent", ((StringBuilder)localObject1).toString());
    j = i;
    if (i == 0) {
      j = 3;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("config 1:Common_HttpRetryCount            result_value:");
    ((StringBuilder)localObject1).append(j);
    ((StringBuilder)localObject1).append("   appid:");
    ((StringBuilder)localObject1).append(str1);
    ((StringBuilder)localObject1).append("     url:");
    ((StringBuilder)localObject1).append(str3);
    LogUtility.c("OpenConfig_agent", ((StringBuilder)localObject1).toString());
    str1 = paramVarArgs[0].getString("downloadfile");
    for (i = 0;; i = k)
    {
      if (isCancelled()) {
        return localHashMap;
      }
      k = i + 1;
      long l5 = 0L;
      label529:
      label542:
      long l4;
      long l3;
      try
      {
        try
        {
          localObject1 = this.e;
          try
          {
            HttpBaseUtil.Statistic localStatistic = a((String)localObject1, this.f, paramVarArgs[0]);
            String str2 = localStatistic.a;
            localObject1 = new JSONObject();
            if (str1 != null)
            {
              ((JSONObject)localObject1).put("content", localStatistic.e);
            }
            else if (bool)
            {
              str2 = HttpBaseUtil.b(str2);
              ((JSONObject)localObject1).put("content", str2);
            }
            else
            {
              localObject1 = HttpBaseUtil.a(str2);
            }
            Object localObject2 = new StringBuilder();
            try
            {
              ((StringBuilder)localObject2).append("response.isModified= ");
              ((StringBuilder)localObject2).append(localStatistic.d);
              LogUtility.a("HttpCgiAsyncTask", ((StringBuilder)localObject2).toString());
              i = localStatistic.d;
              if (i == 0) {
                if (bool)
                {
                  localObject2 = new JSONObject();
                  ((JSONObject)localObject2).put("httpdatamodified", localStatistic.d);
                  ((JSONObject)localObject1).put("extend", localObject2);
                }
                else
                {
                  ((JSONObject)localObject1).put("httpdatamodified", localStatistic.d);
                }
              }
              localHashMap.put("ResultType", Integer.valueOf(1));
              localHashMap.put("ResultValue", localObject1);
              i = -55;
              if (bool)
              {
                localObject1 = Pattern.compile("\"(?:ret|resultCode)\"\\s*\\:\\s*(\\d+)").matcher(str2);
                if (!((Matcher)localObject1).find()) {
                  break label542;
                }
                i = Integer.parseInt(((Matcher)localObject1).group(1));
              }
            }
            catch (SocketTimeoutException localSocketTimeoutException1)
            {
              int m;
            }
            catch (ConnectTimeoutException localConnectTimeoutException1) {}
          }
          catch (HttpBaseUtil.HttpStatusException paramVarArgs)
          {
            l2 = 0L;
          }
        }
        catch (Exception paramVarArgs)
        {
          l2 = 0L;
          if ((paramVarArgs instanceof HttpBaseUtil.NetworkUnavailableException))
          {
            paramVarArgs.printStackTrace();
            localHashMap.put("ResultType", Integer.valueOf(0));
            localHashMap.put("ResultValue", paramVarArgs);
            return localHashMap;
          }
          if ((paramVarArgs instanceof HttpBaseUtil.HttpStatusException))
          {
            paramVarArgs.printStackTrace();
            localHashMap.put("ResultType", Integer.valueOf(0));
            localHashMap.put("ResultValue", paramVarArgs);
            try
            {
              i = Integer.parseInt(paramVarArgs.getMessage().replace("http status code error:", ""));
              ReportManager.a().a(str3, l1, l2, 0L, i, CommonDataAdapter.a().c(), "1000002", null, this.c);
              return localHashMap;
            }
            catch (Exception paramVarArgs)
            {
              paramVarArgs.printStackTrace();
              return localHashMap;
            }
          }
          if ((paramVarArgs instanceof IOException))
          {
            paramVarArgs.printStackTrace();
            localHashMap.put("ResultType", Integer.valueOf(0));
            localHashMap.put("ResultValue", paramVarArgs);
            i = a((IOException)paramVarArgs);
          }
          else
          {
            paramVarArgs.printStackTrace();
            localHashMap.put("ResultType", Integer.valueOf(0));
            localHashMap.put("ResultValue", paramVarArgs);
            l2 = l1;
            l1 = 0L;
            l3 = l1;
            i = -6;
          }
        }
        catch (IOException paramVarArgs)
        {
          paramVarArgs.printStackTrace();
          localHashMap.put("ResultType", Integer.valueOf(0));
          localHashMap.put("ResultValue", paramVarArgs);
          i = a(paramVarArgs);
          l2 = l1;
          l1 = 0L;
          l3 = l1;
        }
        catch (HttpBaseUtil.HttpStatusException paramVarArgs)
        {
          label600:
          l2 = 0L;
        }
      }
      catch (HttpBaseUtil.NetworkUnavailableException paramVarArgs)
      {
        paramVarArgs.printStackTrace();
        localHashMap.put("ResultType", Integer.valueOf(0));
        localHashMap.put("ResultValue", paramVarArgs);
        return localHashMap;
      }
      catch (JSONException paramVarArgs)
      {
        paramVarArgs.printStackTrace();
        localHashMap.put("ResultType", Integer.valueOf(0));
        localHashMap.put("ResultValue", paramVarArgs);
        l2 = l1;
        l1 = 0L;
        l3 = l1;
        i = -4;
      }
      catch (SocketTimeoutException localSocketTimeoutException2)
      {
        localSocketTimeoutException2.printStackTrace();
        localHashMap.put("ResultType", Integer.valueOf(0));
        localHashMap.put("ResultValue", localSocketTimeoutException2);
        i = -8;
        l1 = SystemClock.elapsedRealtime();
      }
      catch (ConnectTimeoutException localConnectTimeoutException2)
      {
        localConnectTimeoutException2.printStackTrace();
        localHashMap.put("ResultType", Integer.valueOf(0));
        localHashMap.put("ResultValue", localConnectTimeoutException2);
        i = -7;
        l1 = SystemClock.elapsedRealtime();
      }
      try
      {
        m = ((JSONObject)localObject1).getInt("ret");
        i = m;
      }
      catch (JSONException localJSONException2)
      {
        break label529;
      }
      try
      {
        m = ((JSONObject)localObject1).getInt("resultCode");
        i = m;
      }
      catch (JSONException localJSONException1)
      {
        break label542;
      }
      long l2 = localStatistic.b;
      try
      {
        l4 = localStatistic.c;
        l3 = l2;
        l2 = l1;
        l1 = l4;
      }
      catch (Exception paramVarArgs)
      {
        break label600;
      }
      catch (HttpBaseUtil.HttpStatusException paramVarArgs) {}
      for (;;)
      {
        paramVarArgs.printStackTrace();
        localHashMap.put("ResultType", Integer.valueOf(0));
        localHashMap.put("ResultValue", paramVarArgs);
        try
        {
          i = Integer.parseInt(paramVarArgs.getMessage().replace("http status code error:", ""));
          ReportManager.a().a(str3, l1, l2, 0L, i, CommonDataAdapter.a().c(), "1000002", null, this.c);
          return localHashMap;
        }
        catch (Exception paramVarArgs)
        {
          paramVarArgs.printStackTrace();
          return localHashMap;
        }
        if (k < j) {
          break;
        }
      }
      paramVarArgs = new StringBuilder();
      paramVarArgs.append(str3);
      paramVarArgs.append(" | ");
      paramVarArgs.append(l2);
      paramVarArgs.append(" | ");
      paramVarArgs.append(l3);
      paramVarArgs.append(" | ");
      paramVarArgs.append(l1);
      paramVarArgs.append(" | ");
      paramVarArgs.append(i);
      LogUtility.c("ReportManager", paramVarArgs.toString());
      try
      {
        paramVarArgs = MobileQQ.sMobileQQ.getFirstSimpleAccount();
        l4 = l5;
        if (paramVarArgs != null) {
          l4 = Long.valueOf(paramVarArgs.getUin()).longValue();
        }
      }
      catch (Exception paramVarArgs)
      {
        paramVarArgs.printStackTrace();
        l4 = l5;
      }
      ReportManager.a().a(str3, l2, l3, l1, i, l4, "1000002", null, this.c);
      return localHashMap;
    }
  }
  
  public void b()
  {
    this.b = null;
  }
  
  public void c()
  {
    Handler localHandler = this.a;
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
      this.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.base.http.HttpCgiAsyncTask
 * JD-Core Version:    0.7.0.1
 */