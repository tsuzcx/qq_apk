package com.tencent.xweb.xwalk.updater;

import android.os.AsyncTask;
import java.util.Timer;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;

public class j
  extends AsyncTask<j.a, j.b, j.c>
{
  private b a = null;
  private j.a b = null;
  private int c = 0;
  private Timer d = null;
  private long e = 0L;
  
  public static void a(j.a parama, b paramb)
  {
    j localj = new j();
    localj.a = paramb;
    localj.b = parama;
    localj.c = 0;
    localj.e = System.currentTimeMillis();
    localj.execute(new j.a[] { localj.b });
  }
  
  private void b()
  {
    this.c += 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("task retry!  mRetrytimes = ");
    localStringBuilder.append(this.c);
    XWalkInitializer.addXWalkInitializeLog(localStringBuilder.toString());
    this.d = new Timer();
    this.d.schedule(new j.1(this), this.c * 3000L);
  }
  
  private static void b(j.a parama, b paramb, int paramInt)
  {
    j localj = new j();
    localj.a = paramb;
    localj.b = parama;
    localj.c = paramInt;
    localj.e = System.currentTimeMillis();
    localj.execute(new j.a[] { localj.b });
  }
  
  private boolean b(j.c paramc)
  {
    if (this.c >= 2) {
      return false;
    }
    if (paramc.c != -10001) {
      return paramc.c != -10004;
    }
    return false;
  }
  
  private void c()
  {
    Timer localTimer = this.d;
    if (localTimer != null)
    {
      localTimer.cancel();
      this.d = null;
    }
  }
  
  /* Error */
  protected j.c a(j.a... paramVarArgs)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 10
    //   6: aconst_null
    //   7: astore 11
    //   9: aload_1
    //   10: ifnonnull +5 -> 15
    //   13: aconst_null
    //   14: areturn
    //   15: aload_1
    //   16: arraylength
    //   17: iconst_1
    //   18: if_icmpeq +5 -> 23
    //   21: aconst_null
    //   22: areturn
    //   23: aload_1
    //   24: iconst_0
    //   25: aaload
    //   26: astore 12
    //   28: aload 12
    //   30: ifnonnull +5 -> 35
    //   33: aconst_null
    //   34: areturn
    //   35: aload_0
    //   36: getfield 21	com/tencent/xweb/xwalk/updater/j:a	Lcom/tencent/xweb/xwalk/updater/b;
    //   39: astore_1
    //   40: aload_1
    //   41: ifnull +9 -> 50
    //   44: aload_1
    //   45: invokeinterface 104 1 0
    //   50: new 88	com/tencent/xweb/xwalk/updater/j$c
    //   53: dup
    //   54: invokespecial 105	com/tencent/xweb/xwalk/updater/j$c:<init>	()V
    //   57: astore 13
    //   59: aload 13
    //   61: aload 12
    //   63: getfield 108	com/tencent/xweb/xwalk/updater/j$a:a	Ljava/lang/String;
    //   66: putfield 109	com/tencent/xweb/xwalk/updater/j$c:a	Ljava/lang/String;
    //   69: aload 13
    //   71: aload 12
    //   73: getfield 111	com/tencent/xweb/xwalk/updater/j$a:b	Ljava/lang/String;
    //   76: putfield 112	com/tencent/xweb/xwalk/updater/j$c:b	Ljava/lang/String;
    //   79: aload 13
    //   81: iconst_0
    //   82: putfield 89	com/tencent/xweb/xwalk/updater/j$c:c	I
    //   85: aload 13
    //   87: ldc 114
    //   89: putfield 116	com/tencent/xweb/xwalk/updater/j$c:e	Ljava/lang/String;
    //   92: aload 13
    //   94: aload_0
    //   95: getfield 25	com/tencent/xweb/xwalk/updater/j:c	I
    //   98: putfield 119	com/tencent/xweb/xwalk/updater/j$c:f	I
    //   101: aload 13
    //   103: lconst_0
    //   104: putfield 122	com/tencent/xweb/xwalk/updater/j$c:g	J
    //   107: aload 13
    //   109: lconst_0
    //   110: putfield 125	com/tencent/xweb/xwalk/updater/j$c:h	J
    //   113: aload 13
    //   115: iconst_0
    //   116: putfield 128	com/tencent/xweb/xwalk/updater/j$c:i	I
    //   119: aload 13
    //   121: invokestatic 134	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   124: invokestatic 140	org/xwalk/core/NetworkUtil:getCurrentNetWorkStatus	(Landroid/content/Context;)I
    //   127: putfield 142	com/tencent/xweb/xwalk/updater/j$c:d	I
    //   130: aload 12
    //   132: getfield 108	com/tencent/xweb/xwalk/updater/j$a:a	Ljava/lang/String;
    //   135: ifnull +988 -> 1123
    //   138: aload 12
    //   140: getfield 111	com/tencent/xweb/xwalk/updater/j$a:b	Ljava/lang/String;
    //   143: ifnull +980 -> 1123
    //   146: aload 12
    //   148: getfield 108	com/tencent/xweb/xwalk/updater/j$a:a	Ljava/lang/String;
    //   151: invokevirtual 148	java/lang/String:length	()I
    //   154: ifeq +969 -> 1123
    //   157: aload 12
    //   159: getfield 111	com/tencent/xweb/xwalk/updater/j$a:b	Ljava/lang/String;
    //   162: invokevirtual 148	java/lang/String:length	()I
    //   165: ifeq +958 -> 1123
    //   168: aload_0
    //   169: getfield 21	com/tencent/xweb/xwalk/updater/j:a	Lcom/tencent/xweb/xwalk/updater/b;
    //   172: ifnonnull +6 -> 178
    //   175: goto +948 -> 1123
    //   178: new 150	java/net/URL
    //   181: dup
    //   182: aload 12
    //   184: getfield 108	com/tencent/xweb/xwalk/updater/j$a:a	Ljava/lang/String;
    //   187: invokespecial 152	java/net/URL:<init>	(Ljava/lang/String;)V
    //   190: invokevirtual 156	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   193: checkcast 158	java/net/HttpURLConnection
    //   196: astore_1
    //   197: aload_1
    //   198: ldc 160
    //   200: invokevirtual 163	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   203: aload_1
    //   204: ldc 165
    //   206: aload_0
    //   207: invokevirtual 167	com/tencent/xweb/xwalk/updater/j:a	()Ljava/lang/String;
    //   210: invokevirtual 171	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: aload 12
    //   215: getfield 174	com/tencent/xweb/xwalk/updater/j$a:c	Z
    //   218: istore 4
    //   220: iload 4
    //   222: ifeq +38 -> 260
    //   225: aload_1
    //   226: instanceof 176
    //   229: istore 4
    //   231: goto +29 -> 260
    //   234: astore 8
    //   236: aconst_null
    //   237: astore 7
    //   239: aload_1
    //   240: astore 9
    //   242: aload 8
    //   244: astore_1
    //   245: aload 9
    //   247: astore 8
    //   249: goto +793 -> 1042
    //   252: astore 8
    //   254: aconst_null
    //   255: astore 7
    //   257: goto +597 -> 854
    //   260: aload_1
    //   261: sipush 8000
    //   264: invokevirtual 180	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   267: aload_1
    //   268: sipush 8000
    //   271: invokevirtual 183	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   274: aload_1
    //   275: invokevirtual 186	java/net/HttpURLConnection:getResponseCode	()I
    //   278: istore_2
    //   279: iload_2
    //   280: sipush 200
    //   283: if_icmpne +362 -> 645
    //   286: aload_1
    //   287: invokevirtual 190	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   290: astore 7
    //   292: aload_1
    //   293: invokevirtual 193	java/net/HttpURLConnection:getContentLength	()I
    //   296: istore_2
    //   297: aload 12
    //   299: getfield 111	com/tencent/xweb/xwalk/updater/j$a:b	Ljava/lang/String;
    //   302: astore 8
    //   304: new 195	java/io/File
    //   307: dup
    //   308: aload 8
    //   310: invokespecial 196	java/io/File:<init>	(Ljava/lang/String;)V
    //   313: astore 11
    //   315: aload 11
    //   317: invokevirtual 200	java/io/File:exists	()Z
    //   320: ifeq +9 -> 329
    //   323: aload 11
    //   325: invokevirtual 203	java/io/File:delete	()Z
    //   328: pop
    //   329: new 205	java/io/FileOutputStream
    //   332: dup
    //   333: aload 8
    //   335: invokespecial 206	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   338: astore 8
    //   340: aload_1
    //   341: astore 9
    //   343: aload_1
    //   344: astore 10
    //   346: sipush 4096
    //   349: newarray byte
    //   351: astore 11
    //   353: aload_1
    //   354: astore 9
    //   356: aload_1
    //   357: astore 10
    //   359: new 208	com/tencent/xweb/xwalk/updater/j$b
    //   362: dup
    //   363: invokespecial 209	com/tencent/xweb/xwalk/updater/j$b:<init>	()V
    //   366: astore 14
    //   368: aload_1
    //   369: astore 9
    //   371: aload_1
    //   372: astore 10
    //   374: aload 14
    //   376: aload 12
    //   378: getfield 108	com/tencent/xweb/xwalk/updater/j$a:a	Ljava/lang/String;
    //   381: putfield 210	com/tencent/xweb/xwalk/updater/j$b:a	Ljava/lang/String;
    //   384: aload_1
    //   385: astore 9
    //   387: aload_1
    //   388: astore 10
    //   390: aload 14
    //   392: iload_2
    //   393: i2l
    //   394: putfield 212	com/tencent/xweb/xwalk/updater/j$b:c	J
    //   397: lconst_0
    //   398: lstore 5
    //   400: aload_1
    //   401: astore 9
    //   403: aload_1
    //   404: astore 10
    //   406: aload 7
    //   408: aload 11
    //   410: invokevirtual 218	java/io/InputStream:read	([B)I
    //   413: istore_3
    //   414: iload_3
    //   415: iconst_m1
    //   416: if_icmpeq +142 -> 558
    //   419: aload_1
    //   420: astore 9
    //   422: aload_1
    //   423: astore 10
    //   425: aload_0
    //   426: invokevirtual 221	com/tencent/xweb/xwalk/updater/j:isCancelled	()Z
    //   429: ifeq +86 -> 515
    //   432: aload_1
    //   433: astore 9
    //   435: aload_1
    //   436: astore 10
    //   438: aload 7
    //   440: invokevirtual 224	java/io/InputStream:close	()V
    //   443: aload 8
    //   445: invokevirtual 227	java/io/OutputStream:close	()V
    //   448: aload 7
    //   450: ifnull +8 -> 458
    //   453: aload 7
    //   455: invokevirtual 224	java/io/InputStream:close	()V
    //   458: aload_1
    //   459: ifnull +7 -> 466
    //   462: aload_1
    //   463: invokevirtual 230	java/net/HttpURLConnection:disconnect	()V
    //   466: aconst_null
    //   467: areturn
    //   468: astore_1
    //   469: new 51	java/lang/StringBuilder
    //   472: dup
    //   473: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   476: astore 7
    //   478: aload 7
    //   480: ldc 232
    //   482: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: pop
    //   486: aload 7
    //   488: aload_1
    //   489: invokevirtual 233	java/io/IOException:toString	()Ljava/lang/String;
    //   492: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: pop
    //   496: aload 7
    //   498: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   501: invokestatic 71	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   504: aload 13
    //   506: sipush -10003
    //   509: putfield 89	com/tencent/xweb/xwalk/updater/j$c:c	I
    //   512: aload 13
    //   514: areturn
    //   515: lload 5
    //   517: iload_3
    //   518: i2l
    //   519: ladd
    //   520: lstore 5
    //   522: aload 8
    //   524: aload 11
    //   526: iconst_0
    //   527: iload_3
    //   528: invokevirtual 237	java/io/OutputStream:write	([BII)V
    //   531: aload 14
    //   533: lload 5
    //   535: putfield 239	com/tencent/xweb/xwalk/updater/j$b:b	J
    //   538: iload_2
    //   539: ifle +600 -> 1139
    //   542: aload_0
    //   543: iconst_1
    //   544: anewarray 208	com/tencent/xweb/xwalk/updater/j$b
    //   547: dup
    //   548: iconst_0
    //   549: aload 14
    //   551: aastore
    //   552: invokevirtual 243	com/tencent/xweb/xwalk/updater/j:publishProgress	([Ljava/lang/Object;)V
    //   555: goto +584 -> 1139
    //   558: aload_1
    //   559: astore 10
    //   561: aload 13
    //   563: lload 5
    //   565: putfield 125	com/tencent/xweb/xwalk/updater/j$c:h	J
    //   568: aload 13
    //   570: invokestatic 39	java/lang/System:currentTimeMillis	()J
    //   573: aload_0
    //   574: getfield 29	com/tencent/xweb/xwalk/updater/j:e	J
    //   577: lsub
    //   578: putfield 122	com/tencent/xweb/xwalk/updater/j$c:g	J
    //   581: aload 8
    //   583: astore 9
    //   585: aload 10
    //   587: astore_1
    //   588: goto +112 -> 700
    //   591: aload_1
    //   592: astore 9
    //   594: astore_1
    //   595: goto +9 -> 604
    //   598: astore 9
    //   600: goto +20 -> 620
    //   603: astore_1
    //   604: aload 8
    //   606: astore 10
    //   608: aload 9
    //   610: astore 8
    //   612: goto +430 -> 1042
    //   615: astore 9
    //   617: aload 10
    //   619: astore_1
    //   620: aload 8
    //   622: astore 10
    //   624: aload 9
    //   626: astore 8
    //   628: aload 10
    //   630: astore 9
    //   632: goto +222 -> 854
    //   635: astore 8
    //   637: goto -398 -> 239
    //   640: astore 8
    //   642: goto -385 -> 257
    //   645: aload_1
    //   646: astore 8
    //   648: aload 13
    //   650: sipush -10005
    //   653: putfield 89	com/tencent/xweb/xwalk/updater/j$c:c	I
    //   656: new 51	java/lang/StringBuilder
    //   659: dup
    //   660: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   663: astore 7
    //   665: aload 7
    //   667: ldc 245
    //   669: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: pop
    //   673: aload 7
    //   675: iload_2
    //   676: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   679: pop
    //   680: aload 13
    //   682: aload 7
    //   684: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   687: putfield 116	com/tencent/xweb/xwalk/updater/j$c:e	Ljava/lang/String;
    //   690: aconst_null
    //   691: astore 7
    //   693: aload 8
    //   695: astore_1
    //   696: aload 11
    //   698: astore 9
    //   700: aload 9
    //   702: astore 10
    //   704: aload_1
    //   705: astore 11
    //   707: aload 7
    //   709: astore 12
    //   711: aload_1
    //   712: invokevirtual 230	java/net/HttpURLConnection:disconnect	()V
    //   715: aload 9
    //   717: ifnull +11 -> 728
    //   720: aload 9
    //   722: invokevirtual 227	java/io/OutputStream:close	()V
    //   725: goto +3 -> 728
    //   728: aload 7
    //   730: ifnull +54 -> 784
    //   733: aload 7
    //   735: invokevirtual 224	java/io/InputStream:close	()V
    //   738: goto +46 -> 784
    //   741: new 51	java/lang/StringBuilder
    //   744: dup
    //   745: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   748: astore_1
    //   749: aload_1
    //   750: ldc 232
    //   752: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: pop
    //   756: aload_1
    //   757: aload 7
    //   759: invokevirtual 233	java/io/IOException:toString	()Ljava/lang/String;
    //   762: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: pop
    //   766: aload_1
    //   767: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   770: invokestatic 71	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   773: aload 13
    //   775: sipush -10003
    //   778: putfield 89	com/tencent/xweb/xwalk/updater/j$c:c	I
    //   781: aload 13
    //   783: areturn
    //   784: aload_1
    //   785: ifnull +7 -> 792
    //   788: aload_1
    //   789: invokevirtual 230	java/net/HttpURLConnection:disconnect	()V
    //   792: aload 13
    //   794: areturn
    //   795: astore 8
    //   797: goto +57 -> 854
    //   800: astore 7
    //   802: goto +10 -> 812
    //   805: astore 8
    //   807: goto +23 -> 830
    //   810: astore 7
    //   812: aload_1
    //   813: astore 8
    //   815: aconst_null
    //   816: astore 9
    //   818: aload 7
    //   820: astore_1
    //   821: aload 9
    //   823: astore 7
    //   825: goto +217 -> 1042
    //   828: astore 8
    //   830: aconst_null
    //   831: astore 7
    //   833: goto +21 -> 854
    //   836: astore_1
    //   837: aconst_null
    //   838: astore 8
    //   840: aload 8
    //   842: astore 7
    //   844: goto +198 -> 1042
    //   847: astore 8
    //   849: aconst_null
    //   850: astore_1
    //   851: aload_1
    //   852: astore 7
    //   854: aload 9
    //   856: astore 10
    //   858: aload_1
    //   859: astore 11
    //   861: aload 7
    //   863: astore 12
    //   865: new 51	java/lang/StringBuilder
    //   868: dup
    //   869: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   872: astore 14
    //   874: aload 9
    //   876: astore 10
    //   878: aload_1
    //   879: astore 11
    //   881: aload 7
    //   883: astore 12
    //   885: aload 14
    //   887: ldc 247
    //   889: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   892: pop
    //   893: aload 9
    //   895: astore 10
    //   897: aload_1
    //   898: astore 11
    //   900: aload 7
    //   902: astore 12
    //   904: aload 14
    //   906: aload 8
    //   908: invokevirtual 248	java/lang/Exception:toString	()Ljava/lang/String;
    //   911: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   914: pop
    //   915: aload 9
    //   917: astore 10
    //   919: aload_1
    //   920: astore 11
    //   922: aload 7
    //   924: astore 12
    //   926: aload 14
    //   928: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   931: invokestatic 71	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   934: aload 9
    //   936: astore 10
    //   938: aload_1
    //   939: astore 11
    //   941: aload 7
    //   943: astore 12
    //   945: aload 13
    //   947: sipush -10002
    //   950: putfield 89	com/tencent/xweb/xwalk/updater/j$c:c	I
    //   953: aload 9
    //   955: ifnull +11 -> 966
    //   958: aload 9
    //   960: invokevirtual 227	java/io/OutputStream:close	()V
    //   963: goto +3 -> 966
    //   966: aload 7
    //   968: ifnull +54 -> 1022
    //   971: aload 7
    //   973: invokevirtual 224	java/io/InputStream:close	()V
    //   976: goto +46 -> 1022
    //   979: new 51	java/lang/StringBuilder
    //   982: dup
    //   983: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   986: astore_1
    //   987: aload_1
    //   988: ldc 232
    //   990: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   993: pop
    //   994: aload_1
    //   995: aload 7
    //   997: invokevirtual 233	java/io/IOException:toString	()Ljava/lang/String;
    //   1000: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1003: pop
    //   1004: aload_1
    //   1005: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1008: invokestatic 71	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   1011: aload 13
    //   1013: sipush -10003
    //   1016: putfield 89	com/tencent/xweb/xwalk/updater/j$c:c	I
    //   1019: aload 13
    //   1021: areturn
    //   1022: aload_1
    //   1023: ifnull +7 -> 1030
    //   1026: aload_1
    //   1027: invokevirtual 230	java/net/HttpURLConnection:disconnect	()V
    //   1030: aload 13
    //   1032: areturn
    //   1033: astore_1
    //   1034: aload 12
    //   1036: astore 7
    //   1038: aload 11
    //   1040: astore 8
    //   1042: aload 10
    //   1044: ifnull +11 -> 1055
    //   1047: aload 10
    //   1049: invokevirtual 227	java/io/OutputStream:close	()V
    //   1052: goto +3 -> 1055
    //   1055: aload 7
    //   1057: ifnull +54 -> 1111
    //   1060: aload 7
    //   1062: invokevirtual 224	java/io/InputStream:close	()V
    //   1065: goto +46 -> 1111
    //   1068: new 51	java/lang/StringBuilder
    //   1071: dup
    //   1072: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   1075: astore_1
    //   1076: aload_1
    //   1077: ldc 232
    //   1079: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1082: pop
    //   1083: aload_1
    //   1084: aload 7
    //   1086: invokevirtual 233	java/io/IOException:toString	()Ljava/lang/String;
    //   1089: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1092: pop
    //   1093: aload_1
    //   1094: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1097: invokestatic 71	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   1100: aload 13
    //   1102: sipush -10003
    //   1105: putfield 89	com/tencent/xweb/xwalk/updater/j$c:c	I
    //   1108: aload 13
    //   1110: areturn
    //   1111: aload 8
    //   1113: ifnull +8 -> 1121
    //   1116: aload 8
    //   1118: invokevirtual 230	java/net/HttpURLConnection:disconnect	()V
    //   1121: aload_1
    //   1122: athrow
    //   1123: ldc 250
    //   1125: invokestatic 71	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   1128: aload 13
    //   1130: sipush -10001
    //   1133: putfield 89	com/tencent/xweb/xwalk/updater/j$c:c	I
    //   1136: aload 13
    //   1138: areturn
    //   1139: goto -739 -> 400
    //   1142: astore 7
    //   1144: goto -403 -> 741
    //   1147: astore 7
    //   1149: goto -170 -> 979
    //   1152: astore 7
    //   1154: goto -86 -> 1068
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1157	0	this	j
    //   0	1157	1	paramVarArgs	j.a[]
    //   278	398	2	i	int
    //   413	115	3	j	int
    //   218	12	4	bool	boolean
    //   398	166	5	l	long
    //   237	521	7	localObject1	java.lang.Object
    //   800	1	7	localObject2	java.lang.Object
    //   810	9	7	localObject3	java.lang.Object
    //   823	262	7	localObject4	java.lang.Object
    //   1142	1	7	localIOException1	java.io.IOException
    //   1147	1	7	localIOException2	java.io.IOException
    //   1152	1	7	localIOException3	java.io.IOException
    //   234	9	8	localObject5	java.lang.Object
    //   247	1	8	localObject6	java.lang.Object
    //   252	1	8	localException1	java.lang.Exception
    //   302	325	8	localObject7	java.lang.Object
    //   635	1	8	localObject8	java.lang.Object
    //   640	1	8	localException2	java.lang.Exception
    //   646	48	8	arrayOfa1	j.a[]
    //   795	1	8	localException3	java.lang.Exception
    //   805	1	8	localException4	java.lang.Exception
    //   813	1	8	arrayOfa2	j.a[]
    //   828	1	8	localException5	java.lang.Exception
    //   838	3	8	localObject9	java.lang.Object
    //   847	60	8	localException6	java.lang.Exception
    //   1040	77	8	localObject10	java.lang.Object
    //   1	592	9	localObject11	java.lang.Object
    //   598	11	9	localException7	java.lang.Exception
    //   615	10	9	localException8	java.lang.Exception
    //   630	329	9	localObject12	java.lang.Object
    //   4	1044	10	localObject13	java.lang.Object
    //   7	1032	11	localObject14	java.lang.Object
    //   26	1009	12	localObject15	java.lang.Object
    //   57	1080	13	localc	j.c
    //   366	561	14	localObject16	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   225	231	234	finally
    //   225	231	252	java/lang/Exception
    //   443	448	468	java/io/IOException
    //   453	458	468	java/io/IOException
    //   522	538	591	finally
    //   542	555	591	finally
    //   561	581	591	finally
    //   522	538	598	java/lang/Exception
    //   542	555	598	java/lang/Exception
    //   561	581	598	java/lang/Exception
    //   346	353	603	finally
    //   359	368	603	finally
    //   374	384	603	finally
    //   390	397	603	finally
    //   406	414	603	finally
    //   425	432	603	finally
    //   438	443	603	finally
    //   346	353	615	java/lang/Exception
    //   359	368	615	java/lang/Exception
    //   374	384	615	java/lang/Exception
    //   390	397	615	java/lang/Exception
    //   406	414	615	java/lang/Exception
    //   425	432	615	java/lang/Exception
    //   438	443	615	java/lang/Exception
    //   292	329	635	finally
    //   329	340	635	finally
    //   292	329	640	java/lang/Exception
    //   329	340	640	java/lang/Exception
    //   711	715	795	java/lang/Exception
    //   648	690	800	finally
    //   648	690	805	java/lang/Exception
    //   197	220	810	finally
    //   260	279	810	finally
    //   286	292	810	finally
    //   197	220	828	java/lang/Exception
    //   260	279	828	java/lang/Exception
    //   286	292	828	java/lang/Exception
    //   178	197	836	finally
    //   178	197	847	java/lang/Exception
    //   711	715	1033	finally
    //   865	874	1033	finally
    //   885	893	1033	finally
    //   904	915	1033	finally
    //   926	934	1033	finally
    //   945	953	1033	finally
    //   720	725	1142	java/io/IOException
    //   733	738	1142	java/io/IOException
    //   958	963	1147	java/io/IOException
    //   971	976	1147	java/io/IOException
    //   1047	1052	1152	java/io/IOException
    //   1060	1065	1152	java/io/IOException
  }
  
  String a()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("XWebSdk/201201 ");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("XWebApk/");
    localStringBuilder2.append(XWalkEnvironment.getInstalledNewstVersionForCurAbi());
    localStringBuilder2.append(" ");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("XWebGrayValue/");
    localStringBuilder2.append(XWalkEnvironment.getGrayValue());
    localStringBuilder2.append(" ");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("XWebTodayGrayValue/");
    localStringBuilder2.append(XWalkEnvironment.getTodayGrayValue());
    localStringBuilder2.append(" ");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("XWebGrayValue2/");
    localStringBuilder2.append(XWalkEnvironment.getUserId());
    localStringBuilder2.append(" ");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("ABI/");
    localStringBuilder2.append(XWalkEnvironment.getRuntimeAbi());
    localStringBuilder2.append(" ");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("APPINFO/ dump (");
    localStringBuilder2.append(XWalkEnvironment.dumpAppInfo());
    localStringBuilder2.append(") ");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("ProcessName/");
    localStringBuilder2.append(XWalkEnvironment.getProcessName());
    localStringBuilder2.append(" ");
    localStringBuilder1.append(localStringBuilder2.toString());
    return localStringBuilder1.toString();
  }
  
  protected void a(j.c paramc)
  {
    j.c localc = paramc;
    if (paramc == null)
    {
      localc = new j.c();
      localc.c = -10004;
      XWalkInitializer.addXWalkInitializeLog("XWebHttpTask invalid params para onPostExecute");
    }
    if (localc.c == 0)
    {
      XWalkInitializer.addXWalkInitializeLog("task succeed! ");
      this.a.a(localc);
      return;
    }
    paramc = new StringBuilder();
    paramc.append("task failed! retcode = ");
    paramc.append(localc.c);
    paramc.append(" mRetrytimes = ");
    paramc.append(this.c);
    XWalkInitializer.addXWalkInitializeLog(paramc.toString());
    if (b(localc))
    {
      b();
      return;
    }
    this.a.b(localc);
  }
  
  protected void a(j.b... paramVarArgs)
  {
    if (paramVarArgs.length != 1) {
      return;
    }
    this.a.a(paramVarArgs[0]);
  }
  
  protected void onPreExecute() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.j
 * JD-Core Version:    0.7.0.1
 */