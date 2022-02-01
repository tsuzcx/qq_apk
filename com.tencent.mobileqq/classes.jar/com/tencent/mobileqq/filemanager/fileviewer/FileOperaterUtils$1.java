package com.tencent.mobileqq.filemanager.fileviewer;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.recreate.FileModel;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class FileOperaterUtils$1
  implements View.OnClickListener
{
  FileOperaterUtils$1(String paramString, IFileBrowser paramIFileBrowser) {}
  
  public void onClick(View paramView)
  {
    for (;;)
    {
      try
      {
        local1 = new FileOperaterUtils.1.1(this);
        localFileModel = FileModel.a(this.jdField_a_of_type_JavaLangString);
        if (localFileModel != null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.w("FileOperaterUtils", 2, "error. get filemodel null, filepath[ " + this.jdField_a_of_type_JavaLangString + "]");
        }
      }
      catch (Exception localException)
      {
        FileOperaterUtils.1.1 local1;
        FileModel localFileModel;
        continue;
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (localFileModel.a(false))
      {
        if (!NetworkUtil.e(BaseApplicationImpl.getContext())) {
          FMToastUtil.a(2131693237);
        } else if (FreeWifiHelper.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), 5, new FileOperaterUtils.1.2(this, local1))) {
          FMDialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), 2131692609, 2131692612, local1);
        }
      }
      else {
        local1.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils.1
 * JD-Core Version:    0.7.0.1
 */