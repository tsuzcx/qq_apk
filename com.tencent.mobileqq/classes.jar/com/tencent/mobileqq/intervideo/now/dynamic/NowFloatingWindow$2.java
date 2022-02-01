package com.tencent.mobileqq.intervideo.now.dynamic;

import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener;
import com.tencent.qphone.base.util.QLog;

class NowFloatingWindow$2
  implements IVideoInnerStatusListener
{
  public void notifyVideoClose(int paramInt)
  {
    QLog.i("NowFloatingWindow", 1, "FloatingVideoListener -- notifyVideoClose closeReason=" + paramInt);
    if ((this.a.a != null) && (paramInt == 1)) {
      this.a.a.b();
    }
  }
  
  public void notifyVideoSeek(int paramInt)
  {
    QLog.i("NowFloatingWindow", 1, "FloatingVideoListener -- notifyVideoSeek seek=" + paramInt);
  }
  
  public void notifyVideoStart()
  {
    QLog.i("NowFloatingWindow", 1, "FloatingVideoListener -- notifyVideoStart ");
  }
  
  public void notifyVideoStop()
  {
    QLog.i("NowFloatingWindow", 1, "FloatingVideoListener -- notifyVideoStop ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.NowFloatingWindow.2
 * JD-Core Version:    0.7.0.1
 */