package com.tencent.mobileqq.flashshow.helper;

import com.tencent.mobileqq.flashshow.config.FSConfig;

final class FSBindPhoneNumberHelper$2
  implements Runnable
{
  public void run()
  {
    if (FSConfig.o() == 1) {
      return;
    }
    FSBindPhoneNumberHelper.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.helper.FSBindPhoneNumberHelper.2
 * JD-Core Version:    0.7.0.1
 */