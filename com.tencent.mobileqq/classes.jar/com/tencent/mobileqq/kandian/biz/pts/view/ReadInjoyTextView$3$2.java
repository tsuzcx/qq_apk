package com.tencent.mobileqq.kandian.biz.pts.view;

import com.tencent.mobileqq.kandian.base.utils.RIJStringUtils;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule;
import com.tencent.mobileqq.qroute.QRoute;

class ReadInjoyTextView$3$2
  implements Runnable
{
  ReadInjoyTextView$3$2(ReadInjoyTextView.3 param3) {}
  
  public void run()
  {
    this.a.b.setText(RIJStringUtils.a(((IReadInJoyUserInfoModule)QRoute.api(IReadInJoyUserInfoModule.class)).getDefaultNickName()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInjoyTextView.3.2
 * JD-Core Version:    0.7.0.1
 */