package com.tencent.tbs.log.file;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import com.tencent.tbs.log.Formatter;
import com.tencent.tbs.log.LogItem;
import com.tencent.tbs.log.LogPrinter;
import com.tencent.tbs.log.TBSLog;
import com.tencent.tbs.log.file.backup.BackupStrategy;
import com.tencent.tbs.log.file.clean.CleanStrategy;
import com.tencent.tbs.log.file.naming.LogNameGenerator;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class FilePrinter
  implements LogPrinter
{
  private boolean isAsync;
  private boolean isEncrypt;
  private Context mContext;
  private BackupStrategy mLogBackupStrategy;
  private CleanStrategy mLogCleanStrategy;
  private LogNameGenerator mLogNameGenerator;
  private volatile FilePrinter.Worker mWorker = new FilePrinter.Worker(this, null);
  private FilePrinter.Writer mWriter = new FilePrinter.Writer(this, null);
  
  public FilePrinter(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, LogNameGenerator paramLogNameGenerator, CleanStrategy paramCleanStrategy, BackupStrategy paramBackupStrategy)
  {
    this.isAsync = paramBoolean1;
    this.isEncrypt = paramBoolean2;
    this.mLogNameGenerator = paramLogNameGenerator;
    this.mLogCleanStrategy = paramCleanStrategy;
    this.mLogBackupStrategy = paramBackupStrategy;
    this.mContext = paramContext;
  }
  
  private void doPrintln(LogItem paramLogItem)
  {
    if (!openFileIfNecessary(paramLogItem))
    {
      new Throwable("log file open failed!").printStackTrace();
      return;
    }
    this.mWriter.appendLog(Formatter.formatLog(paramLogItem));
  }
  
  private String getLogPath()
  {
    Object localObject = ((ActivityManager)this.mContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if (localRunningAppProcessInfo.pid == Process.myPid())
      {
        localObject = localRunningAppProcessInfo.processName.toLowerCase().replace(".", "_");
        localObject = new File(TBSLog.getLogPath(), (String)localObject);
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        return ((File)localObject).getAbsolutePath();
      }
    }
    return TBSLog.getLogPath();
  }
  
  private boolean openFileIfNecessary(LogItem paramLogItem)
  {
    Object localObject2;
    Object localObject1;
    try
    {
      localObject2 = this.mWriter.getFileName();
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (!this.mLogNameGenerator.isFileNameChangeable()) {
          break label175;
        }
      }
      localObject1 = this.mLogNameGenerator.generateFileName(paramLogItem);
      if ((localObject1 == null) || (((String)localObject1).trim().length() == 0)) {
        throw new IllegalArgumentException("File name should not be empty.");
      }
    }
    catch (Exception paramLogItem)
    {
      paramLogItem.printStackTrace();
    }
    int i;
    for (;;)
    {
      return false;
      if (!((String)localObject1).equals(localObject2))
      {
        if (this.mWriter.isOpened()) {
          this.mWriter.close();
        }
        paramLogItem = new File(getLogPath()).listFiles();
        if (paramLogItem != null)
        {
          int j = paramLogItem.length;
          i = 0;
          if (i < j)
          {
            localObject2 = paramLogItem[i];
            if (!this.mLogCleanStrategy.shouldClean((File)localObject2)) {
              break;
            }
            ((File)localObject2).delete();
            break;
          }
        }
        if (this.mWriter.open((String)localObject1)) {
          break label295;
        }
      }
    }
    label295:
    for (;;)
    {
      label175:
      paramLogItem = this.mWriter.getFile();
      if ((paramLogItem != null) && (this.mLogBackupStrategy.shouldBackup(paramLogItem)))
      {
        this.mWriter.close();
        localObject2 = new File(getLogPath(), (String)localObject1 + "-" + System.currentTimeMillis() % 86400000L);
        if (((File)localObject2).exists()) {
          ((File)localObject2).delete();
        }
        paramLogItem.renameTo((File)localObject2);
        boolean bool = this.mWriter.open((String)localObject1);
        return bool;
      }
      return true;
      i += 1;
      break;
    }
  }
  
  public void close()
  {
    this.mWriter.close();
    this.mWorker.close();
  }
  
  public void println(LogItem paramLogItem)
  {
    if (this.isAsync)
    {
      if (!this.mWorker.isStarted()) {
        this.mWorker.start();
      }
      this.mWorker.enqueue(paramLogItem);
      return;
    }
    doPrintln(paramLogItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.log.file.FilePrinter
 * JD-Core Version:    0.7.0.1
 */