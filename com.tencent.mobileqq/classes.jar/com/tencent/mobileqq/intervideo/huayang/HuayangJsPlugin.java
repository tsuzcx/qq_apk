package com.tencent.mobileqq.intervideo.huayang;

import aecm;
import aecn;
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
  private Handler jdField_a_of_type_AndroidOsHandler = new aecn(this, Looper.getMainLooper());
  public TroopMemberApiClient a;
  public String a;
  private int b;
  public String b;
  private String c;
  private String d;
  
  public HuayangJsPlugin()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aecm(this);
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
    //   45: ifnull +455 -> 500
    //   48: aload 5
    //   50: arraylength
    //   51: ifle +449 -> 500
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
    //   78: ifeq +477 -> 555
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
    //   109: ifnull +228 -> 337
    //   112: aload 6
    //   114: astore_3
    //   115: aload 7
    //   117: astore_2
    //   118: aload 8
    //   120: astore_1
    //   121: aload 5
    //   123: arraylength
    //   124: ifle +213 -> 337
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
    //   219: aload 5
    //   221: ldc 184
    //   223: invokevirtual 164	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   226: astore_2
    //   227: aload_0
    //   228: getfield 97	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   231: aload_0
    //   232: getfield 182	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:c	Ljava/lang/String;
    //   235: aload_2
    //   236: invokestatic 189	com/tencent/mobileqq/intervideo/huayang/MonitorConfig:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   239: aload_1
    //   240: astore_2
    //   241: aload_1
    //   242: ifnull +10 -> 252
    //   245: aload_1
    //   246: ldc 191
    //   248: invokestatic 197	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   251: astore_2
    //   252: aload 4
    //   254: astore_1
    //   255: aload_0
    //   256: getfield 176	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   259: invokestatic 201	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   262: ifeq +9 -> 271
    //   265: aload_0
    //   266: ldc 131
    //   268: putfield 176	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   271: new 203	android/content/IntentFilter
    //   274: dup
    //   275: aload_0
    //   276: getfield 176	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   279: invokestatic 205	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:a	(Ljava/lang/String;)Ljava/lang/String;
    //   282: invokespecial 206	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   285: astore 4
    //   287: aload 4
    //   289: aload_0
    //   290: getfield 176	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   293: invokestatic 208	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:b	(Ljava/lang/String;)Ljava/lang/String;
    //   296: invokevirtual 211	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   299: aload 4
    //   301: aload_0
    //   302: getfield 176	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   305: invokestatic 213	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:c	(Ljava/lang/String;)Ljava/lang/String;
    //   308: invokevirtual 211	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   311: aload 4
    //   313: aload_0
    //   314: getfield 176	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   317: invokestatic 215	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:d	(Ljava/lang/String;)Ljava/lang/String;
    //   320: invokevirtual 211	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   323: aload_0
    //   324: getfield 97	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   327: aload_0
    //   328: getfield 28	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   331: aload 4
    //   333: invokevirtual 219	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   336: pop
    //   337: aload_0
    //   338: invokestatic 225	java/lang/System:currentTimeMillis	()J
    //   341: putfield 227	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_a_of_type_Long	J
    //   344: aload_0
    //   345: getfield 55	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:d	Ljava/lang/String;
    //   348: ldc 229
    //   350: invokestatic 127	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   353: ifeq +74 -> 427
    //   356: aload_0
    //   357: getfield 176	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   360: ldc 121
    //   362: invokestatic 127	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   365: ifeq +62 -> 427
    //   368: aload_0
    //   369: getfield 97	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   372: invokestatic 235	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   375: invokeinterface 241 1 0
    //   380: astore 4
    //   382: aload 4
    //   384: new 58	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   391: ldc 243
    //   393: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: aload_0
    //   397: getfield 247	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   400: invokevirtual 252	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   403: invokevirtual 257	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   406: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: iconst_1
    //   413: invokeinterface 263 3 0
    //   418: pop
    //   419: aload 4
    //   421: invokeinterface 266 1 0
    //   426: pop
    //   427: aload_0
    //   428: getfield 268	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   431: aload_0
    //   432: getfield 182	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:c	Ljava/lang/String;
    //   435: aload_3
    //   436: aload_2
    //   437: aload_0
    //   438: getfield 55	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:d	Ljava/lang/String;
    //   441: aload_0
    //   442: getfield 176	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   445: aload_1
    //   446: invokevirtual 273	com/tencent/biz/troop/TroopMemberApiClient:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   449: ldc 43
    //   451: ldc_w 275
    //   454: aload_0
    //   455: getfield 51	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_b_of_type_Int	I
    //   458: invokestatic 225	java/lang/System:currentTimeMillis	()J
    //   461: aload_0
    //   462: getfield 227	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_a_of_type_Long	J
    //   465: lsub
    //   466: l2i
    //   467: iconst_4
    //   468: anewarray 141	java/lang/String
    //   471: dup
    //   472: iconst_0
    //   473: aload_0
    //   474: getfield 55	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:d	Ljava/lang/String;
    //   477: aastore
    //   478: dup
    //   479: iconst_1
    //   480: aconst_null
    //   481: aastore
    //   482: dup
    //   483: iconst_2
    //   484: aload_0
    //   485: getfield 176	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   488: aastore
    //   489: dup
    //   490: iconst_3
    //   491: ldc_w 277
    //   494: aastore
    //   495: invokestatic 282	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   498: iconst_1
    //   499: ireturn
    //   500: ldc_w 284
    //   503: astore_1
    //   504: goto -445 -> 59
    //   507: astore_2
    //   508: aload_2
    //   509: invokevirtual 285	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   512: aconst_null
    //   513: astore_2
    //   514: goto -262 -> 252
    //   517: astore 4
    //   519: aconst_null
    //   520: astore_2
    //   521: aconst_null
    //   522: astore 5
    //   524: aload_1
    //   525: astore_3
    //   526: aload 5
    //   528: astore_1
    //   529: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   532: ifeq +15 -> 547
    //   535: ldc 115
    //   537: iconst_2
    //   538: aload 4
    //   540: iconst_0
    //   541: anewarray 287	java/lang/Object
    //   544: invokestatic 291	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   547: aload 4
    //   549: invokestatic 296	com/tencent/mobileqq/intervideo/huayang/HuayangCrashReport:a	(Ljava/lang/Throwable;)V
    //   552: goto -297 -> 255
    //   555: ldc_w 298
    //   558: aload 4
    //   560: invokevirtual 144	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   563: ifeq +90 -> 653
    //   566: aload_0
    //   567: getfield 268	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   570: aload_0
    //   571: getfield 176	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   574: aload_0
    //   575: getfield 182	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:c	Ljava/lang/String;
    //   578: invokevirtual 301	com/tencent/biz/troop/TroopMemberApiClient:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   581: aload_0
    //   582: getfield 176	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   585: invokestatic 303	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:a	(Ljava/lang/String;)Z
    //   588: ifeq +67 -> 655
    //   591: ldc_w 305
    //   594: invokestatic 157	com/tencent/mobileqq/intervideo/huayang/Monitor:a	(Ljava/lang/String;)V
    //   597: aload_0
    //   598: invokespecial 307	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:a	()V
    //   601: ldc 43
    //   603: ldc_w 298
    //   606: aload_0
    //   607: getfield 51	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_b_of_type_Int	I
    //   610: invokestatic 225	java/lang/System:currentTimeMillis	()J
    //   613: aload_0
    //   614: getfield 227	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_a_of_type_Long	J
    //   617: lsub
    //   618: l2i
    //   619: iconst_4
    //   620: anewarray 141	java/lang/String
    //   623: dup
    //   624: iconst_0
    //   625: aload_0
    //   626: getfield 21	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_a_of_type_Int	I
    //   629: invokestatic 310	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   632: aastore
    //   633: dup
    //   634: iconst_1
    //   635: aconst_null
    //   636: aastore
    //   637: dup
    //   638: iconst_2
    //   639: aload_0
    //   640: getfield 176	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   643: aastore
    //   644: dup
    //   645: iconst_3
    //   646: ldc_w 277
    //   649: aastore
    //   650: invokestatic 282	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   653: iconst_0
    //   654: ireturn
    //   655: aload_0
    //   656: getfield 176	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   659: invokestatic 312	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:b	(Ljava/lang/String;)Z
    //   662: ifeq +12 -> 674
    //   665: ldc_w 314
    //   668: invokestatic 157	com/tencent/mobileqq/intervideo/huayang/Monitor:a	(Ljava/lang/String;)V
    //   671: goto -74 -> 597
    //   674: getstatic 317	com/tencent/mobileqq/intervideo/huayang/MonitorConfig:a	Ljava/util/Map;
    //   677: aload_0
    //   678: getfield 182	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:c	Ljava/lang/String;
    //   681: invokeinterface 323 2 0
    //   686: ifnull -89 -> 597
    //   689: getstatic 317	com/tencent/mobileqq/intervideo/huayang/MonitorConfig:a	Ljava/util/Map;
    //   692: aload_0
    //   693: getfield 182	com/tencent/mobileqq/intervideo/huayang/HuayangJsPlugin:c	Ljava/lang/String;
    //   696: invokeinterface 323 2 0
    //   701: checkcast 186	com/tencent/mobileqq/intervideo/huayang/MonitorConfig
    //   704: getfield 326	com/tencent/mobileqq/intervideo/huayang/MonitorConfig:h	I
    //   707: invokestatic 310	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   710: invokestatic 328	com/tencent/mobileqq/intervideo/huayang/Monitor:b	(Ljava/lang/String;)V
    //   713: goto -116 -> 597
    //   716: astore 4
    //   718: aload_1
    //   719: astore_2
    //   720: aconst_null
    //   721: astore_1
    //   722: goto -193 -> 529
    //   725: astore 5
    //   727: aload_1
    //   728: astore_2
    //   729: aload 4
    //   731: astore_1
    //   732: aload 5
    //   734: astore 4
    //   736: goto -207 -> 529
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	739	0	this	HuayangJsPlugin
    //   0	739	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	739	2	paramString1	String
    //   0	739	3	paramString2	String
    //   0	739	4	paramString3	String
    //   0	739	5	paramVarArgs	String[]
    //   90	23	6	localObject1	java.lang.Object
    //   93	23	7	localObject2	java.lang.Object
    //   96	23	8	localObject3	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   245	252	507	java/io/UnsupportedEncodingException
    //   130	143	517	org/json/JSONException
    //   146	154	517	org/json/JSONException
    //   156	164	517	org/json/JSONException
    //   166	208	716	org/json/JSONException
    //   208	239	725	org/json/JSONException
    //   245	252	725	org/json/JSONException
    //   508	512	725	org/json/JSONException
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    this.jdField_a_of_type_AndroidContentContext = this.mRuntime.a().getApplicationContext();
    a(" onCreate");
  }
  
  protected void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null)
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.c(this.jdField_b_of_type_JavaLangString, this.c);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangJsPlugin
 * JD-Core Version:    0.7.0.1
 */