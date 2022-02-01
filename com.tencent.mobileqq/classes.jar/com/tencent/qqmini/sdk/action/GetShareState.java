package com.tencent.qqmini.sdk.action;

import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.model.AppMode;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.utils.QUAUtil;

@MiniKeep
public class GetShareState
  implements Action<ShareState>
{
  public static ShareState obtain(IMiniAppContext paramIMiniAppContext)
  {
    if (paramIMiniAppContext == null) {
      return null;
    }
    ShareState localShareState = (ShareState)paramIMiniAppContext.performAction(new GetShareState());
    MiniAppInfo localMiniAppInfo = paramIMiniAppContext.getMiniAppInfo();
    if (((localMiniAppInfo != null) && (localMiniAppInfo.verType != 3)) || (QUAUtil.isDemoApp()))
    {
      localShareState.showDebug = true;
      localShareState.showMonitor = true;
    }
    if (shouldHideWechatChannels())
    {
      localShareState.withShareWeChatFriend = false;
      localShareState.withShareWeChatMoment = false;
    }
    if (shouldHideQzoneChannel()) {
      localShareState.withShareQzone = false;
    }
    updateShareStateByAppMode(localShareState, localMiniAppInfo);
    if ((QUAUtil.isQQApp()) || (QUAUtil.isMicroApp())) {
      localShareState.isShareInMiniProcess = true;
    }
    localShareState.isOrientationLandscape = paramIMiniAppContext.isOrientationLandscape();
    return localShareState;
  }
  
  private static boolean shouldHideQzoneChannel()
  {
    return (QUAUtil.isQQSpeedApp()) || (QUAUtil.isTimApp());
  }
  
  private static boolean shouldHideWechatChannels()
  {
    if (WnsConfig.getConfig("qqminiapp", "mini_app_share_to_wx_switcher", 1) != 1) {
      return true;
    }
    return QUAUtil.isQQSpeedApp();
  }
  
  private static void updateShareStateByAppMode(ShareState paramShareState, MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.isSpecialMiniApp())) {
      paramShareState.withShareOthers = false;
    }
    if (paramMiniAppInfo.appMode.disableShareToAIO) {
      paramShareState.withShareQQ = false;
    }
    if (paramMiniAppInfo.appMode.disableShareToQZone) {
      paramShareState.withShareQzone = false;
    }
    if (paramMiniAppInfo.appMode.disableShareToWeChat)
    {
      paramShareState.withShareWeChatFriend = false;
      paramShareState.withShareWeChatMoment = false;
    }
  }
  
  public ShareState perform(BaseRuntime paramBaseRuntime)
  {
    return paramBaseRuntime.getShareState();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.action.GetShareState
 * JD-Core Version:    0.7.0.1
 */