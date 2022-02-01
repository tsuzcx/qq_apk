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
    Object localObject2;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject1 = (TroopManager)MultiCardManager.a(this.this$0).getManager(QQManagerFactory.TROOP_MANAGER);
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Long localLong = (Long)((Iterator)localObject2).next();
        String str = ((TroopManager)localObject1).a(this.jdField_a_of_type_Long + "", localLong + "");
        if (str != null) {
          localHashMap.put(localLong, str);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("callbackWithNativeMemberNick ").append(this.jdField_a_of_type_Long).append(" ");
      if (localHashMap == null) {
        break label218;
      }
    }
    label218:
    for (Object localObject1 = localHashMap.size() + localHashMap.toString();; localObject1 = "null")
    {
      QLog.d("MultiCardManager", 2, (String)localObject1);
      ThreadManager.getUIHandler().post(new MultiCardManager.1.1(this, localHashMap));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardManager.1
 * JD-Core Version:    0.7.0.1
 */