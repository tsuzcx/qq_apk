package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.widget.TextView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class TbsLogClient
{
  static TbsLogClient a;
  static File c;
  static String d;
  static byte[] e;
  private static boolean i = true;
  TextView b;
  private SimpleDateFormat f = null;
  private Context g = null;
  private StringBuffer h = new StringBuffer();
  
  public TbsLogClient(Context paramContext)
  {
    try
    {
      this.g = paramContext.getApplicationContext();
      this.f = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS", Locale.US);
      return;
    }
    catch (Exception paramContext)
    {
      label50:
      break label50;
    }
    this.f = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
  }
  
  private void a()
  {
    try
    {
      if (c == null)
      {
        String str;
        if (Environment.getExternalStorageState().equals("mounted"))
        {
          str = FileUtil.a(this.g, 6);
          if (str != null) {}
        }
        else
        {
          c = null;
          return;
        }
        c = new File(str, "tbslog.txt");
        d = LogFileUtils.createKey();
        e = LogFileUtils.createHeaderText(c.getName(), d);
        return;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      localNullPointerException.printStackTrace();
      return;
    }
    catch (SecurityException localSecurityException)
    {
      localSecurityException.printStackTrace();
    }
  }
  
  public static void setWriteLogJIT(boolean paramBoolean)
  {
    i = paramBoolean;
  }
  
  public void d(String paramString1, String paramString2) {}
  
  public void e(String paramString1, String paramString2) {}
  
  public void i(String paramString1, String paramString2) {}
  
  public void setLogView(TextView paramTextView)
  {
    this.b = paramTextView;
  }
  
  public void showLog(String paramString)
  {
    TextView localTextView = this.b;
    if (localTextView != null) {
      localTextView.post(new TbsLogClient.a(this, paramString));
    }
  }
  
  public void v(String paramString1, String paramString2) {}
  
  public void w(String paramString1, String paramString2) {}
  
  public void writeLog(String paramString)
  {
    try
    {
      String str = this.f.format(Long.valueOf(System.currentTimeMillis()));
      StringBuffer localStringBuffer = this.h;
      localStringBuffer.append(str);
      localStringBuffer.append(" pid=");
      localStringBuffer.append(Process.myPid());
      localStringBuffer.append(" tid=");
      localStringBuffer.append(Process.myTid());
      localStringBuffer.append(paramString);
      localStringBuffer.append("\n");
      if ((Thread.currentThread() != Looper.getMainLooper().getThread()) || (i)) {
        writeLogToDisk();
      }
      if (this.h.length() > 524288)
      {
        this.h.delete(0, this.h.length());
        return;
      }
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
      a();
      if (c != null)
      {
        LogFileUtils.writeDataToStorage(c, d, e, this.h.toString(), true);
        this.h.delete(0, this.h.length());
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.utils.TbsLogClient
 * JD-Core Version:    0.7.0.1
 */