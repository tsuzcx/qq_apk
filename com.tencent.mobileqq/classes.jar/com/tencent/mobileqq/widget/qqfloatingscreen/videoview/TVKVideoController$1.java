package com.tencent.mobileqq.widget.qqfloatingscreen.videoview;

import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qphone.base.util.QLog;

class TVKVideoController$1
  implements IVideoInnerStatusListener
{
  TVKVideoController$1(TVKVideoController paramTVKVideoController) {}
  
  public void notifyVideoClose(int paramInt)
  {
    this.a.b();
  }
  
  public void notifyVideoSeek(int paramInt)
  {
    if (TVKVideoController.c(this.a) != null)
    {
      double d1 = paramInt;
      double d2 = TVKVideoController.c(this.a).getVideoDurationMs();
      Double.isNaN(d1);
      Double.isNaN(d2);
      int i = (int)(d1 * d2 / 100.0D);
      TVKVideoController.a(this.a, i);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mOuterStatusListener notifyVideoSeek : ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("  seekMillSec :");
        localStringBuilder.append(i);
        QLog.d("TVKVideoController", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void notifyVideoStart()
  {
    TVKVideoController.a(this.a);
  }
  
  public void notifyVideoStop()
  {
    TVKVideoController.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.videoview.TVKVideoController.1
 * JD-Core Version:    0.7.0.1
 */