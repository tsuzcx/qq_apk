package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class TbsCoreLoadStat
{
  private static final String TAG = "TbsCoreLoadStat";
  private static final String TBSAPK_LOAD_STAT_FLAG_FILENAME = "tbs_load_stat_flag";
  private static final String TBS_CORE_REPORT_LOCK_FILE = "tbs_report_lock.txt";
  private static TbsCoreLoadStat mInstance = null;
  public static volatile int mLoadErrorCode = -1;
  private final int QUEUE_SIZE = 3;
  private TbsCoreLoadStat.TbsSequenceQueue mTbsSequenceQueue = null;
  private boolean needReportFlag = false;
  
  private void freeFileLock(FileLock paramFileLock, FileOutputStream paramFileOutputStream)
  {
    if (paramFileLock != null) {}
    try
    {
      paramFileLock.release();
      if (paramFileOutputStream == null) {}
    }
    catch (Exception paramFileLock)
    {
      for (;;)
      {
        try
        {
          paramFileOutputStream.close();
          return;
        }
        catch (Exception paramFileLock)
        {
          paramFileLock.printStackTrace();
        }
        paramFileLock = paramFileLock;
        paramFileLock.printStackTrace();
      }
    }
  }
  
  public static TbsCoreLoadStat getInstance()
  {
    if (mInstance == null) {
      mInstance = new TbsCoreLoadStat();
    }
    return mInstance;
  }
  
  private FileOutputStream getLoadReportLockFos(Context paramContext)
  {
    paramContext = getLockFile(paramContext, "tbs_report_lock.txt");
    if (paramContext != null) {
      try
      {
        paramContext = new FileOutputStream(paramContext);
        return paramContext;
      }
      catch (FileNotFoundException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return null;
  }
  
  private File getLockFile(Context paramContext, String paramString)
  {
    paramContext = TbsInstaller.getTbsCorePrivateDir(paramContext);
    if (paramContext == null) {
      return null;
    }
    paramContext = new File(paramContext, paramString);
    if ((paramContext != null) && (paramContext.exists())) {
      return paramContext;
    }
    try
    {
      paramContext.createNewFile();
      return paramContext;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  private FileLock tryFileLock(Context paramContext, FileOutputStream paramFileOutputStream)
  {
    if (paramFileOutputStream == null) {}
    for (;;)
    {
      return null;
      try
      {
        paramContext = paramFileOutputStream.getChannel().tryLock();
        boolean bool = paramContext.isValid();
        if (bool) {
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return null;
  }
  
  void clearErrorCodeQueue()
  {
    if (this.mTbsSequenceQueue != null) {
      this.mTbsSequenceQueue.clear();
    }
    this.needReportFlag = false;
  }
  
  void setLoadErrorCode(Context paramContext, int paramInt)
  {
    setLoadErrorCode(paramContext, paramInt, null);
    TbsLog.e("loaderror", "" + paramInt);
  }
  
  void setLoadErrorCode(Context paramContext, int paramInt, Throwable paramThrowable)
  {
    for (;;)
    {
      try
      {
        if (mLoadErrorCode == -1)
        {
          mLoadErrorCode = paramInt;
          TbsLog.addLog(998, "code=%d,desc=%s", new Object[] { Integer.valueOf(paramInt), String.valueOf(paramThrowable) });
          if (paramThrowable != null) {
            TbsLogReport.getInstance(paramContext).setLoadErrorCode(paramInt, paramThrowable);
          }
        }
        else
        {
          paramContext = new StringBuilder("setLoadErrorCode :: error(");
          paramContext.append(mLoadErrorCode);
          paramContext.append(") was already reported; ");
          paramContext.append(paramInt);
          paramContext.append(" is duplicated. Try to remove it!");
          TbsLog.w("TbsCoreLoadStat", paramContext.toString());
          continue;
        }
        TbsLog.e("TbsCoreLoadStat", "setLoadErrorCode :: error is null with errorCode: " + paramInt + "; Check & correct it!");
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsCoreLoadStat
 * JD-Core Version:    0.7.0.1
 */