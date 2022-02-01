package com.tencent.mobileqq.profilesetting;

import com.tencent.mobileqq.mutualmark.MutualMarkDataCenter;
import com.tencent.mobileqq.profilecard.data.AllInOne;

class ProfileCardMoreActivity$1
  implements Runnable
{
  ProfileCardMoreActivity$1(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  public void run()
  {
    this.this$0.h();
    ProfileCardMoreActivity localProfileCardMoreActivity = this.this$0;
    localProfileCardMoreActivity.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(MutualMarkDataCenter.a(localProfileCardMoreActivity.app, this.this$0.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin, true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.1
 * JD-Core Version:    0.7.0.1
 */