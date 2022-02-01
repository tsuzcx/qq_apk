package com.tencent.mobileqq.vas.updatesystem;

import android.text.TextUtils;
import com.google.gson.stream.JsonReader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.quickupdate.UpdateCallbackSelector;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateAdapter;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateBusinessCallback;
import com.tencent.mobileqq.vas.updatesystem.callback.TagItemInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileReader;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class VasUpdateUtil
{
  public static JsonReader a(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean, CallBacker paramCallBacker)
  {
    if (paramAppRuntime == null)
    {
      paramCallBacker = new StringBuilder();
      paramCallBacker.append("getJSONFromLocalByStreamRead, app == null; scid:");
      paramCallBacker.append(paramString);
      paramCallBacker.append(", app=");
      paramCallBacker.append(paramAppRuntime);
      QLog.e("VasUpdateUtil", 1, paramCallBacker.toString());
      return null;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramAppRuntime.getApplication().getFilesDir());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    File localFile = new File((String)localObject);
    if (localFile.exists()) {
      try
      {
        JsonReader localJsonReader = new JsonReader(new FileReader(localFile));
        return localJsonReader;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getJSONFromLocalByStreamRead error,json_name:");
          localStringBuilder.append(paramString);
          QLog.e("VasUpdateUtil", 2, localStringBuilder.toString(), localThrowable);
        }
        localFile.delete();
      }
    }
    if (paramBoolean) {
      ((IVasQuickUpdateAdapter)QRoute.api(IVasQuickUpdateAdapter.class)).downloadItem(paramAppRuntime, 1000L, paramString, (String)localObject, paramCallBacker);
    }
    return null;
  }
  
  public static TagItemInfo a(long paramLong, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getItemInfo bid = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" scid = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("VasUpdateUtil", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = UpdateCallbackSelector.getCallback(paramLong);
    if (localObject == null) {
      return null;
    }
    return ((QuickUpdateBusinessCallback)localObject).getItemInfo(paramLong, paramString);
  }
  
  public static File a(AppRuntime paramAppRuntime, long paramLong, String paramString1, String paramString2, boolean paramBoolean, CallBacker paramCallBacker)
  {
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2))
    {
      str = paramString2;
      if (paramAppRuntime != null)
      {
        paramString2 = new StringBuilder();
        paramString2.append(paramAppRuntime.getApplication().getFilesDir());
        paramString2.append(File.separator);
        paramString2.append(paramString1);
        str = paramString2.toString();
      }
    }
    if (TextUtils.isEmpty(str))
    {
      paramString2 = new StringBuilder();
      paramString2.append("getFileFromLocal err filePath, bid=");
      paramString2.append(paramLong);
      paramString2.append(",scid:");
      paramString2.append(paramString1);
      paramString2.append(", app=");
      paramString2.append(paramAppRuntime);
      paramString2.append(", filePaht=");
      paramString2.append(str);
      QLog.e("VasUpdateUtil", 1, paramString2.toString());
      return null;
    }
    File localFile = new File(str);
    paramString2 = localFile;
    if (!localFile.exists())
    {
      if (paramBoolean) {
        ((IVasQuickUpdateAdapter)QRoute.api(IVasQuickUpdateAdapter.class)).downloadItem(paramAppRuntime, paramLong, paramString1, str, paramCallBacker);
      }
      paramString2 = null;
    }
    return paramString2;
  }
  
  /* Error */
  public static String a(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 8
    //   12: new 141	com/tencent/commonsdk/zip/QZipFile
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 142	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/io/File;)V
    //   20: astore 4
    //   22: aload 4
    //   24: invokevirtual 146	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   27: astore 13
    //   29: sipush 8192
    //   32: newarray byte
    //   34: astore 14
    //   36: aconst_null
    //   37: astore_0
    //   38: aload_0
    //   39: astore 5
    //   41: aload 8
    //   43: astore 6
    //   45: aload 5
    //   47: astore 11
    //   49: aload 5
    //   51: astore 12
    //   53: aload 6
    //   55: astore 7
    //   57: aload 4
    //   59: astore 8
    //   61: aload_0
    //   62: astore 9
    //   64: aload 13
    //   66: invokeinterface 151 1 0
    //   71: ifeq +925 -> 996
    //   74: aload 5
    //   76: astore 11
    //   78: aload 5
    //   80: astore 12
    //   82: aload 6
    //   84: astore 7
    //   86: aload 4
    //   88: astore 8
    //   90: aload_0
    //   91: astore 9
    //   93: aload 13
    //   95: invokeinterface 155 1 0
    //   100: checkcast 157	java/util/zip/ZipEntry
    //   103: astore 15
    //   105: aload 5
    //   107: astore 11
    //   109: aload 5
    //   111: astore 12
    //   113: aload 6
    //   115: astore 7
    //   117: aload 4
    //   119: astore 8
    //   121: aload_0
    //   122: astore 9
    //   124: aload 15
    //   126: invokevirtual 160	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   129: ldc 162
    //   131: invokevirtual 167	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   134: ifeq +6 -> 140
    //   137: goto -92 -> 45
    //   140: aload 5
    //   142: astore 11
    //   144: aload 5
    //   146: astore 12
    //   148: aload 6
    //   150: astore 7
    //   152: aload 4
    //   154: astore 8
    //   156: aload_0
    //   157: astore 9
    //   159: aload 15
    //   161: invokevirtual 170	java/util/zip/ZipEntry:isDirectory	()Z
    //   164: ifeq +445 -> 609
    //   167: aload 5
    //   169: astore 11
    //   171: aload 5
    //   173: astore 12
    //   175: aload 6
    //   177: astore 7
    //   179: aload 4
    //   181: astore 8
    //   183: aload_0
    //   184: astore 9
    //   186: invokestatic 173	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   189: istore_3
    //   190: iload_3
    //   191: ifeq +118 -> 309
    //   194: aload 5
    //   196: astore 11
    //   198: aload 5
    //   200: astore 12
    //   202: aload 6
    //   204: astore 7
    //   206: aload 4
    //   208: astore 8
    //   210: aload_0
    //   211: astore 9
    //   213: new 15	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 16	java/lang/StringBuilder:<init>	()V
    //   220: astore 10
    //   222: aload 5
    //   224: astore 11
    //   226: aload 5
    //   228: astore 12
    //   230: aload 6
    //   232: astore 7
    //   234: aload 4
    //   236: astore 8
    //   238: aload_0
    //   239: astore 9
    //   241: aload 10
    //   243: ldc 175
    //   245: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload 5
    //   251: astore 11
    //   253: aload 5
    //   255: astore 12
    //   257: aload 6
    //   259: astore 7
    //   261: aload 4
    //   263: astore 8
    //   265: aload_0
    //   266: astore 9
    //   268: aload 10
    //   270: aload 15
    //   272: invokevirtual 160	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   275: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: aload 5
    //   281: astore 11
    //   283: aload 5
    //   285: astore 12
    //   287: aload 6
    //   289: astore 7
    //   291: aload 4
    //   293: astore 8
    //   295: aload_0
    //   296: astore 9
    //   298: ldc 177
    //   300: iconst_4
    //   301: aload 10
    //   303: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   309: aload 5
    //   311: astore 11
    //   313: aload 5
    //   315: astore 12
    //   317: aload 6
    //   319: astore 7
    //   321: aload 4
    //   323: astore 8
    //   325: aload_0
    //   326: astore 9
    //   328: new 15	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 16	java/lang/StringBuilder:<init>	()V
    //   335: astore 10
    //   337: aload 5
    //   339: astore 11
    //   341: aload 5
    //   343: astore 12
    //   345: aload 6
    //   347: astore 7
    //   349: aload 4
    //   351: astore 8
    //   353: aload_0
    //   354: astore 9
    //   356: aload 10
    //   358: aload_1
    //   359: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: pop
    //   363: aload 5
    //   365: astore 11
    //   367: aload 5
    //   369: astore 12
    //   371: aload 6
    //   373: astore 7
    //   375: aload 4
    //   377: astore 8
    //   379: aload_0
    //   380: astore 9
    //   382: aload 10
    //   384: aload 15
    //   386: invokevirtual 160	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   389: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: aload 5
    //   395: astore 11
    //   397: aload 5
    //   399: astore 12
    //   401: aload 6
    //   403: astore 7
    //   405: aload 4
    //   407: astore 8
    //   409: aload_0
    //   410: astore 9
    //   412: new 164	java/lang/String
    //   415: dup
    //   416: aload 10
    //   418: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   421: ldc 179
    //   423: invokevirtual 183	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   426: ldc 185
    //   428: invokespecial 188	java/lang/String:<init>	([BLjava/lang/String;)V
    //   431: astore 10
    //   433: aload 5
    //   435: astore 11
    //   437: aload 5
    //   439: astore 12
    //   441: aload 6
    //   443: astore 7
    //   445: aload 4
    //   447: astore 8
    //   449: aload_0
    //   450: astore 9
    //   452: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   455: ifeq +115 -> 570
    //   458: aload 5
    //   460: astore 11
    //   462: aload 5
    //   464: astore 12
    //   466: aload 6
    //   468: astore 7
    //   470: aload 4
    //   472: astore 8
    //   474: aload_0
    //   475: astore 9
    //   477: new 15	java/lang/StringBuilder
    //   480: dup
    //   481: invokespecial 16	java/lang/StringBuilder:<init>	()V
    //   484: astore 15
    //   486: aload 5
    //   488: astore 11
    //   490: aload 5
    //   492: astore 12
    //   494: aload 6
    //   496: astore 7
    //   498: aload 4
    //   500: astore 8
    //   502: aload_0
    //   503: astore 9
    //   505: aload 15
    //   507: ldc 190
    //   509: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: pop
    //   513: aload 5
    //   515: astore 11
    //   517: aload 5
    //   519: astore 12
    //   521: aload 6
    //   523: astore 7
    //   525: aload 4
    //   527: astore 8
    //   529: aload_0
    //   530: astore 9
    //   532: aload 15
    //   534: aload 10
    //   536: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: pop
    //   540: aload 5
    //   542: astore 11
    //   544: aload 5
    //   546: astore 12
    //   548: aload 6
    //   550: astore 7
    //   552: aload 4
    //   554: astore 8
    //   556: aload_0
    //   557: astore 9
    //   559: ldc 177
    //   561: iconst_2
    //   562: aload 15
    //   564: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   567: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   570: aload 5
    //   572: astore 11
    //   574: aload 5
    //   576: astore 12
    //   578: aload 6
    //   580: astore 7
    //   582: aload 4
    //   584: astore 8
    //   586: aload_0
    //   587: astore 9
    //   589: new 53	java/io/File
    //   592: dup
    //   593: aload 10
    //   595: invokespecial 60	java/io/File:<init>	(Ljava/lang/String;)V
    //   598: invokevirtual 193	java/io/File:mkdir	()Z
    //   601: pop
    //   602: aload 10
    //   604: astore 5
    //   606: goto -561 -> 45
    //   609: aload 5
    //   611: astore 11
    //   613: aload 5
    //   615: astore 12
    //   617: aload 6
    //   619: astore 7
    //   621: aload 4
    //   623: astore 8
    //   625: aload_0
    //   626: astore 9
    //   628: aload 15
    //   630: invokevirtual 160	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   633: astore 5
    //   635: aload 5
    //   637: astore 11
    //   639: aload 5
    //   641: astore 12
    //   643: aload 6
    //   645: astore 7
    //   647: aload 4
    //   649: astore 8
    //   651: aload_0
    //   652: astore 9
    //   654: new 15	java/lang/StringBuilder
    //   657: dup
    //   658: invokespecial 16	java/lang/StringBuilder:<init>	()V
    //   661: astore 10
    //   663: aload 5
    //   665: astore 11
    //   667: aload 5
    //   669: astore 12
    //   671: aload 6
    //   673: astore 7
    //   675: aload 4
    //   677: astore 8
    //   679: aload_0
    //   680: astore 9
    //   682: aload 10
    //   684: aload_1
    //   685: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: pop
    //   689: aload 5
    //   691: astore 11
    //   693: aload 5
    //   695: astore 12
    //   697: aload 6
    //   699: astore 7
    //   701: aload 4
    //   703: astore 8
    //   705: aload_0
    //   706: astore 9
    //   708: aload 10
    //   710: aload 15
    //   712: invokevirtual 160	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   715: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: pop
    //   719: aload 5
    //   721: astore 11
    //   723: aload 5
    //   725: astore 12
    //   727: aload 6
    //   729: astore 7
    //   731: aload 4
    //   733: astore 8
    //   735: aload_0
    //   736: astore 9
    //   738: new 53	java/io/File
    //   741: dup
    //   742: aload 10
    //   744: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   747: invokespecial 60	java/io/File:<init>	(Ljava/lang/String;)V
    //   750: astore 10
    //   752: aload 5
    //   754: astore 11
    //   756: aload 5
    //   758: astore 12
    //   760: aload 6
    //   762: astore 7
    //   764: aload 4
    //   766: astore 8
    //   768: aload_0
    //   769: astore 9
    //   771: aload 10
    //   773: invokevirtual 196	java/io/File:getParentFile	()Ljava/io/File;
    //   776: invokevirtual 199	java/io/File:mkdirs	()Z
    //   779: pop
    //   780: aload 5
    //   782: astore 11
    //   784: aload 5
    //   786: astore 12
    //   788: aload 6
    //   790: astore 7
    //   792: aload 4
    //   794: astore 8
    //   796: aload_0
    //   797: astore 9
    //   799: aload 10
    //   801: invokevirtual 64	java/io/File:exists	()Z
    //   804: ifeq +28 -> 832
    //   807: aload 5
    //   809: astore 11
    //   811: aload 5
    //   813: astore 12
    //   815: aload 6
    //   817: astore 7
    //   819: aload 4
    //   821: astore 8
    //   823: aload_0
    //   824: astore 9
    //   826: aload 10
    //   828: invokevirtual 85	java/io/File:delete	()Z
    //   831: pop
    //   832: aload 5
    //   834: astore 11
    //   836: aload 5
    //   838: astore 12
    //   840: aload 6
    //   842: astore 7
    //   844: aload 4
    //   846: astore 8
    //   848: aload_0
    //   849: astore 9
    //   851: new 201	java/io/BufferedOutputStream
    //   854: dup
    //   855: new 203	java/io/FileOutputStream
    //   858: dup
    //   859: aload 10
    //   861: invokespecial 204	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   864: invokespecial 207	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   867: astore 10
    //   869: aload_0
    //   870: astore 9
    //   872: aload_0
    //   873: astore 7
    //   875: aload_0
    //   876: astore 8
    //   878: aload 4
    //   880: aload 15
    //   882: invokevirtual 211	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   885: astore_0
    //   886: aload_0
    //   887: astore 9
    //   889: aload_0
    //   890: astore 7
    //   892: aload_0
    //   893: astore 8
    //   895: aload_0
    //   896: aload 14
    //   898: iconst_0
    //   899: sipush 8192
    //   902: invokevirtual 217	java/io/InputStream:read	([BII)I
    //   905: istore_2
    //   906: iload_2
    //   907: iconst_m1
    //   908: if_icmpeq +24 -> 932
    //   911: aload_0
    //   912: astore 9
    //   914: aload_0
    //   915: astore 7
    //   917: aload_0
    //   918: astore 8
    //   920: aload 10
    //   922: aload 14
    //   924: iconst_0
    //   925: iload_2
    //   926: invokevirtual 223	java/io/OutputStream:write	([BII)V
    //   929: goto -43 -> 886
    //   932: aload_0
    //   933: astore 9
    //   935: aload_0
    //   936: astore 7
    //   938: aload_0
    //   939: astore 8
    //   941: aload_0
    //   942: invokevirtual 226	java/io/InputStream:close	()V
    //   945: aload_0
    //   946: astore 9
    //   948: aload_0
    //   949: astore 7
    //   951: aload_0
    //   952: astore 8
    //   954: aload 10
    //   956: invokevirtual 227	java/io/OutputStream:close	()V
    //   959: aload 10
    //   961: astore 6
    //   963: goto -918 -> 45
    //   966: astore_0
    //   967: aload 10
    //   969: astore 7
    //   971: goto +361 -> 1332
    //   974: astore_1
    //   975: aload 10
    //   977: astore 6
    //   979: aload 7
    //   981: astore_0
    //   982: goto +164 -> 1146
    //   985: astore_1
    //   986: aload 10
    //   988: astore 6
    //   990: aload 8
    //   992: astore_0
    //   993: goto +249 -> 1242
    //   996: aload 5
    //   998: astore 11
    //   1000: aload 5
    //   1002: astore 12
    //   1004: aload 6
    //   1006: astore 7
    //   1008: aload 4
    //   1010: astore 8
    //   1012: aload_0
    //   1013: astore 9
    //   1015: aload 4
    //   1017: invokevirtual 228	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   1020: aload 6
    //   1022: ifnull +21 -> 1043
    //   1025: aload 6
    //   1027: invokevirtual 227	java/io/OutputStream:close	()V
    //   1030: goto +13 -> 1043
    //   1033: astore_1
    //   1034: ldc 29
    //   1036: iconst_1
    //   1037: ldc 230
    //   1039: aload_1
    //   1040: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1043: aload_0
    //   1044: ifnull +20 -> 1064
    //   1047: aload_0
    //   1048: invokevirtual 226	java/io/InputStream:close	()V
    //   1051: goto +13 -> 1064
    //   1054: astore_0
    //   1055: ldc 29
    //   1057: iconst_1
    //   1058: ldc 230
    //   1060: aload_0
    //   1061: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1064: aload 5
    //   1066: astore_0
    //   1067: aload 4
    //   1069: invokevirtual 228	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   1072: aload 5
    //   1074: areturn
    //   1075: astore_1
    //   1076: ldc 29
    //   1078: iconst_1
    //   1079: ldc 230
    //   1081: aload_1
    //   1082: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1085: aload_0
    //   1086: areturn
    //   1087: astore_1
    //   1088: aload 11
    //   1090: astore 5
    //   1092: goto +54 -> 1146
    //   1095: astore_1
    //   1096: aload 12
    //   1098: astore 5
    //   1100: goto +142 -> 1242
    //   1103: astore_0
    //   1104: aconst_null
    //   1105: astore 9
    //   1107: aload 5
    //   1109: astore 7
    //   1111: goto +221 -> 1332
    //   1114: astore_1
    //   1115: goto +26 -> 1141
    //   1118: astore_1
    //   1119: goto +114 -> 1233
    //   1122: astore_0
    //   1123: aconst_null
    //   1124: astore 4
    //   1126: aload 4
    //   1128: astore 9
    //   1130: aload 5
    //   1132: astore 7
    //   1134: goto +198 -> 1332
    //   1137: astore_1
    //   1138: aconst_null
    //   1139: astore 4
    //   1141: aconst_null
    //   1142: astore_0
    //   1143: aconst_null
    //   1144: astore 5
    //   1146: aload 6
    //   1148: astore 7
    //   1150: aload 4
    //   1152: astore 8
    //   1154: aload_0
    //   1155: astore 9
    //   1157: ldc 29
    //   1159: iconst_1
    //   1160: ldc 232
    //   1162: aload_1
    //   1163: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1166: aload 6
    //   1168: ifnull +21 -> 1189
    //   1171: aload 6
    //   1173: invokevirtual 227	java/io/OutputStream:close	()V
    //   1176: goto +13 -> 1189
    //   1179: astore_1
    //   1180: ldc 29
    //   1182: iconst_1
    //   1183: ldc 230
    //   1185: aload_1
    //   1186: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1189: aload_0
    //   1190: ifnull +20 -> 1210
    //   1193: aload_0
    //   1194: invokevirtual 226	java/io/InputStream:close	()V
    //   1197: goto +13 -> 1210
    //   1200: astore_0
    //   1201: ldc 29
    //   1203: iconst_1
    //   1204: ldc 230
    //   1206: aload_0
    //   1207: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1210: aload 5
    //   1212: astore_0
    //   1213: aload 4
    //   1215: ifnull +110 -> 1325
    //   1218: aload 5
    //   1220: astore_0
    //   1221: aload 4
    //   1223: invokevirtual 228	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   1226: aload 5
    //   1228: areturn
    //   1229: astore_1
    //   1230: aconst_null
    //   1231: astore 4
    //   1233: aconst_null
    //   1234: astore_0
    //   1235: aconst_null
    //   1236: astore 5
    //   1238: aload 7
    //   1240: astore 6
    //   1242: aload 6
    //   1244: astore 7
    //   1246: aload 4
    //   1248: astore 8
    //   1250: aload_0
    //   1251: astore 9
    //   1253: ldc 29
    //   1255: iconst_1
    //   1256: ldc 234
    //   1258: aload_1
    //   1259: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1262: aload 6
    //   1264: ifnull +21 -> 1285
    //   1267: aload 6
    //   1269: invokevirtual 227	java/io/OutputStream:close	()V
    //   1272: goto +13 -> 1285
    //   1275: astore_1
    //   1276: ldc 29
    //   1278: iconst_1
    //   1279: ldc 230
    //   1281: aload_1
    //   1282: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1285: aload_0
    //   1286: ifnull +20 -> 1306
    //   1289: aload_0
    //   1290: invokevirtual 226	java/io/InputStream:close	()V
    //   1293: goto +13 -> 1306
    //   1296: astore_0
    //   1297: ldc 29
    //   1299: iconst_1
    //   1300: ldc 230
    //   1302: aload_0
    //   1303: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1306: aload 5
    //   1308: astore_0
    //   1309: aload 4
    //   1311: ifnull +14 -> 1325
    //   1314: aload 5
    //   1316: astore_0
    //   1317: aload 4
    //   1319: invokevirtual 228	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   1322: aload 5
    //   1324: astore_0
    //   1325: aload_0
    //   1326: areturn
    //   1327: astore_0
    //   1328: aload 8
    //   1330: astore 4
    //   1332: aload 7
    //   1334: ifnull +21 -> 1355
    //   1337: aload 7
    //   1339: invokevirtual 227	java/io/OutputStream:close	()V
    //   1342: goto +13 -> 1355
    //   1345: astore_1
    //   1346: ldc 29
    //   1348: iconst_1
    //   1349: ldc 230
    //   1351: aload_1
    //   1352: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1355: aload 9
    //   1357: ifnull +21 -> 1378
    //   1360: aload 9
    //   1362: invokevirtual 226	java/io/InputStream:close	()V
    //   1365: goto +13 -> 1378
    //   1368: astore_1
    //   1369: ldc 29
    //   1371: iconst_1
    //   1372: ldc 230
    //   1374: aload_1
    //   1375: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1378: aload 4
    //   1380: ifnull +21 -> 1401
    //   1383: aload 4
    //   1385: invokevirtual 228	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   1388: goto +13 -> 1401
    //   1391: astore_1
    //   1392: ldc 29
    //   1394: iconst_1
    //   1395: ldc 230
    //   1397: aload_1
    //   1398: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1401: goto +5 -> 1406
    //   1404: aload_0
    //   1405: athrow
    //   1406: goto -2 -> 1404
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1409	0	paramFile	File
    //   0	1409	1	paramString	String
    //   905	21	2	i	int
    //   189	2	3	bool	boolean
    //   20	1364	4	localObject1	Object
    //   7	1316	5	localObject2	Object
    //   1	1267	6	localObject3	Object
    //   4	1334	7	localObject4	Object
    //   10	1319	8	localObject5	Object
    //   62	1299	9	localObject6	Object
    //   220	767	10	localObject7	Object
    //   47	1042	11	localObject8	Object
    //   51	1046	12	localObject9	Object
    //   27	67	13	localEnumeration	java.util.Enumeration
    //   34	889	14	arrayOfByte	byte[]
    //   103	778	15	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   878	886	966	finally
    //   895	906	966	finally
    //   920	929	966	finally
    //   941	945	966	finally
    //   954	959	966	finally
    //   878	886	974	java/lang/OutOfMemoryError
    //   895	906	974	java/lang/OutOfMemoryError
    //   920	929	974	java/lang/OutOfMemoryError
    //   941	945	974	java/lang/OutOfMemoryError
    //   954	959	974	java/lang/OutOfMemoryError
    //   878	886	985	java/lang/Exception
    //   895	906	985	java/lang/Exception
    //   920	929	985	java/lang/Exception
    //   941	945	985	java/lang/Exception
    //   954	959	985	java/lang/Exception
    //   1025	1030	1033	java/lang/Exception
    //   1047	1051	1054	java/lang/Exception
    //   1067	1072	1075	java/lang/Exception
    //   1221	1226	1075	java/lang/Exception
    //   1317	1322	1075	java/lang/Exception
    //   64	74	1087	java/lang/OutOfMemoryError
    //   93	105	1087	java/lang/OutOfMemoryError
    //   124	137	1087	java/lang/OutOfMemoryError
    //   159	167	1087	java/lang/OutOfMemoryError
    //   186	190	1087	java/lang/OutOfMemoryError
    //   213	222	1087	java/lang/OutOfMemoryError
    //   241	249	1087	java/lang/OutOfMemoryError
    //   268	279	1087	java/lang/OutOfMemoryError
    //   298	309	1087	java/lang/OutOfMemoryError
    //   328	337	1087	java/lang/OutOfMemoryError
    //   356	363	1087	java/lang/OutOfMemoryError
    //   382	393	1087	java/lang/OutOfMemoryError
    //   412	433	1087	java/lang/OutOfMemoryError
    //   452	458	1087	java/lang/OutOfMemoryError
    //   477	486	1087	java/lang/OutOfMemoryError
    //   505	513	1087	java/lang/OutOfMemoryError
    //   532	540	1087	java/lang/OutOfMemoryError
    //   559	570	1087	java/lang/OutOfMemoryError
    //   589	602	1087	java/lang/OutOfMemoryError
    //   628	635	1087	java/lang/OutOfMemoryError
    //   654	663	1087	java/lang/OutOfMemoryError
    //   682	689	1087	java/lang/OutOfMemoryError
    //   708	719	1087	java/lang/OutOfMemoryError
    //   738	752	1087	java/lang/OutOfMemoryError
    //   771	780	1087	java/lang/OutOfMemoryError
    //   799	807	1087	java/lang/OutOfMemoryError
    //   826	832	1087	java/lang/OutOfMemoryError
    //   851	869	1087	java/lang/OutOfMemoryError
    //   1015	1020	1087	java/lang/OutOfMemoryError
    //   64	74	1095	java/lang/Exception
    //   93	105	1095	java/lang/Exception
    //   124	137	1095	java/lang/Exception
    //   159	167	1095	java/lang/Exception
    //   186	190	1095	java/lang/Exception
    //   213	222	1095	java/lang/Exception
    //   241	249	1095	java/lang/Exception
    //   268	279	1095	java/lang/Exception
    //   298	309	1095	java/lang/Exception
    //   328	337	1095	java/lang/Exception
    //   356	363	1095	java/lang/Exception
    //   382	393	1095	java/lang/Exception
    //   412	433	1095	java/lang/Exception
    //   452	458	1095	java/lang/Exception
    //   477	486	1095	java/lang/Exception
    //   505	513	1095	java/lang/Exception
    //   532	540	1095	java/lang/Exception
    //   559	570	1095	java/lang/Exception
    //   589	602	1095	java/lang/Exception
    //   628	635	1095	java/lang/Exception
    //   654	663	1095	java/lang/Exception
    //   682	689	1095	java/lang/Exception
    //   708	719	1095	java/lang/Exception
    //   738	752	1095	java/lang/Exception
    //   771	780	1095	java/lang/Exception
    //   799	807	1095	java/lang/Exception
    //   826	832	1095	java/lang/Exception
    //   851	869	1095	java/lang/Exception
    //   1015	1020	1095	java/lang/Exception
    //   22	36	1103	finally
    //   22	36	1114	java/lang/OutOfMemoryError
    //   22	36	1118	java/lang/Exception
    //   12	22	1122	finally
    //   12	22	1137	java/lang/OutOfMemoryError
    //   1171	1176	1179	java/lang/Exception
    //   1193	1197	1200	java/lang/Exception
    //   12	22	1229	java/lang/Exception
    //   1267	1272	1275	java/lang/Exception
    //   1289	1293	1296	java/lang/Exception
    //   64	74	1327	finally
    //   93	105	1327	finally
    //   124	137	1327	finally
    //   159	167	1327	finally
    //   186	190	1327	finally
    //   213	222	1327	finally
    //   241	249	1327	finally
    //   268	279	1327	finally
    //   298	309	1327	finally
    //   328	337	1327	finally
    //   356	363	1327	finally
    //   382	393	1327	finally
    //   412	433	1327	finally
    //   452	458	1327	finally
    //   477	486	1327	finally
    //   505	513	1327	finally
    //   532	540	1327	finally
    //   559	570	1327	finally
    //   589	602	1327	finally
    //   628	635	1327	finally
    //   654	663	1327	finally
    //   682	689	1327	finally
    //   708	719	1327	finally
    //   738	752	1327	finally
    //   771	780	1327	finally
    //   799	807	1327	finally
    //   826	832	1327	finally
    //   851	869	1327	finally
    //   1015	1020	1327	finally
    //   1157	1166	1327	finally
    //   1253	1262	1327	finally
    //   1337	1342	1345	java/lang/Exception
    //   1360	1365	1368	java/lang/Exception
    //   1383	1388	1391	java/lang/Exception
  }
  
  public static JSONObject a(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean, CallBacker paramCallBacker)
  {
    if (paramAppRuntime == null)
    {
      paramCallBacker = new StringBuilder();
      paramCallBacker.append("getJSONFromLocal, app == null; scid:");
      paramCallBacker.append(paramString);
      paramCallBacker.append(", app=");
      paramCallBacker.append(paramAppRuntime);
      QLog.e("VasUpdateUtil", 1, paramCallBacker.toString());
      return null;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramAppRuntime.getApplication().getFilesDir());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    File localFile = new File((String)localObject);
    if (localFile.exists()) {
      try
      {
        JSONObject localJSONObject = new JSONObject(FileUtils.readFileContent(localFile));
        return localJSONObject;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getJsonOOM,json_name:");
          localStringBuilder.append(paramString);
          QLog.e("VasUpdateUtil", 2, localStringBuilder.toString(), localThrowable);
        }
        localFile.delete();
      }
    }
    if (paramBoolean) {
      ((IVasQuickUpdateAdapter)QRoute.api(IVasQuickUpdateAdapter.class)).downloadItem(paramAppRuntime, 1000L, paramString, (String)localObject, paramCallBacker);
    }
    return null;
  }
  
  public static boolean a()
  {
    return ((IVasQuickUpdateAdapter)QRoute.api(IVasQuickUpdateAdapter.class)).isPobingUpdateEnable();
  }
  
  public static boolean a(File paramFile)
  {
    return a(paramFile, "");
  }
  
  public static boolean a(File paramFile, String paramString)
  {
    if (!paramFile.exists()) {
      return true;
    }
    if (paramFile.isDirectory())
    {
      localObject = paramFile.listFiles();
      if (localObject != null)
      {
        int i = 0;
        while (i < localObject.length)
        {
          a(localObject[i], paramString);
          i += 1;
        }
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramFile.getParent());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    paramString = new File(((StringBuilder)localObject).toString());
    paramFile.renameTo(paramString);
    return paramString.delete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil
 * JD-Core Version:    0.7.0.1
 */