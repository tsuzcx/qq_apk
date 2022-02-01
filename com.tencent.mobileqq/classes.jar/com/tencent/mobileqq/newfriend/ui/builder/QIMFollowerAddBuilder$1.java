package com.tencent.mobileqq.newfriend.ui.builder;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl;
import com.tencent.mobileqq.newfriend.msg.QIMFollowMessage;

class QIMFollowerAddBuilder$1
  implements Runnable
{
  QIMFollowerAddBuilder$1(QIMFollowerAddBuilder paramQIMFollowerAddBuilder) {}
  
  public void run()
  {
    ((NewFriendServiceImpl)this.this$0.d.getRuntimeService(INewFriendService.class, "")).deleteQIMFollowerAdd(((QIMFollowMessage)this.this$0.g).a);
    this.this$0.d.runOnUiThread(new QIMFollowerAddBuilder.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.builder.QIMFollowerAddBuilder.1
 * JD-Core Version:    0.7.0.1
 */