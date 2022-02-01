package com.tencent.mobileqq.troop.troopcreate.ui;

import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.troop.api.troopcreate.IRelationFriendsSearchHelper;
import com.tencent.mobileqq.troop.troopcreate.api.IRelationFriendsTroopViewHelper.CallBack;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PinnedFooterExpandableListView;
import java.util.ArrayList;

class RelationFriendsTroopViewHelper$3
  implements Runnable
{
  RelationFriendsTroopViewHelper$3(RelationFriendsTroopViewHelper paramRelationFriendsTroopViewHelper, String paramString) {}
  
  public void run()
  {
    Object localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqTroopApiTroopcreateIRelationFriendsSearchHelper.search(this.a, this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface);
    if (localObject1 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateRelationFriends searchend result null,uin:");
      ((StringBuilder)localObject1).append(this.a);
      QLog.i("RelationFriendsTroopViewHelper", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("updateRelationFriends startsearch uin:");
    ((StringBuilder)localObject2).append(this.a);
    ((StringBuilder)localObject2).append(",resultsize:");
    ((StringBuilder)localObject2).append(((ArrayList)localObject1).size());
    QLog.i("RelationFriendsTroopViewHelper", 1, ((StringBuilder)localObject2).toString());
    localObject2 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(RelationFriendsTroopViewHelper.a(this.this$0).b());
    int j = 0;
    int i;
    for (int k = 0; j < ((ArrayList)localObject1).size(); k = i)
    {
      Friends localFriends = (Friends)((ArrayList)localObject1).get(j);
      if (k >= 5) {
        break;
      }
      i = k;
      if (!localArrayList.contains(localFriends.uin))
      {
        ((ArrayList)localObject2).add(localFriends);
        k += 1;
        i = k;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("updateRelationFriends relationuin:");
          localStringBuilder.append(localFriends.uin);
          QLog.i("RelationFriendsTroopViewHelper", 2, localStringBuilder.toString());
          i = k;
        }
      }
      j += 1;
    }
    if (this.this$0.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView != null) {
      this.this$0.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.post(new RelationFriendsTroopViewHelper.3.1(this, (ArrayList)localObject2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.RelationFriendsTroopViewHelper.3
 * JD-Core Version:    0.7.0.1
 */