package com.tencent.mobileqq.newfriend.ui.adapter;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.newfriend.msg.QIMNotifyAddFriendMsg;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;

class NewFriendMoreSysMsgAdapter$13
  implements Runnable
{
  NewFriendMoreSysMsgAdapter$13(NewFriendMoreSysMsgAdapter paramNewFriendMoreSysMsgAdapter, NewFriendMessage paramNewFriendMessage) {}
  
  public void run()
  {
    ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).deleteQIMNotifyAddFriendData(((QIMNotifyAddFriendMsg)this.a).a, this.this$0.a);
    this.this$0.a.runOnUiThread(new NewFriendMoreSysMsgAdapter.13.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.adapter.NewFriendMoreSysMsgAdapter.13
 * JD-Core Version:    0.7.0.1
 */