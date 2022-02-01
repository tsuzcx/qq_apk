package com.tencent.mobileqq.multicard;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.os.MqqHandler;

class MultiCardManager$1
  implements Runnable
{
  MultiCardManager$1(MultiCardManager paramMultiCardManager, ArrayList paramArrayList, long paramLong, MultiCardManager.GetGroupMemberNickListener paramGetGroupMemberNickListener) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap(50);
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject1 = (TroopManager)MultiCardManager.a(this.this$0).getManager(QQManagerFactory.TROOP_MANAGER);
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Long localLong = (Long)((Iterator)localObject2).next();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(this.jdField_a_of_type_Long);
        ((StringBuilder)localObject3).append("");
        localObject3 = ((StringBuilder)localObject3).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localLong);
        localStringBuilder.append("");
        localObject3 = ((TroopManager)localObject1).a((String)localObject3, localStringBuilder.toString());
        if (localObject3 != null) {
          localHashMap.put(localLong, localObject3);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("callbackWithNativeMemberNick ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject1).append(" ");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localHashMap.size());
      ((StringBuilder)localObject2).append(localHashMap.toString());
      ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
      QLog.d("MultiCardManager", 2, ((StringBuilder)localObject1).toString());
    }
    ThreadManager.getUIHandler().post(new MultiCardManager.1.1(this, localHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardManager.1
 * JD-Core Version:    0.7.0.1
 */