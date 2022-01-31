package com.tencent.mobileqq.util;

import awgf;
import awgg;
import bdda;
import bdnn;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;

public final class NearbyProfileUtil$1
  implements Runnable
{
  public void run()
  {
    awgf localawgf = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject1;
    long l;
    if (localawgf != null)
    {
      localObject1 = null;
      if (this.jdField_a_of_type_Long > 0L) {
        localObject1 = (NearbyPeopleCard)localawgf.a(NearbyPeopleCard.class, "tinyId=?", new String[] { String.valueOf(this.jdField_a_of_type_Long) });
      }
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = localObject1;
        if (!bdnn.a(this.jdField_a_of_type_JavaLangString)) {
          localObject2 = (NearbyPeopleCard)localawgf.a(NearbyPeopleCard.class, "uin=?", new String[] { this.jdField_a_of_type_JavaLangString });
        }
      }
      if (localObject2 != null)
      {
        localObject1 = ((NearbyPeopleCard)localObject2).vSeed;
        l = ((NearbyPeopleCard)localObject2).feedPreviewTime;
        localawgf.a();
      }
    }
    for (;;)
    {
      bdda.a(this.jdField_a_of_type_Auxh, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, (byte[])localObject1, l, false, 0L, false, 0L, 0);
      return;
      localObject1 = null;
      l = 0L;
      break;
      l = 0L;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.NearbyProfileUtil.1
 * JD-Core Version:    0.7.0.1
 */