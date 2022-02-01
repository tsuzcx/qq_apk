package com.tencent.mobileqq.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SDKSetEmotionPreviewFragment$PreviewGridAdapter$1
  implements View.OnClickListener
{
  SDKSetEmotionPreviewFragment$PreviewGridAdapter$1(SDKSetEmotionPreviewFragment.PreviewGridAdapter paramPreviewGridAdapter, String paramString, View paramView) {}
  
  public void onClick(View paramView)
  {
    SDKSetEmotionPreviewFragment.a(this.a, this.c.c.getBaseActivity(), this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.SDKSetEmotionPreviewFragment.PreviewGridAdapter.1
 * JD-Core Version:    0.7.0.1
 */