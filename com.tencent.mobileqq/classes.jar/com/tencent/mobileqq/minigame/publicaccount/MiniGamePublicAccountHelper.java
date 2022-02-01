package com.tencent.mobileqq.minigame.publicaccount;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.minigame.publicaccount.config.MiniGamePAConfBean;
import com.tencent.mobileqq.minigame.publicaccount.config.MiniGamePAConfProcessor;
import com.tencent.mobileqq.minigame.publicaccount.config.OpenHippyParam;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyFragment;
import com.tencent.mobileqq.qroute.QRoute;
import common.config.service.QzoneConfig;

public class MiniGamePublicAccountHelper
{
  private static boolean isOpenHippy()
  {
    return MiniGamePAConfProcessor.loadConfig().getEnable() == 1;
  }
  
  private static boolean isOpenWebFragment()
  {
    QzoneConfig localQzoneConfig = QzoneConfig.getInstance();
    boolean bool = false;
    if (localQzoneConfig.getConfig("qqtriton", "MiniGamePublicAccountEnableWeb", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static void launchMiniGamePublicAccount(Context paramContext, String paramString)
  {
    if (isOpenHippy())
    {
      openHippyMiniGamePA(paramContext, paramString);
      return;
    }
    paramString = new Intent();
    paramString.putExtra("startTime", SystemClock.elapsedRealtime());
    PublicFragmentActivityForTool.b((Activity)paramContext, paramString, MiniGamePublicAccountWebFragment.class, 10000);
  }
  
  private static void openHippyMiniGamePA(Context paramContext, String paramString)
  {
    MiniGamePAConfBean localMiniGamePAConfBean = MiniGamePAConfProcessor.loadConfig();
    OpenHippyInfo localOpenHippyInfo = new OpenHippyInfo();
    localOpenHippyInfo.bundleName = "qqMiniGame";
    Object localObject2 = localMiniGamePAConfBean.getEnableDomain();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "qzone.qq.com";
    }
    localOpenHippyInfo.domain = ((String)localObject1);
    localObject2 = localMiniGamePAConfBean.getOpenParams();
    if (localObject2 != null)
    {
      localOpenHippyInfo.url = ((OpenHippyParam)localObject2).getUrl();
      localOpenHippyInfo.errorUrl = ((OpenHippyParam)localObject2).getErrorUrl();
      if (((OpenHippyParam)localObject2).isInToolProcess()) {
        localObject1 = "tool";
      } else {
        localObject1 = "main";
      }
      localOpenHippyInfo.processName = ((String)localObject1);
      localOpenHippyInfo.isPreload = ((OpenHippyParam)localObject2).isPreload();
      localOpenHippyInfo.isPreloadWhenClosed = ((OpenHippyParam)localObject2).isPreloadWhenClosed();
      localOpenHippyInfo.isPredraw = ((OpenHippyParam)localObject2).isPredraw();
      localOpenHippyInfo.isPredrawWhenClosed = ((OpenHippyParam)localObject2).isPredrawWhenClosed();
      localOpenHippyInfo.isAnimated = ((OpenHippyParam)localObject2).isAnimated();
    }
    localOpenHippyInfo.fragmentClass = MiniGamePAHippyFragment.class;
    localOpenHippyInfo.from = paramString;
    ((IHippyAccessHelper)QRoute.api(IHippyAccessHelper.class)).openHippyPage(paramContext, localOpenHippyInfo);
  }
  
  public static boolean shouldOpenWebFragment(String paramString)
  {
    boolean bool2 = TextUtils.equals(AppConstants.MINI_GAME_PUBLIC_ACCOUNT_UIN, paramString);
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    if ((isOpenHippy()) || (isOpenWebFragment())) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean shouldUseWebStrategy2()
  {
    QzoneConfig localQzoneConfig = QzoneConfig.getInstance();
    boolean bool = false;
    if (localQzoneConfig.getConfig("qqtriton", "MiniGamePublicAccountArkMsgGray", 0) == 1) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountHelper
 * JD-Core Version:    0.7.0.1
 */