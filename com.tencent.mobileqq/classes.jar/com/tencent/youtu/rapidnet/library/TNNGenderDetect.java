package com.tencent.youtu.rapidnet.library;

import android.graphics.Bitmap;
import android.graphics.PointF;
import java.util.List;

public class TNNGenderDetect
{
  private long nativePtr;
  
  public float[] FacePoints2Box(List<PointF> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = 0;
      float f1 = 1.4E-45F;
      float f4 = 1.4E-45F;
      float f2 = 3.4028235E+38F;
      float f3;
      for (float f5 = 3.4028235E+38F; i < paramList.size(); f5 = f3)
      {
        f3 = f5;
        if (((PointF)paramList.get(i)).x < f5) {
          f3 = ((PointF)paramList.get(i)).x;
        }
        f5 = f4;
        if (((PointF)paramList.get(i)).x > f4) {
          f5 = ((PointF)paramList.get(i)).x;
        }
        float f6 = f2;
        if (((PointF)paramList.get(i)).y < f2) {
          f6 = ((PointF)paramList.get(i)).y;
        }
        f2 = f1;
        if (((PointF)paramList.get(i)).y > f1) {
          f2 = ((PointF)paramList.get(i)).y;
        }
        i += 1;
        f1 = f2;
        f4 = f5;
        f2 = f6;
      }
      if ((f5 == 3.4028235E+38F) || (f2 == 3.4028235E+38F) || (f4 == 1.4E-45F) || (f1 == 1.4E-45F)) {
        return null;
      }
      return new float[] { f5, f2, f4, f1 };
    }
    return null;
  }
  
  public native int deinit();
  
  public native float[] forward(Bitmap paramBitmap);
  
  public native float[] forwardWithBox(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public long getNativePtr()
  {
    return this.nativePtr;
  }
  
  public native int init(String paramString1, String paramString2, String paramString3);
  
  public void setNativePtr(long paramLong)
  {
    this.nativePtr = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.rapidnet.library.TNNGenderDetect
 * JD-Core Version:    0.7.0.1
 */