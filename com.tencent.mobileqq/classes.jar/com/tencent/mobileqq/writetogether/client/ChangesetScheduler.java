package com.tencent.mobileqq.writetogether.client;

import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.util.MqqWeakReferenceHandler;
import mqq.os.MqqHandler;

public class ChangesetScheduler
  implements Handler.Callback, IScheduler
{
  private MqqHandler a = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  private ISchedulerCallback b;
  
  public void a(int paramInt)
  {
    this.a.removeMessages(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (!this.a.hasMessages(paramInt1)) {
      this.a.sendEmptyMessageDelayed(paramInt1, paramInt2);
    }
  }
  
  public void a(ISchedulerCallback paramISchedulerCallback)
  {
    this.b = paramISchedulerCallback;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    ISchedulerCallback localISchedulerCallback = this.b;
    if (localISchedulerCallback != null) {
      return localISchedulerCallback.c(paramMessage.what);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.client.ChangesetScheduler
 * JD-Core Version:    0.7.0.1
 */