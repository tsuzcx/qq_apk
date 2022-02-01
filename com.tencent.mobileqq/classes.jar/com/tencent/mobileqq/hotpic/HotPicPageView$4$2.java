package com.tencent.mobileqq.hotpic;

import android.app.Dialog;
import anzj;
import avtt;
import avtu;
import avub;
import bhlq;
import bhpc;
import com.tencent.qphone.base.util.QLog;

public class HotPicPageView$4$2
  implements Runnable
{
  public HotPicPageView$4$2(avtt paramavtt) {}
  
  public void run()
  {
    bhpc localbhpc = bhlq.a(this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.a, 232, null, anzj.a(2131704503), new avtu(this), null);
    try
    {
      localbhpc.show();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotPicManagerHotPicPageView", 2, "show dialog fail");
      }
      if (this.a.jdField_a_of_type_Avub.a == 1) {
        this.a.jdField_a_of_type_Avub.a(0);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.d = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView.4.2
 * JD-Core Version:    0.7.0.1
 */