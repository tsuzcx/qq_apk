package com.tencent.upload.b;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.upload.a.a;
import com.tencent.upload.common.Const.UploadRetCode;
import com.tencent.upload.common.Const.b;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.d.d;
import com.tencent.upload.e.a.e;
import com.tencent.upload.network.a.c.a;
import com.tencent.upload.network.route.RouteFactory.ServerCategory;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.uinterface.data.BatchControlTask;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class g
  implements d, c.a
{
  private long a = 1L;
  private LinkedBlockingQueue<AbstractUploadTask> b;
  private LinkedBlockingQueue<AbstractUploadTask> c;
  private final Map<Const.b, com.tencent.upload.network.a.c> d;
  private Handler e;
  private com.tencent.upload.e.a.c f;
  private boolean g;
  private long h;
  
  public g(com.tencent.upload.e.a.c paramc)
  {
    this.f = paramc;
    this.d = new HashMap();
    this.b = new LinkedBlockingQueue();
    this.c = new LinkedBlockingQueue();
    paramc = new HandlerThread("Dispatcher");
    paramc.start();
    this.e = new Handler(paramc.getLooper());
  }
  
  public g(com.tencent.upload.e.a.c paramc, int paramInt)
  {
    this(paramc);
    this.a = paramInt;
  }
  
  public static Const.b b(AbstractUploadTask paramAbstractUploadTask)
  {
    return paramAbstractUploadTask.getUploadTaskType().serverCategory.supportFileType;
  }
  
  private void c(Const.b paramb)
  {
    com.tencent.upload.common.b.b("UploadTaskManager", "recovery -- mRunningList:" + this.c.size());
    if (this.c.size() > 0)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        AbstractUploadTask localAbstractUploadTask = (AbstractUploadTask)localIterator.next();
        if ((b(localAbstractUploadTask) == paramb) && ((localAbstractUploadTask.getTaskState() == com.tencent.upload.d.c.f) || (localAbstractUploadTask.getTaskState() == com.tencent.upload.d.c.a) || (localAbstractUploadTask.getTaskState() == com.tencent.upload.d.c.b) || (localAbstractUploadTask.getTaskState() == com.tencent.upload.d.c.d)))
        {
          com.tencent.upload.common.b.b("UploadTaskManager", "recovery taskId:" + localAbstractUploadTask.getTaskId() + ", path:" + localAbstractUploadTask.getFilePath());
          localAbstractUploadTask.resetTask();
          e(localAbstractUploadTask);
        }
      }
    }
    f();
  }
  
  private boolean d(Const.b paramb)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      if (b((AbstractUploadTask)localIterator.next()) == paramb) {
        return true;
      }
    }
    localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      if (b((AbstractUploadTask)localIterator.next()) == paramb) {
        return true;
      }
    }
    return false;
  }
  
  private void e()
  {
    Iterator localIterator = this.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      Const.b localb = (Const.b)localIterator.next();
      ((com.tencent.upload.network.a.c)this.d.get(localb)).d();
    }
    this.d.clear();
  }
  
  private void e(AbstractUploadTask paramAbstractUploadTask)
  {
    com.tencent.upload.common.b.b("UploadTaskManager", "runTask -- [" + paramAbstractUploadTask.getClass().getSimpleName() + "], flowId:" + paramAbstractUploadTask.flowId + ", path:" + paramAbstractUploadTask.getFilePath());
    a.a(paramAbstractUploadTask);
    com.tencent.upload.e.a.b localb = this.f.a();
    com.tencent.upload.network.a.c localc = c(paramAbstractUploadTask);
    if (localc != null) {
      localc.l();
    }
    paramAbstractUploadTask.bindThreadPool(localb);
    paramAbstractUploadTask.bindSessionPool(localc);
    paramAbstractUploadTask.setTaskId(paramAbstractUploadTask.flowId);
    paramAbstractUploadTask.start();
  }
  
  private void f()
  {
    boolean bool = UploadConfiguration.isNetworkAvailable();
    com.tencent.upload.common.b.c("UploadTaskManager", "next --- Pending:" + this.b.size() + ", Running:" + this.c.size() + ", network:" + bool);
    j();
    if (!bool) {
      return;
    }
    if (this.c.size() >= this.a)
    {
      com.tencent.upload.common.b.b("UploadTaskManager", "channel is full now! mMaxDispatchNum:" + this.a + " thread pool:" + e.a().toString());
      return;
    }
    Object localObject = g();
    if ((localObject != null) && (f((AbstractUploadTask)localObject)))
    {
      e((AbstractUploadTask)localObject);
      return;
    }
    if (localObject == null) {
      com.tencent.upload.common.b.b("UploadTaskManager", "getTask return null!");
    }
    for (;;)
    {
      j();
      return;
      localObject = (com.tencent.upload.network.a.c)this.d.get(b((AbstractUploadTask)localObject));
      if ((localObject != null) && (!((com.tencent.upload.network.a.c)localObject).i()))
      {
        com.tencent.upload.common.b.b("UploadTaskManager", "getSessionPool: " + localObject.hashCode() + " is not ready, reset it");
        ((com.tencent.upload.network.a.c)localObject).h();
      }
    }
  }
  
  private boolean f(AbstractUploadTask paramAbstractUploadTask)
  {
    boolean bool = paramAbstractUploadTask.onVerifyUploadFile();
    Const.b localb = b(paramAbstractUploadTask);
    com.tencent.upload.network.a.c localc = (com.tencent.upload.network.a.c)this.d.get(localb);
    StringBuilder localStringBuilder = new StringBuilder().append("getSessionPool pool:");
    if (localc != null) {}
    for (paramAbstractUploadTask = Integer.valueOf(localc.hashCode());; paramAbstractUploadTask = "null")
    {
      com.tencent.upload.common.b.b("UploadTaskManager", paramAbstractUploadTask);
      if (localc != null) {
        break;
      }
      paramAbstractUploadTask = new com.tencent.upload.network.a.c(localb);
      paramAbstractUploadTask.a(this);
      paramAbstractUploadTask.b();
      this.d.put(localb, paramAbstractUploadTask);
      return false;
    }
    if ((bool) && (localc.i())) {}
    for (bool = true;; bool = false) {
      return bool;
    }
  }
  
  private AbstractUploadTask g()
  {
    ??? = null;
    if (this.b.size() <= 0) {
      return null;
    }
    Object localObject1;
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      do
      {
        localObject1 = ???;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (AbstractUploadTask)localIterator.next();
      } while (((AbstractUploadTask)localObject1).getTaskState() != com.tencent.upload.d.c.a);
      this.b.remove(localObject1);
      if (localObject1 == null) {}
    }
    for (;;)
    {
      synchronized (this.c)
      {
        this.c.add(localObject1);
        ((AbstractUploadTask)localObject1).bindHandler(this.e);
        ??? = new StringBuilder().append("getTask, move task from pending to running, taskId:");
        if (localObject1 != null)
        {
          ??? = Integer.valueOf(((AbstractUploadTask)localObject1).getTaskId());
          com.tencent.upload.common.b.b("UploadTaskManager", ???);
          return localObject1;
          localObject2 = finally;
          throw localObject2;
        }
      }
      ??? = "";
    }
  }
  
  private void h()
  {
    com.tencent.upload.common.b.b("UploadTaskManager", "clearAllLogTask !");
    AbstractUploadTask localAbstractUploadTask;
    synchronized (this.b)
    {
      Iterator localIterator1 = this.b.iterator();
      while (localIterator1.hasNext())
      {
        localAbstractUploadTask = (AbstractUploadTask)localIterator1.next();
        if (localAbstractUploadTask.getFileType() == Const.b.f) {
          this.b.remove(localAbstractUploadTask);
        }
      }
    }
    synchronized (this.c)
    {
      Iterator localIterator2 = this.c.iterator();
      while (localIterator2.hasNext())
      {
        localAbstractUploadTask = (AbstractUploadTask)localIterator2.next();
        if (localAbstractUploadTask.getFileType() == Const.b.f) {
          localAbstractUploadTask.onError(Const.UploadRetCode.SERVER_DISCONNECT.getCode(), Const.UploadRetCode.SERVER_DISCONNECT.getDesc());
        }
      }
    }
  }
  
  private boolean i()
  {
    if ((this.b.size() == 0) && (this.c.size() == 0))
    {
      com.tencent.upload.common.b.b("UploadTaskManager", "uploadTaskManager checkEmpty empty == true");
      Iterator localIterator = this.d.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Const.b)localIterator.next();
        localObject = (com.tencent.upload.network.a.c)this.d.get(localObject);
        if (localObject != null) {
          ((com.tencent.upload.network.a.c)localObject).k();
        }
      }
      return true;
    }
    return false;
  }
  
  private void j()
  {
    StringBuilder localStringBuilder = new StringBuilder("pending:").append(this.b.size());
    Iterator localIterator = this.b.iterator();
    AbstractUploadTask localAbstractUploadTask;
    while (localIterator.hasNext())
    {
      localAbstractUploadTask = (AbstractUploadTask)localIterator.next();
      localStringBuilder.append(" [" + localAbstractUploadTask.flowId + " state:" + localAbstractUploadTask.getTaskState() + "]");
    }
    com.tencent.upload.common.b.b("UploadTaskManager", localStringBuilder.toString());
    localStringBuilder.setLength(0);
    localStringBuilder.append("running:").append(this.c.size());
    localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      localAbstractUploadTask = (AbstractUploadTask)localIterator.next();
      localStringBuilder.append(" [" + localAbstractUploadTask.flowId + " state:" + localAbstractUploadTask.getTaskState() + "]");
    }
    com.tencent.upload.common.b.b("UploadTaskManager", localStringBuilder.toString());
  }
  
  public void a()
  {
    Iterator localIterator = this.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Const.b)localIterator.next();
      localObject = (com.tencent.upload.network.a.c)this.d.get(localObject);
      if (localObject != null) {
        ((com.tencent.upload.network.a.c)localObject).h();
      }
    }
  }
  
  public void a(Const.b paramb)
  {
    if ((com.tencent.upload.network.a.c)this.d.get(paramb) == null)
    {
      com.tencent.upload.common.b.b("UploadTaskManager", "prepare pool == null need create new, type:" + paramb);
      com.tencent.upload.network.a.c localc = new com.tencent.upload.network.a.c(paramb);
      localc.a(this);
      localc.b();
      this.d.put(paramb, localc);
    }
  }
  
  public void a(com.tencent.upload.d.b paramb) {}
  
  public void a(com.tencent.upload.d.b paramb, int paramInt, String arg3)
  {
    if ((paramb instanceof AbstractUploadTask))
    {
      com.tencent.upload.common.b.b("UploadTaskManager", "taskId:" + paramb.getTaskId() + " onTaskFinished state: " + paramb.getTaskState() + " ret:" + paramInt + " msg:" + ???);
      if (paramb.getTaskState() == com.tencent.upload.d.c.g) {
        synchronized (this.c)
        {
          this.c.remove(paramb);
          com.tencent.upload.common.b.b("UploadTaskManager", "remove -- flowid:" + ((AbstractUploadTask)paramb).flowId);
          if (!i()) {
            f();
          }
          return;
        }
      }
      if ((paramb.getTaskState() != com.tencent.upload.d.c.f) && (paramb.getTaskState() != com.tencent.upload.d.c.e)) {}
    }
    synchronized (this.c)
    {
      this.c.remove(paramb);
      com.tencent.upload.common.b.b("UploadTaskManager", "remove -- flowid:" + ((AbstractUploadTask)paramb).flowId);
      if ((paramb.getFileType() == Const.b.f) && (paramInt == Const.UploadRetCode.SERVER_DISCONNECT.getCode()))
      {
        this.g = true;
        h();
      }
      if (paramInt == Const.UploadRetCode.NETWORK_NOT_AVAILABLE.getCode())
      {
        this.e.postAtTime(new Runnable()
        {
          public void run()
          {
            g.a(g.this);
          }
        }, 500L);
        return;
      }
    }
    f();
  }
  
  public void a(com.tencent.upload.network.a.c paramc)
  {
    if (paramc == null) {}
    for (;;)
    {
      return;
      if (paramc.a() == Const.b.f)
      {
        this.g = true;
        h();
        return;
      }
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        AbstractUploadTask localAbstractUploadTask = (AbstractUploadTask)localIterator.next();
        if ((localAbstractUploadTask.getFileType() == paramc.a()) || ((localAbstractUploadTask instanceof BatchControlTask))) {
          localAbstractUploadTask.onError(Const.UploadRetCode.ALL_IP_FAILED.getCode(), Const.UploadRetCode.ALL_IP_FAILED.getDesc());
        }
      }
    }
  }
  
  public void a(com.tencent.upload.network.a.c paramc, int paramInt)
  {
    com.tencent.upload.common.b.b("UploadTaskManager", "no available sessions !");
    if (d(paramc.a()))
    {
      com.tencent.upload.common.b.b("UploadTaskManager", "hasRemainTask == true;");
      if (System.currentTimeMillis() - this.h > 1000L)
      {
        paramc.g();
        this.h = System.currentTimeMillis();
        com.tencent.upload.common.b.b("UploadTaskManager", "rebuildSessions;");
      }
    }
  }
  
  public boolean a(AbstractUploadTask paramAbstractUploadTask)
  {
    if (paramAbstractUploadTask == null) {
      return false;
    }
    if ((this.g) && (paramAbstractUploadTask.getFileType() == Const.b.f))
    {
      com.tencent.upload.common.b.b("UploadTaskManager", "bStopAllLogTask now ! ");
      return false;
    }
    if (paramAbstractUploadTask.getTaskState() != com.tencent.upload.d.c.a) {
      paramAbstractUploadTask.resetWaitState();
    }
    synchronized (this.b)
    {
      this.b.add(paramAbstractUploadTask);
      paramAbstractUploadTask.setTaskStateListener(this);
      if (!UploadConfiguration.isNetworkAvailable())
      {
        a(paramAbstractUploadTask.getFileType());
        return false;
      }
    }
    this.e.post(new Runnable()
    {
      public void run()
      {
        g.a(g.this);
      }
    });
  }
  
  public void b()
  {
    this.b.clear();
    this.c.clear();
    e();
  }
  
  public void b(final Const.b paramb)
  {
    com.tencent.upload.common.b.b("UploadTaskManager", "onSessionPoolRestore type: " + paramb);
    this.e.postDelayed(new Runnable()
    {
      public void run()
      {
        g.a(g.this, paramb);
      }
    }, 500L);
  }
  
  public com.tencent.upload.network.a.c c(AbstractUploadTask paramAbstractUploadTask)
  {
    paramAbstractUploadTask = b(paramAbstractUploadTask);
    return (com.tencent.upload.network.a.c)this.d.get(paramAbstractUploadTask);
  }
  
  public void c()
  {
    com.tencent.upload.common.b.b("UploadTaskManager", "cancelAllTasks --- ");
    this.e.post(new Runnable()
    {
      public void run()
      {
        synchronized (g.b(g.this))
        {
          g.b(g.this).clear();
          synchronized (g.c(g.this))
          {
            Iterator localIterator = g.c(g.this).iterator();
            if (localIterator.hasNext()) {
              ((AbstractUploadTask)localIterator.next()).cancel();
            }
          }
        }
        g.c(g.this).clear();
      }
    });
  }
  
  public int d()
  {
    j();
    if ((this.b != null) && (this.c != null))
    {
      Iterator localIterator = this.b.iterator();
      int i = 0;
      AbstractUploadTask localAbstractUploadTask;
      while (localIterator.hasNext())
      {
        localAbstractUploadTask = (AbstractUploadTask)localIterator.next();
        if ((localAbstractUploadTask.getTaskState().a() != com.tencent.upload.d.c.e.a()) && (localAbstractUploadTask.getTaskState().a() != com.tencent.upload.d.c.f.a()) && (localAbstractUploadTask.getTaskState().a() != com.tencent.upload.d.c.g.a())) {
          i += 1;
        }
      }
      localIterator = this.c.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localAbstractUploadTask = (AbstractUploadTask)localIterator.next();
        if ((localAbstractUploadTask.getTaskState().a() != com.tencent.upload.d.c.e.a()) && (localAbstractUploadTask.getTaskState().a() != com.tencent.upload.d.c.f.a()) && (localAbstractUploadTask.getTaskState().a() != com.tencent.upload.d.c.g.a())) {
          i += 1;
        }
      }
    }
    int j = 0;
    return j;
  }
  
  public void d(final AbstractUploadTask paramAbstractUploadTask)
  {
    this.e.post(new Runnable()
    {
      public void run()
      {
        if (paramAbstractUploadTask == null) {
          return;
        }
        com.tencent.upload.common.b.b("UploadTaskManager", "remove task, flowId: " + paramAbstractUploadTask.flowId + ", path:" + paramAbstractUploadTask.uploadFilePath);
        for (;;)
        {
          Iterator localIterator;
          synchronized (g.b(g.this))
          {
            localIterator = g.b(g.this).iterator();
            if (!localIterator.hasNext()) {
              break label228;
            }
            AbstractUploadTask localAbstractUploadTask1 = (AbstractUploadTask)localIterator.next();
            if (localAbstractUploadTask1.flowId != paramAbstractUploadTask.flowId) {
              continue;
            }
            if (localAbstractUploadTask1 != null)
            {
              g.b(g.this).remove(localAbstractUploadTask1);
              return;
            }
          }
          for (;;)
          {
            synchronized (g.c(g.this))
            {
              localIterator = g.c(g.this).iterator();
              if (localIterator.hasNext())
              {
                AbstractUploadTask localAbstractUploadTask2 = (AbstractUploadTask)localIterator.next();
                if (localAbstractUploadTask2.flowId != paramAbstractUploadTask.flowId) {
                  continue;
                }
                if (localAbstractUploadTask2 != null)
                {
                  g.c(g.this).remove(localAbstractUploadTask2);
                  localAbstractUploadTask2.cancel();
                }
                g.a(g.this);
                return;
              }
            }
            localObject3 = null;
          }
          label228:
          Object localObject3 = null;
        }
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.b.g
 * JD-Core Version:    0.7.0.1
 */