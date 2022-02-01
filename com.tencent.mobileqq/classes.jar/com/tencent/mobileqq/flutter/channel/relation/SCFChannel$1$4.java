package com.tencent.mobileqq.flutter.channel.relation;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import io.flutter.plugin.common.MethodChannel.Result;
import mqq.os.MqqHandler;

class SCFChannel$1$4
  implements Runnable
{
  SCFChannel$1$4(SCFChannel.1 param1, String paramString, MethodChannel.Result paramResult) {}
  
  public void run()
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("KEY_UIN", this.a);
    localObject = QIPCClientHelper.getInstance().getClient().callServer("FriendQIPCModule", "ACTION_GET_SCF_RING_NAME", (Bundle)localObject);
    if (((EIPCResult)localObject).isSuccess()) {
      localObject = ((EIPCResult)localObject).data.getString("KEY_SCF_RING_NAME");
    } else {
      localObject = "";
    }
    if (QLog.isColorLevel()) {
      QLog.d("flutter.SCFSettingChannel", 2, String.format("getSpecialRing, ringName: %s", new Object[] { localObject }));
    }
    ThreadManager.getUIHandler().post(new SCFChannel.1.4.1(this, (String)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.relation.SCFChannel.1.4
 * JD-Core Version:    0.7.0.1
 */