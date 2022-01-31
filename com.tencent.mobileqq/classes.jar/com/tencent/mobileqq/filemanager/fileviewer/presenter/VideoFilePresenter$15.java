package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import alud;
import android.app.Activity;
import arki;
import arnb;
import arng;
import aron;
import bdgm;
import bdjz;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class VideoFilePresenter$15
  implements Runnable
{
  public VideoFilePresenter$15(arnb paramarnb, int paramInt, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int != -6101) && (this.jdField_a_of_type_Int != -7003) && (this.jdField_a_of_type_Int != 201)) {
      this.this$0.jdField_a_of_type_Aron.a(this.this$0.jdField_a_of_type_Arki.d(), this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692971));
    }
    label301:
    for (;;)
    {
      return;
      Object localObject;
      if ((this.jdField_a_of_type_Int == -6101) || (this.jdField_a_of_type_Int == -7003))
      {
        localObject = this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692941);
        this.this$0.jdField_a_of_type_Arki.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        if (BaseActivity.sTopActivity == null) {
          break label301;
        }
        localObject = bdgm.a(BaseActivity.sTopActivity, 230, "", (CharSequence)localObject, null, alud.a(2131716659), new arng(this), null);
        if (((bdjz)localObject).isShowing()) {
          break;
        }
        ((bdjz)localObject).show();
        return;
        if (this.jdField_a_of_type_Int == 201)
        {
          if (!this.this$0.jdField_a_of_type_Arki.g()) {
            localObject = this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692972);
          } else {
            this.this$0.jdField_a_of_type_Aron.a(this.this$0.jdField_a_of_type_Arki.d(), this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692971));
          }
        }
        else
        {
          String str = this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692971);
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