package com.tencent.tkd.topicsdk.common;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.media.ExifInterface;
import com.tencent.tkd.topicsdk.framework.TLog;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/common/BitmapUtils;", "", "()V", "BUFFER_SIZE", "", "DEFAULT_JPEG_QUALITY", "TAG", "", "compressToFile", "", "bitmap", "Landroid/graphics/Bitmap;", "format", "Landroid/graphics/Bitmap$CompressFormat;", "quality", "path", "decodeFileWithBuffer", "exifToDegrees", "exifOrientation", "getExif", "Landroid/media/ExifInterface;", "getImageWH", "Lkotlin/Pair;", "resizeAndCrop", "cropRect", "Landroid/graphics/RectF;", "currentImageRect", "currentScale", "", "rotate", "degrees", "shouldCrop", "width", "height", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class BitmapUtils
{
  public static final BitmapUtils a = new BitmapUtils();
  
  private final int a(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 7: 
    default: 
      return 0;
    case 6: 
      return 90;
    case 3: 
      return 180;
    }
    return 270;
  }
  
  private final Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    Object localObject = paramBitmap;
    if (paramInt != 0)
    {
      localObject = new Matrix();
      ((Matrix)localObject).setRotate(paramInt, paramBitmap.getWidth() / 2, paramBitmap.getHeight() / 2);
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
      localObject = paramBitmap;
      if ((Intrinsics.areEqual(paramBitmap, localBitmap) ^ true))
      {
        paramBitmap.recycle();
        Intrinsics.checkExpressionValueIsNotNull(localBitmap, "converted");
        localObject = localBitmap;
      }
      return localObject;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      TLog.c("BitmapUtils", "rotate error", (Throwable)localOutOfMemoryError);
    }
    return paramBitmap;
  }
  
  @JvmStatic
  @Nullable
  public static final Bitmap a(@NotNull Bitmap paramBitmap, @NotNull RectF paramRectF1, @NotNull RectF paramRectF2, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramBitmap, "bitmap");
    Intrinsics.checkParameterIsNotNull(paramRectF1, "cropRect");
    Intrinsics.checkParameterIsNotNull(paramRectF2, "currentImageRect");
    int i = (int)((paramRectF1.left - paramRectF2.left) / paramFloat);
    int j = (int)((paramRectF1.top - paramRectF2.top) / paramFloat);
    int k = (int)(paramRectF1.width() / paramFloat);
    int m = (int)(paramRectF1.height() / paramFloat);
    if (a.a(paramRectF1, paramRectF2, k, m)) {
      try
      {
        paramBitmap = Bitmap.createBitmap(paramBitmap, i, j, k, m);
        return paramBitmap;
      }
      catch (Throwable paramBitmap)
      {
        TLog.a("CropImageView", "ImageStateTransform transform", paramBitmap);
        return null;
      }
    }
    return paramBitmap;
  }
  
  private final ExifInterface a(String paramString)
  {
    try
    {
      paramString = new ExifInterface(paramString);
      return paramString;
    }
    catch (IOException paramString)
    {
      TLog.c("BitmapUtils", "getExif", (Throwable)paramString);
    }
    return null;
  }
  
  /* Error */
  @JvmStatic
  public static final boolean a(@NotNull Bitmap paramBitmap, @NotNull Bitmap.CompressFormat paramCompressFormat, int paramInt, @NotNull String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 111
    //   3: invokestatic 114	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_1
    //   7: ldc 158
    //   9: invokestatic 114	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_3
    //   13: ldc 159
    //   15: invokestatic 114	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   18: aload_0
    //   19: invokevirtual 163	android/graphics/Bitmap:isRecycled	()Z
    //   22: ifeq +5 -> 27
    //   25: iconst_0
    //   26: ireturn
    //   27: invokestatic 169	android/os/SystemClock:uptimeMillis	()J
    //   30: lstore 4
    //   32: aconst_null
    //   33: checkcast 171	java/io/BufferedOutputStream
    //   36: astore 9
    //   38: new 173	java/io/File
    //   41: dup
    //   42: aload_3
    //   43: invokespecial 174	java/io/File:<init>	(Ljava/lang/String;)V
    //   46: astore 8
    //   48: aload 9
    //   50: astore 7
    //   52: aload 8
    //   54: invokevirtual 177	java/io/File:exists	()Z
    //   57: ifne +39 -> 96
    //   60: aload 9
    //   62: astore 7
    //   64: aload 8
    //   66: invokevirtual 180	java/io/File:createNewFile	()Z
    //   69: ifne +27 -> 96
    //   72: aload 9
    //   74: astore 7
    //   76: ldc 96
    //   78: ldc 182
    //   80: invokestatic 186	com/tencent/tkd/topicsdk/framework/TLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: getstatic 191	com/tencent/tkd/topicsdk/common/IoUtils:a	Lcom/tencent/tkd/topicsdk/common/IoUtils;
    //   86: aload 9
    //   88: checkcast 193	java/io/Closeable
    //   91: invokevirtual 196	com/tencent/tkd/topicsdk/common/IoUtils:a	(Ljava/io/Closeable;)V
    //   94: iconst_0
    //   95: ireturn
    //   96: aload 9
    //   98: astore 7
    //   100: new 171	java/io/BufferedOutputStream
    //   103: dup
    //   104: new 198	java/io/FileOutputStream
    //   107: dup
    //   108: aload 8
    //   110: invokespecial 201	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   113: checkcast 203	java/io/OutputStream
    //   116: sipush 8192
    //   119: invokespecial 206	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   122: astore 8
    //   124: aload_0
    //   125: invokevirtual 163	android/graphics/Bitmap:isRecycled	()Z
    //   128: istore 6
    //   130: iload 6
    //   132: ifeq +16 -> 148
    //   135: getstatic 191	com/tencent/tkd/topicsdk/common/IoUtils:a	Lcom/tencent/tkd/topicsdk/common/IoUtils;
    //   138: aload 8
    //   140: checkcast 193	java/io/Closeable
    //   143: invokevirtual 196	com/tencent/tkd/topicsdk/common/IoUtils:a	(Ljava/io/Closeable;)V
    //   146: iconst_0
    //   147: ireturn
    //   148: aload_0
    //   149: aload_1
    //   150: iload_2
    //   151: aload 8
    //   153: checkcast 203	java/io/OutputStream
    //   156: invokevirtual 210	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   159: ifne +23 -> 182
    //   162: ldc 96
    //   164: ldc 212
    //   166: invokestatic 186	com/tencent/tkd/topicsdk/framework/TLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: getstatic 191	com/tencent/tkd/topicsdk/common/IoUtils:a	Lcom/tencent/tkd/topicsdk/common/IoUtils;
    //   172: aload 8
    //   174: checkcast 193	java/io/Closeable
    //   177: invokevirtual 196	com/tencent/tkd/topicsdk/common/IoUtils:a	(Ljava/io/Closeable;)V
    //   180: iconst_0
    //   181: ireturn
    //   182: getstatic 191	com/tencent/tkd/topicsdk/common/IoUtils:a	Lcom/tencent/tkd/topicsdk/common/IoUtils;
    //   185: aload 8
    //   187: checkcast 193	java/io/Closeable
    //   190: invokevirtual 196	com/tencent/tkd/topicsdk/common/IoUtils:a	(Ljava/io/Closeable;)V
    //   193: invokestatic 216	com/tencent/tkd/topicsdk/framework/TopicSDKHelperKt:a	()Z
    //   196: ifeq +41 -> 237
    //   199: ldc 96
    //   201: new 218	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   208: ldc 221
    //   210: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: invokestatic 169	android/os/SystemClock:uptimeMillis	()J
    //   216: lload 4
    //   218: lsub
    //   219: invokevirtual 228	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   222: ldc 230
    //   224: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: aload_3
    //   228: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 236	com/tencent/tkd/topicsdk/framework/TLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: iconst_1
    //   238: ireturn
    //   239: astore_1
    //   240: aload 9
    //   242: astore_0
    //   243: aload_0
    //   244: astore 7
    //   246: ldc 96
    //   248: new 218	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   255: aload_1
    //   256: invokevirtual 239	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   259: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: ldc 230
    //   264: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload_1
    //   268: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   271: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: invokestatic 186	com/tencent/tkd/topicsdk/framework/TLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   277: getstatic 191	com/tencent/tkd/topicsdk/common/IoUtils:a	Lcom/tencent/tkd/topicsdk/common/IoUtils;
    //   280: aload_0
    //   281: checkcast 193	java/io/Closeable
    //   284: invokevirtual 196	com/tencent/tkd/topicsdk/common/IoUtils:a	(Ljava/io/Closeable;)V
    //   287: iconst_0
    //   288: ireturn
    //   289: astore_0
    //   290: getstatic 191	com/tencent/tkd/topicsdk/common/IoUtils:a	Lcom/tencent/tkd/topicsdk/common/IoUtils;
    //   293: aload 7
    //   295: checkcast 193	java/io/Closeable
    //   298: invokevirtual 196	com/tencent/tkd/topicsdk/common/IoUtils:a	(Ljava/io/Closeable;)V
    //   301: aload_0
    //   302: athrow
    //   303: astore_0
    //   304: aload 8
    //   306: astore 7
    //   308: goto -18 -> 290
    //   311: astore_1
    //   312: aload 8
    //   314: astore_0
    //   315: goto -72 -> 243
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	318	0	paramBitmap	Bitmap
    //   0	318	1	paramCompressFormat	Bitmap.CompressFormat
    //   0	318	2	paramInt	int
    //   0	318	3	paramString	String
    //   30	187	4	l	long
    //   128	3	6	bool	boolean
    //   50	257	7	localObject1	Object
    //   46	267	8	localObject2	Object
    //   36	205	9	localBufferedOutputStream	java.io.BufferedOutputStream
    // Exception table:
    //   from	to	target	type
    //   52	60	239	java/lang/Exception
    //   64	72	239	java/lang/Exception
    //   76	83	239	java/lang/Exception
    //   100	124	239	java/lang/Exception
    //   52	60	289	finally
    //   64	72	289	finally
    //   76	83	289	finally
    //   100	124	289	finally
    //   246	277	289	finally
    //   124	130	303	finally
    //   148	169	303	finally
    //   124	130	311	java/lang/Exception
    //   148	169	311	java/lang/Exception
  }
  
  @JvmStatic
  public static final boolean a(@NotNull Bitmap paramBitmap, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramBitmap, "bitmap");
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    return a(paramBitmap, Bitmap.CompressFormat.JPEG, 80, paramString);
  }
  
  private final boolean a(RectF paramRectF1, RectF paramRectF2, int paramInt1, int paramInt2)
  {
    paramInt1 = Math.max(paramInt1, paramInt2) / (int)1000.0F + 1;
    return (Math.abs(paramRectF1.left - paramRectF2.left) > paramInt1) || (Math.abs(paramRectF1.top - paramRectF2.top) > paramInt1) || (Math.abs(paramRectF1.bottom - paramRectF2.bottom) > paramInt1) || (Math.abs(paramRectF1.right - paramRectF2.right) > paramInt1);
  }
  
  /* Error */
  @Nullable
  public final Bitmap a(@NotNull String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 159
    //   3: invokestatic 114	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_1
    //   7: checkcast 272	java/lang/CharSequence
    //   10: invokestatic 278	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +5 -> 18
    //   16: aconst_null
    //   17: areturn
    //   18: aconst_null
    //   19: checkcast 64	android/graphics/Bitmap
    //   22: astore 6
    //   24: aconst_null
    //   25: checkcast 280	java/io/BufferedInputStream
    //   28: astore_3
    //   29: new 280	java/io/BufferedInputStream
    //   32: dup
    //   33: new 282	java/io/FileInputStream
    //   36: dup
    //   37: aload_1
    //   38: invokespecial 283	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   41: checkcast 285	java/io/InputStream
    //   44: invokespecial 288	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   47: astore 4
    //   49: aload 4
    //   51: astore_3
    //   52: aload 4
    //   54: checkcast 285	java/io/InputStream
    //   57: invokestatic 294	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   60: astore 5
    //   62: aload 4
    //   64: invokevirtual 297	java/io/BufferedInputStream:close	()V
    //   67: aload 5
    //   69: astore_3
    //   70: aload_0
    //   71: aload_1
    //   72: invokespecial 299	com/tencent/tkd/topicsdk/common/BitmapUtils:a	(Ljava/lang/String;)Landroid/media/ExifInterface;
    //   75: astore_1
    //   76: aload_1
    //   77: ifnull +162 -> 239
    //   80: aload_1
    //   81: ldc_w 301
    //   84: iconst_1
    //   85: invokevirtual 305	android/media/ExifInterface:getAttributeInt	(Ljava/lang/String;I)I
    //   88: istore_2
    //   89: getstatic 53	com/tencent/tkd/topicsdk/common/BitmapUtils:a	Lcom/tencent/tkd/topicsdk/common/BitmapUtils;
    //   92: iload_2
    //   93: invokespecial 307	com/tencent/tkd/topicsdk/common/BitmapUtils:a	(I)I
    //   96: istore_2
    //   97: aload_3
    //   98: ifnull +141 -> 239
    //   101: getstatic 53	com/tencent/tkd/topicsdk/common/BitmapUtils:a	Lcom/tencent/tkd/topicsdk/common/BitmapUtils;
    //   104: aload_3
    //   105: iload_2
    //   106: invokespecial 309	com/tencent/tkd/topicsdk/common/BitmapUtils:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   109: areturn
    //   110: astore_3
    //   111: ldc 96
    //   113: ldc_w 311
    //   116: aload_3
    //   117: checkcast 100	java/lang/Throwable
    //   120: invokestatic 106	com/tencent/tkd/topicsdk/framework/TLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   123: goto -56 -> 67
    //   126: astore_1
    //   127: aload_3
    //   128: astore 4
    //   130: aload 4
    //   132: astore_3
    //   133: ldc 96
    //   135: ldc_w 313
    //   138: aload_1
    //   139: checkcast 100	java/lang/Throwable
    //   142: invokestatic 106	com/tencent/tkd/topicsdk/framework/TLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   145: aload 4
    //   147: astore_3
    //   148: aload_1
    //   149: checkcast 100	java/lang/Throwable
    //   152: athrow
    //   153: astore_1
    //   154: aload_3
    //   155: ifnull +7 -> 162
    //   158: aload_3
    //   159: invokevirtual 297	java/io/BufferedInputStream:close	()V
    //   162: aload_1
    //   163: athrow
    //   164: astore 5
    //   166: aload_3
    //   167: astore 4
    //   169: aload 4
    //   171: astore_3
    //   172: ldc 96
    //   174: ldc_w 315
    //   177: aload 5
    //   179: checkcast 100	java/lang/Throwable
    //   182: invokestatic 106	com/tencent/tkd/topicsdk/framework/TLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   185: aload 6
    //   187: astore_3
    //   188: aload 4
    //   190: ifnull -120 -> 70
    //   193: aload 4
    //   195: invokevirtual 297	java/io/BufferedInputStream:close	()V
    //   198: aload 6
    //   200: astore_3
    //   201: goto -131 -> 70
    //   204: astore_3
    //   205: ldc 96
    //   207: ldc_w 311
    //   210: aload_3
    //   211: checkcast 100	java/lang/Throwable
    //   214: invokestatic 106	com/tencent/tkd/topicsdk/framework/TLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   217: aload 6
    //   219: astore_3
    //   220: goto -150 -> 70
    //   223: astore_3
    //   224: ldc 96
    //   226: ldc_w 311
    //   229: aload_3
    //   230: checkcast 100	java/lang/Throwable
    //   233: invokestatic 106	com/tencent/tkd/topicsdk/framework/TLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   236: goto -74 -> 162
    //   239: aload_3
    //   240: areturn
    //   241: astore_1
    //   242: goto -88 -> 154
    //   245: astore 5
    //   247: goto -78 -> 169
    //   250: astore_1
    //   251: goto -121 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	this	BitmapUtils
    //   0	254	1	paramString	String
    //   88	18	2	i	int
    //   28	77	3	localObject1	Object
    //   110	18	3	localIOException1	IOException
    //   132	69	3	localObject2	Object
    //   204	7	3	localIOException2	IOException
    //   219	1	3	localBitmap1	Bitmap
    //   223	17	3	localIOException3	IOException
    //   47	147	4	localObject3	Object
    //   60	8	5	localBitmap2	Bitmap
    //   164	14	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   245	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   22	196	6	localBitmap3	Bitmap
    // Exception table:
    //   from	to	target	type
    //   62	67	110	java/io/IOException
    //   29	49	126	java/lang/OutOfMemoryError
    //   52	62	153	finally
    //   133	145	153	finally
    //   148	153	153	finally
    //   172	185	153	finally
    //   29	49	164	java/io/FileNotFoundException
    //   193	198	204	java/io/IOException
    //   158	162	223	java/io/IOException
    //   29	49	241	finally
    //   52	62	245	java/io/FileNotFoundException
    //   52	62	250	java/lang/OutOfMemoryError
  }
  
  @NotNull
  public final Pair<Integer, Integer> a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    return new Pair(Integer.valueOf(localOptions.outWidth), Integer.valueOf(localOptions.outHeight));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.BitmapUtils
 * JD-Core Version:    0.7.0.1
 */