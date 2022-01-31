package com.tencent.qqmini.sdk.core.proxy.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import benn;
import besl;
import besz;
import betc;
import beut;
import bezl;
import bfgc;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.ui.MainPageFragment;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class DefaultMoreItemSelectedListener
  implements bfgc
{
  private static final String TAG = "DefaultMoreItemSelectedListener";
  
  private void reportClick(besz parambesz, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!parambesz.a().isEngineTypeMiniGame()) {
      return;
    }
    bezl.a(parambesz.a(), bezl.a(parambesz.a()), null, "user_click", "more_button", paramString);
  }
  
  private void startAboutPage(Activity paramActivity, MiniAppInfo paramMiniAppInfo, besl parambesl)
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
        betc.d("DefaultMoreItemSelectedListener", "startComplainAndCallback, url = " + "");
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    Object localObject = "https://tucao.qq.com/qq_miniprogram/tucao?appid=" + paramString + "&openid=" + beut.a().a() + "&avatar=" + (String)localObject + "&nickname=游客";
    paramString = new Intent();
    paramString.putExtra("url", (String)localObject);
    paramString.putExtra("title", "投诉与反馈");
    localObject = new Bundle();
    ((Bundle)localObject).putBoolean("hide_more_button", true);
    paramString.putExtras((Bundle)localObject);
    ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).startBrowserActivity(paramActivity, paramString);
  }
  
  public void onMoreItemSelected(besz parambesz, int paramInt)
  {
    if (parambesz == null) {
      return;
    }
    String str = "";
    if ((paramInt >= 100) && (paramInt <= 200))
    {
      parambesz.a(paramInt, null);
      reportClick(parambesz, "share_" + paramInt);
      return;
    }
    Activity localActivity = parambesz.a();
    MiniAppInfo localMiniAppInfo = parambesz.a();
    switch (paramInt)
    {
    }
    for (;;)
    {
      reportClick(parambesz, str);
      return;
      parambesz.a(1, null);
      str = "share_QQ";
      continue;
      parambesz.a(2, null);
      str = "share_QZ";
      continue;
      parambesz.a(3, null);
      str = "share_WX";
      continue;
      parambesz.a(4, null);
      str = "share_Moments";
      continue;
      if ((localActivity != null) && (localMiniAppInfo != null)) {
        startAboutPage(localActivity, localMiniAppInfo, parambesz.a());
      }
      str = "about";
      continue;
      if ((localActivity != null) && (localMiniAppInfo != null)) {
        startComplaintPage(localActivity, localMiniAppInfo.appId);
      }
      str = "report";
      continue;
      parambesz.a();
      benn.a(localActivity, "调试面板需重启生效", 1).a();
      continue;
      parambesz.b();
      continue;
      str = "cancel";
      continue;
      str = "cancel_system";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.DefaultMoreItemSelectedListener
 * JD-Core Version:    0.7.0.1
 */