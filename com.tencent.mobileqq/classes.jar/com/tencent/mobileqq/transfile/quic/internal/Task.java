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
    paramITaskHandler = this.report;
    paramITaskHandler.channel = paramString1;
    paramITaskHandler.tempPath = getTempPath(paramString4, paramString3, paramString2);
    paramITaskHandler = this.report;
    paramITaskHandler.savePath = paramString3;
    paramITaskHandler.id = QuicDownloadRunnable.getTaskID(paramITaskHandler.tempPath);
    paramITaskHandler = this.report;
    paramITaskHandler.errCode = 0;
    paramITaskHandler.httpStatus = 0;
    paramITaskHandler.url = paramString2;
    paramITaskHandler.startTime = System.currentTimeMillis();
  }
  
  private void copyFile(String paramString)
  {
    paramString = new File(paramString);
    boolean bool = FileUtils.copyFile(paramString, new File(this.report.savePath), true);
    FileUtils.deleteFile(paramString);
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
    paramString1 = new StringBuilder();
    paramString1.append(paramString2);
    paramString1.append(".");
    paramString1.append(MD5.toMD5(paramString3));
    paramString1.append(".tmp");
    return paramString1.toString();
  }
  
  void handleException(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.report.id);
    ((StringBuilder)localObject).append(" handleException code ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" failed ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" running ");
    ((StringBuilder)localObject).append(this.running);
    QLog.e("quic", 4, ((StringBuilder)localObject).toString());
    if (this.handler == null) {
      return;
    }
    if (!this.running) {
      return;
    }
    this.report.errCode = paramInt1;
    if (NetworkUtil.isNetworkAvailable()) {
      this.report.failReason = paramInt2;
    } else {
      this.report.failReason = 6;
    }
    localObject = Message.obtain();
    ((Message)localObject).what = 8;
    ((Message)localObject).obj = this;
    this.handler.handleMessage((Message)localObject);
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
      FileUtils.createFile(this.report.tempPath);
      return;
    }
    localFile = localFile.getParentFile();
    if ((localFile != null) && (!localFile.exists())) {
      FileUtils.createDirectory(localFile.getAbsolutePath());
    }
    FileUtils.createFile(this.report.tempPath);
  }
  
  protected void parseStateLine(String paramString)
  {
    boolean bool = paramString.startsWith("HTTP/1.");
    int j = 9;
    int i;
    if (bool)
    {
      if ((paramString.length() >= 9) && (paramString.charAt(8) == ' '))
      {
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
        else if (i == 1)
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
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unexpected status line: ");
          localStringBuilder.append(paramString);
          throw new ProtocolException(localStringBuilder.toString());
        }
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unexpected status line: ");
        localStringBuilder.append(paramString);
        throw new ProtocolException(localStringBuilder.toString());
      }
    }
    else
    {
      if (!paramString.startsWith("ICY ")) {
        break label298;
      }
      i = 4;
    }
    j = paramString.length();
    int k = i + 3;
    if (j >= k) {}
    try
    {
      i = Integer.parseInt(paramString.substring(i, k));
      this.report.httpStatus = i;
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label222:
      break label222;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unexpected status line: ");
    localStringBuilder.append(paramString);
    throw new ProtocolException(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unexpected status line: ");
    localStringBuilder.append(paramString);
    throw new ProtocolException(localStringBuilder.toString());
    label298:
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unexpected status line: ");
    localStringBuilder.append(paramString);
    throw new ProtocolException(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.quic.internal.Task
 * JD-Core Version:    0.7.0.1
 */