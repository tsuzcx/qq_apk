package com.tencent.mobileqq.utils;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;

public class QAVGroupConfig$GroupInviteFlag
{
  public String a;
  public boolean a;
  
  public static GroupInviteFlag a(Bundle paramBundle)
  {
    GroupInviteFlag localGroupInviteFlag = new GroupInviteFlag();
    localGroupInviteFlag.jdField_a_of_type_JavaLangString = paramBundle.getString("uin");
    localGroupInviteFlag.jdField_a_of_type_Boolean = paramBundle.getBoolean("enableInvite");
    return localGroupInviteFlag;
  }
  
  public static void a(String paramString1, QQAppInterface paramQQAppInterface, String paramString2)
  {
    boolean bool = QAVGroupConfig.a(paramString1, paramQQAppInterface, paramString2);
    paramString1 = new Intent();
    paramString1.setAction("tencent.video.q2v.GroupInfoChanged");
    paramString1.putExtra("uin", paramString2);
    paramString1.putExtra("enableInvite", bool);
    paramString1.setPackage(paramQQAppInterface.getApplication().getPackageName());
    paramQQAppInterface.getApp().sendBroadcast(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QAVGroupConfig.GroupInviteFlag
 * JD-Core Version:    0.7.0.1
 */