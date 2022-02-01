package com.tencent.mobileqq.nearby.guide;

class NearbyGuideActivity$8
  implements Runnable
{
  NearbyGuideActivity$8(NearbyGuideActivity paramNearbyGuideActivity, String paramString) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	com/tencent/mobileqq/nearby/guide/NearbyGuideActivity$8:this$0	Lcom/tencent/mobileqq/nearby/guide/NearbyGuideActivity;
    //   4: invokevirtual 31	com/tencent/mobileqq/nearby/guide/NearbyGuideActivity:getResources	()Landroid/content/res/Resources;
    //   7: ldc 32
    //   9: invokevirtual 38	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   12: istore 4
    //   14: aconst_null
    //   15: astore 7
    //   17: aconst_null
    //   18: astore 8
    //   20: aconst_null
    //   21: astore 6
    //   23: iconst_0
    //   24: istore_2
    //   25: iconst_0
    //   26: istore_3
    //   27: iconst_0
    //   28: istore_1
    //   29: new 40	java/io/FileInputStream
    //   32: dup
    //   33: new 42	java/io/File
    //   36: dup
    //   37: aload_0
    //   38: getfield 16	com/tencent/mobileqq/nearby/guide/NearbyGuideActivity$8:a	Ljava/lang/String;
    //   41: invokespecial 45	java/io/File:<init>	(Ljava/lang/String;)V
    //   44: invokespecial 48	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   47: astore 5
    //   49: new 50	android/graphics/BitmapFactory$Options
    //   52: dup
    //   53: invokespecial 51	android/graphics/BitmapFactory$Options:<init>	()V
    //   56: astore 7
    //   58: aload 7
    //   60: aload 5
    //   62: iload 4
    //   64: iload 4
    //   66: invokestatic 56	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/InputStream;II)D
    //   69: d2i
    //   70: putfield 60	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   73: aload 5
    //   75: invokevirtual 65	java/io/InputStream:close	()V
    //   78: aload_0
    //   79: getfield 16	com/tencent/mobileqq/nearby/guide/NearbyGuideActivity$8:a	Ljava/lang/String;
    //   82: aload 7
    //   84: invokestatic 70	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   87: astore 7
    //   89: aload 7
    //   91: astore 6
    //   93: aload 7
    //   95: ifnull +141 -> 236
    //   98: aload 7
    //   100: astore 6
    //   102: aload 7
    //   104: aload 7
    //   106: invokevirtual 76	android/graphics/Bitmap:getWidth	()I
    //   109: aload 7
    //   111: invokevirtual 79	android/graphics/Bitmap:getHeight	()I
    //   114: invokestatic 82	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   117: astore 7
    //   119: aload 7
    //   121: astore 6
    //   123: goto +113 -> 236
    //   126: astore 6
    //   128: iconst_1
    //   129: istore_1
    //   130: goto +162 -> 292
    //   133: astore 8
    //   135: iconst_1
    //   136: istore_2
    //   137: goto +40 -> 177
    //   140: astore 6
    //   142: iload_3
    //   143: istore_1
    //   144: goto +148 -> 292
    //   147: astore 8
    //   149: aconst_null
    //   150: astore 6
    //   152: goto +25 -> 177
    //   155: astore 6
    //   157: aload 7
    //   159: astore 5
    //   161: goto +131 -> 292
    //   164: astore 7
    //   166: aconst_null
    //   167: astore 6
    //   169: aload 8
    //   171: astore 5
    //   173: aload 7
    //   175: astore 8
    //   177: aload 5
    //   179: astore 7
    //   181: iload_2
    //   182: istore_1
    //   183: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   186: ifeq +20 -> 206
    //   189: aload 5
    //   191: astore 7
    //   193: iload_2
    //   194: istore_1
    //   195: ldc 90
    //   197: iconst_2
    //   198: aload 8
    //   200: invokevirtual 94	java/lang/Throwable:toString	()Ljava/lang/String;
    //   203: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: iload_2
    //   207: ifne +29 -> 236
    //   210: aload 5
    //   212: ifnull +24 -> 236
    //   215: aload 5
    //   217: invokevirtual 65	java/io/InputStream:close	()V
    //   220: goto +16 -> 236
    //   223: astore 5
    //   225: invokestatic 101	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   228: ifeq +8 -> 236
    //   231: aload 5
    //   233: invokevirtual 104	java/io/IOException:printStackTrace	()V
    //   236: aload 6
    //   238: ifnonnull +17 -> 255
    //   241: aload_0
    //   242: getfield 14	com/tencent/mobileqq/nearby/guide/NearbyGuideActivity$8:this$0	Lcom/tencent/mobileqq/nearby/guide/NearbyGuideActivity;
    //   245: iconst_1
    //   246: ldc 105
    //   248: invokestatic 110	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   251: invokevirtual 114	com/tencent/mobileqq/nearby/guide/NearbyGuideActivity:showToast	(ILjava/lang/String;)V
    //   254: return
    //   255: aload 6
    //   257: ifnull +34 -> 291
    //   260: invokestatic 120	android/os/Message:obtain	()Landroid/os/Message;
    //   263: astore 5
    //   265: aload 5
    //   267: iconst_2
    //   268: putfield 123	android/os/Message:what	I
    //   271: aload 5
    //   273: aload 6
    //   275: putfield 127	android/os/Message:obj	Ljava/lang/Object;
    //   278: aload_0
    //   279: getfield 14	com/tencent/mobileqq/nearby/guide/NearbyGuideActivity$8:this$0	Lcom/tencent/mobileqq/nearby/guide/NearbyGuideActivity;
    //   282: getfield 131	com/tencent/mobileqq/nearby/guide/NearbyGuideActivity:mUiHandler	Landroid/os/Handler;
    //   285: aload 5
    //   287: invokevirtual 137	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   290: pop
    //   291: return
    //   292: iload_1
    //   293: ifne +29 -> 322
    //   296: aload 5
    //   298: ifnull +24 -> 322
    //   301: aload 5
    //   303: invokevirtual 65	java/io/InputStream:close	()V
    //   306: goto +16 -> 322
    //   309: astore 5
    //   311: invokestatic 101	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   314: ifeq +8 -> 322
    //   317: aload 5
    //   319: invokevirtual 104	java/io/IOException:printStackTrace	()V
    //   322: aload 6
    //   324: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	325	0	this	8
    //   28	265	1	i	int
    //   24	183	2	j	int
    //   26	117	3	k	int
    //   12	53	4	m	int
    //   47	169	5	localObject1	Object
    //   223	9	5	localIOException1	java.io.IOException
    //   263	39	5	localMessage	android.os.Message
    //   309	9	5	localIOException2	java.io.IOException
    //   21	101	6	localObject2	Object
    //   126	1	6	localObject3	Object
    //   140	1	6	localObject4	Object
    //   150	1	6	localObject5	Object
    //   155	1	6	localObject6	Object
    //   167	156	6	localObject7	Object
    //   15	143	7	localObject8	Object
    //   164	10	7	localThrowable1	java.lang.Throwable
    //   179	13	7	localObject9	Object
    //   18	1	8	localObject10	Object
    //   133	1	8	localThrowable2	java.lang.Throwable
    //   147	23	8	localThrowable3	java.lang.Throwable
    //   175	24	8	localThrowable4	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   78	89	126	finally
    //   102	119	126	finally
    //   78	89	133	java/lang/Throwable
    //   102	119	133	java/lang/Throwable
    //   49	78	140	finally
    //   49	78	147	java/lang/Throwable
    //   29	49	155	finally
    //   183	189	155	finally
    //   195	206	155	finally
    //   29	49	164	java/lang/Throwable
    //   215	220	223	java/io/IOException
    //   301	306	309	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.guide.NearbyGuideActivity.8
 * JD-Core Version:    0.7.0.1
 */