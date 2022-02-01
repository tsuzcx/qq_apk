package com.tencent.mobileqq.extendfriend.wiget;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.extendfriend.bean.ExtendFriendSignalBombCardData;
import com.tencent.mobileqq.extendfriend.bean.MatchInfo;
import com.tencent.mobileqq.limitchat.LimitChatUtil;
import com.tencent.mobileqq.matchchat.MatchChatMsgUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;

class ExtendFriendSignalBombDialog$1
  implements Runnable
{
  ExtendFriendSignalBombDialog$1(ExtendFriendSignalBombDialog paramExtendFriendSignalBombDialog) {}
  
  public void run()
  {
    Object localObject;
    if (ExtendFriendSignalBombDialog.a(this.this$0) != null)
    {
      QLog.d("ExtendFriendSignalBombDialog", 2, " handle data signal bomb dialog ");
      if (!LimitChatUtil.a(ExtendFriendSignalBombDialog.a(this.this$0), ExtendFriendSignalBombDialog.a(this.this$0).a, 1044)) {
        break label112;
      }
      localObject = ExtendFriendSignalBombCardData.a(ExtendFriendSignalBombDialog.a(this.this$0));
      ((MatchInfo)localObject).a = MessageCache.a();
      LimitChatUtil.a(ExtendFriendSignalBombDialog.a(this.this$0), (MatchInfo)localObject, ((MatchInfo)localObject).a, 2);
    }
    for (;;)
    {
      localObject = MatchChatMsgUtil.a(this.this$0.getContext(), ExtendFriendSignalBombDialog.a(this.this$0).a);
      this.this$0.getContext().startActivity((Intent)localObject);
      return;
      label112:
      QLog.d("ExtendFriendSignalBombDialog", 2, " handle data signal bomb dialog not last topic ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendSignalBombDialog.1
 * JD-Core Version:    0.7.0.1
 */