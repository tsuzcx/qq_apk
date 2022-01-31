package com.tencent.mobileqq.hotpic;

import alud;
import android.app.Dialog;
import asui;
import asuj;
import asuq;
import bdgm;
import bdjz;
import com.tencent.qphone.base.util.QLog;

public class HotPicPageView$4$2
  implements Runnable
{
  public HotPicPageView$4$2(asui paramasui) {}
  
  public void run()
  {
    bdjz localbdjz = bdgm.a(this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.a, 232, null, alud.a(2131705995), new asuj(this), null);
    try
    {
      localbdjz.show();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotPicManagerHotPicPageView", 2, "show dialog fail");
      }
      if (this.a.jdField_a_of_type_Asuq.a == 1) {
        this.a.jdField_a_of_type_Asuq.a(0);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.d = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView.4.2
 * JD-Core Version:    0.7.0.1
 */