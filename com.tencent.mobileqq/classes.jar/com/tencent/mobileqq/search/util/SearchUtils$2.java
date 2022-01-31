package com.tencent.mobileqq.search.util;

import android.text.TextUtils;
import android.view.View;
import awmu;
import awmx;
import awoe;
import awwa;
import axrn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class SearchUtils$2
  implements Runnable
{
  public SearchUtils$2(View paramView, awoe paramawoe) {}
  
  public void run()
  {
    int j = -1;
    HashMap localHashMap = new HashMap();
    Object localObject = (Integer)this.jdField_a_of_type_AndroidViewView.getTag(2131379214);
    int i;
    if (localObject != null)
    {
      i = ((Integer)localObject).intValue();
      localHashMap.put("itemLinePosition", String.valueOf(i + 1));
      localHashMap.put("matchDegree", String.valueOf(this.jdField_a_of_type_Awoe.b()));
      localHashMap.put("className", this.jdField_a_of_type_Awoe.getClass().getSimpleName());
      localHashMap.put("keyword", this.jdField_a_of_type_Awoe.a());
      if (this.jdField_a_of_type_Awoe.jdField_a_of_type_JavaUtilHashMap != null) {
        localHashMap.putAll(this.jdField_a_of_type_Awoe.jdField_a_of_type_JavaUtilHashMap);
      }
      if (!(this.jdField_a_of_type_Awoe instanceof awmx)) {
        break label339;
      }
      localObject = ((awmx)this.jdField_a_of_type_Awoe).a;
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (this.jdField_a_of_type_Awoe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
      {
        int k = this.jdField_a_of_type_Awoe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b((String)localObject);
        localHashMap.put("troopMask", String.valueOf(this.jdField_a_of_type_Awoe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b((String)localObject)));
        TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_Awoe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
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
      axrn.a(BaseApplicationImpl.getApplication()).a(null, "ContactSearchMatchDegree", true, 0L, 0L, awwa.a(localHashMap), "", false);
      return;
      i = -1;
      break;
      label339:
      if ((this.jdField_a_of_type_Awoe instanceof awmu)) {
        localObject = ((awmu)this.jdField_a_of_type_Awoe).a;
      } else {
        localObject = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.SearchUtils.2
 * JD-Core Version:    0.7.0.1
 */