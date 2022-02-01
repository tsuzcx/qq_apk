package com.tencent.mobileqq.filemanager.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.LocalFileAdapter.LocalFileItemHolder;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class LocalFileBrowserActivity$5$1
  implements View.OnClickListener
{
  LocalFileBrowserActivity$5$1(LocalFileBrowserActivity.5 param5, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (LocalFileAdapter.LocalFileItemHolder)this.jdField_a_of_type_AndroidViewView.getTag();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity$5.a.e = ((LocalFileAdapter.LocalFileItemHolder)localObject).a;
    localObject = (FileInfo)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity$5.a.b.get(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity$5.a.e);
    if ((FileUtils.fileExistsAndNotEmpty(((FileInfo)localObject).c())) && (!((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).deleteFile(((FileInfo)localObject).c())))
    {
      FMToastUtil.a(2131692274);
    }
    else
    {
      QQFileManagerUtil.e(((FileInfo)localObject).c());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity$5.a.b.remove(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity$5.a.e);
      LocalFileBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity$5.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity.5.1
 * JD-Core Version:    0.7.0.1
 */