package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class VideoFeedsVideoUIDelegate$1
  extends Handler
{
  VideoFeedsVideoUIDelegate$1(VideoFeedsVideoUIDelegate paramVideoFeedsVideoUIDelegate, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != -1) {
      return;
    }
    if (QLog.isColorLevel())
    {
      paramMessage = new StringBuilder();
      paramMessage.append("mUiHandler.postDelayed() innerChangePlayButton(SHOW_LOADING_BTN) mIsNeedShowLoading = ");
      paramMessage.append(VideoFeedsVideoUIDelegate.a(this.a));
      QLog.d("VideoFeedsVideoUIDelegate", 2, paramMessage.toString());
    }
    if (VideoFeedsVideoUIDelegate.a(this.a)) {
      this.a.a(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsVideoUIDelegate.1
 * JD-Core Version:    0.7.0.1
 */