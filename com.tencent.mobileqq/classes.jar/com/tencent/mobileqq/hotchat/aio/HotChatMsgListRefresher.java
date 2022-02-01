package com.tencent.mobileqq.hotchat.aio;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListRefresher;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatContext;

public class HotChatMsgListRefresher
  extends MsgListRefresher
{
  public HotChatMsgListRefresher(@NonNull AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  public void e()
  {
    super.e();
    if (((HotChatContext)this.a).Q() == 2) {
      this.a.e().b().b(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.aio.HotChatMsgListRefresher
 * JD-Core Version:    0.7.0.1
 */