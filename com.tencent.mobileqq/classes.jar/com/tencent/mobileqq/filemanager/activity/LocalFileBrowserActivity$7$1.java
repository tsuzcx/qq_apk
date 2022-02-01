package com.tencent.mobileqq.filemanager.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.LocalFileAdapter.LocalFileItemHolder;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class LocalFileBrowserActivity$7$1
  implements View.OnClickListener
{
  LocalFileBrowserActivity$7$1(LocalFileBrowserActivity.7 param7, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (LocalFileAdapter.LocalFileItemHolder)this.jdField_a_of_type_AndroidViewView.getTag();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity$7.a.e = ((LocalFileAdapter.LocalFileItemHolder)localObject).a;
    localObject = (FileInfo)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity$7.a.b.get(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity$7.a.e);
    if ((!FileUtil.a(((FileInfo)localObject).c())) || (FileUtil.c(((FileInfo)localObject).c())))
    {
      FileManagerUtil.d(((FileInfo)localObject).c());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity$7.a.b.remove(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity$7.a.e);
      LocalFileBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity$7.a);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      FMToastUtil.a(2131692346);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity.7.1
 * JD-Core Version:    0.7.0.1
 */