package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.qphone.base.util.QLog;

class NearbyPeopleProfileActivity$17$1
  implements Runnable
{
  NearbyPeopleProfileActivity$17$1(NearbyPeopleProfileActivity.17 param17, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$17.a.e == 1) {}
    do
    {
      return;
      if (NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$17.a) != null)
      {
        NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$17.a).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.nearby_people_card.", 2, "mDisplayModel == null ！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.17.1
 * JD-Core Version:    0.7.0.1
 */