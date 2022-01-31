package com.tencent.qqlive.mediaplayer.sdkupdate;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import org.json.JSONObject;

public class b
{
  private static final int[] a = { 5000, 5000, 10000 };
  private static final int[] b = { 15000, 15000, 20000 };
  private Context c;
  private int d = 0;
  private File e = null;
  private File f = null;
  private File g = null;
  private File h = null;
  private File i = null;
  private File j = null;
  private boolean k = false;
  private SDKLocalConfig l;
  private TVK_SDKMgr.InstallListener m = null;
  
  public b(Context paramContext)
  {
    this.c = paramContext;
  }
  
  /* Error */
  private int a(SDKLocalConfig paramSDKLocalConfig, String paramString)
  {
    // Byte code:
    //   0: iconst_3
    //   1: istore_3
    //   2: iload_3
    //   3: iconst_1
    //   4: isub
    //   5: istore 4
    //   7: iload_3
    //   8: ifle +3176 -> 3184
    //   11: aload_0
    //   12: getfield 55	com/tencent/qqlive/mediaplayer/sdkupdate/b:c	Landroid/content/Context;
    //   15: invokestatic 69	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(Landroid/content/Context;)Z
    //   18: ifne +24 -> 42
    //   21: iload 4
    //   23: iconst_2
    //   24: if_icmpge +18 -> 42
    //   27: iconst_5
    //   28: ldc 71
    //   30: ldc 73
    //   32: ldc 75
    //   34: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   37: bipush 101
    //   39: istore_3
    //   40: iload_3
    //   41: ireturn
    //   42: iconst_3
    //   43: ldc 71
    //   45: ldc 73
    //   47: new 80	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   54: ldc 83
    //   56: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: iconst_2
    //   60: iload 4
    //   62: isub
    //   63: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   66: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   72: aconst_null
    //   73: astore 22
    //   75: aconst_null
    //   76: astore 21
    //   78: aconst_null
    //   79: astore 23
    //   81: aconst_null
    //   82: astore 18
    //   84: aconst_null
    //   85: astore 9
    //   87: aconst_null
    //   88: astore 16
    //   90: aconst_null
    //   91: astore 17
    //   93: aconst_null
    //   94: astore 20
    //   96: aconst_null
    //   97: astore 10
    //   99: aconst_null
    //   100: astore 19
    //   102: aload 20
    //   104: astore 14
    //   106: aload 22
    //   108: astore 15
    //   110: aload 21
    //   112: astore 13
    //   114: aload 10
    //   116: astore 11
    //   118: aload 23
    //   120: astore 12
    //   122: new 96	java/io/File
    //   125: dup
    //   126: aload_2
    //   127: invokespecial 99	java/io/File:<init>	(Ljava/lang/String;)V
    //   130: invokestatic 102	com/tencent/qqlive/mediaplayer/sdkupdate/d:b	(Ljava/io/File;)V
    //   133: aload 20
    //   135: astore 14
    //   137: aload 22
    //   139: astore 15
    //   141: aload 21
    //   143: astore 13
    //   145: aload 10
    //   147: astore 11
    //   149: aload 23
    //   151: astore 12
    //   153: new 96	java/io/File
    //   156: dup
    //   157: aload_2
    //   158: ldc 104
    //   160: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: astore 25
    //   165: aload 20
    //   167: astore 14
    //   169: aload 22
    //   171: astore 15
    //   173: aload 21
    //   175: astore 13
    //   177: aload 10
    //   179: astore 11
    //   181: aload 23
    //   183: astore 12
    //   185: aload 25
    //   187: invokevirtual 111	java/io/File:getParentFile	()Ljava/io/File;
    //   190: invokevirtual 115	java/io/File:mkdirs	()Z
    //   193: pop
    //   194: aload 20
    //   196: astore 14
    //   198: aload 22
    //   200: astore 15
    //   202: aload 21
    //   204: astore 13
    //   206: aload 10
    //   208: astore 11
    //   210: aload 23
    //   212: astore 12
    //   214: new 117	java/net/URL
    //   217: dup
    //   218: aload_1
    //   219: getfield 123	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:URL	Ljava/lang/String;
    //   222: invokespecial 124	java/net/URL:<init>	(Ljava/lang/String;)V
    //   225: invokevirtual 128	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   228: checkcast 130	java/net/HttpURLConnection
    //   231: astore 24
    //   233: aload 24
    //   235: ifnonnull +232 -> 467
    //   238: aload 20
    //   240: astore 14
    //   242: aload 22
    //   244: astore 15
    //   246: aload 21
    //   248: astore 13
    //   250: aload 10
    //   252: astore 11
    //   254: aload 23
    //   256: astore 12
    //   258: iconst_5
    //   259: ldc 71
    //   261: ldc 73
    //   263: ldc 132
    //   265: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   268: iload 4
    //   270: ifne +98 -> 368
    //   273: bipush 101
    //   275: istore_3
    //   276: iconst_0
    //   277: ifeq +11 -> 288
    //   280: new 134	java/lang/NullPointerException
    //   283: dup
    //   284: invokespecial 135	java/lang/NullPointerException:<init>	()V
    //   287: athrow
    //   288: iconst_0
    //   289: ifeq -249 -> 40
    //   292: new 134	java/lang/NullPointerException
    //   295: dup
    //   296: invokespecial 135	java/lang/NullPointerException:<init>	()V
    //   299: athrow
    //   300: astore_1
    //   301: iconst_5
    //   302: ldc 71
    //   304: ldc 73
    //   306: new 80	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   313: ldc 137
    //   315: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: aload_1
    //   319: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   322: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   331: bipush 101
    //   333: ireturn
    //   334: astore_1
    //   335: iconst_5
    //   336: ldc 71
    //   338: ldc 73
    //   340: new 80	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   347: ldc 140
    //   349: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: aload_1
    //   353: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   356: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   365: goto -77 -> 288
    //   368: iconst_0
    //   369: ifeq +11 -> 380
    //   372: new 134	java/lang/NullPointerException
    //   375: dup
    //   376: invokespecial 135	java/lang/NullPointerException:<init>	()V
    //   379: athrow
    //   380: iconst_0
    //   381: ifeq +2898 -> 3279
    //   384: new 134	java/lang/NullPointerException
    //   387: dup
    //   388: invokespecial 135	java/lang/NullPointerException:<init>	()V
    //   391: athrow
    //   392: astore 9
    //   394: iconst_5
    //   395: ldc 71
    //   397: ldc 73
    //   399: new 80	java/lang/StringBuilder
    //   402: dup
    //   403: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   406: ldc 140
    //   408: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: aload 9
    //   413: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   416: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   425: goto -45 -> 380
    //   428: astore 9
    //   430: iconst_5
    //   431: ldc 71
    //   433: ldc 73
    //   435: new 80	java/lang/StringBuilder
    //   438: dup
    //   439: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   442: ldc 137
    //   444: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: aload 9
    //   449: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   452: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   458: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   461: iload 4
    //   463: istore_3
    //   464: goto -462 -> 2
    //   467: aload 20
    //   469: astore 14
    //   471: aload 22
    //   473: astore 15
    //   475: aload 21
    //   477: astore 13
    //   479: aload 10
    //   481: astore 11
    //   483: aload 23
    //   485: astore 12
    //   487: new 142	java/io/FileOutputStream
    //   490: dup
    //   491: aload 25
    //   493: invokespecial 144	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   496: astore 10
    //   498: aload 18
    //   500: astore 11
    //   502: aload 9
    //   504: astore 14
    //   506: aload 16
    //   508: astore 13
    //   510: aload 17
    //   512: astore 12
    //   514: aload 24
    //   516: invokevirtual 148	java/net/HttpURLConnection:getResponseCode	()I
    //   519: istore_3
    //   520: iload_3
    //   521: sipush 300
    //   524: if_icmple +293 -> 817
    //   527: iload 4
    //   529: ifne +142 -> 671
    //   532: aload 18
    //   534: astore 11
    //   536: aload 9
    //   538: astore 14
    //   540: aload 16
    //   542: astore 13
    //   544: aload 17
    //   546: astore 12
    //   548: iconst_5
    //   549: ldc 71
    //   551: ldc 73
    //   553: new 80	java/lang/StringBuilder
    //   556: dup
    //   557: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   560: ldc 150
    //   562: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: iload_3
    //   566: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   569: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   572: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   575: bipush 102
    //   577: istore_3
    //   578: iconst_0
    //   579: ifeq +11 -> 590
    //   582: new 134	java/lang/NullPointerException
    //   585: dup
    //   586: invokespecial 135	java/lang/NullPointerException:<init>	()V
    //   589: athrow
    //   590: aload 10
    //   592: ifnull -552 -> 40
    //   595: aload 10
    //   597: invokevirtual 153	java/io/FileOutputStream:close	()V
    //   600: bipush 102
    //   602: ireturn
    //   603: astore_1
    //   604: iconst_5
    //   605: ldc 71
    //   607: ldc 73
    //   609: new 80	java/lang/StringBuilder
    //   612: dup
    //   613: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   616: ldc 137
    //   618: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: aload_1
    //   622: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   625: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   631: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   634: bipush 102
    //   636: ireturn
    //   637: astore_1
    //   638: iconst_5
    //   639: ldc 71
    //   641: ldc 73
    //   643: new 80	java/lang/StringBuilder
    //   646: dup
    //   647: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   650: ldc 140
    //   652: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: aload_1
    //   656: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   659: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   665: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   668: goto -78 -> 590
    //   671: aload 18
    //   673: astore 11
    //   675: aload 9
    //   677: astore 14
    //   679: aload 16
    //   681: astore 13
    //   683: aload 17
    //   685: astore 12
    //   687: iconst_3
    //   688: ldc 71
    //   690: ldc 73
    //   692: new 80	java/lang/StringBuilder
    //   695: dup
    //   696: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   699: ldc 155
    //   701: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: iload_3
    //   705: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   708: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   711: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   714: iconst_0
    //   715: ifeq +11 -> 726
    //   718: new 134	java/lang/NullPointerException
    //   721: dup
    //   722: invokespecial 135	java/lang/NullPointerException:<init>	()V
    //   725: athrow
    //   726: aload 10
    //   728: ifnull +2551 -> 3279
    //   731: aload 10
    //   733: invokevirtual 153	java/io/FileOutputStream:close	()V
    //   736: iload 4
    //   738: istore_3
    //   739: goto -737 -> 2
    //   742: astore 9
    //   744: iconst_5
    //   745: ldc 71
    //   747: ldc 73
    //   749: new 80	java/lang/StringBuilder
    //   752: dup
    //   753: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   756: ldc 140
    //   758: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: aload 9
    //   763: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   766: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   772: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   775: goto -49 -> 726
    //   778: astore 9
    //   780: iconst_5
    //   781: ldc 71
    //   783: ldc 73
    //   785: new 80	java/lang/StringBuilder
    //   788: dup
    //   789: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   792: ldc 137
    //   794: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   797: aload 9
    //   799: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   802: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   805: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   808: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   811: iload 4
    //   813: istore_3
    //   814: goto -812 -> 2
    //   817: aload 18
    //   819: astore 11
    //   821: aload 9
    //   823: astore 14
    //   825: aload 16
    //   827: astore 13
    //   829: aload 17
    //   831: astore 12
    //   833: aload 24
    //   835: ldc 157
    //   837: invokevirtual 161	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   840: invokestatic 167	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   843: i2l
    //   844: lstore 7
    //   846: lload 7
    //   848: lconst_0
    //   849: lcmp
    //   850: ifne +233 -> 1083
    //   853: aload 18
    //   855: astore 11
    //   857: aload 9
    //   859: astore 14
    //   861: aload 16
    //   863: astore 13
    //   865: aload 17
    //   867: astore 12
    //   869: iconst_5
    //   870: ldc 71
    //   872: ldc 73
    //   874: ldc 169
    //   876: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   879: iload 4
    //   881: ifne +99 -> 980
    //   884: bipush 103
    //   886: istore_3
    //   887: iconst_0
    //   888: ifeq +11 -> 899
    //   891: new 134	java/lang/NullPointerException
    //   894: dup
    //   895: invokespecial 135	java/lang/NullPointerException:<init>	()V
    //   898: athrow
    //   899: aload 10
    //   901: ifnull -861 -> 40
    //   904: aload 10
    //   906: invokevirtual 153	java/io/FileOutputStream:close	()V
    //   909: bipush 103
    //   911: ireturn
    //   912: astore_1
    //   913: iconst_5
    //   914: ldc 71
    //   916: ldc 73
    //   918: new 80	java/lang/StringBuilder
    //   921: dup
    //   922: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   925: ldc 137
    //   927: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   930: aload_1
    //   931: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   934: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   937: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   940: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   943: bipush 103
    //   945: ireturn
    //   946: astore_1
    //   947: iconst_5
    //   948: ldc 71
    //   950: ldc 73
    //   952: new 80	java/lang/StringBuilder
    //   955: dup
    //   956: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   959: ldc 140
    //   961: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   964: aload_1
    //   965: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   968: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   971: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   974: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   977: goto -78 -> 899
    //   980: iconst_0
    //   981: ifeq +11 -> 992
    //   984: new 134	java/lang/NullPointerException
    //   987: dup
    //   988: invokespecial 135	java/lang/NullPointerException:<init>	()V
    //   991: athrow
    //   992: aload 10
    //   994: ifnull +2285 -> 3279
    //   997: aload 10
    //   999: invokevirtual 153	java/io/FileOutputStream:close	()V
    //   1002: iload 4
    //   1004: istore_3
    //   1005: goto -1003 -> 2
    //   1008: astore 9
    //   1010: iconst_5
    //   1011: ldc 71
    //   1013: ldc 73
    //   1015: new 80	java/lang/StringBuilder
    //   1018: dup
    //   1019: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   1022: ldc 140
    //   1024: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1027: aload 9
    //   1029: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   1032: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1035: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1038: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1041: goto -49 -> 992
    //   1044: astore 9
    //   1046: iconst_5
    //   1047: ldc 71
    //   1049: ldc 73
    //   1051: new 80	java/lang/StringBuilder
    //   1054: dup
    //   1055: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   1058: ldc 137
    //   1060: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1063: aload 9
    //   1065: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   1068: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1071: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1074: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1077: iload 4
    //   1079: istore_3
    //   1080: goto -1078 -> 2
    //   1083: lconst_0
    //   1084: lstore 5
    //   1086: aload 18
    //   1088: astore 11
    //   1090: aload 9
    //   1092: astore 14
    //   1094: aload 16
    //   1096: astore 13
    //   1098: aload 17
    //   1100: astore 12
    //   1102: aload 24
    //   1104: invokevirtual 173	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1107: astore 9
    //   1109: aload 9
    //   1111: ifnonnull +229 -> 1340
    //   1114: iload 4
    //   1116: ifne +123 -> 1239
    //   1119: aload 9
    //   1121: astore 11
    //   1123: aload 9
    //   1125: astore 14
    //   1127: aload 9
    //   1129: astore 13
    //   1131: aload 9
    //   1133: astore 12
    //   1135: iconst_5
    //   1136: ldc 71
    //   1138: ldc 73
    //   1140: ldc 175
    //   1142: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1145: bipush 103
    //   1147: istore_3
    //   1148: aload 9
    //   1150: ifnull +8 -> 1158
    //   1153: aload 9
    //   1155: invokevirtual 178	java/io/InputStream:close	()V
    //   1158: aload 10
    //   1160: ifnull -1120 -> 40
    //   1163: aload 10
    //   1165: invokevirtual 153	java/io/FileOutputStream:close	()V
    //   1168: bipush 103
    //   1170: ireturn
    //   1171: astore_1
    //   1172: iconst_5
    //   1173: ldc 71
    //   1175: ldc 73
    //   1177: new 80	java/lang/StringBuilder
    //   1180: dup
    //   1181: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   1184: ldc 137
    //   1186: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1189: aload_1
    //   1190: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   1193: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1196: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1199: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1202: bipush 103
    //   1204: ireturn
    //   1205: astore_1
    //   1206: iconst_5
    //   1207: ldc 71
    //   1209: ldc 73
    //   1211: new 80	java/lang/StringBuilder
    //   1214: dup
    //   1215: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   1218: ldc 140
    //   1220: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1223: aload_1
    //   1224: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   1227: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1230: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1233: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1236: goto -78 -> 1158
    //   1239: aload 9
    //   1241: ifnull +8 -> 1249
    //   1244: aload 9
    //   1246: invokevirtual 178	java/io/InputStream:close	()V
    //   1249: aload 10
    //   1251: ifnull +2028 -> 3279
    //   1254: aload 10
    //   1256: invokevirtual 153	java/io/FileOutputStream:close	()V
    //   1259: iload 4
    //   1261: istore_3
    //   1262: goto -1260 -> 2
    //   1265: astore 9
    //   1267: iconst_5
    //   1268: ldc 71
    //   1270: ldc 73
    //   1272: new 80	java/lang/StringBuilder
    //   1275: dup
    //   1276: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   1279: ldc 140
    //   1281: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1284: aload 9
    //   1286: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   1289: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1292: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1295: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1298: goto -49 -> 1249
    //   1301: astore 9
    //   1303: iconst_5
    //   1304: ldc 71
    //   1306: ldc 73
    //   1308: new 80	java/lang/StringBuilder
    //   1311: dup
    //   1312: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   1315: ldc 137
    //   1317: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1320: aload 9
    //   1322: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   1325: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1328: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1331: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1334: iload 4
    //   1336: istore_3
    //   1337: goto -1335 -> 2
    //   1340: aload 9
    //   1342: astore 11
    //   1344: aload 9
    //   1346: astore 14
    //   1348: aload 9
    //   1350: astore 13
    //   1352: aload 9
    //   1354: astore 12
    //   1356: sipush 8192
    //   1359: newarray byte
    //   1361: astore 15
    //   1363: aload 9
    //   1365: astore 11
    //   1367: aload 9
    //   1369: astore 14
    //   1371: aload 9
    //   1373: astore 13
    //   1375: aload 9
    //   1377: astore 12
    //   1379: aload 9
    //   1381: aload 15
    //   1383: iconst_0
    //   1384: sipush 8192
    //   1387: invokevirtual 182	java/io/InputStream:read	([BII)I
    //   1390: istore_3
    //   1391: iload_3
    //   1392: iconst_m1
    //   1393: if_icmple +161 -> 1554
    //   1396: aload 9
    //   1398: astore 11
    //   1400: aload 9
    //   1402: astore 14
    //   1404: aload 9
    //   1406: astore 13
    //   1408: aload 9
    //   1410: astore 12
    //   1412: aload 10
    //   1414: aload 15
    //   1416: iconst_0
    //   1417: iload_3
    //   1418: invokevirtual 186	java/io/FileOutputStream:write	([BII)V
    //   1421: lload 5
    //   1423: iload_3
    //   1424: i2l
    //   1425: ladd
    //   1426: lstore 5
    //   1428: aload 9
    //   1430: astore 11
    //   1432: aload 9
    //   1434: astore 14
    //   1436: aload 9
    //   1438: astore 13
    //   1440: aload 9
    //   1442: astore 12
    //   1444: aload_0
    //   1445: lload 5
    //   1447: l2d
    //   1448: lload 7
    //   1450: l2d
    //   1451: ddiv
    //   1452: d2f
    //   1453: invokevirtual 189	com/tencent/qqlive/mediaplayer/sdkupdate/b:a	(F)V
    //   1456: goto -93 -> 1363
    //   1459: astore 11
    //   1461: aload 10
    //   1463: astore 11
    //   1465: aload 9
    //   1467: astore 10
    //   1469: aload 11
    //   1471: astore 9
    //   1473: aload_0
    //   1474: bipush 101
    //   1476: putfield 37	com/tencent/qqlive/mediaplayer/sdkupdate/b:d	I
    //   1479: iload 4
    //   1481: ifne +728 -> 2209
    //   1484: iconst_5
    //   1485: ldc 71
    //   1487: ldc 73
    //   1489: ldc 191
    //   1491: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1494: bipush 101
    //   1496: istore_3
    //   1497: aload 10
    //   1499: ifnull +8 -> 1507
    //   1502: aload 10
    //   1504: invokevirtual 178	java/io/InputStream:close	()V
    //   1507: aload 9
    //   1509: ifnull -1469 -> 40
    //   1512: aload 9
    //   1514: invokevirtual 153	java/io/FileOutputStream:close	()V
    //   1517: bipush 101
    //   1519: ireturn
    //   1520: astore_1
    //   1521: iconst_5
    //   1522: ldc 71
    //   1524: ldc 73
    //   1526: new 80	java/lang/StringBuilder
    //   1529: dup
    //   1530: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   1533: ldc 137
    //   1535: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1538: aload_1
    //   1539: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   1542: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1545: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1548: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1551: bipush 101
    //   1553: ireturn
    //   1554: aload 9
    //   1556: astore 11
    //   1558: aload 9
    //   1560: astore 14
    //   1562: aload 9
    //   1564: astore 13
    //   1566: aload 9
    //   1568: astore 12
    //   1570: aload 10
    //   1572: invokevirtual 194	java/io/FileOutputStream:flush	()V
    //   1575: aload 9
    //   1577: astore 11
    //   1579: aload 9
    //   1581: astore 14
    //   1583: aload 9
    //   1585: astore 13
    //   1587: aload 9
    //   1589: astore 12
    //   1591: aload 10
    //   1593: invokevirtual 153	java/io/FileOutputStream:close	()V
    //   1596: aconst_null
    //   1597: astore 10
    //   1599: aconst_null
    //   1600: astore 16
    //   1602: aload 9
    //   1604: astore 14
    //   1606: aload 9
    //   1608: astore 15
    //   1610: aload 9
    //   1612: astore 13
    //   1614: aload 10
    //   1616: astore 11
    //   1618: aload 9
    //   1620: astore 12
    //   1622: aload 24
    //   1624: invokevirtual 197	java/net/HttpURLConnection:disconnect	()V
    //   1627: aload 9
    //   1629: astore 14
    //   1631: aload 9
    //   1633: astore 15
    //   1635: aload 9
    //   1637: astore 13
    //   1639: aload 10
    //   1641: astore 11
    //   1643: aload 9
    //   1645: astore 12
    //   1647: iconst_3
    //   1648: ldc 71
    //   1650: ldc 73
    //   1652: new 80	java/lang/StringBuilder
    //   1655: dup
    //   1656: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   1659: ldc 199
    //   1661: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1664: lload 7
    //   1666: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1669: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1672: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1675: aload 9
    //   1677: astore 14
    //   1679: aload 9
    //   1681: astore 15
    //   1683: aload 9
    //   1685: astore 13
    //   1687: aload 10
    //   1689: astore 11
    //   1691: aload 9
    //   1693: astore 12
    //   1695: aload_0
    //   1696: aload_0
    //   1697: aload 25
    //   1699: aload_1
    //   1700: aload_2
    //   1701: invokespecial 205	com/tencent/qqlive/mediaplayer/sdkupdate/b:a	(Ljava/io/File;Lcom/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig;Ljava/lang/String;)I
    //   1704: putfield 37	com/tencent/qqlive/mediaplayer/sdkupdate/b:d	I
    //   1707: aload 9
    //   1709: astore 14
    //   1711: aload 9
    //   1713: astore 15
    //   1715: aload 9
    //   1717: astore 13
    //   1719: aload 10
    //   1721: astore 11
    //   1723: aload 9
    //   1725: astore 12
    //   1727: aload_0
    //   1728: getfield 37	com/tencent/qqlive/mediaplayer/sdkupdate/b:d	I
    //   1731: ifeq +352 -> 2083
    //   1734: iload 4
    //   1736: ifne +126 -> 1862
    //   1739: aload 9
    //   1741: astore 14
    //   1743: aload 9
    //   1745: astore 15
    //   1747: aload 9
    //   1749: astore 13
    //   1751: aload 10
    //   1753: astore 11
    //   1755: aload 9
    //   1757: astore 12
    //   1759: iconst_5
    //   1760: ldc 71
    //   1762: ldc 73
    //   1764: ldc 207
    //   1766: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1769: bipush 101
    //   1771: istore_3
    //   1772: aload 9
    //   1774: ifnull +8 -> 1782
    //   1777: aload 9
    //   1779: invokevirtual 178	java/io/InputStream:close	()V
    //   1782: iconst_0
    //   1783: ifeq -1743 -> 40
    //   1786: new 134	java/lang/NullPointerException
    //   1789: dup
    //   1790: invokespecial 135	java/lang/NullPointerException:<init>	()V
    //   1793: athrow
    //   1794: astore_1
    //   1795: iconst_5
    //   1796: ldc 71
    //   1798: ldc 73
    //   1800: new 80	java/lang/StringBuilder
    //   1803: dup
    //   1804: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   1807: ldc 137
    //   1809: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1812: aload_1
    //   1813: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   1816: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1819: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1822: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1825: bipush 101
    //   1827: ireturn
    //   1828: astore_1
    //   1829: iconst_5
    //   1830: ldc 71
    //   1832: ldc 73
    //   1834: new 80	java/lang/StringBuilder
    //   1837: dup
    //   1838: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   1841: ldc 140
    //   1843: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1846: aload_1
    //   1847: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   1850: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1853: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1856: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1859: goto -77 -> 1782
    //   1862: aload 9
    //   1864: astore 14
    //   1866: aload 9
    //   1868: astore 15
    //   1870: aload 9
    //   1872: astore 13
    //   1874: aload 10
    //   1876: astore 11
    //   1878: aload 9
    //   1880: astore 12
    //   1882: aload_0
    //   1883: getfield 37	com/tencent/qqlive/mediaplayer/sdkupdate/b:d	I
    //   1886: istore_3
    //   1887: bipush 103
    //   1889: iload_3
    //   1890: if_icmpne +96 -> 1986
    //   1893: bipush 103
    //   1895: istore_3
    //   1896: aload 9
    //   1898: ifnull +8 -> 1906
    //   1901: aload 9
    //   1903: invokevirtual 178	java/io/InputStream:close	()V
    //   1906: iconst_0
    //   1907: ifeq -1867 -> 40
    //   1910: new 134	java/lang/NullPointerException
    //   1913: dup
    //   1914: invokespecial 135	java/lang/NullPointerException:<init>	()V
    //   1917: athrow
    //   1918: astore_1
    //   1919: iconst_5
    //   1920: ldc 71
    //   1922: ldc 73
    //   1924: new 80	java/lang/StringBuilder
    //   1927: dup
    //   1928: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   1931: ldc 137
    //   1933: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1936: aload_1
    //   1937: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   1940: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1943: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1946: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1949: bipush 103
    //   1951: ireturn
    //   1952: astore_1
    //   1953: iconst_5
    //   1954: ldc 71
    //   1956: ldc 73
    //   1958: new 80	java/lang/StringBuilder
    //   1961: dup
    //   1962: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   1965: ldc 140
    //   1967: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1970: aload_1
    //   1971: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   1974: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1977: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1980: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1983: goto -77 -> 1906
    //   1986: aload 9
    //   1988: ifnull +8 -> 1996
    //   1991: aload 9
    //   1993: invokevirtual 178	java/io/InputStream:close	()V
    //   1996: iconst_0
    //   1997: ifeq +1282 -> 3279
    //   2000: new 134	java/lang/NullPointerException
    //   2003: dup
    //   2004: invokespecial 135	java/lang/NullPointerException:<init>	()V
    //   2007: athrow
    //   2008: astore 9
    //   2010: iconst_5
    //   2011: ldc 71
    //   2013: ldc 73
    //   2015: new 80	java/lang/StringBuilder
    //   2018: dup
    //   2019: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   2022: ldc 140
    //   2024: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2027: aload 9
    //   2029: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   2032: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2035: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2038: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2041: goto -45 -> 1996
    //   2044: astore 9
    //   2046: iconst_5
    //   2047: ldc 71
    //   2049: ldc 73
    //   2051: new 80	java/lang/StringBuilder
    //   2054: dup
    //   2055: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   2058: ldc 137
    //   2060: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2063: aload 9
    //   2065: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   2068: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2071: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2074: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2077: iload 4
    //   2079: istore_3
    //   2080: goto -2078 -> 2
    //   2083: aload 9
    //   2085: ifnull +8 -> 2093
    //   2088: aload 9
    //   2090: invokevirtual 178	java/io/InputStream:close	()V
    //   2093: iconst_0
    //   2094: ifeq +11 -> 2105
    //   2097: new 134	java/lang/NullPointerException
    //   2100: dup
    //   2101: invokespecial 135	java/lang/NullPointerException:<init>	()V
    //   2104: athrow
    //   2105: iconst_0
    //   2106: ireturn
    //   2107: astore_1
    //   2108: iconst_5
    //   2109: ldc 71
    //   2111: ldc 73
    //   2113: new 80	java/lang/StringBuilder
    //   2116: dup
    //   2117: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   2120: ldc 140
    //   2122: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2125: aload_1
    //   2126: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   2129: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2132: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2135: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2138: goto -45 -> 2093
    //   2141: astore_1
    //   2142: iconst_5
    //   2143: ldc 71
    //   2145: ldc 73
    //   2147: new 80	java/lang/StringBuilder
    //   2150: dup
    //   2151: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   2154: ldc 137
    //   2156: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2159: aload_1
    //   2160: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   2163: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2166: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2169: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2172: goto -67 -> 2105
    //   2175: astore_1
    //   2176: iconst_5
    //   2177: ldc 71
    //   2179: ldc 73
    //   2181: new 80	java/lang/StringBuilder
    //   2184: dup
    //   2185: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   2188: ldc 140
    //   2190: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2193: aload_1
    //   2194: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   2197: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2200: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2203: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2206: goto -699 -> 1507
    //   2209: iconst_5
    //   2210: ldc 71
    //   2212: ldc 73
    //   2214: ldc 209
    //   2216: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2219: aload 10
    //   2221: ifnull +8 -> 2229
    //   2224: aload 10
    //   2226: invokevirtual 178	java/io/InputStream:close	()V
    //   2229: aload 9
    //   2231: ifnull +1048 -> 3279
    //   2234: aload 9
    //   2236: invokevirtual 153	java/io/FileOutputStream:close	()V
    //   2239: iload 4
    //   2241: istore_3
    //   2242: goto -2240 -> 2
    //   2245: astore 10
    //   2247: iconst_5
    //   2248: ldc 71
    //   2250: ldc 73
    //   2252: new 80	java/lang/StringBuilder
    //   2255: dup
    //   2256: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   2259: ldc 140
    //   2261: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2264: aload 10
    //   2266: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   2269: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2272: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2275: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2278: goto -49 -> 2229
    //   2281: astore 9
    //   2283: iconst_5
    //   2284: ldc 71
    //   2286: ldc 73
    //   2288: new 80	java/lang/StringBuilder
    //   2291: dup
    //   2292: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   2295: ldc 137
    //   2297: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2300: aload 9
    //   2302: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   2305: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2308: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2311: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2314: iload 4
    //   2316: istore_3
    //   2317: goto -2315 -> 2
    //   2320: aconst_null
    //   2321: astore 9
    //   2323: astore 10
    //   2325: aload 9
    //   2327: astore 11
    //   2329: aload 14
    //   2331: astore 12
    //   2333: aload_0
    //   2334: bipush 100
    //   2336: putfield 37	com/tencent/qqlive/mediaplayer/sdkupdate/b:d	I
    //   2339: iload 4
    //   2341: ifne +115 -> 2456
    //   2344: aload 9
    //   2346: astore 11
    //   2348: aload 14
    //   2350: astore 12
    //   2352: iconst_5
    //   2353: ldc 71
    //   2355: ldc 73
    //   2357: ldc 191
    //   2359: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2362: bipush 100
    //   2364: istore_3
    //   2365: aload 14
    //   2367: ifnull +8 -> 2375
    //   2370: aload 14
    //   2372: invokevirtual 178	java/io/InputStream:close	()V
    //   2375: aload 9
    //   2377: ifnull -2337 -> 40
    //   2380: aload 9
    //   2382: invokevirtual 153	java/io/FileOutputStream:close	()V
    //   2385: bipush 100
    //   2387: ireturn
    //   2388: astore_1
    //   2389: iconst_5
    //   2390: ldc 71
    //   2392: ldc 73
    //   2394: new 80	java/lang/StringBuilder
    //   2397: dup
    //   2398: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   2401: ldc 137
    //   2403: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2406: aload_1
    //   2407: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   2410: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2413: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2416: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2419: bipush 100
    //   2421: ireturn
    //   2422: astore_1
    //   2423: iconst_5
    //   2424: ldc 71
    //   2426: ldc 73
    //   2428: new 80	java/lang/StringBuilder
    //   2431: dup
    //   2432: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   2435: ldc 140
    //   2437: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2440: aload_1
    //   2441: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   2444: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2447: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2450: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2453: goto -78 -> 2375
    //   2456: aload 9
    //   2458: astore 11
    //   2460: aload 14
    //   2462: astore 12
    //   2464: iconst_5
    //   2465: ldc 71
    //   2467: ldc 73
    //   2469: ldc 209
    //   2471: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2474: aload 14
    //   2476: ifnull +8 -> 2484
    //   2479: aload 14
    //   2481: invokevirtual 178	java/io/InputStream:close	()V
    //   2484: aload 9
    //   2486: ifnull +793 -> 3279
    //   2489: aload 9
    //   2491: invokevirtual 153	java/io/FileOutputStream:close	()V
    //   2494: iload 4
    //   2496: istore_3
    //   2497: goto -2495 -> 2
    //   2500: astore 10
    //   2502: iconst_5
    //   2503: ldc 71
    //   2505: ldc 73
    //   2507: new 80	java/lang/StringBuilder
    //   2510: dup
    //   2511: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   2514: ldc 140
    //   2516: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2519: aload 10
    //   2521: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   2524: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2527: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2530: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2533: goto -49 -> 2484
    //   2536: astore 9
    //   2538: iconst_5
    //   2539: ldc 71
    //   2541: ldc 73
    //   2543: new 80	java/lang/StringBuilder
    //   2546: dup
    //   2547: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   2550: ldc 137
    //   2552: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2555: aload 9
    //   2557: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   2560: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2563: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2566: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2569: iload 4
    //   2571: istore_3
    //   2572: goto -2570 -> 2
    //   2575: aconst_null
    //   2576: astore 9
    //   2578: astore 10
    //   2580: aload 15
    //   2582: astore 13
    //   2584: aload 9
    //   2586: astore 11
    //   2588: aload 13
    //   2590: astore 12
    //   2592: aload_0
    //   2593: bipush 101
    //   2595: putfield 37	com/tencent/qqlive/mediaplayer/sdkupdate/b:d	I
    //   2598: iload 4
    //   2600: ifne +115 -> 2715
    //   2603: aload 9
    //   2605: astore 11
    //   2607: aload 13
    //   2609: astore 12
    //   2611: iconst_5
    //   2612: ldc 71
    //   2614: ldc 73
    //   2616: ldc 191
    //   2618: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2621: bipush 101
    //   2623: istore_3
    //   2624: aload 13
    //   2626: ifnull +8 -> 2634
    //   2629: aload 13
    //   2631: invokevirtual 178	java/io/InputStream:close	()V
    //   2634: aload 9
    //   2636: ifnull -2596 -> 40
    //   2639: aload 9
    //   2641: invokevirtual 153	java/io/FileOutputStream:close	()V
    //   2644: bipush 101
    //   2646: ireturn
    //   2647: astore_1
    //   2648: iconst_5
    //   2649: ldc 71
    //   2651: ldc 73
    //   2653: new 80	java/lang/StringBuilder
    //   2656: dup
    //   2657: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   2660: ldc 137
    //   2662: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2665: aload_1
    //   2666: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   2669: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2672: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2675: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2678: bipush 101
    //   2680: ireturn
    //   2681: astore_1
    //   2682: iconst_5
    //   2683: ldc 71
    //   2685: ldc 73
    //   2687: new 80	java/lang/StringBuilder
    //   2690: dup
    //   2691: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   2694: ldc 140
    //   2696: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2699: aload_1
    //   2700: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   2703: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2706: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2709: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2712: goto -78 -> 2634
    //   2715: aload 9
    //   2717: astore 11
    //   2719: aload 13
    //   2721: astore 12
    //   2723: iconst_5
    //   2724: ldc 71
    //   2726: ldc 73
    //   2728: ldc 209
    //   2730: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2733: aload 13
    //   2735: ifnull +8 -> 2743
    //   2738: aload 13
    //   2740: invokevirtual 178	java/io/InputStream:close	()V
    //   2743: aload 9
    //   2745: ifnull +534 -> 3279
    //   2748: aload 9
    //   2750: invokevirtual 153	java/io/FileOutputStream:close	()V
    //   2753: iload 4
    //   2755: istore_3
    //   2756: goto -2754 -> 2
    //   2759: astore 10
    //   2761: iconst_5
    //   2762: ldc 71
    //   2764: ldc 73
    //   2766: new 80	java/lang/StringBuilder
    //   2769: dup
    //   2770: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   2773: ldc 140
    //   2775: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2778: aload 10
    //   2780: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   2783: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2786: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2789: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2792: goto -49 -> 2743
    //   2795: astore 9
    //   2797: iconst_5
    //   2798: ldc 71
    //   2800: ldc 73
    //   2802: new 80	java/lang/StringBuilder
    //   2805: dup
    //   2806: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   2809: ldc 137
    //   2811: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2814: aload 9
    //   2816: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   2819: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2822: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2825: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2828: iload 4
    //   2830: istore_3
    //   2831: goto -2829 -> 2
    //   2834: aconst_null
    //   2835: astore 9
    //   2837: astore 10
    //   2839: aload 9
    //   2841: astore 11
    //   2843: aload 13
    //   2845: astore 12
    //   2847: aload_0
    //   2848: bipush 101
    //   2850: putfield 37	com/tencent/qqlive/mediaplayer/sdkupdate/b:d	I
    //   2853: iload 4
    //   2855: ifne +115 -> 2970
    //   2858: aload 9
    //   2860: astore 11
    //   2862: aload 13
    //   2864: astore 12
    //   2866: iconst_5
    //   2867: ldc 71
    //   2869: ldc 73
    //   2871: ldc 191
    //   2873: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2876: bipush 101
    //   2878: istore_3
    //   2879: aload 13
    //   2881: ifnull +8 -> 2889
    //   2884: aload 13
    //   2886: invokevirtual 178	java/io/InputStream:close	()V
    //   2889: aload 9
    //   2891: ifnull -2851 -> 40
    //   2894: aload 9
    //   2896: invokevirtual 153	java/io/FileOutputStream:close	()V
    //   2899: bipush 101
    //   2901: ireturn
    //   2902: astore_1
    //   2903: iconst_5
    //   2904: ldc 71
    //   2906: ldc 73
    //   2908: new 80	java/lang/StringBuilder
    //   2911: dup
    //   2912: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   2915: ldc 137
    //   2917: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2920: aload_1
    //   2921: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   2924: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2927: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2930: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2933: bipush 101
    //   2935: ireturn
    //   2936: astore_1
    //   2937: iconst_5
    //   2938: ldc 71
    //   2940: ldc 73
    //   2942: new 80	java/lang/StringBuilder
    //   2945: dup
    //   2946: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   2949: ldc 140
    //   2951: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2954: aload_1
    //   2955: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   2958: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2961: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2964: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2967: goto -78 -> 2889
    //   2970: aload 9
    //   2972: astore 11
    //   2974: aload 13
    //   2976: astore 12
    //   2978: iconst_5
    //   2979: ldc 71
    //   2981: ldc 73
    //   2983: ldc 209
    //   2985: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2988: aload 13
    //   2990: ifnull +8 -> 2998
    //   2993: aload 13
    //   2995: invokevirtual 178	java/io/InputStream:close	()V
    //   2998: aload 9
    //   3000: ifnull +279 -> 3279
    //   3003: aload 9
    //   3005: invokevirtual 153	java/io/FileOutputStream:close	()V
    //   3008: iload 4
    //   3010: istore_3
    //   3011: goto -3009 -> 2
    //   3014: astore 10
    //   3016: iconst_5
    //   3017: ldc 71
    //   3019: ldc 73
    //   3021: new 80	java/lang/StringBuilder
    //   3024: dup
    //   3025: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   3028: ldc 140
    //   3030: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3033: aload 10
    //   3035: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   3038: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3041: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3044: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3047: goto -49 -> 2998
    //   3050: astore 9
    //   3052: iconst_5
    //   3053: ldc 71
    //   3055: ldc 73
    //   3057: new 80	java/lang/StringBuilder
    //   3060: dup
    //   3061: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   3064: ldc 137
    //   3066: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3069: aload 9
    //   3071: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   3074: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3077: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3080: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3083: iload 4
    //   3085: istore_3
    //   3086: goto -3084 -> 2
    //   3089: astore_1
    //   3090: aload 11
    //   3092: astore 9
    //   3094: aload 12
    //   3096: ifnull +8 -> 3104
    //   3099: aload 12
    //   3101: invokevirtual 178	java/io/InputStream:close	()V
    //   3104: aload 9
    //   3106: ifnull +8 -> 3114
    //   3109: aload 9
    //   3111: invokevirtual 153	java/io/FileOutputStream:close	()V
    //   3114: aload_1
    //   3115: athrow
    //   3116: astore_2
    //   3117: iconst_5
    //   3118: ldc 71
    //   3120: ldc 73
    //   3122: new 80	java/lang/StringBuilder
    //   3125: dup
    //   3126: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   3129: ldc 140
    //   3131: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3134: aload_2
    //   3135: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   3138: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3141: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3144: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3147: goto -43 -> 3104
    //   3150: astore_2
    //   3151: iconst_5
    //   3152: ldc 71
    //   3154: ldc 73
    //   3156: new 80	java/lang/StringBuilder
    //   3159: dup
    //   3160: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   3163: ldc 137
    //   3165: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3168: aload_2
    //   3169: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   3172: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3175: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3178: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3181: goto -67 -> 3114
    //   3184: bipush 100
    //   3186: ireturn
    //   3187: astore_1
    //   3188: aload 10
    //   3190: astore 9
    //   3192: aload 11
    //   3194: astore 12
    //   3196: goto -102 -> 3094
    //   3199: astore_1
    //   3200: aload 10
    //   3202: astore 12
    //   3204: goto -110 -> 3094
    //   3207: astore 9
    //   3209: aload 10
    //   3211: astore 9
    //   3213: aload 14
    //   3215: astore 13
    //   3217: goto -378 -> 2839
    //   3220: astore 9
    //   3222: aload 10
    //   3224: astore 9
    //   3226: goto -642 -> 2584
    //   3229: astore 9
    //   3231: aload 10
    //   3233: astore 9
    //   3235: aload 12
    //   3237: astore 14
    //   3239: goto -914 -> 2325
    //   3242: astore 9
    //   3244: aconst_null
    //   3245: astore 10
    //   3247: aload 19
    //   3249: astore 9
    //   3251: goto -1778 -> 1473
    //   3254: astore 9
    //   3256: aload 10
    //   3258: astore 9
    //   3260: aconst_null
    //   3261: astore 10
    //   3263: goto -1790 -> 1473
    //   3266: astore 10
    //   3268: aload 9
    //   3270: astore 10
    //   3272: aload 16
    //   3274: astore 9
    //   3276: goto -1803 -> 1473
    //   3279: iload 4
    //   3281: istore_3
    //   3282: goto -3280 -> 2
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3285	0	this	b
    //   0	3285	1	paramSDKLocalConfig	SDKLocalConfig
    //   0	3285	2	paramString	String
    //   1	3281	3	n	int
    //   5	3275	4	i1	int
    //   1084	362	5	l1	long
    //   844	821	7	l2	long
    //   85	1	9	localObject1	Object
    //   392	20	9	localException1	Exception
    //   428	248	9	localException2	Exception
    //   742	20	9	localException3	Exception
    //   778	80	9	localException4	Exception
    //   1008	20	9	localException5	Exception
    //   1044	47	9	localException6	Exception
    //   1107	138	9	localInputStream	java.io.InputStream
    //   1265	20	9	localException7	Exception
    //   1301	165	9	localException8	Exception
    //   1471	521	9	localObject2	Object
    //   2008	20	9	localException9	Exception
    //   2044	191	9	localException10	Exception
    //   2281	20	9	localException11	Exception
    //   2321	169	9	localObject3	Object
    //   2536	20	9	localException12	Exception
    //   2576	173	9	localObject4	Object
    //   2795	20	9	localException13	Exception
    //   2835	169	9	localObject5	Object
    //   3050	20	9	localException14	Exception
    //   3092	99	9	localObject6	Object
    //   3207	1	9	localThrowable1	Throwable
    //   3211	1	9	localObject7	Object
    //   3220	1	9	localOutOfMemoryError1	OutOfMemoryError
    //   3224	1	9	localObject8	Object
    //   3229	1	9	localNoSuchMethodError1	java.lang.NoSuchMethodError
    //   3233	1	9	localObject9	Object
    //   3242	1	9	localException15	Exception
    //   3249	1	9	localObject10	Object
    //   3254	1	9	localException16	Exception
    //   3258	17	9	localObject11	Object
    //   97	2128	10	localObject12	Object
    //   2245	20	10	localException17	Exception
    //   2323	1	10	localNoSuchMethodError2	java.lang.NoSuchMethodError
    //   2500	20	10	localException18	Exception
    //   2578	1	10	localOutOfMemoryError2	OutOfMemoryError
    //   2759	20	10	localException19	Exception
    //   2837	1	10	localThrowable2	Throwable
    //   3014	218	10	localException20	Exception
    //   3245	17	10	localObject13	Object
    //   3266	1	10	localException21	Exception
    //   3270	1	10	localObject14	Object
    //   116	1315	11	localObject15	Object
    //   1459	1	11	localException22	Exception
    //   1463	1730	11	localObject16	Object
    //   120	3116	12	localObject17	Object
    //   112	3104	13	localObject18	Object
    //   104	3134	14	localObject19	Object
    //   108	2473	15	localObject20	Object
    //   88	3185	16	localObject21	Object
    //   91	1008	17	localObject22	Object
    //   82	1005	18	localObject23	Object
    //   100	3148	19	localObject24	Object
    //   94	374	20	localObject25	Object
    //   76	400	21	localObject26	Object
    //   73	399	22	localObject27	Object
    //   79	405	23	localObject28	Object
    //   231	1392	24	localHttpURLConnection	java.net.HttpURLConnection
    //   163	1535	25	localFile	File
    // Exception table:
    //   from	to	target	type
    //   292	300	300	java/lang/Exception
    //   280	288	334	java/lang/Exception
    //   372	380	392	java/lang/Exception
    //   384	392	428	java/lang/Exception
    //   595	600	603	java/lang/Exception
    //   582	590	637	java/lang/Exception
    //   718	726	742	java/lang/Exception
    //   731	736	778	java/lang/Exception
    //   904	909	912	java/lang/Exception
    //   891	899	946	java/lang/Exception
    //   984	992	1008	java/lang/Exception
    //   997	1002	1044	java/lang/Exception
    //   1163	1168	1171	java/lang/Exception
    //   1153	1158	1205	java/lang/Exception
    //   1244	1249	1265	java/lang/Exception
    //   1254	1259	1301	java/lang/Exception
    //   1135	1145	1459	java/lang/Exception
    //   1356	1363	1459	java/lang/Exception
    //   1379	1391	1459	java/lang/Exception
    //   1412	1421	1459	java/lang/Exception
    //   1444	1456	1459	java/lang/Exception
    //   1570	1575	1459	java/lang/Exception
    //   1591	1596	1459	java/lang/Exception
    //   1512	1517	1520	java/lang/Exception
    //   1786	1794	1794	java/lang/Exception
    //   1777	1782	1828	java/lang/Exception
    //   1910	1918	1918	java/lang/Exception
    //   1901	1906	1952	java/lang/Exception
    //   1991	1996	2008	java/lang/Exception
    //   2000	2008	2044	java/lang/Exception
    //   2088	2093	2107	java/lang/Exception
    //   2097	2105	2141	java/lang/Exception
    //   1502	1507	2175	java/lang/Exception
    //   2224	2229	2245	java/lang/Exception
    //   2234	2239	2281	java/lang/Exception
    //   122	133	2320	java/lang/NoSuchMethodError
    //   153	165	2320	java/lang/NoSuchMethodError
    //   185	194	2320	java/lang/NoSuchMethodError
    //   214	233	2320	java/lang/NoSuchMethodError
    //   258	268	2320	java/lang/NoSuchMethodError
    //   487	498	2320	java/lang/NoSuchMethodError
    //   1622	1627	2320	java/lang/NoSuchMethodError
    //   1647	1675	2320	java/lang/NoSuchMethodError
    //   1695	1707	2320	java/lang/NoSuchMethodError
    //   1727	1734	2320	java/lang/NoSuchMethodError
    //   1759	1769	2320	java/lang/NoSuchMethodError
    //   1882	1887	2320	java/lang/NoSuchMethodError
    //   2380	2385	2388	java/lang/Exception
    //   2370	2375	2422	java/lang/Exception
    //   2479	2484	2500	java/lang/Exception
    //   2489	2494	2536	java/lang/Exception
    //   122	133	2575	java/lang/OutOfMemoryError
    //   153	165	2575	java/lang/OutOfMemoryError
    //   185	194	2575	java/lang/OutOfMemoryError
    //   214	233	2575	java/lang/OutOfMemoryError
    //   258	268	2575	java/lang/OutOfMemoryError
    //   487	498	2575	java/lang/OutOfMemoryError
    //   1622	1627	2575	java/lang/OutOfMemoryError
    //   1647	1675	2575	java/lang/OutOfMemoryError
    //   1695	1707	2575	java/lang/OutOfMemoryError
    //   1727	1734	2575	java/lang/OutOfMemoryError
    //   1759	1769	2575	java/lang/OutOfMemoryError
    //   1882	1887	2575	java/lang/OutOfMemoryError
    //   2639	2644	2647	java/lang/Exception
    //   2629	2634	2681	java/lang/Exception
    //   2738	2743	2759	java/lang/Exception
    //   2748	2753	2795	java/lang/Exception
    //   122	133	2834	java/lang/Throwable
    //   153	165	2834	java/lang/Throwable
    //   185	194	2834	java/lang/Throwable
    //   214	233	2834	java/lang/Throwable
    //   258	268	2834	java/lang/Throwable
    //   487	498	2834	java/lang/Throwable
    //   1622	1627	2834	java/lang/Throwable
    //   1647	1675	2834	java/lang/Throwable
    //   1695	1707	2834	java/lang/Throwable
    //   1727	1734	2834	java/lang/Throwable
    //   1759	1769	2834	java/lang/Throwable
    //   1882	1887	2834	java/lang/Throwable
    //   2894	2899	2902	java/lang/Exception
    //   2884	2889	2936	java/lang/Exception
    //   2993	2998	3014	java/lang/Exception
    //   3003	3008	3050	java/lang/Exception
    //   122	133	3089	finally
    //   153	165	3089	finally
    //   185	194	3089	finally
    //   214	233	3089	finally
    //   258	268	3089	finally
    //   487	498	3089	finally
    //   1622	1627	3089	finally
    //   1647	1675	3089	finally
    //   1695	1707	3089	finally
    //   1727	1734	3089	finally
    //   1759	1769	3089	finally
    //   1882	1887	3089	finally
    //   2333	2339	3089	finally
    //   2352	2362	3089	finally
    //   2464	2474	3089	finally
    //   2592	2598	3089	finally
    //   2611	2621	3089	finally
    //   2723	2733	3089	finally
    //   2847	2853	3089	finally
    //   2866	2876	3089	finally
    //   2978	2988	3089	finally
    //   3099	3104	3116	java/lang/Exception
    //   3109	3114	3150	java/lang/Exception
    //   514	520	3187	finally
    //   548	575	3187	finally
    //   687	714	3187	finally
    //   833	846	3187	finally
    //   869	879	3187	finally
    //   1102	1109	3187	finally
    //   1135	1145	3187	finally
    //   1356	1363	3187	finally
    //   1379	1391	3187	finally
    //   1412	1421	3187	finally
    //   1444	1456	3187	finally
    //   1570	1575	3187	finally
    //   1591	1596	3187	finally
    //   1473	1479	3199	finally
    //   1484	1494	3199	finally
    //   2209	2219	3199	finally
    //   514	520	3207	java/lang/Throwable
    //   548	575	3207	java/lang/Throwable
    //   687	714	3207	java/lang/Throwable
    //   833	846	3207	java/lang/Throwable
    //   869	879	3207	java/lang/Throwable
    //   1102	1109	3207	java/lang/Throwable
    //   1135	1145	3207	java/lang/Throwable
    //   1356	1363	3207	java/lang/Throwable
    //   1379	1391	3207	java/lang/Throwable
    //   1412	1421	3207	java/lang/Throwable
    //   1444	1456	3207	java/lang/Throwable
    //   1570	1575	3207	java/lang/Throwable
    //   1591	1596	3207	java/lang/Throwable
    //   514	520	3220	java/lang/OutOfMemoryError
    //   548	575	3220	java/lang/OutOfMemoryError
    //   687	714	3220	java/lang/OutOfMemoryError
    //   833	846	3220	java/lang/OutOfMemoryError
    //   869	879	3220	java/lang/OutOfMemoryError
    //   1102	1109	3220	java/lang/OutOfMemoryError
    //   1135	1145	3220	java/lang/OutOfMemoryError
    //   1356	1363	3220	java/lang/OutOfMemoryError
    //   1379	1391	3220	java/lang/OutOfMemoryError
    //   1412	1421	3220	java/lang/OutOfMemoryError
    //   1444	1456	3220	java/lang/OutOfMemoryError
    //   1570	1575	3220	java/lang/OutOfMemoryError
    //   1591	1596	3220	java/lang/OutOfMemoryError
    //   514	520	3229	java/lang/NoSuchMethodError
    //   548	575	3229	java/lang/NoSuchMethodError
    //   687	714	3229	java/lang/NoSuchMethodError
    //   833	846	3229	java/lang/NoSuchMethodError
    //   869	879	3229	java/lang/NoSuchMethodError
    //   1102	1109	3229	java/lang/NoSuchMethodError
    //   1135	1145	3229	java/lang/NoSuchMethodError
    //   1356	1363	3229	java/lang/NoSuchMethodError
    //   1379	1391	3229	java/lang/NoSuchMethodError
    //   1412	1421	3229	java/lang/NoSuchMethodError
    //   1444	1456	3229	java/lang/NoSuchMethodError
    //   1570	1575	3229	java/lang/NoSuchMethodError
    //   1591	1596	3229	java/lang/NoSuchMethodError
    //   122	133	3242	java/lang/Exception
    //   153	165	3242	java/lang/Exception
    //   185	194	3242	java/lang/Exception
    //   214	233	3242	java/lang/Exception
    //   258	268	3242	java/lang/Exception
    //   487	498	3242	java/lang/Exception
    //   514	520	3254	java/lang/Exception
    //   548	575	3254	java/lang/Exception
    //   687	714	3254	java/lang/Exception
    //   833	846	3254	java/lang/Exception
    //   869	879	3254	java/lang/Exception
    //   1102	1109	3254	java/lang/Exception
    //   1622	1627	3266	java/lang/Exception
    //   1647	1675	3266	java/lang/Exception
    //   1695	1707	3266	java/lang/Exception
    //   1727	1734	3266	java/lang/Exception
    //   1759	1769	3266	java/lang/Exception
    //   1882	1887	3266	java/lang/Exception
  }
  
  /* Error */
  private int a(File paramFile, SDKLocalConfig paramSDKLocalConfig, String paramString)
  {
    // Byte code:
    //   0: bipush 103
    //   2: istore 5
    //   4: aconst_null
    //   5: astore 12
    //   7: aconst_null
    //   8: astore 13
    //   10: aconst_null
    //   11: astore 6
    //   13: iload 5
    //   15: istore 4
    //   17: aload_1
    //   18: ifnull +60 -> 78
    //   21: iload 5
    //   23: istore 4
    //   25: aload_1
    //   26: invokevirtual 214	java/io/File:exists	()Z
    //   29: ifeq +49 -> 78
    //   32: aload_0
    //   33: aload_1
    //   34: aload_2
    //   35: getfield 217	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:MD5	Ljava/lang/String;
    //   38: invokevirtual 220	com/tencent/qqlive/mediaplayer/sdkupdate/b:a	(Ljava/io/File;Ljava/lang/String;)Z
    //   41: ifne +40 -> 81
    //   44: iconst_5
    //   45: ldc 71
    //   47: ldc 73
    //   49: new 80	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   56: ldc 222
    //   58: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_2
    //   62: getfield 217	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:MD5	Ljava/lang/String;
    //   65: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   74: iload 5
    //   76: istore 4
    //   78: iload 4
    //   80: ireturn
    //   81: aload_0
    //   82: aload_1
    //   83: invokevirtual 225	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   86: aload_3
    //   87: invokevirtual 228	com/tencent/qqlive/mediaplayer/sdkupdate/b:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   90: ifne +16 -> 106
    //   93: iconst_5
    //   94: ldc 71
    //   96: ldc 73
    //   98: ldc 230
    //   100: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   103: bipush 103
    //   105: ireturn
    //   106: aload_0
    //   107: iconst_1
    //   108: putfield 51	com/tencent/qqlive/mediaplayer/sdkupdate/b:k	Z
    //   111: aload_0
    //   112: aload_3
    //   113: invokespecial 233	com/tencent/qqlive/mediaplayer/sdkupdate/b:a	(Ljava/lang/String;)Ljava/io/File;
    //   116: astore 7
    //   118: aload 7
    //   120: ifnonnull +16 -> 136
    //   123: iconst_5
    //   124: ldc 71
    //   126: ldc 73
    //   128: ldc 235
    //   130: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   133: bipush 103
    //   135: ireturn
    //   136: aload_2
    //   137: aload 7
    //   139: invokestatic 238	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(Ljava/io/File;)Ljava/lang/String;
    //   142: putfield 241	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:JARMD5	Ljava/lang/String;
    //   145: new 96	java/io/File
    //   148: dup
    //   149: aload_3
    //   150: ldc 243
    //   152: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: astore_3
    //   156: new 245	java/io/ByteArrayOutputStream
    //   159: dup
    //   160: sipush 4096
    //   163: invokespecial 248	java/io/ByteArrayOutputStream:<init>	(I)V
    //   166: astore 7
    //   168: new 250	java/io/ObjectOutputStream
    //   171: dup
    //   172: aload 7
    //   174: invokespecial 253	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   177: astore 11
    //   179: aload 13
    //   181: astore 10
    //   183: aload 11
    //   185: astore 9
    //   187: aload 7
    //   189: astore 8
    //   191: aload 11
    //   193: aload_2
    //   194: invokevirtual 257	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   197: aload 13
    //   199: astore 10
    //   201: aload 11
    //   203: astore 9
    //   205: aload 7
    //   207: astore 8
    //   209: aload 11
    //   211: invokevirtual 258	java/io/ObjectOutputStream:flush	()V
    //   214: aload 13
    //   216: astore 10
    //   218: aload 11
    //   220: astore 9
    //   222: aload 7
    //   224: astore 8
    //   226: aload 11
    //   228: invokevirtual 259	java/io/ObjectOutputStream:close	()V
    //   231: new 142	java/io/FileOutputStream
    //   234: dup
    //   235: aload_3
    //   236: invokespecial 144	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   239: astore_3
    //   240: aload 7
    //   242: aload_3
    //   243: invokevirtual 262	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   246: aload 7
    //   248: invokevirtual 263	java/io/ByteArrayOutputStream:flush	()V
    //   251: aload 7
    //   253: invokevirtual 264	java/io/ByteArrayOutputStream:close	()V
    //   256: aload_3
    //   257: invokevirtual 153	java/io/FileOutputStream:close	()V
    //   260: iconst_3
    //   261: ldc 71
    //   263: ldc 73
    //   265: new 80	java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   272: ldc_w 266
    //   275: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload_2
    //   279: getfield 269	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:version	Ljava/lang/String;
    //   282: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: ldc_w 271
    //   288: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: aload_2
    //   292: getfield 241	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:JARMD5	Ljava/lang/String;
    //   295: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   304: iconst_0
    //   305: ifeq +11 -> 316
    //   308: new 134	java/lang/NullPointerException
    //   311: dup
    //   312: invokespecial 135	java/lang/NullPointerException:<init>	()V
    //   315: athrow
    //   316: iconst_0
    //   317: ifeq +11 -> 328
    //   320: new 134	java/lang/NullPointerException
    //   323: dup
    //   324: invokespecial 135	java/lang/NullPointerException:<init>	()V
    //   327: athrow
    //   328: iconst_0
    //   329: ifeq +11 -> 340
    //   332: new 134	java/lang/NullPointerException
    //   335: dup
    //   336: invokespecial 135	java/lang/NullPointerException:<init>	()V
    //   339: athrow
    //   340: aload_1
    //   341: invokevirtual 274	java/io/File:delete	()Z
    //   344: pop
    //   345: iconst_0
    //   346: ireturn
    //   347: astore_2
    //   348: aload_2
    //   349: invokevirtual 277	java/io/IOException:printStackTrace	()V
    //   352: goto -36 -> 316
    //   355: astore_2
    //   356: aload_2
    //   357: invokevirtual 277	java/io/IOException:printStackTrace	()V
    //   360: goto -32 -> 328
    //   363: astore_2
    //   364: aload_2
    //   365: invokevirtual 277	java/io/IOException:printStackTrace	()V
    //   368: goto -28 -> 340
    //   371: astore_3
    //   372: aconst_null
    //   373: astore_2
    //   374: aconst_null
    //   375: astore 7
    //   377: aload 6
    //   379: astore 10
    //   381: aload_2
    //   382: astore 9
    //   384: aload 7
    //   386: astore 8
    //   388: iconst_5
    //   389: ldc 71
    //   391: ldc 73
    //   393: new 80	java/lang/StringBuilder
    //   396: dup
    //   397: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   400: ldc_w 279
    //   403: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: aload_3
    //   407: invokevirtual 280	java/io/IOException:toString	()Ljava/lang/String;
    //   410: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   416: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   419: aload 6
    //   421: astore 10
    //   423: aload_2
    //   424: astore 9
    //   426: aload 7
    //   428: astore 8
    //   430: aload_1
    //   431: invokevirtual 274	java/io/File:delete	()Z
    //   434: pop
    //   435: bipush 104
    //   437: istore 4
    //   439: aload 6
    //   441: ifnull +8 -> 449
    //   444: aload 6
    //   446: invokevirtual 153	java/io/FileOutputStream:close	()V
    //   449: aload_2
    //   450: ifnull +7 -> 457
    //   453: aload_2
    //   454: invokevirtual 259	java/io/ObjectOutputStream:close	()V
    //   457: aload 7
    //   459: ifnull -381 -> 78
    //   462: aload 7
    //   464: invokevirtual 264	java/io/ByteArrayOutputStream:close	()V
    //   467: bipush 104
    //   469: ireturn
    //   470: astore_1
    //   471: aload_1
    //   472: invokevirtual 277	java/io/IOException:printStackTrace	()V
    //   475: bipush 104
    //   477: ireturn
    //   478: astore_1
    //   479: aload_1
    //   480: invokevirtual 277	java/io/IOException:printStackTrace	()V
    //   483: goto -34 -> 449
    //   486: astore_1
    //   487: aload_1
    //   488: invokevirtual 277	java/io/IOException:printStackTrace	()V
    //   491: goto -34 -> 457
    //   494: astore_1
    //   495: aconst_null
    //   496: astore_2
    //   497: aconst_null
    //   498: astore 6
    //   500: aload 12
    //   502: astore_3
    //   503: aload_3
    //   504: ifnull +7 -> 511
    //   507: aload_3
    //   508: invokevirtual 153	java/io/FileOutputStream:close	()V
    //   511: aload_2
    //   512: ifnull +7 -> 519
    //   515: aload_2
    //   516: invokevirtual 259	java/io/ObjectOutputStream:close	()V
    //   519: aload 6
    //   521: ifnull +8 -> 529
    //   524: aload 6
    //   526: invokevirtual 264	java/io/ByteArrayOutputStream:close	()V
    //   529: aload_1
    //   530: athrow
    //   531: astore_3
    //   532: aload_3
    //   533: invokevirtual 277	java/io/IOException:printStackTrace	()V
    //   536: goto -25 -> 511
    //   539: astore_2
    //   540: aload_2
    //   541: invokevirtual 277	java/io/IOException:printStackTrace	()V
    //   544: goto -25 -> 519
    //   547: astore_2
    //   548: aload_2
    //   549: invokevirtual 277	java/io/IOException:printStackTrace	()V
    //   552: goto -23 -> 529
    //   555: astore_1
    //   556: aconst_null
    //   557: astore_2
    //   558: aload 12
    //   560: astore_3
    //   561: aload 7
    //   563: astore 6
    //   565: goto -62 -> 503
    //   568: astore_1
    //   569: aload 10
    //   571: astore_3
    //   572: aload 9
    //   574: astore_2
    //   575: aload 8
    //   577: astore 6
    //   579: goto -76 -> 503
    //   582: astore_1
    //   583: aconst_null
    //   584: astore_2
    //   585: aload 7
    //   587: astore 6
    //   589: goto -86 -> 503
    //   592: astore_1
    //   593: aconst_null
    //   594: astore 6
    //   596: aconst_null
    //   597: astore_2
    //   598: goto -95 -> 503
    //   601: astore_3
    //   602: aconst_null
    //   603: astore_2
    //   604: goto -227 -> 377
    //   607: astore_3
    //   608: aload 11
    //   610: astore_2
    //   611: goto -234 -> 377
    //   614: astore 8
    //   616: aconst_null
    //   617: astore_2
    //   618: aload_3
    //   619: astore 6
    //   621: aload 8
    //   623: astore_3
    //   624: goto -247 -> 377
    //   627: astore 8
    //   629: aconst_null
    //   630: astore 7
    //   632: aload_3
    //   633: astore 6
    //   635: aconst_null
    //   636: astore_2
    //   637: aload 8
    //   639: astore_3
    //   640: goto -263 -> 377
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	643	0	this	b
    //   0	643	1	paramFile	File
    //   0	643	2	paramSDKLocalConfig	SDKLocalConfig
    //   0	643	3	paramString	String
    //   15	423	4	n	int
    //   2	73	5	i1	int
    //   11	623	6	localObject1	Object
    //   116	515	7	localObject2	Object
    //   189	387	8	localObject3	Object
    //   614	8	8	localIOException1	java.io.IOException
    //   627	11	8	localIOException2	java.io.IOException
    //   185	388	9	localObject4	Object
    //   181	389	10	localObject5	Object
    //   177	432	11	localObjectOutputStream	java.io.ObjectOutputStream
    //   5	554	12	localObject6	Object
    //   8	207	13	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   308	316	347	java/io/IOException
    //   320	328	355	java/io/IOException
    //   332	340	363	java/io/IOException
    //   145	168	371	java/io/IOException
    //   260	304	371	java/io/IOException
    //   462	467	470	java/io/IOException
    //   444	449	478	java/io/IOException
    //   453	457	486	java/io/IOException
    //   145	168	494	finally
    //   260	304	494	finally
    //   507	511	531	java/io/IOException
    //   515	519	539	java/io/IOException
    //   524	529	547	java/io/IOException
    //   168	179	555	finally
    //   231	240	555	finally
    //   191	197	568	finally
    //   209	214	568	finally
    //   226	231	568	finally
    //   388	419	568	finally
    //   430	435	568	finally
    //   240	256	582	finally
    //   256	260	592	finally
    //   168	179	601	java/io/IOException
    //   231	240	601	java/io/IOException
    //   191	197	607	java/io/IOException
    //   209	214	607	java/io/IOException
    //   226	231	607	java/io/IOException
    //   240	256	614	java/io/IOException
    //   256	260	627	java/io/IOException
  }
  
  private File a(String paramString)
  {
    if (paramString.contains("TencentVideoKitUpdate")) {}
    for (paramString = this.f;; paramString = this.e)
    {
      paramString = b(paramString, "TVK_MediaPlayer");
      if (TextUtils.isEmpty(paramString)) {
        break;
      }
      return new File(paramString);
    }
    return null;
  }
  
  /* Error */
  private String a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 7
    //   8: aconst_null
    //   9: astore 8
    //   11: aconst_null
    //   12: astore 4
    //   14: new 117	java/net/URL
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 124	java/net/URL:<init>	(Ljava/lang/String;)V
    //   22: invokevirtual 128	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   25: checkcast 130	java/net/HttpURLConnection
    //   28: astore_1
    //   29: iload_2
    //   30: ifne +29 -> 59
    //   33: aload 7
    //   35: astore 5
    //   37: aload 8
    //   39: astore 6
    //   41: aload_1
    //   42: iconst_1
    //   43: invokevirtual 305	java/net/HttpURLConnection:setDoInput	(Z)V
    //   46: aload 7
    //   48: astore 5
    //   50: aload 8
    //   52: astore 6
    //   54: aload_1
    //   55: iconst_1
    //   56: invokevirtual 308	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   59: aload 7
    //   61: astore 5
    //   63: aload 8
    //   65: astore 6
    //   67: aload_1
    //   68: iconst_0
    //   69: invokevirtual 311	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   72: aload 7
    //   74: astore 5
    //   76: aload 8
    //   78: astore 6
    //   80: aload_1
    //   81: ldc_w 313
    //   84: invokevirtual 316	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   87: aload 7
    //   89: astore 5
    //   91: aload 8
    //   93: astore 6
    //   95: aload_1
    //   96: invokevirtual 173	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   99: astore_3
    //   100: aload_3
    //   101: astore 5
    //   103: aload_3
    //   104: astore 6
    //   106: new 318	java/io/BufferedReader
    //   109: dup
    //   110: new 320	java/io/InputStreamReader
    //   113: dup
    //   114: aload_3
    //   115: invokespecial 323	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   118: invokespecial 326	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   121: astore 7
    //   123: ldc_w 328
    //   126: astore 4
    //   128: aload_3
    //   129: astore 5
    //   131: aload 7
    //   133: invokevirtual 331	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   136: astore 6
    //   138: aload 6
    //   140: ifnull +41 -> 181
    //   143: aload_3
    //   144: astore 5
    //   146: new 80	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   153: aload 4
    //   155: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload 6
    //   160: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: ldc_w 333
    //   166: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: astore 6
    //   174: aload 6
    //   176: astore 4
    //   178: goto -50 -> 128
    //   181: aload_3
    //   182: ifnull +7 -> 189
    //   185: aload_3
    //   186: invokevirtual 178	java/io/InputStream:close	()V
    //   189: aload_1
    //   190: ifnull +287 -> 477
    //   193: aload_1
    //   194: invokevirtual 197	java/net/HttpURLConnection:disconnect	()V
    //   197: aload 4
    //   199: astore_3
    //   200: aload_3
    //   201: areturn
    //   202: astore_3
    //   203: aload_3
    //   204: invokevirtual 277	java/io/IOException:printStackTrace	()V
    //   207: goto -18 -> 189
    //   210: astore 5
    //   212: ldc_w 328
    //   215: astore_1
    //   216: aconst_null
    //   217: astore_3
    //   218: iconst_5
    //   219: ldc 71
    //   221: ldc 73
    //   223: new 80	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   230: ldc_w 335
    //   233: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: aload 5
    //   238: invokevirtual 336	java/net/MalformedURLException:toString	()Ljava/lang/String;
    //   241: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   250: aload_3
    //   251: ifnull +7 -> 258
    //   254: aload_3
    //   255: invokevirtual 178	java/io/InputStream:close	()V
    //   258: aload_1
    //   259: astore_3
    //   260: aload 4
    //   262: ifnull -62 -> 200
    //   265: aload 4
    //   267: invokevirtual 197	java/net/HttpURLConnection:disconnect	()V
    //   270: aload_1
    //   271: areturn
    //   272: astore_3
    //   273: aload_3
    //   274: invokevirtual 277	java/io/IOException:printStackTrace	()V
    //   277: goto -19 -> 258
    //   280: astore 5
    //   282: ldc_w 328
    //   285: astore_1
    //   286: aconst_null
    //   287: astore 4
    //   289: iconst_5
    //   290: ldc 71
    //   292: ldc 73
    //   294: new 80	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   301: ldc_w 338
    //   304: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: aload 5
    //   309: invokevirtual 280	java/io/IOException:toString	()Ljava/lang/String;
    //   312: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   321: aload_3
    //   322: ifnull +7 -> 329
    //   325: aload_3
    //   326: invokevirtual 178	java/io/InputStream:close	()V
    //   329: aload_1
    //   330: astore_3
    //   331: aload 4
    //   333: ifnull -133 -> 200
    //   336: aload 4
    //   338: invokevirtual 197	java/net/HttpURLConnection:disconnect	()V
    //   341: aload_1
    //   342: areturn
    //   343: astore_3
    //   344: aload_3
    //   345: invokevirtual 277	java/io/IOException:printStackTrace	()V
    //   348: goto -19 -> 329
    //   351: astore_1
    //   352: aconst_null
    //   353: astore 4
    //   355: aload 5
    //   357: astore_3
    //   358: aload_3
    //   359: ifnull +7 -> 366
    //   362: aload_3
    //   363: invokevirtual 178	java/io/InputStream:close	()V
    //   366: aload 4
    //   368: ifnull +8 -> 376
    //   371: aload 4
    //   373: invokevirtual 197	java/net/HttpURLConnection:disconnect	()V
    //   376: aload_1
    //   377: athrow
    //   378: astore_3
    //   379: aload_3
    //   380: invokevirtual 277	java/io/IOException:printStackTrace	()V
    //   383: goto -17 -> 366
    //   386: astore_3
    //   387: aload_1
    //   388: astore 4
    //   390: aload_3
    //   391: astore_1
    //   392: aload 5
    //   394: astore_3
    //   395: goto -37 -> 358
    //   398: astore_1
    //   399: goto -41 -> 358
    //   402: astore_1
    //   403: goto -45 -> 358
    //   406: astore 5
    //   408: aload_1
    //   409: astore 4
    //   411: ldc_w 328
    //   414: astore_1
    //   415: aload 6
    //   417: astore_3
    //   418: goto -129 -> 289
    //   421: astore 5
    //   423: aload_1
    //   424: astore 6
    //   426: aload 4
    //   428: astore_1
    //   429: aload 6
    //   431: astore 4
    //   433: goto -144 -> 289
    //   436: astore 5
    //   438: aconst_null
    //   439: astore_3
    //   440: aload_1
    //   441: astore 4
    //   443: ldc_w 328
    //   446: astore_1
    //   447: goto -229 -> 218
    //   450: astore 5
    //   452: aload_1
    //   453: astore 4
    //   455: ldc_w 328
    //   458: astore_1
    //   459: goto -241 -> 218
    //   462: astore 5
    //   464: aload_1
    //   465: astore 6
    //   467: aload 4
    //   469: astore_1
    //   470: aload 6
    //   472: astore 4
    //   474: goto -256 -> 218
    //   477: aload 4
    //   479: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	480	0	this	b
    //   0	480	1	paramString	String
    //   0	480	2	paramBoolean	boolean
    //   1	200	3	localObject1	Object
    //   202	2	3	localIOException1	java.io.IOException
    //   217	43	3	str1	String
    //   272	54	3	localIOException2	java.io.IOException
    //   330	1	3	str2	String
    //   343	2	3	localIOException3	java.io.IOException
    //   357	6	3	localObject2	Object
    //   378	2	3	localIOException4	java.io.IOException
    //   386	5	3	localObject3	Object
    //   394	46	3	localObject4	Object
    //   12	466	4	localObject5	Object
    //   3	142	5	localObject6	Object
    //   210	27	5	localMalformedURLException1	java.net.MalformedURLException
    //   280	113	5	localIOException5	java.io.IOException
    //   406	1	5	localIOException6	java.io.IOException
    //   421	1	5	localIOException7	java.io.IOException
    //   436	1	5	localMalformedURLException2	java.net.MalformedURLException
    //   450	1	5	localMalformedURLException3	java.net.MalformedURLException
    //   462	1	5	localMalformedURLException4	java.net.MalformedURLException
    //   39	432	6	localObject7	Object
    //   6	126	7	localBufferedReader	java.io.BufferedReader
    //   9	83	8	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   185	189	202	java/io/IOException
    //   14	29	210	java/net/MalformedURLException
    //   254	258	272	java/io/IOException
    //   14	29	280	java/io/IOException
    //   325	329	343	java/io/IOException
    //   14	29	351	finally
    //   362	366	378	java/io/IOException
    //   41	46	386	finally
    //   54	59	386	finally
    //   67	72	386	finally
    //   80	87	386	finally
    //   95	100	386	finally
    //   106	123	386	finally
    //   131	138	386	finally
    //   146	174	386	finally
    //   218	250	398	finally
    //   289	321	402	finally
    //   41	46	406	java/io/IOException
    //   54	59	406	java/io/IOException
    //   67	72	406	java/io/IOException
    //   80	87	406	java/io/IOException
    //   95	100	406	java/io/IOException
    //   106	123	406	java/io/IOException
    //   131	138	421	java/io/IOException
    //   146	174	421	java/io/IOException
    //   41	46	436	java/net/MalformedURLException
    //   54	59	436	java/net/MalformedURLException
    //   67	72	436	java/net/MalformedURLException
    //   80	87	436	java/net/MalformedURLException
    //   95	100	436	java/net/MalformedURLException
    //   106	123	450	java/net/MalformedURLException
    //   131	138	462	java/net/MalformedURLException
    //   146	174	462	java/net/MalformedURLException
  }
  
  private String b(File paramFile, String paramString)
  {
    d.a(3, "", "MediaPlayerMgr", "getFilePathByPrefix, dirFile: " + paramFile + " - prefix : " + paramString);
    if (paramFile == null) {}
    for (;;)
    {
      return null;
      paramFile = paramFile.listFiles();
      if ((paramFile == null) || (paramFile.length <= 0))
      {
        d.a(3, "", "MediaPlayerMgr", "getFilePathByPrefix , childFiles is null or length 0 ");
        return null;
      }
      int i1 = paramFile.length;
      int n = 0;
      while (n < i1)
      {
        Object localObject = paramFile[n];
        d.a(3, "", "MediaPlayerMgr", "getFilePathByPrefix,  file.name : " + localObject.getName() + " , file.path :" + localObject.getAbsolutePath());
        if ((localObject.getName().length() >= paramString.length()) && (localObject.getName().substring(0, paramString.length()).equalsIgnoreCase(paramString))) {
          return localObject.getAbsolutePath();
        }
        n += 1;
      }
    }
  }
  
  private String b(String paramString)
  {
    int n = 3;
    System.setProperty("http.keepAlive", "false");
    System.setProperty("http.maxConnections", "100");
    d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", "request url: " + paramString);
    while (n > 0) {
      try
      {
        String str = a(paramString, false);
        if (TextUtils.isEmpty(str)) {
          a(paramString, true);
        }
        d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", "fetchResultWithURL, result : " + str);
        if (!TextUtils.isEmpty(str))
        {
          boolean bool = TextUtils.isEmpty(str.trim());
          if (!bool) {
            return str;
          }
        }
        n -= 1;
      }
      catch (Exception paramString)
      {
        this.d = 102;
        return null;
      }
      catch (OutOfMemoryError paramString)
      {
        this.d = 102;
        return null;
      }
    }
    this.d = 102;
    return null;
  }
  
  private String b(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("http://commdata.v.qq.com/commdatav2?cmd=51&so_name=TvkPlugin&so_ver=");
    if (paramBoolean) {}
    for (String str = this.l.version;; str = "V0.0.0.0") {
      return str + "&app_id=" + "000" + "&sdk_version=" + c.a;
    }
  }
  
  private boolean b(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      d.a(5, "", "", "checkjarMd5 failed, empty,  md5: " + paramString1 + ", dirPath: " + paramString2);
      return false;
    }
    paramString2 = d.a(a(paramString2));
    if ((TextUtils.isEmpty(paramString2)) || (!paramString1.equalsIgnoreCase(paramString2)))
    {
      d.a(5, "", "", "checkjarMd5 failed, localMD5 = " + paramString1 + ", fileMd5: " + paramString2);
      return false;
    }
    return true;
  }
  
  private SDKLocalConfig c(String paramString)
  {
    String str1 = paramString;
    String str2;
    String str3;
    try
    {
      if (paramString.startsWith("QZOutputJson=")) {
        str1 = paramString.replace("QZOutputJson=", "");
      }
      localObject = new JSONObject(str1);
      if (((JSONObject)localObject).optString("error_msg").equals("no record"))
      {
        this.d = 102;
        return null;
      }
      paramString = ((JSONObject)localObject).optString("c_so_url");
      str1 = ((JSONObject)localObject).optString("c_so_name");
      str2 = ((JSONObject)localObject).optString("c_so_update_ver");
      str3 = ((JSONObject)localObject).optString("c_so_md5");
      localObject = ((JSONObject)localObject).optString("ret");
      if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty((CharSequence)localObject)))
      {
        this.d = 102;
        return null;
      }
    }
    catch (Exception paramString)
    {
      this.d = 102;
      return null;
    }
    Object localObject = new SDKLocalConfig();
    ((SDKLocalConfig)localObject).filename = str1;
    ((SDKLocalConfig)localObject).version = str2;
    ((SDKLocalConfig)localObject).MD5 = str3;
    ((SDKLocalConfig)localObject).URL = paramString;
    return localObject;
  }
  
  private boolean c(SDKLocalConfig paramSDKLocalConfig)
  {
    if (!TVK_SDKMgr.checkSdkPluginMode()) {}
    String[] arrayOfString1;
    String[] arrayOfString2;
    do
    {
      return true;
      arrayOfString1 = TVK_SDKMgr.SDK_Ver.split("\\.");
      arrayOfString2 = paramSDKLocalConfig.version.split("\\.");
    } while ((arrayOfString1 != null) && (arrayOfString2 != null) && (arrayOfString1.length > 1) && (arrayOfString2.length > 1) && (arrayOfString1[0].equalsIgnoreCase(arrayOfString2[0])) && (arrayOfString1[1].equalsIgnoreCase(arrayOfString2[1])));
    d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", "version not match, sdk:" + TVK_SDKMgr.SDK_Ver + ", configver: " + paramSDKLocalConfig.version);
    return false;
  }
  
  private boolean d(SDKLocalConfig paramSDKLocalConfig)
  {
    if (!TVK_SDKMgr.checkSdkPluginMode()) {}
    String[] arrayOfString2;
    int n;
    do
    {
      return true;
      String[] arrayOfString1 = TVK_SDKMgr.SDK_Ver.split("\\.");
      arrayOfString2 = paramSDKLocalConfig.version.split("\\.");
      if ((arrayOfString1 == null) || (arrayOfString2 == null) || (arrayOfString1.length <= 3) || (arrayOfString2.length <= 3)) {
        break;
      }
      n = Integer.valueOf(arrayOfString1[3]).intValue();
    } while (Integer.valueOf(arrayOfString2[3]).intValue() >= n);
    d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", "build version not match, sdk:" + TVK_SDKMgr.SDK_Ver + ", configver: " + paramSDKLocalConfig.version);
    return false;
    d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", "build version is invalid, sdk:" + TVK_SDKMgr.SDK_Ver + ", configver: " + paramSDKLocalConfig.version);
    return false;
  }
  
  private boolean d(String paramString)
  {
    boolean bool2 = false;
    try
    {
      if (!Environment.getExternalStorageState().equals("mounted")) {
        return false;
      }
      localFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "/tencent/TencentVideoSdk/com.tencent.videokit", "TVKConfig.ser");
      bool1 = bool2;
      if (!localFile.exists()) {
        return bool1;
      }
      this.j = new File(paramString, "TVKConfig.ser");
      this.j.getParentFile().mkdirs();
      if (!d.a(localFile, this.j))
      {
        d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", "copyRemoteFiles, copy SDKConfig fail");
        return false;
      }
    }
    catch (Exception paramString)
    {
      d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", "copyRemoteFiles, exception: " + paramString.toString());
      return false;
    }
    File localFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "/tencent/TencentVideoSdk/com.tencent.videokit", "TvkPlugin.zip");
    boolean bool1 = bool2;
    if (localFile.exists())
    {
      this.i = new File(paramString, "TvkPlugin.zip");
      this.i.getParentFile().mkdirs();
      if (!d.a(localFile, this.i))
      {
        d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", "copyRemoteFiles, copy SDKZip fail");
        return false;
      }
      if (!a(this.i.getAbsolutePath(), this.i.getParentFile().getAbsolutePath()))
      {
        d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", "copyRemoteFiles, file unzip error");
        return false;
      }
      bool1 = true;
    }
    return bool1;
  }
  
  private void i()
  {
    try
    {
      if ((this.j != null) && (this.j.exists()))
      {
        this.j.delete();
        this.j = null;
      }
      try
      {
        label30:
        if ((this.i != null) && (this.i.exists()))
        {
          this.i.delete();
          this.i = null;
        }
        return;
      }
      catch (Throwable localThrowable1) {}
    }
    catch (Throwable localThrowable2)
    {
      break label30;
    }
  }
  
  public SDKLocalConfig a(boolean paramBoolean)
  {
    Object localObject = b(b(paramBoolean));
    if (localObject == null)
    {
      this.d = 102;
      return null;
    }
    localObject = c((String)localObject);
    if ((localObject != null) && (!c((SDKLocalConfig)localObject)) && (!d((SDKLocalConfig)localObject)))
    {
      this.d = 102;
      return null;
    }
    return localObject;
  }
  
  public void a(float paramFloat)
  {
    if (this.m != null) {
      this.m.onInstallProgress(paramFloat);
    }
  }
  
  public void a(TVK_SDKMgr.InstallListener paramInstallListener)
  {
    this.m = paramInstallListener;
  }
  
  public void a(SDKLocalConfig paramSDKLocalConfig, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = this.f.getAbsolutePath();; str = this.e.getAbsolutePath())
    {
      int n = a(paramSDKLocalConfig, str);
      this.d = n;
      if ((n == 0) && (!paramBoolean)) {
        this.l = paramSDKLocalConfig;
      }
      return;
    }
  }
  
  public boolean a()
  {
    Object localObject2 = null;
    try
    {
      Object localObject1;
      if ((this.c.getFilesDir().exists()) && (this.c.getFilesDir().canRead()) && (this.c.getFilesDir().canWrite())) {
        localObject1 = this.c.getFilesDir().getAbsolutePath();
      }
      while (localObject1 != null)
      {
        this.e = new File((String)localObject1, "TencentVideoKit");
        this.f = new File((String)localObject1, "TencentVideoKitUpdate");
        this.g = new File(this.e.getAbsolutePath(), "TVKConfig.ser");
        this.h = new File(this.f.getAbsolutePath(), "TVKConfig.ser");
        b();
        return true;
        localObject1 = localObject2;
        if (Environment.getExternalStorageState().equals("mounted"))
        {
          localObject1 = localObject2;
          if (this.c.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) != null) {
            localObject1 = this.c.getFilesDir().getAbsolutePath();
          }
        }
      }
      this.d = 104;
      d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", "helperInit failed, dir error");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.d = 104;
        d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", "helperInit failed, " + localException.toString());
      }
    }
    return false;
  }
  
  public boolean a(SDKLocalConfig paramSDKLocalConfig)
  {
    return (paramSDKLocalConfig != null) && (!TextUtils.isEmpty(paramSDKLocalConfig.version)) && (this.l != null) && (paramSDKLocalConfig.version.equals(this.l.version));
  }
  
  /* Error */
  public boolean a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +21 -> 22
    //   4: aload_1
    //   5: invokevirtual 214	java/io/File:exists	()Z
    //   8: ifeq +14 -> 22
    //   11: aload_2
    //   12: ifnull +10 -> 22
    //   15: aload_2
    //   16: invokevirtual 214	java/io/File:exists	()Z
    //   19: ifne +5 -> 24
    //   22: iconst_0
    //   23: ireturn
    //   24: new 558	java/io/ObjectInputStream
    //   27: dup
    //   28: new 560	java/io/FileInputStream
    //   31: dup
    //   32: aload_2
    //   33: invokespecial 561	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   36: invokespecial 562	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   39: astore_3
    //   40: aload_3
    //   41: astore_2
    //   42: aload_0
    //   43: aload_3
    //   44: invokevirtual 566	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   47: checkcast 119	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig
    //   50: putfield 397	com/tencent/qqlive/mediaplayer/sdkupdate/b:l	Lcom/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig;
    //   53: aload_3
    //   54: ifnull +7 -> 61
    //   57: aload_3
    //   58: invokevirtual 567	java/io/ObjectInputStream:close	()V
    //   61: aload_0
    //   62: getfield 397	com/tencent/qqlive/mediaplayer/sdkupdate/b:l	Lcom/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig;
    //   65: ifnull +43 -> 108
    //   68: aload_0
    //   69: getfield 397	com/tencent/qqlive/mediaplayer/sdkupdate/b:l	Lcom/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig;
    //   72: getfield 217	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:MD5	Ljava/lang/String;
    //   75: ifnull +33 -> 108
    //   78: aload_0
    //   79: getfield 397	com/tencent/qqlive/mediaplayer/sdkupdate/b:l	Lcom/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig;
    //   82: getfield 455	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:filename	Ljava/lang/String;
    //   85: ifnull +23 -> 108
    //   88: aload_0
    //   89: getfield 397	com/tencent/qqlive/mediaplayer/sdkupdate/b:l	Lcom/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig;
    //   92: getfield 269	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:version	Ljava/lang/String;
    //   95: ifnull +13 -> 108
    //   98: aload_0
    //   99: getfield 397	com/tencent/qqlive/mediaplayer/sdkupdate/b:l	Lcom/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig;
    //   102: getfield 241	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:JARMD5	Ljava/lang/String;
    //   105: ifnonnull +104 -> 209
    //   108: iconst_5
    //   109: ldc 71
    //   111: ldc 73
    //   113: new 80	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   120: ldc_w 569
    //   123: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_1
    //   127: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload_1
    //   137: invokestatic 102	com/tencent/qqlive/mediaplayer/sdkupdate/d:b	(Ljava/io/File;)V
    //   140: iconst_0
    //   141: ireturn
    //   142: astore 4
    //   144: aconst_null
    //   145: astore_3
    //   146: aload_3
    //   147: astore_2
    //   148: iconst_5
    //   149: ldc 71
    //   151: ldc 73
    //   153: new 80	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   160: ldc_w 571
    //   163: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload 4
    //   168: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   171: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 78	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   180: aload_3
    //   181: astore_2
    //   182: aload_1
    //   183: invokestatic 102	com/tencent/qqlive/mediaplayer/sdkupdate/d:b	(Ljava/io/File;)V
    //   186: aload_3
    //   187: ifnull +7 -> 194
    //   190: aload_3
    //   191: invokevirtual 567	java/io/ObjectInputStream:close	()V
    //   194: iconst_0
    //   195: ireturn
    //   196: astore_1
    //   197: aconst_null
    //   198: astore_2
    //   199: aload_2
    //   200: ifnull +7 -> 207
    //   203: aload_2
    //   204: invokevirtual 567	java/io/ObjectInputStream:close	()V
    //   207: aload_1
    //   208: athrow
    //   209: aload_0
    //   210: aload_0
    //   211: getfield 397	com/tencent/qqlive/mediaplayer/sdkupdate/b:l	Lcom/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig;
    //   214: getfield 241	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:JARMD5	Ljava/lang/String;
    //   217: aload_1
    //   218: invokevirtual 225	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   221: invokespecial 573	com/tencent/qqlive/mediaplayer/sdkupdate/b:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   224: ifne +9 -> 233
    //   227: aload_1
    //   228: invokestatic 102	com/tencent/qqlive/mediaplayer/sdkupdate/d:b	(Ljava/io/File;)V
    //   231: iconst_0
    //   232: ireturn
    //   233: aload_0
    //   234: aload_0
    //   235: getfield 397	com/tencent/qqlive/mediaplayer/sdkupdate/b:l	Lcom/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig;
    //   238: invokespecial 520	com/tencent/qqlive/mediaplayer/sdkupdate/b:c	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig;)Z
    //   241: ifne +9 -> 250
    //   244: aload_1
    //   245: invokestatic 102	com/tencent/qqlive/mediaplayer/sdkupdate/d:b	(Ljava/io/File;)V
    //   248: iconst_0
    //   249: ireturn
    //   250: aload_0
    //   251: aload_0
    //   252: getfield 397	com/tencent/qqlive/mediaplayer/sdkupdate/b:l	Lcom/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig;
    //   255: invokespecial 522	com/tencent/qqlive/mediaplayer/sdkupdate/b:d	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig;)Z
    //   258: ifne +9 -> 267
    //   261: aload_1
    //   262: invokestatic 102	com/tencent/qqlive/mediaplayer/sdkupdate/d:b	(Ljava/io/File;)V
    //   265: iconst_0
    //   266: ireturn
    //   267: iconst_1
    //   268: ireturn
    //   269: astore_2
    //   270: goto -209 -> 61
    //   273: astore_1
    //   274: goto -80 -> 194
    //   277: astore_2
    //   278: goto -71 -> 207
    //   281: astore_1
    //   282: goto -83 -> 199
    //   285: astore 4
    //   287: goto -141 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	this	b
    //   0	290	1	paramFile1	File
    //   0	290	2	paramFile2	File
    //   39	152	3	localObjectInputStream	ObjectInputStream
    //   142	25	4	localException1	Exception
    //   285	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   24	40	142	java/lang/Exception
    //   24	40	196	finally
    //   57	61	269	java/lang/Exception
    //   190	194	273	java/lang/Exception
    //   203	207	277	java/lang/Exception
    //   42	53	281	finally
    //   148	180	281	finally
    //   182	186	281	finally
    //   42	53	285	java/lang/Exception
  }
  
  public boolean a(File paramFile, String paramString)
  {
    return paramString.equalsIgnoreCase(d.a(paramFile));
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    try
    {
      d.a(paramString1, paramString2);
      return true;
    }
    catch (Throwable paramString1)
    {
      d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", "unzipFile,  exception: " + paramString1.toString());
    }
    return false;
  }
  
  public void b()
  {
    this.k = false;
    if (d()) {
      this.k = true;
    }
    while (!e()) {
      return;
    }
    this.k = true;
  }
  
  public boolean b(SDKLocalConfig paramSDKLocalConfig)
  {
    try
    {
      if (!Environment.getExternalStorageState().equals("mounted")) {
        return false;
      }
      File localFile1 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "/tencent/TencentVideoSdk/com.tencent.videokit", "TVKConfig.ser");
      if (!localFile1.exists()) {
        return false;
      }
      File localFile2 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "/tencent/TencentVideoSdk/com.tencent.videokit", "TvkPlugin.zip");
      if (!localFile2.exists()) {
        return false;
      }
      Object localObject = new ObjectInputStream(new FileInputStream(localFile1));
      SDKLocalConfig localSDKLocalConfig;
      try
      {
        localSDKLocalConfig = (SDKLocalConfig)((ObjectInputStream)localObject).readObject();
        ((ObjectInputStream)localObject).close();
        if ((localSDKLocalConfig == null) || (localSDKLocalConfig.MD5 == null) || (localSDKLocalConfig.filename == null) || (localSDKLocalConfig.version == null) || (localSDKLocalConfig.JARMD5 == null))
        {
          d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", "remotecofig info error");
          return false;
        }
      }
      catch (Exception paramSDKLocalConfig)
      {
        ((ObjectInputStream)localObject).close();
        return false;
      }
      localObject = d.a(localFile2);
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).equalsIgnoreCase(localSDKLocalConfig.MD5)))
      {
        d.a(5, "", "MediaPlayerMgr", "md5 not match, localMD5 = " + localSDKLocalConfig.MD5 + ", fileMd5: " + (String)localObject);
        d.b(localFile1);
        d.b(localFile2);
        return false;
      }
      d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", "compare, ver: " + localSDKLocalConfig.version + ", md5: " + localSDKLocalConfig.MD5);
      if ((!TextUtils.isEmpty(localSDKLocalConfig.version)) && (localSDKLocalConfig.version.equalsIgnoreCase(paramSDKLocalConfig.version)) && (!TextUtils.isEmpty(localSDKLocalConfig.MD5)) && (localSDKLocalConfig.MD5.equalsIgnoreCase(paramSDKLocalConfig.MD5)))
      {
        if (!d(this.f.getAbsolutePath()))
        {
          d.a(5, "", "MediaPlayerMgr", "copy failed");
          i();
          return false;
        }
        return true;
      }
    }
    catch (Exception paramSDKLocalConfig)
    {
      d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", "read config failed: " + paramSDKLocalConfig.toString());
    }
    return false;
  }
  
  public boolean c()
  {
    return this.k;
  }
  
  public boolean d()
  {
    if (!a(this.f, this.h)) {
      return false;
    }
    d.b(this.e);
    if (!this.f.renameTo(this.e))
    {
      d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", "renameTo failed");
      return false;
    }
    return true;
  }
  
  public boolean e()
  {
    return a(this.e, this.g);
  }
  
  public void f()
  {
    if (this.m == null) {
      return;
    }
    if (this.d == 0)
    {
      this.m.onInstalledSuccessed();
      return;
    }
    this.m.onInstalledFailed(this.d);
  }
  
  public String g()
  {
    if (this.k) {
      return b(this.e, "TVK_MediaPlayer");
    }
    return null;
  }
  
  public String h()
  {
    d.a(3, "", "MediaPlayerMgr", "getLibs, isFileExisted: " + this.k + " - " + this.e);
    if (this.k) {
      return b(this.e, "armeabi");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qqlive.mediaplayer.sdkupdate.b
 * JD-Core Version:    0.7.0.1
 */