package com.tencent.mobileqq.qassistant.wake.aicore;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import bakl;
import bakt;
import balw;
import band;
import baob;
import baoc;
import baod;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EglHandlerThread;
import java.io.File;

public class QQWakeAIEngine
  implements Handler.Callback
{
  public static volatile long a;
  public static volatile boolean a;
  public static boolean b;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private baob jdField_a_of_type_Baob;
  private baoc jdField_a_of_type_Baoc;
  baod jdField_a_of_type_Baod;
  private EglHandlerThread jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private Handler b;
  private boolean c;
  
  static
  {
    jdField_b_of_type_Boolean = true;
  }
  
  public QQWakeAIEngine(baob parambaob)
  {
    a();
    this.jdField_a_of_type_Baob = parambaob;
    if (this.jdField_a_of_type_Baob.jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      this.c = bool;
      if (balw.a()) {
        this.jdField_a_of_type_Baod = new baod();
      }
      return;
      bool = false;
    }
  }
  
  public static void a()
  {
    try
    {
      if ((band.a()) && (!jdField_a_of_type_Boolean))
      {
        String str = bakt.a("wake", band.a()) + "/" + "libHelloQQ.so";
        if (new File(str).exists())
        {
          bakl.a("HelloQQWake", "loadSo file exists: " + str);
          System.load(str);
          jdField_a_of_type_Boolean = true;
          return;
        }
        bakl.a("HelloQQWake", "loadSo file not exists: " + str);
        return;
      }
    }
    catch (Exception localException)
    {
      bakl.a("HelloQQWake", "loadSo() error: " + localException.getMessage());
      jdField_b_of_type_Boolean = false;
    }
  }
  
  private void b(short[] paramArrayOfShort, int paramInt)
  {
    Float localFloat = Float.valueOf(0.0F);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      bakl.a("HelloQQWake", "doProcess mLock");
      if (jdField_a_of_type_Long != 0L) {
        localFloat = Float.valueOf(HelloQQDetect(jdField_a_of_type_Long, paramArrayOfShort, paramInt));
      }
      ??? = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(200, localFloat);
      this.jdField_b_of_type_AndroidOsHandler.sendMessage((Message)???);
      if (balw.a())
      {
        this.jdField_a_of_type_Baod.a(paramArrayOfShort);
        if (localFloat.floatValue() > 0.5D) {
          this.jdField_a_of_type_Baod.a(localFloat.floatValue());
        }
      }
      return;
    }
  }
  
  private void d()
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_Long == 0L)
        {
          jdField_a_of_type_Long = HelloQQInit(this.jdField_a_of_type_Baob.jdField_a_of_type_Int, this.jdField_a_of_type_Baob.jdField_b_of_type_Int, this.jdField_a_of_type_Baob.jdField_c_of_type_Int, this.jdField_a_of_type_Baob.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Baob.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Baob.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Baob.d, this.jdField_a_of_type_Baob.e);
          bakl.a("HelloQQWake", "QQWakeAIEngine mNativeObj  after：" + jdField_a_of_type_Long);
          if (this.jdField_a_of_type_Baoc != null)
          {
            baoc localbaoc = this.jdField_a_of_type_Baoc;
            if (jdField_a_of_type_Long == 0L) {
              break label141;
            }
            bool = true;
            localbaoc.a(bool);
          }
        }
        return;
      }
      label141:
      boolean bool = false;
    }
  }
  
  private void e()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Long != 0L)
      {
        HelloQQDestroy(jdField_a_of_type_Long);
        bakl.a("HelloQQWake", "native doDestroy  done:" + jdField_a_of_type_Long);
        jdField_a_of_type_Long = 0L;
      }
      return;
    }
  }
  
  private void f()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Long != 0L)
      {
        HelloQQClear(jdField_a_of_type_Long);
        bakl.a("HelloQQWake", "native  HelloQQClear done");
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
      }
      return;
    }
  }
  
  public native void HelloQQClear(long paramLong);
  
  public native void HelloQQDestroy(long paramLong);
  
  public native float HelloQQDetect(long paramLong, short[] paramArrayOfShort, int paramInt);
  
  public native long HelloQQInit(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  public void a(Looper paramLooper)
  {
    if (this.jdField_b_of_type_AndroidOsHandler == null)
    {
      if (paramLooper != null) {
        this.jdField_b_of_type_AndroidOsHandler = new Handler(paramLooper, this);
      }
    }
    else
    {
      if (!this.c) {
        break label118;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread = new EglHandlerThread("QQWAKE_EGL_THREAD", null);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread.start();
      }
      paramLooper = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread.getLooper();
      if (paramLooper == null) {
        break label110;
      }
      if (this.jdField_a_of_type_AndroidOsHandler == null) {
        this.jdField_a_of_type_AndroidOsHandler = new Handler(paramLooper, this);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(100);
      return;
    }
    bakl.a("HelloQQWake", "QQWakeAIEngine init initEnv exception: uiLooper=null");
    return;
    label110:
    bakl.a("HelloQQWake", "QQWakeAIEngine init eglHandler exception: looper=null");
    return;
    label118:
    d();
  }
  
  public void a(baoc parambaoc)
  {
    this.jdField_a_of_type_Baoc = parambaoc;
  }
  
  public void a(short[] paramArrayOfShort, int paramInt)
  {
    if (!this.c) {
      b(paramArrayOfShort, paramInt);
    }
    while (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(101);
    localMessage.arg1 = paramInt;
    localMessage.obj = paramArrayOfShort;
    localMessage.sendToTarget();
  }
  
  public void b()
  {
    bakl.a("HelloQQWake", "destroy()");
    if (!this.c) {
      e();
    }
    while (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(102);
  }
  
  public void c()
  {
    if (!this.c) {
      f();
    }
    while (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(103);
  }
  
  public native int getRunType();
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      bakl.a("HelloQQWake", "QQWakeAIEngine MSG_EGL_INIT");
      d();
      continue;
      b((short[])paramMessage.obj, paramMessage.arg1);
      continue;
      bakl.a("HelloQQWake", "QQWakeAIEngine MSG_EGL_DESTROY");
      e();
      try
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread.quitSafely();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread = null;
        this.jdField_a_of_type_AndroidOsHandler = null;
      }
      catch (Exception paramMessage)
      {
        paramMessage.printStackTrace();
      }
      continue;
      bakl.a("HelloQQWake", "QQWakeAIEngine  MSG_EGL_CLEAR");
      f();
      continue;
      float f = 0.0F;
      if ((paramMessage.obj instanceof Float)) {
        f = ((Float)paramMessage.obj).floatValue();
      }
      if (this.jdField_a_of_type_Baoc != null) {
        this.jdField_a_of_type_Baoc.a(f);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.aicore.QQWakeAIEngine
 * JD-Core Version:    0.7.0.1
 */