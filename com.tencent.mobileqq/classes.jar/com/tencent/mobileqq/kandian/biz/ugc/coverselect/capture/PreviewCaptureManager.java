package com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;

public class PreviewCaptureManager
  implements CapturePreparedListener, CaptureTask.OnTaskListener
{
  private Queue<CaptureTask> a = new ArrayDeque();
  private Queue<CaptureTask> b = new ArrayDeque();
  private Executor c = ThreadManagerExecutor.getExecutorService(64);
  private ICaptureProxy d;
  private boolean e = false;
  private Handler f = new PreviewCaptureManager.1(this);
  
  public PreviewCaptureManager(ICaptureProxy paramICaptureProxy)
  {
    this.d = paramICaptureProxy;
    this.d.a(this);
  }
  
  private void b()
  {
    if ((this.e) && (!this.a.isEmpty()))
    {
      int j = Math.min(3 - this.b.size(), this.a.size());
      int i = j;
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("fetchTaskToExe concurrentCount:");
        ((StringBuilder)localObject).append(j);
        QLog.d("PreviewCaptureManager", 2, ((StringBuilder)localObject).toString());
        i = j;
      }
      while (i > 0)
      {
        j = i - 1;
        localObject = (CaptureTask)this.a.poll();
        i = j;
        if (localObject != null)
        {
          e((CaptureTask)localObject);
          i = j;
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("PreviewCaptureManager", 2, "fetchTaskToExe return for capturePrepared is false or waittingTaskQueue is Empty");
    }
  }
  
  private void c()
  {
    this.f.sendEmptyMessage(1000);
  }
  
  private void d(CaptureTask paramCaptureTask)
  {
    paramCaptureTask.a(this.d);
    paramCaptureTask.a(this);
  }
  
  private void e(CaptureTask paramCaptureTask)
  {
    this.b.add(paramCaptureTask);
    d(paramCaptureTask);
    paramCaptureTask.executeOnExecutor(this.c, null);
  }
  
  public void a()
  {
    this.f.removeCallbacksAndMessages(null);
    Object localObject = new ArrayList(this.a);
    ((List)localObject).addAll(this.b);
    this.a.clear();
    this.b.clear();
    int i = 0;
    while (i < ((List)localObject).size())
    {
      CaptureTask localCaptureTask = (CaptureTask)((List)localObject).get(i);
      if (localCaptureTask != null) {
        localCaptureTask.cancel(true);
      }
      i += 1;
    }
    localObject = this.d;
    if (localObject != null) {
      ((ICaptureProxy)localObject).a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    this.e = true;
    c();
  }
  
  public void a(CaptureTask paramCaptureTask) {}
  
  public void b(CaptureTask paramCaptureTask)
  {
    this.b.remove(paramCaptureTask);
    c();
  }
  
  public void c(CaptureTask paramCaptureTask)
  {
    if (!this.a.contains(paramCaptureTask))
    {
      if (this.b.contains(paramCaptureTask)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addCaptureTask task:");
        localStringBuilder.append(paramCaptureTask);
        QLog.d("PreviewCaptureManager", 2, localStringBuilder.toString());
      }
      this.a.add(paramCaptureTask);
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture.PreviewCaptureManager
 * JD-Core Version:    0.7.0.1
 */