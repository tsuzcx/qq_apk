package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
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
  public static volatile BroadcastReceiver a;
  public static CopyOnWriteArrayList<WeakReference<EventApiPlugin>> a;
  public static AtomicBoolean a;
  String jdField_a_of_type_JavaLangString = "";
  WeakReference<EventApiPlugin> jdField_a_of_type_JavaLangRefWeakReference = null;
  
  static
  {
    jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = null;
  }
  
  public EventApiPlugin()
  {
    this.mPluginNameSpace = "event";
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EventApiPlugin", 2, "unRegisterEventReceiver");
    }
    if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) {
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    }
    if ((jdField_a_of_type_AndroidContentBroadcastReceiver != null) && (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false)))
    {
      BaseApplicationImpl.getApplication().unregisterReceiver(jdField_a_of_type_AndroidContentBroadcastReceiver);
      jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
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
  
  private static void b()
  {
    jdField_a_of_type_AndroidContentBroadcastReceiver = new EventApiPlugin.1();
    if (QLog.isColorLevel()) {
      QLog.d("EventApiPlugin", 2, "init dispatch Event Receiver!");
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    localIntentFilter.addAction("com.tencent.mobileqq.action.closewebview");
    BaseApplicationImpl.getApplication().registerReceiver(jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
    if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) {
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    }
  }
  
  ComponentName a(String paramString)
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
  
  Intent a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = null;
    }
    Intent localIntent;
    Object localObject;
    do
    {
      do
      {
        return paramJSONObject;
        localIntent = new Intent();
        localObject = paramJSONObject.optString("action", "");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localIntent.setAction((String)localObject);
        }
        localObject = paramJSONObject.optString("category", "");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localIntent.addCategory((String)localObject);
        }
        localObject = paramJSONObject.optString("componentName", "");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localIntent.setComponent(a((String)localObject));
        }
        localObject = paramJSONObject.getJSONObject("intentExtras");
        paramJSONObject = localIntent;
      } while (localObject == null);
      localObject = a((JSONObject)localObject);
      paramJSONObject = localIntent;
    } while (localObject == null);
    localIntent.putExtras((Bundle)localObject);
    return localIntent;
  }
  
  Bundle a(JSONObject paramJSONObject)
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
  
  String a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return this.jdField_a_of_type_JavaLangString;
    }
    Activity localActivity = this.mRuntime.a();
    if (localActivity != null) {}
    for (this.jdField_a_of_type_JavaLangString = (String.valueOf(System.currentTimeMillis()) + String.valueOf(localActivity.hashCode()));; this.jdField_a_of_type_JavaLangString = (String.valueOf(System.currentTimeMillis()) + String.valueOf((int)(Math.random() * 1000000.0D)))) {
      return this.jdField_a_of_type_JavaLangString;
    }
  }
  
  /* Error */
  public void a(android.content.Context paramContext, Intent paramIntent)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: iconst_0
    //   4: istore_3
    //   5: aload_2
    //   6: ifnull +20 -> 26
    //   9: aload_0
    //   10: getfield 35	com/tencent/mobileqq/jsp/EventApiPlugin:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   13: ifnull +13 -> 26
    //   16: aload_0
    //   17: getfield 35	com/tencent/mobileqq/jsp/EventApiPlugin:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   20: invokevirtual 275	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   23: ifnonnull +4 -> 27
    //   26: return
    //   27: aload_2
    //   28: ldc_w 277
    //   31: iconst_1
    //   32: invokevirtual 281	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   35: ifeq -9 -> 26
    //   38: aload_2
    //   39: ldc_w 283
    //   42: invokevirtual 286	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull +14 -> 61
    //   50: aload_1
    //   51: aload_0
    //   52: invokevirtual 288	com/tencent/mobileqq/jsp/EventApiPlugin:a	()Ljava/lang/String;
    //   55: invokevirtual 292	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   58: ifne -32 -> 26
    //   61: aload_2
    //   62: ldc 37
    //   64: invokevirtual 286	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   67: astore 6
    //   69: aload 6
    //   71: invokestatic 150	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   74: ifne -48 -> 26
    //   77: aload 6
    //   79: ldc_w 294
    //   82: invokevirtual 292	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   85: ifeq +14 -> 99
    //   88: aload_0
    //   89: getfield 229	com/tencent/mobileqq/jsp/EventApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   92: invokevirtual 234	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   95: invokevirtual 299	android/app/Activity:finish	()V
    //   98: return
    //   99: aload_2
    //   100: ldc 89
    //   102: invokevirtual 286	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   105: astore_1
    //   106: aload_1
    //   107: ifnull +275 -> 382
    //   110: new 91	org/json/JSONObject
    //   113: dup
    //   114: aload_1
    //   115: invokespecial 300	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   118: astore_1
    //   119: aload_2
    //   120: ldc 97
    //   122: invokevirtual 304	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   125: astore 7
    //   127: aload 7
    //   129: ifnull -103 -> 26
    //   132: aload_2
    //   133: ldc 110
    //   135: invokevirtual 286	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   138: astore 8
    //   140: aload 5
    //   142: astore_2
    //   143: aload 8
    //   145: ifnull +13 -> 158
    //   148: new 91	org/json/JSONObject
    //   151: dup
    //   152: aload 8
    //   154: invokespecial 300	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   157: astore_2
    //   158: aload_0
    //   159: getfield 229	com/tencent/mobileqq/jsp/EventApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   162: invokevirtual 307	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   165: astore 5
    //   167: aload 5
    //   169: ifnull -143 -> 26
    //   172: aload 5
    //   174: invokevirtual 312	com/tencent/smtt/sdk/WebView:getUrl	()Ljava/lang/String;
    //   177: astore 8
    //   179: aload 8
    //   181: ifnull -155 -> 26
    //   184: aload 8
    //   186: invokestatic 318	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   189: invokevirtual 321	android/net/Uri:getHost	()Ljava/lang/String;
    //   192: astore 9
    //   194: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   197: ifeq +68 -> 265
    //   200: aload_0
    //   201: getfield 35	com/tencent/mobileqq/jsp/EventApiPlugin:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   204: invokevirtual 322	java/lang/Object:toString	()Ljava/lang/String;
    //   207: astore 10
    //   209: aload_1
    //   210: ifnull +114 -> 324
    //   213: aload_1
    //   214: invokevirtual 95	org/json/JSONObject:toString	()Ljava/lang/String;
    //   217: astore 5
    //   219: ldc 48
    //   221: iconst_2
    //   222: ldc_w 324
    //   225: iconst_5
    //   226: anewarray 253	java/lang/Object
    //   229: dup
    //   230: iconst_0
    //   231: aload 10
    //   233: aastore
    //   234: dup
    //   235: iconst_1
    //   236: aload 6
    //   238: aastore
    //   239: dup
    //   240: iconst_2
    //   241: aload 5
    //   243: aastore
    //   244: dup
    //   245: iconst_3
    //   246: ldc_w 326
    //   249: aload 7
    //   251: invokestatic 330	android/text/TextUtils:join	(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
    //   254: aastore
    //   255: dup
    //   256: iconst_4
    //   257: aload_2
    //   258: aastore
    //   259: invokestatic 334	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   262: invokestatic 54	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   265: aload 6
    //   267: ldc_w 336
    //   270: invokevirtual 292	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   273: ifne +14 -> 287
    //   276: aload 6
    //   278: ldc_w 338
    //   281: invokevirtual 292	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   284: ifeq +48 -> 332
    //   287: invokestatic 343	com/tencent/biz/AuthorizeConfig:a	()Lcom/tencent/biz/AuthorizeConfig;
    //   290: aload 8
    //   292: ldc_w 345
    //   295: invokevirtual 348	com/tencent/biz/AuthorizeConfig:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   298: ifne +17 -> 315
    //   301: invokestatic 343	com/tencent/biz/AuthorizeConfig:a	()Lcom/tencent/biz/AuthorizeConfig;
    //   304: aload 8
    //   306: ldc_w 350
    //   309: invokevirtual 348	com/tencent/biz/AuthorizeConfig:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   312: ifeq +20 -> 332
    //   315: aload_0
    //   316: aload 6
    //   318: aload_1
    //   319: aload_2
    //   320: invokevirtual 354	com/tencent/mobileqq/jsp/EventApiPlugin:dispatchJsEvent	(Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;)V
    //   323: return
    //   324: ldc_w 356
    //   327: astore 5
    //   329: goto -110 -> 219
    //   332: aload 7
    //   334: invokevirtual 361	java/util/ArrayList:size	()I
    //   337: istore 4
    //   339: iload_3
    //   340: iload 4
    //   342: if_icmpge -316 -> 26
    //   345: aload 7
    //   347: iload_3
    //   348: invokevirtual 364	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   351: checkcast 154	java/lang/String
    //   354: aload 9
    //   356: invokestatic 366	com/tencent/biz/AuthorizeConfig:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   359: ifeq +12 -> 371
    //   362: aload_0
    //   363: aload 6
    //   365: aload_1
    //   366: aload_2
    //   367: invokevirtual 354	com/tencent/mobileqq/jsp/EventApiPlugin:dispatchJsEvent	(Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;)V
    //   370: return
    //   371: iload_3
    //   372: iconst_1
    //   373: iadd
    //   374: istore_3
    //   375: goto -36 -> 339
    //   378: astore_1
    //   379: return
    //   380: astore_1
    //   381: return
    //   382: aconst_null
    //   383: astore_1
    //   384: goto -265 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	387	0	this	EventApiPlugin
    //   0	387	1	paramContext	android.content.Context
    //   0	387	2	paramIntent	Intent
    //   4	371	3	i	int
    //   337	6	4	j	int
    //   1	327	5	localObject	Object
    //   67	297	6	str1	String
    //   125	221	7	localArrayList	ArrayList
    //   138	167	8	str2	String
    //   192	163	9	str3	String
    //   207	25	10	str4	String
    // Exception table:
    //   from	to	target	type
    //   148	158	378	org/json/JSONException
    //   110	119	380	org/json/JSONException
  }
  
  void a(String paramString)
  {
    if ((!Build.MANUFACTURER.contains("Xiaomi")) || (TextUtils.isEmpty(paramString))) {}
    label196:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.e("EventApiPlugin", 2, "handleMiUIInstallIntercepterEvent,finger print:" + Build.FINGERPRINT + ",config:" + paramString);
          }
          try
          {
            paramString = a(new JSONObject(paramString));
            if ((paramString == null) || (this.mRuntime == null)) {
              break label196;
            }
            Activity localActivity = this.mRuntime.a();
            if (localActivity != null)
            {
              localActivity.startActivity(paramString);
              return;
            }
          }
          catch (JSONException paramString)
          {
            if (QLog.isColorLevel())
            {
              QLog.d("EventApiPlugin", 2, "error:" + paramString.toString());
              return;
              if (QLog.isColorLevel())
              {
                QLog.d("EventApiPlugin", 2, "activity is null.");
                return;
              }
            }
          }
          catch (Exception paramString) {}
        }
      } while (!QLog.isColorLevel());
      QLog.d("EventApiPlugin", 2, "error:" + paramString.toString());
      return;
    } while (!QLog.isColorLevel());
    QLog.d("EventApiPlugin", 2, "intent or runtime is null");
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934606L)
    {
      paramString = new JSONObject();
      if (paramMap != null) {}
      try
      {
        paramString.put("x", (Integer)paramMap.get("X"));
        paramString.put("y", (Integer)paramMap.get("Y"));
        dispatchJsEvent("qbrowserTitleBarClick", paramString, null);
        return true;
      }
      catch (ClassCastException localClassCastException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("EventApiPlugin", 2, "ClassCastException, " + paramMap.get("X") + ", " + paramMap.get("Y"));
          }
          localClassCastException.printStackTrace();
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("EventApiPlugin", 2, "JSONException, " + paramMap.get("X") + ", " + paramMap.get("Y"));
          }
          localJSONException.printStackTrace();
        }
      }
    }
    if (paramLong == 8589934607L)
    {
      dispatchJsEvent("qbrowserOptionsButtonClick", null, null);
      return true;
    }
    return false;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("event".equals(paramString2)) {
      if ((!"dispatchEvent".equals(paramString3)) || (paramVarArgs.length != 1) || (this.jdField_a_of_type_JavaLangRefWeakReference == null)) {}
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = this.mRuntime.a();
        if (localObject1 == null) {
          return true;
        }
        paramString3 = new JSONObject(paramVarArgs[0]);
        paramString1 = paramString3.optString("event");
        if (TextUtils.isEmpty(paramString1))
        {
          if (!QLog.isColorLevel()) {
            break label696;
          }
          QLog.w("EventApiPlugin", 2, "param event is requested");
          break label696;
        }
        paramString2 = paramString3.optJSONObject("data");
        if (paramString2 == null) {
          break label698;
        }
        paramJsBridgeListener = paramString2.toString();
        if ((!TextUtils.isEmpty(paramJsBridgeListener)) && (paramJsBridgeListener.length() >= 460800L))
        {
          QLog.e("EventApiPlugin", 1, "param data is over size! " + paramJsBridgeListener.length());
          return true;
        }
        paramVarArgs = paramString3.optJSONObject("options");
        int k = 1;
        boolean bool1 = true;
        paramString3 = new ArrayList();
        paramJsBridgeListener = new ArrayList();
        localObject1 = ((WebView)localObject1).getUrl();
        Object localObject2;
        if (paramVarArgs != null)
        {
          boolean bool2 = paramVarArgs.optBoolean("echo", true);
          boolean bool3 = paramVarArgs.optBoolean("broadcast", true);
          localObject2 = paramVarArgs.optJSONArray("domains");
          int j;
          if (localObject2 != null)
          {
            i = 0;
            j = ((JSONArray)localObject2).length();
            if (i < j)
            {
              String str = ((JSONArray)localObject2).optString(i);
              if (TextUtils.isEmpty(str)) {
                break label704;
              }
              paramString3.add(str);
              break label704;
            }
          }
          paramVarArgs = paramVarArgs.optJSONArray("platos");
          bool1 = bool3;
          k = bool2;
          if (paramVarArgs != null)
          {
            i = 0;
            j = paramVarArgs.length();
            bool1 = bool3;
            k = bool2;
            if (i < j)
            {
              localObject2 = paramVarArgs.optString(i);
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                break label713;
              }
              paramJsBridgeListener.add(localObject2);
              break label713;
            }
          }
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
          localObject2 = this.jdField_a_of_type_JavaLangRefWeakReference.toString();
          if (paramString2 != null)
          {
            paramJsBridgeListener = paramString2.toString();
            QLog.d("EventApiPlugin", 2, String.format("send event broadcast, pluginReference: %s, event: %s, data: %s, domains: %s, source: %s", new Object[] { localObject2, paramString1, paramJsBridgeListener, TextUtils.join(",", paramString3), paramVarArgs }));
          }
        }
        else
        {
          BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject1, "com.tencent.msg.permission.pushnotify");
          if (k != 0) {
            dispatchJsEvent(paramString1, paramString2, paramVarArgs);
          }
          if (!"cancelPayDialog".equals(paramString1)) {
            break;
          }
          MonitorManager.a().a(1, 6, "取消支付", "");
          break;
        }
        paramJsBridgeListener = "NULL";
        continue;
        if (!"miuiInstallInterceptor".equals(paramString3)) {
          break;
        }
      }
      catch (Throwable paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
      }
      if ((paramVarArgs.length < 1) && (QLog.isColorLevel()))
      {
        QLog.e("EventApiPlugin", 2, "no arguments.");
        return true;
      }
      a(paramVarArgs[0]);
      return true;
      return false;
      label696:
      return true;
      label698:
      paramJsBridgeListener = "";
      continue;
      label704:
      i += 1;
      continue;
      label713:
      i += 1;
    }
    return true;
  }
  
  public void onActivityReady()
  {
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {}
    try
    {
      b();
      if ((jdField_a_of_type_AndroidContentBroadcastReceiver != null) && (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null))
      {
        this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
        jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(this.jdField_a_of_type_JavaLangRefWeakReference);
        if (QLog.isColorLevel()) {
          QLog.d("EventApiPlugin", 2, "put current EventApiPlugin into sDispatchEventPlugins: " + this.jdField_a_of_type_JavaLangRefWeakReference.toString());
        }
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EventApiPlugin", 2, "error:" + localException.toString());
        }
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EventApiPlugin", 2, "remove current EventApiPlugin from sDispatchEventPlugins: " + this.jdField_a_of_type_JavaLangRefWeakReference.toString());
      }
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(this.jdField_a_of_type_JavaLangRefWeakReference);
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.EventApiPlugin
 * JD-Core Version:    0.7.0.1
 */