package com.tencent.qqmini.sdk.core.proxy.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import bemw;
import beru;
import besi;
import besl;
import beuc;
import beyu;
import bffl;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.ui.MainPageFragment;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class DefaultMoreItemSelectedListener
  implements bffl
{
  private static final String TAG = "DefaultMoreItemSelectedListener";
  
  private void reportClick(besi parambesi, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!parambesi.a().isEngineTypeMiniGame()) {
      return;
    }
    beyu.a(parambesi.a(), beyu.a(parambesi.a()), null, "user_click", "more_button", paramString);
  }
  
  private void startAboutPage(Activity paramActivity, MiniAppInfo paramMiniAppInfo, beru paramberu)
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
        besl.d("DefaultMoreItemSelectedListener", "startComplainAndCallback, url = " + "");
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    Object localObject = "https://tucao.qq.com/qq_miniprogram/tucao?appid=" + paramString + "&openid=" + beuc.a().a() + "&avatar=" + (String)localObject + "&nickname=游客";
    paramString = new Intent();
    paramString.putExtra("url", (String)localObject);
    paramString.putExtra("title", "投诉与反馈");
    localObject = new Bundle();
    ((Bundle)localObject).putBoolean("hide_more_button", true);
    paramString.putExtras((Bundle)localObject);
    ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).startBrowserActivity(paramActivity, paramString);
  }
  
  public void onMoreItemSelected(besi parambesi, int paramInt)
  {
    if (parambesi == null) {
      return;
    }
    String str = "";
    if ((paramInt >= 100) && (paramInt <= 200))
    {
      parambesi.a(paramInt, null);
      reportClick(parambesi, "share_" + paramInt);
      return;
    }
    Activity localActivity = parambesi.a();
    MiniAppInfo localMiniAppInfo = parambesi.a();
    switch (paramInt)
    {
    }
    for (;;)
    {
      reportClick(parambesi, str);
      return;
      parambesi.a(1, null);
      str = "share_QQ";
      continue;
      parambesi.a(2, null);
      str = "share_QZ";
      continue;
      parambesi.a(3, null);
      str = "share_WX";
      continue;
      parambesi.a(4, null);
      str = "share_Moments";
      continue;
      if ((localActivity != null) && (localMiniAppInfo != null)) {
        startAboutPage(localActivity, localMiniAppInfo, parambesi.a());
      }
      str = "about";
      continue;
      if ((localActivity != null) && (localMiniAppInfo != null)) {
        startComplaintPage(localActivity, localMiniAppInfo.appId);
      }
      str = "report";
      continue;
      parambesi.a();
      bemw.a(localActivity, "调试面板需重启生效", 1).a();
      continue;
      parambesi.b();
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