package com.tencent.mobileqq.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class JumpActionLegacy$12
  extends QidianBusinessObserver
{
  JumpActionLegacy$12(JumpActionLegacy paramJumpActionLegacy) {}
  
  protected void i(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if (paramHashMap == null) {
      return;
    }
    Object localObject = paramHashMap.get("ranKey");
    if ((localObject != null) && (this.jdField_a_of_type_Int != ((Integer)localObject).intValue())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    if (paramBoolean)
    {
      localObject = (String)paramHashMap.get("key_ext_uin");
      String str1 = (String)paramHashMap.get("key_sigt");
      String str2 = (String)paramHashMap.get("key_return_root");
      Intent localIntent = new Intent();
      if ((!TextUtils.isEmpty(str2)) && (!str2.equals("NO")))
      {
        localIntent.setComponent(new ComponentName(this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy.jdField_a_of_type_AndroidContentContext, SplashActivity.class));
        localIntent.putExtra("open_chatfragment", true);
      }
      else
      {
        localIntent.setComponent(new ComponentName(this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy.jdField_a_of_type_AndroidContentContext, ChatActivity.class));
      }
      localIntent.addFlags(67108864);
      int i = ((Integer)paramHashMap.get("key_aio_type")).intValue();
      if (localObject != null)
      {
        if (str1 != null) {
          localIntent.putExtra("sigt", HexUtil.hexStr2Bytes(str1));
        }
        if (i == 1)
        {
          if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b((String)localObject))
          {
            localIntent.putExtra("uintype", 0);
            localIntent.putExtra("uinname", ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject));
            if (QLog.isColorLevel()) {
              QLog.d("JumpAction", 2, "onAssignExt AIO_TYPE_EXT UIN_TYPE_FRIEND");
            }
          }
          else
          {
            localIntent.putExtra("uintype", 1025);
            localIntent.putExtra("from_wpa_for_crm", true);
            if (QLog.isColorLevel()) {
              QLog.d("JumpAction", 2, "onAssignExt AIO_TYPE_EXT UIN_TYPE_BUSINESS_CRM_EXT_TMP");
            }
          }
        }
        else
        {
          localIntent.putExtra("uintype", 1024);
          localIntent.putExtra("chat_subType", 1);
          if (QLog.isColorLevel()) {
            QLog.d("JumpAction", 2, "onAssignExt AIO_TYPE_MASTER");
          }
        }
        localIntent.putExtra("uin", (String)localObject);
        this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      }
    }
  }
  
  protected void j(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    if (paramHashMap != null)
    {
      int i;
      if (paramBoolean) {
        i = ((Integer)paramHashMap.get("key_aio_type")).intValue();
      } else {
        i = 2;
      }
      String str1 = (String)paramHashMap.get("key_sigt");
      String str2 = (String)paramHashMap.get("uin");
      paramHashMap = (String)paramHashMap.get("key_return_root");
      Intent localIntent = new Intent();
      if ((!TextUtils.isEmpty(paramHashMap)) && (!paramHashMap.equals("NO")))
      {
        localIntent.setComponent(new ComponentName(this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy.jdField_a_of_type_AndroidContentContext, SplashActivity.class));
        localIntent.putExtra("open_chatfragment", true);
      }
      else
      {
        localIntent.setComponent(new ComponentName(this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy.jdField_a_of_type_AndroidContentContext, ChatActivity.class));
      }
      localIntent.addFlags(67108864);
      if ((str1 != null) && (str2 != null)) {
        localIntent.putExtra("sigt", HexUtil.hexStr2Bytes(str1));
      }
      if (i == 1)
      {
        if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(str2))
        {
          localIntent.putExtra("uintype", 0);
          localIntent.putExtra("uinname", ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2));
          if (QLog.isColorLevel()) {
            QLog.d("JumpAction", 2, "onCorpUinWpaReport AIO_TYPE_EXT UIN_TYPE_FRIEND");
          }
        }
        else
        {
          localIntent.putExtra("uintype", 1025);
          localIntent.putExtra("from_wpa_for_crm", true);
          if (QLog.isColorLevel()) {
            QLog.d("JumpAction", 2, "onCorpUinWpaReport AIO_TYPE_EXT UIN_TYPE_BUSINESS_CRM_EXT_TMP");
          }
        }
      }
      else
      {
        localIntent.putExtra("uintype", 1024);
        localIntent.putExtra("chat_subType", 1);
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "onCorpUinWpaReport AIO_TYPE_MASTER");
        }
      }
      localIntent.putExtra("uin", str2);
      this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
  }
  
  protected void k(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    if ((paramBoolean) && (paramHashMap != null))
    {
      paramHashMap = (String)paramHashMap.get("cipher_text");
      this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy.jdField_a_of_type_JavaUtilHashMap.put("uin", paramHashMap);
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy.jdField_a_of_type_JavaUtilHashMap.containsKey("isPrivate")) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy.jdField_a_of_type_JavaUtilHashMap.remove("isPrivate");
      }
      JumpActionLegacy.g(this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy);
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, BaseApplicationImpl.getContext().getString(2131718218), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpActionLegacy.12
 * JD-Core Version:    0.7.0.1
 */