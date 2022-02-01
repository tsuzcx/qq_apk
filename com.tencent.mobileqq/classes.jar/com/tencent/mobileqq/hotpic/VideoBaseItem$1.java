package com.tencent.mobileqq.hotpic;

import android.view.SurfaceHolder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase.IVideoViewCallBack;

class VideoBaseItem$1
  implements IVideoViewBase.IVideoViewCallBack
{
  VideoBaseItem$1(VideoBaseItem paramVideoBaseItem) {}
  
  public void onSurfaceChanged(SurfaceHolder paramSurfaceHolder)
  {
    paramSurfaceHolder = new StringBuilder();
    paramSurfaceHolder.append("key:");
    paramSurfaceHolder.append(this.a.b);
    paramSurfaceHolder.append(";broad finish start show here onsurface changed  here");
    QLog.d("VideoBaseItem", 2, paramSurfaceHolder.toString());
  }
  
  public void onSurfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    paramSurfaceHolder = new StringBuilder();
    paramSurfaceHolder.append("key:");
    paramSurfaceHolder.append(this.a.b);
    paramSurfaceHolder.append("; broad finish start show here onsurface create ok here");
    QLog.d("VideoBaseItem", 2, paramSurfaceHolder.toString());
  }
  
  public void onSurfaceDestory(SurfaceHolder paramSurfaceHolder)
  {
    this.a.a = true;
    paramSurfaceHolder = new StringBuilder();
    paramSurfaceHolder.append("key:");
    paramSurfaceHolder.append(this.a.b);
    paramSurfaceHolder.append("; broad finish start show here onsurface Destroy  here");
    QLog.d("VideoBaseItem", 2, paramSurfaceHolder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.VideoBaseItem.1
 * JD-Core Version:    0.7.0.1
 */