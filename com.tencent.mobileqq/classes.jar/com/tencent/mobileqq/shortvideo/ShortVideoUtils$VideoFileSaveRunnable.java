package com.tencent.mobileqq.shortvideo;

import mqq.os.MqqHandler;

public class ShortVideoUtils$VideoFileSaveRunnable
  implements Runnable
{
  public static final int MSG_TYPE_SAVE_EXITS = 3;
  public static final int MSG_TYPE_SAVE_FAILURE = 1;
  public static final int MSG_TYPE_SAVE_SUCCESS = 2;
  MqqHandler mHandler;
  boolean mNeedReplace;
  String mUniqueName;
  String mVideoPath;
  boolean mbKeepUniqueName = false;
  
  public ShortVideoUtils$VideoFileSaveRunnable(String paramString1, MqqHandler paramMqqHandler, String paramString2, boolean paramBoolean)
  {
    this.mVideoPath = paramString1;
    this.mHandler = paramMqqHandler;
    this.mUniqueName = paramString2;
    this.mNeedReplace = paramBoolean;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 30	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:mVideoPath	Ljava/lang/String;
    //   4: invokestatic 48	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +348 -> 355
    //   10: aload_0
    //   11: getfield 30	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:mVideoPath	Ljava/lang/String;
    //   14: invokestatic 54	com/tencent/mobileqq/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   17: ifne +6 -> 23
    //   20: goto +335 -> 355
    //   23: new 56	java/io/File
    //   26: dup
    //   27: aload_0
    //   28: getfield 30	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:mVideoPath	Ljava/lang/String;
    //   31: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   34: astore 4
    //   36: invokestatic 65	com/tencent/util/VersionUtils:b	()Z
    //   39: ifeq +13 -> 52
    //   42: getstatic 70	android/os/Environment:DIRECTORY_MOVIES	Ljava/lang/String;
    //   45: invokestatic 74	android/os/Environment:getExternalStoragePublicDirectory	(Ljava/lang/String;)Ljava/io/File;
    //   48: astore_2
    //   49: goto +14 -> 63
    //   52: new 56	java/io/File
    //   55: dup
    //   56: getstatic 79	com/tencent/mobileqq/app/AppConstants:SDCARD_VIDEO	Ljava/lang/String;
    //   59: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   62: astore_2
    //   63: aload_2
    //   64: invokevirtual 82	java/io/File:mkdirs	()Z
    //   67: pop
    //   68: aload_0
    //   69: getfield 28	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:mbKeepUniqueName	Z
    //   72: ifeq +11 -> 83
    //   75: aload_0
    //   76: getfield 34	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:mUniqueName	Ljava/lang/String;
    //   79: astore_3
    //   80: goto +11 -> 91
    //   83: aload_0
    //   84: getfield 34	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:mUniqueName	Ljava/lang/String;
    //   87: invokestatic 88	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getShortVideoSaveFileName	(Ljava/lang/String;)Ljava/lang/String;
    //   90: astore_3
    //   91: new 56	java/io/File
    //   94: dup
    //   95: aload_2
    //   96: aload_3
    //   97: invokespecial 91	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   100: astore_2
    //   101: aload_0
    //   102: getfield 36	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:mNeedReplace	Z
    //   105: ifne +33 -> 138
    //   108: aload_2
    //   109: invokevirtual 94	java/io/File:exists	()Z
    //   112: ifeq +26 -> 138
    //   115: aload_0
    //   116: getfield 32	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:mHandler	Lmqq/os/MqqHandler;
    //   119: iconst_3
    //   120: aload_0
    //   121: getfield 30	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:mVideoPath	Ljava/lang/String;
    //   124: invokevirtual 100	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   127: astore_2
    //   128: aload_0
    //   129: getfield 32	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:mHandler	Lmqq/os/MqqHandler;
    //   132: aload_2
    //   133: invokevirtual 104	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   136: pop
    //   137: return
    //   138: aconst_null
    //   139: astore_3
    //   140: new 106	java/io/FileOutputStream
    //   143: dup
    //   144: aload_2
    //   145: invokespecial 109	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   148: astore 5
    //   150: new 111	java/io/FileInputStream
    //   153: dup
    //   154: aload 4
    //   156: invokespecial 112	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   159: astore_3
    //   160: ldc 113
    //   162: newarray byte
    //   164: astore 4
    //   166: aload_3
    //   167: aload 4
    //   169: invokevirtual 117	java/io/FileInputStream:read	([B)I
    //   172: istore_1
    //   173: iload_1
    //   174: iconst_m1
    //   175: if_icmpeq +20 -> 195
    //   178: aload 5
    //   180: aload 4
    //   182: iconst_0
    //   183: iload_1
    //   184: invokevirtual 121	java/io/FileOutputStream:write	([BII)V
    //   187: aload 5
    //   189: invokevirtual 124	java/io/FileOutputStream:flush	()V
    //   192: goto -26 -> 166
    //   195: aload_0
    //   196: getfield 32	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:mHandler	Lmqq/os/MqqHandler;
    //   199: iconst_2
    //   200: aload_2
    //   201: invokevirtual 128	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   204: invokevirtual 100	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   207: astore_2
    //   208: aload_0
    //   209: getfield 32	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:mHandler	Lmqq/os/MqqHandler;
    //   212: aload_2
    //   213: invokevirtual 104	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   216: pop
    //   217: aload 5
    //   219: invokevirtual 131	java/io/FileOutputStream:close	()V
    //   222: aload_3
    //   223: astore_2
    //   224: aload_2
    //   225: invokevirtual 132	java/io/FileInputStream:close	()V
    //   228: return
    //   229: astore_2
    //   230: aload 5
    //   232: astore 4
    //   234: goto +98 -> 332
    //   237: astore 4
    //   239: aload_3
    //   240: astore_2
    //   241: goto +17 -> 258
    //   244: astore_2
    //   245: aconst_null
    //   246: astore_3
    //   247: aload 5
    //   249: astore 4
    //   251: goto +81 -> 332
    //   254: astore 4
    //   256: aconst_null
    //   257: astore_2
    //   258: aload 5
    //   260: astore_3
    //   261: goto +17 -> 278
    //   264: astore_2
    //   265: aconst_null
    //   266: astore 4
    //   268: aload 4
    //   270: astore_3
    //   271: goto +61 -> 332
    //   274: astore 4
    //   276: aconst_null
    //   277: astore_2
    //   278: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   281: ifeq +13 -> 294
    //   284: ldc 139
    //   286: iconst_2
    //   287: ldc 141
    //   289: aload 4
    //   291: invokestatic 145	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   294: aload_0
    //   295: getfield 32	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:mHandler	Lmqq/os/MqqHandler;
    //   298: iconst_1
    //   299: invokevirtual 149	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   302: pop
    //   303: aload_3
    //   304: ifnull +10 -> 314
    //   307: aload_3
    //   308: invokevirtual 131	java/io/FileOutputStream:close	()V
    //   311: goto +3 -> 314
    //   314: aload_2
    //   315: ifnull +6 -> 321
    //   318: goto -94 -> 224
    //   321: return
    //   322: astore 5
    //   324: aload_3
    //   325: astore 4
    //   327: aload_2
    //   328: astore_3
    //   329: aload 5
    //   331: astore_2
    //   332: aload 4
    //   334: ifnull +11 -> 345
    //   337: aload 4
    //   339: invokevirtual 131	java/io/FileOutputStream:close	()V
    //   342: goto +3 -> 345
    //   345: aload_3
    //   346: ifnull +7 -> 353
    //   349: aload_3
    //   350: invokevirtual 132	java/io/FileInputStream:close	()V
    //   353: aload_2
    //   354: athrow
    //   355: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   358: ifeq +37 -> 395
    //   361: new 151	java/lang/StringBuilder
    //   364: dup
    //   365: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   368: astore_2
    //   369: aload_2
    //   370: ldc 154
    //   372: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload_2
    //   377: aload_0
    //   378: getfield 30	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:mVideoPath	Ljava/lang/String;
    //   381: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: ldc 139
    //   387: iconst_2
    //   388: aload_2
    //   389: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokestatic 164	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   395: aload_0
    //   396: getfield 32	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:mHandler	Lmqq/os/MqqHandler;
    //   399: iconst_1
    //   400: invokevirtual 149	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   403: pop
    //   404: return
    //   405: astore_2
    //   406: aload_3
    //   407: astore_2
    //   408: goto -184 -> 224
    //   411: astore_2
    //   412: return
    //   413: astore_3
    //   414: goto -100 -> 314
    //   417: astore 4
    //   419: goto -74 -> 345
    //   422: astore_3
    //   423: goto -70 -> 353
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	426	0	this	VideoFileSaveRunnable
    //   172	12	1	i	int
    //   48	177	2	localObject1	Object
    //   229	1	2	localObject2	Object
    //   240	1	2	localObject3	Object
    //   244	1	2	localObject4	Object
    //   257	1	2	localObject5	Object
    //   264	1	2	localObject6	Object
    //   277	112	2	localObject7	Object
    //   405	1	2	localIOException1	java.io.IOException
    //   407	1	2	localObject8	Object
    //   411	1	2	localIOException2	java.io.IOException
    //   79	328	3	localObject9	Object
    //   413	1	3	localIOException3	java.io.IOException
    //   422	1	3	localIOException4	java.io.IOException
    //   34	199	4	localObject10	Object
    //   237	1	4	localException1	java.lang.Exception
    //   249	1	4	localObject11	Object
    //   254	1	4	localException2	java.lang.Exception
    //   266	3	4	localObject12	Object
    //   274	16	4	localException3	java.lang.Exception
    //   325	13	4	localObject13	Object
    //   417	1	4	localIOException5	java.io.IOException
    //   148	111	5	localFileOutputStream	java.io.FileOutputStream
    //   322	8	5	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   160	166	229	finally
    //   166	173	229	finally
    //   178	192	229	finally
    //   195	217	229	finally
    //   160	166	237	java/lang/Exception
    //   166	173	237	java/lang/Exception
    //   178	192	237	java/lang/Exception
    //   195	217	237	java/lang/Exception
    //   150	160	244	finally
    //   150	160	254	java/lang/Exception
    //   140	150	264	finally
    //   140	150	274	java/lang/Exception
    //   278	294	322	finally
    //   294	303	322	finally
    //   217	222	405	java/io/IOException
    //   224	228	411	java/io/IOException
    //   307	311	413	java/io/IOException
    //   337	342	417	java/io/IOException
    //   349	353	422	java/io/IOException
  }
  
  public void setKeepUniqueName(boolean paramBoolean)
  {
    this.mbKeepUniqueName = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable
 * JD-Core Version:    0.7.0.1
 */