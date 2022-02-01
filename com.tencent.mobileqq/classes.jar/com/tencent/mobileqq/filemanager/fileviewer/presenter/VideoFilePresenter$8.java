package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import anzj;
import augj;
import aujj;
import aujp;
import aukp;
import bhlq;
import bhpc;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class VideoFilePresenter$8
  implements Runnable
{
  public void run()
  {
    if ((this.jdField_a_of_type_Int != -6101) && (this.jdField_a_of_type_Int != -7003) && (this.jdField_a_of_type_Int != 201)) {
      this.this$0.jdField_a_of_type_Aukp.a(this.this$0.jdField_a_of_type_Augj.d(), this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692503));
    }
    label301:
    for (;;)
    {
      return;
      Object localObject;
      if ((this.jdField_a_of_type_Int == -6101) || (this.jdField_a_of_type_Int == -7003))
      {
        localObject = this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692472);
        this.this$0.jdField_a_of_type_Augj.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        if (BaseActivity.sTopActivity == null) {
          break label301;
        }
        localObject = bhlq.a(BaseActivity.sTopActivity, 230, "", (CharSequence)localObject, null, anzj.a(2131715045), new aujp(this), null);
        if (((bhpc)localObject).isShowing()) {
          break;
        }
        ((bhpc)localObject).show();
        return;
        if (this.jdField_a_of_type_Int == 201)
        {
          if (!this.this$0.jdField_a_of_type_Augj.g()) {
            localObject = this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692504);
          } else {
            this.this$0.jdField_a_of_type_Aukp.a(this.this$0.jdField_a_of_type_Augj.d(), this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692503));
          }
        }
        else
        {
          String str = this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692503);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.8
 * JD-Core Version:    0.7.0.1
 */