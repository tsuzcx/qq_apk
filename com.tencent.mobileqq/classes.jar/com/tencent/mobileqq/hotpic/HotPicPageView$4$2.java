package com.tencent.mobileqq.hotpic;

import ajya;
import android.app.Dialog;
import aqzl;
import aqzm;
import aqzt;
import bbdj;
import bbgu;
import com.tencent.qphone.base.util.QLog;

public class HotPicPageView$4$2
  implements Runnable
{
  public HotPicPageView$4$2(aqzl paramaqzl) {}
  
  public void run()
  {
    bbgu localbbgu = bbdj.a(this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.a, 232, null, ajya.a(2131705611), new aqzm(this), null);
    try
    {
      localbbgu.show();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotPicManagerHotPicPageView", 2, "show dialog fail");
      }
      if (this.a.jdField_a_of_type_Aqzt.a == 1) {
        this.a.jdField_a_of_type_Aqzt.a(0);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.d = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView.4.2
 * JD-Core Version:    0.7.0.1
 */