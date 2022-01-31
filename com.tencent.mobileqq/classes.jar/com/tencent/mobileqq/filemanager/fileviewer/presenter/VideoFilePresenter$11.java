package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import ajjy;
import android.app.Activity;
import aovk;
import aoyb;
import aoyd;
import aozd;
import babr;
import bafb;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class VideoFilePresenter$11
  implements Runnable
{
  public VideoFilePresenter$11(aoyb paramaoyb, int paramInt, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int != -6101) && (this.jdField_a_of_type_Int != -7003) && (this.jdField_a_of_type_Int != 201)) {
      this.this$0.jdField_a_of_type_Aozd.a(this.this$0.jdField_a_of_type_Aovk.c(), this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131627248));
    }
    label301:
    for (;;)
    {
      return;
      Object localObject;
      if ((this.jdField_a_of_type_Int == -6101) || (this.jdField_a_of_type_Int == -7003))
      {
        localObject = this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131627218);
        this.this$0.jdField_a_of_type_Aovk.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        if (BaseActivity.sTopActivity == null) {
          break label301;
        }
        localObject = babr.a(BaseActivity.sTopActivity, 230, "", (CharSequence)localObject, null, ajjy.a(2131650473), new aoyd(this), null);
        if (((bafb)localObject).isShowing()) {
          break;
        }
        ((bafb)localObject).show();
        return;
        if (this.jdField_a_of_type_Int == 201)
        {
          if (!this.this$0.jdField_a_of_type_Aovk.g()) {
            localObject = this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131627249);
          } else {
            this.this$0.jdField_a_of_type_Aozd.a(this.this$0.jdField_a_of_type_Aovk.c(), this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131627248));
          }
        }
        else
        {
          String str = this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131627248);
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