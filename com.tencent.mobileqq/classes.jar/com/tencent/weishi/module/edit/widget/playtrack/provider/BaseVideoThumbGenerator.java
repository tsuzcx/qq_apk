package com.tencent.weishi.module.edit.widget.playtrack.provider;

import com.tencent.tav.coremedia.CMTime;

public abstract class BaseVideoThumbGenerator
{
  protected float mCoverHeight;
  protected float mCoverWidth;
  protected RunnableHandler mGenerateHandler;
  protected VideoThumbListener mVideoThumbListener;
  
  public abstract void generateCoverByTime(CMTime paramCMTime);
  
  public abstract void pause();
  
  public abstract void release();
  
  public abstract void resume();
  
  public void setCoverHeight(float paramFloat)
  {
    this.mCoverHeight = paramFloat;
  }
  
  public void setCoverWidth(float paramFloat)
  {
    this.mCoverWidth = paramFloat;
  }
  
  public void setGenerateHandler(RunnableHandler paramRunnableHandler)
  {
    this.mGenerateHandler = paramRunnableHandler;
  }
  
  public void setVideoThumbListener(VideoThumbListener paramVideoThumbListener)
  {
    this.mVideoThumbListener = paramVideoThumbListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weishi.module.edit.widget.playtrack.provider.BaseVideoThumbGenerator
 * JD-Core Version:    0.7.0.1
 */