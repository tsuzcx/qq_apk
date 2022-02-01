package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
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
    return a(paramBoolean, 0);
  }
  
  public static final String a(boolean paramBoolean, int paramInt)
  {
    boolean bool;
    if (paramInt == 64) {
      bool = true;
    } else if (paramInt == 32) {
      bool = false;
    } else {
      bool = b.b();
    }
    if (bool)
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
    if ((paramFile != null) && (paramFile.exists())) {
      if ((paramLong > 0L) && (paramLong != paramFile.length())) {
        paramContext = "verifyTbsApk return false #2";
      }
    }
    for (;;)
    {
      TbsLog.i("ApkUtil", paramContext);
      return false;
      try
      {
        int i = a(paramContext, paramFile);
        if (paramInt != i)
        {
          paramContext = new StringBuilder();
          paramContext.append("verifyTbsApk return false #3  versionCode is ");
          paramContext.append(i);
          paramContext.append(" apkVersion is ");
          paramContext.append(paramInt);
          TbsLog.i("ApkUtil", paramContext.toString());
          return false;
        }
        boolean bool = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(b.a(paramContext, true, paramFile));
        return bool;
      }
      catch (Exception paramContext)
      {
        paramFile = new StringBuilder();
        paramFile.append("verifyTbsApk false  stack is ");
        paramFile.append(Log.getStackTraceString(paramContext));
        paramContext = paramFile.toString();
      }
      continue;
      paramContext = "verifyTbsApk return false #1";
    }
  }
  
  /* Error */
  public static int b(File paramFile)
  {
    // Byte code:
    //   0: new 144	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: ldc_w 293
    //   12: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload_2
    //   17: aload_0
    //   18: invokevirtual 296	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_2
    //   23: ldc_w 298
    //   26: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_2
    //   31: aload_0
    //   32: invokevirtual 52	java/io/File:exists	()Z
    //   35: invokevirtual 301	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload_2
    //   40: ldc_w 303
    //   43: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload_2
    //   48: aload_0
    //   49: invokevirtual 306	java/io/File:canRead	()Z
    //   52: invokevirtual 301	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: ldc_w 308
    //   59: aload_2
    //   60: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 44	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: ldc 2
    //   68: monitorenter
    //   69: new 310	java/util/jar/JarFile
    //   72: dup
    //   73: aload_0
    //   74: invokespecial 311	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   77: astore_0
    //   78: new 313	java/io/BufferedReader
    //   81: dup
    //   82: new 315	java/io/InputStreamReader
    //   85: dup
    //   86: aload_0
    //   87: aload_0
    //   88: ldc_w 317
    //   91: invokevirtual 321	java/util/jar/JarFile:getJarEntry	(Ljava/lang/String;)Ljava/util/jar/JarEntry;
    //   94: invokevirtual 325	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   97: invokespecial 328	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   100: invokespecial 331	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   103: astore_2
    //   104: aload_0
    //   105: astore_3
    //   106: aload_2
    //   107: astore 4
    //   109: aload_2
    //   110: invokevirtual 334	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   113: astore 5
    //   115: aload 5
    //   117: ifnull +146 -> 263
    //   120: aload_0
    //   121: astore_3
    //   122: aload_2
    //   123: astore 4
    //   125: aload 5
    //   127: ldc_w 336
    //   130: invokevirtual 64	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   133: ifeq -29 -> 104
    //   136: aload_0
    //   137: astore_3
    //   138: aload_2
    //   139: astore 4
    //   141: aload 5
    //   143: ldc_w 338
    //   146: invokevirtual 342	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   149: astore 5
    //   151: aload 5
    //   153: ifnull -49 -> 104
    //   156: aload_0
    //   157: astore_3
    //   158: aload_2
    //   159: astore 4
    //   161: aload 5
    //   163: arraylength
    //   164: iconst_2
    //   165: if_icmpne -61 -> 104
    //   168: aload_0
    //   169: astore_3
    //   170: aload_2
    //   171: astore 4
    //   173: aload 5
    //   175: iconst_1
    //   176: aaload
    //   177: invokevirtual 345	java/lang/String:trim	()Ljava/lang/String;
    //   180: astore 5
    //   182: aload_0
    //   183: astore_3
    //   184: aload_2
    //   185: astore 4
    //   187: new 144	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   194: astore 6
    //   196: aload_0
    //   197: astore_3
    //   198: aload_2
    //   199: astore 4
    //   201: aload 6
    //   203: ldc_w 347
    //   206: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload_0
    //   211: astore_3
    //   212: aload_2
    //   213: astore 4
    //   215: aload 6
    //   217: aload 5
    //   219: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload_0
    //   224: astore_3
    //   225: aload_2
    //   226: astore 4
    //   228: ldc_w 308
    //   231: aload 6
    //   233: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 44	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: aload_0
    //   240: astore_3
    //   241: aload_2
    //   242: astore 4
    //   244: aload 5
    //   246: invokestatic 190	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   249: istore_1
    //   250: aload_2
    //   251: invokevirtual 348	java/io/BufferedReader:close	()V
    //   254: aload_0
    //   255: invokevirtual 349	java/util/jar/JarFile:close	()V
    //   258: ldc 2
    //   260: monitorexit
    //   261: iload_1
    //   262: ireturn
    //   263: aload_2
    //   264: invokevirtual 348	java/io/BufferedReader:close	()V
    //   267: aload_0
    //   268: invokevirtual 349	java/util/jar/JarFile:close	()V
    //   271: goto +69 -> 340
    //   274: astore 5
    //   276: goto +32 -> 308
    //   279: astore_2
    //   280: aconst_null
    //   281: astore 4
    //   283: goto +65 -> 348
    //   286: astore 5
    //   288: aconst_null
    //   289: astore_2
    //   290: goto +18 -> 308
    //   293: astore_2
    //   294: aconst_null
    //   295: astore_0
    //   296: aload_0
    //   297: astore 4
    //   299: goto +49 -> 348
    //   302: astore 5
    //   304: aconst_null
    //   305: astore_0
    //   306: aload_0
    //   307: astore_2
    //   308: aload_0
    //   309: astore_3
    //   310: aload_2
    //   311: astore 4
    //   313: aload 5
    //   315: invokestatic 352	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/Throwable;)V
    //   318: aload_2
    //   319: ifnull +14 -> 333
    //   322: aload_2
    //   323: invokevirtual 348	java/io/BufferedReader:close	()V
    //   326: goto +7 -> 333
    //   329: astore_0
    //   330: goto +38 -> 368
    //   333: aload_0
    //   334: ifnull +6 -> 340
    //   337: goto -70 -> 267
    //   340: ldc 2
    //   342: monitorexit
    //   343: iconst_m1
    //   344: ireturn
    //   345: astore_2
    //   346: aload_3
    //   347: astore_0
    //   348: aload 4
    //   350: ifnull +8 -> 358
    //   353: aload 4
    //   355: invokevirtual 348	java/io/BufferedReader:close	()V
    //   358: aload_0
    //   359: ifnull +7 -> 366
    //   362: aload_0
    //   363: invokevirtual 349	java/util/jar/JarFile:close	()V
    //   366: aload_2
    //   367: athrow
    //   368: ldc 2
    //   370: monitorexit
    //   371: goto +5 -> 376
    //   374: aload_0
    //   375: athrow
    //   376: goto -2 -> 374
    //   379: astore_0
    //   380: goto -122 -> 258
    //   383: astore_0
    //   384: goto -44 -> 340
    //   387: astore_0
    //   388: goto -22 -> 366
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	391	0	paramFile	File
    //   249	13	1	i	int
    //   7	257	2	localObject1	Object
    //   279	1	2	localObject2	Object
    //   289	1	2	localObject3	Object
    //   293	1	2	localObject4	Object
    //   307	16	2	localFile1	File
    //   345	22	2	localObject5	Object
    //   105	242	3	localFile2	File
    //   107	247	4	localObject6	Object
    //   113	132	5	localObject7	Object
    //   274	1	5	localException1	Exception
    //   286	1	5	localException2	Exception
    //   302	12	5	localException3	Exception
    //   194	38	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   109	115	274	java/lang/Exception
    //   125	136	274	java/lang/Exception
    //   141	151	274	java/lang/Exception
    //   161	168	274	java/lang/Exception
    //   173	182	274	java/lang/Exception
    //   187	196	274	java/lang/Exception
    //   201	210	274	java/lang/Exception
    //   215	223	274	java/lang/Exception
    //   228	239	274	java/lang/Exception
    //   244	250	274	java/lang/Exception
    //   78	104	279	finally
    //   78	104	286	java/lang/Exception
    //   69	78	293	finally
    //   69	78	302	java/lang/Exception
    //   250	258	329	finally
    //   258	261	329	finally
    //   263	267	329	finally
    //   267	271	329	finally
    //   322	326	329	finally
    //   340	343	329	finally
    //   353	358	329	finally
    //   362	366	329	finally
    //   366	368	329	finally
    //   368	371	329	finally
    //   109	115	345	finally
    //   125	136	345	finally
    //   141	151	345	finally
    //   161	168	345	finally
    //   173	182	345	finally
    //   187	196	345	finally
    //   201	210	345	finally
    //   215	223	345	finally
    //   228	239	345	finally
    //   244	250	345	finally
    //   313	318	345	finally
    //   250	258	379	java/lang/Exception
    //   263	267	383	java/lang/Exception
    //   267	271	383	java/lang/Exception
    //   322	326	383	java/lang/Exception
    //   353	358	387	java/lang/Exception
    //   362	366	387	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.utils.a
 * JD-Core Version:    0.7.0.1
 */