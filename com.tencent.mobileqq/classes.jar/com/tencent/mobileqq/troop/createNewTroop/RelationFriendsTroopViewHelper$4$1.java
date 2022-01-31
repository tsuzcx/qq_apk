package com.tencent.mobileqq.troop.createNewTroop;

import bbjz;
import bbka;
import bbkb;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class RelationFriendsTroopViewHelper$4$1
  implements Runnable
{
  public RelationFriendsTroopViewHelper$4$1(bbka parambbka, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      bbjz.b(this.jdField_a_of_type_Bbka.a).clear();
      int i = 0;
      if ((i < this.jdField_a_of_type_JavaUtilArrayList.size()) && (i < 5))
      {
        Object localObject = (RelationTroopEntity)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        bbjz.b(this.jdField_a_of_type_Bbka.a).add(localObject);
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
      bbjz.a(this.jdField_a_of_type_Bbka.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.RelationFriendsTroopViewHelper.4.1
 * JD-Core Version:    0.7.0.1
 */