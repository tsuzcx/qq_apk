package com.tencent.mobileqq.profilecard.bussiness.achievement;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class LifeAchivementHelper
{
  static final long CLICK_INTERVAL_MS = 500L;
  static final String MINI_APP_LIFE_ACHIVEMENT_ADD_PAGE = "mqqapi://miniapp/open?_atype=0&_mappid=1110348796&_mvid=&_path=pages%2Findex%2Findex&_vt=3&referer=2062&via=2062_3&_sig=1925072163";
  static final String MINI_APP_LIFE_ACHIVEMENT_DISPALY_PAGE = "mqqapi://miniapp/open?_atype=0&_mappid=1110348796&_mvid=&_path=pages%2Fachievement%2Fachievement&_vt=3&referer=2062&via=2062_3&_sig=831969013";
  static final String TAG = "LifeAchivementHelper";
  
  public static String formatPraiseNum(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt < 10000)) {
      return String.valueOf(paramInt);
    }
    StringBuilder localStringBuilder;
    float f;
    if ((paramInt >= 10000) && (paramInt < 100000000))
    {
      if (paramInt % 10000 < 500)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt / 10000);
        localStringBuilder.append("万");
        return localStringBuilder.toString();
      }
      f = paramInt * 1.0F / 10000.0F;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(Math.round(f * 10.0F) * 1.0F / 10.0F);
      localStringBuilder.append("万");
      return localStringBuilder.toString();
    }
    if (paramInt >= 100000000)
    {
      if (paramInt % 100000000 < 5000000)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt / 100000000);
        localStringBuilder.append("亿");
        return localStringBuilder.toString();
      }
      f = paramInt * 1.0F / 1.0E+008F;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(Math.round(f * 10.0F) * 1.0F / 10.0F);
      localStringBuilder.append("亿");
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public static void jumpToLifeAchivementMiniAppAchiivementDetailPage(Context paramContext, String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqqapi://miniapp/open?_atype=0&_mappid=1110348796&_mvid=&_path=pages%2Fachievement%2Fachievement&_vt=3&referer=2062&via=2062_3&_sig=831969013&openid=");
    localStringBuilder.append(paramString);
    localStringBuilder.append("&achievement_id=");
    localStringBuilder.append(paramInt);
    paramString = localStringBuilder.toString();
    if (QLog.isColorLevel()) {
      QLog.d("LifeAchivementHelper", 2, String.format("jumpToLifeAchivementMiniAppAchiivementDetailPage miniAppUrl=%s", new Object[] { paramString }));
    }
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramContext, paramString, 2062, null);
  }
  
  public static void jumpToLifeAchivementMiniAppAchivementListPage(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqqapi://miniapp/open?_atype=0&_mappid=1110348796&_mvid=&_path=pages%2Fachievement%2Fachievement&_vt=3&referer=2062&via=2062_3&_sig=831969013&openid=");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    if (QLog.isColorLevel()) {
      QLog.d("LifeAchivementHelper", 2, String.format("jumpToLifeAchivementMiniAppAchivementListPage miniAppUrl=%s", new Object[] { paramString }));
    }
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramContext, paramString, 2062, null);
  }
  
  public static void jumpToLifeAchivementMiniAppAddPage(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LifeAchivementHelper", 2, String.format("jumpToLifeAchivementMiniAppAddPage miniAppUrl=%s", new Object[] { "mqqapi://miniapp/open?_atype=0&_mappid=1110348796&_mvid=&_path=pages%2Findex%2Findex&_vt=3&referer=2062&via=2062_3&_sig=1925072163" }));
    }
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramContext, "mqqapi://miniapp/open?_atype=0&_mappid=1110348796&_mvid=&_path=pages%2Findex%2Findex&_vt=3&referer=2062&via=2062_3&_sig=1925072163", 2062, null);
  }
  
  public static void setViewClickInterval(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView.setClickable(false);
    paramView.postDelayed(new LifeAchivementHelper.1(paramView), 500L);
  }
  
  public static boolean shouldShowAchivementPanelOrNot(Card paramCard, IProfileConfig paramIProfileConfig, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool1;
    if ((paramIProfileConfig != null) && (!paramIProfileConfig.isSwitchEnable(10))) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    boolean bool2;
    if ((paramCard != null) && (paramCard.switchLifeAchievement != 1)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if (paramBoolean1) {
      if ((!bool1) || (!bool2)) {}
    }
    boolean bool3;
    for (;;)
    {
      bool3 = true;
      break;
      do
      {
        bool3 = false;
        break;
      } while ((!bool1) || (!bool2) || (!paramBoolean2));
    }
    if (QLog.isColorLevel()) {
      QLog.d("LifeAchivementHelper", 2, String.format("shouldShowAchivementPanelOrNot configEnable:%s,switchEnable:%s,hasLifeAchivement:%s,isSelf:%s,result:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool3) }));
    }
    return bool3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.achievement.LifeAchivementHelper
 * JD-Core Version:    0.7.0.1
 */