package com.tencent.mobileqq.data;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;

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
  public static SystemMsg decode(com.tencent.common.app.AppInterface paramAppInterface, String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: aconst_null
    //   4: astore 13
    //   6: aconst_null
    //   7: astore 11
    //   9: aload 13
    //   11: astore 10
    //   13: aload_1
    //   14: ifnull +5467 -> 5481
    //   17: iload_3
    //   18: invokestatic 54	com/tencent/mobileqq/data/SystemMsg:isTroopSystemMessage	(I)Z
    //   21: istore 9
    //   23: iload 9
    //   25: ifeq +2252 -> 2277
    //   28: aload_1
    //   29: invokestatic 60	com/tencent/mobileqq/utils/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   32: astore_2
    //   33: new 2	com/tencent/mobileqq/data/SystemMsg
    //   36: dup
    //   37: invokespecial 61	com/tencent/mobileqq/data/SystemMsg:<init>	()V
    //   40: astore_1
    //   41: aload_1
    //   42: aload_2
    //   43: invokestatic 65	com/tencent/mobileqq/data/SystemMsg:getTroopCodeFromTroopSysMsg	([B)Ljava/lang/String;
    //   46: putfield 67	com/tencent/mobileqq/data/SystemMsg:troopCode	Ljava/lang/String;
    //   49: aload_1
    //   50: aload_2
    //   51: invokestatic 71	com/tencent/mobileqq/data/SystemMsg:getTroopTypeFromTroopSysMsg	([B)B
    //   54: putfield 73	com/tencent/mobileqq/data/SystemMsg:troopType	B
    //   57: aload_1
    //   58: aload_2
    //   59: iload_3
    //   60: invokestatic 77	com/tencent/mobileqq/data/SystemMsg:getManagerUinFromTroopSysMsg	([BI)Ljava/lang/String;
    //   63: putfield 79	com/tencent/mobileqq/data/SystemMsg:managerUin	Ljava/lang/String;
    //   66: aload_1
    //   67: aload_2
    //   68: iload_3
    //   69: invokestatic 82	com/tencent/mobileqq/data/SystemMsg:getStrMsgFromTroopSysMsg	([BI)Ljava/lang/String;
    //   72: putfield 84	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   75: aload_1
    //   76: aload_2
    //   77: iload_3
    //   78: invokestatic 88	com/tencent/mobileqq/data/SystemMsg:getTroopOpFromTroopSysMsg	([BI)B
    //   81: putfield 90	com/tencent/mobileqq/data/SystemMsg:op	B
    //   84: aload_1
    //   85: aload_2
    //   86: iload_3
    //   87: invokestatic 93	com/tencent/mobileqq/data/SystemMsg:getRequestUinFromTroopSysMsg	([BI)Ljava/lang/String;
    //   90: putfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   93: aload_1
    //   94: aload_2
    //   95: iload_3
    //   96: invokestatic 99	com/tencent/mobileqq/data/SystemMsg:getAuthFromTroopSysMsg	([BI)[B
    //   99: putfield 101	com/tencent/mobileqq/data/SystemMsg:auth	[B
    //   102: aload_1
    //   103: aload_2
    //   104: iload_3
    //   105: invokestatic 104	com/tencent/mobileqq/data/SystemMsg:getInviteUinFromTroopSysMsg	([BI)Ljava/lang/String;
    //   108: putfield 106	com/tencent/mobileqq/data/SystemMsg:inviteMemUin	Ljava/lang/String;
    //   111: aload_0
    //   112: aload_1
    //   113: getfield 67	com/tencent/mobileqq/data/SystemMsg:troopCode	Ljava/lang/String;
    //   116: iconst_1
    //   117: invokestatic 112	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Z)Ljava/lang/String;
    //   120: astore_2
    //   121: aload_0
    //   122: aload_1
    //   123: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   126: iconst_1
    //   127: invokestatic 115	com/tencent/mobileqq/utils/ContactUtils:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Z)Ljava/lang/String;
    //   130: astore 10
    //   132: aload_0
    //   133: aload_1
    //   134: getfield 79	com/tencent/mobileqq/data/SystemMsg:managerUin	Ljava/lang/String;
    //   137: iconst_1
    //   138: invokestatic 115	com/tencent/mobileqq/utils/ContactUtils:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Z)Ljava/lang/String;
    //   141: astore 11
    //   143: aload_0
    //   144: aload_1
    //   145: getfield 106	com/tencent/mobileqq/data/SystemMsg:inviteMemUin	Ljava/lang/String;
    //   148: iconst_1
    //   149: invokestatic 115	com/tencent/mobileqq/utils/ContactUtils:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Z)Ljava/lang/String;
    //   152: astore 12
    //   154: iload_3
    //   155: bipush 46
    //   157: if_icmpeq +731 -> 888
    //   160: iload_3
    //   161: tableswitch	default:+31 -> 192, -1023:+727->888, -1022:+562->723, -1021:+444->605, -1020:+94->255
    //   193: tableswitch	default:+27 -> 220, 35:+62->255, 36:+412->605, 37:+530->723
    //   221: tableswitch	default:+31 -> 252, 84:+34->255, 85:+384->605, 86:+502->723, 87:+667->888
    //   253: iconst_4
    //   254: <illegal opcode>
    //   255: aload_1
    //   256: getfield 84	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   259: ifnull +26 -> 285
    //   262: ldc 39
    //   264: aload_1
    //   265: getfield 84	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   268: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   271: ifeq +6 -> 277
    //   274: goto +11 -> 285
    //   277: aload_1
    //   278: getfield 84	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   281: astore_0
    //   282: goto +12 -> 294
    //   285: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   288: ldc 128
    //   290: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   293: astore_0
    //   294: aload_1
    //   295: aload_0
    //   296: putfield 84	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   299: aload_1
    //   300: getfield 67	com/tencent/mobileqq/data/SystemMsg:troopCode	Ljava/lang/String;
    //   303: ifnull +144 -> 447
    //   306: aload_1
    //   307: getfield 67	com/tencent/mobileqq/data/SystemMsg:troopCode	Ljava/lang/String;
    //   310: aload_2
    //   311: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   314: ifne +133 -> 447
    //   317: aload_1
    //   318: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   321: ifnull +67 -> 388
    //   324: aload_1
    //   325: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   328: aload 10
    //   330: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   333: ifne +55 -> 388
    //   336: new 134	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   343: astore_0
    //   344: aload_0
    //   345: aload 10
    //   347: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: aload_0
    //   352: ldc 140
    //   354: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload_0
    //   359: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   362: ldc 141
    //   364: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   367: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: pop
    //   371: aload_0
    //   372: aload_2
    //   373: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: aload_1
    //   378: aload_0
    //   379: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: putfield 147	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   385: goto +1874 -> 2259
    //   388: new 134	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   395: astore_0
    //   396: aload_0
    //   397: ldc 149
    //   399: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: pop
    //   403: aload_0
    //   404: aload 10
    //   406: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: aload_0
    //   411: ldc 151
    //   413: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: aload_0
    //   418: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   421: ldc 141
    //   423: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   426: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: pop
    //   430: aload_0
    //   431: aload_2
    //   432: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: aload_1
    //   437: aload_0
    //   438: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   441: putfield 147	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   444: goto +1815 -> 2259
    //   447: aload_1
    //   448: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   451: ifnull +81 -> 532
    //   454: aload_1
    //   455: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   458: aload 10
    //   460: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   463: ifne +69 -> 532
    //   466: new 134	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   473: astore_0
    //   474: aload_0
    //   475: aload 10
    //   477: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: pop
    //   481: aload_0
    //   482: ldc 140
    //   484: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: pop
    //   488: aload_0
    //   489: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   492: ldc 141
    //   494: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   497: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: aload_0
    //   502: ldc 149
    //   504: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: pop
    //   508: aload_0
    //   509: aload_2
    //   510: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: pop
    //   514: aload_0
    //   515: ldc 149
    //   517: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: pop
    //   521: aload_1
    //   522: aload_0
    //   523: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   526: putfield 147	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   529: goto +1730 -> 2259
    //   532: new 134	java/lang/StringBuilder
    //   535: dup
    //   536: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   539: astore_0
    //   540: aload_0
    //   541: ldc 149
    //   543: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: pop
    //   547: aload_0
    //   548: aload 10
    //   550: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: pop
    //   554: aload_0
    //   555: ldc 151
    //   557: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: pop
    //   561: aload_0
    //   562: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   565: ldc 141
    //   567: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   570: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: pop
    //   574: aload_0
    //   575: ldc 149
    //   577: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: pop
    //   581: aload_0
    //   582: aload_2
    //   583: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: pop
    //   587: aload_0
    //   588: ldc 149
    //   590: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: pop
    //   594: aload_1
    //   595: aload_0
    //   596: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   599: putfield 147	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   602: goto +1657 -> 2259
    //   605: aload_1
    //   606: getfield 79	com/tencent/mobileqq/data/SystemMsg:managerUin	Ljava/lang/String;
    //   609: ifnull +61 -> 670
    //   612: aload_1
    //   613: getfield 79	com/tencent/mobileqq/data/SystemMsg:managerUin	Ljava/lang/String;
    //   616: aload 11
    //   618: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   621: ifne +49 -> 670
    //   624: new 134	java/lang/StringBuilder
    //   627: dup
    //   628: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   631: astore_0
    //   632: aload_0
    //   633: aload 11
    //   635: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: pop
    //   639: aload_0
    //   640: ldc 140
    //   642: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: pop
    //   646: aload_0
    //   647: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   650: ldc 152
    //   652: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   655: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: pop
    //   659: aload_1
    //   660: aload_0
    //   661: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   664: putfield 147	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   667: goto +1592 -> 2259
    //   670: new 134	java/lang/StringBuilder
    //   673: dup
    //   674: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   677: astore_0
    //   678: aload_0
    //   679: ldc 149
    //   681: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: pop
    //   685: aload_0
    //   686: aload 11
    //   688: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: pop
    //   692: aload_0
    //   693: ldc 151
    //   695: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: pop
    //   699: aload_0
    //   700: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   703: ldc 152
    //   705: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   708: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: pop
    //   712: aload_1
    //   713: aload_0
    //   714: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   717: putfield 147	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   720: goto +1539 -> 2259
    //   723: aload_1
    //   724: getfield 84	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   727: ifnull +29 -> 756
    //   730: ldc 39
    //   732: aload_1
    //   733: getfield 84	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   736: invokevirtual 155	java/lang/String:trim	()Ljava/lang/String;
    //   739: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   742: ifeq +6 -> 748
    //   745: goto +11 -> 756
    //   748: aload_1
    //   749: getfield 84	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   752: astore_0
    //   753: goto +12 -> 765
    //   756: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   759: ldc 128
    //   761: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   764: astore_0
    //   765: aload_1
    //   766: aload_0
    //   767: putfield 84	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   770: aload_1
    //   771: getfield 79	com/tencent/mobileqq/data/SystemMsg:managerUin	Ljava/lang/String;
    //   774: ifnull +61 -> 835
    //   777: aload_1
    //   778: getfield 79	com/tencent/mobileqq/data/SystemMsg:managerUin	Ljava/lang/String;
    //   781: aload 11
    //   783: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   786: ifne +49 -> 835
    //   789: new 134	java/lang/StringBuilder
    //   792: dup
    //   793: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   796: astore_0
    //   797: aload_0
    //   798: aload 11
    //   800: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: pop
    //   804: aload_0
    //   805: ldc 140
    //   807: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   810: pop
    //   811: aload_0
    //   812: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   815: ldc 156
    //   817: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   820: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: pop
    //   824: aload_1
    //   825: aload_0
    //   826: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   829: putfield 147	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   832: goto +1427 -> 2259
    //   835: new 134	java/lang/StringBuilder
    //   838: dup
    //   839: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   842: astore_0
    //   843: aload_0
    //   844: ldc 149
    //   846: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   849: pop
    //   850: aload_0
    //   851: aload 11
    //   853: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   856: pop
    //   857: aload_0
    //   858: ldc 151
    //   860: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   863: pop
    //   864: aload_0
    //   865: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   868: ldc 156
    //   870: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   873: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   876: pop
    //   877: aload_1
    //   878: aload_0
    //   879: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   882: putfield 147	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   885: goto +1374 -> 2259
    //   888: aload_1
    //   889: getfield 84	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   892: ifnull +26 -> 918
    //   895: ldc 39
    //   897: aload_1
    //   898: getfield 84	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   901: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   904: ifeq +6 -> 910
    //   907: goto +11 -> 918
    //   910: aload_1
    //   911: getfield 84	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   914: astore_0
    //   915: goto +12 -> 927
    //   918: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   921: ldc 128
    //   923: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   926: astore_0
    //   927: aload_1
    //   928: aload_0
    //   929: putfield 84	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   932: aload_1
    //   933: getfield 90	com/tencent/mobileqq/data/SystemMsg:op	B
    //   936: iconst_1
    //   937: if_icmpeq +1019 -> 1956
    //   940: aload_1
    //   941: getfield 90	com/tencent/mobileqq/data/SystemMsg:op	B
    //   944: iconst_4
    //   945: if_icmpne +6 -> 951
    //   948: goto +1008 -> 1956
    //   951: aload_1
    //   952: getfield 90	com/tencent/mobileqq/data/SystemMsg:op	B
    //   955: iconst_2
    //   956: if_icmpne +309 -> 1265
    //   959: aload_1
    //   960: getfield 67	com/tencent/mobileqq/data/SystemMsg:troopCode	Ljava/lang/String;
    //   963: ifnull +144 -> 1107
    //   966: aload_1
    //   967: getfield 67	com/tencent/mobileqq/data/SystemMsg:troopCode	Ljava/lang/String;
    //   970: aload_2
    //   971: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   974: ifne +133 -> 1107
    //   977: aload_1
    //   978: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   981: ifnull +67 -> 1048
    //   984: aload_1
    //   985: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   988: aload 10
    //   990: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   993: ifne +55 -> 1048
    //   996: new 134	java/lang/StringBuilder
    //   999: dup
    //   1000: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   1003: astore_0
    //   1004: aload_0
    //   1005: aload 10
    //   1007: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1010: pop
    //   1011: aload_0
    //   1012: ldc 140
    //   1014: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1017: pop
    //   1018: aload_0
    //   1019: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1022: ldc 157
    //   1024: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1027: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1030: pop
    //   1031: aload_0
    //   1032: aload_2
    //   1033: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1036: pop
    //   1037: aload_1
    //   1038: aload_0
    //   1039: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1042: putfield 147	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   1045: goto +1214 -> 2259
    //   1048: new 134	java/lang/StringBuilder
    //   1051: dup
    //   1052: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   1055: astore_0
    //   1056: aload_0
    //   1057: ldc 149
    //   1059: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1062: pop
    //   1063: aload_0
    //   1064: aload 10
    //   1066: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1069: pop
    //   1070: aload_0
    //   1071: ldc 151
    //   1073: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1076: pop
    //   1077: aload_0
    //   1078: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1081: ldc 157
    //   1083: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1086: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1089: pop
    //   1090: aload_0
    //   1091: aload_2
    //   1092: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1095: pop
    //   1096: aload_1
    //   1097: aload_0
    //   1098: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1101: putfield 147	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   1104: goto +1155 -> 2259
    //   1107: aload_1
    //   1108: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   1111: ifnull +81 -> 1192
    //   1114: aload_1
    //   1115: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   1118: aload 10
    //   1120: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1123: ifne +69 -> 1192
    //   1126: new 134	java/lang/StringBuilder
    //   1129: dup
    //   1130: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   1133: astore_0
    //   1134: aload_0
    //   1135: aload 10
    //   1137: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1140: pop
    //   1141: aload_0
    //   1142: ldc 140
    //   1144: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1147: pop
    //   1148: aload_0
    //   1149: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1152: ldc 157
    //   1154: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1157: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1160: pop
    //   1161: aload_0
    //   1162: ldc 149
    //   1164: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1167: pop
    //   1168: aload_0
    //   1169: aload_2
    //   1170: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1173: pop
    //   1174: aload_0
    //   1175: ldc 149
    //   1177: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1180: pop
    //   1181: aload_1
    //   1182: aload_0
    //   1183: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1186: putfield 147	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   1189: goto +1070 -> 2259
    //   1192: new 134	java/lang/StringBuilder
    //   1195: dup
    //   1196: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   1199: astore_0
    //   1200: aload_0
    //   1201: ldc 149
    //   1203: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1206: pop
    //   1207: aload_0
    //   1208: aload 10
    //   1210: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1213: pop
    //   1214: aload_0
    //   1215: ldc 151
    //   1217: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1220: pop
    //   1221: aload_0
    //   1222: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1225: ldc 157
    //   1227: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1230: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1233: pop
    //   1234: aload_0
    //   1235: ldc 149
    //   1237: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1240: pop
    //   1241: aload_0
    //   1242: aload_2
    //   1243: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1246: pop
    //   1247: aload_0
    //   1248: ldc 149
    //   1250: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1253: pop
    //   1254: aload_1
    //   1255: aload_0
    //   1256: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1259: putfield 147	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   1262: goto +997 -> 2259
    //   1265: aload_1
    //   1266: getfield 90	com/tencent/mobileqq/data/SystemMsg:op	B
    //   1269: iconst_3
    //   1270: if_icmpne +309 -> 1579
    //   1273: aload_1
    //   1274: getfield 67	com/tencent/mobileqq/data/SystemMsg:troopCode	Ljava/lang/String;
    //   1277: ifnull +144 -> 1421
    //   1280: aload_1
    //   1281: getfield 67	com/tencent/mobileqq/data/SystemMsg:troopCode	Ljava/lang/String;
    //   1284: aload_2
    //   1285: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1288: ifne +133 -> 1421
    //   1291: aload_1
    //   1292: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   1295: ifnull +67 -> 1362
    //   1298: aload_1
    //   1299: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   1302: aload 10
    //   1304: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1307: ifne +55 -> 1362
    //   1310: new 134	java/lang/StringBuilder
    //   1313: dup
    //   1314: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   1317: astore_0
    //   1318: aload_0
    //   1319: aload 10
    //   1321: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1324: pop
    //   1325: aload_0
    //   1326: ldc 140
    //   1328: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1331: pop
    //   1332: aload_0
    //   1333: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1336: ldc 158
    //   1338: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1341: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1344: pop
    //   1345: aload_0
    //   1346: aload_2
    //   1347: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1350: pop
    //   1351: aload_1
    //   1352: aload_0
    //   1353: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1356: putfield 147	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   1359: goto +900 -> 2259
    //   1362: new 134	java/lang/StringBuilder
    //   1365: dup
    //   1366: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   1369: astore_0
    //   1370: aload_0
    //   1371: ldc 149
    //   1373: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1376: pop
    //   1377: aload_0
    //   1378: aload 10
    //   1380: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1383: pop
    //   1384: aload_0
    //   1385: ldc 151
    //   1387: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1390: pop
    //   1391: aload_0
    //   1392: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1395: ldc 158
    //   1397: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1400: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1403: pop
    //   1404: aload_0
    //   1405: aload_2
    //   1406: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1409: pop
    //   1410: aload_1
    //   1411: aload_0
    //   1412: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1415: putfield 147	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   1418: goto +841 -> 2259
    //   1421: aload_1
    //   1422: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   1425: ifnull +81 -> 1506
    //   1428: aload_1
    //   1429: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   1432: aload 10
    //   1434: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1437: ifne +69 -> 1506
    //   1440: new 134	java/lang/StringBuilder
    //   1443: dup
    //   1444: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   1447: astore_0
    //   1448: aload_0
    //   1449: aload 10
    //   1451: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1454: pop
    //   1455: aload_0
    //   1456: ldc 140
    //   1458: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1461: pop
    //   1462: aload_0
    //   1463: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1466: ldc 158
    //   1468: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1471: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1474: pop
    //   1475: aload_0
    //   1476: ldc 149
    //   1478: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1481: pop
    //   1482: aload_0
    //   1483: aload_2
    //   1484: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1487: pop
    //   1488: aload_0
    //   1489: ldc 149
    //   1491: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1494: pop
    //   1495: aload_1
    //   1496: aload_0
    //   1497: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1500: putfield 147	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   1503: goto +756 -> 2259
    //   1506: new 134	java/lang/StringBuilder
    //   1509: dup
    //   1510: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   1513: astore_0
    //   1514: aload_0
    //   1515: ldc 149
    //   1517: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1520: pop
    //   1521: aload_0
    //   1522: aload 10
    //   1524: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1527: pop
    //   1528: aload_0
    //   1529: ldc 151
    //   1531: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1534: pop
    //   1535: aload_0
    //   1536: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1539: ldc 158
    //   1541: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1544: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1547: pop
    //   1548: aload_0
    //   1549: ldc 149
    //   1551: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1554: pop
    //   1555: aload_0
    //   1556: aload_2
    //   1557: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1560: pop
    //   1561: aload_0
    //   1562: ldc 149
    //   1564: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1567: pop
    //   1568: aload_1
    //   1569: aload_0
    //   1570: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1573: putfield 147	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   1576: goto +683 -> 2259
    //   1579: aload_1
    //   1580: getfield 90	com/tencent/mobileqq/data/SystemMsg:op	B
    //   1583: iconst_5
    //   1584: if_icmpne +675 -> 2259
    //   1587: aload_1
    //   1588: getfield 67	com/tencent/mobileqq/data/SystemMsg:troopCode	Ljava/lang/String;
    //   1591: ifnull +144 -> 1735
    //   1594: aload_1
    //   1595: getfield 67	com/tencent/mobileqq/data/SystemMsg:troopCode	Ljava/lang/String;
    //   1598: aload_2
    //   1599: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1602: ifne +133 -> 1735
    //   1605: aload_1
    //   1606: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   1609: ifnull +67 -> 1676
    //   1612: aload_1
    //   1613: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   1616: aload 10
    //   1618: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1621: ifne +55 -> 1676
    //   1624: new 134	java/lang/StringBuilder
    //   1627: dup
    //   1628: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   1631: astore_0
    //   1632: aload_0
    //   1633: aload 10
    //   1635: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1638: pop
    //   1639: aload_0
    //   1640: ldc 140
    //   1642: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1645: pop
    //   1646: aload_0
    //   1647: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1650: ldc 141
    //   1652: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1655: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1658: pop
    //   1659: aload_0
    //   1660: aload_2
    //   1661: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1664: pop
    //   1665: aload_1
    //   1666: aload_0
    //   1667: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1670: putfield 147	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   1673: goto +217 -> 1890
    //   1676: new 134	java/lang/StringBuilder
    //   1679: dup
    //   1680: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   1683: astore_0
    //   1684: aload_0
    //   1685: ldc 149
    //   1687: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1690: pop
    //   1691: aload_0
    //   1692: aload 10
    //   1694: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1697: pop
    //   1698: aload_0
    //   1699: ldc 151
    //   1701: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1704: pop
    //   1705: aload_0
    //   1706: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1709: ldc 141
    //   1711: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1714: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1717: pop
    //   1718: aload_0
    //   1719: aload_2
    //   1720: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1723: pop
    //   1724: aload_1
    //   1725: aload_0
    //   1726: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1729: putfield 147	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   1732: goto +158 -> 1890
    //   1735: aload_1
    //   1736: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   1739: ifnull +81 -> 1820
    //   1742: aload_1
    //   1743: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   1746: aload 10
    //   1748: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1751: ifne +69 -> 1820
    //   1754: new 134	java/lang/StringBuilder
    //   1757: dup
    //   1758: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   1761: astore_0
    //   1762: aload_0
    //   1763: aload 10
    //   1765: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1768: pop
    //   1769: aload_0
    //   1770: ldc 140
    //   1772: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1775: pop
    //   1776: aload_0
    //   1777: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1780: ldc 141
    //   1782: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1785: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1788: pop
    //   1789: aload_0
    //   1790: ldc 149
    //   1792: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1795: pop
    //   1796: aload_0
    //   1797: aload_2
    //   1798: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1801: pop
    //   1802: aload_0
    //   1803: ldc 149
    //   1805: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1808: pop
    //   1809: aload_1
    //   1810: aload_0
    //   1811: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1814: putfield 147	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   1817: goto +73 -> 1890
    //   1820: new 134	java/lang/StringBuilder
    //   1823: dup
    //   1824: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   1827: astore_0
    //   1828: aload_0
    //   1829: ldc 149
    //   1831: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1834: pop
    //   1835: aload_0
    //   1836: aload 10
    //   1838: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1841: pop
    //   1842: aload_0
    //   1843: ldc 151
    //   1845: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1848: pop
    //   1849: aload_0
    //   1850: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1853: ldc 141
    //   1855: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1858: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1861: pop
    //   1862: aload_0
    //   1863: ldc 149
    //   1865: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1868: pop
    //   1869: aload_0
    //   1870: aload_2
    //   1871: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1874: pop
    //   1875: aload_0
    //   1876: ldc 149
    //   1878: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1881: pop
    //   1882: aload_1
    //   1883: aload_0
    //   1884: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1887: putfield 147	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   1890: new 134	java/lang/StringBuilder
    //   1893: dup
    //   1894: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   1897: astore_0
    //   1898: aload_0
    //   1899: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1902: ldc 159
    //   1904: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1907: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1910: pop
    //   1911: aload_0
    //   1912: ldc 140
    //   1914: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1917: pop
    //   1918: aload_0
    //   1919: aload 12
    //   1921: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1924: pop
    //   1925: aload_0
    //   1926: ldc 140
    //   1928: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1931: pop
    //   1932: aload_0
    //   1933: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1936: ldc 160
    //   1938: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1941: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1944: pop
    //   1945: aload_1
    //   1946: aload_0
    //   1947: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1950: putfield 84	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   1953: goto +306 -> 2259
    //   1956: aload_1
    //   1957: getfield 67	com/tencent/mobileqq/data/SystemMsg:troopCode	Ljava/lang/String;
    //   1960: ifnull +144 -> 2104
    //   1963: aload_1
    //   1964: getfield 67	com/tencent/mobileqq/data/SystemMsg:troopCode	Ljava/lang/String;
    //   1967: aload_2
    //   1968: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1971: ifne +133 -> 2104
    //   1974: aload_1
    //   1975: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   1978: ifnull +67 -> 2045
    //   1981: aload_1
    //   1982: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   1985: aload 10
    //   1987: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1990: ifne +55 -> 2045
    //   1993: new 134	java/lang/StringBuilder
    //   1996: dup
    //   1997: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   2000: astore_0
    //   2001: aload_0
    //   2002: aload 10
    //   2004: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2007: pop
    //   2008: aload_0
    //   2009: ldc 140
    //   2011: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2014: pop
    //   2015: aload_0
    //   2016: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2019: ldc 161
    //   2021: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   2024: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2027: pop
    //   2028: aload_0
    //   2029: aload_2
    //   2030: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2033: pop
    //   2034: aload_1
    //   2035: aload_0
    //   2036: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2039: putfield 147	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   2042: goto +217 -> 2259
    //   2045: new 134	java/lang/StringBuilder
    //   2048: dup
    //   2049: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   2052: astore_0
    //   2053: aload_0
    //   2054: ldc 149
    //   2056: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2059: pop
    //   2060: aload_0
    //   2061: aload 10
    //   2063: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2066: pop
    //   2067: aload_0
    //   2068: ldc 151
    //   2070: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2073: pop
    //   2074: aload_0
    //   2075: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2078: ldc 161
    //   2080: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   2083: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2086: pop
    //   2087: aload_0
    //   2088: aload_2
    //   2089: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2092: pop
    //   2093: aload_1
    //   2094: aload_0
    //   2095: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2098: putfield 147	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   2101: goto +158 -> 2259
    //   2104: aload_1
    //   2105: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   2108: ifnull +81 -> 2189
    //   2111: aload_1
    //   2112: getfield 95	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   2115: aload 10
    //   2117: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2120: ifne +69 -> 2189
    //   2123: new 134	java/lang/StringBuilder
    //   2126: dup
    //   2127: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   2130: astore_0
    //   2131: aload_0
    //   2132: aload 10
    //   2134: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2137: pop
    //   2138: aload_0
    //   2139: ldc 140
    //   2141: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2144: pop
    //   2145: aload_0
    //   2146: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2149: ldc 161
    //   2151: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   2154: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2157: pop
    //   2158: aload_0
    //   2159: ldc 149
    //   2161: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2164: pop
    //   2165: aload_0
    //   2166: aload_2
    //   2167: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2170: pop
    //   2171: aload_0
    //   2172: ldc 149
    //   2174: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2177: pop
    //   2178: aload_1
    //   2179: aload_0
    //   2180: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2183: putfield 147	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   2186: goto +73 -> 2259
    //   2189: new 134	java/lang/StringBuilder
    //   2192: dup
    //   2193: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   2196: astore_0
    //   2197: aload_0
    //   2198: ldc 149
    //   2200: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2203: pop
    //   2204: aload_0
    //   2205: aload 10
    //   2207: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2210: pop
    //   2211: aload_0
    //   2212: ldc 151
    //   2214: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2217: pop
    //   2218: aload_0
    //   2219: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2222: ldc 161
    //   2224: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   2227: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2230: pop
    //   2231: aload_0
    //   2232: ldc 149
    //   2234: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2237: pop
    //   2238: aload_0
    //   2239: aload_2
    //   2240: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2243: pop
    //   2244: aload_0
    //   2245: ldc 149
    //   2247: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2250: pop
    //   2251: aload_1
    //   2252: aload_0
    //   2253: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2256: putfield 147	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   2259: aload_1
    //   2260: areturn
    //   2261: astore_2
    //   2262: aload_1
    //   2263: astore_0
    //   2264: aload_2
    //   2265: astore_1
    //   2266: goto +3198 -> 5464
    //   2269: astore_2
    //   2270: aload_1
    //   2271: astore_0
    //   2272: aload_2
    //   2273: astore_1
    //   2274: goto +3200 -> 5474
    //   2277: new 163	java/io/DataInputStream
    //   2280: dup
    //   2281: new 165	java/io/ByteArrayInputStream
    //   2284: dup
    //   2285: aload_1
    //   2286: invokestatic 60	com/tencent/mobileqq/utils/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   2289: invokespecial 168	java/io/ByteArrayInputStream:<init>	([B)V
    //   2292: invokespecial 171	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   2295: astore 14
    //   2297: iload_3
    //   2298: sipush -2004
    //   2301: if_icmpeq +3106 -> 5407
    //   2304: iload_3
    //   2305: sipush -2003
    //   2308: if_icmpeq +3055 -> 5363
    //   2311: iload_3
    //   2312: bipush 9
    //   2314: if_icmpeq +3049 -> 5363
    //   2317: iload_3
    //   2318: sipush 513
    //   2321: if_icmpeq +3086 -> 5407
    //   2324: iconst_0
    //   2325: istore 5
    //   2327: iconst_0
    //   2328: istore 6
    //   2330: iconst_0
    //   2331: istore 7
    //   2333: iconst_0
    //   2334: istore 8
    //   2336: iconst_0
    //   2337: istore 4
    //   2339: iload_3
    //   2340: tableswitch	default:+3194 -> 5534, -1010:+2508->4848, -1009:+1929->4269, -1008:+1388->3728, -1007:+842->3182, -1006:+83->2423
    //   2377: fconst_2
    //   2378: astore 10
    //   2380: aload_2
    //   2381: getstatic 176	com/tencent/mobileqq/app/AppConstants:QQBROADCAST_MSG_UIN	Ljava/lang/String;
    //   2384: invokestatic 180	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   2387: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2390: ifeq +3091 -> 5481
    //   2393: new 2	com/tencent/mobileqq/data/SystemMsg
    //   2396: dup
    //   2397: invokespecial 61	com/tencent/mobileqq/data/SystemMsg:<init>	()V
    //   2400: astore_1
    //   2401: aload_1
    //   2402: astore_0
    //   2403: aload_1
    //   2404: astore_2
    //   2405: aload_1
    //   2406: ldc 182
    //   2408: putfield 147	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   2411: aload_1
    //   2412: areturn
    //   2413: astore_1
    //   2414: goto +3050 -> 5464
    //   2417: astore_1
    //   2418: aload_2
    //   2419: astore_0
    //   2420: goto +3054 -> 5474
    //   2423: new 2	com/tencent/mobileqq/data/SystemMsg
    //   2426: dup
    //   2427: invokespecial 61	com/tencent/mobileqq/data/SystemMsg:<init>	()V
    //   2430: astore 10
    //   2432: aload 10
    //   2434: astore_1
    //   2435: aload 10
    //   2437: astore_0
    //   2438: aload 10
    //   2440: aload 14
    //   2442: invokevirtual 186	java/io/DataInputStream:readUnsignedByte	()I
    //   2445: putfield 188	com/tencent/mobileqq/data/SystemMsg:cVession	I
    //   2448: aload 10
    //   2450: astore_1
    //   2451: aload 10
    //   2453: astore_0
    //   2454: aload 14
    //   2456: invokevirtual 186	java/io/DataInputStream:readUnsignedByte	()I
    //   2459: newarray byte
    //   2461: astore 11
    //   2463: aload 10
    //   2465: astore_1
    //   2466: aload 10
    //   2468: astore_0
    //   2469: aload 14
    //   2471: aload 11
    //   2473: invokevirtual 192	java/io/DataInputStream:read	([B)I
    //   2476: pop
    //   2477: aload 10
    //   2479: astore_1
    //   2480: aload 10
    //   2482: astore_0
    //   2483: aload 10
    //   2485: new 117	java/lang/String
    //   2488: dup
    //   2489: aload 11
    //   2491: invokestatic 197	com/tencent/mobileqq/service/message/EmotionCodecUtils:a	([B)[B
    //   2494: ldc 199
    //   2496: invokespecial 202	java/lang/String:<init>	([BLjava/lang/String;)V
    //   2499: invokevirtual 155	java/lang/String:trim	()Ljava/lang/String;
    //   2502: putfield 84	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   2505: aload 10
    //   2507: astore_1
    //   2508: aload 10
    //   2510: astore_0
    //   2511: aload 14
    //   2513: lconst_1
    //   2514: invokevirtual 206	java/io/DataInputStream:skip	(J)J
    //   2517: pop2
    //   2518: aload 10
    //   2520: astore_1
    //   2521: aload 10
    //   2523: astore_0
    //   2524: aload 10
    //   2526: aload 14
    //   2528: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   2531: putfield 211	com/tencent/mobileqq/data/SystemMsg:wSourceID	I
    //   2534: aload 10
    //   2536: astore_1
    //   2537: aload 10
    //   2539: astore_0
    //   2540: aload 10
    //   2542: aload 14
    //   2544: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   2547: putfield 213	com/tencent/mobileqq/data/SystemMsg:wSourceSubID	I
    //   2550: aload 10
    //   2552: astore_1
    //   2553: aload 10
    //   2555: astore_0
    //   2556: aload 14
    //   2558: aload 14
    //   2560: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   2563: i2l
    //   2564: invokevirtual 206	java/io/DataInputStream:skip	(J)J
    //   2567: pop2
    //   2568: aload 10
    //   2570: astore_1
    //   2571: aload 10
    //   2573: astore_0
    //   2574: aload 14
    //   2576: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   2579: ifeq +2992 -> 5571
    //   2582: aload 10
    //   2584: astore_1
    //   2585: aload 10
    //   2587: astore_0
    //   2588: aload 14
    //   2590: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   2593: istore_3
    //   2594: goto +3 -> 2597
    //   2597: aload 10
    //   2599: astore_1
    //   2600: aload 10
    //   2602: astore_0
    //   2603: iload_3
    //   2604: newarray byte
    //   2606: astore 11
    //   2608: aload 10
    //   2610: astore_1
    //   2611: aload 10
    //   2613: astore_0
    //   2614: aload 14
    //   2616: aload 11
    //   2618: invokevirtual 192	java/io/DataInputStream:read	([B)I
    //   2621: pop
    //   2622: aload 10
    //   2624: astore_1
    //   2625: aload 10
    //   2627: astore_0
    //   2628: aload 11
    //   2630: arraylength
    //   2631: ifne +98 -> 2729
    //   2634: aload 10
    //   2636: astore_1
    //   2637: aload 10
    //   2639: astore_0
    //   2640: new 134	java/lang/StringBuilder
    //   2643: dup
    //   2644: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   2647: astore 11
    //   2649: aload 10
    //   2651: astore_1
    //   2652: aload 10
    //   2654: astore_0
    //   2655: aload 11
    //   2657: ldc 149
    //   2659: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2662: pop
    //   2663: aload 10
    //   2665: astore_1
    //   2666: aload 10
    //   2668: astore_0
    //   2669: aload 11
    //   2671: aload_2
    //   2672: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2675: pop
    //   2676: aload 10
    //   2678: astore_1
    //   2679: aload 10
    //   2681: astore_0
    //   2682: aload 11
    //   2684: ldc 149
    //   2686: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2689: pop
    //   2690: aload 10
    //   2692: astore_1
    //   2693: aload 10
    //   2695: astore_0
    //   2696: aload 11
    //   2698: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2701: ldc 214
    //   2703: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   2706: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2709: pop
    //   2710: aload 10
    //   2712: astore_1
    //   2713: aload 10
    //   2715: astore_0
    //   2716: aload 10
    //   2718: aload 11
    //   2720: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2723: putfield 147	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   2726: goto +107 -> 2833
    //   2729: aload 10
    //   2731: astore_1
    //   2732: aload 10
    //   2734: astore_0
    //   2735: aload 11
    //   2737: invokestatic 197	com/tencent/mobileqq/service/message/EmotionCodecUtils:a	([B)[B
    //   2740: pop
    //   2741: aload 10
    //   2743: astore_1
    //   2744: aload 10
    //   2746: astore_0
    //   2747: new 134	java/lang/StringBuilder
    //   2750: dup
    //   2751: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   2754: astore 11
    //   2756: aload 10
    //   2758: astore_1
    //   2759: aload 10
    //   2761: astore_0
    //   2762: aload 11
    //   2764: ldc 149
    //   2766: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2769: pop
    //   2770: aload 10
    //   2772: astore_1
    //   2773: aload 10
    //   2775: astore_0
    //   2776: aload 11
    //   2778: aload_2
    //   2779: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2782: pop
    //   2783: aload 10
    //   2785: astore_1
    //   2786: aload 10
    //   2788: astore_0
    //   2789: aload 11
    //   2791: ldc 149
    //   2793: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2796: pop
    //   2797: aload 10
    //   2799: astore_1
    //   2800: aload 10
    //   2802: astore_0
    //   2803: aload 11
    //   2805: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2808: ldc 214
    //   2810: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   2813: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2816: pop
    //   2817: aload 10
    //   2819: astore_1
    //   2820: aload 10
    //   2822: astore_0
    //   2823: aload 10
    //   2825: aload 11
    //   2827: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2830: putfield 147	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   2833: aload 10
    //   2835: astore_1
    //   2836: aload 10
    //   2838: astore_0
    //   2839: aload 14
    //   2841: ldc2_w 215
    //   2844: invokevirtual 206	java/io/DataInputStream:skip	(J)J
    //   2847: pop2
    //   2848: aload 10
    //   2850: astore_1
    //   2851: aload 10
    //   2853: astore_0
    //   2854: aload 14
    //   2856: aload 14
    //   2858: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   2861: newarray byte
    //   2863: invokevirtual 192	java/io/DataInputStream:read	([B)I
    //   2866: pop
    //   2867: aload 10
    //   2869: astore_1
    //   2870: aload 10
    //   2872: astore_0
    //   2873: aload 14
    //   2875: invokevirtual 186	java/io/DataInputStream:readUnsignedByte	()I
    //   2878: pop
    //   2879: aload 10
    //   2881: astore_1
    //   2882: aload 10
    //   2884: astore_0
    //   2885: aload 14
    //   2887: invokevirtual 186	java/io/DataInputStream:readUnsignedByte	()I
    //   2890: istore 5
    //   2892: iload 4
    //   2894: istore_3
    //   2895: aload 10
    //   2897: astore_0
    //   2898: iload_3
    //   2899: iload 5
    //   2901: if_icmpge +1366 -> 4267
    //   2904: aload 10
    //   2906: astore_1
    //   2907: aload 10
    //   2909: astore_0
    //   2910: aload 14
    //   2912: invokevirtual 220	java/io/DataInputStream:readShort	()S
    //   2915: istore 4
    //   2917: aload 10
    //   2919: astore_1
    //   2920: aload 10
    //   2922: astore_0
    //   2923: aload 14
    //   2925: invokevirtual 220	java/io/DataInputStream:readShort	()S
    //   2928: newarray byte
    //   2930: astore_2
    //   2931: aload 10
    //   2933: astore_1
    //   2934: aload 10
    //   2936: astore_0
    //   2937: aload 14
    //   2939: aload_2
    //   2940: invokevirtual 192	java/io/DataInputStream:read	([B)I
    //   2943: pop
    //   2944: iload 4
    //   2946: sipush 1000
    //   2949: if_icmpne +97 -> 3046
    //   2952: aload 10
    //   2954: astore_1
    //   2955: aload 10
    //   2957: astore_0
    //   2958: new 222	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo
    //   2961: dup
    //   2962: invokespecial 223	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo:<init>	()V
    //   2965: astore 11
    //   2967: aload 10
    //   2969: astore_0
    //   2970: aload 11
    //   2972: aload_2
    //   2973: invokevirtual 227	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2976: checkcast 222	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo
    //   2979: astore_2
    //   2980: goto +5 -> 2985
    //   2983: aconst_null
    //   2984: astore_2
    //   2985: aload_2
    //   2986: ifnull +189 -> 3175
    //   2989: aload 10
    //   2991: astore_1
    //   2992: aload 10
    //   2994: astore_0
    //   2995: aload 10
    //   2997: aload_2
    //   2998: getfield 231	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo:str_group_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3001: invokevirtual 236	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3004: putfield 238	com/tencent/mobileqq/data/SystemMsg:strGroupName	Ljava/lang/String;
    //   3007: aload 10
    //   3009: astore_1
    //   3010: aload 10
    //   3012: astore_0
    //   3013: aload 10
    //   3015: aload_2
    //   3016: getfield 241	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo:str_group_nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3019: invokevirtual 236	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3022: putfield 243	com/tencent/mobileqq/data/SystemMsg:strGroupNickName	Ljava/lang/String;
    //   3025: aload 10
    //   3027: astore_1
    //   3028: aload 10
    //   3030: astore_0
    //   3031: aload 10
    //   3033: aload_2
    //   3034: getfield 247	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo:uint64_group_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   3037: invokevirtual 252	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   3040: putfield 254	com/tencent/mobileqq/data/SystemMsg:strGroupUin	J
    //   3043: goto +132 -> 3175
    //   3046: iload 4
    //   3048: sipush 1001
    //   3051: if_icmpne +61 -> 3112
    //   3054: aload 10
    //   3056: astore_1
    //   3057: aload 10
    //   3059: astore_0
    //   3060: new 256	tencent/im/s2c/frdsysmsg/FrdSysMsg$TongXunLuNickInfo
    //   3063: dup
    //   3064: invokespecial 257	tencent/im/s2c/frdsysmsg/FrdSysMsg$TongXunLuNickInfo:<init>	()V
    //   3067: astore 11
    //   3069: aload 10
    //   3071: astore_0
    //   3072: aload 11
    //   3074: aload_2
    //   3075: invokevirtual 258	tencent/im/s2c/frdsysmsg/FrdSysMsg$TongXunLuNickInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3078: checkcast 256	tencent/im/s2c/frdsysmsg/FrdSysMsg$TongXunLuNickInfo
    //   3081: astore_2
    //   3082: goto +5 -> 3087
    //   3085: aconst_null
    //   3086: astore_2
    //   3087: aload_2
    //   3088: ifnull +87 -> 3175
    //   3091: aload 10
    //   3093: astore_1
    //   3094: aload 10
    //   3096: astore_0
    //   3097: aload 10
    //   3099: aload_2
    //   3100: getfield 261	tencent/im/s2c/frdsysmsg/FrdSysMsg$TongXunLuNickInfo:str_tongxunlu_nickname	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3103: invokevirtual 236	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3106: putfield 263	com/tencent/mobileqq/data/SystemMsg:strAddressBookNickName	Ljava/lang/String;
    //   3109: goto +66 -> 3175
    //   3112: iload 4
    //   3114: sipush 1002
    //   3117: if_icmpne +58 -> 3175
    //   3120: aload 10
    //   3122: astore_1
    //   3123: aload 10
    //   3125: astore_0
    //   3126: new 265	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo
    //   3129: dup
    //   3130: invokespecial 266	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:<init>	()V
    //   3133: astore 11
    //   3135: aload 10
    //   3137: astore_0
    //   3138: aload 11
    //   3140: aload_2
    //   3141: invokevirtual 267	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3144: checkcast 265	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo
    //   3147: astore_2
    //   3148: goto +5 -> 3153
    //   3151: aconst_null
    //   3152: astore_2
    //   3153: aload_2
    //   3154: ifnull +21 -> 3175
    //   3157: aload 10
    //   3159: astore_1
    //   3160: aload 10
    //   3162: astore_0
    //   3163: aload 10
    //   3165: aload_2
    //   3166: getfield 270	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:str_fromuin_nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3169: invokevirtual 236	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3172: putfield 41	com/tencent/mobileqq/data/SystemMsg:strServerFromUinNickName	Ljava/lang/String;
    //   3175: iload_3
    //   3176: iconst_1
    //   3177: iadd
    //   3178: istore_3
    //   3179: goto -284 -> 2895
    //   3182: new 2	com/tencent/mobileqq/data/SystemMsg
    //   3185: dup
    //   3186: invokespecial 61	com/tencent/mobileqq/data/SystemMsg:<init>	()V
    //   3189: astore 10
    //   3191: aload 10
    //   3193: astore_1
    //   3194: aload 10
    //   3196: astore_0
    //   3197: aload 10
    //   3199: aload 14
    //   3201: invokevirtual 186	java/io/DataInputStream:readUnsignedByte	()I
    //   3204: putfield 188	com/tencent/mobileqq/data/SystemMsg:cVession	I
    //   3207: aload 10
    //   3209: astore_1
    //   3210: aload 10
    //   3212: astore_0
    //   3213: aload 14
    //   3215: invokevirtual 186	java/io/DataInputStream:readUnsignedByte	()I
    //   3218: pop
    //   3219: aload 10
    //   3221: astore_1
    //   3222: aload 10
    //   3224: astore_0
    //   3225: aload 14
    //   3227: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   3230: ifeq +2346 -> 5576
    //   3233: aload 10
    //   3235: astore_1
    //   3236: aload 10
    //   3238: astore_0
    //   3239: aload 14
    //   3241: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   3244: istore_3
    //   3245: goto +3 -> 3248
    //   3248: aload 10
    //   3250: astore_1
    //   3251: aload 10
    //   3253: astore_0
    //   3254: iload_3
    //   3255: newarray byte
    //   3257: astore 11
    //   3259: aload 10
    //   3261: astore_1
    //   3262: aload 10
    //   3264: astore_0
    //   3265: aload 14
    //   3267: aload 11
    //   3269: invokevirtual 192	java/io/DataInputStream:read	([B)I
    //   3272: pop
    //   3273: aload 10
    //   3275: astore_1
    //   3276: aload 10
    //   3278: astore_0
    //   3279: aload 11
    //   3281: arraylength
    //   3282: ifne +99 -> 3381
    //   3285: aload 10
    //   3287: astore_1
    //   3288: aload 10
    //   3290: astore_0
    //   3291: new 134	java/lang/StringBuilder
    //   3294: dup
    //   3295: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   3298: astore 11
    //   3300: aload 10
    //   3302: astore_1
    //   3303: aload 10
    //   3305: astore_0
    //   3306: aload 11
    //   3308: ldc 149
    //   3310: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3313: pop
    //   3314: aload 10
    //   3316: astore_1
    //   3317: aload 10
    //   3319: astore_0
    //   3320: aload 11
    //   3322: aload_2
    //   3323: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3326: pop
    //   3327: aload 10
    //   3329: astore_1
    //   3330: aload 10
    //   3332: astore_0
    //   3333: aload 11
    //   3335: ldc 149
    //   3337: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3340: pop
    //   3341: aload 10
    //   3343: astore_1
    //   3344: aload 10
    //   3346: astore_0
    //   3347: aload 11
    //   3349: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3352: ldc_w 271
    //   3355: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   3358: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3361: pop
    //   3362: aload 10
    //   3364: astore_1
    //   3365: aload 10
    //   3367: astore_0
    //   3368: aload 10
    //   3370: aload 11
    //   3372: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3375: putfield 147	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   3378: goto +115 -> 3493
    //   3381: aload 10
    //   3383: astore_1
    //   3384: aload 10
    //   3386: astore_0
    //   3387: new 117	java/lang/String
    //   3390: dup
    //   3391: aload 11
    //   3393: invokestatic 197	com/tencent/mobileqq/service/message/EmotionCodecUtils:a	([B)[B
    //   3396: invokespecial 272	java/lang/String:<init>	([B)V
    //   3399: pop
    //   3400: aload 10
    //   3402: astore_1
    //   3403: aload 10
    //   3405: astore_0
    //   3406: new 134	java/lang/StringBuilder
    //   3409: dup
    //   3410: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   3413: astore 11
    //   3415: aload 10
    //   3417: astore_1
    //   3418: aload 10
    //   3420: astore_0
    //   3421: aload 11
    //   3423: ldc 149
    //   3425: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3428: pop
    //   3429: aload 10
    //   3431: astore_1
    //   3432: aload 10
    //   3434: astore_0
    //   3435: aload 11
    //   3437: aload_2
    //   3438: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3441: pop
    //   3442: aload 10
    //   3444: astore_1
    //   3445: aload 10
    //   3447: astore_0
    //   3448: aload 11
    //   3450: ldc 149
    //   3452: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3455: pop
    //   3456: aload 10
    //   3458: astore_1
    //   3459: aload 10
    //   3461: astore_0
    //   3462: aload 11
    //   3464: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3467: ldc_w 271
    //   3470: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   3473: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3476: pop
    //   3477: aload 10
    //   3479: astore_1
    //   3480: aload 10
    //   3482: astore_0
    //   3483: aload 10
    //   3485: aload 11
    //   3487: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3490: putfield 147	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   3493: aload 10
    //   3495: astore_1
    //   3496: aload 10
    //   3498: astore_0
    //   3499: aload 14
    //   3501: ldc2_w 215
    //   3504: invokevirtual 206	java/io/DataInputStream:skip	(J)J
    //   3507: pop2
    //   3508: aload 10
    //   3510: astore_1
    //   3511: aload 10
    //   3513: astore_0
    //   3514: aload 14
    //   3516: aload 14
    //   3518: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   3521: newarray byte
    //   3523: invokevirtual 192	java/io/DataInputStream:read	([B)I
    //   3526: pop
    //   3527: aload 10
    //   3529: astore_1
    //   3530: aload 10
    //   3532: astore_0
    //   3533: aload 14
    //   3535: invokevirtual 186	java/io/DataInputStream:readUnsignedByte	()I
    //   3538: istore 4
    //   3540: iload 5
    //   3542: istore_3
    //   3543: aload 10
    //   3545: astore_0
    //   3546: iload_3
    //   3547: iload 4
    //   3549: if_icmpge +718 -> 4267
    //   3552: aload 10
    //   3554: astore_1
    //   3555: aload 10
    //   3557: astore_0
    //   3558: aload 14
    //   3560: invokevirtual 220	java/io/DataInputStream:readShort	()S
    //   3563: istore 5
    //   3565: aload 10
    //   3567: astore_1
    //   3568: aload 10
    //   3570: astore_0
    //   3571: aload 14
    //   3573: invokevirtual 220	java/io/DataInputStream:readShort	()S
    //   3576: newarray byte
    //   3578: astore_2
    //   3579: aload 10
    //   3581: astore_1
    //   3582: aload 10
    //   3584: astore_0
    //   3585: aload 14
    //   3587: aload_2
    //   3588: invokevirtual 192	java/io/DataInputStream:read	([B)I
    //   3591: pop
    //   3592: iload 5
    //   3594: sipush 1002
    //   3597: if_icmpne +61 -> 3658
    //   3600: aload 10
    //   3602: astore_1
    //   3603: aload 10
    //   3605: astore_0
    //   3606: new 265	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo
    //   3609: dup
    //   3610: invokespecial 266	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:<init>	()V
    //   3613: astore 11
    //   3615: aload 10
    //   3617: astore_0
    //   3618: aload 11
    //   3620: aload_2
    //   3621: invokevirtual 267	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3624: checkcast 265	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo
    //   3627: astore_2
    //   3628: goto +5 -> 3633
    //   3631: aconst_null
    //   3632: astore_2
    //   3633: aload_2
    //   3634: ifnull +87 -> 3721
    //   3637: aload 10
    //   3639: astore_1
    //   3640: aload 10
    //   3642: astore_0
    //   3643: aload 10
    //   3645: aload_2
    //   3646: getfield 270	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:str_fromuin_nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3649: invokevirtual 236	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3652: putfield 41	com/tencent/mobileqq/data/SystemMsg:strServerFromUinNickName	Ljava/lang/String;
    //   3655: goto +66 -> 3721
    //   3658: iload 5
    //   3660: sipush 1003
    //   3663: if_icmpne +58 -> 3721
    //   3666: aload 10
    //   3668: astore_1
    //   3669: aload 10
    //   3671: astore_0
    //   3672: new 274	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendHelloInfo
    //   3675: dup
    //   3676: invokespecial 275	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendHelloInfo:<init>	()V
    //   3679: astore 11
    //   3681: aload 10
    //   3683: astore_0
    //   3684: aload 11
    //   3686: aload_2
    //   3687: invokevirtual 276	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendHelloInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3690: checkcast 274	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendHelloInfo
    //   3693: astore_2
    //   3694: goto +5 -> 3699
    //   3697: aconst_null
    //   3698: astore_2
    //   3699: aload_2
    //   3700: ifnull +21 -> 3721
    //   3703: aload 10
    //   3705: astore_1
    //   3706: aload 10
    //   3708: astore_0
    //   3709: aload 10
    //   3711: aload_2
    //   3712: getfield 279	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendHelloInfo:str_source_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3715: invokevirtual 236	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3718: putfield 43	com/tencent/mobileqq/data/SystemMsg:strGameName	Ljava/lang/String;
    //   3721: iload_3
    //   3722: iconst_1
    //   3723: iadd
    //   3724: istore_3
    //   3725: goto -182 -> 3543
    //   3728: new 2	com/tencent/mobileqq/data/SystemMsg
    //   3731: dup
    //   3732: invokespecial 61	com/tencent/mobileqq/data/SystemMsg:<init>	()V
    //   3735: astore 10
    //   3737: aload 10
    //   3739: astore_1
    //   3740: aload 10
    //   3742: astore_0
    //   3743: aload 10
    //   3745: aload 14
    //   3747: invokevirtual 186	java/io/DataInputStream:readUnsignedByte	()I
    //   3750: putfield 188	com/tencent/mobileqq/data/SystemMsg:cVession	I
    //   3753: aload 10
    //   3755: astore_1
    //   3756: aload 10
    //   3758: astore_0
    //   3759: aload 14
    //   3761: invokevirtual 186	java/io/DataInputStream:readUnsignedByte	()I
    //   3764: pop
    //   3765: aload 10
    //   3767: astore_1
    //   3768: aload 10
    //   3770: astore_0
    //   3771: aload 14
    //   3773: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   3776: ifeq +1805 -> 5581
    //   3779: aload 10
    //   3781: astore_1
    //   3782: aload 10
    //   3784: astore_0
    //   3785: aload 14
    //   3787: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   3790: istore_3
    //   3791: goto +3 -> 3794
    //   3794: aload 10
    //   3796: astore_1
    //   3797: aload 10
    //   3799: astore_0
    //   3800: iload_3
    //   3801: newarray byte
    //   3803: astore 11
    //   3805: aload 10
    //   3807: astore_1
    //   3808: aload 10
    //   3810: astore_0
    //   3811: aload 14
    //   3813: aload 11
    //   3815: invokevirtual 192	java/io/DataInputStream:read	([B)I
    //   3818: pop
    //   3819: aload 10
    //   3821: astore_1
    //   3822: aload 10
    //   3824: astore_0
    //   3825: aload 11
    //   3827: arraylength
    //   3828: ifne +99 -> 3927
    //   3831: aload 10
    //   3833: astore_1
    //   3834: aload 10
    //   3836: astore_0
    //   3837: new 134	java/lang/StringBuilder
    //   3840: dup
    //   3841: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   3844: astore 11
    //   3846: aload 10
    //   3848: astore_1
    //   3849: aload 10
    //   3851: astore_0
    //   3852: aload 11
    //   3854: ldc 149
    //   3856: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3859: pop
    //   3860: aload 10
    //   3862: astore_1
    //   3863: aload 10
    //   3865: astore_0
    //   3866: aload 11
    //   3868: aload_2
    //   3869: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3872: pop
    //   3873: aload 10
    //   3875: astore_1
    //   3876: aload 10
    //   3878: astore_0
    //   3879: aload 11
    //   3881: ldc 149
    //   3883: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3886: pop
    //   3887: aload 10
    //   3889: astore_1
    //   3890: aload 10
    //   3892: astore_0
    //   3893: aload 11
    //   3895: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3898: ldc_w 280
    //   3901: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   3904: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3907: pop
    //   3908: aload 10
    //   3910: astore_1
    //   3911: aload 10
    //   3913: astore_0
    //   3914: aload 10
    //   3916: aload 11
    //   3918: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3921: putfield 147	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   3924: goto +108 -> 4032
    //   3927: aload 10
    //   3929: astore_1
    //   3930: aload 10
    //   3932: astore_0
    //   3933: aload 11
    //   3935: invokestatic 197	com/tencent/mobileqq/service/message/EmotionCodecUtils:a	([B)[B
    //   3938: pop
    //   3939: aload 10
    //   3941: astore_1
    //   3942: aload 10
    //   3944: astore_0
    //   3945: new 134	java/lang/StringBuilder
    //   3948: dup
    //   3949: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   3952: astore 11
    //   3954: aload 10
    //   3956: astore_1
    //   3957: aload 10
    //   3959: astore_0
    //   3960: aload 11
    //   3962: ldc 149
    //   3964: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3967: pop
    //   3968: aload 10
    //   3970: astore_1
    //   3971: aload 10
    //   3973: astore_0
    //   3974: aload 11
    //   3976: aload_2
    //   3977: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3980: pop
    //   3981: aload 10
    //   3983: astore_1
    //   3984: aload 10
    //   3986: astore_0
    //   3987: aload 11
    //   3989: ldc 149
    //   3991: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3994: pop
    //   3995: aload 10
    //   3997: astore_1
    //   3998: aload 10
    //   4000: astore_0
    //   4001: aload 11
    //   4003: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4006: ldc_w 280
    //   4009: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   4012: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4015: pop
    //   4016: aload 10
    //   4018: astore_1
    //   4019: aload 10
    //   4021: astore_0
    //   4022: aload 10
    //   4024: aload 11
    //   4026: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4029: putfield 147	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   4032: aload 10
    //   4034: astore_1
    //   4035: aload 10
    //   4037: astore_0
    //   4038: aload 14
    //   4040: ldc2_w 215
    //   4043: invokevirtual 206	java/io/DataInputStream:skip	(J)J
    //   4046: pop2
    //   4047: aload 10
    //   4049: astore_1
    //   4050: aload 10
    //   4052: astore_0
    //   4053: aload 14
    //   4055: aload 14
    //   4057: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   4060: newarray byte
    //   4062: invokevirtual 192	java/io/DataInputStream:read	([B)I
    //   4065: pop
    //   4066: aload 10
    //   4068: astore_1
    //   4069: aload 10
    //   4071: astore_0
    //   4072: aload 14
    //   4074: invokevirtual 186	java/io/DataInputStream:readUnsignedByte	()I
    //   4077: istore 4
    //   4079: iload 6
    //   4081: istore_3
    //   4082: aload 10
    //   4084: astore_0
    //   4085: iload_3
    //   4086: iload 4
    //   4088: if_icmpge +179 -> 4267
    //   4091: aload 10
    //   4093: astore_1
    //   4094: aload 10
    //   4096: astore_0
    //   4097: aload 14
    //   4099: invokevirtual 220	java/io/DataInputStream:readShort	()S
    //   4102: istore 5
    //   4104: aload 10
    //   4106: astore_1
    //   4107: aload 10
    //   4109: astore_0
    //   4110: aload 14
    //   4112: invokevirtual 220	java/io/DataInputStream:readShort	()S
    //   4115: newarray byte
    //   4117: astore_2
    //   4118: aload 10
    //   4120: astore_1
    //   4121: aload 10
    //   4123: astore_0
    //   4124: aload 14
    //   4126: aload_2
    //   4127: invokevirtual 192	java/io/DataInputStream:read	([B)I
    //   4130: pop
    //   4131: iload 5
    //   4133: sipush 1002
    //   4136: if_icmpne +61 -> 4197
    //   4139: aload 10
    //   4141: astore_1
    //   4142: aload 10
    //   4144: astore_0
    //   4145: new 265	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo
    //   4148: dup
    //   4149: invokespecial 266	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:<init>	()V
    //   4152: astore 11
    //   4154: aload 10
    //   4156: astore_0
    //   4157: aload 11
    //   4159: aload_2
    //   4160: invokevirtual 267	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4163: checkcast 265	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo
    //   4166: astore_2
    //   4167: goto +5 -> 4172
    //   4170: aconst_null
    //   4171: astore_2
    //   4172: aload_2
    //   4173: ifnull +87 -> 4260
    //   4176: aload 10
    //   4178: astore_1
    //   4179: aload 10
    //   4181: astore_0
    //   4182: aload 10
    //   4184: aload_2
    //   4185: getfield 270	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:str_fromuin_nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4188: invokevirtual 236	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   4191: putfield 41	com/tencent/mobileqq/data/SystemMsg:strServerFromUinNickName	Ljava/lang/String;
    //   4194: goto +66 -> 4260
    //   4197: iload 5
    //   4199: sipush 1003
    //   4202: if_icmpne +58 -> 4260
    //   4205: aload 10
    //   4207: astore_1
    //   4208: aload 10
    //   4210: astore_0
    //   4211: new 274	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendHelloInfo
    //   4214: dup
    //   4215: invokespecial 275	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendHelloInfo:<init>	()V
    //   4218: astore 11
    //   4220: aload 10
    //   4222: astore_0
    //   4223: aload 11
    //   4225: aload_2
    //   4226: invokevirtual 276	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendHelloInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4229: checkcast 274	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendHelloInfo
    //   4232: astore_2
    //   4233: goto +5 -> 4238
    //   4236: aconst_null
    //   4237: astore_2
    //   4238: aload_2
    //   4239: ifnull +21 -> 4260
    //   4242: aload 10
    //   4244: astore_1
    //   4245: aload 10
    //   4247: astore_0
    //   4248: aload 10
    //   4250: aload_2
    //   4251: getfield 279	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendHelloInfo:str_source_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4254: invokevirtual 236	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   4257: putfield 43	com/tencent/mobileqq/data/SystemMsg:strGameName	Ljava/lang/String;
    //   4260: iload_3
    //   4261: iconst_1
    //   4262: iadd
    //   4263: istore_3
    //   4264: goto -182 -> 4082
    //   4267: aload_0
    //   4268: areturn
    //   4269: new 2	com/tencent/mobileqq/data/SystemMsg
    //   4272: dup
    //   4273: invokespecial 61	com/tencent/mobileqq/data/SystemMsg:<init>	()V
    //   4276: astore 10
    //   4278: aload 10
    //   4280: astore_1
    //   4281: aload 10
    //   4283: astore_0
    //   4284: aload 10
    //   4286: aload 14
    //   4288: invokevirtual 186	java/io/DataInputStream:readUnsignedByte	()I
    //   4291: putfield 188	com/tencent/mobileqq/data/SystemMsg:cVession	I
    //   4294: aload 10
    //   4296: astore_1
    //   4297: aload 10
    //   4299: astore_0
    //   4300: aload 14
    //   4302: invokevirtual 186	java/io/DataInputStream:readUnsignedByte	()I
    //   4305: newarray byte
    //   4307: astore 11
    //   4309: aload 10
    //   4311: astore_1
    //   4312: aload 10
    //   4314: astore_0
    //   4315: aload 14
    //   4317: aload 11
    //   4319: invokevirtual 192	java/io/DataInputStream:read	([B)I
    //   4322: pop
    //   4323: aload 10
    //   4325: astore_1
    //   4326: aload 10
    //   4328: astore_0
    //   4329: new 117	java/lang/String
    //   4332: dup
    //   4333: aload 11
    //   4335: invokestatic 197	com/tencent/mobileqq/service/message/EmotionCodecUtils:a	([B)[B
    //   4338: invokespecial 272	java/lang/String:<init>	([B)V
    //   4341: invokevirtual 155	java/lang/String:trim	()Ljava/lang/String;
    //   4344: astore 12
    //   4346: aload 12
    //   4348: ifnull +23 -> 4371
    //   4351: aload 12
    //   4353: astore 11
    //   4355: aload 10
    //   4357: astore_1
    //   4358: aload 10
    //   4360: astore_0
    //   4361: ldc 39
    //   4363: aload 12
    //   4365: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4368: ifeq +19 -> 4387
    //   4371: aload 10
    //   4373: astore_1
    //   4374: aload 10
    //   4376: astore_0
    //   4377: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4380: ldc 128
    //   4382: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   4385: astore 11
    //   4387: aload 10
    //   4389: astore_1
    //   4390: aload 10
    //   4392: astore_0
    //   4393: aload 10
    //   4395: aload 11
    //   4397: putfield 84	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   4400: aload 10
    //   4402: astore_1
    //   4403: aload 10
    //   4405: astore_0
    //   4406: aload 14
    //   4408: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   4411: ifeq +1175 -> 5586
    //   4414: aload 10
    //   4416: astore_1
    //   4417: aload 10
    //   4419: astore_0
    //   4420: aload 14
    //   4422: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   4425: istore_3
    //   4426: goto +3 -> 4429
    //   4429: aload 10
    //   4431: astore_1
    //   4432: aload 10
    //   4434: astore_0
    //   4435: iload_3
    //   4436: newarray byte
    //   4438: astore 11
    //   4440: aload 10
    //   4442: astore_1
    //   4443: aload 10
    //   4445: astore_0
    //   4446: aload 14
    //   4448: aload 11
    //   4450: invokevirtual 192	java/io/DataInputStream:read	([B)I
    //   4453: pop
    //   4454: aload 10
    //   4456: astore_1
    //   4457: aload 10
    //   4459: astore_0
    //   4460: aload 11
    //   4462: arraylength
    //   4463: ifne +99 -> 4562
    //   4466: aload 10
    //   4468: astore_1
    //   4469: aload 10
    //   4471: astore_0
    //   4472: new 134	java/lang/StringBuilder
    //   4475: dup
    //   4476: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   4479: astore 11
    //   4481: aload 10
    //   4483: astore_1
    //   4484: aload 10
    //   4486: astore_0
    //   4487: aload 11
    //   4489: ldc 149
    //   4491: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4494: pop
    //   4495: aload 10
    //   4497: astore_1
    //   4498: aload 10
    //   4500: astore_0
    //   4501: aload 11
    //   4503: aload_2
    //   4504: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4507: pop
    //   4508: aload 10
    //   4510: astore_1
    //   4511: aload 10
    //   4513: astore_0
    //   4514: aload 11
    //   4516: ldc 149
    //   4518: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4521: pop
    //   4522: aload 10
    //   4524: astore_1
    //   4525: aload 10
    //   4527: astore_0
    //   4528: aload 11
    //   4530: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4533: ldc_w 281
    //   4536: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   4539: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4542: pop
    //   4543: aload 10
    //   4545: astore_1
    //   4546: aload 10
    //   4548: astore_0
    //   4549: aload 10
    //   4551: aload 11
    //   4553: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4556: putfield 147	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   4559: goto +108 -> 4667
    //   4562: aload 10
    //   4564: astore_1
    //   4565: aload 10
    //   4567: astore_0
    //   4568: aload 11
    //   4570: invokestatic 197	com/tencent/mobileqq/service/message/EmotionCodecUtils:a	([B)[B
    //   4573: pop
    //   4574: aload 10
    //   4576: astore_1
    //   4577: aload 10
    //   4579: astore_0
    //   4580: new 134	java/lang/StringBuilder
    //   4583: dup
    //   4584: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   4587: astore 11
    //   4589: aload 10
    //   4591: astore_1
    //   4592: aload 10
    //   4594: astore_0
    //   4595: aload 11
    //   4597: ldc 149
    //   4599: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4602: pop
    //   4603: aload 10
    //   4605: astore_1
    //   4606: aload 10
    //   4608: astore_0
    //   4609: aload 11
    //   4611: aload_2
    //   4612: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4615: pop
    //   4616: aload 10
    //   4618: astore_1
    //   4619: aload 10
    //   4621: astore_0
    //   4622: aload 11
    //   4624: ldc 149
    //   4626: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4629: pop
    //   4630: aload 10
    //   4632: astore_1
    //   4633: aload 10
    //   4635: astore_0
    //   4636: aload 11
    //   4638: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4641: ldc_w 281
    //   4644: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   4647: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4650: pop
    //   4651: aload 10
    //   4653: astore_1
    //   4654: aload 10
    //   4656: astore_0
    //   4657: aload 10
    //   4659: aload 11
    //   4661: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4664: putfield 147	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   4667: aload 10
    //   4669: astore_1
    //   4670: aload 10
    //   4672: astore_0
    //   4673: aload 14
    //   4675: ldc2_w 215
    //   4678: invokevirtual 206	java/io/DataInputStream:skip	(J)J
    //   4681: pop2
    //   4682: aload 10
    //   4684: astore_1
    //   4685: aload 10
    //   4687: astore_0
    //   4688: aload 14
    //   4690: aload 14
    //   4692: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   4695: newarray byte
    //   4697: invokevirtual 192	java/io/DataInputStream:read	([B)I
    //   4700: pop
    //   4701: aload 10
    //   4703: astore_1
    //   4704: aload 10
    //   4706: astore_0
    //   4707: aload 14
    //   4709: invokevirtual 186	java/io/DataInputStream:readUnsignedByte	()I
    //   4712: pop
    //   4713: aload 10
    //   4715: astore_1
    //   4716: aload 10
    //   4718: astore_0
    //   4719: aload 14
    //   4721: invokevirtual 186	java/io/DataInputStream:readUnsignedByte	()I
    //   4724: istore 4
    //   4726: iload 7
    //   4728: istore_3
    //   4729: aload 10
    //   4731: astore_0
    //   4732: iload_3
    //   4733: iload 4
    //   4735: if_icmpge -468 -> 4267
    //   4738: aload 10
    //   4740: astore_1
    //   4741: aload 10
    //   4743: astore_0
    //   4744: aload 14
    //   4746: invokevirtual 220	java/io/DataInputStream:readShort	()S
    //   4749: istore 5
    //   4751: aload 10
    //   4753: astore_1
    //   4754: aload 10
    //   4756: astore_0
    //   4757: aload 14
    //   4759: invokevirtual 220	java/io/DataInputStream:readShort	()S
    //   4762: newarray byte
    //   4764: astore_2
    //   4765: aload 10
    //   4767: astore_1
    //   4768: aload 10
    //   4770: astore_0
    //   4771: aload 14
    //   4773: aload_2
    //   4774: invokevirtual 192	java/io/DataInputStream:read	([B)I
    //   4777: pop
    //   4778: iload 5
    //   4780: sipush 1002
    //   4783: if_icmpne +58 -> 4841
    //   4786: aload 10
    //   4788: astore_1
    //   4789: aload 10
    //   4791: astore_0
    //   4792: new 265	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo
    //   4795: dup
    //   4796: invokespecial 266	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:<init>	()V
    //   4799: astore 11
    //   4801: aload 10
    //   4803: astore_0
    //   4804: aload 11
    //   4806: aload_2
    //   4807: invokevirtual 267	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4810: checkcast 265	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo
    //   4813: astore_2
    //   4814: goto +5 -> 4819
    //   4817: aconst_null
    //   4818: astore_2
    //   4819: aload_2
    //   4820: ifnull +21 -> 4841
    //   4823: aload 10
    //   4825: astore_1
    //   4826: aload 10
    //   4828: astore_0
    //   4829: aload 10
    //   4831: aload_2
    //   4832: getfield 270	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:str_fromuin_nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4835: invokevirtual 236	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   4838: putfield 41	com/tencent/mobileqq/data/SystemMsg:strServerFromUinNickName	Ljava/lang/String;
    //   4841: iload_3
    //   4842: iconst_1
    //   4843: iadd
    //   4844: istore_3
    //   4845: goto -116 -> 4729
    //   4848: new 2	com/tencent/mobileqq/data/SystemMsg
    //   4851: dup
    //   4852: invokespecial 61	com/tencent/mobileqq/data/SystemMsg:<init>	()V
    //   4855: astore 10
    //   4857: aload 10
    //   4859: astore_1
    //   4860: aload 10
    //   4862: astore_0
    //   4863: new 134	java/lang/StringBuilder
    //   4866: dup
    //   4867: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   4870: astore 11
    //   4872: aload 10
    //   4874: astore_1
    //   4875: aload 10
    //   4877: astore_0
    //   4878: aload 11
    //   4880: ldc 149
    //   4882: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4885: pop
    //   4886: aload 10
    //   4888: astore_1
    //   4889: aload 10
    //   4891: astore_0
    //   4892: aload 11
    //   4894: aload_2
    //   4895: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4898: pop
    //   4899: aload 10
    //   4901: astore_1
    //   4902: aload 10
    //   4904: astore_0
    //   4905: aload 11
    //   4907: ldc 149
    //   4909: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4912: pop
    //   4913: aload 10
    //   4915: astore_1
    //   4916: aload 10
    //   4918: astore_0
    //   4919: aload 11
    //   4921: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4924: ldc_w 282
    //   4927: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   4930: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4933: pop
    //   4934: aload 10
    //   4936: astore_1
    //   4937: aload 10
    //   4939: astore_0
    //   4940: aload 10
    //   4942: aload 11
    //   4944: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4947: putfield 147	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   4950: aload 10
    //   4952: astore_0
    //   4953: new 2	com/tencent/mobileqq/data/SystemMsg
    //   4956: dup
    //   4957: invokespecial 61	com/tencent/mobileqq/data/SystemMsg:<init>	()V
    //   4960: astore_1
    //   4961: aload_1
    //   4962: aload 14
    //   4964: invokevirtual 186	java/io/DataInputStream:readUnsignedByte	()I
    //   4967: putfield 188	com/tencent/mobileqq/data/SystemMsg:cVession	I
    //   4970: aload 14
    //   4972: aload 14
    //   4974: invokevirtual 186	java/io/DataInputStream:readUnsignedByte	()I
    //   4977: newarray byte
    //   4979: invokevirtual 192	java/io/DataInputStream:read	([B)I
    //   4982: pop
    //   4983: aload_1
    //   4984: aload 14
    //   4986: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   4989: putfield 211	com/tencent/mobileqq/data/SystemMsg:wSourceID	I
    //   4992: aload_1
    //   4993: aload 14
    //   4995: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   4998: putfield 213	com/tencent/mobileqq/data/SystemMsg:wSourceSubID	I
    //   5001: aload 14
    //   5003: aload 14
    //   5005: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   5008: i2l
    //   5009: invokevirtual 206	java/io/DataInputStream:skip	(J)J
    //   5012: pop2
    //   5013: aload 14
    //   5015: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   5018: ifeq +573 -> 5591
    //   5021: aload 14
    //   5023: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   5026: istore_3
    //   5027: goto +3 -> 5030
    //   5030: iload_3
    //   5031: newarray byte
    //   5033: astore_0
    //   5034: aload 14
    //   5036: aload_0
    //   5037: invokevirtual 192	java/io/DataInputStream:read	([B)I
    //   5040: pop
    //   5041: aload_0
    //   5042: arraylength
    //   5043: ifne +56 -> 5099
    //   5046: new 134	java/lang/StringBuilder
    //   5049: dup
    //   5050: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   5053: astore_0
    //   5054: aload_0
    //   5055: ldc 149
    //   5057: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5060: pop
    //   5061: aload_0
    //   5062: aload_2
    //   5063: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5066: pop
    //   5067: aload_0
    //   5068: ldc 149
    //   5070: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5073: pop
    //   5074: aload_0
    //   5075: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   5078: ldc_w 282
    //   5081: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   5084: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5087: pop
    //   5088: aload_1
    //   5089: aload_0
    //   5090: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5093: putfield 147	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   5096: goto +58 -> 5154
    //   5099: aload_0
    //   5100: invokestatic 197	com/tencent/mobileqq/service/message/EmotionCodecUtils:a	([B)[B
    //   5103: pop
    //   5104: new 134	java/lang/StringBuilder
    //   5107: dup
    //   5108: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   5111: astore_0
    //   5112: aload_0
    //   5113: ldc 149
    //   5115: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5118: pop
    //   5119: aload_0
    //   5120: aload_2
    //   5121: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5124: pop
    //   5125: aload_0
    //   5126: ldc 149
    //   5128: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5131: pop
    //   5132: aload_0
    //   5133: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   5136: ldc_w 282
    //   5139: invokevirtual 132	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   5142: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5145: pop
    //   5146: aload_1
    //   5147: aload_0
    //   5148: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5151: putfield 147	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   5154: aload 14
    //   5156: ldc2_w 215
    //   5159: invokevirtual 206	java/io/DataInputStream:skip	(J)J
    //   5162: pop2
    //   5163: aload 14
    //   5165: aload 14
    //   5167: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   5170: newarray byte
    //   5172: invokevirtual 192	java/io/DataInputStream:read	([B)I
    //   5175: pop
    //   5176: aload 14
    //   5178: invokevirtual 186	java/io/DataInputStream:readUnsignedByte	()I
    //   5181: istore 4
    //   5183: iload 8
    //   5185: istore_3
    //   5186: aload_1
    //   5187: astore_0
    //   5188: iload_3
    //   5189: iload 4
    //   5191: if_icmpge +158 -> 5349
    //   5194: aload 14
    //   5196: invokevirtual 220	java/io/DataInputStream:readShort	()S
    //   5199: istore 5
    //   5201: aload 14
    //   5203: invokevirtual 220	java/io/DataInputStream:readShort	()S
    //   5206: newarray byte
    //   5208: astore_0
    //   5209: aload 14
    //   5211: aload_0
    //   5212: invokevirtual 192	java/io/DataInputStream:read	([B)I
    //   5215: pop
    //   5216: iload 5
    //   5218: sipush 1000
    //   5221: if_icmpne +65 -> 5286
    //   5224: new 222	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo
    //   5227: dup
    //   5228: invokespecial 223	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo:<init>	()V
    //   5231: astore_2
    //   5232: aload_2
    //   5233: aload_0
    //   5234: invokevirtual 227	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5237: checkcast 222	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo
    //   5240: astore_0
    //   5241: goto +5 -> 5246
    //   5244: aconst_null
    //   5245: astore_0
    //   5246: aload_0
    //   5247: ifnull +84 -> 5331
    //   5250: aload_1
    //   5251: aload_0
    //   5252: getfield 231	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo:str_group_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5255: invokevirtual 236	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   5258: putfield 238	com/tencent/mobileqq/data/SystemMsg:strGroupName	Ljava/lang/String;
    //   5261: aload_1
    //   5262: aload_0
    //   5263: getfield 241	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo:str_group_nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5266: invokevirtual 236	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   5269: putfield 243	com/tencent/mobileqq/data/SystemMsg:strGroupNickName	Ljava/lang/String;
    //   5272: aload_1
    //   5273: aload_0
    //   5274: getfield 247	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo:uint64_group_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5277: invokevirtual 252	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5280: putfield 254	com/tencent/mobileqq/data/SystemMsg:strGroupUin	J
    //   5283: goto +48 -> 5331
    //   5286: iload 5
    //   5288: sipush 1002
    //   5291: if_icmpne +40 -> 5331
    //   5294: new 265	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo
    //   5297: dup
    //   5298: invokespecial 266	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:<init>	()V
    //   5301: astore_2
    //   5302: aload_2
    //   5303: aload_0
    //   5304: invokevirtual 267	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5307: checkcast 265	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo
    //   5310: astore_0
    //   5311: goto +5 -> 5316
    //   5314: aconst_null
    //   5315: astore_0
    //   5316: aload_0
    //   5317: ifnull +14 -> 5331
    //   5320: aload_1
    //   5321: aload_0
    //   5322: getfield 270	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:str_fromuin_nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5325: invokevirtual 236	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   5328: putfield 41	com/tencent/mobileqq/data/SystemMsg:strServerFromUinNickName	Ljava/lang/String;
    //   5331: iload_3
    //   5332: iconst_1
    //   5333: iadd
    //   5334: istore_3
    //   5335: goto -149 -> 5186
    //   5338: astore_2
    //   5339: aload_1
    //   5340: astore_0
    //   5341: aload_2
    //   5342: astore_1
    //   5343: goto +131 -> 5474
    //   5346: aload 10
    //   5348: astore_0
    //   5349: aload_0
    //   5350: areturn
    //   5351: astore_2
    //   5352: aload_1
    //   5353: astore_0
    //   5354: aload_2
    //   5355: astore_1
    //   5356: goto +108 -> 5464
    //   5359: astore_1
    //   5360: goto +114 -> 5474
    //   5363: aload 13
    //   5365: astore 10
    //   5367: aload_2
    //   5368: getstatic 176	com/tencent/mobileqq/app/AppConstants:QQBROADCAST_MSG_UIN	Ljava/lang/String;
    //   5371: invokestatic 180	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   5374: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5377: ifeq +104 -> 5481
    //   5380: new 2	com/tencent/mobileqq/data/SystemMsg
    //   5383: dup
    //   5384: invokespecial 61	com/tencent/mobileqq/data/SystemMsg:<init>	()V
    //   5387: astore 10
    //   5389: aload 10
    //   5391: astore_0
    //   5392: aload 10
    //   5394: astore_2
    //   5395: aload 10
    //   5397: aload_1
    //   5398: putfield 147	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   5401: aload 10
    //   5403: astore_1
    //   5404: goto -2993 -> 2411
    //   5407: aload 13
    //   5409: astore 10
    //   5411: aload_2
    //   5412: getstatic 176	com/tencent/mobileqq/app/AppConstants:QQBROADCAST_MSG_UIN	Ljava/lang/String;
    //   5415: invokestatic 180	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   5418: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5421: ifeq +60 -> 5481
    //   5424: new 2	com/tencent/mobileqq/data/SystemMsg
    //   5427: dup
    //   5428: invokespecial 61	com/tencent/mobileqq/data/SystemMsg:<init>	()V
    //   5431: astore 10
    //   5433: aload 10
    //   5435: astore_0
    //   5436: aload 10
    //   5438: astore_2
    //   5439: aload 10
    //   5441: ldc_w 284
    //   5444: aload_1
    //   5445: invokestatic 290	com/tencent/mobileqq/utils/httputils/PkgTools:getParaVal	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   5448: invokestatic 294	com/tencent/mobileqq/utils/httputils/PkgTools:decodeCgi	(Ljava/lang/String;)Ljava/lang/String;
    //   5451: putfield 147	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   5454: aload 10
    //   5456: astore_1
    //   5457: goto -3046 -> 2411
    //   5460: astore_1
    //   5461: aload 11
    //   5463: astore_0
    //   5464: aload_1
    //   5465: invokevirtual 297	java/lang/Exception:printStackTrace	()V
    //   5468: aload_0
    //   5469: areturn
    //   5470: astore_1
    //   5471: aload 12
    //   5473: astore_0
    //   5474: aload_1
    //   5475: invokevirtual 298	java/io/IOException:printStackTrace	()V
    //   5478: aload_0
    //   5479: astore 10
    //   5481: aload 10
    //   5483: areturn
    //   5484: astore_0
    //   5485: goto -2502 -> 2983
    //   5488: astore_0
    //   5489: goto -2404 -> 3085
    //   5492: astore_0
    //   5493: goto -2342 -> 3151
    //   5496: astore_0
    //   5497: goto -1866 -> 3631
    //   5500: astore_0
    //   5501: goto -1804 -> 3697
    //   5504: astore_0
    //   5505: goto -1335 -> 4170
    //   5508: astore_0
    //   5509: goto -1273 -> 4236
    //   5512: astore_0
    //   5513: goto -696 -> 4817
    //   5516: astore_0
    //   5517: goto -171 -> 5346
    //   5520: astore_0
    //   5521: aload_1
    //   5522: astore_0
    //   5523: goto -174 -> 5349
    //   5526: astore_0
    //   5527: goto -283 -> 5244
    //   5530: astore_0
    //   5531: goto -217 -> 5314
    //   5534: iload_3
    //   5535: tableswitch	default:+33 -> 5568, 187:+-3112->2423, 188:+-2353->3182, 189:+-1807->3728, 190:+-1266->4269, 191:+-687->4848
    //   5569: <illegal opcode>
    //   5570: l2i
    //   5571: iconst_0
    //   5572: istore_3
    //   5573: goto -2976 -> 2597
    //   5576: iconst_0
    //   5577: istore_3
    //   5578: goto -2330 -> 3248
    //   5581: iconst_0
    //   5582: istore_3
    //   5583: goto -1789 -> 3794
    //   5586: iconst_0
    //   5587: istore_3
    //   5588: goto -1159 -> 4429
    //   5591: iconst_0
    //   5592: istore_3
    //   5593: goto -563 -> 5030
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5596	0	paramAppInterface	com.tencent.common.app.AppInterface
    //   0	5596	1	paramString1	String
    //   0	5596	2	paramString2	String
    //   0	5596	3	paramInt	int
    //   2337	2855	4	i	int
    //   2325	2967	5	j	int
    //   2328	1752	6	k	int
    //   2331	2396	7	m	int
    //   2334	2850	8	n	int
    //   21	3	9	bool	boolean
    //   11	5471	10	localObject1	Object
    //   7	5455	11	localObject2	Object
    //   1	5471	12	str	String
    //   4	5404	13	localObject3	Object
    //   2295	2915	14	localDataInputStream	java.io.DataInputStream
    // Exception table:
    //   from	to	target	type
    //   41	154	2261	java/lang/Exception
    //   255	274	2261	java/lang/Exception
    //   277	282	2261	java/lang/Exception
    //   285	294	2261	java/lang/Exception
    //   294	385	2261	java/lang/Exception
    //   388	444	2261	java/lang/Exception
    //   447	529	2261	java/lang/Exception
    //   532	602	2261	java/lang/Exception
    //   605	667	2261	java/lang/Exception
    //   670	720	2261	java/lang/Exception
    //   723	745	2261	java/lang/Exception
    //   748	753	2261	java/lang/Exception
    //   756	765	2261	java/lang/Exception
    //   765	832	2261	java/lang/Exception
    //   835	885	2261	java/lang/Exception
    //   888	907	2261	java/lang/Exception
    //   910	915	2261	java/lang/Exception
    //   918	927	2261	java/lang/Exception
    //   927	948	2261	java/lang/Exception
    //   951	1045	2261	java/lang/Exception
    //   1048	1104	2261	java/lang/Exception
    //   1107	1189	2261	java/lang/Exception
    //   1192	1262	2261	java/lang/Exception
    //   1265	1359	2261	java/lang/Exception
    //   1362	1418	2261	java/lang/Exception
    //   1421	1503	2261	java/lang/Exception
    //   1506	1576	2261	java/lang/Exception
    //   1579	1673	2261	java/lang/Exception
    //   1676	1732	2261	java/lang/Exception
    //   1735	1817	2261	java/lang/Exception
    //   1820	1890	2261	java/lang/Exception
    //   1890	1953	2261	java/lang/Exception
    //   1956	2042	2261	java/lang/Exception
    //   2045	2101	2261	java/lang/Exception
    //   2104	2186	2261	java/lang/Exception
    //   2189	2259	2261	java/lang/Exception
    //   41	154	2269	java/io/IOException
    //   255	274	2269	java/io/IOException
    //   277	282	2269	java/io/IOException
    //   285	294	2269	java/io/IOException
    //   294	385	2269	java/io/IOException
    //   388	444	2269	java/io/IOException
    //   447	529	2269	java/io/IOException
    //   532	602	2269	java/io/IOException
    //   605	667	2269	java/io/IOException
    //   670	720	2269	java/io/IOException
    //   723	745	2269	java/io/IOException
    //   748	753	2269	java/io/IOException
    //   756	765	2269	java/io/IOException
    //   765	832	2269	java/io/IOException
    //   835	885	2269	java/io/IOException
    //   888	907	2269	java/io/IOException
    //   910	915	2269	java/io/IOException
    //   918	927	2269	java/io/IOException
    //   927	948	2269	java/io/IOException
    //   951	1045	2269	java/io/IOException
    //   1048	1104	2269	java/io/IOException
    //   1107	1189	2269	java/io/IOException
    //   1192	1262	2269	java/io/IOException
    //   1265	1359	2269	java/io/IOException
    //   1362	1418	2269	java/io/IOException
    //   1421	1503	2269	java/io/IOException
    //   1506	1576	2269	java/io/IOException
    //   1579	1673	2269	java/io/IOException
    //   1676	1732	2269	java/io/IOException
    //   1735	1817	2269	java/io/IOException
    //   1820	1890	2269	java/io/IOException
    //   1890	1953	2269	java/io/IOException
    //   1956	2042	2269	java/io/IOException
    //   2045	2101	2269	java/io/IOException
    //   2104	2186	2269	java/io/IOException
    //   2189	2259	2269	java/io/IOException
    //   2405	2411	2413	java/lang/Exception
    //   5395	5401	2413	java/lang/Exception
    //   5439	5454	2413	java/lang/Exception
    //   2405	2411	2417	java/io/IOException
    //   5395	5401	2417	java/io/IOException
    //   5439	5454	2417	java/io/IOException
    //   4961	5027	5338	java/io/IOException
    //   5030	5096	5338	java/io/IOException
    //   5099	5154	5338	java/io/IOException
    //   5154	5183	5338	java/io/IOException
    //   5194	5216	5338	java/io/IOException
    //   5224	5232	5338	java/io/IOException
    //   5232	5241	5338	java/io/IOException
    //   5250	5283	5338	java/io/IOException
    //   5294	5302	5338	java/io/IOException
    //   5302	5311	5338	java/io/IOException
    //   5320	5331	5338	java/io/IOException
    //   2438	2448	5351	java/lang/Exception
    //   2454	2463	5351	java/lang/Exception
    //   2469	2477	5351	java/lang/Exception
    //   2483	2505	5351	java/lang/Exception
    //   2511	2518	5351	java/lang/Exception
    //   2524	2534	5351	java/lang/Exception
    //   2540	2550	5351	java/lang/Exception
    //   2556	2568	5351	java/lang/Exception
    //   2574	2582	5351	java/lang/Exception
    //   2588	2594	5351	java/lang/Exception
    //   2603	2608	5351	java/lang/Exception
    //   2614	2622	5351	java/lang/Exception
    //   2628	2634	5351	java/lang/Exception
    //   2640	2649	5351	java/lang/Exception
    //   2655	2663	5351	java/lang/Exception
    //   2669	2676	5351	java/lang/Exception
    //   2682	2690	5351	java/lang/Exception
    //   2696	2710	5351	java/lang/Exception
    //   2716	2726	5351	java/lang/Exception
    //   2735	2741	5351	java/lang/Exception
    //   2747	2756	5351	java/lang/Exception
    //   2762	2770	5351	java/lang/Exception
    //   2776	2783	5351	java/lang/Exception
    //   2789	2797	5351	java/lang/Exception
    //   2803	2817	5351	java/lang/Exception
    //   2823	2833	5351	java/lang/Exception
    //   2839	2848	5351	java/lang/Exception
    //   2854	2867	5351	java/lang/Exception
    //   2873	2879	5351	java/lang/Exception
    //   2885	2892	5351	java/lang/Exception
    //   2910	2917	5351	java/lang/Exception
    //   2923	2931	5351	java/lang/Exception
    //   2937	2944	5351	java/lang/Exception
    //   2958	2967	5351	java/lang/Exception
    //   2995	3007	5351	java/lang/Exception
    //   3013	3025	5351	java/lang/Exception
    //   3031	3043	5351	java/lang/Exception
    //   3060	3069	5351	java/lang/Exception
    //   3097	3109	5351	java/lang/Exception
    //   3126	3135	5351	java/lang/Exception
    //   3163	3175	5351	java/lang/Exception
    //   3197	3207	5351	java/lang/Exception
    //   3213	3219	5351	java/lang/Exception
    //   3225	3233	5351	java/lang/Exception
    //   3239	3245	5351	java/lang/Exception
    //   3254	3259	5351	java/lang/Exception
    //   3265	3273	5351	java/lang/Exception
    //   3279	3285	5351	java/lang/Exception
    //   3291	3300	5351	java/lang/Exception
    //   3306	3314	5351	java/lang/Exception
    //   3320	3327	5351	java/lang/Exception
    //   3333	3341	5351	java/lang/Exception
    //   3347	3362	5351	java/lang/Exception
    //   3368	3378	5351	java/lang/Exception
    //   3387	3400	5351	java/lang/Exception
    //   3406	3415	5351	java/lang/Exception
    //   3421	3429	5351	java/lang/Exception
    //   3435	3442	5351	java/lang/Exception
    //   3448	3456	5351	java/lang/Exception
    //   3462	3477	5351	java/lang/Exception
    //   3483	3493	5351	java/lang/Exception
    //   3499	3508	5351	java/lang/Exception
    //   3514	3527	5351	java/lang/Exception
    //   3533	3540	5351	java/lang/Exception
    //   3558	3565	5351	java/lang/Exception
    //   3571	3579	5351	java/lang/Exception
    //   3585	3592	5351	java/lang/Exception
    //   3606	3615	5351	java/lang/Exception
    //   3643	3655	5351	java/lang/Exception
    //   3672	3681	5351	java/lang/Exception
    //   3709	3721	5351	java/lang/Exception
    //   3743	3753	5351	java/lang/Exception
    //   3759	3765	5351	java/lang/Exception
    //   3771	3779	5351	java/lang/Exception
    //   3785	3791	5351	java/lang/Exception
    //   3800	3805	5351	java/lang/Exception
    //   3811	3819	5351	java/lang/Exception
    //   3825	3831	5351	java/lang/Exception
    //   3837	3846	5351	java/lang/Exception
    //   3852	3860	5351	java/lang/Exception
    //   3866	3873	5351	java/lang/Exception
    //   3879	3887	5351	java/lang/Exception
    //   3893	3908	5351	java/lang/Exception
    //   3914	3924	5351	java/lang/Exception
    //   3933	3939	5351	java/lang/Exception
    //   3945	3954	5351	java/lang/Exception
    //   3960	3968	5351	java/lang/Exception
    //   3974	3981	5351	java/lang/Exception
    //   3987	3995	5351	java/lang/Exception
    //   4001	4016	5351	java/lang/Exception
    //   4022	4032	5351	java/lang/Exception
    //   4038	4047	5351	java/lang/Exception
    //   4053	4066	5351	java/lang/Exception
    //   4072	4079	5351	java/lang/Exception
    //   4097	4104	5351	java/lang/Exception
    //   4110	4118	5351	java/lang/Exception
    //   4124	4131	5351	java/lang/Exception
    //   4145	4154	5351	java/lang/Exception
    //   4182	4194	5351	java/lang/Exception
    //   4211	4220	5351	java/lang/Exception
    //   4248	4260	5351	java/lang/Exception
    //   4284	4294	5351	java/lang/Exception
    //   4300	4309	5351	java/lang/Exception
    //   4315	4323	5351	java/lang/Exception
    //   4329	4346	5351	java/lang/Exception
    //   4361	4371	5351	java/lang/Exception
    //   4377	4387	5351	java/lang/Exception
    //   4393	4400	5351	java/lang/Exception
    //   4406	4414	5351	java/lang/Exception
    //   4420	4426	5351	java/lang/Exception
    //   4435	4440	5351	java/lang/Exception
    //   4446	4454	5351	java/lang/Exception
    //   4460	4466	5351	java/lang/Exception
    //   4472	4481	5351	java/lang/Exception
    //   4487	4495	5351	java/lang/Exception
    //   4501	4508	5351	java/lang/Exception
    //   4514	4522	5351	java/lang/Exception
    //   4528	4543	5351	java/lang/Exception
    //   4549	4559	5351	java/lang/Exception
    //   4568	4574	5351	java/lang/Exception
    //   4580	4589	5351	java/lang/Exception
    //   4595	4603	5351	java/lang/Exception
    //   4609	4616	5351	java/lang/Exception
    //   4622	4630	5351	java/lang/Exception
    //   4636	4651	5351	java/lang/Exception
    //   4657	4667	5351	java/lang/Exception
    //   4673	4682	5351	java/lang/Exception
    //   4688	4701	5351	java/lang/Exception
    //   4707	4713	5351	java/lang/Exception
    //   4719	4726	5351	java/lang/Exception
    //   4744	4751	5351	java/lang/Exception
    //   4757	4765	5351	java/lang/Exception
    //   4771	4778	5351	java/lang/Exception
    //   4792	4801	5351	java/lang/Exception
    //   4829	4841	5351	java/lang/Exception
    //   4863	4872	5351	java/lang/Exception
    //   4878	4886	5351	java/lang/Exception
    //   4892	4899	5351	java/lang/Exception
    //   4905	4913	5351	java/lang/Exception
    //   4919	4934	5351	java/lang/Exception
    //   4940	4950	5351	java/lang/Exception
    //   2438	2448	5359	java/io/IOException
    //   2454	2463	5359	java/io/IOException
    //   2469	2477	5359	java/io/IOException
    //   2483	2505	5359	java/io/IOException
    //   2511	2518	5359	java/io/IOException
    //   2524	2534	5359	java/io/IOException
    //   2540	2550	5359	java/io/IOException
    //   2556	2568	5359	java/io/IOException
    //   2574	2582	5359	java/io/IOException
    //   2588	2594	5359	java/io/IOException
    //   2603	2608	5359	java/io/IOException
    //   2614	2622	5359	java/io/IOException
    //   2628	2634	5359	java/io/IOException
    //   2640	2649	5359	java/io/IOException
    //   2655	2663	5359	java/io/IOException
    //   2669	2676	5359	java/io/IOException
    //   2682	2690	5359	java/io/IOException
    //   2696	2710	5359	java/io/IOException
    //   2716	2726	5359	java/io/IOException
    //   2735	2741	5359	java/io/IOException
    //   2747	2756	5359	java/io/IOException
    //   2762	2770	5359	java/io/IOException
    //   2776	2783	5359	java/io/IOException
    //   2789	2797	5359	java/io/IOException
    //   2803	2817	5359	java/io/IOException
    //   2823	2833	5359	java/io/IOException
    //   2839	2848	5359	java/io/IOException
    //   2854	2867	5359	java/io/IOException
    //   2873	2879	5359	java/io/IOException
    //   2885	2892	5359	java/io/IOException
    //   2910	2917	5359	java/io/IOException
    //   2923	2931	5359	java/io/IOException
    //   2937	2944	5359	java/io/IOException
    //   2958	2967	5359	java/io/IOException
    //   2970	2980	5359	java/io/IOException
    //   2995	3007	5359	java/io/IOException
    //   3013	3025	5359	java/io/IOException
    //   3031	3043	5359	java/io/IOException
    //   3060	3069	5359	java/io/IOException
    //   3072	3082	5359	java/io/IOException
    //   3097	3109	5359	java/io/IOException
    //   3126	3135	5359	java/io/IOException
    //   3138	3148	5359	java/io/IOException
    //   3163	3175	5359	java/io/IOException
    //   3197	3207	5359	java/io/IOException
    //   3213	3219	5359	java/io/IOException
    //   3225	3233	5359	java/io/IOException
    //   3239	3245	5359	java/io/IOException
    //   3254	3259	5359	java/io/IOException
    //   3265	3273	5359	java/io/IOException
    //   3279	3285	5359	java/io/IOException
    //   3291	3300	5359	java/io/IOException
    //   3306	3314	5359	java/io/IOException
    //   3320	3327	5359	java/io/IOException
    //   3333	3341	5359	java/io/IOException
    //   3347	3362	5359	java/io/IOException
    //   3368	3378	5359	java/io/IOException
    //   3387	3400	5359	java/io/IOException
    //   3406	3415	5359	java/io/IOException
    //   3421	3429	5359	java/io/IOException
    //   3435	3442	5359	java/io/IOException
    //   3448	3456	5359	java/io/IOException
    //   3462	3477	5359	java/io/IOException
    //   3483	3493	5359	java/io/IOException
    //   3499	3508	5359	java/io/IOException
    //   3514	3527	5359	java/io/IOException
    //   3533	3540	5359	java/io/IOException
    //   3558	3565	5359	java/io/IOException
    //   3571	3579	5359	java/io/IOException
    //   3585	3592	5359	java/io/IOException
    //   3606	3615	5359	java/io/IOException
    //   3618	3628	5359	java/io/IOException
    //   3643	3655	5359	java/io/IOException
    //   3672	3681	5359	java/io/IOException
    //   3684	3694	5359	java/io/IOException
    //   3709	3721	5359	java/io/IOException
    //   3743	3753	5359	java/io/IOException
    //   3759	3765	5359	java/io/IOException
    //   3771	3779	5359	java/io/IOException
    //   3785	3791	5359	java/io/IOException
    //   3800	3805	5359	java/io/IOException
    //   3811	3819	5359	java/io/IOException
    //   3825	3831	5359	java/io/IOException
    //   3837	3846	5359	java/io/IOException
    //   3852	3860	5359	java/io/IOException
    //   3866	3873	5359	java/io/IOException
    //   3879	3887	5359	java/io/IOException
    //   3893	3908	5359	java/io/IOException
    //   3914	3924	5359	java/io/IOException
    //   3933	3939	5359	java/io/IOException
    //   3945	3954	5359	java/io/IOException
    //   3960	3968	5359	java/io/IOException
    //   3974	3981	5359	java/io/IOException
    //   3987	3995	5359	java/io/IOException
    //   4001	4016	5359	java/io/IOException
    //   4022	4032	5359	java/io/IOException
    //   4038	4047	5359	java/io/IOException
    //   4053	4066	5359	java/io/IOException
    //   4072	4079	5359	java/io/IOException
    //   4097	4104	5359	java/io/IOException
    //   4110	4118	5359	java/io/IOException
    //   4124	4131	5359	java/io/IOException
    //   4145	4154	5359	java/io/IOException
    //   4157	4167	5359	java/io/IOException
    //   4182	4194	5359	java/io/IOException
    //   4211	4220	5359	java/io/IOException
    //   4223	4233	5359	java/io/IOException
    //   4248	4260	5359	java/io/IOException
    //   4284	4294	5359	java/io/IOException
    //   4300	4309	5359	java/io/IOException
    //   4315	4323	5359	java/io/IOException
    //   4329	4346	5359	java/io/IOException
    //   4361	4371	5359	java/io/IOException
    //   4377	4387	5359	java/io/IOException
    //   4393	4400	5359	java/io/IOException
    //   4406	4414	5359	java/io/IOException
    //   4420	4426	5359	java/io/IOException
    //   4435	4440	5359	java/io/IOException
    //   4446	4454	5359	java/io/IOException
    //   4460	4466	5359	java/io/IOException
    //   4472	4481	5359	java/io/IOException
    //   4487	4495	5359	java/io/IOException
    //   4501	4508	5359	java/io/IOException
    //   4514	4522	5359	java/io/IOException
    //   4528	4543	5359	java/io/IOException
    //   4549	4559	5359	java/io/IOException
    //   4568	4574	5359	java/io/IOException
    //   4580	4589	5359	java/io/IOException
    //   4595	4603	5359	java/io/IOException
    //   4609	4616	5359	java/io/IOException
    //   4622	4630	5359	java/io/IOException
    //   4636	4651	5359	java/io/IOException
    //   4657	4667	5359	java/io/IOException
    //   4673	4682	5359	java/io/IOException
    //   4688	4701	5359	java/io/IOException
    //   4707	4713	5359	java/io/IOException
    //   4719	4726	5359	java/io/IOException
    //   4744	4751	5359	java/io/IOException
    //   4757	4765	5359	java/io/IOException
    //   4771	4778	5359	java/io/IOException
    //   4792	4801	5359	java/io/IOException
    //   4804	4814	5359	java/io/IOException
    //   4829	4841	5359	java/io/IOException
    //   4863	4872	5359	java/io/IOException
    //   4878	4886	5359	java/io/IOException
    //   4892	4899	5359	java/io/IOException
    //   4905	4913	5359	java/io/IOException
    //   4919	4934	5359	java/io/IOException
    //   4940	4950	5359	java/io/IOException
    //   4953	4961	5359	java/io/IOException
    //   17	23	5460	java/lang/Exception
    //   28	41	5460	java/lang/Exception
    //   2277	2297	5460	java/lang/Exception
    //   2380	2401	5460	java/lang/Exception
    //   2423	2432	5460	java/lang/Exception
    //   3182	3191	5460	java/lang/Exception
    //   3728	3737	5460	java/lang/Exception
    //   4269	4278	5460	java/lang/Exception
    //   4848	4857	5460	java/lang/Exception
    //   5367	5389	5460	java/lang/Exception
    //   5411	5433	5460	java/lang/Exception
    //   17	23	5470	java/io/IOException
    //   28	41	5470	java/io/IOException
    //   2277	2297	5470	java/io/IOException
    //   2380	2401	5470	java/io/IOException
    //   2423	2432	5470	java/io/IOException
    //   3182	3191	5470	java/io/IOException
    //   3728	3737	5470	java/io/IOException
    //   4269	4278	5470	java/io/IOException
    //   4848	4857	5470	java/io/IOException
    //   5367	5389	5470	java/io/IOException
    //   5411	5433	5470	java/io/IOException
    //   2970	2980	5484	java/lang/Exception
    //   3072	3082	5488	java/lang/Exception
    //   3138	3148	5492	java/lang/Exception
    //   3618	3628	5496	java/lang/Exception
    //   3684	3694	5500	java/lang/Exception
    //   4157	4167	5504	java/lang/Exception
    //   4223	4233	5508	java/lang/Exception
    //   4804	4814	5512	java/lang/Exception
    //   4953	4961	5516	java/lang/Exception
    //   4961	5027	5520	java/lang/Exception
    //   5030	5096	5520	java/lang/Exception
    //   5099	5154	5520	java/lang/Exception
    //   5154	5183	5520	java/lang/Exception
    //   5194	5216	5520	java/lang/Exception
    //   5224	5232	5520	java/lang/Exception
    //   5250	5283	5520	java/lang/Exception
    //   5294	5302	5520	java/lang/Exception
    //   5320	5331	5520	java/lang/Exception
    //   5232	5241	5526	java/lang/Exception
    //   5302	5311	5530	java/lang/Exception
  }
  
  public static byte[] getAuthFromTroopSysMsg(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    if (paramInt != 46) {}
    switch (paramInt)
    {
    default: 
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          return null;
        }
        break;
      }
    case -1020: 
      paramInt = PkgTools.getUnsignedByte(paramArrayOfByte[9]) + 10 + 2 + PkgTools.getShortData(paramArrayOfByte, PkgTools.getUnsignedByte(paramArrayOfByte[9]) + 10);
      i = PkgTools.getShortData(paramArrayOfByte, paramInt);
      arrayOfByte = new byte[i];
      System.arraycopy(paramArrayOfByte, paramInt + 2, arrayOfByte, 0, i);
      return arrayOfByte;
    case -1023: 
      paramInt = getTroopOpFromTroopSysMsg(paramArrayOfByte, paramInt);
      if ((paramInt == 1) || (paramInt == 4)) {
        break label215;
      }
      if (paramInt == 5)
      {
        paramInt = PkgTools.getUnsignedByte(paramArrayOfByte[19]) + 19;
        i = PkgTools.getShortData(paramArrayOfByte, paramInt);
        arrayOfByte = new byte[i];
        System.arraycopy(paramArrayOfByte, paramInt + 2, arrayOfByte, 0, i);
        return arrayOfByte;
      }
      break;
    }
    return null;
    label215:
    paramInt = PkgTools.getUnsignedByte(paramArrayOfByte[15]) + 15;
    int i = PkgTools.getShortData(paramArrayOfByte, paramInt);
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(paramArrayOfByte, paramInt + 2, arrayOfByte, 0, i);
    return arrayOfByte;
  }
  
  public static String getInviteUinFromTroopSysMsg(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    if ((paramInt != -1023) && (paramInt != 46) && (paramInt != 87)) {
      return null;
    }
    if (getTroopOpFromTroopSysMsg(paramArrayOfByte, paramInt) == 5) {
      return String.valueOf(PkgTools.getLongData(paramArrayOfByte, 14));
    }
    return null;
  }
  
  public static String getManagerUinFromTroopSysMsg(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    if (paramInt != 46) {
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          }
          break;
        }
      case -1020: 
        return null;
      case -1022: 
      case -1021: 
        return String.valueOf(PkgTools.getLongData(paramArrayOfByte, 5));
      }
    }
    return String.valueOf(PkgTools.getLongData(paramArrayOfByte, 10));
  }
  
  public static String getRequestUinFromTroopSysMsg(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    if (paramInt != 46) {
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          default: 
            return null;
          }
          break;
        }
      case -1020: 
        return String.valueOf(PkgTools.getLongData(paramArrayOfByte, 5));
      }
    }
    return String.valueOf(PkgTools.getLongData(paramArrayOfByte, 10));
  }
  
  public static String getStrMsgFromTroopSysMsg(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    byte[] arrayOfByte;
    if (paramInt != 46) {
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          default: 
            return null;
          }
          break;
        }
      case -1022: 
      case -1021: 
      case -1020: 
        paramInt = PkgTools.getUnsignedByte(paramArrayOfByte[9]);
        arrayOfByte = new byte[paramInt];
        PkgTools.copyData(arrayOfByte, 0, paramArrayOfByte, 10, paramInt);
        return String.valueOf(PkgTools.utf8Byte2String(EmotionCodecUtils.a(arrayOfByte), 0, paramInt));
      }
    }
    if (getTroopOpFromTroopSysMsg(paramArrayOfByte, paramInt) == 5)
    {
      paramInt = PkgTools.getUnsignedByte(paramArrayOfByte[18]);
      arrayOfByte = new byte[paramInt];
      PkgTools.copyData(arrayOfByte, 0, paramArrayOfByte, 19, paramInt);
      paramArrayOfByte = EmotionCodecUtils.a(arrayOfByte);
    }
    else
    {
      paramInt = PkgTools.getUnsignedByte(paramArrayOfByte[14]);
      arrayOfByte = new byte[paramInt];
      PkgTools.copyData(arrayOfByte, 0, paramArrayOfByte, 15, paramInt);
      paramArrayOfByte = EmotionCodecUtils.a(arrayOfByte);
    }
    return String.valueOf(PkgTools.utf8Byte2String(paramArrayOfByte, 0, paramInt));
  }
  
  public static String getTroopCodeFromTroopSysMsg(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    return String.valueOf(PkgTools.getLongData(paramArrayOfByte, 0));
  }
  
  public static byte getTroopOpFromTroopSysMsg(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return -1;
    }
    if (paramInt != 46) {
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          }
          break;
        }
      case -1022: 
      case -1021: 
      case -1020: 
        return -1;
      }
    }
    return paramArrayOfByte[5];
  }
  
  public static int getTroopSystemMsgType(int paramInt)
  {
    int j = -1020;
    int i = j;
    if (paramInt != -1020)
    {
      i = j;
      if (paramInt != 84)
      {
        if (paramInt == 35) {
          return -1020;
        }
        j = -1021;
        i = j;
        if (paramInt != -1021)
        {
          i = j;
          if (paramInt != 85)
          {
            if (paramInt == 36) {
              return -1021;
            }
            j = -1022;
            i = j;
            if (paramInt != -1022)
            {
              i = j;
              if (paramInt != 86)
              {
                if (paramInt == 37) {
                  return -1022;
                }
                j = -1023;
                i = j;
                if (paramInt != -1023)
                {
                  i = j;
                  if (paramInt != 87)
                  {
                    if (paramInt == 46) {
                      return -1023;
                    }
                    return -1000;
                  }
                }
              }
            }
          }
        }
      }
    }
    return i;
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
    if ((paramInt <= -1006) && (paramInt >= -1010)) {
      return true;
    }
    if (paramInt == -1011) {
      return true;
    }
    return (paramInt >= 187) && (paramInt <= 191);
  }
  
  public static boolean isTroopSystemMessage(int paramInt)
  {
    boolean bool2 = true;
    if ((paramInt <= -1020) && (paramInt >= -1023)) {
      return true;
    }
    boolean bool1;
    if (paramInt >= 84)
    {
      bool1 = bool2;
      if (paramInt <= 87) {}
    }
    else if (paramInt >= 35)
    {
      bool1 = bool2;
      if (paramInt <= 37) {}
    }
    else
    {
      bool1 = bool2;
      if (paramInt != 46)
      {
        if (paramInt == 45) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
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
    Object localObject = this.sMsg;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.append;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.message;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.troopCode;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.managerUin;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.requestUin;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    paramJceOutputStream.write(this.troopType, 7);
    paramJceOutputStream.write(this.op, 8);
    localObject = this.auth;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 9);
    }
    paramJceOutputStream.write(this.lToMobile, 10);
    localObject = this.strNickName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.SystemMsg
 * JD-Core Version:    0.7.0.1
 */