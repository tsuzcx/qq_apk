package com.tencent.tav.decoder;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.RectF;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.extractor.AssetExtractor;
import java.nio.ByteBuffer;

public class DecoderUtils
{
  public static final String MIME_AUDIO = "audio/";
  public static final String MIME_VIDEO = "video/";
  public static final int TIMEOUT_US = 1000;
  
  public static long getAudioDuration(long paramLong, int paramInt1, int paramInt2)
  {
    return 1000000L * paramLong / (paramInt1 * 2 * paramInt2);
  }
  
  /* Error */
  public static long getAudioDuration(AssetExtractor paramAssetExtractor)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 34	com/tencent/tav/extractor/AssetExtractor:getTrackCount	()I
    //   4: istore_2
    //   5: iconst_0
    //   6: istore_1
    //   7: iload_1
    //   8: iload_2
    //   9: if_icmpge +53 -> 62
    //   12: aload_0
    //   13: iload_1
    //   14: invokevirtual 38	com/tencent/tav/extractor/AssetExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   17: astore 5
    //   19: aload 5
    //   21: ldc 40
    //   23: invokevirtual 46	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   26: ldc 8
    //   28: invokevirtual 52	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   31: ifeq +23 -> 54
    //   34: aload 5
    //   36: ldc 54
    //   38: invokevirtual 57	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   41: ifeq +13 -> 54
    //   44: aload 5
    //   46: ldc 54
    //   48: invokevirtual 61	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   51: lstore_3
    //   52: lload_3
    //   53: lreturn
    //   54: iload_1
    //   55: iconst_1
    //   56: iadd
    //   57: istore_1
    //   58: goto -51 -> 7
    //   61: astore_0
    //   62: lconst_0
    //   63: lreturn
    //   64: astore_0
    //   65: goto -3 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	paramAssetExtractor	AssetExtractor
    //   6	52	1	i	int
    //   4	6	2	j	int
    //   51	2	3	l	long
    //   17	28	5	localMediaFormat	MediaFormat
    // Exception table:
    //   from	to	target	type
    //   0	5	61	java/lang/Exception
    //   12	52	61	java/lang/Exception
    //   0	5	64	java/lang/Error
    //   12	52	64	java/lang/Error
  }
  
  public static long getDuration(AssetExtractor paramAssetExtractor)
  {
    try
    {
      j = paramAssetExtractor.getTrackCount();
      i = 0;
      l1 = 0L;
      l2 = 0L;
    }
    catch (Exception paramAssetExtractor)
    {
      int j;
      MediaFormat localMediaFormat;
      String str;
      return 0L;
    }
    catch (Error paramAssetExtractor)
    {
      for (;;)
      {
        int i;
        long l3;
        long l4;
        continue;
        i += 1;
        long l2 = l3;
        long l1 = l4;
      }
    }
    if (i < j)
    {
      localMediaFormat = paramAssetExtractor.getTrackFormat(i);
      str = localMediaFormat.getString("mime");
      if (str.startsWith("video/"))
      {
        l3 = l2;
        l4 = l1;
        if (localMediaFormat.containsKey("durationUs"))
        {
          l4 = localMediaFormat.getLong("durationUs");
          l3 = l2;
        }
      }
      else
      {
        l3 = l2;
        l4 = l1;
        if (str.startsWith("audio/"))
        {
          l3 = l2;
          l4 = l1;
          if (localMediaFormat.containsKey("durationUs"))
          {
            l3 = localMediaFormat.getLong("durationUs");
            l4 = l1;
          }
        }
      }
    }
    else
    {
      if (l1 > 0L) {
        return l1;
      }
      return l2;
    }
  }
  
  public static long getDuration(String paramString)
  {
    try
    {
      AssetExtractor localAssetExtractor = new AssetExtractor();
      localAssetExtractor.setDataSource(paramString);
      long l = getDuration(localAssetExtractor);
      try
      {
        localAssetExtractor.release();
        return l;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return l;
      }
      catch (Error paramString)
      {
        paramString.printStackTrace();
        return l;
      }
      return 0L;
    }
    catch (Error paramString) {}catch (Exception paramString) {}
  }
  
  /* Error */
  public static MediaFormat getFirstFormat(AssetExtractor paramAssetExtractor, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 34	com/tencent/tav/extractor/AssetExtractor:getTrackCount	()I
    //   4: istore_3
    //   5: iconst_0
    //   6: istore_2
    //   7: iload_2
    //   8: iload_3
    //   9: if_icmpge +39 -> 48
    //   12: aload_0
    //   13: iload_2
    //   14: invokevirtual 38	com/tencent/tav/extractor/AssetExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   17: astore 5
    //   19: aload 5
    //   21: ldc 40
    //   23: invokevirtual 46	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   26: aload_1
    //   27: invokevirtual 52	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   30: istore 4
    //   32: iload 4
    //   34: ifeq +6 -> 40
    //   37: aload 5
    //   39: areturn
    //   40: iload_2
    //   41: iconst_1
    //   42: iadd
    //   43: istore_2
    //   44: goto -37 -> 7
    //   47: astore_0
    //   48: aconst_null
    //   49: areturn
    //   50: astore_0
    //   51: goto -3 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	paramAssetExtractor	AssetExtractor
    //   0	54	1	paramString	String
    //   6	38	2	i	int
    //   4	6	3	j	int
    //   30	3	4	bool	boolean
    //   17	21	5	localMediaFormat	MediaFormat
    // Exception table:
    //   from	to	target	type
    //   0	5	47	java/lang/Exception
    //   12	32	47	java/lang/Exception
    //   0	5	50	java/lang/Error
    //   12	32	50	java/lang/Error
  }
  
  /* Error */
  public static int getFirstTrackIndex(AssetExtractor paramAssetExtractor, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 34	com/tencent/tav/extractor/AssetExtractor:getTrackCount	()I
    //   4: istore_3
    //   5: iconst_0
    //   6: istore_2
    //   7: iload_2
    //   8: iload_3
    //   9: if_icmpge +34 -> 43
    //   12: aload_0
    //   13: iload_2
    //   14: invokevirtual 38	com/tencent/tav/extractor/AssetExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   17: ldc 40
    //   19: invokevirtual 46	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   22: aload_1
    //   23: invokevirtual 52	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   26: istore 4
    //   28: iload 4
    //   30: ifeq +5 -> 35
    //   33: iload_2
    //   34: ireturn
    //   35: iload_2
    //   36: iconst_1
    //   37: iadd
    //   38: istore_2
    //   39: goto -32 -> 7
    //   42: astore_0
    //   43: iconst_m1
    //   44: ireturn
    //   45: astore_0
    //   46: goto -3 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	paramAssetExtractor	AssetExtractor
    //   0	49	1	paramString	String
    //   6	33	2	i	int
    //   4	6	3	j	int
    //   26	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   0	5	42	java/lang/Exception
    //   12	28	42	java/lang/Exception
    //   0	5	45	java/lang/Error
    //   12	28	45	java/lang/Error
  }
  
  public static ByteBuffer getInputBuffer(MediaCodec paramMediaCodec, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return paramMediaCodec.getInputBuffers()[paramInt];
    }
    return paramMediaCodec.getInputBuffer(paramInt);
  }
  
  public static Rectangle getMatrixAndCropRect(CGSize paramCGSize, int paramInt, float paramFloat1, float paramFloat2, Point paramPoint, Matrix paramMatrix)
  {
    while (paramInt < 0) {
      paramInt += 4;
    }
    paramInt %= 4;
    getRotationMatrix(paramMatrix, paramInt, paramCGSize.width, paramCGSize.height);
    Object localObject = getTransformedSize(paramCGSize, paramInt, paramFloat2);
    if ((paramFloat2 > 0.0F) || (paramFloat1 > 1.0F))
    {
      CGSize localCGSize = new CGSize();
      float f2;
      float f1;
      if (paramInt % 2 == 1)
      {
        localCGSize.width = paramCGSize.height;
        localCGSize.height = paramCGSize.width;
        f2 = 0.0F;
        paramFloat2 = 0.0F;
        if (((CGSize)localObject).width == localCGSize.width) {
          break label499;
        }
        f1 = (localCGSize.width - ((CGSize)localObject).width) * 0.5F;
      }
      for (;;)
      {
        Matrix localMatrix = new Matrix();
        localMatrix.setTranslate(-f1, -paramFloat2);
        f2 = ((CGSize)localObject).width;
        float f3 = ((CGSize)localObject).height;
        f2 /= paramFloat1;
        f3 /= paramFloat1;
        float f5 = (paramFloat1 - 1.0F) / paramFloat1;
        float f4 = -((CGSize)localObject).width * 0.5F * f5 - paramPoint.x;
        f5 = -((CGSize)localObject).height * 0.5F * f5 - paramPoint.y;
        paramPoint = new Matrix();
        paramPoint.setTranslate(f4, f5);
        f1 -= f4;
        paramFloat2 -= f5;
        localMatrix.postConcat(paramPoint);
        localMatrix.postScale(paramFloat1, paramFloat1);
        paramPoint = new Matrix();
        paramMatrix.invert(paramPoint);
        localObject = new RectF(f1, paramFloat2, f2 + f1, f3 + paramFloat2);
        paramPoint.mapRect((RectF)localObject);
        paramPoint = new Rectangle(((RectF)localObject).left, ((RectF)localObject).top, ((RectF)localObject).width(), ((RectF)localObject).height());
        if (paramPoint.x < 0.0F)
        {
          paramPoint.width += paramPoint.x;
          paramPoint.x = 0.0F;
        }
        if (paramPoint.y < 0.0F)
        {
          paramPoint.height += paramPoint.y;
          paramPoint.y = 0.0F;
        }
        if (paramPoint.x + paramPoint.width > paramCGSize.width) {
          paramPoint.width = (localCGSize.width - paramPoint.x);
        }
        if (paramPoint.y + paramPoint.height > paramCGSize.height) {
          paramPoint.height = (localCGSize.height - paramPoint.y);
        }
        paramMatrix.postConcat(localMatrix);
        return paramPoint;
        localCGSize.width = paramCGSize.width;
        localCGSize.height = paramCGSize.height;
        break;
        label499:
        f1 = f2;
        if (((CGSize)localObject).height != localCGSize.height)
        {
          paramFloat2 = (localCGSize.height - ((CGSize)localObject).height) * 0.5F;
          f1 = f2;
        }
      }
    }
    return null;
  }
  
  public static ByteBuffer getOutputBuffer(MediaCodec paramMediaCodec, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return paramMediaCodec.getOutputBuffers()[paramInt];
    }
    return paramMediaCodec.getOutputBuffer(paramInt);
  }
  
  public static void getRotationMatrix(Matrix paramMatrix, int paramInt, float paramFloat1, float paramFloat2)
  {
    float f1 = -1.0F;
    int i = paramInt % 4;
    paramInt = i;
    if (i < 0) {
      paramInt = i + 4;
    }
    float f2;
    float f3;
    float f4;
    switch (paramInt)
    {
    default: 
      paramFloat2 = 0.0F;
      paramFloat1 = 0.0F;
      f1 = 1.0F;
      f2 = 0.0F;
      f3 = 0.0F;
      f4 = 1.0F;
    }
    for (;;)
    {
      paramMatrix.setValues(new float[] { f4, f2, paramFloat1, f3, f1, paramFloat2, 0.0F, 0.0F, 1.0F });
      return;
      paramFloat1 = paramFloat2;
      f2 = -1.0F;
      f3 = 1.0F;
      f4 = 0.0F;
      f1 = 0.0F;
      paramFloat2 = 0.0F;
      continue;
      f2 = 0.0F;
      f3 = 0.0F;
      f4 = -1.0F;
      continue;
      paramFloat2 = paramFloat1;
      f2 = 1.0F;
      f3 = -1.0F;
      f4 = 0.0F;
      f1 = 0.0F;
      paramFloat1 = 0.0F;
    }
  }
  
  public static CGSize getTransformedSize(CGSize paramCGSize, int paramInt, float paramFloat)
  {
    paramCGSize = paramCGSize.clone();
    if (Math.abs(paramInt) % 2 == 1)
    {
      float f = paramCGSize.width;
      paramCGSize.width = paramCGSize.height;
      paramCGSize.height = f;
    }
    if (paramFloat > 0.0F)
    {
      if (paramCGSize.width * 1.0F / paramCGSize.height > paramFloat) {
        paramCGSize.width = ((int)Math.ceil(paramCGSize.height * paramFloat));
      }
    }
    else {
      return paramCGSize;
    }
    paramCGSize.height = ((int)Math.ceil(paramCGSize.width * 1.0F / paramFloat));
    return paramCGSize;
  }
  
  private static void swap(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    float f = paramArrayOfFloat[paramInt1];
    paramArrayOfFloat[paramInt1] = paramArrayOfFloat[paramInt2];
    paramArrayOfFloat[paramInt2] = f;
  }
  
  public static float[] toOpenGL2DMatrix(Matrix paramMatrix)
  {
    float[] arrayOfFloat = new float[9];
    if (paramMatrix == null)
    {
      int i = 0;
      if (i < 9)
      {
        if (i % 4 == 0) {}
        for (float f = 1.0F;; f = 0.0F)
        {
          arrayOfFloat[i] = f;
          i += 1;
          break;
        }
      }
    }
    else
    {
      paramMatrix.getValues(arrayOfFloat);
      swap(arrayOfFloat, 1, 3);
      swap(arrayOfFloat, 2, 6);
      swap(arrayOfFloat, 5, 7);
    }
    return arrayOfFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.decoder.DecoderUtils
 * JD-Core Version:    0.7.0.1
 */