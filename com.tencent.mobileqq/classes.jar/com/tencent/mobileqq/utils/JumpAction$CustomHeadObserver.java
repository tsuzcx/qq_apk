package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Hashtable;

public class JumpAction$CustomHeadObserver
  extends AvatarObserver
{
  private final JumpAction b;
  
  public JumpAction$CustomHeadObserver(JumpAction paramJumpAction1, JumpAction paramJumpAction2)
  {
    this.b = paramJumpAction2;
  }
  
  public void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (this.a.jdField_a_of_type_JavaUtilHashtable == null) || (!this.a.jdField_a_of_type_JavaUtilHashtable.containsKey(paramString))) {}
    do
    {
      return;
      this.a.jdField_a_of_type_JavaUtilHashtable.remove(paramString);
      if (this.a.jdField_a_of_type_JavaUtilHashtable.size() == 0) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.a.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction$CustomHeadObserver);
      }
      Object localObject = Uri.parse(JumpAction.a(this.a) + "&uin=" + paramString);
      localObject = new Intent((String)this.a.jdField_a_of_type_JavaUtilHashMap.get("callback_name"), (Uri)localObject);
      this.a.jdField_a_of_type_AndroidContentContext.sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
    } while (!QLog.isColorLevel());
    QLog.i("JumpAction", 2, "download head " + paramString + " success. Send broadcast to " + (String)this.a.jdField_a_of_type_JavaUtilHashMap.get("callback_name"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpAction.CustomHeadObserver
 * JD-Core Version:    0.7.0.1
 */