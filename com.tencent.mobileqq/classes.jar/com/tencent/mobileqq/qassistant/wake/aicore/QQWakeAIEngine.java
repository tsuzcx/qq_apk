package com.tencent.mobileqq.qassistant.wake.aicore;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.qassistant.core.LoadManager;
import com.tencent.mobileqq.qassistant.setting.QassistantConfig;
import com.tencent.mobileqq.qassistant.wake.HelloQQHelper;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EglHandlerThread;
import java.io.File;

public class QQWakeAIEngine
  implements Handler.Callback
{
  public static volatile long a = 0L;
  public static volatile boolean a = false;
  public static boolean b = true;
  private Handler jdField_a_of_type_AndroidOsHandler = null;
  private AIModelParam jdField_a_of_type_ComTencentMobileqqQassistantWakeAicoreAIModelParam;
  private QQWakeUICallback jdField_a_of_type_ComTencentMobileqqQassistantWakeAicoreQQWakeUICallback;
  WakeDataSaveHelper jdField_a_of_type_ComTencentMobileqqQassistantWakeAicoreWakeDataSaveHelper;
  private EglHandlerThread jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglHandlerThread;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private Handler b;
  private boolean c;
  
  public QQWakeAIEngine(AIModelParam paramAIModelParam)
  {
    this.jdField_b_of_type_AndroidOsHandler = null;
    a();
    this.jdField_a_of_type_ComTencentMobileqqQassistantWakeAicoreAIModelParam = paramAIModelParam;
    int i = this.jdField_a_of_type_ComTencentMobileqqQassistantWakeAicoreAIModelParam.jdField_a_of_type_Int;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    this.c = bool;
    if (QassistantConfig.a()) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantWakeAicoreWakeDataSaveHelper = new WakeDataSaveHelper();
    }
  }
  
  public static void a()
  {
    try
    {
      if ((HelloQQHelper.a()) && (!jdField_a_of_type_Boolean))
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(LoadManager.a("wake", HelloQQHelper.a()));
        ((StringBuilder)localObject).append("/");
        ((StringBuilder)localObject).append("libHelloQQ.so");
        localObject = ((StringBuilder)localObject).toString();
        if (new File((String)localObject).exists())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("loadSo file exists: ");
          localStringBuilder.append((String)localObject);
          AssistantUtils.a("HelloQQWake", localStringBuilder.toString());
          System.load((String)localObject);
          jdField_a_of_type_Boolean = true;
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("loadSo file not exists: ");
        localStringBuilder.append((String)localObject);
        AssistantUtils.a("HelloQQWake", localStringBuilder.toString());
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadSo() error: ");
      localStringBuilder.append(localException.getMessage());
      AssistantUtils.a("HelloQQWake", localStringBuilder.toString());
      jdField_b_of_type_Boolean = false;
    }
  }
  
  private void b(short[] paramArrayOfShort, int paramInt)
  {
    Float localFloat = Float.valueOf(0.0F);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      AssistantUtils.a("HelloQQWake", "doProcess mLock");
      if (jdField_a_of_type_Long != 0L) {
        localFloat = Float.valueOf(HelloQQDetect(jdField_a_of_type_Long, paramArrayOfShort, paramInt));
      }
      ??? = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(200, localFloat);
      this.jdField_b_of_type_AndroidOsHandler.sendMessage((Message)???);
      if (QassistantConfig.a())
      {
        this.jdField_a_of_type_ComTencentMobileqqQassistantWakeAicoreWakeDataSaveHelper.a(paramArrayOfShort);
        if (localFloat.floatValue() > 0.5D) {
          this.jdField_a_of_type_ComTencentMobileqqQassistantWakeAicoreWakeDataSaveHelper.a(localFloat.floatValue());
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
          jdField_a_of_type_Long = HelloQQInit(this.jdField_a_of_type_ComTencentMobileqqQassistantWakeAicoreAIModelParam.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqQassistantWakeAicoreAIModelParam.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqQassistantWakeAicoreAIModelParam.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqQassistantWakeAicoreAIModelParam.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqQassistantWakeAicoreAIModelParam.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqQassistantWakeAicoreAIModelParam.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqQassistantWakeAicoreAIModelParam.d, this.jdField_a_of_type_ComTencentMobileqqQassistantWakeAicoreAIModelParam.e);
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("QQWakeAIEngine mNativeObj  after：");
          ((StringBuilder)localObject2).append(jdField_a_of_type_Long);
          AssistantUtils.a("HelloQQWake", ((StringBuilder)localObject2).toString());
          if (this.jdField_a_of_type_ComTencentMobileqqQassistantWakeAicoreQQWakeUICallback != null)
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqQassistantWakeAicoreQQWakeUICallback;
            if (jdField_a_of_type_Long == 0L) {
              break label150;
            }
            bool = true;
            ((QQWakeUICallback)localObject2).a(bool);
          }
        }
        return;
      }
      label150:
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("native doDestroy  done:");
        localStringBuilder.append(jdField_a_of_type_Long);
        AssistantUtils.a("HelloQQWake", localStringBuilder.toString());
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
        AssistantUtils.a("HelloQQWake", "native  HelloQQClear done");
      }
      ??? = this.jdField_a_of_type_AndroidOsHandler;
      if (??? != null) {
        ((Handler)???).removeMessages(101);
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
    if (this.jdField_b_of_type_AndroidOsHandler == null) {
      if (paramLooper != null)
      {
        this.jdField_b_of_type_AndroidOsHandler = new Handler(paramLooper, this);
      }
      else
      {
        AssistantUtils.a("HelloQQWake", "QQWakeAIEngine init initEnv exception: uiLooper=null");
        return;
      }
    }
    if (this.c)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglHandlerThread == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglHandlerThread = new EglHandlerThread("QQWAKE_EGL_THREAD", null);
        this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglHandlerThread.start();
      }
      paramLooper = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglHandlerThread.getLooper();
      if (paramLooper != null)
      {
        if (this.jdField_a_of_type_AndroidOsHandler == null) {
          this.jdField_a_of_type_AndroidOsHandler = new Handler(paramLooper, this);
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(100);
        return;
      }
      AssistantUtils.a("HelloQQWake", "QQWakeAIEngine init eglHandler exception: looper=null");
      return;
    }
    d();
  }
  
  public void a(QQWakeUICallback paramQQWakeUICallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqQassistantWakeAicoreQQWakeUICallback = paramQQWakeUICallback;
  }
  
  public void a(short[] paramArrayOfShort, int paramInt)
  {
    if (!this.c)
    {
      b(paramArrayOfShort, paramInt);
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      localObject = ((Handler)localObject).obtainMessage(101);
      ((Message)localObject).arg1 = paramInt;
      ((Message)localObject).obj = paramArrayOfShort;
      ((Message)localObject).sendToTarget();
    }
  }
  
  public void b()
  {
    AssistantUtils.a("HelloQQWake", "destroy()");
    if (!this.c)
    {
      e();
      return;
    }
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.sendEmptyMessage(102);
    }
  }
  
  public void c()
  {
    if (!this.c)
    {
      f();
      return;
    }
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.sendEmptyMessage(103);
    }
  }
  
  public native int getRunType();
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 200)
    {
      switch (i)
      {
      default: 
        break;
      case 103: 
        AssistantUtils.a("HelloQQWake", "QQWakeAIEngine  MSG_EGL_CLEAR");
        f();
        break;
      case 102: 
        AssistantUtils.a("HelloQQWake", "QQWakeAIEngine MSG_EGL_DESTROY");
        e();
        try
        {
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
          this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglHandlerThread.quitSafely();
          this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglHandlerThread = null;
          this.jdField_a_of_type_AndroidOsHandler = null;
        }
        catch (Exception paramMessage)
        {
          paramMessage.printStackTrace();
        }
      case 101: 
        b((short[])paramMessage.obj, paramMessage.arg1);
        break;
      case 100: 
        AssistantUtils.a("HelloQQWake", "QQWakeAIEngine MSG_EGL_INIT");
        d();
        break;
      }
    }
    else
    {
      float f = 0.0F;
      if ((paramMessage.obj instanceof Float)) {
        f = ((Float)paramMessage.obj).floatValue();
      }
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqQassistantWakeAicoreQQWakeUICallback;
      if (paramMessage != null) {
        paramMessage.a(f);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.aicore.QQWakeAIEngine
 * JD-Core Version:    0.7.0.1
 */