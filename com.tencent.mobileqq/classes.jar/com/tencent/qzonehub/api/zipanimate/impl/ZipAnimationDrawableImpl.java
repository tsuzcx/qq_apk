package com.tencent.qzonehub.api.zipanimate.impl;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import androidx.lifecycle.Lifecycle;
import com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable;
import cooperation.qzone.zipanimate.OnAnimationListener;
import cooperation.qzone.zipanimate.ZipAnimationDrawable;
import cooperation.qzone.zipanimate.ZipFrameLoadedListener;

public class ZipAnimationDrawableImpl
  implements IZipAnimationDrawable
{
  public void bindLifeCycle(Drawable paramDrawable, Lifecycle paramLifecycle)
  {
    ((ZipAnimationDrawable)paramDrawable).bindLifeCycle(paramLifecycle);
  }
  
  public void clearFirstFrame(Drawable paramDrawable)
  {
    ((ZipAnimationDrawable)paramDrawable).clearFirstFrame();
  }
  
  public String getAnimationResZipUrl(Drawable paramDrawable)
  {
    return ((ZipAnimationDrawable)paramDrawable).getAnimationResZipUrl();
  }
  
  public int getDuration(Drawable paramDrawable)
  {
    return ((ZipAnimationDrawable)paramDrawable).getDuration();
  }
  
  public int getNumberOfFrames(Drawable paramDrawable)
  {
    return ((ZipAnimationDrawable)paramDrawable).getNumberOfFrames();
  }
  
  public Drawable getZipAnimationDrawable()
  {
    return new ZipAnimationDrawable();
  }
  
  public Drawable getZipAnimationDrawable(String paramString, int paramInt)
  {
    return new ZipAnimationDrawable(paramString, paramInt);
  }
  
  public boolean hasDownloadComplete(Drawable paramDrawable)
  {
    return ((ZipAnimationDrawable)paramDrawable).hasDownloadComplete();
  }
  
  public boolean isOneShot(Drawable paramDrawable)
  {
    return ((ZipAnimationDrawable)paramDrawable).isOneShot();
  }
  
  public boolean isRunning(Drawable paramDrawable)
  {
    return ((ZipAnimationDrawable)paramDrawable).isRunning();
  }
  
  public boolean isZipAnimationDrawable(Animatable paramAnimatable)
  {
    return paramAnimatable instanceof ZipAnimationDrawable;
  }
  
  public boolean isZipDrawableShow(Drawable paramDrawable)
  {
    return ((ZipAnimationDrawable)paramDrawable).isZipDrawableShow();
  }
  
  public void loadAndShowFirstFrame(Drawable paramDrawable)
  {
    ((ZipAnimationDrawable)paramDrawable).loadAndShowFirstFrame();
  }
  
  public void preLoadFrame(Drawable paramDrawable, int paramInt)
  {
    ((ZipAnimationDrawable)paramDrawable).preLoadFrame(paramInt);
  }
  
  public void release(Animatable paramAnimatable)
  {
    ((ZipAnimationDrawable)paramAnimatable).release();
  }
  
  public void release(Drawable paramDrawable)
  {
    ((ZipAnimationDrawable)paramDrawable).release();
  }
  
  public void restartAnimation(Drawable paramDrawable)
  {
    ((ZipAnimationDrawable)paramDrawable).restartAnimation();
  }
  
  public void setAnimationListener(Drawable paramDrawable, OnAnimationListener paramOnAnimationListener)
  {
    ((ZipAnimationDrawable)paramDrawable).setAnimationListener(paramOnAnimationListener);
  }
  
  public void setAnimationRes(Drawable paramDrawable, String paramString, int paramInt)
  {
    ((ZipAnimationDrawable)paramDrawable).setAnimationRes(paramString, paramInt);
  }
  
  public void setDrawableLoadedListener(Drawable paramDrawable, ZipFrameLoadedListener paramZipFrameLoadedListener)
  {
    ((ZipAnimationDrawable)paramDrawable).setDrawableLoadedListener(paramZipFrameLoadedListener);
  }
  
  public void setIsShowFirstFrame(Drawable paramDrawable, boolean paramBoolean)
  {
    ((ZipAnimationDrawable)paramDrawable).setIsShowFirstFrame(paramBoolean);
  }
  
  public void setOneShot(Drawable paramDrawable, boolean paramBoolean)
  {
    ((ZipAnimationDrawable)paramDrawable).setOneShot(paramBoolean);
  }
  
  public void setPreloadNum(Drawable paramDrawable, int paramInt)
  {
    ((ZipAnimationDrawable)paramDrawable).setPreloadNum(paramInt);
  }
  
  public void setRepeatAnimation(Drawable paramDrawable, boolean paramBoolean)
  {
    ((ZipAnimationDrawable)paramDrawable).setRepeatAnimation(paramBoolean);
  }
  
  public void setScale(Drawable paramDrawable, float paramFloat)
  {
    ((ZipAnimationDrawable)paramDrawable).setScale(paramFloat);
  }
  
  public void setShowLastFrameWhenStop(Drawable paramDrawable, boolean paramBoolean)
  {
    ((ZipAnimationDrawable)paramDrawable).setShowLastFrameWhenStop(paramBoolean);
  }
  
  public void start(Drawable paramDrawable)
  {
    ((ZipAnimationDrawable)paramDrawable).start();
  }
  
  public void stop(Drawable paramDrawable)
  {
    ((ZipAnimationDrawable)paramDrawable).stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qzonehub.api.zipanimate.impl.ZipAnimationDrawableImpl
 * JD-Core Version:    0.7.0.1
 */