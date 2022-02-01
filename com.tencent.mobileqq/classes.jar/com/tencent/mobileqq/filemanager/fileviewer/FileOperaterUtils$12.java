package com.tencent.mobileqq.filemanager.fileviewer;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanageraux.link.LinkByWeiyunFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class FileOperaterUtils$12
  implements View.OnClickListener
{
  FileOperaterUtils$12(Activity paramActivity, FileManagerEntity paramFileManagerEntity, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidAppActivity != null) {
      LinkByWeiyunFragment.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_JavaLangString, false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils.12
 * JD-Core Version:    0.7.0.1
 */