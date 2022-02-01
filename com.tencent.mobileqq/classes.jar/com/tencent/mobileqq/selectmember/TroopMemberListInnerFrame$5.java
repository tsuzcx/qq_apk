package com.tencent.mobileqq.selectmember;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.selectmember.util.CommonUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class TroopMemberListInnerFrame$5
  implements Runnable
{
  TroopMemberListInnerFrame$5(TroopMemberListInnerFrame paramTroopMemberListInnerFrame, List paramList, int paramInt1, int paramInt2, String paramString1, String paramString2, TroopInfo paramTroopInfo, Map paramMap, AtomicInteger paramAtomicInteger) {}
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.subList(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)localIterator.next();
      Object localObject1;
      if (!this.jdField_a_of_type_JavaLangString.equals(this.this$0.jdField_b_of_type_JavaLangString))
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("subThread, curTroopUin != mTroopUin, return, ");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject1).append(",");
          ((StringBuilder)localObject1).append(this.this$0.jdField_b_of_type_JavaLangString);
          QLog.d("TroopMemberListInnerFrame.thread", 2, ((StringBuilder)localObject1).toString());
        }
        return;
      }
      if (((!this.this$0.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mShowMyself) || (this.this$0.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mIsPutMySelfFirst)) && (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase(localTroopMemberInfo.memberuin))) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo = localTroopMemberInfo;
      } else if ((!this.this$0.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mUinsToHide.contains(localTroopMemberInfo.memberuin)) && (Utils.d(localTroopMemberInfo.memberuin))) {
        if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (this.this$0.jdField_b_of_type_Int == 2) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isTroopAdmin(localTroopMemberInfo.memberuin)) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isTroopOwner(localTroopMemberInfo.memberuin)))
        {
          this.this$0.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mUinsToHide.add(localTroopMemberInfo.memberuin);
        }
        else
        {
          localTroopMemberInfo.displayedNamePinyinFirst = ChnToSpell.a(CommonUtils.a(this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface, localTroopMemberInfo.troopuin, localTroopMemberInfo.memberuin), 2);
          if ((localTroopMemberInfo.displayedNamePinyinFirst != null) && (localTroopMemberInfo.displayedNamePinyinFirst.length() != 0)) {
            localObject1 = localTroopMemberInfo.displayedNamePinyinFirst.substring(0, 1);
          } else {
            localObject1 = "#";
          }
          int j = ((String)localObject1).charAt(0);
          if (((65 <= j) && (j <= 90)) || ((97 <= j) && (j <= 122))) {
            localObject1 = ((String)localObject1).toUpperCase();
          } else {
            localObject1 = "#";
          }
          synchronized (this.jdField_a_of_type_JavaUtilMap)
          {
            if (this.jdField_a_of_type_JavaUtilMap.get(localObject1) == null) {
              this.jdField_a_of_type_JavaUtilMap.put(localObject1, new ArrayList());
            }
            ((List)this.jdField_a_of_type_JavaUtilMap.get(localObject1)).add(localTroopMemberInfo);
            i += 1;
          }
        }
      }
    }
    Object localObject3;
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("subThread end, id=");
      ((StringBuilder)localObject3).append(Thread.currentThread().getId());
      ((StringBuilder)localObject3).append(", threadCnt=");
      ((StringBuilder)localObject3).append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      ((StringBuilder)localObject3).append(", curTroopUin=");
      ((StringBuilder)localObject3).append(this.jdField_a_of_type_JavaLangString);
      QLog.d("TroopMemberListInnerFrame.thread", 2, ((StringBuilder)localObject3).toString());
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndDecrement() <= 1)
    {
      localObject3 = this.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
      ((Message)localObject3).arg1 = i;
      ((Message)localObject3).obj = new Object[] { this.jdField_a_of_type_JavaUtilMap, this.jdField_a_of_type_JavaLangString };
      this.this$0.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopMemberListInnerFrame.5
 * JD-Core Version:    0.7.0.1
 */