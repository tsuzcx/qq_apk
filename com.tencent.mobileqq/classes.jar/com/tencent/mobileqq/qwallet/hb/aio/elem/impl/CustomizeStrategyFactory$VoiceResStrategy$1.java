package com.tencent.mobileqq.qwallet.hb.aio.elem.impl;

import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.qphone.base.util.QLog;

class CustomizeStrategyFactory$VoiceResStrategy$1
  implements Runnable
{
  CustomizeStrategyFactory$VoiceResStrategy$1(CustomizeStrategyFactory.VoiceResStrategy paramVoiceResStrategy, RedPacketInfo paramRedPacketInfo) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "VoiceResStrategy");
      }
      if ((this.this$0.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqQwalletConfigIQWalletConfigService != null))
      {
        String str = this.this$0.jdField_a_of_type_ComTencentMobileqqQwalletConfigIQWalletConfigService.getString("voice_pwd", "https://imgcache.qq.com/channel/static/socialpay/voice/", new String[] { "urlPrefix" });
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("voice_rate_");
        localStringBuilder.append(this.a.templateId);
        localStringBuilder.append(".zip");
        str = localStringBuilder.toString();
        this.this$0.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService.getUnzipFolderPath(str, new CustomizeStrategyFactory.VoiceResStrategy.1.1(this));
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
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.elem.impl.CustomizeStrategyFactory.VoiceResStrategy.1
 * JD-Core Version:    0.7.0.1
 */