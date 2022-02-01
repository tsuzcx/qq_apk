package com.tencent.mobileqq.troop.troopcreate.ui;

import com.tencent.mobileqq.troop.troopcreate.api.IRelationFriendsTroopViewHelper.CallBack;
import java.util.ArrayList;

class RelationFriendsTroopViewHelper$3$1
  implements Runnable
{
  RelationFriendsTroopViewHelper$3$1(RelationFriendsTroopViewHelper.3 param3, ArrayList paramArrayList) {}
  
  public void run()
  {
    RelationFriendsTroopViewHelper.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiRelationFriendsTroopViewHelper$3.this$0).clear();
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      int i = 0;
      while ((i < this.jdField_a_of_type_JavaUtilArrayList.size()) && (i < 5))
      {
        RelationFriendsTroopViewHelper.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiRelationFriendsTroopViewHelper$3.this$0).add(this.jdField_a_of_type_JavaUtilArrayList.get(i));
        i += 1;
      }
    }
    RelationFriendsTroopViewHelper.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiRelationFriendsTroopViewHelper$3.this$0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.RelationFriendsTroopViewHelper.3.1
 * JD-Core Version:    0.7.0.1
 */