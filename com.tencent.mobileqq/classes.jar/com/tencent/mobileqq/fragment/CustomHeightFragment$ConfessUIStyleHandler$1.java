package com.tencent.mobileqq.fragment;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CustomHeightFragment$ConfessUIStyleHandler$1
  implements View.OnClickListener
{
  CustomHeightFragment$ConfessUIStyleHandler$1(CustomHeightFragment.ConfessUIStyleHandler paramConfessUIStyleHandler) {}
  
  public void onClick(View paramView)
  {
    this.a.a.getHostActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.CustomHeightFragment.ConfessUIStyleHandler.1
 * JD-Core Version:    0.7.0.1
 */