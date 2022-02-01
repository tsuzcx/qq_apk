package com.tencent.mobileqq.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VipVideoPlayActivity$1
  implements View.OnClickListener
{
  VipVideoPlayActivity$1(VipVideoPlayActivity paramVipVideoPlayActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.getRequestedOrientation() == 0)
    {
      this.a.setRequestedOrientation(1);
    }
    else
    {
      this.a.setResult(0);
      this.a.finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.video.VipVideoPlayActivity.1
 * JD-Core Version:    0.7.0.1
 */