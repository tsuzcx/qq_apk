package com.tencent.mobileqq.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.app.BaseFragment;

@Deprecated
public class PublicBaseFragment
  extends BaseFragment
{
  public void beforeFinish() {}
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public void initSideFling(Context paramContext, FlingHandler paramFlingHandler) {}
  
  public void initWindowStyleAndAnimation(Activity paramActivity) {}
  
  public boolean isSupportScreenShot()
  {
    return true;
  }
  
  public boolean isWrapContent()
  {
    return true;
  }
  
  public boolean needDispatchTouchEvent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return true;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public void onAccountChanged() {}
  
  public boolean onBackEvent()
  {
    return false;
  }
  
  public void onFinish() {}
  
  public void onMultiWindowModeChanged(boolean paramBoolean) {}
  
  public void onNewIntent(Intent paramIntent) {}
  
  public void onPostThemeChanged() {}
  
  public void onPreThemeChanged() {}
  
  public void onWindowFocusChanged(boolean paramBoolean) {}
  
  public boolean overrideFinish()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.PublicBaseFragment
 * JD-Core Version:    0.7.0.1
 */