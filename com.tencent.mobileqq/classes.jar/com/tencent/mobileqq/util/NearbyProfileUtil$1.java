package com.tencent.mobileqq.util;

import aukn;
import auko;
import bazj;
import bbjw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;

public final class NearbyProfileUtil$1
  implements Runnable
{
  public void run()
  {
    aukn localaukn = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject1;
    long l;
    if (localaukn != null)
    {
      localObject1 = null;
      if (this.jdField_a_of_type_Long > 0L) {
        localObject1 = (NearbyPeopleCard)localaukn.a(NearbyPeopleCard.class, "tinyId=?", new String[] { String.valueOf(this.jdField_a_of_type_Long) });
      }
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = localObject1;
        if (!bbjw.a(this.jdField_a_of_type_JavaLangString)) {
          localObject2 = (NearbyPeopleCard)localaukn.a(NearbyPeopleCard.class, "uin=?", new String[] { this.jdField_a_of_type_JavaLangString });
        }
      }
      if (localObject2 != null)
      {
        localObject1 = ((NearbyPeopleCard)localObject2).vSeed;
        l = ((NearbyPeopleCard)localObject2).feedPreviewTime;
        localaukn.a();
      }
    }
    for (;;)
    {
      bazj.a(this.jdField_a_of_type_Atbx, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, (byte[])localObject1, l, false, 0L, false, 0L, 0);
      return;
      localObject1 = null;
      l = 0L;
      break;
      l = 0L;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.util.NearbyProfileUtil.1
 * JD-Core Version:    0.7.0.1
 */