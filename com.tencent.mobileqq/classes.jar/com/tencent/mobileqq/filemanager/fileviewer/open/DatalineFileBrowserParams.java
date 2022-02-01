package com.tencent.mobileqq.filemanager.fileviewer.open;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = ForwardFileOption.a((FileManagerEntity)localObject1);
    ((ForwardFileInfo)localObject2).b(10009);
    localObject1 = new Intent();
    ((Intent)localObject1).putExtra("fileinfo", (Parcelable)localObject2);
    localObject2 = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0)) {
      ((Intent)localObject1).putStringArrayListExtra("Aio_SessionId_ImageList", this.jdField_a_of_type_JavaUtilArrayList);
    }
    ((Intent)localObject1).putExtra("_from_aio_", this.d);
    return localObject1;
  }
  
  protected String a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.fileName;
    }
    return "";
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  protected String b()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.getFilePath();
    }
    return "";
  }
  
  public boolean b()
  {
    return false;
  }
  
  boolean d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localObject == null) {
      return false;
    }
    int i = FileManagerUtil.a(((FileManagerEntity)localObject).fileName);
    if (i != 2)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("id:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
        ((StringBuilder)localObject).append(" type is:");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" use old filebrowser:");
        QLog.i("FileVideo", 1, ((StringBuilder)localObject).toString());
      }
      return false;
    }
    boolean bool = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("id:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      ((StringBuilder)localObject).append(" status:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status);
      ((StringBuilder)localObject).append(" isLocal:");
      ((StringBuilder)localObject).append(bool);
      QLog.i("FileVideo", 1, ((StringBuilder)localObject).toString());
    }
    if (!bool) {
      return false;
    }
    return (!bool) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 1) || (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isSend());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.open.DatalineFileBrowserParams
 * JD-Core Version:    0.7.0.1
 */