package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import amtj;
import android.app.Activity;
import asst;
import asvt;
import asvz;
import aswz;
import bfur;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class VideoFilePresenter$8
  implements Runnable
{
  public void run()
  {
    if ((this.jdField_a_of_type_Int != -6101) && (this.jdField_a_of_type_Int != -7003) && (this.jdField_a_of_type_Int != 201)) {
      this.this$0.jdField_a_of_type_Aswz.a(this.this$0.jdField_a_of_type_Asst.d(), this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692551));
    }
    label301:
    for (;;)
    {
      return;
      Object localObject;
      if ((this.jdField_a_of_type_Int == -6101) || (this.jdField_a_of_type_Int == -7003))
      {
        localObject = this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692520);
        this.this$0.jdField_a_of_type_Asst.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        if (BaseActivity.sTopActivity == null) {
          break label301;
        }
        localObject = bfur.a(BaseActivity.sTopActivity, 230, "", (CharSequence)localObject, null, amtj.a(2131715279), new asvz(this), null);
        if (((QQCustomDialog)localObject).isShowing()) {
          break;
        }
        ((QQCustomDialog)localObject).show();
        return;
        if (this.jdField_a_of_type_Int == 201)
        {
          if (!this.this$0.jdField_a_of_type_Asst.g()) {
            localObject = this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692552);
          } else {
            this.this$0.jdField_a_of_type_Aswz.a(this.this$0.jdField_a_of_type_Asst.d(), this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692551));
          }
        }
        else
        {
          String str = this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692551);
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