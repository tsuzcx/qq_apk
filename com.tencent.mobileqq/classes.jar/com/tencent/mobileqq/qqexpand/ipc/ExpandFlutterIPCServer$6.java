package com.tencent.mobileqq.qqexpand.ipc;

import android.os.Bundle;
import com.google.gson.Gson;
import com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExpandChatRepository.GetConversationListCallback;
import com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExpandConverListResponse;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

class ExpandFlutterIPCServer$6
  implements ExpandChatRepository.GetConversationListCallback
{
  ExpandFlutterIPCServer$6(ExpandFlutterIPCServer paramExpandFlutterIPCServer, int paramInt) {}
  
  public void a(int paramInt, String paramString, ExpandConverListResponse paramExpandConverListResponse)
  {
    paramString = new StringBuilder();
    paramString.append("getConversationList response ");
    paramString.append(paramInt);
    paramString.append(" callbackId");
    paramString.append(this.a);
    QLog.d("expand.ipc.ExpandFlutterIPCServer", 2, paramString.toString());
    paramExpandConverListResponse = new Gson().toJson(paramExpandConverListResponse);
    paramString = new Bundle();
    paramString.putString("response", paramExpandConverListResponse);
    paramExpandConverListResponse = new EIPCResult();
    paramExpandConverListResponse.data = paramString;
    this.b.callbackResult(this.a, paramExpandConverListResponse);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.ipc.ExpandFlutterIPCServer.6
 * JD-Core Version:    0.7.0.1
 */