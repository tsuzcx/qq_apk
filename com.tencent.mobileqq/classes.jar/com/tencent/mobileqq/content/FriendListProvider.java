package com.tencent.mobileqq.content;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.net.Uri;
import mqq.app.AppContentProvider;

public class FriendListProvider
  extends AppContentProvider
  implements FriendList
{
  private final UriMatcher a = new UriMatcher(-1);
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }
  
  public boolean onCreate()
  {
    super.onCreate();
    this.a.addURI("qq.friendlist", "group/#", 1000);
    this.a.addURI("qq.friendlist", "friendlist/#", 1001);
    this.a.addURI("qq.friendlist", "trooplist/#", 1002);
    this.a.addURI("qq.friendlist", "troopmemberinfo/#/#/#", 1003);
    this.a.addURI("qq.friendlist", "troopname/#/#", 1004);
    this.a.addURI("qq.friendlist", "discussinfo/#/#", 1005);
    this.a.addURI("qq.friendlist", "discussmenberinfo/#/#/#", 1006);
    this.a.addURI("qq.friendlist", "individuationUserData/#", 1007);
    return true;
  }
  
  /* Error */
  public android.database.Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 19	com/tencent/mobileqq/content/FriendListProvider:a	Landroid/content/UriMatcher;
    //   4: aload_1
    //   5: invokevirtual 60	android/content/UriMatcher:match	(Landroid/net/Uri;)I
    //   8: istore 6
    //   10: aload_1
    //   11: invokevirtual 66	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   14: iconst_1
    //   15: invokeinterface 72 2 0
    //   20: checkcast 74	java/lang/String
    //   23: astore 9
    //   25: aload_0
    //   26: aload 9
    //   28: invokevirtual 78	com/tencent/mobileqq/content/FriendListProvider:getRuntime	(Ljava/lang/String;)Lmqq/app/AppRuntime;
    //   31: astore 10
    //   33: new 80	com/tencent/mobileqq/content/ProviderAppRuntimeProxy
    //   36: dup
    //   37: invokespecial 81	com/tencent/mobileqq/content/ProviderAppRuntimeProxy:<init>	()V
    //   40: aload 10
    //   42: aload 9
    //   44: iconst_1
    //   45: invokevirtual 84	com/tencent/mobileqq/content/ProviderAppRuntimeProxy:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Z)Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   48: astore 13
    //   50: aconst_null
    //   51: astore 12
    //   53: aconst_null
    //   54: astore 9
    //   56: aconst_null
    //   57: astore 10
    //   59: aconst_null
    //   60: astore 11
    //   62: aload 13
    //   64: ifnonnull +36 -> 100
    //   67: new 86	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   74: astore_2
    //   75: aload_2
    //   76: ldc 89
    //   78: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload_2
    //   83: aload_1
    //   84: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: ldc 98
    //   90: iconst_1
    //   91: aload_2
    //   92: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 108	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: aconst_null
    //   99: areturn
    //   100: iload 6
    //   102: tableswitch	default:+46 -> 148, 1000:+902->1004, 1001:+876->978, 1002:+821->923, 1003:+749->851, 1004:+677->779, 1005:+618->720, 1006:+490->592, 1007:+92->194
    //   149: lconst_1
    //   150: astore_2
    //   151: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq +906 -> 1060
    //   157: new 86	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   164: astore_2
    //   165: aload_2
    //   166: ldc 113
    //   168: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload_2
    //   173: aload_1
    //   174: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: ldc 98
    //   180: iconst_2
    //   181: aload_2
    //   182: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 108	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: aload 10
    //   190: astore_2
    //   191: goto +869 -> 1060
    //   194: invokestatic 119	android/os/SystemClock:uptimeMillis	()J
    //   197: lstore 7
    //   199: aload 12
    //   201: astore_2
    //   202: ldc 121
    //   204: invokevirtual 126	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   207: astore 5
    //   209: aload 12
    //   211: astore_2
    //   212: aload 13
    //   214: aload 5
    //   216: aconst_null
    //   217: aload_3
    //   218: aload 4
    //   220: ldc 128
    //   222: ldc 130
    //   224: invokevirtual 135	com/tencent/mobileqq/app/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   227: astore 4
    //   229: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   232: ifeq +35 -> 267
    //   235: new 86	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   242: astore_2
    //   243: aload_2
    //   244: ldc 137
    //   246: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload_2
    //   251: aload 4
    //   253: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: ldc 98
    //   259: iconst_2
    //   260: aload_2
    //   261: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   267: aload 11
    //   269: astore_2
    //   270: aload 4
    //   272: ifnull +175 -> 447
    //   275: aload 11
    //   277: astore_2
    //   278: aload 4
    //   280: invokeinterface 145 1 0
    //   285: ifeq +162 -> 447
    //   288: new 147	android/database/MatrixCursor
    //   291: dup
    //   292: iconst_2
    //   293: anewarray 74	java/lang/String
    //   296: dup
    //   297: iconst_0
    //   298: ldc 149
    //   300: aastore
    //   301: dup
    //   302: iconst_1
    //   303: ldc 151
    //   305: aastore
    //   306: invokespecial 154	android/database/MatrixCursor:<init>	([Ljava/lang/String;)V
    //   309: astore_2
    //   310: aload 4
    //   312: aload 4
    //   314: ldc 149
    //   316: invokeinterface 158 2 0
    //   321: invokeinterface 162 2 0
    //   326: astore_3
    //   327: aload 4
    //   329: aload 4
    //   331: ldc 151
    //   333: invokeinterface 158 2 0
    //   338: invokeinterface 162 2 0
    //   343: astore 5
    //   345: aload_2
    //   346: iconst_2
    //   347: anewarray 164	java/lang/Object
    //   350: dup
    //   351: iconst_0
    //   352: aload_3
    //   353: aastore
    //   354: dup
    //   355: iconst_1
    //   356: aload 5
    //   358: aastore
    //   359: invokevirtual 168	android/database/MatrixCursor:addRow	([Ljava/lang/Object;)V
    //   362: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   365: ifeq +75 -> 440
    //   368: new 86	java/lang/StringBuilder
    //   371: dup
    //   372: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   375: astore 9
    //   377: aload 9
    //   379: ldc 170
    //   381: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: aload 9
    //   387: aload 4
    //   389: invokeinterface 174 1 0
    //   394: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: aload 9
    //   400: ldc 179
    //   402: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: aload 9
    //   408: aload_3
    //   409: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: aload 9
    //   415: ldc 181
    //   417: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: pop
    //   421: aload 9
    //   423: aload 5
    //   425: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: ldc 98
    //   431: iconst_2
    //   432: aload 9
    //   434: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   440: goto +7 -> 447
    //   443: astore_3
    //   444: goto +32 -> 476
    //   447: aload_2
    //   448: astore_3
    //   449: aload 4
    //   451: ifnull +80 -> 531
    //   454: aload 4
    //   456: invokeinterface 184 1 0
    //   461: aload_2
    //   462: astore_3
    //   463: goto +68 -> 531
    //   466: astore_1
    //   467: aload 4
    //   469: astore_2
    //   470: goto +110 -> 580
    //   473: astore_3
    //   474: aconst_null
    //   475: astore_2
    //   476: aload_3
    //   477: astore 5
    //   479: aload 4
    //   481: astore_3
    //   482: aload_2
    //   483: astore 4
    //   485: goto +21 -> 506
    //   488: astore_2
    //   489: goto +8 -> 497
    //   492: astore_1
    //   493: goto +87 -> 580
    //   496: astore_2
    //   497: aconst_null
    //   498: astore 4
    //   500: aload 9
    //   502: astore_3
    //   503: aload_2
    //   504: astore 5
    //   506: aload_3
    //   507: astore_2
    //   508: ldc 98
    //   510: iconst_1
    //   511: ldc 186
    //   513: aload 5
    //   515: invokestatic 189	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   518: aload_3
    //   519: ifnull +9 -> 528
    //   522: aload_3
    //   523: invokeinterface 184 1 0
    //   528: aload 4
    //   530: astore_3
    //   531: aload_3
    //   532: astore_2
    //   533: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   536: ifeq +524 -> 1060
    //   539: new 86	java/lang/StringBuilder
    //   542: dup
    //   543: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   546: astore_2
    //   547: aload_2
    //   548: ldc 191
    //   550: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: pop
    //   554: aload_2
    //   555: invokestatic 119	android/os/SystemClock:uptimeMillis	()J
    //   558: lload 7
    //   560: lsub
    //   561: invokevirtual 194	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   564: pop
    //   565: ldc 98
    //   567: iconst_2
    //   568: aload_2
    //   569: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   572: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   575: aload_3
    //   576: astore_2
    //   577: goto +483 -> 1060
    //   580: aload_2
    //   581: ifnull +9 -> 590
    //   584: aload_2
    //   585: invokeinterface 184 1 0
    //   590: aload_1
    //   591: athrow
    //   592: aload_1
    //   593: invokevirtual 66	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   596: astore_3
    //   597: aload 10
    //   599: astore_2
    //   600: aload_3
    //   601: invokeinterface 197 1 0
    //   606: iconst_4
    //   607: if_icmplt +453 -> 1060
    //   610: ldc 199
    //   612: aload_3
    //   613: iconst_3
    //   614: invokeinterface 72 2 0
    //   619: invokevirtual 203	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   622: ifeq +44 -> 666
    //   625: aload 13
    //   627: new 205	com/tencent/mobileqq/data/DiscussionMemberInfo
    //   630: dup
    //   631: invokespecial 206	com/tencent/mobileqq/data/DiscussionMemberInfo:<init>	()V
    //   634: invokevirtual 209	com/tencent/mobileqq/data/DiscussionMemberInfo:getTableName	()Ljava/lang/String;
    //   637: aconst_null
    //   638: ldc 211
    //   640: iconst_1
    //   641: anewarray 74	java/lang/String
    //   644: dup
    //   645: iconst_0
    //   646: aload_3
    //   647: iconst_2
    //   648: invokeinterface 72 2 0
    //   653: checkcast 74	java/lang/String
    //   656: aastore
    //   657: aconst_null
    //   658: aconst_null
    //   659: invokevirtual 135	com/tencent/mobileqq/app/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   662: astore_2
    //   663: goto +397 -> 1060
    //   666: aload 13
    //   668: new 205	com/tencent/mobileqq/data/DiscussionMemberInfo
    //   671: dup
    //   672: invokespecial 206	com/tencent/mobileqq/data/DiscussionMemberInfo:<init>	()V
    //   675: invokevirtual 209	com/tencent/mobileqq/data/DiscussionMemberInfo:getTableName	()Ljava/lang/String;
    //   678: aconst_null
    //   679: ldc 213
    //   681: iconst_2
    //   682: anewarray 74	java/lang/String
    //   685: dup
    //   686: iconst_0
    //   687: aload_3
    //   688: iconst_2
    //   689: invokeinterface 72 2 0
    //   694: checkcast 74	java/lang/String
    //   697: aastore
    //   698: dup
    //   699: iconst_1
    //   700: aload_3
    //   701: iconst_3
    //   702: invokeinterface 72 2 0
    //   707: checkcast 74	java/lang/String
    //   710: aastore
    //   711: aconst_null
    //   712: aconst_null
    //   713: invokevirtual 135	com/tencent/mobileqq/app/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   716: astore_2
    //   717: goto +343 -> 1060
    //   720: aload_1
    //   721: invokevirtual 66	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   724: astore_3
    //   725: aload 10
    //   727: astore_2
    //   728: aload_3
    //   729: invokeinterface 197 1 0
    //   734: iconst_3
    //   735: if_icmplt +325 -> 1060
    //   738: aload 13
    //   740: new 215	com/tencent/mobileqq/data/DiscussionInfo
    //   743: dup
    //   744: invokespecial 216	com/tencent/mobileqq/data/DiscussionInfo:<init>	()V
    //   747: invokevirtual 217	com/tencent/mobileqq/data/DiscussionInfo:getTableName	()Ljava/lang/String;
    //   750: aconst_null
    //   751: ldc 219
    //   753: iconst_1
    //   754: anewarray 74	java/lang/String
    //   757: dup
    //   758: iconst_0
    //   759: aload_3
    //   760: iconst_2
    //   761: invokeinterface 72 2 0
    //   766: checkcast 74	java/lang/String
    //   769: aastore
    //   770: aconst_null
    //   771: aconst_null
    //   772: invokevirtual 135	com/tencent/mobileqq/app/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   775: astore_2
    //   776: goto +284 -> 1060
    //   779: aload_1
    //   780: invokevirtual 66	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   783: astore_3
    //   784: aload 10
    //   786: astore_2
    //   787: aload_3
    //   788: invokeinterface 197 1 0
    //   793: iconst_2
    //   794: if_icmplt +266 -> 1060
    //   797: new 221	com/tencent/mobileqq/data/troop/TroopInfo
    //   800: dup
    //   801: invokespecial 222	com/tencent/mobileqq/data/troop/TroopInfo:<init>	()V
    //   804: invokevirtual 223	com/tencent/mobileqq/data/troop/TroopInfo:getTableName	()Ljava/lang/String;
    //   807: astore_2
    //   808: aload_3
    //   809: iconst_2
    //   810: invokeinterface 72 2 0
    //   815: checkcast 74	java/lang/String
    //   818: astore_3
    //   819: aload 13
    //   821: aload_2
    //   822: iconst_1
    //   823: anewarray 74	java/lang/String
    //   826: dup
    //   827: iconst_0
    //   828: ldc 225
    //   830: aastore
    //   831: ldc 227
    //   833: iconst_1
    //   834: anewarray 74	java/lang/String
    //   837: dup
    //   838: iconst_0
    //   839: aload_3
    //   840: aastore
    //   841: aload 5
    //   843: aconst_null
    //   844: invokevirtual 135	com/tencent/mobileqq/app/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   847: astore_2
    //   848: goto +212 -> 1060
    //   851: aload_1
    //   852: invokevirtual 66	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   855: astore_3
    //   856: aload 10
    //   858: astore_2
    //   859: aload_3
    //   860: invokeinterface 197 1 0
    //   865: iconst_4
    //   866: if_icmplt +194 -> 1060
    //   869: aload 13
    //   871: new 229	com/tencent/mobileqq/data/troop/TroopMemberInfo
    //   874: dup
    //   875: invokespecial 230	com/tencent/mobileqq/data/troop/TroopMemberInfo:<init>	()V
    //   878: invokevirtual 231	com/tencent/mobileqq/data/troop/TroopMemberInfo:getTableName	()Ljava/lang/String;
    //   881: aconst_null
    //   882: ldc 233
    //   884: iconst_2
    //   885: anewarray 74	java/lang/String
    //   888: dup
    //   889: iconst_0
    //   890: aload_3
    //   891: iconst_2
    //   892: invokeinterface 72 2 0
    //   897: checkcast 74	java/lang/String
    //   900: aastore
    //   901: dup
    //   902: iconst_1
    //   903: aload_3
    //   904: iconst_3
    //   905: invokeinterface 72 2 0
    //   910: checkcast 74	java/lang/String
    //   913: aastore
    //   914: aconst_null
    //   915: aconst_null
    //   916: invokevirtual 135	com/tencent/mobileqq/app/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   919: astore_2
    //   920: goto +140 -> 1060
    //   923: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   926: ifeq +40 -> 966
    //   929: new 86	java/lang/StringBuilder
    //   932: dup
    //   933: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   936: astore_2
    //   937: aload_2
    //   938: aload_0
    //   939: invokevirtual 237	java/lang/Object:getClass	()Ljava/lang/Class;
    //   942: invokevirtual 240	java/lang/Class:getName	()Ljava/lang/String;
    //   945: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   948: pop
    //   949: aload_2
    //   950: ldc 242
    //   952: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   955: pop
    //   956: ldc 243
    //   958: iconst_2
    //   959: aload_2
    //   960: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   963: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   966: aload 13
    //   968: ldc 245
    //   970: aconst_null
    //   971: invokevirtual 249	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   974: astore_2
    //   975: goto +85 -> 1060
    //   978: aload 13
    //   980: new 251	com/tencent/mobileqq/data/Friends
    //   983: dup
    //   984: invokespecial 252	com/tencent/mobileqq/data/Friends:<init>	()V
    //   987: invokevirtual 253	com/tencent/mobileqq/data/Friends:getTableName	()Ljava/lang/String;
    //   990: aload_2
    //   991: aload_3
    //   992: aload 4
    //   994: aload 5
    //   996: aconst_null
    //   997: invokevirtual 135	com/tencent/mobileqq/app/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1000: astore_2
    //   1001: goto +59 -> 1060
    //   1004: aload 13
    //   1006: new 255	com/tencent/mobileqq/data/Groups
    //   1009: dup
    //   1010: invokespecial 256	com/tencent/mobileqq/data/Groups:<init>	()V
    //   1013: invokevirtual 257	com/tencent/mobileqq/data/Groups:getTableName	()Ljava/lang/String;
    //   1016: iconst_5
    //   1017: anewarray 74	java/lang/String
    //   1020: dup
    //   1021: iconst_0
    //   1022: ldc_w 259
    //   1025: aastore
    //   1026: dup
    //   1027: iconst_1
    //   1028: ldc_w 261
    //   1031: aastore
    //   1032: dup
    //   1033: iconst_2
    //   1034: ldc_w 263
    //   1037: aastore
    //   1038: dup
    //   1039: iconst_3
    //   1040: ldc_w 265
    //   1043: aastore
    //   1044: dup
    //   1045: iconst_4
    //   1046: ldc_w 267
    //   1049: aastore
    //   1050: aload_3
    //   1051: aload 4
    //   1053: aload 5
    //   1055: aconst_null
    //   1056: invokevirtual 135	com/tencent/mobileqq/app/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1059: astore_2
    //   1060: aload_2
    //   1061: ifnull +17 -> 1078
    //   1064: aload_2
    //   1065: aload_0
    //   1066: invokevirtual 271	com/tencent/mobileqq/content/FriendListProvider:getContext	()Landroid/content/Context;
    //   1069: invokevirtual 277	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   1072: aload_1
    //   1073: invokeinterface 281 3 0
    //   1078: aload_2
    //   1079: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1080	0	this	FriendListProvider
    //   0	1080	1	paramUri	Uri
    //   0	1080	2	paramArrayOfString1	String[]
    //   0	1080	3	paramString1	String
    //   0	1080	4	paramArrayOfString2	String[]
    //   0	1080	5	paramString2	String
    //   8	93	6	i	int
    //   197	362	7	l	long
    //   23	478	9	localObject1	java.lang.Object
    //   31	826	10	localAppRuntime	mqq.app.AppRuntime
    //   60	216	11	localObject2	java.lang.Object
    //   51	159	12	localObject3	java.lang.Object
    //   48	957	13	localSQLiteDatabase	com.tencent.mobileqq.app.SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   362	440	443	java/lang/Exception
    //   229	267	466	finally
    //   278	362	466	finally
    //   362	440	466	finally
    //   229	267	473	java/lang/Exception
    //   278	362	473	java/lang/Exception
    //   212	229	488	java/lang/Exception
    //   202	209	492	finally
    //   212	229	492	finally
    //   508	518	492	finally
    //   202	209	496	java/lang/Exception
  }
  
  /* Error */
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +49 -> 52
    //   6: new 86	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: ldc_w 285
    //   18: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_3
    //   23: aload_1
    //   24: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_3
    //   29: ldc_w 287
    //   32: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_3
    //   37: aload_2
    //   38: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: ldc 98
    //   44: iconst_2
    //   45: aload_3
    //   46: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aload_1
    //   53: ifnonnull +14 -> 67
    //   56: ldc 98
    //   58: iconst_1
    //   59: ldc_w 289
    //   62: invokestatic 108	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   65: iconst_0
    //   66: ireturn
    //   67: aload_1
    //   68: invokevirtual 66	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   71: iconst_1
    //   72: invokeinterface 72 2 0
    //   77: checkcast 74	java/lang/String
    //   80: astore_3
    //   81: aload_3
    //   82: invokestatic 295	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   85: ifeq +14 -> 99
    //   88: ldc 98
    //   90: iconst_1
    //   91: ldc_w 297
    //   94: invokestatic 108	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   97: iconst_0
    //   98: ireturn
    //   99: aload_0
    //   100: aload_3
    //   101: invokevirtual 78	com/tencent/mobileqq/content/FriendListProvider:getRuntime	(Ljava/lang/String;)Lmqq/app/AppRuntime;
    //   104: astore 4
    //   106: aload 4
    //   108: ifnonnull +14 -> 122
    //   111: ldc 98
    //   113: iconst_1
    //   114: ldc_w 299
    //   117: invokestatic 108	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: iconst_0
    //   121: ireturn
    //   122: new 80	com/tencent/mobileqq/content/ProviderAppRuntimeProxy
    //   125: dup
    //   126: invokespecial 81	com/tencent/mobileqq/content/ProviderAppRuntimeProxy:<init>	()V
    //   129: aload 4
    //   131: aload_3
    //   132: iconst_0
    //   133: invokevirtual 84	com/tencent/mobileqq/content/ProviderAppRuntimeProxy:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Z)Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   136: astore 4
    //   138: aload 4
    //   140: ifnonnull +14 -> 154
    //   143: ldc 98
    //   145: iconst_1
    //   146: ldc_w 301
    //   149: invokestatic 108	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: iconst_0
    //   153: ireturn
    //   154: aload_0
    //   155: getfield 19	com/tencent/mobileqq/content/FriendListProvider:a	Landroid/content/UriMatcher;
    //   158: aload_1
    //   159: invokevirtual 60	android/content/UriMatcher:match	(Landroid/net/Uri;)I
    //   162: sipush 1007
    //   165: if_icmpeq +5 -> 170
    //   168: iconst_0
    //   169: ireturn
    //   170: invokestatic 119	android/os/SystemClock:uptimeMillis	()J
    //   173: lstore 6
    //   175: ldc 121
    //   177: invokevirtual 126	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   180: astore 11
    //   182: aload 4
    //   184: aload 11
    //   186: invokevirtual 305	com/tencent/mobileqq/app/SQLiteDatabase:containsTable	(Ljava/lang/String;)Z
    //   189: ifne +75 -> 264
    //   192: aload 4
    //   194: new 121	com/tencent/mobileqq/vas/VasKeyValue
    //   197: dup
    //   198: invokespecial 306	com/tencent/mobileqq/vas/VasKeyValue:<init>	()V
    //   201: invokestatic 312	com/tencent/mobileqq/persistence/TableBuilder:createSQLStatement	(Lcom/tencent/mobileqq/persistence/Entity;)Ljava/lang/String;
    //   204: invokevirtual 315	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   207: istore 10
    //   209: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   212: ifeq +36 -> 248
    //   215: new 86	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   222: astore_1
    //   223: aload_1
    //   224: ldc_w 317
    //   227: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload_1
    //   232: iload 10
    //   234: invokevirtual 320	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: ldc 98
    //   240: iconst_2
    //   241: aload_1
    //   242: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   248: iload 10
    //   250: ifne +14 -> 264
    //   253: ldc 98
    //   255: iconst_1
    //   256: ldc_w 322
    //   259: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: iconst_0
    //   263: ireturn
    //   264: aload_2
    //   265: ldc 149
    //   267: invokevirtual 328	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   270: astore 12
    //   272: aload_2
    //   273: ldc 151
    //   275: invokevirtual 328	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   278: astore_1
    //   279: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   282: ifeq +50 -> 332
    //   285: new 86	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   292: astore_3
    //   293: aload_3
    //   294: ldc_w 330
    //   297: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload_3
    //   302: aload 12
    //   304: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload_3
    //   309: ldc_w 332
    //   312: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload_3
    //   317: aload_1
    //   318: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: ldc 98
    //   324: iconst_2
    //   325: aload_3
    //   326: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   332: aload 12
    //   334: invokestatic 295	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   337: ifeq +14 -> 351
    //   340: ldc 98
    //   342: iconst_1
    //   343: ldc_w 334
    //   346: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   349: iconst_0
    //   350: ireturn
    //   351: aconst_null
    //   352: astore_1
    //   353: aconst_null
    //   354: astore_1
    //   355: aload 4
    //   357: aload 11
    //   359: aconst_null
    //   360: ldc_w 336
    //   363: iconst_1
    //   364: anewarray 74	java/lang/String
    //   367: dup
    //   368: iconst_0
    //   369: aload 12
    //   371: aastore
    //   372: aconst_null
    //   373: aconst_null
    //   374: invokevirtual 135	com/tencent/mobileqq/app/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   377: astore_3
    //   378: aload_3
    //   379: ifnull +269 -> 648
    //   382: aload_3
    //   383: astore_1
    //   384: aload_3
    //   385: invokeinterface 174 1 0
    //   390: ifle +258 -> 648
    //   393: aload_3
    //   394: astore_1
    //   395: aload_3
    //   396: invokeinterface 145 1 0
    //   401: ifeq +247 -> 648
    //   404: aload_3
    //   405: astore_1
    //   406: aload_3
    //   407: aload_3
    //   408: ldc 149
    //   410: invokeinterface 158 2 0
    //   415: invokeinterface 162 2 0
    //   420: astore 13
    //   422: aload_3
    //   423: astore_1
    //   424: aload_3
    //   425: aload_3
    //   426: ldc 151
    //   428: invokeinterface 158 2 0
    //   433: invokeinterface 162 2 0
    //   438: astore 14
    //   440: aload_3
    //   441: astore_1
    //   442: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   445: ifeq +94 -> 539
    //   448: aload_3
    //   449: astore_1
    //   450: new 86	java/lang/StringBuilder
    //   453: dup
    //   454: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   457: astore 15
    //   459: aload_3
    //   460: astore_1
    //   461: aload 15
    //   463: ldc_w 338
    //   466: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: aload_3
    //   471: astore_1
    //   472: aload 15
    //   474: aload 13
    //   476: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: pop
    //   480: aload_3
    //   481: astore_1
    //   482: aload 15
    //   484: ldc_w 340
    //   487: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: pop
    //   491: aload_3
    //   492: astore_1
    //   493: aload 15
    //   495: aload 14
    //   497: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: aload_3
    //   502: astore_1
    //   503: aload 15
    //   505: ldc_w 342
    //   508: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: pop
    //   512: aload_3
    //   513: astore_1
    //   514: aload 15
    //   516: aload_3
    //   517: invokeinterface 174 1 0
    //   522: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   525: pop
    //   526: aload_3
    //   527: astore_1
    //   528: ldc 98
    //   530: iconst_2
    //   531: aload 15
    //   533: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   536: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   539: aload_3
    //   540: astore_1
    //   541: aload 4
    //   543: aload 11
    //   545: aload_2
    //   546: ldc_w 336
    //   549: iconst_1
    //   550: anewarray 74	java/lang/String
    //   553: dup
    //   554: iconst_0
    //   555: aload 12
    //   557: aastore
    //   558: invokevirtual 345	com/tencent/mobileqq/app/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   561: istore 5
    //   563: aload_3
    //   564: astore_1
    //   565: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   568: ifeq +67 -> 635
    //   571: aload_3
    //   572: astore_1
    //   573: new 86	java/lang/StringBuilder
    //   576: dup
    //   577: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   580: astore_2
    //   581: aload_3
    //   582: astore_1
    //   583: aload_2
    //   584: ldc_w 347
    //   587: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: pop
    //   591: aload_3
    //   592: astore_1
    //   593: aload_2
    //   594: iload 5
    //   596: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   599: pop
    //   600: aload_3
    //   601: astore_1
    //   602: aload_2
    //   603: ldc_w 349
    //   606: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: pop
    //   610: aload_3
    //   611: astore_1
    //   612: aload_2
    //   613: invokestatic 119	android/os/SystemClock:uptimeMillis	()J
    //   616: lload 6
    //   618: lsub
    //   619: invokevirtual 194	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   622: pop
    //   623: aload_3
    //   624: astore_1
    //   625: ldc 98
    //   627: iconst_2
    //   628: aload_2
    //   629: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   632: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   635: aload_3
    //   636: ifnull +9 -> 645
    //   639: aload_3
    //   640: invokeinterface 184 1 0
    //   645: iload 5
    //   647: ireturn
    //   648: aload_3
    //   649: astore_1
    //   650: aload 4
    //   652: aload 11
    //   654: aconst_null
    //   655: aload_2
    //   656: invokevirtual 352	com/tencent/mobileqq/app/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   659: lstore 8
    //   661: aload_3
    //   662: astore_1
    //   663: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   666: ifeq +67 -> 733
    //   669: aload_3
    //   670: astore_1
    //   671: new 86	java/lang/StringBuilder
    //   674: dup
    //   675: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   678: astore_2
    //   679: aload_3
    //   680: astore_1
    //   681: aload_2
    //   682: ldc_w 354
    //   685: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: pop
    //   689: aload_3
    //   690: astore_1
    //   691: aload_2
    //   692: lload 8
    //   694: invokevirtual 194	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   697: pop
    //   698: aload_3
    //   699: astore_1
    //   700: aload_2
    //   701: ldc_w 349
    //   704: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: pop
    //   708: aload_3
    //   709: astore_1
    //   710: aload_2
    //   711: invokestatic 119	android/os/SystemClock:uptimeMillis	()J
    //   714: lload 6
    //   716: lsub
    //   717: invokevirtual 194	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   720: pop
    //   721: aload_3
    //   722: astore_1
    //   723: ldc 98
    //   725: iconst_2
    //   726: aload_2
    //   727: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   730: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   733: lload 8
    //   735: ldc2_w 355
    //   738: lcmp
    //   739: ifeq +9 -> 748
    //   742: iconst_1
    //   743: istore 5
    //   745: goto +6 -> 751
    //   748: iconst_0
    //   749: istore 5
    //   751: aload_3
    //   752: ifnull +9 -> 761
    //   755: aload_3
    //   756: invokeinterface 184 1 0
    //   761: iload 5
    //   763: ireturn
    //   764: astore 4
    //   766: aload_3
    //   767: astore_2
    //   768: goto +21 -> 789
    //   771: astore_1
    //   772: aconst_null
    //   773: astore_2
    //   774: goto +46 -> 820
    //   777: astore 4
    //   779: aconst_null
    //   780: astore_2
    //   781: goto +8 -> 789
    //   784: astore_1
    //   785: goto +35 -> 820
    //   788: astore_1
    //   789: aload_2
    //   790: astore_1
    //   791: ldc 98
    //   793: iconst_1
    //   794: ldc_w 358
    //   797: aload 4
    //   799: invokestatic 189	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   802: aload_2
    //   803: ifnull -635 -> 168
    //   806: aload_2
    //   807: invokeinterface 184 1 0
    //   812: goto -644 -> 168
    //   815: astore_3
    //   816: aload_1
    //   817: astore_2
    //   818: aload_3
    //   819: astore_1
    //   820: aload_2
    //   821: ifnull +9 -> 830
    //   824: aload_2
    //   825: invokeinterface 184 1 0
    //   830: goto +5 -> 835
    //   833: aload_1
    //   834: athrow
    //   835: goto -2 -> 833
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	838	0	this	FriendListProvider
    //   0	838	1	paramUri	Uri
    //   0	838	2	paramContentValues	ContentValues
    //   0	838	3	paramString	String
    //   0	838	4	paramArrayOfString	String[]
    //   561	201	5	i	int
    //   173	542	6	l1	long
    //   659	75	8	l2	long
    //   207	42	10	bool	boolean
    //   180	473	11	str1	String
    //   270	286	12	str2	String
    //   420	55	13	str3	String
    //   438	58	14	str4	String
    //   457	75	15	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   384	393	764	java/lang/Exception
    //   395	404	764	java/lang/Exception
    //   406	422	764	java/lang/Exception
    //   424	440	764	java/lang/Exception
    //   442	448	764	java/lang/Exception
    //   450	459	764	java/lang/Exception
    //   461	470	764	java/lang/Exception
    //   472	480	764	java/lang/Exception
    //   482	491	764	java/lang/Exception
    //   493	501	764	java/lang/Exception
    //   503	512	764	java/lang/Exception
    //   514	526	764	java/lang/Exception
    //   528	539	764	java/lang/Exception
    //   541	563	764	java/lang/Exception
    //   565	571	764	java/lang/Exception
    //   573	581	764	java/lang/Exception
    //   583	591	764	java/lang/Exception
    //   593	600	764	java/lang/Exception
    //   602	610	764	java/lang/Exception
    //   612	623	764	java/lang/Exception
    //   625	635	764	java/lang/Exception
    //   650	661	764	java/lang/Exception
    //   663	669	764	java/lang/Exception
    //   671	679	764	java/lang/Exception
    //   681	689	764	java/lang/Exception
    //   691	698	764	java/lang/Exception
    //   700	708	764	java/lang/Exception
    //   710	721	764	java/lang/Exception
    //   723	733	764	java/lang/Exception
    //   355	378	771	finally
    //   355	378	777	java/lang/Exception
    //   384	393	815	finally
    //   395	404	815	finally
    //   406	422	815	finally
    //   424	440	815	finally
    //   442	448	815	finally
    //   450	459	815	finally
    //   461	470	815	finally
    //   472	480	815	finally
    //   482	491	815	finally
    //   493	501	815	finally
    //   503	512	815	finally
    //   514	526	815	finally
    //   528	539	815	finally
    //   541	563	815	finally
    //   565	571	815	finally
    //   573	581	815	finally
    //   583	591	815	finally
    //   593	600	815	finally
    //   602	610	815	finally
    //   612	623	815	finally
    //   625	635	815	finally
    //   650	661	815	finally
    //   663	669	815	finally
    //   671	679	815	finally
    //   681	689	815	finally
    //   691	698	815	finally
    //   700	708	815	finally
    //   710	721	815	finally
    //   723	733	815	finally
    //   791	802	815	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.content.FriendListProvider
 * JD-Core Version:    0.7.0.1
 */