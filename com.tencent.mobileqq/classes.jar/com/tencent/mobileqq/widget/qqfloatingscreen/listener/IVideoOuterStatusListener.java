package com.tencent.mobileqq.widget.qqfloatingscreen.listener;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public abstract interface IVideoOuterStatusListener
{
  public abstract void onOrientationChange(boolean paramBoolean);
  
  public abstract void onSetVideoCover(Bitmap paramBitmap);
  
  public abstract void onSetVideoCover(Drawable paramDrawable);
  
  public abstract void onVideoBuffering();
  
  public abstract void onVideoComplete(boolean paramBoolean);
  
  public abstract void onVideoError(int paramInt);
  
  public abstract void onVideoProgressUpdate(int paramInt);
  
  public abstract void onVideoSize(int paramInt1, int paramInt2);
  
  public abstract void onVideoStart(int paramInt);
  
  public abstract void onVideoStop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener
 * JD-Core Version:    0.7.0.1
 */