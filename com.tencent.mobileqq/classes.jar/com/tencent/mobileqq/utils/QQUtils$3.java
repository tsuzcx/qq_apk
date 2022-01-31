package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public final class QQUtils$3
  implements Runnable
{
  public void run()
  {
    String str = null;
    if (this.jdField_a_of_type_Boolean) {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131720516);
    }
    if (str != null) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2, str, 0).b(this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQUtils.3
 * JD-Core Version:    0.7.0.1
 */