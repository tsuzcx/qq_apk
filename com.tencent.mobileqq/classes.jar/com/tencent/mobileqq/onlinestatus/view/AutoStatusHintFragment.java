package com.tencent.mobileqq.onlinestatus.view;

import aeow;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import azcl;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;

public class AutoStatusHintFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private Button a;
  
  public static void a(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.setClass(paramContext, PublicTransFragmentActivity.class);
    localIntent.putExtra("public_fragment_class", AutoStatusHintFragment.class.getName());
    aeow.a(localIntent, PublicTransFragmentActivity.class, AutoStatusHintFragment.class);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().setSoftInputMode(3);
    paramActivity.overridePendingTransition(2130771986, 2130771985);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      azcl.a("0X800B0F4");
      getActivity().finish();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = paramLayoutInflater.inflate(2131558417, null);
    paramLayoutInflater.setOnClickListener(this);
    this.a = ((Button)paramLayoutInflater.findViewById(2131373062));
    this.a.setOnClickListener(this);
    azcl.a("0X800B0F3");
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onFinish()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.overridePendingTransition(2130771986, 2130771985);
    }
    super.onFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.AutoStatusHintFragment
 * JD-Core Version:    0.7.0.1
 */