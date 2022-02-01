package com.tencent.mobileqq.filemanager.fileviewer.FileView;

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
    QLog.i("LocalTbsViewManager<FileAssistant>", 1, "tbs reader engine download error. code[" + paramInt + "] msg[" + paramString + "]");
    ReportController.b(null, "dc00898", "", "", "0X800B00A", "0X800B00A", 2, 0, "" + paramInt, "", "", "");
  }
  
  public void onProgressChanged(int paramInt1, int paramInt2)
  {
    QLog.i("LocalTbsViewManager<FileAssistant>", 1, "tbs progress: oldProgress[" + paramInt1 + "] newProgress[" + paramInt2 + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalTbsViewManager.2
 * JD-Core Version:    0.7.0.1
 */