package com.tencent.mobileqq.nearby.profilecard;

import bhhu;
import bhnv;
import bhsr;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.qphone.base.util.BaseApplication;

class NearbyPeopleProfileActivity$3
  implements Runnable
{
  NearbyPeopleProfileActivity$3(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void run()
  {
    if ((!bhnv.d(BaseApplication.getContext())) && (this.this$0.k)) {}
    byte[] arrayOfByte;
    long l;
    do
    {
      do
      {
        return;
      } while (NearbyPeopleProfileActivity.a(this.this$0) == null);
      arrayOfByte = NearbyPeopleProfileActivity.a(this.this$0).vSeed;
      l = NearbyPeopleProfileActivity.a(this.this$0).feedPreviewTime;
      if (this.this$0.jdField_a_of_type_Long > 0L)
      {
        bhhu.a(this.this$0.jdField_a_of_type_Axxj, this.this$0.app, this.this$0.jdField_a_of_type_Long, null, this.this$0.d, arrayOfByte, l, true, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Long, NearbyPeopleProfileActivity.a(this.this$0.j), NearbyPeopleProfileActivity.a(this.this$0), NearbyPeopleProfileActivity.a(this.this$0));
        return;
      }
    } while (bhsr.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
    bhhu.a(this.this$0.jdField_a_of_type_Axxj, this.this$0.app, 0L, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.this$0.d, arrayOfByte, l, true, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Long, NearbyPeopleProfileActivity.a(this.this$0.j), NearbyPeopleProfileActivity.a(this.this$0), NearbyPeopleProfileActivity.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.3
 * JD-Core Version:    0.7.0.1
 */