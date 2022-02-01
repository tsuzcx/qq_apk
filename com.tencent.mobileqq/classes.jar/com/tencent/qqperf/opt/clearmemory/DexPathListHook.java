package com.tencent.qqperf.opt.clearmemory;

import android.os.Build.VERSION;
import android.os.Environment;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Field;
import java.util.zip.ZipFile;

public class DexPathListHook
{
  public static int a(ClassLoader paramClassLoader)
  {
    k = 0;
    if (Build.VERSION.SDK_INT >= 24) {
      i = 0;
    }
    do
    {
      return i;
      try
      {
        localObject1 = DexClassLoader.class.getSuperclass().getDeclaredField("pathList");
        ((Field)localObject1).setAccessible(true);
        localObject3 = ((Field)localObject1).get(paramClassLoader);
        paramClassLoader = localObject3.getClass().getDeclaredField("dexElements");
        paramClassLoader.setAccessible(true);
        localObject4 = (Object[])paramClassLoader.get(localObject3);
        try
        {
          paramClassLoader = Environment.getExternalStorageDirectory().getPath() + "/tencent/MobileQQ/" + "com.tencent.mobileqq".replace(".", File.separator) + File.separator;
          localObject1 = paramClassLoader + "myZip.zip";
          a((String)localObject1, paramClassLoader + "info.txt");
          paramClassLoader = new File((String)localObject1);
          if ((paramClassLoader == null) || (!paramClassLoader.exists()))
          {
            if (!QLog.isColorLevel()) {
              break label660;
            }
            QLog.e("DexPathListHook", 2, "ClearDexPathListZipFile zipFile generate false");
          }
        }
        catch (Exception paramClassLoader)
        {
          for (;;)
          {
            paramClassLoader.printStackTrace();
            paramClassLoader = null;
          }
          m = localObject4.length;
          j = 0;
          i = 0;
        }
      }
      catch (Exception paramClassLoader)
      {
        for (;;)
        {
          Object localObject1;
          Object localObject3;
          Object localObject4;
          int m;
          int j;
          Object localObject5;
          i = 0;
          continue;
          break label662;
          return 0;
          j += 1;
          continue;
          k += 1;
        }
      }
      if (j < m) {
        localObject5 = localObject4[j];
      }
      try
      {
        Object localObject6 = localObject5.getClass().getDeclaredField("zipFile");
        ((Field)localObject6).setAccessible(true);
        ZipFile localZipFile = (ZipFile)((Field)localObject6).get(localObject5);
        if (localZipFile == null) {
          break;
        }
        if ((localZipFile instanceof HookDexZipFile))
        {
          if (!((HookDexZipFile)localZipFile).a()) {
            break;
          }
          i += 1;
          break;
        }
        localObject1 = localZipFile.getName();
        if (!((String)localObject1).contains("com.tencent.mobileqq")) {
          break;
        }
        boolean bool = ((String)localObject1).contains("base.apk");
        if (!bool) {
          break;
        }
        Object localObject2;
        try
        {
          localObject1 = localObject5.getClass().getDeclaredField("zip");
          ((Field)localObject1).setAccessible(true);
          localObject1 = (File)((Field)localObject1).get(localObject5);
          if (localObject1 == null) {
            break;
          }
          localObject1 = new HookDexZipFile(paramClassLoader, (File)localObject1, localZipFile);
          ((Field)localObject6).set(localObject5, localObject1);
          ((HookDexZipFile)localObject1).a();
          i += 1;
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          for (;;)
          {
            localObject2 = localObject5.getClass().getDeclaredField("file");
          }
        }
        j = i;
        if (Build.VERSION.SDK_INT == 23)
        {
          localObject2 = localObject3.getClass().getDeclaredField("nativeLibraryPathElements");
          ((Field)localObject2).setAccessible(true);
          localObject2 = (Object[])((Field)localObject2).get(localObject3);
          m = localObject2.length;
          j = i;
          if (k < m)
          {
            localObject3 = localObject2[k];
            localObject4 = localObject3.getClass().getDeclaredField("zipFile");
            ((Field)localObject4).setAccessible(true);
            localObject5 = (ZipFile)((Field)localObject4).get(localObject3);
            if ((localObject5 == null) || ((localObject5 instanceof HookDexZipFile))) {
              break label669;
            }
            localObject6 = ((ZipFile)localObject5).getName();
            if ((!((String)localObject6).contains("com.tencent.mobileqq")) || (!((String)localObject6).contains("base.apk"))) {
              break label669;
            }
            localObject6 = localObject3.getClass().getDeclaredField("zip");
            ((Field)localObject6).setAccessible(true);
            localObject6 = (File)((Field)localObject6).get(localObject3);
            if (localObject6 == null) {
              break label669;
            }
            localObject5 = new HookDexZipFile(paramClassLoader, (File)localObject6, (ZipFile)localObject5);
            ((Field)localObject4).set(localObject3, localObject5);
            ((HookDexZipFile)localObject5).a();
          }
        }
      }
      catch (Exception paramClassLoader)
      {
        paramClassLoader.printStackTrace();
        j = i;
        i = j;
      }
    } while (!QLog.isColorLevel());
    QLog.d("DexPathListHook", 2, "ClearDexPathListZipFile clearCount " + j);
    return j;
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 63	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 100	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aload_2
    //   10: invokevirtual 104	java/io/File:exists	()Z
    //   13: ifeq +25 -> 38
    //   16: aload_2
    //   17: invokevirtual 163	java/io/File:isFile	()Z
    //   20: ifeq +18 -> 38
    //   23: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +11 -> 37
    //   29: ldc 111
    //   31: iconst_2
    //   32: ldc 165
    //   34: invokestatic 160	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: return
    //   38: new 167	java/util/ArrayList
    //   41: dup
    //   42: iconst_1
    //   43: invokespecial 170	java/util/ArrayList:<init>	(I)V
    //   46: astore 4
    //   48: new 63	java/io/File
    //   51: dup
    //   52: aload_1
    //   53: invokespecial 100	java/io/File:<init>	(Ljava/lang/String;)V
    //   56: astore_1
    //   57: aload_1
    //   58: invokevirtual 104	java/io/File:exists	()Z
    //   61: ifeq +38 -> 99
    //   64: aload_1
    //   65: invokevirtual 163	java/io/File:isFile	()Z
    //   68: ifeq +31 -> 99
    //   71: aload_1
    //   72: invokevirtual 174	java/io/File:length	()J
    //   75: lconst_0
    //   76: lcmp
    //   77: ifle +22 -> 99
    //   80: aload 4
    //   82: aload_1
    //   83: invokevirtual 177	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   86: invokeinterface 183 2 0
    //   91: pop
    //   92: aload 4
    //   94: aload_0
    //   95: invokestatic 186	com/tencent/qqperf/opt/clearmemory/DexPathListHook:a	(Ljava/util/List;Ljava/lang/String;)V
    //   98: return
    //   99: aload_1
    //   100: invokevirtual 189	java/io/File:getParentFile	()Ljava/io/File;
    //   103: invokevirtual 104	java/io/File:exists	()Z
    //   106: ifne +11 -> 117
    //   109: aload_1
    //   110: invokevirtual 189	java/io/File:getParentFile	()Ljava/io/File;
    //   113: invokevirtual 192	java/io/File:mkdirs	()Z
    //   116: pop
    //   117: aload 4
    //   119: aload_1
    //   120: invokevirtual 177	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   123: invokeinterface 183 2 0
    //   128: pop
    //   129: aload_1
    //   130: invokevirtual 195	java/io/File:createNewFile	()Z
    //   133: pop
    //   134: new 197	java/io/BufferedOutputStream
    //   137: dup
    //   138: new 199	java/io/FileOutputStream
    //   141: dup
    //   142: aload_1
    //   143: invokespecial 202	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   146: invokespecial 205	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   149: astore_2
    //   150: aload_2
    //   151: astore_1
    //   152: aload_2
    //   153: ldc 207
    //   155: invokevirtual 211	java/lang/String:getBytes	()[B
    //   158: invokevirtual 215	java/io/BufferedOutputStream:write	([B)V
    //   161: aload_2
    //   162: astore_1
    //   163: aload_2
    //   164: invokevirtual 218	java/io/BufferedOutputStream:flush	()V
    //   167: aload_2
    //   168: ifnull +7 -> 175
    //   171: aload_2
    //   172: invokevirtual 221	java/io/BufferedOutputStream:close	()V
    //   175: aload 4
    //   177: aload_0
    //   178: invokestatic 186	com/tencent/qqperf/opt/clearmemory/DexPathListHook:a	(Ljava/util/List;Ljava/lang/String;)V
    //   181: return
    //   182: astore_3
    //   183: aconst_null
    //   184: astore_2
    //   185: aload_2
    //   186: astore_1
    //   187: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   190: ifeq +14 -> 204
    //   193: aload_2
    //   194: astore_1
    //   195: ldc 111
    //   197: iconst_2
    //   198: ldc 223
    //   200: aload_3
    //   201: invokestatic 226	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   204: aload_2
    //   205: ifnull -30 -> 175
    //   208: aload_2
    //   209: invokevirtual 221	java/io/BufferedOutputStream:close	()V
    //   212: goto -37 -> 175
    //   215: astore_1
    //   216: goto -41 -> 175
    //   219: astore_0
    //   220: aconst_null
    //   221: astore_1
    //   222: aload_1
    //   223: ifnull +7 -> 230
    //   226: aload_1
    //   227: invokevirtual 221	java/io/BufferedOutputStream:close	()V
    //   230: aload_0
    //   231: athrow
    //   232: astore_1
    //   233: goto -58 -> 175
    //   236: astore_1
    //   237: goto -7 -> 230
    //   240: astore_0
    //   241: goto -19 -> 222
    //   244: astore_3
    //   245: goto -60 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	paramString1	String
    //   0	248	1	paramString2	String
    //   8	201	2	localObject	Object
    //   182	19	3	localException1	Exception
    //   244	1	3	localException2	Exception
    //   46	130	4	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   129	150	182	java/lang/Exception
    //   208	212	215	java/lang/Exception
    //   129	150	219	finally
    //   171	175	232	java/lang/Exception
    //   226	230	236	java/lang/Exception
    //   152	161	240	finally
    //   163	167	240	finally
    //   187	193	240	finally
    //   195	204	240	finally
    //   152	161	244	java/lang/Exception
    //   163	167	244	java/lang/Exception
  }
  
  /* Error */
  public static void a(java.util.List<String> paramList, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 199	java/io/FileOutputStream
    //   6: dup
    //   7: new 63	java/io/File
    //   10: dup
    //   11: aload_1
    //   12: invokespecial 100	java/io/File:<init>	(Ljava/lang/String;)V
    //   15: invokespecial 202	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   18: astore_3
    //   19: new 197	java/io/BufferedOutputStream
    //   22: dup
    //   23: aload_3
    //   24: invokespecial 205	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   27: astore 4
    //   29: new 230	java/util/zip/ZipOutputStream
    //   32: dup
    //   33: aload 4
    //   35: invokespecial 231	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   38: astore_1
    //   39: aload_0
    //   40: invokeinterface 235 1 0
    //   45: astore_0
    //   46: aload_0
    //   47: invokeinterface 240 1 0
    //   52: ifeq +243 -> 295
    //   55: new 63	java/io/File
    //   58: dup
    //   59: aload_0
    //   60: invokeinterface 244 1 0
    //   65: checkcast 83	java/lang/String
    //   68: invokespecial 100	java/io/File:<init>	(Ljava/lang/String;)V
    //   71: astore 5
    //   73: aload 5
    //   75: ifnull -29 -> 46
    //   78: aload 5
    //   80: invokevirtual 104	java/io/File:exists	()Z
    //   83: ifeq -37 -> 46
    //   86: aload_1
    //   87: new 246	java/util/zip/ZipEntry
    //   90: dup
    //   91: aload 5
    //   93: invokevirtual 247	java/io/File:getName	()Ljava/lang/String;
    //   96: invokespecial 248	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   99: invokevirtual 252	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   102: aload_1
    //   103: bipush 9
    //   105: invokevirtual 255	java/util/zip/ZipOutputStream:setLevel	(I)V
    //   108: new 257	java/io/FileInputStream
    //   111: dup
    //   112: aload 5
    //   114: invokespecial 258	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   117: astore 5
    //   119: sipush 20480
    //   122: newarray byte
    //   124: astore 6
    //   126: aload 5
    //   128: aload 6
    //   130: iconst_0
    //   131: sipush 20480
    //   134: invokevirtual 262	java/io/FileInputStream:read	([BII)I
    //   137: istore_2
    //   138: iload_2
    //   139: iconst_m1
    //   140: if_icmpeq +101 -> 241
    //   143: aload_1
    //   144: aload 6
    //   146: iconst_0
    //   147: iload_2
    //   148: invokevirtual 265	java/util/zip/ZipOutputStream:write	([BII)V
    //   151: goto -25 -> 126
    //   154: astore_0
    //   155: aload 5
    //   157: ifnull +8 -> 165
    //   160: aload 5
    //   162: invokevirtual 266	java/io/FileInputStream:close	()V
    //   165: aload_1
    //   166: ifnull +11 -> 177
    //   169: aload_1
    //   170: invokevirtual 267	java/util/zip/ZipOutputStream:flush	()V
    //   173: aload_1
    //   174: invokevirtual 270	java/util/zip/ZipOutputStream:closeEntry	()V
    //   177: aload_0
    //   178: athrow
    //   179: astore 6
    //   181: aload_1
    //   182: astore_0
    //   183: aload 4
    //   185: astore 5
    //   187: aload_3
    //   188: astore_1
    //   189: aload_0
    //   190: astore 4
    //   192: aload 5
    //   194: astore_0
    //   195: aload 6
    //   197: astore_3
    //   198: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   201: ifeq +13 -> 214
    //   204: ldc 111
    //   206: iconst_2
    //   207: ldc_w 272
    //   210: aload_3
    //   211: invokestatic 274	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   214: aload 4
    //   216: ifnull +8 -> 224
    //   219: aload 4
    //   221: invokevirtual 275	java/util/zip/ZipOutputStream:close	()V
    //   224: aload_0
    //   225: ifnull +7 -> 232
    //   228: aload_0
    //   229: invokevirtual 221	java/io/BufferedOutputStream:close	()V
    //   232: aload_1
    //   233: ifnull +7 -> 240
    //   236: aload_1
    //   237: invokevirtual 276	java/io/FileOutputStream:close	()V
    //   240: return
    //   241: aload 5
    //   243: ifnull +8 -> 251
    //   246: aload 5
    //   248: invokevirtual 266	java/io/FileInputStream:close	()V
    //   251: aload_1
    //   252: ifnull -206 -> 46
    //   255: aload_1
    //   256: invokevirtual 267	java/util/zip/ZipOutputStream:flush	()V
    //   259: aload_1
    //   260: invokevirtual 270	java/util/zip/ZipOutputStream:closeEntry	()V
    //   263: goto -217 -> 46
    //   266: astore_0
    //   267: aload_1
    //   268: ifnull +7 -> 275
    //   271: aload_1
    //   272: invokevirtual 275	java/util/zip/ZipOutputStream:close	()V
    //   275: aload 4
    //   277: ifnull +8 -> 285
    //   280: aload 4
    //   282: invokevirtual 221	java/io/BufferedOutputStream:close	()V
    //   285: aload_3
    //   286: ifnull +7 -> 293
    //   289: aload_3
    //   290: invokevirtual 276	java/io/FileOutputStream:close	()V
    //   293: aload_0
    //   294: athrow
    //   295: aload_1
    //   296: ifnull +7 -> 303
    //   299: aload_1
    //   300: invokevirtual 275	java/util/zip/ZipOutputStream:close	()V
    //   303: aload 4
    //   305: ifnull +8 -> 313
    //   308: aload 4
    //   310: invokevirtual 221	java/io/BufferedOutputStream:close	()V
    //   313: aload_3
    //   314: ifnull -74 -> 240
    //   317: aload_3
    //   318: invokevirtual 276	java/io/FileOutputStream:close	()V
    //   321: return
    //   322: astore_0
    //   323: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   326: ifeq -86 -> 240
    //   329: ldc 111
    //   331: iconst_2
    //   332: ldc_w 278
    //   335: aload_0
    //   336: invokestatic 274	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   339: return
    //   340: astore_0
    //   341: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   344: ifeq -41 -> 303
    //   347: ldc 111
    //   349: iconst_2
    //   350: ldc_w 278
    //   353: aload_0
    //   354: invokestatic 274	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   357: goto -54 -> 303
    //   360: astore_0
    //   361: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   364: ifeq -51 -> 313
    //   367: ldc 111
    //   369: iconst_2
    //   370: ldc_w 278
    //   373: aload_0
    //   374: invokestatic 274	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   377: goto -64 -> 313
    //   380: astore_3
    //   381: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   384: ifeq -160 -> 224
    //   387: ldc 111
    //   389: iconst_2
    //   390: ldc_w 278
    //   393: aload_3
    //   394: invokestatic 274	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   397: goto -173 -> 224
    //   400: astore_0
    //   401: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   404: ifeq -172 -> 232
    //   407: ldc 111
    //   409: iconst_2
    //   410: ldc_w 278
    //   413: aload_0
    //   414: invokestatic 274	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   417: goto -185 -> 232
    //   420: astore_0
    //   421: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   424: ifeq -184 -> 240
    //   427: ldc 111
    //   429: iconst_2
    //   430: ldc_w 278
    //   433: aload_0
    //   434: invokestatic 274	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   437: return
    //   438: astore_1
    //   439: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   442: ifeq -167 -> 275
    //   445: ldc 111
    //   447: iconst_2
    //   448: ldc_w 278
    //   451: aload_1
    //   452: invokestatic 274	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   455: goto -180 -> 275
    //   458: astore_1
    //   459: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   462: ifeq -177 -> 285
    //   465: ldc 111
    //   467: iconst_2
    //   468: ldc_w 278
    //   471: aload_1
    //   472: invokestatic 274	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   475: goto -190 -> 285
    //   478: astore_1
    //   479: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   482: ifeq -189 -> 293
    //   485: ldc 111
    //   487: iconst_2
    //   488: ldc_w 278
    //   491: aload_1
    //   492: invokestatic 274	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   495: goto -202 -> 293
    //   498: astore_0
    //   499: aconst_null
    //   500: astore_1
    //   501: aconst_null
    //   502: astore 4
    //   504: aconst_null
    //   505: astore_3
    //   506: goto -239 -> 267
    //   509: astore_0
    //   510: aconst_null
    //   511: astore_1
    //   512: aconst_null
    //   513: astore 4
    //   515: goto -248 -> 267
    //   518: astore_0
    //   519: aconst_null
    //   520: astore_1
    //   521: goto -254 -> 267
    //   524: astore 6
    //   526: aload_0
    //   527: astore_3
    //   528: aload_1
    //   529: astore 5
    //   531: aload 4
    //   533: astore_1
    //   534: aload 6
    //   536: astore_0
    //   537: aload_3
    //   538: astore 4
    //   540: aload 5
    //   542: astore_3
    //   543: goto -276 -> 267
    //   546: astore_3
    //   547: aconst_null
    //   548: astore_0
    //   549: aconst_null
    //   550: astore_1
    //   551: aload 5
    //   553: astore 4
    //   555: goto -357 -> 198
    //   558: astore 4
    //   560: aconst_null
    //   561: astore_0
    //   562: aload_3
    //   563: astore_1
    //   564: aload 4
    //   566: astore_3
    //   567: aload 5
    //   569: astore 4
    //   571: goto -373 -> 198
    //   574: astore 6
    //   576: aload 4
    //   578: astore_0
    //   579: aload_3
    //   580: astore_1
    //   581: aload 6
    //   583: astore_3
    //   584: aload 5
    //   586: astore 4
    //   588: goto -390 -> 198
    //   591: astore_0
    //   592: aconst_null
    //   593: astore 5
    //   595: goto -440 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	598	0	paramList	java.util.List<String>
    //   0	598	1	paramString	String
    //   137	11	2	i	int
    //   18	300	3	localObject1	Object
    //   380	14	3	localIOException	java.io.IOException
    //   505	38	3	localObject2	Object
    //   546	17	3	localException1	Exception
    //   566	18	3	localObject3	Object
    //   27	527	4	localObject4	Object
    //   558	7	4	localException2	Exception
    //   569	18	4	localObject5	Object
    //   1	593	5	localObject6	Object
    //   124	21	6	arrayOfByte	byte[]
    //   179	17	6	localException3	Exception
    //   524	11	6	localObject7	Object
    //   574	8	6	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   119	126	154	finally
    //   126	138	154	finally
    //   143	151	154	finally
    //   39	46	179	java/lang/Exception
    //   46	73	179	java/lang/Exception
    //   78	108	179	java/lang/Exception
    //   160	165	179	java/lang/Exception
    //   169	177	179	java/lang/Exception
    //   177	179	179	java/lang/Exception
    //   246	251	179	java/lang/Exception
    //   255	263	179	java/lang/Exception
    //   39	46	266	finally
    //   46	73	266	finally
    //   78	108	266	finally
    //   160	165	266	finally
    //   169	177	266	finally
    //   177	179	266	finally
    //   246	251	266	finally
    //   255	263	266	finally
    //   317	321	322	java/io/IOException
    //   299	303	340	java/io/IOException
    //   308	313	360	java/io/IOException
    //   219	224	380	java/io/IOException
    //   228	232	400	java/io/IOException
    //   236	240	420	java/io/IOException
    //   271	275	438	java/io/IOException
    //   280	285	458	java/io/IOException
    //   289	293	478	java/io/IOException
    //   3	19	498	finally
    //   19	29	509	finally
    //   29	39	518	finally
    //   198	214	524	finally
    //   3	19	546	java/lang/Exception
    //   19	29	558	java/lang/Exception
    //   29	39	574	java/lang/Exception
    //   108	119	591	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.opt.clearmemory.DexPathListHook
 * JD-Core Version:    0.7.0.1
 */