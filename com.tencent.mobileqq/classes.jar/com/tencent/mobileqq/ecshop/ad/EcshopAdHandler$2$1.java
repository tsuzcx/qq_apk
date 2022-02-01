package com.tencent.mobileqq.ecshop.ad;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.ChatMessage;

class EcshopAdHandler$2$1
  implements Runnable
{
  EcshopAdHandler$2$1(EcshopAdHandler.2 param2, Object paramObject) {}
  
  public void run()
  {
    ChatMessage localChatMessage = (ChatMessage)this.a;
    IEcshopAdHandler localIEcshopAdHandler = (IEcshopAdHandler)this.this$0.a.getBusinessHandler(EcshopAdHandler.class.getName());
    IEcshopAdHandler.ReportInfo localReportInfo = new IEcshopAdHandler.ReportInfo();
    localReportInfo.a = 10;
    localIEcshopAdHandler.a(EcshopAdHandler.a(localReportInfo, localChatMessage), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.ad.EcshopAdHandler.2.1
 * JD-Core Version:    0.7.0.1
 */