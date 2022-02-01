package com.tencent.mobileqq.utils;

import android.content.res.Resources;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.util.AudioHelperUtil;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class SyncLoadTask
{
  public final String TAG;
  int mTaskStatus = 1;
  
  public SyncLoadTask(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(AudioHelperUtil.a());
    this.TAG = localStringBuilder.toString();
  }
  
  public static void requestSyncTask(Resources paramResources, ArrayList<SyncLoadTask> paramArrayList, SyncLoadTask.OnSyncTaskListener paramOnSyncTaskListener)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      SyncLoadTask localSyncLoadTask = (SyncLoadTask)localIterator.next();
      if (localSyncLoadTask.isNeedRunTask()) {
        localArrayList.add(localSyncLoadTask);
      }
    }
    localIterator = localArrayList.iterator();
    while (localIterator.hasNext()) {
      ((SyncLoadTask)localIterator.next()).setRunning();
    }
    ThreadManager.post(new SyncLoadTask.1(localArrayList, paramResources, paramOnSyncTaskListener, paramArrayList), 8, null, true);
  }
  
  public final void clean()
  {
    this.mTaskStatus = 1;
    innerClean();
  }
  
  public abstract void innerClean();
  
  public final boolean isNeedRunTask()
  {
    int i = this.mTaskStatus;
    return (i != 20) && (i != 2);
  }
  
  final boolean isRunning()
  {
    return (this.mTaskStatus & 0x2) == 2;
  }
  
  final boolean isSuc()
  {
    return (this.mTaskStatus & 0x14) == 20;
  }
  
  public abstract boolean runOnSubThread(Resources paramResources);
  
  final void setComplete(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mTaskStatus = 20;
      return;
    }
    this.mTaskStatus = 36;
  }
  
  final void setRunning()
  {
    this.mTaskStatus = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SyncLoadTask
 * JD-Core Version:    0.7.0.1
 */