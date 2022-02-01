package com.tencent.tkd.topicsdk.videoprocess.videocapture;

import android.os.Handler;
import com.tencent.tkd.topicsdk.framework.TLog;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/PreviewCaptureManager;", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask$OnTaskListener;", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CapturePreparedListener;", "captureProxy", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/ICaptureProxy;", "(Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/ICaptureProxy;)V", "capturePrepared", "", "executor", "Ljava/util/concurrent/ExecutorService;", "handler", "Landroid/os/Handler;", "runningTaskQueue", "Ljava/util/Queue;", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask;", "waitingTaskQueue", "addCaptureTask", "", "task", "attachCaptureProxyToTask", "executeTask", "fetchTaskToExe", "msgToCheckExecute", "onCapturePrepared", "width", "", "height", "duration", "", "onTaskComplete", "onTaskStart", "stop", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PreviewCaptureManager
  implements CapturePreparedListener, CaptureTask.OnTaskListener
{
  public static final PreviewCaptureManager.Companion a = new PreviewCaptureManager.Companion(null);
  private final Queue<CaptureTask> b;
  private final Queue<CaptureTask> c;
  private final ExecutorService d;
  private boolean e;
  private final Handler f;
  private final ICaptureProxy g;
  
  public PreviewCaptureManager(@NotNull ICaptureProxy paramICaptureProxy)
  {
    this.g = paramICaptureProxy;
    this.b = ((Queue)new ArrayDeque());
    this.c = ((Queue)new ArrayDeque());
    paramICaptureProxy = Executors.newFixedThreadPool(5);
    Intrinsics.checkExpressionValueIsNotNull(paramICaptureProxy, "Executors.newFixedThreadPool(5)");
    this.d = paramICaptureProxy;
    this.f = ((Handler)new PreviewCaptureManager.handler.1(this));
    this.g.a((CapturePreparedListener)this);
  }
  
  private final void b()
  {
    if ((this.e) && (!this.b.isEmpty()))
    {
      int i = Math.min(3 - this.c.size(), this.b.size());
      while (i > 0)
      {
        int j = i - 1;
        CaptureTask localCaptureTask = (CaptureTask)this.b.poll();
        i = j;
        if (localCaptureTask != null)
        {
          e(localCaptureTask);
          i = j;
        }
      }
      return;
    }
    TLog.c("PreviewCaptureManager", "fetchTaskToExe return for capturePrepared is false or waitingTaskQueue is Empty");
  }
  
  private final void c()
  {
    this.f.sendEmptyMessage(1000);
  }
  
  private final void d(CaptureTask paramCaptureTask)
  {
    paramCaptureTask.a(this.g);
    paramCaptureTask.a((CaptureTask.OnTaskListener)this);
  }
  
  private final void e(CaptureTask paramCaptureTask)
  {
    this.c.add(paramCaptureTask);
    d(paramCaptureTask);
    paramCaptureTask.executeOnExecutor((Executor)this.d, new Unit[] { null });
  }
  
  public final void a()
  {
    this.f.removeCallbacksAndMessages(null);
    List localList = (List)new ArrayList((Collection)this.b);
    localList.addAll((Collection)this.c);
    this.b.clear();
    this.c.clear();
    int j = ((Collection)localList).size();
    int i = 0;
    while (i < j)
    {
      ((CaptureTask)localList.get(i)).cancel(true);
      i += 1;
    }
    this.g.b();
    this.d.shutdown();
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    this.e = true;
    c();
  }
  
  public void a(@NotNull CaptureTask paramCaptureTask)
  {
    Intrinsics.checkParameterIsNotNull(paramCaptureTask, "task");
  }
  
  public void b(@NotNull CaptureTask paramCaptureTask)
  {
    Intrinsics.checkParameterIsNotNull(paramCaptureTask, "task");
    this.c.remove(paramCaptureTask);
    c();
  }
  
  public final void c(@NotNull CaptureTask paramCaptureTask)
  {
    Intrinsics.checkParameterIsNotNull(paramCaptureTask, "task");
    if (!this.b.contains(paramCaptureTask))
    {
      if (this.c.contains(paramCaptureTask)) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addCaptureTask task: ");
      localStringBuilder.append(paramCaptureTask);
      TLog.b("PreviewCaptureManager", localStringBuilder.toString());
      this.b.add(paramCaptureTask);
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videocapture.PreviewCaptureManager
 * JD-Core Version:    0.7.0.1
 */