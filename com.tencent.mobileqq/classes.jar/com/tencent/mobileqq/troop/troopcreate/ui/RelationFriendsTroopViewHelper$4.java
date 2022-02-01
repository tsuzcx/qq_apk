package com.tencent.mobileqq.troop.troopcreate.ui;

import com.tencent.mobileqq.troop.troopcreate.api.ITroopSearchService.SearchResult;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopSearchService.TroopSearchCallback;
import com.tencent.widget.PinnedFooterExpandableListView;
import java.util.ArrayList;

class RelationFriendsTroopViewHelper$4
  implements ITroopSearchService.TroopSearchCallback
{
  RelationFriendsTroopViewHelper$4(RelationFriendsTroopViewHelper paramRelationFriendsTroopViewHelper) {}
  
  public void a(ArrayList<ITroopSearchService.SearchResult> paramArrayList)
  {
    if (this.a.c != null) {
      this.a.c.post(new RelationFriendsTroopViewHelper.4.1(this, paramArrayList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.RelationFriendsTroopViewHelper.4
 * JD-Core Version:    0.7.0.1
 */