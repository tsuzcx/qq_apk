package com.tencent.mobileqq.richmedia.mediacodec.decoder.flow;

import ahab;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.EGLContext;
import android.opengl.Matrix;
import android.support.annotation.NonNull;
import android.view.Surface;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EglCore;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EglSurfaceBase;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.TextureRender;

public final class FlowDecodeOffScreenSurface
  implements SurfaceTexture.OnFrameAvailableListener, FlowDecodeSurface
{
  private int jdField_a_of_type_Int;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private FrameBuffer jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFrameBuffer;
  private EglCore jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglCore;
  private EglSurfaceBase jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglSurfaceBase;
  private TextureRender jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private int b;
  private int c;
  
  FlowDecodeOffScreenSurface(EGLContext paramEGLContext, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglCore = new EglCore(paramEGLContext, 1);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglSurfaceBase = new EglSurfaceBase(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglCore);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglSurfaceBase.a(paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglSurfaceBase.b();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender = new TextureRender();
    this.c = GlUtil.a(36197);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.c);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
    this.jdField_a_of_type_AndroidViewSurface = new Surface(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFrameBuffer = new FrameBuffer(this.jdField_a_of_type_Int, this.b);
    Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
  }
  
  public Surface a()
  {
    return this.jdField_a_of_type_AndroidViewSurface;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglCore != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglCore.a();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglCore = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglSurfaceBase != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglSurfaceBase.a();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglSurfaceBase = null;
    }
    this.jdField_a_of_type_AndroidViewSurface.release();
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.release();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFrameBuffer.b();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFrameBuffer = null;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender = null;
    this.jdField_a_of_type_AndroidViewSurface = null;
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
  }
  
  public void a(@NonNull ahab paramahab, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(this.jdField_a_of_type_ArrayOfFloat);
    paramahab.jdField_a_of_type_ArrayOfFloat = ((float[])this.jdField_a_of_type_ArrayOfFloat.clone());
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFrameBuffer.a(paramahab.a());
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender.a(36197, this.c, null, null);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFrameBuffer.a();
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      for (;;)
      {
        boolean bool = this.jdField_a_of_type_Boolean;
        if (!bool) {
          try
          {
            this.jdField_a_of_type_JavaLangObject.wait();
            if (!this.jdField_a_of_type_Boolean) {
              throw new RuntimeException("frame wait timed out");
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            throw new RuntimeException(localInterruptedException);
          }
        }
      }
    }
    this.jdField_a_of_type_Boolean = false;
    GlUtil.a("before updateTexImage");
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.updateTexImage();
  }
  
  public void onFrameAvailable(SurfaceTexture arg1)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Boolean) {
        throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
      }
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangObject.notifyAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.FlowDecodeOffScreenSurface
 * JD-Core Version:    0.7.0.1
 */