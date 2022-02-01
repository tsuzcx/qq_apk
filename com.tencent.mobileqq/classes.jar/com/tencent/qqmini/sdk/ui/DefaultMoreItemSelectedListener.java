package com.tencent.qqmini.sdk.ui;

import android.app.Activity;
import android.content.Context;
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
  
  private String onAboutSelect(IMiniAppContext paramIMiniAppContext, Activity paramActivity, MiniAppInfo paramMiniAppInfo)
  {
    if ((paramActivity != null) && (paramMiniAppInfo != null)) {
      startAboutPage(paramActivity, paramMiniAppInfo, GetShareState.obtain(paramIMiniAppContext));
    }
    return "about";
  }
  
  private String onComplaintSelect(Activity paramActivity, MiniAppInfo paramMiniAppInfo)
  {
    if ((paramActivity != null) && (paramMiniAppInfo != null)) {
      startComplaintPage(paramActivity, paramMiniAppInfo.appId);
    }
    return "report";
  }
  
  private String onFavoriteSelect(MiniAppInfo paramMiniAppInfo)
  {
    int i;
    if (paramMiniAppInfo.topType == 0) {
      i = 1;
    } else {
      i = 0;
    }
    paramMiniAppInfo.topType = i;
    sChannelProxy.setUserAppTop(paramMiniAppInfo, null);
    if (paramMiniAppInfo.topType == 1) {
      return "settop_on";
    }
    return "settop_off";
  }
  
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
    if ((paramActivity != null) && (paramString != null))
    {
      Object localObject = "";
      try
      {
        String str = URLEncoder.encode("https://support.qq.com/data/1368/2018/0927/5e6c84b68d1f3ad390e7beeb6c2f83b0.jpeg", "UTF-8");
        localObject = str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("startComplainAndCallback, url = ");
        localStringBuilder2.append("");
        QMLog.e("DefaultMoreItemSelectedListener", localStringBuilder2.toString());
        localUnsupportedEncodingException.printStackTrace();
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("https://tucao.qq.com/qq_miniprogram/tucao?appid=");
      localStringBuilder1.append(paramString);
      localStringBuilder1.append("&openid=");
      localStringBuilder1.append(LoginManager.getInstance().getAccount());
      localStringBuilder1.append("&avatar=");
      localStringBuilder1.append((String)localObject);
      localStringBuilder1.append("&nickname=游客");
      localObject = localStringBuilder1.toString();
      paramString = new Intent();
      paramString.putExtra("url", (String)localObject);
      paramString.putExtra("title", "投诉与反馈");
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("hide_more_button", true);
      paramString.putExtras((Bundle)localObject);
      sMiniAppProxy.startBrowserActivity(paramActivity, paramString);
    }
  }
  
  public void onMoreItemSelected(IMiniAppContext paramIMiniAppContext, int paramInt)
  {
    if (paramIMiniAppContext == null) {
      return;
    }
    if ((paramInt >= 100) && (paramInt <= 200))
    {
      localObject = new Bundle();
      ((Bundle)localObject).putInt("key_share_item_id", paramInt);
      paramIMiniAppContext.performAction(ShareAction.obtain(7, (Bundle)localObject));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("share_");
      ((StringBuilder)localObject).append(paramInt);
      reportClick(paramIMiniAppContext, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = paramIMiniAppContext.getAttachedActivity();
    MiniAppInfo localMiniAppInfo = paramIMiniAppContext.getMiniAppInfo();
    switch (paramInt)
    {
    default: 
      break;
    case 12: 
      paramIMiniAppContext.performAction(FavoritesAction.obtain(1));
      localObject = "qq_favorites";
      break;
    case 11: 
      sMiniAppProxy.addShortcut((Context)localObject, localMiniAppInfo, null);
      localObject = "add_desktop";
      break;
    case 10: 
      localObject = onFavoriteSelect(localMiniAppInfo);
      break;
    case 9: 
      RestartAction.restart(paramIMiniAppContext);
      break;
    case 8: 
      UpdateUIAction.toggleMonitorPanel(paramIMiniAppContext);
      break;
    case 7: 
      UpdateUIAction.toggleDebugPanel(paramIMiniAppContext);
      MiniToast.makeText((Context)localObject, "调试面板需重启生效", 1).show();
      break;
    case 6: 
      localObject = onComplaintSelect((Activity)localObject, localMiniAppInfo);
      break;
    case 5: 
      localObject = onAboutSelect(paramIMiniAppContext, (Activity)localObject, localMiniAppInfo);
      break;
    case 4: 
      paramIMiniAppContext.performAction(ShareAction.obtain(4));
      localObject = "share_Moments";
      break;
    case 3: 
      paramIMiniAppContext.performAction(ShareAction.obtain(3));
      localObject = "share_WX";
      break;
    case 2: 
      paramIMiniAppContext.performAction(ShareAction.obtain(2));
      localObject = "share_QZ";
      break;
    case 1: 
      paramIMiniAppContext.performAction(ShareAction.obtain(1));
      localObject = "share_QQ";
      break;
    case 0: 
      localObject = "cancel_system";
      break;
    case -1: 
      localObject = "cancel";
      break;
    }
    localObject = "";
    reportClick(paramIMiniAppContext, (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.DefaultMoreItemSelectedListener
 * JD-Core Version:    0.7.0.1
 */