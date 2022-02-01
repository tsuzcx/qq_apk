package com.tencent.mobileqq.kandian.glue.viola.view;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

class ViolaBaseView$20
  implements ViolaBaseView.LoadAsyBack
{
  ViolaBaseView$20(ViolaBaseView paramViolaBaseView, boolean paramBoolean) {}
  
  public void a()
  {
    if (ViolaBaseView.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView) != null) {
      ViolaBaseView.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView).c();
    }
    ViolaBaseView.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView, 2, this.jdField_a_of_type_Boolean);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(ViolaBaseView.b(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView)))
    {
      ViolaBaseView.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView, paramString, this.jdField_a_of_type_Boolean);
    }
    else
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      if (!bool) {
        ViolaBaseView.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView, paramString, bool);
      }
    }
    if (QLog.isColorLevel()) {
      ThreadManager.post(new ViolaBaseView.20.1(this, paramString), 8, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView.20
 * JD-Core Version:    0.7.0.1
 */