package com.tencent.vas.update.module.impl;

import androidx.annotation.NonNull;
import com.tencent.vas.update.callback.listener.ITimerListener;
import com.tencent.vas.update.factory.api.IVasLog;
import com.tencent.vas.update.module.api.ITimerModule;
import com.tencent.vas.update.module.thread.ThreadManager;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.util.HashMap;
import java.util.concurrent.ScheduledFuture;

public class TimerModuleImpl
  implements ITimerModule
{
  private ITimerListener a;
  private HashMap<Integer, ScheduledFuture> b;
  
  public TimerModuleImpl(ITimerListener paramITimerListener)
  {
    this.a = paramITimerListener;
    this.b = new HashMap();
  }
  
  private void a(@NonNull TimerModuleImpl.TimerTaskParams paramTimerTaskParams)
  {
    Object localObject = VasUpdateWrapper.getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("send timer task = ");
    localStringBuilder.append(paramTimerTaskParams.toString());
    ((IVasLog)localObject).b("VasUpdate_TimerModule", localStringBuilder.toString());
    localObject = new TimerModuleImpl.TaskRunnable(this, paramTimerTaskParams);
    localObject = ThreadManager.getInstance().postDelay(2, (Runnable)localObject, paramTimerTaskParams.b);
    this.b.put(Integer.valueOf(paramTimerTaskParams.a), localObject);
  }
  
  public void a(int paramInt)
  {
    if ((this.b.containsKey(Integer.valueOf(paramInt))) && (this.b.get(Integer.valueOf(paramInt)) != null))
    {
      ((ScheduledFuture)this.b.get(Integer.valueOf(paramInt))).cancel(true);
      this.b.remove(Integer.valueOf(paramInt));
      VasUpdateWrapper.getLog().b("VasUpdate_TimerModule", "stop true");
    }
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    if (this.b.containsKey(Integer.valueOf(paramInt)))
    {
      localObject = VasUpdateWrapper.getLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setTimer repeat type = ");
      localStringBuilder.append(paramInt);
      ((IVasLog)localObject).b("VasUpdate_TimerModule", localStringBuilder.toString());
      return;
    }
    Object localObject = new TimerModuleImpl.TimerTaskParams(this, null);
    ((TimerModuleImpl.TimerTaskParams)localObject).a = paramInt;
    ((TimerModuleImpl.TimerTaskParams)localObject).b = paramLong;
    ((TimerModuleImpl.TimerTaskParams)localObject).c = paramBoolean;
    a((TimerModuleImpl.TimerTaskParams)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.vas.update.module.impl.TimerModuleImpl
 * JD-Core Version:    0.7.0.1
 */