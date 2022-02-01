package com.tencent.mobileqq.filemanager.fileviewer.open;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;

public class CommonFileBrowserParams
  extends BaseFileBrowserParams
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  
  public CommonFileBrowserParams(QQAppInterface paramQQAppInterface, Context paramContext, FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    super(paramQQAppInterface, paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    FileManagerUtil.b(paramFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private ForwardFileInfo a()
  {
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    localForwardFileInfo.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    localForwardFileInfo.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
    localForwardFileInfo.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath());
    localForwardFileInfo.b(this.jdField_a_of_type_Int);
    int i = this.jdField_a_of_type_Int;
    if (i != 10000)
    {
      if (i != 10001)
      {
        if (i != 10004) {
          return localForwardFileInfo;
        }
        String str;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) {
          str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        } else {
          str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
        }
        localForwardFileInfo.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType());
        if (str != null) {
          localForwardFileInfo.a(Long.valueOf(str.replace("+", "")).longValue());
        }
        localForwardFileInfo.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
        localForwardFileInfo.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid);
        return localForwardFileInfo;
      }
      localForwardFileInfo.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType());
      localForwardFileInfo.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
      localForwardFileInfo.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid);
      return localForwardFileInfo;
    }
    localForwardFileInfo.d(3);
    localForwardFileInfo.b(10000);
    return localForwardFileInfo;
  }
  
  private Intent b()
  {
    Intent localIntent = new Intent();
    Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
    if (localBundle != null) {
      localIntent.putExtras(localBundle);
    }
    return localIntent;
  }
  
  protected int a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.status;
    }
    return 0;
  }
  
  protected long a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.fileSize;
    }
    return 0L;
  }
  
  public Intent a()
  {
    ForwardFileInfo localForwardFileInfo = a();
    Intent localIntent = b();
    localIntent.putExtra("fileinfo", localForwardFileInfo);
    localIntent.putExtra("selfSet_leftViewText", HardCodeUtil.a(2131702406));
    return localIntent;
  }
  
  protected String a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.fileName;
    }
    return "";
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  protected String b()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.getFilePath();
    }
    return "";
  }
  
  public void b(Bundle paramBundle)
  {
    Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
    if ((localBundle != null) && (paramBundle != null))
    {
      if (localBundle.containsKey("file_color_note_subType")) {
        paramBundle.putInt("file_color_note_subType", this.jdField_a_of_type_AndroidOsBundle.getInt("file_color_note_subType", -1));
      }
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("FromChatHistoryTab")) {
        paramBundle.putInt("FromChatHistoryTab", this.jdField_a_of_type_AndroidOsBundle.getInt("FromChatHistoryTab", 0));
      }
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("file_location_pos_entrance_multiseq")) {
        paramBundle.putBoolean("file_location_pos_entrance_multiseq", this.jdField_a_of_type_AndroidOsBundle.getBoolean("file_location_pos_entrance_multiseq", false));
      }
    }
  }
  
  boolean c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 0) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 3)) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("id:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      localStringBuilder.append(" status:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status);
      localStringBuilder.append(" resume");
      QLog.i("FileVideo", 1, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    return true;
  }
  
  boolean d()
  {
    int i = FileManagerUtil.a(a());
    StringBuilder localStringBuilder;
    if (i != 2)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("id:");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
        localStringBuilder.append(" type is:");
        localStringBuilder.append(i);
        localStringBuilder.append(" use old filebrowser:");
        QLog.i("FileVideo", 1, localStringBuilder.toString());
      }
      return false;
    }
    boolean bool = FileManagerUtil.a(b());
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("id:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      localStringBuilder.append(" status:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status);
      localStringBuilder.append(" isLocal:");
      localStringBuilder.append(bool);
      QLog.i("FileVideo", 1, localStringBuilder.toString());
    }
    if ((!bool) && (QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin))) {
      return false;
    }
    return (!bool) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 1) || (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isSend());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.open.CommonFileBrowserParams
 * JD-Core Version:    0.7.0.1
 */