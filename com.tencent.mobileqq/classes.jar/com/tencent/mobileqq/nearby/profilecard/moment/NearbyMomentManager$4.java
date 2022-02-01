package com.tencent.mobileqq.nearby.profilecard.moment;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.pb.now.ilive_feeds_read.FeedsInfo;
import java.util.List;

class NearbyMomentManager$4
  implements NearbyMomentProtocol.GetMomentListCallback
{
  NearbyMomentManager$4(NearbyMomentManager paramNearbyMomentManager, NearbyMomentManager.GetMomentListCallback paramGetMomentListCallback) {}
  
  public void a(boolean paramBoolean1, List<ilive_feeds_read.FeedsInfo> paramList, boolean paramBoolean2, int paramInt)
  {
    ThreadManager.post(new NearbyMomentManager.4.1(this, paramList, paramBoolean1, paramBoolean2, paramInt), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.4
 * JD-Core Version:    0.7.0.1
 */