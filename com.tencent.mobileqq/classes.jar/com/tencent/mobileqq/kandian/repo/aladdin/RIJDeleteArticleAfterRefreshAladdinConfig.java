package com.tencent.mobileqq.kandian.repo.aladdin;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.repo.daily.api.IDailyModeConfigHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class RIJDeleteArticleAfterRefreshAladdinConfig
{
  private static final AladdinConfig a = Aladdin.getConfig(256);
  
  public static boolean a(int paramInt)
  {
    boolean bool = false;
    if ((paramInt != 0) && (!((IDailyModeConfigHandler)QRoute.api(IDailyModeConfigHandler.class)).isDailyUnlimitChannel(paramInt))) {
      return false;
    }
    if (a.getIntegerFromString("enable_delete_article_after_refresh", 0) == 1) {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[isEnableDeleteArticleAfterRefresh] channelID = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", res = ");
      localStringBuilder.append(bool);
      QLog.i("RIJDeleteArticleAfterRefreshAladdinConfig", 1, localStringBuilder.toString());
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.RIJDeleteArticleAfterRefreshAladdinConfig
 * JD-Core Version:    0.7.0.1
 */