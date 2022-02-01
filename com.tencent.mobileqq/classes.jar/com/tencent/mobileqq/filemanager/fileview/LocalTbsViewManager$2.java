package com.tencent.mobileqq.filemanager.fileview;

import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tbs.one.TBSOneCallback;
import java.io.File;

class LocalTbsViewManager$2
  extends TBSOneCallback<File>
{
  LocalTbsViewManager$2(LocalTbsViewManager paramLocalTbsViewManager) {}
  
  public void a(File paramFile)
  {
    QLog.i("LocalTbsViewManager<FileAssistant>", 1, "tbs reader engine download complete.");
    LocalTbsViewManager.a(this.a);
    ReportController.b(null, "dc00898", "", "", "0X800B00A", "0X800B00A", 1, 0, "", "", "", "");
  }
  
  public void onError(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tbs reader engine download error. code[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("] msg[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    QLog.i("LocalTbsViewManager<FileAssistant>", 1, localStringBuilder.toString());
    paramString = new StringBuilder();
    paramString.append("");
    paramString.append(paramInt);
    ReportController.b(null, "dc00898", "", "", "0X800B00A", "0X800B00A", 2, 0, paramString.toString(), "", "", "");
  }
  
  public void onProgressChanged(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tbs progress: oldProgress[");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("] newProgress[");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("]");
    QLog.i("LocalTbsViewManager<FileAssistant>", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.2
 * JD-Core Version:    0.7.0.1
 */