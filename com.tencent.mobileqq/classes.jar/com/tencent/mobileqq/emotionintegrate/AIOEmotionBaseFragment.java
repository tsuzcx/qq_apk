package com.tencent.mobileqq.emotionintegrate;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import mqq.app.AppRuntime;

public abstract class AIOEmotionBaseFragment
  extends PublicBaseFragment
{
  protected View a;
  protected Context b;
  protected int c;
  
  public abstract View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup);
  
  protected abstract void a(int paramInt, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem);
  
  protected void a(View paramView)
  {
    paramView.setFitsSystemWindows(true);
    TextView localTextView = (TextView)paramView.findViewById(2131436180);
    localTextView.setText(HardCodeUtil.a(2131901576));
    localTextView.setOnClickListener(new AIOEmotionBaseFragment.1(this));
    if (a())
    {
      paramView = (ImageView)paramView.findViewById(2131436194);
      paramView.setImageResource(2130838021);
      paramView.setVisibility(0);
      paramView.setContentDescription(HardCodeUtil.a(2131898287));
      paramView.setOnClickListener(new AIOEmotionBaseFragment.2(this));
    }
  }
  
  protected void a(String paramString)
  {
    ReportController.b(null, "dc00898", "", "", paramString, paramString, this.c, 0, "", "", "", "");
  }
  
  public boolean a()
  {
    return true;
  }
  
  protected abstract void b();
  
  protected abstract void b(View paramView);
  
  protected QQAppInterface c()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public boolean needImmersive()
  {
    return true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    a("0X800997D");
    paramLayoutInflater = a(paramLayoutInflater, paramViewGroup);
    this.a = paramLayoutInflater;
    this.b = getBaseActivity();
    a(paramLayoutInflater);
    b(paramLayoutInflater);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onPause()
  {
    super.onPause();
    AbstractGifImage.pauseAll();
    ApngImage.pauseByTag(0);
  }
  
  public void onResume()
  {
    super.onResume();
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.AIOEmotionBaseFragment
 * JD-Core Version:    0.7.0.1
 */