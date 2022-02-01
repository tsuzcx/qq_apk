package com.tencent.mobileqq.troop.troopcreate.tempapi;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troop.troopcreate.ui.NewTroopContactView;
import com.tencent.mobileqq.troop.troopcreate.ui.RelationFriendsTroopViewHelper;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface ICreateTroopForUI
  extends IRuntimeService
{
  public abstract void destoryAdapter();
  
  public abstract PinnedHeaderExpandableListView.ExpandableListAdapter getContactListAdapter(NewTroopContactView paramNewTroopContactView, AppInterface paramAppInterface, ExpandableListView paramExpandableListView, boolean paramBoolean);
  
  public abstract Groups getGroupByGroupId(long paramLong);
  
  public abstract void jump2Aio(Context paramContext, String paramString, boolean paramBoolean);
  
  public abstract void setRelationFriendTroopHelper(RelationFriendsTroopViewHelper paramRelationFriendsTroopViewHelper);
  
  public abstract void setSelectedAndJoinedUins(List<String> paramList1, List<String> paramList2);
  
  public abstract void setTabBarVisible(boolean paramBoolean, QBaseActivity paramQBaseActivity);
  
  public abstract void showContactSearchFragment(NewTroopContactView paramNewTroopContactView, QBaseActivity paramQBaseActivity);
  
  public abstract void startSearch(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.tempapi.ICreateTroopForUI
 * JD-Core Version:    0.7.0.1
 */