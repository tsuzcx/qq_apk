package com.tencent.tav.decoder;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.RectF;
import android.media.MediaCodec;
import android.os.Build.VERSION;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.extractor.ExtractorUtils;
import java.nio.ByteBuffer;

public class DecoderUtils
{
  public static final int AUDIO_SAMPLE_SIZE = 8192;
  public static final int RESAMPLE_CHANNEL_COUNT = 1;
  public static final int RESAMPLE_SAMPLE_RATE = 44100;
  public static final int TIMEOUT_US = 1000;
  
  public static long getAudioDuration(long paramLong, int paramInt1, int paramInt2)
  {
    return paramLong * 1000000L / (paramInt1 * 2 * paramInt2);
  }
  
  public static long getDuration(String paramString)
  {
    return ExtractorUtils.getDuration(paramString);
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
    if ((paramFloat2 <= 0.0F) && (paramFloat1 <= 1.0F)) {
      return null;
    }
    CGSize localCGSize = new CGSize();
    if (paramInt % 2 == 1)
    {
      localCGSize.width = paramCGSize.height;
      localCGSize.height = paramCGSize.width;
    }
    else
    {
      localCGSize.width = paramCGSize.width;
      localCGSize.height = paramCGSize.height;
    }
    if (((CGSize)localObject).width != localCGSize.width)
    {
      paramFloat2 = (localCGSize.width - ((CGSize)localObject).width) * 0.5F;
    }
    else
    {
      if (((CGSize)localObject).height != localCGSize.height)
      {
        paramFloat2 = (localCGSize.height - ((CGSize)localObject).height) * 0.5F;
        f1 = 0.0F;
        break label187;
      }
      paramFloat2 = 0.0F;
    }
    float f2 = 0.0F;
    float f1 = paramFloat2;
    paramFloat2 = f2;
    label187:
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
  }
  
  public static ByteBuffer getOutputBuffer(MediaCodec paramMediaCodec, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return paramMediaCodec.getOutputBuffers()[paramInt];
    }
    return paramMediaCodec.getOutputBuffer(paramInt);
  }
  
  public static Matrix getPreferMatrix(CGSize paramCGSize1, CGSize paramCGSize2, int paramInt)
  {
    Matrix localMatrix1 = new Matrix();
    getMatrixAndCropRect(paramCGSize2, paramInt, 1.0F, 0.0F, new Point(0, 0), localMatrix1);
    Matrix localMatrix2 = new Matrix();
    paramCGSize2 = getTransformedSize(paramCGSize2, paramInt, 0.0F);
    float f1;
    float f2;
    if (paramCGSize2.width * 1.0F / paramCGSize1.width > paramCGSize2.height * 1.0F / paramCGSize1.height)
    {
      f1 = paramCGSize1.width / paramCGSize2.width;
      localMatrix2.setScale(f1, f1);
      f2 = paramCGSize2.height;
      localMatrix2.postTranslate(0.0F, Math.round((paramCGSize1.height - f2 * f1) * 0.5F));
    }
    else
    {
      f1 = paramCGSize1.height / paramCGSize2.height;
      localMatrix2.setScale(f1, f1);
      f2 = paramCGSize2.width;
      localMatrix2.postTranslate(Math.round((paramCGSize1.width - f2 * f1) * 0.5F), 0.0F);
    }
    localMatrix1.postConcat(localMatrix2);
    return localMatrix1;
  }
  
  public static Matrix getRotationMatrix(int paramInt, float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = new Matrix();
    getRotationMatrix(localMatrix, paramInt, paramFloat1, paramFloat2);
    return localMatrix;
  }
  
  public static void getRotationMatrix(Matrix paramMatrix, int paramInt, float paramFloat1, float paramFloat2)
  {
    int i = paramInt % 4;
    paramInt = i;
    if (i < 0) {
      paramInt = i + 4;
    }
    float f1 = -1.0F;
    float f4;
    float f3;
    if (paramInt != 1) {
      if (paramInt != 2) {
        if (paramInt != 3)
        {
          f4 = 0.0F;
          f3 = 0.0F;
          paramFloat1 = 0.0F;
          paramFloat2 = 1.0F;
        }
      }
    }
    float f2;
    for (f1 = 1.0F;; f1 = 0.0F)
    {
      f2 = 0.0F;
      break;
      f4 = 1.0F;
      f3 = 0.0F;
      float f5 = -1.0F;
      paramFloat2 = 0.0F;
      f1 = 0.0F;
      f2 = paramFloat1;
      paramFloat1 = f5;
      break;
      f2 = paramFloat2;
      f4 = 0.0F;
      f5 = 0.0F;
      f3 = -1.0F;
      paramFloat2 = f1;
      f1 = f3;
      f3 = paramFloat1;
      paramFloat1 = f5;
      break;
      f3 = paramFloat2;
      f4 = -1.0F;
      paramFloat1 = 1.0F;
      paramFloat2 = 0.0F;
    }
    paramMatrix.setValues(new float[] { paramFloat2, f4, f3, paramFloat1, f1, f2, 0.0F, 0.0F, 1.0F });
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
      if (paramCGSize.width * 1.0F / paramCGSize.height > paramFloat)
      {
        paramCGSize.width = ((int)Math.ceil(paramCGSize.height * paramFloat));
        return paramCGSize;
      }
      paramCGSize.height = ((int)Math.ceil(paramCGSize.width * 1.0F / paramFloat));
    }
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
      while (i < 9)
      {
        float f;
        if (i % 4 == 0) {
          f = 1.0F;
        } else {
          f = 0.0F;
        }
        arrayOfFloat[i] = f;
        i += 1;
      }
    }
    paramMatrix.getValues(arrayOfFloat);
    swap(arrayOfFloat, 1, 3);
    swap(arrayOfFloat, 2, 6);
    swap(arrayOfFloat, 5, 7);
    return arrayOfFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.decoder.DecoderUtils
 * JD-Core Version:    0.7.0.1
 */