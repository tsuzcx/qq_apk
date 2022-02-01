package com.tencent.mobileqq.persistence.backup.impl;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.dbfix.DBFix;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.database.corrupt.DBFixManager;
import com.tencent.mobileqq.persistence.backup.DBBackupConfigProcessor;
import com.tencent.mobileqq.persistence.backup.DBBackupConfigProcessor.Config;
import com.tencent.mobileqq.persistence.backup.IDBBackupService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class DBBackupServiceImpl
  implements IDBBackupService
{
  private static final String DB_FILE_SUFFIX = ".db";
  private static final String MASTER_FILE_SUFFIX = ".db-mbu";
  private static final String MASTER_TEMP_FILE_SUFFIX = "_temp.db-mbu";
  private static final String TAG = "DBFix";
  
  private boolean backupMaster(AppRuntime paramAppRuntime, File paramFile1, File paramFile2)
  {
    try
    {
      if (!((DBFixManager)paramAppRuntime.getManager(QQManagerFactory.DB_FIX_MANAGER)).b()) {
        return false;
      }
      long l = System.currentTimeMillis();
      boolean bool = DBFix.getInstance().doBackupMaster(paramFile1.getAbsolutePath(), paramFile2.getAbsolutePath());
      QLog.d("DBFix", 1, new Object[] { "backup master result: ", Boolean.valueOf(bool), ", cost: ", Long.valueOf(System.currentTimeMillis() - l), "ms" });
      return bool;
    }
    catch (Exception paramAppRuntime)
    {
      QLog.e("DBFix", 1, "backup master failed! ", paramAppRuntime);
    }
    return false;
  }
  
  private void copyMasterFile(boolean paramBoolean, File paramFile1, File paramFile2)
  {
    if (paramBoolean)
    {
      FileUtils.deleteFile(paramFile1.getAbsolutePath());
      if (!paramFile2.renameTo(paramFile1))
      {
        QLog.e("DBFix", 1, "backup master success but rename fail");
        paramBoolean = FileUtils.copyFile(paramFile2, paramFile1);
        FileUtils.deleteFile(paramFile2.getAbsolutePath());
        if (!paramBoolean) {
          QLog.e("DBFix", 1, "backup master success but copy fail final");
        }
      }
    }
  }
  
  public void backupDBMaster()
  {
    boolean bool = DBBackupConfigProcessor.a().a();
    QLog.d("DBFix", 1, new Object[] { "isBackupMaster: ", Boolean.valueOf(bool) });
    if (!bool) {
      return;
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject1 = localAppRuntime.getAccount();
    Object localObject2 = localAppRuntime.getApplication();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(".db");
    localObject2 = ((MobileQQ)localObject2).getDatabasePath(((StringBuilder)localObject3).toString());
    localObject3 = localAppRuntime.getApplication();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append((String)localObject1);
    ((StringBuilder)localObject4).append(".db-mbu");
    localObject3 = ((MobileQQ)localObject3).getDatabasePath(((StringBuilder)localObject4).toString());
    localObject4 = localAppRuntime.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("_temp.db-mbu");
    localObject1 = ((MobileQQ)localObject4).getDatabasePath(localStringBuilder.toString());
    FileUtils.deleteFile(((File)localObject1).getAbsolutePath());
    ThreadManager.post(new DBBackupServiceImpl.1(this, localAppRuntime, (File)localObject2, (File)localObject1, (File)localObject3), 10, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.backup.impl.DBBackupServiceImpl
 * JD-Core Version:    0.7.0.1
 */