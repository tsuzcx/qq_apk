package com.tencent.mobileqq.webview.swift.component;

import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.comic.api.IQQComicRedTouchService;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.mobileqq.webview.swift.injector.ISwiftBrowserTBSInjector;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class SwiftBrowserTBSInjectorImpl
  implements ISwiftBrowserTBSInjector
{
  Map<String, RedAppInfo> a;
  
  private String b(SwiftBrowserComponentsProvider.SwiftBrowserComponentContext paramSwiftBrowserComponentContext)
  {
    if ((paramSwiftBrowserComponentContext.b() instanceof QQBrowserActivity)) {
      paramSwiftBrowserComponentContext = (QQBrowserActivity)paramSwiftBrowserComponentContext.b();
    } else {
      paramSwiftBrowserComponentContext = null;
    }
    if ((paramSwiftBrowserComponentContext != null) && (paramSwiftBrowserComponentContext.tabBarConfigData != null) && (paramSwiftBrowserComponentContext.tabBarConfigData.size() > 1))
    {
      if (this.a == null)
      {
        localObject1 = (IQQComicRedTouchService)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web")).getRuntimeService(IQQComicRedTouchService.class, "all");
        Object localObject2 = new ArrayList();
        ((ArrayList)localObject2).add("1113.100803");
        localObject1 = ((IQQComicRedTouchService)localObject1).getRedAppInfo((ArrayList)localObject2);
        if (localObject1 != null)
        {
          this.a = new HashMap();
          localObject2 = ((Map)localObject1).keySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            String str = (String)((Iterator)localObject2).next();
            Object localObject3 = ((Map)localObject1).get(str);
            if ((localObject3 instanceof RedAppInfo)) {
              this.a.put(str, (RedAppInfo)localObject3);
            }
          }
        }
      }
      Object localObject1 = this.a;
      int j = 0;
      int i = j;
      if (localObject1 != null)
      {
        localObject1 = (RedAppInfo)((Map)localObject1).get("1113.100803");
        i = j;
        if (localObject1 != null)
        {
          i = j;
          if (((RedAppInfo)localObject1).b() != 0) {
            i = 1;
          }
        }
      }
      localObject1 = "";
      if ((i != 0) && (paramSwiftBrowserComponentContext.tabBarConfigData.size() > 4) && (paramSwiftBrowserComponentContext.currentTabIndex == 0))
      {
        paramSwiftBrowserComponentContext = (WebViewTabBarData)paramSwiftBrowserComponentContext.tabBarConfigData.get(4);
        if (paramSwiftBrowserComponentContext != null) {
          localObject1 = paramSwiftBrowserComponentContext.url;
        }
        return localObject1;
      }
      i = paramSwiftBrowserComponentContext.currentTabIndex + 1;
      if (i >= paramSwiftBrowserComponentContext.tabBarConfigData.size()) {
        i = -1;
      }
      if (i > 0)
      {
        paramSwiftBrowserComponentContext = (WebViewTabBarData)paramSwiftBrowserComponentContext.tabBarConfigData.get(i);
        if (paramSwiftBrowserComponentContext != null) {
          localObject1 = paramSwiftBrowserComponentContext.url;
        }
        return localObject1;
      }
    }
    return null;
  }
  
  public void a(SwiftBrowserComponentsProvider.SwiftBrowserComponentContext paramSwiftBrowserComponentContext)
  {
    if (SwiftWebViewUtils.e())
    {
      String str = b(paramSwiftBrowserComponentContext);
      if ((!TextUtils.isEmpty(str)) && (SwiftWebViewUtils.d(str)) && (!str.contains("asyncMode=3")) && (!str.contains("sonic=1"))) {
        SwiftBrowserTBSHandler.a(str, paramSwiftBrowserComponentContext.a());
      }
    }
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    if ("onUploadLiveLogFinished".equals(paramString))
    {
      int i = 0;
      boolean bool = paramBundle.getBoolean("result", false);
      paramString = new StringBuilder();
      paramString.append("onUploadLiveLogFinished, result: ");
      paramString.append(bool);
      QLog.d("SwiftBrowserTBSInjectorImpl", 1, paramString.toString());
      if ((UiApiPlugin.aa != null) && (UiApiPlugin.Z.get() != -1L))
      {
        paramString = new Bundle();
        paramString.putLong("seq", UiApiPlugin.Z.get());
        paramBundle = UiApiPlugin.aa;
        if (!bool) {
          i = -3;
        }
        paramBundle.send(i, paramString);
        UiApiPlugin.aa = null;
        UiApiPlugin.Z.set(-1L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSInjectorImpl
 * JD-Core Version:    0.7.0.1
 */