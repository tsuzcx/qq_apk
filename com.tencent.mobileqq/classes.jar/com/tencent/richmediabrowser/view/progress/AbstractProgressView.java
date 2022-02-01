package com.tencent.richmediabrowser.view.progress;

import android.app.Activity;
import com.tencent.richmediabrowser.view.BrowserBaseScene;

public abstract interface AbstractProgressView
{
  public abstract void hide();
  
  public abstract void init(Activity paramActivity, BrowserBaseScene paramBrowserBaseScene);
  
  public abstract boolean isShow();
  
  public abstract boolean isStarted();
  
  public abstract void setProgress(int paramInt);
  
  public abstract void show();
  
  public abstract void start(int paramInt);
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.progress.AbstractProgressView
 * JD-Core Version:    0.7.0.1
 */