package com.tencent.mobileqq.kandian.glue.viola.view;

import android.text.TextUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;

class ViolaBaseView$20$1
  implements Runnable
{
  ViolaBaseView$20$1(ViolaBaseView.20 param20, String paramString) {}
  
  public void run()
  {
    String str2 = ViolaBaseView.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadJSSource process from downJsFromNet url: ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView$20.a.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" , js source Md5 :");
    String str1;
    if (!TextUtils.isEmpty(ViolaBaseView.b(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView$20.a))) {
      str1 = ViolaBaseView.b(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView$20.a);
    } else {
      str1 = "";
    }
    localStringBuilder.append(MD5Utils.toMD5(str1));
    localStringBuilder.append(" js down source MD5 ");
    localStringBuilder.append(MD5Utils.toMD5(this.jdField_a_of_type_JavaLangString));
    QLog.d(str2, 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView.20.1
 * JD-Core Version:    0.7.0.1
 */