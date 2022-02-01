package com.tencent.mobileqq.troop.troopcreate.ui;

import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter;

class NewTroopContactView$2
  extends FriendObserver
{
  NewTroopContactView$2(NewTroopContactView paramNewTroopContactView) {}
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.a.y.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.NewTroopContactView.2
 * JD-Core Version:    0.7.0.1
 */