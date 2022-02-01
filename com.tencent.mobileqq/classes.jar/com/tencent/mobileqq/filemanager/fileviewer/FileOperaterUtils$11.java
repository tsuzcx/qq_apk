package com.tencent.mobileqq.filemanager.fileviewer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class FileOperaterUtils$11
  implements View.OnClickListener
{
  FileOperaterUtils$11(Activity paramActivity, Bundle paramBundle, FileManagerEntity paramFileManagerEntity) {}
  
  public void onClick(View paramView)
  {
    FileOperaterUtils.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils.11
 * JD-Core Version:    0.7.0.1
 */