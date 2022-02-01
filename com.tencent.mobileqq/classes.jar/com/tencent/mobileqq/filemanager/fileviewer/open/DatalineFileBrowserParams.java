package com.tencent.mobileqq.filemanager.fileviewer.open;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class DatalineFileBrowserParams
  extends BaseFileBrowserParams
{
  private Context jdField_a_of_type_AndroidContentContext;
  private FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private boolean d;
  
  public DatalineFileBrowserParams(QQAppInterface paramQQAppInterface, Context paramContext, FileManagerEntity paramFileManagerEntity)
  {
    super(paramQQAppInterface, paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
    this.d = false;
  }
  
  protected int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status;
    }
    return 0;
  }
  
  protected long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
    }
    return 0L;
  }
  
  public Intent a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      return null;
    }
    ForwardFileInfo localForwardFileInfo = ForwardFileOption.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    localForwardFileInfo.b(10009);
    Intent localIntent = new Intent();
    localIntent.putExtra("fileinfo", localForwardFileInfo);
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      localIntent.putStringArrayListExtra("Aio_SessionId_ImageList", this.jdField_a_of_type_JavaUtilArrayList);
    }
    localIntent.putExtra("_from_aio_", this.d);
    return localIntent;
  }
  
  protected String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName;
    }
    return "";
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  protected String b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath();
    }
    return "";
  }
  
  public boolean b()
  {
    return false;
  }
  
  boolean d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {}
    boolean bool;
    do
    {
      int i;
      do
      {
        return false;
        i = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
        if (i == 2) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("FileVideo", 1, "id:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + " type is:" + i + " use old filebrowser:");
      return false;
      bool = FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath);
      if (QLog.isColorLevel()) {
        QLog.i("FileVideo", 1, "id:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + " status:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status + " isLocal:" + bool);
      }
    } while ((!bool) || ((bool) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 1) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isSend())));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.open.DatalineFileBrowserParams
 * JD-Core Version:    0.7.0.1
 */