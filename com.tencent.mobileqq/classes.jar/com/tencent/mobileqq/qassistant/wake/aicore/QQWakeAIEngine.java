package com.tencent.mobileqq.qassistant.wake.aicore;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import azeu;
import azfc;
import azgf;
import azgv;
import azht;
import azhu;
import azhv;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EglHandlerThread;
import java.io.File;

public class QQWakeAIEngine
  implements Handler.Callback
{
  public static volatile long a;
  public static volatile boolean a;
  public static boolean b;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private azht jdField_a_of_type_Azht;
  private azhu jdField_a_of_type_Azhu;
  azhv jdField_a_of_type_Azhv;
  private EglHandlerThread jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private Handler b;
  private boolean c;
  
  static
  {
    jdField_b_of_type_Boolean = true;
  }
  
  public QQWakeAIEngine(azht paramazht)
  {
    a();
    this.jdField_a_of_type_Azht = paramazht;
    if (this.jdField_a_of_type_Azht.jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      this.c = bool;
      if (azgf.a()) {
        this.jdField_a_of_type_Azhv = new azhv();
      }
      return;
      bool = false;
    }
  }
  
  public static void a()
  {
    try
    {
      if ((azgv.a()) && (!jdField_a_of_type_Boolean))
      {
        String str = azfc.a("wake", azgv.a()) + "/" + "libHelloQQ.so";
        if (new File(str).exists())
        {
          azeu.a("HelloQQWake", "loadSo file exists: " + str);
          System.load(str);
          jdField_a_of_type_Boolean = true;
          return;
        }
        azeu.a("HelloQQWake", "loadSo file not exists: " + str);
        return;
      }
    }
    catch (Exception localException)
    {
      azeu.a("HelloQQWake", "loadSo() error: " + localException.getMessage());
      jdField_b_of_type_Boolean = false;
    }
  }
  
  private void b(short[] paramArrayOfShort, int paramInt)
  {
    Float localFloat = Float.valueOf(0.0F);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      azeu.a("HelloQQWake", "doProcess mLock");
      if (jdField_a_of_type_Long != 0L) {
        localFloat = Float.valueOf(HelloQQDetect(jdField_a_of_type_Long, paramArrayOfShort, paramInt));
      }
      ??? = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(200, localFloat);
      this.jdField_b_of_type_AndroidOsHandler.sendMessage((Message)???);
      if (azgf.a())
      {
        this.jdField_a_of_type_Azhv.a(paramArrayOfShort);
        if (localFloat.floatValue() > 0.5D) {
          this.jdField_a_of_type_Azhv.a(localFloat.floatValue());
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
          jdField_a_of_type_Long = HelloQQInit(this.jdField_a_of_type_Azht.jdField_a_of_type_Int, this.jdField_a_of_type_Azht.jdField_b_of_type_Int, this.jdField_a_of_type_Azht.jdField_c_of_type_Int, this.jdField_a_of_type_Azht.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Azht.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Azht.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Azht.d, this.jdField_a_of_type_Azht.e);
          azeu.a("HelloQQWake", "QQWakeAIEngine mNativeObj  after：" + jdField_a_of_type_Long);
          if (this.jdField_a_of_type_Azhu != null)
          {
            azhu localazhu = this.jdField_a_of_type_Azhu;
            if (jdField_a_of_type_Long == 0L) {
              break label141;
            }
            bool = true;
            localazhu.a(bool);
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
        azeu.a("HelloQQWake", "native doDestroy  done:" + jdField_a_of_type_Long);
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
        azeu.a("HelloQQWake", "native  HelloQQClear done");
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
    azeu.a("HelloQQWake", "QQWakeAIEngine init initEnv exception: uiLooper=null");
    return;
    label110:
    azeu.a("HelloQQWake", "QQWakeAIEngine init eglHandler exception: looper=null");
    return;
    label118:
    d();
  }
  
  public void a(azhu paramazhu)
  {
    this.jdField_a_of_type_Azhu = paramazhu;
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
    azeu.a("HelloQQWake", "destroy()");
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
      azeu.a("HelloQQWake", "QQWakeAIEngine MSG_EGL_INIT");
      d();
      continue;
      b((short[])paramMessage.obj, paramMessage.arg1);
      continue;
      azeu.a("HelloQQWake", "QQWakeAIEngine MSG_EGL_DESTROY");
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
      azeu.a("HelloQQWake", "QQWakeAIEngine  MSG_EGL_CLEAR");
      f();
      continue;
      float f = 0.0F;
      if ((paramMessage.obj instanceof Float)) {
        f = ((Float)paramMessage.obj).floatValue();
      }
      if (this.jdField_a_of_type_Azhu != null) {
        this.jdField_a_of_type_Azhu.a(f);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.aicore.QQWakeAIEngine
 * JD-Core Version:    0.7.0.1
 */