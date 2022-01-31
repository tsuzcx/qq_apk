package dov.com.tencent.mobileqq.richmedia.mediacodec.renderer;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.Surface;
import aonh;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EglCore;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EglSurfaceBase;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.mediacodec.tracker.SimpleStickerTrackerOrigin;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class GPUVideoFrameRender
  implements SurfaceTexture.OnFrameAvailableListener
{
  private static String jdField_a_of_type_JavaLangString = "SimpleStickerTrackerOrigin";
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private aonh jdField_a_of_type_Aonh;
  private EglCore jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglCore;
  private EglSurfaceBase jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglSurfaceBase;
  private SimpleStickerTrackerOrigin jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerSimpleStickerTrackerOrigin;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ByteBuffer jdField_a_of_type_JavaNioByteBuffer;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = -1L;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private Object jdField_c_of_type_JavaLangObject = new Object();
  
  public GPUVideoFrameRender(SimpleStickerTrackerOrigin paramSimpleStickerTrackerOrigin)
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerSimpleStickerTrackerOrigin = paramSimpleStickerTrackerOrigin;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Aonh = new aonh();
    this.jdField_a_of_type_Aonh.a();
    this.jdField_a_of_type_Aonh.a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.jdField_a_of_type_Aonh.a());
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
    this.jdField_a_of_type_AndroidViewSurface = new Surface(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
    this.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocateDirect(this.jdField_b_of_type_Int * this.jdField_c_of_type_Int * 4);
    this.jdField_a_of_type_JavaNioByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglSurfaceBase = new EglSurfaceBase(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglCore);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglSurfaceBase.a(paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglSurfaceBase.b();
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
  }
  
  public Surface a()
  {
    return this.jdField_a_of_type_AndroidViewSurface;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Long = -1L;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglSurfaceBase != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglSurfaceBase.a();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglSurfaceBase = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglCore != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglCore.a();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglCore = null;
    }
    if (this.jdField_a_of_type_AndroidViewSurface != null) {
      this.jdField_a_of_type_AndroidViewSurface.release();
    }
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglCore = new EglCore(EGL14.EGL_NO_CONTEXT, 1);
    }
    b(paramInt1, paramInt2);
    b();
  }
  
  public void a(long paramLong)
  {
    Log.d(jdField_a_of_type_JavaLangString, "awaitNewFrame 0, thread id=" + Thread.currentThread().getId());
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Long = paramLong;
      synchronized (this.jdField_c_of_type_JavaLangObject)
      {
        this.jdField_c_of_type_JavaLangObject.notifyAll();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onDecodeFrame start timestamp = " + paramLong);
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    int i = GLES20.glGetError();
    if (i != 0)
    {
      Log.e(jdField_a_of_type_JavaLangString, paramString + ": glError " + i);
      throw new RuntimeException(paramString + ": glError " + i);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public byte[] a()
  {
    if ((this.jdField_a_of_type_JavaNioByteBuffer == null) || (!this.jdField_a_of_type_JavaNioByteBuffer.hasArray())) {
      return null;
    }
    this.jdField_a_of_type_JavaNioByteBuffer.rewind();
    GLES20.glReadPixels(0, 0, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, 6408, 5121, this.jdField_a_of_type_JavaNioByteBuffer);
    byte[] arrayOfByte = this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerSimpleStickerTrackerOrigin.a(this.jdField_a_of_type_JavaNioByteBuffer.array().length);
    System.arraycopy(this.jdField_a_of_type_JavaNioByteBuffer.array(), 0, arrayOfByte, 0, this.jdField_a_of_type_JavaNioByteBuffer.array().length);
    return arrayOfByte;
  }
  
  public void b(boolean paramBoolean)
  {
    Log.d(jdField_a_of_type_JavaLangString, "drawImage");
    this.jdField_a_of_type_Aonh.a(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture, paramBoolean);
  }
  
  public void onFrameAvailable(SurfaceTexture arg1)
  {
    Log.i(jdField_a_of_type_JavaLangString, "new frame available, thread id=" + Thread.currentThread().getId());
    if (this.jdField_b_of_type_Long >= this.jdField_a_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onFrameAvailable wait onDecodeFrame. mLastAvailableTimestamp = " + this.jdField_b_of_type_Long + " , mLastDecodeTimestamp " + this.jdField_a_of_type_Long);
      }
      try
      {
        synchronized (this.jdField_c_of_type_JavaLangObject)
        {
          this.jdField_c_of_type_JavaLangObject.wait(5L);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_b_of_type_JavaLangObject.notifyAll();
        QLog.w(jdField_a_of_type_JavaLangString, 2, "onFrameAvailable error= ; isStoped=" + this.jdField_a_of_type_Boolean);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onFrameAvailable start");
      }
      if (this.jdField_b_of_type_Boolean) {
        new RuntimeException("mFrameAvailable already set, frame could be dropped");
      }
      this.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      this.jdField_b_of_type_Boolean = true;
      this.jdField_b_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUVideoFrameRender
 * JD-Core Version:    0.7.0.1
 */