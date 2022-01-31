package dov.com.tencent.mobileqq.richmedia.mediacodec.tracker;

import android.annotation.TargetApi;
import android.media.Image;
import android.media.Image.Plane;
import java.nio.ByteBuffer;

public class TrackingUtil
{
  public static float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = paramInt3 / paramInt4;
    float f2 = paramInt1 / paramInt2;
    if (f1 < f2) {
      return paramInt4 / paramInt2;
    }
    if (f1 > f2) {
      return paramInt3 / paramInt1;
    }
    return paramInt4 / paramInt2;
  }
  
  @TargetApi(19)
  public static byte[] a(Image paramImage, byte[] paramArrayOfByte)
  {
    paramImage.getFormat();
    int m = paramImage.getWidth();
    int n = paramImage.getHeight();
    paramImage = paramImage.getPlanes();
    ByteBuffer localByteBuffer = paramImage[0].getBuffer();
    int i1 = paramImage[0].getRowStride();
    int i2 = paramImage[0].getPixelStride();
    localByteBuffer.position(0);
    int i = 0;
    int j = 0;
    int k = m;
    if (i < n)
    {
      if (i2 == 1)
      {
        localByteBuffer.get(paramArrayOfByte, j, k);
        j += k;
      }
      for (;;)
      {
        if (i < n - 1) {
          localByteBuffer.position(localByteBuffer.position() + i1 - k);
        }
        i += 1;
        break;
        k = (m - 1) * i2 + 1;
      }
    }
    return paramArrayOfByte;
  }
  
  public static float b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f = 0.0F;
    if (paramInt3 / paramInt4 < paramInt1 / paramInt2) {
      f = (paramInt4 / paramInt2 * paramInt1 - paramInt3) / 2.0F;
    }
    return f;
  }
  
  public static float c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f = 0.0F;
    if (paramInt3 / paramInt4 > paramInt1 / paramInt2) {
      f = (paramInt3 / paramInt1 * paramInt2 - paramInt4) / 2.0F;
    }
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.tracker.TrackingUtil
 * JD-Core Version:    0.7.0.1
 */