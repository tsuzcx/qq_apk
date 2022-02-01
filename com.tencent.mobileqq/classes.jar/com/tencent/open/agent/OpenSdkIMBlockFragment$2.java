package com.tencent.open.agent;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class OpenSdkIMBlockFragment$2
  implements View.OnClickListener
{
  OpenSdkIMBlockFragment$2(OpenSdkIMBlockFragment paramOpenSdkIMBlockFragment) {}
  
  public void onClick(View paramView)
  {
    AuthReporter.a(OpenSdkIMBlockFragment.a(this.a), "0X800B65B");
    OpenSdkIMBlockFragment.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.OpenSdkIMBlockFragment.2
 * JD-Core Version:    0.7.0.1
 */