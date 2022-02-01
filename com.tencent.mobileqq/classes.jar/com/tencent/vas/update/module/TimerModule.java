package com.tencent.vas.update.module;

import androidx.annotation.NonNull;
import com.tencent.vas.update.callback.IVasLog;
import com.tencent.vas.update.callback.listener.ITimerListener;
import com.tencent.vas.update.module.thread.ThreadManager;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;

public class TimerModule
{
  private static final String TAG = "VasUpdate_TimerModule";
  private ITimerListener listener;
  private HashMap<Integer, ScheduledFuture> mTimerMap;
  
  public TimerModule(ITimerListener paramITimerListener)
  {
    this.listener = paramITimerListener;
    this.mTimerMap = new HashMap();
  }
  
  private void sendTimerTask(@NonNull TimerModule.TimerTaskParams paramTimerTaskParams)
  {
    VasUpdateWrapper.getLog().i("VasUpdate_TimerModule", "send timer task = " + paramTimerTaskParams.toString());
    Object localObject = new TimerModule.TaskRunnable(this, paramTimerTaskParams);
    localObject = ThreadManager.getInstance().postDelay(2, (Runnable)localObject, paramTimerTaskParams.mDelay);
    this.mTimerMap.put(Integer.valueOf(paramTimerTaskParams.mType), localObject);
  }
  
  public void onDestory()
  {
    Iterator localIterator = this.mTimerMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (localEntry.getValue() != null) {
        ((ScheduledFuture)localEntry.getValue()).cancel(true);
      }
    }
  }
  
  public void setTimer(int paramInt, long paramLong, boolean paramBoolean)
  {
    if (this.mTimerMap.containsKey(Integer.valueOf(paramInt)))
    {
      VasUpdateWrapper.getLog().i("VasUpdate_TimerModule", "setTimer repeat type = " + paramInt);
      return;
    }
    TimerModule.TimerTaskParams localTimerTaskParams = new TimerModule.TimerTaskParams(this, null);
    localTimerTaskParams.mType = paramInt;
    localTimerTaskParams.mDelay = paramLong;
    localTimerTaskParams.mIsLoop = paramBoolean;
    sendTimerTask(localTimerTaskParams);
  }
  
  public void stopTimer(int paramInt)
  {
    if ((this.mTimerMap.containsKey(Integer.valueOf(paramInt))) && (this.mTimerMap.get(Integer.valueOf(paramInt)) != null))
    {
      ((ScheduledFuture)this.mTimerMap.get(Integer.valueOf(paramInt))).cancel(true);
      this.mTimerMap.remove(Integer.valueOf(paramInt));
      VasUpdateWrapper.getLog().i("VasUpdate_TimerModule", "stop true");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.vas.update.module.TimerModule
 * JD-Core Version:    0.7.0.1
 */