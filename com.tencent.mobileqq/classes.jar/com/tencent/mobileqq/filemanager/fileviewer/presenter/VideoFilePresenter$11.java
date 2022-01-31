package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import ajyc;
import android.app.Activity;
import apmx;
import appp;
import appr;
import apqx;
import bbcv;
import bbgg;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class VideoFilePresenter$11
  implements Runnable
{
  public VideoFilePresenter$11(appp paramappp, int paramInt, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int != -6101) && (this.jdField_a_of_type_Int != -7003) && (this.jdField_a_of_type_Int != 201)) {
      this.this$0.jdField_a_of_type_Apqx.a(this.this$0.jdField_a_of_type_Apmx.c(), this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692886));
    }
    label301:
    for (;;)
    {
      return;
      Object localObject;
      if ((this.jdField_a_of_type_Int == -6101) || (this.jdField_a_of_type_Int == -7003))
      {
        localObject = this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692856);
        this.this$0.jdField_a_of_type_Apmx.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        if (BaseActivity.sTopActivity == null) {
          break label301;
        }
        localObject = bbcv.a(BaseActivity.sTopActivity, 230, "", (CharSequence)localObject, null, ajyc.a(2131716264), new appr(this), null);
        if (((bbgg)localObject).isShowing()) {
          break;
        }
        ((bbgg)localObject).show();
        return;
        if (this.jdField_a_of_type_Int == 201)
        {
          if (!this.this$0.jdField_a_of_type_Apmx.g()) {
            localObject = this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692887);
          } else {
            this.this$0.jdField_a_of_type_Apqx.a(this.this$0.jdField_a_of_type_Apmx.c(), this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692886));
          }
        }
        else
        {
          String str = this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131692886);
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