package com.tencent.mobileqq.qwallet.hb.aio.elem.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.qphone.base.util.QLog;

class CustomizeStrategyFactory$PanelStrategy$1
  implements Runnable
{
  CustomizeStrategyFactory$PanelStrategy$1(CustomizeStrategyFactory.PanelStrategy paramPanelStrategy, RedPacketInfo paramRedPacketInfo) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "PanelStrategy");
      }
      if ((this.this$0.a != null) && (this.this$0.b != null) && (!TextUtils.isEmpty(this.a.templateId)))
      {
        String str = this.this$0.b.getString("redPackPanel", "https://i.gtimg.cn/channel/imglib/201803/", new String[] { "themeInfo", "prefix" });
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(this.a.templateId);
        localStringBuilder.append(".png");
        str = localStringBuilder.toString();
        this.this$0.a.getFilePath(str, new CustomizeStrategyFactory.PanelStrategy.1.1(this));
        return;
      }
      CustomizeStrategyFactory.d().a(this.a);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.elem.impl.CustomizeStrategyFactory.PanelStrategy.1
 * JD-Core Version:    0.7.0.1
 */