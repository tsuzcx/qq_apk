package com.tencent.mobileqq.editor.composite.step;

import android.graphics.Bitmap;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.HWEncodeListener;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.HWVideoRecorder;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MuiltiImageToVideo$1
  implements HWEncodeListener
{
  public long a;
  
  MuiltiImageToVideo$1(MuiltiImageToVideo paramMuiltiImageToVideo, List paramList, VideoStoryPicToVideo.ConvertListener paramConvertListener, VideoStoryPicToVideo.RetCode paramRetCode) {}
  
  private boolean a()
  {
    int i;
    if (MuiltiImageToVideo.d(this.e).size() == 1)
    {
      i = 0;
    }
    else
    {
      int j = (int)(MuiltiImageToVideo.g(this.e) / (Long.valueOf("2").longValue() * 1000L * 1000000L));
      i = j;
      if (j >= MuiltiImageToVideo.d(this.e).size()) {
        return false;
      }
    }
    long l = MuiltiImageToVideo.h(this.e) * 1000000;
    if ((MuiltiImageToVideo.e(this.e) != null) && (((Integer)MuiltiImageToVideo.d(this.e).get(i)).intValue() > 0) && (MuiltiImageToVideo.g(this.e) < MuiltiImageToVideo.i(this.e) * 1000000L))
    {
      MuiltiImageToVideo.e(this.e).a(3553, ((Integer)MuiltiImageToVideo.d(this.e).get(0)).intValue(), null, null, MuiltiImageToVideo.g(this.e));
      MuiltiImageToVideo localMuiltiImageToVideo = this.e;
      MuiltiImageToVideo.a(localMuiltiImageToVideo, MuiltiImageToVideo.g(localMuiltiImageToVideo) + l);
      return true;
    }
    return false;
  }
  
  public void onEncodeError(int paramInt, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("onEncodeError, code:");
      ((StringBuilder)???).append(paramInt);
      QLog.e("MuiltiImageToVideo", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.e)
    {
      this.e.notifyAll();
      if (this.c != null)
      {
        this.d.a(paramThrowable.getMessage());
        this.d.a(943001);
        this.c.b(this.d);
      }
      return;
    }
  }
  
  public void onEncodeFinish(String arg1)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ???.append("onEncodeStart encode cost: ");
      ???.append(l - this.a);
      ???.append(" ms mGpuBlur:");
      ???.append(MuiltiImageToVideo.a(this.e));
      QLog.d("MuiltiImageToVideo", 2, ???.toString());
    }
    ??? = this.c;
    if (??? != null) {
      ???.a(this.d);
    }
    if (MuiltiImageToVideo.f(this.e) != null)
    {
      MuiltiImageToVideo.f(this.e).surfaceDestroyed();
      MuiltiImageToVideo.a(this.e, null);
    }
    if (MuiltiImageToVideo.e(this.e) != null)
    {
      MuiltiImageToVideo.e(this.e).e();
      MuiltiImageToVideo.a(this.e, null);
    }
    if (MuiltiImageToVideo.d(this.e) != null) {
      MuiltiImageToVideo.d(this.e).clear();
    }
    synchronized (this.e)
    {
      this.e.notifyAll();
      return;
    }
  }
  
  public void onEncodeFrame()
  {
    QLog.d("MuiltiImageToVideo", 2, "onEncodeFrame() ");
    if ((!a()) && (MuiltiImageToVideo.e(this.e) != null)) {
      MuiltiImageToVideo.e(this.e).b();
    }
  }
  
  public void onEncodeStart()
  {
    long l1 = System.currentTimeMillis();
    Object localObject = this.b.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Bitmap localBitmap = (Bitmap)((Iterator)localObject).next();
      MuiltiImageToVideo localMuiltiImageToVideo;
      int i;
      if (!MuiltiImageToVideo.a(this.e))
      {
        localMuiltiImageToVideo = this.e;
        i = MuiltiImageToVideo.a(localMuiltiImageToVideo, localBitmap, MuiltiImageToVideo.b(localMuiltiImageToVideo), MuiltiImageToVideo.c(this.e));
      }
      else
      {
        localMuiltiImageToVideo = this.e;
        i = MuiltiImageToVideo.b(localMuiltiImageToVideo, localBitmap, MuiltiImageToVideo.b(localMuiltiImageToVideo), MuiltiImageToVideo.c(this.e));
      }
      MuiltiImageToVideo.d(this.e).add(Integer.valueOf(i));
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onEncodeStart preProcess cost: ");
      ((StringBuilder)localObject).append(l2 - l1);
      ((StringBuilder)localObject).append(" ms mGpuBlur:");
      ((StringBuilder)localObject).append(MuiltiImageToVideo.a(this.e));
      QLog.d("MuiltiImageToVideo", 2, ((StringBuilder)localObject).toString());
    }
    this.a = System.currentTimeMillis();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.editor.composite.step.MuiltiImageToVideo.1
 * JD-Core Version:    0.7.0.1
 */