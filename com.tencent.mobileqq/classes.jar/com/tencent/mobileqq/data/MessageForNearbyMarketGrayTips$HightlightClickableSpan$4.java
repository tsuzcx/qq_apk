package com.tencent.mobileqq.data;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class MessageForNearbyMarketGrayTips$HightlightClickableSpan$4
  implements Runnable
{
  MessageForNearbyMarketGrayTips$HightlightClickableSpan$4(MessageForNearbyMarketGrayTips.HightlightClickableSpan paramHightlightClickableSpan, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MessageForNearbyMarketGrayTips", 4, "0X80052C4");
    }
    ReportController.b(this.a, "CliOper", "", "", "0X80052C4", "0X80052C4", 0, 0, MessageForNearbyMarketGrayTips.HightlightClickableSpan.b(this.this$0).frienduin, "", "", "");
    if ((MessageForNearbyMarketGrayTips.HightlightClickableSpan.b(this.this$0).AioType == 1) || (MessageForNearbyMarketGrayTips.HightlightClickableSpan.b(this.this$0).AioType == 3))
    {
      QQAppInterface localQQAppInterface = this.a;
      String str;
      if (MessageForNearbyMarketGrayTips.HightlightClickableSpan.b(this.this$0).AioType == 0) {
        str = "0";
      } else {
        str = "1";
      }
      ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "tmp_grey", "clk_blue", 0, 0, str, "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips.HightlightClickableSpan.4
 * JD-Core Version:    0.7.0.1
 */