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
  public static volatile boolean a = false;
  public static volatile long b = 0L;
  public static boolean c = true;
  WakeDataSaveHelper d;
  private boolean e;
  private EglHandlerThread f;
  private Handler g = null;
  private Handler h = null;
  private final Object i = new Object();
  private AIModelParam j;
  private QQWakeUICallback k;
  
  public QQWakeAIEngine(AIModelParam paramAIModelParam)
  {
    a();
    this.j = paramAIModelParam;
    int m = this.j.a;
    boolean bool = true;
    if (m != 1) {
      bool = false;
    }
    this.e = bool;
    if (QassistantConfig.a()) {
      this.d = new WakeDataSaveHelper();
    }
  }
  
  public static void a()
  {
    try
    {
      if ((HelloQQHelper.c()) && (!a))
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
          a = true;
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
      c = false;
    }
  }
  
  private void b(short[] paramArrayOfShort, int paramInt)
  {
    Float localFloat = Float.valueOf(0.0F);
    synchronized (this.i)
    {
      AssistantUtils.a("HelloQQWake", "doProcess mLock");
      if (b != 0L) {
        localFloat = Float.valueOf(HelloQQDetect(b, paramArrayOfShort, paramInt));
      }
      ??? = this.h.obtainMessage(200, localFloat);
      this.h.sendMessage((Message)???);
      if (QassistantConfig.a())
      {
        this.d.a(paramArrayOfShort);
        if (localFloat.floatValue() > 0.5D) {
          this.d.a(localFloat.floatValue());
        }
      }
      return;
    }
  }
  
  private void d()
  {
    for (;;)
    {
      synchronized (this.i)
      {
        if (b == 0L)
        {
          b = HelloQQInit(this.j.a, this.j.b, this.j.c, this.j.d, this.j.e, this.j.f, this.j.g, this.j.h);
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("QQWakeAIEngine mNativeObj  after：");
          ((StringBuilder)localObject2).append(b);
          AssistantUtils.a("HelloQQWake", ((StringBuilder)localObject2).toString());
          if (this.k != null)
          {
            localObject2 = this.k;
            if (b == 0L) {
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
    synchronized (this.i)
    {
      if (b != 0L)
      {
        HelloQQDestroy(b);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("native doDestroy  done:");
        localStringBuilder.append(b);
        AssistantUtils.a("HelloQQWake", localStringBuilder.toString());
        b = 0L;
      }
      return;
    }
  }
  
  private void f()
  {
    synchronized (this.i)
    {
      if (b != 0L)
      {
        HelloQQClear(b);
        AssistantUtils.a("HelloQQWake", "native  HelloQQClear done");
      }
      ??? = this.g;
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
    if (this.h == null) {
      if (paramLooper != null)
      {
        this.h = new Handler(paramLooper, this);
      }
      else
      {
        AssistantUtils.a("HelloQQWake", "QQWakeAIEngine init initEnv exception: uiLooper=null");
        return;
      }
    }
    if (this.e)
    {
      if (this.f == null)
      {
        this.f = new EglHandlerThread("QQWAKE_EGL_THREAD", null);
        this.f.start();
      }
      paramLooper = this.f.getLooper();
      if (paramLooper != null)
      {
        if (this.g == null) {
          this.g = new Handler(paramLooper, this);
        }
        this.g.sendEmptyMessage(100);
        return;
      }
      AssistantUtils.a("HelloQQWake", "QQWakeAIEngine init eglHandler exception: looper=null");
      return;
    }
    d();
  }
  
  public void a(QQWakeUICallback paramQQWakeUICallback)
  {
    this.k = paramQQWakeUICallback;
  }
  
  public void a(short[] paramArrayOfShort, int paramInt)
  {
    if (!this.e)
    {
      b(paramArrayOfShort, paramInt);
      return;
    }
    Object localObject = this.g;
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
    if (!this.e)
    {
      e();
      return;
    }
    Handler localHandler = this.g;
    if (localHandler != null) {
      localHandler.sendEmptyMessage(102);
    }
  }
  
  public void c()
  {
    if (!this.e)
    {
      f();
      return;
    }
    Handler localHandler = this.g;
    if (localHandler != null) {
      localHandler.sendEmptyMessage(103);
    }
  }
  
  public native int getRunType();
  
  public boolean handleMessage(Message paramMessage)
  {
    int m = paramMessage.what;
    if (m != 200)
    {
      switch (m)
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
          this.g.removeCallbacksAndMessages(null);
          this.f.quitSafely();
          this.f = null;
          this.g = null;
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
      float f1 = 0.0F;
      if ((paramMessage.obj instanceof Float)) {
        f1 = ((Float)paramMessage.obj).floatValue();
      }
      paramMessage = this.k;
      if (paramMessage != null) {
        paramMessage.a(f1);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.aicore.QQWakeAIEngine
 * JD-Core Version:    0.7.0.1
 */