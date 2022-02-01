package com.tencent.mobileqq.qwallet.hb.aio.elem.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.qphone.base.util.QLog;

class CustomizeStrategyFactory$ThemeCustomizeStrategy$1
  implements Runnable
{
  CustomizeStrategyFactory$ThemeCustomizeStrategy$1(CustomizeStrategyFactory.ThemeCustomizeStrategy paramThemeCustomizeStrategy, RedPacketInfo paramRedPacketInfo) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "ThemeCustomizeStrategy");
      }
      if ((CustomizeStrategyFactory.ThemeCustomizeStrategy.a(this.this$0) != null) && (!TextUtils.isEmpty(this.a.templateId)))
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.a.templateId);
        ((StringBuilder)localObject).append(".png");
        localObject = ((StringBuilder)localObject).toString();
        CustomizeStrategyFactory.ThemeCustomizeStrategy.a(this.this$0).getFilePath((String)localObject, new CustomizeStrategyFactory.ThemeCustomizeStrategy.1.1(this));
        return;
      }
      CustomizeStrategyFactory.a().a(this.a);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.elem.impl.CustomizeStrategyFactory.ThemeCustomizeStrategy.1
 * JD-Core Version:    0.7.0.1
 */