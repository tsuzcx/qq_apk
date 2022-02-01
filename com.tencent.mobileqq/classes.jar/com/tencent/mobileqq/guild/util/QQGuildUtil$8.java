package com.tencent.mobileqq.guild.util;

import com.tencent.mobileqq.widget.QQToast;
import mqq.app.MobileQQ;

final class QQGuildUtil$8
  implements Runnable
{
  QQGuildUtil$8(String paramString) {}
  
  public void run()
  {
    QQToast.makeText(MobileQQ.sMobileQQ.getApplicationContext(), this.a, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.QQGuildUtil.8
 * JD-Core Version:    0.7.0.1
 */