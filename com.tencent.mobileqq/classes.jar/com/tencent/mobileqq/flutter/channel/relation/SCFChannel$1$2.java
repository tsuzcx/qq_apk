package com.tencent.mobileqq.flutter.channel.relation;

import android.os.Bundle;
import auek;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCClient;
import io.flutter.plugin.common.MethodChannel.Result;
import mqq.os.MqqHandler;

public class SCFChannel$1$2
  implements Runnable
{
  public SCFChannel$1$2(auek paramauek, String paramString, Boolean paramBoolean, MethodChannel.Result paramResult) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("KEY_UIN", this.jdField_a_of_type_JavaLangString);
    localBundle.putInt("KEY_SCF_SWITCH_TYPE", 3);
    localBundle.putBoolean("KEY_SCF_SWITCH_STATUS", this.jdField_a_of_type_JavaLangBoolean.booleanValue());
    QIPCClientHelper.getInstance().getClient().callServer("FriendQIPCModule", "ACTION_SET_SAVE_SWITCH", localBundle);
    ThreadManager.getUIHandler().post(new SCFChannel.1.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.relation.SCFChannel.1.2
 * JD-Core Version:    0.7.0.1
 */