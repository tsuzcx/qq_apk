package com.tencent.open.appcommon.js;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import bcxm;
import bdfo;
import bdfu;
import bdht;
import bdio;
import bdja;
import com.tencent.mobileqq.app.ThreadManager;
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
  public Handler mHandler = new bdfu();
  protected WeakReference<WebView> mWebViewRef;
  protected WebView webView;
  
  public HttpInterface(Activity paramActivity, WebView paramWebView)
  {
    this.webView = paramWebView;
    this.mWebViewRef = new WeakReference(paramWebView);
    this.asyncTaskList = new ArrayList();
  }
  
  @TargetApi(11)
  protected void aSyncTaskExecute(bdio parambdio, Bundle paramBundle)
  {
    Executor localExecutor = obtainMultiExecutor();
    if (localExecutor != null)
    {
      parambdio.executeOnExecutor(localExecutor, new Bundle[] { paramBundle });
      return;
    }
    parambdio.execute(new Bundle[] { paramBundle });
  }
  
  public void clearWebViewCache()
  {
    try
    {
      if (this.webView != null) {
        this.webView.clearCache(true);
      }
      return;
    }
    catch (Exception localException)
    {
      bdht.a("HttpInterface", "clearWebViewCache>>>", localException);
    }
  }
  
  public void destroy()
  {
    int j = this.asyncTaskList.size();
    int i = 0;
    while (i < j)
    {
      AsyncTask localAsyncTask = (AsyncTask)this.asyncTaskList.get(i);
      if ((localAsyncTask != null) && (!localAsyncTask.isCancelled()))
      {
        bdht.c("HttpInterface", "cancel AsyncTask when onDestory");
        localAsyncTask.cancel(true);
        if ((localAsyncTask instanceof bdio)) {
          ((bdio)localAsyncTask).b();
        }
      }
      i += 1;
    }
    if (this.mHandler != null)
    {
      this.mHandler.removeCallbacksAndMessages(null);
      this.mHandler = null;
    }
  }
  
  public String getInterfaceName()
  {
    return "qzone_http";
  }
  
  public void httpRequest(String paramString)
  {
    boolean bool = true;
    if (!hasRight())
    {
      bdht.c("HttpInterface", ">>httpReauest has not right>>");
      return;
    }
    bdht.c("HttpInterface", "httpRequest >>> " + paramString.toString());
    try
    {
      localJSONObject = new JSONObject(paramString);
      localObject1 = localJSONObject.optString("guid");
      str1 = localJSONObject.optString("url");
      str2 = localJSONObject.optString("method");
      str3 = localJSONObject.optString("oncomplate");
      str4 = localJSONObject.optString("onerror");
      if (localJSONObject.optInt("supportetag", 1) != 1) {
        break label328;
      }
      i = 1;
    }
    catch (JSONException paramString)
    {
      String str1;
      String str2;
      String str3;
      String str4;
      int i;
      for (;;)
      {
        JSONObject localJSONObject;
        Iterator localIterator;
        bdht.c("HttpInterface", "httpRequest JSONException", paramString);
        return;
        i = 0;
        continue;
        bool = false;
      }
      if (i == 0) {
        break label360;
      }
      paramString.putString("needhttpcache", "");
      bdht.c("HttpInterface", "use supportEtag");
      bdht.c("HttpInterface", "execute asyncTask url >>> " + str1 + " methodName " + str2);
      Object localObject1 = new bdio(str1, str2, new bdfo(this, (WebView)this.mWebViewRef.get(), (String)localObject1, str3, str4, bool));
      aSyncTaskExecute((bdio)localObject1, paramString);
      this.asyncTaskList.add(localObject1);
      return;
    }
    catch (Exception paramString)
    {
      bdht.c("HttpInterface", "httpRequest Exception", paramString);
    }
    if (localJSONObject.optInt("from_h5", 0) == 1)
    {
      paramString = new Bundle();
      paramString.putBoolean("from_h5", bool);
      paramString.putString("platform", bcxm.a().g());
      paramString.putString("keystr", bcxm.a().a());
      paramString.putString("uin", String.valueOf(bcxm.a().a()));
      paramString.putString("resolution", bdja.e());
      paramString.putString("keytype", "256");
      if (!str2.equals("POST")) {
        break label338;
      }
      localJSONObject = localJSONObject.optJSONObject("params");
      if (localJSONObject == null) {
        break label360;
      }
      localIterator = localJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str5 = localIterator.next().toString();
        Object localObject2 = localJSONObject.get(str5);
        bdht.c("HttpInterface", "key = " + str5 + " value = " + localObject2.toString());
        if (!TextUtils.isEmpty(str5)) {
          paramString.putString(str5, localObject2.toString());
        }
      }
    }
    label328:
    label338:
    label360:
    return;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appcommon.js.HttpInterface
 * JD-Core Version:    0.7.0.1
 */