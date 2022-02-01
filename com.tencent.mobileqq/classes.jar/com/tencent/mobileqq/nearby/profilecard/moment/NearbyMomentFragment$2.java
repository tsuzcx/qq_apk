package com.tencent.mobileqq.nearby.profilecard.moment;

import com.tencent.mobileqq.nearby.profilecard.moment.data.MomentFeedInfo;
import java.util.List;

class NearbyMomentFragment$2
  implements NearbyMomentManager.GetMomentListCallback
{
  NearbyMomentFragment$2(NearbyMomentFragment paramNearbyMomentFragment, NearbyMomentFragment.RefreshCallback paramRefreshCallback) {}
  
  public void a(boolean paramBoolean1, List<MomentFeedInfo> paramList, boolean paramBoolean2, int paramInt)
  {
    NearbyMomentFragment.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment).clear();
    NearbyMomentFragment.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment).addAll(paramList);
    NearbyMomentFragment.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment, paramList);
    NearbyMomentFragment.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment, paramBoolean1, paramBoolean2, paramInt, paramList, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment$RefreshCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment.2
 * JD-Core Version:    0.7.0.1
 */