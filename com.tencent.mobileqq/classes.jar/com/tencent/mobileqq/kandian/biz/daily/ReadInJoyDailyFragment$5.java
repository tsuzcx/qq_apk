package com.tencent.mobileqq.kandian.biz.daily;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;

class ReadInJoyDailyFragment$5
  implements Runnable
{
  ReadInJoyDailyFragment$5(ReadInJoyDailyFragment paramReadInJoyDailyFragment) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.a();
    if (localQQAppInterface == null) {
      return;
    }
    ((IWebProcessManagerService)localQQAppInterface.getRuntimeService(IWebProcessManagerService.class, "")).startWebProcess(-1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyFragment.5
 * JD-Core Version:    0.7.0.1
 */