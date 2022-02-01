package com.tencent.mobileqq.newfriend.ui.adapter;

import android.os.Bundle;
import com.tencent.mobileqq.app.AddBatchPhoneFriendResult;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import friendlist.EAddFriendSourceID;
import java.util.ArrayList;

class NewFriendMoreSysMsgAdapter$7
  extends FriendObserver
{
  NewFriendMoreSysMsgAdapter$7(NewFriendMoreSysMsgAdapter paramNewFriendMoreSysMsgAdapter) {}
  
  public void onAddBatchPhoneFriend(boolean paramBoolean, ArrayList<AddBatchPhoneFriendResult> paramArrayList)
  {
    if (paramBoolean) {
      NewFriendMoreSysMsgAdapter.c(this.a);
    }
  }
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if ((paramBoolean1) && (EAddFriendSourceID.a(paramBundle.getInt("source_id")))) {
      NewFriendMoreSysMsgAdapter.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.adapter.NewFriendMoreSysMsgAdapter.7
 * JD-Core Version:    0.7.0.1
 */