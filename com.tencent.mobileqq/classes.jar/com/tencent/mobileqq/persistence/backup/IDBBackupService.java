package com.tencent.mobileqq.persistence.backup;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IDBBackupService
  extends QRouteApi
{
  public abstract void backupDBMaster();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.backup.IDBBackupService
 * JD-Core Version:    0.7.0.1
 */