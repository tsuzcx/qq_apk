package com.tencent.mobileqq.nearby.profilecard;

import auqc;
import bcyr;
import bdee;
import bdje;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.qphone.base.util.BaseApplication;

class NearbyPeopleProfileActivity$4
  implements Runnable
{
  NearbyPeopleProfileActivity$4(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void run()
  {
    Object localObject = (auqc)this.this$0.app.getManager(106);
    this.this$0.k = ((auqc)localObject).b(NearbyPeopleProfileActivity.a(this.this$0));
    if (!this.this$0.k) {}
    long l;
    do
    {
      do
      {
        return;
      } while ((!bdee.d(BaseApplication.getContext())) && (this.this$0.k));
      localObject = NearbyPeopleProfileActivity.a(this.this$0).vSeed;
      l = NearbyPeopleProfileActivity.a(this.this$0).feedPreviewTime;
      if (this.this$0.jdField_a_of_type_Long > 0L)
      {
        bcyr.a(this.this$0.jdField_a_of_type_Ausy, this.this$0.app, this.this$0.jdField_a_of_type_Long, null, this.this$0.d, (byte[])localObject, l, true, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Long, NearbyPeopleProfileActivity.a(this.this$0.j), NearbyPeopleProfileActivity.a(this.this$0), NearbyPeopleProfileActivity.a(this.this$0));
        return;
      }
    } while (bdje.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
    bcyr.a(this.this$0.jdField_a_of_type_Ausy, this.this$0.app, 0L, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.this$0.d, (byte[])localObject, l, true, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Long, NearbyPeopleProfileActivity.a(this.this$0.j), NearbyPeopleProfileActivity.a(this.this$0), NearbyPeopleProfileActivity.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.4
 * JD-Core Version:    0.7.0.1
 */