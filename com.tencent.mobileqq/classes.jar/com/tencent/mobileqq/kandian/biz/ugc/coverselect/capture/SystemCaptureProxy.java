package com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import mqq.os.MqqHandler;

public class SystemCaptureProxy
  implements ICaptureProxy
{
  private MediaMetadataRetriever a = new MediaMetadataRetriever();
  private SparseArray<CaptureTask.OnCaptureCallback> b = new SparseArray();
  private Set<CapturePreparedListener> c = new HashSet();
  private String d;
  private int e;
  private int f;
  private int g;
  private volatile boolean h = true;
  private volatile boolean i;
  
  private int a(int paramInt)
  {
    return Integer.parseInt(this.a.extractMetadata(paramInt));
  }
  
  private Bitmap a(MediaMetadataRetriever paramMediaMetadataRetriever, CaptureTask paramCaptureTask)
  {
    try
    {
      paramMediaMetadataRetriever = paramMediaMetadataRetriever.getFrameAtTime(paramCaptureTask.d * 1000, 0);
      return paramMediaMetadataRetriever;
    }
    catch (Throwable paramMediaMetadataRetriever)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFrameAtTime failed for captureTask");
      localStringBuilder.append(paramCaptureTask.d);
      QLog.e("SystemCaptureProxy", 1, localStringBuilder.toString(), paramMediaMetadataRetriever);
    }
    return null;
  }
  
  private void e()
  {
    try
    {
      QLog.d("SystemCaptureProxy", 1, "prepare...");
      this.a.setDataSource(this.d);
      QLog.d("SystemCaptureProxy", 1, "prepare after...");
      this.e = a(9);
      this.f = a(18);
      this.g = a(19);
      ThreadManager.getUIHandler().post(new SystemCaptureProxy.3(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private void f()
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      CapturePreparedListener localCapturePreparedListener = (CapturePreparedListener)localIterator.next();
      if (localCapturePreparedListener != null) {
        localCapturePreparedListener.a(this.f, this.g, this.e);
      }
    }
  }
  
  public void a()
  {
    this.i = true;
    MediaMetadataRetriever localMediaMetadataRetriever = this.a;
    if (localMediaMetadataRetriever != null) {
      localMediaMetadataRetriever.release();
    }
  }
  
  public void a(int paramInt, ISuperPlayer.OnSeekCompleteListener paramOnSeekCompleteListener) {}
  
  public void a(CapturePreparedListener paramCapturePreparedListener)
  {
    this.c.add(paramCapturePreparedListener);
  }
  
  public void a(CaptureTask paramCaptureTask, CaptureTask.OnCaptureCallback paramOnCaptureCallback)
  {
    try
    {
      ThreadManager.excute(new SystemCaptureProxy.2(this, paramCaptureTask, paramOnCaptureCallback), 16, null, true);
      return;
    }
    finally
    {
      paramCaptureTask = finally;
      throw paramCaptureTask;
    }
  }
  
  public void a(String paramString, ViewGroup paramViewGroup)
  {
    this.d = paramString;
    QLog.d("SystemCaptureProxy", 1, "prepare before...");
    ThreadManager.excute(new SystemCaptureProxy.1(this), 16, null, true);
  }
  
  public long b()
  {
    return this.e;
  }
  
  public void c() {}
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture.SystemCaptureProxy
 * JD-Core Version:    0.7.0.1
 */