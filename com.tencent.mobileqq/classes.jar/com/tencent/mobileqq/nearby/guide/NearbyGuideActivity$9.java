package com.tencent.mobileqq.nearby.guide;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

class NearbyGuideActivity$9
  implements View.OnClickListener
{
  NearbyGuideActivity$9(NearbyGuideActivity paramNearbyGuideActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.mPromptDialog != null) && (!this.a.isFinishing()))
    {
      this.a.mPromptDialog.dismiss();
      paramView = this.a;
      paramView.mPromptDialog = null;
      paramView.doClickReport("0X800590A");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.guide.NearbyGuideActivity.9
 * JD-Core Version:    0.7.0.1
 */