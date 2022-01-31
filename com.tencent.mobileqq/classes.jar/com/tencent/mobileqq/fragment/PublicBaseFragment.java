package com.tencent.mobileqq.fragment;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;

public class PublicBaseFragment
  extends Fragment
{
  public void initWindowStyleAndAnimation(Activity paramActivity) {}
  
  public boolean isSupportScreenShot()
  {
    return true;
  }
  
  public boolean isWrapContent()
  {
    return true;
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
  
  public void onNewIntent(Intent paramIntent) {}
  
  public void onPostThemeChanged() {}
  
  public void onPreThemeChanged() {}
  
  public void onWindowFocusChanged(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.PublicBaseFragment
 * JD-Core Version:    0.7.0.1
 */