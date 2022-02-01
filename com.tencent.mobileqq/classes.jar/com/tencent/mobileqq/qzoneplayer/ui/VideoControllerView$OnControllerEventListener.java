package com.tencent.mobileqq.qzoneplayer.ui;

import android.view.View;

public abstract interface VideoControllerView$OnControllerEventListener
{
  public abstract void onControllerHide(View paramView);
  
  public abstract void onGestureMoveDown();
  
  public abstract void onGestureMoveRight();
  
  public abstract void onGestureMoveUp();
  
  public abstract void onRequestOriginalVideo();
  
  public abstract void onRequestPauseVideo();
  
  public abstract void onRequestPlayVideo();
  
  public abstract void onRequestToggleFullscreen(View paramView, boolean paramBoolean);
  
  public abstract void onRequestToggleLandscape(View paramView, boolean paramBoolean);
  
  public abstract void onRequsetJumpAdvUrl();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.OnControllerEventListener
 * JD-Core Version:    0.7.0.1
 */