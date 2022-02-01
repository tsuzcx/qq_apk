package com.tencent.mobileqq.flutter.channel.expand.chat;

import android.os.Bundle;
import com.google.gson.Gson;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.ipc.ExpandFlutterIPCServer;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCServer;

class ExpandChatRepository$3$2
  implements Runnable
{
  ExpandChatRepository$3$2(ExpandChatRepository.3 param3, boolean paramBoolean, Card paramCard, int paramInt) {}
  
  public void run()
  {
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqDataCard == null))
    {
      QLog.w("expand.chat.ExpandChatRepository", 2, "onGetExtendFriendInfo success=" + this.jdField_a_of_type_Boolean);
      localObject = new Bundle();
      ((Bundle)localObject).putString("data", "");
      ((Bundle)localObject).putInt("seqNum", this.jdField_a_of_type_Int);
      QIPCServerHelper.getInstance().getServer().callClient(ExpandFlutterIPCServer.a(), 1, "ExpandFlutterIPCClient", "notifyGetExtendFriendInfoResponse", (Bundle)localObject);
      return;
    }
    QLog.d("expand.chat.ExpandChatRepository", 2, "onGetExtendFriendInfo success");
    Object localObject = new ExtendFriendInfo();
    ((ExtendFriendInfo)localObject).nickName = this.jdField_a_of_type_ComTencentMobileqqDataCard.strNick;
    ((ExtendFriendInfo)localObject).declaration = this.jdField_a_of_type_ComTencentMobileqqDataCard.declaration;
    ((ExtendFriendInfo)localObject).voiceUrl = this.jdField_a_of_type_ComTencentMobileqqDataCard.voiceUrl;
    localObject = new Gson().toJson(localObject);
    Bundle localBundle = new Bundle();
    localBundle.putString("data", (String)localObject);
    localBundle.putInt("seqNum", this.jdField_a_of_type_Int);
    QIPCServerHelper.getInstance().getServer().callClient(ExpandFlutterIPCServer.a(), 1, "ExpandFlutterIPCClient", "notifyGetExtendFriendInfoResponse", localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.expand.chat.ExpandChatRepository.3.2
 * JD-Core Version:    0.7.0.1
 */