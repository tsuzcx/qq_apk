package com.tencent.mobileqq.hotpic;

import android.app.Dialog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class HotPicPageView$4$2
  implements Runnable
{
  HotPicPageView$4$2(HotPicPageView.4 param4) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.a, 232, null, HardCodeUtil.a(2131705693), new HotPicPageView.4.2.1(this), null);
    try
    {
      localQQCustomDialog.show();
      return;
    }
    catch (Exception localException)
    {
      label37:
      break label37;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HotPicManagerHotPicPageView", 2, "show dialog fail");
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder.a == 1) {
      this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder.a(0);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.d = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView.4.2
 * JD-Core Version:    0.7.0.1
 */