package com.tencent.mobileqq.filemanager.util;

final class QQFileManagerUtilImpl$13
  implements Runnable
{
  QQFileManagerUtilImpl$13(String paramString, int paramInt1, boolean paramBoolean, QQFileManagerUtil.IGetVideoCallback paramIGetVideoCallback, int paramInt2, int paramInt3) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: getstatic 48	android/os/Build$VERSION:SDK_INT	I
    //   3: istore_2
    //   4: aconst_null
    //   5: astore 6
    //   7: aload 6
    //   9: astore 5
    //   11: iload_2
    //   12: bipush 10
    //   14: if_icmplt +233 -> 247
    //   17: new 50	android/media/MediaMetadataRetriever
    //   20: dup
    //   21: invokespecial 51	android/media/MediaMetadataRetriever:<init>	()V
    //   24: astore 7
    //   26: aload 7
    //   28: aload_0
    //   29: getfield 20	com/tencent/mobileqq/filemanager/util/QQFileManagerUtilImpl$13:a	Ljava/lang/String;
    //   32: invokevirtual 55	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   35: aload_0
    //   36: getfield 22	com/tencent/mobileqq/filemanager/util/QQFileManagerUtilImpl$13:b	I
    //   39: i2l
    //   40: lstore_3
    //   41: aload_0
    //   42: getfield 22	com/tencent/mobileqq/filemanager/util/QQFileManagerUtilImpl$13:b	I
    //   45: ifgt +7 -> 52
    //   48: ldc2_w 56
    //   51: lstore_3
    //   52: aload 7
    //   54: lload_3
    //   55: iconst_2
    //   56: invokevirtual 61	android/media/MediaMetadataRetriever:getFrameAtTime	(JI)Landroid/graphics/Bitmap;
    //   59: astore 5
    //   61: aload 7
    //   63: invokevirtual 64	android/media/MediaMetadataRetriever:release	()V
    //   66: goto +21 -> 87
    //   69: astore 5
    //   71: aload 7
    //   73: invokevirtual 64	android/media/MediaMetadataRetriever:release	()V
    //   76: aload 5
    //   78: athrow
    //   79: aload 7
    //   81: invokevirtual 64	android/media/MediaMetadataRetriever:release	()V
    //   84: aconst_null
    //   85: astore 5
    //   87: aload 5
    //   89: ifnonnull +4 -> 93
    //   92: return
    //   93: aload_0
    //   94: getfield 24	com/tencent/mobileqq/filemanager/util/QQFileManagerUtilImpl$13:c	Z
    //   97: ifne +24 -> 121
    //   100: aload_0
    //   101: getfield 26	com/tencent/mobileqq/filemanager/util/QQFileManagerUtilImpl$13:d	Lcom/tencent/mobileqq/filemanager/util/QQFileManagerUtil$IGetVideoCallback;
    //   104: astore 7
    //   106: aload 7
    //   108: ifnull +13 -> 121
    //   111: aload 7
    //   113: aload 5
    //   115: invokeinterface 69 2 0
    //   120: return
    //   121: aload 5
    //   123: invokevirtual 75	android/graphics/Bitmap:getWidth	()I
    //   126: aload 5
    //   128: invokevirtual 78	android/graphics/Bitmap:getHeight	()I
    //   131: if_icmpge +18 -> 149
    //   134: aload_0
    //   135: getfield 28	com/tencent/mobileqq/filemanager/util/QQFileManagerUtilImpl$13:e	I
    //   138: i2f
    //   139: fstore_1
    //   140: aload 5
    //   142: invokevirtual 75	android/graphics/Bitmap:getWidth	()I
    //   145: istore_2
    //   146: goto +15 -> 161
    //   149: aload_0
    //   150: getfield 30	com/tencent/mobileqq/filemanager/util/QQFileManagerUtilImpl$13:f	I
    //   153: i2f
    //   154: fstore_1
    //   155: aload 5
    //   157: invokevirtual 78	android/graphics/Bitmap:getHeight	()I
    //   160: istore_2
    //   161: fload_1
    //   162: iload_2
    //   163: i2f
    //   164: fdiv
    //   165: fstore_1
    //   166: new 80	android/graphics/Matrix
    //   169: dup
    //   170: invokespecial 81	android/graphics/Matrix:<init>	()V
    //   173: astore 7
    //   175: aload 7
    //   177: fload_1
    //   178: fload_1
    //   179: invokevirtual 85	android/graphics/Matrix:setScale	(FF)V
    //   182: aload 7
    //   184: aload 5
    //   186: aload_0
    //   187: getfield 28	com/tencent/mobileqq/filemanager/util/QQFileManagerUtilImpl$13:e	I
    //   190: aload_0
    //   191: getfield 30	com/tencent/mobileqq/filemanager/util/QQFileManagerUtilImpl$13:f	I
    //   194: invokestatic 90	com/tencent/mobileqq/filemanager/util/QQFileManagerUtilImpl:a	(Landroid/graphics/Matrix;Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   197: astore 5
    //   199: goto +48 -> 247
    //   202: astore 5
    //   204: new 92	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   211: astore 7
    //   213: aload 7
    //   215: ldc 95
    //   217: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload 7
    //   223: aload 5
    //   225: invokevirtual 103	java/lang/Exception:toString	()Ljava/lang/String;
    //   228: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: ldc 105
    //   234: iconst_1
    //   235: aload 7
    //   237: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 111	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: aload 6
    //   245: astore 5
    //   247: aload_0
    //   248: getfield 26	com/tencent/mobileqq/filemanager/util/QQFileManagerUtilImpl$13:d	Lcom/tencent/mobileqq/filemanager/util/QQFileManagerUtil$IGetVideoCallback;
    //   251: astore 6
    //   253: aload 6
    //   255: ifnull +12 -> 267
    //   258: aload 6
    //   260: aload 5
    //   262: invokeinterface 69 2 0
    //   267: return
    //   268: astore 5
    //   270: goto -191 -> 79
    //   273: astore 7
    //   275: goto -188 -> 87
    //   278: astore 6
    //   280: goto -204 -> 76
    //   283: astore 5
    //   285: goto -201 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	288	0	this	13
    //   139	40	1	f1	float
    //   3	160	2	i	int
    //   40	15	3	l	long
    //   9	51	5	localObject1	Object
    //   69	8	5	localObject2	Object
    //   85	113	5	localBitmap	android.graphics.Bitmap
    //   202	22	5	localException1	java.lang.Exception
    //   245	16	5	localIGetVideoCallback1	QQFileManagerUtil.IGetVideoCallback
    //   268	1	5	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   283	1	5	localException2	java.lang.Exception
    //   5	254	6	localIGetVideoCallback2	QQFileManagerUtil.IGetVideoCallback
    //   278	1	6	localException3	java.lang.Exception
    //   24	212	7	localObject3	Object
    //   273	1	7	localException4	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   26	41	69	finally
    //   41	48	69	finally
    //   52	61	69	finally
    //   182	199	202	java/lang/Exception
    //   26	41	268	java/lang/IllegalArgumentException
    //   26	41	268	java/lang/RuntimeException
    //   26	41	268	java/lang/OutOfMemoryError
    //   41	48	268	java/lang/IllegalArgumentException
    //   41	48	268	java/lang/RuntimeException
    //   41	48	268	java/lang/OutOfMemoryError
    //   52	61	268	java/lang/IllegalArgumentException
    //   52	61	268	java/lang/RuntimeException
    //   52	61	268	java/lang/OutOfMemoryError
    //   61	66	273	java/lang/Exception
    //   71	76	278	java/lang/Exception
    //   79	84	283	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl.13
 * JD-Core Version:    0.7.0.1
 */