package com.tencent.mobileqq.profile.vote;

import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.nearby.INearbyLikeLimitManager.onDoVoteListener;
import com.tencent.mobileqq.nearby.api.INearbyLikeLimitManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;

class VoteHelper$2
  implements INearbyLikeLimitManager.onDoVoteListener
{
  VoteHelper$2(VoteHelper paramVoteHelper, CardProfile paramCardProfile, ImageView paramImageView) {}
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper.a(this.jdField_a_of_type_ComTencentMobileqqDataCardProfile, this.jdField_a_of_type_AndroidWidgetImageView, paramBoolean);
    INearbyLikeLimitManagerUtil localINearbyLikeLimitManagerUtil = (INearbyLikeLimitManagerUtil)QRoute.api(INearbyLikeLimitManagerUtil.class);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper.a;
    String str1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataCardProfile.type == 3) {
      str1 = "1";
    } else {
      str1 = "2";
    }
    String str2;
    if (paramBoolean) {
      str2 = "2";
    } else {
      str2 = "1";
    }
    localINearbyLikeLimitManagerUtil.report(localQQAppInterface, "detail_like", paramString, str1, "", "", str2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.vote.VoteHelper.2
 * JD-Core Version:    0.7.0.1
 */