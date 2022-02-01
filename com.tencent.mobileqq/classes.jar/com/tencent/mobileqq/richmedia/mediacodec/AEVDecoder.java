package com.tencent.mobileqq.richmedia.mediacodec;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.mobileqq.videocodec.mediacodec.decoder.DecodeConfig;
import com.tencent.mobileqq.videocodec.mediacodec.decoder.HWDecodeListener;
import com.tencent.mobileqq.videocodec.mediacodec.decoder.HWVideoDecoder;
import com.tencent.ttpic.video.AEDecoder;

public class AEVDecoder
  implements SurfaceTexture.OnFrameAvailableListener, HWDecodeListener, AEDecoder
{
  private final int jdField_a_of_type_Int = 1;
  private Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  private SurfaceTextureFilter jdField_a_of_type_ComTencentFilterSurfaceTextureFilter;
  private DecodeConfig jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig;
  private HWVideoDecoder jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderHWVideoDecoder = new HWVideoDecoder();
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private final int b = 2;
  private final int c = 3;
  private final int d = 4;
  private final int e = 5;
  private final int f = 6;
  private int g = 1;
  private int h = -1;
  private int i = -1;
  private int j;
  private int k;
  
  public AEVDecoder(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig = new DecodeConfig(paramString, 0, false, false);
  }
  
  private void e()
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    this.k = arrayOfInt[0];
    this.jdField_a_of_type_ComTencentFilterSurfaceTextureFilter = new SurfaceTextureFilter();
    this.jdField_a_of_type_ComTencentFilterSurfaceTextureFilter.apply();
  }
  
  private void f()
  {
    GLES20.glDeleteTextures(1, new int[] { this.k }, 0);
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
    this.jdField_a_of_type_ComTencentFilterSurfaceTextureFilter.clearGLSLSelf();
  }
  
  public void a() {}
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    this.g = 6;
    this.jdField_a_of_type_JavaLangObject.notifyAll();
  }
  
  public void a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      while (this.g != 2) {
        this.jdField_a_of_type_JavaLangObject.wait();
      }
      this.g = 3;
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void b()
  {
    this.g = 5;
    this.jdField_a_of_type_JavaLangObject.notifyAll();
  }
  
  public void b(long paramLong) {}
  
  public void c() {}
  
  public void d() {}
  
  public int getNextFrameTexture()
  {
    try
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        while ((this.g != 4) && (this.g != 5) && (this.g != 6)) {
          this.jdField_a_of_type_JavaLangObject.wait();
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      label52:
      break label52;
    }
    if (this.g == 4)
    {
      if ((this.h == -1) || (this.i == -1))
      {
        this.h = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderHWVideoDecoder.a();
        this.i = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderHWVideoDecoder.b();
      }
      this.jdField_a_of_type_ComTencentFilterSurfaceTextureFilter.updateMatrix(this.jdField_a_of_type_ArrayOfFloat);
      this.jdField_a_of_type_ComTencentFilterSurfaceTextureFilter.RenderProcess(this.k, this.h, this.i, this.j, 0.0D, this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame);
      this.g = 2;
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      return 0;
    }
    return -1;
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    paramSurfaceTexture.updateTexImage();
    paramSurfaceTexture.getTransformMatrix(this.jdField_a_of_type_ArrayOfFloat);
    this.g = 4;
    this.jdField_a_of_type_JavaLangObject.notifyAll();
  }
  
  public void release()
  {
    f();
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderHWVideoDecoder.a();
  }
  
  public void setTexture(int paramInt)
  {
    e();
    this.j = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderHWVideoDecoder.a(this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig, this.k, this, this);
    this.g = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.AEVDecoder
 * JD-Core Version:    0.7.0.1
 */