package com.tencent.tbs.one.impl.policy.builtin;

import android.content.Context;
import android.os.Bundle;
import com.tencent.tbs.one.impl.base.CancellableJob;
import com.tencent.tbs.one.impl.base.ThreadUtils;
import com.tencent.tbs.one.impl.common.DEPSConfig.ComponentConfig;
import com.tencent.tbs.one.impl.policy.InstallationResult;
import java.io.File;

public class BuiltinComponentInstallationJob
  extends CancellableJob<InstallationResult<File>>
{
  private Context mCallerContext;
  private String mCategory;
  private DEPSConfig.ComponentConfig mComponentConfig;
  private String mLocalRespository;
  private Bundle mOptions;
  private File mOutputDirectory;
  
  public BuiltinComponentInstallationJob(Context paramContext, String paramString1, DEPSConfig.ComponentConfig paramComponentConfig, File paramFile, Bundle paramBundle, String paramString2)
  {
    this.mCallerContext = paramContext;
    this.mCategory = paramString1;
    this.mComponentConfig = paramComponentConfig;
    this.mOutputDirectory = paramFile;
    this.mOptions = paramBundle;
    this.mLocalRespository = paramString2;
  }
  
  /* Error */
  private void install(Context paramContext, String paramString, DEPSConfig.ComponentConfig paramComponentConfig, File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 58	com/tencent/tbs/one/impl/common/PathService:getNativeLibraryDirectory	(Landroid/content/Context;)Ljava/io/File;
    //   4: astore 10
    //   6: aload_3
    //   7: invokevirtual 64	com/tencent/tbs/one/impl/common/DEPSConfig$ComponentConfig:getName	()Ljava/lang/String;
    //   10: astore 11
    //   12: aload 10
    //   14: aload 11
    //   16: ldc 66
    //   18: invokestatic 70	com/tencent/tbs/one/impl/common/PathService:getComponentFileInNativeLibraryDirectory	(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   21: astore_2
    //   22: aload_2
    //   23: invokestatic 76	com/tencent/tbs/one/impl/common/ManifestConfig:parse	(Ljava/io/File;)Lcom/tencent/tbs/one/impl/common/ManifestConfig;
    //   26: astore_3
    //   27: aload_0
    //   28: getfield 27	com/tencent/tbs/one/impl/policy/builtin/BuiltinComponentInstallationJob:mComponentConfig	Lcom/tencent/tbs/one/impl/common/DEPSConfig$ComponentConfig;
    //   31: invokevirtual 80	com/tencent/tbs/one/impl/common/DEPSConfig$ComponentConfig:getVersionCode	()I
    //   34: istore 5
    //   36: aload_3
    //   37: invokevirtual 81	com/tencent/tbs/one/impl/common/ManifestConfig:getVersionCode	()I
    //   40: istore 6
    //   42: iload 5
    //   44: iload 6
    //   46: if_icmpeq +60 -> 106
    //   49: aload_0
    //   50: sipush 417
    //   53: new 83	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   60: ldc 86
    //   62: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: iload 5
    //   67: invokevirtual 93	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: ldc 95
    //   72: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: iload 6
    //   77: invokevirtual 93	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   80: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: aconst_null
    //   84: invokevirtual 102	com/tencent/tbs/one/impl/policy/builtin/BuiltinComponentInstallationJob:fail	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   87: return
    //   88: astore_1
    //   89: aload_0
    //   90: aload_1
    //   91: invokevirtual 105	com/tencent/tbs/one/TBSOneException:getErrorCode	()I
    //   94: aload_1
    //   95: invokevirtual 108	com/tencent/tbs/one/TBSOneException:getMessage	()Ljava/lang/String;
    //   98: aload_1
    //   99: invokevirtual 112	com/tencent/tbs/one/TBSOneException:getCause	()Ljava/lang/Throwable;
    //   102: invokevirtual 102	com/tencent/tbs/one/impl/policy/builtin/BuiltinComponentInstallationJob:fail	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   105: return
    //   106: aload 4
    //   108: invokestatic 118	com/tencent/tbs/one/impl/base/FileUtils:mkdirsWithWarning	(Ljava/io/File;)V
    //   111: aload_2
    //   112: new 120	java/io/File
    //   115: dup
    //   116: aload 4
    //   118: ldc 66
    //   120: invokespecial 123	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   123: invokestatic 127	com/tencent/tbs/one/impl/base/FileUtils:copyFile	(Ljava/io/File;Ljava/io/File;)V
    //   126: aload_3
    //   127: invokevirtual 131	com/tencent/tbs/one/impl/common/ManifestConfig:getFileConfigs	()[Lcom/tencent/tbs/one/impl/common/ManifestConfig$FileConfig;
    //   130: astore 12
    //   132: aload 12
    //   134: arraylength
    //   135: istore 6
    //   137: iconst_0
    //   138: istore 5
    //   140: aconst_null
    //   141: astore 7
    //   143: iload 5
    //   145: iload 6
    //   147: if_icmpge +353 -> 500
    //   150: aload 12
    //   152: iload 5
    //   154: aaload
    //   155: astore 14
    //   157: aload 14
    //   159: invokevirtual 136	com/tencent/tbs/one/impl/common/ManifestConfig$FileConfig:getPath	()Ljava/lang/String;
    //   162: astore_2
    //   163: new 120	java/io/File
    //   166: dup
    //   167: aload 4
    //   169: aload_2
    //   170: invokespecial 123	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   173: astore 13
    //   175: aload 14
    //   177: invokevirtual 139	com/tencent/tbs/one/impl/common/ManifestConfig$FileConfig:getURL	()Ljava/lang/String;
    //   180: invokestatic 145	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   183: ifne +240 -> 423
    //   186: ldc 147
    //   188: iconst_2
    //   189: anewarray 149	java/lang/Object
    //   192: dup
    //   193: iconst_0
    //   194: aload_2
    //   195: aastore
    //   196: dup
    //   197: iconst_1
    //   198: aload 14
    //   200: invokevirtual 139	com/tencent/tbs/one/impl/common/ManifestConfig$FileConfig:getURL	()Ljava/lang/String;
    //   203: aastore
    //   204: invokestatic 155	com/tencent/tbs/one/impl/base/Logging:i	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   207: aload_1
    //   208: aload_0
    //   209: getfield 33	com/tencent/tbs/one/impl/policy/builtin/BuiltinComponentInstallationJob:mLocalRespository	Ljava/lang/String;
    //   212: aload 14
    //   214: invokevirtual 139	com/tencent/tbs/one/impl/common/ManifestConfig$FileConfig:getURL	()Ljava/lang/String;
    //   217: invokestatic 159	com/tencent/tbs/one/impl/base/FileUtils:openFile	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    //   220: astore_2
    //   221: ldc 161
    //   223: iconst_1
    //   224: anewarray 149	java/lang/Object
    //   227: dup
    //   228: iconst_0
    //   229: aload_2
    //   230: aastore
    //   231: invokestatic 155	com/tencent/tbs/one/impl/base/Logging:i	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   234: new 163	java/io/FileOutputStream
    //   237: dup
    //   238: aload 13
    //   240: invokespecial 165	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   243: astore_3
    //   244: aload_2
    //   245: aload_3
    //   246: invokestatic 169	com/tencent/tbs/one/impl/base/FileUtils:copyStream	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   249: aload_2
    //   250: invokestatic 173	com/tencent/tbs/one/impl/base/FileUtils:close	(Ljava/io/Closeable;)V
    //   253: aload_3
    //   254: invokestatic 173	com/tencent/tbs/one/impl/base/FileUtils:close	(Ljava/io/Closeable;)V
    //   257: aload 14
    //   259: invokevirtual 176	com/tencent/tbs/one/impl/common/ManifestConfig$FileConfig:getMD5	()Ljava/lang/String;
    //   262: astore_3
    //   263: aload 7
    //   265: astore_2
    //   266: aload_3
    //   267: invokestatic 145	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   270: ifne +22 -> 292
    //   273: aload 7
    //   275: astore_2
    //   276: aload 7
    //   278: ifnonnull +7 -> 285
    //   281: invokestatic 182	com/tencent/tbs/one/impl/policy/InstallationUtils:getMD5Digest	()Ljava/security/MessageDigest;
    //   284: astore_2
    //   285: aload_2
    //   286: aload 13
    //   288: aload_3
    //   289: invokestatic 186	com/tencent/tbs/one/impl/policy/InstallationUtils:verifyFileMd5	(Ljava/security/MessageDigest;Ljava/io/File;Ljava/lang/String;)V
    //   292: iload 5
    //   294: iconst_1
    //   295: iadd
    //   296: istore 5
    //   298: aload_2
    //   299: astore 7
    //   301: goto -158 -> 143
    //   304: astore_1
    //   305: aload_0
    //   306: sipush 312
    //   309: new 83	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   316: ldc 188
    //   318: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload 10
    //   323: invokevirtual 191	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   326: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: ldc 193
    //   331: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: aload_2
    //   335: invokevirtual 191	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   338: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: aload_1
    //   345: invokevirtual 102	com/tencent/tbs/one/impl/policy/builtin/BuiltinComponentInstallationJob:fail	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   348: return
    //   349: astore 8
    //   351: aconst_null
    //   352: astore_3
    //   353: aconst_null
    //   354: astore_2
    //   355: aload_0
    //   356: sipush 318
    //   359: new 83	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   366: ldc 195
    //   368: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: aload 13
    //   373: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   376: ldc 200
    //   378: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: aload 14
    //   383: invokevirtual 139	com/tencent/tbs/one/impl/common/ManifestConfig$FileConfig:getURL	()Ljava/lang/String;
    //   386: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: aload 8
    //   394: invokevirtual 102	com/tencent/tbs/one/impl/policy/builtin/BuiltinComponentInstallationJob:fail	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   397: aload_3
    //   398: invokestatic 173	com/tencent/tbs/one/impl/base/FileUtils:close	(Ljava/io/Closeable;)V
    //   401: aload_2
    //   402: invokestatic 173	com/tencent/tbs/one/impl/base/FileUtils:close	(Ljava/io/Closeable;)V
    //   405: goto -148 -> 257
    //   408: astore_1
    //   409: aconst_null
    //   410: astore_3
    //   411: aconst_null
    //   412: astore_2
    //   413: aload_3
    //   414: invokestatic 173	com/tencent/tbs/one/impl/base/FileUtils:close	(Ljava/io/Closeable;)V
    //   417: aload_2
    //   418: invokestatic 173	com/tencent/tbs/one/impl/base/FileUtils:close	(Ljava/io/Closeable;)V
    //   421: aload_1
    //   422: athrow
    //   423: aload 10
    //   425: aload 11
    //   427: aload_2
    //   428: aload 13
    //   430: invokestatic 204	com/tencent/tbs/one/impl/policy/InstallationUtils:extractFromNativeLibraryDirectory	(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)V
    //   433: goto -176 -> 257
    //   436: astore_1
    //   437: aload_0
    //   438: sipush 312
    //   441: new 83	java/lang/StringBuilder
    //   444: dup
    //   445: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   448: ldc 188
    //   450: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: aload 10
    //   455: invokevirtual 191	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   458: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: ldc 193
    //   463: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: aload 13
    //   468: invokevirtual 191	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   471: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   477: aload_1
    //   478: invokevirtual 102	com/tencent/tbs/one/impl/policy/builtin/BuiltinComponentInstallationJob:fail	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   481: return
    //   482: astore_1
    //   483: aload_0
    //   484: aload_1
    //   485: invokevirtual 105	com/tencent/tbs/one/TBSOneException:getErrorCode	()I
    //   488: aload_1
    //   489: invokevirtual 108	com/tencent/tbs/one/TBSOneException:getMessage	()Ljava/lang/String;
    //   492: aload_1
    //   493: invokevirtual 112	com/tencent/tbs/one/TBSOneException:getCause	()Ljava/lang/Throwable;
    //   496: invokevirtual 102	com/tencent/tbs/one/impl/policy/builtin/BuiltinComponentInstallationJob:fail	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   499: return
    //   500: aload_0
    //   501: getstatic 210	com/tencent/tbs/one/impl/policy/InstallationResult$Source:BUILTIN	Lcom/tencent/tbs/one/impl/policy/InstallationResult$Source;
    //   504: aload 4
    //   506: invokestatic 216	com/tencent/tbs/one/impl/policy/InstallationResult:make	(Lcom/tencent/tbs/one/impl/policy/InstallationResult$Source;Ljava/lang/Object;)Lcom/tencent/tbs/one/impl/policy/InstallationResult;
    //   509: invokevirtual 220	com/tencent/tbs/one/impl/policy/builtin/BuiltinComponentInstallationJob:finish	(Ljava/lang/Object;)V
    //   512: return
    //   513: astore_1
    //   514: aconst_null
    //   515: astore 4
    //   517: aload_2
    //   518: astore_3
    //   519: aload 4
    //   521: astore_2
    //   522: goto -109 -> 413
    //   525: astore_1
    //   526: aload_2
    //   527: astore 4
    //   529: aload_3
    //   530: astore_2
    //   531: aload 4
    //   533: astore_3
    //   534: goto -121 -> 413
    //   537: astore_1
    //   538: goto -125 -> 413
    //   541: astore 8
    //   543: aconst_null
    //   544: astore 9
    //   546: aload_2
    //   547: astore_3
    //   548: aload 9
    //   550: astore_2
    //   551: goto -196 -> 355
    //   554: astore 8
    //   556: aload_2
    //   557: astore 9
    //   559: aload_3
    //   560: astore_2
    //   561: aload 9
    //   563: astore_3
    //   564: goto -209 -> 355
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	567	0	this	BuiltinComponentInstallationJob
    //   0	567	1	paramContext	Context
    //   0	567	2	paramString	String
    //   0	567	3	paramComponentConfig	DEPSConfig.ComponentConfig
    //   0	567	4	paramFile	File
    //   34	263	5	i	int
    //   40	108	6	j	int
    //   141	159	7	str1	String
    //   349	44	8	localIOException1	java.io.IOException
    //   541	1	8	localIOException2	java.io.IOException
    //   554	1	8	localIOException3	java.io.IOException
    //   544	18	9	str2	String
    //   4	450	10	localFile1	File
    //   10	416	11	str3	String
    //   130	21	12	arrayOfFileConfig	com.tencent.tbs.one.impl.common.ManifestConfig.FileConfig[]
    //   173	294	13	localFile2	File
    //   155	227	14	localFileConfig	com.tencent.tbs.one.impl.common.ManifestConfig.FileConfig
    // Exception table:
    //   from	to	target	type
    //   22	27	88	com/tencent/tbs/one/TBSOneException
    //   111	126	304	java/io/IOException
    //   207	221	349	java/io/IOException
    //   207	221	408	finally
    //   423	433	436	java/io/IOException
    //   281	285	482	com/tencent/tbs/one/TBSOneException
    //   285	292	482	com/tencent/tbs/one/TBSOneException
    //   221	244	513	finally
    //   244	249	525	finally
    //   355	397	537	finally
    //   221	244	541	java/io/IOException
    //   244	249	554	java/io/IOException
  }
  
  public void run()
  {
    ThreadUtils.postOnBackgroundThread(new BuiltinComponentInstallationJob.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.builtin.BuiltinComponentInstallationJob
 * JD-Core Version:    0.7.0.1
 */