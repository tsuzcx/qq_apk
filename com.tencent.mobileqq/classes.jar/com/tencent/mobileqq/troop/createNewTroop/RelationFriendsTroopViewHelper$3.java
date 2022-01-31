package com.tencent.mobileqq.troop.createNewTroop;

import ayku;
import ayky;
import ayla;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PinnedFooterExpandableListView;
import java.util.ArrayList;

public class RelationFriendsTroopViewHelper$3
  implements Runnable
{
  public RelationFriendsTroopViewHelper$3(ayky paramayky, String paramString) {}
  
  public void run()
  {
    ArrayList localArrayList1 = this.this$0.jdField_a_of_type_Ayku.a(this.a);
    if (localArrayList1 == null)
    {
      QLog.i("RelationFriendsTroopViewHelper", 1, "updateRelationFriends searchend result null,uin:" + this.a);
      return;
    }
    QLog.i("RelationFriendsTroopViewHelper", 1, "updateRelationFriends startsearch uin:" + this.a + ",resultsize:" + localArrayList1.size());
    ArrayList localArrayList2 = new ArrayList();
    int j = 0;
    int i = 0;
    Friends localFriends;
    if (j < localArrayList1.size())
    {
      localFriends = (Friends)localArrayList1.get(j);
      if (i < 5) {}
    }
    else
    {
      this.this$0.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.post(new RelationFriendsTroopViewHelper.3.1(this, localArrayList2));
      return;
    }
    int k = 0;
    label153:
    if (k < ayky.a(this.this$0).a().size()) {
      if (!((ResultRecord)ayky.a(this.this$0).a().get(k)).a.equals(localFriends.uin)) {}
    }
    for (k = 1;; k = 0)
    {
      if (k == 0)
      {
        localArrayList2.add(localFriends);
        k = i + 1;
        i = k;
        if (QLog.isColorLevel())
        {
          QLog.i("RelationFriendsTroopViewHelper", 2, "updateRelationFriends relationuin:" + localFriends.uin);
          i = k;
        }
      }
      for (;;)
      {
        j += 1;
        break;
        k += 1;
        break label153;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.RelationFriendsTroopViewHelper.3
 * JD-Core Version:    0.7.0.1
 */