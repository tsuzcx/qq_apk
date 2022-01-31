package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.io.File;

public class ApkUtil
{
  private static final String LOGTAG = "ApkUtil";
  public static final String TBS_APK_SIG = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a";
  
  public static int getApkVersion(Context paramContext, File paramFile)
  {
    int j = 0;
    int i = j;
    if (paramFile != null)
    {
      i = j;
      if (!paramFile.exists()) {}
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramFile.getAbsolutePath(), 1);
      i = j;
      if (paramContext != null) {
        i = paramContext.versionCode;
      }
      return i;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return -1;
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
    //   12: ldc 58
    //   14: castore
    //   15: dup
    //   16: iconst_1
    //   17: ldc 59
    //   19: castore
    //   20: dup
    //   21: iconst_2
    //   22: ldc 60
    //   24: castore
    //   25: dup
    //   26: iconst_3
    //   27: ldc 61
    //   29: castore
    //   30: dup
    //   31: iconst_4
    //   32: ldc 62
    //   34: castore
    //   35: dup
    //   36: iconst_5
    //   37: ldc 63
    //   39: castore
    //   40: dup
    //   41: bipush 6
    //   43: ldc 64
    //   45: castore
    //   46: dup
    //   47: bipush 7
    //   49: ldc 65
    //   51: castore
    //   52: dup
    //   53: bipush 8
    //   55: ldc 66
    //   57: castore
    //   58: dup
    //   59: bipush 9
    //   61: ldc 67
    //   63: castore
    //   64: dup
    //   65: bipush 10
    //   67: ldc 68
    //   69: castore
    //   70: dup
    //   71: bipush 11
    //   73: ldc 69
    //   75: castore
    //   76: dup
    //   77: bipush 12
    //   79: ldc 70
    //   81: castore
    //   82: dup
    //   83: bipush 13
    //   85: ldc 71
    //   87: castore
    //   88: dup
    //   89: bipush 14
    //   91: ldc 72
    //   93: castore
    //   94: dup
    //   95: bipush 15
    //   97: ldc 73
    //   99: castore
    //   100: pop
    //   101: bipush 32
    //   103: newarray char
    //   105: astore 7
    //   107: ldc 75
    //   109: invokestatic 81	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   112: astore 8
    //   114: new 83	java/io/FileInputStream
    //   117: dup
    //   118: aload_0
    //   119: invokespecial 86	java/io/FileInputStream:<init>	(Ljava/io/File;)V
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
    //   141: invokevirtual 90	java/io/FileInputStream:read	([B)I
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
    //   159: invokevirtual 94	java/security/MessageDigest:update	([BII)V
    //   162: goto -28 -> 134
    //   165: astore 6
    //   167: aload 5
    //   169: astore_0
    //   170: aload 6
    //   172: invokevirtual 95	java/lang/Exception:printStackTrace	()V
    //   175: aload 5
    //   177: ifnull +8 -> 185
    //   180: aload 5
    //   182: invokevirtual 98	java/io/FileInputStream:close	()V
    //   185: aconst_null
    //   186: astore_0
    //   187: aload_0
    //   188: areturn
    //   189: aload 5
    //   191: astore_0
    //   192: aload 8
    //   194: invokevirtual 102	java/security/MessageDigest:digest	()[B
    //   197: astore 8
    //   199: iconst_0
    //   200: istore_2
    //   201: goto +85 -> 286
    //   204: aload 5
    //   206: astore_0
    //   207: new 104	java/lang/String
    //   210: dup
    //   211: aload 7
    //   213: invokespecial 107	java/lang/String:<init>	([C)V
    //   216: astore 6
    //   218: aload 6
    //   220: astore_0
    //   221: aload 5
    //   223: ifnull -36 -> 187
    //   226: aload 5
    //   228: invokevirtual 98	java/io/FileInputStream:close	()V
    //   231: aload 6
    //   233: areturn
    //   234: astore_0
    //   235: aload_0
    //   236: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   239: aload 6
    //   241: areturn
    //   242: astore 5
    //   244: aconst_null
    //   245: astore_0
    //   246: aload_0
    //   247: ifnull +7 -> 254
    //   250: aload_0
    //   251: invokevirtual 98	java/io/FileInputStream:close	()V
    //   254: aload 5
    //   256: athrow
    //   257: astore_0
    //   258: aload_0
    //   259: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   262: goto -8 -> 254
    //   265: astore_0
    //   266: aload_0
    //   267: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   270: goto -85 -> 185
    //   273: astore 5
    //   275: goto -29 -> 246
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
    //   242	13	5	localObject1	Object
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
    //   107	124	242	finally
    //   250	254	257	java/io/IOException
    //   180	185	265	java/io/IOException
    //   127	134	273	finally
    //   137	145	273	finally
    //   153	162	273	finally
    //   170	175	273	finally
    //   192	199	273	finally
    //   207	218	273	finally
    //   107	124	278	java/lang/Exception
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
            boolean bool = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(AppUtil.getSignatureFromApk(paramContext, paramFile));
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