package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import cooperation.vip.manager.MonitorManager;
import cooperation.vip.manager.QZoneVipInfoManager;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QZoneFeedActionJsPlugin
  extends QzoneInternalWebViewPlugin
{
  public static final String ACTION_BROADCAST_NOTIFY_INPUT_FONT_SELECT = "FeedActionPanelActivity.font_select";
  public static final String ACTION_BROADCAST_NOTIFY_INPUT_PANEL_CLOSED = "FeedActionPanelActivity.inputpanel_closed";
  public static final String ACTION_CONTENT = "FeedActionPanelActivity.content";
  public static final String ACTION_H5PAY_CALL_BACK = "action_h5pay_callback";
  public static final String ACTION_OPEN_VIP_INFO_SUCC = "openVipInfo";
  public static final String ACTION_PANEL_HEIGHT = "FeedActionPanelActivity.inputpanel_height";
  public static final String ACTION_SWITCH_WEISHI_MEDAL = "hasClickedWeiShiMedelSwitch";
  public static final String FEEDACTION_METHOD_NAMESPACE = "TopicComment";
  public static final String H5PAY_CALLBACK = "H5PayCallBack";
  public static final String H5PAY_CALL_BACK_JSON = "h5pay_callback_json";
  public static final String INPUT_PANEL_HEIGHT = "panel_height";
  public static final String TAG = "QZoneFeedActionJsPlugin";
  public static final String UNIQUE_KEY_FEEDACTION_ACTIVE = "FeedAction#isActive";
  public static String name = "";
  public static boolean sAcceptEncoded = false;
  private boolean acceptEncoded = false;
  private String mSwitchFontCallback;
  
  /* Error */
  private void handleFeedActionPanel(String... paramVarArgs)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: ldc 44
    //   5: iconst_0
    //   6: invokestatic 70	cooperation/qzone/LocalMultiProcConfig:getBool	(Ljava/lang/String;Z)Z
    //   9: ifeq +4 -> 13
    //   12: return
    //   13: ldc 44
    //   15: iconst_1
    //   16: invokestatic 74	cooperation/qzone/LocalMultiProcConfig:putBool	(Ljava/lang/String;Z)V
    //   19: iconst_m1
    //   20: istore 10
    //   22: ldc 47
    //   24: astore 18
    //   26: aload_1
    //   27: ifnull +545 -> 572
    //   30: aload_1
    //   31: arraylength
    //   32: ifle +540 -> 572
    //   35: new 76	org/json/JSONObject
    //   38: dup
    //   39: aload_1
    //   40: iconst_0
    //   41: aaload
    //   42: invokespecial 79	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   45: astore 20
    //   47: aload 20
    //   49: ldc 81
    //   51: invokevirtual 85	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   54: astore_1
    //   55: aload 20
    //   57: ldc 87
    //   59: invokevirtual 85	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   62: astore 17
    //   64: aload 20
    //   66: ldc 89
    //   68: invokevirtual 93	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   71: istore_2
    //   72: aload 20
    //   74: ldc 95
    //   76: invokevirtual 93	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   79: istore_3
    //   80: aload 20
    //   82: ldc 97
    //   84: invokevirtual 93	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   87: istore 4
    //   89: aload 20
    //   91: ldc 99
    //   93: invokevirtual 93	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   96: istore 5
    //   98: aload 20
    //   100: ldc 101
    //   102: invokevirtual 93	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   105: istore 6
    //   107: aload 18
    //   109: astore 19
    //   111: aload 20
    //   113: ldc 103
    //   115: invokevirtual 85	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   118: putstatic 105	cooperation/qzone/webviewplugin/QZoneFeedActionJsPlugin:name	Ljava/lang/String;
    //   121: aload 18
    //   123: astore 19
    //   125: aload_0
    //   126: aload 20
    //   128: ldc 106
    //   130: invokevirtual 110	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   133: putfield 60	cooperation/qzone/webviewplugin/QZoneFeedActionJsPlugin:acceptEncoded	Z
    //   136: aload 18
    //   138: astore 19
    //   140: aload_0
    //   141: getfield 60	cooperation/qzone/webviewplugin/QZoneFeedActionJsPlugin:acceptEncoded	Z
    //   144: putstatic 112	cooperation/qzone/webviewplugin/QZoneFeedActionJsPlugin:sAcceptEncoded	Z
    //   147: aload 18
    //   149: astore 19
    //   151: aload 20
    //   153: ldc 114
    //   155: invokevirtual 85	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   158: astore 18
    //   160: aload 18
    //   162: astore 19
    //   164: aload 20
    //   166: ldc 116
    //   168: invokevirtual 93	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   171: istore 7
    //   173: aload 20
    //   175: ldc 118
    //   177: invokevirtual 93	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   180: istore 8
    //   182: aload 20
    //   184: ldc 120
    //   186: invokevirtual 110	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   189: istore 13
    //   191: aload 20
    //   193: ldc 122
    //   195: invokevirtual 110	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   198: istore 14
    //   200: aload 20
    //   202: ldc 124
    //   204: invokevirtual 110	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   207: istore 16
    //   209: aload 20
    //   211: ldc 126
    //   213: invokevirtual 93	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   216: istore 9
    //   218: iload 9
    //   220: iconst_1
    //   221: if_icmpne +9 -> 230
    //   224: iconst_1
    //   225: istore 15
    //   227: goto +6 -> 233
    //   230: iconst_0
    //   231: istore 15
    //   233: aload 20
    //   235: ldc 128
    //   237: iconst_m1
    //   238: invokevirtual 131	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   241: istore 9
    //   243: iload 9
    //   245: istore 10
    //   247: aload_0
    //   248: aload 20
    //   250: ldc 133
    //   252: invokevirtual 85	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   255: putfield 135	cooperation/qzone/webviewplugin/QZoneFeedActionJsPlugin:mSwitchFontCallback	Ljava/lang/String;
    //   258: iload 9
    //   260: istore 10
    //   262: aload 18
    //   264: astore 19
    //   266: aload 17
    //   268: astore 18
    //   270: iload_2
    //   271: istore 9
    //   273: aload 19
    //   275: astore 17
    //   277: iload 10
    //   279: istore_2
    //   280: goto +257 -> 537
    //   283: astore 20
    //   285: aload 18
    //   287: astore 19
    //   289: aload 17
    //   291: astore 18
    //   293: aload 20
    //   295: astore 17
    //   297: iload_2
    //   298: istore 9
    //   300: goto +214 -> 514
    //   303: astore 20
    //   305: aload 18
    //   307: astore 19
    //   309: aload 17
    //   311: astore 18
    //   313: aload 20
    //   315: astore 17
    //   317: goto +191 -> 508
    //   320: astore 20
    //   322: aload 18
    //   324: astore 19
    //   326: aload 17
    //   328: astore 18
    //   330: aload 20
    //   332: astore 17
    //   334: goto +171 -> 505
    //   337: astore 20
    //   339: aload 18
    //   341: astore 19
    //   343: aload 17
    //   345: astore 18
    //   347: aload 20
    //   349: astore 17
    //   351: goto +151 -> 502
    //   354: astore 20
    //   356: aload 18
    //   358: astore 19
    //   360: aload 17
    //   362: astore 18
    //   364: aload 20
    //   366: astore 17
    //   368: goto +131 -> 499
    //   371: astore 20
    //   373: aload 18
    //   375: astore 19
    //   377: aload 17
    //   379: astore 18
    //   381: aload 20
    //   383: astore 17
    //   385: goto +111 -> 496
    //   388: astore 20
    //   390: aload 17
    //   392: astore 18
    //   394: aload 20
    //   396: astore 17
    //   398: goto +95 -> 493
    //   401: astore 19
    //   403: aload 17
    //   405: astore 18
    //   407: aload 19
    //   409: astore 17
    //   411: goto +75 -> 486
    //   414: astore 19
    //   416: aload 17
    //   418: astore 18
    //   420: aload 19
    //   422: astore 17
    //   424: goto +59 -> 483
    //   427: astore 19
    //   429: aload 17
    //   431: astore 18
    //   433: aload 19
    //   435: astore 17
    //   437: goto +43 -> 480
    //   440: astore 19
    //   442: aload 17
    //   444: astore 18
    //   446: aload 19
    //   448: astore 17
    //   450: goto +28 -> 478
    //   453: astore 19
    //   455: aload 17
    //   457: astore 18
    //   459: aload 19
    //   461: astore 17
    //   463: goto +13 -> 476
    //   466: astore 17
    //   468: goto +8 -> 476
    //   471: astore 17
    //   473: ldc 47
    //   475: astore_1
    //   476: iconst_0
    //   477: istore_2
    //   478: iconst_0
    //   479: istore_3
    //   480: iconst_0
    //   481: istore 4
    //   483: iconst_0
    //   484: istore 5
    //   486: ldc 47
    //   488: astore 19
    //   490: iconst_0
    //   491: istore 6
    //   493: iconst_0
    //   494: istore 7
    //   496: iconst_0
    //   497: istore 8
    //   499: iconst_0
    //   500: istore 13
    //   502: iconst_0
    //   503: istore 14
    //   505: iconst_0
    //   506: istore 16
    //   508: iconst_0
    //   509: istore 15
    //   511: iload_2
    //   512: istore 9
    //   514: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   517: ifeq +13 -> 530
    //   520: ldc 41
    //   522: iconst_2
    //   523: ldc 143
    //   525: aload 17
    //   527: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   530: iload 10
    //   532: istore_2
    //   533: aload 19
    //   535: astore 17
    //   537: iload 4
    //   539: istore 10
    //   541: iload 5
    //   543: istore 11
    //   545: iload 6
    //   547: istore 12
    //   549: iload 7
    //   551: istore 5
    //   553: iload 8
    //   555: istore 4
    //   557: iload 10
    //   559: istore 6
    //   561: iload 11
    //   563: istore 7
    //   565: iload 12
    //   567: istore 8
    //   569: goto +40 -> 609
    //   572: ldc 47
    //   574: astore_1
    //   575: aload_1
    //   576: astore 17
    //   578: iconst_0
    //   579: istore_3
    //   580: iconst_0
    //   581: istore 5
    //   583: iconst_0
    //   584: istore 6
    //   586: iconst_0
    //   587: istore 7
    //   589: iconst_0
    //   590: istore 8
    //   592: iconst_0
    //   593: istore 9
    //   595: iconst_0
    //   596: istore 13
    //   598: iconst_0
    //   599: istore 14
    //   601: iconst_0
    //   602: istore 16
    //   604: iconst_0
    //   605: istore 15
    //   607: iconst_m1
    //   608: istore_2
    //   609: invokestatic 150	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   612: ifeq +262 -> 874
    //   615: new 152	java/lang/StringBuilder
    //   618: dup
    //   619: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   622: astore 19
    //   624: aload 19
    //   626: ldc 155
    //   628: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: pop
    //   632: aload 19
    //   634: aload 18
    //   636: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: pop
    //   640: aload 19
    //   642: ldc 161
    //   644: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: pop
    //   648: aload 19
    //   650: aload_1
    //   651: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: pop
    //   655: aload 19
    //   657: ldc 163
    //   659: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: pop
    //   663: aload 19
    //   665: iload 9
    //   667: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   670: pop
    //   671: aload 19
    //   673: ldc 168
    //   675: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: pop
    //   679: aload 19
    //   681: iload_3
    //   682: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   685: pop
    //   686: aload 19
    //   688: ldc 170
    //   690: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: pop
    //   694: aload 19
    //   696: iload 6
    //   698: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   701: pop
    //   702: aload 19
    //   704: ldc 172
    //   706: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: pop
    //   710: aload 19
    //   712: iload 7
    //   714: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   717: pop
    //   718: aload 19
    //   720: ldc 174
    //   722: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: pop
    //   726: aload 19
    //   728: iload 8
    //   730: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   733: pop
    //   734: aload 19
    //   736: ldc 176
    //   738: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: pop
    //   742: aload 19
    //   744: iload 5
    //   746: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   749: pop
    //   750: aload 19
    //   752: ldc 178
    //   754: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: pop
    //   758: aload 19
    //   760: iload 4
    //   762: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   765: pop
    //   766: aload 19
    //   768: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   771: astore 19
    //   773: new 152	java/lang/StringBuilder
    //   776: dup
    //   777: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   780: astore 20
    //   782: aload 20
    //   784: ldc 184
    //   786: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   789: pop
    //   790: aload 20
    //   792: aload_0
    //   793: getfield 60	cooperation/qzone/webviewplugin/QZoneFeedActionJsPlugin:acceptEncoded	Z
    //   796: invokevirtual 187	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   799: pop
    //   800: aload 20
    //   802: ldc 189
    //   804: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   807: pop
    //   808: aload 20
    //   810: iload 13
    //   812: invokevirtual 187	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   815: pop
    //   816: aload 20
    //   818: ldc 191
    //   820: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: pop
    //   824: aload 20
    //   826: iload 14
    //   828: invokevirtual 187	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   831: pop
    //   832: aload 20
    //   834: ldc 193
    //   836: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   839: pop
    //   840: aload 20
    //   842: iload 16
    //   844: invokevirtual 187	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   847: pop
    //   848: ldc 41
    //   850: iconst_4
    //   851: iconst_2
    //   852: anewarray 195	java/lang/Object
    //   855: dup
    //   856: iconst_0
    //   857: aload 19
    //   859: aastore
    //   860: dup
    //   861: iconst_1
    //   862: aload 20
    //   864: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   867: aastore
    //   868: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   871: goto +3 -> 874
    //   874: new 200	android/os/Bundle
    //   877: dup
    //   878: invokespecial 201	android/os/Bundle:<init>	()V
    //   881: astore 19
    //   883: aload 19
    //   885: ldc 120
    //   887: iload 13
    //   889: invokevirtual 204	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   892: aload 19
    //   894: ldc 122
    //   896: iload 14
    //   898: invokevirtual 204	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   901: aload 19
    //   903: ldc 124
    //   905: iload 16
    //   907: invokevirtual 204	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   910: aload 19
    //   912: ldc 126
    //   914: iload 15
    //   916: invokevirtual 204	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   919: aload 19
    //   921: ldc 206
    //   923: iload_2
    //   924: invokevirtual 210	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   927: aload_0
    //   928: getfield 214	cooperation/qzone/webviewplugin/QZoneFeedActionJsPlugin:parentPlugin	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   931: aload_0
    //   932: getfield 214	cooperation/qzone/webviewplugin/QZoneFeedActionJsPlugin:parentPlugin	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   935: getfield 220	com/tencent/mobileqq/webview/swift/WebViewPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   938: iconst_2
    //   939: invokestatic 226	cooperation/qzone/webviewplugin/QZoneWebViewPlugin:generateRequestCode	(Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;I)I
    //   942: istore_2
    //   943: aload_0
    //   944: getfield 214	cooperation/qzone/webviewplugin/QZoneFeedActionJsPlugin:parentPlugin	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   947: getfield 220	com/tencent/mobileqq/webview/swift/WebViewPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   950: invokevirtual 232	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   953: invokestatic 238	cooperation/qzone/QZoneHelper$UserInfo:getInstance	()Lcooperation/qzone/QZoneHelper$UserInfo;
    //   956: iload_2
    //   957: aload 18
    //   959: aload_1
    //   960: ldc 47
    //   962: ldc 47
    //   964: iload 8
    //   966: iconst_0
    //   967: iload_3
    //   968: iload 9
    //   970: iconst_0
    //   971: iload 6
    //   973: iload 7
    //   975: aload 17
    //   977: iload 5
    //   979: iload 4
    //   981: iconst_0
    //   982: ldc 47
    //   984: iconst_0
    //   985: aload 19
    //   987: invokestatic 244	cooperation/qzone/QZoneHelper:forwardToFeedActionPanel	(Landroid/app/Activity;Lcooperation/qzone/QZoneHelper$UserInfo;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZIIIIILjava/lang/String;IIZLjava/lang/String;ZLandroid/os/Bundle;)V
    //   990: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	991	0	this	QZoneFeedActionJsPlugin
    //   0	991	1	paramVarArgs	String[]
    //   71	886	2	i	int
    //   79	889	3	j	int
    //   1	979	4	k	int
    //   96	882	5	m	int
    //   105	867	6	n	int
    //   171	803	7	i1	int
    //   180	785	8	i2	int
    //   216	753	9	i3	int
    //   20	538	10	i4	int
    //   543	19	11	i5	int
    //   547	19	12	i6	int
    //   189	699	13	bool1	boolean
    //   198	699	14	bool2	boolean
    //   225	690	15	bool3	boolean
    //   207	699	16	bool4	boolean
    //   62	400	17	localObject1	Object
    //   466	1	17	localJSONException1	JSONException
    //   471	55	17	localJSONException2	JSONException
    //   535	441	17	localObject2	Object
    //   24	934	18	localObject3	Object
    //   109	267	19	localObject4	Object
    //   401	7	19	localJSONException3	JSONException
    //   414	7	19	localJSONException4	JSONException
    //   427	7	19	localJSONException5	JSONException
    //   440	7	19	localJSONException6	JSONException
    //   453	7	19	localJSONException7	JSONException
    //   488	498	19	localObject5	Object
    //   45	204	20	localJSONObject	JSONObject
    //   283	11	20	localJSONException8	JSONException
    //   303	11	20	localJSONException9	JSONException
    //   320	11	20	localJSONException10	JSONException
    //   337	11	20	localJSONException11	JSONException
    //   354	11	20	localJSONException12	JSONException
    //   371	11	20	localJSONException13	JSONException
    //   388	7	20	localJSONException14	JSONException
    //   780	83	20	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   233	243	283	org/json/JSONException
    //   247	258	283	org/json/JSONException
    //   209	218	303	org/json/JSONException
    //   200	209	320	org/json/JSONException
    //   191	200	337	org/json/JSONException
    //   182	191	354	org/json/JSONException
    //   173	182	371	org/json/JSONException
    //   111	121	388	org/json/JSONException
    //   125	136	388	org/json/JSONException
    //   140	147	388	org/json/JSONException
    //   151	160	388	org/json/JSONException
    //   164	173	388	org/json/JSONException
    //   98	107	401	org/json/JSONException
    //   89	98	414	org/json/JSONException
    //   80	89	427	org/json/JSONException
    //   72	80	440	org/json/JSONException
    //   64	72	453	org/json/JSONException
    //   55	64	466	org/json/JSONException
    //   35	55	471	org/json/JSONException
  }
  
  private void handleH5PayCallBackSucess(String paramString)
  {
    Object localObject1 = new Intent("action_js2qzone");
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putString("cmd", "H5PayCallSucess");
    ((Intent)localObject1).putExtras((Bundle)localObject2);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("handleWriteBlog actionString: ");
      ((StringBuilder)localObject2).append(((Intent)localObject1).getAction());
      QLog.d("QZoneFeedActionJsPlugin", 2, ((StringBuilder)localObject2).toString());
    }
    QZoneHelper.forwardToQzoneTransluentActivity(this.parentPlugin.mRuntime.a(), QZoneHelper.UserInfo.getInstance(), (Intent)localObject1);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        localObject1 = new JSONObject();
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("vipType", paramString);
        ((JSONObject)localObject1).put("type", "YellowInfo");
        ((JSONObject)localObject1).put("data", localObject2);
        localObject2 = new JSONObject();
        JSONArray localJSONArray = new JSONArray();
        localJSONArray.put("*.qzone.qq.com");
        ((JSONObject)localObject2).put("echo", true);
        ((JSONObject)localObject2).put("broadcast", true);
        ((JSONObject)localObject2).put("domains", localJSONArray);
        dispatchEvent("openVipInfo", (JSONObject)localObject1, (JSONObject)localObject2);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QZoneFeedActionJsPlugin", 2, "handleJsRequest: ", localException);
        }
      }
    }
    if (("normalVip".equals(paramString)) || ("highVip".equals(paramString)))
    {
      paramString = this.parentPlugin.mRuntime.a();
      if (paramString != null) {
        paramString.finish();
      }
    }
  }
  
  private void handleSwitchWeishiMedal(long paramLong, int paramInt)
  {
    RemoteHandleManager.getInstance().getSender().refreshWeishiMedalStatus(paramLong, paramInt);
  }
  
  private void notifyH5FontSelect(Intent paramIntent)
  {
    if ((!TextUtils.isEmpty(this.mSwitchFontCallback)) && (paramIntent != null)) {
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("font_id", paramIntent.getIntExtra("extra_key_font_id", -1));
        ((JSONObject)localObject).put("font_type", paramIntent.getIntExtra("extra_key_font_format_type", -1));
        ((JSONObject)localObject).put("font_url", paramIntent.getStringExtra("extra_key_font_url"));
        paramIntent = new StringBuilder();
        paramIntent.append("window.");
        paramIntent.append(this.mSwitchFontCallback);
        paramIntent.append("(");
        paramIntent.append(((JSONObject)localObject).toString());
        paramIntent.append(");");
        paramIntent = paramIntent.toString();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("invoke callback js:");
          ((StringBuilder)localObject).append(paramIntent);
          QLog.d("QZoneFeedActionJsPlugin", 2, ((StringBuilder)localObject).toString());
        }
        this.parentPlugin.mRuntime.a().callJs(paramIntent);
        return;
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
        return;
      }
    }
    QLog.e("QZoneFeedActionJsPlugin", 1, "notifyH5FontSelect error callback = null");
  }
  
  private void notifyInputPanelClosed(Intent paramIntent)
  {
    QLog.d("QZoneFeedActionJsPlugin", 2, "notifyInputPanelClosed");
    try
    {
      paramIntent = new StringBuilder();
      paramIntent.append("window.");
      paramIntent.append(name);
      paramIntent.append("(");
      paramIntent.append("{event_type:\"PANEL_CLOSED\"}");
      paramIntent.append(");");
      paramIntent = paramIntent.toString();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("invoke callback js:");
        localStringBuilder.append(paramIntent);
        QLog.d("QZoneFeedActionJsPlugin", 2, localStringBuilder.toString());
      }
      this.parentPlugin.mRuntime.a().callJs(paramIntent);
      return;
    }
    catch (Throwable paramIntent)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZoneFeedActionJsPlugin", 2, "notifyInputPanelClosed: ", paramIntent);
      }
    }
  }
  
  private void notifyPanelHeightChanged(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("panel_height", -1);
    paramIntent = new StringBuilder();
    paramIntent.append("Input FeedActionPanel totalHeight : ");
    paramIntent.append(i);
    QLog.d("QZoneFeedActionJsPlugin", 2, paramIntent.toString());
    if (i == -1) {
      return;
    }
    try
    {
      paramIntent = new StringBuilder();
      paramIntent.append("{event_type:\"HEIGHT_CHANGED\",height:\"");
      paramIntent.append(i);
      paramIntent.append("\"}");
      paramIntent = paramIntent.toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("window.");
      localStringBuilder.append(name);
      localStringBuilder.append("(");
      localStringBuilder.append(paramIntent);
      localStringBuilder.append(");");
      paramIntent = localStringBuilder.toString();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("invoke callback js:");
        localStringBuilder.append(paramIntent);
        QLog.d("QZoneFeedActionJsPlugin", 2, localStringBuilder.toString());
      }
      this.parentPlugin.mRuntime.a().callJs(paramIntent);
      return;
    }
    catch (Throwable paramIntent)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZoneFeedActionJsPlugin", 2, "notifyPanelHeightChanged: ", paramIntent);
      }
    }
  }
  
  private void notifyVipStatusChange(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" notifyVipStatusChange result = ");
    localStringBuilder.append(paramString);
    QLog.i("QzoneVip", 1, localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      if ((paramString.has("status")) && ("success".equalsIgnoreCase(paramString.getString("status"))))
      {
        paramString = paramString.optString("vipType", "");
        if (TextUtils.isEmpty(paramString)) {
          return;
        }
        if ("NOBLE_VIP".equals(paramString))
        {
          QZoneVipInfoManager.a().a(2);
          return;
        }
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void sendH5PayCallBackBroadcast(String paramString)
  {
    Intent localIntent = new Intent("action_h5pay_callback");
    localIntent.putExtra("h5pay_callback_json", paramString);
    this.parentPlugin.mRuntime.a().sendBroadcast(localIntent);
  }
  
  private void writeContent2H5(Intent paramIntent)
  {
    int i = 0;
    boolean bool = paramIntent.getBooleanExtra("extraPrivateComment", false);
    String str = paramIntent.getStringExtra("contentIntentKey");
    for (;;)
    {
      try
      {
        if (this.acceptEncoded)
        {
          localObject = URLEncoder.encode(str, "utf-8");
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("content", localObject);
          if (bool) {
            i = 1;
          }
          localJSONObject.put("privateComment", i);
          localJSONObject.put("font_id", paramIntent.getIntExtra("extra_key_font_id", -1));
          localJSONObject.put("font_type", paramIntent.getIntExtra("extra_key_font_format_type", -1));
          localJSONObject.put("font_url", paramIntent.getStringExtra("extra_key_font_url"));
          paramIntent = new StringBuilder();
          paramIntent.append("window.");
          paramIntent.append(name);
          paramIntent.append("(");
          paramIntent.append(localJSONObject.toString());
          paramIntent.append(");");
          paramIntent = paramIntent.toString();
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("invoke callback js:");
            ((StringBuilder)localObject).append(paramIntent);
            QLog.d("QZoneFeedActionJsPlugin", 2, ((StringBuilder)localObject).toString());
          }
          this.parentPlugin.mRuntime.a().callJs(paramIntent);
          return;
        }
      }
      catch (Throwable paramIntent)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("content:");
          ((StringBuilder)localObject).append(str);
          QLog.d("QZoneFeedActionJsPlugin", 2, ((StringBuilder)localObject).toString(), paramIntent);
        }
        return;
      }
      Object localObject = str;
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("handleJsRequest \n url: ");
      paramJsBridgeListener.append(paramString1);
      paramJsBridgeListener.append("\n pkgName:");
      paramJsBridgeListener.append(paramString2);
      paramJsBridgeListener.append("\n method:");
      paramJsBridgeListener.append(paramString3);
      QLog.d("QZoneFeedActionJsPlugin", 2, paramJsBridgeListener.toString());
    }
    if ("TopicComment".equalsIgnoreCase(paramString3))
    {
      handleFeedActionPanel(paramVarArgs);
      return true;
    }
    if ("H5PayCallBack".equalsIgnoreCase(paramString3))
    {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        paramString1 = MonitorManager.a();
        paramString2 = new StringBuilder();
        paramString2.append("");
        paramString2.append(paramVarArgs[0]);
        paramString1.a(1, 4, "js 通知native 黄钻支付结果", paramString2.toString());
        sendH5PayCallBackBroadcast(paramVarArgs[0]);
        notifyVipStatusChange(paramVarArgs[0]);
        if ((!paramJsBridgeListener.has("status")) || (!"success".equalsIgnoreCase(paramJsBridgeListener.getString("status")))) {
          break label302;
        }
        handleH5PayCallBackSucess(paramJsBridgeListener.optString("vipType", null));
        return true;
      }
      catch (Exception paramJsBridgeListener)
      {
        if (!QLog.isColorLevel()) {
          break label302;
        }
      }
      QLog.d("QZoneFeedActionJsPlugin", 2, "handleJsRequest: ", paramJsBridgeListener);
      return false;
    }
    else if ("hasClickedWeiShiMedelSwitch".equalsIgnoreCase(paramString3))
    {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        if ((paramJsBridgeListener.has("uin")) && (paramJsBridgeListener.has("ishide")))
        {
          handleSwitchWeishiMedal(paramJsBridgeListener.getLong("uin"), paramJsBridgeListener.getInt("ishide"));
          return true;
        }
      }
      catch (Exception paramJsBridgeListener)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QZoneFeedActionJsPlugin", 2, "handleJsRequest: ", paramJsBridgeListener);
        }
      }
    }
    label302:
    return false;
  }
  
  public void initRuntime(WebViewPlugin paramWebViewPlugin)
  {
    super.initRuntime(paramWebViewPlugin);
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (paramByte != 2) {
      return;
    }
    if (paramInt == -1) {
      writeContent2H5(paramIntent);
    }
  }
  
  public void onDestroy()
  {
    LocalMultiProcConfig.putBool("FeedAction#isActive", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneFeedActionJsPlugin
 * JD-Core Version:    0.7.0.1
 */