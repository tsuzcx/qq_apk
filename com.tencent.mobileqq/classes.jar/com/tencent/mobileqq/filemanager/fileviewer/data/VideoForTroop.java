package com.tencent.mobileqq.filemanager.fileviewer.data;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFMSettings;
import com.tencent.mobileqq.filemanager.core.FileVideoDownloadManager;
import com.tencent.mobileqq.filemanager.core.FileVideoDownloadManager.FileVideoManagerCallback;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.troop.data.TroopFileInfo.FileStatus;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.QLog;
import com.tencent.securitysdk.utils.MD5;
import java.util.UUID;

public class VideoForTroop
  implements BaseVideoBiz
{
  protected QQAppInterface a;
  private TroopFileStatusInfo jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo;
  private UUID jdField_a_of_type_JavaUtilUUID;
  
  public VideoForTroop(QQAppInterface paramQQAppInterface, TroopFileStatusInfo paramTroopFileStatusInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo = paramTroopFileStatusInfo;
    this.jdField_a_of_type_JavaUtilUUID = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID;
    if (this.jdField_a_of_type_JavaUtilUUID != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      return;
    }
    throw new NullPointerException("TroopFileStatusInfo Id null");
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.c;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.e;
  }
  
  public void a(long paramLong)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_b_of_type_Long);
    if (localTroopFileTransferManager == null)
    {
      QLog.e("VideoForTroop<QFile>", 1, "notifyProgress: get troopFileTransferManager failed.");
      return;
    }
    TroopFileTransferManager.Item localItem = localTroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
    if (localItem != null)
    {
      localItem.ProgressValue = paramLong;
      localTroopFileTransferManager.a(localItem, 8);
    }
  }
  
  public void a(FileVideoDownloadManager.FileVideoManagerCallback paramFileVideoManagerCallback)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_b_of_type_Long);
    if (localTroopFileTransferManager == null)
    {
      QLog.e("VideoForTroop<QFile>", 1, "getUrl: get troopFileTransferManager failed.");
      return;
    }
    localTroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.e, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.g, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.c, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.h, new VideoForTroop.1(this, paramFileVideoManagerCallback));
  }
  
  public void a(String paramString)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_b_of_type_Long);
    if (localTroopFileTransferManager == null)
    {
      QLog.e("VideoForTroop<QFile>", 1, "notifySuccessed: get troopFileTransferManager failed.");
      return;
    }
    TroopFileTransferManager.Item localItem = localTroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
    if (localItem != null)
    {
      boolean bool = TroopFileInfo.FileStatus.b(localItem.Status);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("notifySuccessed  itemStatus[");
        localStringBuilder.append(localItem.Status);
        localStringBuilder.append("]");
        QLog.e("VideoForTroop<QFile>", 1, localStringBuilder.toString());
      }
      if ((!bool) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_b_of_type_Int != 7))
      {
        localTroopFileTransferManager.a(localItem, 6);
      }
      else
      {
        localItem.LocalFile = paramString;
        localTroopFileTransferManager.a(localItem, 11);
      }
    }
    FileVideoDownloadManager.a(this);
  }
  
  public void a(boolean paramBoolean)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_b_of_type_Long);
    if (localTroopFileTransferManager == null)
    {
      QLog.e("VideoForTroop<QFile>", 1, "notifyFileFailed: get troopFileTransferManager failed.");
      return;
    }
    TroopFileTransferManager.Item localItem = localTroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
    if (localItem != null)
    {
      if (paramBoolean)
      {
        localTroopFileTransferManager.a(localItem, 12);
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("notifyFileFaild isInvalid[");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append("], itemStatus[");
        localStringBuilder.append(localItem.Status);
        localStringBuilder.append("]");
        QLog.e("VideoForTroop<QFile>", 1, localStringBuilder.toString());
      }
      if ((!TroopFileInfo.FileStatus.b(localItem.Status)) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_b_of_type_Int != 7)) {
        localTroopFileTransferManager.a(localItem, 3);
      } else {
        localTroopFileTransferManager.a(localItem, 10);
      }
    }
    FileVideoDownloadManager.a(this);
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FMSettings.a().getDefaultTmpPath());
    localStringBuilder.append(MD5.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.e));
    return localStringBuilder.toString();
  }
  
  public String c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.data.VideoForTroop
 * JD-Core Version:    0.7.0.1
 */