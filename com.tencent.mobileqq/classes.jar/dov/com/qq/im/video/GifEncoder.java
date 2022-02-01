package dov.com.qq.im.video;

import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import dov.com.qq.im.ae.AEKitForQQ;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;

public class GifEncoder
{
  private static int jdField_a_of_type_Int;
  private static int b;
  private static int c;
  private static int d;
  private static final int e;
  private long jdField_a_of_type_Long = 0L;
  private int f = Math.max(2, Math.min(e - 1, 4));
  private int g;
  private int h;
  
  static
  {
    try
    {
      AEKitForQQ.a();
      System.load(new File(FeatureManager.getSoDir(), "libgiftools.so").getPath());
      jdField_a_of_type_Int = 0;
      b = 1;
      c = 2;
      d = 3;
      e = Runtime.getRuntime().availableProcessors();
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
    a(paramInt1, paramInt2, paramString, b);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if (0L != this.jdField_a_of_type_Long) {
      a();
    }
    this.g = paramInt1;
    this.h = paramInt2;
    QLog.d("GifEncoder", 4, new Object[] { "GifEncoder init, with = ", Integer.valueOf(paramInt1), ", height = ", Integer.valueOf(paramInt2), ", path = ", paramString, ", encodingType = ", Integer.valueOf(paramInt3), ", threadCount = ", Integer.valueOf(this.f) });
    this.jdField_a_of_type_Long = nativeInit(paramInt1, paramInt2, paramString, paramInt3, this.f);
    if (0L == this.jdField_a_of_type_Long) {
      throw new FileNotFoundException();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (0L == this.jdField_a_of_type_Long) {
      return;
    }
    nativeSetDither(this.jdField_a_of_type_Long, paramBoolean);
  }
  
  public boolean a(Bitmap paramBitmap, int paramInt)
  {
    if (0L == this.jdField_a_of_type_Long) {
      return false;
    }
    if ((paramBitmap.getWidth() != this.g) || (paramBitmap.getHeight() != this.h)) {
      throw new RuntimeException(String.format(Locale.ENGLISH, "The size specified at initialization differs from the size of the image.\n expected:(%d, %d) actual:(%d,%d)", new Object[] { Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) }));
    }
    nativeEncodeFrame(this.jdField_a_of_type_Long, paramBitmap, paramInt);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.qq.im.video.GifEncoder
 * JD-Core Version:    0.7.0.1
 */