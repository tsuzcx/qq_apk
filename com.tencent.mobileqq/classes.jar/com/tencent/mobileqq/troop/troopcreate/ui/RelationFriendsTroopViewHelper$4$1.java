package com.tencent.mobileqq.troop.troopcreate.ui;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.troopcreate.RelationTroopEntity;
import com.tencent.mobileqq.troop.troopcreate.api.IRelationFriendsTroopViewHelper.CallBack;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopSearchService.SearchResult;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class RelationFriendsTroopViewHelper$4$1
  implements Runnable
{
  RelationFriendsTroopViewHelper$4$1(RelationFriendsTroopViewHelper.4 param4, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      RelationFriendsTroopViewHelper.b(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiRelationFriendsTroopViewHelper$4.a).clear();
      int i = 0;
      while ((i < this.jdField_a_of_type_JavaUtilArrayList.size()) && (i < 5))
      {
        Object localObject = new RelationTroopEntity();
        ((RelationTroopEntity)localObject).troopInfo = ((ITroopSearchService.SearchResult)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a;
        RelationFriendsTroopViewHelper.b(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiRelationFriendsTroopViewHelper$4.a).add(localObject);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("updateRelationTroops entityname:");
          if (((RelationTroopEntity)localObject).troopInfo == null) {
            localObject = "null";
          } else {
            localObject = ((RelationTroopEntity)localObject).troopInfo.getTroopDisplayName();
          }
          localStringBuilder.append((String)localObject);
          QLog.i("RelationFriendsTroopViewHelper", 2, localStringBuilder.toString());
        }
        i += 1;
      }
      RelationFriendsTroopViewHelper.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiRelationFriendsTroopViewHelper$4.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.RelationFriendsTroopViewHelper.4.1
 * JD-Core Version:    0.7.0.1
 */