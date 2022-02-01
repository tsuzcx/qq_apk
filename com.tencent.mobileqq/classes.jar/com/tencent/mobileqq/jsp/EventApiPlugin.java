package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import cooperation.vip.manager.MonitorManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EventApiPlugin
  extends WebViewPlugin
{
  public static volatile BroadcastReceiver b;
  public static AtomicBoolean c = new AtomicBoolean(false);
  public static CopyOnWriteArrayList<WeakReference<EventApiPlugin>> d = null;
  String a = "";
  WeakReference<EventApiPlugin> e = null;
  
  public EventApiPlugin()
  {
    this.mPluginNameSpace = "event";
  }
  
  public static void a(String paramString1, JSONObject paramJSONObject, ArrayList<String> paramArrayList, String paramString2)
  {
    Intent localIntent = new Intent("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    localIntent.putExtra("event", paramString1);
    if (paramJSONObject != null) {
      localIntent.putExtra("data", paramJSONObject.toString());
    }
    localIntent.putStringArrayListExtra("domains", paramArrayList);
    paramString1 = new JSONObject();
    try
    {
      paramString1.put("url", paramString2);
      label61:
      localIntent.putExtra("source", paramString1.toString());
      BaseApplicationImpl.getContext().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      break label61;
    }
  }
  
  public static void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EventApiPlugin", 2, "unRegisterEventReceiver");
    }
    CopyOnWriteArrayList localCopyOnWriteArrayList = d;
    if (localCopyOnWriteArrayList != null) {
      localCopyOnWriteArrayList.clear();
    }
    if ((b != null) && (c.compareAndSet(true, false)))
    {
      BaseApplicationImpl.getApplication().unregisterReceiver(b);
      b = null;
    }
  }
  
  private static void c()
  {
    b = new EventApiPlugin.1();
    if (QLog.isColorLevel()) {
      QLog.d("EventApiPlugin", 2, "init dispatch Event Receiver!");
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    localIntentFilter.addAction("com.tencent.mobileqq.action.closewebview");
    BaseApplicationImpl.getApplication().registerReceiver(b, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
    if (d == null) {
      d = new CopyOnWriteArrayList();
    }
  }
  
  Intent a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    Intent localIntent = new Intent();
    String str = paramJSONObject.optString("action", "");
    if (!TextUtils.isEmpty(str)) {
      localIntent.setAction(str);
    }
    str = paramJSONObject.optString("category", "");
    if (!TextUtils.isEmpty(str)) {
      localIntent.addCategory(str);
    }
    str = paramJSONObject.optString("componentName", "");
    if (!TextUtils.isEmpty(str)) {
      localIntent.setComponent(b(str));
    }
    paramJSONObject = paramJSONObject.getJSONObject("intentExtras");
    if (paramJSONObject != null)
    {
      paramJSONObject = b(paramJSONObject);
      if (paramJSONObject != null) {
        localIntent.putExtras(paramJSONObject);
      }
    }
    return localIntent;
  }
  
  String a()
  {
    if (!TextUtils.isEmpty(this.a)) {
      return this.a;
    }
    Object localObject = this.mRuntime.d();
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(System.currentTimeMillis()));
      localStringBuilder.append(String.valueOf(localObject.hashCode()));
      this.a = localStringBuilder.toString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(String.valueOf(System.currentTimeMillis()));
      ((StringBuilder)localObject).append(String.valueOf((int)(Math.random() * 1000000.0D)));
      this.a = ((StringBuilder)localObject).toString();
    }
    return this.a;
  }
  
  public void a(Context paramContext, Intent paramIntent)
  {
    String str1;
    Object localObject;
    if (paramIntent != null)
    {
      paramContext = this.e;
      if (paramContext != null)
      {
        if (paramContext.get() == null) {
          return;
        }
        if (!paramIntent.getBooleanExtra("broadcast", true)) {
          return;
        }
        paramContext = paramIntent.getStringExtra("unique");
        if ((paramContext != null) && (paramContext.equals(a()))) {
          return;
        }
        str1 = paramIntent.getStringExtra("event");
        if (TextUtils.isEmpty(str1)) {
          return;
        }
        if (str1.equals("closeWebView"))
        {
          this.mRuntime.d().finish();
          return;
        }
        paramContext = paramIntent.getStringExtra("data");
        localObject = null;
        if (paramContext == null) {}
      }
    }
    try
    {
      paramContext = new JSONObject(paramContext);
      break label122;
      paramContext = null;
      label122:
      ArrayList localArrayList = paramIntent.getStringArrayListExtra("domains");
      if (localArrayList == null) {
        return;
      }
      String str2 = paramIntent.getStringExtra("source");
      paramIntent = (Intent)localObject;
      if (str2 != null) {}
      String str3;
      boolean bool;
      int i;
      String str4;
      int j;
      return;
    }
    catch (JSONException paramContext)
    {
      try
      {
        paramIntent = new JSONObject(str2);
        localObject = this.mRuntime.a();
        if (localObject == null) {
          return;
        }
        str2 = ((WebView)localObject).getUrl();
        if (str2 == null) {
          return;
        }
        str3 = Uri.parse(str2).getHost();
        bool = QLog.isColorLevel();
        i = 0;
        if (bool)
        {
          str4 = this.e.toString();
          if (paramContext != null) {
            localObject = paramContext.toString();
          } else {
            localObject = "NULL";
          }
          QLog.d("EventApiPlugin", 2, String.format("onReceive, pluginReference: %s, event: %s, data: %s, domains: %s, source: %s", new Object[] { str4, str1, localObject, TextUtils.join(",", localArrayList), paramIntent }));
        }
        if (((!str1.equals("follow")) && (!str1.equals("unfollow"))) || ((!AuthorizeConfig.a().a(str2, "publicAccount.isFollowUin")) && (!AuthorizeConfig.a().a(str2, "data.isFollowUin"))))
        {
          j = localArrayList.size();
          while (i < j)
          {
            if (AuthorizeConfig.b((String)localArrayList.get(i), str3))
            {
              dispatchJsEvent(str1, paramContext, paramIntent);
              return;
            }
            i += 1;
          }
          return;
        }
        dispatchJsEvent(str1, paramContext, paramIntent);
        return;
      }
      catch (JSONException paramContext) {}
      paramContext = paramContext;
      return;
    }
  }
  
  void a(String paramString)
  {
    if (Build.MANUFACTURER.contains("Xiaomi"))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleMiUIInstallIntercepterEvent,finger print:");
        ((StringBuilder)localObject).append(Build.FINGERPRINT);
        ((StringBuilder)localObject).append(",config:");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("EventApiPlugin", 2, ((StringBuilder)localObject).toString());
      }
      try
      {
        paramString = a(new JSONObject(paramString));
        if ((paramString != null) && (this.mRuntime != null))
        {
          localObject = this.mRuntime.d();
          if (localObject != null)
          {
            ((Activity)localObject).startActivity(paramString);
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("EventApiPlugin", 2, "activity is null.");
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("EventApiPlugin", 2, "intent or runtime is null");
          return;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("error:");
          ((StringBuilder)localObject).append(paramString.toString());
          QLog.d("EventApiPlugin", 2, ((StringBuilder)localObject).toString());
          return;
        }
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("error:");
          ((StringBuilder)localObject).append(paramString.toString());
          QLog.d("EventApiPlugin", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  ComponentName b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("/");
      if ((paramString != null) && (paramString.length == 2)) {
        return new ComponentName(paramString[0], paramString[1]);
      }
    }
    return null;
  }
  
  Bundle b(JSONObject paramJSONObject)
  {
    Iterator localIterator = paramJSONObject.keys();
    if (localIterator != null)
    {
      Bundle localBundle = new Bundle();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!TextUtils.isEmpty(str)) {
          localBundle.putCharSequence(str, paramJSONObject.getString(str));
        }
      }
      return localBundle;
    }
    return null;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934606L)
    {
      paramString = new JSONObject();
      if (paramMap != null) {
        try
        {
          paramString.put("x", (Integer)paramMap.get("X"));
          paramString.put("y", (Integer)paramMap.get("Y"));
        }
        catch (JSONException localJSONException)
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("JSONException, ");
            localStringBuilder.append(paramMap.get("X"));
            localStringBuilder.append(", ");
            localStringBuilder.append(paramMap.get("Y"));
            QLog.d("EventApiPlugin", 2, localStringBuilder.toString());
          }
          localJSONException.printStackTrace();
        }
        catch (ClassCastException localClassCastException)
        {
          StringBuilder localStringBuilder;
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("ClassCastException, ");
            localStringBuilder.append(paramMap.get("X"));
            localStringBuilder.append(", ");
            localStringBuilder.append(paramMap.get("Y"));
            QLog.d("EventApiPlugin", 2, localStringBuilder.toString());
          }
          localClassCastException.printStackTrace();
        }
      }
      dispatchJsEvent("qbrowserTitleBarClick", paramString, null);
      return true;
    }
    if (paramLong == 8589934607L)
    {
      dispatchJsEvent("qbrowserOptionsButtonClick", null, null);
      return true;
    }
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2;
    boolean bool1;
    int i;
    int j;
    if ("event".equals(paramString2)) {
      if (("dispatchEvent".equals(paramString3)) && (paramVarArgs.length == 1) && (this.e != null))
      {
        try
        {
          localObject1 = this.mRuntime.a();
          if (localObject1 == null) {
            return true;
          }
          paramString3 = new JSONObject(paramVarArgs[0]);
          paramString1 = paramString3.optString("event");
          if (TextUtils.isEmpty(paramString1))
          {
            if (!QLog.isColorLevel()) {
              break label677;
            }
            QLog.w("EventApiPlugin", 2, "param event is requested");
            return true;
          }
          paramString2 = paramString3.optJSONObject("data");
          if (paramString2 == null) {
            break label679;
          }
          paramJsBridgeListener = paramString2.toString();
          if ((!TextUtils.isEmpty(paramJsBridgeListener)) && (paramJsBridgeListener.length() >= 460800L))
          {
            paramString1 = new StringBuilder();
            paramString1.append("param data is over size! ");
            paramString1.append(paramJsBridgeListener.length());
            QLog.e("EventApiPlugin", 1, paramString1.toString());
            return true;
          }
          paramVarArgs = paramString3.optJSONObject("options");
          paramString3 = new ArrayList();
          paramJsBridgeListener = new ArrayList();
          localObject1 = ((WebView)localObject1).getUrl();
          if (paramVarArgs == null) {
            break label709;
          }
          bool2 = paramVarArgs.optBoolean("echo", true);
          bool1 = paramVarArgs.optBoolean("broadcast", true);
          localObject2 = paramVarArgs.optJSONArray("domains");
          if (localObject2 == null) {
            break label694;
          }
          i = ((JSONArray)localObject2).length();
          j = 0;
          label255:
          if (j < i)
          {
            String str = ((JSONArray)localObject2).optString(j);
            if (TextUtils.isEmpty(str)) {
              break label685;
            }
            paramString3.add(str);
            break label685;
          }
          label290:
          paramVarArgs = paramVarArgs.optJSONArray("platos");
          if (paramVarArgs == null) {
            break label706;
          }
          j = paramVarArgs.length();
          i = 0;
          label315:
          if (i >= j) {
            break label706;
          }
          localObject2 = paramVarArgs.optString(i);
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label697;
          }
          paramJsBridgeListener.add(localObject2);
        }
        catch (Throwable paramJsBridgeListener)
        {
          Object localObject1;
          Object localObject2;
          label349:
          paramJsBridgeListener.printStackTrace();
          break label673;
        }
        paramVarArgs = new JSONObject();
        paramVarArgs.put("url", localObject1);
        if ((paramString3.size() == 0) && (localObject1 != null))
        {
          localObject1 = Uri.parse((String)localObject1);
          if (((Uri)localObject1).isHierarchical()) {
            paramString3.add(((Uri)localObject1).getHost());
          }
        }
        localObject1 = new Intent("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
        ((Intent)localObject1).putExtra("broadcast", bool1);
        ((Intent)localObject1).putExtra("unique", a());
        ((Intent)localObject1).putExtra("event", paramString1);
        if (paramString2 != null) {
          ((Intent)localObject1).putExtra("data", paramString2.toString());
        }
        ((Intent)localObject1).putStringArrayListExtra("domains", paramString3);
        ((Intent)localObject1).putStringArrayListExtra("platos", paramJsBridgeListener);
        ((Intent)localObject1).putExtra("source", paramVarArgs.toString());
        if (QLog.isColorLevel())
        {
          localObject2 = this.e.toString();
          if (paramString2 == null) {
            break label718;
          }
          paramJsBridgeListener = paramString2.toString();
        }
      }
    }
    for (;;)
    {
      QLog.d("EventApiPlugin", 2, String.format("send event broadcast, pluginReference: %s, event: %s, data: %s, domains: %s, source: %s", new Object[] { localObject2, paramString1, paramJsBridgeListener, TextUtils.join(",", paramString3), paramVarArgs }));
      BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject1, "com.tencent.msg.permission.pushnotify");
      if (bool2) {
        dispatchJsEvent(paramString1, paramString2, paramVarArgs);
      }
      if ("cancelPayDialog".equals(paramString1))
      {
        MonitorManager.a().a(1, 6, "取消支付", "");
        break label673;
        if ("miuiInstallInterceptor".equals(paramString3))
        {
          if ((paramVarArgs.length < 1) && (QLog.isColorLevel()))
          {
            QLog.e("EventApiPlugin", 2, "no arguments.");
            return true;
          }
          a(paramVarArgs[0]);
          return true;
        }
      }
      label673:
      return true;
      return false;
      label677:
      return true;
      label679:
      paramJsBridgeListener = "";
      break;
      label685:
      j += 1;
      break label255;
      label694:
      break label290;
      label697:
      i += 1;
      break label315;
      label706:
      break label349;
      label709:
      bool1 = true;
      bool2 = true;
      break label349;
      label718:
      paramJsBridgeListener = "NULL";
    }
  }
  
  public void onActivityReady()
  {
    if (c.compareAndSet(false, true)) {
      try
      {
        c();
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("error:");
          localStringBuilder2.append(localException.toString());
          QLog.d("EventApiPlugin", 2, localStringBuilder2.toString());
        }
      }
    }
    if ((b != null) && (d != null))
    {
      this.e = new WeakReference(this);
      d.add(this.e);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("put current EventApiPlugin into sDispatchEventPlugins: ");
        localStringBuilder1.append(this.e.toString());
        QLog.d("EventApiPlugin", 2, localStringBuilder1.toString());
      }
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.e != null) && (d != null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("remove current EventApiPlugin from sDispatchEventPlugins: ");
        localStringBuilder.append(this.e.toString());
        QLog.d("EventApiPlugin", 2, localStringBuilder.toString());
      }
      d.remove(this.e);
      this.e = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.EventApiPlugin
 * JD-Core Version:    0.7.0.1
 */