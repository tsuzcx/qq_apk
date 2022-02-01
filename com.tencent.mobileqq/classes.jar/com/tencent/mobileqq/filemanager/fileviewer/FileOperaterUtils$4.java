package com.tencent.mobileqq.filemanager.fileviewer;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;

final class FileOperaterUtils$4
  implements View.OnClickListener
{
  FileOperaterUtils$4(FileManagerEntity paramFileManagerEntity, IFileBrowser paramIFileBrowser) {}
  
  public void onClick(View paramView)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      int i = FileManagerUtil.h(this.a);
      if ((i != 1) && (i != 2) && (i != 4))
      {
        if ((this.a.nFileType == 0) && (FileUtil.b(this.a.getFilePath())))
        {
          QfavBuilder.b(this.a.getFilePath()).a(localQQAppInterface).a(QBaseActivity.sTopActivity, localQQAppInterface.getAccount());
          QfavReport.a(localQQAppInterface, 7, 3);
        }
        else if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("FileVideoMediaPlayHelperthis is a local file, but favorite fail. [Uuid] = ");
          localStringBuilder.append(this.a.Uuid);
          localStringBuilder.append(" [status] = ");
          localStringBuilder.append(this.a.status);
          localStringBuilder.append(" [fileType] = ");
          localStringBuilder.append(this.a.nFileType);
          QLog.i("FileOperaterUtils", 2, localStringBuilder.toString());
        }
      }
      else {
        new QfavBuilder(3).a(localQQAppInterface, QBaseActivity.sTopActivity, this.a, null, false);
      }
      if ((this.b != null) && (this.b.g())) {
        FileManagerUtil.a(localQQAppInterface, this.a.nSessionId);
      }
    }
    catch (Exception localException)
    {
      label238:
      break label238;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils.4
 * JD-Core Version:    0.7.0.1
 */