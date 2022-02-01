package com.tencent.qqmini.sdk.ui;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.action.GetShareState;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.launcher.ui.MiniFragmentLauncher;
import com.tencent.qqmini.sdk.launcher.ui.MiniFragmentLauncher.FragmentType;
import com.tencent.qqmini.sdk.launcher.ui.MoreItemList.Builder;
import com.tencent.qqmini.sdk.launcher.ui.MoreItemList.DisplaySettings;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.ArrayList;

@MiniKeep
public class MorePanel
{
  private static final int REQUEST_SHOW_MORE = 9527;
  private static final String TAG = "MorePanel";
  private static boolean sVisible;
  
  private static String getPagePath(IMiniAppContext paramIMiniAppContext)
  {
    return PageAction.obtain(paramIMiniAppContext).getPageUrl();
  }
  
  private static void reportClick(IMiniAppContext paramIMiniAppContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    SDKMiniProgramLpReportDC04239.reportUserClick(paramIMiniAppContext.getMiniAppInfo(), SDKMiniProgramLpReportDC04239.getAppType(paramIMiniAppContext.getMiniAppInfo()), getPagePath(paramIMiniAppContext), "user_click", "more_button", paramString);
  }
  
  @MiniKeep
  public static void show(IMiniAppContext paramIMiniAppContext)
  {
    boolean bool2 = false;
    if (sVisible)
    {
      QMLog.w("MorePanel", "Ignore. Already showing");
      return;
    }
    if (paramIMiniAppContext == null)
    {
      QMLog.w("MorePanel", "Failed to show. miniAppContext is null");
      return;
    }
    Activity localActivity = paramIMiniAppContext.getAttachedActivity();
    if ((localActivity == null) || (localActivity.isFinishing()))
    {
      QMLog.w("MorePanel", "Failed to show. activity is null");
      return;
    }
    MiniAppInfo localMiniAppInfo = paramIMiniAppContext.getMiniAppInfo();
    if (localMiniAppInfo == null)
    {
      QMLog.w("MorePanel", "Failed to show. MiniAppInfo is null");
      return;
    }
    ShareState localShareState = GetShareState.obtain(paramIMiniAppContext);
    if (localShareState == null)
    {
      QMLog.w("MorePanel", "Failed to show. shareState is null");
      return;
    }
    Intent localIntent = new Intent();
    Object localObject1 = new MoreItemList.DisplaySettings();
    ((MoreItemList.DisplaySettings)localObject1).isShowShareQQ = localShareState.withShareQQ;
    ((MoreItemList.DisplaySettings)localObject1).isShowShareQzone = localShareState.withShareQzone;
    ((MoreItemList.DisplaySettings)localObject1).isShowShareWxFriends = localShareState.withShareWeChatFriend;
    ((MoreItemList.DisplaySettings)localObject1).isShowShareWxMoments = localShareState.withShareWeChatMoment;
    ((MoreItemList.DisplaySettings)localObject1).isShowShareOthers = localShareState.withShareOthers;
    ((MoreItemList.DisplaySettings)localObject1).isShowDebug = localShareState.showDebug;
    ((MoreItemList.DisplaySettings)localObject1).isShowMonitor = localShareState.showMonitor;
    ((MoreItemList.DisplaySettings)localObject1).isShowAbout = true;
    ((MoreItemList.DisplaySettings)localObject1).isShowComplaint = true;
    boolean bool1;
    if (paramIMiniAppContext.isMiniGame()) {
      if ((GameWnsUtils.showRestartButton()) && (localShareState.showRestart)) {
        bool1 = true;
      }
    }
    for (;;)
    {
      ((MoreItemList.DisplaySettings)localObject1).isShowRestart = bool1;
      ((MoreItemList.DisplaySettings)localObject1).isShowFavorite = showAddFavorite(localMiniAppInfo);
      bool1 = bool2;
      if (localMiniAppInfo.topType == 1) {
        bool1 = true;
      }
      ((MoreItemList.DisplaySettings)localObject1).isMyFavorite = bool1;
      ((MoreItemList.DisplaySettings)localObject1).isShowShortcut = showAddShortcut(localMiniAppInfo);
      Object localObject2 = new MoreItemList.Builder().setDisplaySettings((MoreItemList.DisplaySettings)localObject1);
      localObject1 = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
      localObject2 = ((MiniAppProxy)localObject1).getMoreItems((MoreItemList.Builder)localObject2);
      localIntent.putExtra("key_orientation_landscape", paramIMiniAppContext.isOrientationLandscape());
      localIntent.putExtra("key_mini_app_info", localMiniAppInfo);
      localIntent.putParcelableArrayListExtra("key_more_item_list", (ArrayList)localObject2);
      ActivityResultManager.g().addActivityResultListener(new MorePanel.1(localShareState, (MiniAppProxy)localObject1, paramIMiniAppContext));
      MiniFragmentLauncher.startTranslucentForResult(localActivity, localIntent, 9527, MiniFragmentLauncher.FragmentType.FRAGMENT_MORE);
      reportClick(paramIMiniAppContext, "open");
      sVisible = true;
      return;
      bool1 = false;
      continue;
      bool1 = localShareState.showRestart;
    }
  }
  
  private static boolean showAddFavorite(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {}
    while ((paramMiniAppInfo.isSpecialMiniApp()) || (paramMiniAppInfo.isLimitedAccessApp())) {
      return false;
    }
    return true;
  }
  
  private static boolean showAddShortcut(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {}
    while ((paramMiniAppInfo.isLimitedAccessApp()) || ((!QUAUtil.isQQApp()) && (QUAUtil.isDemoApp()))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MorePanel
 * JD-Core Version:    0.7.0.1
 */