package com.tencent.open.appcommon.js;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpInterface
  extends BaseInterface
{
  public static final String PLUGIN_NAMESPACE = "qzone_http";
  private static final String TAG = "HttpInterface";
  protected ArrayList<AsyncTask<Bundle, Void, HashMap<String, Object>>> asyncTaskList;
  protected Handler mHandler = new WebviewHandler();
  protected WeakReference<WebView> mWebViewRef;
  protected WebView webView;
  
  public HttpInterface(Activity paramActivity, WebView paramWebView)
  {
    this.webView = paramWebView;
    this.mWebViewRef = new WeakReference(paramWebView);
    this.asyncTaskList = new ArrayList();
  }
  
  @TargetApi(11)
  protected void aSyncTaskExecute(HttpCgiAsyncTask paramHttpCgiAsyncTask, Bundle paramBundle)
  {
    Executor localExecutor = obtainMultiExecutor();
    if (localExecutor != null)
    {
      paramHttpCgiAsyncTask.executeOnExecutor(localExecutor, new Bundle[] { paramBundle });
      return;
    }
    paramHttpCgiAsyncTask.execute(new Bundle[] { paramBundle });
  }
  
  public void clearWebViewCache()
  {
    try
    {
      if (this.webView != null)
      {
        this.webView.clearCache(true);
        return;
      }
    }
    catch (Exception localException)
    {
      LogUtility.a("HttpInterface", "clearWebViewCache>>>", localException);
    }
  }
  
  public void destroy()
  {
    int j = this.asyncTaskList.size();
    int i = 0;
    while (i < j)
    {
      localObject = (AsyncTask)this.asyncTaskList.get(i);
      if ((localObject != null) && (!((AsyncTask)localObject).isCancelled()))
      {
        LogUtility.c("HttpInterface", "cancel AsyncTask when onDestory");
        ((AsyncTask)localObject).cancel(true);
        if ((localObject instanceof HttpCgiAsyncTask)) {
          ((HttpCgiAsyncTask)localObject).c();
        }
      }
      i += 1;
    }
    Object localObject = this.mHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.mHandler = null;
    }
  }
  
  public String getInterfaceName()
  {
    return "qzone_http";
  }
  
  public void httpRequest(String paramString)
  {
    if (!hasRight())
    {
      LogUtility.c("HttpInterface", ">>httpReauest has not right>>");
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("httpRequest >>> ");
    ((StringBuilder)localObject1).append(paramString.toString());
    LogUtility.c("HttpInterface", ((StringBuilder)localObject1).toString());
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject(paramString);
        localObject1 = ((JSONObject)localObject2).optString("guid");
        String str1 = ((JSONObject)localObject2).optString("url");
        String str2 = ((JSONObject)localObject2).optString("method");
        String str3 = ((JSONObject)localObject2).optString("oncomplate");
        String str4 = ((JSONObject)localObject2).optString("onerror");
        if (((JSONObject)localObject2).optInt("supportetag", 1) == 1)
        {
          i = 1;
          if (((JSONObject)localObject2).optInt("from_h5", 0) != 1) {
            break label507;
          }
          bool = true;
          paramString = new Bundle();
          paramString.putBoolean("from_h5", bool);
          paramString.putString("platform", CommonDataAdapter.a().m());
          paramString.putString("keystr", CommonDataAdapter.a().e());
          paramString.putString("uin", String.valueOf(CommonDataAdapter.a().c()));
          paramString.putString("resolution", MobileInfoUtil.getResolution());
          paramString.putString("keytype", "256");
          if (str2.equals("POST"))
          {
            localObject2 = ((JSONObject)localObject2).optJSONObject("params");
            if (localObject2 != null)
            {
              Iterator localIterator = ((JSONObject)localObject2).keys();
              if (localIterator.hasNext())
              {
                String str5 = localIterator.next().toString();
                Object localObject3 = ((JSONObject)localObject2).get(str5);
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("key = ");
                localStringBuilder.append(str5);
                localStringBuilder.append(" value = ");
                localStringBuilder.append(localObject3.toString());
                LogUtility.c("HttpInterface", localStringBuilder.toString());
                if (TextUtils.isEmpty(str5)) {
                  continue;
                }
                paramString.putString(str5, localObject3.toString());
                continue;
              }
            }
          }
          else if (i != 0)
          {
            paramString.putString("needhttpcache", "");
            LogUtility.c("HttpInterface", "use supportEtag");
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("execute asyncTask url >>> ");
          ((StringBuilder)localObject2).append(str1);
          ((StringBuilder)localObject2).append(" methodName ");
          ((StringBuilder)localObject2).append(str2);
          LogUtility.c("HttpInterface", ((StringBuilder)localObject2).toString());
          localObject1 = new HttpCgiAsyncTask(str1, str2, new HttpInterface.JsHttpCallback(this, (WebView)this.mWebViewRef.get(), (String)localObject1, str3, str4, bool));
          aSyncTaskExecute((HttpCgiAsyncTask)localObject1, paramString);
          this.asyncTaskList.add(localObject1);
          return;
        }
      }
      catch (Exception paramString)
      {
        LogUtility.c("HttpInterface", "httpRequest Exception", paramString);
        return;
      }
      catch (JSONException paramString)
      {
        LogUtility.c("HttpInterface", "httpRequest JSONException", paramString);
        return;
      }
      int i = 0;
      continue;
      label507:
      boolean bool = false;
    }
  }
  
  @TargetApi(11)
  protected Executor obtainMultiExecutor()
  {
    if (Build.VERSION.SDK_INT >= 11) {
      return ThreadManager.getNetExcutor();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appcommon.js.HttpInterface
 * JD-Core Version:    0.7.0.1
 */