package com.tencent.mobileqq.troop.troopcreate.ui;

import com.tencent.mobileqq.troop.troopcreate.api.IRelationFriendsTroopViewHelper.CallBack;
import java.util.ArrayList;

class RelationFriendsTroopViewHelper$3$1
  implements Runnable
{
  RelationFriendsTroopViewHelper$3$1(RelationFriendsTroopViewHelper.3 param3, ArrayList paramArrayList) {}
  
  public void run()
  {
    RelationFriendsTroopViewHelper.a(this.b.this$0).clear();
    if (this.a.size() > 0)
    {
      int i = 0;
      while ((i < this.a.size()) && (i < 5))
      {
        RelationFriendsTroopViewHelper.a(this.b.this$0).add(this.a.get(i));
        i += 1;
      }
    }
    RelationFriendsTroopViewHelper.c(this.b.this$0).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.RelationFriendsTroopViewHelper.3.1
 * JD-Core Version:    0.7.0.1
 */