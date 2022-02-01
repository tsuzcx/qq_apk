package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.smtt.sdk.TbsExtensionFunctionManager;
import com.tencent.smtt.sdk.TbsPVConfig;
import com.tencent.smtt.sdk.TbsShareManager;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a
{
  public static int a(Context paramContext, File paramFile)
  {
    try
    {
      if (Build.VERSION.SDK_INT < 20) {
        break label45;
      }
      bool = TbsExtensionFunctionManager.getInstance().canUseFunction(paramContext, "disable_get_apk_version_switch.txt") ^ true;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        int i;
        continue;
        label45:
        boolean bool = false;
      }
    }
    i = a(paramContext, paramFile, bool);
    return i;
    TbsLog.i("ApkUtil", "getApkVersion Failed");
    return 0;
  }
  
  public static int a(Context paramContext, File paramFile, boolean paramBoolean)
  {
    if (paramFile != null) {}
    for (;;)
    {
      int j;
      try
      {
        if (!paramFile.exists()) {
          break label163;
        }
        boolean bool1 = paramFile.getName().contains("tbs.org");
        boolean bool2 = paramFile.getName().contains("x5.tbs.decouple");
        if ((bool1) || (bool2))
        {
          i = a(bool2, paramFile);
          if (i > 0) {
            return i;
          }
          if ((!TbsShareManager.isThirdPartyApp(paramContext)) && (!paramFile.getAbsolutePath().contains(paramContext.getApplicationInfo().packageName))) {
            return 0;
          }
        }
        if (((Build.VERSION.SDK_INT != 23) && (Build.VERSION.SDK_INT != 25)) || (!Build.MANUFACTURER.toLowerCase().contains("mi"))) {
          break label207;
        }
        i = 1;
        TbsPVConfig.releaseInstance();
        j = TbsPVConfig.getInstance(paramContext).getReadApk();
        if (j != 1) {
          break label212;
        }
        paramBoolean = false;
        i = 0;
      }
      catch (Throwable localThrowable)
      {
        label145:
        localThrowable.printStackTrace();
      }
      int i = b(paramFile);
      if (i > 0) {
        return i;
      }
      label163:
      label207:
      label212:
      do
      {
        if ((paramFile != null) && (paramFile.exists())) {
          try
          {
            paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramFile.getAbsolutePath(), 1);
            if (paramContext != null)
            {
              i = paramContext.versionCode;
              return i;
            }
          }
          catch (Throwable paramContext)
          {
            paramContext.printStackTrace();
            return -1;
          }
        }
        return 0;
        i = 0;
        break;
        if (j == 2) {
          return 0;
        }
        if (paramBoolean) {
          break label145;
        }
      } while (i == 0);
    }
  }
  
  private static int a(boolean paramBoolean, File paramFile)
  {
    try
    {
      paramFile = paramFile.getParentFile();
      if (paramFile != null)
      {
        paramFile = paramFile.listFiles();
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(a(paramBoolean));
        ((StringBuilder)localObject1).append("(.*)");
        localObject1 = Pattern.compile(((StringBuilder)localObject1).toString());
        int j = paramFile.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = paramFile[i];
          if ((((Pattern)localObject1).matcher(localObject2.getName()).find()) && (localObject2.isFile()) && (localObject2.exists()))
          {
            i = Integer.parseInt(localObject2.getName().substring(localObject2.getName().lastIndexOf(".") + 1));
            return i;
          }
          i += 1;
        }
      }
    }
    catch (Exception paramFile)
    {
      label131:
      break label131;
    }
    return -1;
  }
  
  /* Error */
  public static String a(File paramFile)
  {
    // Byte code:
    //   0: bipush 16
    //   2: newarray char
    //   4: astore 6
    //   6: aload 6
    //   8: dup
    //   9: iconst_0
    //   10: ldc 194
    //   12: castore
    //   13: dup
    //   14: iconst_1
    //   15: ldc 195
    //   17: castore
    //   18: dup
    //   19: iconst_2
    //   20: ldc 196
    //   22: castore
    //   23: dup
    //   24: iconst_3
    //   25: ldc 197
    //   27: castore
    //   28: dup
    //   29: iconst_4
    //   30: ldc 198
    //   32: castore
    //   33: dup
    //   34: iconst_5
    //   35: ldc 199
    //   37: castore
    //   38: dup
    //   39: bipush 6
    //   41: ldc 200
    //   43: castore
    //   44: dup
    //   45: bipush 7
    //   47: ldc 201
    //   49: castore
    //   50: dup
    //   51: bipush 8
    //   53: ldc 202
    //   55: castore
    //   56: dup
    //   57: bipush 9
    //   59: ldc 203
    //   61: castore
    //   62: dup
    //   63: bipush 10
    //   65: ldc 204
    //   67: castore
    //   68: dup
    //   69: bipush 11
    //   71: ldc 205
    //   73: castore
    //   74: dup
    //   75: bipush 12
    //   77: ldc 206
    //   79: castore
    //   80: dup
    //   81: bipush 13
    //   83: ldc 207
    //   85: castore
    //   86: dup
    //   87: bipush 14
    //   89: ldc 208
    //   91: castore
    //   92: dup
    //   93: bipush 15
    //   95: ldc 209
    //   97: castore
    //   98: pop
    //   99: bipush 32
    //   101: newarray char
    //   103: astore 7
    //   105: ldc 211
    //   107: invokestatic 216	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   110: astore 8
    //   112: new 218	java/io/FileInputStream
    //   115: dup
    //   116: aload_0
    //   117: invokespecial 221	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   120: astore 5
    //   122: aload 5
    //   124: astore_0
    //   125: sipush 8192
    //   128: newarray byte
    //   130: astore 9
    //   132: aload 5
    //   134: astore_0
    //   135: aload 5
    //   137: aload 9
    //   139: invokevirtual 225	java/io/FileInputStream:read	([B)I
    //   142: istore_1
    //   143: iconst_0
    //   144: istore_2
    //   145: iload_1
    //   146: iconst_m1
    //   147: if_icmpeq +18 -> 165
    //   150: aload 5
    //   152: astore_0
    //   153: aload 8
    //   155: aload 9
    //   157: iconst_0
    //   158: iload_1
    //   159: invokevirtual 229	java/security/MessageDigest:update	([BII)V
    //   162: goto -30 -> 132
    //   165: aload 5
    //   167: astore_0
    //   168: aload 8
    //   170: invokevirtual 233	java/security/MessageDigest:digest	()[B
    //   173: astore 8
    //   175: iconst_0
    //   176: istore_1
    //   177: goto +104 -> 281
    //   180: aload 5
    //   182: astore_0
    //   183: new 60	java/lang/String
    //   186: dup
    //   187: aload 7
    //   189: invokespecial 236	java/lang/String:<init>	([C)V
    //   192: astore 6
    //   194: aload 5
    //   196: invokevirtual 239	java/io/FileInputStream:close	()V
    //   199: aload 6
    //   201: areturn
    //   202: astore_0
    //   203: aload_0
    //   204: invokevirtual 240	java/io/IOException:printStackTrace	()V
    //   207: aload 6
    //   209: areturn
    //   210: astore 6
    //   212: goto +15 -> 227
    //   215: astore 5
    //   217: aconst_null
    //   218: astore_0
    //   219: goto +37 -> 256
    //   222: astore 6
    //   224: aconst_null
    //   225: astore 5
    //   227: aload 5
    //   229: astore_0
    //   230: aload 6
    //   232: invokevirtual 241	java/lang/Exception:printStackTrace	()V
    //   235: aload 5
    //   237: ifnull +15 -> 252
    //   240: aload 5
    //   242: invokevirtual 239	java/io/FileInputStream:close	()V
    //   245: aconst_null
    //   246: areturn
    //   247: astore_0
    //   248: aload_0
    //   249: invokevirtual 240	java/io/IOException:printStackTrace	()V
    //   252: aconst_null
    //   253: areturn
    //   254: astore 5
    //   256: aload_0
    //   257: ifnull +15 -> 272
    //   260: aload_0
    //   261: invokevirtual 239	java/io/FileInputStream:close	()V
    //   264: goto +8 -> 272
    //   267: astore_0
    //   268: aload_0
    //   269: invokevirtual 240	java/io/IOException:printStackTrace	()V
    //   272: goto +6 -> 278
    //   275: aload 5
    //   277: athrow
    //   278: goto -3 -> 275
    //   281: iload_2
    //   282: bipush 16
    //   284: if_icmpge -104 -> 180
    //   287: aload 8
    //   289: iload_2
    //   290: baload
    //   291: istore_3
    //   292: iload_1
    //   293: iconst_1
    //   294: iadd
    //   295: istore 4
    //   297: aload 7
    //   299: iload_1
    //   300: aload 6
    //   302: iload_3
    //   303: iconst_4
    //   304: iushr
    //   305: bipush 15
    //   307: iand
    //   308: caload
    //   309: castore
    //   310: iload 4
    //   312: iconst_1
    //   313: iadd
    //   314: istore_1
    //   315: aload 7
    //   317: iload 4
    //   319: aload 6
    //   321: iload_3
    //   322: bipush 15
    //   324: iand
    //   325: caload
    //   326: castore
    //   327: iload_2
    //   328: iconst_1
    //   329: iadd
    //   330: istore_2
    //   331: goto -50 -> 281
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	paramFile	File
    //   142	173	1	i	int
    //   144	187	2	j	int
    //   291	34	3	k	int
    //   295	23	4	m	int
    //   120	75	5	localFileInputStream	java.io.FileInputStream
    //   215	1	5	localObject1	Object
    //   225	16	5	localObject2	Object
    //   254	22	5	localObject3	Object
    //   4	204	6	localObject4	Object
    //   210	1	6	localException1	Exception
    //   222	98	6	localException2	Exception
    //   103	213	7	arrayOfChar	char[]
    //   110	178	8	localObject5	Object
    //   130	26	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   194	199	202	java/io/IOException
    //   125	132	210	java/lang/Exception
    //   135	143	210	java/lang/Exception
    //   153	162	210	java/lang/Exception
    //   168	175	210	java/lang/Exception
    //   183	194	210	java/lang/Exception
    //   105	122	215	finally
    //   105	122	222	java/lang/Exception
    //   240	245	247	java/io/IOException
    //   125	132	254	finally
    //   135	143	254	finally
    //   153	162	254	finally
    //   168	175	254	finally
    //   183	194	254	finally
    //   230	235	254	finally
    //   260	264	267	java/io/IOException
  }
  
  public static final String a(boolean paramBoolean)
  {
    if (b.d())
    {
      if (paramBoolean) {
        return "x5.64.decouple.backup";
      }
      return "x5.64.backup";
    }
    if (paramBoolean) {
      return "x5.decouple.backup";
    }
    return "x5.backup";
  }
  
  public static boolean a(Context paramContext, File paramFile, long paramLong, int paramInt)
  {
    if (paramFile != null)
    {
      if (!paramFile.exists()) {
        return false;
      }
      if ((paramLong > 0L) && (paramLong != paramFile.length())) {
        return false;
      }
    }
    try
    {
      if (paramInt != a(paramContext, paramFile)) {
        return false;
      }
      boolean bool = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(b.a(paramContext, true, paramFile));
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
    return false;
  }
  
  /* Error */
  public static int b(File paramFile)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore_2
    //   7: aconst_null
    //   8: astore 6
    //   10: new 272	java/util/jar/JarFile
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 273	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   18: astore_0
    //   19: aload_3
    //   20: astore_2
    //   21: aload_0
    //   22: astore_3
    //   23: new 275	java/io/BufferedReader
    //   26: dup
    //   27: new 277	java/io/InputStreamReader
    //   30: dup
    //   31: aload_0
    //   32: aload_0
    //   33: ldc_w 279
    //   36: invokevirtual 283	java/util/jar/JarFile:getJarEntry	(Ljava/lang/String;)Ljava/util/jar/JarEntry;
    //   39: invokevirtual 287	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   42: invokespecial 290	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   45: invokespecial 293	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   48: astore 4
    //   50: aload 4
    //   52: invokevirtual 296	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   55: astore_2
    //   56: aload_2
    //   57: ifnull +55 -> 112
    //   60: aload_2
    //   61: ldc_w 298
    //   64: invokevirtual 64	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   67: ifeq -17 -> 50
    //   70: aload_2
    //   71: ldc_w 300
    //   74: invokevirtual 304	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   77: astore_2
    //   78: aload_2
    //   79: ifnull -29 -> 50
    //   82: aload_2
    //   83: arraylength
    //   84: iconst_2
    //   85: if_icmpne -35 -> 50
    //   88: aload_2
    //   89: iconst_1
    //   90: aaload
    //   91: invokevirtual 307	java/lang/String:trim	()Ljava/lang/String;
    //   94: invokestatic 190	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   97: istore_1
    //   98: aload 4
    //   100: invokevirtual 308	java/io/BufferedReader:close	()V
    //   103: aload_0
    //   104: invokevirtual 309	java/util/jar/JarFile:close	()V
    //   107: ldc 2
    //   109: monitorexit
    //   110: iload_1
    //   111: ireturn
    //   112: aload 4
    //   114: invokevirtual 308	java/io/BufferedReader:close	()V
    //   117: aload_0
    //   118: invokevirtual 309	java/util/jar/JarFile:close	()V
    //   121: goto +76 -> 197
    //   124: astore_3
    //   125: aload 4
    //   127: astore_2
    //   128: aload_3
    //   129: astore 4
    //   131: goto +75 -> 206
    //   134: astore 5
    //   136: goto +27 -> 163
    //   139: astore 5
    //   141: aload 6
    //   143: astore 4
    //   145: goto +18 -> 163
    //   148: astore 4
    //   150: aconst_null
    //   151: astore_0
    //   152: goto +54 -> 206
    //   155: astore 5
    //   157: aconst_null
    //   158: astore_0
    //   159: aload 6
    //   161: astore 4
    //   163: aload 4
    //   165: astore_2
    //   166: aload_0
    //   167: astore_3
    //   168: aload 5
    //   170: invokevirtual 241	java/lang/Exception:printStackTrace	()V
    //   173: aload 4
    //   175: ifnull +15 -> 190
    //   178: aload 4
    //   180: invokevirtual 308	java/io/BufferedReader:close	()V
    //   183: goto +7 -> 190
    //   186: astore_0
    //   187: goto +38 -> 225
    //   190: aload_0
    //   191: ifnull +6 -> 197
    //   194: goto -77 -> 117
    //   197: ldc 2
    //   199: monitorexit
    //   200: iconst_m1
    //   201: ireturn
    //   202: astore 4
    //   204: aload_3
    //   205: astore_0
    //   206: aload_2
    //   207: ifnull +7 -> 214
    //   210: aload_2
    //   211: invokevirtual 308	java/io/BufferedReader:close	()V
    //   214: aload_0
    //   215: ifnull +7 -> 222
    //   218: aload_0
    //   219: invokevirtual 309	java/util/jar/JarFile:close	()V
    //   222: aload 4
    //   224: athrow
    //   225: ldc 2
    //   227: monitorexit
    //   228: goto +5 -> 233
    //   231: aload_0
    //   232: athrow
    //   233: goto -2 -> 231
    //   236: astore_0
    //   237: goto -130 -> 107
    //   240: astore_0
    //   241: goto -44 -> 197
    //   244: astore_0
    //   245: goto -23 -> 222
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	paramFile	File
    //   97	14	1	i	int
    //   6	205	2	localObject1	Object
    //   4	19	3	localFile1	File
    //   124	5	3	localObject2	Object
    //   167	38	3	localFile2	File
    //   48	96	4	localObject3	Object
    //   148	1	4	localObject4	Object
    //   161	18	4	localObject5	Object
    //   202	21	4	localObject6	Object
    //   134	1	5	localException1	Exception
    //   139	1	5	localException2	Exception
    //   155	14	5	localException3	Exception
    //   8	152	6	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   50	56	124	finally
    //   60	78	124	finally
    //   82	98	124	finally
    //   50	56	134	java/lang/Exception
    //   60	78	134	java/lang/Exception
    //   82	98	134	java/lang/Exception
    //   23	50	139	java/lang/Exception
    //   10	19	148	finally
    //   10	19	155	java/lang/Exception
    //   98	107	186	finally
    //   107	110	186	finally
    //   112	117	186	finally
    //   117	121	186	finally
    //   178	183	186	finally
    //   197	200	186	finally
    //   210	214	186	finally
    //   218	222	186	finally
    //   222	225	186	finally
    //   225	228	186	finally
    //   23	50	202	finally
    //   168	173	202	finally
    //   98	107	236	java/lang/Exception
    //   112	117	240	java/lang/Exception
    //   117	121	240	java/lang/Exception
    //   178	183	240	java/lang/Exception
    //   210	214	244	java/lang/Exception
    //   218	222	244	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.utils.a
 * JD-Core Version:    0.7.0.1
 */