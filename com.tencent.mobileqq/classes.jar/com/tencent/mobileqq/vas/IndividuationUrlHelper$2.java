package com.tencent.mobileqq.vas;

import com.tencent.common.app.BaseApplicationImpl;

final class IndividuationUrlHelper$2
  implements Runnable
{
  IndividuationUrlHelper$2(IndividuationUrlHelper.UrlCallback paramUrlCallback) {}
  
  public void run()
  {
    IndividuationUrlHelper.a(BaseApplicationImpl.sApplication.getRuntime());
    IndividuationUrlHelper.a(true);
    if (this.a != null) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.IndividuationUrlHelper.2
 * JD-Core Version:    0.7.0.1
 */