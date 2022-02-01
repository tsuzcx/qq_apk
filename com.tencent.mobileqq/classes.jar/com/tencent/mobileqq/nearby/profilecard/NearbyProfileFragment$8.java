package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.mobileqq.nearby.FaceScoreCallBack;

class NearbyProfileFragment$8
  extends FaceScoreCallBack
{
  NearbyProfileFragment$8(NearbyProfileFragment paramNearbyProfileFragment, long paramLong) {}
  
  public void a(long paramLong1, long paramLong2)
  {
    if ((this.jdField_a_of_type_Long == paramLong1) && (paramLong2 > 0L))
    {
      NearbyProfileFragment.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment).tinyId = paramLong2;
      NearbyPeopleProfileActivity localNearbyPeopleProfileActivity = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment.a;
      if (!NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment.a.j)) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment.a.jdField_a_of_type_Long = paramLong2;
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment.a(paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileFragment.8
 * JD-Core Version:    0.7.0.1
 */