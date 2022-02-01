package com.tencent.mobileqq.intervideo.lite_now_biz.now_od;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.falco.utils.HexUtil;
import com.tencent.falco.utils.NetworkUtil;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.intervideo.nowproxy.common.util.DeviceUtil;
import com.tencent.livesdk.accountengine.UserEngine;
import com.tencent.mobileqq.intervideo.lite_now_biz.utils.UriUtil;
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

public class ODWebCookieManager
{
  private static ODWebCookieManager jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizNow_odODWebCookieManager = new ODWebCookieManager();
  private String jdField_a_of_type_JavaLangString = "0";
  
  public ODWebCookieManager()
  {
    a();
  }
  
  public static ODWebCookieManager a()
  {
    return jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizNow_odODWebCookieManager;
  }
  
  private List<String> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = UriUtil.a(paramString);
    paramString = ";Domain=" + paramString + ";Path=/;";
    String str = DeviceInfoUtil.c();
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "p_skey", this.jdField_a_of_type_JavaLangString, paramString }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "__client_type", Integer.valueOf(406), paramString }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "sdkver", "2.0.0", paramString }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "platform", "Android", paramString }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "program_id", "", paramString }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "appversion", str, paramString }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "versioncode", "800409", paramString }));
    return localArrayList;
  }
  
  private void a()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, "0"))) {
      return;
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    TicketManager localTicketManager = (TicketManager)((AppRuntime)localObject).getManager(2);
    localObject = ((AppRuntime)localObject).getCurrentAccountUin();
    ODWebCookieManager.1 local1 = new ODWebCookieManager.1(this);
    localTicketManager.getPskey((String)localObject, 16L, new String[] { "now.qq.com" }, local1);
  }
  
  private List<String> b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = UriUtil.a(paramString);
    paramString = ";Domain=" + paramString + ";Path=/;";
    Object localObject = DeviceUtil.getDeviceId(BaseApplicationImpl.getContext());
    int i = NetworkUtil.getNetworkType(BaseApplicationImpl.getContext());
    String str1 = BusinessManager.a.a().e;
    String str2 = DeviceInfoUtil.c();
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "p_skey", this.jdField_a_of_type_JavaLangString, paramString }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "__client_type", Integer.valueOf(405), paramString }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "sdkver", "2.0.0", paramString }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "platform", "Android", paramString }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "installsrc", Integer.valueOf(405), paramString }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "deviceID", localObject, paramString }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "networktype", Integer.valueOf(i), paramString }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "program_id", "", paramString }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "guid", str1, paramString }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "qbid", "NowSdkFactory.getNowSdkInstance().getInitData().mQBID", paramString }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "appversion", str2, paramString }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%S", new Object[] { "appid", "1", paramString }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "imei", localObject, paramString }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "__client_build", "NowSdkFactory.getNowSdkInstance().getInitData().mQUA", paramString }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "version", str2, paramString }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "versioncode", "800409", paramString }));
    localObject = ((LoginServiceInterface)BizEngineMgr.getInstance().getUserEngine().getService(LoginServiceInterface.class)).getLoginInfo();
    long l2;
    if (localObject != null)
    {
      l2 = ((LoginInfo)localObject).uid;
      if (((LoginInfo)localObject).tinyid == 0L) {
        break label1020;
      }
    }
    label1020:
    for (long l1 = ((LoginInfo)localObject).tinyid;; l1 = l2)
    {
      str1 = HexUtil.bytesToHexString(((LoginInfo)localObject).a2);
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "ilive_uin", Long.valueOf(l2), paramString }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "ilive_tinyid", Long.valueOf(l1), paramString }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "ilive_a2", str1, paramString }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_id", ((LoginInfo)localObject).openId, paramString }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_key", ((LoginInfo)localObject).access_token, paramString }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "original_id_type", Integer.valueOf(1), paramString }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "original_key_type", Integer.valueOf(37), paramString }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_auth_appid", "101490787", paramString }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "uin_type", Integer.valueOf(2), paramString }));
      return localArrayList;
    }
  }
  
  public void a(String paramString)
  {
    CookieSyncManager.createInstance(BaseApplicationImpl.getContext());
    CookieManager localCookieManager = CookieManager.getInstance();
    localCookieManager.setAcceptCookie(true);
    Iterator localIterator = b(paramString).iterator();
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
    Iterator localIterator = a(paramString).iterator();
    while (localIterator.hasNext()) {
      localCookieManager.setCookie(paramString, (String)localIterator.next());
    }
    localCookieManager.removeExpiredCookie();
    CookieSyncManager.getInstance().sync();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.now_od.ODWebCookieManager
 * JD-Core Version:    0.7.0.1
 */