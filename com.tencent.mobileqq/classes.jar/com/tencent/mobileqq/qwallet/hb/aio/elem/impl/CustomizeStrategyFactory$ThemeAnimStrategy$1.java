package com.tencent.mobileqq.qwallet.hb.aio.elem.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.qphone.base.util.QLog;

class CustomizeStrategyFactory$ThemeAnimStrategy$1
  implements Runnable
{
  CustomizeStrategyFactory$ThemeAnimStrategy$1(CustomizeStrategyFactory.ThemeAnimStrategy paramThemeAnimStrategy, RedPacketInfo paramRedPacketInfo) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomizeStrategyFactory", 2, "ThemeAnimStrategy");
    }
    if ((CustomizeStrategyFactory.ThemeAnimStrategy.a(this.this$0) != null) && (!TextUtils.isEmpty(this.a.templateId)))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.templateId);
      ((StringBuilder)localObject).append(".zip");
      localObject = ((StringBuilder)localObject).toString();
      CustomizeStrategyFactory.ThemeAnimStrategy.a(this.this$0).getUnzipFolderPath((String)localObject, "", new CustomizeStrategyFactory.ThemeAnimStrategy.1.1(this));
      return;
    }
    CustomizeStrategyFactory.a().a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.elem.impl.CustomizeStrategyFactory.ThemeAnimStrategy.1
 * JD-Core Version:    0.7.0.1
 */