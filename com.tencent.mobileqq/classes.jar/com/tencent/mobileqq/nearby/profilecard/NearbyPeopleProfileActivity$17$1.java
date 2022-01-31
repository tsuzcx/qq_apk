package com.tencent.mobileqq.nearby.profilecard;

import asss;
import astd;
import com.tencent.qphone.base.util.QLog;

public class NearbyPeopleProfileActivity$17$1
  implements Runnable
{
  public NearbyPeopleProfileActivity$17$1(asss paramasss, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Asss.a.e == 1) {}
    do
    {
      return;
      if (NearbyPeopleProfileActivity.a(this.jdField_a_of_type_Asss.a) != null)
      {
        NearbyPeopleProfileActivity.a(this.jdField_a_of_type_Asss.a).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.nearby_people_card.", 2, "mDisplayModel == null ！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.17.1
 * JD-Core Version:    0.7.0.1
 */