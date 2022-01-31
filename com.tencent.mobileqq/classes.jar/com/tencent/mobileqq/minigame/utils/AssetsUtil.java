package com.tencent.mobileqq.minigame.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import arof;
import com.tencent.mobileqq.mini.utils.DebugUtil;
import com.tencent.mobileqq.mini.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AssetsUtil
{
  public static final String LOG_TAG = "AssetsUtil";
  private static final String PRELOAD_JS = "preloadJS";
  private static final String PRELOAD_JSON = "preload/preload.json";
  private static final String PRELOAD_JSON_PATH = "mini/preload/preload.json";
  private static final String PRELOAD_JS_FOR_OPENDATA = "preloadJSForOpendata";
  private static final String PRELOAD_JS_PATH = "mini/";
  
  /* Error */
  private static boolean copyAssetToFile(AssetManager paramAssetManager, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 7
    //   9: new 34	java/io/FileOutputStream
    //   12: dup
    //   13: aload_2
    //   14: invokespecial 37	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   17: astore 4
    //   19: aload 4
    //   21: astore 6
    //   23: aload 8
    //   25: astore 5
    //   27: new 39	java/io/BufferedInputStream
    //   30: dup
    //   31: aload_0
    //   32: aload_1
    //   33: invokevirtual 45	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   36: invokespecial 48	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   39: astore_0
    //   40: sipush 8192
    //   43: newarray byte
    //   45: astore 5
    //   47: aload_0
    //   48: aload 5
    //   50: invokevirtual 52	java/io/BufferedInputStream:read	([B)I
    //   53: istore_3
    //   54: iload_3
    //   55: iconst_m1
    //   56: if_icmpeq +110 -> 166
    //   59: aload 4
    //   61: aload 5
    //   63: iconst_0
    //   64: iload_3
    //   65: invokevirtual 58	java/io/OutputStream:write	([BII)V
    //   68: goto -21 -> 47
    //   71: astore 5
    //   73: aload_0
    //   74: astore 7
    //   76: aload 5
    //   78: astore_0
    //   79: aload 4
    //   81: astore 6
    //   83: aload 7
    //   85: astore 5
    //   87: ldc 60
    //   89: iconst_1
    //   90: new 62	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   97: ldc 65
    //   99: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_1
    //   103: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: ldc 71
    //   108: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_2
    //   112: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: ldc 73
    //   117: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_0
    //   121: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
    //   124: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: aload 7
    //   135: ifnull +8 -> 143
    //   138: aload 7
    //   140: invokevirtual 89	java/io/BufferedInputStream:close	()V
    //   143: aload 4
    //   145: ifnull +19 -> 164
    //   148: aload 4
    //   150: checkcast 34	java/io/FileOutputStream
    //   153: invokevirtual 93	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   156: invokevirtual 98	java/io/FileDescriptor:sync	()V
    //   159: aload 4
    //   161: invokevirtual 99	java/io/OutputStream:close	()V
    //   164: iconst_0
    //   165: ireturn
    //   166: aload_0
    //   167: ifnull +7 -> 174
    //   170: aload_0
    //   171: invokevirtual 89	java/io/BufferedInputStream:close	()V
    //   174: aload 4
    //   176: ifnull +19 -> 195
    //   179: aload 4
    //   181: checkcast 34	java/io/FileOutputStream
    //   184: invokevirtual 93	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   187: invokevirtual 98	java/io/FileDescriptor:sync	()V
    //   190: aload 4
    //   192: invokevirtual 99	java/io/OutputStream:close	()V
    //   195: iconst_1
    //   196: ireturn
    //   197: astore_0
    //   198: ldc 60
    //   200: iconst_1
    //   201: new 62	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   208: ldc 65
    //   210: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload_1
    //   214: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: ldc 71
    //   219: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: aload_2
    //   223: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: ldc 73
    //   228: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload_0
    //   232: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
    //   235: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   244: goto -70 -> 174
    //   247: astore_0
    //   248: ldc 60
    //   250: iconst_1
    //   251: new 62	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   258: ldc 65
    //   260: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: aload_1
    //   264: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: ldc 71
    //   269: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: aload_2
    //   273: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: ldc 73
    //   278: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: aload_0
    //   282: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
    //   285: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   294: goto -99 -> 195
    //   297: astore_0
    //   298: ldc 60
    //   300: iconst_1
    //   301: new 62	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   308: ldc 65
    //   310: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: aload_1
    //   314: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: ldc 71
    //   319: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: aload_2
    //   323: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: ldc 73
    //   328: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: aload_0
    //   332: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
    //   335: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   344: aload 4
    //   346: invokevirtual 99	java/io/OutputStream:close	()V
    //   349: goto -154 -> 195
    //   352: astore_0
    //   353: ldc 60
    //   355: iconst_1
    //   356: new 62	java/lang/StringBuilder
    //   359: dup
    //   360: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   363: ldc 65
    //   365: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: aload_1
    //   369: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: ldc 71
    //   374: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: aload_2
    //   378: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: ldc 73
    //   383: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: aload_0
    //   387: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
    //   390: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   399: goto -204 -> 195
    //   402: astore_0
    //   403: aload 4
    //   405: invokevirtual 99	java/io/OutputStream:close	()V
    //   408: aload_0
    //   409: athrow
    //   410: astore 4
    //   412: ldc 60
    //   414: iconst_1
    //   415: new 62	java/lang/StringBuilder
    //   418: dup
    //   419: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   422: ldc 65
    //   424: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload_1
    //   428: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: ldc 71
    //   433: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: aload_2
    //   437: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: ldc 73
    //   442: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: aload 4
    //   447: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
    //   450: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   456: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   459: goto -51 -> 408
    //   462: astore_0
    //   463: ldc 60
    //   465: iconst_1
    //   466: new 62	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   473: ldc 65
    //   475: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: aload_1
    //   479: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: ldc 71
    //   484: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: aload_2
    //   488: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: ldc 73
    //   493: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: aload_0
    //   497: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
    //   500: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   506: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   509: goto -366 -> 143
    //   512: astore_0
    //   513: ldc 60
    //   515: iconst_1
    //   516: new 62	java/lang/StringBuilder
    //   519: dup
    //   520: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   523: ldc 65
    //   525: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: aload_1
    //   529: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: ldc 71
    //   534: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: aload_2
    //   538: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: ldc 73
    //   543: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: aload_0
    //   547: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
    //   550: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   556: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   559: goto -395 -> 164
    //   562: astore_0
    //   563: ldc 60
    //   565: iconst_1
    //   566: new 62	java/lang/StringBuilder
    //   569: dup
    //   570: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   573: ldc 65
    //   575: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: aload_1
    //   579: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: ldc 71
    //   584: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: aload_2
    //   588: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: ldc 73
    //   593: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: aload_0
    //   597: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
    //   600: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   606: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   609: aload 4
    //   611: invokevirtual 99	java/io/OutputStream:close	()V
    //   614: goto -450 -> 164
    //   617: astore_0
    //   618: ldc 60
    //   620: iconst_1
    //   621: new 62	java/lang/StringBuilder
    //   624: dup
    //   625: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   628: ldc 65
    //   630: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: aload_1
    //   634: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: ldc 71
    //   639: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: aload_2
    //   643: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: ldc 73
    //   648: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   651: aload_0
    //   652: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
    //   655: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   661: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   664: goto -500 -> 164
    //   667: astore_0
    //   668: aload 4
    //   670: invokevirtual 99	java/io/OutputStream:close	()V
    //   673: aload_0
    //   674: athrow
    //   675: astore 4
    //   677: ldc 60
    //   679: iconst_1
    //   680: new 62	java/lang/StringBuilder
    //   683: dup
    //   684: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   687: ldc 65
    //   689: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: aload_1
    //   693: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: ldc 71
    //   698: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: aload_2
    //   702: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: ldc 73
    //   707: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   710: aload 4
    //   712: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
    //   715: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   721: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   724: goto -51 -> 673
    //   727: astore_0
    //   728: aconst_null
    //   729: astore 4
    //   731: aload 5
    //   733: ifnull +8 -> 741
    //   736: aload 5
    //   738: invokevirtual 89	java/io/BufferedInputStream:close	()V
    //   741: aload 4
    //   743: ifnull +19 -> 762
    //   746: aload 4
    //   748: checkcast 34	java/io/FileOutputStream
    //   751: invokevirtual 93	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   754: invokevirtual 98	java/io/FileDescriptor:sync	()V
    //   757: aload 4
    //   759: invokevirtual 99	java/io/OutputStream:close	()V
    //   762: aload_0
    //   763: athrow
    //   764: astore 5
    //   766: ldc 60
    //   768: iconst_1
    //   769: new 62	java/lang/StringBuilder
    //   772: dup
    //   773: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   776: ldc 65
    //   778: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   781: aload_1
    //   782: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   785: ldc 71
    //   787: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   790: aload_2
    //   791: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: ldc 73
    //   796: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: aload 5
    //   801: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
    //   804: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   807: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   810: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   813: goto -72 -> 741
    //   816: astore 4
    //   818: ldc 60
    //   820: iconst_1
    //   821: new 62	java/lang/StringBuilder
    //   824: dup
    //   825: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   828: ldc 65
    //   830: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   833: aload_1
    //   834: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   837: ldc 71
    //   839: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   842: aload_2
    //   843: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   846: ldc 73
    //   848: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   851: aload 4
    //   853: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
    //   856: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   862: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   865: goto -103 -> 762
    //   868: astore 5
    //   870: ldc 60
    //   872: iconst_1
    //   873: new 62	java/lang/StringBuilder
    //   876: dup
    //   877: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   880: ldc 65
    //   882: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   885: aload_1
    //   886: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   889: ldc 71
    //   891: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   894: aload_2
    //   895: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   898: ldc 73
    //   900: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   903: aload 5
    //   905: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
    //   908: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   911: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   914: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   917: aload 4
    //   919: invokevirtual 99	java/io/OutputStream:close	()V
    //   922: goto -160 -> 762
    //   925: astore 4
    //   927: ldc 60
    //   929: iconst_1
    //   930: new 62	java/lang/StringBuilder
    //   933: dup
    //   934: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   937: ldc 65
    //   939: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   942: aload_1
    //   943: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   946: ldc 71
    //   948: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   951: aload_2
    //   952: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   955: ldc 73
    //   957: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   960: aload 4
    //   962: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
    //   965: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   968: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   971: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   974: goto -212 -> 762
    //   977: astore_0
    //   978: aload 4
    //   980: invokevirtual 99	java/io/OutputStream:close	()V
    //   983: aload_0
    //   984: athrow
    //   985: astore 4
    //   987: ldc 60
    //   989: iconst_1
    //   990: new 62	java/lang/StringBuilder
    //   993: dup
    //   994: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   997: ldc 65
    //   999: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1002: aload_1
    //   1003: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1006: ldc 71
    //   1008: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1011: aload_2
    //   1012: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1015: ldc 73
    //   1017: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1020: aload 4
    //   1022: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1025: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1028: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1031: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1034: goto -51 -> 983
    //   1037: astore_0
    //   1038: aload 6
    //   1040: astore 4
    //   1042: goto -311 -> 731
    //   1045: astore 5
    //   1047: aload_0
    //   1048: astore 6
    //   1050: aload 5
    //   1052: astore_0
    //   1053: aload 6
    //   1055: astore 5
    //   1057: goto -326 -> 731
    //   1060: astore_0
    //   1061: aconst_null
    //   1062: astore 4
    //   1064: goto -985 -> 79
    //   1067: astore_0
    //   1068: goto -989 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1071	0	paramAssetManager	AssetManager
    //   0	1071	1	paramString1	String
    //   0	1071	2	paramString2	String
    //   53	12	3	i	int
    //   17	387	4	localFileOutputStream	java.io.FileOutputStream
    //   410	259	4	localIOException1	IOException
    //   675	36	4	localIOException2	IOException
    //   729	29	4	localObject1	Object
    //   816	102	4	localIOException3	IOException
    //   925	54	4	localIOException4	IOException
    //   985	36	4	localIOException5	IOException
    //   1040	23	4	localObject2	Object
    //   1	61	5	localObject3	Object
    //   71	6	5	localIOException6	IOException
    //   85	652	5	localObject4	Object
    //   764	36	5	localIOException7	IOException
    //   868	36	5	localIOException8	IOException
    //   1045	6	5	localObject5	Object
    //   1055	1	5	localObject6	Object
    //   21	1033	6	localObject7	Object
    //   7	132	7	localAssetManager	AssetManager
    //   4	20	8	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   40	47	71	java/io/IOException
    //   47	54	71	java/io/IOException
    //   59	68	71	java/io/IOException
    //   170	174	197	java/io/IOException
    //   190	195	247	java/io/IOException
    //   179	190	297	java/io/IOException
    //   344	349	352	java/io/IOException
    //   179	190	402	finally
    //   298	344	402	finally
    //   403	408	410	java/io/IOException
    //   138	143	462	java/io/IOException
    //   159	164	512	java/io/IOException
    //   148	159	562	java/io/IOException
    //   609	614	617	java/io/IOException
    //   148	159	667	finally
    //   563	609	667	finally
    //   668	673	675	java/io/IOException
    //   9	19	727	finally
    //   736	741	764	java/io/IOException
    //   757	762	816	java/io/IOException
    //   746	757	868	java/io/IOException
    //   917	922	925	java/io/IOException
    //   746	757	977	finally
    //   870	917	977	finally
    //   978	983	985	java/io/IOException
    //   27	40	1037	finally
    //   87	133	1037	finally
    //   40	47	1045	finally
    //   47	54	1045	finally
    //   59	68	1045	finally
    //   9	19	1060	java/io/IOException
    //   27	40	1067	java/io/IOException
  }
  
  public static void copyFileOrDir(Context paramContext, String paramString1, String paramString2, long[] paramArrayOfLong)
  {
    for (;;)
    {
      int i;
      try
      {
        paramString1 = paramContext.getAssets();
        paramArrayOfLong = new File(paramString2);
        if (!paramArrayOfLong.exists()) {
          paramArrayOfLong.mkdir();
        }
        paramContext = getJSConfigByPath(paramContext);
        if (paramContext == null)
        {
          QLog.e("minigame", 1, "[Load Asset preload js Json],getJSConfigByPath return NULL!!!");
          return;
        }
        paramArrayOfLong = new File(paramString2, "preload/preload.json");
        if (!paramArrayOfLong.getParentFile().exists()) {
          paramArrayOfLong.getParentFile().mkdirs();
        }
        if (copyAssetToFile(paramString1, "mini/preload/preload.json", paramArrayOfLong.getAbsolutePath())) {
          break label329;
        }
        QLog.e("minigame", 1, "[Load Asset preload js Json],copy preload.json error!!! ");
      }
      catch (Throwable paramContext)
      {
        File localFile;
        QLog.e("minigame", 1, "[Load Asset preload js Json],copy fileList[] error!!! ");
        QLog.e("AssetsUtil", 1, paramContext, new Object[0]);
      }
      if (i < paramContext.size())
      {
        if (TextUtils.isEmpty((CharSequence)paramContext.get(i)))
        {
          QLog.e("minigame", 1, "[Load Asset preload js Json],fileList[" + i + "/" + paramContext.size() + "] isEmpty ");
        }
        else
        {
          paramArrayOfLong = "mini/" + (String)paramContext.get(i);
          localFile = new File(paramString2, (String)paramContext.get(i));
          if (!localFile.getParentFile().exists()) {
            localFile.getParentFile().mkdirs();
          }
          if (!copyAssetToFile(paramString1, paramArrayOfLong, new File(paramString2, (String)paramContext.get(i)).getAbsolutePath())) {
            QLog.e("minigame", 1, "[Load Asset preload js Json],copy fileList[" + i + "/" + paramContext.size() + "] error! ");
          }
        }
      }
      else
      {
        return;
        label329:
        i = 0;
        continue;
      }
      i += 1;
    }
  }
  
  public static boolean copyFileOrDir(Context paramContext, String paramString1, String paramString2, List<String> paramList)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramList == null) || (paramList.size() <= 0)) {
      return false;
    }
    try
    {
      paramContext = paramContext.getAssets();
      Object localObject = new File(paramString2);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdir();
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (!TextUtils.isEmpty(str))
        {
          localObject = new File(paramString2, str);
          if (!((File)localObject).exists()) {
            ((File)localObject).getParentFile().mkdirs();
          }
          str = paramString1 + File.separator + str;
          localObject = ((File)localObject).getAbsolutePath();
          if (!copyAssetToFile(paramContext, str, (String)localObject))
          {
            QLog.e("[mini] AssetsUtil", 1, String.format("copyAssetToFile from=%s, to=%s fail", new Object[] { str, localObject }));
            return false;
          }
        }
      }
      return true;
    }
    catch (Throwable paramContext)
    {
      QLog.e("[mini] AssetsUtil", 1, String.format("copyFileOrDir assetsPath=%s, destPath=%s, exception", new Object[] { paramString1, paramString2 }), paramContext);
    }
    try
    {
      paramContext = new File(paramString2);
      if (paramContext.exists()) {
        arof.a(paramContext);
      }
      label242:
      return false;
    }
    catch (Throwable paramContext)
    {
      break label242;
    }
  }
  
  public static void getAssetsSizeTotal(Context paramContext, String paramString, long[] paramArrayOfLong, boolean[] paramArrayOfBoolean)
  {
    AssetManager localAssetManager = paramContext.getAssets();
    String[] arrayOfString;
    try
    {
      arrayOfString = localAssetManager.list(paramString);
      if (arrayOfString == null) {
        return;
      }
      if (arrayOfString.length == 0)
      {
        readAssetSize(localAssetManager, paramString, paramArrayOfLong);
        return;
      }
    }
    catch (IOException paramContext)
    {
      if ((paramArrayOfBoolean != null) && (paramArrayOfBoolean.length > 0)) {
        paramArrayOfBoolean[0] = false;
      }
      QLog.e("AssetsUtil", 1, "getAssetsSizeTotal error " + DebugUtil.getPrintableStackTrace(paramContext));
      return;
    }
    int i = 0;
    for (;;)
    {
      if (i < arrayOfString.length)
      {
        if (!TextUtils.isEmpty(arrayOfString[i])) {
          getAssetsSizeTotal(paramContext, paramString + "/" + arrayOfString[i], paramArrayOfLong, paramArrayOfBoolean);
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  /* Error */
  public static String getContentFromAssets(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 8
    //   2: iconst_1
    //   3: iconst_2
    //   4: anewarray 4	java/lang/Object
    //   7: dup
    //   8: iconst_0
    //   9: ldc 245
    //   11: aastore
    //   12: dup
    //   13: iconst_1
    //   14: aload_1
    //   15: aastore
    //   16: invokestatic 249	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   19: aload_0
    //   20: invokevirtual 109	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   23: aload_1
    //   24: invokevirtual 45	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   27: astore_1
    //   28: new 251	java/io/BufferedReader
    //   31: dup
    //   32: new 253	java/io/InputStreamReader
    //   35: dup
    //   36: aload_1
    //   37: invokespecial 254	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   40: invokespecial 257	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   43: astore_3
    //   44: aload_3
    //   45: astore 5
    //   47: aload_1
    //   48: astore 4
    //   50: new 62	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   57: astore_0
    //   58: aload_3
    //   59: astore 5
    //   61: aload_1
    //   62: astore 4
    //   64: aload_3
    //   65: invokevirtual 260	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   68: astore_2
    //   69: aload_2
    //   70: ifnull +72 -> 142
    //   73: aload_3
    //   74: astore 5
    //   76: aload_1
    //   77: astore 4
    //   79: aload_0
    //   80: aload_2
    //   81: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: goto -27 -> 58
    //   88: astore_2
    //   89: aconst_null
    //   90: astore_0
    //   91: aload_3
    //   92: astore 5
    //   94: aload_1
    //   95: astore 4
    //   97: ldc 8
    //   99: iconst_1
    //   100: iconst_2
    //   101: anewarray 4	java/lang/Object
    //   104: dup
    //   105: iconst_0
    //   106: ldc_w 262
    //   109: aastore
    //   110: dup
    //   111: iconst_1
    //   112: aload_2
    //   113: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
    //   116: aastore
    //   117: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   120: aload_3
    //   121: ifnull +7 -> 128
    //   124: aload_3
    //   125: invokevirtual 265	java/io/BufferedReader:close	()V
    //   128: aload_0
    //   129: astore_2
    //   130: aload_1
    //   131: ifnull +9 -> 140
    //   134: aload_1
    //   135: invokevirtual 268	java/io/InputStream:close	()V
    //   138: aload_0
    //   139: astore_2
    //   140: aload_2
    //   141: areturn
    //   142: aload_3
    //   143: astore 5
    //   145: aload_1
    //   146: astore 4
    //   148: aload_0
    //   149: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: astore_0
    //   153: aload_3
    //   154: astore 5
    //   156: aload_1
    //   157: astore 4
    //   159: ldc 8
    //   161: iconst_1
    //   162: ldc_w 270
    //   165: invokestatic 272	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   168: aload_3
    //   169: ifnull +7 -> 176
    //   172: aload_3
    //   173: invokevirtual 265	java/io/BufferedReader:close	()V
    //   176: aload_0
    //   177: astore_2
    //   178: aload_1
    //   179: ifnull -39 -> 140
    //   182: aload_1
    //   183: invokevirtual 268	java/io/InputStream:close	()V
    //   186: aload_0
    //   187: areturn
    //   188: astore_1
    //   189: ldc 8
    //   191: iconst_1
    //   192: iconst_2
    //   193: anewarray 4	java/lang/Object
    //   196: dup
    //   197: iconst_0
    //   198: ldc_w 274
    //   201: aastore
    //   202: dup
    //   203: iconst_1
    //   204: aload_1
    //   205: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
    //   208: aastore
    //   209: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   212: aload_0
    //   213: areturn
    //   214: astore_2
    //   215: ldc 8
    //   217: iconst_1
    //   218: iconst_2
    //   219: anewarray 4	java/lang/Object
    //   222: dup
    //   223: iconst_0
    //   224: ldc_w 276
    //   227: aastore
    //   228: dup
    //   229: iconst_1
    //   230: aload_2
    //   231: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
    //   234: aastore
    //   235: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   238: goto -62 -> 176
    //   241: astore_2
    //   242: ldc 8
    //   244: iconst_1
    //   245: iconst_2
    //   246: anewarray 4	java/lang/Object
    //   249: dup
    //   250: iconst_0
    //   251: ldc_w 276
    //   254: aastore
    //   255: dup
    //   256: iconst_1
    //   257: aload_2
    //   258: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
    //   261: aastore
    //   262: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   265: goto -137 -> 128
    //   268: astore_1
    //   269: ldc 8
    //   271: iconst_1
    //   272: iconst_2
    //   273: anewarray 4	java/lang/Object
    //   276: dup
    //   277: iconst_0
    //   278: ldc_w 274
    //   281: aastore
    //   282: dup
    //   283: iconst_1
    //   284: aload_1
    //   285: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
    //   288: aastore
    //   289: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   292: aload_0
    //   293: areturn
    //   294: astore_0
    //   295: aconst_null
    //   296: astore 5
    //   298: aconst_null
    //   299: astore_1
    //   300: aload 5
    //   302: ifnull +8 -> 310
    //   305: aload 5
    //   307: invokevirtual 265	java/io/BufferedReader:close	()V
    //   310: aload_1
    //   311: ifnull +7 -> 318
    //   314: aload_1
    //   315: invokevirtual 268	java/io/InputStream:close	()V
    //   318: aload_0
    //   319: athrow
    //   320: astore_2
    //   321: ldc 8
    //   323: iconst_1
    //   324: iconst_2
    //   325: anewarray 4	java/lang/Object
    //   328: dup
    //   329: iconst_0
    //   330: ldc_w 276
    //   333: aastore
    //   334: dup
    //   335: iconst_1
    //   336: aload_2
    //   337: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
    //   340: aastore
    //   341: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   344: goto -34 -> 310
    //   347: astore_1
    //   348: ldc 8
    //   350: iconst_1
    //   351: iconst_2
    //   352: anewarray 4	java/lang/Object
    //   355: dup
    //   356: iconst_0
    //   357: ldc_w 274
    //   360: aastore
    //   361: dup
    //   362: iconst_1
    //   363: aload_1
    //   364: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
    //   367: aastore
    //   368: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   371: goto -53 -> 318
    //   374: astore_0
    //   375: aconst_null
    //   376: astore 5
    //   378: goto -78 -> 300
    //   381: astore_0
    //   382: aload 4
    //   384: astore_1
    //   385: goto -85 -> 300
    //   388: astore_2
    //   389: aconst_null
    //   390: astore_3
    //   391: aconst_null
    //   392: astore_1
    //   393: aconst_null
    //   394: astore_0
    //   395: goto -304 -> 91
    //   398: astore_2
    //   399: aconst_null
    //   400: astore_3
    //   401: aconst_null
    //   402: astore_0
    //   403: goto -312 -> 91
    //   406: astore_2
    //   407: goto -316 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	410	0	paramContext	Context
    //   0	410	1	paramString	String
    //   68	13	2	str1	String
    //   88	25	2	localIOException1	IOException
    //   129	49	2	localContext	Context
    //   214	17	2	localIOException2	IOException
    //   241	17	2	localIOException3	IOException
    //   320	17	2	localIOException4	IOException
    //   388	1	2	localIOException5	IOException
    //   398	1	2	localIOException6	IOException
    //   406	1	2	localIOException7	IOException
    //   43	358	3	localBufferedReader1	java.io.BufferedReader
    //   48	335	4	str2	String
    //   45	332	5	localBufferedReader2	java.io.BufferedReader
    // Exception table:
    //   from	to	target	type
    //   50	58	88	java/io/IOException
    //   64	69	88	java/io/IOException
    //   79	85	88	java/io/IOException
    //   148	153	88	java/io/IOException
    //   182	186	188	java/io/IOException
    //   172	176	214	java/io/IOException
    //   124	128	241	java/io/IOException
    //   134	138	268	java/io/IOException
    //   19	28	294	finally
    //   305	310	320	java/io/IOException
    //   314	318	347	java/io/IOException
    //   28	44	374	finally
    //   50	58	381	finally
    //   64	69	381	finally
    //   79	85	381	finally
    //   97	120	381	finally
    //   148	153	381	finally
    //   159	168	381	finally
    //   19	28	388	java/io/IOException
    //   28	44	398	java/io/IOException
    //   159	168	406	java/io/IOException
  }
  
  public static ArrayList<String> getJSConfigByPath(Context paramContext)
  {
    int j = 0;
    paramContext = FileUtils.readFileFromAssets("mini/preload/preload.json");
    if (TextUtils.isEmpty(paramContext))
    {
      QLog.e("minigame", 1, "[Load Asset preload js Json]getJSConfig error, jsConfig file empty");
      return null;
    }
    try
    {
      QLog.i("minigame", 1, "[Load Asset preload js Json],context:" + paramContext);
      Object localObject = new JSONObject(paramContext);
      paramContext = new ArrayList();
      JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("preloadJS");
      int i = 0;
      while (i < localJSONArray.length())
      {
        paramContext.add(localJSONArray.getString(i));
        i += 1;
      }
      localObject = ((JSONObject)localObject).getJSONArray("preloadJSForOpendata");
      i = j;
      while (i < ((JSONArray)localObject).length())
      {
        paramContext.add(((JSONArray)localObject).getString(i));
        i += 1;
      }
      paramContext.add("preload/jssdk/QGameWorkerContext.js");
      return paramContext;
    }
    catch (JSONException paramContext)
    {
      QLog.e("minigame", 1, "[Load Asset preload js Json],getJSConfig error, parse jsConfig file exception: ", paramContext);
    }
    return null;
  }
  
  /* Error */
  private static void readAssetSize(AssetManager paramAssetManager, String paramString, long[] paramArrayOfLong)
  {
    // Byte code:
    //   0: sipush 8192
    //   3: newarray byte
    //   5: astore 4
    //   7: new 39	java/io/BufferedInputStream
    //   10: dup
    //   11: aload_0
    //   12: aload_1
    //   13: invokevirtual 45	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   16: invokespecial 48	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   19: astore_1
    //   20: aload_1
    //   21: aload 4
    //   23: invokevirtual 52	java/io/BufferedInputStream:read	([B)I
    //   26: istore_3
    //   27: iload_3
    //   28: iconst_m1
    //   29: if_icmpeq +35 -> 64
    //   32: aload_2
    //   33: ifnull -13 -> 20
    //   36: aload_2
    //   37: arraylength
    //   38: ifle -18 -> 20
    //   41: aload_2
    //   42: iconst_0
    //   43: aload_2
    //   44: iconst_0
    //   45: laload
    //   46: iload_3
    //   47: i2l
    //   48: ladd
    //   49: lastore
    //   50: goto -30 -> 20
    //   53: astore_0
    //   54: aload_1
    //   55: ifnull +7 -> 62
    //   58: aload_1
    //   59: invokevirtual 89	java/io/BufferedInputStream:close	()V
    //   62: aload_0
    //   63: athrow
    //   64: aload_1
    //   65: ifnull +7 -> 72
    //   68: aload_1
    //   69: invokevirtual 89	java/io/BufferedInputStream:close	()V
    //   72: return
    //   73: astore_0
    //   74: aload_0
    //   75: invokevirtual 320	java/io/IOException:printStackTrace	()V
    //   78: return
    //   79: astore_1
    //   80: aload_1
    //   81: invokevirtual 320	java/io/IOException:printStackTrace	()V
    //   84: goto -22 -> 62
    //   87: astore_0
    //   88: aconst_null
    //   89: astore_1
    //   90: goto -36 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	paramAssetManager	AssetManager
    //   0	93	1	paramString	String
    //   0	93	2	paramArrayOfLong	long[]
    //   26	21	3	i	int
    //   5	17	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   20	27	53	finally
    //   36	41	53	finally
    //   68	72	73	java/io/IOException
    //   58	62	79	java/io/IOException
    //   7	20	87	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.utils.AssetsUtil
 * JD-Core Version:    0.7.0.1
 */