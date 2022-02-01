package com.tencent.mobileqq.selectmember;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.CommonlyUsedTroop;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.selectmember.util.CommonUtils;
import com.tencent.mobileqq.troop.adapter.contact.CommonlyUsedTroopCompator;
import com.tencent.mobileqq.troop.adapter.contact.TroopCompator;
import com.tencent.mobileqq.troop.adapter.contact.TroopListItemWithMask;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

class TroopListBaseAdapter$3$1
  implements Runnable
{
  TroopListBaseAdapter$3$1(TroopListBaseAdapter.3 param3, ArrayList paramArrayList, List paramList) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("load data troopListInfo.size: ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilArrayList.size());
      ((StringBuilder)localObject1).append(" discussions.size:");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilList.size());
      QLog.d("TroopListBaseAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.c.clear();
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.e.clear();
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.d.clear();
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.b.clear();
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.f.clear();
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.g.clear();
    Object localObject1 = ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopInfoService.class, "")).getCommonlyUsedTroopList();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getCommonlyUsedTroopList troops size= ");
      ((StringBuilder)localObject2).append(((List)localObject1).size());
      QLog.d("TroopListBaseAdapter", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject3;
    if (localObject1 != null)
    {
      Collections.sort((List)localObject1, new CommonlyUsedTroopCompator());
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (CommonlyUsedTroop)((Iterator)localObject1).next();
        localObject3 = CommonUtils.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface, ((CommonlyUsedTroop)localObject2).troopUin);
        if (localObject3 != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.a((TroopInfo)localObject3, this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.a);
          this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.b.add(localObject3);
        }
        else if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("findTroopInfo troopInfo==null item.troopUin:");
          ((StringBuilder)localObject3).append(((CommonlyUsedTroop)localObject2).troopUin);
          QLog.d("TroopListBaseAdapter", 2, ((StringBuilder)localObject3).toString());
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("mSetTopTroopList1 size= ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.b.size());
      QLog.d("TroopListBaseAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentUin();
    Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (TroopInfo)((Iterator)localObject2).next();
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.a((TroopInfo)localObject3, this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.a);
      i = ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).changeMask(SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface, ((TroopInfo)localObject3).troopuin));
      if (((((TroopInfo)localObject3).dwAdditionalFlag & 1L) != 1L) && ((((TroopInfo)localObject3).troopowneruin == null) || (!((TroopInfo)localObject3).troopowneruin.equals(localObject1))))
      {
        if ((((TroopInfo)localObject3).dwCmdUinUinFlag & 1L) == 1L) {
          this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.d.add(new TroopListItemWithMask(i, (Entity)localObject3));
        } else {
          this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.e.add(new TroopListItemWithMask(i, (Entity)localObject3));
        }
      }
      else {
        this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.c.add(new TroopListItemWithMask(i, (Entity)localObject3));
      }
      if (!((TroopInfo)localObject3).hasSetTroopName()) {
        this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.f.add(new TroopListItemWithMask(i, (Entity)localObject3));
      }
      if (TroopListBaseAdapter.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0, ((TroopInfo)localObject3).troopuin, 1)) {
        this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.g.add(new TroopListItemWithMask(i, (Entity)localObject3));
      }
    }
    localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (DiscussionInfo)((Iterator)localObject1).next();
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.a.a(((DiscussionInfo)localObject2).uin, 3000);
      ((DiscussionInfo)localObject2).lastMsgTime = ((RecentUser)localObject3).lastmsgtime;
      if (((RecentUser)localObject3).showUpTime != 0L) {
        this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.b.add(localObject2);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentUin().equals(((DiscussionInfo)localObject2).ownerUin)) {
        this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.c.add(new TroopListItemWithMask(1, (Entity)localObject2));
      } else {
        this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.e.add(new TroopListItemWithMask(1, (Entity)localObject2));
      }
      if (!((DiscussionInfo)localObject2).hasRenamed()) {
        this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.f.add(new TroopListItemWithMask(1, (Entity)localObject2));
      }
      if (TroopListBaseAdapter.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0, ((DiscussionInfo)localObject2).uin, 3000)) {
        this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.g.add(new TroopListItemWithMask(1, (Entity)localObject2));
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("mSetTopTroopList2 size= ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.b.size());
      QLog.d("TroopListBaseAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = new TroopCompator();
    Collections.sort(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.c, (Comparator)localObject1);
    Collections.sort(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.d, (Comparator)localObject1);
    Collections.sort(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.e, (Comparator)localObject1);
    Collections.sort(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.f, (Comparator)localObject1);
    Collections.sort(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.g, (Comparator)localObject1);
    if (!this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.g.isEmpty()) {
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(13));
    }
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.b.isEmpty();
    boolean bool1 = false;
    if ((bool2 ^ true)) {
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(0));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.f.size() > 0) {
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(8));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.c.size() > 0) {
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(4));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.d.size() > 0) {
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(6));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.e.size() > 0) {
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(2));
    }
    localObject1 = new HashSet(5);
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilHashSet.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Integer)((Iterator)localObject2).next();
      if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilList.contains(localObject3)) {
        ((HashSet)localObject1).add(localObject3);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilHashSet = ((HashSet)localObject1);
    TroopListBaseAdapter.b(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0);
    if (TroopListBaseAdapter.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilList.get(0));
        TroopListBaseAdapter.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0).expandGroup(0);
      }
      TroopListBaseAdapter.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0, false);
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilList.size() == 1)
    {
      TroopListBaseAdapter.b(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0).expandGroup(0);
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilList.get(0));
    }
    else
    {
      i = 0;
      while (i < this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilList.size())
      {
        if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilHashSet.contains(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilList.get(i))) {
          TroopListBaseAdapter.c(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0).expandGroup(i);
        } else {
          TroopListBaseAdapter.d(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0).collapseGroup(i);
        }
        i += 1;
      }
    }
    if ((TroopListBaseAdapter.e(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0) instanceof PinnedHeaderExpandableListView))
    {
      localObject1 = (PinnedHeaderExpandableListView)TroopListBaseAdapter.f(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0);
      if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilList.size() > 1) {
        bool1 = true;
      }
      ((PinnedHeaderExpandableListView)localObject1).setHeaderViewShouldShow(bool1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopListBaseAdapter.3.1
 * JD-Core Version:    0.7.0.1
 */