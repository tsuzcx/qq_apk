package com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture;

import android.view.ViewGroup;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;

public abstract interface ICaptureProxy
{
  public abstract void a();
  
  public abstract void a(int paramInt, ISuperPlayer.OnSeekCompleteListener paramOnSeekCompleteListener);
  
  public abstract void a(CapturePreparedListener paramCapturePreparedListener);
  
  public abstract void a(CaptureTask paramCaptureTask, CaptureTask.OnCaptureCallback paramOnCaptureCallback);
  
  public abstract void a(String paramString, ViewGroup paramViewGroup);
  
  public abstract long b();
  
  public abstract void c();
  
  public abstract void d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture.ICaptureProxy
 * JD-Core Version:    0.7.0.1
 */