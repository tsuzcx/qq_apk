package com.tencent.mobileqq.flutter.channel.relation;

import android.os.Bundle;
import aunc;
import aund;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import io.flutter.plugin.common.MethodChannel.Result;
import mqq.os.MqqHandler;

public class SCFChannel$1$3
  implements Runnable
{
  public SCFChannel$1$3(aund paramaund, String paramString, MethodChannel.Result paramResult) {}
  
  public void run()
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("KEY_UIN", this.jdField_a_of_type_JavaLangString);
    localObject = QIPCClientHelper.getInstance().getClient().callServer("FriendQIPCModule", "ACTION_GET_SPECIAL_CARE_INFO", (Bundle)localObject);
    SpecialCareInfo localSpecialCareInfo;
    if (((EIPCResult)localObject).isSuccess())
    {
      localObject = ((EIPCResult)localObject).data;
      if (localObject == null) {
        break label158;
      }
      localSpecialCareInfo = (SpecialCareInfo)((Bundle)localObject).getParcelable("KEY_SCF_INFO");
      label59:
      if ((localObject == null) || (!((Bundle)localObject).getBoolean("KEY_SCF_VOICE_NEW_FLAG"))) {
        break label163;
      }
    }
    label158:
    label163:
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_Aund.a.b(), "Care", "RedShow", "", 1, 0, 0, null, null, null);
      }
      if (QLog.isColorLevel()) {
        QLog.d("flutter.SCFSettingChannel", 2, String.format("getSCFSwitchs, from main process: %s, isVoiceNewFlag: %s", new Object[] { localSpecialCareInfo, Boolean.valueOf(bool) }));
      }
      ThreadManager.getUIHandler().post(new SCFChannel.1.3.1(this, localSpecialCareInfo, bool));
      return;
      localObject = null;
      break;
      localSpecialCareInfo = null;
      break label59;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.relation.SCFChannel.1.3
 * JD-Core Version:    0.7.0.1
 */