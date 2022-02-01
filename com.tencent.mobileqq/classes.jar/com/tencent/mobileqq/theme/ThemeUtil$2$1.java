package com.tencent.mobileqq.theme;

import aoei;
import beir;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;

public class ThemeUtil$2$1
  implements Runnable
{
  public ThemeUtil$2$1(beir parambeir) {}
  
  public void run()
  {
    ThemeUtil.isNowThemeIsAnimate();
    aoei localaoei = (aoei)this.this$0.a.getBusinessHandler(BusinessHandlerFactory.THEME_HANDLER);
    if (localaoei != null) {
      localaoei.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeUtil.2.1
 * JD-Core Version:    0.7.0.1
 */