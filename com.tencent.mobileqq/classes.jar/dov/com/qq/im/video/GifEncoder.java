package dov.com.qq.im.video;

import android.graphics.Bitmap;
import bkoq;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;

public class GifEncoder
{
  private static int jdField_a_of_type_Int;
  private static int b;
  private static int c;
  private static final int d;
  private long jdField_a_of_type_Long;
  private int e = Math.max(2, Math.min(d - 1, 4));
  private int f;
  private int g;
  
  static
  {
    try
    {
      bkoq.a();
      System.load(new File(FeatureManager.getSoDir(), "libgiftools.so").getPath());
      jdField_a_of_type_Int = 1;
      b = 2;
      c = 3;
      d = Runtime.getRuntime().availableProcessors();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("GifEncoder", 4, "load libgiftools.so fail, msg = " + localException.getMessage());
      }
    }
  }
  
  private native void nativeClose(long paramLong);
  
  private native boolean nativeEncodeFrame(long paramLong, Bitmap paramBitmap, int paramInt);
  
  private native long nativeInit(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4);
  
  private native void nativeSetDither(long paramLong, boolean paramBoolean);
  
  private native void nativeSetThreadCount(long paramLong, int paramInt);
  
  public void a()
  {
    nativeClose(this.jdField_a_of_type_Long);
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    a(paramInt1, paramInt2, paramString, jdField_a_of_type_Int);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if (0L != this.jdField_a_of_type_Long) {
      a();
    }
    this.f = paramInt1;
    this.g = paramInt2;
    QLog.d("GifEncoder", 4, new Object[] { "GifEncoder init, with = ", Integer.valueOf(paramInt1), ", height = ", Integer.valueOf(paramInt2), ", path = ", paramString, ", encodingType = ", Integer.valueOf(paramInt3), ", threadCount = ", Integer.valueOf(this.e) });
    this.jdField_a_of_type_Long = nativeInit(paramInt1, paramInt2, paramString, paramInt3, this.e);
    if (0L == this.jdField_a_of_type_Long) {
      throw new FileNotFoundException();
    }
  }
  
  public boolean a(Bitmap paramBitmap, int paramInt)
  {
    if (0L == this.jdField_a_of_type_Long) {
      return false;
    }
    if ((paramBitmap.getWidth() != this.f) || (paramBitmap.getHeight() != this.g)) {
      throw new RuntimeException(String.format(Locale.ENGLISH, "The size specified at initialization differs from the size of the image.\n expected:(%d, %d) actual:(%d,%d)", new Object[] { Integer.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) }));
    }
    nativeEncodeFrame(this.jdField_a_of_type_Long, paramBitmap, paramInt);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.video.GifEncoder
 * JD-Core Version:    0.7.0.1
 */