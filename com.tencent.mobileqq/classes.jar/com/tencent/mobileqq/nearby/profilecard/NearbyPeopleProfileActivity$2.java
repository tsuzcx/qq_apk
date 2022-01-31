package com.tencent.mobileqq.nearby.profilecard;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import auqc;
import awbw;
import awbx;
import bcyr;
import bdee;
import bdje;
import bhoh;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class NearbyPeopleProfileActivity$2
  implements Runnable
{
  NearbyPeopleProfileActivity$2(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity, bhoh parambhoh) {}
  
  public void run()
  {
    if ((this.a != null) && (this.a.a()))
    {
      this.a.b(4);
      this.a.a(5);
      this.a.a(8);
    }
    Object localObject3 = this.this$0.app.getEntityManagerFactory().createEntityManager();
    boolean bool1 = false;
    Object localObject1;
    Object localObject2;
    label183:
    long l;
    label209:
    boolean bool2;
    if (localObject3 != null)
    {
      localObject1 = null;
      localObject2 = null;
      if (NearbyPeopleProfileActivity.a(this.this$0) == 0)
      {
        if (this.this$0.jdField_a_of_type_Long > 0L) {
          localObject2 = (NearbyPeopleCard)((awbw)localObject3).a(NearbyPeopleCard.class, "tinyId=?", new String[] { String.valueOf(this.this$0.jdField_a_of_type_Long) });
        }
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!bdje.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
          {
            localObject1 = (NearbyPeopleCard)((awbw)localObject3).a(NearbyPeopleCard.class, "uin=?", new String[] { this.this$0.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString });
            break label715;
          }
        }
        ((awbw)localObject3).a();
        if (localObject1 == null) {
          break label1073;
        }
        localObject2 = ((NearbyPeopleCard)localObject1).vSeed;
        l = ((NearbyPeopleCard)localObject1).feedPreviewTime;
        bool1 = true;
        if (this.this$0.e == 1) {
          break label1064;
        }
        if (localObject1 != null) {
          break label1061;
        }
        localObject1 = new NearbyPeopleCard();
        ((NearbyPeopleCard)localObject1).tinyId = this.this$0.jdField_a_of_type_Long;
        ((NearbyPeopleCard)localObject1).uin = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
        label261:
        if ((!TextUtils.isEmpty(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h)) && (TextUtils.isEmpty(((NearbyPeopleCard)localObject1).nickname))) {
          ((NearbyPeopleCard)localObject1).nickname = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h;
        }
        if (NearbyPeopleProfileActivity.a(this.this$0.j))
        {
          if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_b_of_type_Int != -1) {
            ((NearbyPeopleCard)localObject1).age = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_b_of_type_Int;
          }
          if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte != -1) {
            ((NearbyPeopleCard)localObject1).gender = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte;
          }
          if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_Byte != 0) {
            ((NearbyPeopleCard)localObject1).constellation = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_Byte;
          }
        }
        if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_b_of_type_Byte != 0) {
          ((NearbyPeopleCard)localObject1).maritalStatus = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_b_of_type_Byte;
        }
        if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_Int != 0) {
          ((NearbyPeopleCard)localObject1).job = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_Int;
        }
        if (!TextUtils.isEmpty(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_b_of_type_JavaLangString)) {
          ((NearbyPeopleCard)localObject1).aioDistanceAndTime = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_b_of_type_JavaLangString;
        }
        this.this$0.jdField_d_of_type_JavaLangString = ((NearbyPeopleCard)localObject1).uin;
        localObject3 = (auqc)this.this$0.app.getManager(106);
        String str = this.this$0.app.getCurrentAccountUin();
        boolean bool3 = this.this$0.n;
        if (this.this$0.j != -1) {
          break label763;
        }
        bool2 = true;
        label552:
        bool2 = ((auqc)localObject3).a((NearbyPeopleCard)localObject1, str, bool3, bool2, this.this$0.jdField_d_of_type_Int, bool1);
        localObject3 = this.this$0.getIntent();
        bool1 = bool2;
        if (localObject3 != null)
        {
          bool1 = bool2;
          if (((Intent)localObject3).getIntExtra("refresh_flag", 0) == 1) {
            bool1 = true;
          }
        }
        if (!bool1) {
          this.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(101, localObject1).sendToTarget();
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.nearby_people_card.", 4, "isNeedUpdateNearbyCard tinyid is: " + ((NearbyPeopleCard)localObject1).tinyId + " uin is: " + ((NearbyPeopleCard)localObject1).uin + " " + bool1);
        }
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      if ((!bdee.d(BaseApplication.getContext())) && (bool1))
      {
        this.this$0.runOnUiThread(new NearbyPeopleProfileActivity.2.1(this));
        label715:
        return;
        if (NearbyPeopleProfileActivity.a(this.this$0) <= 0L) {
          break label183;
        }
        localObject1 = (NearbyPeopleCard)((awbw)localObject3).a(NearbyPeopleCard.class, "nowId=?", new String[] { String.valueOf(NearbyPeopleProfileActivity.a(this.this$0)) });
        break label183;
        label763:
        bool2 = false;
        break label552;
      }
      if ((this.a != null) && (this.a.a()))
      {
        this.a.a(6);
        this.a.a(9);
      }
      int i = (int)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Long;
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Long == 1L) {
        i = 6;
      }
      for (;;)
      {
        if (this.this$0.e != 1)
        {
          if (!bool1) {
            break;
          }
          if (this.this$0.jdField_a_of_type_Long > 0L)
          {
            bcyr.a(this.this$0.jdField_a_of_type_Ausy, this.this$0.app, this.this$0.jdField_a_of_type_Long, null, this.this$0.jdField_d_of_type_Int, (byte[])localObject1, l, false, i, NearbyPeopleProfileActivity.a(this.this$0.j), NearbyPeopleProfileActivity.a(this.this$0), NearbyPeopleProfileActivity.a(this.this$0));
            return;
          }
          bcyr.a(this.this$0.jdField_a_of_type_Ausy, this.this$0.app, 0L, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.this$0.jdField_d_of_type_Int, (byte[])localObject1, l, false, i, NearbyPeopleProfileActivity.a(this.this$0.j), NearbyPeopleProfileActivity.a(this.this$0), NearbyPeopleProfileActivity.a(this.this$0));
          return;
        }
        bcyr.a(this.this$0.jdField_a_of_type_Ausy, this.this$0.app, 0L, this.this$0.app.getCurrentAccountUin(), this.this$0.jdField_d_of_type_Int, (byte[])localObject1, l, false, i, NearbyPeopleProfileActivity.a(this.this$0.j), NearbyPeopleProfileActivity.a(this.this$0), NearbyPeopleProfileActivity.a(this.this$0));
        return;
      }
      label1061:
      break label261;
      label1064:
      bool1 = true;
      localObject1 = localObject2;
      continue;
      label1073:
      l = 0L;
      localObject2 = null;
      break label209;
      bool1 = true;
      l = 0L;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.2
 * JD-Core Version:    0.7.0.1
 */