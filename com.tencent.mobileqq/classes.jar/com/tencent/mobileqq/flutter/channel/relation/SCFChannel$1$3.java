package com.tencent.mobileqq.flutter.channel.relation;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import io.flutter.plugin.common.MethodChannel.Result;
import mqq.os.MqqHandler;

class SCFChannel$1$3
  implements Runnable
{
  SCFChannel$1$3(SCFChannel.1 param1, String paramString, MethodChannel.Result paramResult) {}
  
  public void run()
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("KEY_UIN", this.a);
    localObject = QIPCClientHelper.getInstance().getClient().callServer("FriendQIPCModule", "ACTION_GET_SPECIAL_CARE_INFO", (Bundle)localObject);
    boolean bool = ((EIPCResult)localObject).isSuccess();
    SpecialCareInfo localSpecialCareInfo = null;
    if (bool) {
      localObject = ((EIPCResult)localObject).data;
    } else {
      localObject = null;
    }
    if (localObject != null) {
      localSpecialCareInfo = (SpecialCareInfo)((Bundle)localObject).getParcelable("KEY_SCF_INFO");
    }
    if ((localObject != null) && (((Bundle)localObject).getBoolean("KEY_SCF_VOICE_NEW_FLAG"))) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool) {
      VasWebviewUtil.a(this.c.a.e(), "Care", "RedShow", "", 1, 0, 0, null, null, null);
    }
    if (QLog.isColorLevel()) {
      QLog.d("flutter.SCFSettingChannel", 2, String.format("getSCFSwitchs, from main process: %s, isVoiceNewFlag: %s", new Object[] { localSpecialCareInfo, Boolean.valueOf(bool) }));
    }
    ThreadManager.getUIHandler().post(new SCFChannel.1.3.1(this, localSpecialCareInfo, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.relation.SCFChannel.1.3
 * JD-Core Version:    0.7.0.1
 */