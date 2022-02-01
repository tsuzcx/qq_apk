package com.tencent.mobileqq.vas.updatesystem;

import android.text.TextUtils;
import com.google.gson.stream.JsonReader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback;
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
      QLog.e("VasUpdateUtil", 1, "getJSONFromLocalByStreamRead, app == null; scid:" + paramString + ", app=" + paramAppRuntime);
      return null;
    }
    String str = paramAppRuntime.getApplication().getFilesDir() + File.separator + paramString;
    File localFile = new File(str);
    if (localFile.exists()) {
      try
      {
        JsonReader localJsonReader = new JsonReader(new FileReader(localFile));
        return localJsonReader;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VasUpdateUtil", 2, "getJSONFromLocalByStreamRead error,json_name:" + paramString, localThrowable);
        }
        localFile.delete();
      }
    }
    if (paramBoolean) {
      ((IVasQuickUpdateAdapter)QRoute.api(IVasQuickUpdateAdapter.class)).downloadItem(paramAppRuntime, 1000L, paramString, str, paramCallBacker);
    }
    return null;
  }
  
  public static TagItemInfo a(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasUpdateUtil", 2, "getItemInfo bid = " + paramLong + " scid = " + paramString);
    }
    BaseUpdateCallback localBaseUpdateCallback = UpdateCallbackSelector.getCallback(paramLong);
    if (localBaseUpdateCallback == null) {
      return null;
    }
    return localBaseUpdateCallback.getItemInfo(paramLong, paramString);
  }
  
  public static File a(AppRuntime paramAppRuntime, long paramLong, String paramString1, String paramString2, boolean paramBoolean, CallBacker paramCallBacker)
  {
    if ((TextUtils.isEmpty(paramString2)) && (paramAppRuntime != null)) {
      paramString2 = paramAppRuntime.getApplication().getFilesDir() + File.separator + paramString1;
    }
    for (;;)
    {
      if (TextUtils.isEmpty(paramString2))
      {
        QLog.e("VasUpdateUtil", 1, "getFileFromLocal err filePath, bid=" + paramLong + ",scid:" + paramString1 + ", app=" + paramAppRuntime + ", filePaht=" + paramString2);
        return null;
      }
      File localFile2 = new File(paramString2);
      File localFile1 = localFile2;
      if (!localFile2.exists())
      {
        if (paramBoolean) {
          ((IVasQuickUpdateAdapter)QRoute.api(IVasQuickUpdateAdapter.class)).downloadItem(paramAppRuntime, paramLong, paramString1, paramString2, paramCallBacker);
        }
        localFile1 = null;
      }
      return localFile1;
    }
  }
  
  /* Error */
  public static String a(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 141	com/tencent/commonsdk/zip/QZipFile
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 142	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/io/File;)V
    //   10: astore 6
    //   12: aload 6
    //   14: invokevirtual 146	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   17: astore 10
    //   19: sipush 8192
    //   22: newarray byte
    //   24: astore 11
    //   26: aconst_null
    //   27: astore 4
    //   29: aconst_null
    //   30: astore 5
    //   32: aload 6
    //   34: astore 9
    //   36: aload 4
    //   38: astore 8
    //   40: aload 5
    //   42: astore 7
    //   44: aload 10
    //   46: invokeinterface 151 1 0
    //   51: ifeq +525 -> 576
    //   54: aload 6
    //   56: astore 9
    //   58: aload 4
    //   60: astore 8
    //   62: aload 5
    //   64: astore 7
    //   66: aload 10
    //   68: invokeinterface 155 1 0
    //   73: checkcast 157	java/util/zip/ZipEntry
    //   76: astore 12
    //   78: aload 6
    //   80: astore 9
    //   82: aload 4
    //   84: astore 8
    //   86: aload 5
    //   88: astore 7
    //   90: aload 12
    //   92: invokevirtual 160	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   95: ldc 162
    //   97: invokevirtual 167	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   100: ifne -68 -> 32
    //   103: aload 6
    //   105: astore 9
    //   107: aload 4
    //   109: astore 8
    //   111: aload 5
    //   113: astore 7
    //   115: aload 12
    //   117: invokevirtual 170	java/util/zip/ZipEntry:isDirectory	()Z
    //   120: ifeq +195 -> 315
    //   123: aload 6
    //   125: astore 9
    //   127: aload 4
    //   129: astore 8
    //   131: aload 5
    //   133: astore 7
    //   135: invokestatic 173	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   138: ifeq +44 -> 182
    //   141: aload 6
    //   143: astore 9
    //   145: aload 4
    //   147: astore 8
    //   149: aload 5
    //   151: astore 7
    //   153: ldc 175
    //   155: iconst_4
    //   156: new 17	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   163: ldc 177
    //   165: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload 12
    //   170: invokevirtual 160	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   173: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   182: aload 6
    //   184: astore 9
    //   186: aload 4
    //   188: astore 8
    //   190: aload 5
    //   192: astore 7
    //   194: new 164	java/lang/String
    //   197: dup
    //   198: new 17	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   205: aload_1
    //   206: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload 12
    //   211: invokevirtual 160	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   214: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: ldc 179
    //   222: invokevirtual 183	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   225: ldc 185
    //   227: invokespecial 188	java/lang/String:<init>	([BLjava/lang/String;)V
    //   230: astore_0
    //   231: aload 6
    //   233: astore 9
    //   235: aload 4
    //   237: astore 8
    //   239: aload 5
    //   241: astore 7
    //   243: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   246: ifeq +40 -> 286
    //   249: aload 6
    //   251: astore 9
    //   253: aload 4
    //   255: astore 8
    //   257: aload 5
    //   259: astore 7
    //   261: ldc 175
    //   263: iconst_2
    //   264: new 17	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   271: ldc 190
    //   273: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload_0
    //   277: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   286: aload 6
    //   288: astore 9
    //   290: aload 4
    //   292: astore 8
    //   294: aload 5
    //   296: astore 7
    //   298: new 53	java/io/File
    //   301: dup
    //   302: aload_0
    //   303: invokespecial 60	java/io/File:<init>	(Ljava/lang/String;)V
    //   306: invokevirtual 193	java/io/File:mkdir	()Z
    //   309: pop
    //   310: aload_0
    //   311: astore_3
    //   312: goto -280 -> 32
    //   315: aload 6
    //   317: astore 9
    //   319: aload 4
    //   321: astore 8
    //   323: aload 5
    //   325: astore 7
    //   327: aload 12
    //   329: invokevirtual 160	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   332: astore_0
    //   333: aload 6
    //   335: astore 9
    //   337: aload 4
    //   339: astore 8
    //   341: aload 5
    //   343: astore 7
    //   345: new 53	java/io/File
    //   348: dup
    //   349: new 17	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   356: aload_1
    //   357: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: aload 12
    //   362: invokevirtual 160	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   365: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: invokespecial 60	java/io/File:<init>	(Ljava/lang/String;)V
    //   374: astore_3
    //   375: aload 6
    //   377: astore 9
    //   379: aload 4
    //   381: astore 8
    //   383: aload 5
    //   385: astore 7
    //   387: aload_3
    //   388: invokevirtual 196	java/io/File:getParentFile	()Ljava/io/File;
    //   391: invokevirtual 199	java/io/File:mkdirs	()Z
    //   394: pop
    //   395: aload 6
    //   397: astore 9
    //   399: aload 4
    //   401: astore 8
    //   403: aload 5
    //   405: astore 7
    //   407: aload_3
    //   408: invokevirtual 64	java/io/File:exists	()Z
    //   411: ifeq +20 -> 431
    //   414: aload 6
    //   416: astore 9
    //   418: aload 4
    //   420: astore 8
    //   422: aload 5
    //   424: astore 7
    //   426: aload_3
    //   427: invokevirtual 85	java/io/File:delete	()Z
    //   430: pop
    //   431: aload 6
    //   433: astore 9
    //   435: aload 4
    //   437: astore 8
    //   439: aload 5
    //   441: astore 7
    //   443: new 201	java/io/BufferedOutputStream
    //   446: dup
    //   447: new 203	java/io/FileOutputStream
    //   450: dup
    //   451: aload_3
    //   452: invokespecial 204	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   455: invokespecial 207	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   458: astore_3
    //   459: aload 6
    //   461: aload 12
    //   463: invokevirtual 211	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   466: astore 5
    //   468: aload 5
    //   470: aload 11
    //   472: iconst_0
    //   473: sipush 8192
    //   476: invokevirtual 217	java/io/InputStream:read	([BII)I
    //   479: istore_2
    //   480: iload_2
    //   481: iconst_m1
    //   482: if_icmpeq +73 -> 555
    //   485: aload_3
    //   486: aload 11
    //   488: iconst_0
    //   489: iload_2
    //   490: invokevirtual 223	java/io/OutputStream:write	([BII)V
    //   493: goto -25 -> 468
    //   496: astore_1
    //   497: aload 5
    //   499: astore 4
    //   501: aload 6
    //   503: astore 9
    //   505: aload 4
    //   507: astore 8
    //   509: aload_3
    //   510: astore 7
    //   512: ldc 15
    //   514: iconst_1
    //   515: ldc 225
    //   517: aload_1
    //   518: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   521: aload_3
    //   522: ifnull +7 -> 529
    //   525: aload_3
    //   526: invokevirtual 228	java/io/OutputStream:close	()V
    //   529: aload 4
    //   531: ifnull +8 -> 539
    //   534: aload 4
    //   536: invokevirtual 229	java/io/InputStream:close	()V
    //   539: aload_0
    //   540: astore_1
    //   541: aload 6
    //   543: ifnull +10 -> 553
    //   546: aload 6
    //   548: invokevirtual 230	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   551: aload_0
    //   552: astore_1
    //   553: aload_1
    //   554: areturn
    //   555: aload 5
    //   557: invokevirtual 229	java/io/InputStream:close	()V
    //   560: aload_3
    //   561: invokevirtual 228	java/io/OutputStream:close	()V
    //   564: aload 5
    //   566: astore 4
    //   568: aload_3
    //   569: astore 5
    //   571: aload_0
    //   572: astore_3
    //   573: goto -541 -> 32
    //   576: aload 6
    //   578: astore 9
    //   580: aload 4
    //   582: astore 8
    //   584: aload 5
    //   586: astore 7
    //   588: aload 6
    //   590: invokevirtual 230	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   593: aload 5
    //   595: ifnull +8 -> 603
    //   598: aload 5
    //   600: invokevirtual 228	java/io/OutputStream:close	()V
    //   603: aload 4
    //   605: ifnull +8 -> 613
    //   608: aload 4
    //   610: invokevirtual 229	java/io/InputStream:close	()V
    //   613: aload 6
    //   615: ifnull +389 -> 1004
    //   618: aload 6
    //   620: invokevirtual 230	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   623: aload_3
    //   624: areturn
    //   625: astore_0
    //   626: ldc 15
    //   628: iconst_1
    //   629: ldc 232
    //   631: aload_0
    //   632: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   635: goto -32 -> 603
    //   638: astore_0
    //   639: ldc 15
    //   641: iconst_1
    //   642: ldc 232
    //   644: aload_0
    //   645: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   648: goto -35 -> 613
    //   651: astore_0
    //   652: ldc 15
    //   654: iconst_1
    //   655: ldc 232
    //   657: aload_0
    //   658: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   661: aload_3
    //   662: areturn
    //   663: astore_1
    //   664: ldc 15
    //   666: iconst_1
    //   667: ldc 232
    //   669: aload_1
    //   670: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   673: goto -144 -> 529
    //   676: astore_1
    //   677: ldc 15
    //   679: iconst_1
    //   680: ldc 232
    //   682: aload_1
    //   683: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   686: goto -147 -> 539
    //   689: astore_1
    //   690: ldc 15
    //   692: iconst_1
    //   693: ldc 232
    //   695: aload_1
    //   696: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   699: aload_0
    //   700: areturn
    //   701: astore_1
    //   702: aconst_null
    //   703: astore 6
    //   705: aconst_null
    //   706: astore 4
    //   708: aconst_null
    //   709: astore_3
    //   710: aconst_null
    //   711: astore_0
    //   712: aload 6
    //   714: astore 9
    //   716: aload 4
    //   718: astore 8
    //   720: aload_3
    //   721: astore 7
    //   723: ldc 15
    //   725: iconst_1
    //   726: ldc 234
    //   728: aload_1
    //   729: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   732: aload_3
    //   733: ifnull +7 -> 740
    //   736: aload_3
    //   737: invokevirtual 228	java/io/OutputStream:close	()V
    //   740: aload 4
    //   742: ifnull +8 -> 750
    //   745: aload 4
    //   747: invokevirtual 229	java/io/InputStream:close	()V
    //   750: aload_0
    //   751: astore_1
    //   752: aload 6
    //   754: ifnull -201 -> 553
    //   757: aload 6
    //   759: invokevirtual 230	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   762: aload_0
    //   763: areturn
    //   764: astore_1
    //   765: ldc 15
    //   767: iconst_1
    //   768: ldc 232
    //   770: aload_1
    //   771: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   774: aload_0
    //   775: areturn
    //   776: astore_1
    //   777: ldc 15
    //   779: iconst_1
    //   780: ldc 232
    //   782: aload_1
    //   783: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   786: goto -46 -> 740
    //   789: astore_1
    //   790: ldc 15
    //   792: iconst_1
    //   793: ldc 232
    //   795: aload_1
    //   796: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   799: goto -49 -> 750
    //   802: astore_0
    //   803: aconst_null
    //   804: astore 6
    //   806: aconst_null
    //   807: astore 4
    //   809: aconst_null
    //   810: astore_1
    //   811: aload_1
    //   812: ifnull +7 -> 819
    //   815: aload_1
    //   816: invokevirtual 228	java/io/OutputStream:close	()V
    //   819: aload 4
    //   821: ifnull +8 -> 829
    //   824: aload 4
    //   826: invokevirtual 229	java/io/InputStream:close	()V
    //   829: aload 6
    //   831: ifnull +8 -> 839
    //   834: aload 6
    //   836: invokevirtual 230	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   839: aload_0
    //   840: athrow
    //   841: astore_1
    //   842: ldc 15
    //   844: iconst_1
    //   845: ldc 232
    //   847: aload_1
    //   848: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   851: goto -32 -> 819
    //   854: astore_1
    //   855: ldc 15
    //   857: iconst_1
    //   858: ldc 232
    //   860: aload_1
    //   861: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   864: goto -35 -> 829
    //   867: astore_1
    //   868: ldc 15
    //   870: iconst_1
    //   871: ldc 232
    //   873: aload_1
    //   874: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   877: goto -38 -> 839
    //   880: astore_0
    //   881: aconst_null
    //   882: astore 4
    //   884: aconst_null
    //   885: astore_1
    //   886: goto -75 -> 811
    //   889: astore_0
    //   890: aload 5
    //   892: astore 4
    //   894: aload_3
    //   895: astore_1
    //   896: goto -85 -> 811
    //   899: astore_0
    //   900: aload 9
    //   902: astore 6
    //   904: aload 8
    //   906: astore 4
    //   908: aload 7
    //   910: astore_1
    //   911: goto -100 -> 811
    //   914: astore_0
    //   915: aload_3
    //   916: astore_1
    //   917: goto -106 -> 811
    //   920: astore_1
    //   921: aconst_null
    //   922: astore 4
    //   924: aconst_null
    //   925: astore_3
    //   926: aconst_null
    //   927: astore_0
    //   928: goto -216 -> 712
    //   931: astore_1
    //   932: aload 5
    //   934: astore 4
    //   936: goto -224 -> 712
    //   939: astore_1
    //   940: aload_3
    //   941: astore_0
    //   942: aload 5
    //   944: astore_3
    //   945: goto -233 -> 712
    //   948: astore_1
    //   949: aload 5
    //   951: astore_3
    //   952: goto -240 -> 712
    //   955: astore_1
    //   956: goto -244 -> 712
    //   959: astore_1
    //   960: aconst_null
    //   961: astore 6
    //   963: aconst_null
    //   964: astore 4
    //   966: aconst_null
    //   967: astore_3
    //   968: aconst_null
    //   969: astore_0
    //   970: goto -469 -> 501
    //   973: astore_1
    //   974: aconst_null
    //   975: astore 4
    //   977: aconst_null
    //   978: astore_3
    //   979: aconst_null
    //   980: astore_0
    //   981: goto -480 -> 501
    //   984: astore_1
    //   985: aload_3
    //   986: astore_0
    //   987: aload 5
    //   989: astore_3
    //   990: goto -489 -> 501
    //   993: astore_1
    //   994: aload 5
    //   996: astore_3
    //   997: goto -496 -> 501
    //   1000: astore_1
    //   1001: goto -500 -> 501
    //   1004: aload_3
    //   1005: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1006	0	paramFile	File
    //   0	1006	1	paramString	String
    //   479	11	2	i	int
    //   1	1004	3	localObject1	Object
    //   27	949	4	localObject2	Object
    //   30	965	5	localObject3	Object
    //   10	952	6	localObject4	Object
    //   42	867	7	localObject5	Object
    //   38	867	8	localObject6	Object
    //   34	867	9	localObject7	Object
    //   17	50	10	localEnumeration	java.util.Enumeration
    //   24	463	11	arrayOfByte	byte[]
    //   76	386	12	localZipEntry	java.util.zip.ZipEntry
    // Exception table:
    //   from	to	target	type
    //   468	480	496	java/lang/Exception
    //   485	493	496	java/lang/Exception
    //   555	564	496	java/lang/Exception
    //   598	603	625	java/lang/Exception
    //   608	613	638	java/lang/Exception
    //   618	623	651	java/lang/Exception
    //   525	529	663	java/lang/Exception
    //   534	539	676	java/lang/Exception
    //   546	551	689	java/lang/Exception
    //   2	12	701	java/lang/OutOfMemoryError
    //   757	762	764	java/lang/Exception
    //   736	740	776	java/lang/Exception
    //   745	750	789	java/lang/Exception
    //   2	12	802	finally
    //   815	819	841	java/lang/Exception
    //   824	829	854	java/lang/Exception
    //   834	839	867	java/lang/Exception
    //   12	26	880	finally
    //   468	480	889	finally
    //   485	493	889	finally
    //   555	564	889	finally
    //   44	54	899	finally
    //   66	78	899	finally
    //   90	103	899	finally
    //   115	123	899	finally
    //   135	141	899	finally
    //   153	182	899	finally
    //   194	231	899	finally
    //   243	249	899	finally
    //   261	286	899	finally
    //   298	310	899	finally
    //   327	333	899	finally
    //   345	375	899	finally
    //   387	395	899	finally
    //   407	414	899	finally
    //   426	431	899	finally
    //   443	459	899	finally
    //   512	521	899	finally
    //   588	593	899	finally
    //   723	732	899	finally
    //   459	468	914	finally
    //   12	26	920	java/lang/OutOfMemoryError
    //   468	480	931	java/lang/OutOfMemoryError
    //   485	493	931	java/lang/OutOfMemoryError
    //   555	564	931	java/lang/OutOfMemoryError
    //   44	54	939	java/lang/OutOfMemoryError
    //   66	78	939	java/lang/OutOfMemoryError
    //   90	103	939	java/lang/OutOfMemoryError
    //   115	123	939	java/lang/OutOfMemoryError
    //   135	141	939	java/lang/OutOfMemoryError
    //   153	182	939	java/lang/OutOfMemoryError
    //   194	231	939	java/lang/OutOfMemoryError
    //   243	249	939	java/lang/OutOfMemoryError
    //   261	286	939	java/lang/OutOfMemoryError
    //   298	310	939	java/lang/OutOfMemoryError
    //   327	333	939	java/lang/OutOfMemoryError
    //   588	593	939	java/lang/OutOfMemoryError
    //   345	375	948	java/lang/OutOfMemoryError
    //   387	395	948	java/lang/OutOfMemoryError
    //   407	414	948	java/lang/OutOfMemoryError
    //   426	431	948	java/lang/OutOfMemoryError
    //   443	459	948	java/lang/OutOfMemoryError
    //   459	468	955	java/lang/OutOfMemoryError
    //   2	12	959	java/lang/Exception
    //   12	26	973	java/lang/Exception
    //   44	54	984	java/lang/Exception
    //   66	78	984	java/lang/Exception
    //   90	103	984	java/lang/Exception
    //   115	123	984	java/lang/Exception
    //   135	141	984	java/lang/Exception
    //   153	182	984	java/lang/Exception
    //   194	231	984	java/lang/Exception
    //   243	249	984	java/lang/Exception
    //   261	286	984	java/lang/Exception
    //   298	310	984	java/lang/Exception
    //   327	333	984	java/lang/Exception
    //   588	593	984	java/lang/Exception
    //   345	375	993	java/lang/Exception
    //   387	395	993	java/lang/Exception
    //   407	414	993	java/lang/Exception
    //   426	431	993	java/lang/Exception
    //   443	459	993	java/lang/Exception
    //   459	468	1000	java/lang/Exception
  }
  
  public static JSONObject a(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean, CallBacker paramCallBacker)
  {
    if (paramAppRuntime == null)
    {
      QLog.e("VasUpdateUtil", 1, "getJSONFromLocal, app == null; scid:" + paramString + ", app=" + paramAppRuntime);
      return null;
    }
    String str = paramAppRuntime.getApplication().getFilesDir() + File.separator + paramString;
    File localFile = new File(str);
    if (localFile.exists()) {
      try
      {
        JSONObject localJSONObject = new JSONObject(FileUtils.a(localFile));
        return localJSONObject;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VasUpdateUtil", 2, "getJsonOOM,json_name:" + paramString, localThrowable);
        }
        localFile.delete();
      }
    }
    if (paramBoolean) {
      ((IVasQuickUpdateAdapter)QRoute.api(IVasQuickUpdateAdapter.class)).downloadItem(paramAppRuntime, 1000L, paramString, str, paramCallBacker);
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
      File[] arrayOfFile = paramFile.listFiles();
      if (arrayOfFile != null)
      {
        int i = 0;
        while (i < arrayOfFile.length)
        {
          a(arrayOfFile[i], paramString);
          i += 1;
        }
      }
    }
    paramString = new File(paramFile.getParent() + File.separator + paramString + System.currentTimeMillis());
    paramFile.renameTo(paramString);
    return paramString.delete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil
 * JD-Core Version:    0.7.0.1
 */