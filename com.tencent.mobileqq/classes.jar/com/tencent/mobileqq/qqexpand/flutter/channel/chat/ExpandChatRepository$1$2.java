package com.tencent.mobileqq.qqexpand.flutter.channel.chat;

import android.os.Bundle;
import com.google.gson.Gson;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qqexpand.ipc.IExpandFlutterIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCServer;

class ExpandChatRepository$1$2
  implements Runnable
{
  ExpandChatRepository$1$2(ExpandChatRepository.1 param1, boolean paramBoolean, Card paramCard, int paramInt) {}
  
  public void run()
  {
    if ((this.a) && (this.b != null))
    {
      QLog.d("expand.chat.ExpandChatRepository", 2, "onGetExtendFriendInfo success");
      localObject = new ExtendFriendInfo();
      ((ExtendFriendInfo)localObject).nickName = this.b.strNick;
      ((ExtendFriendInfo)localObject).declaration = this.b.declaration;
      ((ExtendFriendInfo)localObject).voiceUrl = this.b.voiceUrl;
      localObject = new Gson().toJson(localObject);
      Bundle localBundle = new Bundle();
      localBundle.putString("data", (String)localObject);
      localBundle.putInt("seqNum", this.c);
      QIPCServerHelper.getInstance().getServer().callClient(((IExpandFlutterIPCServerHelper)QRoute.api(IExpandFlutterIPCServerHelper.class)).getProcessName(), 1, "ExpandFlutterIPCClient", "notifyGetExtendFriendInfoResponse", localBundle);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onGetExtendFriendInfo success=");
    ((StringBuilder)localObject).append(this.a);
    QLog.w("expand.chat.ExpandChatRepository", 2, ((StringBuilder)localObject).toString());
    localObject = new Bundle();
    ((Bundle)localObject).putString("data", "");
    ((Bundle)localObject).putInt("seqNum", this.c);
    QIPCServerHelper.getInstance().getServer().callClient(((IExpandFlutterIPCServerHelper)QRoute.api(IExpandFlutterIPCServerHelper.class)).getProcessName(), 1, "ExpandFlutterIPCClient", "notifyGetExtendFriendInfoResponse", (Bundle)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExpandChatRepository.1.2
 * JD-Core Version:    0.7.0.1
 */