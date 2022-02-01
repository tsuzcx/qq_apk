package com.tencent.mobileqq.theme;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThemeHandler;

class ThemeUtil$2$1
  implements Runnable
{
  ThemeUtil$2$1(ThemeUtil.2 param2) {}
  
  public void run()
  {
    ThemeUtil.isNowThemeIsAnimate();
    ThemeHandler localThemeHandler = (ThemeHandler)this.this$0.val$app.getBusinessHandler(BusinessHandlerFactory.THEME_HANDLER);
    if (localThemeHandler != null) {
      localThemeHandler.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeUtil.2.1
 * JD-Core Version:    0.7.0.1
 */