package com.tencent.mobileqq.data;

import arut;
import bdla;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class MessageForNearbyMarketGrayTips$HightlightClickableSpan$4
  implements Runnable
{
  public MessageForNearbyMarketGrayTips$HightlightClickableSpan$4(arut paramarut, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MessageForNearbyMarketGrayTips", 4, "0X80052C4");
    }
    bdla.b(this.a, "CliOper", "", "", "0X80052C4", "0X80052C4", 0, 0, arut.a(this.this$0).frienduin, "", "", "");
    QQAppInterface localQQAppInterface;
    if ((arut.a(this.this$0).AioType == 1) || (arut.a(this.this$0).AioType == 3))
    {
      localQQAppInterface = this.a;
      if (arut.a(this.this$0).AioType != 0) {
        break label122;
      }
    }
    label122:
    for (String str = "0";; str = "1")
    {
      bdla.b(localQQAppInterface, "dc00899", "grp_lbs", "", "tmp_grey", "clk_blue", 0, 0, str, "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips.HightlightClickableSpan.4
 * JD-Core Version:    0.7.0.1
 */