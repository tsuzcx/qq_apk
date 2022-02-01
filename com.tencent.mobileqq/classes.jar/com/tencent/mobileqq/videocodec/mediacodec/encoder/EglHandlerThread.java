package com.tencent.mobileqq.videocodec.mediacodec.encoder;

import android.annotation.TargetApi;
import android.opengl.EGLContext;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;

@TargetApi(18)
public class EglHandlerThread
  extends HandlerThread
{
  private EGLContext jdField_a_of_type_AndroidOpenglEGLContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private EglCore jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglCore;
  private EglSurfaceBase jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglSurfaceBase;
  private boolean jdField_a_of_type_Boolean = false;
  
  public EglHandlerThread(String paramString, EGLContext paramEGLContext)
  {
    super(paramString);
    this.jdField_a_of_type_AndroidOpenglEGLContext = paramEGLContext;
  }
  
  private void a()
  {
    if (getLooper().getThread() != Thread.currentThread())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("release should be called in origin thread ");
      ((StringBuilder)localObject).append(getThreadId());
      QLog.e("EglHandlerThread", 2, ((StringBuilder)localObject).toString());
      return;
    }
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglSurfaceBase;
    if (localObject != null)
    {
      ((EglSurfaceBase)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglSurfaceBase = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglCore;
    if (localObject != null)
    {
      ((EglCore)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglCore = null;
    }
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
    try
    {
      super.onLooperPrepared();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(getLooper());
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglCore = new EglCore(this.jdField_a_of_type_AndroidOpenglEGLContext, 1);
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglSurfaceBase = new EglSurfaceBase(this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglCore);
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglSurfaceBase.a(64, 64);
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglSurfaceBase.b();
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Exception localException)
    {
      this.jdField_a_of_type_Boolean = false;
      QLog.e("EglHandlerThread", 2, localException, new Object[0]);
    }
  }
  
  public boolean quit()
  {
    if (getLooper().getThread() != Thread.currentThread())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("quit should be called in origin thread ");
      localStringBuilder.append(getThreadId());
      QLog.e("EglHandlerThread", 2, localStringBuilder.toString());
      this.jdField_a_of_type_AndroidOsHandler.post(new EglHandlerThread.1(this));
      return false;
    }
    boolean bool = super.quit();
    a();
    return bool;
  }
  
  public boolean quitSafely()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new EglHandlerThread.2(this));
    return super.quitSafely();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.mediacodec.encoder.EglHandlerThread
 * JD-Core Version:    0.7.0.1
 */