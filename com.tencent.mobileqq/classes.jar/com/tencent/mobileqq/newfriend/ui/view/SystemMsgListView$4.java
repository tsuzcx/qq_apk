package com.tencent.mobileqq.newfriend.ui.view;

import android.os.Bundle;
import com.tencent.mobileqq.app.AddBatchPhoneFriendResult;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
import friendlist.EAddFriendSourceID;
import java.util.ArrayList;

class SystemMsgListView$4
  extends FriendObserver
{
  SystemMsgListView$4(SystemMsgListView paramSystemMsgListView) {}
  
  public void onAddBatchPhoneFriend(boolean paramBoolean, ArrayList<AddBatchPhoneFriendResult> paramArrayList)
  {
    if (paramBoolean) {
      SystemMsgListView.a(this.a).c();
    }
  }
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if (paramBoolean1)
    {
      paramString = paramBundle.getString("uin");
      int i = paramBundle.getInt("source_id");
      paramBundle = paramBundle.getString("extra");
      if (((i == 3006) || (i == 3075)) && ("ContactMatchBuilder".equals(paramBundle))) {
        this.a.a(paramString);
      }
      if (EAddFriendSourceID.a(i)) {
        SystemMsgListView.a(this.a).c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.view.SystemMsgListView.4
 * JD-Core Version:    0.7.0.1
 */