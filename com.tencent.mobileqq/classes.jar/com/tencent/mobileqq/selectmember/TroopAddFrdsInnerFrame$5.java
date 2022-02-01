package com.tencent.mobileqq.selectmember;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
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

class TroopAddFrdsInnerFrame$5
  implements Runnable
{
  TroopAddFrdsInnerFrame$5(TroopAddFrdsInnerFrame paramTroopAddFrdsInnerFrame, List paramList1, int paramInt1, int paramInt2, String paramString1, String paramString2, Map paramMap, List paramList2, AtomicInteger paramAtomicInteger) {}
  
  public void run()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilList.subList(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((List)localObject1).iterator();
    int i = 0;
    TroopMemberInfo localTroopMemberInfo;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localTroopMemberInfo = (TroopMemberInfo)localIterator.next();
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
    } while (((!this.this$0.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mShowMyself) && (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase(localTroopMemberInfo.memberuin))) || (this.this$0.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mUinsToHide.contains(localTroopMemberInfo.memberuin)) || (!Utils.d(localTroopMemberInfo.memberuin)));
    for (;;)
    {
      try
      {
        for (;;)
        {
          long l = Long.valueOf(localTroopMemberInfo.memberuin).longValue();
          if (l < 0L) {
            break;
          }
          localObject1 = null;
          if (this.this$0.f == TroopAddFrdsInnerFrame.d)
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
          }
          else if (this.this$0.f == TroopAddFrdsInnerFrame.e)
          {
            if ((!TextUtils.isEmpty(TroopAddFrdsInnerFrame.a(this.this$0))) && (TroopAddFrdsInnerFrame.a(this.this$0).equalsIgnoreCase(localTroopMemberInfo.memberuin))) {
              localTroopMemberInfo.addState = 1;
            } else {
              localTroopMemberInfo.addState = TroopAddFrdsInnerFrame.a(this.this$0, localTroopMemberInfo.memberuin);
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("");
            ((StringBuilder)localObject1).append(localTroopMemberInfo.addState);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          if ((localTroopMemberInfo.commonFrdCnt == -2147483648) && (!localTroopMemberInfo.memberuin.equals(this.jdField_b_of_type_JavaLangString))) {
            localArrayList.add(localTroopMemberInfo.memberuin);
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
      catch (Exception localException)
      {
        continue;
      }
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        this.jdField_b_of_type_JavaUtilList.addAll(localArrayList);
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("subThread end, id=");
          ((StringBuilder)???).append(Thread.currentThread().getId());
          ((StringBuilder)???).append(", threadCnt=");
          ((StringBuilder)???).append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
          ((StringBuilder)???).append(", curTroopUin=");
          ((StringBuilder)???).append(this.jdField_a_of_type_JavaLangString);
          QLog.d("TroopMemberListInnerFrame.thread", 2, ((StringBuilder)???).toString());
        }
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndDecrement() <= 1)
        {
          ??? = this.this$0.jdField_b_of_type_AndroidOsHandler.obtainMessage(3);
          ((Message)???).arg1 = i;
          ((Message)???).obj = new Object[] { this.jdField_a_of_type_JavaUtilMap, this.jdField_a_of_type_JavaLangString };
          this.this$0.jdField_b_of_type_AndroidOsHandler.sendMessage((Message)???);
          if (this.jdField_b_of_type_JavaUtilList.size() > 0)
          {
            ??? = this.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(5);
            ((Message)???).obj = this.jdField_b_of_type_JavaUtilList;
            this.this$0.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)???);
          }
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopAddFrdsInnerFrame.5
 * JD-Core Version:    0.7.0.1
 */