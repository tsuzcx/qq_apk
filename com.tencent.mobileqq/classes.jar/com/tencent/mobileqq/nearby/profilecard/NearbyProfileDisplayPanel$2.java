package com.tencent.mobileqq.nearby.profilecard;

import android.view.View;
import android.view.View.OnClickListener;

class NearbyProfileDisplayPanel$2
  implements View.OnClickListener
{
  NearbyProfileDisplayPanel$2(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.e.onBackEvent())
    {
      this.a.e.finish();
      this.a.e.notifyWebViewIfNeeded(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.2
 * JD-Core Version:    0.7.0.1
 */