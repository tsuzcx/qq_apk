package com.tencent.mobileqq.troop.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.open.base.http.HttpAsyncTask;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpWebCgiAsyncTask
  extends HttpAsyncTask<HashMap<String, Object>, Void, JSONObject>
{
  protected HttpWebCgiAsyncTask.Callback a = null;
  protected int b;
  protected Bundle c;
  protected boolean d = false;
  
  public HttpWebCgiAsyncTask(String paramString1, String paramString2, HttpWebCgiAsyncTask.Callback paramCallback, int paramInt, Bundle paramBundle)
  {
    super(paramString1, paramString2);
    this.a = paramCallback;
    this.b = paramInt;
    this.c = paramBundle;
  }
  
  public HttpWebCgiAsyncTask(String paramString1, String paramString2, HttpWebCgiAsyncTask.Callback paramCallback, int paramInt, Bundle paramBundle, boolean paramBoolean)
  {
    super(paramString1, paramString2);
    this.a = paramCallback;
    this.b = paramInt;
    this.c = paramBundle;
    this.d = paramBoolean;
  }
  
  protected JSONObject a(HashMap<String, Object>... paramVarArgs)
  {
    if (isCancelled()) {
      return null;
    }
    Object localObject = paramVarArgs[0];
    if (((((HashMap)localObject).get("CONTEXT") instanceof Context)) && ((((HashMap)localObject).get("BUNDLE") instanceof Bundle)))
    {
      paramVarArgs = (Context)((HashMap)localObject).get("CONTEXT");
      localObject = (Bundle)((HashMap)localObject).get("BUNDLE");
      try
      {
        Bundle localBundle = new Bundle();
        String str1 = ((Bundle)localObject).getString("Cookie");
        String str2 = ((Bundle)localObject).getString("Referer");
        String str3 = ((Bundle)localObject).getString("Host");
        if (str1 != null)
        {
          localBundle.putString("Cookie", str1);
          ((Bundle)localObject).remove("Cookie");
        }
        if (str2 != null)
        {
          localBundle.putString("Referer", str2);
          ((Bundle)localObject).remove("Referer");
        }
        if (str3 != null)
        {
          localBundle.putString("Host", str3);
          ((Bundle)localObject).remove(str3);
        }
        paramVarArgs = new JSONObject(HttpUtil.openUrl(paramVarArgs, this.e, this.f, (Bundle)localObject, localBundle));
        if ((!this.d) && (paramVarArgs.getInt("retcode") == 0))
        {
          paramVarArgs = paramVarArgs.getJSONObject("result");
          return paramVarArgs;
        }
        return paramVarArgs;
      }
      catch (OutOfMemoryError paramVarArgs)
      {
        QLog.w("HttpWebCgiAsyncTask", 1, paramVarArgs.getMessage(), paramVarArgs);
        return null;
      }
      catch (JSONException paramVarArgs)
      {
        QLog.w("HttpWebCgiAsyncTask", 1, paramVarArgs.getMessage(), paramVarArgs);
        return null;
      }
      catch (IOException paramVarArgs)
      {
        QLog.w("HttpWebCgiAsyncTask", 1, paramVarArgs.getMessage(), paramVarArgs);
      }
    }
    return null;
  }
  
  @SuppressLint({"InlinedApi", "NewApi"})
  public void a(HashMap<String, Object> paramHashMap)
  {
    Executor localExecutor = a();
    if (localExecutor != null)
    {
      executeOnExecutor(localExecutor, new HashMap[] { paramHashMap });
      return;
    }
    execute(new HashMap[] { paramHashMap });
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    if (isCancelled()) {
      return;
    }
    HttpWebCgiAsyncTask.Callback localCallback = this.a;
    if (localCallback != null) {
      localCallback.a(paramJSONObject, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask
 * JD-Core Version:    0.7.0.1
 */