package com.tencent.mobileqq.troop.createNewTroop;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.troop.data.TroopCreateLogic.RelationTroopsCallback;
import com.tencent.widget.PinnedFooterExpandableListView;
import java.util.ArrayList;

class RelationFriendsTroopViewHelper$4
  implements TroopCreateLogic.RelationTroopsCallback
{
  RelationFriendsTroopViewHelper$4(RelationFriendsTroopViewHelper paramRelationFriendsTroopViewHelper) {}
  
  public void a(ArrayList<Entity> paramArrayList)
  {
    if (this.a.a != null) {
      this.a.a.post(new RelationFriendsTroopViewHelper.4.1(this, paramArrayList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.RelationFriendsTroopViewHelper.4
 * JD-Core Version:    0.7.0.1
 */