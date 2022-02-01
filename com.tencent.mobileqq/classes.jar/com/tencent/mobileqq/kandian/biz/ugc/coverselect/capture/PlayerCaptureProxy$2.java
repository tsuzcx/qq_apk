package com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import java.util.Iterator;
import java.util.Set;

class PlayerCaptureProxy$2
  implements Runnable
{
  PlayerCaptureProxy$2(PlayerCaptureProxy paramPlayerCaptureProxy) {}
  
  public void run()
  {
    if (PlayerCaptureProxy.a(this.this$0) == null)
    {
      QLog.e("PlayerCaptureProxy", 1, "onPreviewVideoPrepared error for player is null");
      return;
    }
    PlayerCaptureProxy.a(this.this$0, true);
    int m = PlayerCaptureProxy.a(this.this$0).getVideoWidth();
    int n = PlayerCaptureProxy.a(this.this$0).getVideoHeight();
    long l = PlayerCaptureProxy.a(this.this$0).getDurationMs();
    int i1 = PlayerCaptureProxy.a(this.this$0).getVideoRotation();
    int k = DisplayUtil.a(BaseApplicationImpl.getContext()).a();
    int j = m;
    int i = n;
    if (m > k)
    {
      float f = m / k;
      i = (int)(n / f);
      j = k;
    }
    if (i1 != 90)
    {
      m = j;
      k = i;
      if (i1 != 270) {}
    }
    else
    {
      k = j;
      m = i;
    }
    Iterator localIterator = PlayerCaptureProxy.b(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      CapturePreparedListener localCapturePreparedListener = (CapturePreparedListener)localIterator.next();
      if (localCapturePreparedListener != null) {
        localCapturePreparedListener.a(m, k, l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture.PlayerCaptureProxy.2
 * JD-Core Version:    0.7.0.1
 */