package com.tencent.mobileqq.intervideo.now.dynamic;

import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener;
import com.tencent.qphone.base.util.QLog;

class NowFloatingWindow$2
  implements IVideoInnerStatusListener
{
  public void notifyVideoClose(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FloatingVideoListener -- notifyVideoClose closeReason=");
    localStringBuilder.append(paramInt);
    QLog.i("NowFloatingWindow", 1, localStringBuilder.toString());
    if ((this.a.a != null) && (paramInt == 1)) {
      this.a.a.b();
    }
  }
  
  public void notifyVideoSeek(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FloatingVideoListener -- notifyVideoSeek seek=");
    localStringBuilder.append(paramInt);
    QLog.i("NowFloatingWindow", 1, localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.NowFloatingWindow.2
 * JD-Core Version:    0.7.0.1
 */