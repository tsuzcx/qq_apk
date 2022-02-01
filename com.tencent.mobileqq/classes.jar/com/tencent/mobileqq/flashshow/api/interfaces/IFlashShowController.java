package com.tencent.mobileqq.flashshow.api.interfaces;

import android.view.View;
import androidx.fragment.app.Fragment;

public abstract interface IFlashShowController
{
  public abstract Fragment getFragmentInstance();
  
  public abstract View getRootView();
  
  public abstract void onAccountChange(boolean paramBoolean);
  
  public abstract boolean onBackPressed();
  
  public abstract void onPageClickSelf();
  
  public abstract void onPageDestroy();
  
  public abstract void onPageSelected();
  
  public abstract void onPageUnSelected();
  
  public abstract void reportFrameExpose(int paramInt);
  
  public abstract void reportFrameTabClick();
  
  public abstract void setTabHeight(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.api.interfaces.IFlashShowController
 * JD-Core Version:    0.7.0.1
 */