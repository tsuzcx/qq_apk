package com.tencent.mobileqq.gamecenter.util;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.gamecenter.wadl.api.IQQGameConfigService;
import com.tencent.gamecenter.wadl.api.IQQGameReportService;
import com.tencent.gamecenter.wadl.biz.entity.ApkInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlCommConfig;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import cooperation.wadl.ipc.WadlProxyServiceUtil;
import cooperation.wadl.ipc.WadlProxyServiceWrap;
import java.net.URL;

public class GameCenterInterruptPlugin
  extends WebViewPlugin
{
  public GameCenterInterruptPlugin()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterInterruptPlugin", 2, "GameCenterInterruptPlugin init");
    }
    this.mPluginNameSpace = "gameCenter";
  }
  
  public long getWebViewSchemaByNameSpace(String paramString)
  {
    return 3L;
  }
  
  public boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    if (paramString1 != null) {}
    for (;;)
    {
      try
      {
        if (!paramString1.contains("apk")) {
          break label574;
        }
        localObject4 = (WadlCommConfig)((IQQGameConfigService)QRoute.api(IQQGameConfigService.class)).getConfig("comminfo");
        if (localObject4 == null) {
          break label576;
        }
        paramString2 = ((WadlCommConfig)localObject4).a(paramString1);
        if (QLog.isColorLevel()) {
          QLog.d("GameCenterInterruptPlugin", 1, "handleSchemaRequest url=" + paramString1 + " apkInfo=" + paramString2);
        }
        if ((paramString2 == null) || (PackageUtil.a(BaseApplication.getContext(), paramString2.c)))
        {
          localObject3 = WadlReportInfo.a();
          paramString2 = null;
        }
      }
      catch (Exception paramString1)
      {
        Object localObject4;
        Object localObject3;
        Object localObject1;
        Pair localPair;
        QLog.e("GameCenterInterruptPlugin", 1, "handleSchemaRequest error =" + paramString1.toString());
      }
      try
      {
        localObject1 = new URL(paramString1).getHost();
        paramString2 = (String)localObject1;
      }
      catch (Throwable localThrowable)
      {
        continue;
        continue;
        paramString1 = null;
        Object localObject2 = null;
        continue;
      }
      ((WadlReportInfo)localObject3).g = paramString1;
      ((WadlReportInfo)localObject3).h = paramString2;
      ((IQQGameReportService)QRoute.api(IQQGameReportService.class)).reportDC("205925", "20", (WadlReportInfo)localObject3, "08a00036462");
      return false;
      QLog.i("GameCenterInterruptPlugin", 1, "interrupt url downLoad apk channelId=" + paramString2.d + " pkgName=" + paramString2.c + ", appid=" + paramString2.a + ",gameName=" + paramString2.b + ",url=" + paramString1);
      if (this.mRuntime != null)
      {
        paramString1 = this.mRuntime.a();
        localObject1 = this.mRuntime.a();
        if (localObject1 != null)
        {
          localObject3 = null;
          if (paramString1 != null) {
            localObject3 = paramString1.getIntent();
          }
          localPair = GameCenterUtils.a((Intent)localObject3);
          QLog.i("GameCenterInterruptPlugin", 1, "originalUrl=" + ((CustomWebView)localObject1).getOriginalUrl() + ",sessionInfo=" + localPair + ",url=" + ((CustomWebView)localObject1).getUrl());
          localObject3 = ((CustomWebView)localObject1).getUrl();
          if (TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject3 = ((CustomWebView)localObject1).getOriginalUrl();
            paramString1 = new WadlParams(paramString2.a, paramString2.c);
            paramString1.b = 2;
            paramString1.a = false;
            paramString1.c = paramString2.d;
            paramString1.j = paramString2.b;
            paramString1.e = paramString2.e;
            paramString1.l = "GameCenterIntterup";
            paramString1.d = 6;
            paramString1.m = ((String)localObject3);
            WadlProxyServiceUtil.a().b(paramString1);
            if (localObject4 != null)
            {
              paramString1 = ((WadlCommConfig)localObject4).c;
              localObject4 = paramString1;
              if (TextUtils.isEmpty(paramString1)) {
                localObject4 = "https://speed.gamecenter.qq.com/pushgame/v1/downloadadmin";
              }
              ((CustomWebView)localObject1).loadUrl((String)localObject4);
              GameCenterUtils.a(null, "558", "205758", paramString2.a, "55801", "4", "430", new String[] { String.valueOf(localPair.first), (String)localPair.second, paramString2.d, paramString2.e, localObject3 });
              return true;
            }
            paramString1 = "https://speed.gamecenter.qq.com/pushgame/v1/downloadadmin";
            continue;
          }
        }
        else
        {
          return false;
        }
      }
      label574:
      return false;
      label576:
      paramString2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.util.GameCenterInterruptPlugin
 * JD-Core Version:    0.7.0.1
 */