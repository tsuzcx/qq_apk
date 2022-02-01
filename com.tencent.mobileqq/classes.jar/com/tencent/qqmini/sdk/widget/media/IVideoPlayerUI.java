package com.tencent.qqmini.sdk.widget.media;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.widget.VideoGestureRelativeLayout.VideoGestureListener;

public abstract interface IVideoPlayerUI
{
  public abstract void changeState();
  
  public abstract void fullScreen(MiniAppVideoConfig paramMiniAppVideoConfig, IMiniAppContext paramIMiniAppContext, boolean paramBoolean, String paramString);
  
  public abstract MiniAppVideoController getController();
  
  public abstract int getGestureProgress();
  
  public abstract boolean getIsBarrageOn();
  
  public abstract int getPlayerViewHeight();
  
  public abstract int getPlayerViewWidth();
  
  public abstract int getStatusImgVisibility();
  
  public abstract FrameLayout getUI();
  
  public abstract void hideControllerPopContainer();
  
  public abstract void hideLoadingView();
  
  public abstract void hidePlayerStatusImg();
  
  public abstract void hideVideoPosterImg();
  
  public abstract void onBrightnessGesture(MiniAppVideoConfig paramMiniAppVideoConfig, MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2);
  
  public abstract void onCaptureImageSucceed(Canvas paramCanvas);
  
  public abstract void onDoubleTapGesture(MiniAppVideoConfig paramMiniAppVideoConfig, boolean paramBoolean);
  
  public abstract void onDown(int paramInt1, int paramInt2);
  
  public abstract void onEndFF_REW(MotionEvent paramMotionEvent);
  
  public abstract void onProgressChanged(String paramString);
  
  public abstract void onProgressGesture(MiniAppVideoConfig paramMiniAppVideoConfig, MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2);
  
  public abstract void onSingleTapGesture(MiniAppVideoConfig paramMiniAppVideoConfig, MotionEvent paramMotionEvent);
  
  public abstract void onStartTrackingTouch(MiniAppVideoConfig paramMiniAppVideoConfig);
  
  public abstract void onStopTrackingTouch(MiniAppVideoConfig paramMiniAppVideoConfig);
  
  public abstract void onVolumeGesture(MiniAppVideoConfig paramMiniAppVideoConfig, MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2, int paramInt, AudioManager paramAudioManager);
  
  public abstract void performClickControlBtn();
  
  public abstract void release();
  
  public abstract void resetBarrageDrawable(MiniAppVideoConfig paramMiniAppVideoConfig);
  
  public abstract void resetControlIvDrawable(boolean paramBoolean);
  
  public abstract void resetMuteImage(MiniAppVideoConfig paramMiniAppVideoConfig, boolean paramBoolean);
  
  public abstract void resetWindowIvDrawable(MiniAppVideoConfig paramMiniAppVideoConfig);
  
  public abstract void setController(MiniAppVideoController paramMiniAppVideoController);
  
  public abstract void setPoster(Bitmap paramBitmap);
  
  public abstract void setPoster(Drawable paramDrawable);
  
  public abstract void setProgressByPlayingTime(long paramLong1, long paramLong2);
  
  public abstract void setSeekBarGone();
  
  public abstract void setSeekBarInvisible();
  
  public abstract void setSeekBarVisible();
  
  public abstract void setUpUI(View.OnClickListener paramOnClickListener, VideoGestureRelativeLayout.VideoGestureListener paramVideoGestureListener, SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener);
  
  public abstract void setUpVideoView(View paramView, MiniAppVideoConfig paramMiniAppVideoConfig);
  
  public abstract void showBarrageNextTime(String paramString, int paramInt);
  
  public abstract void showLoadingView();
  
  public abstract void showPopCtrViewNoAutoHide(MiniAppVideoConfig paramMiniAppVideoConfig);
  
  public abstract void showPopCtrViewThenAutoHide(MiniAppVideoConfig paramMiniAppVideoConfig);
  
  public abstract void smallScreen(IMiniAppContext paramIMiniAppContext, MiniAppVideoConfig paramMiniAppVideoConfig);
  
  public abstract void updateCenterBtn(MiniAppVideoConfig paramMiniAppVideoConfig);
  
  public abstract void updateControllerView(MiniAppVideoConfig paramMiniAppVideoConfig);
  
  public abstract void updateDanmuTime(long paramLong);
  
  public abstract void updateDanmuView(MiniAppVideoConfig paramMiniAppVideoConfig);
  
  public abstract void updatePlayingTime(String paramString);
  
  public abstract void updatePopCtrView(MiniAppVideoConfig paramMiniAppVideoConfig, boolean paramBoolean);
  
  public abstract void updateTotalTimeText(String paramString);
  
  public abstract void updateVideoGestureSetting(MiniAppVideoConfig paramMiniAppVideoConfig);
  
  public abstract void updateVideoPosition(MiniAppVideoConfig paramMiniAppVideoConfig, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
 * JD-Core Version:    0.7.0.1
 */