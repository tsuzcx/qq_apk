package com.tencent.ttpic.util;

import android.graphics.PointF;
import com.tencent.ttpic.model.SizeI;
import java.util.ArrayList;
import java.util.List;

public class AlgoUtils
{
  public static native void RGBA2YUV420SP(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
  
  public static native void RGBA2YUV420SP2(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
  
  public static native void RGBA2YUV420SP3(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
  
  public static native void YUVNV21TORGBA(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2);
  
  public static native void YUVX2YUV(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
  
  public static SizeI calCutSize(int paramInt1, int paramInt2, double paramDouble)
  {
    if (paramInt1 / paramInt2 >= paramDouble) {
      return new SizeI((int)(paramInt2 * paramDouble), paramInt2);
    }
    return new SizeI(paramInt1, (int)(paramInt1 / paramDouble));
  }
  
  public static float[] calPositions(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2)
  {
    paramFloat1 = paramFloat1 / paramInt1 * 2.0F - 1.0F;
    paramFloat2 = paramFloat2 / paramInt2 * 2.0F - 1.0F;
    paramFloat3 = paramFloat3 / paramInt1 * 2.0F - 1.0F;
    paramFloat4 = paramFloat4 / paramInt2 * 2.0F - 1.0F;
    return new float[] { paramFloat1, paramFloat4, paramFloat1, paramFloat2, paramFloat3, paramFloat2, paramFloat3, paramFloat4 };
  }
  
  public static float[] calTexCoords(int paramInt1, int paramInt2, double paramDouble)
  {
    int m;
    int i;
    int k;
    int j;
    if (paramInt1 / paramInt2 >= paramDouble)
    {
      m = paramInt2;
      i = 0;
      k = (int)(paramInt2 * paramDouble);
      j = (paramInt1 - k) / 2;
      k = j + k;
    }
    for (;;)
    {
      float f1 = j / paramInt1;
      float f2 = k / paramInt1;
      float f3 = m / paramInt2;
      float f4 = i / paramInt2;
      return new float[] { f1, f4, f1, f3, f2, f3, f2, f4 };
      j = 0;
      k = paramInt1;
      m = (int)(paramInt1 / paramDouble);
      i = (paramInt2 - m) / 2;
      m = i + m;
    }
  }
  
  public static float[] calTexCoords(int paramInt1, int paramInt2, int paramInt3, double paramDouble)
  {
    int j;
    int i;
    if (paramInt3 != 90)
    {
      j = paramInt1;
      i = paramInt2;
      if (paramInt3 != 270) {}
    }
    else
    {
      i = paramInt1;
      j = paramInt2;
    }
    int k;
    if (j / i >= paramDouble)
    {
      k = i;
      paramInt1 = 0;
      paramInt3 = (int)(i * paramDouble);
      paramInt2 = (j - paramInt3) / 2;
      paramInt3 = paramInt2 + paramInt3;
    }
    for (;;)
    {
      float f1 = paramInt2 / j;
      float f2 = paramInt3 / j;
      float f3 = k / i;
      float f4 = paramInt1 / i;
      return new float[] { f1, f3, f1, f4, f2, f4, f2, f3 };
      paramInt2 = 0;
      paramInt3 = j;
      k = (int)(j / paramDouble);
      paramInt1 = (i - k) / 2;
      k = paramInt1 + k;
    }
  }
  
  public static float distanceOfPoint2Line(PointF paramPointF1, PointF paramPointF2, float paramFloat, PointF paramPointF3)
  {
    float f1 = getDistance(paramPointF1, paramPointF3);
    float f2 = getDistance(paramPointF2, paramPointF3);
    float f3 = (paramFloat + f1 + f2) / 2.0F;
    f1 = (float)Math.sqrt((f3 - paramFloat) * f3 * (f3 - f1) * (f3 - f2));
    if (f1 < 0.001D) {
      return 0.0F;
    }
    return f1 * 2.0F / paramFloat;
  }
  
  public static float getDistance(PointF paramPointF1, PointF paramPointF2)
  {
    if ((paramPointF1 == null) || (paramPointF2 == null)) {
      return 0.0F;
    }
    double d1 = paramPointF1.x - paramPointF2.x;
    double d2 = paramPointF1.y - paramPointF2.y;
    return (float)Math.sqrt(d1 * d1 + d2 * d2);
  }
  
  public static PointF middlePoint(PointF paramPointF1, PointF paramPointF2)
  {
    if ((paramPointF1 == null) || (paramPointF2 == null)) {
      return new PointF();
    }
    return new PointF((paramPointF1.x + paramPointF2.x) / 2.0F, (paramPointF1.y + paramPointF2.y) / 2.0F);
  }
  
  public static native void nativeRotatePlane(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3);
  
  public static native void nativeScalePlane(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2);
  
  public static List<Float> substract(List<Float> paramList, float[] paramArrayOfFloat)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramArrayOfFloat == null)) {}
    for (;;)
    {
      return localArrayList;
      int i = 0;
      while (i < Math.min(paramList.size(), paramArrayOfFloat.length))
      {
        localArrayList.add(Float.valueOf(((Float)paramList.get(i)).floatValue() - paramArrayOfFloat[i]));
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.AlgoUtils
 * JD-Core Version:    0.7.0.1
 */