package com.tencent.mobileqq.tribe.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import baph;
import bapi;
import bfea;
import bfeb;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import mqq.os.MqqHandler;

public class TribeVideoPreviewFragment
  extends PublicBaseFragment
{
  private BaseVideoView a;
  
  private void a(View paramView)
  {
    paramView = paramView.findViewById(2131379310);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setStartOffset(3000L);
    paramView.startAnimation(localAlphaAnimation);
  }
  
  private void a(View paramView, String paramString)
  {
    paramView = (RelativeLayout)paramView.findViewById(2131380935);
    VideoPlayParam localVideoPlayParam = new VideoPlayParam();
    localVideoPlayParam.mVideoPath = paramString;
    localVideoPlayParam.mIsLocal = true;
    localVideoPlayParam.mIsLoop = true;
    localVideoPlayParam.mSceneId = 111;
    localVideoPlayParam.mSceneName = bapi.a(111);
    this.a = ((BaseVideoView)baph.b(paramView.getContext(), 0L, localVideoPlayParam, null));
    paramString = new RelativeLayout.LayoutParams(-1, -1);
    this.a.setLayoutParams(paramString);
    paramView.addView(this.a, 0);
    this.a.play();
  }
  
  private void a(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new TribeVideoPreviewFragment.3(this, paramBoolean));
  }
  
  private void b(View paramView, String paramString)
  {
    ((ImageButton)paramView.findViewById(2131377007)).setOnClickListener(new bfeb(this, paramString));
  }
  
  public void a(String paramString)
  {
    ThreadManager.post(new TribeVideoPreviewFragment.4(this, paramString), 5, null, true);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().setFlags(1024, 1024);
    super.initWindowStyleAndAnimation(paramActivity);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131563007, paramViewGroup, false);
    paramViewGroup = getActivity().getIntent().getStringExtra("path");
    a(paramLayoutInflater, paramViewGroup);
    a(paramLayoutInflater);
    b(paramLayoutInflater, paramViewGroup);
    paramLayoutInflater.setOnTouchListener(new bfea(this));
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    this.a = null;
    super.onDestroy();
  }
  
  public void onFinish()
  {
    super.onFinish();
    getActivity().overridePendingTransition(0, 2130772332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoPreviewFragment
 * JD-Core Version:    0.7.0.1
 */