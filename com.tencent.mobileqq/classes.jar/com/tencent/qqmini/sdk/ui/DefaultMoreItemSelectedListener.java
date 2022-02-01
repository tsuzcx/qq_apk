package com.tencent.qqmini.sdk.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.action.FavoritesAction;
import com.tencent.qqmini.sdk.action.GetShareState;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.action.RestartAction;
import com.tencent.qqmini.sdk.action.ShareAction;
import com.tencent.qqmini.sdk.action.UpdateUIAction;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.launcher.ui.MiniFragmentLauncher;
import com.tencent.qqmini.sdk.launcher.ui.MiniFragmentLauncher.FragmentType;
import com.tencent.qqmini.sdk.launcher.ui.OnMoreItemSelectedListener;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.widget.MiniToast;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@MiniKeep
public class DefaultMoreItemSelectedListener
  implements OnMoreItemSelectedListener
{
  private static final String TAG = "DefaultMoreItemSelectedListener";
  private static ChannelProxy sChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
  private static MiniAppProxy sMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
  
  private void reportClick(IMiniAppContext paramIMiniAppContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    SDKMiniProgramLpReportDC04239.reportUserClick(paramIMiniAppContext.getMiniAppInfo(), SDKMiniProgramLpReportDC04239.getAppType(paramIMiniAppContext.getMiniAppInfo()), PageAction.obtain(paramIMiniAppContext).getPageUrl(), "user_click", "more_button", paramString);
  }
  
  private void startAboutPage(Activity paramActivity, MiniAppInfo paramMiniAppInfo, ShareState paramShareState)
  {
    paramShareState = new Intent();
    paramShareState.putExtra("public_fragment_window_feature", 1);
    paramShareState.putExtra("mini_app_info", paramMiniAppInfo);
    paramShareState.putExtra("versionType", paramMiniAppInfo.version);
    MiniFragmentLauncher.start(paramActivity, paramShareState, MiniFragmentLauncher.FragmentType.FRAGMENT_MAIN_PAGE);
  }
  
  private void startComplaintPage(Activity paramActivity, String paramString)
  {
    if ((paramActivity != null) && (paramString != null)) {
      localObject = "";
    }
    try
    {
      String str = URLEncoder.encode("https://support.qq.com/data/1368/2018/0927/5e6c84b68d1f3ad390e7beeb6c2f83b0.jpeg", "UTF-8");
      localObject = str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        QMLog.e("DefaultMoreItemSelectedListener", "startComplainAndCallback, url = " + "");
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    Object localObject = "https://tucao.qq.com/qq_miniprogram/tucao?appid=" + paramString + "&openid=" + LoginManager.getInstance().getAccount() + "&avatar=" + (String)localObject + "&nickname=游客";
    paramString = new Intent();
    paramString.putExtra("url", (String)localObject);
    paramString.putExtra("title", "投诉与反馈");
    localObject = new Bundle();
    ((Bundle)localObject).putBoolean("hide_more_button", true);
    paramString.putExtras((Bundle)localObject);
    sMiniAppProxy.startBrowserActivity(paramActivity, paramString);
  }
  
  public void onMoreItemSelected(IMiniAppContext paramIMiniAppContext, int paramInt)
  {
    if (paramIMiniAppContext == null) {
      return;
    }
    Object localObject = "";
    if ((paramInt >= 100) && (paramInt <= 200))
    {
      localObject = new Bundle();
      ((Bundle)localObject).putInt("key_share_item_id", paramInt);
      paramIMiniAppContext.performAction(ShareAction.obtain(6, (Bundle)localObject));
      reportClick(paramIMiniAppContext, "share_" + paramInt);
      return;
    }
    Activity localActivity = paramIMiniAppContext.getAttachedActivity();
    MiniAppInfo localMiniAppInfo = paramIMiniAppContext.getMiniAppInfo();
    switch (paramInt)
    {
    }
    for (;;)
    {
      reportClick(paramIMiniAppContext, (String)localObject);
      return;
      paramIMiniAppContext.performAction(ShareAction.obtain(1));
      localObject = "share_QQ";
      continue;
      paramIMiniAppContext.performAction(ShareAction.obtain(2));
      localObject = "share_QZ";
      continue;
      paramIMiniAppContext.performAction(ShareAction.obtain(3));
      localObject = "share_WX";
      continue;
      paramIMiniAppContext.performAction(ShareAction.obtain(4));
      localObject = "share_Moments";
      continue;
      if ((localActivity != null) && (localMiniAppInfo != null)) {
        startAboutPage(localActivity, localMiniAppInfo, GetShareState.obtain(paramIMiniAppContext));
      }
      localObject = "about";
      continue;
      if ((localActivity != null) && (localMiniAppInfo != null)) {
        startComplaintPage(localActivity, localMiniAppInfo.appId);
      }
      localObject = "report";
      continue;
      UpdateUIAction.toggleDebugPanel(paramIMiniAppContext);
      MiniToast.makeText(localActivity, "调试面板需重启生效", 1).show();
      continue;
      UpdateUIAction.toggleMonitorPanel(paramIMiniAppContext);
      continue;
      RestartAction.restart(paramIMiniAppContext);
      continue;
      if (localMiniAppInfo.topType == 0) {}
      for (paramInt = 1;; paramInt = 0)
      {
        localMiniAppInfo.topType = paramInt;
        sChannelProxy.setUserAppTop(localMiniAppInfo, null);
        if (localMiniAppInfo.topType != 1) {
          break label373;
        }
        localObject = "settop_on";
        break;
      }
      label373:
      localObject = "settop_off";
      continue;
      sMiniAppProxy.addShortcut(localActivity, localMiniAppInfo, null);
      localObject = "add_desktop";
      continue;
      localObject = "cancel";
      continue;
      localObject = "cancel_system";
      continue;
      paramIMiniAppContext.performAction(FavoritesAction.obtain(1));
      localObject = "qq_favorites";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.DefaultMoreItemSelectedListener
 * JD-Core Version:    0.7.0.1
 */