package com.tencent.mobileqq.troop.createNewTroop;

import com.tencent.mobileqq.app.FriendListObserver;

class NewTroopContactView$2
  extends FriendListObserver
{
  NewTroopContactView$2(NewTroopContactView paramNewTroopContactView) {}
  
  public void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.NewTroopContactView.2
 * JD-Core Version:    0.7.0.1
 */