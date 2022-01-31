package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import ajya;
import android.app.Activity;
import apnb;
import appt;
import appv;
import aprb;
import bbdj;
import bbgu;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class VideoFilePresenter$11
  implements Runnable
{
  public VideoFilePresenter$11(appt paramappt, int paramInt, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int != -6101) && (this.jdField_a_of_type_Int != -7003) && (this.jdField_a_of_type_Int != 201)) {
      this.this$0.jdField_a_of_type_Aprb.a(this.this$0.jdField_a_of_type_Apnb.c(), this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692887));
    }
    label301:
    for (;;)
    {
      return;
      Object localObject;
      if ((this.jdField_a_of_type_Int == -6101) || (this.jdField_a_of_type_Int == -7003))
      {
        localObject = this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692857);
        this.this$0.jdField_a_of_type_Apnb.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        if (BaseActivity.sTopActivity == null) {
          break label301;
        }
        localObject = bbdj.a(BaseActivity.sTopActivity, 230, "", (CharSequence)localObject, null, ajya.a(2131716275), new appv(this), null);
        if (((bbgu)localObject).isShowing()) {
          break;
        }
        ((bbgu)localObject).show();
        return;
        if (this.jdField_a_of_type_Int == 201)
        {
          if (!this.this$0.jdField_a_of_type_Apnb.g()) {
            localObject = this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692888);
          } else {
            this.this$0.jdField_a_of_type_Aprb.a(this.this$0.jdField_a_of_type_Apnb.c(), this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692887));
          }
        }
        else
        {
          String str = this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692887);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.11
 * JD-Core Version:    0.7.0.1
 */