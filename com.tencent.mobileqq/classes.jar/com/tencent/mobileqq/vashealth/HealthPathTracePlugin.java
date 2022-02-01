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
import com.tencent.mobileqq.vashealth.api.IPathTraceManager;
import com.tencent.mobileqq.webview.swift.IPreCreatePluginChecker;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class HealthPathTracePlugin
  extends WebViewPlugin
  implements IPreCreatePluginChecker
{
  public Activity a;
  private LocationManager a;
  public AppInterface a;
  public boolean a;
  
  public HealthPathTracePlugin()
  {
    this.mPluginNameSpace = "healthpathtrace";
  }
  
  private void a()
  {
    Intent localIntent = new Intent(this.mRuntime.a().getApplicationContext(), PathTraceService.class);
    try
    {
      this.mRuntime.a().getApplicationContext().stopService(localIntent);
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
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 8589934631L;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    Object localObject2 = (IPathTraceManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPathTraceManager.class, "tool");
    this.jdField_a_of_type_Boolean = a(paramString);
    boolean bool1 = this.jdField_a_of_type_Boolean;
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
        break label861;
        if ((paramLong != 2L) || (((IPathTraceManager)localObject2).getEngineWorkingMode() != 0)) {
          break;
        }
        if (Build.VERSION.SDK_INT >= 23)
        {
          if (this.jdField_a_of_type_AndroidAppActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
          {
            paramString = this.jdField_a_of_type_AndroidAppActivity;
            if ((paramString instanceof AppActivity)) {
              ((AppActivity)paramString).requestPermissions(this, 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
            }
          }
          else
          {
            ((IPathTraceManager)localObject2).startLocation(0);
          }
        }
        else {
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
        localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getSharedPreferences(this.mRuntime.a().getCurrentAccountUin(), 0);
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
      label861:
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
    //   1: ifnull +2815 -> 2816
    //   4: ldc 17
    //   6: aload_3
    //   7: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10: ifeq +2806 -> 2816
    //   13: aload 4
    //   15: ifnonnull +6 -> 21
    //   18: goto +2798 -> 2816
    //   21: aload_2
    //   22: invokestatic 293	com/tencent/mobileqq/webview/swift/WebViewPlugin:getJsonFromJSBridge	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   25: astore 26
    //   27: aload 26
    //   29: ifnull +2789 -> 2818
    //   32: aload 26
    //   34: ldc_w 295
    //   37: invokevirtual 300	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   40: astore_1
    //   41: new 185	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   48: astore_2
    //   49: aload_2
    //   50: ldc_w 302
    //   53: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_2
    //   58: aload 4
    //   60: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload_2
    //   65: ldc_w 304
    //   68: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload_2
    //   73: aload 26
    //   75: invokevirtual 305	org/json/JSONObject:toString	()Ljava/lang/String;
    //   78: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: ldc 60
    //   84: iconst_1
    //   85: aload_2
    //   86: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 72	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   92: goto +3 -> 95
    //   95: aload 5
    //   97: iconst_0
    //   98: aaload
    //   99: astore_2
    //   100: aload_1
    //   101: invokestatic 79	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   104: ifeq +14 -> 118
    //   107: ldc 60
    //   109: iconst_1
    //   110: ldc_w 307
    //   113: invokestatic 310	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   116: iconst_1
    //   117: ireturn
    //   118: aload_0
    //   119: getfield 94	com/tencent/mobileqq/vashealth/HealthPathTracePlugin:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   122: ldc 96
    //   124: ldc 98
    //   126: invokevirtual 104	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   129: checkcast 96	com/tencent/mobileqq/vashealth/api/IPathTraceManager
    //   132: astore 25
    //   134: ldc_w 312
    //   137: aload 4
    //   139: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   142: istore 18
    //   144: iload 18
    //   146: ifeq +124 -> 270
    //   149: new 297	org/json/JSONObject
    //   152: dup
    //   153: invokespecial 313	org/json/JSONObject:<init>	()V
    //   156: astore 4
    //   158: aload 4
    //   160: ldc_w 315
    //   163: iconst_1
    //   164: invokevirtual 318	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   167: pop
    //   168: aload 4
    //   170: ldc 167
    //   172: aload 25
    //   174: invokeinterface 198 1 0
    //   179: invokevirtual 318	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   182: pop
    //   183: aload 25
    //   185: invokeinterface 198 1 0
    //   190: ifeq +60 -> 250
    //   193: aload 25
    //   195: invokeinterface 322 1 0
    //   200: checkcast 324	com/tencent/mobileqq/vashealth/TracePathData
    //   203: astore_3
    //   204: aload_3
    //   205: astore_2
    //   206: aload_3
    //   207: ifnonnull +14 -> 221
    //   210: aload 25
    //   212: invokeinterface 327 1 0
    //   217: checkcast 324	com/tencent/mobileqq/vashealth/TracePathData
    //   220: astore_2
    //   221: aload_2
    //   222: ifnull +19 -> 241
    //   225: aload 4
    //   227: ldc_w 329
    //   230: aload_2
    //   231: getfield 331	com/tencent/mobileqq/vashealth/TracePathData:type	I
    //   234: invokevirtual 318	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   237: pop
    //   238: goto +12 -> 250
    //   241: ldc 60
    //   243: iconst_1
    //   244: ldc_w 333
    //   247: invokestatic 72	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   250: aload_0
    //   251: aload_1
    //   252: iconst_1
    //   253: anewarray 83	java/lang/String
    //   256: dup
    //   257: iconst_0
    //   258: aload 4
    //   260: invokevirtual 305	org/json/JSONObject:toString	()Ljava/lang/String;
    //   263: aastore
    //   264: invokespecial 337	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   267: goto +2556 -> 2823
    //   270: ldc_w 339
    //   273: aload 4
    //   275: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   278: istore 18
    //   280: iload 18
    //   282: ifeq +130 -> 412
    //   285: new 297	org/json/JSONObject
    //   288: dup
    //   289: invokespecial 313	org/json/JSONObject:<init>	()V
    //   292: astore_2
    //   293: aload_0
    //   294: getfield 341	com/tencent/mobileqq/vashealth/HealthPathTracePlugin:jdField_a_of_type_AndroidLocationLocationManager	Landroid/location/LocationManager;
    //   297: ldc_w 343
    //   300: invokevirtual 348	android/location/LocationManager:isProviderEnabled	(Ljava/lang/String;)Z
    //   303: ifne +16 -> 319
    //   306: aload_2
    //   307: ldc_w 315
    //   310: bipush 254
    //   312: invokevirtual 318	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   315: pop
    //   316: goto +77 -> 393
    //   319: aload_2
    //   320: ldc_w 315
    //   323: iconst_1
    //   324: invokevirtual 318	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   327: pop
    //   328: aload 25
    //   330: ifnull +63 -> 393
    //   333: aload 25
    //   335: invokeinterface 327 1 0
    //   340: ifnull +53 -> 393
    //   343: aload_2
    //   344: ldc_w 315
    //   347: bipush 249
    //   349: invokevirtual 318	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   352: pop
    //   353: aload_2
    //   354: ldc_w 350
    //   357: aload 25
    //   359: invokeinterface 327 1 0
    //   364: checkcast 324	com/tencent/mobileqq/vashealth/TracePathData
    //   367: getfield 353	com/tencent/mobileqq/vashealth/TracePathData:startTime	J
    //   370: invokevirtual 356	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   373: pop
    //   374: aload_2
    //   375: ldc_w 358
    //   378: aload 25
    //   380: aconst_null
    //   381: invokeinterface 361 2 0
    //   386: invokevirtual 305	org/json/JSONObject:toString	()Ljava/lang/String;
    //   389: invokevirtual 364	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   392: pop
    //   393: aload_0
    //   394: aload_1
    //   395: iconst_1
    //   396: anewarray 83	java/lang/String
    //   399: dup
    //   400: iconst_0
    //   401: aload_2
    //   402: invokevirtual 305	org/json/JSONObject:toString	()Ljava/lang/String;
    //   405: aastore
    //   406: invokevirtual 365	com/tencent/mobileqq/vashealth/HealthPathTracePlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   409: goto +2414 -> 2823
    //   412: ldc_w 367
    //   415: aload 4
    //   417: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   420: istore 18
    //   422: iload 18
    //   424: ifeq +238 -> 662
    //   427: aload 25
    //   429: ifnull +50 -> 479
    //   432: aload 25
    //   434: invokeinterface 122 1 0
    //   439: ifle +40 -> 479
    //   442: new 297	org/json/JSONObject
    //   445: dup
    //   446: invokespecial 313	org/json/JSONObject:<init>	()V
    //   449: astore_2
    //   450: aload_2
    //   451: ldc_w 315
    //   454: bipush 252
    //   456: invokevirtual 318	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   459: pop
    //   460: aload_0
    //   461: aload_1
    //   462: iconst_1
    //   463: anewarray 83	java/lang/String
    //   466: dup
    //   467: iconst_0
    //   468: aload_2
    //   469: invokevirtual 305	org/json/JSONObject:toString	()Ljava/lang/String;
    //   472: aastore
    //   473: invokespecial 337	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   476: goto +2347 -> 2823
    //   479: new 297	org/json/JSONObject
    //   482: dup
    //   483: invokespecial 313	org/json/JSONObject:<init>	()V
    //   486: astore_2
    //   487: getstatic 134	android/os/Build$VERSION:SDK_INT	I
    //   490: bipush 23
    //   492: if_icmplt +129 -> 621
    //   495: aload_0
    //   496: getfield 136	com/tencent/mobileqq/vashealth/HealthPathTracePlugin:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   499: ldc 138
    //   501: invokevirtual 144	android/app/Activity:checkSelfPermission	(Ljava/lang/String;)I
    //   504: ifeq +76 -> 580
    //   507: aload_0
    //   508: getfield 136	com/tencent/mobileqq/vashealth/HealthPathTracePlugin:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   511: instanceof 146
    //   514: ifeq +2309 -> 2823
    //   517: aload_0
    //   518: getfield 136	com/tencent/mobileqq/vashealth/HealthPathTracePlugin:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   521: checkcast 146	mqq/app/AppActivity
    //   524: aload_0
    //   525: iconst_1
    //   526: iconst_1
    //   527: anewarray 83	java/lang/String
    //   530: dup
    //   531: iconst_0
    //   532: ldc 138
    //   534: aastore
    //   535: invokevirtual 150	mqq/app/AppActivity:requestPermissions	(Ljava/lang/Object;I[Ljava/lang/String;)V
    //   538: aload_2
    //   539: ldc_w 315
    //   542: bipush 252
    //   544: invokevirtual 318	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   547: pop
    //   548: aload_0
    //   549: aload_1
    //   550: iconst_1
    //   551: anewarray 83	java/lang/String
    //   554: dup
    //   555: iconst_0
    //   556: aload_2
    //   557: invokevirtual 305	org/json/JSONObject:toString	()Ljava/lang/String;
    //   560: aastore
    //   561: invokespecial 337	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   564: aload 25
    //   566: ifnull +2257 -> 2823
    //   569: aload 25
    //   571: iconst_0
    //   572: invokeinterface 153 2 0
    //   577: goto +2246 -> 2823
    //   580: aload_2
    //   581: ldc_w 315
    //   584: iconst_1
    //   585: invokevirtual 318	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   588: pop
    //   589: aload_0
    //   590: aload_1
    //   591: iconst_1
    //   592: anewarray 83	java/lang/String
    //   595: dup
    //   596: iconst_0
    //   597: aload_2
    //   598: invokevirtual 305	org/json/JSONObject:toString	()Ljava/lang/String;
    //   601: aastore
    //   602: invokespecial 337	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   605: aload 25
    //   607: ifnull +2216 -> 2823
    //   610: aload 25
    //   612: iconst_0
    //   613: invokeinterface 153 2 0
    //   618: goto +2205 -> 2823
    //   621: aload_2
    //   622: ldc_w 315
    //   625: iconst_1
    //   626: invokevirtual 318	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   629: pop
    //   630: aload_0
    //   631: aload_1
    //   632: iconst_1
    //   633: anewarray 83	java/lang/String
    //   636: dup
    //   637: iconst_0
    //   638: aload_2
    //   639: invokevirtual 305	org/json/JSONObject:toString	()Ljava/lang/String;
    //   642: aastore
    //   643: invokespecial 337	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   646: aload 25
    //   648: ifnull +2175 -> 2823
    //   651: aload 25
    //   653: iconst_0
    //   654: invokeinterface 153 2 0
    //   659: goto +2164 -> 2823
    //   662: ldc_w 369
    //   665: aload 4
    //   667: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   670: ifeq +245 -> 915
    //   673: new 297	org/json/JSONObject
    //   676: dup
    //   677: invokespecial 313	org/json/JSONObject:<init>	()V
    //   680: astore_2
    //   681: aload_0
    //   682: getfield 341	com/tencent/mobileqq/vashealth/HealthPathTracePlugin:jdField_a_of_type_AndroidLocationLocationManager	Landroid/location/LocationManager;
    //   685: ldc_w 343
    //   688: invokevirtual 348	android/location/LocationManager:isProviderEnabled	(Ljava/lang/String;)Z
    //   691: ifne +31 -> 722
    //   694: aload_2
    //   695: ldc_w 315
    //   698: bipush 254
    //   700: invokevirtual 318	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   703: pop
    //   704: aload_0
    //   705: aload_1
    //   706: iconst_1
    //   707: anewarray 83	java/lang/String
    //   710: dup
    //   711: iconst_0
    //   712: aload_2
    //   713: invokevirtual 305	org/json/JSONObject:toString	()Ljava/lang/String;
    //   716: aastore
    //   717: invokespecial 337	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   720: iconst_0
    //   721: ireturn
    //   722: getstatic 134	android/os/Build$VERSION:SDK_INT	I
    //   725: bipush 19
    //   727: if_icmpge +15 -> 742
    //   730: aload_2
    //   731: ldc_w 371
    //   734: iconst_1
    //   735: invokevirtual 318	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   738: pop
    //   739: goto +40 -> 779
    //   742: aload_0
    //   743: getfield 136	com/tencent/mobileqq/vashealth/HealthPathTracePlugin:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   746: ldc_w 373
    //   749: invokevirtual 377	android/app/Activity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   752: checkcast 379	android/hardware/SensorManager
    //   755: bipush 19
    //   757: invokevirtual 383	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   760: ifnonnull +2066 -> 2826
    //   763: iconst_1
    //   764: istore 16
    //   766: goto +3 -> 769
    //   769: aload_2
    //   770: ldc_w 371
    //   773: iload 16
    //   775: invokevirtual 318	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   778: pop
    //   779: getstatic 134	android/os/Build$VERSION:SDK_INT	I
    //   782: bipush 23
    //   784: if_icmplt +103 -> 887
    //   787: aload_0
    //   788: getfield 136	com/tencent/mobileqq/vashealth/HealthPathTracePlugin:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   791: ldc 138
    //   793: invokevirtual 144	android/app/Activity:checkSelfPermission	(Ljava/lang/String;)I
    //   796: ifeq +63 -> 859
    //   799: aload_0
    //   800: getfield 136	com/tencent/mobileqq/vashealth/HealthPathTracePlugin:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   803: instanceof 146
    //   806: ifeq +2017 -> 2823
    //   809: aload_0
    //   810: getfield 136	com/tencent/mobileqq/vashealth/HealthPathTracePlugin:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   813: checkcast 146	mqq/app/AppActivity
    //   816: aload_0
    //   817: iconst_1
    //   818: iconst_1
    //   819: anewarray 83	java/lang/String
    //   822: dup
    //   823: iconst_0
    //   824: ldc 138
    //   826: aastore
    //   827: invokevirtual 150	mqq/app/AppActivity:requestPermissions	(Ljava/lang/Object;I[Ljava/lang/String;)V
    //   830: aload_2
    //   831: ldc_w 315
    //   834: bipush 254
    //   836: invokevirtual 318	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   839: pop
    //   840: aload_0
    //   841: aload_1
    //   842: iconst_1
    //   843: anewarray 83	java/lang/String
    //   846: dup
    //   847: iconst_0
    //   848: aload_2
    //   849: invokevirtual 305	org/json/JSONObject:toString	()Ljava/lang/String;
    //   852: aastore
    //   853: invokespecial 337	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   856: goto +1967 -> 2823
    //   859: aload 25
    //   861: aload 26
    //   863: invokeinterface 387 2 0
    //   868: aload_0
    //   869: aload_1
    //   870: iconst_1
    //   871: anewarray 83	java/lang/String
    //   874: dup
    //   875: iconst_0
    //   876: aload_2
    //   877: invokevirtual 305	org/json/JSONObject:toString	()Ljava/lang/String;
    //   880: aastore
    //   881: invokespecial 337	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   884: goto +1939 -> 2823
    //   887: aload 25
    //   889: aload 26
    //   891: invokeinterface 387 2 0
    //   896: aload_0
    //   897: aload_1
    //   898: iconst_1
    //   899: anewarray 83	java/lang/String
    //   902: dup
    //   903: iconst_0
    //   904: aload_2
    //   905: invokevirtual 305	org/json/JSONObject:toString	()Ljava/lang/String;
    //   908: aastore
    //   909: invokespecial 337	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   912: goto +1911 -> 2823
    //   915: ldc_w 389
    //   918: aload 4
    //   920: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   923: ifeq +46 -> 969
    //   926: new 297	org/json/JSONObject
    //   929: dup
    //   930: invokespecial 313	org/json/JSONObject:<init>	()V
    //   933: astore_2
    //   934: aload 25
    //   936: invokeinterface 392 1 0
    //   941: aload_2
    //   942: ldc_w 315
    //   945: iconst_1
    //   946: invokevirtual 318	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   949: pop
    //   950: aload_0
    //   951: aload_1
    //   952: iconst_1
    //   953: anewarray 83	java/lang/String
    //   956: dup
    //   957: iconst_0
    //   958: aload_2
    //   959: invokevirtual 305	org/json/JSONObject:toString	()Ljava/lang/String;
    //   962: aastore
    //   963: invokespecial 337	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   966: goto +1857 -> 2823
    //   969: ldc_w 394
    //   972: aload 4
    //   974: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   977: ifeq +223 -> 1200
    //   980: new 297	org/json/JSONObject
    //   983: dup
    //   984: invokespecial 313	org/json/JSONObject:<init>	()V
    //   987: astore_2
    //   988: aload_0
    //   989: getfield 341	com/tencent/mobileqq/vashealth/HealthPathTracePlugin:jdField_a_of_type_AndroidLocationLocationManager	Landroid/location/LocationManager;
    //   992: ldc_w 343
    //   995: invokevirtual 348	android/location/LocationManager:isProviderEnabled	(Ljava/lang/String;)Z
    //   998: ifne +31 -> 1029
    //   1001: aload_2
    //   1002: ldc_w 315
    //   1005: bipush 254
    //   1007: invokevirtual 318	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1010: pop
    //   1011: aload_0
    //   1012: aload_1
    //   1013: iconst_1
    //   1014: anewarray 83	java/lang/String
    //   1017: dup
    //   1018: iconst_0
    //   1019: aload_2
    //   1020: invokevirtual 305	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1023: aastore
    //   1024: invokespecial 337	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1027: iconst_0
    //   1028: ireturn
    //   1029: aload 25
    //   1031: invokeinterface 322 1 0
    //   1036: checkcast 324	com/tencent/mobileqq/vashealth/TracePathData
    //   1039: ifnonnull +27 -> 1066
    //   1042: aload_2
    //   1043: ldc_w 315
    //   1046: bipush 244
    //   1048: invokevirtual 318	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1051: pop
    //   1052: aload_2
    //   1053: ldc_w 396
    //   1056: ldc_w 398
    //   1059: invokevirtual 364	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1062: pop
    //   1063: goto +118 -> 1181
    //   1066: getstatic 134	android/os/Build$VERSION:SDK_INT	I
    //   1069: bipush 23
    //   1071: if_icmplt +94 -> 1165
    //   1074: aload_0
    //   1075: getfield 136	com/tencent/mobileqq/vashealth/HealthPathTracePlugin:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1078: ldc 138
    //   1080: invokevirtual 144	android/app/Activity:checkSelfPermission	(Ljava/lang/String;)I
    //   1083: ifeq +63 -> 1146
    //   1086: aload_0
    //   1087: getfield 136	com/tencent/mobileqq/vashealth/HealthPathTracePlugin:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1090: instanceof 146
    //   1093: ifeq +88 -> 1181
    //   1096: aload_0
    //   1097: getfield 136	com/tencent/mobileqq/vashealth/HealthPathTracePlugin:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1100: checkcast 146	mqq/app/AppActivity
    //   1103: aload_0
    //   1104: iconst_1
    //   1105: iconst_1
    //   1106: anewarray 83	java/lang/String
    //   1109: dup
    //   1110: iconst_0
    //   1111: ldc 138
    //   1113: aastore
    //   1114: invokevirtual 150	mqq/app/AppActivity:requestPermissions	(Ljava/lang/Object;I[Ljava/lang/String;)V
    //   1117: aload_2
    //   1118: ldc_w 315
    //   1121: bipush 254
    //   1123: invokevirtual 318	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1126: pop
    //   1127: aload_0
    //   1128: aload_1
    //   1129: iconst_1
    //   1130: anewarray 83	java/lang/String
    //   1133: dup
    //   1134: iconst_0
    //   1135: aload_2
    //   1136: invokevirtual 305	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1139: aastore
    //   1140: invokespecial 337	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1143: goto +38 -> 1181
    //   1146: aload 25
    //   1148: invokeinterface 401 1 0
    //   1153: aload_2
    //   1154: ldc_w 315
    //   1157: iconst_1
    //   1158: invokevirtual 318	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1161: pop
    //   1162: goto +19 -> 1181
    //   1165: aload 25
    //   1167: invokeinterface 401 1 0
    //   1172: aload_2
    //   1173: ldc_w 315
    //   1176: iconst_1
    //   1177: invokevirtual 318	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1180: pop
    //   1181: aload_0
    //   1182: aload_1
    //   1183: iconst_1
    //   1184: anewarray 83	java/lang/String
    //   1187: dup
    //   1188: iconst_0
    //   1189: aload_2
    //   1190: invokevirtual 305	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1193: aastore
    //   1194: invokespecial 337	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1197: goto +1626 -> 2823
    //   1200: ldc_w 403
    //   1203: aload 4
    //   1205: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1208: ifeq +979 -> 2187
    //   1211: new 297	org/json/JSONObject
    //   1214: dup
    //   1215: invokespecial 313	org/json/JSONObject:<init>	()V
    //   1218: astore 5
    //   1220: aload 25
    //   1222: invokeinterface 322 1 0
    //   1227: checkcast 324	com/tencent/mobileqq/vashealth/TracePathData
    //   1230: astore_3
    //   1231: aload_3
    //   1232: astore_2
    //   1233: aload_3
    //   1234: ifnonnull +14 -> 1248
    //   1237: aload 25
    //   1239: invokeinterface 327 1 0
    //   1244: checkcast 324	com/tencent/mobileqq/vashealth/TracePathData
    //   1247: astore_2
    //   1248: aload_2
    //   1249: ifnonnull +26 -> 1275
    //   1252: aload 5
    //   1254: ldc_w 315
    //   1257: bipush 248
    //   1259: invokevirtual 318	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1262: pop
    //   1263: ldc 60
    //   1265: iconst_1
    //   1266: ldc_w 405
    //   1269: invokestatic 310	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1272: goto +857 -> 2129
    //   1275: aload 26
    //   1277: ldc_w 407
    //   1280: aload_2
    //   1281: getfield 409	com/tencent/mobileqq/vashealth/TracePathData:totalTime	J
    //   1284: invokevirtual 412	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   1287: lstore 19
    //   1289: aload 25
    //   1291: lload 19
    //   1293: invokeinterface 416 3 0
    //   1298: ifeq +16 -> 1314
    //   1301: aload 5
    //   1303: ldc_w 315
    //   1306: iconst_1
    //   1307: invokevirtual 318	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1310: pop
    //   1311: goto +14 -> 1325
    //   1314: aload 5
    //   1316: ldc_w 315
    //   1319: bipush 251
    //   1321: invokevirtual 318	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1324: pop
    //   1325: aload 5
    //   1327: ldc_w 350
    //   1330: aload_2
    //   1331: getfield 353	com/tencent/mobileqq/vashealth/TracePathData:startTime	J
    //   1334: invokevirtual 356	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   1337: pop
    //   1338: new 418	org/json/JSONArray
    //   1341: dup
    //   1342: invokespecial 419	org/json/JSONArray:<init>	()V
    //   1345: astore 4
    //   1347: aload_0
    //   1348: getfield 30	com/tencent/mobileqq/vashealth/HealthPathTracePlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1351: invokevirtual 216	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   1354: invokevirtual 213	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   1357: aload_2
    //   1358: getfield 353	com/tencent/mobileqq/vashealth/TracePathData:startTime	J
    //   1361: invokestatic 422	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1364: iconst_0
    //   1365: invokevirtual 225	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1368: astore_3
    //   1369: aload_3
    //   1370: getstatic 427	com/tencent/mobileqq/vashealth/api/impl/PathTraceManagerImpl:LAST_TIME	I
    //   1373: invokestatic 430	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1376: lconst_0
    //   1377: invokeinterface 233 4 0
    //   1382: lstore 21
    //   1384: aload_3
    //   1385: getstatic 433	com/tencent/mobileqq/vashealth/api/impl/PathTraceManagerImpl:LAST_DISTANCE	I
    //   1388: invokestatic 430	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1391: fconst_0
    //   1392: invokeinterface 247 3 0
    //   1397: fstore 14
    //   1399: lload 19
    //   1401: lload 21
    //   1403: lsub
    //   1404: lstore 23
    //   1406: lload 23
    //   1408: lconst_0
    //   1409: lcmp
    //   1410: ifle +239 -> 1649
    //   1413: aload_3
    //   1414: invokeinterface 437 1 0
    //   1419: astore 25
    //   1421: aload_2
    //   1422: getfield 441	com/tencent/mobileqq/vashealth/TracePathData:distance	D
    //   1425: ldc2_w 442
    //   1428: ddiv
    //   1429: dconst_1
    //   1430: dadd
    //   1431: d2i
    //   1432: istore 16
    //   1434: new 185	java/lang/StringBuilder
    //   1437: dup
    //   1438: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   1441: astore 26
    //   1443: lload 23
    //   1445: l2d
    //   1446: dstore 6
    //   1448: aload_2
    //   1449: getfield 441	com/tencent/mobileqq/vashealth/TracePathData:distance	D
    //   1452: dstore 8
    //   1454: fload 14
    //   1456: f2d
    //   1457: dstore 10
    //   1459: dload 10
    //   1461: invokestatic 449	java/lang/Double:isNaN	(D)Z
    //   1464: pop
    //   1465: ldc_w 450
    //   1468: invokestatic 455	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1471: invokevirtual 459	java/lang/Float:floatValue	()F
    //   1474: fstore 15
    //   1476: fload 15
    //   1478: f2d
    //   1479: dstore 12
    //   1481: dload 12
    //   1483: invokestatic 449	java/lang/Double:isNaN	(D)Z
    //   1486: pop
    //   1487: dload 8
    //   1489: dload 10
    //   1491: dsub
    //   1492: dload 12
    //   1494: ddiv
    //   1495: dstore 8
    //   1497: dload 6
    //   1499: invokestatic 449	java/lang/Double:isNaN	(D)Z
    //   1502: pop
    //   1503: dload 6
    //   1505: dload 8
    //   1507: ddiv
    //   1508: d2i
    //   1509: istore 17
    //   1511: aload 26
    //   1513: iload 17
    //   1515: invokestatic 430	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1518: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1521: pop
    //   1522: aload 26
    //   1524: ldc_w 461
    //   1527: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1530: pop
    //   1531: aload 25
    //   1533: iload 16
    //   1535: invokestatic 430	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1538: aload 26
    //   1540: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1543: invokeinterface 467 3 0
    //   1548: invokeinterface 470 1 0
    //   1553: pop
    //   1554: new 185	java/lang/StringBuilder
    //   1557: dup
    //   1558: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   1561: astore 25
    //   1563: aload 25
    //   1565: ldc_w 472
    //   1568: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1571: pop
    //   1572: aload 25
    //   1574: lload 19
    //   1576: invokevirtual 277	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1579: pop
    //   1580: aload 25
    //   1582: ldc_w 474
    //   1585: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1588: pop
    //   1589: aload 25
    //   1591: lload 21
    //   1593: invokevirtual 277	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1596: pop
    //   1597: aload 25
    //   1599: ldc_w 476
    //   1602: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1605: pop
    //   1606: aload 25
    //   1608: aload_2
    //   1609: getfield 441	com/tencent/mobileqq/vashealth/TracePathData:distance	D
    //   1612: invokevirtual 479	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   1615: pop
    //   1616: aload 25
    //   1618: ldc_w 481
    //   1621: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1624: pop
    //   1625: aload 25
    //   1627: fload 14
    //   1629: invokevirtual 256	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1632: pop
    //   1633: aload 25
    //   1635: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1638: astore_2
    //   1639: ldc 60
    //   1641: iconst_1
    //   1642: aload_2
    //   1643: invokestatic 272	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1646: goto +1186 -> 2832
    //   1649: aload_2
    //   1650: getfield 409	com/tencent/mobileqq/vashealth/TracePathData:totalTime	J
    //   1653: lload 21
    //   1655: lsub
    //   1656: lconst_0
    //   1657: lcmp
    //   1658: ifle +248 -> 1906
    //   1661: aload_3
    //   1662: invokeinterface 437 1 0
    //   1667: astore 25
    //   1669: aload_2
    //   1670: getfield 441	com/tencent/mobileqq/vashealth/TracePathData:distance	D
    //   1673: ldc2_w 442
    //   1676: ddiv
    //   1677: dconst_1
    //   1678: dadd
    //   1679: d2i
    //   1680: istore 16
    //   1682: new 185	java/lang/StringBuilder
    //   1685: dup
    //   1686: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   1689: astore 26
    //   1691: aload_2
    //   1692: getfield 409	com/tencent/mobileqq/vashealth/TracePathData:totalTime	J
    //   1695: lstore 23
    //   1697: lload 23
    //   1699: lload 21
    //   1701: lsub
    //   1702: l2d
    //   1703: dstore 6
    //   1705: aload_2
    //   1706: getfield 441	com/tencent/mobileqq/vashealth/TracePathData:distance	D
    //   1709: dstore 8
    //   1711: fload 14
    //   1713: f2d
    //   1714: dstore 10
    //   1716: dload 10
    //   1718: invokestatic 449	java/lang/Double:isNaN	(D)Z
    //   1721: pop
    //   1722: ldc_w 450
    //   1725: invokestatic 455	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1728: invokevirtual 459	java/lang/Float:floatValue	()F
    //   1731: fstore 15
    //   1733: fload 15
    //   1735: f2d
    //   1736: dstore 12
    //   1738: dload 12
    //   1740: invokestatic 449	java/lang/Double:isNaN	(D)Z
    //   1743: pop
    //   1744: dload 8
    //   1746: dload 10
    //   1748: dsub
    //   1749: dload 12
    //   1751: ddiv
    //   1752: dstore 8
    //   1754: dload 6
    //   1756: invokestatic 449	java/lang/Double:isNaN	(D)Z
    //   1759: pop
    //   1760: dload 6
    //   1762: dload 8
    //   1764: ddiv
    //   1765: d2i
    //   1766: istore 17
    //   1768: aload 26
    //   1770: iload 17
    //   1772: invokestatic 430	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1775: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1778: pop
    //   1779: aload 26
    //   1781: ldc_w 461
    //   1784: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1787: pop
    //   1788: aload 25
    //   1790: iload 16
    //   1792: invokestatic 430	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1795: aload 26
    //   1797: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1800: invokeinterface 467 3 0
    //   1805: invokeinterface 470 1 0
    //   1810: pop
    //   1811: new 185	java/lang/StringBuilder
    //   1814: dup
    //   1815: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   1818: astore 25
    //   1820: aload 25
    //   1822: ldc_w 483
    //   1825: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1828: pop
    //   1829: aload 25
    //   1831: lload 19
    //   1833: invokevirtual 277	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1836: pop
    //   1837: aload 25
    //   1839: ldc_w 474
    //   1842: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1845: pop
    //   1846: aload 25
    //   1848: lload 21
    //   1850: invokevirtual 277	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1853: pop
    //   1854: aload 25
    //   1856: ldc_w 476
    //   1859: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1862: pop
    //   1863: aload 25
    //   1865: aload_2
    //   1866: getfield 441	com/tencent/mobileqq/vashealth/TracePathData:distance	D
    //   1869: invokevirtual 479	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   1872: pop
    //   1873: aload 25
    //   1875: ldc_w 481
    //   1878: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1881: pop
    //   1882: aload 25
    //   1884: fload 14
    //   1886: invokevirtual 256	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1889: pop
    //   1890: aload 25
    //   1892: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1895: astore_2
    //   1896: ldc 60
    //   1898: iconst_1
    //   1899: aload_2
    //   1900: invokestatic 272	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1903: goto +929 -> 2832
    //   1906: new 185	java/lang/StringBuilder
    //   1909: dup
    //   1910: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   1913: astore 25
    //   1915: aload 25
    //   1917: ldc_w 485
    //   1920: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1923: pop
    //   1924: aload 25
    //   1926: lload 19
    //   1928: invokevirtual 277	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1931: pop
    //   1932: aload 25
    //   1934: ldc_w 474
    //   1937: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1940: pop
    //   1941: aload 25
    //   1943: lload 21
    //   1945: invokevirtual 277	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1948: pop
    //   1949: aload 25
    //   1951: ldc_w 476
    //   1954: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1957: pop
    //   1958: aload 25
    //   1960: aload_2
    //   1961: getfield 441	com/tencent/mobileqq/vashealth/TracePathData:distance	D
    //   1964: invokevirtual 479	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   1967: pop
    //   1968: aload 25
    //   1970: ldc_w 481
    //   1973: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1976: pop
    //   1977: aload 25
    //   1979: fload 14
    //   1981: invokevirtual 256	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1984: pop
    //   1985: ldc 60
    //   1987: iconst_1
    //   1988: aload 25
    //   1990: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1993: invokestatic 272	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1996: aload 4
    //   1998: astore_2
    //   1999: aload_3
    //   2000: astore 4
    //   2002: aload 4
    //   2004: iconst_1
    //   2005: invokestatic 430	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2008: aconst_null
    //   2009: invokeinterface 488 3 0
    //   2014: astore_3
    //   2015: iconst_1
    //   2016: istore 16
    //   2018: aload_3
    //   2019: ifnull +100 -> 2119
    //   2022: aload_3
    //   2023: ldc_w 490
    //   2026: invokevirtual 494	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   2029: astore_3
    //   2030: new 297	org/json/JSONObject
    //   2033: dup
    //   2034: invokespecial 313	org/json/JSONObject:<init>	()V
    //   2037: astore 25
    //   2039: aload 25
    //   2041: ldc_w 496
    //   2044: iload 16
    //   2046: invokestatic 430	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2049: invokevirtual 364	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2052: pop
    //   2053: aload 25
    //   2055: ldc_w 498
    //   2058: aload_3
    //   2059: iconst_0
    //   2060: aaload
    //   2061: invokevirtual 364	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2064: pop
    //   2065: aload 25
    //   2067: ldc_w 500
    //   2070: aload_3
    //   2071: iconst_1
    //   2072: aaload
    //   2073: invokevirtual 364	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2076: pop
    //   2077: aload 25
    //   2079: ldc_w 502
    //   2082: aload_3
    //   2083: iconst_2
    //   2084: aaload
    //   2085: invokevirtual 364	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2088: pop
    //   2089: aload_2
    //   2090: aload 25
    //   2092: invokevirtual 505	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   2095: pop
    //   2096: iload 16
    //   2098: iconst_1
    //   2099: iadd
    //   2100: istore 16
    //   2102: aload 4
    //   2104: iload 16
    //   2106: invokestatic 430	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2109: aconst_null
    //   2110: invokeinterface 488 3 0
    //   2115: astore_3
    //   2116: goto -98 -> 2018
    //   2119: aload 5
    //   2121: ldc_w 507
    //   2124: aload_2
    //   2125: invokevirtual 364	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2128: pop
    //   2129: new 185	java/lang/StringBuilder
    //   2132: dup
    //   2133: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   2136: astore_2
    //   2137: aload_2
    //   2138: ldc_w 509
    //   2141: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2144: pop
    //   2145: aload_2
    //   2146: aload 5
    //   2148: invokevirtual 305	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2151: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2154: pop
    //   2155: ldc 60
    //   2157: iconst_1
    //   2158: aload_2
    //   2159: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2162: invokestatic 272	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2165: aload 5
    //   2167: invokevirtual 305	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2170: astore_2
    //   2171: aload_0
    //   2172: aload_1
    //   2173: iconst_1
    //   2174: anewarray 83	java/lang/String
    //   2177: dup
    //   2178: iconst_0
    //   2179: aload_2
    //   2180: aastore
    //   2181: invokespecial 337	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2184: goto +630 -> 2814
    //   2187: ldc_w 511
    //   2190: aload 4
    //   2192: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2195: ifeq +81 -> 2276
    //   2198: new 297	org/json/JSONObject
    //   2201: dup
    //   2202: invokespecial 313	org/json/JSONObject:<init>	()V
    //   2205: astore_2
    //   2206: aload 26
    //   2208: ldc_w 350
    //   2211: invokevirtual 514	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2214: ifne +43 -> 2257
    //   2217: aload_2
    //   2218: ldc_w 315
    //   2221: bipush 244
    //   2223: invokevirtual 318	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2226: pop
    //   2227: aload_2
    //   2228: ldc_w 396
    //   2231: ldc_w 398
    //   2234: invokevirtual 364	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2237: pop
    //   2238: aload_0
    //   2239: aload_1
    //   2240: iconst_1
    //   2241: anewarray 83	java/lang/String
    //   2244: dup
    //   2245: iconst_0
    //   2246: aload_2
    //   2247: invokevirtual 305	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2250: aastore
    //   2251: invokespecial 337	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2254: goto +560 -> 2814
    //   2257: aload 25
    //   2259: aload 26
    //   2261: ldc_w 350
    //   2264: invokevirtual 516	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   2267: aload_1
    //   2268: invokeinterface 520 4 0
    //   2273: goto +541 -> 2814
    //   2276: ldc_w 522
    //   2279: aload 4
    //   2281: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2284: ifeq +39 -> 2323
    //   2287: new 297	org/json/JSONObject
    //   2290: dup
    //   2291: invokespecial 313	org/json/JSONObject:<init>	()V
    //   2294: astore_2
    //   2295: aload_2
    //   2296: ldc_w 315
    //   2299: iconst_1
    //   2300: invokevirtual 318	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2303: pop
    //   2304: aload_0
    //   2305: aload_1
    //   2306: iconst_1
    //   2307: anewarray 83	java/lang/String
    //   2310: dup
    //   2311: iconst_0
    //   2312: aload_2
    //   2313: invokevirtual 305	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2316: aastore
    //   2317: invokespecial 337	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2320: goto +494 -> 2814
    //   2323: ldc_w 524
    //   2326: aload 4
    //   2328: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2331: ifeq +80 -> 2411
    //   2334: new 297	org/json/JSONObject
    //   2337: dup
    //   2338: invokespecial 313	org/json/JSONObject:<init>	()V
    //   2341: astore_3
    //   2342: aload_1
    //   2343: invokestatic 79	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2346: ifne +36 -> 2382
    //   2349: aload 25
    //   2351: aload_2
    //   2352: invokeinterface 361 2 0
    //   2357: astore_2
    //   2358: aload_3
    //   2359: ldc_w 315
    //   2362: iconst_1
    //   2363: invokevirtual 318	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2366: pop
    //   2367: aload_3
    //   2368: ldc_w 358
    //   2371: aload_2
    //   2372: invokevirtual 305	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2375: invokevirtual 364	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2378: pop
    //   2379: goto +13 -> 2392
    //   2382: aload_3
    //   2383: ldc_w 315
    //   2386: bipush 248
    //   2388: invokevirtual 318	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2391: pop
    //   2392: aload_0
    //   2393: aload_1
    //   2394: iconst_1
    //   2395: anewarray 83	java/lang/String
    //   2398: dup
    //   2399: iconst_0
    //   2400: aload_3
    //   2401: invokevirtual 305	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2404: aastore
    //   2405: invokespecial 337	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2408: goto +406 -> 2814
    //   2411: ldc_w 526
    //   2414: aload 4
    //   2416: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2419: ifeq +28 -> 2447
    //   2422: aload_0
    //   2423: aload_1
    //   2424: iconst_1
    //   2425: anewarray 83	java/lang/String
    //   2428: dup
    //   2429: iconst_0
    //   2430: aload 25
    //   2432: invokeinterface 530 1 0
    //   2437: invokevirtual 305	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2440: aastore
    //   2441: invokespecial 337	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2444: goto +370 -> 2814
    //   2447: ldc_w 532
    //   2450: aload 4
    //   2452: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2455: ifeq +73 -> 2528
    //   2458: new 297	org/json/JSONObject
    //   2461: dup
    //   2462: aload_2
    //   2463: invokespecial 535	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2466: ldc_w 350
    //   2469: invokevirtual 516	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   2472: invokestatic 540	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2475: astore_2
    //   2476: aload_2
    //   2477: astore_1
    //   2478: aload_2
    //   2479: invokevirtual 543	java/lang/Long:longValue	()J
    //   2482: lconst_0
    //   2483: lcmp
    //   2484: ifne +32 -> 2516
    //   2487: aload_2
    //   2488: astore_1
    //   2489: aload 25
    //   2491: invokeinterface 327 1 0
    //   2496: ifnull +20 -> 2516
    //   2499: aload 25
    //   2501: invokeinterface 327 1 0
    //   2506: checkcast 545	com/tencent/mobileqq/vashealth/TracePointsData
    //   2509: getfield 546	com/tencent/mobileqq/vashealth/TracePointsData:startTime	J
    //   2512: invokestatic 540	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2515: astore_1
    //   2516: aload 25
    //   2518: aload_1
    //   2519: invokeinterface 550 2 0
    //   2524: pop
    //   2525: goto +289 -> 2814
    //   2528: ldc_w 552
    //   2531: aload 4
    //   2533: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2536: ifeq +85 -> 2621
    //   2539: new 297	org/json/JSONObject
    //   2542: dup
    //   2543: aload_2
    //   2544: invokespecial 535	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2547: ldc_w 554
    //   2550: invokevirtual 557	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   2553: istore 16
    //   2555: iload 16
    //   2557: iconst_1
    //   2558: if_icmpne +14 -> 2572
    //   2561: aload 25
    //   2563: iconst_1
    //   2564: invokeinterface 561 2 0
    //   2569: goto +16 -> 2585
    //   2572: iload 16
    //   2574: ifne +11 -> 2585
    //   2577: aload 25
    //   2579: iconst_0
    //   2580: invokeinterface 561 2 0
    //   2585: new 297	org/json/JSONObject
    //   2588: dup
    //   2589: invokespecial 313	org/json/JSONObject:<init>	()V
    //   2592: astore_2
    //   2593: aload_2
    //   2594: ldc_w 315
    //   2597: iconst_1
    //   2598: invokevirtual 318	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2601: pop
    //   2602: aload_0
    //   2603: aload_1
    //   2604: iconst_1
    //   2605: anewarray 83	java/lang/String
    //   2608: dup
    //   2609: iconst_0
    //   2610: aload_2
    //   2611: invokevirtual 305	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2614: aastore
    //   2615: invokespecial 337	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2618: goto +196 -> 2814
    //   2621: ldc_w 563
    //   2624: aload 4
    //   2626: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2629: ifeq +72 -> 2701
    //   2632: new 297	org/json/JSONObject
    //   2635: dup
    //   2636: aload_2
    //   2637: invokespecial 535	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2640: ldc_w 565
    //   2643: invokevirtual 557	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   2646: iconst_1
    //   2647: if_icmpne +200 -> 2847
    //   2650: iconst_1
    //   2651: istore 18
    //   2653: goto +3 -> 2656
    //   2656: aload 25
    //   2658: iload 18
    //   2660: invokeinterface 568 2 0
    //   2665: new 297	org/json/JSONObject
    //   2668: dup
    //   2669: invokespecial 313	org/json/JSONObject:<init>	()V
    //   2672: astore_2
    //   2673: aload_2
    //   2674: ldc_w 315
    //   2677: iconst_1
    //   2678: invokevirtual 318	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2681: pop
    //   2682: aload_0
    //   2683: aload_1
    //   2684: iconst_1
    //   2685: anewarray 83	java/lang/String
    //   2688: dup
    //   2689: iconst_0
    //   2690: aload_2
    //   2691: invokevirtual 305	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2694: aastore
    //   2695: invokespecial 337	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2698: goto +116 -> 2814
    //   2701: ldc_w 570
    //   2704: aload 4
    //   2706: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2709: ifeq +105 -> 2814
    //   2712: new 297	org/json/JSONObject
    //   2715: dup
    //   2716: invokespecial 313	org/json/JSONObject:<init>	()V
    //   2719: astore_2
    //   2720: aload_0
    //   2721: getfield 341	com/tencent/mobileqq/vashealth/HealthPathTracePlugin:jdField_a_of_type_AndroidLocationLocationManager	Landroid/location/LocationManager;
    //   2724: ldc_w 343
    //   2727: invokevirtual 348	android/location/LocationManager:isProviderEnabled	(Ljava/lang/String;)Z
    //   2730: ifne +16 -> 2746
    //   2733: aload_2
    //   2734: ldc_w 315
    //   2737: bipush 254
    //   2739: invokevirtual 318	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2742: pop
    //   2743: goto +12 -> 2755
    //   2746: aload_2
    //   2747: ldc_w 315
    //   2750: iconst_1
    //   2751: invokevirtual 318	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2754: pop
    //   2755: aload_0
    //   2756: aload_1
    //   2757: iconst_1
    //   2758: anewarray 83	java/lang/String
    //   2761: dup
    //   2762: iconst_0
    //   2763: aload_2
    //   2764: invokevirtual 305	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2767: aastore
    //   2768: invokespecial 337	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2771: goto +43 -> 2814
    //   2774: astore_1
    //   2775: goto +4 -> 2779
    //   2778: astore_1
    //   2779: new 185	java/lang/StringBuilder
    //   2782: dup
    //   2783: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   2786: astore_2
    //   2787: aload_2
    //   2788: ldc_w 572
    //   2791: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2794: pop
    //   2795: aload_2
    //   2796: aload_1
    //   2797: invokevirtual 573	java/lang/Exception:toString	()Ljava/lang/String;
    //   2800: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2803: pop
    //   2804: ldc 60
    //   2806: iconst_1
    //   2807: aload_2
    //   2808: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2811: invokestatic 72	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2814: iconst_0
    //   2815: ireturn
    //   2816: iconst_0
    //   2817: ireturn
    //   2818: aconst_null
    //   2819: astore_1
    //   2820: goto -2725 -> 95
    //   2823: goto -9 -> 2814
    //   2826: iconst_0
    //   2827: istore 16
    //   2829: goto -2060 -> 769
    //   2832: goto -836 -> 1996
    //   2835: astore_1
    //   2836: goto -57 -> 2779
    //   2839: astore_1
    //   2840: goto +4 -> 2844
    //   2843: astore_1
    //   2844: goto -65 -> 2779
    //   2847: iconst_0
    //   2848: istore 18
    //   2850: goto -194 -> 2656
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2853	0	this	HealthPathTracePlugin
    //   0	2853	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	2853	2	paramString1	String
    //   0	2853	3	paramString2	String
    //   0	2853	4	paramString3	String
    //   0	2853	5	paramVarArgs	String[]
    //   1446	315	6	d1	double
    //   1452	311	8	d2	double
    //   1457	290	10	d3	double
    //   1479	271	12	d4	double
    //   1397	583	14	f1	float
    //   1474	260	15	f2	float
    //   764	2064	16	i	int
    //   1509	262	17	j	int
    //   142	2707	18	bool	boolean
    //   1287	640	19	l1	long
    //   1382	562	21	l2	long
    //   1404	294	23	l3	long
    //   132	2525	25	localObject1	Object
    //   25	2235	26	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2171	2184	2774	java/lang/Exception
    //   2187	2254	2774	java/lang/Exception
    //   2257	2273	2774	java/lang/Exception
    //   2276	2320	2774	java/lang/Exception
    //   2323	2379	2774	java/lang/Exception
    //   2382	2392	2774	java/lang/Exception
    //   2392	2408	2774	java/lang/Exception
    //   2411	2444	2774	java/lang/Exception
    //   2447	2476	2774	java/lang/Exception
    //   2478	2487	2774	java/lang/Exception
    //   2489	2516	2774	java/lang/Exception
    //   2516	2525	2774	java/lang/Exception
    //   2528	2555	2774	java/lang/Exception
    //   2561	2569	2774	java/lang/Exception
    //   2577	2585	2774	java/lang/Exception
    //   2585	2618	2774	java/lang/Exception
    //   2621	2650	2774	java/lang/Exception
    //   2656	2698	2774	java/lang/Exception
    //   2701	2743	2774	java/lang/Exception
    //   2746	2755	2774	java/lang/Exception
    //   2755	2771	2774	java/lang/Exception
    //   21	27	2778	java/lang/Exception
    //   32	92	2778	java/lang/Exception
    //   100	116	2778	java/lang/Exception
    //   118	144	2778	java/lang/Exception
    //   149	204	2778	java/lang/Exception
    //   210	221	2778	java/lang/Exception
    //   225	238	2778	java/lang/Exception
    //   241	250	2778	java/lang/Exception
    //   250	267	2778	java/lang/Exception
    //   270	280	2778	java/lang/Exception
    //   285	316	2778	java/lang/Exception
    //   319	328	2778	java/lang/Exception
    //   333	393	2778	java/lang/Exception
    //   393	409	2778	java/lang/Exception
    //   412	422	2778	java/lang/Exception
    //   432	476	2778	java/lang/Exception
    //   479	564	2778	java/lang/Exception
    //   569	577	2778	java/lang/Exception
    //   580	605	2778	java/lang/Exception
    //   610	618	2778	java/lang/Exception
    //   621	646	2778	java/lang/Exception
    //   651	659	2778	java/lang/Exception
    //   662	720	2778	java/lang/Exception
    //   722	739	2778	java/lang/Exception
    //   742	763	2778	java/lang/Exception
    //   769	779	2778	java/lang/Exception
    //   779	856	2778	java/lang/Exception
    //   859	884	2778	java/lang/Exception
    //   887	912	2778	java/lang/Exception
    //   915	966	2778	java/lang/Exception
    //   969	1027	2778	java/lang/Exception
    //   1029	1063	2778	java/lang/Exception
    //   1066	1143	2778	java/lang/Exception
    //   1146	1162	2778	java/lang/Exception
    //   1165	1181	2778	java/lang/Exception
    //   1181	1197	2778	java/lang/Exception
    //   1200	1231	2778	java/lang/Exception
    //   1237	1248	2778	java/lang/Exception
    //   1252	1272	2778	java/lang/Exception
    //   1275	1311	2778	java/lang/Exception
    //   1314	1325	2778	java/lang/Exception
    //   1325	1399	2778	java/lang/Exception
    //   1421	1443	2835	java/lang/Exception
    //   1448	1454	2835	java/lang/Exception
    //   1465	1476	2835	java/lang/Exception
    //   1511	1639	2835	java/lang/Exception
    //   1705	1711	2839	java/lang/Exception
    //   1722	1733	2839	java/lang/Exception
    //   1768	1896	2839	java/lang/Exception
    //   1413	1421	2843	java/lang/Exception
    //   1639	1646	2843	java/lang/Exception
    //   1649	1697	2843	java/lang/Exception
    //   1896	1903	2843	java/lang/Exception
    //   1906	1996	2843	java/lang/Exception
    //   2002	2015	2843	java/lang/Exception
    //   2022	2096	2843	java/lang/Exception
    //   2102	2116	2843	java/lang/Exception
    //   2119	2129	2843	java/lang/Exception
    //   2129	2171	2843	java/lang/Exception
  }
  
  public boolean isNeedPreCreatePlugin(Intent paramIntent, String paramString1, String paramString2)
  {
    return a(paramString1);
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_AndroidAppActivity = this.mRuntime.a();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = this.mRuntime.a();
    this.jdField_a_of_type_AndroidLocationLocationManager = ((LocationManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("location"));
    IPathTraceManager localIPathTraceManager = (IPathTraceManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPathTraceManager.class, "tool");
    Object localObject;
    if (this.mRuntime.a() != null) {
      localObject = this.mRuntime.a().getCurrentUrl();
    } else {
      localObject = null;
    }
    this.jdField_a_of_type_Boolean = a((String)localObject);
    if (this.jdField_a_of_type_Boolean) {
      localIPathTraceManager.registerWebViewPlug(this);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OnCreate isRunningPage: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      QLog.d("PathTraceManager.Plugin", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void onDestroy()
  {
    try
    {
      Object localObject = (IPathTraceManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPathTraceManager.class, "tool");
      if ((localObject != null) && (((IPathTraceManager)localObject).getEngineWorkingMode() == 0) && (this.jdField_a_of_type_Boolean))
      {
        QLog.d("PathTraceManager.Plugin", 1, "here stop");
        ((IPathTraceManager)localObject).stopLocation(-1);
        a();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDestroy isRunningPage: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      QLog.d("PathTraceManager.Plugin", 1, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PathTraceManager.Plugin", 1, "onDestroy Err:", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthPathTracePlugin
 * JD-Core Version:    0.7.0.1
 */