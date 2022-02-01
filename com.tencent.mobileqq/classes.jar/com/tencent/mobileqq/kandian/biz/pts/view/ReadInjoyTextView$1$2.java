package com.tencent.mobileqq.kandian.biz.pts.view;

import com.tencent.mobileqq.kandian.base.utils.RIJStringUtils;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule;
import com.tencent.mobileqq.qroute.QRoute;

class ReadInjoyTextView$1$2
  implements Runnable
{
  ReadInjoyTextView$1$2(ReadInjoyTextView.1 param1) {}
  
  public void run()
  {
    this.a.a.setText(ReadInjoyTextView.a(this.a.a, this.a.b, RIJStringUtils.a(((IReadInJoyUserInfoModule)QRoute.api(IReadInJoyUserInfoModule.class)).getDefaultNickName())));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInjoyTextView.1.2
 * JD-Core Version:    0.7.0.1
 */