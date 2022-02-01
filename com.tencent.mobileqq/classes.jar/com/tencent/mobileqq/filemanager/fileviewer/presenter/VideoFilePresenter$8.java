package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import anni;
import atoo;
import atro;
import atru;
import atsu;
import bglp;
import bgpa;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class VideoFilePresenter$8
  implements Runnable
{
  public void run()
  {
    if ((this.jdField_a_of_type_Int != -6101) && (this.jdField_a_of_type_Int != -7003) && (this.jdField_a_of_type_Int != 201)) {
      this.this$0.jdField_a_of_type_Atsu.a(this.this$0.jdField_a_of_type_Atoo.d(), this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692497));
    }
    label301:
    for (;;)
    {
      return;
      Object localObject;
      if ((this.jdField_a_of_type_Int == -6101) || (this.jdField_a_of_type_Int == -7003))
      {
        localObject = this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692466);
        this.this$0.jdField_a_of_type_Atoo.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        if (BaseActivity.sTopActivity == null) {
          break label301;
        }
        localObject = bglp.a(BaseActivity.sTopActivity, 230, "", (CharSequence)localObject, null, anni.a(2131714936), new atru(this), null);
        if (((bgpa)localObject).isShowing()) {
          break;
        }
        ((bgpa)localObject).show();
        return;
        if (this.jdField_a_of_type_Int == 201)
        {
          if (!this.this$0.jdField_a_of_type_Atoo.g()) {
            localObject = this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692498);
          } else {
            this.this$0.jdField_a_of_type_Atsu.a(this.this$0.jdField_a_of_type_Atoo.d(), this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692497));
          }
        }
        else
        {
          String str = this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692497);
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