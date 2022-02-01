package com.tencent.mobileqq.theme;

import anbt;
import bdbr;
import com.tencent.mobileqq.app.QQAppInterface;

public class ThemeUtil$2$1
  implements Runnable
{
  public ThemeUtil$2$1(bdbr parambdbr) {}
  
  public void run()
  {
    ThemeUtil.isNowThemeIsAnimate();
    anbt localanbt = (anbt)this.this$0.a.getBusinessHandler(14);
    if (localanbt != null) {
      localanbt.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeUtil.2.1
 * JD-Core Version:    0.7.0.1
 */