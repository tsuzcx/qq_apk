package com.tencent.mobileqq.emosm.favroaming;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;

class EmoAddedAuthCallback$4
  implements Runnable
{
  EmoAddedAuthCallback$4(EmoAddedAuthCallback paramEmoAddedAuthCallback) {}
  
  public void run()
  {
    Object localObject = (BaseQQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    int i = ((IFavroamingDBManagerService)this.this$0.a.getRuntimeService(IFavroamingDBManagerService.class)).syncGetCustomEmotionInfoShowedInPanel().size();
    if (i != FavEmoConstant.b)
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("local_size", String.valueOf(i));
      ((HashMap)localObject).put("roaming_max_size", String.valueOf(FavEmoConstant.b));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "AddFavEmotionError", false, 0L, 0L, (HashMap)localObject, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoAddedAuthCallback.4
 * JD-Core Version:    0.7.0.1
 */