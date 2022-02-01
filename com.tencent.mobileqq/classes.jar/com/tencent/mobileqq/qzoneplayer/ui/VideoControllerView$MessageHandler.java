package com.tencent.mobileqq.qzoneplayer.ui;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.oskplayer.util.PlayerUtils;
import java.lang.ref.WeakReference;

class VideoControllerView$MessageHandler
  extends Handler
{
  private final WeakReference<VideoControllerView> mView;
  
  VideoControllerView$MessageHandler(Looper paramLooper, VideoControllerView paramVideoControllerView)
  {
    super(paramLooper);
    this.mView = new WeakReference(paramVideoControllerView);
  }
  
  public void handleMessage(Message paramMessage)
  {
    VideoControllerView localVideoControllerView = (VideoControllerView)this.mView.get();
    if (localVideoControllerView != null)
    {
      if (localVideoControllerView.mPlayer == null) {
        return;
      }
      int i = paramMessage.what;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return;
          }
          VideoControllerView.access$500(localVideoControllerView);
          return;
        }
        if (!localVideoControllerView.mPlayer.isPlayComplete())
        {
          i = VideoControllerView.access$500(localVideoControllerView);
          if ((!VideoControllerView.access$300(localVideoControllerView)) && (localVideoControllerView.getParent() != null) && ((localVideoControllerView.mShowing) || (localVideoControllerView.getVisibility() == 0)))
          {
            removeMessages(2);
            sendMessageDelayed(obtainMessage(2), 1000 - i % 1000);
          }
        }
        else
        {
          i = localVideoControllerView.mPlayer.getDuration();
          if (i > 0) {
            localVideoControllerView.mVideoDuration = i;
          }
          localVideoControllerView.setProgress(localVideoControllerView.mVideoDuration);
        }
      }
      else
      {
        PlayerUtils.runOnUiThread(new VideoControllerView.MessageHandler.1(this, localVideoControllerView));
      }
    }
  }
  
  public boolean sendMessageAtTime(Message paramMessage, long paramLong)
  {
    VideoControllerView localVideoControllerView = (VideoControllerView)this.mView.get();
    if ((localVideoControllerView != null) && (localVideoControllerView.mPlayer != null)) {
      return super.sendMessageAtTime(paramMessage, paramLong);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MessageHandler
 * JD-Core Version:    0.7.0.1
 */