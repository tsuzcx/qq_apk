package com.tencent.mobileqq.intervideo.huayang.impl;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.intervideo.huayang.IHuayangJsPlugin;
import com.tencent.mobileqq.intervideo.huayang.Monitor;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class HuayangJsPluginImpl
  extends WebViewPlugin
  implements IHuayangJsPlugin
{
  private static final String ACTION_BACK_NOTIFY = "com.tencent.mobileqq.intervideo.backPressed";
  private static final String ACTION_CACHE_USER_NOTIFY = "com.tencent.mobileqq.intervideo.userCacheState";
  private static final String ACTION_DOWNLOAD_NOTIFY = "com.tencent.mobileqq.intervideo.huayang.downloadPreLoad";
  private static final String ACTION_HY_LAUHCHER_NOTIFY = "com.tencent.mobileqq.huayang.launcher";
  public static final String ACTION_JS_CHECK_VERSION = "checkVersion";
  public static final String ACTION_JS_DOWNLOAD = "download";
  public static final String ACTION_JS_SIIENT_DOWNLOAD = "slientDownload";
  public static final String EXTRA_KEY_DOWNLOAD_PROGRESS = "key_progress";
  public static final String EXTRA_KEY_DOWNLOAD_TOTALSIZE = "key_totalSize";
  public static final String EXTRA_KEY_ERRORMSG = "key_error_msg";
  public static final String EXTRA_KEY_INSTALLED_PLUGIN = "key_installedplugin";
  public static final String EXTRA_KEY_ISCACHE = "key_isCache";
  public static final String EXTRA_KEY_SATTE = "key_state";
  public static final String NAMESPACE = "huayang";
  public static final int STATE_CHECK_VERSION = 0;
  public static final int STATE_DOWANLOADING = 1;
  public static final int STATE_DOWANLODAD_COMPLETE = 2;
  public static final int STATE_DOWANLODAD_FAILED = 3;
  public static final int STATE_LAUNCHERING = 8;
  public static final int STATE_LAUNCHER_FAILED = 10;
  public static final int STATE_LAUNCHER_SUCC = 9;
  public static final int STATE_LOADING = 4;
  public static final int STATE_LOAD_COMPLETE = 6;
  public static final int STATE_LOAD_FALIED = 7;
  public static final int STATE_PRELOAD_FALIED = 5;
  public static final int STATE_STOP_LOAD = 10;
  private static final String TAG = "HuayangJsPlugin";
  private String appType = null;
  private String mAction;
  private int mCacheUserState = -1;
  protected TroopMemberApiClient mClient = null;
  protected Context mContext;
  private int mCurrentProgress;
  protected BroadcastReceiver mHuayangPluginBroadcastReceiver = new HuayangJsPluginImpl.1(this);
  protected String mJsNotifyCallback;
  private long mStartTime;
  private int mState;
  private Handler mUIHandler = new HuayangJsPluginImpl.2(this, Looper.getMainLooper());
  protected String pluginPackageName;
  
  public HuayangJsPluginImpl()
  {
    this.mPluginNameSpace = "huayang";
  }
  
  private JSONObject getCallJsStateJson(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.putOpt("state", Integer.valueOf(paramInt));
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  private void log(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HuayangJsPlugin", 2, paramString);
    }
  }
  
  private void unregisterBroadcast()
  {
    try
    {
      this.mContext.unregisterReceiver(this.mHuayangPluginBroadcastReceiver);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public String getBackNotifyAction(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.mobileqq.intervideo.backPressed");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public String getCacheUserNotifyAction(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.mobileqq.intervideo.userCacheState");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public String getDownloadNotifyAction(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.mobileqq.intervideo.huayang.downloadPreLoad");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public String getLauncherNotifyAction(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.mobileqq.huayang.launcher");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  /* Error */
  protected boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 49
    //   2: aload_3
    //   3: invokevirtual 223	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifne +14 -> 20
    //   9: ldc 225
    //   11: aload_3
    //   12: invokevirtual 223	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15: ifne +5 -> 20
    //   18: iconst_0
    //   19: ireturn
    //   20: new 201	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   27: astore_2
    //   28: aload_2
    //   29: ldc 227
    //   31: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_2
    //   36: aload 4
    //   38: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_2
    //   43: ldc 229
    //   45: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload 5
    //   51: ifnull +17 -> 68
    //   54: aload 5
    //   56: arraylength
    //   57: ifle +11 -> 68
    //   60: aload 5
    //   62: iconst_0
    //   63: aaload
    //   64: astore_1
    //   65: goto +6 -> 71
    //   68: ldc 231
    //   70: astore_1
    //   71: aload_2
    //   72: aload_1
    //   73: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload_0
    //   78: aload_2
    //   79: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokespecial 143	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:log	(Ljava/lang/String;)V
    //   85: ldc 233
    //   87: aload 4
    //   89: invokevirtual 223	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   92: ifeq +644 -> 736
    //   95: ldc 235
    //   97: invokestatic 240	com/tencent/mobileqq/intervideo/huayang/Monitor:a	(Ljava/lang/String;)V
    //   100: aload 5
    //   102: ifnull +542 -> 644
    //   105: aload 5
    //   107: arraylength
    //   108: ifle +536 -> 644
    //   111: new 160	org/json/JSONObject
    //   114: dup
    //   115: aload 5
    //   117: iconst_0
    //   118: aaload
    //   119: invokespecial 242	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   122: astore_3
    //   123: aload_3
    //   124: ldc 244
    //   126: invokevirtual 247	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   129: astore_1
    //   130: aload_3
    //   131: ldc 249
    //   133: invokevirtual 247	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   136: astore 10
    //   138: aload_0
    //   139: aload_3
    //   140: ldc 251
    //   142: invokevirtual 247	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   145: putfield 253	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:mJsNotifyCallback	Ljava/lang/String;
    //   148: aload_0
    //   149: aload_3
    //   150: ldc 255
    //   152: invokevirtual 247	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   155: putfield 152	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:mAction	Ljava/lang/String;
    //   158: aload_0
    //   159: aload_3
    //   160: ldc_w 256
    //   163: invokevirtual 247	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   166: putfield 258	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:pluginPackageName	Ljava/lang/String;
    //   169: aload_3
    //   170: ldc_w 260
    //   173: invokevirtual 247	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   176: astore_2
    //   177: aload_0
    //   178: aload_3
    //   179: ldc_w 261
    //   182: invokevirtual 247	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   185: putfield 101	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:appType	Ljava/lang/String;
    //   188: aload_3
    //   189: ldc_w 263
    //   192: invokevirtual 247	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   195: astore 4
    //   197: aload_3
    //   198: ldc_w 265
    //   201: invokevirtual 247	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   204: astore 5
    //   206: aload_3
    //   207: ldc_w 267
    //   210: invokevirtual 271	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   213: istore 6
    //   215: iload 6
    //   217: i2l
    //   218: lstore 7
    //   220: aload 5
    //   222: invokestatic 277	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   225: ifne +99 -> 324
    //   228: new 279	android/content/Intent
    //   231: dup
    //   232: aload_0
    //   233: getfield 191	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:mContext	Landroid/content/Context;
    //   236: ldc_w 281
    //   239: invokespecial 284	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   242: astore_3
    //   243: aload_3
    //   244: ldc_w 267
    //   247: lload 7
    //   249: invokevirtual 288	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   252: pop
    //   253: aload_3
    //   254: ldc_w 290
    //   257: aload_0
    //   258: getfield 101	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:appType	Ljava/lang/String;
    //   261: invokevirtual 293	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   264: pop
    //   265: aload_3
    //   266: ldc_w 256
    //   269: aload_0
    //   270: getfield 258	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:pluginPackageName	Ljava/lang/String;
    //   273: invokevirtual 293	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   276: pop
    //   277: aload_3
    //   278: ldc_w 260
    //   281: aload_2
    //   282: invokevirtual 293	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   285: pop
    //   286: aload_3
    //   287: ldc 255
    //   289: aload_0
    //   290: getfield 152	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:mAction	Ljava/lang/String;
    //   293: invokevirtual 293	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   296: pop
    //   297: aload_3
    //   298: ldc 249
    //   300: aload 10
    //   302: invokevirtual 293	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   305: pop
    //   306: aload_3
    //   307: ldc_w 294
    //   310: invokevirtual 298	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   313: pop
    //   314: aload_0
    //   315: getfield 191	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:mContext	Landroid/content/Context;
    //   318: aload_3
    //   319: invokevirtual 302	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   322: iconst_1
    //   323: ireturn
    //   324: aload_2
    //   325: astore_3
    //   326: aload_0
    //   327: getfield 191	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:mContext	Landroid/content/Context;
    //   330: aload_0
    //   331: getfield 101	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:appType	Ljava/lang/String;
    //   334: aload 4
    //   336: invokestatic 307	com/tencent/mobileqq/intervideo/huayang/MonitorConfig:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   339: aload_1
    //   340: astore 4
    //   342: aload 10
    //   344: astore 9
    //   346: aload_3
    //   347: astore 5
    //   349: aload 10
    //   351: ifnull +155 -> 506
    //   354: aload 10
    //   356: ldc_w 309
    //   359: invokestatic 315	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   362: astore 4
    //   364: aload 4
    //   366: astore_2
    //   367: goto +148 -> 515
    //   370: astore 4
    //   372: aload 4
    //   374: invokevirtual 316	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   377: aconst_null
    //   378: astore_2
    //   379: goto +136 -> 515
    //   382: aload_2
    //   383: astore 5
    //   385: astore_2
    //   386: aload_1
    //   387: astore_3
    //   388: aload 10
    //   390: astore 4
    //   392: aload 5
    //   394: astore_1
    //   395: goto +69 -> 464
    //   398: astore_3
    //   399: aload_2
    //   400: astore 5
    //   402: aload_3
    //   403: astore_2
    //   404: aload_1
    //   405: astore_3
    //   406: aload 10
    //   408: astore 4
    //   410: aload 5
    //   412: astore_1
    //   413: goto +51 -> 464
    //   416: astore_3
    //   417: aload_2
    //   418: astore 5
    //   420: aload_3
    //   421: astore_2
    //   422: aload_1
    //   423: astore_3
    //   424: aload 10
    //   426: astore 4
    //   428: aload 5
    //   430: astore_1
    //   431: goto +33 -> 464
    //   434: astore_2
    //   435: aconst_null
    //   436: astore 5
    //   438: aload_1
    //   439: astore_3
    //   440: aload 10
    //   442: astore 4
    //   444: aload 5
    //   446: astore_1
    //   447: goto +17 -> 464
    //   450: astore_2
    //   451: aload_1
    //   452: astore_3
    //   453: goto +6 -> 459
    //   456: astore_2
    //   457: aconst_null
    //   458: astore_3
    //   459: aconst_null
    //   460: astore 4
    //   462: aconst_null
    //   463: astore_1
    //   464: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   467: ifeq +14 -> 481
    //   470: ldc 76
    //   472: iconst_2
    //   473: aload_2
    //   474: iconst_0
    //   475: anewarray 318	java/lang/Object
    //   478: invokestatic 322	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   481: ldc_w 324
    //   484: invokestatic 330	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   487: checkcast 324	com/tencent/mobileqq/intervideo/huayang/IHuayangCrashReport
    //   490: aload_2
    //   491: invokeinterface 334 2 0
    //   496: aload_1
    //   497: astore 5
    //   499: aload 4
    //   501: astore 9
    //   503: aload_3
    //   504: astore 4
    //   506: aload 9
    //   508: astore_2
    //   509: aload 5
    //   511: astore_3
    //   512: aload 4
    //   514: astore_1
    //   515: aload_0
    //   516: getfield 258	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:pluginPackageName	Ljava/lang/String;
    //   519: invokestatic 277	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   522: ifeq +10 -> 532
    //   525: aload_0
    //   526: ldc_w 336
    //   529: putfield 258	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:pluginPackageName	Ljava/lang/String;
    //   532: new 338	android/content/IntentFilter
    //   535: dup
    //   536: ldc 6
    //   538: invokestatic 330	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   541: checkcast 6	com/tencent/mobileqq/intervideo/huayang/IHuayangJsPlugin
    //   544: aload_0
    //   545: getfield 258	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:pluginPackageName	Ljava/lang/String;
    //   548: invokeinterface 340 2 0
    //   553: invokespecial 341	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   556: astore 4
    //   558: aload 4
    //   560: ldc 6
    //   562: invokestatic 330	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   565: checkcast 6	com/tencent/mobileqq/intervideo/huayang/IHuayangJsPlugin
    //   568: aload_0
    //   569: getfield 258	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:pluginPackageName	Ljava/lang/String;
    //   572: invokeinterface 343 2 0
    //   577: invokevirtual 346	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   580: aload 4
    //   582: ldc 6
    //   584: invokestatic 330	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   587: checkcast 6	com/tencent/mobileqq/intervideo/huayang/IHuayangJsPlugin
    //   590: aload_0
    //   591: getfield 258	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:pluginPackageName	Ljava/lang/String;
    //   594: invokeinterface 348 2 0
    //   599: invokevirtual 346	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   602: aload 4
    //   604: ldc 6
    //   606: invokestatic 330	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   609: checkcast 6	com/tencent/mobileqq/intervideo/huayang/IHuayangJsPlugin
    //   612: aload_0
    //   613: getfield 258	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:pluginPackageName	Ljava/lang/String;
    //   616: invokeinterface 350 2 0
    //   621: invokevirtual 346	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   624: aload_0
    //   625: getfield 191	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:mContext	Landroid/content/Context;
    //   628: aload_0
    //   629: getfield 110	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:mHuayangPluginBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   632: aload 4
    //   634: invokevirtual 354	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   637: pop
    //   638: aload_2
    //   639: astore 4
    //   641: goto +14 -> 655
    //   644: aconst_null
    //   645: astore_2
    //   646: aload_2
    //   647: astore_1
    //   648: aload_1
    //   649: astore_3
    //   650: aload_1
    //   651: astore 4
    //   653: aload_2
    //   654: astore_1
    //   655: aload_0
    //   656: invokestatic 360	java/lang/System:currentTimeMillis	()J
    //   659: putfield 362	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:mStartTime	J
    //   662: aload_0
    //   663: getfield 99	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:mClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   666: aload_0
    //   667: getfield 101	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:appType	Ljava/lang/String;
    //   670: aload_1
    //   671: aload 4
    //   673: aload_0
    //   674: getfield 152	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:mAction	Ljava/lang/String;
    //   677: aload_0
    //   678: getfield 258	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:pluginPackageName	Ljava/lang/String;
    //   681: aload_3
    //   682: invokevirtual 367	com/tencent/biz/troop/TroopMemberApiClient:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   685: ldc 49
    //   687: ldc_w 369
    //   690: aload_0
    //   691: getfield 131	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:mState	I
    //   694: invokestatic 360	java/lang/System:currentTimeMillis	()J
    //   697: aload_0
    //   698: getfield 362	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:mStartTime	J
    //   701: lsub
    //   702: l2i
    //   703: iconst_4
    //   704: anewarray 219	java/lang/String
    //   707: dup
    //   708: iconst_0
    //   709: aload_0
    //   710: getfield 152	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:mAction	Ljava/lang/String;
    //   713: aastore
    //   714: dup
    //   715: iconst_1
    //   716: aconst_null
    //   717: aastore
    //   718: dup
    //   719: iconst_2
    //   720: aload_0
    //   721: getfield 258	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:pluginPackageName	Ljava/lang/String;
    //   724: aastore
    //   725: dup
    //   726: iconst_3
    //   727: ldc_w 371
    //   730: aastore
    //   731: invokestatic 376	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   734: iconst_1
    //   735: ireturn
    //   736: ldc_w 378
    //   739: aload 4
    //   741: invokevirtual 223	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   744: ifeq +174 -> 918
    //   747: aload_0
    //   748: getfield 99	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:mClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   751: aload_0
    //   752: getfield 258	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:pluginPackageName	Ljava/lang/String;
    //   755: aload_0
    //   756: getfield 101	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:appType	Ljava/lang/String;
    //   759: invokevirtual 382	com/tencent/biz/troop/TroopMemberApiClient:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   762: ldc 6
    //   764: invokestatic 330	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   767: checkcast 6	com/tencent/mobileqq/intervideo/huayang/IHuayangJsPlugin
    //   770: aload_0
    //   771: getfield 258	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:pluginPackageName	Ljava/lang/String;
    //   774: invokeinterface 386 2 0
    //   779: ifeq +12 -> 791
    //   782: ldc_w 388
    //   785: invokestatic 240	com/tencent/mobileqq/intervideo/huayang/Monitor:a	(Ljava/lang/String;)V
    //   788: goto +71 -> 859
    //   791: ldc 6
    //   793: invokestatic 330	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   796: checkcast 6	com/tencent/mobileqq/intervideo/huayang/IHuayangJsPlugin
    //   799: aload_0
    //   800: getfield 258	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:pluginPackageName	Ljava/lang/String;
    //   803: invokeinterface 391 2 0
    //   808: ifeq +12 -> 820
    //   811: ldc_w 393
    //   814: invokestatic 240	com/tencent/mobileqq/intervideo/huayang/Monitor:a	(Ljava/lang/String;)V
    //   817: goto +42 -> 859
    //   820: getstatic 396	com/tencent/mobileqq/intervideo/huayang/MonitorConfig:a	Ljava/util/Map;
    //   823: aload_0
    //   824: getfield 101	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:appType	Ljava/lang/String;
    //   827: invokeinterface 402 2 0
    //   832: ifnull +27 -> 859
    //   835: getstatic 396	com/tencent/mobileqq/intervideo/huayang/MonitorConfig:a	Ljava/util/Map;
    //   838: aload_0
    //   839: getfield 101	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:appType	Ljava/lang/String;
    //   842: invokeinterface 402 2 0
    //   847: checkcast 304	com/tencent/mobileqq/intervideo/huayang/MonitorConfig
    //   850: getfield 405	com/tencent/mobileqq/intervideo/huayang/MonitorConfig:i	I
    //   853: invokestatic 408	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   856: invokestatic 411	com/tencent/mobileqq/intervideo/huayang/Monitor:b	(Ljava/lang/String;)V
    //   859: aload_0
    //   860: invokespecial 413	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:unregisterBroadcast	()V
    //   863: ldc 49
    //   865: ldc_w 378
    //   868: aload_0
    //   869: getfield 131	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:mState	I
    //   872: invokestatic 360	java/lang/System:currentTimeMillis	()J
    //   875: aload_0
    //   876: getfield 362	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:mStartTime	J
    //   879: lsub
    //   880: l2i
    //   881: iconst_4
    //   882: anewarray 219	java/lang/String
    //   885: dup
    //   886: iconst_0
    //   887: aload_0
    //   888: getfield 103	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:mCacheUserState	I
    //   891: invokestatic 408	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   894: aastore
    //   895: dup
    //   896: iconst_1
    //   897: aconst_null
    //   898: aastore
    //   899: dup
    //   900: iconst_2
    //   901: aload_0
    //   902: getfield 258	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:pluginPackageName	Ljava/lang/String;
    //   905: aastore
    //   906: dup
    //   907: iconst_3
    //   908: ldc_w 371
    //   911: aastore
    //   912: invokestatic 376	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   915: goto +68 -> 983
    //   918: ldc_w 415
    //   921: aload 4
    //   923: invokevirtual 223	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   926: ifeq +57 -> 983
    //   929: new 279	android/content/Intent
    //   932: dup
    //   933: aload_0
    //   934: getfield 191	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:mContext	Landroid/content/Context;
    //   937: ldc_w 281
    //   940: invokespecial 284	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   943: astore_1
    //   944: aload_1
    //   945: ldc_w 294
    //   948: invokevirtual 298	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   951: pop
    //   952: aload_1
    //   953: ldc_w 417
    //   956: aload 5
    //   958: iconst_0
    //   959: aaload
    //   960: invokevirtual 293	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   963: pop
    //   964: aload_1
    //   965: ldc_w 419
    //   968: iconst_1
    //   969: invokevirtual 422	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   972: pop
    //   973: aload_0
    //   974: getfield 191	com/tencent/mobileqq/intervideo/huayang/impl/HuayangJsPluginImpl:mContext	Landroid/content/Context;
    //   977: aload_1
    //   978: invokevirtual 302	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   981: iconst_0
    //   982: ireturn
    //   983: iconst_0
    //   984: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	985	0	this	HuayangJsPluginImpl
    //   0	985	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	985	2	paramString1	String
    //   0	985	3	paramString2	String
    //   0	985	4	paramString3	String
    //   0	985	5	paramVarArgs	String[]
    //   213	3	6	i	int
    //   218	30	7	l	long
    //   344	163	9	str1	String
    //   136	305	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   354	364	370	java/io/UnsupportedEncodingException
    //   277	322	382	org/json/JSONException
    //   326	339	382	org/json/JSONException
    //   354	364	382	org/json/JSONException
    //   372	377	382	org/json/JSONException
    //   220	277	398	org/json/JSONException
    //   177	215	416	org/json/JSONException
    //   138	177	434	org/json/JSONException
    //   130	138	450	org/json/JSONException
    //   111	130	456	org/json/JSONException
  }
  
  public WebViewPlugin init()
  {
    this.mPluginNameSpace = "huayang";
    return this;
  }
  
  public boolean isHyPkg(String paramString)
  {
    return TextUtils.equals(paramString, "com.tencent.huayang");
  }
  
  public boolean isODPkg(String paramString)
  {
    return TextUtils.equals(paramString, "com.tencent.od");
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.mClient = TroopMemberApiClient.a();
    this.mClient.e();
    this.mContext = this.mRuntime.d().getApplicationContext();
    log(" onCreate");
  }
  
  protected void onDestroy()
  {
    TroopMemberApiClient localTroopMemberApiClient = this.mClient;
    if (localTroopMemberApiClient != null)
    {
      localTroopMemberApiClient.c(this.pluginPackageName, this.appType);
      this.mClient.f();
    }
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("HuayangJsPlugin", 2, " onDestroy");
    }
    Monitor.a("2597860");
    unregisterBroadcast();
    this.mUIHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.impl.HuayangJsPluginImpl
 * JD-Core Version:    0.7.0.1
 */