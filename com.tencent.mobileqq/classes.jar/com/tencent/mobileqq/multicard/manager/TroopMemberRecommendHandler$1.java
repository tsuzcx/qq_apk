package com.tencent.mobileqq.multicard.manager;

import astl;
import aukn;
import auko;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.multicard.RecommendPerson;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class TroopMemberRecommendHandler$1
  implements Runnable
{
  public TroopMemberRecommendHandler$1(astl paramastl, long paramLong, ArrayList paramArrayList) {}
  
  public void run()
  {
    aukn localaukn = this.this$0.app.getEntityManagerFactory().createEntityManager();
    int i = localaukn.a(RecommendPerson.class.getSimpleName(), "troopUin=? ", new String[] { String.valueOf(this.jdField_a_of_type_Long) });
    if (QLog.isColorLevel()) {
      QLog.i("TroopMemberRecommend.Handler", 2, "handleGetTroopMemRecommendCards,delete count =" + i);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      RecommendPerson localRecommendPerson = (RecommendPerson)localIterator.next();
      this.this$0.a(localaukn, localRecommendPerson);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.manager.TroopMemberRecommendHandler.1
 * JD-Core Version:    0.7.0.1
 */