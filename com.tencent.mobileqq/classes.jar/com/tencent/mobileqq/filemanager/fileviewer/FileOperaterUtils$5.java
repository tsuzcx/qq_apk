package com.tencent.mobileqq.filemanager.fileviewer;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.PrinterDefaultActivity;
import com.dataline.data.PrinterManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.PrinterHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class FileOperaterUtils$5
  implements View.OnClickListener
{
  FileOperaterUtils$5(String paramString, IFileBrowser paramIFileBrowser, long paramLong) {}
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    DataLineHandler localDataLineHandler = (DataLineHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    if ((FileUtil.b(this.a)) && (localDataLineHandler.h.c(FileManagerUtil.a(this.a))))
    {
      Activity localActivity = this.b.getActivity();
      if (!localDataLineHandler.h.d()) {
        localActivity.startActivity(new Intent(localActivity, PrinterDefaultActivity.class));
      } else {
        localDataLineHandler.e.a(localActivity, this.a);
      }
      if (this.b.g()) {
        FileManagerUtil.a(localQQAppInterface, this.c);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils.5
 * JD-Core Version:    0.7.0.1
 */