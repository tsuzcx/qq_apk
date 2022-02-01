package com.tencent.mobileqq.filemanager.fileviewer;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class FileOperaterUtils$2
  implements View.OnClickListener
{
  FileOperaterUtils$2(FileManagerEntity paramFileManagerEntity, IFileBrowser paramIFileBrowser) {}
  
  public void onClick(View paramView)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      localQQAppInterface.getFileManagerEngine().a(this.a, this.a.peerUin);
      FMToastUtil.d(QBaseActivity.sTopActivity.getString(2131889761));
      if ((this.b != null) && (this.b.g())) {
        FileManagerUtil.a(localQQAppInterface, this.a.nSessionId);
      }
      label70:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label70;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils.2
 * JD-Core Version:    0.7.0.1
 */