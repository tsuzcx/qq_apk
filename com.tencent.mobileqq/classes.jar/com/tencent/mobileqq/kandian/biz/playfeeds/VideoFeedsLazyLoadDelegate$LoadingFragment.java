package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.BaseFragment;

public class VideoFeedsLazyLoadDelegate$LoadingFragment
  extends BaseFragment
{
  private VideoFeedsLazyLoadDelegate a;
  
  public static LoadingFragment a(VideoFeedsLazyLoadDelegate paramVideoFeedsLazyLoadDelegate)
  {
    LoadingFragment localLoadingFragment = new LoadingFragment();
    localLoadingFragment.a = paramVideoFeedsLazyLoadDelegate;
    return localLoadingFragment;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return this.a.a(paramLayoutInflater, paramViewGroup, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsLazyLoadDelegate.LoadingFragment
 * JD-Core Version:    0.7.0.1
 */