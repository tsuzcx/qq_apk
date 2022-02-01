package com.tencent.mobileqq.utils;

import com.tencent.qphone.base.remote.SimpleAccount;
import mqq.app.MobileQQ;

public class OCRAccountUtil
{
  public static final String a()
  {
    SimpleAccount localSimpleAccount = MobileQQ.sMobileQQ.getFirstSimpleAccount();
    if (localSimpleAccount != null) {
      return localSimpleAccount.getUin();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.OCRAccountUtil
 * JD-Core Version:    0.7.0.1
 */