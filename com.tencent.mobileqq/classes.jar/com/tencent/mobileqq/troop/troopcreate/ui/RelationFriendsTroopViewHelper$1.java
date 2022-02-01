package com.tencent.mobileqq.troop.troopcreate.ui;

import com.tencent.mobileqq.troop.troopcreate.api.IRelationFriendsTroopViewHelper.CallBack;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class RelationFriendsTroopViewHelper$1
  implements Runnable
{
  RelationFriendsTroopViewHelper$1(RelationFriendsTroopViewHelper paramRelationFriendsTroopViewHelper) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RelationFriendsTroopViewHelper", 2, "onSearchResult lastRecord null");
    }
    RelationFriendsTroopViewHelper.a(this.this$0, "");
    RelationFriendsTroopViewHelper.a(this.this$0).clear();
    RelationFriendsTroopViewHelper.b(this.this$0).clear();
    RelationFriendsTroopViewHelper.a(this.this$0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.RelationFriendsTroopViewHelper.1
 * JD-Core Version:    0.7.0.1
 */