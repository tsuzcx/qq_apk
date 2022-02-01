package com.tencent.mobileqq.hotpic;

import android.app.Dialog;
import anni;
import avbr;
import avbs;
import avbz;
import bglp;
import bgpa;
import com.tencent.qphone.base.util.QLog;

public class HotPicPageView$4$2
  implements Runnable
{
  public HotPicPageView$4$2(avbr paramavbr) {}
  
  public void run()
  {
    bgpa localbgpa = bglp.a(this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.a, 232, null, anni.a(2131704396), new avbs(this), null);
    try
    {
      localbgpa.show();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotPicManagerHotPicPageView", 2, "show dialog fail");
      }
      if (this.a.jdField_a_of_type_Avbz.a == 1) {
        this.a.jdField_a_of_type_Avbz.a(0);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.d = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView.4.2
 * JD-Core Version:    0.7.0.1
 */