package com.tencent.mobileqq.emotionintegrate;

import ajjy;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import anmo;
import anmp;
import awqx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
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
  
  protected void a(View paramView)
  {
    paramView.setFitsSystemWindows(true);
    TextView localTextView = (TextView)paramView.findViewById(2131302804);
    localTextView.setText(ajjy.a(2131634227));
    localTextView.setOnClickListener(new anmo(this));
    if (a())
    {
      paramView = (ImageView)paramView.findViewById(2131302816);
      paramView.setImageResource(2130837729);
      paramView.setVisibility(0);
      paramView.setContentDescription(ajjy.a(2131634226));
      paramView.setOnClickListener(new anmp(this));
    }
  }
  
  public void a(String paramString)
  {
    awqx.b(null, "dc00898", "", "", paramString, paramString, this.jdField_a_of_type_Int, 0, "", "", "", "");
  }
  
  public boolean a()
  {
    return true;
  }
  
  protected abstract void b(View paramView);
  
  protected abstract void c(int paramInt);
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.AIOEmotionBaseFragment
 * JD-Core Version:    0.7.0.1
 */