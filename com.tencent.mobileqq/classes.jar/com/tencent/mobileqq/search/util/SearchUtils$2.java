package com.tencent.mobileqq.search.util;

import android.text.TextUtils;
import android.view.View;
import bcdv;
import bcdy;
import bcff;
import bcnc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class SearchUtils$2
  implements Runnable
{
  public SearchUtils$2(View paramView, bcff parambcff) {}
  
  public void run()
  {
    int j = -1;
    HashMap localHashMap = new HashMap();
    Object localObject = (Integer)this.jdField_a_of_type_AndroidViewView.getTag(2131381184);
    int i;
    if (localObject != null)
    {
      i = ((Integer)localObject).intValue();
      localHashMap.put("itemLinePosition", String.valueOf(i + 1));
      localHashMap.put("matchDegree", String.valueOf(this.jdField_a_of_type_Bcff.b()));
      localHashMap.put("className", this.jdField_a_of_type_Bcff.getClass().getSimpleName());
      localHashMap.put("keyword", this.jdField_a_of_type_Bcff.a());
      if (this.jdField_a_of_type_Bcff.jdField_a_of_type_JavaUtilHashMap != null) {
        localHashMap.putAll(this.jdField_a_of_type_Bcff.jdField_a_of_type_JavaUtilHashMap);
      }
      if (!(this.jdField_a_of_type_Bcff instanceof bcdy)) {
        break label340;
      }
      localObject = ((bcdy)this.jdField_a_of_type_Bcff).a;
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (this.jdField_a_of_type_Bcff.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
      {
        int k = this.jdField_a_of_type_Bcff.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask((String)localObject);
        localHashMap.put("troopMask", String.valueOf(this.jdField_a_of_type_Bcff.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask((String)localObject)));
        TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_Bcff.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        i = j;
        if (localTroopManager != null)
        {
          localObject = localTroopManager.c((String)localObject);
          i = j;
          if (localObject != null) {
            i = ((TroopInfo)localObject).wMemberNum;
          }
        }
        localHashMap.put("troopMask", String.valueOf(k));
        localHashMap.put("troopMemberNum", String.valueOf(i));
        if (QLog.isColorLevel()) {
          QLog.d("searchUtils", 2, "Report troop member click, troopMask:" + k + " troopMemberNum:" + i);
        }
      }
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "ContactSearchMatchDegree", true, 0L, 0L, bcnc.a(localHashMap), "", false);
      return;
      i = -1;
      break;
      label340:
      if ((this.jdField_a_of_type_Bcff instanceof bcdv)) {
        localObject = ((bcdv)this.jdField_a_of_type_Bcff).a;
      } else {
        localObject = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.SearchUtils.2
 * JD-Core Version:    0.7.0.1
 */