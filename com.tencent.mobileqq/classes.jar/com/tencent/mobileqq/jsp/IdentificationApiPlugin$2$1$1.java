package com.tencent.mobileqq.jsp;

import android.content.Intent;
import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class IdentificationApiPlugin$2$1$1
  implements QQPermissionCallback
{
  IdentificationApiPlugin$2$1$1(IdentificationApiPlugin.2.1 param1) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(IdentificationApiPlugin.a(this.a.jdField_a_of_type_ComTencentMobileqqJspIdentificationApiPlugin$2.a), paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = new Intent();
    paramArrayOfString.putExtra("FaceRecognition.AppConf", this.a.jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf);
    IdentificationApiPlugin.a(this.a.jdField_a_of_type_ComTencentMobileqqJspIdentificationApiPlugin$2.a, paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.IdentificationApiPlugin.2.1.1
 * JD-Core Version:    0.7.0.1
 */