package com.tencent.mobileqq.vashealth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.vashealth.api.IPathTraceManager;
import com.tencent.mobileqq.webview.swift.IPreCreatePluginChecker;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class HealthPathTracePlugin
  extends WebViewPlugin
  implements IPreCreatePluginChecker
{
  public Activity a;
  public AppInterface b;
  public boolean c;
  private LocationManager d;
  private QQPermission e = null;
  private BusinessConfig f = new BusinessConfig("biz_src_qqsports", "health_community");
  
  public HealthPathTracePlugin()
  {
    this.mPluginNameSpace = "healthpathtrace";
  }
  
  private void a()
  {
    Intent localIntent = new Intent(this.mRuntime.c().getApplicationContext(), PathTraceService.class);
    try
    {
      this.mRuntime.c().getApplicationContext().stopService(localIntent);
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PathTraceManager.Plugin", 2, "", localThrowable);
      }
    }
    QLog.i("PathTraceManager.Plugin", 1, "stopPathTraceService");
  }
  
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.contains("__page=run"));
  }
  
  private void b()
  {
    if (this.a != null) {
      this.e = QQPermissionFactory.a(this.mRuntime.d(), this.f);
    }
  }
  
  private boolean c()
  {
    if (this.e == null) {
      b();
    }
    QQPermission localQQPermission = this.e;
    return (localQQPermission != null) && (localQQPermission.a("android.permission.ACCESS_FINE_LOCATION") == 0);
  }
  
  private void d()
  {
    QQPermission localQQPermission = this.e;
    if (localQQPermission != null)
    {
      HealthPathTracePlugin.1 local1 = new HealthPathTracePlugin.1(this);
      localQQPermission.a(new String[] { "android.permission.ACCESS_FINE_LOCATION" }, 2, local1);
    }
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 8589934631L;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    Object localObject2 = (IPathTraceManager)this.b.getRuntimeService(IPathTraceManager.class, "tool");
    this.c = a(paramString);
    boolean bool1 = this.c;
    boolean bool2 = false;
    boolean bool3 = false;
    if (!bool1) {
      return false;
    }
    ((IPathTraceManager)localObject2).registerWebViewPlug(this);
    if ((paramLong == 8589934597L) || (paramLong == 2L) || (paramLong == 32L))
    {
      String str = "";
      if ((paramLong == 8589934597L) && (((IPathTraceManager)localObject2).getEngineWorkingMode() == 0)) {
        ((IPathTraceManager)localObject2).stopLocation(0);
      }
      for (paramString = "pause";; paramString = "resume")
      {
        bool1 = true;
        localObject1 = paramString;
        break label826;
        if ((paramLong != 2L) || (((IPathTraceManager)localObject2).getEngineWorkingMode() != 0)) {
          break;
        }
        if ((Build.VERSION.SDK_INT >= 23) && (!c())) {
          d();
        } else {
          ((IPathTraceManager)localObject2).startLocation(0);
        }
      }
      bool1 = bool3;
      Object localObject1 = str;
      if (paramLong == 32L)
      {
        localObject1 = Uri.parse(paramString);
        if (((Uri)localObject1).getQuery() != null)
        {
          if (((Uri)localObject1).getQueryParameter("runningState") != null)
          {
            paramString = String.valueOf(paramMap.get("url"));
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("runningState=");
            localStringBuilder.append(((Uri)localObject1).getQueryParameter("runningState"));
            localObject1 = localStringBuilder.toString();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("runningState=");
            localStringBuilder.append(((IPathTraceManager)localObject2).getRunningStatus());
            paramString = paramString.replace((CharSequence)localObject1, localStringBuilder.toString());
          }
          else
          {
            paramString = new StringBuilder();
            paramString.append(String.valueOf(paramMap.get("url")));
            paramString.append("&runningState=");
            paramString.append(((IPathTraceManager)localObject2).getRunningStatus());
            paramString = paramString.toString();
          }
        }
        else
        {
          paramString = new StringBuilder();
          paramString.append(String.valueOf(paramMap.get("url")));
          paramString.append("?runningState=");
          paramString.append(((IPathTraceManager)localObject2).getRunningStatus());
          paramString = paramString.toString();
        }
        localObject1 = this.b.getApplication().getSharedPreferences(this.mRuntime.b().getCurrentAccountUin(), 0);
        long l1 = ((SharedPreferences)localObject1).getLong("search_lbs_timestamp", 0L);
        long l2 = System.currentTimeMillis();
        float f1 = 0.0F;
        float f2;
        if (l2 - l1 < 10800000L)
        {
          f2 = ((SharedPreferences)localObject1).getFloat("search_lbs_logitude", 0.0F);
          f1 = ((SharedPreferences)localObject1).getFloat("search_lbs_latitude", 0.0F);
        }
        else
        {
          f2 = 0.0F;
        }
        if (paramString.contains("lati"))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("lati=");
          ((StringBuilder)localObject1).append(Uri.parse(paramString).getQueryParameter("lati"));
          localObject1 = ((StringBuilder)localObject1).toString();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("lati=");
          ((StringBuilder)localObject2).append(f1);
          paramString = paramString.replace((CharSequence)localObject1, ((StringBuilder)localObject2).toString());
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append("&lati=");
          ((StringBuilder)localObject1).append(f1);
          paramString = ((StringBuilder)localObject1).toString();
        }
        if (paramString.contains("logi"))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("logi=");
          ((StringBuilder)localObject1).append(Uri.parse(paramString).getQueryParameter("logi"));
          localObject1 = ((StringBuilder)localObject1).toString();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("logi=");
          ((StringBuilder)localObject2).append(f2);
          paramString = paramString.replace((CharSequence)localObject1, ((StringBuilder)localObject2).toString());
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append("&logi=");
          ((StringBuilder)localObject1).append(f2);
          paramString = ((StringBuilder)localObject1).toString();
        }
        paramMap.put("url", paramString);
        bool1 = bool3;
        localObject1 = str;
        if (QLog.isColorLevel())
        {
          paramMap = new StringBuilder();
          paramMap.append("Intercep url:");
          paramMap.append(paramString);
          QLog.d("PathTraceManager.Plugin", 2, paramMap.toString());
          localObject1 = str;
          bool1 = bool3;
        }
      }
      label826:
      bool2 = bool1;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        paramString = new StringBuilder();
        paramString.append("webview event type:");
        paramString.append(paramLong);
        paramString.append(", event name: ");
        paramString.append((String)localObject1);
        QLog.i("PathTraceManager.Plugin", 1, paramString.toString());
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  /* Error */
  protected boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +2586 -> 2587
    //   4: ldc 37
    //   6: aload_3
    //   7: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10: ifeq +2577 -> 2587
    //   13: aload 4
    //   15: ifnonnull +6 -> 21
    //   18: goto +2569 -> 2587
    //   21: aload_2
    //   22: invokestatic 327	com/tencent/mobileqq/webview/swift/WebViewPlugin:getJsonFromJSBridge	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   25: astore 25
    //   27: aload 25
    //   29: ifnull +2560 -> 2589
    //   32: aload 25
    //   34: ldc_w 329
    //   37: invokevirtual 334	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   40: astore_1
    //   41: new 219	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   48: astore_2
    //   49: aload_2
    //   50: ldc_w 336
    //   53: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_2
    //   58: aload 4
    //   60: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload_2
    //   65: ldc_w 338
    //   68: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload_2
    //   73: aload 25
    //   75: invokevirtual 339	org/json/JSONObject:toString	()Ljava/lang/String;
    //   78: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: ldc 80
    //   84: iconst_1
    //   85: aload_2
    //   86: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 91	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   92: goto +3 -> 95
    //   95: aload 5
    //   97: iconst_0
    //   98: aaload
    //   99: astore_2
    //   100: aload_1
    //   101: invokestatic 98	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   104: ifeq +14 -> 118
    //   107: ldc 80
    //   109: iconst_1
    //   110: ldc_w 341
    //   113: invokestatic 343	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   116: iconst_1
    //   117: ireturn
    //   118: aload_0
    //   119: getfield 140	com/tencent/mobileqq/vashealth/HealthPathTracePlugin:b	Lcom/tencent/common/app/AppInterface;
    //   122: ldc 142
    //   124: ldc 144
    //   126: invokevirtual 150	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   129: checkcast 142	com/tencent/mobileqq/vashealth/api/IPathTraceManager
    //   132: astore 5
    //   134: ldc_w 345
    //   137: aload 4
    //   139: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   142: istore 18
    //   144: iload 18
    //   146: ifeq +124 -> 270
    //   149: new 331	org/json/JSONObject
    //   152: dup
    //   153: invokespecial 346	org/json/JSONObject:<init>	()V
    //   156: astore 4
    //   158: aload 4
    //   160: ldc_w 348
    //   163: iconst_1
    //   164: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   167: pop
    //   168: aload 4
    //   170: ldc 201
    //   172: aload 5
    //   174: invokeinterface 232 1 0
    //   179: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   182: pop
    //   183: aload 5
    //   185: invokeinterface 232 1 0
    //   190: ifeq +60 -> 250
    //   193: aload 5
    //   195: invokeinterface 355 1 0
    //   200: checkcast 357	com/tencent/mobileqq/vashealth/TracePathData
    //   203: astore_3
    //   204: aload_3
    //   205: astore_2
    //   206: aload_3
    //   207: ifnonnull +14 -> 221
    //   210: aload 5
    //   212: invokeinterface 360 1 0
    //   217: checkcast 357	com/tencent/mobileqq/vashealth/TracePathData
    //   220: astore_2
    //   221: aload_2
    //   222: ifnull +19 -> 241
    //   225: aload 4
    //   227: ldc_w 362
    //   230: aload_2
    //   231: getfield 364	com/tencent/mobileqq/vashealth/TracePathData:type	I
    //   234: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   237: pop
    //   238: goto +12 -> 250
    //   241: ldc 80
    //   243: iconst_1
    //   244: ldc_w 366
    //   247: invokestatic 91	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   250: aload_0
    //   251: aload_1
    //   252: iconst_1
    //   253: anewarray 102	java/lang/String
    //   256: dup
    //   257: iconst_0
    //   258: aload 4
    //   260: invokevirtual 339	org/json/JSONObject:toString	()Ljava/lang/String;
    //   263: aastore
    //   264: invokespecial 370	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   267: goto +2327 -> 2594
    //   270: ldc_w 372
    //   273: aload 4
    //   275: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   278: istore 18
    //   280: iload 18
    //   282: ifeq +130 -> 412
    //   285: new 331	org/json/JSONObject
    //   288: dup
    //   289: invokespecial 346	org/json/JSONObject:<init>	()V
    //   292: astore_2
    //   293: aload_0
    //   294: getfield 374	com/tencent/mobileqq/vashealth/HealthPathTracePlugin:d	Landroid/location/LocationManager;
    //   297: ldc_w 376
    //   300: invokevirtual 381	android/location/LocationManager:isProviderEnabled	(Ljava/lang/String;)Z
    //   303: ifne +16 -> 319
    //   306: aload_2
    //   307: ldc_w 348
    //   310: bipush 254
    //   312: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   315: pop
    //   316: goto +77 -> 393
    //   319: aload_2
    //   320: ldc_w 348
    //   323: iconst_1
    //   324: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   327: pop
    //   328: aload 5
    //   330: ifnull +63 -> 393
    //   333: aload 5
    //   335: invokeinterface 360 1 0
    //   340: ifnull +53 -> 393
    //   343: aload_2
    //   344: ldc_w 348
    //   347: bipush 249
    //   349: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   352: pop
    //   353: aload_2
    //   354: ldc_w 383
    //   357: aload 5
    //   359: invokeinterface 360 1 0
    //   364: checkcast 357	com/tencent/mobileqq/vashealth/TracePathData
    //   367: getfield 386	com/tencent/mobileqq/vashealth/TracePathData:startTime	J
    //   370: invokevirtual 389	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   373: pop
    //   374: aload_2
    //   375: ldc_w 391
    //   378: aload 5
    //   380: aconst_null
    //   381: invokeinterface 394 2 0
    //   386: invokevirtual 339	org/json/JSONObject:toString	()Ljava/lang/String;
    //   389: invokevirtual 397	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   392: pop
    //   393: aload_0
    //   394: aload_1
    //   395: iconst_1
    //   396: anewarray 102	java/lang/String
    //   399: dup
    //   400: iconst_0
    //   401: aload_2
    //   402: invokevirtual 339	org/json/JSONObject:toString	()Ljava/lang/String;
    //   405: aastore
    //   406: invokevirtual 398	com/tencent/mobileqq/vashealth/HealthPathTracePlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   409: goto +2185 -> 2594
    //   412: ldc_w 400
    //   415: aload 4
    //   417: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   420: ifeq +136 -> 556
    //   423: aload 5
    //   425: ifnull +50 -> 475
    //   428: aload 5
    //   430: invokeinterface 168 1 0
    //   435: ifle +40 -> 475
    //   438: new 331	org/json/JSONObject
    //   441: dup
    //   442: invokespecial 346	org/json/JSONObject:<init>	()V
    //   445: astore_2
    //   446: aload_2
    //   447: ldc_w 348
    //   450: bipush 252
    //   452: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   455: pop
    //   456: aload_0
    //   457: aload_1
    //   458: iconst_1
    //   459: anewarray 102	java/lang/String
    //   462: dup
    //   463: iconst_0
    //   464: aload_2
    //   465: invokevirtual 339	org/json/JSONObject:toString	()Ljava/lang/String;
    //   468: aastore
    //   469: invokespecial 370	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   472: goto +2122 -> 2594
    //   475: new 331	org/json/JSONObject
    //   478: dup
    //   479: invokespecial 346	org/json/JSONObject:<init>	()V
    //   482: astore_2
    //   483: getstatic 180	android/os/Build$VERSION:SDK_INT	I
    //   486: bipush 23
    //   488: if_icmplt +27 -> 515
    //   491: aload_0
    //   492: invokespecial 182	com/tencent/mobileqq/vashealth/HealthPathTracePlugin:c	()Z
    //   495: ifne +20 -> 515
    //   498: aload_0
    //   499: invokespecial 184	com/tencent/mobileqq/vashealth/HealthPathTracePlugin:d	()V
    //   502: aload_2
    //   503: ldc_w 348
    //   506: bipush 252
    //   508: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   511: pop
    //   512: goto +12 -> 524
    //   515: aload_2
    //   516: ldc_w 348
    //   519: iconst_1
    //   520: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   523: pop
    //   524: aload_0
    //   525: aload_1
    //   526: iconst_1
    //   527: anewarray 102	java/lang/String
    //   530: dup
    //   531: iconst_0
    //   532: aload_2
    //   533: invokevirtual 339	org/json/JSONObject:toString	()Ljava/lang/String;
    //   536: aastore
    //   537: invokespecial 370	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   540: aload 5
    //   542: ifnull +2052 -> 2594
    //   545: aload 5
    //   547: iconst_0
    //   548: invokeinterface 187 2 0
    //   553: goto +2041 -> 2594
    //   556: ldc_w 402
    //   559: aload 4
    //   561: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   564: ifeq +169 -> 733
    //   567: new 331	org/json/JSONObject
    //   570: dup
    //   571: invokespecial 346	org/json/JSONObject:<init>	()V
    //   574: astore_2
    //   575: aload_0
    //   576: getfield 374	com/tencent/mobileqq/vashealth/HealthPathTracePlugin:d	Landroid/location/LocationManager;
    //   579: ldc_w 376
    //   582: invokevirtual 381	android/location/LocationManager:isProviderEnabled	(Ljava/lang/String;)Z
    //   585: ifne +31 -> 616
    //   588: aload_2
    //   589: ldc_w 348
    //   592: bipush 254
    //   594: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   597: pop
    //   598: aload_0
    //   599: aload_1
    //   600: iconst_1
    //   601: anewarray 102	java/lang/String
    //   604: dup
    //   605: iconst_0
    //   606: aload_2
    //   607: invokevirtual 339	org/json/JSONObject:toString	()Ljava/lang/String;
    //   610: aastore
    //   611: invokespecial 370	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   614: iconst_0
    //   615: ireturn
    //   616: getstatic 180	android/os/Build$VERSION:SDK_INT	I
    //   619: bipush 19
    //   621: if_icmpge +15 -> 636
    //   624: aload_2
    //   625: ldc_w 404
    //   628: iconst_1
    //   629: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   632: pop
    //   633: goto +40 -> 673
    //   636: aload_0
    //   637: getfield 107	com/tencent/mobileqq/vashealth/HealthPathTracePlugin:a	Landroid/app/Activity;
    //   640: ldc_w 406
    //   643: invokevirtual 412	android/app/Activity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   646: checkcast 414	android/hardware/SensorManager
    //   649: bipush 19
    //   651: invokevirtual 418	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   654: ifnonnull +1943 -> 2597
    //   657: iconst_1
    //   658: istore 16
    //   660: goto +3 -> 663
    //   663: aload_2
    //   664: ldc_w 404
    //   667: iload 16
    //   669: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   672: pop
    //   673: getstatic 180	android/os/Build$VERSION:SDK_INT	I
    //   676: bipush 23
    //   678: if_icmplt +27 -> 705
    //   681: aload_0
    //   682: invokespecial 182	com/tencent/mobileqq/vashealth/HealthPathTracePlugin:c	()Z
    //   685: ifne +20 -> 705
    //   688: aload_0
    //   689: invokespecial 184	com/tencent/mobileqq/vashealth/HealthPathTracePlugin:d	()V
    //   692: aload_2
    //   693: ldc_w 348
    //   696: bipush 254
    //   698: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   701: pop
    //   702: goto +12 -> 714
    //   705: aload 5
    //   707: aload 25
    //   709: invokeinterface 422 2 0
    //   714: aload_0
    //   715: aload_1
    //   716: iconst_1
    //   717: anewarray 102	java/lang/String
    //   720: dup
    //   721: iconst_0
    //   722: aload_2
    //   723: invokevirtual 339	org/json/JSONObject:toString	()Ljava/lang/String;
    //   726: aastore
    //   727: invokespecial 370	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   730: goto +1864 -> 2594
    //   733: ldc_w 424
    //   736: aload 4
    //   738: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   741: ifeq +46 -> 787
    //   744: new 331	org/json/JSONObject
    //   747: dup
    //   748: invokespecial 346	org/json/JSONObject:<init>	()V
    //   751: astore_2
    //   752: aload 5
    //   754: invokeinterface 427 1 0
    //   759: aload_2
    //   760: ldc_w 348
    //   763: iconst_1
    //   764: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   767: pop
    //   768: aload_0
    //   769: aload_1
    //   770: iconst_1
    //   771: anewarray 102	java/lang/String
    //   774: dup
    //   775: iconst_0
    //   776: aload_2
    //   777: invokevirtual 339	org/json/JSONObject:toString	()Ljava/lang/String;
    //   780: aastore
    //   781: invokespecial 370	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   784: goto +1810 -> 2594
    //   787: ldc_w 429
    //   790: aload 4
    //   792: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   795: ifeq +172 -> 967
    //   798: new 331	org/json/JSONObject
    //   801: dup
    //   802: invokespecial 346	org/json/JSONObject:<init>	()V
    //   805: astore_2
    //   806: aload_0
    //   807: getfield 374	com/tencent/mobileqq/vashealth/HealthPathTracePlugin:d	Landroid/location/LocationManager;
    //   810: ldc_w 376
    //   813: invokevirtual 381	android/location/LocationManager:isProviderEnabled	(Ljava/lang/String;)Z
    //   816: ifne +31 -> 847
    //   819: aload_2
    //   820: ldc_w 348
    //   823: bipush 254
    //   825: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   828: pop
    //   829: aload_0
    //   830: aload_1
    //   831: iconst_1
    //   832: anewarray 102	java/lang/String
    //   835: dup
    //   836: iconst_0
    //   837: aload_2
    //   838: invokevirtual 339	org/json/JSONObject:toString	()Ljava/lang/String;
    //   841: aastore
    //   842: invokespecial 370	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   845: iconst_0
    //   846: ireturn
    //   847: aload 5
    //   849: invokeinterface 355 1 0
    //   854: checkcast 357	com/tencent/mobileqq/vashealth/TracePathData
    //   857: ifnonnull +27 -> 884
    //   860: aload_2
    //   861: ldc_w 348
    //   864: bipush 244
    //   866: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   869: pop
    //   870: aload_2
    //   871: ldc_w 431
    //   874: ldc_w 433
    //   877: invokevirtual 397	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   880: pop
    //   881: goto +67 -> 948
    //   884: getstatic 180	android/os/Build$VERSION:SDK_INT	I
    //   887: bipush 23
    //   889: if_icmplt +43 -> 932
    //   892: aload_0
    //   893: invokespecial 182	com/tencent/mobileqq/vashealth/HealthPathTracePlugin:c	()Z
    //   896: ifne +36 -> 932
    //   899: aload_0
    //   900: invokespecial 184	com/tencent/mobileqq/vashealth/HealthPathTracePlugin:d	()V
    //   903: aload_2
    //   904: ldc_w 348
    //   907: bipush 254
    //   909: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   912: pop
    //   913: aload_0
    //   914: aload_1
    //   915: iconst_1
    //   916: anewarray 102	java/lang/String
    //   919: dup
    //   920: iconst_0
    //   921: aload_2
    //   922: invokevirtual 339	org/json/JSONObject:toString	()Ljava/lang/String;
    //   925: aastore
    //   926: invokespecial 370	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   929: goto +19 -> 948
    //   932: aload 5
    //   934: invokeinterface 436 1 0
    //   939: aload_2
    //   940: ldc_w 348
    //   943: iconst_1
    //   944: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   947: pop
    //   948: aload_0
    //   949: aload_1
    //   950: iconst_1
    //   951: anewarray 102	java/lang/String
    //   954: dup
    //   955: iconst_0
    //   956: aload_2
    //   957: invokevirtual 339	org/json/JSONObject:toString	()Ljava/lang/String;
    //   960: aastore
    //   961: invokespecial 370	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   964: goto +1630 -> 2594
    //   967: ldc_w 438
    //   970: aload 4
    //   972: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   975: ifeq +983 -> 1958
    //   978: new 331	org/json/JSONObject
    //   981: dup
    //   982: invokespecial 346	org/json/JSONObject:<init>	()V
    //   985: astore 4
    //   987: aload 5
    //   989: invokeinterface 355 1 0
    //   994: checkcast 357	com/tencent/mobileqq/vashealth/TracePathData
    //   997: astore_3
    //   998: aload_3
    //   999: astore_2
    //   1000: aload_3
    //   1001: ifnonnull +14 -> 1015
    //   1004: aload 5
    //   1006: invokeinterface 360 1 0
    //   1011: checkcast 357	com/tencent/mobileqq/vashealth/TracePathData
    //   1014: astore_2
    //   1015: aload_2
    //   1016: ifnonnull +26 -> 1042
    //   1019: aload 4
    //   1021: ldc_w 348
    //   1024: bipush 248
    //   1026: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1029: pop
    //   1030: ldc 80
    //   1032: iconst_1
    //   1033: ldc_w 440
    //   1036: invokestatic 343	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1039: goto +861 -> 1900
    //   1042: aload 25
    //   1044: ldc_w 442
    //   1047: aload_2
    //   1048: getfield 444	com/tencent/mobileqq/vashealth/TracePathData:totalTime	J
    //   1051: invokevirtual 447	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   1054: lstore 19
    //   1056: aload 5
    //   1058: lload 19
    //   1060: invokeinterface 451 3 0
    //   1065: ifeq +16 -> 1081
    //   1068: aload 4
    //   1070: ldc_w 348
    //   1073: iconst_1
    //   1074: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1077: pop
    //   1078: goto +14 -> 1092
    //   1081: aload 4
    //   1083: ldc_w 348
    //   1086: bipush 251
    //   1088: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1091: pop
    //   1092: aload 4
    //   1094: ldc_w 383
    //   1097: aload_2
    //   1098: getfield 386	com/tencent/mobileqq/vashealth/TracePathData:startTime	J
    //   1101: invokevirtual 389	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   1104: pop
    //   1105: new 453	org/json/JSONArray
    //   1108: dup
    //   1109: invokespecial 454	org/json/JSONArray:<init>	()V
    //   1112: astore_3
    //   1113: aload_0
    //   1114: getfield 50	com/tencent/mobileqq/vashealth/HealthPathTracePlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1117: invokevirtual 250	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:b	()Lcom/tencent/common/app/AppInterface;
    //   1120: invokevirtual 247	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   1123: aload_2
    //   1124: getfield 386	com/tencent/mobileqq/vashealth/TracePathData:startTime	J
    //   1127: invokestatic 457	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1130: iconst_0
    //   1131: invokevirtual 259	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1134: astore 5
    //   1136: aload 5
    //   1138: getstatic 462	com/tencent/mobileqq/vashealth/api/impl/PathTraceManagerImpl:LAST_TIME	I
    //   1141: invokestatic 465	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1144: lconst_0
    //   1145: invokeinterface 267 4 0
    //   1150: lstore 21
    //   1152: aload 5
    //   1154: getstatic 468	com/tencent/mobileqq/vashealth/api/impl/PathTraceManagerImpl:LAST_DISTANCE	I
    //   1157: invokestatic 465	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1160: fconst_0
    //   1161: invokeinterface 281 3 0
    //   1166: fstore 14
    //   1168: lload 19
    //   1170: lload 21
    //   1172: lsub
    //   1173: lstore 23
    //   1175: lload 23
    //   1177: lconst_0
    //   1178: lcmp
    //   1179: ifle +240 -> 1419
    //   1182: aload 5
    //   1184: invokeinterface 472 1 0
    //   1189: astore 25
    //   1191: aload_2
    //   1192: getfield 476	com/tencent/mobileqq/vashealth/TracePathData:distance	D
    //   1195: ldc2_w 477
    //   1198: ddiv
    //   1199: dconst_1
    //   1200: dadd
    //   1201: d2i
    //   1202: istore 16
    //   1204: new 219	java/lang/StringBuilder
    //   1207: dup
    //   1208: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   1211: astore 26
    //   1213: lload 23
    //   1215: l2d
    //   1216: dstore 6
    //   1218: aload_2
    //   1219: getfield 476	com/tencent/mobileqq/vashealth/TracePathData:distance	D
    //   1222: dstore 8
    //   1224: fload 14
    //   1226: f2d
    //   1227: dstore 10
    //   1229: dload 10
    //   1231: invokestatic 484	java/lang/Double:isNaN	(D)Z
    //   1234: pop
    //   1235: ldc_w 485
    //   1238: invokestatic 490	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1241: invokevirtual 494	java/lang/Float:floatValue	()F
    //   1244: fstore 15
    //   1246: fload 15
    //   1248: f2d
    //   1249: dstore 12
    //   1251: dload 12
    //   1253: invokestatic 484	java/lang/Double:isNaN	(D)Z
    //   1256: pop
    //   1257: dload 8
    //   1259: dload 10
    //   1261: dsub
    //   1262: dload 12
    //   1264: ddiv
    //   1265: dstore 8
    //   1267: dload 6
    //   1269: invokestatic 484	java/lang/Double:isNaN	(D)Z
    //   1272: pop
    //   1273: dload 6
    //   1275: dload 8
    //   1277: ddiv
    //   1278: d2i
    //   1279: istore 17
    //   1281: aload 26
    //   1283: iload 17
    //   1285: invokestatic 465	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1288: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1291: pop
    //   1292: aload 26
    //   1294: ldc_w 496
    //   1297: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1300: pop
    //   1301: aload 25
    //   1303: iload 16
    //   1305: invokestatic 465	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1308: aload 26
    //   1310: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1313: invokeinterface 502 3 0
    //   1318: invokeinterface 505 1 0
    //   1323: pop
    //   1324: new 219	java/lang/StringBuilder
    //   1327: dup
    //   1328: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   1331: astore 25
    //   1333: aload 25
    //   1335: ldc_w 507
    //   1338: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1341: pop
    //   1342: aload 25
    //   1344: lload 19
    //   1346: invokevirtual 311	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1349: pop
    //   1350: aload 25
    //   1352: ldc_w 509
    //   1355: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1358: pop
    //   1359: aload 25
    //   1361: lload 21
    //   1363: invokevirtual 311	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1366: pop
    //   1367: aload 25
    //   1369: ldc_w 511
    //   1372: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1375: pop
    //   1376: aload 25
    //   1378: aload_2
    //   1379: getfield 476	com/tencent/mobileqq/vashealth/TracePathData:distance	D
    //   1382: invokevirtual 514	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   1385: pop
    //   1386: aload 25
    //   1388: ldc_w 516
    //   1391: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1394: pop
    //   1395: aload 25
    //   1397: fload 14
    //   1399: invokevirtual 290	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1402: pop
    //   1403: aload 25
    //   1405: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1408: astore_2
    //   1409: ldc 80
    //   1411: iconst_1
    //   1412: aload_2
    //   1413: invokestatic 306	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1416: goto +1187 -> 2603
    //   1419: ldc 80
    //   1421: astore 25
    //   1423: aload_2
    //   1424: getfield 444	com/tencent/mobileqq/vashealth/TracePathData:totalTime	J
    //   1427: lload 21
    //   1429: lsub
    //   1430: lconst_0
    //   1431: lcmp
    //   1432: ifle +249 -> 1681
    //   1435: aload 5
    //   1437: invokeinterface 472 1 0
    //   1442: astore 26
    //   1444: aload_2
    //   1445: getfield 476	com/tencent/mobileqq/vashealth/TracePathData:distance	D
    //   1448: ldc2_w 477
    //   1451: ddiv
    //   1452: dconst_1
    //   1453: dadd
    //   1454: d2i
    //   1455: istore 16
    //   1457: new 219	java/lang/StringBuilder
    //   1460: dup
    //   1461: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   1464: astore 27
    //   1466: aload_2
    //   1467: getfield 444	com/tencent/mobileqq/vashealth/TracePathData:totalTime	J
    //   1470: lstore 23
    //   1472: lload 23
    //   1474: lload 21
    //   1476: lsub
    //   1477: l2d
    //   1478: dstore 6
    //   1480: aload_2
    //   1481: getfield 476	com/tencent/mobileqq/vashealth/TracePathData:distance	D
    //   1484: dstore 8
    //   1486: fload 14
    //   1488: f2d
    //   1489: dstore 10
    //   1491: dload 10
    //   1493: invokestatic 484	java/lang/Double:isNaN	(D)Z
    //   1496: pop
    //   1497: ldc_w 485
    //   1500: invokestatic 490	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1503: invokevirtual 494	java/lang/Float:floatValue	()F
    //   1506: fstore 15
    //   1508: fload 15
    //   1510: f2d
    //   1511: dstore 12
    //   1513: dload 12
    //   1515: invokestatic 484	java/lang/Double:isNaN	(D)Z
    //   1518: pop
    //   1519: dload 8
    //   1521: dload 10
    //   1523: dsub
    //   1524: dload 12
    //   1526: ddiv
    //   1527: dstore 8
    //   1529: dload 6
    //   1531: invokestatic 484	java/lang/Double:isNaN	(D)Z
    //   1534: pop
    //   1535: dload 6
    //   1537: dload 8
    //   1539: ddiv
    //   1540: d2i
    //   1541: istore 17
    //   1543: aload 27
    //   1545: iload 17
    //   1547: invokestatic 465	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1550: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1553: pop
    //   1554: aload 27
    //   1556: ldc_w 496
    //   1559: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1562: pop
    //   1563: aload 26
    //   1565: iload 16
    //   1567: invokestatic 465	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1570: aload 27
    //   1572: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1575: invokeinterface 502 3 0
    //   1580: invokeinterface 505 1 0
    //   1585: pop
    //   1586: new 219	java/lang/StringBuilder
    //   1589: dup
    //   1590: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   1593: astore 26
    //   1595: aload 26
    //   1597: ldc_w 518
    //   1600: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1603: pop
    //   1604: aload 26
    //   1606: lload 19
    //   1608: invokevirtual 311	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1611: pop
    //   1612: aload 26
    //   1614: ldc_w 509
    //   1617: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1620: pop
    //   1621: aload 26
    //   1623: lload 21
    //   1625: invokevirtual 311	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1628: pop
    //   1629: aload 26
    //   1631: ldc_w 511
    //   1634: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1637: pop
    //   1638: aload 26
    //   1640: aload_2
    //   1641: getfield 476	com/tencent/mobileqq/vashealth/TracePathData:distance	D
    //   1644: invokevirtual 514	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   1647: pop
    //   1648: aload 26
    //   1650: ldc_w 516
    //   1653: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1656: pop
    //   1657: aload 26
    //   1659: fload 14
    //   1661: invokevirtual 290	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1664: pop
    //   1665: aload 26
    //   1667: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1670: astore_2
    //   1671: aload 25
    //   1673: iconst_1
    //   1674: aload_2
    //   1675: invokestatic 306	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1678: goto +925 -> 2603
    //   1681: new 219	java/lang/StringBuilder
    //   1684: dup
    //   1685: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   1688: astore 26
    //   1690: aload 26
    //   1692: ldc_w 520
    //   1695: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1698: pop
    //   1699: aload 26
    //   1701: lload 19
    //   1703: invokevirtual 311	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1706: pop
    //   1707: aload 26
    //   1709: ldc_w 509
    //   1712: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1715: pop
    //   1716: aload 26
    //   1718: lload 21
    //   1720: invokevirtual 311	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1723: pop
    //   1724: aload 26
    //   1726: ldc_w 511
    //   1729: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1732: pop
    //   1733: aload 26
    //   1735: aload_2
    //   1736: getfield 476	com/tencent/mobileqq/vashealth/TracePathData:distance	D
    //   1739: invokevirtual 514	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   1742: pop
    //   1743: aload 26
    //   1745: ldc_w 516
    //   1748: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1751: pop
    //   1752: aload 26
    //   1754: fload 14
    //   1756: invokevirtual 290	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1759: pop
    //   1760: aload 25
    //   1762: iconst_1
    //   1763: aload 26
    //   1765: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1768: invokestatic 306	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1771: aload_3
    //   1772: astore_2
    //   1773: aload 5
    //   1775: iconst_1
    //   1776: invokestatic 465	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1779: aconst_null
    //   1780: invokeinterface 523 3 0
    //   1785: astore_3
    //   1786: iconst_1
    //   1787: istore 16
    //   1789: aload_3
    //   1790: ifnull +100 -> 1890
    //   1793: aload_3
    //   1794: ldc_w 525
    //   1797: invokevirtual 529	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1800: astore_3
    //   1801: new 331	org/json/JSONObject
    //   1804: dup
    //   1805: invokespecial 346	org/json/JSONObject:<init>	()V
    //   1808: astore 25
    //   1810: aload 25
    //   1812: ldc_w 531
    //   1815: iload 16
    //   1817: invokestatic 465	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1820: invokevirtual 397	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1823: pop
    //   1824: aload 25
    //   1826: ldc_w 533
    //   1829: aload_3
    //   1830: iconst_0
    //   1831: aaload
    //   1832: invokevirtual 397	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1835: pop
    //   1836: aload 25
    //   1838: ldc_w 535
    //   1841: aload_3
    //   1842: iconst_1
    //   1843: aaload
    //   1844: invokevirtual 397	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1847: pop
    //   1848: aload 25
    //   1850: ldc_w 537
    //   1853: aload_3
    //   1854: iconst_2
    //   1855: aaload
    //   1856: invokevirtual 397	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1859: pop
    //   1860: aload_2
    //   1861: aload 25
    //   1863: invokevirtual 540	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   1866: pop
    //   1867: iload 16
    //   1869: iconst_1
    //   1870: iadd
    //   1871: istore 16
    //   1873: aload 5
    //   1875: iload 16
    //   1877: invokestatic 465	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1880: aconst_null
    //   1881: invokeinterface 523 3 0
    //   1886: astore_3
    //   1887: goto -98 -> 1789
    //   1890: aload 4
    //   1892: ldc_w 542
    //   1895: aload_2
    //   1896: invokevirtual 397	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1899: pop
    //   1900: new 219	java/lang/StringBuilder
    //   1903: dup
    //   1904: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   1907: astore_2
    //   1908: aload_2
    //   1909: ldc_w 544
    //   1912: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1915: pop
    //   1916: aload_2
    //   1917: aload 4
    //   1919: invokevirtual 339	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1922: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1925: pop
    //   1926: ldc 80
    //   1928: iconst_1
    //   1929: aload_2
    //   1930: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1933: invokestatic 306	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1936: aload 4
    //   1938: invokevirtual 339	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1941: astore_2
    //   1942: aload_0
    //   1943: aload_1
    //   1944: iconst_1
    //   1945: anewarray 102	java/lang/String
    //   1948: dup
    //   1949: iconst_0
    //   1950: aload_2
    //   1951: aastore
    //   1952: invokespecial 370	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1955: goto +630 -> 2585
    //   1958: ldc_w 546
    //   1961: aload 4
    //   1963: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1966: ifeq +81 -> 2047
    //   1969: new 331	org/json/JSONObject
    //   1972: dup
    //   1973: invokespecial 346	org/json/JSONObject:<init>	()V
    //   1976: astore_2
    //   1977: aload 25
    //   1979: ldc_w 383
    //   1982: invokevirtual 549	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1985: ifne +43 -> 2028
    //   1988: aload_2
    //   1989: ldc_w 348
    //   1992: bipush 244
    //   1994: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1997: pop
    //   1998: aload_2
    //   1999: ldc_w 431
    //   2002: ldc_w 433
    //   2005: invokevirtual 397	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2008: pop
    //   2009: aload_0
    //   2010: aload_1
    //   2011: iconst_1
    //   2012: anewarray 102	java/lang/String
    //   2015: dup
    //   2016: iconst_0
    //   2017: aload_2
    //   2018: invokevirtual 339	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2021: aastore
    //   2022: invokespecial 370	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2025: goto +560 -> 2585
    //   2028: aload 5
    //   2030: aload 25
    //   2032: ldc_w 383
    //   2035: invokevirtual 551	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   2038: aload_1
    //   2039: invokeinterface 555 4 0
    //   2044: goto +541 -> 2585
    //   2047: ldc_w 557
    //   2050: aload 4
    //   2052: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2055: ifeq +39 -> 2094
    //   2058: new 331	org/json/JSONObject
    //   2061: dup
    //   2062: invokespecial 346	org/json/JSONObject:<init>	()V
    //   2065: astore_2
    //   2066: aload_2
    //   2067: ldc_w 348
    //   2070: iconst_1
    //   2071: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2074: pop
    //   2075: aload_0
    //   2076: aload_1
    //   2077: iconst_1
    //   2078: anewarray 102	java/lang/String
    //   2081: dup
    //   2082: iconst_0
    //   2083: aload_2
    //   2084: invokevirtual 339	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2087: aastore
    //   2088: invokespecial 370	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2091: goto +494 -> 2585
    //   2094: ldc_w 559
    //   2097: aload 4
    //   2099: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2102: ifeq +80 -> 2182
    //   2105: new 331	org/json/JSONObject
    //   2108: dup
    //   2109: invokespecial 346	org/json/JSONObject:<init>	()V
    //   2112: astore_3
    //   2113: aload_1
    //   2114: invokestatic 98	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2117: ifne +36 -> 2153
    //   2120: aload 5
    //   2122: aload_2
    //   2123: invokeinterface 394 2 0
    //   2128: astore_2
    //   2129: aload_3
    //   2130: ldc_w 348
    //   2133: iconst_1
    //   2134: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2137: pop
    //   2138: aload_3
    //   2139: ldc_w 391
    //   2142: aload_2
    //   2143: invokevirtual 339	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2146: invokevirtual 397	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2149: pop
    //   2150: goto +13 -> 2163
    //   2153: aload_3
    //   2154: ldc_w 348
    //   2157: bipush 248
    //   2159: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2162: pop
    //   2163: aload_0
    //   2164: aload_1
    //   2165: iconst_1
    //   2166: anewarray 102	java/lang/String
    //   2169: dup
    //   2170: iconst_0
    //   2171: aload_3
    //   2172: invokevirtual 339	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2175: aastore
    //   2176: invokespecial 370	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2179: goto +406 -> 2585
    //   2182: ldc_w 561
    //   2185: aload 4
    //   2187: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2190: ifeq +28 -> 2218
    //   2193: aload_0
    //   2194: aload_1
    //   2195: iconst_1
    //   2196: anewarray 102	java/lang/String
    //   2199: dup
    //   2200: iconst_0
    //   2201: aload 5
    //   2203: invokeinterface 565 1 0
    //   2208: invokevirtual 339	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2211: aastore
    //   2212: invokespecial 370	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2215: goto +370 -> 2585
    //   2218: ldc_w 567
    //   2221: aload 4
    //   2223: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2226: ifeq +73 -> 2299
    //   2229: new 331	org/json/JSONObject
    //   2232: dup
    //   2233: aload_2
    //   2234: invokespecial 570	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2237: ldc_w 383
    //   2240: invokevirtual 551	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   2243: invokestatic 575	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2246: astore_2
    //   2247: aload_2
    //   2248: astore_1
    //   2249: aload_2
    //   2250: invokevirtual 578	java/lang/Long:longValue	()J
    //   2253: lconst_0
    //   2254: lcmp
    //   2255: ifne +32 -> 2287
    //   2258: aload_2
    //   2259: astore_1
    //   2260: aload 5
    //   2262: invokeinterface 360 1 0
    //   2267: ifnull +20 -> 2287
    //   2270: aload 5
    //   2272: invokeinterface 360 1 0
    //   2277: checkcast 580	com/tencent/mobileqq/vashealth/TracePointsData
    //   2280: getfield 581	com/tencent/mobileqq/vashealth/TracePointsData:startTime	J
    //   2283: invokestatic 575	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2286: astore_1
    //   2287: aload 5
    //   2289: aload_1
    //   2290: invokeinterface 585 2 0
    //   2295: pop
    //   2296: goto +289 -> 2585
    //   2299: ldc_w 587
    //   2302: aload 4
    //   2304: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2307: ifeq +85 -> 2392
    //   2310: new 331	org/json/JSONObject
    //   2313: dup
    //   2314: aload_2
    //   2315: invokespecial 570	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2318: ldc_w 589
    //   2321: invokevirtual 592	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   2324: istore 16
    //   2326: iload 16
    //   2328: iconst_1
    //   2329: if_icmpne +14 -> 2343
    //   2332: aload 5
    //   2334: iconst_1
    //   2335: invokeinterface 596 2 0
    //   2340: goto +16 -> 2356
    //   2343: iload 16
    //   2345: ifne +11 -> 2356
    //   2348: aload 5
    //   2350: iconst_0
    //   2351: invokeinterface 596 2 0
    //   2356: new 331	org/json/JSONObject
    //   2359: dup
    //   2360: invokespecial 346	org/json/JSONObject:<init>	()V
    //   2363: astore_2
    //   2364: aload_2
    //   2365: ldc_w 348
    //   2368: iconst_1
    //   2369: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2372: pop
    //   2373: aload_0
    //   2374: aload_1
    //   2375: iconst_1
    //   2376: anewarray 102	java/lang/String
    //   2379: dup
    //   2380: iconst_0
    //   2381: aload_2
    //   2382: invokevirtual 339	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2385: aastore
    //   2386: invokespecial 370	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2389: goto +196 -> 2585
    //   2392: ldc_w 598
    //   2395: aload 4
    //   2397: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2400: ifeq +72 -> 2472
    //   2403: new 331	org/json/JSONObject
    //   2406: dup
    //   2407: aload_2
    //   2408: invokespecial 570	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2411: ldc_w 600
    //   2414: invokevirtual 592	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   2417: iconst_1
    //   2418: if_icmpne +204 -> 2622
    //   2421: iconst_1
    //   2422: istore 18
    //   2424: goto +3 -> 2427
    //   2427: aload 5
    //   2429: iload 18
    //   2431: invokeinterface 603 2 0
    //   2436: new 331	org/json/JSONObject
    //   2439: dup
    //   2440: invokespecial 346	org/json/JSONObject:<init>	()V
    //   2443: astore_2
    //   2444: aload_2
    //   2445: ldc_w 348
    //   2448: iconst_1
    //   2449: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2452: pop
    //   2453: aload_0
    //   2454: aload_1
    //   2455: iconst_1
    //   2456: anewarray 102	java/lang/String
    //   2459: dup
    //   2460: iconst_0
    //   2461: aload_2
    //   2462: invokevirtual 339	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2465: aastore
    //   2466: invokespecial 370	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2469: goto +116 -> 2585
    //   2472: ldc_w 605
    //   2475: aload 4
    //   2477: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2480: ifeq +105 -> 2585
    //   2483: new 331	org/json/JSONObject
    //   2486: dup
    //   2487: invokespecial 346	org/json/JSONObject:<init>	()V
    //   2490: astore_2
    //   2491: aload_0
    //   2492: getfield 374	com/tencent/mobileqq/vashealth/HealthPathTracePlugin:d	Landroid/location/LocationManager;
    //   2495: ldc_w 376
    //   2498: invokevirtual 381	android/location/LocationManager:isProviderEnabled	(Ljava/lang/String;)Z
    //   2501: ifne +16 -> 2517
    //   2504: aload_2
    //   2505: ldc_w 348
    //   2508: bipush 254
    //   2510: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2513: pop
    //   2514: goto +12 -> 2526
    //   2517: aload_2
    //   2518: ldc_w 348
    //   2521: iconst_1
    //   2522: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2525: pop
    //   2526: aload_0
    //   2527: aload_1
    //   2528: iconst_1
    //   2529: anewarray 102	java/lang/String
    //   2532: dup
    //   2533: iconst_0
    //   2534: aload_2
    //   2535: invokevirtual 339	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2538: aastore
    //   2539: invokespecial 370	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2542: goto +43 -> 2585
    //   2545: astore_1
    //   2546: goto +4 -> 2550
    //   2549: astore_1
    //   2550: new 219	java/lang/StringBuilder
    //   2553: dup
    //   2554: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   2557: astore_2
    //   2558: aload_2
    //   2559: ldc_w 607
    //   2562: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2565: pop
    //   2566: aload_2
    //   2567: aload_1
    //   2568: invokevirtual 608	java/lang/Exception:toString	()Ljava/lang/String;
    //   2571: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2574: pop
    //   2575: ldc 80
    //   2577: iconst_1
    //   2578: aload_2
    //   2579: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2582: invokestatic 91	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2585: iconst_0
    //   2586: ireturn
    //   2587: iconst_0
    //   2588: ireturn
    //   2589: aconst_null
    //   2590: astore_1
    //   2591: goto -2496 -> 95
    //   2594: goto -9 -> 2585
    //   2597: iconst_0
    //   2598: istore 16
    //   2600: goto -1937 -> 663
    //   2603: goto -832 -> 1771
    //   2606: astore_1
    //   2607: goto -57 -> 2550
    //   2610: astore_1
    //   2611: goto +8 -> 2619
    //   2614: astore_1
    //   2615: goto +4 -> 2619
    //   2618: astore_1
    //   2619: goto -69 -> 2550
    //   2622: iconst_0
    //   2623: istore 18
    //   2625: goto -198 -> 2427
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2628	0	this	HealthPathTracePlugin
    //   0	2628	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	2628	2	paramString1	String
    //   0	2628	3	paramString2	String
    //   0	2628	4	paramString3	String
    //   0	2628	5	paramVarArgs	String[]
    //   1216	320	6	d1	double
    //   1222	316	8	d2	double
    //   1227	295	10	d3	double
    //   1249	276	12	d4	double
    //   1166	589	14	f1	float
    //   1244	265	15	f2	float
    //   658	1941	16	i	int
    //   1279	267	17	j	int
    //   142	2482	18	bool	boolean
    //   1054	648	19	l1	long
    //   1150	569	21	l2	long
    //   1173	300	23	l3	long
    //   25	2006	25	localObject1	Object
    //   1211	553	26	localObject2	Object
    //   1464	107	27	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   1942	1955	2545	java/lang/Exception
    //   1958	2025	2545	java/lang/Exception
    //   2028	2044	2545	java/lang/Exception
    //   2047	2091	2545	java/lang/Exception
    //   2094	2150	2545	java/lang/Exception
    //   2153	2163	2545	java/lang/Exception
    //   2163	2179	2545	java/lang/Exception
    //   2182	2215	2545	java/lang/Exception
    //   2218	2247	2545	java/lang/Exception
    //   2249	2258	2545	java/lang/Exception
    //   2260	2287	2545	java/lang/Exception
    //   2287	2296	2545	java/lang/Exception
    //   2299	2326	2545	java/lang/Exception
    //   2332	2340	2545	java/lang/Exception
    //   2348	2356	2545	java/lang/Exception
    //   2356	2389	2545	java/lang/Exception
    //   2392	2421	2545	java/lang/Exception
    //   2427	2469	2545	java/lang/Exception
    //   2472	2514	2545	java/lang/Exception
    //   2517	2526	2545	java/lang/Exception
    //   2526	2542	2545	java/lang/Exception
    //   21	27	2549	java/lang/Exception
    //   32	92	2549	java/lang/Exception
    //   100	116	2549	java/lang/Exception
    //   118	144	2549	java/lang/Exception
    //   149	204	2549	java/lang/Exception
    //   210	221	2549	java/lang/Exception
    //   225	238	2549	java/lang/Exception
    //   241	250	2549	java/lang/Exception
    //   250	267	2549	java/lang/Exception
    //   270	280	2549	java/lang/Exception
    //   285	316	2549	java/lang/Exception
    //   319	328	2549	java/lang/Exception
    //   333	393	2549	java/lang/Exception
    //   393	409	2549	java/lang/Exception
    //   412	423	2549	java/lang/Exception
    //   428	472	2549	java/lang/Exception
    //   475	512	2549	java/lang/Exception
    //   515	524	2549	java/lang/Exception
    //   524	540	2549	java/lang/Exception
    //   545	553	2549	java/lang/Exception
    //   556	614	2549	java/lang/Exception
    //   616	633	2549	java/lang/Exception
    //   636	657	2549	java/lang/Exception
    //   663	673	2549	java/lang/Exception
    //   673	702	2549	java/lang/Exception
    //   705	714	2549	java/lang/Exception
    //   714	730	2549	java/lang/Exception
    //   733	784	2549	java/lang/Exception
    //   787	845	2549	java/lang/Exception
    //   847	881	2549	java/lang/Exception
    //   884	929	2549	java/lang/Exception
    //   932	948	2549	java/lang/Exception
    //   948	964	2549	java/lang/Exception
    //   967	998	2549	java/lang/Exception
    //   1004	1015	2549	java/lang/Exception
    //   1019	1039	2549	java/lang/Exception
    //   1042	1078	2549	java/lang/Exception
    //   1081	1092	2549	java/lang/Exception
    //   1092	1168	2549	java/lang/Exception
    //   1191	1213	2606	java/lang/Exception
    //   1218	1224	2606	java/lang/Exception
    //   1235	1246	2606	java/lang/Exception
    //   1281	1409	2606	java/lang/Exception
    //   1182	1191	2610	java/lang/Exception
    //   1480	1486	2614	java/lang/Exception
    //   1497	1508	2614	java/lang/Exception
    //   1543	1671	2614	java/lang/Exception
    //   1409	1416	2618	java/lang/Exception
    //   1423	1472	2618	java/lang/Exception
    //   1671	1678	2618	java/lang/Exception
    //   1681	1771	2618	java/lang/Exception
    //   1773	1786	2618	java/lang/Exception
    //   1793	1867	2618	java/lang/Exception
    //   1873	1887	2618	java/lang/Exception
    //   1890	1900	2618	java/lang/Exception
    //   1900	1942	2618	java/lang/Exception
  }
  
  public boolean isNeedPreCreatePlugin(Intent paramIntent, String paramString1, String paramString2)
  {
    return a(paramString1);
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.a = this.mRuntime.d();
    this.b = this.mRuntime.b();
    this.d = ((LocationManager)this.a.getSystemService("location"));
    IPathTraceManager localIPathTraceManager = (IPathTraceManager)this.b.getRuntimeService(IPathTraceManager.class, "tool");
    Object localObject;
    if (this.mRuntime.f() != null) {
      localObject = this.mRuntime.f().getCurrentUrl();
    } else {
      localObject = null;
    }
    this.c = a((String)localObject);
    if (this.c) {
      localIPathTraceManager.registerWebViewPlug(this);
    }
    if (this.e == null) {
      b();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OnCreate isRunningPage: ");
      ((StringBuilder)localObject).append(this.c);
      QLog.d("PathTraceManager.Plugin", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void onDestroy()
  {
    try
    {
      Object localObject = (IPathTraceManager)this.b.getRuntimeService(IPathTraceManager.class, "tool");
      if ((localObject != null) && (((IPathTraceManager)localObject).getEngineWorkingMode() == 0) && (this.c))
      {
        QLog.d("PathTraceManager.Plugin", 1, "here stop");
        ((IPathTraceManager)localObject).stopLocation(-1);
        a();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDestroy isRunningPage: ");
      ((StringBuilder)localObject).append(this.c);
      QLog.d("PathTraceManager.Plugin", 1, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PathTraceManager.Plugin", 1, "onDestroy Err:", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthPathTracePlugin
 * JD-Core Version:    0.7.0.1
 */