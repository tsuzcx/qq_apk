package com.tencent.vas.update.module.impl;

import androidx.annotation.NonNull;
import com.tencent.vas.update.callback.listener.ITimerListener;
import com.tencent.vas.update.factory.api.IVasLog;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.util.HashMap;

class TimerModuleImpl$TaskRunnable
  implements Runnable
{
  private TimerModuleImpl.TimerTaskParams a;
  
  public TimerModuleImpl$TaskRunnable(TimerModuleImpl paramTimerModuleImpl, @NonNull TimerModuleImpl.TimerTaskParams paramTimerTaskParams)
  {
    this.a = paramTimerTaskParams;
  }
  
  public void run()
  {
    if (!TimerModuleImpl.a(this.this$0).containsKey(Integer.valueOf(this.a.a))) {
      return;
    }
    TimerModuleImpl.a(this.this$0).remove(Integer.valueOf(this.a.a));
    IVasLog localIVasLog = VasUpdateWrapper.getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("timer run = ");
    localStringBuilder.append(this.a.toString());
    localIVasLog.b("VasUpdate_TimerModule", localStringBuilder.toString());
    if (TimerModuleImpl.b(this.this$0) != null) {
      TimerModuleImpl.b(this.this$0).onTime(this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.vas.update.module.impl.TimerModuleImpl.TaskRunnable
 * JD-Core Version:    0.7.0.1
 */