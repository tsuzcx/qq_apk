package com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.falco.utils.HexUtil;
import com.tencent.falco.utils.NetworkUtil;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.intervideo.nowproxy.common.util.DeviceUtil;
import com.tencent.livesdk.accountengine.UserEngine;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

public class MultiVoiceWebCookieManager
{
  private static MultiVoiceWebCookieManager a = new MultiVoiceWebCookieManager();
  private String b = "0";
  
  public MultiVoiceWebCookieManager()
  {
    b();
  }
  
  public static MultiVoiceWebCookieManager a()
  {
    return a;
  }
  
  private void b()
  {
    if ((!TextUtils.isEmpty(this.b)) && (!TextUtils.equals(this.b, "0"))) {
      return;
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    TicketManager localTicketManager = (TicketManager)((AppRuntime)localObject).getManager(2);
    localObject = ((AppRuntime)localObject).getCurrentAccountUin();
    MultiVoiceWebCookieManager.1 local1 = new MultiVoiceWebCookieManager.1(this);
    localTicketManager.getPskey((String)localObject, 16L, new String[] { "now.qq.com" }, local1);
  }
  
  private List<String> c(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = com.tencent.mobileqq.intervideo.lite_now_biz.utils.UriUtil.a(paramString);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(";Domain=");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(";Path=/;");
    paramString = ((StringBuilder)localObject).toString();
    localObject = DeviceInfoUtil.e();
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "p_skey", this.b, paramString }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "__client_type", Integer.valueOf(406), paramString }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "sdkver", "2.0.0", paramString }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "platform", "Android", paramString }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "program_id", "", paramString }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "appversion", localObject, paramString }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "versioncode", "800409", paramString }));
    return localArrayList;
  }
  
  private List<String> d(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = com.tencent.mobileqq.litelivesdk.utils.UriUtil.a(paramString);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(";Domain=");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(";Path=/;");
    ((StringBuilder)localObject).toString();
    paramString = DeviceUtil.getDeviceId(BaseApplicationImpl.getContext());
    int i = NetworkUtil.getNetworkType(BaseApplicationImpl.getContext());
    localObject = BusinessManager.a.b().j;
    String str = DeviceInfoUtil.e();
    Locale localLocale = Locale.ENGLISH;
    Integer localInteger = Integer.valueOf(406);
    localArrayList.add(String.format(localLocale, "%s=%d%s", new Object[] { "__client_type", localInteger, "" }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "sdkver", "2.0.0", "" }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "platform", "Android", "" }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "installsrc", localInteger, "" }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "deviceID", paramString, "" }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "networktype", Integer.valueOf(i), "" }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "program_id", "", "" }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "guid", localObject, "" }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "qbid", "NowSdkFactory.getNowSdkInstance().getInitData().mQBID", "" }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "appversion", str, "" }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%S", new Object[] { "appid", "1", "" }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "imei", paramString, "" }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "__client_build", "NowSdkFactory.getNowSdkInstance().getInitData().mQUA", "" }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "version", str, "" }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "versioncode", "800409", "" }));
    paramString = ((LoginServiceInterface)BizEngineMgr.getInstance().getUserEngine().getService(LoginServiceInterface.class)).getLoginInfo();
    if (paramString != null)
    {
      long l2 = paramString.uid;
      long l1;
      if (paramString.tinyid != 0L) {
        l1 = paramString.tinyid;
      } else {
        l1 = l2;
      }
      localObject = HexUtil.bytesToHexString(paramString.a2);
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "ilive_uin", Long.valueOf(l2), "" }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "ilive_tinyid", Long.valueOf(l1), "" }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "ilive_a2", localObject, "" }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_id", paramString.openId, "" }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_key", paramString.access_token, "" }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "original_id_type", Integer.valueOf(1), "" }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "original_key_type", Integer.valueOf(37), "" }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_auth_appid", "101490787", "" }));
    }
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "uin_type", Integer.valueOf(2), "" }));
    return localArrayList;
  }
  
  public void a(String paramString)
  {
    Uri.parse(paramString);
    CookieSyncManager.createInstance(BaseApplicationImpl.getContext());
    CookieManager localCookieManager = CookieManager.getInstance();
    localCookieManager.setAcceptCookie(true);
    Iterator localIterator = d(paramString).iterator();
    while (localIterator.hasNext()) {
      localCookieManager.setCookie(paramString, (String)localIterator.next());
    }
    localCookieManager.removeExpiredCookie();
    CookieSyncManager.getInstance().sync();
  }
  
  public void b(String paramString)
  {
    CookieSyncManager.createInstance(BaseApplicationImpl.getContext());
    CookieManager localCookieManager = CookieManager.getInstance();
    localCookieManager.setAcceptCookie(true);
    Iterator localIterator = c(paramString).iterator();
    while (localIterator.hasNext()) {
      localCookieManager.setCookie(paramString, (String)localIterator.next());
    }
    localCookieManager.removeExpiredCookie();
    CookieSyncManager.getInstance().sync();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice.MultiVoiceWebCookieManager
 * JD-Core Version:    0.7.0.1
 */