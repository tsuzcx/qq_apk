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

public class ApkUtil
{
  private static final String LOGTAG = "ApkUtil";
  public static final String TBS_APK_SIG = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a";
  public static final String TBS_BACKUP_APK_FILENAME_CONFIG = "x5.backup";
  public static final String TBS_BACKUP_APK_FILENAME_CONFIG_64 = "x5.64.backup";
  public static final String TBS_DECOPULE_BACKUP_APK_FILENAME_CONFIG = "x5.decouple.backup";
  public static final String TBS_DECOPULE_BACKUP_APK_FILENAME_CONFIG_64 = "x5.64.decouple.backup";
  
  public static int getApkVersion(Context paramContext, File paramFile)
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
            int i = getApkVersion(paramContext, paramFile, bool);
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
  
  public static int getApkVersion(Context paramContext, File paramFile, boolean paramBoolean)
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
            i = getBackupVersionByReadConfigFile(bool2, paramFile);
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
            i = getApkVersionByReadFile(paramFile);
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
  
  /* Error */
  public static int getApkVersionByReadFile(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: new 153	java/util/jar/JarFile
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 156	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   13: astore_3
    //   14: new 158	java/io/BufferedReader
    //   17: dup
    //   18: new 160	java/io/InputStreamReader
    //   21: dup
    //   22: aload_3
    //   23: aload_3
    //   24: ldc 162
    //   26: invokevirtual 166	java/util/jar/JarFile:getJarEntry	(Ljava/lang/String;)Ljava/util/jar/JarEntry;
    //   29: invokevirtual 170	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   32: invokespecial 173	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   35: invokespecial 176	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   38: astore_0
    //   39: aload_0
    //   40: invokevirtual 179	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   43: astore_2
    //   44: aload_2
    //   45: ifnull +60 -> 105
    //   48: aload_2
    //   49: ldc 181
    //   51: invokevirtual 81	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   54: ifeq -15 -> 39
    //   57: aload_2
    //   58: ldc 183
    //   60: invokevirtual 187	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   63: astore_2
    //   64: aload_2
    //   65: ifnull -26 -> 39
    //   68: aload_2
    //   69: arraylength
    //   70: iconst_2
    //   71: if_icmpne -32 -> 39
    //   74: aload_2
    //   75: iconst_1
    //   76: aaload
    //   77: invokevirtual 190	java/lang/String:trim	()Ljava/lang/String;
    //   80: invokestatic 196	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   83: istore_1
    //   84: aload_0
    //   85: ifnull +7 -> 92
    //   88: aload_0
    //   89: invokevirtual 199	java/io/BufferedReader:close	()V
    //   92: aload_3
    //   93: ifnull +7 -> 100
    //   96: aload_3
    //   97: invokevirtual 200	java/util/jar/JarFile:close	()V
    //   100: ldc 2
    //   102: monitorexit
    //   103: iload_1
    //   104: ireturn
    //   105: aload_0
    //   106: ifnull +7 -> 113
    //   109: aload_0
    //   110: invokevirtual 199	java/io/BufferedReader:close	()V
    //   113: aload_3
    //   114: ifnull +7 -> 121
    //   117: aload_3
    //   118: invokevirtual 200	java/util/jar/JarFile:close	()V
    //   121: ldc 2
    //   123: monitorexit
    //   124: iconst_m1
    //   125: ireturn
    //   126: astore_0
    //   127: ldc 2
    //   129: monitorexit
    //   130: aload_0
    //   131: athrow
    //   132: astore_3
    //   133: aconst_null
    //   134: astore_0
    //   135: aload_3
    //   136: invokevirtual 201	java/lang/Exception:printStackTrace	()V
    //   139: aload_0
    //   140: ifnull +7 -> 147
    //   143: aload_0
    //   144: invokevirtual 199	java/io/BufferedReader:close	()V
    //   147: aload_2
    //   148: ifnull -27 -> 121
    //   151: aload_2
    //   152: invokevirtual 200	java/util/jar/JarFile:close	()V
    //   155: goto -34 -> 121
    //   158: astore_0
    //   159: goto -38 -> 121
    //   162: astore_2
    //   163: aconst_null
    //   164: astore_0
    //   165: aconst_null
    //   166: astore_3
    //   167: aload_0
    //   168: ifnull +7 -> 175
    //   171: aload_0
    //   172: invokevirtual 199	java/io/BufferedReader:close	()V
    //   175: aload_3
    //   176: ifnull +7 -> 183
    //   179: aload_3
    //   180: invokevirtual 200	java/util/jar/JarFile:close	()V
    //   183: aload_2
    //   184: athrow
    //   185: astore_0
    //   186: goto -3 -> 183
    //   189: astore_2
    //   190: aconst_null
    //   191: astore_0
    //   192: goto -25 -> 167
    //   195: astore_2
    //   196: goto -29 -> 167
    //   199: astore 4
    //   201: aload_2
    //   202: astore_3
    //   203: aload 4
    //   205: astore_2
    //   206: goto -39 -> 167
    //   209: astore 4
    //   211: aconst_null
    //   212: astore_0
    //   213: aload_3
    //   214: astore_2
    //   215: aload 4
    //   217: astore_3
    //   218: goto -83 -> 135
    //   221: astore 4
    //   223: aload_3
    //   224: astore_2
    //   225: aload 4
    //   227: astore_3
    //   228: goto -93 -> 135
    //   231: astore_0
    //   232: goto -111 -> 121
    //   235: astore_0
    //   236: goto -136 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	239	0	paramFile	File
    //   83	21	1	i	int
    //   1	151	2	localObject1	Object
    //   162	22	2	localObject2	Object
    //   189	1	2	localObject3	Object
    //   195	7	2	localObject4	Object
    //   205	20	2	localObject5	Object
    //   13	105	3	localJarFile	java.util.jar.JarFile
    //   132	4	3	localException1	Exception
    //   166	62	3	localObject6	Object
    //   199	5	4	localObject7	Object
    //   209	7	4	localException2	Exception
    //   221	5	4	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   88	92	126	finally
    //   96	100	126	finally
    //   100	103	126	finally
    //   109	113	126	finally
    //   117	121	126	finally
    //   121	124	126	finally
    //   127	130	126	finally
    //   143	147	126	finally
    //   151	155	126	finally
    //   171	175	126	finally
    //   179	183	126	finally
    //   183	185	126	finally
    //   5	14	132	java/lang/Exception
    //   143	147	158	java/lang/Exception
    //   151	155	158	java/lang/Exception
    //   5	14	162	finally
    //   171	175	185	java/lang/Exception
    //   179	183	185	java/lang/Exception
    //   14	39	189	finally
    //   39	44	195	finally
    //   48	64	195	finally
    //   68	84	195	finally
    //   135	139	199	finally
    //   14	39	209	java/lang/Exception
    //   39	44	221	java/lang/Exception
    //   48	64	221	java/lang/Exception
    //   68	84	221	java/lang/Exception
    //   109	113	231	java/lang/Exception
    //   117	121	231	java/lang/Exception
    //   88	92	235	java/lang/Exception
    //   96	100	235	java/lang/Exception
  }
  
  private static int getBackupVersionByReadConfigFile(boolean paramBoolean, File paramFile)
  {
    try
    {
      paramFile = paramFile.getParentFile();
      if (paramFile != null)
      {
        paramFile = paramFile.listFiles();
        Pattern localPattern = Pattern.compile(getCoreVersionCfgFile(paramBoolean) + "(.*)");
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
  
  public static final String getCoreVersionCfgFile(boolean paramBoolean)
  {
    if (AppUtil.is64BitImpl())
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
  
  /* Error */
  public static String getMd5(File paramFile)
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
    //   12: ldc_w 262
    //   15: castore
    //   16: dup
    //   17: iconst_1
    //   18: ldc_w 263
    //   21: castore
    //   22: dup
    //   23: iconst_2
    //   24: ldc_w 264
    //   27: castore
    //   28: dup
    //   29: iconst_3
    //   30: ldc_w 265
    //   33: castore
    //   34: dup
    //   35: iconst_4
    //   36: ldc_w 266
    //   39: castore
    //   40: dup
    //   41: iconst_5
    //   42: ldc_w 267
    //   45: castore
    //   46: dup
    //   47: bipush 6
    //   49: ldc_w 268
    //   52: castore
    //   53: dup
    //   54: bipush 7
    //   56: ldc_w 269
    //   59: castore
    //   60: dup
    //   61: bipush 8
    //   63: ldc_w 270
    //   66: castore
    //   67: dup
    //   68: bipush 9
    //   70: ldc_w 271
    //   73: castore
    //   74: dup
    //   75: bipush 10
    //   77: ldc_w 272
    //   80: castore
    //   81: dup
    //   82: bipush 11
    //   84: ldc_w 273
    //   87: castore
    //   88: dup
    //   89: bipush 12
    //   91: ldc_w 274
    //   94: castore
    //   95: dup
    //   96: bipush 13
    //   98: ldc_w 275
    //   101: castore
    //   102: dup
    //   103: bipush 14
    //   105: ldc_w 276
    //   108: castore
    //   109: dup
    //   110: bipush 15
    //   112: ldc_w 277
    //   115: castore
    //   116: pop
    //   117: bipush 32
    //   119: newarray char
    //   121: astore 7
    //   123: ldc_w 279
    //   126: invokestatic 284	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   129: astore 8
    //   131: new 286	java/io/FileInputStream
    //   134: dup
    //   135: aload_0
    //   136: invokespecial 287	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   139: astore 5
    //   141: aload 5
    //   143: astore_0
    //   144: sipush 8192
    //   147: newarray byte
    //   149: astore 9
    //   151: aload 5
    //   153: astore_0
    //   154: aload 5
    //   156: aload 9
    //   158: invokevirtual 291	java/io/FileInputStream:read	([B)I
    //   161: istore_2
    //   162: iload_2
    //   163: iconst_m1
    //   164: if_icmpeq +42 -> 206
    //   167: aload 5
    //   169: astore_0
    //   170: aload 8
    //   172: aload 9
    //   174: iconst_0
    //   175: iload_2
    //   176: invokevirtual 295	java/security/MessageDigest:update	([BII)V
    //   179: goto -28 -> 151
    //   182: astore 6
    //   184: aload 5
    //   186: astore_0
    //   187: aload 6
    //   189: invokevirtual 201	java/lang/Exception:printStackTrace	()V
    //   192: aload 5
    //   194: ifnull +8 -> 202
    //   197: aload 5
    //   199: invokevirtual 296	java/io/FileInputStream:close	()V
    //   202: aconst_null
    //   203: astore_0
    //   204: aload_0
    //   205: areturn
    //   206: aload 5
    //   208: astore_0
    //   209: aload 8
    //   211: invokevirtual 300	java/security/MessageDigest:digest	()[B
    //   214: astore 8
    //   216: iconst_0
    //   217: istore_2
    //   218: goto +85 -> 303
    //   221: aload 5
    //   223: astore_0
    //   224: new 77	java/lang/String
    //   227: dup
    //   228: aload 7
    //   230: invokespecial 303	java/lang/String:<init>	([C)V
    //   233: astore 6
    //   235: aload 6
    //   237: astore_0
    //   238: aload 5
    //   240: ifnull -36 -> 204
    //   243: aload 5
    //   245: invokevirtual 296	java/io/FileInputStream:close	()V
    //   248: aload 6
    //   250: areturn
    //   251: astore_0
    //   252: aload_0
    //   253: invokevirtual 304	java/io/IOException:printStackTrace	()V
    //   256: aload 6
    //   258: areturn
    //   259: astore_0
    //   260: aload_0
    //   261: invokevirtual 304	java/io/IOException:printStackTrace	()V
    //   264: goto -62 -> 202
    //   267: astore 5
    //   269: aconst_null
    //   270: astore_0
    //   271: aload_0
    //   272: ifnull +7 -> 279
    //   275: aload_0
    //   276: invokevirtual 296	java/io/FileInputStream:close	()V
    //   279: aload 5
    //   281: athrow
    //   282: astore_0
    //   283: aload_0
    //   284: invokevirtual 304	java/io/IOException:printStackTrace	()V
    //   287: goto -8 -> 279
    //   290: astore 5
    //   292: goto -21 -> 271
    //   295: astore 6
    //   297: aconst_null
    //   298: astore 5
    //   300: goto -116 -> 184
    //   303: iload_1
    //   304: bipush 16
    //   306: if_icmpge -85 -> 221
    //   309: aload 8
    //   311: iload_1
    //   312: baload
    //   313: istore_3
    //   314: iload_2
    //   315: iconst_1
    //   316: iadd
    //   317: istore 4
    //   319: aload 7
    //   321: iload_2
    //   322: aload 6
    //   324: iload_3
    //   325: iconst_4
    //   326: iushr
    //   327: bipush 15
    //   329: iand
    //   330: caload
    //   331: castore
    //   332: iload 4
    //   334: iconst_1
    //   335: iadd
    //   336: istore_2
    //   337: aload 7
    //   339: iload 4
    //   341: aload 6
    //   343: iload_3
    //   344: bipush 15
    //   346: iand
    //   347: caload
    //   348: castore
    //   349: iload_1
    //   350: iconst_1
    //   351: iadd
    //   352: istore_1
    //   353: goto -50 -> 303
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	356	0	paramFile	File
    //   1	352	1	i	int
    //   161	176	2	j	int
    //   313	34	3	k	int
    //   317	23	4	m	int
    //   139	105	5	localFileInputStream	java.io.FileInputStream
    //   267	13	5	localObject1	Object
    //   290	1	5	localObject2	Object
    //   298	1	5	localObject3	Object
    //   6	3	6	arrayOfChar1	char[]
    //   182	6	6	localException1	Exception
    //   233	24	6	str	String
    //   295	47	6	localException2	Exception
    //   121	217	7	arrayOfChar2	char[]
    //   129	181	8	localObject4	Object
    //   149	24	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   144	151	182	java/lang/Exception
    //   154	162	182	java/lang/Exception
    //   170	179	182	java/lang/Exception
    //   209	216	182	java/lang/Exception
    //   224	235	182	java/lang/Exception
    //   243	248	251	java/io/IOException
    //   197	202	259	java/io/IOException
    //   123	141	267	finally
    //   275	279	282	java/io/IOException
    //   144	151	290	finally
    //   154	162	290	finally
    //   170	179	290	finally
    //   187	192	290	finally
    //   209	216	290	finally
    //   224	235	290	finally
    //   123	141	295	java/lang/Exception
  }
  
  public static boolean verifyTbsApk(Context paramContext, File paramFile, long paramLong, int paramInt)
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    for (;;)
    {
      return false;
      if ((paramLong <= 0L) || (paramLong == paramFile.length())) {
        try
        {
          if (paramInt == getApkVersion(paramContext, paramFile))
          {
            boolean bool = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(AppUtil.getSignatureFromApk(paramContext, true, paramFile));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.utils.ApkUtil
 * JD-Core Version:    0.7.0.1
 */