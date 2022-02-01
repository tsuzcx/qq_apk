package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.troop.createNewTroop.RelationTroopEntity;
import com.tencent.mobileqq.troop.logic.TroopSearchLogic.SearchResult;
import com.tencent.mobileqq.troop.logic.TroopSearchLogic.TroopSearchCallback;
import java.util.ArrayList;

class TroopCreateLogic$2
  implements TroopSearchLogic.TroopSearchCallback
{
  TroopCreateLogic$2(TroopCreateLogic paramTroopCreateLogic, TroopCreateLogic.RelationTroopsCallback paramRelationTroopsCallback) {}
  
  public void a(ArrayList<TroopSearchLogic.SearchResult> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      RelationTroopEntity localRelationTroopEntity = new RelationTroopEntity();
      localRelationTroopEntity.troopInfo = ((TroopSearchLogic.SearchResult)paramArrayList.get(i)).a;
      localArrayList.add(localRelationTroopEntity);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$RelationTroopsCallback.a(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopCreateLogic.2
 * JD-Core Version:    0.7.0.1
 */