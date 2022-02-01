package com.tencent.mobileqq.selectmember;

import com.tencent.mobileqq.friend.observer.IFriendObserver;

class FriendTeamListInnerFrame$4
  implements IFriendObserver
{
  FriendTeamListInnerFrame$4(FriendTeamListInnerFrame paramFriendTeamListInnerFrame) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      FriendTeamListInnerFrame.b(this.a).notifyDataSetChanged();
    }
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    boolean bool = true;
    if (paramInt == 1)
    {
      if ((!paramBoolean) || (!((Boolean)paramObject).booleanValue())) {
        bool = false;
      }
      a(paramBoolean, bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.FriendTeamListInnerFrame.4
 * JD-Core Version:    0.7.0.1
 */