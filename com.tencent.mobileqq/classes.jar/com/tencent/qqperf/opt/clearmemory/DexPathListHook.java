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
    if (Build.VERSION.SDK_INT >= 24) {
      return 0;
    }
    for (;;)
    {
      int j;
      try
      {
        Object localObject1 = DexClassLoader.class.getSuperclass().getDeclaredField("pathList");
        ((Field)localObject1).setAccessible(true);
        Object localObject2 = ((Field)localObject1).get(paramClassLoader);
        paramClassLoader = localObject2.getClass().getDeclaredField("dexElements");
        paramClassLoader.setAccessible(true);
        Object localObject3 = (Object[])paramClassLoader.get(localObject2);
        Object localObject4;
        try
        {
          paramClassLoader = new StringBuilder();
          paramClassLoader.append(Environment.getExternalStorageDirectory().getPath());
          paramClassLoader.append("/tencent/MobileQQ/");
          paramClassLoader.append("com.tencent.mobileqq".replace(".", File.separator));
          paramClassLoader.append(File.separator);
          paramClassLoader = paramClassLoader.toString();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramClassLoader);
          ((StringBuilder)localObject1).append("myZip.zip");
          localObject1 = ((StringBuilder)localObject1).toString();
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(paramClassLoader);
          ((StringBuilder)localObject4).append("info.txt");
          a((String)localObject1, ((StringBuilder)localObject4).toString());
          paramClassLoader = new File((String)localObject1);
        }
        catch (Exception paramClassLoader)
        {
          paramClassLoader.printStackTrace();
          paramClassLoader = null;
        }
        if (paramClassLoader != null) {
          try
          {
            if (paramClassLoader.exists())
            {
              int m = localObject3.length;
              j = 0;
              i = 0;
              if (j < m) {
                localObject4 = localObject3[j];
              }
              Object localObject5;
              ZipFile localZipFile;
              try
              {
                localObject5 = localObject4.getClass().getDeclaredField("zipFile");
                ((Field)localObject5).setAccessible(true);
                localZipFile = (ZipFile)((Field)localObject5).get(localObject4);
                k = i;
                if (localZipFile == null) {
                  break label712;
                }
                if ((localZipFile instanceof HookDexZipFile))
                {
                  k = i;
                  if (!((HookDexZipFile)localZipFile).a()) {
                    break label712;
                  }
                  break label708;
                }
                localObject1 = localZipFile.getName();
                k = i;
                if (!((String)localObject1).contains("com.tencent.mobileqq")) {
                  break label712;
                }
                bool = ((String)localObject1).contains("base.apk");
                k = i;
                if (!bool) {
                  break label712;
                }
              }
              catch (Exception paramClassLoader) {}
            }
          }
          catch (Exception paramClassLoader) {}
        }
      }
      catch (Exception paramClassLoader)
      {
        boolean bool;
        i = 0;
        paramClassLoader.printStackTrace();
        k = i;
        if (QLog.isColorLevel())
        {
          paramClassLoader = new StringBuilder();
          paramClassLoader.append("ClearDexPathListZipFile clearCount ");
          paramClassLoader.append(k);
          QLog.d("DexPathListHook", 2, paramClassLoader.toString());
        }
        return k;
      }
      try
      {
        localObject1 = localObject4.getClass().getDeclaredField("zip");
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        continue;
      }
      localObject1 = localObject4.getClass().getDeclaredField("file");
      ((Field)localObject1).setAccessible(true);
      localObject1 = (File)((Field)localObject1).get(localObject4);
      int k = i;
      if (localObject1 != null)
      {
        localObject1 = new HookDexZipFile(paramClassLoader, (File)localObject1, localZipFile);
        ((Field)localObject5).set(localObject4, localObject1);
        ((HookDexZipFile)localObject1).a();
        break label708;
        k = i;
        if (Build.VERSION.SDK_INT == 23)
        {
          localObject1 = localObject2.getClass().getDeclaredField("nativeLibraryPathElements");
          ((Field)localObject1).setAccessible(true);
          localObject1 = (Object[])((Field)localObject1).get(localObject2);
          m = localObject1.length;
          j = 0;
          k = i;
          if (j < m)
          {
            localObject2 = localObject1[j];
            localObject3 = localObject2.getClass().getDeclaredField("zipFile");
            ((Field)localObject3).setAccessible(true);
            localObject4 = (ZipFile)((Field)localObject3).get(localObject2);
            if ((localObject4 != null) && (!(localObject4 instanceof HookDexZipFile)))
            {
              localObject5 = ((ZipFile)localObject4).getName();
              if ((((String)localObject5).contains("com.tencent.mobileqq")) && (((String)localObject5).contains("base.apk")))
              {
                localObject5 = localObject2.getClass().getDeclaredField("zip");
                ((Field)localObject5).setAccessible(true);
                localObject5 = (File)((Field)localObject5).get(localObject2);
                if (localObject5 != null)
                {
                  localObject4 = new HookDexZipFile(paramClassLoader, (File)localObject5, (ZipFile)localObject4);
                  ((Field)localObject3).set(localObject2, localObject4);
                  ((HookDexZipFile)localObject4).b();
                }
              }
            }
            j += 1;
            continue;
            bool = QLog.isColorLevel();
            if (bool) {
              QLog.e("DexPathListHook", 2, "ClearDexPathListZipFile zipFile generate false");
            }
            return 0;
          }
        }
        label708:
        k = i + 1;
      }
      label712:
      j += 1;
      int i = k;
    }
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
    //   10: invokevirtual 107	java/io/File:exists	()Z
    //   13: ifeq +25 -> 38
    //   16: aload_2
    //   17: invokevirtual 164	java/io/File:isFile	()Z
    //   20: ifeq +18 -> 38
    //   23: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +11 -> 37
    //   29: ldc 147
    //   31: iconst_2
    //   32: ldc 166
    //   34: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: return
    //   38: new 168	java/util/ArrayList
    //   41: dup
    //   42: iconst_1
    //   43: invokespecial 171	java/util/ArrayList:<init>	(I)V
    //   46: astore 4
    //   48: new 63	java/io/File
    //   51: dup
    //   52: aload_1
    //   53: invokespecial 100	java/io/File:<init>	(Ljava/lang/String;)V
    //   56: astore 5
    //   58: aload 5
    //   60: invokevirtual 107	java/io/File:exists	()Z
    //   63: ifeq +41 -> 104
    //   66: aload 5
    //   68: invokevirtual 164	java/io/File:isFile	()Z
    //   71: ifeq +33 -> 104
    //   74: aload 5
    //   76: invokevirtual 175	java/io/File:length	()J
    //   79: lconst_0
    //   80: lcmp
    //   81: ifle +23 -> 104
    //   84: aload 4
    //   86: aload 5
    //   88: invokevirtual 178	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   91: invokeinterface 184 2 0
    //   96: pop
    //   97: aload 4
    //   99: aload_0
    //   100: invokestatic 187	com/tencent/qqperf/opt/clearmemory/DexPathListHook:a	(Ljava/util/List;Ljava/lang/String;)V
    //   103: return
    //   104: aload 5
    //   106: invokevirtual 190	java/io/File:getParentFile	()Ljava/io/File;
    //   109: invokevirtual 107	java/io/File:exists	()Z
    //   112: ifne +12 -> 124
    //   115: aload 5
    //   117: invokevirtual 190	java/io/File:getParentFile	()Ljava/io/File;
    //   120: invokevirtual 193	java/io/File:mkdirs	()Z
    //   123: pop
    //   124: aload 4
    //   126: aload 5
    //   128: invokevirtual 178	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   131: invokeinterface 184 2 0
    //   136: pop
    //   137: aconst_null
    //   138: astore_3
    //   139: aconst_null
    //   140: astore_2
    //   141: aload_2
    //   142: astore_1
    //   143: aload 5
    //   145: invokevirtual 196	java/io/File:createNewFile	()Z
    //   148: pop
    //   149: aload_2
    //   150: astore_1
    //   151: new 198	java/io/BufferedOutputStream
    //   154: dup
    //   155: new 200	java/io/FileOutputStream
    //   158: dup
    //   159: aload 5
    //   161: invokespecial 203	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   164: invokespecial 206	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   167: astore_2
    //   168: aload_2
    //   169: ldc 208
    //   171: invokevirtual 212	java/lang/String:getBytes	()[B
    //   174: invokevirtual 216	java/io/BufferedOutputStream:write	([B)V
    //   177: aload_2
    //   178: invokevirtual 219	java/io/BufferedOutputStream:flush	()V
    //   181: aload_2
    //   182: invokevirtual 222	java/io/BufferedOutputStream:close	()V
    //   185: goto +49 -> 234
    //   188: astore_0
    //   189: aload_2
    //   190: astore_1
    //   191: goto +50 -> 241
    //   194: astore_3
    //   195: goto +12 -> 207
    //   198: astore_0
    //   199: goto +42 -> 241
    //   202: astore_1
    //   203: aload_3
    //   204: astore_2
    //   205: aload_1
    //   206: astore_3
    //   207: aload_2
    //   208: astore_1
    //   209: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   212: ifeq +14 -> 226
    //   215: aload_2
    //   216: astore_1
    //   217: ldc 147
    //   219: iconst_2
    //   220: ldc 224
    //   222: aload_3
    //   223: invokestatic 227	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   226: aload_2
    //   227: ifnull +7 -> 234
    //   230: aload_2
    //   231: invokevirtual 222	java/io/BufferedOutputStream:close	()V
    //   234: aload 4
    //   236: aload_0
    //   237: invokestatic 187	com/tencent/qqperf/opt/clearmemory/DexPathListHook:a	(Ljava/util/List;Ljava/lang/String;)V
    //   240: return
    //   241: aload_1
    //   242: ifnull +7 -> 249
    //   245: aload_1
    //   246: invokevirtual 222	java/io/BufferedOutputStream:close	()V
    //   249: aload_0
    //   250: athrow
    //   251: astore_1
    //   252: goto -18 -> 234
    //   255: astore_1
    //   256: goto -7 -> 249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	paramString1	String
    //   0	259	1	paramString2	String
    //   8	223	2	localObject1	Object
    //   138	1	3	localObject2	Object
    //   194	10	3	localException	Exception
    //   206	17	3	str	String
    //   46	189	4	localArrayList	java.util.ArrayList
    //   56	104	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   168	181	188	finally
    //   168	181	194	java/lang/Exception
    //   143	149	198	finally
    //   151	168	198	finally
    //   209	215	198	finally
    //   217	226	198	finally
    //   143	149	202	java/lang/Exception
    //   151	168	202	java/lang/Exception
    //   181	185	251	java/lang/Exception
    //   230	234	251	java/lang/Exception
    //   245	249	255	java/lang/Exception
  }
  
  /* Error */
  public static void a(java.util.List<String> paramList, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: new 200	java/io/FileOutputStream
    //   9: dup
    //   10: new 63	java/io/File
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 100	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: invokespecial 203	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   21: astore_1
    //   22: new 198	java/io/BufferedOutputStream
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 206	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   30: astore_3
    //   31: aload_1
    //   32: astore 4
    //   34: aload_3
    //   35: astore 6
    //   37: new 231	java/util/zip/ZipOutputStream
    //   40: dup
    //   41: aload_3
    //   42: invokespecial 232	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   45: astore 5
    //   47: aload_0
    //   48: invokeinterface 236 1 0
    //   53: astore 4
    //   55: aload 4
    //   57: invokeinterface 241 1 0
    //   62: ifeq +133 -> 195
    //   65: new 63	java/io/File
    //   68: dup
    //   69: aload 4
    //   71: invokeinterface 245 1 0
    //   76: checkcast 83	java/lang/String
    //   79: invokespecial 100	java/io/File:<init>	(Ljava/lang/String;)V
    //   82: astore_0
    //   83: aload_0
    //   84: invokevirtual 107	java/io/File:exists	()Z
    //   87: ifeq -32 -> 55
    //   90: aload 5
    //   92: new 247	java/util/zip/ZipEntry
    //   95: dup
    //   96: aload_0
    //   97: invokevirtual 248	java/io/File:getName	()Ljava/lang/String;
    //   100: invokespecial 249	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   103: invokevirtual 253	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   106: aload 5
    //   108: bipush 9
    //   110: invokevirtual 256	java/util/zip/ZipOutputStream:setLevel	(I)V
    //   113: new 258	java/io/FileInputStream
    //   116: dup
    //   117: aload_0
    //   118: invokespecial 259	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   121: astore_0
    //   122: sipush 20480
    //   125: newarray byte
    //   127: astore 6
    //   129: aload_0
    //   130: aload 6
    //   132: iconst_0
    //   133: sipush 20480
    //   136: invokevirtual 263	java/io/FileInputStream:read	([BII)I
    //   139: istore_2
    //   140: iload_2
    //   141: iconst_m1
    //   142: if_icmpeq +15 -> 157
    //   145: aload 5
    //   147: aload 6
    //   149: iconst_0
    //   150: iload_2
    //   151: invokevirtual 266	java/util/zip/ZipOutputStream:write	([BII)V
    //   154: goto -25 -> 129
    //   157: aload_0
    //   158: invokevirtual 267	java/io/FileInputStream:close	()V
    //   161: aload 5
    //   163: invokevirtual 268	java/util/zip/ZipOutputStream:flush	()V
    //   166: aload 5
    //   168: invokevirtual 271	java/util/zip/ZipOutputStream:closeEntry	()V
    //   171: goto -116 -> 55
    //   174: aload_0
    //   175: ifnull +7 -> 182
    //   178: aload_0
    //   179: invokevirtual 267	java/io/FileInputStream:close	()V
    //   182: aload 5
    //   184: invokevirtual 268	java/util/zip/ZipOutputStream:flush	()V
    //   187: aload 5
    //   189: invokevirtual 271	java/util/zip/ZipOutputStream:closeEntry	()V
    //   192: aload 4
    //   194: athrow
    //   195: aload 5
    //   197: invokevirtual 272	java/util/zip/ZipOutputStream:close	()V
    //   200: goto +20 -> 220
    //   203: astore_0
    //   204: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   207: ifeq +13 -> 220
    //   210: ldc 147
    //   212: iconst_2
    //   213: ldc_w 274
    //   216: aload_0
    //   217: invokestatic 276	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   220: aload_3
    //   221: invokevirtual 222	java/io/BufferedOutputStream:close	()V
    //   224: goto +20 -> 244
    //   227: astore_0
    //   228: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   231: ifeq +13 -> 244
    //   234: ldc 147
    //   236: iconst_2
    //   237: ldc_w 274
    //   240: aload_0
    //   241: invokestatic 276	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   244: aload_1
    //   245: invokevirtual 277	java/io/FileOutputStream:close	()V
    //   248: return
    //   249: astore_0
    //   250: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   253: ifeq +209 -> 462
    //   256: ldc 147
    //   258: iconst_2
    //   259: ldc_w 274
    //   262: aload_0
    //   263: invokestatic 276	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   266: return
    //   267: astore_0
    //   268: aload_1
    //   269: astore 4
    //   271: aload 5
    //   273: astore_1
    //   274: goto +196 -> 470
    //   277: astore_0
    //   278: aload 5
    //   280: astore 7
    //   282: aload_1
    //   283: astore 5
    //   285: aload_3
    //   286: astore_1
    //   287: goto +58 -> 345
    //   290: astore_0
    //   291: aload_1
    //   292: astore 5
    //   294: aload_3
    //   295: astore_1
    //   296: goto +49 -> 345
    //   299: astore 5
    //   301: aconst_null
    //   302: astore_3
    //   303: aload_3
    //   304: astore_0
    //   305: aload_1
    //   306: astore 4
    //   308: aload_0
    //   309: astore_1
    //   310: aload 5
    //   312: astore_0
    //   313: goto +157 -> 470
    //   316: astore_0
    //   317: aconst_null
    //   318: astore_3
    //   319: aload_1
    //   320: astore 5
    //   322: aload_3
    //   323: astore_1
    //   324: goto +21 -> 345
    //   327: astore_0
    //   328: aconst_null
    //   329: astore_3
    //   330: aload_3
    //   331: astore 4
    //   333: aload 4
    //   335: astore_1
    //   336: goto +134 -> 470
    //   339: astore_0
    //   340: aconst_null
    //   341: astore_1
    //   342: aload_1
    //   343: astore 5
    //   345: aload 7
    //   347: astore 8
    //   349: aload 5
    //   351: astore 4
    //   353: aload_1
    //   354: astore 6
    //   356: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   359: ifeq +24 -> 383
    //   362: aload 7
    //   364: astore 8
    //   366: aload 5
    //   368: astore 4
    //   370: aload_1
    //   371: astore 6
    //   373: ldc 147
    //   375: iconst_2
    //   376: ldc_w 279
    //   379: aload_0
    //   380: invokestatic 276	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   383: aload 7
    //   385: ifnull +28 -> 413
    //   388: aload 7
    //   390: invokevirtual 272	java/util/zip/ZipOutputStream:close	()V
    //   393: goto +20 -> 413
    //   396: astore_0
    //   397: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   400: ifeq +13 -> 413
    //   403: ldc 147
    //   405: iconst_2
    //   406: ldc_w 274
    //   409: aload_0
    //   410: invokestatic 276	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   413: aload_1
    //   414: ifnull +27 -> 441
    //   417: aload_1
    //   418: invokevirtual 222	java/io/BufferedOutputStream:close	()V
    //   421: goto +20 -> 441
    //   424: astore_0
    //   425: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   428: ifeq +13 -> 441
    //   431: ldc 147
    //   433: iconst_2
    //   434: ldc_w 274
    //   437: aload_0
    //   438: invokestatic 276	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   441: aload 5
    //   443: ifnull +19 -> 462
    //   446: aload 5
    //   448: invokevirtual 277	java/io/FileOutputStream:close	()V
    //   451: return
    //   452: astore_0
    //   453: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   456: ifeq +6 -> 462
    //   459: goto -203 -> 256
    //   462: return
    //   463: astore_0
    //   464: aload 8
    //   466: astore_1
    //   467: aload 6
    //   469: astore_3
    //   470: aload_1
    //   471: ifnull +27 -> 498
    //   474: aload_1
    //   475: invokevirtual 272	java/util/zip/ZipOutputStream:close	()V
    //   478: goto +20 -> 498
    //   481: astore_1
    //   482: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   485: ifeq +13 -> 498
    //   488: ldc 147
    //   490: iconst_2
    //   491: ldc_w 274
    //   494: aload_1
    //   495: invokestatic 276	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   498: aload_3
    //   499: ifnull +27 -> 526
    //   502: aload_3
    //   503: invokevirtual 222	java/io/BufferedOutputStream:close	()V
    //   506: goto +20 -> 526
    //   509: astore_1
    //   510: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   513: ifeq +13 -> 526
    //   516: ldc 147
    //   518: iconst_2
    //   519: ldc_w 274
    //   522: aload_1
    //   523: invokestatic 276	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   526: aload 4
    //   528: ifnull +28 -> 556
    //   531: aload 4
    //   533: invokevirtual 277	java/io/FileOutputStream:close	()V
    //   536: goto +20 -> 556
    //   539: astore_1
    //   540: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   543: ifeq +13 -> 556
    //   546: ldc 147
    //   548: iconst_2
    //   549: ldc_w 274
    //   552: aload_1
    //   553: invokestatic 276	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   556: goto +5 -> 561
    //   559: aload_0
    //   560: athrow
    //   561: goto -2 -> 559
    //   564: astore 4
    //   566: goto -392 -> 174
    //   569: astore 4
    //   571: aconst_null
    //   572: astore_0
    //   573: goto -399 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	576	0	paramList	java.util.List<String>
    //   0	576	1	paramString	String
    //   139	12	2	i	int
    //   30	473	3	localObject1	Object
    //   32	500	4	localObject2	Object
    //   564	1	4	localObject3	Object
    //   569	1	4	localObject4	Object
    //   45	248	5	localObject5	Object
    //   299	12	5	localObject6	Object
    //   320	127	5	str	String
    //   35	433	6	localObject7	Object
    //   4	385	7	localObject8	Object
    //   1	464	8	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   195	200	203	java/io/IOException
    //   220	224	227	java/io/IOException
    //   244	248	249	java/io/IOException
    //   47	55	267	finally
    //   55	113	267	finally
    //   157	171	267	finally
    //   178	182	267	finally
    //   182	195	267	finally
    //   47	55	277	java/lang/Exception
    //   55	113	277	java/lang/Exception
    //   157	171	277	java/lang/Exception
    //   178	182	277	java/lang/Exception
    //   182	195	277	java/lang/Exception
    //   37	47	290	java/lang/Exception
    //   22	31	299	finally
    //   22	31	316	java/lang/Exception
    //   6	22	327	finally
    //   6	22	339	java/lang/Exception
    //   388	393	396	java/io/IOException
    //   417	421	424	java/io/IOException
    //   446	451	452	java/io/IOException
    //   37	47	463	finally
    //   356	362	463	finally
    //   373	383	463	finally
    //   474	478	481	java/io/IOException
    //   502	506	509	java/io/IOException
    //   531	536	539	java/io/IOException
    //   122	129	564	finally
    //   129	140	564	finally
    //   145	154	564	finally
    //   113	122	569	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.opt.clearmemory.DexPathListHook
 * JD-Core Version:    0.7.0.1
 */