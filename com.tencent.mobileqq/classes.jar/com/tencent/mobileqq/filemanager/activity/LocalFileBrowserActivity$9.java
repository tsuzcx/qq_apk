package com.tencent.mobileqq.filemanager.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Environment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.LocalFileAdapter;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

class LocalFileBrowserActivity$9
  extends AsyncTask<String, String, List<FileInfo>>
{
  LocalFileBrowserActivity$9(LocalFileBrowserActivity paramLocalFileBrowserActivity, boolean paramBoolean) {}
  
  protected List<FileInfo> a(String... paramVarArgs)
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_f_of_type_Int;
    int i = 0;
    if (j == 6)
    {
      if (AppConstants.SDCARD_FILE_SAVE_PATH.equalsIgnoreCase(paramVarArgs[0])) {
        paramVarArgs = QQFileManagerUtil.a(false, 0);
      } else {
        paramVarArgs = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getFiles(paramVarArgs[0], false, 0);
      }
    }
    else {
      paramVarArgs = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getFiles(paramVarArgs[0], false, 1);
    }
    if (paramVarArgs == null)
    {
      paramVarArgs = LocalFileBrowserActivity.e;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("tmp is null! mCategory:");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_f_of_type_Int);
      QLog.e(paramVarArgs, 1, ((StringBuilder)localObject1).toString());
      return null;
    }
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.l)
    {
      localObject1 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
      ((StringBuilder)localObject2).append("/QQ/");
      localObject1 = new File(((StringBuilder)localObject2).toString());
      localObject1 = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getFiles(((File)localObject1).getAbsolutePath(), false, 0);
      if (localObject1 != null) {
        paramVarArgs.addAll((Collection)localObject1);
      }
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.getIntent().getStringArrayExtra("STRING_Show_Within_Suffixs");
    if (localObject1 != null) {
      while (i < paramVarArgs.size())
      {
        localObject2 = (FileInfo)paramVarArgs.get(i);
        j = i;
        if (!((FileInfo)localObject2).d()) {
          if (((FileInfo)localObject2).a() != 0L)
          {
            j = i;
            if (((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).checkEnds(((FileInfo)localObject2).d().toLowerCase(), (String[])localObject1)) {}
          }
          else
          {
            paramVarArgs.remove(i);
            j = i - 1;
          }
        }
        i = j + 1;
      }
    }
    return paramVarArgs;
  }
  
  protected void a(List<FileInfo> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.b.clear();
    if (paramList != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.b.addAll(paramList);
      paramList.clear();
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter.getCount() != 0)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.isStackFromBottom()) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setStackFromBottom(true);
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setStackFromBottom(false);
      }
      LocalFileBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity);
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_JavaUtilMap.containsKey(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_f_of_type_JavaLangString))
    {
      int i = ((Integer)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_f_of_type_JavaLangString)).intValue();
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter.getCount() > i) {
        LocalFileBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity, i);
      }
    }
    QQFileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.centerView);
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisible(true);
    QQFileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.centerView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity.9
 * JD-Core Version:    0.7.0.1
 */