package com.tencent.open.base;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;

public class BitmapUtil
{
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions, boolean paramBoolean)
  {
    if (paramBitmap == null) {
      return null;
    }
    int i = paramInt1;
    if (paramInt1 == -1) {
      i = paramOptions.outWidth * paramInt2 / paramOptions.outHeight;
    }
    paramInt1 = paramInt2;
    if (paramInt2 == -1) {
      paramInt1 = paramOptions.outHeight * i / paramOptions.outWidth;
    }
    paramInt2 = i;
    int j = paramInt1;
    if (i != -1)
    {
      paramInt2 = i;
      j = paramInt1;
      if (paramInt1 != -1) {
        if (paramOptions.outHeight > paramOptions.outWidth)
        {
          if (paramBoolean)
          {
            paramInt2 = paramOptions.outWidth * paramInt1 / paramOptions.outHeight;
            j = paramInt1;
          }
          else
          {
            j = paramOptions.outHeight * i / paramOptions.outWidth;
            paramInt2 = i;
          }
        }
        else if (paramBoolean)
        {
          j = paramOptions.outHeight * i / paramOptions.outWidth;
          paramInt2 = i;
        }
        else
        {
          paramInt2 = paramOptions.outWidth * paramInt1 / paramOptions.outHeight;
          j = paramInt1;
        }
      }
    }
    return Bitmap.createScaledBitmap(paramBitmap, paramInt2, j, true);
  }
  
  /* Error */
  public static Bitmap a(java.lang.String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 6
    //   12: aload_0
    //   13: ifnull +331 -> 344
    //   16: new 35	java/io/File
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 38	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: invokevirtual 42	java/io/File:exists	()Z
    //   27: ifne +5 -> 32
    //   30: aconst_null
    //   31: areturn
    //   32: aload 4
    //   34: astore 5
    //   36: invokestatic 45	com/tencent/open/base/BitmapUtil:a	()Landroid/graphics/BitmapFactory$Options;
    //   39: astore 9
    //   41: aload 4
    //   43: astore 5
    //   45: new 47	java/io/BufferedInputStream
    //   48: dup
    //   49: new 49	java/io/FileInputStream
    //   52: dup
    //   53: aload_0
    //   54: invokespecial 50	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   57: sipush 8192
    //   60: invokespecial 53	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   63: astore_0
    //   64: aload_0
    //   65: aconst_null
    //   66: aload 9
    //   68: invokestatic 59	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   71: pop
    //   72: aload 6
    //   74: astore 4
    //   76: aload 9
    //   78: getfield 20	android/graphics/BitmapFactory$Options:outHeight	I
    //   81: ifle +125 -> 206
    //   84: aload 6
    //   86: astore 4
    //   88: aload 9
    //   90: getfield 17	android/graphics/BitmapFactory$Options:outWidth	I
    //   93: ifle +113 -> 206
    //   96: aload 9
    //   98: iload_1
    //   99: iload_2
    //   100: iload_3
    //   101: invokestatic 62	com/tencent/open/base/BitmapUtil:a	(Landroid/graphics/BitmapFactory$Options;IIZ)Landroid/graphics/BitmapFactory$Options;
    //   104: pop
    //   105: aload_0
    //   106: aconst_null
    //   107: aload 9
    //   109: invokestatic 59	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   112: astore 4
    //   114: goto +24 -> 138
    //   117: aload 9
    //   119: aload 9
    //   121: getfield 65	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   124: iconst_1
    //   125: isub
    //   126: putfield 65	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   129: aload_0
    //   130: aconst_null
    //   131: aload 9
    //   133: invokestatic 59	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   136: astore 4
    //   138: aload 4
    //   140: ifnonnull +9 -> 149
    //   143: aload_0
    //   144: invokevirtual 68	java/io/BufferedInputStream:close	()V
    //   147: aconst_null
    //   148: areturn
    //   149: aload 4
    //   151: invokevirtual 71	android/graphics/Bitmap:hasAlpha	()Z
    //   154: ifeq +11 -> 165
    //   157: getstatic 77	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   160: astore 5
    //   162: goto +8 -> 170
    //   165: getstatic 80	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   168: astore 5
    //   170: aload 9
    //   172: aload 5
    //   174: putfield 83	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   177: aload 4
    //   179: iload_1
    //   180: iload_2
    //   181: aload 9
    //   183: iload_3
    //   184: invokestatic 85	com/tencent/open/base/BitmapUtil:a	(Landroid/graphics/Bitmap;IILandroid/graphics/BitmapFactory$Options;Z)Landroid/graphics/Bitmap;
    //   187: astore 5
    //   189: aload 5
    //   191: astore 4
    //   193: goto +13 -> 206
    //   196: astore 6
    //   198: goto +52 -> 250
    //   201: astore 6
    //   203: goto +93 -> 296
    //   206: aload_0
    //   207: invokevirtual 68	java/io/BufferedInputStream:close	()V
    //   210: aload 4
    //   212: areturn
    //   213: astore 4
    //   215: goto +118 -> 333
    //   218: astore 6
    //   220: aconst_null
    //   221: astore 4
    //   223: goto +27 -> 250
    //   226: astore 6
    //   228: aconst_null
    //   229: astore 4
    //   231: goto +65 -> 296
    //   234: astore 4
    //   236: aload 5
    //   238: astore_0
    //   239: goto +94 -> 333
    //   242: astore 6
    //   244: aconst_null
    //   245: astore 4
    //   247: aload 7
    //   249: astore_0
    //   250: aload_0
    //   251: astore 5
    //   253: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   256: ifeq +17 -> 273
    //   259: aload_0
    //   260: astore 5
    //   262: ldc 92
    //   264: iconst_2
    //   265: aload 6
    //   267: invokestatic 96	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   270: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   273: aload 4
    //   275: astore 5
    //   277: aload_0
    //   278: ifnull +52 -> 330
    //   281: aload_0
    //   282: invokevirtual 68	java/io/BufferedInputStream:close	()V
    //   285: aload 4
    //   287: areturn
    //   288: astore 6
    //   290: aconst_null
    //   291: astore 4
    //   293: aload 8
    //   295: astore_0
    //   296: aload_0
    //   297: astore 5
    //   299: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   302: ifeq +17 -> 319
    //   305: aload_0
    //   306: astore 5
    //   308: ldc 92
    //   310: iconst_2
    //   311: aload 6
    //   313: invokestatic 96	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   316: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   319: aload 4
    //   321: astore 5
    //   323: aload_0
    //   324: ifnull +6 -> 330
    //   327: goto -46 -> 281
    //   330: aload 5
    //   332: areturn
    //   333: aload_0
    //   334: ifnull +7 -> 341
    //   337: aload_0
    //   338: invokevirtual 68	java/io/BufferedInputStream:close	()V
    //   341: aload 4
    //   343: athrow
    //   344: aconst_null
    //   345: areturn
    //   346: astore 4
    //   348: goto -231 -> 117
    //   351: astore_0
    //   352: aconst_null
    //   353: areturn
    //   354: astore_0
    //   355: goto -145 -> 210
    //   358: astore_0
    //   359: aload 4
    //   361: areturn
    //   362: astore_0
    //   363: goto -22 -> 341
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	366	0	paramString	java.lang.String
    //   0	366	1	paramInt1	int
    //   0	366	2	paramInt2	int
    //   0	366	3	paramBoolean	boolean
    //   1	210	4	localObject1	Object
    //   213	1	4	localObject2	Object
    //   221	9	4	localObject3	Object
    //   234	1	4	localObject4	Object
    //   245	97	4	localBitmap	Bitmap
    //   346	14	4	localException	java.lang.Exception
    //   34	297	5	localObject5	Object
    //   10	75	6	localObject6	Object
    //   196	1	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   201	1	6	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   218	1	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   226	1	6	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   242	24	6	localFileNotFoundException3	java.io.FileNotFoundException
    //   288	24	6	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   4	244	7	localObject7	Object
    //   7	287	8	localObject8	Object
    //   39	143	9	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   149	162	196	java/io/FileNotFoundException
    //   165	170	196	java/io/FileNotFoundException
    //   170	189	196	java/io/FileNotFoundException
    //   149	162	201	java/lang/OutOfMemoryError
    //   165	170	201	java/lang/OutOfMemoryError
    //   170	189	201	java/lang/OutOfMemoryError
    //   64	72	213	finally
    //   76	84	213	finally
    //   88	105	213	finally
    //   105	114	213	finally
    //   117	138	213	finally
    //   149	162	213	finally
    //   165	170	213	finally
    //   170	189	213	finally
    //   64	72	218	java/io/FileNotFoundException
    //   76	84	218	java/io/FileNotFoundException
    //   88	105	218	java/io/FileNotFoundException
    //   105	114	218	java/io/FileNotFoundException
    //   117	138	218	java/io/FileNotFoundException
    //   64	72	226	java/lang/OutOfMemoryError
    //   76	84	226	java/lang/OutOfMemoryError
    //   88	105	226	java/lang/OutOfMemoryError
    //   105	114	226	java/lang/OutOfMemoryError
    //   117	138	226	java/lang/OutOfMemoryError
    //   36	41	234	finally
    //   45	64	234	finally
    //   253	259	234	finally
    //   262	273	234	finally
    //   299	305	234	finally
    //   308	319	234	finally
    //   36	41	242	java/io/FileNotFoundException
    //   45	64	242	java/io/FileNotFoundException
    //   36	41	288	java/lang/OutOfMemoryError
    //   45	64	288	java/lang/OutOfMemoryError
    //   105	114	346	java/lang/Exception
    //   143	147	351	java/lang/Exception
    //   206	210	354	java/lang/Exception
    //   281	285	358	java/lang/Exception
    //   337	341	362	java/lang/Exception
  }
  
  public static BitmapFactory.Options a()
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    localOptions.inPurgeable = true;
    localOptions.inInputShareable = true;
    return localOptions;
  }
  
  public static BitmapFactory.Options a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramOptions.inJustDecodeBounds = false;
    paramOptions.inSampleSize = 2;
    if (paramBoolean) {
      while ((paramOptions.outWidth / paramOptions.inSampleSize >= paramInt1) || (paramOptions.outHeight / paramOptions.inSampleSize >= paramInt2)) {
        paramOptions.inSampleSize += 1;
      }
    }
    while ((paramOptions.outWidth / paramOptions.inSampleSize >= paramInt1) && (paramOptions.outHeight / paramOptions.inSampleSize >= paramInt2)) {
      paramOptions.inSampleSize += 1;
    }
    paramOptions.inSampleSize -= 1;
    return paramOptions;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.base.BitmapUtil
 * JD-Core Version:    0.7.0.1
 */