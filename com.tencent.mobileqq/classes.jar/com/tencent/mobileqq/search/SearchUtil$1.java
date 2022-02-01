package com.tencent.mobileqq.search;

import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelGlobalTroop;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelGlobalTroopMember;
import com.tencent.mobileqq.search.business.contact.model.IContactSearchModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class SearchUtil$1
  implements Runnable
{
  SearchUtil$1(View paramView, IContactSearchModel paramIContactSearchModel) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    Object localObject = (Integer)this.jdField_a_of_type_AndroidViewView.getTag(2131380885);
    int j = -1;
    int i;
    if (localObject != null) {
      i = ((Integer)localObject).intValue();
    } else {
      i = -1;
    }
    localHashMap.put("itemLinePosition", String.valueOf(i + 1));
    localHashMap.put("matchDegree", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactModelIContactSearchModel.b()));
    localHashMap.put("className", this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactModelIContactSearchModel.getClass().getSimpleName());
    localHashMap.put("keyword", this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactModelIContactSearchModel.b());
    if (this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactModelIContactSearchModel.jdField_a_of_type_JavaUtilHashMap != null) {
      localHashMap.putAll(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactModelIContactSearchModel.jdField_a_of_type_JavaUtilHashMap);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactModelIContactSearchModel;
    if ((localObject instanceof ContactSearchModelGlobalTroopMember)) {
      localObject = ((ContactSearchModelGlobalTroopMember)localObject).a;
    } else if ((localObject instanceof ContactSearchModelGlobalTroop)) {
      localObject = ((ContactSearchModelGlobalTroop)localObject).a;
    } else {
      localObject = "";
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactModelIContactSearchModel.jdField_a_of_type_ComTencentCommonAppAppInterface != null))
    {
      int k = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactModelIContactSearchModel.jdField_a_of_type_ComTencentCommonAppAppInterface).getTroopMask((String)localObject);
      localHashMap.put("troopMask", String.valueOf(((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactModelIContactSearchModel.jdField_a_of_type_ComTencentCommonAppAppInterface).getTroopMask((String)localObject)));
      TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactModelIContactSearchModel.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
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
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Report troop member click, troopMask:");
        ((StringBuilder)localObject).append(k);
        ((StringBuilder)localObject).append(" troopMemberNum:");
        ((StringBuilder)localObject).append(i);
        QLog.d("searchUtils", 2, ((StringBuilder)localObject).toString());
      }
    }
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "ContactSearchMatchDegree", true, 0L, 0L, SearchUtils.a(localHashMap), "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.SearchUtil.1
 * JD-Core Version:    0.7.0.1
 */