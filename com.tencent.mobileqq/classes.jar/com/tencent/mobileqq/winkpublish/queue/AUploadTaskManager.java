package com.tencent.mobileqq.winkpublish.queue;

import android.text.TextUtils;
import com.tencent.mobileqq.winkpublish.IQueueTask;
import com.tencent.mobileqq.winkpublish.Singleton;
import com.tencent.mobileqq.winkpublish.api.IUploadLocalConfig;
import com.tencent.mobileqq.winkpublish.common.AUploadBusinessLooper;
import com.tencent.mobileqq.winkpublish.common.AUploadCommonSetting;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;
import com.tencent.mobileqq.winkpublish.task.AUploadTask;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.utils.NetworkState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class AUploadTaskManager
{
  public static final String a;
  private static int b = 5;
  private static final Singleton<AUploadTaskManager, Void> f = new AUploadTaskManager.1();
  private CopyOnWriteArrayList<IQueueTask> c = new CopyOnWriteArrayList();
  private AUploadTaskCacheManager d = new AUploadTaskCacheManager(AUploadCommonSetting.a().getTaskCacheName());
  private volatile boolean e = false;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(UploadConstants.a);
    localStringBuilder.append("[upload2_AUploadTaskManager]");
    a = localStringBuilder.toString();
  }
  
  public static AUploadTaskManager a()
  {
    return (AUploadTaskManager)f.get(null);
  }
  
  public IQueueTask a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    if (bool) {
      return null;
    }
    Iterator localIterator = this.c.iterator();
    Object localObject1;
    do
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (IQueueTask)localIterator.next();
    } while (!paramString.equals(((IQueueTask)localObject1).getCacheKey()));
    return localObject1;
  }
  
  public boolean a(IQueueTask paramIQueueTask)
  {
    if ((paramIQueueTask != null) && (!this.c.contains(paramIQueueTask)))
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addTask id:");
      localStringBuilder.append(paramIQueueTask.getTaskId());
      QLog.i(str, 1, localStringBuilder.toString());
      this.c.add(paramIQueueTask);
      this.d.a(paramIQueueTask);
      return true;
    }
    QLog.w(a, 1, "addTask error");
    return false;
  }
  
  public boolean a(IQueueTask paramIQueueTask, boolean paramBoolean)
  {
    if ((paramIQueueTask != null) && (this.c.contains(paramIQueueTask)))
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("completeTask id:");
      localStringBuilder.append(paramIQueueTask.getTaskId());
      localStringBuilder.append(", succeed:");
      localStringBuilder.append(paramBoolean);
      QLog.i(str, 1, localStringBuilder.toString());
      if (paramBoolean)
      {
        paramIQueueTask.setState(3);
        this.c.remove(paramIQueueTask);
        this.d.c(paramIQueueTask);
        return true;
      }
      if (paramIQueueTask.isNeedRetryByQueue()) {
        paramIQueueTask.setState(2);
      } else {
        paramIQueueTask.setState(8);
      }
      this.d.b(paramIQueueTask);
      return true;
    }
    QLog.w(a, 1, "completeTask error");
    return false;
  }
  
  public boolean b()
  {
    int i = h();
    boolean bool2 = NetworkState.isNetSupport();
    boolean bool3 = false;
    boolean bool1 = true;
    if (!bool2)
    {
      if (i <= 0) {
        bool1 = false;
      }
      this.e = bool1;
      return false;
    }
    int k = QCircleConfigHelper.a("QZoneSetting", "MaxParallelTaskCount", Integer.valueOf(b)).intValue();
    int j;
    if (i <= k)
    {
      Iterator localIterator = this.c.iterator();
      bool2 = false;
      do
      {
        IQueueTask localIQueueTask;
        do
        {
          do
          {
            j = i;
            bool1 = bool2;
            if (!localIterator.hasNext()) {
              break;
            }
            localIQueueTask = (IQueueTask)localIterator.next();
          } while (localIQueueTask == null);
          if (localIQueueTask.getState() != 0)
          {
            j = i;
            bool1 = bool2;
            if (localIQueueTask.getState() != 6) {
              break;
            }
          }
        } while ((localIQueueTask.isVideoTask()) && (f() > 0));
        String str = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("runTask id:");
        localStringBuilder.append(localIQueueTask.getTaskId());
        QLog.i(str, 1, localStringBuilder.toString());
        j = i + 1;
        localIQueueTask.setState(1);
        AUploadBusinessLooper.a().a((AUploadTask)localIQueueTask);
        bool1 = true;
        i = j;
        bool2 = bool1;
      } while (j != k);
    }
    else
    {
      bool1 = false;
      j = i;
    }
    bool2 = bool3;
    if (j > 0) {
      bool2 = true;
    }
    this.e = bool2;
    return bool1;
  }
  
  public boolean b(IQueueTask paramIQueueTask)
  {
    if ((paramIQueueTask != null) && (this.c.contains(paramIQueueTask)))
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateTask id:");
      localStringBuilder.append(paramIQueueTask.getTaskId());
      QLog.i(str, 1, localStringBuilder.toString());
      this.d.b(paramIQueueTask);
      return true;
    }
    QLog.w(a, 1, "updateTask error");
    return false;
  }
  
  public boolean c()
  {
    QLog.d(a, 1, "restore...");
    Object localObject3;
    Object localObject4;
    if (!this.c.isEmpty())
    {
      localObject1 = this.c.iterator();
      boolean bool = false;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (IQueueTask)((Iterator)localObject1).next();
        if (localObject2 == null)
        {
          QLog.w(a, 1, "restore... task is null");
        }
        else
        {
          localObject3 = a;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("restore... task state:");
          ((StringBuilder)localObject4).append(((IQueueTask)localObject2).getState());
          QLog.d((String)localObject3, 1, ((StringBuilder)localObject4).toString());
          if (((IQueueTask)localObject2).getState() == 2) {
            bool = true;
          }
        }
      }
      QLog.d(a, 1, new Object[] { "restore... isNeedRestore:", Boolean.valueOf(bool) });
      return bool;
    }
    Object localObject1 = this.d.a();
    if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
    {
      localObject2 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (IQueueTask)((Iterator)localObject2).next();
        if ((localObject3 != null) && (((IQueueTask)localObject3).getState() != 1))
        {
          ((IQueueTask)localObject3).onRestore();
          localObject4 = a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("restore task id:");
          localStringBuilder.append(((IQueueTask)localObject3).getTaskId());
          localStringBuilder.append(" state:");
          localStringBuilder.append(((IQueueTask)localObject3).getState());
          QLog.i((String)localObject4, 1, localStringBuilder.toString());
        }
      }
      this.c.clear();
      this.c.addAll((Collection)localObject1);
    }
    localObject1 = a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("restore total size:");
    ((StringBuilder)localObject2).append(this.c.size());
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    return this.c.size() > 0;
  }
  
  public boolean c(IQueueTask paramIQueueTask)
  {
    if ((paramIQueueTask != null) && (this.c.contains(paramIQueueTask)))
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pauseTask id:");
      localStringBuilder.append(paramIQueueTask.getTaskId());
      QLog.i(str, 1, localStringBuilder.toString());
      paramIQueueTask.cancel();
      paramIQueueTask.setState(2);
      b(paramIQueueTask);
      return true;
    }
    QLog.w(a, 1, "pauseTask error");
    return false;
  }
  
  public void d()
  {
    Object localObject1 = a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("reset total size:");
    ((StringBuilder)localObject2).append(this.c.size());
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    if (this.c.size() > 0)
    {
      localObject1 = this.c.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (IQueueTask)((Iterator)localObject1).next();
        if ((localObject2 != null) && (!((IQueueTask)localObject2).cancel())) {
          ((IQueueTask)localObject2).clear();
        }
      }
    }
    this.c.clear();
  }
  
  public boolean d(IQueueTask paramIQueueTask)
  {
    if ((paramIQueueTask != null) && (this.c.contains(paramIQueueTask)))
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resumeTask id:");
      localStringBuilder.append(paramIQueueTask.getTaskId());
      localStringBuilder.append(", current state:");
      localStringBuilder.append(paramIQueueTask.getState());
      QLog.i(str, 1, localStringBuilder.toString());
      int i = paramIQueueTask.getState();
      if (i != 0)
      {
        if ((i != 2) && (i != 5)) {
          return true;
        }
        paramIQueueTask.onResume();
        if (NetworkState.isNetSupport()) {
          paramIQueueTask.setState(0);
        } else {
          paramIQueueTask.setState(6);
        }
        b(paramIQueueTask);
      }
      return true;
    }
    QLog.w(a, 1, "resumeTask error");
    return false;
  }
  
  public CopyOnWriteArrayList<IQueueTask> e()
  {
    return (CopyOnWriteArrayList)this.c.clone();
  }
  
  public boolean e(IQueueTask paramIQueueTask)
  {
    if ((paramIQueueTask != null) && (this.c.contains(paramIQueueTask)))
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resumeTaskForAll id:");
      localStringBuilder.append(paramIQueueTask.getTaskId());
      localStringBuilder.append(", current state:");
      localStringBuilder.append(paramIQueueTask.getState());
      QLog.i(str, 1, localStringBuilder.toString());
      int i = paramIQueueTask.getState();
      if (i != 0)
      {
        if ((i != 2) && (i != 8) && (i != 5)) {
          return true;
        }
        paramIQueueTask.onResume();
        if (NetworkState.isNetSupport()) {
          paramIQueueTask.setState(0);
        } else {
          paramIQueueTask.setState(6);
        }
        b(paramIQueueTask);
      }
      return true;
    }
    QLog.w(a, 1, "resumeTask error");
    return false;
  }
  
  public int f()
  {
    Object localObject = this.c;
    int k = 0;
    int i = 0;
    int j = k;
    if (localObject != null)
    {
      j = k;
      if (((CopyOnWriteArrayList)localObject).size() > 0)
      {
        localObject = this.c.iterator();
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          IQueueTask localIQueueTask = (IQueueTask)((Iterator)localObject).next();
          if ((localIQueueTask != null) && (localIQueueTask.isVideoTask()) && ((localIQueueTask.getState() == 1) || (localIQueueTask.getState() == 4))) {
            i += 1;
          }
        }
      }
    }
    return j;
  }
  
  public boolean f(IQueueTask paramIQueueTask)
  {
    if ((paramIQueueTask != null) && (this.c.contains(paramIQueueTask)))
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeTask id:");
      localStringBuilder.append(paramIQueueTask.getTaskId());
      QLog.i(str, 1, localStringBuilder.toString());
      paramIQueueTask.setState(5);
      paramIQueueTask.onRemove();
      this.c.remove(paramIQueueTask);
      this.d.c(paramIQueueTask);
      return true;
    }
    QLog.w(a, 1, "removeTask error");
    return false;
  }
  
  public int g()
  {
    return this.c.size();
  }
  
  public boolean g(IQueueTask paramIQueueTask)
  {
    return this.c.contains(paramIQueueTask);
  }
  
  public int h()
  {
    boolean bool = this.c.isEmpty();
    int i = 0;
    if (bool) {
      return 0;
    }
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      IQueueTask localIQueueTask = (IQueueTask)localIterator.next();
      if ((localIQueueTask != null) && ((localIQueueTask.getState() == 1) || (localIQueueTask.getState() == 4))) {
        if (System.currentTimeMillis() - localIQueueTask.getTime() < 1800000L) {
          i += 1;
        } else {
          localIQueueTask.setState(2);
        }
      }
    }
    return i;
  }
  
  public boolean i()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.queue.AUploadTaskManager
 * JD-Core Version:    0.7.0.1
 */