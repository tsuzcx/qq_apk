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
    if ((FileUtil.a(this.jdField_a_of_type_JavaLangString)) && (localDataLineHandler.jdField_a_of_type_ComDatalineDataPrinterManager.a(FileManagerUtil.a(this.jdField_a_of_type_JavaLangString))))
    {
      Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity();
      if (!localDataLineHandler.jdField_a_of_type_ComDatalineDataPrinterManager.a()) {
        localActivity.startActivity(new Intent(localActivity, PrinterDefaultActivity.class));
      } else {
        localDataLineHandler.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler.a(localActivity, this.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.c()) {
        FileManagerUtil.a(localQQAppInterface, this.jdField_a_of_type_Long);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils.5
 * JD-Core Version:    0.7.0.1
 */