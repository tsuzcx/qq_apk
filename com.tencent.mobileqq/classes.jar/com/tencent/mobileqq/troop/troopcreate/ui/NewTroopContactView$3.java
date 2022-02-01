package com.tencent.mobileqq.troop.troopcreate.ui;

import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.troop.troopcreate.api.IRelationFriendsTroopViewHelper.CallBack;
import com.tencent.mobileqq.troop.troopcreate.tempapi.ICreateTroopForUI;
import com.tencent.widget.PinnedFooterExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter;
import java.util.ArrayList;

class NewTroopContactView$3
  implements IRelationFriendsTroopViewHelper.CallBack
{
  NewTroopContactView$3(NewTroopContactView paramNewTroopContactView) {}
  
  public ArrayList<ResultRecord> a()
  {
    return this.a.c;
  }
  
  public void a()
  {
    this.a.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter.notifyDataSetChanged();
    if (this.a.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter.getGroupCount() > 0)
    {
      Groups localGroups1 = NewTroopContactView.a(this.a).getGroupByGroupId(1007L);
      Groups localGroups2 = NewTroopContactView.a(this.a).getGroupByGroupId(1008L);
      if ((localGroups1 != null) || (localGroups2 != null))
      {
        this.a.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.expandGroup(0);
        this.a.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setIsNeedScrollPositionTop(true);
        this.a.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.smoothScrollToPositionFromTop(1, 0, 0);
      }
      if (localGroups1 != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiRelationFriendsTroopViewHelper.a();
      }
      if (localGroups2 != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiRelationFriendsTroopViewHelper.c();
      }
    }
  }
  
  public ArrayList<String> b()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.a.c.size())
    {
      localArrayList.add(((ResultRecord)this.a.c.get(i)).uin);
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.NewTroopContactView.3
 * JD-Core Version:    0.7.0.1
 */