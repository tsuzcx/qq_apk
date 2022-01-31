package com.tencent.qqmini.sdk.core.proxy.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import bgrm;
import bgxl;
import bhcn;
import bhmq;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.launcher.shell.IMiniRuntime;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.ui.MainPageFragment;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class DefaultMoreItemSelectedListener
  implements bhmq
{
  private static final String TAG = "DefaultMoreItemSelectedListener";
  
  private void reportClick(IMiniRuntime paramIMiniRuntime, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!paramIMiniRuntime.getMiniAppInfo().isEngineTypeMiniGame()) {
      return;
    }
    bhcn.a(paramIMiniRuntime.getMiniAppInfo(), bhcn.a(paramIMiniRuntime.getMiniAppInfo()), null, "user_click", "more_button", paramString);
  }
  
  private void startAboutPage(Activity paramActivity, MiniAppInfo paramMiniAppInfo, ShareState paramShareState)
  {
    MainPageFragment.a(paramActivity, paramMiniAppInfo, paramMiniAppInfo.verType);
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
    Object localObject = "https://tucao.qq.com/qq_miniprogram/tucao?appid=" + paramString + "&openid=" + bgxl.a().a() + "&avatar=" + (String)localObject + "&nickname=游客";
    paramString = new Intent();
    paramString.putExtra("url", (String)localObject);
    paramString.putExtra("title", "投诉与反馈");
    localObject = new Bundle();
    ((Bundle)localObject).putBoolean("hide_more_button", true);
    paramString.putExtras((Bundle)localObject);
    ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).startBrowserActivity(paramActivity, paramString);
  }
  
  public void onMoreItemSelected(IMiniRuntime paramIMiniRuntime, int paramInt)
  {
    if (paramIMiniRuntime == null) {
      return;
    }
    String str = "";
    if ((paramInt >= 100) && (paramInt <= 200))
    {
      paramIMiniRuntime.share(paramInt, null);
      reportClick(paramIMiniRuntime, "share_" + paramInt);
      return;
    }
    Activity localActivity = paramIMiniRuntime.getAttachedActivity();
    MiniAppInfo localMiniAppInfo = paramIMiniRuntime.getMiniAppInfo();
    switch (paramInt)
    {
    }
    for (;;)
    {
      reportClick(paramIMiniRuntime, str);
      return;
      paramIMiniRuntime.share(1, null);
      str = "share_QQ";
      continue;
      paramIMiniRuntime.share(2, null);
      str = "share_QZ";
      continue;
      paramIMiniRuntime.share(3, null);
      str = "share_WX";
      continue;
      paramIMiniRuntime.share(4, null);
      str = "share_Moments";
      continue;
      if ((localActivity != null) && (localMiniAppInfo != null)) {
        startAboutPage(localActivity, localMiniAppInfo, paramIMiniRuntime.getShareState());
      }
      str = "about";
      continue;
      if ((localActivity != null) && (localMiniAppInfo != null)) {
        startComplaintPage(localActivity, localMiniAppInfo.appId);
      }
      str = "report";
      continue;
      paramIMiniRuntime.toggleDebugPanel();
      bgrm.a(localActivity, "调试面板需重启生效", 1).a();
      continue;
      paramIMiniRuntime.toggleMonitorPanel();
      continue;
      paramIMiniRuntime.restart();
      continue;
      str = "cancel";
      continue;
      str = "cancel_system";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.DefaultMoreItemSelectedListener
 * JD-Core Version:    0.7.0.1
 */