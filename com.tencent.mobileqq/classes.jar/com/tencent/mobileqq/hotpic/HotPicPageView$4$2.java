package com.tencent.mobileqq.hotpic;

import alpo;
import android.app.Dialog;
import aspz;
import asqa;
import asqh;
import bdcd;
import bdfq;
import com.tencent.qphone.base.util.QLog;

public class HotPicPageView$4$2
  implements Runnable
{
  public HotPicPageView$4$2(aspz paramaspz) {}
  
  public void run()
  {
    bdfq localbdfq = bdcd.a(this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.a, 232, null, alpo.a(2131705983), new asqa(this), null);
    try
    {
      localbdfq.show();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotPicManagerHotPicPageView", 2, "show dialog fail");
      }
      if (this.a.jdField_a_of_type_Asqh.a == 1) {
        this.a.jdField_a_of_type_Asqh.a(0);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.d = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView.4.2
 * JD-Core Version:    0.7.0.1
 */