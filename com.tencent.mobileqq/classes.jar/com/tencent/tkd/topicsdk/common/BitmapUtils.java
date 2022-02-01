package com.tencent.tkd.topicsdk.common;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.tencent.tkd.topicsdk.framework.TLog;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/common/BitmapUtils;", "", "()V", "TAG", "", "decodeFileWithBuffer", "Landroid/graphics/Bitmap;", "path", "exifToDegrees", "", "exifOrientation", "getExif", "Landroid/media/ExifInterface;", "getImageWH", "Lkotlin/Pair;", "rotate", "bitmap", "degrees", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class BitmapUtils
{
  public static final BitmapUtils a = new BitmapUtils();
  
  private final int a(int paramInt)
  {
    if (paramInt != 3)
    {
      if (paramInt != 6)
      {
        if (paramInt != 8) {
          return 0;
        }
        return 270;
      }
      return 90;
    }
    return 180;
  }
  
  private final Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    if (paramInt != 0)
    {
      Object localObject = new Matrix();
      float f1 = paramInt;
      float f2 = paramBitmap.getWidth();
      float f3 = 2;
      ((Matrix)localObject).setRotate(f1, f2 / f3, paramBitmap.getHeight() / f3);
      try
      {
        localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
        if ((Intrinsics.areEqual(paramBitmap, localObject) ^ true))
        {
          paramBitmap.recycle();
          Intrinsics.checkExpressionValueIsNotNull(localObject, "converted");
          return localObject;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        TLog.b("BitmapUtils", "rotate error", (Throwable)localOutOfMemoryError);
      }
    }
    return paramBitmap;
  }
  
  private final ExifInterface c(String paramString)
  {
    try
    {
      paramString = new ExifInterface(paramString);
      return paramString;
    }
    catch (IOException paramString)
    {
      TLog.b("BitmapUtils", "getExif", (Throwable)paramString);
    }
    return null;
  }
  
  /* Error */
  @org.jetbrains.annotations.Nullable
  public final Bitmap a(@NotNull String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 108
    //   3: invokestatic 111	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_1
    //   7: checkcast 113	java/lang/CharSequence
    //   10: invokestatic 119	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +5 -> 18
    //   16: aconst_null
    //   17: areturn
    //   18: aconst_null
    //   19: checkcast 50	android/graphics/Bitmap
    //   22: astore 6
    //   24: aconst_null
    //   25: checkcast 121	java/io/BufferedInputStream
    //   28: astore 5
    //   30: aload 5
    //   32: astore_3
    //   33: new 121	java/io/BufferedInputStream
    //   36: dup
    //   37: new 123	java/io/FileInputStream
    //   40: dup
    //   41: aload_1
    //   42: invokespecial 124	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   45: checkcast 126	java/io/InputStream
    //   48: invokespecial 129	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   51: astore 4
    //   53: aload 4
    //   55: checkcast 126	java/io/InputStream
    //   58: invokestatic 135	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   61: astore 5
    //   63: aload 5
    //   65: astore_3
    //   66: aload 4
    //   68: invokevirtual 138	java/io/BufferedInputStream:close	()V
    //   71: aload 5
    //   73: astore_3
    //   74: goto +86 -> 160
    //   77: astore 4
    //   79: ldc 82
    //   81: ldc 140
    //   83: aload 4
    //   85: checkcast 86	java/lang/Throwable
    //   88: invokestatic 92	com/tencent/tkd/topicsdk/framework/TLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   91: goto +69 -> 160
    //   94: astore_1
    //   95: aload 4
    //   97: astore_3
    //   98: goto +126 -> 224
    //   101: astore_3
    //   102: aload 4
    //   104: astore 5
    //   106: aload_3
    //   107: astore 4
    //   109: goto +17 -> 126
    //   112: astore_1
    //   113: aload 4
    //   115: astore 5
    //   117: goto +85 -> 202
    //   120: astore_1
    //   121: goto +103 -> 224
    //   124: astore 4
    //   126: aload 5
    //   128: astore_3
    //   129: ldc 82
    //   131: ldc 142
    //   133: aload 4
    //   135: checkcast 86	java/lang/Throwable
    //   138: invokestatic 92	com/tencent/tkd/topicsdk/framework/TLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   141: aload 6
    //   143: astore_3
    //   144: aload 5
    //   146: ifnull +14 -> 160
    //   149: aload 6
    //   151: astore_3
    //   152: aload 5
    //   154: invokevirtual 138	java/io/BufferedInputStream:close	()V
    //   157: aload 6
    //   159: astore_3
    //   160: aload_0
    //   161: aload_1
    //   162: invokespecial 144	com/tencent/tkd/topicsdk/common/BitmapUtils:c	(Ljava/lang/String;)Landroid/media/ExifInterface;
    //   165: astore_1
    //   166: aload_1
    //   167: ifnull +32 -> 199
    //   170: aload_1
    //   171: ldc 146
    //   173: iconst_1
    //   174: invokevirtual 150	android/media/ExifInterface:getAttributeInt	(Ljava/lang/String;I)I
    //   177: istore_2
    //   178: getstatic 39	com/tencent/tkd/topicsdk/common/BitmapUtils:a	Lcom/tencent/tkd/topicsdk/common/BitmapUtils;
    //   181: iload_2
    //   182: invokespecial 152	com/tencent/tkd/topicsdk/common/BitmapUtils:a	(I)I
    //   185: istore_2
    //   186: aload_3
    //   187: ifnull +12 -> 199
    //   190: getstatic 39	com/tencent/tkd/topicsdk/common/BitmapUtils:a	Lcom/tencent/tkd/topicsdk/common/BitmapUtils;
    //   193: aload_3
    //   194: iload_2
    //   195: invokespecial 154	com/tencent/tkd/topicsdk/common/BitmapUtils:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   198: areturn
    //   199: aload_3
    //   200: areturn
    //   201: astore_1
    //   202: aload 5
    //   204: astore_3
    //   205: ldc 82
    //   207: ldc 156
    //   209: aload_1
    //   210: checkcast 86	java/lang/Throwable
    //   213: invokestatic 92	com/tencent/tkd/topicsdk/framework/TLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   216: aload 5
    //   218: astore_3
    //   219: aload_1
    //   220: checkcast 86	java/lang/Throwable
    //   223: athrow
    //   224: aload_3
    //   225: ifnull +22 -> 247
    //   228: aload_3
    //   229: invokevirtual 138	java/io/BufferedInputStream:close	()V
    //   232: goto +15 -> 247
    //   235: astore_3
    //   236: ldc 82
    //   238: ldc 140
    //   240: aload_3
    //   241: checkcast 86	java/lang/Throwable
    //   244: invokestatic 92	com/tencent/tkd/topicsdk/framework/TLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   247: aload_1
    //   248: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	this	BitmapUtils
    //   0	249	1	paramString	String
    //   177	18	2	i	int
    //   32	66	3	localObject1	Object
    //   101	6	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   128	101	3	localObject2	Object
    //   235	6	3	localIOException1	IOException
    //   51	16	4	localBufferedInputStream	java.io.BufferedInputStream
    //   77	26	4	localIOException2	IOException
    //   107	7	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   124	10	4	localFileNotFoundException3	java.io.FileNotFoundException
    //   28	189	5	localObject3	Object
    //   22	136	6	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   66	71	77	java/io/IOException
    //   152	157	77	java/io/IOException
    //   53	63	94	finally
    //   53	63	101	java/io/FileNotFoundException
    //   53	63	112	java/lang/OutOfMemoryError
    //   33	53	120	finally
    //   129	141	120	finally
    //   205	216	120	finally
    //   219	224	120	finally
    //   33	53	124	java/io/FileNotFoundException
    //   33	53	201	java/lang/OutOfMemoryError
    //   228	232	235	java/io/IOException
  }
  
  @NotNull
  public final Pair<Integer, Integer> b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    return new Pair(Integer.valueOf(localOptions.outWidth), Integer.valueOf(localOptions.outHeight));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.BitmapUtils
 * JD-Core Version:    0.7.0.1
 */