package com.tencent.mobileqq.kandian.ad.api.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJCommonService;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.AladdinParseUtils;
import com.tencent.mobileqq.kandian.repo.daily.api.IDailyModeConfigHandler;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Map;
import mqq.app.AppRuntime;

public class RIJCommonServiceImpl
  implements IRIJCommonService
{
  public String appendUrlParameter(String paramString)
  {
    return ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).appendUrlParameter(paramString);
  }
  
  public void applySharedPreferences(SharedPreferences.Editor paramEditor, boolean paramBoolean)
  {
    ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).applySharedPreferences(paramEditor, paramBoolean);
  }
  
  public boolean checkIsVideoFeedsGameAdComBarLocalConfigToday(AppRuntime paramAppRuntime)
  {
    return ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).checkIsVideoFeedsGameAdComBarLocalConfigToday();
  }
  
  public void closeFloatWindow(Context paramContext)
  {
    ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).closeFloatWindow(paramContext);
  }
  
  public String getProteusOfflineBid(String paramString)
  {
    return ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getProteusOfflineBid(paramString);
  }
  
  public SharedPreferences getReadInJoySP(AppRuntime paramAppRuntime, boolean paramBoolean1, boolean paramBoolean2)
  {
    return ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getReadInJoySP(paramBoolean1, paramBoolean2);
  }
  
  public <T> T getReadInJoySpValue(String paramString, T paramT)
  {
    return ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getReadInJoySpValue(paramString, paramT);
  }
  
  public boolean isDailyChannel(int paramInt)
  {
    return ((IDailyModeConfigHandler)QRoute.api(IDailyModeConfigHandler.class)).isDaily(paramInt);
  }
  
  public boolean isRecommendChannel(int paramInt)
  {
    return paramInt == 0;
  }
  
  public Integer jumpToUrl(Context paramContext, String paramString)
  {
    return ((IRIJJumpUtils)QRoute.api(IRIJJumpUtils.class)).jumpToUrl(paramContext, paramString);
  }
  
  public Integer jumpToUrl(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    return ((IRIJJumpUtils)QRoute.api(IRIJJumpUtils.class)).jumpToUrl(paramContext, paramString1, paramString2, paramString3);
  }
  
  public Map<String, String> parseContentXml(String paramString)
  {
    return AladdinParseUtils.a(paramString);
  }
  
  public void showPopSheetDialog(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).showPopSheetDialog(paramContext, paramString1, paramString2, paramString3);
  }
  
  public void updateProteusOfflineBid(String paramString1, String paramString2)
  {
    ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateProteusOfflineBid(paramString1, paramString2);
  }
  
  public <T> void updateReadInJoySpValue(String paramString, T paramT)
  {
    ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateReadInJoySpValue(paramString, paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.impl.RIJCommonServiceImpl
 * JD-Core Version:    0.7.0.1
 */