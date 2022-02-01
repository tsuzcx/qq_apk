package com.tencent.mobileqq.troop.troopcreate.tempapi.impl;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment;
import com.tencent.mobileqq.search.business.contact.presenter.ContactSearchResultPresenter.OnActionListener;
import com.tencent.mobileqq.troop.createNewTroop.ContactListAdapter;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCreateActivity;
import com.tencent.mobileqq.troop.troopcreate.tempapi.ICreateTroopForUI;
import com.tencent.mobileqq.troop.troopcreate.ui.NewTroopContactView;
import com.tencent.mobileqq.troop.troopcreate.ui.RelationFriendsTroopViewHelper;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter;
import java.util.List;
import mqq.app.AppRuntime;

public class CreateTroopForUIImpl
  implements ICreateTroopForUI
{
  private static final String TAG = "CreateTroopForUIImpl";
  ContactSearchResultPresenter.OnActionListener listener = new CreateTroopForUIImpl.1(this);
  private ContactListAdapter mAdapter;
  private ContactSearchFragment mSearchFragment;
  private NewTroopContactView mView;
  
  public void destoryAdapter()
  {
    ContactListAdapter localContactListAdapter = this.mAdapter;
    if (localContactListAdapter != null) {
      localContactListAdapter.c();
    }
  }
  
  public PinnedHeaderExpandableListView.ExpandableListAdapter getContactListAdapter(NewTroopContactView paramNewTroopContactView, AppInterface paramAppInterface, ExpandableListView paramExpandableListView, boolean paramBoolean)
  {
    this.mAdapter = new ContactListAdapter(paramNewTroopContactView, (QQAppInterface)paramAppInterface, paramExpandableListView, paramBoolean);
    return this.mAdapter;
  }
  
  ContactSearchFragment getContactSearchFragment(NewTroopContactView paramNewTroopContactView)
  {
    this.mView = paramNewTroopContactView;
    return ContactSearchFragment.a(-1, 4194309, null, paramNewTroopContactView.d, this.listener);
  }
  
  public Groups getGroupByGroupId(long paramLong)
  {
    ContactListAdapter localContactListAdapter = this.mAdapter;
    if (localContactListAdapter != null) {
      localContactListAdapter.b(paramLong);
    }
    QLog.e("CreateTroopForUIImpl", 1, new Object[] { "getGroupByGroupId: adapter = ", this.mAdapter });
    return new Groups();
  }
  
  public void jump2Aio(Context paramContext, String paramString, boolean paramBoolean)
  {
    TroopUtils.a(paramContext, paramString, true);
  }
  
  public void onCreate(AppRuntime paramAppRuntime) {}
  
  public void onDestroy() {}
  
  public void setRelationFriendTroopHelper(RelationFriendsTroopViewHelper paramRelationFriendsTroopViewHelper)
  {
    ContactListAdapter localContactListAdapter = this.mAdapter;
    if (localContactListAdapter != null) {
      localContactListAdapter.a(paramRelationFriendsTroopViewHelper);
    }
  }
  
  public void setSelectedAndJoinedUins(List<String> paramList1, List<String> paramList2)
  {
    ContactSearchFragment localContactSearchFragment = this.mSearchFragment;
    if (localContactSearchFragment != null) {
      localContactSearchFragment.a(paramList1, paramList2);
    }
  }
  
  public void setTabBarVisible(boolean paramBoolean, QBaseActivity paramQBaseActivity)
  {
    if ((paramQBaseActivity instanceof NewTroopCreateActivity)) {
      ((NewTroopCreateActivity)paramQBaseActivity).a(paramBoolean);
    }
  }
  
  public void showContactSearchFragment(NewTroopContactView paramNewTroopContactView, QBaseActivity paramQBaseActivity)
  {
    ContactSearchFragment localContactSearchFragment = getContactSearchFragment(paramNewTroopContactView);
    if (localContactSearchFragment != null)
    {
      localContactSearchFragment.d(true);
      localContactSearchFragment.a(paramNewTroopContactView.getResultUins(), paramNewTroopContactView.c);
      paramNewTroopContactView = paramQBaseActivity.getSupportFragmentManager().beginTransaction();
      paramQBaseActivity = this.mSearchFragment;
      if (paramQBaseActivity != null) {
        paramNewTroopContactView.remove(paramQBaseActivity);
      }
      paramNewTroopContactView.add(2131444724, localContactSearchFragment);
      paramNewTroopContactView.commitAllowingStateLoss();
      this.mSearchFragment = localContactSearchFragment;
    }
  }
  
  public void startSearch(String paramString)
  {
    ContactSearchFragment localContactSearchFragment = this.mSearchFragment;
    if (localContactSearchFragment != null) {
      localContactSearchFragment.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.tempapi.impl.CreateTroopForUIImpl
 * JD-Core Version:    0.7.0.1
 */