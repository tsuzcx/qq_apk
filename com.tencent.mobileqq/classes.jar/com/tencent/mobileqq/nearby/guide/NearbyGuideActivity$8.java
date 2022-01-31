package com.tencent.mobileqq.nearby.guide;

class NearbyGuideActivity$8
  implements Runnable
{
  NearbyGuideActivity$8(NearbyGuideActivity paramNearbyGuideActivity, String paramString) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: aload_0
    //   7: getfield 14	com/tencent/mobileqq/nearby/guide/NearbyGuideActivity$8:this$0	Lcom/tencent/mobileqq/nearby/guide/NearbyGuideActivity;
    //   10: invokevirtual 31	com/tencent/mobileqq/nearby/guide/NearbyGuideActivity:getResources	()Landroid/content/res/Resources;
    //   13: ldc 32
    //   15: invokevirtual 38	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   18: istore 4
    //   20: iconst_0
    //   21: istore_1
    //   22: iconst_0
    //   23: istore_3
    //   24: iconst_0
    //   25: istore_2
    //   26: new 40	java/io/FileInputStream
    //   29: dup
    //   30: new 42	java/io/File
    //   33: dup
    //   34: aload_0
    //   35: getfield 16	com/tencent/mobileqq/nearby/guide/NearbyGuideActivity$8:a	Ljava/lang/String;
    //   38: invokespecial 45	java/io/File:<init>	(Ljava/lang/String;)V
    //   41: invokespecial 48	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   44: astore 5
    //   46: iload_3
    //   47: istore_1
    //   48: aload 5
    //   50: astore 6
    //   52: new 50	android/graphics/BitmapFactory$Options
    //   55: dup
    //   56: invokespecial 51	android/graphics/BitmapFactory$Options:<init>	()V
    //   59: astore 9
    //   61: iload_3
    //   62: istore_1
    //   63: aload 5
    //   65: astore 6
    //   67: aload 9
    //   69: aload 5
    //   71: iload 4
    //   73: iload 4
    //   75: invokestatic 56	bdhj:a	(Ljava/io/InputStream;II)D
    //   78: d2i
    //   79: putfield 60	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   82: iload_3
    //   83: istore_1
    //   84: aload 5
    //   86: astore 6
    //   88: aload 5
    //   90: invokevirtual 65	java/io/InputStream:close	()V
    //   93: aload 8
    //   95: astore 7
    //   97: aload_0
    //   98: getfield 16	com/tencent/mobileqq/nearby/guide/NearbyGuideActivity$8:a	Ljava/lang/String;
    //   101: aload 9
    //   103: invokestatic 70	bdal:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   106: astore 8
    //   108: aload 8
    //   110: astore 6
    //   112: aload 8
    //   114: ifnull +24 -> 138
    //   117: aload 8
    //   119: astore 7
    //   121: aload 8
    //   123: aload 8
    //   125: invokevirtual 76	android/graphics/Bitmap:getWidth	()I
    //   128: aload 8
    //   130: invokevirtual 79	android/graphics/Bitmap:getHeight	()I
    //   133: invokestatic 82	bdhj:a	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   136: astore 6
    //   138: aload 6
    //   140: ifnonnull +142 -> 282
    //   143: aload_0
    //   144: getfield 14	com/tencent/mobileqq/nearby/guide/NearbyGuideActivity$8:this$0	Lcom/tencent/mobileqq/nearby/guide/NearbyGuideActivity;
    //   147: iconst_1
    //   148: ldc 83
    //   150: invokestatic 88	alud:a	(I)Ljava/lang/String;
    //   153: invokevirtual 91	com/tencent/mobileqq/nearby/guide/NearbyGuideActivity:a	(ILjava/lang/String;)V
    //   156: return
    //   157: astore 8
    //   159: aconst_null
    //   160: astore 5
    //   162: iload_2
    //   163: istore_1
    //   164: aload 5
    //   166: astore 6
    //   168: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   171: ifeq +20 -> 191
    //   174: iload_2
    //   175: istore_1
    //   176: aload 5
    //   178: astore 6
    //   180: ldc 99
    //   182: iconst_2
    //   183: aload 8
    //   185: invokevirtual 103	java/lang/Throwable:toString	()Ljava/lang/String;
    //   188: invokestatic 107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: aload 7
    //   193: astore 6
    //   195: iload_2
    //   196: ifne -58 -> 138
    //   199: aload 7
    //   201: astore 6
    //   203: aload 5
    //   205: ifnull -67 -> 138
    //   208: aload 5
    //   210: invokevirtual 65	java/io/InputStream:close	()V
    //   213: aload 7
    //   215: astore 6
    //   217: goto -79 -> 138
    //   220: astore 5
    //   222: aload 7
    //   224: astore 6
    //   226: invokestatic 110	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   229: ifeq -91 -> 138
    //   232: aload 5
    //   234: invokevirtual 113	java/io/IOException:printStackTrace	()V
    //   237: aload 7
    //   239: astore 6
    //   241: goto -103 -> 138
    //   244: astore 7
    //   246: aconst_null
    //   247: astore 5
    //   249: iload_1
    //   250: ifne +13 -> 263
    //   253: aload 5
    //   255: ifnull +8 -> 263
    //   258: aload 5
    //   260: invokevirtual 65	java/io/InputStream:close	()V
    //   263: aload 7
    //   265: athrow
    //   266: astore 5
    //   268: invokestatic 110	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   271: ifeq -8 -> 263
    //   274: aload 5
    //   276: invokevirtual 113	java/io/IOException:printStackTrace	()V
    //   279: goto -16 -> 263
    //   282: aload 6
    //   284: ifnull -128 -> 156
    //   287: invokestatic 119	android/os/Message:obtain	()Landroid/os/Message;
    //   290: astore 5
    //   292: aload 5
    //   294: iconst_2
    //   295: putfield 122	android/os/Message:what	I
    //   298: aload 5
    //   300: aload 6
    //   302: putfield 126	android/os/Message:obj	Ljava/lang/Object;
    //   305: aload_0
    //   306: getfield 14	com/tencent/mobileqq/nearby/guide/NearbyGuideActivity$8:this$0	Lcom/tencent/mobileqq/nearby/guide/NearbyGuideActivity;
    //   309: getfield 129	com/tencent/mobileqq/nearby/guide/NearbyGuideActivity:a	Landroid/os/Handler;
    //   312: aload 5
    //   314: invokevirtual 135	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   317: pop
    //   318: return
    //   319: astore 7
    //   321: aload 6
    //   323: astore 5
    //   325: goto -76 -> 249
    //   328: astore 7
    //   330: iconst_1
    //   331: istore_1
    //   332: goto -83 -> 249
    //   335: astore 8
    //   337: goto -175 -> 162
    //   340: astore 8
    //   342: iconst_1
    //   343: istore_2
    //   344: goto -182 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	347	0	this	8
    //   21	311	1	i	int
    //   25	319	2	j	int
    //   23	60	3	k	int
    //   18	56	4	m	int
    //   44	165	5	localFileInputStream	java.io.FileInputStream
    //   220	13	5	localIOException1	java.io.IOException
    //   247	12	5	localObject1	Object
    //   266	9	5	localIOException2	java.io.IOException
    //   290	34	5	localObject2	Object
    //   50	272	6	localObject3	Object
    //   4	234	7	localBitmap1	android.graphics.Bitmap
    //   244	20	7	localObject4	Object
    //   319	1	7	localObject5	Object
    //   328	1	7	localObject6	Object
    //   1	128	8	localBitmap2	android.graphics.Bitmap
    //   157	27	8	localThrowable1	java.lang.Throwable
    //   335	1	8	localThrowable2	java.lang.Throwable
    //   340	1	8	localThrowable3	java.lang.Throwable
    //   59	43	9	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   26	46	157	java/lang/Throwable
    //   208	213	220	java/io/IOException
    //   26	46	244	finally
    //   258	263	266	java/io/IOException
    //   52	61	319	finally
    //   67	82	319	finally
    //   88	93	319	finally
    //   168	174	319	finally
    //   180	191	319	finally
    //   97	108	328	finally
    //   121	138	328	finally
    //   52	61	335	java/lang/Throwable
    //   67	82	335	java/lang/Throwable
    //   88	93	335	java/lang/Throwable
    //   97	108	340	java/lang/Throwable
    //   121	138	340	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.guide.NearbyGuideActivity.8
 * JD-Core Version:    0.7.0.1
 */