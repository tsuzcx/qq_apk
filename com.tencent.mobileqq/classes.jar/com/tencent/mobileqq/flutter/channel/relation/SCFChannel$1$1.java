package com.tencent.mobileqq.flutter.channel.relation;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCClient;
import io.flutter.plugin.common.MethodChannel.Result;
import mqq.os.MqqHandler;

class SCFChannel$1$1
  implements Runnable
{
  SCFChannel$1$1(SCFChannel.1 param1, String paramString, Boolean paramBoolean, MethodChannel.Result paramResult) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("KEY_UIN", this.jdField_a_of_type_JavaLangString);
    localBundle.putInt("KEY_SCF_SWITCH_TYPE", 1);
    localBundle.putBoolean("KEY_SCF_SWITCH_STATUS", this.jdField_a_of_type_JavaLangBoolean.booleanValue());
    QIPCClientHelper.getInstance().getClient().callServer("FriendQIPCModule", "ACTION_SET_SAVE_SWITCH", localBundle);
    ThreadManager.getUIHandler().post(new SCFChannel.1.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.relation.SCFChannel.1.1
 * JD-Core Version:    0.7.0.1
 */