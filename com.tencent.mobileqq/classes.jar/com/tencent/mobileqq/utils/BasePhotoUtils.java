package com.tencent.mobileqq.utils;

import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import java.io.File;

public class BasePhotoUtils
{
  public static final int BUFFER_SIZE_DECODE_BITMAP = 8192;
  public static final int BUFFER_SIZE_DECODE_BOUND = 8192;
  private static final String TAG = "BasePhotoUtils";
  
  /* Error */
  public static android.graphics.Bitmap decodeFileWithBuffer(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 27	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 30	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   10: astore_2
    //   11: aload_1
    //   12: ifnull +36 -> 48
    //   15: aload_2
    //   16: astore_0
    //   17: aload_1
    //   18: getfield 36	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   21: ifeq +27 -> 48
    //   24: aload_2
    //   25: astore_0
    //   26: new 38	java/io/BufferedInputStream
    //   29: dup
    //   30: aload_2
    //   31: sipush 8192
    //   34: invokespecial 41	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   37: aconst_null
    //   38: aload_1
    //   39: invokestatic 47	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   42: astore_1
    //   43: aload_1
    //   44: astore_0
    //   45: goto +24 -> 69
    //   48: aload_2
    //   49: astore_0
    //   50: new 38	java/io/BufferedInputStream
    //   53: dup
    //   54: aload_2
    //   55: sipush 8192
    //   58: invokespecial 41	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   61: aconst_null
    //   62: aload_1
    //   63: invokestatic 47	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   66: astore_1
    //   67: aload_1
    //   68: astore_0
    //   69: aload_2
    //   70: invokevirtual 52	java/io/InputStream:close	()V
    //   73: aload_0
    //   74: areturn
    //   75: astore_1
    //   76: goto +16 -> 92
    //   79: astore_1
    //   80: goto +34 -> 114
    //   83: astore_1
    //   84: aconst_null
    //   85: astore_0
    //   86: goto +59 -> 145
    //   89: astore_1
    //   90: aconst_null
    //   91: astore_2
    //   92: aload_2
    //   93: astore_0
    //   94: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   97: ifeq +71 -> 168
    //   100: aload_2
    //   101: astore_0
    //   102: ldc 12
    //   104: iconst_2
    //   105: ldc 60
    //   107: aload_1
    //   108: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   111: goto +57 -> 168
    //   114: aload_2
    //   115: astore_0
    //   116: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   119: ifeq +14 -> 133
    //   122: aload_2
    //   123: astore_0
    //   124: ldc 12
    //   126: iconst_2
    //   127: ldc 60
    //   129: aload_1
    //   130: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   133: aload_2
    //   134: ifnull +8 -> 142
    //   137: aload_3
    //   138: astore_0
    //   139: goto -70 -> 69
    //   142: aconst_null
    //   143: areturn
    //   144: astore_1
    //   145: aload_0
    //   146: ifnull +7 -> 153
    //   149: aload_0
    //   150: invokevirtual 52	java/io/InputStream:close	()V
    //   153: goto +5 -> 158
    //   156: aload_1
    //   157: athrow
    //   158: goto -2 -> 156
    //   161: astore_1
    //   162: aload_0
    //   163: areturn
    //   164: astore_0
    //   165: goto -12 -> 153
    //   168: aload_2
    //   169: ifnull -27 -> 142
    //   172: aload_3
    //   173: astore_0
    //   174: goto -105 -> 69
    //   177: astore_1
    //   178: aconst_null
    //   179: astore_2
    //   180: goto -66 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	paramString	String
    //   0	183	1	paramOptions	BitmapFactory.Options
    //   10	170	2	localFileInputStream	java.io.FileInputStream
    //   1	172	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	24	75	java/lang/Exception
    //   26	43	75	java/lang/Exception
    //   50	67	75	java/lang/Exception
    //   17	24	79	java/lang/OutOfMemoryError
    //   26	43	79	java/lang/OutOfMemoryError
    //   50	67	79	java/lang/OutOfMemoryError
    //   2	11	83	finally
    //   2	11	89	java/lang/Exception
    //   17	24	144	finally
    //   26	43	144	finally
    //   50	67	144	finally
    //   94	100	144	finally
    //   102	111	144	finally
    //   116	122	144	finally
    //   124	133	144	finally
    //   69	73	161	java/io/IOException
    //   149	153	164	java/io/IOException
    //   2	11	177	java/lang/OutOfMemoryError
  }
  
  public static String getImageMimeType(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (!new File(paramString).exists()) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    decodeFileWithBuffer(paramString, localOptions);
    return localOptions.outMimeType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.BasePhotoUtils
 * JD-Core Version:    0.7.0.1
 */