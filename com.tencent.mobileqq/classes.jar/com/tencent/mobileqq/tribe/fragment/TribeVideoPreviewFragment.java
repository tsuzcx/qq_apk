package com.tencent.mobileqq.tribe.fragment;

import aiet;
import aieu;
import aiev;
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
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;

public class TribeVideoPreviewFragment
  extends PublicBaseFragment
{
  private TextureVideoView a;
  
  public void a(Activity paramActivity)
  {
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().setFlags(1024, 1024);
    super.a(paramActivity);
  }
  
  public void a(String paramString)
  {
    ThreadManager.post(new aiev(this, paramString), 5, null, true);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130971597, paramViewGroup, false);
    this.a = ((TextureVideoView)paramLayoutInflater.findViewById(2131375073));
    paramViewGroup = paramLayoutInflater.findViewById(2131375074);
    paramBundle = (ImageButton)paramLayoutInflater.findViewById(2131375075);
    String str = getActivity().getIntent().getStringExtra("path");
    this.a.setVideoPath(str);
    this.a.setLooping(true);
    this.a.setCenterInside(true);
    paramLayoutInflater.setOnTouchListener(new aiet(this));
    this.a.start();
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setStartOffset(3000L);
    paramViewGroup.startAnimation(localAlphaAnimation);
    paramBundle.setOnClickListener(new aieu(this, str));
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.a.a();
  }
  
  public void u_()
  {
    super.u_();
    getActivity().overridePendingTransition(0, 2131034404);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoPreviewFragment
 * JD-Core Version:    0.7.0.1
 */