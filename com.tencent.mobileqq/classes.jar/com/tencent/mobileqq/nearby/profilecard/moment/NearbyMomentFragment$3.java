package com.tencent.mobileqq.nearby.profilecard.moment;

import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.nearby.profilecard.moment.data.MomentFeedInfo;
import java.util.List;

class NearbyMomentFragment$3
  implements NearbyMomentManager.GetMomentListCallback
{
  NearbyMomentFragment$3(NearbyMomentFragment paramNearbyMomentFragment) {}
  
  public void a(boolean paramBoolean1, List<MomentFeedInfo> paramList, boolean paramBoolean2, int paramInt)
  {
    NearbyMomentFragment.a(this.a, false);
    NearbyMomentFragment.c(this.a).setText(HardCodeUtil.a(2131905079));
    if (paramBoolean1)
    {
      NearbyMomentFragment.b(this.a, paramBoolean2);
      NearbyMomentFragment.a(this.a, paramInt);
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramList = NearbyMomentFragment.b(this.a, paramList);
        NearbyMomentFragment.a(this.a, paramList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment.3
 * JD-Core Version:    0.7.0.1
 */