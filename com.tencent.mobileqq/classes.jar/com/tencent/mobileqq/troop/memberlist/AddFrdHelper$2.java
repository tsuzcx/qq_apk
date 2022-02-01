package com.tencent.mobileqq.troop.memberlist;

import android.os.Bundle;
import com.tencent.mobileqq.friend.observer.FriendObserver;

class AddFrdHelper$2
  extends FriendObserver
{
  AddFrdHelper$2(AddFrdHelper paramAddFrdHelper) {}
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      this.a.a(1, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.memberlist.AddFrdHelper.2
 * JD-Core Version:    0.7.0.1
 */