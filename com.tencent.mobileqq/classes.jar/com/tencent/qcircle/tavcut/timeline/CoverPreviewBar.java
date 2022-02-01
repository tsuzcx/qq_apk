package com.tencent.qcircle.tavcut.timeline;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.TextureView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.qcircle.tavcut.player.MoviePlayer;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tavkit.composition.TAVComposition;

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
    int i = this.mLeftEdge;
    return (paramInt - i) * 1.0F / (this.mRightEdge - i);
  }
  
  private void extractBitmapFromPlayer(MoviePlayer paramMoviePlayer)
  {
    Bitmap localBitmap = paramMoviePlayer.getTextureView().getBitmap();
    if (paramMoviePlayer.getTavComposition() != null)
    {
      paramMoviePlayer = paramMoviePlayer.getTavComposition().getRenderSize();
      float f = paramMoviePlayer.height / paramMoviePlayer.width;
      if (f > localBitmap.getHeight() / localBitmap.getWidth())
      {
        i = (int)(localBitmap.getHeight() / f);
        j = localBitmap.getHeight();
        paramMoviePlayer = Bitmap.createBitmap(localBitmap, (localBitmap.getWidth() - i) / 2, 0, i, j);
        this.currCover = paramMoviePlayer;
        setImageBitmap(paramMoviePlayer);
        return;
      }
      int i = (int)(localBitmap.getWidth() * f);
      int j = localBitmap.getWidth();
      paramMoviePlayer = Bitmap.createBitmap(localBitmap, 0, (localBitmap.getHeight() - i) / 2, j, i);
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateSliderPosition: leftEdge = ");
    ((StringBuilder)localObject).append(this.mLeftEdge);
    ((StringBuilder)localObject).append(" | rightEdge = ");
    ((StringBuilder)localObject).append(this.mRightEdge);
    Log.d("CoverPreviewBar", ((StringBuilder)localObject).toString());
    int i = this.mLeftEdge;
    if (paramInt < i)
    {
      paramInt = i;
    }
    else
    {
      i = this.mRightEdge;
      if (paramInt > i) {
        paramInt = i;
      }
    }
    this.mProgress = (calculateProgress(paramInt) * 100.0F);
    localObject = this.mOnSliderSlideListener;
    if (localObject != null) {
      ((CoverPreviewBar.OnPreviewBarSlideListener)localObject).onProgressChanged(this, this.mProgress, paramInt);
    }
    setTranslationX(paramInt);
  }
  
  public void bindPlayer(MoviePlayer paramMoviePlayer)
  {
    paramMoviePlayer.addPlayerListener(new CoverPreviewBar.2(this, paramMoviePlayer));
    paramMoviePlayer.addTextureChangeListener(new CoverPreviewBar.3(this, paramMoviePlayer));
  }
  
  public int calculateTransXByProgress(float paramFloat)
  {
    paramFloat /= 100.0F;
    int i = this.mRightEdge;
    int j = this.mLeftEdge;
    return (int)(paramFloat * (i - j) + j);
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
    CoverPreviewBar.OnPreviewBarSlideListener localOnPreviewBarSlideListener = this.mOnSliderSlideListener;
    if (localOnPreviewBarSlideListener != null) {
      localOnPreviewBarSlideListener.onStopTouchSlide(this);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    CoverPreviewBar.OnPreviewBarSlideListener localOnPreviewBarSlideListener;
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            break label96;
          }
        }
        else
        {
          updateSliderPosition((int)((int)(paramMotionEvent.getRawX() - this.mTouchDownX) + getTranslationX()));
          break label96;
        }
      }
      localOnPreviewBarSlideListener = this.mOnSliderSlideListener;
      if (localOnPreviewBarSlideListener != null) {
        localOnPreviewBarSlideListener.onStopTouchSlide(this);
      }
    }
    else
    {
      this.mTouchDownX = ((int)paramMotionEvent.getRawX());
      localOnPreviewBarSlideListener = this.mOnSliderSlideListener;
      if (localOnPreviewBarSlideListener != null) {
        localOnPreviewBarSlideListener.onStartTouchSlide(this);
      }
    }
    label96:
    this.mTouchDownX = ((int)paramMotionEvent.getRawX());
    return true;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    ImageView localImageView = this.ivCover;
    if (localImageView != null) {
      localImageView.setImageBitmap(paramBitmap);
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
    ImageView localImageView = this.ivCover;
    if (localImageView != null) {
      localImageView.setScaleType(paramScaleType);
    }
  }
  
  public void updateProgress(float paramFloat)
  {
    this.mProgress = paramFloat;
    moveSliderToPosition(calculateTransXByProgress(this.mProgress));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.timeline.CoverPreviewBar
 * JD-Core Version:    0.7.0.1
 */