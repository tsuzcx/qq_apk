package com.tencent.mobileqq.intervideo.huayang;

import adke;
import adkf;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class HuayangJsPlugin
  extends WebViewPlugin
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  protected BroadcastReceiver a;
  public Context a;
  private Handler jdField_a_of_type_AndroidOsHandler = new adkf(this, Looper.getMainLooper());
  public TroopMemberApiClient a;
  public String a;
  private int b;
  public String b;
  private String c;
  private String d;
  
  public HuayangJsPlugin()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new adke(this);
    this.mPluginNameSpace = "huayang";
  }
  
  public static String a(String paramString)
  {
    return "com.tencent.mobileqq.intervideo.huayang.downloadPreLoad" + paramString;
  }
  
  private JSONObject a(int paramInt)
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
  
  private void a()
  {
    try
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HuayangJsPlugin", 2, paramString);
    }
  }
  
  public static boolean a(String paramString)
  {
    return TextUtils.equals(paramString, "com.tencent.od");
  }
  
  public static String b(String paramString)
  {
    return "com.tencent.mobileqq.intervideo.backPressed" + paramString;
  }
  
  public static boolean b(String paramString)
  {
    return TextUtils.equals(paramString, "com.tencent.huayang");
  }
  
  public static String c(String paramString)
  {
    return "com.tencent.mobileqq.intervideo.userCacheState" + paramString;
  }
  
  public static String d(String paramString)
  {
    return "com.tencent.mobileqq.huayang.launcher" + paramString;
  }
  
  /* Error */
  public boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 43
    //   2: aload_3
    //   3: invokevirtual 144	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifne +14 -> 20
    //   9: ldc 146
    //   11: aload_3
    //   12: invokevirtual 144	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15: ifne +5 -> 20
    //   18: iconst_0
    //   19: ireturn
    //   20: new 58	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   27: ldc 148
    //   29: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload 4
    //   34: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 150
    //   39: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: astore_2
    //   43: aload 5
    //   45: ifnull +435 -> 480
    //   48: aload 5
    //   50: arraylength
    //   51: ifle +429 -> 480
    //   54: aload 5
    //   56: iconst_0
    //   57: aaload
    //   58: astore_1
    //   59: aload_0
    //   60: aload_2
    //   61: aload_1
    //   62: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokespecial 107	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:a	(Ljava/lang/String;)V
    //   71: ldc 152
    //   73: aload 4
    //   75: invokevirtual 144	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   78: ifeq +457 -> 535
    //   81: ldc 154
    //   83: invokestatic 157	com/tencent/mobileqq/intervideo/huayang/Monitor:a	(Ljava/lang/String;)V
    //   86: aconst_null
    //   87: astore 4
    //   89: aconst_null
    //   90: astore 6
    //   92: aconst_null
    //   93: astore 7
    //   95: aconst_null
    //   96: astore 8
    //   98: aload 6
    //   100: astore_3
    //   101: aload 7
    //   103: astore_2
    //   104: aload 8
    //   106: astore_1
    //   107: aload 5
    //   109: ifnull +208 -> 317
    //   112: aload 6
    //   114: astore_3
    //   115: aload 7
    //   117: astore_2
    //   118: aload 8
    //   120: astore_1
    //   121: aload 5
    //   123: arraylength
    //   124: ifle +193 -> 317
    //   127: aload 4
    //   129: astore_1
    //   130: new 74	org/json/JSONObject
    //   133: dup
    //   134: aload 5
    //   136: iconst_0
    //   137: aaload
    //   138: invokespecial 159	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   141: astore 5
    //   143: aload 4
    //   145: astore_1
    //   146: aload 5
    //   148: ldc 161
    //   150: invokevirtual 164	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   153: astore_3
    //   154: aload_3
    //   155: astore_1
    //   156: aload 5
    //   158: ldc 166
    //   160: invokevirtual 164	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   163: astore_2
    //   164: aload_2
    //   165: astore_1
    //   166: aload_0
    //   167: aload 5
    //   169: ldc 168
    //   171: invokevirtual 164	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   174: putfield 170	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   177: aload_0
    //   178: aload 5
    //   180: ldc 172
    //   182: invokevirtual 164	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   185: putfield 55	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:d	Ljava/lang/String;
    //   188: aload_0
    //   189: aload 5
    //   191: ldc 174
    //   193: invokevirtual 164	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   196: putfield 176	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   199: aload 5
    //   201: ldc 178
    //   203: invokevirtual 164	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   206: astore 4
    //   208: aload_0
    //   209: aload 5
    //   211: ldc 180
    //   213: invokevirtual 164	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   216: putfield 182	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:c	Ljava/lang/String;
    //   219: aload_1
    //   220: astore_2
    //   221: aload_1
    //   222: ifnull +10 -> 232
    //   225: aload_1
    //   226: ldc 184
    //   228: invokestatic 190	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   231: astore_2
    //   232: aload 4
    //   234: astore_1
    //   235: aload_0
    //   236: getfield 176	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   239: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   242: ifeq +9 -> 251
    //   245: aload_0
    //   246: ldc 131
    //   248: putfield 176	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   251: new 196	android/content/IntentFilter
    //   254: dup
    //   255: aload_0
    //   256: getfield 176	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   259: invokestatic 198	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:a	(Ljava/lang/String;)Ljava/lang/String;
    //   262: invokespecial 199	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   265: astore 4
    //   267: aload 4
    //   269: aload_0
    //   270: getfield 176	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   273: invokestatic 201	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:b	(Ljava/lang/String;)Ljava/lang/String;
    //   276: invokevirtual 204	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   279: aload 4
    //   281: aload_0
    //   282: getfield 176	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   285: invokestatic 206	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:c	(Ljava/lang/String;)Ljava/lang/String;
    //   288: invokevirtual 204	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   291: aload 4
    //   293: aload_0
    //   294: getfield 176	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   297: invokestatic 208	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:d	(Ljava/lang/String;)Ljava/lang/String;
    //   300: invokevirtual 204	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   303: aload_0
    //   304: getfield 97	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   307: aload_0
    //   308: getfield 28	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   311: aload 4
    //   313: invokevirtual 212	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   316: pop
    //   317: aload_0
    //   318: invokestatic 218	java/lang/System:currentTimeMillis	()J
    //   321: putfield 220	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_a_of_type_Long	J
    //   324: aload_0
    //   325: getfield 55	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:d	Ljava/lang/String;
    //   328: ldc 222
    //   330: invokestatic 127	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   333: ifeq +74 -> 407
    //   336: aload_0
    //   337: getfield 176	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   340: ldc 121
    //   342: invokestatic 127	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   345: ifeq +62 -> 407
    //   348: aload_0
    //   349: getfield 97	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   352: invokestatic 228	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   355: invokeinterface 234 1 0
    //   360: astore 4
    //   362: aload 4
    //   364: new 58	java/lang/StringBuilder
    //   367: dup
    //   368: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   371: ldc 236
    //   373: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: aload_0
    //   377: getfield 240	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   380: invokevirtual 245	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   383: invokevirtual 250	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   386: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: iconst_1
    //   393: invokeinterface 256 3 0
    //   398: pop
    //   399: aload 4
    //   401: invokeinterface 259 1 0
    //   406: pop
    //   407: aload_0
    //   408: getfield 261	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   411: aload_0
    //   412: getfield 182	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:c	Ljava/lang/String;
    //   415: aload_3
    //   416: aload_2
    //   417: aload_0
    //   418: getfield 55	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:d	Ljava/lang/String;
    //   421: aload_0
    //   422: getfield 176	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   425: aload_1
    //   426: invokevirtual 266	com/tencent/biz/troop/TroopMemberApiClient:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   429: ldc 43
    //   431: ldc_w 268
    //   434: aload_0
    //   435: getfield 51	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_b_of_type_Int	I
    //   438: invokestatic 218	java/lang/System:currentTimeMillis	()J
    //   441: aload_0
    //   442: getfield 220	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_a_of_type_Long	J
    //   445: lsub
    //   446: l2i
    //   447: iconst_4
    //   448: anewarray 141	java/lang/String
    //   451: dup
    //   452: iconst_0
    //   453: aload_0
    //   454: getfield 55	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:d	Ljava/lang/String;
    //   457: aastore
    //   458: dup
    //   459: iconst_1
    //   460: aconst_null
    //   461: aastore
    //   462: dup
    //   463: iconst_2
    //   464: aload_0
    //   465: getfield 176	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   468: aastore
    //   469: dup
    //   470: iconst_3
    //   471: ldc_w 270
    //   474: aastore
    //   475: invokestatic 275	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   478: iconst_1
    //   479: ireturn
    //   480: ldc_w 277
    //   483: astore_1
    //   484: goto -425 -> 59
    //   487: astore_2
    //   488: aload_2
    //   489: invokevirtual 278	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   492: aconst_null
    //   493: astore_2
    //   494: goto -262 -> 232
    //   497: astore 4
    //   499: aconst_null
    //   500: astore_2
    //   501: aconst_null
    //   502: astore 5
    //   504: aload_1
    //   505: astore_3
    //   506: aload 5
    //   508: astore_1
    //   509: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   512: ifeq +15 -> 527
    //   515: ldc 115
    //   517: iconst_2
    //   518: aload 4
    //   520: iconst_0
    //   521: anewarray 280	java/lang/Object
    //   524: invokestatic 284	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   527: aload 4
    //   529: invokestatic 289	com/tencent/mobileqq/intervideo/huayang/HuayangCrashReport:a	(Ljava/lang/Throwable;)V
    //   532: goto -297 -> 235
    //   535: ldc_w 291
    //   538: aload 4
    //   540: invokevirtual 144	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   543: ifeq +86 -> 629
    //   546: aload_0
    //   547: getfield 261	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   550: aload_0
    //   551: getfield 176	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   554: invokevirtual 293	com/tencent/biz/troop/TroopMemberApiClient:b	(Ljava/lang/String;)V
    //   557: aload_0
    //   558: getfield 176	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   561: invokestatic 295	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:a	(Ljava/lang/String;)Z
    //   564: ifeq +67 -> 631
    //   567: ldc_w 297
    //   570: invokestatic 157	com/tencent/mobileqq/intervideo/huayang/Monitor:a	(Ljava/lang/String;)V
    //   573: aload_0
    //   574: invokespecial 299	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:a	()V
    //   577: ldc 43
    //   579: ldc_w 291
    //   582: aload_0
    //   583: getfield 51	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_b_of_type_Int	I
    //   586: invokestatic 218	java/lang/System:currentTimeMillis	()J
    //   589: aload_0
    //   590: getfield 220	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_a_of_type_Long	J
    //   593: lsub
    //   594: l2i
    //   595: iconst_4
    //   596: anewarray 141	java/lang/String
    //   599: dup
    //   600: iconst_0
    //   601: aload_0
    //   602: getfield 21	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_a_of_type_Int	I
    //   605: invokestatic 302	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   608: aastore
    //   609: dup
    //   610: iconst_1
    //   611: aconst_null
    //   612: aastore
    //   613: dup
    //   614: iconst_2
    //   615: aload_0
    //   616: getfield 176	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   619: aastore
    //   620: dup
    //   621: iconst_3
    //   622: ldc_w 270
    //   625: aastore
    //   626: invokestatic 275	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   629: iconst_0
    //   630: ireturn
    //   631: aload_0
    //   632: getfield 176	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   635: invokestatic 304	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:b	(Ljava/lang/String;)Z
    //   638: ifeq +12 -> 650
    //   641: ldc_w 306
    //   644: invokestatic 157	com/tencent/mobileqq/intervideo/huayang/Monitor:a	(Ljava/lang/String;)V
    //   647: goto -74 -> 573
    //   650: invokestatic 309	com/tencent/mobileqq/intervideo/huayang/MonitorConfig:a	()V
    //   653: getstatic 312	com/tencent/mobileqq/intervideo/huayang/MonitorConfig:a	Ljava/util/Map;
    //   656: aload_0
    //   657: getfield 182	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:c	Ljava/lang/String;
    //   660: invokeinterface 318 2 0
    //   665: ifnull -92 -> 573
    //   668: getstatic 312	com/tencent/mobileqq/intervideo/huayang/MonitorConfig:a	Ljava/util/Map;
    //   671: aload_0
    //   672: getfield 182	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:c	Ljava/lang/String;
    //   675: invokeinterface 318 2 0
    //   680: checkcast 308	com/tencent/mobileqq/intervideo/huayang/MonitorConfig
    //   683: getfield 321	com/tencent/mobileqq/intervideo/huayang/MonitorConfig:h	I
    //   686: invokestatic 302	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   689: invokestatic 322	com/tencent/mobileqq/intervideo/huayang/Monitor:b	(Ljava/lang/String;)V
    //   692: goto -119 -> 573
    //   695: astore 4
    //   697: aload_1
    //   698: astore_2
    //   699: aconst_null
    //   700: astore_1
    //   701: goto -192 -> 509
    //   704: astore 5
    //   706: aload_1
    //   707: astore_2
    //   708: aload 4
    //   710: astore_1
    //   711: aload 5
    //   713: astore 4
    //   715: goto -206 -> 509
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	718	0	this	HuayangJsPlugin
    //   0	718	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	718	2	paramString1	String
    //   0	718	3	paramString2	String
    //   0	718	4	paramString3	String
    //   0	718	5	paramVarArgs	String[]
    //   90	23	6	localObject1	java.lang.Object
    //   93	23	7	localObject2	java.lang.Object
    //   96	23	8	localObject3	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   225	232	487	java/io/UnsupportedEncodingException
    //   130	143	497	org/json/JSONException
    //   146	154	497	org/json/JSONException
    //   156	164	497	org/json/JSONException
    //   166	208	695	org/json/JSONException
    //   208	219	704	org/json/JSONException
    //   225	232	704	org/json/JSONException
    //   488	492	704	org/json/JSONException
  }
  
  protected void onCreate()
  {
    super.onCreate();
    MonitorConfig.a(this.mRuntime.a());
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    this.jdField_a_of_type_AndroidContentContext = this.mRuntime.a().getApplicationContext();
    a(" onCreate");
  }
  
  protected void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null)
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b(this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    }
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("HuayangJsPlugin", 2, " onDestroy");
    }
    Monitor.a("2597860");
    a();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangJsPlugin
 * JD-Core Version:    0.7.0.1
 */