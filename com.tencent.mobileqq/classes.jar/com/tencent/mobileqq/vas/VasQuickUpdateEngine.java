package com.tencent.mobileqq.vas;

import androidx.annotation.Keep;
import bhyw;
import bhza;
import bici;
import bics;
import bidp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class VasQuickUpdateEngine
  implements bidp
{
  public static final String ENGINE_CONFIG_PATH = BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath() + File.separator + "quickupdate";
  private static final String TAG = "VasQuickUpdateEngine";
  private static final String TAG_NATIVE = "VasQuickUpdateEngine_Native";
  private static VasQuickUpdateEngine mInstance;
  public WeakReference<VasExtensionHandler> mWeakHandler;
  ArrayList<VasQuickUpdateEngine.PendingTask> pendingTasks = new ArrayList();
  
  public static byte[] alloc(int paramInt)
  {
    try
    {
      byte[] arrayOfByte = new byte[paramInt];
      return arrayOfByte;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return null;
  }
  
  private static QQAppInterface getApp()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null) {}
    for (localObject = ((BaseApplicationImpl)localObject).getRuntime();; localObject = null) {
      return (QQAppInterface)localObject;
    }
  }
  
  public static VasQuickUpdateEngine getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new VasQuickUpdateEngine();
      }
      VasQuickUpdateEngine localVasQuickUpdateEngine = mInstance;
      return localVasQuickUpdateEngine;
    }
    finally {}
  }
  
  public static VasQuickUpdateEngine.TagItemInfo getItemInfo(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "getItemInfo bid = " + paramLong + " scid = " + paramString);
    }
    bici localbici = bics.a(paramLong);
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface == null) {
      QLog.e("VasQuickUpdateEngine", 1, "getItemInfo: get null app " + paramString);
    }
    if (localbici == null) {
      return null;
    }
    return localbici.getItemInfo(localQQAppInterface, paramLong, paramString);
  }
  
  @Keep
  public static void quickUpdateLog(int paramInt, byte[] paramArrayOfByte)
  {
    do
    {
      do
      {
        do
        {
          try
          {
            paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
            switch (paramInt)
            {
            default: 
              if (QLog.isColorLevel()) {
                QLog.d("VasQuickUpdateEngine_Native", 2, paramArrayOfByte);
              }
              return;
            }
          }
          catch (Throwable paramArrayOfByte)
          {
            QLog.e("VasQuickUpdateEngine_Native", 1, "Couldn't convert the jbyteArray to jstring", paramArrayOfByte);
            return;
          }
          QLog.e("VasQuickUpdateEngine_Native", 1, paramArrayOfByte);
          return;
        } while (!QLog.isColorLevel());
        QLog.w("VasQuickUpdateEngine_Native", 2, paramArrayOfByte);
        return;
      } while (!QLog.isColorLevel());
      QLog.i("VasQuickUpdateEngine_Native", 2, paramArrayOfByte);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("VasQuickUpdateEngine_Native", 2, paramArrayOfByte);
  }
  
  public static boolean safeDeleteFile(File paramFile)
  {
    return safeDeleteFile(paramFile, "");
  }
  
  public static boolean safeDeleteFile(File paramFile, String paramString)
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
          safeDeleteFile(arrayOfFile[i], paramString);
          i += 1;
        }
      }
    }
    paramString = new File(paramFile.getParent() + File.separator + paramString + System.currentTimeMillis());
    paramFile.renameTo(paramString);
    return paramString.delete();
  }
  
  /* Error */
  public static String unZipFile(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 185	com/tencent/commonsdk/zip/QZipFile
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 188	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/io/File;)V
    //   10: astore 6
    //   12: aload 6
    //   14: invokevirtual 192	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
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
    //   46: invokeinterface 197 1 0
    //   51: ifeq +526 -> 577
    //   54: aload 6
    //   56: astore 9
    //   58: aload 4
    //   60: astore 8
    //   62: aload 5
    //   64: astore 7
    //   66: aload 10
    //   68: invokeinterface 201 1 0
    //   73: checkcast 203	java/util/zip/ZipEntry
    //   76: astore 12
    //   78: aload 6
    //   80: astore 9
    //   82: aload 4
    //   84: astore 8
    //   86: aload 5
    //   88: astore 7
    //   90: aload 12
    //   92: invokevirtual 206	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   95: ldc 208
    //   97: invokevirtual 212	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   100: ifne -68 -> 32
    //   103: aload 6
    //   105: astore 9
    //   107: aload 4
    //   109: astore 8
    //   111: aload 5
    //   113: astore 7
    //   115: aload 12
    //   117: invokevirtual 213	java/util/zip/ZipEntry:isDirectory	()Z
    //   120: ifeq +195 -> 315
    //   123: aload 6
    //   125: astore 9
    //   127: aload 4
    //   129: astore 8
    //   131: aload 5
    //   133: astore 7
    //   135: invokestatic 216	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   138: ifeq +44 -> 182
    //   141: aload 6
    //   143: astore 9
    //   145: aload 4
    //   147: astore 8
    //   149: aload 5
    //   151: astore 7
    //   153: ldc 218
    //   155: iconst_4
    //   156: new 26	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   163: ldc 220
    //   165: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload 12
    //   170: invokevirtual 206	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   173: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   182: aload 6
    //   184: astore 9
    //   186: aload 4
    //   188: astore 8
    //   190: aload 5
    //   192: astore 7
    //   194: new 127	java/lang/String
    //   197: dup
    //   198: new 26	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   205: aload_1
    //   206: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload 12
    //   211: invokevirtual 206	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   214: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: ldc 222
    //   222: invokevirtual 226	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   225: ldc 228
    //   227: invokespecial 132	java/lang/String:<init>	([BLjava/lang/String;)V
    //   230: astore_0
    //   231: aload 6
    //   233: astore 9
    //   235: aload 4
    //   237: astore 8
    //   239: aload 5
    //   241: astore 7
    //   243: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   246: ifeq +40 -> 286
    //   249: aload 6
    //   251: astore 9
    //   253: aload 4
    //   255: astore 8
    //   257: aload 5
    //   259: astore 7
    //   261: ldc 218
    //   263: iconst_2
    //   264: new 26	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   271: ldc 230
    //   273: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload_0
    //   277: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   286: aload 6
    //   288: astore 9
    //   290: aload 4
    //   292: astore 8
    //   294: aload 5
    //   296: astore 7
    //   298: new 41	java/io/File
    //   301: dup
    //   302: aload_0
    //   303: invokespecial 173	java/io/File:<init>	(Ljava/lang/String;)V
    //   306: invokevirtual 233	java/io/File:mkdir	()Z
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
    //   329: invokevirtual 206	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   332: astore_0
    //   333: aload 6
    //   335: astore 9
    //   337: aload 4
    //   339: astore 8
    //   341: aload 5
    //   343: astore 7
    //   345: new 41	java/io/File
    //   348: dup
    //   349: new 26	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   356: aload_1
    //   357: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: aload 12
    //   362: invokevirtual 206	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   365: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: invokespecial 173	java/io/File:<init>	(Ljava/lang/String;)V
    //   374: astore_3
    //   375: aload 6
    //   377: astore 9
    //   379: aload 4
    //   381: astore 8
    //   383: aload 5
    //   385: astore 7
    //   387: aload_3
    //   388: invokevirtual 236	java/io/File:getParentFile	()Ljava/io/File;
    //   391: invokevirtual 239	java/io/File:mkdirs	()Z
    //   394: pop
    //   395: aload 6
    //   397: astore 9
    //   399: aload 4
    //   401: astore 8
    //   403: aload 5
    //   405: astore 7
    //   407: aload_3
    //   408: invokevirtual 154	java/io/File:exists	()Z
    //   411: ifeq +20 -> 431
    //   414: aload 6
    //   416: astore 9
    //   418: aload 4
    //   420: astore 8
    //   422: aload 5
    //   424: astore 7
    //   426: aload_3
    //   427: invokevirtual 179	java/io/File:delete	()Z
    //   430: pop
    //   431: aload 6
    //   433: astore 9
    //   435: aload 4
    //   437: astore 8
    //   439: aload 5
    //   441: astore 7
    //   443: new 241	java/io/BufferedOutputStream
    //   446: dup
    //   447: new 243	java/io/FileOutputStream
    //   450: dup
    //   451: aload_3
    //   452: invokespecial 244	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   455: invokespecial 247	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   458: astore_3
    //   459: aload 6
    //   461: aload 12
    //   463: invokevirtual 251	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   466: astore 5
    //   468: aload 5
    //   470: aload 11
    //   472: iconst_0
    //   473: sipush 8192
    //   476: invokevirtual 257	java/io/InputStream:read	([BII)I
    //   479: istore_2
    //   480: iload_2
    //   481: iconst_m1
    //   482: if_icmpeq +74 -> 556
    //   485: aload_3
    //   486: aload 11
    //   488: iconst_0
    //   489: iload_2
    //   490: invokevirtual 263	java/io/OutputStream:write	([BII)V
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
    //   512: ldc 11
    //   514: iconst_1
    //   515: ldc_w 265
    //   518: aload_1
    //   519: invokestatic 137	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   522: aload_3
    //   523: ifnull +7 -> 530
    //   526: aload_3
    //   527: invokevirtual 268	java/io/OutputStream:close	()V
    //   530: aload 4
    //   532: ifnull +8 -> 540
    //   535: aload 4
    //   537: invokevirtual 269	java/io/InputStream:close	()V
    //   540: aload_0
    //   541: astore_1
    //   542: aload 6
    //   544: ifnull +10 -> 554
    //   547: aload 6
    //   549: invokevirtual 270	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   552: aload_0
    //   553: astore_1
    //   554: aload_1
    //   555: areturn
    //   556: aload 5
    //   558: invokevirtual 269	java/io/InputStream:close	()V
    //   561: aload_3
    //   562: invokevirtual 268	java/io/OutputStream:close	()V
    //   565: aload 5
    //   567: astore 4
    //   569: aload_3
    //   570: astore 5
    //   572: aload_0
    //   573: astore_3
    //   574: goto -542 -> 32
    //   577: aload 6
    //   579: astore 9
    //   581: aload 4
    //   583: astore 8
    //   585: aload 5
    //   587: astore 7
    //   589: aload 6
    //   591: invokevirtual 270	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   594: aload 5
    //   596: ifnull +8 -> 604
    //   599: aload 5
    //   601: invokevirtual 268	java/io/OutputStream:close	()V
    //   604: aload 4
    //   606: ifnull +8 -> 614
    //   609: aload 4
    //   611: invokevirtual 269	java/io/InputStream:close	()V
    //   614: aload 6
    //   616: ifnull +402 -> 1018
    //   619: aload 6
    //   621: invokevirtual 270	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   624: aload_3
    //   625: areturn
    //   626: astore_0
    //   627: ldc 11
    //   629: iconst_1
    //   630: ldc_w 272
    //   633: aload_0
    //   634: invokestatic 137	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   637: goto -33 -> 604
    //   640: astore_0
    //   641: ldc 11
    //   643: iconst_1
    //   644: ldc_w 272
    //   647: aload_0
    //   648: invokestatic 137	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   651: goto -37 -> 614
    //   654: astore_0
    //   655: ldc 11
    //   657: iconst_1
    //   658: ldc_w 272
    //   661: aload_0
    //   662: invokestatic 137	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   665: aload_3
    //   666: areturn
    //   667: astore_1
    //   668: ldc 11
    //   670: iconst_1
    //   671: ldc_w 272
    //   674: aload_1
    //   675: invokestatic 137	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   678: goto -148 -> 530
    //   681: astore_1
    //   682: ldc 11
    //   684: iconst_1
    //   685: ldc_w 272
    //   688: aload_1
    //   689: invokestatic 137	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   692: goto -152 -> 540
    //   695: astore_1
    //   696: ldc 11
    //   698: iconst_1
    //   699: ldc_w 272
    //   702: aload_1
    //   703: invokestatic 137	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   706: aload_0
    //   707: areturn
    //   708: astore_1
    //   709: aconst_null
    //   710: astore 6
    //   712: aconst_null
    //   713: astore 4
    //   715: aconst_null
    //   716: astore_3
    //   717: aconst_null
    //   718: astore_0
    //   719: aload 6
    //   721: astore 9
    //   723: aload 4
    //   725: astore 8
    //   727: aload_3
    //   728: astore 7
    //   730: ldc 11
    //   732: iconst_1
    //   733: ldc_w 274
    //   736: aload_1
    //   737: invokestatic 137	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   740: aload_3
    //   741: ifnull +7 -> 748
    //   744: aload_3
    //   745: invokevirtual 268	java/io/OutputStream:close	()V
    //   748: aload 4
    //   750: ifnull +8 -> 758
    //   753: aload 4
    //   755: invokevirtual 269	java/io/InputStream:close	()V
    //   758: aload_0
    //   759: astore_1
    //   760: aload 6
    //   762: ifnull -208 -> 554
    //   765: aload 6
    //   767: invokevirtual 270	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   770: aload_0
    //   771: areturn
    //   772: astore_1
    //   773: ldc 11
    //   775: iconst_1
    //   776: ldc_w 272
    //   779: aload_1
    //   780: invokestatic 137	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   783: aload_0
    //   784: areturn
    //   785: astore_1
    //   786: ldc 11
    //   788: iconst_1
    //   789: ldc_w 272
    //   792: aload_1
    //   793: invokestatic 137	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   796: goto -48 -> 748
    //   799: astore_1
    //   800: ldc 11
    //   802: iconst_1
    //   803: ldc_w 272
    //   806: aload_1
    //   807: invokestatic 137	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   810: goto -52 -> 758
    //   813: astore_0
    //   814: aconst_null
    //   815: astore 6
    //   817: aconst_null
    //   818: astore 4
    //   820: aconst_null
    //   821: astore_1
    //   822: aload_1
    //   823: ifnull +7 -> 830
    //   826: aload_1
    //   827: invokevirtual 268	java/io/OutputStream:close	()V
    //   830: aload 4
    //   832: ifnull +8 -> 840
    //   835: aload 4
    //   837: invokevirtual 269	java/io/InputStream:close	()V
    //   840: aload 6
    //   842: ifnull +8 -> 850
    //   845: aload 6
    //   847: invokevirtual 270	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   850: aload_0
    //   851: athrow
    //   852: astore_1
    //   853: ldc 11
    //   855: iconst_1
    //   856: ldc_w 272
    //   859: aload_1
    //   860: invokestatic 137	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   863: goto -33 -> 830
    //   866: astore_1
    //   867: ldc 11
    //   869: iconst_1
    //   870: ldc_w 272
    //   873: aload_1
    //   874: invokestatic 137	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   877: goto -37 -> 840
    //   880: astore_1
    //   881: ldc 11
    //   883: iconst_1
    //   884: ldc_w 272
    //   887: aload_1
    //   888: invokestatic 137	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   891: goto -41 -> 850
    //   894: astore_0
    //   895: aconst_null
    //   896: astore 4
    //   898: aconst_null
    //   899: astore_1
    //   900: goto -78 -> 822
    //   903: astore_0
    //   904: aload 5
    //   906: astore 4
    //   908: aload_3
    //   909: astore_1
    //   910: goto -88 -> 822
    //   913: astore_0
    //   914: aload 9
    //   916: astore 6
    //   918: aload 8
    //   920: astore 4
    //   922: aload 7
    //   924: astore_1
    //   925: goto -103 -> 822
    //   928: astore_0
    //   929: aload_3
    //   930: astore_1
    //   931: goto -109 -> 822
    //   934: astore_1
    //   935: aconst_null
    //   936: astore 4
    //   938: aconst_null
    //   939: astore_3
    //   940: aconst_null
    //   941: astore_0
    //   942: goto -223 -> 719
    //   945: astore_1
    //   946: aload 5
    //   948: astore 4
    //   950: goto -231 -> 719
    //   953: astore_1
    //   954: aload_3
    //   955: astore_0
    //   956: aload 5
    //   958: astore_3
    //   959: goto -240 -> 719
    //   962: astore_1
    //   963: aload 5
    //   965: astore_3
    //   966: goto -247 -> 719
    //   969: astore_1
    //   970: goto -251 -> 719
    //   973: astore_1
    //   974: aconst_null
    //   975: astore 6
    //   977: aconst_null
    //   978: astore 4
    //   980: aconst_null
    //   981: astore_3
    //   982: aconst_null
    //   983: astore_0
    //   984: goto -483 -> 501
    //   987: astore_1
    //   988: aconst_null
    //   989: astore 4
    //   991: aconst_null
    //   992: astore_3
    //   993: aconst_null
    //   994: astore_0
    //   995: goto -494 -> 501
    //   998: astore_1
    //   999: aload_3
    //   1000: astore_0
    //   1001: aload 5
    //   1003: astore_3
    //   1004: goto -503 -> 501
    //   1007: astore_1
    //   1008: aload 5
    //   1010: astore_3
    //   1011: goto -510 -> 501
    //   1014: astore_1
    //   1015: goto -514 -> 501
    //   1018: aload_3
    //   1019: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1020	0	paramFile	File
    //   0	1020	1	paramString	String
    //   479	11	2	i	int
    //   1	1018	3	localObject1	Object
    //   27	963	4	localObject2	Object
    //   30	979	5	localObject3	Object
    //   10	966	6	localObject4	Object
    //   42	881	7	localObject5	Object
    //   38	881	8	localObject6	Object
    //   34	881	9	localObject7	Object
    //   17	50	10	localEnumeration	java.util.Enumeration
    //   24	463	11	arrayOfByte	byte[]
    //   76	386	12	localZipEntry	java.util.zip.ZipEntry
    // Exception table:
    //   from	to	target	type
    //   468	480	496	java/lang/Exception
    //   485	493	496	java/lang/Exception
    //   556	565	496	java/lang/Exception
    //   599	604	626	java/lang/Exception
    //   609	614	640	java/lang/Exception
    //   619	624	654	java/lang/Exception
    //   526	530	667	java/lang/Exception
    //   535	540	681	java/lang/Exception
    //   547	552	695	java/lang/Exception
    //   2	12	708	java/lang/OutOfMemoryError
    //   765	770	772	java/lang/Exception
    //   744	748	785	java/lang/Exception
    //   753	758	799	java/lang/Exception
    //   2	12	813	finally
    //   826	830	852	java/lang/Exception
    //   835	840	866	java/lang/Exception
    //   845	850	880	java/lang/Exception
    //   12	26	894	finally
    //   468	480	903	finally
    //   485	493	903	finally
    //   556	565	903	finally
    //   44	54	913	finally
    //   66	78	913	finally
    //   90	103	913	finally
    //   115	123	913	finally
    //   135	141	913	finally
    //   153	182	913	finally
    //   194	231	913	finally
    //   243	249	913	finally
    //   261	286	913	finally
    //   298	310	913	finally
    //   327	333	913	finally
    //   345	375	913	finally
    //   387	395	913	finally
    //   407	414	913	finally
    //   426	431	913	finally
    //   443	459	913	finally
    //   512	522	913	finally
    //   589	594	913	finally
    //   730	740	913	finally
    //   459	468	928	finally
    //   12	26	934	java/lang/OutOfMemoryError
    //   468	480	945	java/lang/OutOfMemoryError
    //   485	493	945	java/lang/OutOfMemoryError
    //   556	565	945	java/lang/OutOfMemoryError
    //   44	54	953	java/lang/OutOfMemoryError
    //   66	78	953	java/lang/OutOfMemoryError
    //   90	103	953	java/lang/OutOfMemoryError
    //   115	123	953	java/lang/OutOfMemoryError
    //   135	141	953	java/lang/OutOfMemoryError
    //   153	182	953	java/lang/OutOfMemoryError
    //   194	231	953	java/lang/OutOfMemoryError
    //   243	249	953	java/lang/OutOfMemoryError
    //   261	286	953	java/lang/OutOfMemoryError
    //   298	310	953	java/lang/OutOfMemoryError
    //   327	333	953	java/lang/OutOfMemoryError
    //   589	594	953	java/lang/OutOfMemoryError
    //   345	375	962	java/lang/OutOfMemoryError
    //   387	395	962	java/lang/OutOfMemoryError
    //   407	414	962	java/lang/OutOfMemoryError
    //   426	431	962	java/lang/OutOfMemoryError
    //   443	459	962	java/lang/OutOfMemoryError
    //   459	468	969	java/lang/OutOfMemoryError
    //   2	12	973	java/lang/Exception
    //   12	26	987	java/lang/Exception
    //   44	54	998	java/lang/Exception
    //   66	78	998	java/lang/Exception
    //   90	103	998	java/lang/Exception
    //   115	123	998	java/lang/Exception
    //   135	141	998	java/lang/Exception
    //   153	182	998	java/lang/Exception
    //   194	231	998	java/lang/Exception
    //   243	249	998	java/lang/Exception
    //   261	286	998	java/lang/Exception
    //   298	310	998	java/lang/Exception
    //   327	333	998	java/lang/Exception
    //   589	594	998	java/lang/Exception
    //   345	375	1007	java/lang/Exception
    //   387	395	1007	java/lang/Exception
    //   407	414	1007	java/lang/Exception
    //   426	431	1007	java/lang/Exception
    //   443	459	1007	java/lang/Exception
    //   459	468	1014	java/lang/Exception
  }
  
  public void cancelDwonloadItem(long paramLong, String paramString) {}
  
  public void cancelQuery(VasQuickUpdateManager.QueryItemVersionCallback paramQueryItemVersionCallback)
  {
    removePendingTask(new VasQuickUpdateEngine.QueryTask(0, "", false, paramQueryItemVersionCallback));
  }
  
  public boolean deleteFiles(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "deleteFiles bid = " + paramLong + " scid = " + paramString);
    }
    bici localbici = bics.a(paramLong);
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface == null) {
      QLog.e("VasQuickUpdateEngine", 1, "deleteFiles: get null app " + paramString);
    }
    return (localbici != null) && (localbici.deleteFiles(localQQAppInterface, paramLong, paramString));
  }
  
  public void downloadGatherItem(long paramLong, String paramString1, String[] paramArrayOfString, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "downloadItem bid = " + paramLong + " scid = " + paramString1 + " scidList = " + paramArrayOfString + " from = " + paramString2);
    }
  }
  
  public void downloadItem(long paramLong, String paramString1, String paramString2) {}
  
  public void onCompleted(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("VasQuickUpdateEngine", 1, "onCompleted bid = " + paramLong + " scid = " + paramString1 + " from = " + paramString3 + " dlFrom = " + paramInt1 + " errorCode = " + paramInt2 + " httpCode = " + paramInt3);
    bici localbici = bics.a(paramLong);
    if (localbici != null)
    {
      QQAppInterface localQQAppInterface = getApp();
      if (localQQAppInterface == null) {
        QLog.e("VasQuickUpdateEngine", 1, "onCompleted: get null app " + paramString1);
      }
      localbici.onCompleted(localQQAppInterface, paramLong, paramString1, paramString2, paramString3, paramInt2, paramInt3);
    }
  }
  
  public void onDestory() {}
  
  public void onPbMsgRecv(int paramInt, String paramString1, String paramString2) {}
  
  public void onProgress(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "onProgress bid = " + paramLong1 + " scid = " + paramString1 + " cfgScid = " + paramString2 + "dwProgress = " + paramLong2 + " dwProgressMax = " + paramLong3);
    }
    bici localbici = bics.a(paramLong1);
    if (localbici != null)
    {
      QQAppInterface localQQAppInterface = getApp();
      if (localQQAppInterface == null) {
        QLog.e("VasQuickUpdateEngine", 1, "onProgress: get null app " + paramString1);
      }
      localbici.onProgress(localQQAppInterface, paramLong1, paramString1, paramString2, paramLong2, paramLong3);
    }
  }
  
  public void queryItemVersion(int paramInt, String paramString, boolean paramBoolean, VasQuickUpdateManager.QueryItemVersionCallback paramQueryItemVersionCallback) {}
  
  void removePendingTask(VasQuickUpdateEngine.PendingTask paramPendingTask)
  {
    for (;;)
    {
      int i;
      synchronized (this.pendingTasks)
      {
        i = this.pendingTasks.size() - 1;
        if (i >= 0)
        {
          VasQuickUpdateEngine.PendingTask localPendingTask = (VasQuickUpdateEngine.PendingTask)this.pendingTasks.get(i);
          if ((localPendingTask.getClass() == paramPendingTask.getClass()) && (localPendingTask.equals(paramPendingTask))) {
            this.pendingTasks.remove(i);
          }
        }
        else
        {
          return;
        }
      }
      i -= 1;
    }
  }
  
  public void setWeakHandler(WeakReference<VasExtensionHandler> paramWeakReference)
  {
    this.mWeakHandler = paramWeakReference;
  }
  
  public void startUpdateAllItem() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateEngine
 * JD-Core Version:    0.7.0.1
 */