package com.tencent.mobileqq.mini.utils;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class ReportLogUtil$1
  implements ReportLogUtil.UploadLogListener
{
  ReportLogUtil$1(String paramString1, String paramString2, long paramLong) {}
  
  public void onFail(String paramString)
  {
    paramString = new StringBuilder();
    paramString.append("upload log fail: ");
    paramString.append(this.val$logPath);
    QLog.d("ReportLogUtil", 1, paramString.toString());
    paramString = new File(this.val$logPath);
    if (paramString.exists()) {
      paramString.delete();
    }
  }
  
  public void onSuccess(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" upload log success: ");
    localStringBuilder.append(this.val$logPath);
    QLog.d("ReportLogUtil", 1, localStringBuilder.toString());
    MiniAppCmdUtil.getInstance().reportLogFileUrl(null, this.val$appid, paramString, this.val$fileSize, new ReportLogUtil.1.1(this, paramString));
    paramString = new File(this.val$logPath);
    if (paramString.exists()) {
      paramString.delete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.ReportLogUtil.1
 * JD-Core Version:    0.7.0.1
 */