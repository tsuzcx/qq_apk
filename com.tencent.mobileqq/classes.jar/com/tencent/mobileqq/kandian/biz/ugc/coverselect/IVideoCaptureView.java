package com.tencent.mobileqq.kandian.biz.ugc.coverselect;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture.CaptureTask;
import java.util.List;

public abstract interface IVideoCaptureView
  extends ImageUpdateListener
{
  public abstract int a();
  
  public abstract void a(float paramFloat, boolean paramBoolean);
  
  public abstract void a(int paramInt);
  
  public abstract void a(long paramLong);
  
  public abstract void a(Bitmap paramBitmap);
  
  public abstract void a(List<CaptureTask> paramList);
  
  public abstract int b();
  
  public abstract void b(long paramLong);
  
  public abstract void b(List<CaptureTask> paramList);
  
  public abstract ViewGroup c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.coverselect.IVideoCaptureView
 * JD-Core Version:    0.7.0.1
 */