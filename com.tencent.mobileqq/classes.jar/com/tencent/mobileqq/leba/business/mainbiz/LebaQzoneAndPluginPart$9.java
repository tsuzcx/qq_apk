package com.tencent.mobileqq.leba.business.mainbiz;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ViewSwitcher.ViewFactory;
import com.tencent.mobileqq.app.QBaseActivity;

class LebaQzoneAndPluginPart$9
  implements ViewSwitcher.ViewFactory
{
  LebaQzoneAndPluginPart$9(LebaQzoneAndPluginPart paramLebaQzoneAndPluginPart, QBaseActivity paramQBaseActivity) {}
  
  public View makeView()
  {
    ImageView localImageView = new ImageView(this.a);
    localImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    return localImageView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart.9
 * JD-Core Version:    0.7.0.1
 */