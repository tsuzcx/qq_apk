package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.app.Activity;
import android.view.MotionEvent;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public abstract interface PageGestureProxy
{
  public abstract void onActivityCreate(Activity paramActivity);
  
  public abstract void onActivityDestroy(Activity paramActivity);
  
  public abstract void onActivityFinish(Activity paramActivity);
  
  public abstract void onActivityPause(Activity paramActivity);
  
  public abstract void onActivityResume(Activity paramActivity);
  
  public abstract void onActivityStop(Activity paramActivity);
  
  public abstract void onCreateMiniAppInfo(MiniAppInfo paramMiniAppInfo);
  
  public abstract void onLoadUrl(IMiniAppContext paramIMiniAppContext);
  
  public abstract void onMoveTaskToBack(Activity paramActivity);
  
  public abstract void onPageWebViewInit();
  
  public abstract void onProcessTouchEvent(MotionEvent paramMotionEvent);
  
  public abstract boolean onViewReleasedAndNeedScrollOriginPosition(MotionEvent paramMotionEvent);
  
  public abstract void updateColorSignPath(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy
 * JD-Core Version:    0.7.0.1
 */