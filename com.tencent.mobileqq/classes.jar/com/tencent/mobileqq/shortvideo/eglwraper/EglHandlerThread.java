package com.tencent.mobileqq.shortvideo.eglwraper;

import android.annotation.TargetApi;
import android.opengl.EGLContext;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.sveffects.SLog;

@TargetApi(18)
public class EglHandlerThread
  extends HandlerThread
{
  private EGLContext jdField_a_of_type_AndroidOpenglEGLContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private EglCore jdField_a_of_type_ComTencentMobileqqShortvideoEglwraperEglCore;
  private EglSurfaceBase jdField_a_of_type_ComTencentMobileqqShortvideoEglwraperEglSurfaceBase;
  private boolean jdField_a_of_type_Boolean = false;
  
  public EglHandlerThread(String paramString, EGLContext paramEGLContext)
  {
    super(paramString);
    this.jdField_a_of_type_AndroidOpenglEGLContext = paramEGLContext;
  }
  
  private void a()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoEglwraperEglSurfaceBase != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoEglwraperEglSurfaceBase.a();
        this.jdField_a_of_type_ComTencentMobileqqShortvideoEglwraperEglSurfaceBase = null;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqShortvideoEglwraperEglCore == null);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoEglwraperEglCore.a();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoEglwraperEglCore = null;
  }
  
  public Handler a()
  {
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void onLooperPrepared()
  {
    super.onLooperPrepared();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(getLooper());
    this.jdField_a_of_type_ComTencentMobileqqShortvideoEglwraperEglCore = new EglCore(this.jdField_a_of_type_AndroidOpenglEGLContext, 1);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoEglwraperEglSurfaceBase = new EglSurfaceBase(this.jdField_a_of_type_ComTencentMobileqqShortvideoEglwraperEglCore);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoEglwraperEglSurfaceBase.a(64, 64);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoEglwraperEglSurfaceBase.b();
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Exception localException)
    {
      this.jdField_a_of_type_Boolean = false;
      SLog.a("EglHandlerThread", localException);
    }
  }
  
  public boolean quit()
  {
    boolean bool = super.quit();
    a();
    return bool;
  }
  
  public boolean quitSafely()
  {
    boolean bool = super.quitSafely();
    a();
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.eglwraper.EglHandlerThread
 * JD-Core Version:    0.7.0.1
 */