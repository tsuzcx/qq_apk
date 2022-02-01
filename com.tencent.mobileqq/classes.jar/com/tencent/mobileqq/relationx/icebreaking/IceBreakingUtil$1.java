package com.tencent.mobileqq.relationx.icebreaking;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.portal.PortalUtils;

final class IceBreakingUtil$1
  implements Runnable
{
  IceBreakingUtil$1(String paramString, int paramInt, QQAppInterface paramQQAppInterface, boolean paramBoolean) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if ((str != null) && (str.length() > 4))
    {
      if (!PortalUtils.a(this.jdField_a_of_type_JavaLangString)) {
        return;
      }
      if (IceBreakingUtil.b(this.jdField_a_of_type_Int))
      {
        IceBreakingUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
        return;
      }
      if (IceBreakingUtil.c(this.jdField_a_of_type_Int))
      {
        IceBreakingUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
        return;
      }
      if (IceBreakingUtil.d(this.jdField_a_of_type_Int))
      {
        IceBreakingUtil.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
        return;
      }
      if (IceBreakingUtil.e(this.jdField_a_of_type_Int)) {
        IceBreakingUtil.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.IceBreakingUtil.1
 * JD-Core Version:    0.7.0.1
 */