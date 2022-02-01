package com.tencent.mobileqq.nearby.profilecard;

import android.widget.TextView;
import com.tencent.mobileqq.widget.BounceScrollView;

class NearbyProfileEditPanel$11
  implements Runnable
{
  NearbyProfileEditPanel$11(NearbyProfileEditPanel paramNearbyProfileEditPanel) {}
  
  public void run()
  {
    int i = this.this$0.B.getTop();
    int j = (int)(this.this$0.F.mDensity * 20.0F);
    this.this$0.C.smoothScrollTo(0, i - j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.11
 * JD-Core Version:    0.7.0.1
 */