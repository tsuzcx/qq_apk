package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class IdentificationApiPlugin$2$1
  implements Runnable
{
  IdentificationApiPlugin$2$1(IdentificationApiPlugin.2 param2, FaceDetectForThirdPartyManager.AppConf paramAppConf) {}
  
  public void run()
  {
    IdentificationApiPlugin.a(this.jdField_a_of_type_ComTencentMobileqqJspIdentificationApiPlugin$2.a);
    int i;
    if (Build.VERSION.SDK_INT >= 23) {
      if (IdentificationApiPlugin.a(this.jdField_a_of_type_ComTencentMobileqqJspIdentificationApiPlugin$2.a).checkSelfPermission("android.permission.CAMERA") == 0) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        ((QQBrowserActivity)IdentificationApiPlugin.a(this.jdField_a_of_type_ComTencentMobileqqJspIdentificationApiPlugin$2.a)).requestPermissions(new IdentificationApiPlugin.2.1.1(this), 1, new String[] { "android.permission.CAMERA" });
        return;
        i = 0;
      }
      else
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("FaceRecognition.AppConf", this.jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf);
        IdentificationApiPlugin.a(this.jdField_a_of_type_ComTencentMobileqqJspIdentificationApiPlugin$2.a, localIntent);
        return;
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.IdentificationApiPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */