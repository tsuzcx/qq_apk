package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.mobileqq.widget.NestViewPager;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class NewNearbyProfileDisplayPanel$selectedTabIndex$1
  implements Runnable
{
  NewNearbyProfileDisplayPanel$selectedTabIndex$1(NewNearbyProfileDisplayPanel paramNewNearbyProfileDisplayPanel, int paramInt) {}
  
  public final void run()
  {
    if (this.a != NewNearbyProfileDisplayPanel.d(this.this$0)) {
      return;
    }
    this.this$0.I.setCurrentItem(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NewNearbyProfileDisplayPanel.selectedTabIndex.1
 * JD-Core Version:    0.7.0.1
 */