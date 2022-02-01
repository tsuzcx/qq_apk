package com.tencent.mobileqq.teamwork;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.config.business.tendoc.TencentDocPreloadConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocPreloadConfigProcessor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocEditBrowserProxy;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class TenDocWebPreLoadHelper
{
  public static volatile String a = "";
  
  public static TouchWebView a(Context paramContext)
  {
    TenDocWebViewPool localTenDocWebViewPool = TenDocWebViewPool.a();
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = BaseApplication.getContext();
    }
    return localTenDocWebViewPool.a((Context)localObject);
  }
  
  public static void a(String paramString)
  {
    QLog.d("TenDocWebPreLoadHelper", 1, "tendocpreload preCreateWebViewNoWebProcess ");
    TenDocWebViewPool.a().a(paramString);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    boolean bool1 = TencentDocPreloadConfigProcessor.a().a();
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    if (!(paramContext instanceof Activity)) {
      return false;
    }
    bool1 = bool2;
    if (!TextUtils.isEmpty(paramString)) {
      if (!((ITeamWorkDocEditBrowserProxy)QRoute.api(ITeamWorkDocEditBrowserProxy.class)).isInstanceClass((Activity)paramContext))
      {
        bool1 = bool2;
        if (!((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isDocsUrlForPreLoad(paramString)) {}
      }
      else
      {
        bool1 = bool2;
        if (TenDocWebViewPool.a().c()) {
          if (!paramString.contains(a))
          {
            bool1 = bool2;
            if (a != null) {}
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static void b(String paramString)
  {
    QLog.d("TenDocWebPreLoadHelper", 1, "tendocpreload preloadTenDocUrl ");
    if (!TextUtils.isEmpty(paramString))
    {
      a = paramString;
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        if ((((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isDocsUrlForPreLoad(paramString)) && (!TenDocWebViewPool.a().b(paramString)))
        {
          TenDocWebViewPool.a().a(paramString);
          TenDocWebViewPool.a().b(paramString);
        }
      }
      else {
        new Handler(Looper.getMainLooper()).post(new TenDocWebPreLoadHelper.1(paramString));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TenDocWebPreLoadHelper
 * JD-Core Version:    0.7.0.1
 */