package com.tencent.mobileqq.shortvideo.common;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.shortvideo.mediadevice.Lock;
import com.tencent.qphone.base.util.QLog;

public class TCTimer
  implements Handler.Callback
{
  public HandlerThread a;
  private TCTimer.TCTimerCallback b;
  private int c;
  private int d;
  private int e;
  private Handler f;
  
  public TCTimer(int paramInt1, int paramInt2)
  {
    this.c = (1000 / paramInt1);
    this.d = ((int)(paramInt2 / 1000.0F * paramInt1) + 1);
    this.e = 0;
    this.a = new HandlerThread("shortvideo_Timer");
    this.a.start();
    this.f = new Handler(this.a.getLooper(), this);
  }
  
  private boolean a(Message paramMessage)
  {
    if (Lock.b)
    {
      paramMessage = RMVideoStateMgr.a();
      boolean bool3 = paramMessage.b;
      boolean bool2 = false;
      boolean bool1 = false;
      if (bool3)
      {
        paramMessage.n = (System.currentTimeMillis() - paramMessage.c);
        if (paramMessage.n >= CodecParam.RECORD_MAX_TIME) {
          bool1 = true;
        }
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          if (bool1)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("handleLooperEvent startTime=");
            localStringBuilder.append(paramMessage.c);
            localStringBuilder.append(" total=");
            localStringBuilder.append(paramMessage.n);
            QLog.d("TCTimer", 2, localStringBuilder.toString());
            bool2 = bool1;
          }
        }
      }
      else if (this.e >= this.d)
      {
        bool2 = true;
      }
      if (bool2) {
        this.e = this.d;
      }
      int i = this.e;
      int j = this.c;
      paramMessage = this.b;
      if (paramMessage != null) {
        paramMessage.a(paramMessage, bool2, j * i, i);
      }
      this.e += 1;
    }
    return true;
  }
  
  public int a()
  {
    return this.c;
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(TCTimer.TCTimerCallback paramTCTimerCallback)
  {
    this.b = paramTCTimerCallback;
  }
  
  public void b()
  {
    Message localMessage = this.f.obtainMessage(1398036036);
    this.f.sendMessageDelayed(localMessage, this.c);
  }
  
  public void c()
  {
    this.a.quit();
  }
  
  public void d()
  {
    this.e = 0;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1398036036) {
      return false;
    }
    Object localObject = this.f;
    if (localObject != null)
    {
      localObject = ((Handler)localObject).obtainMessage(1398036036);
      this.f.sendMessageDelayed((Message)localObject, this.c);
    }
    return a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.common.TCTimer
 * JD-Core Version:    0.7.0.1
 */