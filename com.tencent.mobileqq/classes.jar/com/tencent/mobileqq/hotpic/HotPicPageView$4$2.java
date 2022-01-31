package com.tencent.mobileqq.hotpic;

import ajjy;
import android.app.Dialog;
import aqfh;
import aqfi;
import aqfp;
import babr;
import bafb;
import com.tencent.qphone.base.util.QLog;

public class HotPicPageView$4$2
  implements Runnable
{
  public HotPicPageView$4$2(aqfh paramaqfh) {}
  
  public void run()
  {
    bafb localbafb = babr.a(this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.a, 232, null, ajjy.a(2131639815), new aqfi(this), null);
    try
    {
      localbafb.show();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotPicManagerHotPicPageView", 2, "show dialog fail");
      }
      if (this.a.jdField_a_of_type_Aqfp.a == 1) {
        this.a.jdField_a_of_type_Aqfp.a(0);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.d = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView.4.2
 * JD-Core Version:    0.7.0.1
 */