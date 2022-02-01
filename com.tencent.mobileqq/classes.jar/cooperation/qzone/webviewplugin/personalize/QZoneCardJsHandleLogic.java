package cooperation.qzone.webviewplugin.personalize;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class QZoneCardJsHandleLogic
{
  public static final String CARDDECORATE_SP_KEY = "key_personalize_prefix_18";
  public static final String CARDTAG = "QZoneCardLogic";
  public static final String KEY_PERSONALIZE_PREFIX = "key_personalize_prefix";
  public static final String TAG = "QZoneCardJsHandleLogicQZonePersonalizePlugin";
  
  public static void handleDownCardMethod(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    Object localObject3 = "";
    Object localObject2;
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      try
      {
        Object localObject1 = new JSONObject(paramVarArgs[0]);
        paramVarArgs = ((JSONObject)localObject1).getString("cardid");
        try
        {
          localObject1 = ((JSONObject)localObject1).getString("cardurl");
        }
        catch (JSONException localJSONException1) {}
        localJSONException2.printStackTrace();
      }
      catch (JSONException localJSONException2)
      {
        paramVarArgs = "";
      }
      localObject2 = localObject3;
    }
    else
    {
      paramVarArgs = "";
      localObject2 = localObject3;
    }
    if (QLog.isDevelopLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("handleDownCardMethod js give download cardurl is: ");
      ((StringBuilder)localObject3).append(localObject2);
      ((StringBuilder)localObject3).append("\t cardid:");
      ((StringBuilder)localObject3).append(paramVarArgs);
      QLog.d("QZoneCardLogic.QZoneCardJsHandleLogicQZonePersonalizePlugin", 4, ((StringBuilder)localObject3).toString());
    }
    paramVarArgs = new Intent("action_personalize_js2qzone");
    localObject3 = new Bundle();
    ((Bundle)localObject3).putString("cmd", "downloadcard");
    ((Bundle)localObject3).putString("cardDownloadUrl", localObject2);
    paramVarArgs.putExtras((Bundle)localObject3);
    QZoneHelper.forwardToQzoneTransluentActivity(paramPluginRuntime.a(), QZoneHelper.UserInfo.getInstance(), paramVarArgs);
  }
  
  /* Error */
  public static void handleSetSkinFinish(com.tencent.mobileqq.webview.swift.WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +900 -> 901
    //   4: aload_2
    //   5: arraylength
    //   6: ifle +895 -> 901
    //   9: new 30	org/json/JSONObject
    //   12: dup
    //   13: aload_2
    //   14: iconst_0
    //   15: aaload
    //   16: invokespecial 33	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   19: astore 18
    //   21: aload 18
    //   23: ldc 115
    //   25: invokevirtual 39	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   28: astore_0
    //   29: aload 18
    //   31: ldc 117
    //   33: invokevirtual 39	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   36: astore_2
    //   37: aload 18
    //   39: ldc 119
    //   41: invokevirtual 39	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   44: astore 11
    //   46: aload 18
    //   48: ldc 121
    //   50: invokevirtual 125	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   53: istore_3
    //   54: aload 18
    //   56: ldc 127
    //   58: iconst_0
    //   59: invokevirtual 131	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   62: istore 8
    //   64: aload 18
    //   66: ldc 133
    //   68: invokevirtual 136	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   71: astore 12
    //   73: aload 18
    //   75: ldc 138
    //   77: invokevirtual 136	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   80: astore 13
    //   82: aload 18
    //   84: ldc 140
    //   86: invokevirtual 144	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   89: lstore 9
    //   91: aload 18
    //   93: ldc 146
    //   95: invokevirtual 125	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   98: istore 5
    //   100: aload 18
    //   102: ldc 148
    //   104: invokevirtual 136	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   107: astore 17
    //   109: aload 18
    //   111: ldc 150
    //   113: invokevirtual 125	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   116: istore 4
    //   118: iload 4
    //   120: iconst_1
    //   121: if_icmpne +9 -> 130
    //   124: iconst_1
    //   125: istore 4
    //   127: goto +6 -> 133
    //   130: iconst_0
    //   131: istore 4
    //   133: iload_3
    //   134: sipush 392
    //   137: if_icmpne +223 -> 360
    //   140: aload_2
    //   141: astore 15
    //   143: aload 18
    //   145: ldc 152
    //   147: invokevirtual 136	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   150: astore_2
    //   151: aload_2
    //   152: astore 15
    //   154: aload 18
    //   156: ldc 154
    //   158: invokevirtual 136	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   161: astore 14
    //   163: aload 18
    //   165: ldc 156
    //   167: invokevirtual 136	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   170: astore 16
    //   172: aload 18
    //   174: ldc 158
    //   176: invokevirtual 136	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   179: astore 21
    //   181: aload 18
    //   183: ldc 160
    //   185: invokevirtual 136	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   188: astore 22
    //   190: aload 18
    //   192: ldc 162
    //   194: invokevirtual 125	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   197: istore 6
    //   199: aload_2
    //   200: astore 15
    //   202: aload 14
    //   204: astore 19
    //   206: aload 16
    //   208: astore 18
    //   210: aload 21
    //   212: astore 16
    //   214: aload 22
    //   216: astore 14
    //   218: goto +164 -> 382
    //   221: astore 15
    //   223: iload_3
    //   224: istore 6
    //   226: aload_0
    //   227: astore 20
    //   229: aload 11
    //   231: astore 18
    //   233: aload 12
    //   235: astore 19
    //   237: aload 16
    //   239: astore 11
    //   241: aload 21
    //   243: astore 12
    //   245: aload 22
    //   247: astore_0
    //   248: goto +559 -> 807
    //   251: astore 15
    //   253: ldc 28
    //   255: astore 22
    //   257: iload_3
    //   258: istore 6
    //   260: aload_0
    //   261: astore 20
    //   263: aload 11
    //   265: astore 18
    //   267: aload 12
    //   269: astore 19
    //   271: aload 16
    //   273: astore 11
    //   275: aload 21
    //   277: astore 12
    //   279: aload 22
    //   281: astore_0
    //   282: goto +525 -> 807
    //   285: astore 15
    //   287: ldc 28
    //   289: astore 18
    //   291: aload 16
    //   293: astore 21
    //   295: aload 18
    //   297: astore 16
    //   299: goto +29 -> 328
    //   302: astore 15
    //   304: goto +16 -> 320
    //   307: astore 16
    //   309: ldc 28
    //   311: astore 14
    //   313: aload 15
    //   315: astore_2
    //   316: aload 16
    //   318: astore 15
    //   320: ldc 28
    //   322: astore 21
    //   324: ldc 28
    //   326: astore 16
    //   328: aload 16
    //   330: astore 22
    //   332: iload_3
    //   333: istore 6
    //   335: aload_0
    //   336: astore 20
    //   338: aload 11
    //   340: astore 18
    //   342: aload 12
    //   344: astore 19
    //   346: aload 21
    //   348: astore 11
    //   350: aload 16
    //   352: astore 12
    //   354: aload 22
    //   356: astore_0
    //   357: goto +450 -> 807
    //   360: ldc 28
    //   362: astore 19
    //   364: aload 19
    //   366: astore 18
    //   368: aload 18
    //   370: astore 16
    //   372: aload 16
    //   374: astore 14
    //   376: iconst_0
    //   377: istore 6
    //   379: aload_2
    //   380: astore 15
    //   382: iload 6
    //   384: istore 7
    //   386: aload_0
    //   387: astore_2
    //   388: aload 13
    //   390: astore 22
    //   392: aload 19
    //   394: astore 13
    //   396: aload 18
    //   398: astore_0
    //   399: aload 16
    //   401: astore 20
    //   403: aload 14
    //   405: astore 21
    //   407: aload_2
    //   408: astore 16
    //   410: iload_3
    //   411: istore 6
    //   413: aload 22
    //   415: astore_2
    //   416: aload 11
    //   418: astore 18
    //   420: aload 12
    //   422: astore 19
    //   424: aload 17
    //   426: astore 14
    //   428: aload_0
    //   429: astore 12
    //   431: aload 20
    //   433: astore 11
    //   435: aload 21
    //   437: astore_0
    //   438: iload 7
    //   440: istore_3
    //   441: goto +407 -> 848
    //   444: astore 15
    //   446: goto +9 -> 455
    //   449: astore 15
    //   451: ldc 28
    //   453: astore 17
    //   455: ldc 28
    //   457: astore 20
    //   459: ldc 28
    //   461: astore 21
    //   463: aload 21
    //   465: astore 22
    //   467: aload 22
    //   469: astore 23
    //   471: aload_0
    //   472: astore 16
    //   474: aload 11
    //   476: astore 18
    //   478: aload 12
    //   480: astore 19
    //   482: goto +300 -> 782
    //   485: astore 14
    //   487: ldc 28
    //   489: astore 16
    //   491: aload 16
    //   493: astore 17
    //   495: aload 17
    //   497: astore 18
    //   499: aload 18
    //   501: astore 19
    //   503: aload 19
    //   505: astore 20
    //   507: aload 13
    //   509: astore 15
    //   511: goto +229 -> 740
    //   514: astore 16
    //   516: ldc 28
    //   518: astore 17
    //   520: aload 12
    //   522: astore 14
    //   524: aload 13
    //   526: astore 15
    //   528: aload 17
    //   530: astore 12
    //   532: goto +26 -> 558
    //   535: astore 16
    //   537: aload 12
    //   539: astore 14
    //   541: goto +9 -> 550
    //   544: astore 16
    //   546: ldc 28
    //   548: astore 14
    //   550: ldc 28
    //   552: astore 15
    //   554: ldc 28
    //   556: astore 12
    //   558: aload 12
    //   560: astore 17
    //   562: aload 17
    //   564: astore 18
    //   566: aload 18
    //   568: astore 19
    //   570: aload 19
    //   572: astore 20
    //   574: aload 16
    //   576: astore 13
    //   578: aload 12
    //   580: astore 16
    //   582: goto +147 -> 729
    //   585: astore 12
    //   587: ldc 28
    //   589: astore 13
    //   591: aload 13
    //   593: astore 14
    //   595: aload 14
    //   597: astore 15
    //   599: aload 15
    //   601: astore 17
    //   603: aload 17
    //   605: astore 18
    //   607: aload 18
    //   609: astore 19
    //   611: aload 19
    //   613: astore 20
    //   615: goto +95 -> 710
    //   618: astore 12
    //   620: ldc 28
    //   622: astore 13
    //   624: aload_0
    //   625: astore 16
    //   627: aload 13
    //   629: astore_0
    //   630: goto +49 -> 679
    //   633: astore 12
    //   635: ldc 28
    //   637: astore 11
    //   639: aload_0
    //   640: astore 16
    //   642: aload_2
    //   643: astore 13
    //   645: aload 11
    //   647: astore_2
    //   648: goto +23 -> 671
    //   651: astore 12
    //   653: goto +8 -> 661
    //   656: astore 12
    //   658: ldc 28
    //   660: astore_0
    //   661: ldc 28
    //   663: astore 13
    //   665: ldc 28
    //   667: astore_2
    //   668: aload_0
    //   669: astore 16
    //   671: aload_2
    //   672: astore_0
    //   673: aload_2
    //   674: astore 11
    //   676: aload 13
    //   678: astore_2
    //   679: aload_0
    //   680: astore 14
    //   682: aload 14
    //   684: astore 15
    //   686: aload 15
    //   688: astore 17
    //   690: aload 17
    //   692: astore 18
    //   694: aload 18
    //   696: astore 19
    //   698: aload 19
    //   700: astore 20
    //   702: iconst_0
    //   703: istore_3
    //   704: aload_0
    //   705: astore 13
    //   707: aload 16
    //   709: astore_0
    //   710: iconst_0
    //   711: istore 8
    //   713: aload 15
    //   715: astore 16
    //   717: aload 14
    //   719: astore 15
    //   721: aload 13
    //   723: astore 14
    //   725: aload 12
    //   727: astore 13
    //   729: lconst_0
    //   730: lstore 9
    //   732: aload 14
    //   734: astore 12
    //   736: aload 13
    //   738: astore 14
    //   740: iconst_0
    //   741: istore 5
    //   743: aload 20
    //   745: astore 23
    //   747: aload 19
    //   749: astore 22
    //   751: aload 18
    //   753: astore 21
    //   755: aload 17
    //   757: astore 20
    //   759: aload 16
    //   761: astore 17
    //   763: aload 15
    //   765: astore 13
    //   767: aload 12
    //   769: astore 19
    //   771: aload 11
    //   773: astore 18
    //   775: aload_0
    //   776: astore 16
    //   778: aload 14
    //   780: astore 15
    //   782: iconst_0
    //   783: istore 4
    //   785: aload 23
    //   787: astore_0
    //   788: aload 22
    //   790: astore 12
    //   792: aload 21
    //   794: astore 11
    //   796: aload 20
    //   798: astore 14
    //   800: aload 16
    //   802: astore 20
    //   804: iload_3
    //   805: istore 6
    //   807: aload 15
    //   809: invokevirtual 44	org/json/JSONException:printStackTrace	()V
    //   812: aload 20
    //   814: astore 16
    //   816: aload 13
    //   818: astore 20
    //   820: aload 14
    //   822: astore 13
    //   824: aload 11
    //   826: astore 14
    //   828: aload 12
    //   830: astore 11
    //   832: iconst_0
    //   833: istore_3
    //   834: aload 14
    //   836: astore 12
    //   838: aload 17
    //   840: astore 14
    //   842: aload_2
    //   843: astore 15
    //   845: aload 20
    //   847: astore_2
    //   848: aload 18
    //   850: astore 17
    //   852: iload 6
    //   854: istore 7
    //   856: aload 15
    //   858: astore 18
    //   860: aload 16
    //   862: astore 23
    //   864: iload 5
    //   866: istore 6
    //   868: aload 19
    //   870: astore 15
    //   872: iload 7
    //   874: istore 5
    //   876: aload 18
    //   878: astore 16
    //   880: aload_2
    //   881: astore 18
    //   883: aload 13
    //   885: astore 19
    //   887: aload 12
    //   889: astore 20
    //   891: aload 11
    //   893: astore 21
    //   895: aload_0
    //   896: astore 22
    //   898: goto +86 -> 984
    //   901: ldc 28
    //   903: astore 23
    //   905: aload 23
    //   907: astore_0
    //   908: aload_0
    //   909: astore_2
    //   910: aload_2
    //   911: astore 11
    //   913: aload 11
    //   915: astore 12
    //   917: aload 12
    //   919: astore 13
    //   921: aload 13
    //   923: astore 14
    //   925: aload 14
    //   927: astore 15
    //   929: aload 15
    //   931: astore 16
    //   933: aload 16
    //   935: astore 22
    //   937: iconst_0
    //   938: istore 6
    //   940: iconst_0
    //   941: istore 5
    //   943: lconst_0
    //   944: lstore 9
    //   946: iconst_0
    //   947: istore 8
    //   949: iconst_0
    //   950: istore 4
    //   952: iconst_0
    //   953: istore_3
    //   954: aload 16
    //   956: astore 21
    //   958: aload 15
    //   960: astore 20
    //   962: aload 14
    //   964: astore 19
    //   966: aload 13
    //   968: astore 14
    //   970: aload 12
    //   972: astore 18
    //   974: aload 11
    //   976: astore 17
    //   978: aload_2
    //   979: astore 16
    //   981: aload_0
    //   982: astore 15
    //   984: invokestatic 50	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   987: ifeq +66 -> 1053
    //   990: new 52	java/lang/StringBuilder
    //   993: dup
    //   994: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   997: astore_0
    //   998: aload_0
    //   999: ldc 164
    //   1001: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1004: pop
    //   1005: aload_0
    //   1006: aload 23
    //   1008: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1011: pop
    //   1012: aload_0
    //   1013: ldc 166
    //   1015: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1018: pop
    //   1019: aload_0
    //   1020: aload 16
    //   1022: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1025: pop
    //   1026: aload_0
    //   1027: ldc 61
    //   1029: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1032: pop
    //   1033: aload_0
    //   1034: aload 17
    //   1036: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1039: pop
    //   1040: ldc 63
    //   1042: iconst_4
    //   1043: aload_0
    //   1044: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1047: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1050: goto +3 -> 1053
    //   1053: aload 23
    //   1055: ldc 168
    //   1057: invokevirtual 174	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1060: ifeq +311 -> 1371
    //   1063: new 73	android/content/Intent
    //   1066: dup
    //   1067: ldc 75
    //   1069: invokespecial 76	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   1072: astore_0
    //   1073: new 78	android/os/Bundle
    //   1076: dup
    //   1077: invokespecial 79	android/os/Bundle:<init>	()V
    //   1080: astore_2
    //   1081: aload_2
    //   1082: ldc 119
    //   1084: aload 17
    //   1086: invokevirtual 87	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1089: aload_2
    //   1090: ldc 176
    //   1092: lconst_0
    //   1093: invokevirtual 180	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1096: aload_2
    //   1097: ldc 117
    //   1099: aload 16
    //   1101: invokevirtual 87	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1104: aload_2
    //   1105: ldc 182
    //   1107: lload 9
    //   1109: invokevirtual 180	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1112: aload_2
    //   1113: ldc 184
    //   1115: ldc 28
    //   1117: invokevirtual 87	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1120: aload_2
    //   1121: ldc 138
    //   1123: aload 18
    //   1125: invokevirtual 87	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1128: aload_2
    //   1129: ldc 146
    //   1131: iload 6
    //   1133: invokevirtual 188	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1136: aload_2
    //   1137: ldc 133
    //   1139: aload 15
    //   1141: invokevirtual 87	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1144: aload_2
    //   1145: ldc 121
    //   1147: iload 5
    //   1149: invokevirtual 188	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1152: aload_2
    //   1153: ldc 148
    //   1155: aload 14
    //   1157: invokevirtual 87	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1160: aload_2
    //   1161: ldc 154
    //   1163: aload 19
    //   1165: invokevirtual 87	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1168: aload_2
    //   1169: ldc 156
    //   1171: aload 20
    //   1173: invokevirtual 87	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1176: aload_2
    //   1177: ldc 158
    //   1179: aload 21
    //   1181: invokevirtual 87	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1184: aload_2
    //   1185: ldc 160
    //   1187: aload 22
    //   1189: invokevirtual 87	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1192: aload_2
    //   1193: ldc 162
    //   1195: iload_3
    //   1196: invokevirtual 188	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1199: iload 8
    //   1201: ifeq +8 -> 1209
    //   1204: iconst_1
    //   1205: istore_3
    //   1206: goto +5 -> 1211
    //   1209: iconst_0
    //   1210: istore_3
    //   1211: aload_2
    //   1212: ldc 127
    //   1214: iload_3
    //   1215: invokevirtual 188	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1218: aload_2
    //   1219: ldc 81
    //   1221: ldc 190
    //   1223: invokevirtual 87	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1226: aload_0
    //   1227: aload_2
    //   1228: invokevirtual 93	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   1231: pop
    //   1232: invokestatic 50	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1235: ifeq +79 -> 1314
    //   1238: new 52	java/lang/StringBuilder
    //   1241: dup
    //   1242: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1245: astore_2
    //   1246: aload_2
    //   1247: ldc 192
    //   1249: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1252: pop
    //   1253: aload_2
    //   1254: aload_0
    //   1255: invokevirtual 195	android/content/Intent:getAction	()Ljava/lang/String;
    //   1258: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1261: pop
    //   1262: aload_2
    //   1263: ldc 197
    //   1265: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1268: pop
    //   1269: aload_2
    //   1270: lload 9
    //   1272: invokevirtual 200	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1275: pop
    //   1276: aload_2
    //   1277: ldc 202
    //   1279: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1282: pop
    //   1283: aload_2
    //   1284: iload 5
    //   1286: invokevirtual 205	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1289: pop
    //   1290: aload_2
    //   1291: ldc 207
    //   1293: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1296: pop
    //   1297: aload_2
    //   1298: aload 14
    //   1300: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1303: pop
    //   1304: ldc 63
    //   1306: iconst_4
    //   1307: aload_2
    //   1308: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1311: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1314: aload_1
    //   1315: invokevirtual 99	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1318: invokestatic 105	cooperation/qzone/QZoneHelper$UserInfo:getInstance	()Lcooperation/qzone/QZoneHelper$UserInfo;
    //   1321: aload_0
    //   1322: invokestatic 111	cooperation/qzone/QZoneHelper:forwardToQzoneTransluentActivity	(Landroid/app/Activity;Lcooperation/qzone/QZoneHelper$UserInfo;Landroid/content/Intent;)V
    //   1325: ldc 8
    //   1327: iconst_0
    //   1328: aload_1
    //   1329: invokevirtual 210	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   1332: invokevirtual 215	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1335: invokestatic 221	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   1338: invokevirtual 225	java/lang/Long:longValue	()J
    //   1341: invokestatic 231	cooperation/qzone/LocalMultiProcConfig:putInt4Uin	(Ljava/lang/String;IJ)V
    //   1344: iload 4
    //   1346: ifeq +25 -> 1371
    //   1349: aload_1
    //   1350: invokevirtual 99	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1353: invokestatic 105	cooperation/qzone/QZoneHelper$UserInfo:getInstance	()Lcooperation/qzone/QZoneHelper$UserInfo;
    //   1356: aload_1
    //   1357: invokevirtual 210	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   1360: invokevirtual 234	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   1363: iconst_0
    //   1364: iconst_0
    //   1365: sipush 256
    //   1368: invokestatic 238	cooperation/qzone/QZoneHelper:forwardToUserHome	(Landroid/content/Context;Lcooperation/qzone/QZoneHelper$UserInfo;Ljava/lang/String;III)V
    //   1371: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1372	0	paramWebViewPlugin	com.tencent.mobileqq.webview.swift.WebViewPlugin
    //   0	1372	1	paramPluginRuntime	WebViewPlugin.PluginRuntime
    //   0	1372	2	paramVarArgs	String[]
    //   53	1162	3	i	int
    //   116	1229	4	j	int
    //   98	1187	5	k	int
    //   197	935	6	m	int
    //   384	489	7	n	int
    //   62	1138	8	bool	boolean
    //   89	1182	9	l	long
    //   44	931	11	localObject1	Object
    //   71	508	12	localObject2	Object
    //   585	1	12	localJSONException1	JSONException
    //   618	1	12	localJSONException2	JSONException
    //   633	1	12	localJSONException3	JSONException
    //   651	1	12	localJSONException4	JSONException
    //   656	70	12	localJSONException5	JSONException
    //   734	237	12	localObject3	Object
    //   80	887	13	localObject4	Object
    //   161	266	14	localObject5	Object
    //   485	1	14	localJSONException6	JSONException
    //   522	777	14	localObject6	Object
    //   141	60	15	arrayOfString	String[]
    //   221	1	15	localJSONException7	JSONException
    //   251	1	15	localJSONException8	JSONException
    //   285	1	15	localJSONException9	JSONException
    //   302	12	15	localJSONException10	JSONException
    //   318	63	15	localObject7	Object
    //   444	1	15	localJSONException11	JSONException
    //   449	1	15	localJSONException12	JSONException
    //   509	631	15	localObject8	Object
    //   170	128	16	localObject9	Object
    //   307	10	16	localJSONException13	JSONException
    //   326	166	16	localObject10	Object
    //   514	1	16	localJSONException14	JSONException
    //   535	1	16	localJSONException15	JSONException
    //   544	31	16	localJSONException16	JSONException
    //   580	520	16	localObject11	Object
    //   107	978	17	localObject12	Object
    //   19	1105	18	localObject13	Object
    //   204	960	19	localObject14	Object
    //   227	945	20	localObject15	Object
    //   179	1001	21	localObject16	Object
    //   188	1000	22	localObject17	Object
    //   469	585	23	localObject18	Object
    // Exception table:
    //   from	to	target	type
    //   190	199	221	org/json/JSONException
    //   181	190	251	org/json/JSONException
    //   172	181	285	org/json/JSONException
    //   163	172	302	org/json/JSONException
    //   143	151	307	org/json/JSONException
    //   154	163	307	org/json/JSONException
    //   109	118	444	org/json/JSONException
    //   100	109	449	org/json/JSONException
    //   91	100	485	org/json/JSONException
    //   82	91	514	org/json/JSONException
    //   73	82	535	org/json/JSONException
    //   64	73	544	org/json/JSONException
    //   54	64	585	org/json/JSONException
    //   46	54	618	org/json/JSONException
    //   37	46	633	org/json/JSONException
    //   29	37	651	org/json/JSONException
    //   9	29	656	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.personalize.QZoneCardJsHandleLogic
 * JD-Core Version:    0.7.0.1
 */