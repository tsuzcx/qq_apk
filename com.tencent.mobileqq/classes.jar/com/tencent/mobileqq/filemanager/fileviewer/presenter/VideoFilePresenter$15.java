package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import alpo;
import android.app.Activity;
import arfz;
import aris;
import arix;
import arke;
import bdcd;
import bdfq;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class VideoFilePresenter$15
  implements Runnable
{
  public VideoFilePresenter$15(aris paramaris, int paramInt, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int != -6101) && (this.jdField_a_of_type_Int != -7003) && (this.jdField_a_of_type_Int != 201)) {
      this.this$0.jdField_a_of_type_Arke.a(this.this$0.jdField_a_of_type_Arfz.d(), this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692969));
    }
    label301:
    for (;;)
    {
      return;
      Object localObject;
      if ((this.jdField_a_of_type_Int == -6101) || (this.jdField_a_of_type_Int == -7003))
      {
        localObject = this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692939);
        this.this$0.jdField_a_of_type_Arfz.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        if (BaseActivity.sTopActivity == null) {
          break label301;
        }
        localObject = bdcd.a(BaseActivity.sTopActivity, 230, "", (CharSequence)localObject, null, alpo.a(2131716647), new arix(this), null);
        if (((bdfq)localObject).isShowing()) {
          break;
        }
        ((bdfq)localObject).show();
        return;
        if (this.jdField_a_of_type_Int == 201)
        {
          if (!this.this$0.jdField_a_of_type_Arfz.g()) {
            localObject = this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692970);
          } else {
            this.this$0.jdField_a_of_type_Arke.a(this.this$0.jdField_a_of_type_Arfz.d(), this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692969));
          }
        }
        else
        {
          String str = this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692969);
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
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.15
 * JD-Core Version:    0.7.0.1
 */