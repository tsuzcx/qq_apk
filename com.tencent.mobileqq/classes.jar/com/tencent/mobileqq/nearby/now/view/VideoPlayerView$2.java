package com.tencent.mobileqq.nearby.now.view;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.nearby.now.view.player.IVideoView;
import com.tencent.qphone.base.util.QLog;

class VideoPlayerView$2
  extends Handler
{
  VideoPlayerView$2(VideoPlayerView paramVideoPlayerView, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 2025)
    {
      if (i != 2026) {
        return;
      }
      if ((this.a.ivCover != null) && (this.a.ivCover.getParent() != null) && (((ViewGroup)this.a.ivCover.getParent()).getChildAt(0) != this.a.ivCover))
      {
        if (QLog.isColorLevel())
        {
          paramMessage = new StringBuilder();
          paramMessage.append("UPDATE_COVER  mPlayer.getCurrentPosition()=");
          paramMessage.append(this.a.mPlayer.d());
          QLog.i("VideoPlayerView", 2, paramMessage.toString());
        }
        ((ViewGroup)this.a.ivCover.getParent()).removeView(this.a.ivCover);
        VideoPlayerView.access$100(this.a).addView(this.a.ivCover, 0, new RelativeLayout.LayoutParams(-1, -1));
        VideoPlayerView.access$100(this.a).requestLayout();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayerView", 2, "UPDATE_COVER  2do nothing()=");
      }
    }
    else
    {
      if (this.a.mPlayer != null)
      {
        i = this.a.mPlayer.h();
        ((IVideoPlayerView.VideoInfoListener)this.a.mVideoInfoListener).onPlayProgress(i);
        if (QLog.isColorLevel())
        {
          paramMessage = new StringBuilder();
          paramMessage.append("PROGRESS_MSG :");
          paramMessage.append(i);
          QLog.d("VideoPlayerView", 2, paramMessage.toString());
        }
      }
      this.a.mHandler.sendEmptyMessageDelayed(2025, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.VideoPlayerView.2
 * JD-Core Version:    0.7.0.1
 */