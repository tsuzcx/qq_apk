package com.tencent.mobileqq.vas;

import mqq.app.MobileQQ;

final class IndividuationUrlHelper$2
  implements Runnable
{
  IndividuationUrlHelper$2(IndividuationUrlHelper.UrlCallback paramUrlCallback) {}
  
  public void run()
  {
    IndividuationUrlHelper.a(MobileQQ.sMobileQQ.peekAppRuntime());
    IndividuationUrlHelper.a(true);
    IndividuationUrlHelper.UrlCallback localUrlCallback = this.a;
    if (localUrlCallback != null) {
      localUrlCallback.update();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.IndividuationUrlHelper.2
 * JD-Core Version:    0.7.0.1
 */