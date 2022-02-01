package com.tencent.mobileqq.filemanager.fileviewer.data;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFMSettings;
import com.tencent.mobileqq.filemanager.api.IFileIPv6StrateyController;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.DomainInfo;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.IPInfo;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.IPListInfo;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.FileVideoDownloadManager;
import com.tencent.mobileqq.filemanager.core.FileVideoDownloadManager.FileVideoManagerCallback;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.securitysdk.utils.MD5;
import java.io.File;
import java.util.List;

public class VideoForC2C
  implements BaseVideoBiz
{
  protected QQAppInterface a;
  protected FileManagerEntity a;
  
  public VideoForC2C(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
  }
  
  private String a(String paramString, int paramInt, List<String> paramList, boolean paramBoolean)
  {
    if (!FileIPv6StrateyController.a().isConfigEnableIPV6(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1)) {
      return "";
    }
    int j = 0;
    int i = 0;
    if ((paramBoolean) && (paramList != null) && (paramList.size() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[IPv6-File] offlineVideo download mediaplatform. is config enable IPv6. domain[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i("VideoForC2C<QFile>XOXO", 1, localStringBuilder.toString());
      paramList = FileIPv6StrateyController.a().getIPV6listForMediaPlatfrom(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramList);
      if ((paramList != null) && (paramList.size() > 0))
      {
        j = paramList.size();
        paramInt = i;
      }
    }
    while (paramInt < j)
    {
      paramString = (String)paramList.get(paramInt);
      if (!TextUtils.isEmpty(paramString))
      {
        paramList = new StringBuilder();
        paramList.append("[");
        paramList.append(paramString);
        paramList.append("]");
        paramString = paramList.toString();
        paramList = new StringBuilder();
        paramList.append("[IPv6-File] offlineVideo download mediaplatform. use IPv6. hostlist:");
        paramList.append(paramString);
        QLog.i("VideoForC2C<QFile>XOXO", 1, paramList.toString());
        return paramString;
      }
      paramInt += 1;
      continue;
      QLog.i("VideoForC2C<QFile>XOXO", 1, "[IPv6-File] offlineVideo download mediaplatform. use IPv4");
      return "";
      if (!TextUtils.isEmpty(paramString))
      {
        paramList = new StringBuilder();
        paramList.append("[IPv6-File] offlineVideo download. is config enable IPv6. domain[");
        paramList.append(paramString);
        paramList.append("]");
        QLog.i("VideoForC2C<QFile>XOXO", 1, paramList.toString());
        paramString = new FileIPv6StrateyController.DomainInfo(paramString, paramInt);
        paramString = FileIPv6StrateyController.a().getIPlistForV6Domain(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 1);
        if ((paramString != null) && (!paramString.a()))
        {
          i = paramString.a.size();
          paramInt = j;
        }
        while (paramInt < i)
        {
          paramList = (FileIPv6StrateyController.IPInfo)paramString.a.get(paramInt);
          if ((paramList != null) && (!TextUtils.isEmpty(paramList.a)))
          {
            paramString = paramList.a;
            paramList = new StringBuilder();
            paramList.append("[IPv6-File] offlineVideo download. use IPv6. hostlist:");
            paramList.append(paramString);
            QLog.i("VideoForC2C<QFile>XOXO", 1, paramList.toString());
            return paramString;
          }
          paramInt += 1;
          continue;
          QLog.i("VideoForC2C<QFile>XOXO", 1, "[IPv6-File] offlineVideo download. use IPv4");
        }
      }
    }
    return "";
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    localStringBuilder.append("");
    return localStringBuilder.toString();
  }
  
  public void a(long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    localFileManagerEntity.status = 2;
    localFileManagerEntity.fProgress = ((float)paramLong / (float)localFileManagerEntity.fileSize);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 16, null, 0, null);
  }
  
  public void a(FileVideoDownloadManager.FileVideoManagerCallback paramFileVideoManagerCallback)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid))
    {
      a(true);
      paramFileVideoManagerCallback.a(-6101, BaseApplication.getContext().getResources().getString(2131692751));
      paramFileVideoManagerCallback = new StringBuilder();
      paramFileVideoManagerCallback.append("[");
      paramFileVideoManagerCallback.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      paramFileVideoManagerCallback.append("],[getOnlinePlay]  uuid is null");
      QLog.e("VideoForC2C<QFile>XOXO", 2, paramFileVideoManagerCallback.toString());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType = 1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileIdCrc, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend, false, new VideoForC2C.1(this, paramFileVideoManagerCallback));
  }
  
  public void a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    ((FileManagerEntity)localObject).status = 1;
    ((FileManagerEntity)localObject).setFilePath(paramString);
    localObject = new File(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.localModifyTime = ((File)localObject).lastModified();
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    ((FileManagerEntity)localObject).nOLfileSessionId = 0L;
    ((FileManagerEntity)localObject).fProgress = 1.0F;
    ((FileManagerEntity)localObject).setCloudType(3);
    FileManagerUtil.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 11, new Object[] { paramString, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize), Boolean.valueOf(true), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath }, 0, null);
    FileVideoDownloadManager.a(this);
  }
  
  public void a(boolean paramBoolean)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    localFileManagerEntity.status = 0;
    if (paramBoolean)
    {
      localFileManagerEntity.status = 16;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 12, null, 2, null);
    FileVideoDownloadManager.a(this);
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FMSettings.a().getDefaultTmpPath());
    localStringBuilder.append(MD5.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid));
    return localStringBuilder.toString();
  }
  
  public String c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.data.VideoForC2C
 * JD-Core Version:    0.7.0.1
 */