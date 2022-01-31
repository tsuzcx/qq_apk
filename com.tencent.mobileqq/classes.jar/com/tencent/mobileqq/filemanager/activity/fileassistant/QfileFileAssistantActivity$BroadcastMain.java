package com.tencent.mobileqq.filemanager.activity.fileassistant;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;

public class QfileFileAssistantActivity$BroadcastMain
  extends BroadcastReceiver
{
  public QfileFileAssistantActivity$BroadcastMain(QfileFileAssistantActivity paramQfileFileAssistantActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("com.tencent.fileassistant.createshrotcut")) {
      FMToastUtil.b(2131428092);
    }
    while (!paramIntent.getAction().equals("com.tencent.process.stopping")) {
      return;
    }
    paramContext.getSharedPreferences("Offline_Flags", 0).edit().clear().commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileassistant.QfileFileAssistantActivity.BroadcastMain
 * JD-Core Version:    0.7.0.1
 */