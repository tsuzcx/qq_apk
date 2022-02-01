package com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture;

import android.view.ViewGroup;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import java.util.concurrent.Executor;

public class CandidateCaptureManager
  implements CapturePreparedListener, ISuperPlayer.OnSeekCompleteListener
{
  private ICaptureProxy a = new PlayerCaptureProxy();
  private int b = -1;
  private String c;
  private int d;
  private int e;
  private CaptureTask.OnCaptureCallback f;
  private CaptureTask g = null;
  private Executor h = ThreadManagerExecutor.getExecutorService(64);
  
  private void d()
  {
    e();
    CaptureTask localCaptureTask = new CaptureTask(2, this.c, this.b, this.d, this.e, this.f);
    this.g = localCaptureTask;
    localCaptureTask.a(this.a);
    localCaptureTask.executeOnExecutor(this.h, null);
  }
  
  private void e()
  {
    CaptureTask localCaptureTask = this.g;
    if (localCaptureTask != null) {
      localCaptureTask.cancel(true);
    }
    this.g = null;
  }
  
  public void a()
  {
    ICaptureProxy localICaptureProxy = this.a;
    if (localICaptureProxy != null) {
      localICaptureProxy.c();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.b == paramInt) {
      return;
    }
    this.b = paramInt;
    this.a.a(paramInt, this);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  public void a(CaptureTask.OnCaptureCallback paramOnCaptureCallback)
  {
    this.f = paramOnCaptureCallback;
  }
  
  public void a(String paramString, ViewGroup paramViewGroup, CapturePreparedListener paramCapturePreparedListener)
  {
    this.c = paramString;
    this.a.a(paramString, paramViewGroup);
    this.a.a(paramCapturePreparedListener);
    this.a.a(this);
  }
  
  public void b()
  {
    ICaptureProxy localICaptureProxy = this.a;
    if (localICaptureProxy != null) {
      localICaptureProxy.d();
    }
  }
  
  public void c()
  {
    this.f = null;
    e();
    this.a.a();
  }
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture.CandidateCaptureManager
 * JD-Core Version:    0.7.0.1
 */