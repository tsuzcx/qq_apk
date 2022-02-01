package com.tencent.qzonehub.api.zipanimate;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import androidx.lifecycle.Lifecycle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qzone.zipanimate.OnAnimationListener;
import cooperation.qzone.zipanimate.ZipFrameLoadedListener;

@QAPI(process={"all"})
public abstract interface IZipAnimationDrawable
  extends QRouteApi
{
  public abstract void bindLifeCycle(Drawable paramDrawable, Lifecycle paramLifecycle);
  
  public abstract void clearFirstFrame(Drawable paramDrawable);
  
  public abstract String getAnimationResZipUrl(Drawable paramDrawable);
  
  public abstract int getDuration(Drawable paramDrawable);
  
  public abstract int getNumberOfFrames(Drawable paramDrawable);
  
  public abstract Drawable getZipAnimationDrawable();
  
  public abstract Drawable getZipAnimationDrawable(String paramString, int paramInt);
  
  public abstract boolean hasDownloadComplete(Drawable paramDrawable);
  
  public abstract boolean isOneShot(Drawable paramDrawable);
  
  public abstract boolean isRunning(Drawable paramDrawable);
  
  public abstract boolean isZipAnimationDrawable(Animatable paramAnimatable);
  
  public abstract boolean isZipDrawableShow(Drawable paramDrawable);
  
  public abstract void loadAndShowFirstFrame(Drawable paramDrawable);
  
  public abstract void preLoadFrame(Drawable paramDrawable, int paramInt);
  
  public abstract void release(Animatable paramAnimatable);
  
  public abstract void release(Drawable paramDrawable);
  
  public abstract void restartAnimation(Drawable paramDrawable);
  
  public abstract void setAnimationListener(Drawable paramDrawable, OnAnimationListener paramOnAnimationListener);
  
  public abstract void setAnimationRes(Drawable paramDrawable, String paramString, int paramInt);
  
  public abstract void setDrawableLoadedListener(Drawable paramDrawable, ZipFrameLoadedListener paramZipFrameLoadedListener);
  
  public abstract void setIsShowFirstFrame(Drawable paramDrawable, boolean paramBoolean);
  
  public abstract void setOneShot(Drawable paramDrawable, boolean paramBoolean);
  
  public abstract void setPreloadNum(Drawable paramDrawable, int paramInt);
  
  public abstract void setRepeatAnimation(Drawable paramDrawable, boolean paramBoolean);
  
  public abstract void setScale(Drawable paramDrawable, float paramFloat);
  
  public abstract void setShowLastFrameWhenStop(Drawable paramDrawable, boolean paramBoolean);
  
  public abstract void start(Drawable paramDrawable);
  
  public abstract void stop(Drawable paramDrawable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */