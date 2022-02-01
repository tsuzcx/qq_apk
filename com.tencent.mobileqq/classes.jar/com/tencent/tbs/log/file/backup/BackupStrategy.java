package com.tencent.tbs.log.file.backup;

import java.io.File;

public abstract interface BackupStrategy
{
  public abstract boolean shouldBackup(File paramFile);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.log.file.backup.BackupStrategy
 * JD-Core Version:    0.7.0.1
 */