package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.qphone.base.util.QLog;

class NearbyPeopleProfileActivity$19$1
  implements Runnable
{
  NearbyPeopleProfileActivity$19$1(NearbyPeopleProfileActivity.19 param19, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$19.a.mMode == 1) {
      return;
    }
    if (NearbyPeopleProfileActivity.access$500(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$19.a) != null)
    {
      NearbyPeopleProfileActivity.access$500(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$19.a).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("NearbyPeopleProfileActivity", 2, "mDisplayModel == null ！");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.19.1
 * JD-Core Version:    0.7.0.1
 */