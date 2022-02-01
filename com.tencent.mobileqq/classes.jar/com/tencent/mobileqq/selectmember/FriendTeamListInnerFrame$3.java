package com.tencent.mobileqq.selectmember;

import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.troop.troopcreate.api.IRelationFriendsTroopViewHelper.CallBack;
import com.tencent.mobileqq.troop.troopcreate.ui.RelationFriendsTroopViewHelper;
import com.tencent.widget.PinnedFooterExpandableListView;
import java.util.ArrayList;

class FriendTeamListInnerFrame$3
  implements IRelationFriendsTroopViewHelper.CallBack
{
  FriendTeamListInnerFrame$3(FriendTeamListInnerFrame paramFriendTeamListInnerFrame) {}
  
  public ArrayList<ResultRecord> a()
  {
    return this.a.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getResultRecordList();
  }
  
  public void a()
  {
    FriendTeamListInnerFrame.a(this.a).notifyDataSetChanged();
    if (FriendTeamListInnerFrame.a(this.a).getGroupCount() > 0)
    {
      Groups localGroups1 = FriendTeamListInnerFrame.a(this.a).a(1007L);
      Groups localGroups2 = FriendTeamListInnerFrame.a(this.a).a(1008L);
      if ((localGroups1 != null) || (localGroups2 != null))
      {
        FriendTeamListInnerFrame.a(this.a).expandGroup(0);
        FriendTeamListInnerFrame.a(this.a).setIsNeedScrollPositionTop(true);
        FriendTeamListInnerFrame.a(this.a).smoothScrollToPositionFromTop(1, 0, 0);
        if (localGroups1 != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiRelationFriendsTroopViewHelper.a();
        }
        if (localGroups2 != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiRelationFriendsTroopViewHelper.c();
        }
      }
    }
  }
  
  public ArrayList<String> b()
  {
    return this.a.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getSelectedUinList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.FriendTeamListInnerFrame.3
 * JD-Core Version:    0.7.0.1
 */