package com.tencent.mobileqq.intervideo.huayang;

import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.intervideo.IPluginEnterManager;
import com.tencent.mobileqq.intervideo.shadow.PluginProcessKiller;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Map;

final class HuayangOpenHelper$1
  implements Runnable
{
  HuayangOpenHelper$1(String paramString1, IHuayangDowanloadHelper paramIHuayangDowanloadHelper, QQAppInterface paramQQAppInterface, String paramString2, String paramString3, Map paramMap) {}
  
  public void run()
  {
    ((IPluginEnterManager)QRoute.api(IPluginEnterManager.class)).switchBiz(this.jdField_a_of_type_JavaLangString, (PluginProcessKiller)this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangIHuayangDowanloadHelper);
    ThreadManagerV2.getUIHandlerV2().post(new HuayangOpenHelper.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangOpenHelper.1
 * JD-Core Version:    0.7.0.1
 */