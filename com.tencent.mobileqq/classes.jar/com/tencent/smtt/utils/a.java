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
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 20)
        {
          if (!TbsExtensionFunctionManager.getInstance().canUseFunction(paramContext, "disable_get_apk_version_switch.txt"))
          {
            bool = true;
            int i = a(paramContext, paramFile, bool);
            return i;
          }
          bool = false;
          continue;
        }
        boolean bool = false;
      }
      catch (Exception paramContext)
      {
        TbsLog.i("ApkUtil", "getApkVersion Failed");
        return 0;
      }
    }
  }
  
  public static int a(Context paramContext, File paramFile, boolean paramBoolean)
  {
    if (paramFile != null) {}
    for (;;)
    {
      int i;
      try
      {
        if (paramFile.exists())
        {
          boolean bool1 = paramFile.getName().contains("tbs.org");
          boolean bool2 = paramFile.getName().contains("x5.tbs.decouple");
          int j;
          if ((bool1) || (bool2))
          {
            i = a(bool2, paramFile);
            if (i > 0) {
              return i;
            }
            if (!TbsShareManager.isThirdPartyApp(paramContext)) {}
          }
          else
          {
            if (((Build.VERSION.SDK_INT != 23) && (Build.VERSION.SDK_INT != 25)) || (!Build.MANUFACTURER.toLowerCase().contains("mi"))) {
              break label211;
            }
            i = 1;
            TbsPVConfig.releaseInstance();
            j = TbsPVConfig.getInstance(paramContext).getReadApk();
            if (j != 1) {
              continue;
            }
            i = 0;
            paramBoolean = false;
            break label218;
            label120:
            i = b(paramFile);
            if (i <= 0) {
              break label169;
            }
            return i;
          }
          bool1 = paramFile.getAbsolutePath().contains(paramContext.getApplicationInfo().packageName);
          if (bool1) {
            continue;
          }
          return 0;
          if (j != 2) {
            break label218;
          }
          return 0;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      label169:
      label211:
      label216:
      label218:
      do
      {
        if ((paramFile != null) && (paramFile.exists()))
        {
          try
          {
            paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramFile.getAbsolutePath(), 1);
            if (paramContext == null) {
              break label216;
            }
            i = paramContext.versionCode;
            return i;
          }
          catch (Throwable paramContext)
          {
            paramContext.printStackTrace();
            return -1;
          }
          i = 0;
          break;
        }
        return 0;
        if (paramBoolean) {
          break label120;
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
        Pattern localPattern = Pattern.compile(a(paramBoolean) + "(.*)");
        int j = paramFile.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = paramFile[i];
          if ((localPattern.matcher(localObject.getName()).find()) && (localObject.isFile()) && (localObject.exists()))
          {
            i = Integer.parseInt(localObject.getName().substring(localObject.getName().lastIndexOf(".") + 1));
            return i;
          }
          i += 1;
        }
      }
      return -1;
    }
    catch (Exception paramFile) {}
  }
  
  /* Error */
  public static String a(File paramFile)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: bipush 16
    //   4: newarray char
    //   6: astore 6
    //   8: aload 6
    //   10: dup
    //   11: iconst_0
    //   12: ldc 194
    //   14: castore
    //   15: dup
    //   16: iconst_1
    //   17: ldc 195
    //   19: castore
    //   20: dup
    //   21: iconst_2
    //   22: ldc 196
    //   24: castore
    //   25: dup
    //   26: iconst_3
    //   27: ldc 197
    //   29: castore
    //   30: dup
    //   31: iconst_4
    //   32: ldc 198
    //   34: castore
    //   35: dup
    //   36: iconst_5
    //   37: ldc 199
    //   39: castore
    //   40: dup
    //   41: bipush 6
    //   43: ldc 200
    //   45: castore
    //   46: dup
    //   47: bipush 7
    //   49: ldc 201
    //   51: castore
    //   52: dup
    //   53: bipush 8
    //   55: ldc 202
    //   57: castore
    //   58: dup
    //   59: bipush 9
    //   61: ldc 203
    //   63: castore
    //   64: dup
    //   65: bipush 10
    //   67: ldc 204
    //   69: castore
    //   70: dup
    //   71: bipush 11
    //   73: ldc 205
    //   75: castore
    //   76: dup
    //   77: bipush 12
    //   79: ldc 206
    //   81: castore
    //   82: dup
    //   83: bipush 13
    //   85: ldc 207
    //   87: castore
    //   88: dup
    //   89: bipush 14
    //   91: ldc 208
    //   93: castore
    //   94: dup
    //   95: bipush 15
    //   97: ldc 209
    //   99: castore
    //   100: pop
    //   101: bipush 32
    //   103: newarray char
    //   105: astore 7
    //   107: ldc 211
    //   109: invokestatic 216	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   112: astore 8
    //   114: new 218	java/io/FileInputStream
    //   117: dup
    //   118: aload_0
    //   119: invokespecial 221	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   122: astore 5
    //   124: aload 5
    //   126: astore_0
    //   127: sipush 8192
    //   130: newarray byte
    //   132: astore 9
    //   134: aload 5
    //   136: astore_0
    //   137: aload 5
    //   139: aload 9
    //   141: invokevirtual 225	java/io/FileInputStream:read	([B)I
    //   144: istore_2
    //   145: iload_2
    //   146: iconst_m1
    //   147: if_icmpeq +42 -> 189
    //   150: aload 5
    //   152: astore_0
    //   153: aload 8
    //   155: aload 9
    //   157: iconst_0
    //   158: iload_2
    //   159: invokevirtual 229	java/security/MessageDigest:update	([BII)V
    //   162: goto -28 -> 134
    //   165: astore 6
    //   167: aload 5
    //   169: astore_0
    //   170: aload 6
    //   172: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   175: aload 5
    //   177: ifnull +8 -> 185
    //   180: aload 5
    //   182: invokevirtual 233	java/io/FileInputStream:close	()V
    //   185: aconst_null
    //   186: astore_0
    //   187: aload_0
    //   188: areturn
    //   189: aload 5
    //   191: astore_0
    //   192: aload 8
    //   194: invokevirtual 237	java/security/MessageDigest:digest	()[B
    //   197: astore 8
    //   199: iconst_0
    //   200: istore_2
    //   201: goto +85 -> 286
    //   204: aload 5
    //   206: astore_0
    //   207: new 60	java/lang/String
    //   210: dup
    //   211: aload 7
    //   213: invokespecial 240	java/lang/String:<init>	([C)V
    //   216: astore 6
    //   218: aload 6
    //   220: astore_0
    //   221: aload 5
    //   223: ifnull -36 -> 187
    //   226: aload 5
    //   228: invokevirtual 233	java/io/FileInputStream:close	()V
    //   231: aload 6
    //   233: areturn
    //   234: astore_0
    //   235: aload_0
    //   236: invokevirtual 241	java/io/IOException:printStackTrace	()V
    //   239: aload 6
    //   241: areturn
    //   242: astore_0
    //   243: aload_0
    //   244: invokevirtual 241	java/io/IOException:printStackTrace	()V
    //   247: goto -62 -> 185
    //   250: astore 5
    //   252: aconst_null
    //   253: astore_0
    //   254: aload_0
    //   255: ifnull +7 -> 262
    //   258: aload_0
    //   259: invokevirtual 233	java/io/FileInputStream:close	()V
    //   262: aload 5
    //   264: athrow
    //   265: astore_0
    //   266: aload_0
    //   267: invokevirtual 241	java/io/IOException:printStackTrace	()V
    //   270: goto -8 -> 262
    //   273: astore 5
    //   275: goto -21 -> 254
    //   278: astore 6
    //   280: aconst_null
    //   281: astore 5
    //   283: goto -116 -> 167
    //   286: iload_1
    //   287: bipush 16
    //   289: if_icmpge -85 -> 204
    //   292: aload 8
    //   294: iload_1
    //   295: baload
    //   296: istore_3
    //   297: iload_2
    //   298: iconst_1
    //   299: iadd
    //   300: istore 4
    //   302: aload 7
    //   304: iload_2
    //   305: aload 6
    //   307: iload_3
    //   308: iconst_4
    //   309: iushr
    //   310: bipush 15
    //   312: iand
    //   313: caload
    //   314: castore
    //   315: iload 4
    //   317: iconst_1
    //   318: iadd
    //   319: istore_2
    //   320: aload 7
    //   322: iload 4
    //   324: aload 6
    //   326: iload_3
    //   327: bipush 15
    //   329: iand
    //   330: caload
    //   331: castore
    //   332: iload_1
    //   333: iconst_1
    //   334: iadd
    //   335: istore_1
    //   336: goto -50 -> 286
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	paramFile	File
    //   1	335	1	i	int
    //   144	176	2	j	int
    //   296	34	3	k	int
    //   300	23	4	m	int
    //   122	105	5	localFileInputStream	java.io.FileInputStream
    //   250	13	5	localObject1	Object
    //   273	1	5	localObject2	Object
    //   281	1	5	localObject3	Object
    //   6	3	6	arrayOfChar1	char[]
    //   165	6	6	localException1	Exception
    //   216	24	6	str	String
    //   278	47	6	localException2	Exception
    //   105	216	7	arrayOfChar2	char[]
    //   112	181	8	localObject4	Object
    //   132	24	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   127	134	165	java/lang/Exception
    //   137	145	165	java/lang/Exception
    //   153	162	165	java/lang/Exception
    //   192	199	165	java/lang/Exception
    //   207	218	165	java/lang/Exception
    //   226	231	234	java/io/IOException
    //   180	185	242	java/io/IOException
    //   107	124	250	finally
    //   258	262	265	java/io/IOException
    //   127	134	273	finally
    //   137	145	273	finally
    //   153	162	273	finally
    //   170	175	273	finally
    //   192	199	273	finally
    //   207	218	273	finally
    //   107	124	278	java/lang/Exception
  }
  
  public static final String a(boolean paramBoolean)
  {
    if (b.c())
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
    if ((paramFile == null) || (!paramFile.exists())) {}
    for (;;)
    {
      return false;
      if ((paramLong <= 0L) || (paramLong == paramFile.length())) {
        try
        {
          if (paramInt == a(paramContext, paramFile))
          {
            boolean bool = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(b.a(paramContext, true, paramFile));
            if (bool) {
              return true;
            }
          }
        }
        catch (Exception paramContext) {}
      }
    }
    return false;
  }
  
  /* Error */
  public static int b(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: new 272	java/util/jar/JarFile
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 273	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   13: astore_3
    //   14: new 275	java/io/BufferedReader
    //   17: dup
    //   18: new 277	java/io/InputStreamReader
    //   21: dup
    //   22: aload_3
    //   23: aload_3
    //   24: ldc_w 279
    //   27: invokevirtual 283	java/util/jar/JarFile:getJarEntry	(Ljava/lang/String;)Ljava/util/jar/JarEntry;
    //   30: invokevirtual 287	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   33: invokespecial 290	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   36: invokespecial 293	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   39: astore_0
    //   40: aload_0
    //   41: invokevirtual 296	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   44: astore_2
    //   45: aload_2
    //   46: ifnull +62 -> 108
    //   49: aload_2
    //   50: ldc_w 298
    //   53: invokevirtual 64	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   56: ifeq -16 -> 40
    //   59: aload_2
    //   60: ldc_w 300
    //   63: invokevirtual 304	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   66: astore_2
    //   67: aload_2
    //   68: ifnull -28 -> 40
    //   71: aload_2
    //   72: arraylength
    //   73: iconst_2
    //   74: if_icmpne -34 -> 40
    //   77: aload_2
    //   78: iconst_1
    //   79: aaload
    //   80: invokevirtual 307	java/lang/String:trim	()Ljava/lang/String;
    //   83: invokestatic 190	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   86: istore_1
    //   87: aload_0
    //   88: ifnull +7 -> 95
    //   91: aload_0
    //   92: invokevirtual 308	java/io/BufferedReader:close	()V
    //   95: aload_3
    //   96: ifnull +7 -> 103
    //   99: aload_3
    //   100: invokevirtual 309	java/util/jar/JarFile:close	()V
    //   103: ldc 2
    //   105: monitorexit
    //   106: iload_1
    //   107: ireturn
    //   108: aload_0
    //   109: ifnull +7 -> 116
    //   112: aload_0
    //   113: invokevirtual 308	java/io/BufferedReader:close	()V
    //   116: aload_3
    //   117: ifnull +7 -> 124
    //   120: aload_3
    //   121: invokevirtual 309	java/util/jar/JarFile:close	()V
    //   124: ldc 2
    //   126: monitorexit
    //   127: iconst_m1
    //   128: ireturn
    //   129: astore_0
    //   130: ldc 2
    //   132: monitorexit
    //   133: aload_0
    //   134: athrow
    //   135: astore_3
    //   136: aconst_null
    //   137: astore_0
    //   138: aload_3
    //   139: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   142: aload_0
    //   143: ifnull +7 -> 150
    //   146: aload_0
    //   147: invokevirtual 308	java/io/BufferedReader:close	()V
    //   150: aload_2
    //   151: ifnull -27 -> 124
    //   154: aload_2
    //   155: invokevirtual 309	java/util/jar/JarFile:close	()V
    //   158: goto -34 -> 124
    //   161: astore_0
    //   162: goto -38 -> 124
    //   165: astore_2
    //   166: aconst_null
    //   167: astore_0
    //   168: aconst_null
    //   169: astore_3
    //   170: aload_0
    //   171: ifnull +7 -> 178
    //   174: aload_0
    //   175: invokevirtual 308	java/io/BufferedReader:close	()V
    //   178: aload_3
    //   179: ifnull +7 -> 186
    //   182: aload_3
    //   183: invokevirtual 309	java/util/jar/JarFile:close	()V
    //   186: aload_2
    //   187: athrow
    //   188: astore_0
    //   189: goto -3 -> 186
    //   192: astore_2
    //   193: aconst_null
    //   194: astore_0
    //   195: goto -25 -> 170
    //   198: astore_2
    //   199: goto -29 -> 170
    //   202: astore 4
    //   204: aload_2
    //   205: astore_3
    //   206: aload 4
    //   208: astore_2
    //   209: goto -39 -> 170
    //   212: astore 4
    //   214: aconst_null
    //   215: astore_0
    //   216: aload_3
    //   217: astore_2
    //   218: aload 4
    //   220: astore_3
    //   221: goto -83 -> 138
    //   224: astore 4
    //   226: aload_3
    //   227: astore_2
    //   228: aload 4
    //   230: astore_3
    //   231: goto -93 -> 138
    //   234: astore_0
    //   235: goto -111 -> 124
    //   238: astore_0
    //   239: goto -136 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	paramFile	File
    //   86	21	1	i	int
    //   1	154	2	localObject1	Object
    //   165	22	2	localObject2	Object
    //   192	1	2	localObject3	Object
    //   198	7	2	localObject4	Object
    //   208	20	2	localObject5	Object
    //   13	108	3	localJarFile	java.util.jar.JarFile
    //   135	4	3	localException1	Exception
    //   169	62	3	localObject6	Object
    //   202	5	4	localObject7	Object
    //   212	7	4	localException2	Exception
    //   224	5	4	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   91	95	129	finally
    //   99	103	129	finally
    //   103	106	129	finally
    //   112	116	129	finally
    //   120	124	129	finally
    //   124	127	129	finally
    //   130	133	129	finally
    //   146	150	129	finally
    //   154	158	129	finally
    //   174	178	129	finally
    //   182	186	129	finally
    //   186	188	129	finally
    //   5	14	135	java/lang/Exception
    //   146	150	161	java/lang/Exception
    //   154	158	161	java/lang/Exception
    //   5	14	165	finally
    //   174	178	188	java/lang/Exception
    //   182	186	188	java/lang/Exception
    //   14	40	192	finally
    //   40	45	198	finally
    //   49	67	198	finally
    //   71	87	198	finally
    //   138	142	202	finally
    //   14	40	212	java/lang/Exception
    //   40	45	224	java/lang/Exception
    //   49	67	224	java/lang/Exception
    //   71	87	224	java/lang/Exception
    //   112	116	234	java/lang/Exception
    //   120	124	234	java/lang/Exception
    //   91	95	238	java/lang/Exception
    //   99	103	238	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.utils.a
 * JD-Core Version:    0.7.0.1
 */