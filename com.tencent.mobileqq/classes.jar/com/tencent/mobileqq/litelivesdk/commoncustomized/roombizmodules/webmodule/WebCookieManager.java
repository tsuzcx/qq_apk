package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule;

import android.content.Context;
import android.net.Uri;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.base.libapi.login.LoginRequest;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.falco.base.libapi.login.LoginType;
import com.tencent.falco.utils.HexUtil;
import com.tencent.falco.utils.NetworkUtil;
import com.tencent.falco.utils.UriUtil;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.livesdk.accountengine.UserEngine;
import com.tencent.livesdk.liveengine.LiveEngine;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import cooperation.qzone.QUA;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class WebCookieManager
{
  private static WebCookieManager a = new WebCookieManager();
  private Context b;
  
  public static WebCookieManager a()
  {
    return a;
  }
  
  private List<String> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = UriUtil.getSpecifiedLevelDomain(paramString, 2).toLowerCase();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(";Domain=");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(";Path=/;");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = (AppGeneralInfoService)BizEngineMgr.getInstance().getLiveEngine().getService(AppGeneralInfoService.class);
    int i = NetworkUtil.getNetworkType(this.b);
    paramString = BusinessManager.a.f();
    Object localObject3 = ((AppGeneralInfoService)localObject2).getAppId();
    Object localObject4 = QUA.getQUA3();
    int j = ((AppGeneralInfoService)localObject2).getClientType();
    Object localObject5 = Locale.ENGLISH;
    localObject2 = Integer.valueOf(1);
    localArrayList.add(String.format((Locale)localObject5, "%s=%d%s", new Object[] { "__client_type", Integer.valueOf(j), localObject1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "sdkver", "2.0.0", localObject1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "platform", "Android", localObject1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "installsrc", Integer.valueOf(j), localObject1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "networktype", Integer.valueOf(i), localObject1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "program_id", "", localObject1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "guid", paramString, localObject1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "qbid", "", localObject1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "appversion", "8.8.17", localObject1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%S", new Object[] { "appid", localObject3, localObject1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "__client_build", localObject4, localObject1 }));
    localObject3 = BizEngineMgr.getInstance().getUserEngine();
    if (localObject3 == null)
    {
      QLog.e("WebComponentManager", 1, "mUserEngine null");
      return localArrayList;
    }
    localObject4 = ((LoginServiceInterface)((UserEngine)localObject3).getService(LoginServiceInterface.class)).getLoginInfo();
    if (localObject4 == null)
    {
      QLog.e("WebComponentManager", 1, "loginInfo null");
      return localArrayList;
    }
    long l2 = ((LoginInfo)localObject4).uid;
    long l1;
    if (((LoginInfo)localObject4).tinyid != 0L) {
      l1 = ((LoginInfo)localObject4).tinyid;
    } else {
      l1 = l2;
    }
    localObject5 = HexUtil.bytesToHexString(((LoginInfo)localObject4).a2);
    Locale localLocale = Locale.ENGLISH;
    paramString = "";
    localArrayList.add(String.format(localLocale, "%s=%d%s", new Object[] { "ilive_uin", Long.valueOf(l2), localObject1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "ilive_tinyid", Long.valueOf(l1), localObject1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "ilive_a2", localObject5, localObject1 }));
    localObject5 = new StringBuilder();
    ((StringBuilder)localObject5).append("ilive_uin = ");
    ((StringBuilder)localObject5).append(l2);
    ((StringBuilder)localObject5).append(", ilive_tinyid = ");
    ((StringBuilder)localObject5).append(l1);
    QLog.e("WebComponentManager", 1, ((StringBuilder)localObject5).toString());
    if (!((LoginServiceInterface)((UserEngine)localObject3).getService(LoginServiceInterface.class)).isGuest())
    {
      if (((LoginInfo)localObject4).loginType == LoginType.QQ)
      {
        localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_id", ((LoginInfo)localObject4).openId, localObject1 }));
        localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_key", ((LoginInfo)localObject4).access_token, localObject1 }));
        localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "original_id_type", localObject2, localObject1 }));
        localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "original_key_type", Integer.valueOf(37), localObject1 }));
        localObject4 = Locale.ENGLISH;
        if (((UserEngine)localObject3).getLoginRequest() != null) {
          paramString = ((UserEngine)localObject3).getLoginRequest().appid;
        }
        localArrayList.add(String.format((Locale)localObject4, "%s=%s%s", new Object[] { "original_auth_appid", paramString, localObject1 }));
      }
      else if (((LoginInfo)localObject4).loginType == LoginType.WX)
      {
        localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_id", ((LoginInfo)localObject4).openId, localObject1 }));
        localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_key", ((LoginInfo)localObject4).access_token, localObject1 }));
        localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "original_id_type", Integer.valueOf(2), localObject1 }));
        localObject4 = Locale.ENGLISH;
        if (((UserEngine)localObject3).getLoginRequest() != null) {
          paramString = ((UserEngine)localObject3).getLoginRequest().appid;
        }
        localArrayList.add(String.format((Locale)localObject4, "%s=%s%s", new Object[] { "original_auth_appid", paramString, localObject1 }));
      }
    }
    else
    {
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "uin", paramString, localObject1 }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "skey", paramString, localObject1 }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_id", ((LoginInfo)localObject4).openId, localObject1 }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_key", ((LoginInfo)localObject4).access_token, localObject1 }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_id_type", paramString, localObject1 }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_key_type", paramString, localObject1 }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_auth_appid", paramString, localObject1 }));
    }
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "ilive_uid_type", localObject2, localObject1 }));
    return localArrayList;
  }
  
  public void a(Context paramContext, String paramString)
  {
    this.b = paramContext.getApplicationContext();
    Uri.parse(paramString);
    CookieSyncManager.createInstance(this.b);
    paramContext = CookieManager.getInstance();
    paramContext.setAcceptCookie(true);
    Iterator localIterator = a(paramString).iterator();
    while (localIterator.hasNext()) {
      paramContext.setCookie(paramString, (String)localIterator.next());
    }
    paramContext.removeExpiredCookie();
    CookieSyncManager.getInstance().sync();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.WebCookieManager
 * JD-Core Version:    0.7.0.1
 */