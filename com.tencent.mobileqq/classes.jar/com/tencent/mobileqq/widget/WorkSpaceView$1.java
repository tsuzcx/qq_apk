package com.tencent.mobileqq.widget;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.struct.PushBanner;

class WorkSpaceView$1
  extends Handler
{
  WorkSpaceView$1(WorkSpaceView paramWorkSpaceView) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i == 1) {
        WorkSpaceView.a(this.a).removeMessages(0);
      }
    }
    else
    {
      WorkSpaceView localWorkSpaceView = this.a;
      i = ((PushBanner)localWorkSpaceView.getChildAt(localWorkSpaceView.a).getTag()).d;
      if ((this.a.getChildCount() > 1) && (this.a.getWidth() > 0))
      {
        localWorkSpaceView = this.a;
        localWorkSpaceView.a(localWorkSpaceView.getCurrentScreen() + 1);
      }
      WorkSpaceView.a(this.a).sendEmptyMessageDelayed(0, i * 1000);
    }
    super.handleMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.WorkSpaceView.1
 * JD-Core Version:    0.7.0.1
 */