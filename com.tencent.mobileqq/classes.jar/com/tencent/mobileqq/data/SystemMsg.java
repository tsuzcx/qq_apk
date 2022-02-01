package com.tencent.mobileqq.data;

import bcsa;
import bhvd;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public class SystemMsg
  extends JceStruct
{
  private static final String TAG = "Q.systemmsg.SystemMsg";
  public String append;
  public byte[] auth;
  public int cVession;
  public String inviteMemUin;
  public long lToMobile;
  public String managerUin;
  public String message;
  public byte op;
  public String requestUin;
  public String sMsg;
  public String strAddressBookNickName;
  public String strGameName = "";
  public String strGroupName;
  public String strGroupNickName;
  public long strGroupUin;
  public String strNickName;
  public String strServerFromUinNickName = "";
  public String troopCode;
  public byte troopType;
  public int wSourceID;
  public int wSourceSubID;
  
  /* Error */
  public static SystemMsg decode(com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 6
    //   6: iconst_0
    //   7: istore 7
    //   9: iconst_0
    //   10: istore 8
    //   12: iconst_0
    //   13: istore 4
    //   15: aload_1
    //   16: ifnull +4536 -> 4552
    //   19: iload_3
    //   20: invokestatic 54	com/tencent/mobileqq/data/SystemMsg:isTroopSystemMessage	(I)Z
    //   23: ifeq +2467 -> 2490
    //   26: aload_1
    //   27: invokestatic 60	bhml:a	(Ljava/lang/String;)[B
    //   30: astore_2
    //   31: new 2	com/tencent/mobileqq/data/SystemMsg
    //   34: dup
    //   35: invokespecial 61	com/tencent/mobileqq/data/SystemMsg:<init>	()V
    //   38: astore_1
    //   39: aload_1
    //   40: astore 9
    //   42: aload_1
    //   43: astore 10
    //   45: aload_1
    //   46: aload_2
    //   47: invokestatic 65	com/tencent/mobileqq/data/SystemMsg:getTroopCodeFromTroopSysMsg	([B)Ljava/lang/String;
    //   50: putfield 67	com/tencent/mobileqq/data/SystemMsg:troopCode	Ljava/lang/String;
    //   53: aload_1
    //   54: astore 9
    //   56: aload_1
    //   57: astore 10
    //   59: aload_1
    //   60: aload_2
    //   61: invokestatic 71	com/tencent/mobileqq/data/SystemMsg:getTroopTypeFromTroopSysMsg	([B)B
    //   64: putfield 73	com/tencent/mobileqq/data/SystemMsg:troopType	B
    //   67: aload_1
    //   68: astore 9
    //   70: aload_1
    //   71: astore 10
    //   73: aload_1
    //   74: aload_2
    //   75: iload_3
    //   76: invokestatic 77	com/tencent/mobileqq/data/SystemMsg:getManagerUinFromTroopSysMsg	([BI)Ljava/lang/String;
    //   79: putfield 79	com/tencent/mobileqq/data/SystemMsg:managerUin	Ljava/lang/String;
    //   82: aload_1
    //   83: astore 9
    //   85: aload_1
    //   86: astore 10
    //   88: aload_1
    //   89: aload_2
    //   90: iload_3
    //   91: invokestatic 82	com/tencent/mobileqq/data/SystemMsg:getStrMsgFromTroopSysMsg	([BI)Ljava/lang/String;
    //   94: putfield 84	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   97: aload_1
    //   98: astore 9
    //   100: aload_1
    //   101: astore 10
    //   103: aload_1
    //   104: aload_2
    //   105: iload_3
    //   106: invokestatic 88	com/tencent/mobileqq/data/SystemMsg:getTroopOpFromTroopSysMsg	([BI)B
    //   109: putfield 90	com/tencent/mobileqq/data/SystemMsg:op	B
    //   112: aload_1
    //   113: astore 9
    //   115: aload_1
    //   116: astore 10
    //   118: aload_1
    //   119: aload_2
    //   120: iload_3
    //   121: invokestatic 93	com/tencent/mobileqq/data/SystemMsg:getRequestUinFromTroopSysMsg	([BI)Ljava/lang/String;
    //   124: putfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   127: aload_1
    //   128: astore 9
    //   130: aload_1
    //   131: astore 10
    //   133: aload_1
    //   134: aload_2
    //   135: iload_3
    //   136: invokestatic 99	com/tencent/mobileqq/data/SystemMsg:getAuthFromTroopSysMsg	([BI)[B
    //   139: putfield 101	com/tencent/mobileqq/data/SystemMsg:auth	[B
    //   142: aload_1
    //   143: astore 9
    //   145: aload_1
    //   146: astore 10
    //   148: aload_1
    //   149: aload_2
    //   150: iload_3
    //   151: invokestatic 104	com/tencent/mobileqq/data/SystemMsg:getInviteUinFromTroopSysMsg	([BI)Ljava/lang/String;
    //   154: putfield 106	com/tencent/mobileqq/data/SystemMsg:inviteMemUin	Ljava/lang/String;
    //   157: aload_1
    //   158: astore 9
    //   160: aload_1
    //   161: astore 10
    //   163: aload_0
    //   164: aload_1
    //   165: getfield 67	com/tencent/mobileqq/data/SystemMsg:troopCode	Ljava/lang/String;
    //   168: iconst_1
    //   169: invokestatic 111	bhlg:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Z)Ljava/lang/String;
    //   172: astore_2
    //   173: aload_1
    //   174: astore 9
    //   176: aload_1
    //   177: astore 10
    //   179: aload_0
    //   180: aload_1
    //   181: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   184: iconst_1
    //   185: invokestatic 114	bhlg:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Z)Ljava/lang/String;
    //   188: astore 11
    //   190: aload_1
    //   191: astore 9
    //   193: aload_1
    //   194: astore 10
    //   196: aload_0
    //   197: aload_1
    //   198: getfield 79	com/tencent/mobileqq/data/SystemMsg:managerUin	Ljava/lang/String;
    //   201: iconst_1
    //   202: invokestatic 114	bhlg:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Z)Ljava/lang/String;
    //   205: astore 12
    //   207: aload_1
    //   208: astore 9
    //   210: aload_1
    //   211: astore 10
    //   213: aload_0
    //   214: aload_1
    //   215: getfield 106	com/tencent/mobileqq/data/SystemMsg:inviteMemUin	Ljava/lang/String;
    //   218: iconst_1
    //   219: invokestatic 114	bhlg:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Z)Ljava/lang/String;
    //   222: astore 13
    //   224: iload_3
    //   225: lookupswitch	default:+4329->4554, -1023:+824->1049, -1022:+247->472, -1021:+107->332, -1020:+443->668, 35:+443->668, 36:+107->332, 37:+247->472, 46:+824->1049, 84:+443->668, 85:+107->332, 86:+247->472, 87:+824->1049
    //   333: astore 9
    //   335: aload_1
    //   336: astore 10
    //   338: aload_1
    //   339: getfield 79	com/tencent/mobileqq/data/SystemMsg:managerUin	Ljava/lang/String;
    //   342: ifnull +74 -> 416
    //   345: aload_1
    //   346: astore 9
    //   348: aload_1
    //   349: astore 10
    //   351: aload_1
    //   352: getfield 79	com/tencent/mobileqq/data/SystemMsg:managerUin	Ljava/lang/String;
    //   355: aload 12
    //   357: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   360: ifne +56 -> 416
    //   363: aload_1
    //   364: astore 9
    //   366: aload_1
    //   367: astore 10
    //   369: aload_1
    //   370: new 122	java/lang/StringBuilder
    //   373: dup
    //   374: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   377: aload 12
    //   379: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: ldc 128
    //   384: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   390: ldc 135
    //   392: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   395: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: putfield 145	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   404: aload_1
    //   405: areturn
    //   406: astore_1
    //   407: aload 9
    //   409: astore_0
    //   410: aload_1
    //   411: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   414: aload_0
    //   415: areturn
    //   416: aload_1
    //   417: astore 9
    //   419: aload_1
    //   420: astore 10
    //   422: aload_1
    //   423: new 122	java/lang/StringBuilder
    //   426: dup
    //   427: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   430: ldc 150
    //   432: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aload 12
    //   437: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: ldc 152
    //   442: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   448: ldc 135
    //   450: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   453: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: putfield 145	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   462: aload_1
    //   463: areturn
    //   464: astore_0
    //   465: aload_0
    //   466: invokevirtual 153	java/lang/Exception:printStackTrace	()V
    //   469: aload 10
    //   471: areturn
    //   472: aload_1
    //   473: astore 9
    //   475: aload_1
    //   476: astore 10
    //   478: aload_1
    //   479: getfield 84	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   482: ifnull +24 -> 506
    //   485: aload_1
    //   486: astore 9
    //   488: aload_1
    //   489: astore 10
    //   491: ldc 39
    //   493: aload_1
    //   494: getfield 84	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   497: invokevirtual 156	java/lang/String:trim	()Ljava/lang/String;
    //   500: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   503: ifeq +103 -> 606
    //   506: aload_1
    //   507: astore 9
    //   509: aload_1
    //   510: astore 10
    //   512: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   515: ldc 157
    //   517: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   520: astore_0
    //   521: aload_1
    //   522: astore 9
    //   524: aload_1
    //   525: astore 10
    //   527: aload_1
    //   528: aload_0
    //   529: putfield 84	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   532: aload_1
    //   533: astore 9
    //   535: aload_1
    //   536: astore 10
    //   538: aload_1
    //   539: getfield 79	com/tencent/mobileqq/data/SystemMsg:managerUin	Ljava/lang/String;
    //   542: ifnull +78 -> 620
    //   545: aload_1
    //   546: astore 9
    //   548: aload_1
    //   549: astore 10
    //   551: aload_1
    //   552: getfield 79	com/tencent/mobileqq/data/SystemMsg:managerUin	Ljava/lang/String;
    //   555: aload 12
    //   557: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   560: ifne +60 -> 620
    //   563: aload_1
    //   564: astore 9
    //   566: aload_1
    //   567: astore 10
    //   569: aload_1
    //   570: new 122	java/lang/StringBuilder
    //   573: dup
    //   574: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   577: aload 12
    //   579: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: ldc 128
    //   584: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   590: ldc 158
    //   592: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   595: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   601: putfield 145	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   604: aload_1
    //   605: areturn
    //   606: aload_1
    //   607: astore 9
    //   609: aload_1
    //   610: astore 10
    //   612: aload_1
    //   613: getfield 84	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   616: astore_0
    //   617: goto -96 -> 521
    //   620: aload_1
    //   621: astore 9
    //   623: aload_1
    //   624: astore 10
    //   626: aload_1
    //   627: new 122	java/lang/StringBuilder
    //   630: dup
    //   631: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   634: ldc 150
    //   636: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: aload 12
    //   641: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: ldc 152
    //   646: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   652: ldc 158
    //   654: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   657: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   663: putfield 145	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   666: aload_1
    //   667: areturn
    //   668: aload_1
    //   669: astore 9
    //   671: aload_1
    //   672: astore 10
    //   674: aload_1
    //   675: getfield 84	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   678: ifnull +21 -> 699
    //   681: aload_1
    //   682: astore 9
    //   684: aload_1
    //   685: astore 10
    //   687: ldc 39
    //   689: aload_1
    //   690: getfield 84	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   693: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   696: ifeq +137 -> 833
    //   699: aload_1
    //   700: astore 9
    //   702: aload_1
    //   703: astore 10
    //   705: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   708: ldc 157
    //   710: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   713: astore_0
    //   714: aload_1
    //   715: astore 9
    //   717: aload_1
    //   718: astore 10
    //   720: aload_1
    //   721: aload_0
    //   722: putfield 84	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   725: aload_1
    //   726: astore 9
    //   728: aload_1
    //   729: astore 10
    //   731: aload_1
    //   732: getfield 67	com/tencent/mobileqq/data/SystemMsg:troopCode	Ljava/lang/String;
    //   735: ifnull +164 -> 899
    //   738: aload_1
    //   739: astore 9
    //   741: aload_1
    //   742: astore 10
    //   744: aload_1
    //   745: getfield 67	com/tencent/mobileqq/data/SystemMsg:troopCode	Ljava/lang/String;
    //   748: aload_2
    //   749: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   752: ifne +147 -> 899
    //   755: aload_1
    //   756: astore 9
    //   758: aload_1
    //   759: astore 10
    //   761: aload_1
    //   762: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   765: ifnull +82 -> 847
    //   768: aload_1
    //   769: astore 9
    //   771: aload_1
    //   772: astore 10
    //   774: aload_1
    //   775: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   778: aload 11
    //   780: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   783: ifne +64 -> 847
    //   786: aload_1
    //   787: astore 9
    //   789: aload_1
    //   790: astore 10
    //   792: aload_1
    //   793: new 122	java/lang/StringBuilder
    //   796: dup
    //   797: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   800: aload 11
    //   802: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   805: ldc 128
    //   807: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   810: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   813: ldc 159
    //   815: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   818: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   821: aload_2
    //   822: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   828: putfield 145	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   831: aload_1
    //   832: areturn
    //   833: aload_1
    //   834: astore 9
    //   836: aload_1
    //   837: astore 10
    //   839: aload_1
    //   840: getfield 84	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   843: astore_0
    //   844: goto -130 -> 714
    //   847: aload_1
    //   848: astore 9
    //   850: aload_1
    //   851: astore 10
    //   853: aload_1
    //   854: new 122	java/lang/StringBuilder
    //   857: dup
    //   858: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   861: ldc 150
    //   863: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   866: aload 11
    //   868: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: ldc 152
    //   873: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   876: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   879: ldc 159
    //   881: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   884: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   887: aload_2
    //   888: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   891: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   894: putfield 145	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   897: aload_1
    //   898: areturn
    //   899: aload_1
    //   900: astore 9
    //   902: aload_1
    //   903: astore 10
    //   905: aload_1
    //   906: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   909: ifnull +78 -> 987
    //   912: aload_1
    //   913: astore 9
    //   915: aload_1
    //   916: astore 10
    //   918: aload_1
    //   919: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   922: aload 11
    //   924: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   927: ifne +60 -> 987
    //   930: aload_1
    //   931: astore 9
    //   933: aload_1
    //   934: astore 10
    //   936: aload_1
    //   937: new 122	java/lang/StringBuilder
    //   940: dup
    //   941: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   944: aload 11
    //   946: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   949: ldc 128
    //   951: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   954: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   957: ldc 159
    //   959: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   962: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   965: ldc 150
    //   967: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   970: aload_2
    //   971: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   974: ldc 150
    //   976: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   979: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   982: putfield 145	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   985: aload_1
    //   986: areturn
    //   987: aload_1
    //   988: astore 9
    //   990: aload_1
    //   991: astore 10
    //   993: aload_1
    //   994: new 122	java/lang/StringBuilder
    //   997: dup
    //   998: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   1001: ldc 150
    //   1003: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1006: aload 11
    //   1008: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1011: ldc 152
    //   1013: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1016: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1019: ldc 159
    //   1021: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1024: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1027: ldc 150
    //   1029: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1032: aload_2
    //   1033: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1036: ldc 150
    //   1038: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1041: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1044: putfield 145	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   1047: aload_1
    //   1048: areturn
    //   1049: aload_1
    //   1050: astore 9
    //   1052: aload_1
    //   1053: astore 10
    //   1055: aload_1
    //   1056: getfield 84	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   1059: ifnull +21 -> 1080
    //   1062: aload_1
    //   1063: astore 9
    //   1065: aload_1
    //   1066: astore 10
    //   1068: ldc 39
    //   1070: aload_1
    //   1071: getfield 84	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   1074: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1077: ifeq +165 -> 1242
    //   1080: aload_1
    //   1081: astore 9
    //   1083: aload_1
    //   1084: astore 10
    //   1086: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1089: ldc 157
    //   1091: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1094: astore_0
    //   1095: aload_1
    //   1096: astore 9
    //   1098: aload_1
    //   1099: astore 10
    //   1101: aload_1
    //   1102: aload_0
    //   1103: putfield 84	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   1106: aload_1
    //   1107: astore 9
    //   1109: aload_1
    //   1110: astore 10
    //   1112: aload_1
    //   1113: getfield 90	com/tencent/mobileqq/data/SystemMsg:op	B
    //   1116: iconst_1
    //   1117: if_icmpeq +17 -> 1134
    //   1120: aload_1
    //   1121: astore 9
    //   1123: aload_1
    //   1124: astore 10
    //   1126: aload_1
    //   1127: getfield 90	com/tencent/mobileqq/data/SystemMsg:op	B
    //   1130: iconst_4
    //   1131: if_icmpne +327 -> 1458
    //   1134: aload_1
    //   1135: astore 9
    //   1137: aload_1
    //   1138: astore 10
    //   1140: aload_1
    //   1141: getfield 67	com/tencent/mobileqq/data/SystemMsg:troopCode	Ljava/lang/String;
    //   1144: ifnull +164 -> 1308
    //   1147: aload_1
    //   1148: astore 9
    //   1150: aload_1
    //   1151: astore 10
    //   1153: aload_1
    //   1154: getfield 67	com/tencent/mobileqq/data/SystemMsg:troopCode	Ljava/lang/String;
    //   1157: aload_2
    //   1158: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1161: ifne +147 -> 1308
    //   1164: aload_1
    //   1165: astore 9
    //   1167: aload_1
    //   1168: astore 10
    //   1170: aload_1
    //   1171: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   1174: ifnull +82 -> 1256
    //   1177: aload_1
    //   1178: astore 9
    //   1180: aload_1
    //   1181: astore 10
    //   1183: aload_1
    //   1184: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   1187: aload 11
    //   1189: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1192: ifne +64 -> 1256
    //   1195: aload_1
    //   1196: astore 9
    //   1198: aload_1
    //   1199: astore 10
    //   1201: aload_1
    //   1202: new 122	java/lang/StringBuilder
    //   1205: dup
    //   1206: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   1209: aload 11
    //   1211: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1214: ldc 128
    //   1216: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1219: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1222: ldc 160
    //   1224: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1227: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1230: aload_2
    //   1231: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1234: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1237: putfield 145	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   1240: aload_1
    //   1241: areturn
    //   1242: aload_1
    //   1243: astore 9
    //   1245: aload_1
    //   1246: astore 10
    //   1248: aload_1
    //   1249: getfield 84	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   1252: astore_0
    //   1253: goto -158 -> 1095
    //   1256: aload_1
    //   1257: astore 9
    //   1259: aload_1
    //   1260: astore 10
    //   1262: aload_1
    //   1263: new 122	java/lang/StringBuilder
    //   1266: dup
    //   1267: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   1270: ldc 150
    //   1272: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1275: aload 11
    //   1277: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1280: ldc 152
    //   1282: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1285: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1288: ldc 160
    //   1290: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1293: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1296: aload_2
    //   1297: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1300: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1303: putfield 145	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   1306: aload_1
    //   1307: areturn
    //   1308: aload_1
    //   1309: astore 9
    //   1311: aload_1
    //   1312: astore 10
    //   1314: aload_1
    //   1315: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   1318: ifnull +78 -> 1396
    //   1321: aload_1
    //   1322: astore 9
    //   1324: aload_1
    //   1325: astore 10
    //   1327: aload_1
    //   1328: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   1331: aload 11
    //   1333: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1336: ifne +60 -> 1396
    //   1339: aload_1
    //   1340: astore 9
    //   1342: aload_1
    //   1343: astore 10
    //   1345: aload_1
    //   1346: new 122	java/lang/StringBuilder
    //   1349: dup
    //   1350: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   1353: aload 11
    //   1355: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1358: ldc 128
    //   1360: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1363: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1366: ldc 160
    //   1368: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1371: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1374: ldc 150
    //   1376: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1379: aload_2
    //   1380: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1383: ldc 150
    //   1385: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1388: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1391: putfield 145	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   1394: aload_1
    //   1395: areturn
    //   1396: aload_1
    //   1397: astore 9
    //   1399: aload_1
    //   1400: astore 10
    //   1402: aload_1
    //   1403: new 122	java/lang/StringBuilder
    //   1406: dup
    //   1407: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   1410: ldc 150
    //   1412: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1415: aload 11
    //   1417: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1420: ldc 152
    //   1422: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1425: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1428: ldc 160
    //   1430: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1433: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1436: ldc 150
    //   1438: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1441: aload_2
    //   1442: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1445: ldc 150
    //   1447: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1450: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1453: putfield 145	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   1456: aload_1
    //   1457: areturn
    //   1458: aload_1
    //   1459: astore 9
    //   1461: aload_1
    //   1462: astore 10
    //   1464: aload_1
    //   1465: getfield 90	com/tencent/mobileqq/data/SystemMsg:op	B
    //   1468: iconst_2
    //   1469: if_icmpne +313 -> 1782
    //   1472: aload_1
    //   1473: astore 9
    //   1475: aload_1
    //   1476: astore 10
    //   1478: aload_1
    //   1479: getfield 67	com/tencent/mobileqq/data/SystemMsg:troopCode	Ljava/lang/String;
    //   1482: ifnull +150 -> 1632
    //   1485: aload_1
    //   1486: astore 9
    //   1488: aload_1
    //   1489: astore 10
    //   1491: aload_1
    //   1492: getfield 67	com/tencent/mobileqq/data/SystemMsg:troopCode	Ljava/lang/String;
    //   1495: aload_2
    //   1496: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1499: ifne +133 -> 1632
    //   1502: aload_1
    //   1503: astore 9
    //   1505: aload_1
    //   1506: astore 10
    //   1508: aload_1
    //   1509: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   1512: ifnull +68 -> 1580
    //   1515: aload_1
    //   1516: astore 9
    //   1518: aload_1
    //   1519: astore 10
    //   1521: aload_1
    //   1522: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   1525: aload 11
    //   1527: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1530: ifne +50 -> 1580
    //   1533: aload_1
    //   1534: astore 9
    //   1536: aload_1
    //   1537: astore 10
    //   1539: aload_1
    //   1540: new 122	java/lang/StringBuilder
    //   1543: dup
    //   1544: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   1547: aload 11
    //   1549: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1552: ldc 128
    //   1554: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1557: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1560: ldc 161
    //   1562: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1565: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1568: aload_2
    //   1569: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1572: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1575: putfield 145	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   1578: aload_1
    //   1579: areturn
    //   1580: aload_1
    //   1581: astore 9
    //   1583: aload_1
    //   1584: astore 10
    //   1586: aload_1
    //   1587: new 122	java/lang/StringBuilder
    //   1590: dup
    //   1591: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   1594: ldc 150
    //   1596: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1599: aload 11
    //   1601: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1604: ldc 152
    //   1606: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1609: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1612: ldc 161
    //   1614: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1617: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1620: aload_2
    //   1621: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1624: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1627: putfield 145	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   1630: aload_1
    //   1631: areturn
    //   1632: aload_1
    //   1633: astore 9
    //   1635: aload_1
    //   1636: astore 10
    //   1638: aload_1
    //   1639: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   1642: ifnull +78 -> 1720
    //   1645: aload_1
    //   1646: astore 9
    //   1648: aload_1
    //   1649: astore 10
    //   1651: aload_1
    //   1652: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   1655: aload 11
    //   1657: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1660: ifne +60 -> 1720
    //   1663: aload_1
    //   1664: astore 9
    //   1666: aload_1
    //   1667: astore 10
    //   1669: aload_1
    //   1670: new 122	java/lang/StringBuilder
    //   1673: dup
    //   1674: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   1677: aload 11
    //   1679: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1682: ldc 128
    //   1684: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1687: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1690: ldc 161
    //   1692: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1695: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1698: ldc 150
    //   1700: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1703: aload_2
    //   1704: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1707: ldc 150
    //   1709: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1712: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1715: putfield 145	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   1718: aload_1
    //   1719: areturn
    //   1720: aload_1
    //   1721: astore 9
    //   1723: aload_1
    //   1724: astore 10
    //   1726: aload_1
    //   1727: new 122	java/lang/StringBuilder
    //   1730: dup
    //   1731: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   1734: ldc 150
    //   1736: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1739: aload 11
    //   1741: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1744: ldc 152
    //   1746: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1749: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1752: ldc 161
    //   1754: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1757: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1760: ldc 150
    //   1762: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1765: aload_2
    //   1766: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1769: ldc 150
    //   1771: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1774: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1777: putfield 145	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   1780: aload_1
    //   1781: areturn
    //   1782: aload_1
    //   1783: astore 9
    //   1785: aload_1
    //   1786: astore 10
    //   1788: aload_1
    //   1789: getfield 90	com/tencent/mobileqq/data/SystemMsg:op	B
    //   1792: iconst_3
    //   1793: if_icmpne +313 -> 2106
    //   1796: aload_1
    //   1797: astore 9
    //   1799: aload_1
    //   1800: astore 10
    //   1802: aload_1
    //   1803: getfield 67	com/tencent/mobileqq/data/SystemMsg:troopCode	Ljava/lang/String;
    //   1806: ifnull +150 -> 1956
    //   1809: aload_1
    //   1810: astore 9
    //   1812: aload_1
    //   1813: astore 10
    //   1815: aload_1
    //   1816: getfield 67	com/tencent/mobileqq/data/SystemMsg:troopCode	Ljava/lang/String;
    //   1819: aload_2
    //   1820: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1823: ifne +133 -> 1956
    //   1826: aload_1
    //   1827: astore 9
    //   1829: aload_1
    //   1830: astore 10
    //   1832: aload_1
    //   1833: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   1836: ifnull +68 -> 1904
    //   1839: aload_1
    //   1840: astore 9
    //   1842: aload_1
    //   1843: astore 10
    //   1845: aload_1
    //   1846: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   1849: aload 11
    //   1851: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1854: ifne +50 -> 1904
    //   1857: aload_1
    //   1858: astore 9
    //   1860: aload_1
    //   1861: astore 10
    //   1863: aload_1
    //   1864: new 122	java/lang/StringBuilder
    //   1867: dup
    //   1868: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   1871: aload 11
    //   1873: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1876: ldc 128
    //   1878: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1881: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1884: ldc 162
    //   1886: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1889: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1892: aload_2
    //   1893: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1896: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1899: putfield 145	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   1902: aload_1
    //   1903: areturn
    //   1904: aload_1
    //   1905: astore 9
    //   1907: aload_1
    //   1908: astore 10
    //   1910: aload_1
    //   1911: new 122	java/lang/StringBuilder
    //   1914: dup
    //   1915: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   1918: ldc 150
    //   1920: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1923: aload 11
    //   1925: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1928: ldc 152
    //   1930: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1933: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1936: ldc 162
    //   1938: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1941: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1944: aload_2
    //   1945: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1948: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1951: putfield 145	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   1954: aload_1
    //   1955: areturn
    //   1956: aload_1
    //   1957: astore 9
    //   1959: aload_1
    //   1960: astore 10
    //   1962: aload_1
    //   1963: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   1966: ifnull +78 -> 2044
    //   1969: aload_1
    //   1970: astore 9
    //   1972: aload_1
    //   1973: astore 10
    //   1975: aload_1
    //   1976: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   1979: aload 11
    //   1981: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1984: ifne +60 -> 2044
    //   1987: aload_1
    //   1988: astore 9
    //   1990: aload_1
    //   1991: astore 10
    //   1993: aload_1
    //   1994: new 122	java/lang/StringBuilder
    //   1997: dup
    //   1998: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   2001: aload 11
    //   2003: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2006: ldc 128
    //   2008: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2011: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2014: ldc 162
    //   2016: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   2019: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2022: ldc 150
    //   2024: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2027: aload_2
    //   2028: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2031: ldc 150
    //   2033: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2036: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2039: putfield 145	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   2042: aload_1
    //   2043: areturn
    //   2044: aload_1
    //   2045: astore 9
    //   2047: aload_1
    //   2048: astore 10
    //   2050: aload_1
    //   2051: new 122	java/lang/StringBuilder
    //   2054: dup
    //   2055: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   2058: ldc 150
    //   2060: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2063: aload 11
    //   2065: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2068: ldc 152
    //   2070: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2073: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2076: ldc 162
    //   2078: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   2081: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2084: ldc 150
    //   2086: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2089: aload_2
    //   2090: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2093: ldc 150
    //   2095: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2098: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2101: putfield 145	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   2104: aload_1
    //   2105: areturn
    //   2106: aload_1
    //   2107: astore 9
    //   2109: aload_1
    //   2110: astore 10
    //   2112: aload_1
    //   2113: getfield 90	com/tencent/mobileqq/data/SystemMsg:op	B
    //   2116: iconst_5
    //   2117: if_icmpne +2437 -> 4554
    //   2120: aload_1
    //   2121: astore 9
    //   2123: aload_1
    //   2124: astore 10
    //   2126: aload_1
    //   2127: getfield 67	com/tencent/mobileqq/data/SystemMsg:troopCode	Ljava/lang/String;
    //   2130: ifnull +208 -> 2338
    //   2133: aload_1
    //   2134: astore 9
    //   2136: aload_1
    //   2137: astore 10
    //   2139: aload_1
    //   2140: getfield 67	com/tencent/mobileqq/data/SystemMsg:troopCode	Ljava/lang/String;
    //   2143: aload_2
    //   2144: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2147: ifne +191 -> 2338
    //   2150: aload_1
    //   2151: astore 9
    //   2153: aload_1
    //   2154: astore 10
    //   2156: aload_1
    //   2157: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   2160: ifnull +125 -> 2285
    //   2163: aload_1
    //   2164: astore 9
    //   2166: aload_1
    //   2167: astore 10
    //   2169: aload_1
    //   2170: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   2173: aload 11
    //   2175: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2178: ifne +107 -> 2285
    //   2181: aload_1
    //   2182: astore 9
    //   2184: aload_1
    //   2185: astore 10
    //   2187: aload_1
    //   2188: new 122	java/lang/StringBuilder
    //   2191: dup
    //   2192: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   2195: aload 11
    //   2197: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2200: ldc 128
    //   2202: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2205: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2208: ldc 159
    //   2210: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   2213: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2216: aload_2
    //   2217: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2220: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2223: putfield 145	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   2226: aload_1
    //   2227: astore 9
    //   2229: aload_1
    //   2230: astore 10
    //   2232: aload_1
    //   2233: new 122	java/lang/StringBuilder
    //   2236: dup
    //   2237: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   2240: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2243: ldc 163
    //   2245: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   2248: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2251: ldc 128
    //   2253: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2256: aload 13
    //   2258: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2261: ldc 128
    //   2263: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2266: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2269: ldc 164
    //   2271: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   2274: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2277: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2280: putfield 84	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   2283: aload_1
    //   2284: areturn
    //   2285: aload_1
    //   2286: astore 9
    //   2288: aload_1
    //   2289: astore 10
    //   2291: aload_1
    //   2292: new 122	java/lang/StringBuilder
    //   2295: dup
    //   2296: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   2299: ldc 150
    //   2301: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2304: aload 11
    //   2306: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2309: ldc 152
    //   2311: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2314: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2317: ldc 159
    //   2319: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   2322: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2325: aload_2
    //   2326: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2329: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2332: putfield 145	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   2335: goto -109 -> 2226
    //   2338: aload_1
    //   2339: astore 9
    //   2341: aload_1
    //   2342: astore 10
    //   2344: aload_1
    //   2345: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   2348: ifnull +79 -> 2427
    //   2351: aload_1
    //   2352: astore 9
    //   2354: aload_1
    //   2355: astore 10
    //   2357: aload_1
    //   2358: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   2361: aload 11
    //   2363: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2366: ifne +61 -> 2427
    //   2369: aload_1
    //   2370: astore 9
    //   2372: aload_1
    //   2373: astore 10
    //   2375: aload_1
    //   2376: new 122	java/lang/StringBuilder
    //   2379: dup
    //   2380: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   2383: aload 11
    //   2385: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2388: ldc 128
    //   2390: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2393: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2396: ldc 159
    //   2398: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   2401: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2404: ldc 150
    //   2406: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2409: aload_2
    //   2410: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2413: ldc 150
    //   2415: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2418: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2421: putfield 145	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   2424: goto -198 -> 2226
    //   2427: aload_1
    //   2428: astore 9
    //   2430: aload_1
    //   2431: astore 10
    //   2433: aload_1
    //   2434: new 122	java/lang/StringBuilder
    //   2437: dup
    //   2438: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   2441: ldc 150
    //   2443: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2446: aload 11
    //   2448: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2451: ldc 152
    //   2453: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2456: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2459: ldc 159
    //   2461: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   2464: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2467: ldc 150
    //   2469: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2472: aload_2
    //   2473: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2476: ldc 150
    //   2478: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2481: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2484: putfield 145	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   2487: goto -261 -> 2226
    //   2490: new 166	java/io/DataInputStream
    //   2493: dup
    //   2494: new 168	java/io/ByteArrayInputStream
    //   2497: dup
    //   2498: aload_1
    //   2499: invokestatic 60	bhml:a	(Ljava/lang/String;)[B
    //   2502: invokespecial 171	java/io/ByteArrayInputStream:<init>	([B)V
    //   2505: invokespecial 174	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   2508: astore 11
    //   2510: iload_3
    //   2511: lookupswitch	default:+2045->4556, -2004:+1973->4484, -2003:+1939->4450, -1010:+1520->4031, -1009:+1201->3712, -1008:+897->3408, -1007:+586->3097, -1006:+156->2667, 9:+1939->4450, 187:+156->2667, 188:+586->3097, 189:+897->3408, 190:+1201->3712, 191:+1520->4031, 513:+1973->4484
    //   2633: getstatic 178	antf:J	Ljava/lang/String;
    //   2636: invokestatic 182	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   2639: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2642: ifeq +1910 -> 4552
    //   2645: new 2	com/tencent/mobileqq/data/SystemMsg
    //   2648: dup
    //   2649: invokespecial 61	com/tencent/mobileqq/data/SystemMsg:<init>	()V
    //   2652: astore_0
    //   2653: aload_0
    //   2654: astore 9
    //   2656: aload_0
    //   2657: astore 10
    //   2659: aload_0
    //   2660: ldc 184
    //   2662: putfield 145	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   2665: aload_0
    //   2666: areturn
    //   2667: new 2	com/tencent/mobileqq/data/SystemMsg
    //   2670: dup
    //   2671: invokespecial 61	com/tencent/mobileqq/data/SystemMsg:<init>	()V
    //   2674: astore_0
    //   2675: aload_0
    //   2676: aload 11
    //   2678: invokevirtual 188	java/io/DataInputStream:readUnsignedByte	()I
    //   2681: putfield 190	com/tencent/mobileqq/data/SystemMsg:cVession	I
    //   2684: aload 11
    //   2686: invokevirtual 188	java/io/DataInputStream:readUnsignedByte	()I
    //   2689: newarray byte
    //   2691: astore_1
    //   2692: aload 11
    //   2694: aload_1
    //   2695: invokevirtual 194	java/io/DataInputStream:read	([B)I
    //   2698: pop
    //   2699: aload_0
    //   2700: new 116	java/lang/String
    //   2703: dup
    //   2704: aload_1
    //   2705: invokestatic 199	bcsa:a	([B)[B
    //   2708: ldc 201
    //   2710: invokespecial 204	java/lang/String:<init>	([BLjava/lang/String;)V
    //   2713: invokevirtual 156	java/lang/String:trim	()Ljava/lang/String;
    //   2716: putfield 84	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   2719: aload 11
    //   2721: lconst_1
    //   2722: invokevirtual 208	java/io/DataInputStream:skip	(J)J
    //   2725: pop2
    //   2726: aload_0
    //   2727: aload 11
    //   2729: invokevirtual 211	java/io/DataInputStream:readUnsignedShort	()I
    //   2732: putfield 213	com/tencent/mobileqq/data/SystemMsg:wSourceID	I
    //   2735: aload_0
    //   2736: aload 11
    //   2738: invokevirtual 211	java/io/DataInputStream:readUnsignedShort	()I
    //   2741: putfield 215	com/tencent/mobileqq/data/SystemMsg:wSourceSubID	I
    //   2744: aload 11
    //   2746: aload 11
    //   2748: invokevirtual 211	java/io/DataInputStream:readUnsignedShort	()I
    //   2751: i2l
    //   2752: invokevirtual 208	java/io/DataInputStream:skip	(J)J
    //   2755: pop2
    //   2756: aload 11
    //   2758: invokevirtual 211	java/io/DataInputStream:readUnsignedShort	()I
    //   2761: ifeq +1805 -> 4566
    //   2764: aload 11
    //   2766: invokevirtual 211	java/io/DataInputStream:readUnsignedShort	()I
    //   2769: istore_3
    //   2770: iload_3
    //   2771: newarray byte
    //   2773: astore_1
    //   2774: aload 11
    //   2776: aload_1
    //   2777: invokevirtual 194	java/io/DataInputStream:read	([B)I
    //   2780: pop
    //   2781: aload_1
    //   2782: arraylength
    //   2783: ifne +173 -> 2956
    //   2786: aload_0
    //   2787: new 122	java/lang/StringBuilder
    //   2790: dup
    //   2791: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   2794: ldc 150
    //   2796: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2799: aload_2
    //   2800: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2803: ldc 150
    //   2805: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2808: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2811: ldc 216
    //   2813: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   2816: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2819: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2822: putfield 145	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   2825: aload 11
    //   2827: ldc2_w 217
    //   2830: invokevirtual 208	java/io/DataInputStream:skip	(J)J
    //   2833: pop2
    //   2834: aload 11
    //   2836: aload 11
    //   2838: invokevirtual 211	java/io/DataInputStream:readUnsignedShort	()I
    //   2841: newarray byte
    //   2843: invokevirtual 194	java/io/DataInputStream:read	([B)I
    //   2846: pop
    //   2847: aload 11
    //   2849: invokevirtual 188	java/io/DataInputStream:readUnsignedByte	()I
    //   2852: pop
    //   2853: aload 11
    //   2855: invokevirtual 188	java/io/DataInputStream:readUnsignedByte	()I
    //   2858: istore 5
    //   2860: iload 4
    //   2862: istore_3
    //   2863: iload_3
    //   2864: iload 5
    //   2866: if_icmpge +229 -> 3095
    //   2869: aload 11
    //   2871: invokevirtual 222	java/io/DataInputStream:readShort	()S
    //   2874: istore 4
    //   2876: aload 11
    //   2878: invokevirtual 222	java/io/DataInputStream:readShort	()S
    //   2881: newarray byte
    //   2883: astore_1
    //   2884: aload 11
    //   2886: aload_1
    //   2887: invokevirtual 194	java/io/DataInputStream:read	([B)I
    //   2890: pop
    //   2891: iload 4
    //   2893: sipush 1000
    //   2896: if_icmpne +107 -> 3003
    //   2899: new 224	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo
    //   2902: dup
    //   2903: invokespecial 225	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo:<init>	()V
    //   2906: astore_2
    //   2907: aload_2
    //   2908: aload_1
    //   2909: invokevirtual 229	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2912: checkcast 224	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo
    //   2915: astore_1
    //   2916: aload_1
    //   2917: ifnull +1642 -> 4559
    //   2920: aload_0
    //   2921: aload_1
    //   2922: getfield 233	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo:str_group_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2925: invokevirtual 238	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2928: putfield 240	com/tencent/mobileqq/data/SystemMsg:strGroupName	Ljava/lang/String;
    //   2931: aload_0
    //   2932: aload_1
    //   2933: getfield 243	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo:str_group_nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2936: invokevirtual 238	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2939: putfield 245	com/tencent/mobileqq/data/SystemMsg:strGroupNickName	Ljava/lang/String;
    //   2942: aload_0
    //   2943: aload_1
    //   2944: getfield 249	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo:uint64_group_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   2947: invokevirtual 254	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   2950: putfield 256	com/tencent/mobileqq/data/SystemMsg:strGroupUin	J
    //   2953: goto +1606 -> 4559
    //   2956: aload_1
    //   2957: invokestatic 199	bcsa:a	([B)[B
    //   2960: pop
    //   2961: aload_0
    //   2962: new 122	java/lang/StringBuilder
    //   2965: dup
    //   2966: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   2969: ldc 150
    //   2971: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2974: aload_2
    //   2975: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2978: ldc 150
    //   2980: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2983: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2986: ldc 216
    //   2988: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   2991: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2994: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2997: putfield 145	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   3000: goto -175 -> 2825
    //   3003: iload 4
    //   3005: sipush 1001
    //   3008: if_icmpne +38 -> 3046
    //   3011: new 258	tencent/im/s2c/frdsysmsg/FrdSysMsg$TongXunLuNickInfo
    //   3014: dup
    //   3015: invokespecial 259	tencent/im/s2c/frdsysmsg/FrdSysMsg$TongXunLuNickInfo:<init>	()V
    //   3018: astore_2
    //   3019: aload_2
    //   3020: aload_1
    //   3021: invokevirtual 260	tencent/im/s2c/frdsysmsg/FrdSysMsg$TongXunLuNickInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3024: checkcast 258	tencent/im/s2c/frdsysmsg/FrdSysMsg$TongXunLuNickInfo
    //   3027: astore_1
    //   3028: aload_1
    //   3029: ifnull +1530 -> 4559
    //   3032: aload_0
    //   3033: aload_1
    //   3034: getfield 263	tencent/im/s2c/frdsysmsg/FrdSysMsg$TongXunLuNickInfo:str_tongxunlu_nickname	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3037: invokevirtual 238	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3040: putfield 265	com/tencent/mobileqq/data/SystemMsg:strAddressBookNickName	Ljava/lang/String;
    //   3043: goto +1516 -> 4559
    //   3046: iload 4
    //   3048: sipush 1002
    //   3051: if_icmpne +1508 -> 4559
    //   3054: new 267	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo
    //   3057: dup
    //   3058: invokespecial 268	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:<init>	()V
    //   3061: astore_2
    //   3062: aload_2
    //   3063: aload_1
    //   3064: invokevirtual 269	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3067: checkcast 267	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo
    //   3070: astore_1
    //   3071: aload_1
    //   3072: ifnull +1487 -> 4559
    //   3075: aload_0
    //   3076: aload_1
    //   3077: getfield 272	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:str_fromuin_nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3080: invokevirtual 238	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3083: putfield 41	com/tencent/mobileqq/data/SystemMsg:strServerFromUinNickName	Ljava/lang/String;
    //   3086: goto +1473 -> 4559
    //   3089: astore_1
    //   3090: aconst_null
    //   3091: astore_1
    //   3092: goto -21 -> 3071
    //   3095: aload_0
    //   3096: areturn
    //   3097: new 2	com/tencent/mobileqq/data/SystemMsg
    //   3100: dup
    //   3101: invokespecial 61	com/tencent/mobileqq/data/SystemMsg:<init>	()V
    //   3104: astore_0
    //   3105: aload_0
    //   3106: aload 11
    //   3108: invokevirtual 188	java/io/DataInputStream:readUnsignedByte	()I
    //   3111: putfield 190	com/tencent/mobileqq/data/SystemMsg:cVession	I
    //   3114: aload 11
    //   3116: invokevirtual 188	java/io/DataInputStream:readUnsignedByte	()I
    //   3119: pop
    //   3120: aload 11
    //   3122: invokevirtual 211	java/io/DataInputStream:readUnsignedShort	()I
    //   3125: ifeq +1478 -> 4603
    //   3128: aload 11
    //   3130: invokevirtual 211	java/io/DataInputStream:readUnsignedShort	()I
    //   3133: istore_3
    //   3134: iload_3
    //   3135: newarray byte
    //   3137: astore_1
    //   3138: aload 11
    //   3140: aload_1
    //   3141: invokevirtual 194	java/io/DataInputStream:read	([B)I
    //   3144: pop
    //   3145: aload_1
    //   3146: arraylength
    //   3147: ifne +146 -> 3293
    //   3150: aload_0
    //   3151: new 122	java/lang/StringBuilder
    //   3154: dup
    //   3155: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   3158: ldc 150
    //   3160: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3163: aload_2
    //   3164: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3167: ldc 150
    //   3169: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3172: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3175: ldc_w 273
    //   3178: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   3181: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3184: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3187: putfield 145	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   3190: aload 11
    //   3192: ldc2_w 217
    //   3195: invokevirtual 208	java/io/DataInputStream:skip	(J)J
    //   3198: pop2
    //   3199: aload 11
    //   3201: aload 11
    //   3203: invokevirtual 211	java/io/DataInputStream:readUnsignedShort	()I
    //   3206: newarray byte
    //   3208: invokevirtual 194	java/io/DataInputStream:read	([B)I
    //   3211: pop
    //   3212: aload 11
    //   3214: invokevirtual 188	java/io/DataInputStream:readUnsignedByte	()I
    //   3217: istore 4
    //   3219: iload 5
    //   3221: istore_3
    //   3222: iload_3
    //   3223: iload 4
    //   3225: if_icmpge +181 -> 3406
    //   3228: aload 11
    //   3230: invokevirtual 222	java/io/DataInputStream:readShort	()S
    //   3233: istore 5
    //   3235: aload 11
    //   3237: invokevirtual 222	java/io/DataInputStream:readShort	()S
    //   3240: newarray byte
    //   3242: astore_1
    //   3243: aload 11
    //   3245: aload_1
    //   3246: invokevirtual 194	java/io/DataInputStream:read	([B)I
    //   3249: pop
    //   3250: iload 5
    //   3252: sipush 1002
    //   3255: if_icmpne +93 -> 3348
    //   3258: new 267	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo
    //   3261: dup
    //   3262: invokespecial 268	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:<init>	()V
    //   3265: astore_2
    //   3266: aload_2
    //   3267: aload_1
    //   3268: invokevirtual 269	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3271: checkcast 267	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo
    //   3274: astore_1
    //   3275: aload_1
    //   3276: ifnull +1320 -> 4596
    //   3279: aload_0
    //   3280: aload_1
    //   3281: getfield 272	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:str_fromuin_nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3284: invokevirtual 238	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3287: putfield 41	com/tencent/mobileqq/data/SystemMsg:strServerFromUinNickName	Ljava/lang/String;
    //   3290: goto +1306 -> 4596
    //   3293: new 116	java/lang/String
    //   3296: dup
    //   3297: aload_1
    //   3298: invokestatic 199	bcsa:a	([B)[B
    //   3301: invokespecial 274	java/lang/String:<init>	([B)V
    //   3304: pop
    //   3305: aload_0
    //   3306: new 122	java/lang/StringBuilder
    //   3309: dup
    //   3310: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   3313: ldc 150
    //   3315: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3318: aload_2
    //   3319: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3322: ldc 150
    //   3324: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3327: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3330: ldc_w 273
    //   3333: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   3336: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3339: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3342: putfield 145	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   3345: goto -155 -> 3190
    //   3348: iload 5
    //   3350: sipush 1003
    //   3353: if_icmpne +1243 -> 4596
    //   3356: new 276	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendHelloInfo
    //   3359: dup
    //   3360: invokespecial 277	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendHelloInfo:<init>	()V
    //   3363: astore_2
    //   3364: aload_2
    //   3365: aload_1
    //   3366: invokevirtual 278	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendHelloInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3369: checkcast 276	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendHelloInfo
    //   3372: astore_1
    //   3373: aload_1
    //   3374: ifnull +1222 -> 4596
    //   3377: aload_0
    //   3378: aload_1
    //   3379: getfield 281	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendHelloInfo:str_source_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3382: invokevirtual 238	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3385: putfield 43	com/tencent/mobileqq/data/SystemMsg:strGameName	Ljava/lang/String;
    //   3388: goto +1208 -> 4596
    //   3391: astore_1
    //   3392: aload_0
    //   3393: astore 10
    //   3395: aload_1
    //   3396: astore_0
    //   3397: goto -2932 -> 465
    //   3400: astore_1
    //   3401: aconst_null
    //   3402: astore_1
    //   3403: goto -30 -> 3373
    //   3406: aload_0
    //   3407: areturn
    //   3408: new 2	com/tencent/mobileqq/data/SystemMsg
    //   3411: dup
    //   3412: invokespecial 61	com/tencent/mobileqq/data/SystemMsg:<init>	()V
    //   3415: astore_0
    //   3416: aload_0
    //   3417: aload 11
    //   3419: invokevirtual 188	java/io/DataInputStream:readUnsignedByte	()I
    //   3422: putfield 190	com/tencent/mobileqq/data/SystemMsg:cVession	I
    //   3425: aload 11
    //   3427: invokevirtual 188	java/io/DataInputStream:readUnsignedByte	()I
    //   3430: pop
    //   3431: aload 11
    //   3433: invokevirtual 211	java/io/DataInputStream:readUnsignedShort	()I
    //   3436: ifeq +1189 -> 4625
    //   3439: aload 11
    //   3441: invokevirtual 211	java/io/DataInputStream:readUnsignedShort	()I
    //   3444: istore_3
    //   3445: iload_3
    //   3446: newarray byte
    //   3448: astore_1
    //   3449: aload 11
    //   3451: aload_1
    //   3452: invokevirtual 194	java/io/DataInputStream:read	([B)I
    //   3455: pop
    //   3456: aload_1
    //   3457: arraylength
    //   3458: ifne +146 -> 3604
    //   3461: aload_0
    //   3462: new 122	java/lang/StringBuilder
    //   3465: dup
    //   3466: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   3469: ldc 150
    //   3471: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3474: aload_2
    //   3475: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3478: ldc 150
    //   3480: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3483: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3486: ldc_w 282
    //   3489: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   3492: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3495: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3498: putfield 145	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   3501: aload 11
    //   3503: ldc2_w 217
    //   3506: invokevirtual 208	java/io/DataInputStream:skip	(J)J
    //   3509: pop2
    //   3510: aload 11
    //   3512: aload 11
    //   3514: invokevirtual 211	java/io/DataInputStream:readUnsignedShort	()I
    //   3517: newarray byte
    //   3519: invokevirtual 194	java/io/DataInputStream:read	([B)I
    //   3522: pop
    //   3523: aload 11
    //   3525: invokevirtual 188	java/io/DataInputStream:readUnsignedByte	()I
    //   3528: istore 4
    //   3530: iload 6
    //   3532: istore_3
    //   3533: iload_3
    //   3534: iload 4
    //   3536: if_icmpge +174 -> 3710
    //   3539: aload 11
    //   3541: invokevirtual 222	java/io/DataInputStream:readShort	()S
    //   3544: istore 5
    //   3546: aload 11
    //   3548: invokevirtual 222	java/io/DataInputStream:readShort	()S
    //   3551: newarray byte
    //   3553: astore_1
    //   3554: aload 11
    //   3556: aload_1
    //   3557: invokevirtual 194	java/io/DataInputStream:read	([B)I
    //   3560: pop
    //   3561: iload 5
    //   3563: sipush 1002
    //   3566: if_icmpne +86 -> 3652
    //   3569: new 267	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo
    //   3572: dup
    //   3573: invokespecial 268	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:<init>	()V
    //   3576: astore_2
    //   3577: aload_2
    //   3578: aload_1
    //   3579: invokevirtual 269	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3582: checkcast 267	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo
    //   3585: astore_1
    //   3586: aload_1
    //   3587: ifnull +1031 -> 4618
    //   3590: aload_0
    //   3591: aload_1
    //   3592: getfield 272	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:str_fromuin_nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3595: invokevirtual 238	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3598: putfield 41	com/tencent/mobileqq/data/SystemMsg:strServerFromUinNickName	Ljava/lang/String;
    //   3601: goto +1017 -> 4618
    //   3604: aload_1
    //   3605: invokestatic 199	bcsa:a	([B)[B
    //   3608: pop
    //   3609: aload_0
    //   3610: new 122	java/lang/StringBuilder
    //   3613: dup
    //   3614: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   3617: ldc 150
    //   3619: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3622: aload_2
    //   3623: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3626: ldc 150
    //   3628: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3631: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3634: ldc_w 282
    //   3637: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   3640: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3643: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3646: putfield 145	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   3649: goto -148 -> 3501
    //   3652: iload 5
    //   3654: sipush 1003
    //   3657: if_icmpne +961 -> 4618
    //   3660: new 276	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendHelloInfo
    //   3663: dup
    //   3664: invokespecial 277	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendHelloInfo:<init>	()V
    //   3667: astore_2
    //   3668: aload_2
    //   3669: aload_1
    //   3670: invokevirtual 278	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendHelloInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3673: checkcast 276	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendHelloInfo
    //   3676: astore_1
    //   3677: aload_1
    //   3678: ifnull +940 -> 4618
    //   3681: aload_0
    //   3682: aload_1
    //   3683: getfield 281	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendHelloInfo:str_source_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3686: invokevirtual 238	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3689: putfield 43	com/tencent/mobileqq/data/SystemMsg:strGameName	Ljava/lang/String;
    //   3692: goto +926 -> 4618
    //   3695: astore_1
    //   3696: aload_0
    //   3697: astore 10
    //   3699: aload_1
    //   3700: astore_0
    //   3701: goto -3236 -> 465
    //   3704: astore_1
    //   3705: aconst_null
    //   3706: astore_1
    //   3707: goto -30 -> 3677
    //   3710: aload_0
    //   3711: areturn
    //   3712: new 2	com/tencent/mobileqq/data/SystemMsg
    //   3715: dup
    //   3716: invokespecial 61	com/tencent/mobileqq/data/SystemMsg:<init>	()V
    //   3719: astore_0
    //   3720: aload_0
    //   3721: aload 11
    //   3723: invokevirtual 188	java/io/DataInputStream:readUnsignedByte	()I
    //   3726: putfield 190	com/tencent/mobileqq/data/SystemMsg:cVession	I
    //   3729: aload 11
    //   3731: invokevirtual 188	java/io/DataInputStream:readUnsignedByte	()I
    //   3734: newarray byte
    //   3736: astore_1
    //   3737: aload 11
    //   3739: aload_1
    //   3740: invokevirtual 194	java/io/DataInputStream:read	([B)I
    //   3743: pop
    //   3744: new 116	java/lang/String
    //   3747: dup
    //   3748: aload_1
    //   3749: invokestatic 199	bcsa:a	([B)[B
    //   3752: invokespecial 274	java/lang/String:<init>	([B)V
    //   3755: invokevirtual 156	java/lang/String:trim	()Ljava/lang/String;
    //   3758: astore 9
    //   3760: aload 9
    //   3762: ifnull +16 -> 3778
    //   3765: aload 9
    //   3767: astore_1
    //   3768: ldc 39
    //   3770: aload 9
    //   3772: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3775: ifeq +12 -> 3787
    //   3778: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3781: ldc 157
    //   3783: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   3786: astore_1
    //   3787: aload_0
    //   3788: aload_1
    //   3789: putfield 84	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   3792: aload 11
    //   3794: invokevirtual 211	java/io/DataInputStream:readUnsignedShort	()I
    //   3797: ifeq +850 -> 4647
    //   3800: aload 11
    //   3802: invokevirtual 211	java/io/DataInputStream:readUnsignedShort	()I
    //   3805: istore_3
    //   3806: iload_3
    //   3807: newarray byte
    //   3809: astore_1
    //   3810: aload 11
    //   3812: aload_1
    //   3813: invokevirtual 194	java/io/DataInputStream:read	([B)I
    //   3816: pop
    //   3817: aload_1
    //   3818: arraylength
    //   3819: ifne +152 -> 3971
    //   3822: aload_0
    //   3823: new 122	java/lang/StringBuilder
    //   3826: dup
    //   3827: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   3830: ldc 150
    //   3832: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3835: aload_2
    //   3836: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3839: ldc 150
    //   3841: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3844: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3847: ldc_w 283
    //   3850: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   3853: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3856: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3859: putfield 145	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   3862: aload 11
    //   3864: ldc2_w 217
    //   3867: invokevirtual 208	java/io/DataInputStream:skip	(J)J
    //   3870: pop2
    //   3871: aload 11
    //   3873: aload 11
    //   3875: invokevirtual 211	java/io/DataInputStream:readUnsignedShort	()I
    //   3878: newarray byte
    //   3880: invokevirtual 194	java/io/DataInputStream:read	([B)I
    //   3883: pop
    //   3884: aload 11
    //   3886: invokevirtual 188	java/io/DataInputStream:readUnsignedByte	()I
    //   3889: pop
    //   3890: aload 11
    //   3892: invokevirtual 188	java/io/DataInputStream:readUnsignedByte	()I
    //   3895: istore 4
    //   3897: iload 7
    //   3899: istore_3
    //   3900: iload_3
    //   3901: iload 4
    //   3903: if_icmpge +126 -> 4029
    //   3906: aload 11
    //   3908: invokevirtual 222	java/io/DataInputStream:readShort	()S
    //   3911: istore 5
    //   3913: aload 11
    //   3915: invokevirtual 222	java/io/DataInputStream:readShort	()S
    //   3918: newarray byte
    //   3920: astore_1
    //   3921: aload 11
    //   3923: aload_1
    //   3924: invokevirtual 194	java/io/DataInputStream:read	([B)I
    //   3927: pop
    //   3928: iload 5
    //   3930: sipush 1002
    //   3933: if_icmpne +707 -> 4640
    //   3936: new 267	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo
    //   3939: dup
    //   3940: invokespecial 268	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:<init>	()V
    //   3943: astore_2
    //   3944: aload_2
    //   3945: aload_1
    //   3946: invokevirtual 269	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3949: checkcast 267	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo
    //   3952: astore_1
    //   3953: aload_1
    //   3954: ifnull +686 -> 4640
    //   3957: aload_0
    //   3958: aload_1
    //   3959: getfield 272	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:str_fromuin_nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3962: invokevirtual 238	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3965: putfield 41	com/tencent/mobileqq/data/SystemMsg:strServerFromUinNickName	Ljava/lang/String;
    //   3968: goto +672 -> 4640
    //   3971: aload_1
    //   3972: invokestatic 199	bcsa:a	([B)[B
    //   3975: pop
    //   3976: aload_0
    //   3977: new 122	java/lang/StringBuilder
    //   3980: dup
    //   3981: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   3984: ldc 150
    //   3986: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3989: aload_2
    //   3990: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3993: ldc 150
    //   3995: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3998: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4001: ldc_w 283
    //   4004: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   4007: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4010: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4013: putfield 145	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   4016: goto -154 -> 3862
    //   4019: astore_1
    //   4020: goto -3610 -> 410
    //   4023: astore_1
    //   4024: aconst_null
    //   4025: astore_1
    //   4026: goto -73 -> 3953
    //   4029: aload_0
    //   4030: areturn
    //   4031: new 2	com/tencent/mobileqq/data/SystemMsg
    //   4034: dup
    //   4035: invokespecial 61	com/tencent/mobileqq/data/SystemMsg:<init>	()V
    //   4038: astore_0
    //   4039: aload_0
    //   4040: astore 9
    //   4042: aload_0
    //   4043: astore 10
    //   4045: aload_0
    //   4046: new 122	java/lang/StringBuilder
    //   4049: dup
    //   4050: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   4053: ldc 150
    //   4055: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4058: aload_2
    //   4059: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4062: ldc 150
    //   4064: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4067: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4070: ldc_w 284
    //   4073: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   4076: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4079: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4082: putfield 145	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   4085: aload_0
    //   4086: astore 9
    //   4088: new 2	com/tencent/mobileqq/data/SystemMsg
    //   4091: dup
    //   4092: invokespecial 61	com/tencent/mobileqq/data/SystemMsg:<init>	()V
    //   4095: astore_1
    //   4096: aload_1
    //   4097: aload 11
    //   4099: invokevirtual 188	java/io/DataInputStream:readUnsignedByte	()I
    //   4102: putfield 190	com/tencent/mobileqq/data/SystemMsg:cVession	I
    //   4105: aload 11
    //   4107: aload 11
    //   4109: invokevirtual 188	java/io/DataInputStream:readUnsignedByte	()I
    //   4112: newarray byte
    //   4114: invokevirtual 194	java/io/DataInputStream:read	([B)I
    //   4117: pop
    //   4118: aload_1
    //   4119: aload 11
    //   4121: invokevirtual 211	java/io/DataInputStream:readUnsignedShort	()I
    //   4124: putfield 213	com/tencent/mobileqq/data/SystemMsg:wSourceID	I
    //   4127: aload_1
    //   4128: aload 11
    //   4130: invokevirtual 211	java/io/DataInputStream:readUnsignedShort	()I
    //   4133: putfield 215	com/tencent/mobileqq/data/SystemMsg:wSourceSubID	I
    //   4136: aload 11
    //   4138: aload 11
    //   4140: invokevirtual 211	java/io/DataInputStream:readUnsignedShort	()I
    //   4143: i2l
    //   4144: invokevirtual 208	java/io/DataInputStream:skip	(J)J
    //   4147: pop2
    //   4148: aload 11
    //   4150: invokevirtual 211	java/io/DataInputStream:readUnsignedShort	()I
    //   4153: ifeq +506 -> 4659
    //   4156: aload 11
    //   4158: invokevirtual 211	java/io/DataInputStream:readUnsignedShort	()I
    //   4161: istore_3
    //   4162: iload_3
    //   4163: newarray byte
    //   4165: astore_0
    //   4166: aload 11
    //   4168: aload_0
    //   4169: invokevirtual 194	java/io/DataInputStream:read	([B)I
    //   4172: pop
    //   4173: aload_0
    //   4174: arraylength
    //   4175: ifne +168 -> 4343
    //   4178: aload_1
    //   4179: new 122	java/lang/StringBuilder
    //   4182: dup
    //   4183: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   4186: ldc 150
    //   4188: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4191: aload_2
    //   4192: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4195: ldc 150
    //   4197: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4200: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4203: ldc_w 284
    //   4206: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   4209: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4212: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4215: putfield 145	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   4218: aload 11
    //   4220: ldc2_w 217
    //   4223: invokevirtual 208	java/io/DataInputStream:skip	(J)J
    //   4226: pop2
    //   4227: aload 11
    //   4229: aload 11
    //   4231: invokevirtual 211	java/io/DataInputStream:readUnsignedShort	()I
    //   4234: newarray byte
    //   4236: invokevirtual 194	java/io/DataInputStream:read	([B)I
    //   4239: pop
    //   4240: aload 11
    //   4242: invokevirtual 188	java/io/DataInputStream:readUnsignedByte	()I
    //   4245: istore 4
    //   4247: iload 8
    //   4249: istore_3
    //   4250: iload_3
    //   4251: iload 4
    //   4253: if_icmpge +195 -> 4448
    //   4256: aload 11
    //   4258: invokevirtual 222	java/io/DataInputStream:readShort	()S
    //   4261: istore 5
    //   4263: aload 11
    //   4265: invokevirtual 222	java/io/DataInputStream:readShort	()S
    //   4268: newarray byte
    //   4270: astore_0
    //   4271: aload 11
    //   4273: aload_0
    //   4274: invokevirtual 194	java/io/DataInputStream:read	([B)I
    //   4277: pop
    //   4278: iload 5
    //   4280: sipush 1000
    //   4283: if_icmpne +108 -> 4391
    //   4286: new 224	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo
    //   4289: dup
    //   4290: invokespecial 225	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo:<init>	()V
    //   4293: astore_2
    //   4294: aload_2
    //   4295: aload_0
    //   4296: invokevirtual 229	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4299: checkcast 224	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo
    //   4302: astore_0
    //   4303: aload_0
    //   4304: ifnull +348 -> 4652
    //   4307: aload_1
    //   4308: aload_0
    //   4309: getfield 233	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo:str_group_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4312: invokevirtual 238	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   4315: putfield 240	com/tencent/mobileqq/data/SystemMsg:strGroupName	Ljava/lang/String;
    //   4318: aload_1
    //   4319: aload_0
    //   4320: getfield 243	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo:str_group_nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4323: invokevirtual 238	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   4326: putfield 245	com/tencent/mobileqq/data/SystemMsg:strGroupNickName	Ljava/lang/String;
    //   4329: aload_1
    //   4330: aload_0
    //   4331: getfield 249	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo:uint64_group_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4334: invokevirtual 254	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   4337: putfield 256	com/tencent/mobileqq/data/SystemMsg:strGroupUin	J
    //   4340: goto +312 -> 4652
    //   4343: aload_0
    //   4344: invokestatic 199	bcsa:a	([B)[B
    //   4347: pop
    //   4348: aload_1
    //   4349: new 122	java/lang/StringBuilder
    //   4352: dup
    //   4353: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   4356: ldc 150
    //   4358: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4361: aload_2
    //   4362: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4365: ldc 150
    //   4367: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4370: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4373: ldc_w 284
    //   4376: invokevirtual 139	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   4379: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4382: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4385: putfield 145	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   4388: goto -170 -> 4218
    //   4391: iload 5
    //   4393: sipush 1002
    //   4396: if_icmpne +256 -> 4652
    //   4399: new 267	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo
    //   4402: dup
    //   4403: invokespecial 268	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:<init>	()V
    //   4406: astore_2
    //   4407: aload_2
    //   4408: aload_0
    //   4409: invokevirtual 269	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4412: checkcast 267	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo
    //   4415: astore_0
    //   4416: aload_0
    //   4417: ifnull +235 -> 4652
    //   4420: aload_1
    //   4421: aload_0
    //   4422: getfield 272	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:str_fromuin_nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4425: invokevirtual 238	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   4428: putfield 41	com/tencent/mobileqq/data/SystemMsg:strServerFromUinNickName	Ljava/lang/String;
    //   4431: goto +221 -> 4652
    //   4434: astore_2
    //   4435: aload_1
    //   4436: astore_0
    //   4437: aload_2
    //   4438: astore_1
    //   4439: goto -4029 -> 410
    //   4442: astore_0
    //   4443: aconst_null
    //   4444: astore_0
    //   4445: goto -29 -> 4416
    //   4448: aload_1
    //   4449: areturn
    //   4450: aload_2
    //   4451: getstatic 178	antf:J	Ljava/lang/String;
    //   4454: invokestatic 182	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   4457: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4460: ifeq +92 -> 4552
    //   4463: new 2	com/tencent/mobileqq/data/SystemMsg
    //   4466: dup
    //   4467: invokespecial 61	com/tencent/mobileqq/data/SystemMsg:<init>	()V
    //   4470: astore_0
    //   4471: aload_0
    //   4472: astore 9
    //   4474: aload_0
    //   4475: astore 10
    //   4477: aload_0
    //   4478: aload_1
    //   4479: putfield 145	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   4482: aload_0
    //   4483: areturn
    //   4484: aload_2
    //   4485: getstatic 178	antf:J	Ljava/lang/String;
    //   4488: invokestatic 182	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   4491: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4494: ifeq +58 -> 4552
    //   4497: new 2	com/tencent/mobileqq/data/SystemMsg
    //   4500: dup
    //   4501: invokespecial 61	com/tencent/mobileqq/data/SystemMsg:<init>	()V
    //   4504: astore_0
    //   4505: aload_0
    //   4506: astore 9
    //   4508: aload_0
    //   4509: astore 10
    //   4511: aload_0
    //   4512: ldc_w 286
    //   4515: aload_1
    //   4516: invokestatic 291	bhvd:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   4519: invokestatic 294	bhvd:a	(Ljava/lang/String;)Ljava/lang/String;
    //   4522: putfield 145	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   4525: aload_0
    //   4526: areturn
    //   4527: astore_0
    //   4528: aconst_null
    //   4529: astore 10
    //   4531: goto -4066 -> 465
    //   4534: astore_1
    //   4535: aload_0
    //   4536: astore 10
    //   4538: aload_1
    //   4539: astore_0
    //   4540: goto -4075 -> 465
    //   4543: astore_1
    //   4544: aconst_null
    //   4545: astore_0
    //   4546: goto -4136 -> 410
    //   4549: astore_1
    //   4550: aload_0
    //   4551: areturn
    //   4552: aconst_null
    //   4553: areturn
    //   4554: aload_1
    //   4555: areturn
    //   4556: goto -1924 -> 2632
    //   4559: iload_3
    //   4560: iconst_1
    //   4561: iadd
    //   4562: istore_3
    //   4563: goto -1700 -> 2863
    //   4566: iconst_0
    //   4567: istore_3
    //   4568: goto -1798 -> 2770
    //   4571: astore_1
    //   4572: goto -4162 -> 410
    //   4575: astore_1
    //   4576: aconst_null
    //   4577: astore_1
    //   4578: goto -1662 -> 2916
    //   4581: astore_1
    //   4582: aload_0
    //   4583: astore 10
    //   4585: aload_1
    //   4586: astore_0
    //   4587: goto -4122 -> 465
    //   4590: astore_1
    //   4591: aconst_null
    //   4592: astore_1
    //   4593: goto -1565 -> 3028
    //   4596: iload_3
    //   4597: iconst_1
    //   4598: iadd
    //   4599: istore_3
    //   4600: goto -1378 -> 3222
    //   4603: iconst_0
    //   4604: istore_3
    //   4605: goto -1471 -> 3134
    //   4608: astore_1
    //   4609: goto -4199 -> 410
    //   4612: astore_1
    //   4613: aconst_null
    //   4614: astore_1
    //   4615: goto -1340 -> 3275
    //   4618: iload_3
    //   4619: iconst_1
    //   4620: iadd
    //   4621: istore_3
    //   4622: goto -1089 -> 3533
    //   4625: iconst_0
    //   4626: istore_3
    //   4627: goto -1182 -> 3445
    //   4630: astore_1
    //   4631: goto -4221 -> 410
    //   4634: astore_1
    //   4635: aconst_null
    //   4636: astore_1
    //   4637: goto -1051 -> 3586
    //   4640: iload_3
    //   4641: iconst_1
    //   4642: iadd
    //   4643: istore_3
    //   4644: goto -744 -> 3900
    //   4647: iconst_0
    //   4648: istore_3
    //   4649: goto -843 -> 3806
    //   4652: iload_3
    //   4653: iconst_1
    //   4654: iadd
    //   4655: istore_3
    //   4656: goto -406 -> 4250
    //   4659: iconst_0
    //   4660: istore_3
    //   4661: goto -499 -> 4162
    //   4664: astore_0
    //   4665: aload_1
    //   4666: areturn
    //   4667: astore_0
    //   4668: aconst_null
    //   4669: astore_0
    //   4670: goto -367 -> 4303
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4673	0	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   0	4673	1	paramString1	String
    //   0	4673	2	paramString2	String
    //   0	4673	3	paramInt	int
    //   13	4241	4	i	int
    //   1	4396	5	j	int
    //   4	3527	6	k	int
    //   7	3891	7	m	int
    //   10	4238	8	n	int
    //   40	4467	9	localObject1	java.lang.Object
    //   43	4541	10	localObject2	java.lang.Object
    //   188	4084	11	localObject3	java.lang.Object
    //   205	435	12	str1	String
    //   222	2035	13	str2	String
    // Exception table:
    //   from	to	target	type
    //   45	53	406	java/io/IOException
    //   59	67	406	java/io/IOException
    //   73	82	406	java/io/IOException
    //   88	97	406	java/io/IOException
    //   103	112	406	java/io/IOException
    //   118	127	406	java/io/IOException
    //   133	142	406	java/io/IOException
    //   148	157	406	java/io/IOException
    //   163	173	406	java/io/IOException
    //   179	190	406	java/io/IOException
    //   196	207	406	java/io/IOException
    //   213	224	406	java/io/IOException
    //   338	345	406	java/io/IOException
    //   351	363	406	java/io/IOException
    //   369	404	406	java/io/IOException
    //   422	462	406	java/io/IOException
    //   478	485	406	java/io/IOException
    //   491	506	406	java/io/IOException
    //   512	521	406	java/io/IOException
    //   527	532	406	java/io/IOException
    //   538	545	406	java/io/IOException
    //   551	563	406	java/io/IOException
    //   569	604	406	java/io/IOException
    //   612	617	406	java/io/IOException
    //   626	666	406	java/io/IOException
    //   674	681	406	java/io/IOException
    //   687	699	406	java/io/IOException
    //   705	714	406	java/io/IOException
    //   720	725	406	java/io/IOException
    //   731	738	406	java/io/IOException
    //   744	755	406	java/io/IOException
    //   761	768	406	java/io/IOException
    //   774	786	406	java/io/IOException
    //   792	831	406	java/io/IOException
    //   839	844	406	java/io/IOException
    //   853	897	406	java/io/IOException
    //   905	912	406	java/io/IOException
    //   918	930	406	java/io/IOException
    //   936	985	406	java/io/IOException
    //   993	1047	406	java/io/IOException
    //   1055	1062	406	java/io/IOException
    //   1068	1080	406	java/io/IOException
    //   1086	1095	406	java/io/IOException
    //   1101	1106	406	java/io/IOException
    //   1112	1120	406	java/io/IOException
    //   1126	1134	406	java/io/IOException
    //   1140	1147	406	java/io/IOException
    //   1153	1164	406	java/io/IOException
    //   1170	1177	406	java/io/IOException
    //   1183	1195	406	java/io/IOException
    //   1201	1240	406	java/io/IOException
    //   1248	1253	406	java/io/IOException
    //   1262	1306	406	java/io/IOException
    //   1314	1321	406	java/io/IOException
    //   1327	1339	406	java/io/IOException
    //   1345	1394	406	java/io/IOException
    //   1402	1456	406	java/io/IOException
    //   1464	1472	406	java/io/IOException
    //   1478	1485	406	java/io/IOException
    //   1491	1502	406	java/io/IOException
    //   1508	1515	406	java/io/IOException
    //   1521	1533	406	java/io/IOException
    //   1539	1578	406	java/io/IOException
    //   1586	1630	406	java/io/IOException
    //   1638	1645	406	java/io/IOException
    //   1651	1663	406	java/io/IOException
    //   1669	1718	406	java/io/IOException
    //   1726	1780	406	java/io/IOException
    //   1788	1796	406	java/io/IOException
    //   1802	1809	406	java/io/IOException
    //   1815	1826	406	java/io/IOException
    //   1832	1839	406	java/io/IOException
    //   1845	1857	406	java/io/IOException
    //   1863	1902	406	java/io/IOException
    //   1910	1954	406	java/io/IOException
    //   1962	1969	406	java/io/IOException
    //   1975	1987	406	java/io/IOException
    //   1993	2042	406	java/io/IOException
    //   2050	2104	406	java/io/IOException
    //   2112	2120	406	java/io/IOException
    //   2126	2133	406	java/io/IOException
    //   2139	2150	406	java/io/IOException
    //   2156	2163	406	java/io/IOException
    //   2169	2181	406	java/io/IOException
    //   2187	2226	406	java/io/IOException
    //   2232	2283	406	java/io/IOException
    //   2291	2335	406	java/io/IOException
    //   2344	2351	406	java/io/IOException
    //   2357	2369	406	java/io/IOException
    //   2375	2424	406	java/io/IOException
    //   2433	2487	406	java/io/IOException
    //   2659	2665	406	java/io/IOException
    //   4045	4085	406	java/io/IOException
    //   4088	4096	406	java/io/IOException
    //   4477	4482	406	java/io/IOException
    //   4511	4525	406	java/io/IOException
    //   45	53	464	java/lang/Exception
    //   59	67	464	java/lang/Exception
    //   73	82	464	java/lang/Exception
    //   88	97	464	java/lang/Exception
    //   103	112	464	java/lang/Exception
    //   118	127	464	java/lang/Exception
    //   133	142	464	java/lang/Exception
    //   148	157	464	java/lang/Exception
    //   163	173	464	java/lang/Exception
    //   179	190	464	java/lang/Exception
    //   196	207	464	java/lang/Exception
    //   213	224	464	java/lang/Exception
    //   338	345	464	java/lang/Exception
    //   351	363	464	java/lang/Exception
    //   369	404	464	java/lang/Exception
    //   422	462	464	java/lang/Exception
    //   478	485	464	java/lang/Exception
    //   491	506	464	java/lang/Exception
    //   512	521	464	java/lang/Exception
    //   527	532	464	java/lang/Exception
    //   538	545	464	java/lang/Exception
    //   551	563	464	java/lang/Exception
    //   569	604	464	java/lang/Exception
    //   612	617	464	java/lang/Exception
    //   626	666	464	java/lang/Exception
    //   674	681	464	java/lang/Exception
    //   687	699	464	java/lang/Exception
    //   705	714	464	java/lang/Exception
    //   720	725	464	java/lang/Exception
    //   731	738	464	java/lang/Exception
    //   744	755	464	java/lang/Exception
    //   761	768	464	java/lang/Exception
    //   774	786	464	java/lang/Exception
    //   792	831	464	java/lang/Exception
    //   839	844	464	java/lang/Exception
    //   853	897	464	java/lang/Exception
    //   905	912	464	java/lang/Exception
    //   918	930	464	java/lang/Exception
    //   936	985	464	java/lang/Exception
    //   993	1047	464	java/lang/Exception
    //   1055	1062	464	java/lang/Exception
    //   1068	1080	464	java/lang/Exception
    //   1086	1095	464	java/lang/Exception
    //   1101	1106	464	java/lang/Exception
    //   1112	1120	464	java/lang/Exception
    //   1126	1134	464	java/lang/Exception
    //   1140	1147	464	java/lang/Exception
    //   1153	1164	464	java/lang/Exception
    //   1170	1177	464	java/lang/Exception
    //   1183	1195	464	java/lang/Exception
    //   1201	1240	464	java/lang/Exception
    //   1248	1253	464	java/lang/Exception
    //   1262	1306	464	java/lang/Exception
    //   1314	1321	464	java/lang/Exception
    //   1327	1339	464	java/lang/Exception
    //   1345	1394	464	java/lang/Exception
    //   1402	1456	464	java/lang/Exception
    //   1464	1472	464	java/lang/Exception
    //   1478	1485	464	java/lang/Exception
    //   1491	1502	464	java/lang/Exception
    //   1508	1515	464	java/lang/Exception
    //   1521	1533	464	java/lang/Exception
    //   1539	1578	464	java/lang/Exception
    //   1586	1630	464	java/lang/Exception
    //   1638	1645	464	java/lang/Exception
    //   1651	1663	464	java/lang/Exception
    //   1669	1718	464	java/lang/Exception
    //   1726	1780	464	java/lang/Exception
    //   1788	1796	464	java/lang/Exception
    //   1802	1809	464	java/lang/Exception
    //   1815	1826	464	java/lang/Exception
    //   1832	1839	464	java/lang/Exception
    //   1845	1857	464	java/lang/Exception
    //   1863	1902	464	java/lang/Exception
    //   1910	1954	464	java/lang/Exception
    //   1962	1969	464	java/lang/Exception
    //   1975	1987	464	java/lang/Exception
    //   1993	2042	464	java/lang/Exception
    //   2050	2104	464	java/lang/Exception
    //   2112	2120	464	java/lang/Exception
    //   2126	2133	464	java/lang/Exception
    //   2139	2150	464	java/lang/Exception
    //   2156	2163	464	java/lang/Exception
    //   2169	2181	464	java/lang/Exception
    //   2187	2226	464	java/lang/Exception
    //   2232	2283	464	java/lang/Exception
    //   2291	2335	464	java/lang/Exception
    //   2344	2351	464	java/lang/Exception
    //   2357	2369	464	java/lang/Exception
    //   2375	2424	464	java/lang/Exception
    //   2433	2487	464	java/lang/Exception
    //   2659	2665	464	java/lang/Exception
    //   4045	4085	464	java/lang/Exception
    //   4477	4482	464	java/lang/Exception
    //   4511	4525	464	java/lang/Exception
    //   3062	3071	3089	java/lang/Exception
    //   3105	3134	3391	java/lang/Exception
    //   3134	3190	3391	java/lang/Exception
    //   3190	3219	3391	java/lang/Exception
    //   3228	3250	3391	java/lang/Exception
    //   3258	3266	3391	java/lang/Exception
    //   3279	3290	3391	java/lang/Exception
    //   3293	3345	3391	java/lang/Exception
    //   3356	3364	3391	java/lang/Exception
    //   3377	3388	3391	java/lang/Exception
    //   3364	3373	3400	java/lang/Exception
    //   3416	3445	3695	java/lang/Exception
    //   3445	3501	3695	java/lang/Exception
    //   3501	3530	3695	java/lang/Exception
    //   3539	3561	3695	java/lang/Exception
    //   3569	3577	3695	java/lang/Exception
    //   3590	3601	3695	java/lang/Exception
    //   3604	3649	3695	java/lang/Exception
    //   3660	3668	3695	java/lang/Exception
    //   3681	3692	3695	java/lang/Exception
    //   3668	3677	3704	java/lang/Exception
    //   3720	3760	4019	java/io/IOException
    //   3768	3778	4019	java/io/IOException
    //   3778	3787	4019	java/io/IOException
    //   3787	3806	4019	java/io/IOException
    //   3806	3862	4019	java/io/IOException
    //   3862	3897	4019	java/io/IOException
    //   3906	3928	4019	java/io/IOException
    //   3936	3944	4019	java/io/IOException
    //   3944	3953	4019	java/io/IOException
    //   3957	3968	4019	java/io/IOException
    //   3971	4016	4019	java/io/IOException
    //   3944	3953	4023	java/lang/Exception
    //   4096	4162	4434	java/io/IOException
    //   4162	4218	4434	java/io/IOException
    //   4218	4247	4434	java/io/IOException
    //   4256	4278	4434	java/io/IOException
    //   4286	4294	4434	java/io/IOException
    //   4294	4303	4434	java/io/IOException
    //   4307	4340	4434	java/io/IOException
    //   4343	4388	4434	java/io/IOException
    //   4399	4407	4434	java/io/IOException
    //   4407	4416	4434	java/io/IOException
    //   4420	4431	4434	java/io/IOException
    //   4407	4416	4442	java/lang/Exception
    //   19	39	4527	java/lang/Exception
    //   2490	2510	4527	java/lang/Exception
    //   2632	2653	4527	java/lang/Exception
    //   2667	2675	4527	java/lang/Exception
    //   3097	3105	4527	java/lang/Exception
    //   3408	3416	4527	java/lang/Exception
    //   3712	3720	4527	java/lang/Exception
    //   4031	4039	4527	java/lang/Exception
    //   4450	4471	4527	java/lang/Exception
    //   4484	4505	4527	java/lang/Exception
    //   3720	3760	4534	java/lang/Exception
    //   3768	3778	4534	java/lang/Exception
    //   3778	3787	4534	java/lang/Exception
    //   3787	3806	4534	java/lang/Exception
    //   3806	3862	4534	java/lang/Exception
    //   3862	3897	4534	java/lang/Exception
    //   3906	3928	4534	java/lang/Exception
    //   3936	3944	4534	java/lang/Exception
    //   3957	3968	4534	java/lang/Exception
    //   3971	4016	4534	java/lang/Exception
    //   19	39	4543	java/io/IOException
    //   2490	2510	4543	java/io/IOException
    //   2632	2653	4543	java/io/IOException
    //   2667	2675	4543	java/io/IOException
    //   3097	3105	4543	java/io/IOException
    //   3408	3416	4543	java/io/IOException
    //   3712	3720	4543	java/io/IOException
    //   4031	4039	4543	java/io/IOException
    //   4450	4471	4543	java/io/IOException
    //   4484	4505	4543	java/io/IOException
    //   4088	4096	4549	java/lang/Exception
    //   2675	2770	4571	java/io/IOException
    //   2770	2825	4571	java/io/IOException
    //   2825	2860	4571	java/io/IOException
    //   2869	2891	4571	java/io/IOException
    //   2899	2907	4571	java/io/IOException
    //   2907	2916	4571	java/io/IOException
    //   2920	2953	4571	java/io/IOException
    //   2956	3000	4571	java/io/IOException
    //   3011	3019	4571	java/io/IOException
    //   3019	3028	4571	java/io/IOException
    //   3032	3043	4571	java/io/IOException
    //   3054	3062	4571	java/io/IOException
    //   3062	3071	4571	java/io/IOException
    //   3075	3086	4571	java/io/IOException
    //   2907	2916	4575	java/lang/Exception
    //   2675	2770	4581	java/lang/Exception
    //   2770	2825	4581	java/lang/Exception
    //   2825	2860	4581	java/lang/Exception
    //   2869	2891	4581	java/lang/Exception
    //   2899	2907	4581	java/lang/Exception
    //   2920	2953	4581	java/lang/Exception
    //   2956	3000	4581	java/lang/Exception
    //   3011	3019	4581	java/lang/Exception
    //   3032	3043	4581	java/lang/Exception
    //   3054	3062	4581	java/lang/Exception
    //   3075	3086	4581	java/lang/Exception
    //   3019	3028	4590	java/lang/Exception
    //   3105	3134	4608	java/io/IOException
    //   3134	3190	4608	java/io/IOException
    //   3190	3219	4608	java/io/IOException
    //   3228	3250	4608	java/io/IOException
    //   3258	3266	4608	java/io/IOException
    //   3266	3275	4608	java/io/IOException
    //   3279	3290	4608	java/io/IOException
    //   3293	3345	4608	java/io/IOException
    //   3356	3364	4608	java/io/IOException
    //   3364	3373	4608	java/io/IOException
    //   3377	3388	4608	java/io/IOException
    //   3266	3275	4612	java/lang/Exception
    //   3416	3445	4630	java/io/IOException
    //   3445	3501	4630	java/io/IOException
    //   3501	3530	4630	java/io/IOException
    //   3539	3561	4630	java/io/IOException
    //   3569	3577	4630	java/io/IOException
    //   3577	3586	4630	java/io/IOException
    //   3590	3601	4630	java/io/IOException
    //   3604	3649	4630	java/io/IOException
    //   3660	3668	4630	java/io/IOException
    //   3668	3677	4630	java/io/IOException
    //   3681	3692	4630	java/io/IOException
    //   3577	3586	4634	java/lang/Exception
    //   4096	4162	4664	java/lang/Exception
    //   4162	4218	4664	java/lang/Exception
    //   4218	4247	4664	java/lang/Exception
    //   4256	4278	4664	java/lang/Exception
    //   4286	4294	4664	java/lang/Exception
    //   4307	4340	4664	java/lang/Exception
    //   4343	4388	4664	java/lang/Exception
    //   4399	4407	4664	java/lang/Exception
    //   4420	4431	4664	java/lang/Exception
    //   4294	4303	4667	java/lang/Exception
  }
  
  public static byte[] getAuthFromTroopSysMsg(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {}
    do
    {
      return null;
      switch (paramInt)
      {
      case -1022: 
      case -1021: 
      case 36: 
      case 37: 
      case 85: 
      case 86: 
      default: 
        return null;
      case -1023: 
      case 46: 
      case 87: 
        paramInt = getTroopOpFromTroopSysMsg(paramArrayOfByte, paramInt);
        if ((paramInt == 1) || (paramInt == 4))
        {
          paramInt = bhvd.a(paramArrayOfByte[15]) + 15;
          i = bhvd.a(paramArrayOfByte, paramInt);
          arrayOfByte = new byte[i];
          System.arraycopy(paramArrayOfByte, paramInt + 2, arrayOfByte, 0, i);
          return arrayOfByte;
        }
        break;
      case -1020: 
      case 35: 
      case 84: 
        paramInt = bhvd.a(paramArrayOfByte[9]);
        paramInt = bhvd.a(paramArrayOfByte, bhvd.a(paramArrayOfByte[9]) + 10) + (paramInt + 10 + 2);
        i = bhvd.a(paramArrayOfByte, paramInt);
        arrayOfByte = new byte[i];
        System.arraycopy(paramArrayOfByte, paramInt + 2, arrayOfByte, 0, i);
        return arrayOfByte;
      }
    } while (paramInt != 5);
    paramInt = bhvd.a(paramArrayOfByte[19]) + 19;
    int i = bhvd.a(paramArrayOfByte, paramInt);
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(paramArrayOfByte, paramInt + 2, arrayOfByte, 0, i);
    return arrayOfByte;
  }
  
  public static String getInviteUinFromTroopSysMsg(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {}
    do
    {
      return null;
      switch (paramInt)
      {
      default: 
        return null;
      }
    } while (getTroopOpFromTroopSysMsg(paramArrayOfByte, paramInt) != 5);
    return String.valueOf(bhvd.a(paramArrayOfByte, 14));
  }
  
  public static String getManagerUinFromTroopSysMsg(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    switch (paramInt)
    {
    case -1020: 
    case 35: 
    case 84: 
    default: 
      return null;
    case -1023: 
    case 46: 
    case 87: 
      return String.valueOf(bhvd.a(paramArrayOfByte, 10));
    }
    return String.valueOf(bhvd.a(paramArrayOfByte, 5));
  }
  
  public static String getRequestUinFromTroopSysMsg(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    switch (paramInt)
    {
    default: 
      return null;
    case -1023: 
    case -1022: 
    case -1021: 
    case 36: 
    case 37: 
    case 46: 
    case 85: 
    case 86: 
    case 87: 
      return String.valueOf(bhvd.a(paramArrayOfByte, 10));
    }
    return String.valueOf(bhvd.a(paramArrayOfByte, 5));
  }
  
  public static String getStrMsgFromTroopSysMsg(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    byte[] arrayOfByte;
    switch (paramInt)
    {
    default: 
      return null;
    case -1023: 
    case 46: 
    case 87: 
      if (getTroopOpFromTroopSysMsg(paramArrayOfByte, paramInt) == 5)
      {
        paramInt = bhvd.a(paramArrayOfByte[18]);
        arrayOfByte = new byte[paramInt];
        bhvd.a(arrayOfByte, 0, paramArrayOfByte, 19, paramInt);
      }
      break;
    }
    for (paramArrayOfByte = bcsa.a(arrayOfByte);; paramArrayOfByte = bcsa.a(arrayOfByte))
    {
      return String.valueOf(bhvd.b(paramArrayOfByte, 0, paramInt));
      paramInt = bhvd.a(paramArrayOfByte[9]);
      arrayOfByte = new byte[paramInt];
      bhvd.a(arrayOfByte, 0, paramArrayOfByte, 10, paramInt);
      return String.valueOf(bhvd.b(bcsa.a(arrayOfByte), 0, paramInt));
      paramInt = bhvd.a(paramArrayOfByte[14]);
      arrayOfByte = new byte[paramInt];
      bhvd.a(arrayOfByte, 0, paramArrayOfByte, 15, paramInt);
    }
  }
  
  public static String getTroopCodeFromTroopSysMsg(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    return String.valueOf(bhvd.a(paramArrayOfByte, 0));
  }
  
  public static byte getTroopOpFromTroopSysMsg(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return -1;
    }
    switch (paramInt)
    {
    case -1022: 
    case -1021: 
    case -1020: 
    case 35: 
    case 36: 
    case 37: 
    case 84: 
    case 85: 
    case 86: 
    default: 
      return -1;
    }
    return paramArrayOfByte[5];
  }
  
  public static int getTroopSystemMsgType(int paramInt)
  {
    int j = -1023;
    int i;
    if ((paramInt == -1020) || (paramInt == 84) || (paramInt == 35)) {
      i = -1020;
    }
    do
    {
      do
      {
        do
        {
          return i;
          if ((paramInt == -1021) || (paramInt == 85) || (paramInt == 36)) {
            return -1021;
          }
          if ((paramInt == -1022) || (paramInt == 86) || (paramInt == 37)) {
            return -1022;
          }
          i = j;
        } while (paramInt == -1023);
        i = j;
      } while (paramInt == 87);
      i = j;
    } while (paramInt == 46);
    return -1000;
  }
  
  public static byte getTroopTypeFromTroopSysMsg(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return -1;
    }
    return paramArrayOfByte[4];
  }
  
  public static boolean isSystemMessage(int paramInt)
  {
    if ((paramInt <= -1006) && (paramInt >= -1010)) {}
    while ((paramInt == -1011) || ((paramInt >= 187) && (paramInt <= 191))) {
      return true;
    }
    return false;
  }
  
  public static boolean isTroopSystemMessage(int paramInt)
  {
    if ((paramInt <= -1020) && (paramInt >= -1023)) {}
    while (((paramInt >= 84) && (paramInt <= 87)) || ((paramInt >= 35) && (paramInt <= 37)) || (paramInt == 46) || (paramInt == 45)) {
      return true;
    }
    return false;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    try
    {
      this.cVession = paramJceInputStream.read(this.cVession, 0, true);
      this.sMsg = paramJceInputStream.read(this.sMsg, 1, false);
      this.append = paramJceInputStream.read(this.append, 2, false);
      this.message = paramJceInputStream.read(this.message, 3, false);
      this.troopCode = paramJceInputStream.read(this.troopCode, 4, false);
      this.managerUin = paramJceInputStream.readString(5, false);
      this.requestUin = paramJceInputStream.readString(6, false);
      this.troopType = paramJceInputStream.read(this.troopType, 7, true);
      this.op = paramJceInputStream.read(this.op, 8, true);
      this.auth = paramJceInputStream.read(this.auth, 9, false);
      this.lToMobile = paramJceInputStream.read(this.lToMobile, 10, true);
      this.strNickName = paramJceInputStream.read(this.strNickName, 11, false);
      return;
    }
    catch (Exception paramJceInputStream) {}
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cVession, 0);
    if (this.sMsg != null) {
      paramJceOutputStream.write(this.sMsg, 1);
    }
    if (this.append != null) {
      paramJceOutputStream.write(this.append, 2);
    }
    if (this.message != null) {
      paramJceOutputStream.write(this.message, 3);
    }
    if (this.troopCode != null) {
      paramJceOutputStream.write(this.troopCode, 4);
    }
    if (this.managerUin != null) {
      paramJceOutputStream.write(this.managerUin, 5);
    }
    if (this.requestUin != null) {
      paramJceOutputStream.write(this.requestUin, 6);
    }
    paramJceOutputStream.write(this.troopType, 7);
    paramJceOutputStream.write(this.op, 8);
    if (this.auth != null) {
      paramJceOutputStream.write(this.auth, 9);
    }
    paramJceOutputStream.write(this.lToMobile, 10);
    if (this.strNickName != null) {
      paramJceOutputStream.write(this.strNickName, 11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.SystemMsg
 * JD-Core Version:    0.7.0.1
 */