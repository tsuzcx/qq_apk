package com.tencent.mobileqq.filemanager.fileviewer.FileViewAdapter;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewerAdapterBase;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;

public class WeiyunFileViewerAdapter
  extends FileViewerAdapterBase
{
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  private WeiYunFileInfo jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo;
  
  public WeiyunFileViewerAdapter(QQAppInterface paramQQAppInterface, WeiYunFileInfo paramWeiYunFileInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo = paramWeiYunFileInfo;
  }
  
  private void a(FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
    QQFileManagerUtil.c(paramFileManagerEntity);
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.c.toLowerCase().endsWith("heic"))) {
      return 0;
    }
    return FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.c);
  }
  
  public long a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.nSessionId;
    }
    return -1L;
  }
  
  public FileManagerEntity a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localObject1 != null) {
      return localObject1;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerRSCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.jdField_a_of_type_JavaLangString);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.jdField_a_of_type_JavaLangString);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo);
    }
    if (localObject2 != null) {
      a((FileManagerEntity)localObject2);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  }
  
  public WeiYunFileInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.c;
  }
  
  public void a(String paramString)
  {
    b(paramString);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    return 0;
  }
  
  public long b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.jdField_a_of_type_Long;
  }
  
  public String b()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if ((localFileManagerEntity != null) && (localFileManagerEntity.nFileType == 5) && (FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath()))) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath();
    }
    return null;
  }
  
  public void b(String paramString)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity != null)
    {
      localFileManagerEntity.strThumbPath = paramString;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.h = paramString;
  }
  
  public int c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    int i;
    if (localObject != null)
    {
      i = ((FileManagerEntity)localObject).getCloudType();
    }
    else
    {
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerRSCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.jdField_a_of_type_JavaLangString);
      localObject = localFileManagerEntity;
      if (localFileManagerEntity == null) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.jdField_a_of_type_JavaLangString);
      }
      if (localObject != null)
      {
        a((FileManagerEntity)localObject);
        i = ((FileManagerEntity)localObject).getCloudType();
      }
      else
      {
        i = 2;
      }
    }
    int j = i;
    if (2 == i)
    {
      j = i;
      if (FileUtil.a(g())) {
        j = 3;
      }
    }
    return j;
  }
  
  public long c()
  {
    return MessageCache.a() * 1000L;
  }
  
  public String c()
  {
    return null;
  }
  
  public int d()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.status;
    }
    if (QLog.isDevelopLevel()) {
      QLog.w("WeiyunFileViewerAdapter", 4, "getFileStatus: has not status");
    }
    return -1;
  }
  
  public String d()
  {
    return null;
  }
  
  public int e()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("WeiyunFileViewerAdapter", 4, "getOpType: has not opType");
    }
    return -1;
  }
  
  public String e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.jdField_a_of_type_JavaLangString;
  }
  
  public String f()
  {
    return h();
  }
  
  public String g()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localObject != null) {
      return ((FileManagerEntity)localObject).getFilePath();
    }
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerRSCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.jdField_a_of_type_JavaLangString);
    localObject = localFileManagerEntity;
    if (localFileManagerEntity == null) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.jdField_a_of_type_JavaLangString);
    }
    if (localObject != null)
    {
      a((FileManagerEntity)localObject);
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath();
    }
    return null;
  }
  
  public String h()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localObject != null)
    {
      if (FileUtil.a(((FileManagerEntity)localObject).getFilePath())) {
        return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath();
      }
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strThumbPath;
    }
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerRSCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.jdField_a_of_type_JavaLangString);
    localObject = localFileManagerEntity;
    if (localFileManagerEntity == null) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.jdField_a_of_type_JavaLangString);
    }
    if (localObject != null)
    {
      a((FileManagerEntity)localObject);
      if (FileUtil.a(((FileManagerEntity)localObject).getFilePath())) {
        return ((FileManagerEntity)localObject).getFilePath();
      }
      return ((FileManagerEntity)localObject).strThumbPath;
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.h;
  }
  
  public String i()
  {
    return FileUtil.a(b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileViewAdapter.WeiyunFileViewerAdapter
 * JD-Core Version:    0.7.0.1
 */