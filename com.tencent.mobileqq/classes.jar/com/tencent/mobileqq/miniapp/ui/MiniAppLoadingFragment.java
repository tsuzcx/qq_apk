package com.tencent.mobileqq.miniapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

public class MiniAppLoadingFragment
  extends MiniAppBaseFragment
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131429840) {
      getBaseActivity().finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131624038, paramViewGroup, false);
    paramLayoutInflater.findViewById(2131429840).setOnClickListener(this);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.ui.MiniAppLoadingFragment
 * JD-Core Version:    0.7.0.1
 */