package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.VideoFileViewer;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class VideoFilePresenter$8
  implements Runnable
{
  public void run()
  {
    if ((this.jdField_a_of_type_Int != -6101) && (this.jdField_a_of_type_Int != -7003) && (this.jdField_a_of_type_Int != 201)) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.a(this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d(), this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692791));
    }
    label301:
    for (;;)
    {
      return;
      Object localObject;
      if ((this.jdField_a_of_type_Int == -6101) || (this.jdField_a_of_type_Int == -7003))
      {
        localObject = this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692760);
        this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        if (BaseActivity.sTopActivity == null) {
          break label301;
        }
        localObject = DialogUtil.a(BaseActivity.sTopActivity, 230, "", (CharSequence)localObject, null, HardCodeUtil.a(2131716093), new VideoFilePresenter.8.1(this), null);
        if (((QQCustomDialog)localObject).isShowing()) {
          break;
        }
        ((QQCustomDialog)localObject).show();
        return;
        if (this.jdField_a_of_type_Int == 201)
        {
          if (!this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.g()) {
            localObject = this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692792);
          } else {
            this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.a(this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d(), this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692791));
          }
        }
        else
        {
          String str = this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692791);
          localObject = str;
          if (QLog.isColorLevel())
          {
            QLog.i("FileBrowserPresenter<FileAssistant>", 2, "can not handle video error. rc=[" + this.jdField_a_of_type_Int + "]  msg=[" + this.jdField_a_of_type_JavaLangString + "]");
            localObject = str;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.8
 * JD-Core Version:    0.7.0.1
 */