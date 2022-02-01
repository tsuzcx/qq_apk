package com.tencent.util;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class AnimationTools
{
  public static void a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          paramDrawable.setCallback(null);
          if ((paramDrawable instanceof BitmapDrawable))
          {
            paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
            if ((paramDrawable != null) && (!paramDrawable.isRecycled()))
            {
              paramDrawable.recycle();
              return;
            }
          }
        }
        catch (Exception paramDrawable) {}
      }
    } while (!QLog.isDevelopLevel());
    paramDrawable.printStackTrace();
  }
  
  public static void a(String paramString, boolean paramBoolean, File paramFile)
  {
    QLog.d("DecodeDrawables", 2, "1.0 delete " + paramString + paramBoolean + paramFile + paramFile.exists());
    if (paramString == null) {}
    do
    {
      return;
      paramString = new File(paramString);
      QLog.d("DecodeDrawables", 2, "1.0 delete tag0" + paramString + paramString.exists());
      if ((paramString == null) || (!paramString.exists()))
      {
        QLog.d("DecodeDrawables", 2, "1.0 delete tag1" + paramFile.exists());
        return;
      }
      if (paramString.isFile())
      {
        QLog.d("DecodeDrawables", 2, "1.0 delete tag2" + paramString + paramString.exists() + paramFile.exists());
        paramString.delete();
        QLog.d("DecodeDrawables", 2, "1.0 delete tag3" + paramString + paramString.exists() + paramFile.exists());
        return;
      }
      File[] arrayOfFile = paramString.listFiles();
      if (arrayOfFile == null)
      {
        QLog.d("DecodeDrawables", 2, "1.0 delete tag4" + paramFile.exists());
        return;
      }
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        File localFile = arrayOfFile[i];
        QLog.d("DecodeDrawables", 2, "1.0 delete tag5" + localFile + paramFile.exists());
        a(localFile.getAbsolutePath(), paramBoolean, paramFile);
        QLog.d("DecodeDrawables", 2, "1.0 delete tag6" + localFile + paramFile.exists());
        i += 1;
      }
    } while (paramBoolean);
    QLog.d("DecodeDrawables", 2, "1.0 delete tag7" + paramString + paramFile.exists());
    paramString.delete();
    QLog.d("DecodeDrawables", 2, "1.0 delete tag8" + paramString + paramFile.exists());
  }
  
  public static void a(File[] paramArrayOfFile)
  {
    Arrays.sort(paramArrayOfFile, new AnimationTools.1());
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    File localFile2 = new File(paramString1);
    if (!localFile2.exists()) {}
    for (;;)
    {
      return false;
      String str = paramString1 + "Tmp";
      File localFile1 = new File(str);
      if (QLog.isColorLevel()) {
        QLog.d("DecodeDrawables", 2, "unzipAtomically1" + localFile2 + localFile2.exists() + localFile1 + localFile1.exists());
      }
      FileUtils.a(str, false);
      if (QLog.isColorLevel()) {
        QLog.d("DecodeDrawables", 2, "unzipAtomically2" + localFile2 + localFile2.exists() + localFile1 + localFile1.exists());
      }
      if ((QLog.isColorLevel()) && (!localFile2.exists())) {}
      try
      {
        FileUtils.a(new byte[] { 0, 0 }, paramString1);
        QLog.d("DecodeDrawables", 2, "3." + localFile2 + localFile2.exists());
        a(paramString1 + "intern", false, localFile2);
        QLog.d("DecodeDrawables", 2, "4." + localFile2 + localFile2.exists());
        FileUtils.a(new byte[] { 0, 0 }, paramString1);
        QLog.d("DecodeDrawables", 2, "0." + localFile2 + localFile2.exists());
        a(str, false, localFile2);
        QLog.d("DecodeDrawables", 2, "2." + localFile2 + localFile2.exists());
        try
        {
          boolean bool = FileUtils.e(paramString1, str);
          if ((!bool) || (!localFile1.exists())) {
            continue;
          }
        }
        catch (IOException paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
          }
        }
        paramString1 = new File(paramString2);
        FileUtils.a(paramString2, false);
        if ((!FileUtils.b(localFile1, paramString1)) || (!paramString1.exists())) {
          continue;
        }
        return true;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
        }
      }
    }
  }
  
  /* Error */
  public static Drawable[] a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +28 -> 33
    //   8: ldc 45
    //   10: iconst_2
    //   11: new 47	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   18: ldc 164
    //   20: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: new 62	java/io/File
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   41: astore_0
    //   42: aload_0
    //   43: invokevirtual 65	java/io/File:exists	()Z
    //   46: ifne +19 -> 65
    //   49: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   52: ifeq +11 -> 63
    //   55: ldc 45
    //   57: iconst_2
    //   58: ldc 166
    //   60: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   63: aconst_null
    //   64: areturn
    //   65: aload_0
    //   66: invokevirtual 94	java/io/File:listFiles	()[Ljava/io/File;
    //   69: astore 7
    //   71: aload 7
    //   73: ifnull +9 -> 82
    //   76: aload 7
    //   78: arraylength
    //   79: ifgt +19 -> 98
    //   82: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   85: ifeq +11 -> 96
    //   88: ldc 45
    //   90: iconst_2
    //   91: ldc 170
    //   93: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   96: aconst_null
    //   97: areturn
    //   98: aload 7
    //   100: invokestatic 172	com/tencent/util/AnimationTools:a	([Ljava/io/File;)V
    //   103: aload 7
    //   105: arraylength
    //   106: anewarray 15	android/graphics/drawable/Drawable
    //   109: astore 8
    //   111: iconst_0
    //   112: istore_2
    //   113: iconst_0
    //   114: istore_1
    //   115: iload_2
    //   116: aload 7
    //   118: arraylength
    //   119: if_icmpge +349 -> 468
    //   122: aload 7
    //   124: iload_2
    //   125: aaload
    //   126: ifnull +335 -> 461
    //   129: aload 7
    //   131: iload_2
    //   132: aaload
    //   133: invokevirtual 83	java/io/File:isFile	()Z
    //   136: ifeq +325 -> 461
    //   139: aload 7
    //   141: iload_2
    //   142: aaload
    //   143: invokevirtual 101	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   146: invokestatic 176	com/tencent/mobileqq/utils/FileUtils:f	(Ljava/lang/String;)Z
    //   149: ifeq +312 -> 461
    //   152: new 178	java/io/BufferedInputStream
    //   155: dup
    //   156: new 180	java/io/FileInputStream
    //   159: dup
    //   160: aload 7
    //   162: iload_2
    //   163: aaload
    //   164: invokevirtual 101	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   167: invokespecial 181	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   170: invokespecial 184	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   173: astore 5
    //   175: aload 5
    //   177: astore_0
    //   178: aload 8
    //   180: iload_2
    //   181: new 21	android/graphics/drawable/BitmapDrawable
    //   184: dup
    //   185: aload 5
    //   187: invokespecial 185	android/graphics/drawable/BitmapDrawable:<init>	(Ljava/io/InputStream;)V
    //   190: aastore
    //   191: aload 5
    //   193: ifnull +351 -> 544
    //   196: aload 5
    //   198: invokevirtual 188	java/io/BufferedInputStream:close	()V
    //   201: iload_1
    //   202: ifne +16 -> 218
    //   205: aload 8
    //   207: iload_2
    //   208: aaload
    //   209: checkcast 21	android/graphics/drawable/BitmapDrawable
    //   212: invokevirtual 25	android/graphics/drawable/BitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   215: ifnonnull +246 -> 461
    //   218: iload_2
    //   219: istore_1
    //   220: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   223: ifeq +36 -> 259
    //   226: ldc 45
    //   228: iconst_2
    //   229: new 47	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   236: ldc 190
    //   238: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: aload 7
    //   243: iload_2
    //   244: aaload
    //   245: invokevirtual 101	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   248: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   257: iload_2
    //   258: istore_1
    //   259: iload_1
    //   260: iflt +199 -> 459
    //   263: aload 8
    //   265: iload_1
    //   266: aaload
    //   267: invokestatic 192	com/tencent/util/AnimationTools:a	(Landroid/graphics/drawable/Drawable;)V
    //   270: iload_1
    //   271: iconst_1
    //   272: isub
    //   273: istore_1
    //   274: goto -15 -> 259
    //   277: astore_0
    //   278: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   281: ifeq +28 -> 309
    //   284: ldc 45
    //   286: iconst_2
    //   287: new 47	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   294: ldc 194
    //   296: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload_0
    //   300: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   309: iconst_1
    //   310: istore_1
    //   311: goto -110 -> 201
    //   314: astore 6
    //   316: aconst_null
    //   317: astore 5
    //   319: aload 5
    //   321: astore_0
    //   322: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   325: ifeq +32 -> 357
    //   328: aload 5
    //   330: astore_0
    //   331: ldc 45
    //   333: iconst_2
    //   334: new 47	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   341: ldc 196
    //   343: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: aload 6
    //   348: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   351: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   357: aload 5
    //   359: ifnull +180 -> 539
    //   362: aload 5
    //   364: invokevirtual 188	java/io/BufferedInputStream:close	()V
    //   367: iconst_1
    //   368: istore_1
    //   369: goto -168 -> 201
    //   372: astore_0
    //   373: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   376: ifeq +28 -> 404
    //   379: ldc 45
    //   381: iconst_2
    //   382: new 47	java/lang/StringBuilder
    //   385: dup
    //   386: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   389: ldc 194
    //   391: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: aload_0
    //   395: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   398: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   404: iconst_1
    //   405: istore_1
    //   406: goto -205 -> 201
    //   409: astore 5
    //   411: aconst_null
    //   412: astore_0
    //   413: aload_0
    //   414: ifnull +7 -> 421
    //   417: aload_0
    //   418: invokevirtual 188	java/io/BufferedInputStream:close	()V
    //   421: aload 5
    //   423: athrow
    //   424: astore_0
    //   425: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   428: ifeq -7 -> 421
    //   431: ldc 45
    //   433: iconst_2
    //   434: new 47	java/lang/StringBuilder
    //   437: dup
    //   438: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   441: ldc 194
    //   443: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: aload_0
    //   447: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   450: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   456: goto -35 -> 421
    //   459: aconst_null
    //   460: areturn
    //   461: iload_2
    //   462: iconst_1
    //   463: iadd
    //   464: istore_2
    //   465: goto -350 -> 115
    //   468: aload 8
    //   470: arraylength
    //   471: istore 4
    //   473: iconst_0
    //   474: istore_2
    //   475: iload_3
    //   476: istore_1
    //   477: iload_1
    //   478: iload 4
    //   480: if_icmpge +25 -> 505
    //   483: iload_2
    //   484: istore_3
    //   485: aload 8
    //   487: iload_1
    //   488: aaload
    //   489: ifnull +7 -> 496
    //   492: iload_2
    //   493: iconst_1
    //   494: iadd
    //   495: istore_3
    //   496: iload_1
    //   497: iconst_1
    //   498: iadd
    //   499: istore_1
    //   500: iload_3
    //   501: istore_2
    //   502: goto -25 -> 477
    //   505: iload_2
    //   506: iconst_1
    //   507: if_icmpge +19 -> 526
    //   510: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   513: ifeq +11 -> 524
    //   516: ldc 45
    //   518: iconst_2
    //   519: ldc 198
    //   521: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   524: aconst_null
    //   525: areturn
    //   526: aload 8
    //   528: areturn
    //   529: astore 5
    //   531: goto -118 -> 413
    //   534: astore 6
    //   536: goto -217 -> 319
    //   539: iconst_1
    //   540: istore_1
    //   541: goto -340 -> 201
    //   544: goto -343 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	547	0	paramString	String
    //   114	427	1	i	int
    //   112	396	2	j	int
    //   1	500	3	k	int
    //   471	10	4	m	int
    //   173	190	5	localBufferedInputStream	java.io.BufferedInputStream
    //   409	13	5	localObject1	Object
    //   529	1	5	localObject2	Object
    //   314	33	6	localThrowable1	Throwable
    //   534	1	6	localThrowable2	Throwable
    //   69	173	7	arrayOfFile	File[]
    //   109	418	8	arrayOfDrawable	Drawable[]
    // Exception table:
    //   from	to	target	type
    //   196	201	277	java/io/IOException
    //   152	175	314	java/lang/Throwable
    //   362	367	372	java/io/IOException
    //   152	175	409	finally
    //   417	421	424	java/io/IOException
    //   178	191	529	finally
    //   322	328	529	finally
    //   331	357	529	finally
    //   178	191	534	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.util.AnimationTools
 * JD-Core Version:    0.7.0.1
 */