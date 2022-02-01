package com.tencent.mobileqq.nearby.guide;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NearbyGuideActivity$9
  implements View.OnClickListener
{
  NearbyGuideActivity$9(NearbyGuideActivity paramNearbyGuideActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a != null) && (!this.a.isFinishing()))
    {
      this.a.a.dismiss();
      this.a.a = null;
      this.a.e("0X800590A");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.guide.NearbyGuideActivity.9
 * JD-Core Version:    0.7.0.1
 */