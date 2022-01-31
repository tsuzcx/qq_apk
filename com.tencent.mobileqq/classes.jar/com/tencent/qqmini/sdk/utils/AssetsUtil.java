package com.tencent.qqmini.sdk.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import bgkv;
import com.tencent.qqmini.sdk.log.QMLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
    //   56: if_icmpeq +109 -> 165
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
    //   89: new 62	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   96: ldc 65
    //   98: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload_1
    //   102: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: ldc 71
    //   107: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_2
    //   111: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: ldc 73
    //   116: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_0
    //   120: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
    //   123: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 86	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: aload 7
    //   134: ifnull +8 -> 142
    //   137: aload 7
    //   139: invokevirtual 89	java/io/BufferedInputStream:close	()V
    //   142: aload 4
    //   144: ifnull +19 -> 163
    //   147: aload 4
    //   149: checkcast 34	java/io/FileOutputStream
    //   152: invokevirtual 93	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   155: invokevirtual 98	java/io/FileDescriptor:sync	()V
    //   158: aload 4
    //   160: invokevirtual 99	java/io/OutputStream:close	()V
    //   163: iconst_0
    //   164: ireturn
    //   165: aload_0
    //   166: ifnull +7 -> 173
    //   169: aload_0
    //   170: invokevirtual 89	java/io/BufferedInputStream:close	()V
    //   173: aload 4
    //   175: ifnull +19 -> 194
    //   178: aload 4
    //   180: checkcast 34	java/io/FileOutputStream
    //   183: invokevirtual 93	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   186: invokevirtual 98	java/io/FileDescriptor:sync	()V
    //   189: aload 4
    //   191: invokevirtual 99	java/io/OutputStream:close	()V
    //   194: iconst_1
    //   195: ireturn
    //   196: astore_0
    //   197: ldc 60
    //   199: new 62	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   206: ldc 65
    //   208: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload_1
    //   212: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: ldc 71
    //   217: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload_2
    //   221: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: ldc 73
    //   226: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload_0
    //   230: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
    //   233: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 86	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   242: goto -69 -> 173
    //   245: astore_0
    //   246: ldc 60
    //   248: new 62	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   255: ldc 65
    //   257: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload_1
    //   261: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: ldc 71
    //   266: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload_2
    //   270: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: ldc 73
    //   275: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload_0
    //   279: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
    //   282: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokestatic 86	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   291: goto -97 -> 194
    //   294: astore_0
    //   295: ldc 60
    //   297: new 62	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   304: ldc 65
    //   306: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: aload_1
    //   310: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: ldc 71
    //   315: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: aload_2
    //   319: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: ldc 73
    //   324: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: aload_0
    //   328: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
    //   331: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   337: invokestatic 86	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   340: aload 4
    //   342: invokevirtual 99	java/io/OutputStream:close	()V
    //   345: goto -151 -> 194
    //   348: astore_0
    //   349: ldc 60
    //   351: new 62	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   358: ldc 65
    //   360: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: aload_1
    //   364: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: ldc 71
    //   369: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: aload_2
    //   373: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: ldc 73
    //   378: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: aload_0
    //   382: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
    //   385: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokestatic 86	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   394: goto -200 -> 194
    //   397: astore_0
    //   398: aload 4
    //   400: invokevirtual 99	java/io/OutputStream:close	()V
    //   403: aload_0
    //   404: athrow
    //   405: astore 4
    //   407: ldc 60
    //   409: new 62	java/lang/StringBuilder
    //   412: dup
    //   413: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   416: ldc 65
    //   418: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: aload_1
    //   422: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: ldc 71
    //   427: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: aload_2
    //   431: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: ldc 73
    //   436: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: aload 4
    //   441: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
    //   444: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: invokestatic 86	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   453: goto -50 -> 403
    //   456: astore_0
    //   457: ldc 60
    //   459: new 62	java/lang/StringBuilder
    //   462: dup
    //   463: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   466: ldc 65
    //   468: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: aload_1
    //   472: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: ldc 71
    //   477: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: aload_2
    //   481: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: ldc 73
    //   486: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: aload_0
    //   490: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
    //   493: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   499: invokestatic 86	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   502: goto -360 -> 142
    //   505: astore_0
    //   506: ldc 60
    //   508: new 62	java/lang/StringBuilder
    //   511: dup
    //   512: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   515: ldc 65
    //   517: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: aload_1
    //   521: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: ldc 71
    //   526: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: aload_2
    //   530: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: ldc 73
    //   535: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: aload_0
    //   539: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
    //   542: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   548: invokestatic 86	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   551: goto -388 -> 163
    //   554: astore_0
    //   555: ldc 60
    //   557: new 62	java/lang/StringBuilder
    //   560: dup
    //   561: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   564: ldc 65
    //   566: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: aload_1
    //   570: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: ldc 71
    //   575: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: aload_2
    //   579: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: ldc 73
    //   584: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: aload_0
    //   588: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
    //   591: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   597: invokestatic 86	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   600: aload 4
    //   602: invokevirtual 99	java/io/OutputStream:close	()V
    //   605: goto -442 -> 163
    //   608: astore_0
    //   609: ldc 60
    //   611: new 62	java/lang/StringBuilder
    //   614: dup
    //   615: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   618: ldc 65
    //   620: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: aload_1
    //   624: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: ldc 71
    //   629: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: aload_2
    //   633: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: ldc 73
    //   638: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: aload_0
    //   642: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
    //   645: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   651: invokestatic 86	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   654: goto -491 -> 163
    //   657: astore_0
    //   658: aload 4
    //   660: invokevirtual 99	java/io/OutputStream:close	()V
    //   663: aload_0
    //   664: athrow
    //   665: astore 4
    //   667: ldc 60
    //   669: new 62	java/lang/StringBuilder
    //   672: dup
    //   673: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   676: ldc 65
    //   678: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: aload_1
    //   682: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: ldc 71
    //   687: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: aload_2
    //   691: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   694: ldc 73
    //   696: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: aload 4
    //   701: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
    //   704: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   710: invokestatic 86	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   713: goto -50 -> 663
    //   716: astore_0
    //   717: aconst_null
    //   718: astore 4
    //   720: aload 5
    //   722: ifnull +8 -> 730
    //   725: aload 5
    //   727: invokevirtual 89	java/io/BufferedInputStream:close	()V
    //   730: aload 4
    //   732: ifnull +19 -> 751
    //   735: aload 4
    //   737: checkcast 34	java/io/FileOutputStream
    //   740: invokevirtual 93	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   743: invokevirtual 98	java/io/FileDescriptor:sync	()V
    //   746: aload 4
    //   748: invokevirtual 99	java/io/OutputStream:close	()V
    //   751: aload_0
    //   752: athrow
    //   753: astore 5
    //   755: ldc 60
    //   757: new 62	java/lang/StringBuilder
    //   760: dup
    //   761: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   764: ldc 65
    //   766: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: aload_1
    //   770: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   773: ldc 71
    //   775: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   778: aload_2
    //   779: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   782: ldc 73
    //   784: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: aload 5
    //   789: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
    //   792: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   798: invokestatic 86	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   801: goto -71 -> 730
    //   804: astore 4
    //   806: ldc 60
    //   808: new 62	java/lang/StringBuilder
    //   811: dup
    //   812: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   815: ldc 65
    //   817: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: aload_1
    //   821: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: ldc 71
    //   826: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   829: aload_2
    //   830: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   833: ldc 73
    //   835: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: aload 4
    //   840: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
    //   843: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   846: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   849: invokestatic 86	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   852: goto -101 -> 751
    //   855: astore 5
    //   857: ldc 60
    //   859: new 62	java/lang/StringBuilder
    //   862: dup
    //   863: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   866: ldc 65
    //   868: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: aload_1
    //   872: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   875: ldc 71
    //   877: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   880: aload_2
    //   881: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   884: ldc 73
    //   886: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   889: aload 5
    //   891: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
    //   894: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   897: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   900: invokestatic 86	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   903: aload 4
    //   905: invokevirtual 99	java/io/OutputStream:close	()V
    //   908: goto -157 -> 751
    //   911: astore 4
    //   913: ldc 60
    //   915: new 62	java/lang/StringBuilder
    //   918: dup
    //   919: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   922: ldc 65
    //   924: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   927: aload_1
    //   928: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   931: ldc 71
    //   933: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   936: aload_2
    //   937: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   940: ldc 73
    //   942: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   945: aload 4
    //   947: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
    //   950: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   953: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   956: invokestatic 86	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   959: goto -208 -> 751
    //   962: astore_0
    //   963: aload 4
    //   965: invokevirtual 99	java/io/OutputStream:close	()V
    //   968: aload_0
    //   969: athrow
    //   970: astore 4
    //   972: ldc 60
    //   974: new 62	java/lang/StringBuilder
    //   977: dup
    //   978: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   981: ldc 65
    //   983: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   986: aload_1
    //   987: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   990: ldc 71
    //   992: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   995: aload_2
    //   996: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   999: ldc 73
    //   1001: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1004: aload 4
    //   1006: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1009: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1012: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1015: invokestatic 86	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1018: goto -50 -> 968
    //   1021: astore_0
    //   1022: aload 6
    //   1024: astore 4
    //   1026: goto -306 -> 720
    //   1029: astore 5
    //   1031: aload_0
    //   1032: astore 6
    //   1034: aload 5
    //   1036: astore_0
    //   1037: aload 6
    //   1039: astore 5
    //   1041: goto -321 -> 720
    //   1044: astore_0
    //   1045: aconst_null
    //   1046: astore 4
    //   1048: goto -969 -> 79
    //   1051: astore_0
    //   1052: goto -973 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1055	0	paramAssetManager	AssetManager
    //   0	1055	1	paramString1	String
    //   0	1055	2	paramString2	String
    //   53	12	3	i	int
    //   17	382	4	localFileOutputStream	java.io.FileOutputStream
    //   405	254	4	localIOException1	IOException
    //   665	35	4	localIOException2	IOException
    //   718	29	4	localObject1	Object
    //   804	100	4	localIOException3	IOException
    //   911	53	4	localIOException4	IOException
    //   970	35	4	localIOException5	IOException
    //   1024	23	4	localObject2	Object
    //   1	61	5	localObject3	Object
    //   71	6	5	localIOException6	IOException
    //   85	641	5	localObject4	Object
    //   753	35	5	localIOException7	IOException
    //   855	35	5	localIOException8	IOException
    //   1029	6	5	localObject5	Object
    //   1039	1	5	localObject6	Object
    //   21	1017	6	localObject7	Object
    //   7	131	7	localAssetManager	AssetManager
    //   4	20	8	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   40	47	71	java/io/IOException
    //   47	54	71	java/io/IOException
    //   59	68	71	java/io/IOException
    //   169	173	196	java/io/IOException
    //   189	194	245	java/io/IOException
    //   178	189	294	java/io/IOException
    //   340	345	348	java/io/IOException
    //   178	189	397	finally
    //   295	340	397	finally
    //   398	403	405	java/io/IOException
    //   137	142	456	java/io/IOException
    //   158	163	505	java/io/IOException
    //   147	158	554	java/io/IOException
    //   600	605	608	java/io/IOException
    //   147	158	657	finally
    //   555	600	657	finally
    //   658	663	665	java/io/IOException
    //   9	19	716	finally
    //   725	730	753	java/io/IOException
    //   746	751	804	java/io/IOException
    //   735	746	855	java/io/IOException
    //   903	908	911	java/io/IOException
    //   735	746	962	finally
    //   857	903	962	finally
    //   963	968	970	java/io/IOException
    //   27	40	1021	finally
    //   87	132	1021	finally
    //   40	47	1029	finally
    //   47	54	1029	finally
    //   59	68	1029	finally
    //   9	19	1044	java/io/IOException
    //   27	40	1051	java/io/IOException
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
          QMLog.e("minigame", "[Load Asset preload js Json],getJSConfigByPath return NULL!!!");
          return;
        }
        paramArrayOfLong = new File(paramString2, "preload/preload.json");
        if (!paramArrayOfLong.getParentFile().exists()) {
          paramArrayOfLong.getParentFile().mkdirs();
        }
        if (copyAssetToFile(paramString1, "mini/preload/preload.json", paramArrayOfLong.getAbsolutePath())) {
          break label314;
        }
        QMLog.e("minigame", "[Load Asset preload js Json],copy preload.json error!!! ");
      }
      catch (Throwable paramContext)
      {
        File localFile;
        QMLog.e("minigame", "[Load Asset preload js Json],copy fileList[] error!!! ", paramContext);
      }
      if (i < paramContext.size())
      {
        if (TextUtils.isEmpty((CharSequence)paramContext.get(i)))
        {
          QMLog.e("minigame", "[Load Asset preload js Json],fileList[" + i + "/" + paramContext.size() + "] isEmpty ");
        }
        else
        {
          paramArrayOfLong = "mini/" + (String)paramContext.get(i);
          localFile = new File(paramString2, (String)paramContext.get(i));
          if (!localFile.getParentFile().exists()) {
            localFile.getParentFile().mkdirs();
          }
          if (!copyAssetToFile(paramString1, paramArrayOfLong, new File(paramString2, (String)paramContext.get(i)).getAbsolutePath())) {
            QMLog.e("minigame", "[Load Asset preload js Json],copy fileList[" + i + "/" + paramContext.size() + "] error! ");
          }
        }
      }
      else
      {
        return;
        label314:
        i = 0;
        continue;
      }
      i += 1;
    }
  }
  
  public static boolean copyFileOrDir(Context paramContext, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    for (;;)
    {
      return false;
      try
      {
        AssetManager localAssetManager = paramContext.getAssets();
        String[] arrayOfString = localAssetManager.list(paramString1);
        if ((arrayOfString != null) && (arrayOfString.length != 0))
        {
          localObject = new File(paramString2);
          if (!((File)localObject).exists()) {
            ((File)localObject).mkdir();
          }
          int j = arrayOfString.length;
          i = 0;
          if (i < j)
          {
            str = arrayOfString[i];
            if (!TextUtils.isEmpty(str))
            {
              localObject = new File(paramString2, str);
              if (!((File)localObject).exists()) {
                ((File)localObject).getParentFile().mkdirs();
              }
              str = paramString1 + File.separator + str;
              localObject = ((File)localObject).getAbsolutePath();
              if (localAssetManager.list(str).length == 0)
              {
                if (copyAssetToFile(localAssetManager, str, (String)localObject)) {
                  break label261;
                }
                QMLog.e("[mini] AssetsUtil", String.format("copyAssetToFile from=%s, to=%s fail", new Object[] { str, localObject }));
                return false;
              }
            }
          }
        }
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          Object localObject;
          int i;
          String str;
          for (;;)
          {
            QMLog.e("[mini] AssetsUtil", String.format("copyFileOrDir assetsPath=%s, destPath=%s, exception", new Object[] { paramString1, paramString2 }), paramContext);
            try
            {
              if (!new File(paramString2).exists()) {
                break;
              }
              bgkv.a(paramString2, false);
              return false;
            }
            catch (Throwable paramContext)
            {
              return false;
            }
          }
          copyFileOrDir(paramContext, str, (String)localObject);
          label261:
          i += 1;
        }
      }
    }
    return true;
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
      QMLog.e("AssetsUtil", "getAssetsSizeTotal error " + DebugUtil.getPrintableStackTrace(paramContext));
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
  
  public static ArrayList<String> getJSConfigByPath(Context paramContext)
  {
    int j = 0;
    paramContext = bgkv.a(paramContext, "mini/preload/preload.json");
    if (TextUtils.isEmpty(paramContext))
    {
      QMLog.e("minigame", "[Load Asset preload js Json]getJSConfig error, jsConfig file empty");
      return null;
    }
    try
    {
      QMLog.i("minigame", "[Load Asset preload js Json],context:" + paramContext);
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
      QMLog.e("minigame", "[Load Asset preload js Json],getJSConfig error, parse jsConfig file exception: ", paramContext);
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
    //   75: invokevirtual 263	java/io/IOException:printStackTrace	()V
    //   78: return
    //   79: astore_1
    //   80: aload_1
    //   81: invokevirtual 263	java/io/IOException:printStackTrace	()V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.AssetsUtil
 * JD-Core Version:    0.7.0.1
 */