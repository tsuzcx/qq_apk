package com.tencent.mobileqq.filemanager.fileviewer;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;

class TroopFileDetailBrowserActivity$1
  extends FMObserver
{
  TroopFileDetailBrowserActivity$1(TroopFileDetailBrowserActivity paramTroopFileDetailBrowserActivity) {}
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, String paramString)
  {
    if (!paramBoolean) {
      if ((paramString != null) && (paramString.length() > 0)) {
        FileManagerUtil.c(paramString);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.a.b == null) || (this.a.app == null));
        if (this.a.b.b() == paramLong) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.d("FileBrowserActivity<FileAssistant>", 4, "difference nSessionId");
      return;
    } while (this.a.app.getFileManagerDataCenter().b(paramLong) != null);
    QLog.e("FileBrowserActivity<FileAssistant>", 1, "OnTroopFileCopyToC2cDisc->,but entity is null SessionId[" + paramLong + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity.1
 * JD-Core Version:    0.7.0.1
 */