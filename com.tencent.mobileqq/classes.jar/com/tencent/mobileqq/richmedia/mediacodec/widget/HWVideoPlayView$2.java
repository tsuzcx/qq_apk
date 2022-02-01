package com.tencent.mobileqq.richmedia.mediacodec.widget;

import com.tencent.qphone.base.util.QLog;

class HWVideoPlayView$2
  implements Runnable
{
  HWVideoPlayView$2(HWVideoPlayView paramHWVideoPlayView) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DIDI", 1, "reStartPlaySolveDanceBlackScreen mHaveSurfaceChangedPlayStart=" + this.this$0.c);
    }
    try
    {
      if (!this.this$0.c)
      {
        this.this$0.b();
        if (HWVideoPlayView.a(this.this$0)) {
          this.this$0.c();
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("DIDI", 1, "reStartPlaySolveDanceBlackScreen mHaveSurfaceChangedPlayStart=" + this.this$0.c, localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.widget.HWVideoPlayView.2
 * JD-Core Version:    0.7.0.1
 */