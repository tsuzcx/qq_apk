package com.tencent.mobileqq.transfile;

import android.app.Application;

public class LocalBilldDownloader
  extends AbsDownloader
{
  public static final String PROTOCOL_BILLD_IMG = "billdimg";
  public static final String PROTOCOL_BILLD_THUMB = "billdthumb";
  private static final String TAG = "LocalBilldDownloader";
  Application application;
  
  public LocalBilldDownloader(Application paramApplication)
  {
    this.application = paramApplication;
  }
  
  /* Error */
  public java.io.File downloadImage(java.io.OutputStream paramOutputStream, com.tencent.image.DownloadParams paramDownloadParams, com.tencent.image.URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: new 30	java/io/File
    //   3: dup
    //   4: getstatic 35	com/tencent/mobileqq/app/AppConstants:SDCARD_BILLD_URLDRAWABLE	Ljava/lang/String;
    //   7: invokespecial 38	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_3
    //   11: aload_3
    //   12: invokevirtual 42	java/io/File:exists	()Z
    //   15: ifne +8 -> 23
    //   18: aload_3
    //   19: invokevirtual 45	java/io/File:mkdirs	()Z
    //   22: pop
    //   23: aload_2
    //   24: getfield 51	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   27: invokevirtual 57	java/net/URL:getPath	()Ljava/lang/String;
    //   30: astore_1
    //   31: new 59	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   38: astore 5
    //   40: aload 5
    //   42: aload_3
    //   43: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 5
    //   49: ldc 66
    //   51: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload 5
    //   57: aload_1
    //   58: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: new 30	java/io/File
    //   65: dup
    //   66: aload 5
    //   68: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokespecial 38	java/io/File:<init>	(Ljava/lang/String;)V
    //   74: astore 5
    //   76: aload 5
    //   78: invokevirtual 42	java/io/File:exists	()Z
    //   81: ifeq +13 -> 94
    //   84: aload 5
    //   86: invokevirtual 76	java/io/File:length	()J
    //   89: lconst_0
    //   90: lcmp
    //   91: ifne +236 -> 327
    //   94: new 59	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   101: astore 6
    //   103: aload 6
    //   105: aload_3
    //   106: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload 6
    //   112: ldc 66
    //   114: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload 6
    //   120: aload_1
    //   121: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload 6
    //   127: ldc 78
    //   129: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: new 30	java/io/File
    //   136: dup
    //   137: aload 6
    //   139: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokespecial 38	java/io/File:<init>	(Ljava/lang/String;)V
    //   145: astore 6
    //   147: aload 6
    //   149: invokevirtual 42	java/io/File:exists	()Z
    //   152: ifeq +9 -> 161
    //   155: aload 6
    //   157: invokevirtual 81	java/io/File:delete	()Z
    //   160: pop
    //   161: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   164: ifeq +67 -> 231
    //   167: new 59	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   174: astore_3
    //   175: aload_3
    //   176: ldc 88
    //   178: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload_3
    //   183: aload_2
    //   184: getfield 91	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   187: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_3
    //   192: ldc 93
    //   194: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload_3
    //   199: aload_1
    //   200: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload_3
    //   205: ldc 95
    //   207: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload_3
    //   212: aload 5
    //   214: invokevirtual 98	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   217: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: ldc 14
    //   223: iconst_2
    //   224: aload_3
    //   225: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 102	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   231: aload_0
    //   232: getfield 23	com/tencent/mobileqq/transfile/LocalBilldDownloader:application	Landroid/app/Application;
    //   235: invokevirtual 108	android/app/Application:getResources	()Landroid/content/res/Resources;
    //   238: aload_1
    //   239: ldc 110
    //   241: aload_0
    //   242: getfield 23	com/tencent/mobileqq/transfile/LocalBilldDownloader:application	Landroid/app/Application;
    //   245: invokevirtual 113	android/app/Application:getPackageName	()Ljava/lang/String;
    //   248: invokevirtual 119	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   251: istore 4
    //   253: aconst_null
    //   254: astore_3
    //   255: aconst_null
    //   256: astore_2
    //   257: aload_0
    //   258: getfield 23	com/tencent/mobileqq/transfile/LocalBilldDownloader:application	Landroid/app/Application;
    //   261: invokevirtual 108	android/app/Application:getResources	()Landroid/content/res/Resources;
    //   264: iload 4
    //   266: invokevirtual 123	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   269: astore_1
    //   270: sipush 4096
    //   273: newarray byte
    //   275: astore_3
    //   276: new 125	java/io/FileOutputStream
    //   279: dup
    //   280: aload 6
    //   282: invokespecial 128	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   285: astore_2
    //   286: aload_1
    //   287: aload_3
    //   288: invokevirtual 134	java/io/InputStream:read	([B)I
    //   291: iconst_m1
    //   292: if_icmpeq +15 -> 307
    //   295: aload_2
    //   296: aload_3
    //   297: invokevirtual 138	java/io/FileOutputStream:write	([B)V
    //   300: aload_2
    //   301: invokevirtual 141	java/io/FileOutputStream:flush	()V
    //   304: goto -18 -> 286
    //   307: aload_1
    //   308: ifnull +7 -> 315
    //   311: aload_1
    //   312: invokevirtual 144	java/io/InputStream:close	()V
    //   315: aload_2
    //   316: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   319: aload 6
    //   321: aload 5
    //   323: invokevirtual 149	java/io/File:renameTo	(Ljava/io/File;)Z
    //   326: pop
    //   327: aload 5
    //   329: areturn
    //   330: astore 5
    //   332: aload_1
    //   333: astore_3
    //   334: aload_2
    //   335: astore_1
    //   336: aload 5
    //   338: astore_2
    //   339: goto +57 -> 396
    //   342: astore_3
    //   343: aload_1
    //   344: astore 5
    //   346: aload_2
    //   347: astore_1
    //   348: aload 5
    //   350: astore_2
    //   351: goto +36 -> 387
    //   354: astore_2
    //   355: aconst_null
    //   356: astore 5
    //   358: aload_1
    //   359: astore_3
    //   360: aload 5
    //   362: astore_1
    //   363: goto +33 -> 396
    //   366: astore_3
    //   367: aconst_null
    //   368: astore 5
    //   370: aload_1
    //   371: astore_2
    //   372: aload 5
    //   374: astore_1
    //   375: goto +12 -> 387
    //   378: astore_2
    //   379: aconst_null
    //   380: astore_1
    //   381: goto +15 -> 396
    //   384: astore_3
    //   385: aconst_null
    //   386: astore_1
    //   387: aload_3
    //   388: athrow
    //   389: astore 5
    //   391: aload_2
    //   392: astore_3
    //   393: aload 5
    //   395: astore_2
    //   396: aload_3
    //   397: ifnull +7 -> 404
    //   400: aload_3
    //   401: invokevirtual 144	java/io/InputStream:close	()V
    //   404: aload_1
    //   405: ifnull +7 -> 412
    //   408: aload_1
    //   409: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   412: goto +5 -> 417
    //   415: aload_2
    //   416: athrow
    //   417: goto -2 -> 415
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	420	0	this	LocalBilldDownloader
    //   0	420	1	paramOutputStream	java.io.OutputStream
    //   0	420	2	paramDownloadParams	com.tencent.image.DownloadParams
    //   0	420	3	paramURLDrawableHandler	com.tencent.image.URLDrawableHandler
    //   251	14	4	i	int
    //   38	290	5	localObject1	java.lang.Object
    //   330	7	5	localObject2	java.lang.Object
    //   344	29	5	localOutputStream	java.io.OutputStream
    //   389	5	5	localObject3	java.lang.Object
    //   101	219	6	localObject4	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   286	304	330	finally
    //   286	304	342	java/lang/Exception
    //   270	286	354	finally
    //   270	286	366	java/lang/Exception
    //   257	270	378	finally
    //   257	270	384	java/lang/Exception
    //   387	389	389	finally
  }
  
  public boolean useDiskCache()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.LocalBilldDownloader
 * JD-Core Version:    0.7.0.1
 */