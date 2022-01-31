package com.tencent.mobileqq.richmedia.mediacodec.encoder;

import android.annotation.TargetApi;
import android.opengl.EGLContext;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import auzd;
import auze;
import avan;
import com.tencent.qphone.base.util.QLog;

@TargetApi(18)
public class EglHandlerThread
  extends HandlerThread
{
  private EGLContext jdField_a_of_type_AndroidOpenglEGLContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private auzd jdField_a_of_type_Auzd;
  private auze jdField_a_of_type_Auze;
  private boolean jdField_a_of_type_Boolean;
  
  public EglHandlerThread(String paramString, EGLContext paramEGLContext)
  {
    super(paramString);
    this.jdField_a_of_type_AndroidOpenglEGLContext = paramEGLContext;
  }
  
  private void a()
  {
    if (getLooper().getThread() != Thread.currentThread()) {
      QLog.e("EglHandlerThread", 2, "release should be called in origin thread " + getThreadId());
    }
    do
    {
      do
      {
        return;
      } while (!this.jdField_a_of_type_Boolean);
      if (this.jdField_a_of_type_Auze != null)
      {
        this.jdField_a_of_type_Auze.a();
        this.jdField_a_of_type_Auze = null;
      }
    } while (this.jdField_a_of_type_Auzd == null);
    this.jdField_a_of_type_Auzd.a();
    this.jdField_a_of_type_Auzd = null;
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
      this.jdField_a_of_type_Auzd = new auzd(this.jdField_a_of_type_AndroidOpenglEGLContext, 1);
      this.jdField_a_of_type_Auze = new auze(this.jdField_a_of_type_Auzd);
      this.jdField_a_of_type_Auze.a(64, 64);
      this.jdField_a_of_type_Auze.b();
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Exception localException)
    {
      this.jdField_a_of_type_Boolean = false;
      QLog.e("EglHandlerThread", 2, localException, new Object[0]);
      avan.a(localException);
    }
  }
  
  public boolean quit()
  {
    if (getLooper().getThread() != Thread.currentThread())
    {
      QLog.e("EglHandlerThread", 2, "quit should be called in origin thread " + getThreadId());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.encoder.EglHandlerThread
 * JD-Core Version:    0.7.0.1
 */