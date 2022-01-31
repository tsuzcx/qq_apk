package com.tencent.mobileqq.vaswebviewplugin;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class SignJsPlugin
  extends VasWebviewJsPlugin
{
  private static final String LOCATION_SP_KEY = "sign_location_id_";
  public static final String NAME_SPACE = "sign";
  private static final String PARAM_ACTION_ID = "k_action_id";
  private static final String PARAM_ACTION_TEXT = "k_action_text";
  public static final String PARAM_DATA_ID = "k_data_id";
  public static final String PARAM_DATA_TEXT = "k_data_text";
  private static final byte REQUEST_ACTION = 101;
  private static final byte REQUEST_LOCATION = 100;
  private static final String TAG = "SignJsPlugin";
  private final String SIGNATURE_SYNC_IMG_TEMP_FILE = this.SIGNATURE_SYNC_IMG_TEMP_PATH + "temp.png";
  private final String SIGNATURE_SYNC_IMG_TEMP_PATH = AppConstants.bx + "temp/";
  private BrowserAppInterface browserApp;
  private boolean isSync;
  private String mActionCallback;
  private String mCachePoiId;
  private String mLocationCallback;
  private Bundle mReqBundle;
  
  public SignJsPlugin()
  {
    this.mPluginNameSpace = "sign";
  }
  
  /* Error */
  protected boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +20 -> 24
    //   7: ldc 11
    //   9: aload_3
    //   10: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13: ifeq +11 -> 24
    //   16: aload 4
    //   18: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifeq +5 -> 26
    //   24: iconst_0
    //   25: ireturn
    //   26: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +47 -> 76
    //   32: ldc 31
    //   34: iconst_2
    //   35: new 48	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   42: ldc 106
    //   44: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_2
    //   48: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: ldc 108
    //   53: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_3
    //   57: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: ldc 110
    //   62: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload 4
    //   67: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aconst_null
    //   77: astore 5
    //   79: aload_2
    //   80: invokestatic 120	com/tencent/mobileqq/webview/swift/WebViewPlugin:getJsonFromJSBridge	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   83: astore_1
    //   84: aload_1
    //   85: ifnonnull +5 -> 90
    //   88: iconst_1
    //   89: ireturn
    //   90: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   93: ifeq +31 -> 124
    //   96: ldc 31
    //   98: iconst_2
    //   99: new 48	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   106: ldc 122
    //   108: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_1
    //   112: invokevirtual 125	org/json/JSONObject:toString	()Ljava/lang/String;
    //   115: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   124: aload_1
    //   125: ldc 127
    //   127: invokevirtual 131	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   130: astore 16
    //   132: aload 16
    //   134: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   137: ifeq +13 -> 150
    //   140: ldc 31
    //   142: iconst_1
    //   143: ldc 133
    //   145: invokestatic 136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   148: iconst_1
    //   149: ireturn
    //   150: ldc 138
    //   152: aload 4
    //   154: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   157: ifeq +242 -> 399
    //   160: aload_1
    //   161: ldc 140
    //   163: invokevirtual 131	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   166: astore 5
    //   168: aload 5
    //   170: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   173: ifne +11 -> 184
    //   176: aload 5
    //   178: invokestatic 143	android/text/TextUtils:isDigitsOnly	(Ljava/lang/CharSequence;)Z
    //   181: ifne +20 -> 201
    //   184: aload_0
    //   185: aload 16
    //   187: iconst_1
    //   188: anewarray 94	java/lang/String
    //   191: dup
    //   192: iconst_0
    //   193: ldc 145
    //   195: aastore
    //   196: invokespecial 149	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   199: iconst_1
    //   200: ireturn
    //   201: aload 5
    //   203: invokestatic 155	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   206: istore 6
    //   208: aload_1
    //   209: ldc 157
    //   211: invokevirtual 131	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   214: astore 5
    //   216: aload_1
    //   217: ldc 159
    //   219: invokevirtual 131	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   222: astore 13
    //   224: aload_0
    //   225: getfield 161	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   228: invokevirtual 166	android/os/Bundle:clear	()V
    //   231: aload_0
    //   232: getfield 161	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   235: ldc 140
    //   237: iload 6
    //   239: invokevirtual 170	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   242: aload_0
    //   243: getfield 161	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   246: ldc 172
    //   248: aload 5
    //   250: invokevirtual 176	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   253: aload_0
    //   254: getfield 161	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   257: ldc 159
    //   259: aload 13
    //   261: invokevirtual 176	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   264: aload_1
    //   265: ldc 178
    //   267: invokevirtual 181	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   270: astore 5
    //   272: aload 5
    //   274: ifnull +67 -> 341
    //   277: aload_0
    //   278: getfield 161	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   281: ldc 183
    //   283: aload 5
    //   285: ldc 185
    //   287: invokevirtual 131	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   290: invokevirtual 176	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   293: aload_0
    //   294: getfield 161	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   297: ldc 187
    //   299: aload 5
    //   301: ldc 189
    //   303: invokevirtual 131	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   306: invokevirtual 176	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   309: aload_0
    //   310: getfield 161	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   313: ldc 191
    //   315: aload 5
    //   317: ldc 193
    //   319: invokevirtual 131	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   322: invokevirtual 176	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   325: aload_0
    //   326: getfield 161	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   329: ldc 195
    //   331: aload 5
    //   333: ldc 197
    //   335: invokevirtual 131	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   338: invokevirtual 176	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   341: aload_1
    //   342: ldc 199
    //   344: invokevirtual 203	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   347: astore_1
    //   348: aload_1
    //   349: ifnull +23 -> 372
    //   352: aload_1
    //   353: invokevirtual 209	org/json/JSONArray:length	()I
    //   356: ifle +16 -> 372
    //   359: aload_0
    //   360: getfield 161	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   363: ldc 211
    //   365: aload_1
    //   366: invokevirtual 212	org/json/JSONArray:toString	()Ljava/lang/String;
    //   369: invokevirtual 176	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   372: aload_0
    //   373: ldc 214
    //   375: aload 16
    //   377: aload_0
    //   378: getfield 218	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mOnRemoteResp	Lcom/tencent/mobileqq/emosm/Client$onRemoteRespObserver;
    //   381: getfield 224	com/tencent/mobileqq/emosm/Client$onRemoteRespObserver:key	I
    //   384: aload_0
    //   385: getfield 161	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   388: invokestatic 230	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   391: iconst_0
    //   392: iconst_1
    //   393: invokespecial 234	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:sendRemoteReq	(Landroid/os/Bundle;ZZ)V
    //   396: goto +1666 -> 2062
    //   399: ldc 236
    //   401: aload 4
    //   403: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   406: ifeq +277 -> 683
    //   409: invokestatic 241	cooperation/qzone/QZoneHelper$UserInfo:a	()Lcooperation/qzone/QZoneHelper$UserInfo;
    //   412: astore 13
    //   414: aload 13
    //   416: aload_0
    //   417: getfield 243	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:browserApp	Lcom/tencent/mobileqq/app/BrowserAppInterface;
    //   420: invokevirtual 248	com/tencent/mobileqq/app/BrowserAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   423: putfield 250	cooperation/qzone/QZoneHelper$UserInfo:a	Ljava/lang/String;
    //   426: aload 13
    //   428: aload_0
    //   429: getfield 243	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:browserApp	Lcom/tencent/mobileqq/app/BrowserAppInterface;
    //   432: invokevirtual 253	com/tencent/mobileqq/app/BrowserAppInterface:getCurrentNickname	()Ljava/lang/String;
    //   435: putfield 256	cooperation/qzone/QZoneHelper$UserInfo:b	Ljava/lang/String;
    //   438: aload_0
    //   439: aload 16
    //   441: putfield 258	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mLocationCallback	Ljava/lang/String;
    //   444: aload_0
    //   445: getfield 260	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mCachePoiId	Ljava/lang/String;
    //   448: astore 5
    //   450: aload 5
    //   452: astore_1
    //   453: aload 5
    //   455: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   458: ifeq +50 -> 508
    //   461: aload_0
    //   462: getfield 264	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   465: invokevirtual 269	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   468: invokevirtual 275	com/tencent/common/app/AppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   471: new 48	java/lang/StringBuilder
    //   474: dup
    //   475: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   478: ldc 8
    //   480: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: aload_0
    //   484: getfield 264	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   487: invokevirtual 269	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   490: invokevirtual 276	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   493: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   499: ldc_w 278
    //   502: invokeinterface 284 3 0
    //   507: astore_1
    //   508: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   511: ifeq +29 -> 540
    //   514: ldc 31
    //   516: iconst_2
    //   517: new 48	java/lang/StringBuilder
    //   520: dup
    //   521: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   524: ldc_w 286
    //   527: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: aload_1
    //   531: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   537: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   540: new 163	android/os/Bundle
    //   543: dup
    //   544: invokespecial 287	android/os/Bundle:<init>	()V
    //   547: astore 5
    //   549: aload_1
    //   550: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   553: ifne +21 -> 574
    //   556: aload 5
    //   558: ldc_w 289
    //   561: iconst_1
    //   562: invokevirtual 170	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   565: aload 5
    //   567: ldc_w 291
    //   570: aload_1
    //   571: invokevirtual 176	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   574: aload_0
    //   575: getfield 264	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   578: invokevirtual 294	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   581: aload 13
    //   583: ldc_w 295
    //   586: aload 5
    //   588: invokestatic 300	cooperation/qzone/QZoneHelper:a	(Landroid/app/Activity;Lcooperation/qzone/QZoneHelper$UserInfo;ILandroid/os/Bundle;)V
    //   591: goto +1471 -> 2062
    //   594: astore_1
    //   595: aload 16
    //   597: astore 5
    //   599: ldc 31
    //   601: iconst_2
    //   602: new 48	java/lang/StringBuilder
    //   605: dup
    //   606: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   609: ldc_w 302
    //   612: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: aload_2
    //   616: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: ldc 108
    //   621: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: aload_3
    //   625: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: ldc 110
    //   630: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: aload 4
    //   635: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: ldc_w 304
    //   641: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: aload_1
    //   645: invokevirtual 307	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   648: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   651: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   654: invokestatic 136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   657: aload 5
    //   659: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   662: ifne +1400 -> 2062
    //   665: aload_0
    //   666: aload 5
    //   668: iconst_1
    //   669: anewarray 94	java/lang/String
    //   672: dup
    //   673: iconst_0
    //   674: ldc 145
    //   676: aastore
    //   677: invokespecial 149	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   680: goto +1382 -> 2062
    //   683: ldc_w 309
    //   686: aload 4
    //   688: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   691: ifeq +37 -> 728
    //   694: new 311	android/content/Intent
    //   697: dup
    //   698: aload_0
    //   699: getfield 264	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   702: invokevirtual 294	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   705: ldc_w 313
    //   708: invokespecial 316	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   711: astore_1
    //   712: aload_0
    //   713: aload 16
    //   715: putfield 318	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mActionCallback	Ljava/lang/String;
    //   718: aload_0
    //   719: aload_1
    //   720: bipush 101
    //   722: invokespecial 322	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   725: goto +1337 -> 2062
    //   728: ldc_w 324
    //   731: aload 4
    //   733: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   736: ifeq +126 -> 862
    //   739: aload_1
    //   740: ldc_w 326
    //   743: invokevirtual 131	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   746: astore 5
    //   748: aload_1
    //   749: ldc_w 328
    //   752: invokevirtual 131	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   755: astore 13
    //   757: aload 5
    //   759: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   762: ifeq +20 -> 782
    //   765: aload_0
    //   766: aload 16
    //   768: iconst_1
    //   769: anewarray 94	java/lang/String
    //   772: dup
    //   773: iconst_0
    //   774: ldc 145
    //   776: aastore
    //   777: invokespecial 149	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   780: iconst_1
    //   781: ireturn
    //   782: aload_1
    //   783: ldc_w 330
    //   786: invokevirtual 333	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   789: istore 6
    //   791: aload_0
    //   792: getfield 161	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   795: invokevirtual 166	android/os/Bundle:clear	()V
    //   798: aload_0
    //   799: getfield 161	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   802: ldc_w 326
    //   805: aload 5
    //   807: invokevirtual 176	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   810: aload_0
    //   811: getfield 161	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   814: ldc_w 328
    //   817: aload 13
    //   819: invokevirtual 176	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   822: aload_0
    //   823: getfield 161	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   826: ldc_w 330
    //   829: iload 6
    //   831: invokevirtual 170	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   834: aload_0
    //   835: ldc_w 335
    //   838: aload 16
    //   840: aload_0
    //   841: getfield 218	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mOnRemoteResp	Lcom/tencent/mobileqq/emosm/Client$onRemoteRespObserver;
    //   844: getfield 224	com/tencent/mobileqq/emosm/Client$onRemoteRespObserver:key	I
    //   847: aload_0
    //   848: getfield 161	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   851: invokestatic 230	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   854: iconst_0
    //   855: iconst_1
    //   856: invokespecial 234	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:sendRemoteReq	(Landroid/os/Bundle;ZZ)V
    //   859: goto +1203 -> 2062
    //   862: ldc_w 337
    //   865: aload 4
    //   867: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   870: ifeq +1037 -> 1907
    //   873: aload_1
    //   874: ldc_w 339
    //   877: invokevirtual 131	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   880: astore 5
    //   882: aload_1
    //   883: ldc 172
    //   885: invokevirtual 131	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   888: astore 19
    //   890: aload_0
    //   891: getfield 341	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:isSync	Z
    //   894: ifeq +1168 -> 2062
    //   897: aload 5
    //   899: ifnull +16 -> 915
    //   902: aload 5
    //   904: ifnull +71 -> 975
    //   907: aload 5
    //   909: invokevirtual 343	java/lang/String:isEmpty	()Z
    //   912: ifeq +63 -> 975
    //   915: aload 19
    //   917: ifnull +1145 -> 2062
    //   920: aload 19
    //   922: invokevirtual 343	java/lang/String:isEmpty	()Z
    //   925: ifne +1137 -> 2062
    //   928: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   931: ifeq +31 -> 962
    //   934: ldc_w 345
    //   937: iconst_4
    //   938: new 48	java/lang/StringBuilder
    //   941: dup
    //   942: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   945: ldc_w 347
    //   948: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   951: aload 19
    //   953: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   956: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   959: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   962: aload 19
    //   964: aconst_null
    //   965: ldc_w 349
    //   968: iconst_3
    //   969: invokestatic 352	cooperation/qzone/QZoneHelper:a	(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;I)V
    //   972: goto +1090 -> 2062
    //   975: iconst_0
    //   976: istore 9
    //   978: iconst_0
    //   979: istore 10
    //   981: iconst_0
    //   982: istore 11
    //   984: iconst_0
    //   985: istore 8
    //   987: iload 11
    //   989: istore 6
    //   991: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   994: ifeq +16 -> 1010
    //   997: iload 11
    //   999: istore 6
    //   1001: ldc_w 345
    //   1004: iconst_4
    //   1005: aload 5
    //   1007: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1010: iload 11
    //   1012: istore 6
    //   1014: aload 5
    //   1016: iconst_2
    //   1017: invokestatic 358	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   1020: astore 20
    //   1022: aconst_null
    //   1023: astore_1
    //   1024: aconst_null
    //   1025: astore 17
    //   1027: aconst_null
    //   1028: astore 18
    //   1030: aconst_null
    //   1031: astore 14
    //   1033: aconst_null
    //   1034: astore 15
    //   1036: aload 18
    //   1038: astore 5
    //   1040: aload_1
    //   1041: astore 13
    //   1043: new 360	java/io/File
    //   1046: dup
    //   1047: aload_0
    //   1048: getfield 66	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:SIGNATURE_SYNC_IMG_TEMP_PATH	Ljava/lang/String;
    //   1051: invokespecial 363	java/io/File:<init>	(Ljava/lang/String;)V
    //   1054: astore 21
    //   1056: aload 18
    //   1058: astore 5
    //   1060: aload_1
    //   1061: astore 13
    //   1063: aload 21
    //   1065: invokevirtual 366	java/io/File:exists	()Z
    //   1068: ifne +71 -> 1139
    //   1071: aload 18
    //   1073: astore 5
    //   1075: aload_1
    //   1076: astore 13
    //   1078: aload 21
    //   1080: invokevirtual 369	java/io/File:mkdirs	()Z
    //   1083: istore 12
    //   1085: aload 18
    //   1087: astore 5
    //   1089: aload_1
    //   1090: astore 13
    //   1092: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1095: ifeq +44 -> 1139
    //   1098: aload 18
    //   1100: astore 5
    //   1102: aload_1
    //   1103: astore 13
    //   1105: ldc_w 345
    //   1108: iconst_2
    //   1109: new 48	java/lang/StringBuilder
    //   1112: dup
    //   1113: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   1116: ldc_w 371
    //   1119: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1122: iload 12
    //   1124: invokevirtual 374	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1127: ldc_w 376
    //   1130: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1133: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1136: invokestatic 379	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1139: aload 18
    //   1141: astore 5
    //   1143: aload_1
    //   1144: astore 13
    //   1146: new 381	java/io/FileOutputStream
    //   1149: dup
    //   1150: aload_0
    //   1151: getfield 70	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:SIGNATURE_SYNC_IMG_TEMP_FILE	Ljava/lang/String;
    //   1154: invokespecial 382	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   1157: astore_1
    //   1158: new 384	java/io/BufferedOutputStream
    //   1161: dup
    //   1162: aload_1
    //   1163: invokespecial 387	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   1166: astore 5
    //   1168: aload 5
    //   1170: aload 20
    //   1172: invokevirtual 391	java/io/BufferedOutputStream:write	([B)V
    //   1175: aload 5
    //   1177: invokevirtual 394	java/io/BufferedOutputStream:flush	()V
    //   1180: aload 5
    //   1182: ifnull +12 -> 1194
    //   1185: iload 11
    //   1187: istore 6
    //   1189: aload 5
    //   1191: invokevirtual 397	java/io/BufferedOutputStream:close	()V
    //   1194: aload_1
    //   1195: ifnull +11 -> 1206
    //   1198: iload 11
    //   1200: istore 6
    //   1202: aload_1
    //   1203: invokevirtual 398	java/io/FileOutputStream:close	()V
    //   1206: iload 11
    //   1208: istore 6
    //   1210: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1213: ifeq +17 -> 1230
    //   1216: iload 11
    //   1218: istore 6
    //   1220: ldc_w 345
    //   1223: iconst_2
    //   1224: ldc_w 400
    //   1227: invokestatic 379	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1230: iload 11
    //   1232: istore 6
    //   1234: aload_0
    //   1235: getfield 70	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:SIGNATURE_SYNC_IMG_TEMP_FILE	Ljava/lang/String;
    //   1238: invokestatic 405	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   1241: ifeq +592 -> 1833
    //   1244: iload 11
    //   1246: istore 6
    //   1248: aload_0
    //   1249: getfield 70	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:SIGNATURE_SYNC_IMG_TEMP_FILE	Ljava/lang/String;
    //   1252: invokestatic 407	com/tencent/mobileqq/utils/FileUtils:e	(Ljava/lang/String;)Z
    //   1255: ifeq +578 -> 1833
    //   1258: iload 11
    //   1260: istore 6
    //   1262: new 409	java/util/ArrayList
    //   1265: dup
    //   1266: invokespecial 410	java/util/ArrayList:<init>	()V
    //   1269: astore_1
    //   1270: iload 11
    //   1272: istore 6
    //   1274: aload_1
    //   1275: aload_0
    //   1276: getfield 70	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:SIGNATURE_SYNC_IMG_TEMP_FILE	Ljava/lang/String;
    //   1279: invokevirtual 413	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1282: pop
    //   1283: iload 11
    //   1285: istore 6
    //   1287: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1290: ifeq +41 -> 1331
    //   1293: iload 11
    //   1295: istore 6
    //   1297: ldc_w 345
    //   1300: iconst_2
    //   1301: new 48	java/lang/StringBuilder
    //   1304: dup
    //   1305: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   1308: ldc_w 415
    //   1311: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1314: aload_1
    //   1315: iconst_0
    //   1316: invokevirtual 419	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1319: checkcast 94	java/lang/String
    //   1322: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1325: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1328: invokestatic 379	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1331: iconst_1
    //   1332: istore 6
    //   1334: iconst_1
    //   1335: istore 7
    //   1337: ldc_w 421
    //   1340: aload_1
    //   1341: ldc_w 349
    //   1344: iconst_3
    //   1345: invokestatic 352	cooperation/qzone/QZoneHelper:a	(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;I)V
    //   1348: iconst_1
    //   1349: istore 7
    //   1351: iload 7
    //   1353: ifne +709 -> 2062
    //   1356: aload 19
    //   1358: ifnull +704 -> 2062
    //   1361: aload 19
    //   1363: invokevirtual 343	java/lang/String:isEmpty	()Z
    //   1366: ifne +696 -> 2062
    //   1369: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1372: ifeq +13 -> 1385
    //   1375: ldc_w 345
    //   1378: iconst_4
    //   1379: ldc_w 423
    //   1382: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1385: aload 19
    //   1387: aconst_null
    //   1388: ldc_w 349
    //   1391: iconst_3
    //   1392: invokestatic 352	cooperation/qzone/QZoneHelper:a	(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;I)V
    //   1395: goto +667 -> 2062
    //   1398: astore_1
    //   1399: iload 11
    //   1401: istore 6
    //   1403: aload_1
    //   1404: invokevirtual 426	java/io/IOException:printStackTrace	()V
    //   1407: goto -177 -> 1230
    //   1410: astore_1
    //   1411: iconst_0
    //   1412: istore 7
    //   1414: iload 7
    //   1416: istore 6
    //   1418: ldc_w 345
    //   1421: iconst_2
    //   1422: ldc_w 428
    //   1425: invokestatic 136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1428: iload 7
    //   1430: istore 6
    //   1432: aload_1
    //   1433: invokevirtual 429	java/lang/IllegalArgumentException:printStackTrace	()V
    //   1436: iload 7
    //   1438: ifne +624 -> 2062
    //   1441: aload 19
    //   1443: ifnull +619 -> 2062
    //   1446: aload 19
    //   1448: invokevirtual 343	java/lang/String:isEmpty	()Z
    //   1451: ifne +611 -> 2062
    //   1454: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1457: ifeq +13 -> 1470
    //   1460: ldc_w 345
    //   1463: iconst_4
    //   1464: ldc_w 423
    //   1467: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1470: aload 19
    //   1472: aconst_null
    //   1473: ldc_w 349
    //   1476: iconst_3
    //   1477: invokestatic 352	cooperation/qzone/QZoneHelper:a	(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;I)V
    //   1480: goto +582 -> 2062
    //   1483: astore 14
    //   1485: aload 17
    //   1487: astore_1
    //   1488: aload 15
    //   1490: astore 5
    //   1492: aload_1
    //   1493: astore 13
    //   1495: aload 14
    //   1497: invokevirtual 426	java/io/IOException:printStackTrace	()V
    //   1500: aload 15
    //   1502: ifnull +12 -> 1514
    //   1505: iload 11
    //   1507: istore 6
    //   1509: aload 15
    //   1511: invokevirtual 397	java/io/BufferedOutputStream:close	()V
    //   1514: aload_1
    //   1515: ifnull +11 -> 1526
    //   1518: iload 11
    //   1520: istore 6
    //   1522: aload_1
    //   1523: invokevirtual 398	java/io/FileOutputStream:close	()V
    //   1526: iload 11
    //   1528: istore 6
    //   1530: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1533: ifeq -303 -> 1230
    //   1536: iload 11
    //   1538: istore 6
    //   1540: ldc_w 345
    //   1543: iconst_2
    //   1544: ldc_w 400
    //   1547: invokestatic 379	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1550: goto -320 -> 1230
    //   1553: astore_1
    //   1554: iload 11
    //   1556: istore 6
    //   1558: aload_1
    //   1559: invokevirtual 426	java/io/IOException:printStackTrace	()V
    //   1562: goto -332 -> 1230
    //   1565: astore_1
    //   1566: iload 9
    //   1568: istore 7
    //   1570: iload 7
    //   1572: istore 6
    //   1574: ldc_w 345
    //   1577: iconst_2
    //   1578: ldc_w 431
    //   1581: invokestatic 136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1584: iload 7
    //   1586: istore 6
    //   1588: aload_1
    //   1589: invokevirtual 432	java/lang/Exception:printStackTrace	()V
    //   1592: iload 7
    //   1594: ifne +468 -> 2062
    //   1597: aload 19
    //   1599: ifnull +463 -> 2062
    //   1602: aload 19
    //   1604: invokevirtual 343	java/lang/String:isEmpty	()Z
    //   1607: ifne +455 -> 2062
    //   1610: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1613: ifeq +13 -> 1626
    //   1616: ldc_w 345
    //   1619: iconst_4
    //   1620: ldc_w 423
    //   1623: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1626: aload 19
    //   1628: aconst_null
    //   1629: ldc_w 349
    //   1632: iconst_3
    //   1633: invokestatic 352	cooperation/qzone/QZoneHelper:a	(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;I)V
    //   1636: goto +426 -> 2062
    //   1639: astore_1
    //   1640: aload 5
    //   1642: ifnull +12 -> 1654
    //   1645: iload 11
    //   1647: istore 6
    //   1649: aload 5
    //   1651: invokevirtual 397	java/io/BufferedOutputStream:close	()V
    //   1654: aload 13
    //   1656: ifnull +12 -> 1668
    //   1659: iload 11
    //   1661: istore 6
    //   1663: aload 13
    //   1665: invokevirtual 398	java/io/FileOutputStream:close	()V
    //   1668: iload 11
    //   1670: istore 6
    //   1672: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1675: ifeq +17 -> 1692
    //   1678: iload 11
    //   1680: istore 6
    //   1682: ldc_w 345
    //   1685: iconst_2
    //   1686: ldc_w 400
    //   1689: invokestatic 379	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1692: iload 11
    //   1694: istore 6
    //   1696: aload_1
    //   1697: athrow
    //   1698: astore_1
    //   1699: iload 10
    //   1701: istore 7
    //   1703: iload 7
    //   1705: istore 6
    //   1707: ldc_w 345
    //   1710: iconst_2
    //   1711: ldc_w 434
    //   1714: invokestatic 136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1717: iload 7
    //   1719: istore 6
    //   1721: aload_1
    //   1722: invokevirtual 435	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1725: iload 7
    //   1727: ifne +335 -> 2062
    //   1730: aload 19
    //   1732: ifnull +330 -> 2062
    //   1735: aload 19
    //   1737: invokevirtual 343	java/lang/String:isEmpty	()Z
    //   1740: ifne +322 -> 2062
    //   1743: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1746: ifeq +13 -> 1759
    //   1749: ldc_w 345
    //   1752: iconst_4
    //   1753: ldc_w 423
    //   1756: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1759: aload 19
    //   1761: aconst_null
    //   1762: ldc_w 349
    //   1765: iconst_3
    //   1766: invokestatic 352	cooperation/qzone/QZoneHelper:a	(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;I)V
    //   1769: goto +293 -> 2062
    //   1772: astore 5
    //   1774: iload 11
    //   1776: istore 6
    //   1778: aload 5
    //   1780: invokevirtual 426	java/io/IOException:printStackTrace	()V
    //   1783: goto -91 -> 1692
    //   1786: astore_1
    //   1787: iload 6
    //   1789: ifne +42 -> 1831
    //   1792: aload 19
    //   1794: ifnull +37 -> 1831
    //   1797: aload 19
    //   1799: invokevirtual 343	java/lang/String:isEmpty	()Z
    //   1802: ifne +29 -> 1831
    //   1805: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1808: ifeq +13 -> 1821
    //   1811: ldc_w 345
    //   1814: iconst_4
    //   1815: ldc_w 423
    //   1818: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1821: aload 19
    //   1823: aconst_null
    //   1824: ldc_w 349
    //   1827: iconst_3
    //   1828: invokestatic 352	cooperation/qzone/QZoneHelper:a	(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;I)V
    //   1831: aload_1
    //   1832: athrow
    //   1833: iload 8
    //   1835: istore 7
    //   1837: iload 11
    //   1839: istore 6
    //   1841: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1844: ifeq -493 -> 1351
    //   1847: iload 11
    //   1849: istore 6
    //   1851: ldc_w 345
    //   1854: iconst_2
    //   1855: new 48	java/lang/StringBuilder
    //   1858: dup
    //   1859: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   1862: ldc_w 437
    //   1865: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1868: aload_0
    //   1869: getfield 70	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:SIGNATURE_SYNC_IMG_TEMP_FILE	Ljava/lang/String;
    //   1872: invokestatic 405	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   1875: invokevirtual 374	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1878: ldc_w 439
    //   1881: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1884: aload_0
    //   1885: getfield 70	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:SIGNATURE_SYNC_IMG_TEMP_FILE	Ljava/lang/String;
    //   1888: invokestatic 407	com/tencent/mobileqq/utils/FileUtils:e	(Ljava/lang/String;)Z
    //   1891: invokevirtual 374	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1894: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1897: invokestatic 379	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1900: iload 8
    //   1902: istore 7
    //   1904: goto -553 -> 1351
    //   1907: ldc_w 441
    //   1910: aload 4
    //   1912: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1915: ifeq +31 -> 1946
    //   1918: aload_0
    //   1919: ldc_w 443
    //   1922: aload 16
    //   1924: aload_0
    //   1925: getfield 218	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mOnRemoteResp	Lcom/tencent/mobileqq/emosm/Client$onRemoteRespObserver;
    //   1928: getfield 224	com/tencent/mobileqq/emosm/Client$onRemoteRespObserver:key	I
    //   1931: aload_0
    //   1932: getfield 161	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   1935: invokestatic 230	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   1938: iconst_0
    //   1939: iconst_1
    //   1940: invokespecial 234	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:sendRemoteReq	(Landroid/os/Bundle;ZZ)V
    //   1943: goto +119 -> 2062
    //   1946: ldc_w 445
    //   1949: aload 4
    //   1951: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1954: ifeq +108 -> 2062
    //   1957: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1960: ifeq +12 -> 1972
    //   1963: ldc 31
    //   1965: iconst_2
    //   1966: ldc_w 445
    //   1969: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1972: aload_0
    //   1973: aconst_null
    //   1974: putfield 260	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mCachePoiId	Ljava/lang/String;
    //   1977: aload_0
    //   1978: aload 16
    //   1980: iconst_1
    //   1981: anewarray 94	java/lang/String
    //   1984: dup
    //   1985: iconst_0
    //   1986: ldc_w 447
    //   1989: aastore
    //   1990: invokespecial 149	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1993: goto +69 -> 2062
    //   1996: astore_1
    //   1997: goto -1398 -> 599
    //   2000: astore_1
    //   2001: goto -214 -> 1787
    //   2004: astore_1
    //   2005: iconst_1
    //   2006: istore 7
    //   2008: goto -305 -> 1703
    //   2011: astore_1
    //   2012: iconst_1
    //   2013: istore 7
    //   2015: goto -445 -> 1570
    //   2018: astore_1
    //   2019: goto -605 -> 1414
    //   2022: astore 5
    //   2024: aload_1
    //   2025: astore 13
    //   2027: aload 5
    //   2029: astore_1
    //   2030: aload 14
    //   2032: astore 5
    //   2034: goto -394 -> 1640
    //   2037: astore 14
    //   2039: aload_1
    //   2040: astore 13
    //   2042: aload 14
    //   2044: astore_1
    //   2045: goto -405 -> 1640
    //   2048: astore 14
    //   2050: goto -562 -> 1488
    //   2053: astore 14
    //   2055: aload 5
    //   2057: astore 15
    //   2059: goto -571 -> 1488
    //   2062: iconst_1
    //   2063: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2064	0	this	SignJsPlugin
    //   0	2064	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	2064	2	paramString1	String
    //   0	2064	3	paramString2	String
    //   0	2064	4	paramString3	String
    //   0	2064	5	paramVarArgs	String[]
    //   206	1644	6	i	int
    //   1335	679	7	j	int
    //   985	916	8	k	int
    //   976	591	9	m	int
    //   979	721	10	n	int
    //   982	866	11	i1	int
    //   1083	40	12	bool	boolean
    //   222	1819	13	localObject1	Object
    //   1031	1	14	localObject2	Object
    //   1483	548	14	localIOException1	java.io.IOException
    //   2037	6	14	localObject3	Object
    //   2048	1	14	localIOException2	java.io.IOException
    //   2053	1	14	localIOException3	java.io.IOException
    //   1034	1024	15	arrayOfString	String[]
    //   130	1849	16	str1	String
    //   1025	461	17	localObject4	Object
    //   1028	112	18	localObject5	Object
    //   888	934	19	str2	String
    //   1020	151	20	arrayOfByte	byte[]
    //   1054	25	21	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   132	148	594	java/lang/Throwable
    //   150	184	594	java/lang/Throwable
    //   184	199	594	java/lang/Throwable
    //   201	272	594	java/lang/Throwable
    //   277	341	594	java/lang/Throwable
    //   341	348	594	java/lang/Throwable
    //   352	372	594	java/lang/Throwable
    //   372	396	594	java/lang/Throwable
    //   399	450	594	java/lang/Throwable
    //   453	508	594	java/lang/Throwable
    //   508	540	594	java/lang/Throwable
    //   540	574	594	java/lang/Throwable
    //   574	591	594	java/lang/Throwable
    //   683	725	594	java/lang/Throwable
    //   728	780	594	java/lang/Throwable
    //   782	859	594	java/lang/Throwable
    //   862	897	594	java/lang/Throwable
    //   907	915	594	java/lang/Throwable
    //   920	962	594	java/lang/Throwable
    //   962	972	594	java/lang/Throwable
    //   1361	1385	594	java/lang/Throwable
    //   1385	1395	594	java/lang/Throwable
    //   1446	1470	594	java/lang/Throwable
    //   1470	1480	594	java/lang/Throwable
    //   1602	1626	594	java/lang/Throwable
    //   1626	1636	594	java/lang/Throwable
    //   1735	1759	594	java/lang/Throwable
    //   1759	1769	594	java/lang/Throwable
    //   1797	1821	594	java/lang/Throwable
    //   1821	1831	594	java/lang/Throwable
    //   1831	1833	594	java/lang/Throwable
    //   1907	1943	594	java/lang/Throwable
    //   1946	1972	594	java/lang/Throwable
    //   1972	1993	594	java/lang/Throwable
    //   1189	1194	1398	java/io/IOException
    //   1202	1206	1398	java/io/IOException
    //   1210	1216	1398	java/io/IOException
    //   1220	1230	1398	java/io/IOException
    //   991	997	1410	java/lang/IllegalArgumentException
    //   1001	1010	1410	java/lang/IllegalArgumentException
    //   1014	1022	1410	java/lang/IllegalArgumentException
    //   1189	1194	1410	java/lang/IllegalArgumentException
    //   1202	1206	1410	java/lang/IllegalArgumentException
    //   1210	1216	1410	java/lang/IllegalArgumentException
    //   1220	1230	1410	java/lang/IllegalArgumentException
    //   1234	1244	1410	java/lang/IllegalArgumentException
    //   1248	1258	1410	java/lang/IllegalArgumentException
    //   1262	1270	1410	java/lang/IllegalArgumentException
    //   1274	1283	1410	java/lang/IllegalArgumentException
    //   1287	1293	1410	java/lang/IllegalArgumentException
    //   1297	1331	1410	java/lang/IllegalArgumentException
    //   1403	1407	1410	java/lang/IllegalArgumentException
    //   1509	1514	1410	java/lang/IllegalArgumentException
    //   1522	1526	1410	java/lang/IllegalArgumentException
    //   1530	1536	1410	java/lang/IllegalArgumentException
    //   1540	1550	1410	java/lang/IllegalArgumentException
    //   1558	1562	1410	java/lang/IllegalArgumentException
    //   1649	1654	1410	java/lang/IllegalArgumentException
    //   1663	1668	1410	java/lang/IllegalArgumentException
    //   1672	1678	1410	java/lang/IllegalArgumentException
    //   1682	1692	1410	java/lang/IllegalArgumentException
    //   1696	1698	1410	java/lang/IllegalArgumentException
    //   1778	1783	1410	java/lang/IllegalArgumentException
    //   1841	1847	1410	java/lang/IllegalArgumentException
    //   1851	1900	1410	java/lang/IllegalArgumentException
    //   1043	1056	1483	java/io/IOException
    //   1063	1071	1483	java/io/IOException
    //   1078	1085	1483	java/io/IOException
    //   1092	1098	1483	java/io/IOException
    //   1105	1139	1483	java/io/IOException
    //   1146	1158	1483	java/io/IOException
    //   1509	1514	1553	java/io/IOException
    //   1522	1526	1553	java/io/IOException
    //   1530	1536	1553	java/io/IOException
    //   1540	1550	1553	java/io/IOException
    //   991	997	1565	java/lang/Exception
    //   1001	1010	1565	java/lang/Exception
    //   1014	1022	1565	java/lang/Exception
    //   1189	1194	1565	java/lang/Exception
    //   1202	1206	1565	java/lang/Exception
    //   1210	1216	1565	java/lang/Exception
    //   1220	1230	1565	java/lang/Exception
    //   1234	1244	1565	java/lang/Exception
    //   1248	1258	1565	java/lang/Exception
    //   1262	1270	1565	java/lang/Exception
    //   1274	1283	1565	java/lang/Exception
    //   1287	1293	1565	java/lang/Exception
    //   1297	1331	1565	java/lang/Exception
    //   1403	1407	1565	java/lang/Exception
    //   1509	1514	1565	java/lang/Exception
    //   1522	1526	1565	java/lang/Exception
    //   1530	1536	1565	java/lang/Exception
    //   1540	1550	1565	java/lang/Exception
    //   1558	1562	1565	java/lang/Exception
    //   1649	1654	1565	java/lang/Exception
    //   1663	1668	1565	java/lang/Exception
    //   1672	1678	1565	java/lang/Exception
    //   1682	1692	1565	java/lang/Exception
    //   1696	1698	1565	java/lang/Exception
    //   1778	1783	1565	java/lang/Exception
    //   1841	1847	1565	java/lang/Exception
    //   1851	1900	1565	java/lang/Exception
    //   1043	1056	1639	finally
    //   1063	1071	1639	finally
    //   1078	1085	1639	finally
    //   1092	1098	1639	finally
    //   1105	1139	1639	finally
    //   1146	1158	1639	finally
    //   1495	1500	1639	finally
    //   991	997	1698	java/lang/OutOfMemoryError
    //   1001	1010	1698	java/lang/OutOfMemoryError
    //   1014	1022	1698	java/lang/OutOfMemoryError
    //   1189	1194	1698	java/lang/OutOfMemoryError
    //   1202	1206	1698	java/lang/OutOfMemoryError
    //   1210	1216	1698	java/lang/OutOfMemoryError
    //   1220	1230	1698	java/lang/OutOfMemoryError
    //   1234	1244	1698	java/lang/OutOfMemoryError
    //   1248	1258	1698	java/lang/OutOfMemoryError
    //   1262	1270	1698	java/lang/OutOfMemoryError
    //   1274	1283	1698	java/lang/OutOfMemoryError
    //   1287	1293	1698	java/lang/OutOfMemoryError
    //   1297	1331	1698	java/lang/OutOfMemoryError
    //   1403	1407	1698	java/lang/OutOfMemoryError
    //   1509	1514	1698	java/lang/OutOfMemoryError
    //   1522	1526	1698	java/lang/OutOfMemoryError
    //   1530	1536	1698	java/lang/OutOfMemoryError
    //   1540	1550	1698	java/lang/OutOfMemoryError
    //   1558	1562	1698	java/lang/OutOfMemoryError
    //   1649	1654	1698	java/lang/OutOfMemoryError
    //   1663	1668	1698	java/lang/OutOfMemoryError
    //   1672	1678	1698	java/lang/OutOfMemoryError
    //   1682	1692	1698	java/lang/OutOfMemoryError
    //   1696	1698	1698	java/lang/OutOfMemoryError
    //   1778	1783	1698	java/lang/OutOfMemoryError
    //   1841	1847	1698	java/lang/OutOfMemoryError
    //   1851	1900	1698	java/lang/OutOfMemoryError
    //   1649	1654	1772	java/io/IOException
    //   1663	1668	1772	java/io/IOException
    //   1672	1678	1772	java/io/IOException
    //   1682	1692	1772	java/io/IOException
    //   991	997	1786	finally
    //   1001	1010	1786	finally
    //   1014	1022	1786	finally
    //   1189	1194	1786	finally
    //   1202	1206	1786	finally
    //   1210	1216	1786	finally
    //   1220	1230	1786	finally
    //   1234	1244	1786	finally
    //   1248	1258	1786	finally
    //   1262	1270	1786	finally
    //   1274	1283	1786	finally
    //   1287	1293	1786	finally
    //   1297	1331	1786	finally
    //   1403	1407	1786	finally
    //   1509	1514	1786	finally
    //   1522	1526	1786	finally
    //   1530	1536	1786	finally
    //   1540	1550	1786	finally
    //   1558	1562	1786	finally
    //   1574	1584	1786	finally
    //   1588	1592	1786	finally
    //   1649	1654	1786	finally
    //   1663	1668	1786	finally
    //   1672	1678	1786	finally
    //   1682	1692	1786	finally
    //   1696	1698	1786	finally
    //   1707	1717	1786	finally
    //   1721	1725	1786	finally
    //   1778	1783	1786	finally
    //   1841	1847	1786	finally
    //   1851	1900	1786	finally
    //   79	84	1996	java/lang/Throwable
    //   90	124	1996	java/lang/Throwable
    //   124	132	1996	java/lang/Throwable
    //   1337	1348	2000	finally
    //   1418	1428	2000	finally
    //   1432	1436	2000	finally
    //   1337	1348	2004	java/lang/OutOfMemoryError
    //   1337	1348	2011	java/lang/Exception
    //   1337	1348	2018	java/lang/IllegalArgumentException
    //   1158	1168	2022	finally
    //   1168	1180	2037	finally
    //   1158	1168	2048	java/io/IOException
    //   1168	1180	2053	java/io/IOException
  }
  
  /* Error */
  public void onActivityResult(android.content.Intent paramIntent, byte paramByte, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: iload_2
    //   3: iload_3
    //   4: invokespecial 453	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:onActivityResult	(Landroid/content/Intent;BI)V
    //   7: aconst_null
    //   8: astore 9
    //   10: aload_1
    //   11: ifnonnull +13 -> 24
    //   14: ldc 31
    //   16: iconst_1
    //   17: ldc_w 455
    //   20: invokestatic 136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: return
    //   24: aload 9
    //   26: astore 8
    //   28: aload_1
    //   29: invokevirtual 459	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   32: ifnonnull +51 -> 83
    //   35: aload 9
    //   37: astore 8
    //   39: ldc 31
    //   41: iconst_1
    //   42: ldc_w 461
    //   45: invokestatic 136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: return
    //   49: astore_1
    //   50: ldc 31
    //   52: iconst_1
    //   53: ldc_w 463
    //   56: invokestatic 136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: aload 8
    //   61: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   64: ifne -41 -> 23
    //   67: aload_0
    //   68: aload 8
    //   70: iconst_1
    //   71: anewarray 94	java/lang/String
    //   74: dup
    //   75: iconst_0
    //   76: ldc 145
    //   78: aastore
    //   79: invokevirtual 464	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   82: return
    //   83: aload 9
    //   85: astore 8
    //   87: new 124	org/json/JSONObject
    //   90: dup
    //   91: invokespecial 465	org/json/JSONObject:<init>	()V
    //   94: astore 12
    //   96: iload_2
    //   97: bipush 100
    //   99: if_icmpne +275 -> 374
    //   102: aload 9
    //   104: astore 8
    //   106: aload_0
    //   107: getfield 258	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mLocationCallback	Ljava/lang/String;
    //   110: astore 9
    //   112: aload 9
    //   114: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   117: ifeq +13 -> 130
    //   120: ldc 31
    //   122: iconst_1
    //   123: ldc_w 467
    //   126: invokestatic 136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: return
    //   130: aload_1
    //   131: ldc_w 469
    //   134: invokevirtual 473	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   137: checkcast 475	cooperation/qzone/LbsDataV2$PoiInfo
    //   140: astore_1
    //   141: aload_1
    //   142: ifnonnull +117 -> 259
    //   145: ldc 31
    //   147: iconst_1
    //   148: ldc_w 477
    //   151: invokestatic 136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: aload 12
    //   156: ldc_w 479
    //   159: bipush 101
    //   161: invokevirtual 483	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   164: pop
    //   165: aload_0
    //   166: aload 9
    //   168: iconst_1
    //   169: anewarray 94	java/lang/String
    //   172: dup
    //   173: iconst_0
    //   174: aload 12
    //   176: invokevirtual 125	org/json/JSONObject:toString	()Ljava/lang/String;
    //   179: aastore
    //   180: invokevirtual 464	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   183: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   186: ifeq -163 -> 23
    //   189: ldc 31
    //   191: iconst_2
    //   192: new 48	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   199: ldc_w 485
    //   202: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload 12
    //   207: invokevirtual 125	org/json/JSONObject:toString	()Ljava/lang/String;
    //   210: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: return
    //   220: astore_1
    //   221: aload 9
    //   223: astore 8
    //   225: ldc 31
    //   227: iconst_1
    //   228: ldc_w 487
    //   231: aload_1
    //   232: invokestatic 490	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   235: aload 8
    //   237: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   240: ifne -217 -> 23
    //   243: aload_0
    //   244: aload 8
    //   246: iconst_1
    //   247: anewarray 94	java/lang/String
    //   250: dup
    //   251: iconst_0
    //   252: ldc 145
    //   254: aastore
    //   255: invokevirtual 464	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   258: return
    //   259: aload_0
    //   260: aload_1
    //   261: getfield 493	cooperation/qzone/LbsDataV2$PoiInfo:poiId	Ljava/lang/String;
    //   264: putfield 260	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mCachePoiId	Ljava/lang/String;
    //   267: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   270: ifeq +32 -> 302
    //   273: ldc 31
    //   275: iconst_2
    //   276: new 48	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   283: ldc_w 286
    //   286: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: aload_0
    //   290: getfield 260	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mCachePoiId	Ljava/lang/String;
    //   293: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   302: aload 12
    //   304: ldc_w 479
    //   307: iconst_0
    //   308: invokevirtual 483	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   311: pop
    //   312: new 124	org/json/JSONObject
    //   315: dup
    //   316: invokespecial 465	org/json/JSONObject:<init>	()V
    //   319: astore 8
    //   321: aload_1
    //   322: getfield 496	cooperation/qzone/LbsDataV2$PoiInfo:poiName	Ljava/lang/String;
    //   325: ldc_w 498
    //   328: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   331: ifne +29 -> 360
    //   334: aload 8
    //   336: ldc 159
    //   338: aload_1
    //   339: getfield 496	cooperation/qzone/LbsDataV2$PoiInfo:poiName	Ljava/lang/String;
    //   342: invokevirtual 501	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   345: pop
    //   346: aload 12
    //   348: ldc_w 503
    //   351: aload 8
    //   353: invokevirtual 501	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   356: pop
    //   357: goto -192 -> 165
    //   360: aload 8
    //   362: ldc 159
    //   364: ldc_w 278
    //   367: invokevirtual 501	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   370: pop
    //   371: goto -25 -> 346
    //   374: iload_2
    //   375: bipush 101
    //   377: if_icmpne -354 -> 23
    //   380: aload 9
    //   382: astore 8
    //   384: aload_0
    //   385: getfield 318	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mActionCallback	Ljava/lang/String;
    //   388: astore 9
    //   390: aload 9
    //   392: astore 8
    //   394: aload 9
    //   396: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   399: ifeq +17 -> 416
    //   402: aload 9
    //   404: astore 8
    //   406: ldc 31
    //   408: iconst_1
    //   409: ldc_w 505
    //   412: invokestatic 136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   415: return
    //   416: aload 9
    //   418: astore 8
    //   420: aload_1
    //   421: ldc 14
    //   423: lconst_0
    //   424: invokevirtual 509	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   427: lstore 4
    //   429: aload 9
    //   431: astore 8
    //   433: aload_1
    //   434: ldc 17
    //   436: invokevirtual 512	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   439: astore 10
    //   441: aload 10
    //   443: ifnonnull +338 -> 781
    //   446: ldc_w 278
    //   449: astore 10
    //   451: aload 9
    //   453: astore 8
    //   455: aload_1
    //   456: ldc 20
    //   458: lconst_0
    //   459: invokevirtual 509	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   462: lstore 6
    //   464: aload 9
    //   466: astore 8
    //   468: aload_1
    //   469: ldc 23
    //   471: invokevirtual 512	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   474: astore 11
    //   476: aload 11
    //   478: astore_1
    //   479: aload 11
    //   481: ifnonnull +7 -> 488
    //   484: ldc_w 278
    //   487: astore_1
    //   488: lload 4
    //   490: lconst_0
    //   491: lcmp
    //   492: ifne +85 -> 577
    //   495: aload 9
    //   497: astore 8
    //   499: aload 12
    //   501: ldc_w 479
    //   504: bipush 101
    //   506: invokevirtual 483	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   509: pop
    //   510: aload 9
    //   512: astore 8
    //   514: aload_0
    //   515: aload 9
    //   517: iconst_1
    //   518: anewarray 94	java/lang/String
    //   521: dup
    //   522: iconst_0
    //   523: aload 12
    //   525: invokevirtual 125	org/json/JSONObject:toString	()Ljava/lang/String;
    //   528: aastore
    //   529: invokevirtual 464	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   532: aload 9
    //   534: astore 8
    //   536: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   539: ifeq -516 -> 23
    //   542: aload 9
    //   544: astore 8
    //   546: ldc 31
    //   548: iconst_2
    //   549: new 48	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   556: ldc_w 514
    //   559: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: aload 12
    //   564: invokevirtual 125	org/json/JSONObject:toString	()Ljava/lang/String;
    //   567: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   573: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   576: return
    //   577: aload 9
    //   579: astore 8
    //   581: new 124	org/json/JSONObject
    //   584: dup
    //   585: invokespecial 465	org/json/JSONObject:<init>	()V
    //   588: astore 11
    //   590: aload 9
    //   592: astore 8
    //   594: new 124	org/json/JSONObject
    //   597: dup
    //   598: invokespecial 465	org/json/JSONObject:<init>	()V
    //   601: astore 13
    //   603: aload 9
    //   605: astore 8
    //   607: aload 13
    //   609: ldc 185
    //   611: lload 4
    //   613: invokestatic 519	java/lang/Long:toString	(J)Ljava/lang/String;
    //   616: invokevirtual 501	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   619: pop
    //   620: aload 9
    //   622: astore 8
    //   624: aload 13
    //   626: ldc 189
    //   628: aload 10
    //   630: invokevirtual 501	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   633: pop
    //   634: aload 9
    //   636: astore 8
    //   638: aload 13
    //   640: ldc 193
    //   642: lload 6
    //   644: invokestatic 519	java/lang/Long:toString	(J)Ljava/lang/String;
    //   647: invokevirtual 501	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   650: pop
    //   651: aload 9
    //   653: astore 8
    //   655: aload 13
    //   657: ldc 197
    //   659: aload_1
    //   660: invokevirtual 501	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   663: pop
    //   664: aload 9
    //   666: astore 8
    //   668: aload 11
    //   670: ldc 178
    //   672: aload 13
    //   674: invokevirtual 501	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   677: pop
    //   678: aload 9
    //   680: astore 8
    //   682: aload 12
    //   684: ldc_w 479
    //   687: iconst_0
    //   688: invokevirtual 483	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   691: pop
    //   692: aload 9
    //   694: astore 8
    //   696: aload 12
    //   698: ldc_w 503
    //   701: aload 11
    //   703: invokevirtual 501	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   706: pop
    //   707: aload 9
    //   709: astore 8
    //   711: aload_0
    //   712: aload 9
    //   714: iconst_1
    //   715: anewarray 94	java/lang/String
    //   718: dup
    //   719: iconst_0
    //   720: aload 12
    //   722: invokevirtual 125	org/json/JSONObject:toString	()Ljava/lang/String;
    //   725: aastore
    //   726: invokevirtual 464	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   729: aload 9
    //   731: astore 8
    //   733: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   736: ifeq -713 -> 23
    //   739: aload 9
    //   741: astore 8
    //   743: ldc 31
    //   745: iconst_2
    //   746: new 48	java/lang/StringBuilder
    //   749: dup
    //   750: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   753: ldc_w 514
    //   756: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: aload 12
    //   761: invokevirtual 125	org/json/JSONObject:toString	()Ljava/lang/String;
    //   764: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   767: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   770: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   773: return
    //   774: astore_1
    //   775: aconst_null
    //   776: astore 8
    //   778: goto -553 -> 225
    //   781: goto -330 -> 451
    //   784: astore_1
    //   785: aload 9
    //   787: astore 8
    //   789: goto -739 -> 50
    //   792: astore_1
    //   793: aload 9
    //   795: astore 8
    //   797: goto -572 -> 225
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	800	0	this	SignJsPlugin
    //   0	800	1	paramIntent	android.content.Intent
    //   0	800	2	paramByte	byte
    //   0	800	3	paramInt	int
    //   427	185	4	l1	long
    //   462	181	6	l2	long
    //   26	770	8	localObject1	Object
    //   8	786	9	str1	String
    //   439	190	10	str2	String
    //   474	228	11	localObject2	Object
    //   94	666	12	localJSONObject1	JSONObject
    //   601	72	13	localJSONObject2	JSONObject
    // Exception table:
    //   from	to	target	type
    //   28	35	49	java/lang/OutOfMemoryError
    //   39	48	49	java/lang/OutOfMemoryError
    //   87	96	49	java/lang/OutOfMemoryError
    //   106	112	49	java/lang/OutOfMemoryError
    //   384	390	49	java/lang/OutOfMemoryError
    //   394	402	49	java/lang/OutOfMemoryError
    //   406	415	49	java/lang/OutOfMemoryError
    //   420	429	49	java/lang/OutOfMemoryError
    //   433	441	49	java/lang/OutOfMemoryError
    //   455	464	49	java/lang/OutOfMemoryError
    //   468	476	49	java/lang/OutOfMemoryError
    //   499	510	49	java/lang/OutOfMemoryError
    //   514	532	49	java/lang/OutOfMemoryError
    //   536	542	49	java/lang/OutOfMemoryError
    //   546	576	49	java/lang/OutOfMemoryError
    //   581	590	49	java/lang/OutOfMemoryError
    //   594	603	49	java/lang/OutOfMemoryError
    //   607	620	49	java/lang/OutOfMemoryError
    //   624	634	49	java/lang/OutOfMemoryError
    //   638	651	49	java/lang/OutOfMemoryError
    //   655	664	49	java/lang/OutOfMemoryError
    //   668	678	49	java/lang/OutOfMemoryError
    //   682	692	49	java/lang/OutOfMemoryError
    //   696	707	49	java/lang/OutOfMemoryError
    //   711	729	49	java/lang/OutOfMemoryError
    //   733	739	49	java/lang/OutOfMemoryError
    //   743	773	49	java/lang/OutOfMemoryError
    //   112	129	220	org/json/JSONException
    //   130	141	220	org/json/JSONException
    //   145	165	220	org/json/JSONException
    //   165	219	220	org/json/JSONException
    //   259	302	220	org/json/JSONException
    //   302	346	220	org/json/JSONException
    //   346	357	220	org/json/JSONException
    //   360	371	220	org/json/JSONException
    //   28	35	774	org/json/JSONException
    //   39	48	774	org/json/JSONException
    //   87	96	774	org/json/JSONException
    //   106	112	774	org/json/JSONException
    //   384	390	774	org/json/JSONException
    //   112	129	784	java/lang/OutOfMemoryError
    //   130	141	784	java/lang/OutOfMemoryError
    //   145	165	784	java/lang/OutOfMemoryError
    //   165	219	784	java/lang/OutOfMemoryError
    //   259	302	784	java/lang/OutOfMemoryError
    //   302	346	784	java/lang/OutOfMemoryError
    //   346	357	784	java/lang/OutOfMemoryError
    //   360	371	784	java/lang/OutOfMemoryError
    //   394	402	792	org/json/JSONException
    //   406	415	792	org/json/JSONException
    //   420	429	792	org/json/JSONException
    //   433	441	792	org/json/JSONException
    //   455	464	792	org/json/JSONException
    //   468	476	792	org/json/JSONException
    //   499	510	792	org/json/JSONException
    //   514	532	792	org/json/JSONException
    //   536	542	792	org/json/JSONException
    //   546	576	792	org/json/JSONException
    //   581	590	792	org/json/JSONException
    //   594	603	792	org/json/JSONException
    //   607	620	792	org/json/JSONException
    //   624	634	792	org/json/JSONException
    //   638	651	792	org/json/JSONException
    //   655	664	792	org/json/JSONException
    //   668	678	792	org/json/JSONException
    //   682	692	792	org/json/JSONException
    //   696	707	792	org/json/JSONException
    //   711	729	792	org/json/JSONException
    //   733	739	792	org/json/JSONException
    //   743	773	792	org/json/JSONException
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.mReqBundle = new Bundle();
    AppInterface localAppInterface = this.mRuntime.a();
    if ((localAppInterface instanceof BrowserAppInterface)) {
      this.browserApp = ((BrowserAppInterface)localAppInterface);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("SignJsPlugin", 2, "ERROR!!! ChatFont market is not running in web process!");
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    String str2;
    String str1;
    Object localObject;
    do
    {
      do
      {
        return;
      } while (paramBundle.getInt("respkey", 0) != this.mOnRemoteResp.key);
      str2 = paramBundle.getString("cmd");
      str1 = paramBundle.getString("callbackid");
      try
      {
        localObject = paramBundle.getBundle("response");
        if (localObject == null)
        {
          QLog.e("SignJsPlugin", 1, "onResponse error no bundle");
          super.callJs(str1, new String[] { "{\"result\": -1}" });
          return;
        }
      }
      catch (Exception paramBundle)
      {
        QLog.e("SignJsPlugin", 1, "onResponse error: ", paramBundle);
        super.callJs(str1, new String[] { "{\"result\": -1}" });
        return;
      }
      paramBundle = new JSONObject();
      if ("ipc_signature_setordelete".equals(str2))
      {
        int i = ((Bundle)localObject).getInt("result");
        if (i == 100)
        {
          paramBundle.put("result", 0);
          this.mRuntime.a().getPreferences().edit().putString("sign_location_id_" + this.mRuntime.a().getCurrentAccountUin(), this.mCachePoiId).commit();
        }
        for (;;)
        {
          if (((Bundle)localObject).getBoolean("hasTipsInfo", false))
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("type", ((Bundle)localObject).getInt("tips_type"));
            localJSONObject.put("titleWording", ((Bundle)localObject).getString("tips_titleWording"));
            localJSONObject.put("wording", ((Bundle)localObject).getString("tips_wording"));
            localJSONObject.put("rightBtnWording", ((Bundle)localObject).getString("tips_rightBtnWording"));
            localJSONObject.put("leftBtnWording", ((Bundle)localObject).getString("tips_leftBtnWording"));
            localJSONObject.put("vipType", ((Bundle)localObject).getString("tips_vipType"));
            localJSONObject.put("vipMonth", ((Bundle)localObject).getInt("tips_vipMonth"));
            localJSONObject.put("url", ((Bundle)localObject).getString("tips_url"));
            localObject = new JSONObject();
            ((JSONObject)localObject).put("tipsInfo", localJSONObject);
            paramBundle.put("data", localObject);
          }
          super.callJs(str1, new String[] { paramBundle.toString() });
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("SignJsPlugin", 2, "onResponse cmd = " + str2 + " Result = " + paramBundle.toString());
          return;
          paramBundle.put("result", i);
        }
      }
      if ("ipc_signature_setlike".equals(str2))
      {
        paramBundle.put("result", ((Bundle)localObject).getInt("result"));
        super.callJs(str1, new String[] { paramBundle.toString() });
        return;
      }
    } while (!"ipc_signature_get_sync_tag".equals(str2));
    this.isSync = ((Bundle)localObject).getBoolean("isSync");
    paramBundle.put("result", this.isSync);
    if (QLog.isColorLevel()) {
      QLog.d("SigImg2Zone", 4, "isSync from onResponse: " + this.isSync);
    }
    super.callJs(str1, new String[] { paramBundle.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.SignJsPlugin
 * JD-Core Version:    0.7.0.1
 */