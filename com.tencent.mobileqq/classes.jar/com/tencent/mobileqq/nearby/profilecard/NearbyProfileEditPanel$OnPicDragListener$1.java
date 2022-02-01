package com.tencent.mobileqq.nearby.profilecard;

import android.widget.RelativeLayout;

class NearbyProfileEditPanel$OnPicDragListener$1
  implements Runnable
{
  NearbyProfileEditPanel$OnPicDragListener$1(NearbyProfileEditPanel.OnPicDragListener paramOnPicDragListener) {}
  
  public void run()
  {
    if (NearbyProfileEditPanel.h(this.a.a) != null)
    {
      NearbyProfileEditPanel.h(this.a.a).setVisibility(0);
      this.a.a.m();
      NearbyProfileEditPanel.a(this.a.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.OnPicDragListener.1
 * JD-Core Version:    0.7.0.1
 */