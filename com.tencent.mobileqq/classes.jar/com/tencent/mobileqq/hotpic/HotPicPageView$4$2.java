package com.tencent.mobileqq.hotpic;

import ajyc;
import android.app.Dialog;
import aqzj;
import aqzk;
import aqzr;
import bbcv;
import bbgg;
import com.tencent.qphone.base.util.QLog;

public class HotPicPageView$4$2
  implements Runnable
{
  public HotPicPageView$4$2(aqzj paramaqzj) {}
  
  public void run()
  {
    bbgg localbbgg = bbcv.a(this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.a, 232, null, ajyc.a(2131705600), new aqzk(this), null);
    try
    {
      localbbgg.show();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotPicManagerHotPicPageView", 2, "show dialog fail");
      }
      if (this.a.jdField_a_of_type_Aqzr.a == 1) {
        this.a.jdField_a_of_type_Aqzr.a(0);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.d = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView.4.2
 * JD-Core Version:    0.7.0.1
 */