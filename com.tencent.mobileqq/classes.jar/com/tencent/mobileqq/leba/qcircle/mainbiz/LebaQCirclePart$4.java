package com.tencent.mobileqq.leba.qcircle.mainbiz;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ViewSwitcher.ViewFactory;
import com.tencent.mobileqq.app.QBaseActivity;

class LebaQCirclePart$4
  implements ViewSwitcher.ViewFactory
{
  LebaQCirclePart$4(LebaQCirclePart paramLebaQCirclePart, QBaseActivity paramQBaseActivity) {}
  
  public View makeView()
  {
    ImageView localImageView = new ImageView(this.a);
    localImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    return localImageView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.qcircle.mainbiz.LebaQCirclePart.4
 * JD-Core Version:    0.7.0.1
 */