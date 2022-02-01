package com.tencent.mobileqq.gallery.picocr;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.qq.taf.jce.HexUtil;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class PicOrcUtils
{
  public static Bitmap a(String paramString, BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    try
    {
      localObject1 = SafeBitmapFactory.safeDecode(paramString, paramOptions);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Object localObject1;
      label10:
      Object localObject2;
      break label10;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("retry:");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(", sampleSize:");
      ((StringBuilder)localObject1).append(paramOptions.inSampleSize);
      QLog.i("PicOrcUtils", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = null;
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (paramInt1 < paramInt2)
      {
        paramOptions.inSampleSize *= 2;
        localObject2 = a(paramString, paramOptions, paramInt1 + 1, paramInt2);
      }
    }
    return localObject2;
  }
  
  /* Error */
  public static String a(Bitmap paramBitmap, String paramString, int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: iconst_3
    //   1: newarray int
    //   3: astore 6
    //   5: aload 6
    //   7: dup
    //   8: iconst_0
    //   9: bipush 60
    //   11: iastore
    //   12: dup
    //   13: iconst_1
    //   14: bipush 40
    //   16: iastore
    //   17: dup
    //   18: iconst_2
    //   19: bipush 20
    //   21: iastore
    //   22: pop
    //   23: new 62	java/io/ByteArrayOutputStream
    //   26: dup
    //   27: invokespecial 63	java/io/ByteArrayOutputStream:<init>	()V
    //   30: astore 5
    //   32: iconst_0
    //   33: istore_3
    //   34: iconst_0
    //   35: istore 4
    //   37: iload_3
    //   38: aload 6
    //   40: arraylength
    //   41: if_icmpge +40 -> 81
    //   44: aload_0
    //   45: aload 5
    //   47: aload 6
    //   49: iload_3
    //   50: iaload
    //   51: invokestatic 66	com/tencent/mobileqq/gallery/picocr/PicOrcUtils:a	(Landroid/graphics/Bitmap;Ljava/io/ByteArrayOutputStream;I)Z
    //   54: istore 4
    //   56: iload 4
    //   58: ifeq +16 -> 74
    //   61: aload 5
    //   63: invokevirtual 70	java/io/ByteArrayOutputStream:size	()I
    //   66: ldc 71
    //   68: if_icmpge +6 -> 74
    //   71: goto +10 -> 81
    //   74: iload_3
    //   75: iconst_1
    //   76: iadd
    //   77: istore_3
    //   78: goto -41 -> 37
    //   81: iload_3
    //   82: aload 6
    //   84: arraylength
    //   85: if_icmplt +13 -> 98
    //   88: aload_0
    //   89: aload 5
    //   91: bipush 10
    //   93: invokestatic 66	com/tencent/mobileqq/gallery/picocr/PicOrcUtils:a	(Landroid/graphics/Bitmap;Ljava/io/ByteArrayOutputStream;I)Z
    //   96: istore 4
    //   98: iload 4
    //   100: ifne +22 -> 122
    //   103: invokestatic 25	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   106: ifeq +14 -> 120
    //   109: ldc 2
    //   111: invokevirtual 76	java/lang/Class:getName	()Ljava/lang/String;
    //   114: iconst_2
    //   115: ldc 78
    //   117: invokestatic 81	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: aconst_null
    //   121: areturn
    //   122: aload_2
    //   123: iconst_0
    //   124: aload_0
    //   125: invokevirtual 86	android/graphics/Bitmap:getWidth	()I
    //   128: iastore
    //   129: aload_2
    //   130: iconst_1
    //   131: aload_0
    //   132: invokevirtual 89	android/graphics/Bitmap:getHeight	()I
    //   135: iastore
    //   136: new 91	java/io/File
    //   139: dup
    //   140: aload_1
    //   141: invokespecial 94	java/io/File:<init>	(Ljava/lang/String;)V
    //   144: invokevirtual 95	java/io/File:getName	()Ljava/lang/String;
    //   147: iconst_0
    //   148: invokestatic 100	com/tencent/mobileqq/ocr/OcrImageUtil:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   151: astore_2
    //   152: new 102	java/io/FileOutputStream
    //   155: dup
    //   156: new 91	java/io/File
    //   159: dup
    //   160: aload_2
    //   161: invokespecial 94	java/io/File:<init>	(Ljava/lang/String;)V
    //   164: invokespecial 105	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   167: astore_1
    //   168: aload_1
    //   169: astore_0
    //   170: aload_1
    //   171: aload 5
    //   173: invokevirtual 109	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   176: invokevirtual 113	java/io/FileOutputStream:write	([B)V
    //   179: aload_1
    //   180: astore_0
    //   181: aload_1
    //   182: invokevirtual 116	java/io/FileOutputStream:flush	()V
    //   185: aload_1
    //   186: invokevirtual 119	java/io/FileOutputStream:close	()V
    //   189: aload_2
    //   190: areturn
    //   191: astore_0
    //   192: aload_0
    //   193: invokevirtual 122	java/lang/Exception:printStackTrace	()V
    //   196: aload_2
    //   197: areturn
    //   198: astore_0
    //   199: aconst_null
    //   200: astore_1
    //   201: goto +49 -> 250
    //   204: aconst_null
    //   205: astore_1
    //   206: aload_1
    //   207: astore_0
    //   208: invokestatic 25	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   211: ifeq +16 -> 227
    //   214: aload_1
    //   215: astore_0
    //   216: ldc 2
    //   218: invokevirtual 76	java/lang/Class:getName	()Ljava/lang/String;
    //   221: iconst_2
    //   222: ldc 124
    //   224: invokestatic 81	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   227: aload_1
    //   228: ifnull +15 -> 243
    //   231: aload_1
    //   232: invokevirtual 119	java/io/FileOutputStream:close	()V
    //   235: goto +8 -> 243
    //   238: astore_0
    //   239: aload_0
    //   240: invokevirtual 122	java/lang/Exception:printStackTrace	()V
    //   243: aconst_null
    //   244: areturn
    //   245: astore_2
    //   246: aload_0
    //   247: astore_1
    //   248: aload_2
    //   249: astore_0
    //   250: aload_1
    //   251: ifnull +15 -> 266
    //   254: aload_1
    //   255: invokevirtual 119	java/io/FileOutputStream:close	()V
    //   258: goto +8 -> 266
    //   261: astore_1
    //   262: aload_1
    //   263: invokevirtual 122	java/lang/Exception:printStackTrace	()V
    //   266: goto +5 -> 271
    //   269: aload_0
    //   270: athrow
    //   271: goto -2 -> 269
    //   274: astore_0
    //   275: goto -71 -> 204
    //   278: astore_0
    //   279: goto -73 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	paramBitmap	Bitmap
    //   0	282	1	paramString	String
    //   0	282	2	paramArrayOfInt	int[]
    //   33	53	3	i	int
    //   35	64	4	bool	boolean
    //   30	142	5	localByteArrayOutputStream	ByteArrayOutputStream
    //   3	80	6	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   185	189	191	java/lang/Exception
    //   152	168	198	finally
    //   231	235	238	java/lang/Exception
    //   170	179	245	finally
    //   181	185	245	finally
    //   208	214	245	finally
    //   216	227	245	finally
    //   254	258	261	java/lang/Exception
    //   152	168	274	java/lang/Exception
    //   170	179	278	java/lang/Exception
    //   181	185	278	java/lang/Exception
  }
  
  public static String a(String paramString)
  {
    String str = "";
    System.currentTimeMillis();
    try
    {
      localObject = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
      return localObject;
    }
    catch (OutOfMemoryError paramString)
    {
      paramString.printStackTrace();
      return "";
      localObject = new File(paramString);
      paramString = str;
      if (!((File)localObject).exists()) {}
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        try
        {
          Object localObject;
          paramString = MD5FileUtil.a((File)localObject);
          if (paramString == null) {
            paramString = "";
          }
          return paramString;
        }
        catch (IOException paramString) {}
        localUnsatisfiedLinkError = localUnsatisfiedLinkError;
      }
    }
    return "";
  }
  
  private static boolean a(Bitmap paramBitmap, ByteArrayOutputStream paramByteArrayOutputStream, int paramInt)
  {
    try
    {
      paramByteArrayOutputStream.reset();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, paramByteArrayOutputStream);
      return true;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      if (QLog.isColorLevel()) {
        QLog.e(PicOrcUtils.class.getName(), 2, "doCompress OutOfMemoryError:", paramBitmap);
      }
      paramByteArrayOutputStream.reset();
      return false;
    }
    catch (Exception paramBitmap)
    {
      if (QLog.isColorLevel()) {
        QLog.e(PicOrcUtils.class.getName(), 2, "doCompress Exception:", paramBitmap);
      }
      paramByteArrayOutputStream.reset();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.picocr.PicOrcUtils
 * JD-Core Version:    0.7.0.1
 */