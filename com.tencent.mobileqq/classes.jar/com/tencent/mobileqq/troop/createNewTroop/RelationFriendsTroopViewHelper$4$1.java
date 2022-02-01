package com.tencent.mobileqq.troop.createNewTroop;

import bfod;
import bfoe;
import bfof;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class RelationFriendsTroopViewHelper$4$1
  implements Runnable
{
  public RelationFriendsTroopViewHelper$4$1(bfoe parambfoe, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      bfod.b(this.jdField_a_of_type_Bfoe.a).clear();
      int i = 0;
      if ((i < this.jdField_a_of_type_JavaUtilArrayList.size()) && (i < 5))
      {
        Object localObject = (RelationTroopEntity)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        bfod.b(this.jdField_a_of_type_Bfoe.a).add(localObject);
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder().append("updateRelationTroops entityname:");
          if (((RelationTroopEntity)localObject).troopInfo != null) {
            break label115;
          }
        }
        label115:
        for (localObject = "null";; localObject = ((RelationTroopEntity)localObject).troopInfo.getTroopName())
        {
          QLog.i("RelationFriendsTroopViewHelper", 2, (String)localObject);
          i += 1;
          break;
        }
      }
      bfod.a(this.jdField_a_of_type_Bfoe.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.RelationFriendsTroopViewHelper.4.1
 * JD-Core Version:    0.7.0.1
 */