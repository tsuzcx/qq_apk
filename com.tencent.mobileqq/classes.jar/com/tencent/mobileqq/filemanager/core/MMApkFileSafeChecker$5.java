package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopFileHandler;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.filemanager.TroopFileDataCenter;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class MMApkFileSafeChecker$5
  implements MMApkFileSafeChecker.ICheckResult
{
  MMApkFileSafeChecker$5(MMApkFileSafeChecker paramMMApkFileSafeChecker, TroopFileTransferManager.Item paramItem, long paramLong) {}
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[MMApkCheck] onCheckResult. Item.Id=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getId());
    ((StringBuilder)localObject).append(" errCode:");
    ((StringBuilder)localObject).append(paramInt1);
    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    if ((paramInt1 == 0) && (paramInt2 != 0) && (paramInt2 != 4))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item;
      ((TroopFileTransferManager.Item)localObject).apkSafeLevel = paramInt2;
      ((TroopFileTransferManager.Item)localObject).apkSafeMsg = paramString1;
      ((TroopFileTransferManager.Item)localObject).apkSafeDetailUrl = paramString2;
      TroopFileDataCenter.a(this.jdField_a_of_type_Long, (TroopFileTransferManager.Item)localObject);
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker.a != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id != null))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker.a.getFileManagerDataCenter().a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.troopuin, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id.toString());
        if (localObject != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[MMApkCheck] onCheckResult. Item.Id=");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getId());
          localStringBuilder.append(" update about entity:");
          localStringBuilder.append(((FileManagerEntity)localObject).nSessionId);
          QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, localStringBuilder.toString());
          ((FileManagerEntity)localObject).apkSafeLevel = paramInt2;
          ((FileManagerEntity)localObject).apkSafeMsg = paramString1;
          ((FileManagerEntity)localObject).apkSafeDetailUrl = paramString2;
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker.a.getFileManagerDataCenter().c((FileManagerEntity)localObject);
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker.a != null) {
      ((TroopFileHandler)this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker.a.getBusinessHandler(BusinessHandlerFactory.TROOP_FILE_HANDLER)).d(new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getInfo(this.jdField_a_of_type_Long), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2, paramBundle });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker.5
 * JD-Core Version:    0.7.0.1
 */