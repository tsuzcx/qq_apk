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
  public static final PreviewCaptureManager.Companion a;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final ICaptureProxy jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureICaptureProxy;
  private final Queue<CaptureTask> jdField_a_of_type_JavaUtilQueue;
  private final ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  private boolean jdField_a_of_type_Boolean;
  private final Queue<CaptureTask> b;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocapturePreviewCaptureManager$Companion = new PreviewCaptureManager.Companion(null);
  }
  
  public PreviewCaptureManager(@NotNull ICaptureProxy paramICaptureProxy)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureICaptureProxy = paramICaptureProxy;
    this.jdField_a_of_type_JavaUtilQueue = ((Queue)new ArrayDeque());
    this.b = ((Queue)new ArrayDeque());
    paramICaptureProxy = Executors.newFixedThreadPool(5);
    Intrinsics.checkExpressionValueIsNotNull(paramICaptureProxy, "Executors.newFixedThreadPool(5)");
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = paramICaptureProxy;
    this.jdField_a_of_type_AndroidOsHandler = ((Handler)new PreviewCaptureManager.handler.1(this));
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureICaptureProxy.a((CapturePreparedListener)this);
  }
  
  private final void b()
  {
    if ((this.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_JavaUtilQueue.isEmpty()))
    {
      int i = Math.min(3 - this.b.size(), this.jdField_a_of_type_JavaUtilQueue.size());
      while (i > 0)
      {
        int j = i - 1;
        CaptureTask localCaptureTask = (CaptureTask)this.jdField_a_of_type_JavaUtilQueue.poll();
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
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1000);
  }
  
  private final void d(CaptureTask paramCaptureTask)
  {
    paramCaptureTask.a(this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureICaptureProxy);
    paramCaptureTask.a((CaptureTask.OnTaskListener)this);
  }
  
  private final void e(CaptureTask paramCaptureTask)
  {
    this.b.add(paramCaptureTask);
    d(paramCaptureTask);
    paramCaptureTask.executeOnExecutor((Executor)this.jdField_a_of_type_JavaUtilConcurrentExecutorService, new Unit[] { null });
  }
  
  public final void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    List localList = (List)new ArrayList((Collection)this.jdField_a_of_type_JavaUtilQueue);
    localList.addAll((Collection)this.b);
    this.jdField_a_of_type_JavaUtilQueue.clear();
    this.b.clear();
    int j = ((Collection)localList).size();
    int i = 0;
    while (i < j)
    {
      ((CaptureTask)localList.get(i)).cancel(true);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureICaptureProxy.a();
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.shutdown();
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    this.jdField_a_of_type_Boolean = true;
    c();
  }
  
  public void a(@NotNull CaptureTask paramCaptureTask)
  {
    Intrinsics.checkParameterIsNotNull(paramCaptureTask, "task");
  }
  
  public void b(@NotNull CaptureTask paramCaptureTask)
  {
    Intrinsics.checkParameterIsNotNull(paramCaptureTask, "task");
    this.b.remove(paramCaptureTask);
    c();
  }
  
  public final void c(@NotNull CaptureTask paramCaptureTask)
  {
    Intrinsics.checkParameterIsNotNull(paramCaptureTask, "task");
    if (!this.jdField_a_of_type_JavaUtilQueue.contains(paramCaptureTask))
    {
      if (this.b.contains(paramCaptureTask)) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addCaptureTask task: ");
      localStringBuilder.append(paramCaptureTask);
      TLog.b("PreviewCaptureManager", localStringBuilder.toString());
      this.jdField_a_of_type_JavaUtilQueue.add(paramCaptureTask);
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videocapture.PreviewCaptureManager
 * JD-Core Version:    0.7.0.1
 */