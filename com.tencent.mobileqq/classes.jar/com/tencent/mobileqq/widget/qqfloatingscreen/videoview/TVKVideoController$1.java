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
    if (TVKVideoController.a(this.a) != null)
    {
      int i = (int)(paramInt * TVKVideoController.a(this.a).getVideoDurationMs() / 100.0D);
      TVKVideoController.a(this.a, i);
      if (QLog.isColorLevel()) {
        QLog.d("TVKVideoController", 2, "mOuterStatusListener notifyVideoSeek : " + paramInt + "  seekMillSec :" + i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.videoview.TVKVideoController.1
 * JD-Core Version:    0.7.0.1
 */