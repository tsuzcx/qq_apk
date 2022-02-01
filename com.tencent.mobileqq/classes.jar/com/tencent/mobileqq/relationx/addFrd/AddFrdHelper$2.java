package com.tencent.mobileqq.relationx.addFrd;

import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListObserver;

class AddFrdHelper$2
  extends FriendListObserver
{
  AddFrdHelper$2(AddFrdHelper paramAddFrdHelper) {}
  
  public void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      this.a.a(1, paramString);
    }
  }
  
  public void onUpdateAnswerAddedFriend(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramBoolean) {
      this.a.a(1, paramString);
    }
  }
  
  public void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      this.a.a(2, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.addFrd.AddFrdHelper.2
 * JD-Core Version:    0.7.0.1
 */