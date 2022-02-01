package com.tencent.mobileqq.nearby.profilecard;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.profile.like.PraiseInfo;
import com.tencent.mobileqq.profile.like.PraiseManager.OnPraiseLoadListener;
import java.util.List;

class NearbyCardVoteView$2
  implements PraiseManager.OnPraiseLoadListener
{
  NearbyCardVoteView$2(NearbyCardVoteView paramNearbyCardVoteView, int paramInt1, int paramInt2, List paramList) {}
  
  public void a(int paramInt1, PraiseInfo paramPraiseInfo, int paramInt2, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.a.hasMessages(NearbyCardVoteView.d))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.a.removeMessages(NearbyCardVoteView.d);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.a.obtainMessage(NearbyCardVoteView.d, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaUtilList).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyCardVoteView.2
 * JD-Core Version:    0.7.0.1
 */