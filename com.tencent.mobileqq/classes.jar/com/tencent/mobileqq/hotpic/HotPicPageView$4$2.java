package com.tencent.mobileqq.hotpic;

import android.app.Dialog;
import anvx;
import avmn;
import avmo;
import avmv;
import bhdj;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class HotPicPageView$4$2
  implements Runnable
{
  public HotPicPageView$4$2(avmn paramavmn) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = bhdj.a(this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.a, 232, null, anvx.a(2131705084), new avmo(this), null);
    try
    {
      localQQCustomDialog.show();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotPicManagerHotPicPageView", 2, "show dialog fail");
      }
      if (this.a.jdField_a_of_type_Avmv.a == 1) {
        this.a.jdField_a_of_type_Avmv.a(0);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.d = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView.4.2
 * JD-Core Version:    0.7.0.1
 */