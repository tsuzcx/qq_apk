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
    if (paramBoolean1)
    {
      NearbyMomentFragment.b(this.a, paramBoolean2);
      if (paramBoolean2) {
        NearbyMomentFragment.a(this.a).setText(HardCodeUtil.a(2131707252));
      }
      NearbyMomentFragment.a(this.a, paramInt);
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramList = NearbyMomentFragment.a(this.a, paramList);
        NearbyMomentFragment.a(this.a).addAll(paramList);
        NearbyMomentFragment.a(this.a).b(paramList);
        NearbyMomentFragment.a(this.a, paramList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment.3
 * JD-Core Version:    0.7.0.1
 */