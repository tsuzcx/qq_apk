package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import android.widget.TextView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Vector;

public class TbsLogClient
{
  static final String TBS_LOG_FILE = "tbslog.txt";
  static TbsLogClient intance = null;
  static String mKey = null;
  static byte[] mKeyHeadText = null;
  static File mLogFile = null;
  private static boolean write_log_just_in_time = true;
  Vector<String> logMessage;
  private Context mContext = null;
  TextView mView;
  private StringBuffer msLogContent = new StringBuffer();
  private SimpleDateFormat time_formatter = null;
  
  public TbsLogClient(Context paramContext)
  {
    try
    {
      this.mContext = paramContext.getApplicationContext();
      this.time_formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS", Locale.US);
      return;
    }
    catch (Exception paramContext)
    {
      this.time_formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
    }
  }
  
  private void initIfNeeded()
  {
    try
    {
      if (mLogFile == null) {
        if (Environment.getExternalStorageState().equals("mounted"))
        {
          String str = FileUtil.getTBSSdcardFilePath(this.mContext, 6);
          if (str == null)
          {
            mLogFile = null;
            return;
          }
          mLogFile = new File(str, "tbslog.txt");
          mKey = LogFileUtils.createKey();
          mKeyHeadText = LogFileUtils.createHeaderText(mLogFile.getName(), mKey);
          return;
        }
      }
    }
    catch (SecurityException localSecurityException)
    {
      localSecurityException.printStackTrace();
      return;
      mLogFile = null;
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      localNullPointerException.printStackTrace();
    }
  }
  
  public static void setWriteLogJIT(boolean paramBoolean)
  {
    write_log_just_in_time = paramBoolean;
  }
  
  public void d(String paramString1, String paramString2) {}
  
  public void e(String paramString1, String paramString2)
  {
    Log.e(paramString1, paramString2);
  }
  
  public void i(String paramString1, String paramString2) {}
  
  public void setLogView(TextView paramTextView)
  {
    this.mView = paramTextView;
  }
  
  public void showLog(String paramString)
  {
    if (this.mView != null) {
      this.mView.post(new LogRunnable(paramString));
    }
  }
  
  public void v(String paramString1, String paramString2) {}
  
  public void w(String paramString1, String paramString2) {}
  
  public void writeLog(String paramString)
  {
    try
    {
      String str = this.time_formatter.format(Long.valueOf(System.currentTimeMillis()));
      this.msLogContent.append(str).append(" pid=").append(Process.myPid()).append(" tid=").append(Process.myTid()).append(paramString).append("\n");
      if ((Thread.currentThread() != Looper.getMainLooper().getThread()) || (write_log_just_in_time)) {
        writeLogToDisk();
      }
      if (this.msLogContent.length() > 524288) {
        this.msLogContent.delete(0, this.msLogContent.length());
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void writeLogToDisk()
  {
    try
    {
      initIfNeeded();
      if (mLogFile != null)
      {
        LogFileUtils.writeDataToStorage(mLogFile, mKey, mKeyHeadText, this.msLogContent.toString(), true);
        this.msLogContent.delete(0, this.msLogContent.length());
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private class LogRunnable
    implements Runnable
  {
    String mLog = null;
    
    LogRunnable(String paramString)
    {
      this.mLog = paramString;
    }
    
    public void run()
    {
      if (TbsLogClient.this.mView != null) {
        TbsLogClient.this.mView.append(this.mLog + "\n");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.utils.TbsLogClient
 * JD-Core Version:    0.7.0.1
 */