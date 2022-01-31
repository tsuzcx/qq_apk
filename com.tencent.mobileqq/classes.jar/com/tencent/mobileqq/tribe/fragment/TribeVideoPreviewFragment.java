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
import bazu;
import bazv;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import mqq.os.MqqHandler;

public class TribeVideoPreviewFragment
  extends PublicBaseFragment
{
  private TextureVideoView a;
  
  private void a(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new TribeVideoPreviewFragment.3(this, paramBoolean));
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
    paramLayoutInflater = paramLayoutInflater.inflate(2131562716, paramViewGroup, false);
    this.a = ((TextureVideoView)paramLayoutInflater.findViewById(2131378236));
    paramViewGroup = paramLayoutInflater.findViewById(2131378237);
    paramBundle = (ImageButton)paramLayoutInflater.findViewById(2131376055);
    String str = getActivity().getIntent().getStringExtra("path");
    this.a.setVideoPath(str);
    this.a.setLooping(true);
    this.a.setCenterInside(true);
    paramLayoutInflater.setOnTouchListener(new bazu(this));
    this.a.start();
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setStartOffset(3000L);
    paramViewGroup.startAnimation(localAlphaAnimation);
    paramBundle.setOnClickListener(new bazv(this, str));
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.a.a();
  }
  
  public void onFinish()
  {
    super.onFinish();
    getActivity().overridePendingTransition(0, 2130772322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoPreviewFragment
 * JD-Core Version:    0.7.0.1
 */