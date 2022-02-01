package dov.com.qq.im.video;

import android.graphics.Bitmap;
import com.tencent.aelight.camera.download.api.IAEKitForQQ;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;

public class GifEncoder
{
  private static int jdField_a_of_type_Int = 0;
  private static int b = 1;
  private static int c = 2;
  private static int d = 3;
  private static final int e = Runtime.getRuntime().availableProcessors();
  private long jdField_a_of_type_Long = 0L;
  private int f = Math.max(2, Math.min(e - 1, 4));
  private int g;
  private int h;
  
  static
  {
    try
    {
      ((IAEKitForQQ)QRoute.api(IAEKitForQQ.class)).init();
      System.load(new File(FeatureManager.getSoDir(), "libgiftools.so").getPath());
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("load libgiftools.so fail, msg = ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("GifEncoder", 4, localStringBuilder.toString());
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
    if (0L != this.jdField_a_of_type_Long) {
      return;
    }
    throw new FileNotFoundException();
  }
  
  public void a(boolean paramBoolean)
  {
    long l = this.jdField_a_of_type_Long;
    if (0L == l) {
      return;
    }
    nativeSetDither(l, paramBoolean);
  }
  
  public boolean a(Bitmap paramBitmap, int paramInt)
  {
    if (0L == this.jdField_a_of_type_Long) {
      return false;
    }
    if ((paramBitmap.getWidth() == this.g) && (paramBitmap.getHeight() == this.h))
    {
      nativeEncodeFrame(this.jdField_a_of_type_Long, paramBitmap, paramInt);
      return true;
    }
    throw new RuntimeException(String.format(Locale.ENGLISH, "The size specified at initialization differs from the size of the image.\n expected:(%d, %d) actual:(%d,%d)", new Object[] { Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.video.GifEncoder
 * JD-Core Version:    0.7.0.1
 */