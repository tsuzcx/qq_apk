package com.tencent.mobileqq.utils;

import ajpv;
import com.tencent.mobileqq.app.QQAppInterface;

public final class ForwardSendPicUtil$1
  implements Runnable
{
  public ForwardSendPicUtil$1(String paramString, int paramInt, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      String str = this.jdField_a_of_type_JavaLangString;
      int i = this.jdField_a_of_type_Int;
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      ajpv.a(new String[] { str }, i, false, true, -1, localQQAppInterface);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ForwardSendPicUtil.1
 * JD-Core Version:    0.7.0.1
 */