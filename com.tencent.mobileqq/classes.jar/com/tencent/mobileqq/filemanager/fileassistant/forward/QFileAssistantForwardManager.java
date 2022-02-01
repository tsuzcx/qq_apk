package com.tencent.mobileqq.filemanager.fileassistant.forward;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.qphone.base.util.BaseApplication;

public class QFileAssistantForwardManager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  
  public QFileAssistantForwardManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void b(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131692688);
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      ThreadManagerV2.getUIHandlerV2().postDelayed(new QFileAssistantForwardManager.1(this, paramString), 300L);
      return;
      paramString = str;
    }
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return;
    }
    FileManagerEngine localFileManagerEngine = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine();
    if (paramFileManagerEntity.getCloudType() == 4)
    {
      long l1 = paramFileManagerEntity.TroopUin;
      long l2 = Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue();
      localFileManagerEngine.a(paramFileManagerEntity.nSessionId, paramFileManagerEntity.strFilePath, l1, l2, 0, 0);
    }
    for (;;)
    {
      b("");
      return;
      localFileManagerEngine.a(paramFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_JavaLangString, 0, true);
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", -1);
    localBundle.putString("forward_text", paramString);
    localBundle.putBoolean("forward _key_nojump", true);
    localBundle.putInt("uintype", 0);
    localBundle.putString("uin", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("uinname", BaseApplicationImpl.getContext().getString(2131698224));
    localBundle.putInt("key_forward_ability_type", ForwardAbility.ForwardAbilityType.a.intValue());
    localIntent.putExtras(localBundle);
    ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, BaseApplicationImpl.getContext(), localIntent, null);
    b("");
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.forward.QFileAssistantForwardManager
 * JD-Core Version:    0.7.0.1
 */