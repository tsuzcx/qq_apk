package com.tencent.mobileqq.selectmember;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SelectMemberFromFriendGroup
  extends SelectMemberInnerFrame
{
  SelectMemberFromFriendGroup.ListAdapter jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberFromFriendGroup$ListAdapter;
  private final ArrayList<Groups> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  List<Groups> jdField_a_of_type_JavaUtilList = new ArrayList();
  List<Friends> b = new ArrayList();
  
  public SelectMemberFromFriendGroup(Context paramContext)
  {
    super(paramContext);
  }
  
  public SelectMemberFromFriendGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SelectMemberFromFriendGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void i()
  {
    Object localObject1 = ((IRecentUserProxyService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
    Object localObject3;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject3 = ((RecentUserProxy)localObject1).a(true);
      if (localObject3 != null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
        localObject1 = new ArrayList();
        localObject3 = ((List)localObject3).iterator();
      }
    }
    for (;;)
    {
      Object localObject4;
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = (RecentUser)((Iterator)localObject3).next();
        if (localObject4 == null) {}
      }
      else
      {
        try
        {
          if ((((RecentUser)localObject4).getType() != 0) || (Long.parseLong(((RecentUser)localObject4).uin) < 10000L) || (((RecentUser)localObject4).uin.equals(localObject2)) || (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mUinsToHide.contains(((RecentUser)localObject4).uin))) {
            continue;
          }
          localObject4 = SearchUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, ((RecentUser)localObject4).uin);
          if ((localObject4 == null) || (!((Friends)localObject4).isFriend())) {
            continue;
          }
          ((List)localObject1).add(localObject4);
        }
        catch (NumberFormatException localNumberFormatException) {}
        if (!((List)localObject1).isEmpty())
        {
          localObject2 = new Groups();
          ((Groups)localObject2).group_id = 1003;
          ((Groups)localObject2).group_name = this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getString(2131718136);
          ((Groups)localObject2).group_friend_count = ((List)localObject1).size();
          ((Groups)localObject2).seqid = 0;
          this.jdField_a_of_type_JavaUtilArrayList.add(0, localObject2);
          this.b = ((List)localObject1);
        }
        return;
      }
    }
  }
  
  public ContactSearchFragment a()
  {
    return ContactSearchFragment.a(-1, 1, null, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mUinsToHide, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity);
  }
  
  public String a()
  {
    return null;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    h();
    g();
  }
  
  public void a(Groups paramGroups, boolean paramBoolean)
  {
    if (paramGroups.group_id == 1003) {
      paramGroups = this.b;
    } else {
      paramGroups = SearchUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramGroups.group_id);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mUinsSelectedDefault;
    ArrayList localArrayList = new ArrayList();
    paramGroups = paramGroups.iterator();
    while (paramGroups.hasNext())
    {
      Friends localFriends = (Friends)paramGroups.next();
      if ((localObject == null) || (!((List)localObject).contains(localFriends.uin))) {
        localArrayList.add(SelectMemberActivity.constructAResultRecord(localFriends.uin, localFriends.getFriendNickWithAlias(), 0, "-1"));
      }
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.addFriendResults(localArrayList, false);
    }
    else
    {
      paramGroups = localArrayList.iterator();
      while (paramGroups.hasNext())
      {
        localObject = (ResultRecord)paramGroups.next();
        this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.removeFriendFromResultList(((ResultRecord)localObject).uin);
      }
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mSelectedAndSearchBar.a(false);
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.setupDoneBtn();
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.onResultListChanged();
    }
    f();
  }
  
  boolean a(Groups paramGroups)
  {
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mUinsSelectedDefault;
    if (localArrayList == null) {
      return false;
    }
    if (paramGroups.group_id == 1003) {
      paramGroups = this.b;
    } else {
      paramGroups = SearchUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramGroups.group_id);
    }
    paramGroups = paramGroups.iterator();
    while (paramGroups.hasNext()) {
      if (!localArrayList.contains(((Friends)paramGroups.next()).uin)) {
        return false;
      }
    }
    return true;
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.setupTitleBar(true, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getString(2131718718), this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getString(2131689684));
    f();
  }
  
  public void f()
  {
    ArrayList localArrayList1 = this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mResultList;
    ArrayList localArrayList2 = this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mUinsSelectedDefault;
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = 0;
    while (localIterator1.hasNext())
    {
      Groups localGroups = (Groups)localIterator1.next();
      if (localGroups.group_id == 1003) {
        localObject = this.b;
      } else {
        localObject = SearchUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localGroups.group_id);
      }
      Object localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Friends localFriends = (Friends)((Iterator)localObject).next();
        if ((localArrayList2 == null) || (!localArrayList2.contains(localFriends.uin)))
        {
          Iterator localIterator2 = localArrayList1.iterator();
          j = 0;
          while (localIterator2.hasNext()) {
            if (((ResultRecord)localIterator2.next()).uin.equals(localFriends.uin)) {
              j = 1;
            }
          }
          if (j == 0)
          {
            j = 0;
            break label200;
          }
        }
      }
      int j = 1;
      label200:
      if (j == 0)
      {
        if (!this.jdField_a_of_type_JavaUtilList.contains(localGroups)) {
          continue;
        }
        this.jdField_a_of_type_JavaUtilList.remove(localGroups);
      }
      else
      {
        if (this.jdField_a_of_type_JavaUtilList.contains(localGroups)) {
          continue;
        }
        this.jdField_a_of_type_JavaUtilList.add(localGroups);
      }
      i = 1;
    }
    if (i != 0) {
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberFromFriendGroup$ListAdapter.notifyDataSetChanged();
    }
  }
  
  void g()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity);
    XListView localXListView = new XListView(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity);
    localXListView.setDivider(null);
    localLinearLayout.addView(localXListView);
    localXListView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberFromFriendGroup$ListAdapter = new SelectMemberFromFriendGroup.ListAdapter(this);
    localXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberFromFriendGroup$ListAdapter);
    setContentView(localLinearLayout);
  }
  
  void h()
  {
    Object localObject2 = (ArrayList)((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).asyncGetGroupListForUI(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((List)localObject2).size() != 0) {}
    }
    else
    {
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ArrayList();
      }
    }
    i();
    int i = ((List)localObject1).size() - 1;
    while (i >= 0)
    {
      localObject2 = (Groups)((List)localObject1).get(i);
      if (((Groups)localObject2).group_friend_count != 0) {
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
      }
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.SelectMemberFromFriendGroup
 * JD-Core Version:    0.7.0.1
 */