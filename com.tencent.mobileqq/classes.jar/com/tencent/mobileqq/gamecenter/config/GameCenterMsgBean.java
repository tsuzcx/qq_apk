package com.tencent.mobileqq.gamecenter.config;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public class GameCenterMsgBean
{
  public int a;
  public String a;
  public HashMap<String, ArrayList<String>> a;
  public boolean a;
  public int b;
  public String b;
  public HashMap<String, String> b;
  public int c;
  public String c;
  public int d;
  public String d;
  public String e = "";
  public String f;
  public String g;
  
  public GameCenterMsgBean()
  {
    this.jdField_a_of_type_JavaLangString = "https://fastest.gamecenter.qq.com/_fst_/speed_gamecenter_qq_com/_fst_/pushgame/v1/home/msg?_wv=18950115&_wwv=393&_fst_id=194";
    this.jdField_b_of_type_JavaLangString = "https://speed.gamecenter.qq.com/pushgame/v1/gamemsg-setting?_wv=2&_wwv=134";
    this.jdField_c_of_type_JavaLangString = "[游戏好友]";
    this.jdField_b_of_type_Int = 0;
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
  }
  
  /* Error */
  public static GameCenterMsgBean a(com.tencent.mobileqq.config.QConfItem[] paramArrayOfQConfItem)
  {
    // Byte code:
    //   0: aload_0
    //   1: astore 5
    //   3: ldc 58
    //   5: astore 4
    //   7: ldc 60
    //   9: astore 7
    //   11: aload 5
    //   13: ifnull +996 -> 1009
    //   16: aload 5
    //   18: arraylength
    //   19: ifgt +6 -> 25
    //   22: goto +987 -> 1009
    //   25: ldc 62
    //   27: iconst_1
    //   28: ldc 64
    //   30: invokestatic 70	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: new 2	com/tencent/mobileqq/gamecenter/config/GameCenterMsgBean
    //   36: dup
    //   37: invokespecial 71	com/tencent/mobileqq/gamecenter/config/GameCenterMsgBean:<init>	()V
    //   40: astore 8
    //   42: iconst_0
    //   43: istore_1
    //   44: iconst_0
    //   45: istore_2
    //   46: aload_0
    //   47: astore 5
    //   49: iload_1
    //   50: aload 5
    //   52: arraylength
    //   53: if_icmpge +938 -> 991
    //   56: aload 5
    //   58: iload_1
    //   59: aaload
    //   60: getfield 74	com/tencent/mobileqq/config/QConfItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   63: astore 5
    //   65: new 76	org/json/JSONObject
    //   68: dup
    //   69: aload 5
    //   71: invokespecial 79	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   74: astore 6
    //   76: aload 6
    //   78: aload 7
    //   80: invokevirtual 83	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   83: ifeq +57 -> 140
    //   86: aload 8
    //   88: aload 6
    //   90: aload 7
    //   92: invokevirtual 87	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   95: putfield 45	com/tencent/mobileqq/gamecenter/config/GameCenterMsgBean:jdField_d_of_type_Int	I
    //   98: new 89	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   105: astore 5
    //   107: aload 5
    //   109: ldc 92
    //   111: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload 5
    //   117: aload 8
    //   119: getfield 45	com/tencent/mobileqq/gamecenter/config/GameCenterMsgBean:jdField_d_of_type_Int	I
    //   122: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: ldc 62
    //   128: iconst_1
    //   129: aload 5
    //   131: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 70	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: goto +877 -> 1014
    //   140: aload 6
    //   142: ldc 105
    //   144: invokevirtual 83	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   147: ifeq +21 -> 168
    //   150: ldc 62
    //   152: iconst_1
    //   153: ldc 107
    //   155: invokestatic 70	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: aload 6
    //   160: aload 8
    //   162: invokestatic 110	com/tencent/mobileqq/gamecenter/config/GameCenterMsgBean:a	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/gamecenter/config/GameCenterMsgBean;)V
    //   165: goto +849 -> 1014
    //   168: aload 6
    //   170: ldc 112
    //   172: invokevirtual 83	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   175: istore_3
    //   176: iload_3
    //   177: ifeq +140 -> 317
    //   180: getstatic 118	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   183: astore 9
    //   185: aload 9
    //   187: aconst_null
    //   188: invokevirtual 122	mqq/app/MobileQQ:waitAppRuntime	(Lmqq/app/BaseActivity;)Lmqq/app/AppRuntime;
    //   191: checkcast 124	com/tencent/common/app/AppInterface
    //   194: invokevirtual 128	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   197: astore 9
    //   199: aload 9
    //   201: ldc 130
    //   203: iconst_4
    //   204: invokevirtual 134	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   207: astore 9
    //   209: aload 6
    //   211: ldc 112
    //   213: invokevirtual 138	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   216: astore 6
    //   218: aload 9
    //   220: invokeinterface 144 1 0
    //   225: astore 9
    //   227: new 89	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   234: astore 10
    //   236: aload 10
    //   238: ldc 112
    //   240: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload 10
    //   246: invokestatic 146	com/tencent/mobileqq/gamecenter/config/GameCenterMsgBean:a	()Ljava/lang/String;
    //   249: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload 9
    //   255: aload 10
    //   257: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: aload 6
    //   262: invokevirtual 149	org/json/JSONArray:toString	()Ljava/lang/String;
    //   265: invokeinterface 155 3 0
    //   270: invokeinterface 159 1 0
    //   275: pop
    //   276: new 89	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   283: astore 6
    //   285: aload 6
    //   287: ldc 161
    //   289: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload 6
    //   295: aload 5
    //   297: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: ldc 62
    //   303: iconst_1
    //   304: aload 6
    //   306: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: invokestatic 70	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   312: iconst_1
    //   313: istore_2
    //   314: goto +670 -> 984
    //   317: aload 4
    //   319: astore 5
    //   321: aload 6
    //   323: ldc 163
    //   325: invokevirtual 83	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   328: ifeq +118 -> 446
    //   331: aload 8
    //   333: aload 6
    //   335: ldc 163
    //   337: invokevirtual 87	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   340: putfield 41	com/tencent/mobileqq/gamecenter/config/GameCenterMsgBean:jdField_c_of_type_Int	I
    //   343: new 89	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   350: astore 5
    //   352: aload 5
    //   354: ldc 165
    //   356: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: aload 5
    //   362: aload 8
    //   364: getfield 41	com/tencent/mobileqq/gamecenter/config/GameCenterMsgBean:jdField_c_of_type_Int	I
    //   367: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   370: pop
    //   371: ldc 62
    //   373: iconst_1
    //   374: aload 5
    //   376: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: invokestatic 70	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   382: aload 6
    //   384: ldc 167
    //   386: invokevirtual 83	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   389: ifeq +638 -> 1027
    //   392: aload 8
    //   394: aload 6
    //   396: ldc 167
    //   398: invokevirtual 171	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   401: putfield 43	com/tencent/mobileqq/gamecenter/config/GameCenterMsgBean:e	Ljava/lang/String;
    //   404: new 89	java/lang/StringBuilder
    //   407: dup
    //   408: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   411: astore 5
    //   413: aload 5
    //   415: ldc 173
    //   417: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: pop
    //   421: aload 5
    //   423: aload 8
    //   425: getfield 43	com/tencent/mobileqq/gamecenter/config/GameCenterMsgBean:e	Ljava/lang/String;
    //   428: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: pop
    //   432: ldc 62
    //   434: iconst_1
    //   435: aload 5
    //   437: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   440: invokestatic 70	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   443: goto +584 -> 1027
    //   446: aload 6
    //   448: ldc 175
    //   450: invokevirtual 83	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   453: ifeq +15 -> 468
    //   456: aload 8
    //   458: aload 6
    //   460: ldc 175
    //   462: invokevirtual 87	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   465: putfield 177	com/tencent/mobileqq/gamecenter/config/GameCenterMsgBean:jdField_a_of_type_Int	I
    //   468: aload 6
    //   470: ldc 179
    //   472: invokevirtual 83	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   475: ifeq +15 -> 490
    //   478: aload 8
    //   480: aload 6
    //   482: ldc 179
    //   484: invokevirtual 171	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   487: putfield 25	com/tencent/mobileqq/gamecenter/config/GameCenterMsgBean:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   490: aload 6
    //   492: ldc 181
    //   494: invokevirtual 83	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   497: ifeq +15 -> 512
    //   500: aload 8
    //   502: aload 6
    //   504: ldc 181
    //   506: invokevirtual 171	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   509: putfield 29	com/tencent/mobileqq/gamecenter/config/GameCenterMsgBean:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   512: aload 6
    //   514: ldc 183
    //   516: invokevirtual 83	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   519: ifeq +15 -> 534
    //   522: aload 8
    //   524: aload 6
    //   526: ldc 183
    //   528: invokevirtual 171	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   531: putfield 33	com/tencent/mobileqq/gamecenter/config/GameCenterMsgBean:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   534: aload 6
    //   536: ldc 185
    //   538: invokevirtual 83	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   541: istore_3
    //   542: iload_3
    //   543: ifeq +487 -> 1030
    //   546: aload 8
    //   548: aload 6
    //   550: ldc 185
    //   552: iconst_0
    //   553: invokevirtual 188	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   556: putfield 35	com/tencent/mobileqq/gamecenter/config/GameCenterMsgBean:jdField_b_of_type_Int	I
    //   559: goto +3 -> 562
    //   562: aload 6
    //   564: ldc 190
    //   566: invokevirtual 83	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   569: ifeq +15 -> 584
    //   572: aload 8
    //   574: aload 6
    //   576: ldc 190
    //   578: invokevirtual 171	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   581: putfield 39	com/tencent/mobileqq/gamecenter/config/GameCenterMsgBean:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   584: aload 5
    //   586: astore 4
    //   588: aload 6
    //   590: aload 4
    //   592: invokevirtual 83	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   595: ifeq +55 -> 650
    //   598: aload 6
    //   600: aload 4
    //   602: invokevirtual 194	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   605: astore 5
    //   607: aload 5
    //   609: ifnull +41 -> 650
    //   612: aload 5
    //   614: ldc 196
    //   616: invokevirtual 194	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   619: astore 5
    //   621: aload 5
    //   623: ifnull +27 -> 650
    //   626: aload 8
    //   628: aload 5
    //   630: ldc 198
    //   632: invokevirtual 171	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   635: putfield 200	com/tencent/mobileqq/gamecenter/config/GameCenterMsgBean:f	Ljava/lang/String;
    //   638: aload 8
    //   640: aload 5
    //   642: ldc 202
    //   644: invokevirtual 171	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   647: putfield 204	com/tencent/mobileqq/gamecenter/config/GameCenterMsgBean:g	Ljava/lang/String;
    //   650: new 89	java/lang/StringBuilder
    //   653: dup
    //   654: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   657: astore 5
    //   659: aload 5
    //   661: ldc 206
    //   663: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: pop
    //   667: aload 5
    //   669: aload 8
    //   671: getfield 177	com/tencent/mobileqq/gamecenter/config/GameCenterMsgBean:jdField_a_of_type_Int	I
    //   674: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   677: pop
    //   678: aload 5
    //   680: ldc 208
    //   682: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: pop
    //   686: aload 5
    //   688: aload 8
    //   690: getfield 25	com/tencent/mobileqq/gamecenter/config/GameCenterMsgBean:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   693: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: pop
    //   697: aload 5
    //   699: ldc 210
    //   701: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: pop
    //   705: aload 5
    //   707: aload 8
    //   709: getfield 29	com/tencent/mobileqq/gamecenter/config/GameCenterMsgBean:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   712: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: pop
    //   716: aload 5
    //   718: ldc 212
    //   720: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   723: pop
    //   724: aload 5
    //   726: aload 8
    //   728: getfield 39	com/tencent/mobileqq/gamecenter/config/GameCenterMsgBean:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   731: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: pop
    //   735: aload 5
    //   737: ldc 214
    //   739: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: pop
    //   743: aload 5
    //   745: aload 8
    //   747: getfield 200	com/tencent/mobileqq/gamecenter/config/GameCenterMsgBean:f	Ljava/lang/String;
    //   750: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: pop
    //   754: ldc 62
    //   756: iconst_1
    //   757: aload 5
    //   759: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   762: invokestatic 70	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   765: aload 6
    //   767: ldc 216
    //   769: invokevirtual 83	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   772: ifeq +25 -> 797
    //   775: aload 6
    //   777: ldc 216
    //   779: invokevirtual 87	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   782: iconst_1
    //   783: if_icmpne +250 -> 1033
    //   786: iconst_1
    //   787: istore_3
    //   788: goto +3 -> 791
    //   791: aload 8
    //   793: iload_3
    //   794: putfield 218	com/tencent/mobileqq/gamecenter/config/GameCenterMsgBean:jdField_a_of_type_Boolean	Z
    //   797: new 89	java/lang/StringBuilder
    //   800: dup
    //   801: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   804: astore 5
    //   806: aload 5
    //   808: ldc 206
    //   810: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   813: pop
    //   814: aload 5
    //   816: aload 8
    //   818: getfield 177	com/tencent/mobileqq/gamecenter/config/GameCenterMsgBean:jdField_a_of_type_Int	I
    //   821: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   824: pop
    //   825: aload 5
    //   827: ldc 220
    //   829: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   832: pop
    //   833: aload 5
    //   835: aload 8
    //   837: getfield 25	com/tencent/mobileqq/gamecenter/config/GameCenterMsgBean:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   840: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   843: pop
    //   844: aload 5
    //   846: ldc 210
    //   848: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   851: pop
    //   852: aload 5
    //   854: aload 8
    //   856: getfield 29	com/tencent/mobileqq/gamecenter/config/GameCenterMsgBean:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   859: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: pop
    //   863: aload 5
    //   865: ldc 212
    //   867: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: pop
    //   871: aload 5
    //   873: aload 8
    //   875: getfield 39	com/tencent/mobileqq/gamecenter/config/GameCenterMsgBean:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   878: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   881: pop
    //   882: aload 5
    //   884: ldc 222
    //   886: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   889: pop
    //   890: aload 5
    //   892: aload 8
    //   894: getfield 218	com/tencent/mobileqq/gamecenter/config/GameCenterMsgBean:jdField_a_of_type_Boolean	Z
    //   897: invokevirtual 225	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   900: pop
    //   901: ldc 62
    //   903: iconst_1
    //   904: aload 5
    //   906: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   909: invokestatic 70	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   912: goto +72 -> 984
    //   915: astore 6
    //   917: aload 4
    //   919: astore 5
    //   921: goto +48 -> 969
    //   924: astore 6
    //   926: goto +43 -> 969
    //   929: astore 6
    //   931: aload 4
    //   933: astore 5
    //   935: aload 6
    //   937: astore 4
    //   939: goto +26 -> 965
    //   942: astore 6
    //   944: aload 4
    //   946: astore 5
    //   948: aload 6
    //   950: astore 4
    //   952: goto +13 -> 965
    //   955: astore 6
    //   957: aload 4
    //   959: astore 5
    //   961: aload 6
    //   963: astore 4
    //   965: aload 4
    //   967: astore 6
    //   969: ldc 62
    //   971: iconst_1
    //   972: aload 6
    //   974: invokevirtual 228	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   977: invokestatic 230	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   980: aload 5
    //   982: astore 4
    //   984: iload_1
    //   985: iconst_1
    //   986: iadd
    //   987: istore_1
    //   988: goto -942 -> 46
    //   991: iload_2
    //   992: ifne +6 -> 998
    //   995: invokestatic 232	com/tencent/mobileqq/gamecenter/config/GameCenterMsgBean:a	()V
    //   998: ldc 62
    //   1000: iconst_1
    //   1001: ldc 234
    //   1003: invokestatic 70	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1006: aload 8
    //   1008: areturn
    //   1009: invokestatic 232	com/tencent/mobileqq/gamecenter/config/GameCenterMsgBean:a	()V
    //   1012: aconst_null
    //   1013: areturn
    //   1014: goto -30 -> 984
    //   1017: astore 6
    //   1019: goto -62 -> 957
    //   1022: astore 6
    //   1024: goto -67 -> 957
    //   1027: goto -13 -> 1014
    //   1030: goto -468 -> 562
    //   1033: iconst_0
    //   1034: istore_3
    //   1035: goto -244 -> 791
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1038	0	paramArrayOfQConfItem	com.tencent.mobileqq.config.QConfItem[]
    //   43	945	1	i	int
    //   45	947	2	j	int
    //   175	860	3	bool	boolean
    //   5	978	4	localObject1	Object
    //   1	980	5	localObject2	Object
    //   74	702	6	localObject3	Object
    //   915	1	6	localThrowable1	Throwable
    //   924	1	6	localThrowable2	Throwable
    //   929	7	6	localThrowable3	Throwable
    //   942	7	6	localThrowable4	Throwable
    //   955	7	6	localThrowable5	Throwable
    //   967	6	6	localObject4	Object
    //   1017	1	6	localThrowable6	Throwable
    //   1022	1	6	localThrowable7	Throwable
    //   9	82	7	str	String
    //   40	967	8	localGameCenterMsgBean	GameCenterMsgBean
    //   183	71	9	localObject5	Object
    //   234	22	10	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   588	607	915	java/lang/Throwable
    //   612	621	915	java/lang/Throwable
    //   626	650	915	java/lang/Throwable
    //   650	786	915	java/lang/Throwable
    //   791	797	915	java/lang/Throwable
    //   797	912	915	java/lang/Throwable
    //   546	559	924	java/lang/Throwable
    //   562	584	924	java/lang/Throwable
    //   199	312	929	java/lang/Throwable
    //   321	443	929	java/lang/Throwable
    //   446	468	929	java/lang/Throwable
    //   468	490	929	java/lang/Throwable
    //   490	512	929	java/lang/Throwable
    //   512	534	929	java/lang/Throwable
    //   534	542	929	java/lang/Throwable
    //   140	165	942	java/lang/Throwable
    //   168	176	942	java/lang/Throwable
    //   65	137	955	java/lang/Throwable
    //   185	199	1017	java/lang/Throwable
    //   180	185	1022	java/lang/Throwable
  }
  
  private static String a()
  {
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localAppInterface == null) {
      return "";
    }
    return localAppInterface.getCurrentAccountUin();
  }
  
  public static void a()
  {
    Object localObject1 = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((AppInterface)localObject1).getApp().getSharedPreferences("game_center_sp_mutiprocess", 4);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("trace_url_keyword");
    ((StringBuilder)localObject2).append(a());
    localObject2 = ((StringBuilder)localObject2).toString();
    if (((SharedPreferences)localObject1).contains((String)localObject2))
    {
      QLog.i("GameCenterMsgBean", 1, "parse removeTraceKey");
      ((SharedPreferences)localObject1).edit().remove((String)localObject2).commit();
    }
  }
  
  private static void a(JSONObject paramJSONObject, GameCenterMsgBean paramGameCenterMsgBean)
  {
    try
    {
      QLog.i("GameCenterMsgBean", 1, "[parseAioQuickReply]");
      Iterator localIterator;
      if ((paramGameCenterMsgBean != null) && (paramGameCenterMsgBean.jdField_a_of_type_JavaUtilHashMap != null))
      {
        paramGameCenterMsgBean.jdField_a_of_type_JavaUtilHashMap.clear();
        paramJSONObject = paramJSONObject.getJSONObject("AioQuickReply");
        localIterator = paramJSONObject.keys();
      }
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!TextUtils.isEmpty(str)) {
          if ("friend_verify_msg".equals(str))
          {
            b(paramJSONObject.getJSONObject("friend_verify_msg"), paramGameCenterMsgBean);
          }
          else
          {
            JSONArray localJSONArray = paramJSONObject.getJSONArray(str);
            ArrayList localArrayList = new ArrayList();
            int i = 0;
            while (i < localJSONArray.length())
            {
              localArrayList.add(localJSONArray.get(i).toString());
              i += 1;
            }
            paramGameCenterMsgBean.jdField_a_of_type_JavaUtilHashMap.put(str, localArrayList);
            continue;
            QLog.w("GameCenterMsgBean", 1, "param is null, return.");
            return;
          }
        }
      }
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("GameCenterMsgBean", 1, paramJSONObject.getMessage());
    }
  }
  
  private static void b(JSONObject paramJSONObject, GameCenterMsgBean paramGameCenterMsgBean)
  {
    if (paramGameCenterMsgBean != null) {
      try
      {
        if (paramGameCenterMsgBean.jdField_b_of_type_JavaUtilHashMap == null) {
          return;
        }
        paramGameCenterMsgBean.jdField_b_of_type_JavaUtilHashMap.clear();
        Iterator localIterator = paramJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          if (!TextUtils.isEmpty(str1))
          {
            String str2 = paramJSONObject.optString(str1);
            paramGameCenterMsgBean.jdField_b_of_type_JavaUtilHashMap.put(str1, str2);
          }
        }
        return;
      }
      catch (Throwable paramJSONObject)
      {
        QLog.w("GameCenterMsgBean", 1, paramJSONObject.getMessage());
      }
    }
  }
  
  public void a(GameCenterMsgBean paramGameCenterMsgBean)
  {
    if (paramGameCenterMsgBean == null) {
      return;
    }
    this.jdField_a_of_type_Int = paramGameCenterMsgBean.jdField_a_of_type_Int;
    this.jdField_b_of_type_Int = paramGameCenterMsgBean.jdField_b_of_type_Int;
    this.jdField_a_of_type_Boolean = paramGameCenterMsgBean.jdField_a_of_type_Boolean;
    this.jdField_d_of_type_Int = paramGameCenterMsgBean.jdField_d_of_type_Int;
    this.jdField_a_of_type_Boolean = paramGameCenterMsgBean.jdField_a_of_type_Boolean;
    this.jdField_b_of_type_JavaUtilHashMap = paramGameCenterMsgBean.jdField_b_of_type_JavaUtilHashMap;
    this.jdField_a_of_type_JavaUtilHashMap = paramGameCenterMsgBean.jdField_a_of_type_JavaUtilHashMap;
    if (!TextUtils.isEmpty(paramGameCenterMsgBean.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = paramGameCenterMsgBean.jdField_a_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramGameCenterMsgBean.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = paramGameCenterMsgBean.jdField_b_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramGameCenterMsgBean.jdField_c_of_type_JavaLangString)) {
      this.jdField_c_of_type_JavaLangString = paramGameCenterMsgBean.jdField_c_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramGameCenterMsgBean.jdField_d_of_type_JavaLangString)) {
      this.jdField_d_of_type_JavaLangString = paramGameCenterMsgBean.jdField_d_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramGameCenterMsgBean.f)) {
      this.f = paramGameCenterMsgBean.f;
    }
    if (!TextUtils.isEmpty(paramGameCenterMsgBean.g)) {
      this.g = paramGameCenterMsgBean.g;
    }
    if (!TextUtils.isEmpty(paramGameCenterMsgBean.e)) {
      this.e = paramGameCenterMsgBean.e;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.config.GameCenterMsgBean
 * JD-Core Version:    0.7.0.1
 */