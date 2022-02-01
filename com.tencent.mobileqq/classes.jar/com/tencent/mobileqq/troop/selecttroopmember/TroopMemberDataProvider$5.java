package com.tencent.mobileqq.troop.selecttroopmember;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class TroopMemberDataProvider$5
  implements Runnable
{
  TroopMemberDataProvider$5(TroopMemberDataProvider paramTroopMemberDataProvider, String paramString, List paramList, int paramInt1, int paramInt2, AtomicInteger paramAtomicInteger) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_JavaLangString.equals(this.this$0.jdField_a_of_type_JavaLangString)) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberDataProvider", 2, "subThread, curTroopUin != mTroopUin, return, " + this.jdField_a_of_type_JavaLangString + "," + this.this$0.jdField_a_of_type_JavaLangString);
      }
    }
    do
    {
      return;
      Object localObject2 = this.jdField_a_of_type_JavaUtilList.subList(this.jdField_a_of_type_Int, this.b);
      synchronized (this.this$0.jdField_a_of_type_JavaUtilArrayList)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)((Iterator)localObject2).next();
          if ((Utils.d(localTroopMemberInfo.memberuin)) && ((TextUtils.isEmpty(localTroopMemberInfo.memberuin)) || (!localTroopMemberInfo.memberuin.equals("50000000"))))
          {
            localTroopMemberInfo.displayedNamePinyinFirst = ChnToSpell.a(ContactUtils.g(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTroopMemberInfo.troopuin, localTroopMemberInfo.memberuin), 2);
            this.this$0.jdField_a_of_type_JavaUtilArrayList.add(localTroopMemberInfo);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberDataProvider", 2, "subThread end, id=" + Thread.currentThread().getId() + ", threadCnt=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ", curTroopUin=" + this.jdField_a_of_type_JavaLangString);
      }
    } while (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndDecrement() > 1);
    ??? = this.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
    this.this$0.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)???);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.selecttroopmember.TroopMemberDataProvider.5
 * JD-Core Version:    0.7.0.1
 */