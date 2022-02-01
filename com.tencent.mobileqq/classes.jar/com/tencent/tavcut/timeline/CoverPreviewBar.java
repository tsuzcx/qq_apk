package com.tencent.tavcut.timeline;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.tavcut.player.MoviePlayer;
import com.tencent.tavcut.view.TAVCutVideoView;

public class CoverPreviewBar
  extends FrameLayout
{
  public static final int ALL = 0;
  private static final String TAG = "CoverPreviewBar";
  public static final int TOP = 1;
  Bitmap currCover = null;
  private ImageView ivCover;
  private int mLeftEdge = 0;
  private int mLeftSpace;
  private CoverPreviewBar.OnPreviewBarSlideListener mOnSliderSlideListener;
  private float mProgress;
  private int mRightEdge = getContext().getResources().getDisplayMetrics().widthPixels;
  private int mTimeLineLength;
  private int mTouchDownX;
  private int mWidth;
  
  public CoverPreviewBar(Context paramContext)
  {
    super(paramContext);
    initViews();
  }
  
  public CoverPreviewBar(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initViews();
  }
  
  public CoverPreviewBar(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initViews();
  }
  
  private float calculateProgress(int paramInt)
  {
    return (paramInt - this.mLeftEdge) * 1.0F / (this.mRightEdge - this.mLeftEdge);
  }
  
  private void extractBitmapFromPlayer(MoviePlayer paramMoviePlayer)
  {
    Bitmap localBitmap = paramMoviePlayer.getTextureView().getBitmap();
    if (paramMoviePlayer.getPlayerLayout().getStickerContainer() != null)
    {
      int i = paramMoviePlayer.getPlayerLayout().getStickerContainer().getWidth();
      int j = paramMoviePlayer.getPlayerLayout().getStickerContainer().getHeight();
      paramMoviePlayer = Bitmap.createBitmap(localBitmap, (paramMoviePlayer.getPlayerLayout().getWidth() - i) / 2, (paramMoviePlayer.getPlayerLayout().getHeight() - j) / 2, i, j);
      this.currCover = paramMoviePlayer;
      setImageBitmap(paramMoviePlayer);
      return;
    }
    this.currCover = localBitmap;
    setImageBitmap(localBitmap);
  }
  
  private void initInternalParams()
  {
    this.mLeftEdge = this.mLeftSpace;
    this.mWidth = getMeasuredWidth();
    this.mRightEdge = (this.mLeftEdge + this.mTimeLineLength - this.mWidth);
    moveSliderToPosition(calculateTransXByProgress(this.mProgress));
  }
  
  private void initViews()
  {
    this.ivCover = new ImageView(getContext());
    addView(this.ivCover, -1, -1);
  }
  
  private void updateSliderPosition(int paramInt)
  {
    Log.d("CoverPreviewBar", "updateSliderPosition: leftEdge = " + this.mLeftEdge + " | rightEdge = " + this.mRightEdge);
    int i;
    if (paramInt < this.mLeftEdge) {
      i = this.mLeftEdge;
    }
    for (;;)
    {
      this.mProgress = (calculateProgress(i) * 100.0F);
      if (this.mOnSliderSlideListener != null) {
        this.mOnSliderSlideListener.onProgressChanged(this, this.mProgress, i);
      }
      setTranslationX(i);
      return;
      i = paramInt;
      if (paramInt > this.mRightEdge) {
        i = this.mRightEdge;
      }
    }
  }
  
  public void bindPlayer(MoviePlayer paramMoviePlayer)
  {
    paramMoviePlayer.addPlayerListener(new CoverPreviewBar.2(this, paramMoviePlayer));
    paramMoviePlayer.addTextureChangeListener(new CoverPreviewBar.3(this, paramMoviePlayer));
  }
  
  public int calculateTransXByProgress(float paramFloat)
  {
    return (int)(paramFloat / 100.0F * (this.mRightEdge - this.mLeftEdge) + this.mLeftEdge);
  }
  
  public Bitmap getCurrCover()
  {
    return this.currCover;
  }
  
  public float getProgress()
  {
    return this.mProgress;
  }
  
  public void initCoverSlider(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    this.mLeftSpace = paramInt1;
    this.mTimeLineLength = paramInt3;
    this.mProgress = paramFloat;
    post(new CoverPreviewBar.1(this));
  }
  
  public void moveSliderToPosition(int paramInt)
  {
    updateSliderPosition(paramInt);
    if (this.mOnSliderSlideListener != null) {
      this.mOnSliderSlideListener.onStopTouchSlide(this);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      this.mTouchDownX = ((int)paramMotionEvent.getRawX());
      return true;
      this.mTouchDownX = ((int)paramMotionEvent.getRawX());
      if (this.mOnSliderSlideListener != null)
      {
        this.mOnSliderSlideListener.onStartTouchSlide(this);
        continue;
        updateSliderPosition((int)((int)(paramMotionEvent.getRawX() - this.mTouchDownX) + getTranslationX()));
        continue;
        if (this.mOnSliderSlideListener != null) {
          this.mOnSliderSlideListener.onStopTouchSlide(this);
        }
      }
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    if (this.ivCover != null) {
      this.ivCover.setImageBitmap(paramBitmap);
    }
  }
  
  public void setOnSliderSlideListener(CoverPreviewBar.OnPreviewBarSlideListener paramOnPreviewBarSlideListener)
  {
    this.mOnSliderSlideListener = paramOnPreviewBarSlideListener;
  }
  
  public void setPreviewBarView(ImageView paramImageView)
  {
    removeView(this.ivCover);
    this.ivCover = paramImageView;
    addView(this.ivCover, -1, -1);
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (this.ivCover != null) {
      this.ivCover.setScaleType(paramScaleType);
    }
  }
  
  public void updateProgress(float paramFloat)
  {
    this.mProgress = paramFloat;
    moveSliderToPosition(calculateTransXByProgress(this.mProgress));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.timeline.CoverPreviewBar
 * JD-Core Version:    0.7.0.1
 */