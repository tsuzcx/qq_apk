package com.tencent.vas.update.module;

import androidx.annotation.NonNull;
import com.tencent.vas.update.callback.IVasLog;
import com.tencent.vas.update.callback.listener.ITimerListener;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.util.HashMap;

class TimerModule$TaskRunnable
  implements Runnable
{
  private TimerModule.TimerTaskParams mParams;
  
  public TimerModule$TaskRunnable(TimerModule paramTimerModule, @NonNull TimerModule.TimerTaskParams paramTimerTaskParams)
  {
    this.mParams = paramTimerTaskParams;
  }
  
  public void run()
  {
    if (!TimerModule.access$100(this.this$0).containsKey(Integer.valueOf(this.mParams.mType))) {}
    do
    {
      return;
      TimerModule.access$100(this.this$0).remove(Integer.valueOf(this.mParams.mType));
      VasUpdateWrapper.getLog().i("VasUpdate_TimerModule", "timer run = " + this.mParams.toString());
    } while (TimerModule.access$200(this.this$0) == null);
    TimerModule.access$200(this.this$0).onTime(this.mParams.mType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.vas.update.module.TimerModule.TaskRunnable
 * JD-Core Version:    0.7.0.1
 */