package com.tencent.mobileqq.qqlive.view;

import android.view.View;
import com.tencent.qphone.base.util.QLog;

class TPPlayerVideoView$7
  implements Runnable
{
  TPPlayerVideoView$7(TPPlayerVideoView paramTPPlayerVideoView) {}
  
  public void run()
  {
    try
    {
      ((View)TPPlayerVideoView.e(this.this$0)).requestLayout();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("TPPlayer[TPPlayerVideoView]", 1, "setDegree error", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.view.TPPlayerVideoView.7
 * JD-Core Version:    0.7.0.1
 */