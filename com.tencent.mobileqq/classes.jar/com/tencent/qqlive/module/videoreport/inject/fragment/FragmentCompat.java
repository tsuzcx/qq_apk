package com.tencent.qqlive.module.videoreport.inject.fragment;

import android.app.Activity;
import android.view.View;

public class FragmentCompat
{
  private Activity mActivity;
  private View mView;
  
  public Activity getActivity()
  {
    return this.mActivity;
  }
  
  public View getView()
  {
    return this.mView;
  }
  
  public void setActivity(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  public void setView(View paramView)
  {
    this.mView = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCompat
 * JD-Core Version:    0.7.0.1
 */