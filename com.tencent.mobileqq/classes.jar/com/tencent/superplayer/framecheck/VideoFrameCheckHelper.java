package com.tencent.superplayer.framecheck;

import android.graphics.Bitmap;
import android.view.TextureView;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.view.ISPlayerVideoView;

public class VideoFrameCheckHelper
  implements IFrameCaptureTaskRunner, IVideoFrameCheckHelper
{
  private static final String TAG = "VideoFrameCheckHelper";
  private VideoFrameCaptureTask mFirstFrameCaptureTask;
  private FrameComparePipeLine.OnVideoFrameCheckListener mOnVideoFrameCheckListener;
  private FrameComparePipeLine mPipeLine = new FrameComparePipeLine();
  private TextureView mTextureView;
  
  private void stopTaskWhenTextureViewNotAvailable()
  {
    FrameComparePipeLine.OnVideoFrameCheckListener localOnVideoFrameCheckListener = this.mOnVideoFrameCheckListener;
    if (localOnVideoFrameCheckListener != null)
    {
      TextureView localTextureView = this.mTextureView;
      if (localTextureView == null) {
        localOnVideoFrameCheckListener.onVideoFrameCheckResult(4);
      } else if (!localTextureView.isAvailable()) {
        this.mOnVideoFrameCheckListener.onVideoFrameCheckResult(5);
      }
    }
    this.mPipeLine.stop();
  }
  
  public Bitmap doCapture(int paramInt1, int paramInt2)
  {
    TextureView localTextureView = this.mTextureView;
    if ((localTextureView != null) && (localTextureView.isAvailable()))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        return this.mTextureView.getBitmap();
      }
      return this.mTextureView.getBitmap(paramInt1, paramInt2);
    }
    stopTaskWhenTextureViewNotAvailable();
    return null;
  }
  
  public void onFirstFrameRendered()
  {
    this.mFirstFrameCaptureTask = new FirstFrameCaptureTask(this);
    this.mPipeLine.addTask(this.mFirstFrameCaptureTask);
  }
  
  public void onPlayerRelease()
  {
    this.mPipeLine.release();
  }
  
  public void onPlayerReset()
  {
    onPlayerStop();
  }
  
  public void onPlayerStart()
  {
    TextureView localTextureView = this.mTextureView;
    if (localTextureView == null) {
      LogUtil.e("VideoFrameCheckHelper", "onPlayerStart but mTextureView is null");
    } else if (!localTextureView.isAvailable()) {
      LogUtil.e("VideoFrameCheckHelper", "onPlayerStart but mTextureView is not available");
    }
    this.mPipeLine.addTask(new VideoFrameCaptureTask(this));
    this.mPipeLine.addTask(new VideoFrameCaptureTask(this, true));
    this.mPipeLine.start();
  }
  
  public void onPlayerStop()
  {
    this.mPipeLine.reset();
    this.mPipeLine.stop();
  }
  
  public void setOnVideoFrameCheckListener(FrameComparePipeLine.OnVideoFrameCheckListener paramOnVideoFrameCheckListener)
  {
    this.mOnVideoFrameCheckListener = paramOnVideoFrameCheckListener;
    this.mPipeLine.setOnVideoFrameCheckListener(paramOnVideoFrameCheckListener);
  }
  
  public void updatePlayerVideoView(ISPlayerVideoView paramISPlayerVideoView)
  {
    if (paramISPlayerVideoView == null)
    {
      this.mTextureView = null;
      LogUtil.e("VideoFrameCheckHelper", "updatePlayerVideoView to null.");
      return;
    }
    if ((paramISPlayerVideoView.getRenderView() instanceof TextureView))
    {
      this.mTextureView = ((TextureView)paramISPlayerVideoView.getRenderView());
      return;
    }
    LogUtil.w("VideoFrameCheckHelper", "getTextureView failed...");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.framecheck.VideoFrameCheckHelper
 * JD-Core Version:    0.7.0.1
 */