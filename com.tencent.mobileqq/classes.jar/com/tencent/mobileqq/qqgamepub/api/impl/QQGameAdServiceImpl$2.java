package com.tencent.mobileqq.qqgamepub.api.impl;

import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class QQGameAdServiceImpl$2
  implements Runnable
{
  QQGameAdServiceImpl$2(QQGameAdServiceImpl paramQQGameAdServiceImpl) {}
  
  public void run()
  {
    ((IGdtAdAPI)QRoute.api(IGdtAdAPI.class)).initGdtContext(QQGameAdServiceImpl.access$000(this.this$0), new InitGdtContextParams());
    QLog.i("QQGamePub_QQGameAdServiceImpl", 2, "<<<<init device info<<<<");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGameAdServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */