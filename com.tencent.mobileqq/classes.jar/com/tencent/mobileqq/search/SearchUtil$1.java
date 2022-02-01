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
    Object localObject = (Integer)this.a.getTag(2131449868);
    int j = -1;
    int i;
    if (localObject != null) {
      i = ((Integer)localObject).intValue();
    } else {
      i = -1;
    }
    localHashMap.put("itemLinePosition", String.valueOf(i + 1));
    localHashMap.put("matchDegree", String.valueOf(this.b.u()));
    localHashMap.put("className", this.b.getClass().getSimpleName());
    localHashMap.put("keyword", this.b.g());
    if (this.b.v != null) {
      localHashMap.putAll(this.b.v);
    }
    localObject = this.b;
    if ((localObject instanceof ContactSearchModelGlobalTroopMember)) {
      localObject = ((ContactSearchModelGlobalTroopMember)localObject).a;
    } else if ((localObject instanceof ContactSearchModelGlobalTroop)) {
      localObject = ((ContactSearchModelGlobalTroop)localObject).a;
    } else {
      localObject = "";
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (this.b.m != null))
    {
      int k = ((QQAppInterface)this.b.m).getTroopMask((String)localObject);
      localHashMap.put("troopMask", String.valueOf(((QQAppInterface)this.b.m).getTroopMask((String)localObject)));
      TroopManager localTroopManager = (TroopManager)this.b.m.getManager(QQManagerFactory.TROOP_MANAGER);
      i = j;
      if (localTroopManager != null)
      {
        localObject = localTroopManager.g((String)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.SearchUtil.1
 * JD-Core Version:    0.7.0.1
 */