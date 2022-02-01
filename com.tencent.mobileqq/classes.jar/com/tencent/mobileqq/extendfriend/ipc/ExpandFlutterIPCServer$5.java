package com.tencent.mobileqq.extendfriend.ipc;

import android.os.Bundle;
import com.google.gson.Gson;
import com.tencent.mobileqq.flutter.channel.expand.chat.ExpandChatRepository.GetConversationListCallback;
import com.tencent.mobileqq.flutter.channel.expand.chat.ExpandConverListResponse;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

class ExpandFlutterIPCServer$5
  implements ExpandChatRepository.GetConversationListCallback
{
  ExpandFlutterIPCServer$5(ExpandFlutterIPCServer paramExpandFlutterIPCServer, int paramInt) {}
  
  public void a(int paramInt, String paramString, ExpandConverListResponse paramExpandConverListResponse)
  {
    QLog.d("expand.ipc.ExpandFlutterIPCServer", 2, "getConversationList response " + paramInt + " callbackId" + this.jdField_a_of_type_Int);
    paramExpandConverListResponse = new Gson().toJson(paramExpandConverListResponse);
    paramString = new Bundle();
    paramString.putString("response", paramExpandConverListResponse);
    paramExpandConverListResponse = new EIPCResult();
    paramExpandConverListResponse.data = paramString;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendIpcExpandFlutterIPCServer.callbackResult(this.jdField_a_of_type_Int, paramExpandConverListResponse);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ipc.ExpandFlutterIPCServer.5
 * JD-Core Version:    0.7.0.1
 */