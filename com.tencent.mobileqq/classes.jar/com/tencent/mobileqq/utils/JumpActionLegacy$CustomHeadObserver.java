package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Hashtable;

public class JumpActionLegacy$CustomHeadObserver
  extends AvatarObserver
{
  private final JumpAction jdField_a_of_type_ComTencentMobileqqUtilsJumpAction;
  
  public JumpActionLegacy$CustomHeadObserver(JumpActionLegacy paramJumpActionLegacy, JumpAction paramJumpAction)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction = paramJumpAction;
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy.jdField_a_of_type_JavaUtilHashtable != null))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy.jdField_a_of_type_JavaUtilHashtable.containsKey(paramString)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy.jdField_a_of_type_JavaUtilHashtable.remove(paramString);
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy.jdField_a_of_type_JavaUtilHashtable.size() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy$CustomHeadObserver);
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy.b());
      ((StringBuilder)localObject).append("&uin=");
      ((StringBuilder)localObject).append(paramString);
      localObject = Uri.parse(((StringBuilder)localObject).toString());
      localObject = new Intent((String)this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy.jdField_a_of_type_JavaUtilHashMap.get("callback_name"), (Uri)localObject);
      this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy.jdField_a_of_type_AndroidContentContext.sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("download head ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" success. Send broadcast to ");
        ((StringBuilder)localObject).append((String)this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy.jdField_a_of_type_JavaUtilHashMap.get("callback_name"));
        QLog.i("JumpAction", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpActionLegacy.CustomHeadObserver
 * JD-Core Version:    0.7.0.1
 */