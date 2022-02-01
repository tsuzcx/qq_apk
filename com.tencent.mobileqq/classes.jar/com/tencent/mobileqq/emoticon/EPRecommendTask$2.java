package com.tencent.mobileqq.emoticon;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import mqq.util.WeakReference;

class EPRecommendTask$2
  extends CallBacker
{
  EPRecommendTask$2(EPRecommendTask paramEPRecommendTask) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    paramString2 = (QQAppInterface)this.a.jdField_a_of_type_MqqUtilWeakReference.get();
    if (paramString2 == null) {}
    while (!"emoji_app_vip_emoji_aio_android_config.json".equals(paramString1)) {
      return;
    }
    ((IVasQuickUpdateService)paramString2.getRuntimeService(IVasQuickUpdateService.class, "")).removeCallBacker(this.a.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker);
    paramString1 = VasUpdateUtil.a(paramString2, "emoji_app_vip_emoji_aio_android_config.json", false, null);
    this.a.a(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EPRecommendTask.2
 * JD-Core Version:    0.7.0.1
 */