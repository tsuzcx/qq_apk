package com.tencent.mobileqq.filemanager.fileviewer;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.PrinterDefaultActivity;
import com.dataline.data.PrinterManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.PrinterHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class FileOperaterUtils$6
  implements View.OnClickListener
{
  FileOperaterUtils$6(String paramString, IFileBrowser paramIFileBrowser) {}
  
  public void onClick(View paramView)
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    if (!FileUtil.b(this.jdField_a_of_type_JavaLangString)) {}
    label153:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (localDataLineHandler.jdField_a_of_type_ComDatalineDataPrinterManager.a(FileManagerUtil.a(this.jdField_a_of_type_JavaLangString)))
      {
        Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity();
        if (!localDataLineHandler.jdField_a_of_type_ComDatalineDataPrinterManager.a()) {
          localActivity.startActivity(new Intent(localActivity, PrinterDefaultActivity.class));
        }
        for (;;)
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.c()) {
            break label153;
          }
          long l = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().b();
          FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), l);
          break;
          localDataLineHandler.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler.a((BaseActivity)localActivity, this.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils.6
 * JD-Core Version:    0.7.0.1
 */