package com.tencent.mobileqq.newfriend.ui.builder;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.newfriend.msg.QIMNotifyAddFriendMsg;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;

class QIMNotifyAddFriendBuilder$1
  implements Runnable
{
  QIMNotifyAddFriendBuilder$1(QIMNotifyAddFriendBuilder paramQIMNotifyAddFriendBuilder) {}
  
  public void run()
  {
    ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).deleteQIMNotifyAddFriendData(((QIMNotifyAddFriendMsg)this.this$0.g).a, this.this$0.d);
    this.this$0.d.runOnUiThread(new QIMNotifyAddFriendBuilder.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.builder.QIMNotifyAddFriendBuilder.1
 * JD-Core Version:    0.7.0.1
 */