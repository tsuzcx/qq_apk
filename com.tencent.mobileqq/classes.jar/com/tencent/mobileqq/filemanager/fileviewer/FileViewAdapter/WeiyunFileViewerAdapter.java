package com.tencent.mobileqq.filemanager.fileviewer.FileViewAdapter;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewerAdapterBase;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
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
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
    }
    return -1L;
  }
  
  public FileManagerEntity a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerRSCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.jdField_a_of_type_JavaLangString);
    Object localObject1 = localObject2;
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
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 5)
      {
        localObject1 = localObject2;
        if (FileUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath())) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath();
        }
      }
    }
    return localObject1;
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strThumbPath = paramString;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.h = paramString;
  }
  
  public int c()
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) {
      i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType();
    }
    for (;;)
    {
      int j = i;
      if (2 == i)
      {
        j = i;
        if (FileUtil.b(g())) {
          j = 3;
        }
      }
      return j;
      FileManagerEntity localFileManagerEntity2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerRSCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.jdField_a_of_type_JavaLangString);
      FileManagerEntity localFileManagerEntity1 = localFileManagerEntity2;
      if (localFileManagerEntity2 == null) {
        localFileManagerEntity1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.jdField_a_of_type_JavaLangString);
      }
      if (localFileManagerEntity1 != null)
      {
        a(localFileManagerEntity1);
        i = localFileManagerEntity1.getCloudType();
      }
      else
      {
        i = 2;
      }
    }
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
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status;
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
  
  public String g()
  {
    String str = null;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) {
      str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath();
    }
    FileManagerEntity localFileManagerEntity1;
    do
    {
      return str;
      FileManagerEntity localFileManagerEntity2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerRSCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.jdField_a_of_type_JavaLangString);
      localFileManagerEntity1 = localFileManagerEntity2;
      if (localFileManagerEntity2 == null) {
        localFileManagerEntity1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.jdField_a_of_type_JavaLangString);
      }
    } while (localFileManagerEntity1 == null);
    a(localFileManagerEntity1);
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath();
  }
  
  public String h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)
    {
      if (FileUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath())) {
        return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath();
      }
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strThumbPath;
    }
    FileManagerEntity localFileManagerEntity2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerRSCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.jdField_a_of_type_JavaLangString);
    FileManagerEntity localFileManagerEntity1 = localFileManagerEntity2;
    if (localFileManagerEntity2 == null) {
      localFileManagerEntity1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.jdField_a_of_type_JavaLangString);
    }
    if (localFileManagerEntity1 != null)
    {
      a(localFileManagerEntity1);
      if (FileUtil.b(localFileManagerEntity1.getFilePath())) {
        return localFileManagerEntity1.getFilePath();
      }
      return localFileManagerEntity1.strThumbPath;
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.h;
  }
  
  public String i()
  {
    return FileUtil.a(b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileViewAdapter.WeiyunFileViewerAdapter
 * JD-Core Version:    0.7.0.1
 */