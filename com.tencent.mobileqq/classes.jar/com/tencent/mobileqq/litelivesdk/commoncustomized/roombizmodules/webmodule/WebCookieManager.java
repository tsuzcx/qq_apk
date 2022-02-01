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
  private static WebCookieManager jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebCookieManager = new WebCookieManager();
  private Context jdField_a_of_type_AndroidContentContext;
  private UserEngine jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine = BizEngineMgr.getInstance().getUserEngine();
  
  public static WebCookieManager a()
  {
    return jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebCookieManager;
  }
  
  private List<String> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = UriUtil.getSpecifiedLevelDomain(paramString, 2).toLowerCase();
    String str1 = ";Domain=" + paramString + ";Path=/;";
    paramString = (AppGeneralInfoService)BizEngineMgr.getInstance().getLiveEngine().getService(AppGeneralInfoService.class);
    int i = NetworkUtil.getNetworkType(this.jdField_a_of_type_AndroidContentContext);
    Object localObject = BusinessManager.a.a();
    String str2 = paramString.getAppId();
    String str3 = QUA.getQUA3();
    int j = paramString.getClientType();
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "__client_type", Integer.valueOf(j), str1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "sdkver", "2.0.0", str1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "platform", "Android", str1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "installsrc", Integer.valueOf(j), str1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "networktype", Integer.valueOf(i), str1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "program_id", "", str1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "guid", localObject, str1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "qbid", "", str1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "appversion", "8.5.5", str1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%S", new Object[] { "appid", str2, str1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "__client_build", str3, str1 }));
    if (this.jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine == null)
    {
      QLog.e("WebComponentManager", 1, "mUserEngine null");
      return localArrayList;
    }
    paramString = ((LoginServiceInterface)this.jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine.getService(LoginServiceInterface.class)).getLoginInfo();
    if (paramString == null)
    {
      QLog.e("WebComponentManager", 1, "loginInfo null");
      return localArrayList;
    }
    long l2 = paramString.uid;
    long l1;
    if (paramString.tinyid != 0L)
    {
      l1 = paramString.tinyid;
      localObject = HexUtil.bytesToHexString(paramString.a2);
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "ilive_uin", Long.valueOf(l2), str1 }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "ilive_tinyid", Long.valueOf(l1), str1 }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "ilive_a2", localObject, str1 }));
      QLog.e("WebComponentManager", 1, "ilive_uin = " + l2 + ", ilive_tinyid = " + l1);
      if (((LoginServiceInterface)this.jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine.getService(LoginServiceInterface.class)).isGuest()) {
        break label1194;
      }
      if (paramString.loginType != LoginType.QQ) {
        break label1005;
      }
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_id", paramString.openId, str1 }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_key", paramString.access_token, str1 }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "original_id_type", Integer.valueOf(1), str1 }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "original_key_type", Integer.valueOf(37), str1 }));
      localObject = Locale.ENGLISH;
      if (this.jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine.getLoginRequest() == null) {
        break label999;
      }
      paramString = this.jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine.getLoginRequest().appid;
      label919:
      localArrayList.add(String.format((Locale)localObject, "%s=%s%s", new Object[] { "original_auth_appid", paramString, str1 }));
    }
    label1194:
    for (;;)
    {
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "ilive_uid_type", Integer.valueOf(1), str1 }));
      return localArrayList;
      l1 = l2;
      break;
      label999:
      paramString = "";
      break label919;
      label1005:
      if (paramString.loginType == LoginType.WX)
      {
        localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_id", paramString.openId, str1 }));
        localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_key", paramString.access_token, str1 }));
        localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "original_id_type", Integer.valueOf(2), str1 }));
        localObject = Locale.ENGLISH;
        if (this.jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine.getLoginRequest() != null) {}
        for (paramString = this.jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine.getLoginRequest().appid;; paramString = "")
        {
          localArrayList.add(String.format((Locale)localObject, "%s=%s%s", new Object[] { "original_auth_appid", paramString, str1 }));
          break;
        }
        localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "uin", "", str1 }));
        localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "skey", "", str1 }));
        localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_id", paramString.openId, str1 }));
        localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_key", paramString.access_token, str1 }));
        localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_id_type", "", str1 }));
        localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_key_type", "", str1 }));
        localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_auth_appid", "", str1 }));
      }
    }
  }
  
  public void a(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    Uri.parse(paramString);
    CookieSyncManager.createInstance(this.jdField_a_of_type_AndroidContentContext);
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