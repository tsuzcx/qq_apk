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
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt, String paramString)
  {
    if (!paramBoolean)
    {
      if ((paramString != null) && (paramString.length() > 0)) {
        FileManagerUtil.a(paramString);
      }
      return;
    }
    if (this.a.b != null)
    {
      if (this.a.app == null) {
        return;
      }
      if (this.a.b.b() != paramLong)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("FileBrowserActivity<FileAssistant>", 4, "difference nSessionId");
        }
        return;
      }
      if (this.a.app.getFileManagerDataCenter().b(paramLong) == null)
      {
        paramString = new StringBuilder();
        paramString.append("OnTroopFileCopyToC2cDisc->,but entity is null SessionId[");
        paramString.append(paramLong);
        paramString.append("]");
        QLog.e("FileBrowserActivity<FileAssistant>", 1, paramString.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity.1
 * JD-Core Version:    0.7.0.1
 */