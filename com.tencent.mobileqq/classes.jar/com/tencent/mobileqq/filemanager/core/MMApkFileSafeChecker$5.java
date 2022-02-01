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
    ((StringBuilder)localObject).append(this.a.getId());
    ((StringBuilder)localObject).append(" errCode:");
    ((StringBuilder)localObject).append(paramInt1);
    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    if ((paramInt1 == 0) && (paramInt2 != 0) && (paramInt2 != 4))
    {
      localObject = this.a;
      ((TroopFileTransferManager.Item)localObject).apkSafeLevel = paramInt2;
      ((TroopFileTransferManager.Item)localObject).apkSafeMsg = paramString1;
      ((TroopFileTransferManager.Item)localObject).apkSafeDetailUrl = paramString2;
      TroopFileDataCenter.a(this.b, (TroopFileTransferManager.Item)localObject);
      if ((this.c.b != null) && (this.a.Id != null))
      {
        localObject = this.c.b.getFileManagerDataCenter().c(this.a.troopuin, this.a.Id.toString());
        if (localObject != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[MMApkCheck] onCheckResult. Item.Id=");
          localStringBuilder.append(this.a.getId());
          localStringBuilder.append(" update about entity:");
          localStringBuilder.append(((FileManagerEntity)localObject).nSessionId);
          QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, localStringBuilder.toString());
          ((FileManagerEntity)localObject).apkSafeLevel = paramInt2;
          ((FileManagerEntity)localObject).apkSafeMsg = paramString1;
          ((FileManagerEntity)localObject).apkSafeDetailUrl = paramString2;
          this.c.b.getFileManagerDataCenter().c((FileManagerEntity)localObject);
        }
      }
    }
    if (this.c.b != null) {
      ((TroopFileHandler)this.c.b.getBusinessHandler(BusinessHandlerFactory.TROOP_FILE_HANDLER)).d(new Object[] { this.a.getInfo(this.b), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2, paramBundle });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker.5
 * JD-Core Version:    0.7.0.1
 */