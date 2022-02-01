package com.tencent.mobileqq.emotionintegrate;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import anzj;
import asto;
import astp;
import bdll;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import mqq.app.AppRuntime;

public abstract class AIOEmotionBaseFragment
  extends PublicBaseFragment
{
  protected int a;
  public Context a;
  protected View a;
  
  public abstract View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup);
  
  public QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public abstract void a();
  
  protected abstract void a(int paramInt, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem);
  
  protected void a(View paramView)
  {
    paramView.setFitsSystemWindows(true);
    TextView localTextView = (TextView)paramView.findViewById(2131369042);
    localTextView.setText(anzj.a(2131698940));
    localTextView.setOnClickListener(new asto(this));
    if (a())
    {
      paramView = (ImageView)paramView.findViewById(2131369056);
      paramView.setImageResource(2130838040);
      paramView.setVisibility(0);
      paramView.setContentDescription(anzj.a(2131698939));
      paramView.setOnClickListener(new astp(this));
    }
  }
  
  public void a(String paramString)
  {
    bdll.b(null, "dc00898", "", "", paramString, paramString, this.jdField_a_of_type_Int, 0, "", "", "", "");
  }
  
  public boolean a()
  {
    return true;
  }
  
  protected abstract void b(View paramView);
  
  public boolean needImmersive()
  {
    return true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    a("0X800997D");
    paramLayoutInflater = a(paramLayoutInflater, paramViewGroup);
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater;
    this.jdField_a_of_type_AndroidContentContext = getActivity();
    a(paramLayoutInflater);
    b(paramLayoutInflater);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.AIOEmotionBaseFragment
 * JD-Core Version:    0.7.0.1
 */