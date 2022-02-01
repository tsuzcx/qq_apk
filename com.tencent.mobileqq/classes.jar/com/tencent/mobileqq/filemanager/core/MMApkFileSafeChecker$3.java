package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class MMApkFileSafeChecker$3
  implements MMApkFileSafeChecker.ICheckResult
{
  MMApkFileSafeChecker$3(MMApkFileSafeChecker paramMMApkFileSafeChecker, FileManagerEntity paramFileManagerEntity) {}
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[MMApkCheck] onCheckResult. nSessionId=");
    ((StringBuilder)localObject).append(this.a.nSessionId);
    ((StringBuilder)localObject).append(" errCode:");
    ((StringBuilder)localObject).append(paramInt1);
    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    if ((paramInt1 == 0) && (paramInt2 != 0) && (paramInt2 != 4))
    {
      localObject = this.a;
      ((FileManagerEntity)localObject).apkSafeLevel = paramInt2;
      ((FileManagerEntity)localObject).apkSafeMsg = paramString1;
      ((FileManagerEntity)localObject).apkSafeDetailUrl = paramString2;
      if (this.b.b != null) {
        this.b.b.getFileManagerDataCenter().c(this.a);
      }
    }
    if (this.b.b != null) {
      this.b.b.getFileManagerNotifyCenter().a(true, 200, new Object[] { Long.valueOf(this.a.nSessionId), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2, paramBundle });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker.3
 * JD-Core Version:    0.7.0.1
 */