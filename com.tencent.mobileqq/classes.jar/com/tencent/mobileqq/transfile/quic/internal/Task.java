package com.tencent.mobileqq.transfile.quic.internal;

import android.os.Message;
import com.tencent.mobileqq.transfile.quic.report.QuicNetReport;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.ProtocolException;
import java.util.Map;

public class Task<T>
{
  static final String CONTENT_LENGTH = "content-length";
  static final String CONTENT_TYPE = "content-type";
  static final int ERROR_CODE_CANCELED = 10007;
  static final int ERROR_CODE_DNS_ERROR = 10005;
  static final int ERROR_CODE_HEADER = 10001;
  static final int ERROR_CODE_READ_DATA_FAILED = 10006;
  static final int ERROR_CODE_SAVE_PATH = 10004;
  static final int ERROR_CODE_SERVER = 20000;
  static final int ERROR_COPY_FAILED = 10008;
  static final int ERROR_NATIVE_METHOD_ERROR = 30006;
  static final String USER_RETURNCODE = "User-ReturnCode";
  static final String UUID = "x-nws-log-uuid";
  long downloadLength = 0L;
  public ITaskHandler handler;
  Map<String, String> headers = null;
  T netListener;
  public QuicNetReport report;
  public boolean running = false;
  
  Task(ITaskHandler paramITaskHandler, String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap, T paramT)
  {
    this.handler = paramITaskHandler;
    this.headers = paramMap;
    this.netListener = paramT;
    this.report = new QuicNetReport();
    this.report.channel = paramString1;
    this.report.tempPath = getTempPath(paramString4, paramString3, paramString2);
    this.report.savePath = paramString3;
    this.report.id = QuicDownloadRunnable.getTaskID(this.report.tempPath);
    this.report.errCode = 0;
    this.report.httpStatus = 0;
    this.report.url = paramString2;
    this.report.startTime = System.currentTimeMillis();
  }
  
  private void copyFile(String paramString)
  {
    paramString = new File(paramString);
    boolean bool = FileUtils.a(paramString, new File(this.report.savePath), true);
    FileUtils.a(paramString);
    if (bool)
    {
      paramString = Message.obtain();
      paramString.what = 6;
      paramString.obj = this;
      this.handler.handleMessage(paramString);
      return;
    }
    this.report.errMsg = "copy temp file fail.";
    handleException(10008, 4);
  }
  
  public static String getTempPath(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (paramString1.length() > 0)) {
      return paramString1;
    }
    return paramString2 + "." + MD5.toMD5(paramString3) + ".tmp";
  }
  
  void handleException(int paramInt1, int paramInt2)
  {
    QLog.e("quic", 4, this.report.id + " handleException code " + paramInt1 + " failed " + paramInt2 + " running " + this.running);
    if (this.handler == null) {}
    while (!this.running) {
      return;
    }
    this.report.errCode = paramInt1;
    if (NetworkUtil.a()) {}
    for (this.report.failReason = paramInt2;; this.report.failReason = 6)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 8;
      localMessage.obj = this;
      this.handler.handleMessage(localMessage);
      return;
    }
  }
  
  void handleFinish(String paramString)
  {
    if (!this.running) {
      return;
    }
    copyFile(paramString);
  }
  
  public void initDownloadFile()
  {
    this.downloadLength = 0L;
    File localFile = new File(this.report.tempPath);
    if (localFile.exists())
    {
      localFile.delete();
      FileUtils.a(this.report.tempPath);
      return;
    }
    localFile = localFile.getParentFile();
    if ((localFile != null) && (!localFile.exists())) {
      FileUtils.b(localFile.getAbsolutePath());
    }
    FileUtils.a(this.report.tempPath);
  }
  
  protected void parseStateLine(String paramString)
  {
    int j = 9;
    int i;
    if (paramString.startsWith("HTTP/1."))
    {
      if ((paramString.length() < 9) || (paramString.charAt(8) != ' ')) {
        throw new ProtocolException("Unexpected status line: " + paramString);
      }
      i = paramString.charAt(7) - '0';
      if (i == 0)
      {
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("quic", 4, "HTTP/1.0");
          i = j;
        }
      }
    }
    while (paramString.length() < i + 3)
    {
      throw new ProtocolException("Unexpected status line: " + paramString);
      if (i == 1)
      {
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("quic", 4, "HTTP/1.1");
          i = j;
        }
      }
      else
      {
        throw new ProtocolException("Unexpected status line: " + paramString);
        if (paramString.startsWith("ICY ")) {
          i = 4;
        } else {
          throw new ProtocolException("Unexpected status line: " + paramString);
        }
      }
    }
    try
    {
      i = Integer.parseInt(paramString.substring(i, i + 3));
      this.report.httpStatus = i;
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new ProtocolException("Unexpected status line: " + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.quic.internal.Task
 * JD-Core Version:    0.7.0.1
 */