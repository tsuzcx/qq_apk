package com.tencent.mobileqq.nearby.profilecard;

import android.widget.TextView;
import com.tencent.mobileqq.widget.BounceScrollView;

class NearbyProfileEditTribePanel$8
  implements Runnable
{
  NearbyProfileEditTribePanel$8(NearbyProfileEditTribePanel paramNearbyProfileEditTribePanel) {}
  
  public void run()
  {
    int i = this.this$0.y.getTop();
    int j = (int)(this.this$0.A.mDensity * 20.0F);
    this.this$0.z.smoothScrollTo(0, i - j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel.8
 * JD-Core Version:    0.7.0.1
 */