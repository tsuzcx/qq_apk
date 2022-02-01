package com.tencent.mobileqq.multicard.manager;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.multicard.RecommendPerson;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class TroopMemberRecommendHandler$1
  implements Runnable
{
  TroopMemberRecommendHandler$1(TroopMemberRecommendHandler paramTroopMemberRecommendHandler, long paramLong, ArrayList paramArrayList) {}
  
  public void run()
  {
    EntityManager localEntityManager = TroopMemberRecommendHandler.a(this.this$0).getEntityManagerFactory().createEntityManager();
    int i = localEntityManager.delete(RecommendPerson.class.getSimpleName(), "troopUin=? ", new String[] { String.valueOf(this.jdField_a_of_type_Long) });
    if (QLog.isColorLevel()) {
      QLog.i("TroopMemberRecommend.Handler", 2, "handleGetTroopMemRecommendCards,delete count =" + i);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      RecommendPerson localRecommendPerson = (RecommendPerson)localIterator.next();
      this.this$0.a(localEntityManager, localRecommendPerson);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.manager.TroopMemberRecommendHandler.1
 * JD-Core Version:    0.7.0.1
 */