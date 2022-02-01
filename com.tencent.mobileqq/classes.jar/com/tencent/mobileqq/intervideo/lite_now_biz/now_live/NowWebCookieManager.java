package com.tencent.mobileqq.intervideo.lite_now_biz.now_live;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.litelivesdk.api.login.LoginResult;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.litelivesdk.framework.login.LoginManager;
import com.tencent.mobileqq.litelivesdk.utils.DeviceUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.IPUtils;

public class NowWebCookieManager
{
  public static String a()
  {
    BusinessConfig localBusinessConfig = BusinessManager.a.a();
    Object localObject3 = LoginManager.a.a();
    if (localObject3 == null) {
      localObject1 = "";
    } else {
      localObject1 = String.valueOf(LoginManager.a.a().a);
    }
    IPUtils.a(BaseApplicationImpl.getContext());
    String str1 = NetworkUtils.getAPN(BaseApplicationImpl.getContext());
    String str3 = DeviceUtils.a(BaseApplicationImpl.getContext());
    String str2 = DeviceInfoUtil.a();
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("ilive_a2=");
    if (localObject3 == null) {
      localObject2 = "";
    } else {
      localObject2 = ((LoginResult)localObject3).e;
    }
    localStringBuilder2.append((String)localObject2);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("; ilive_tinyid=");
    if (localObject3 == null) {
      localObject2 = "";
    } else {
      localObject2 = ((LoginResult)localObject3).f;
    }
    localStringBuilder2.append((String)localObject2);
    localStringBuilder1.append(localStringBuilder2.toString());
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("; ilive_uin=");
    long l;
    if (localObject3 == null) {
      l = 0L;
    } else {
      l = ((LoginResult)localObject3).a;
    }
    ((StringBuilder)localObject2).append(l);
    localStringBuilder1.append(((StringBuilder)localObject2).toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("; p_skey=");
    int i = 0;
    if (localObject3 == null) {
      localObject2 = Integer.valueOf(0);
    } else {
      localObject2 = "jSuFWcbtxpNBUgKxUxyN86CMsbzKQ*WM9bGdSk2i73s_";
    }
    localStringBuilder2.append(localObject2);
    localStringBuilder1.append(localStringBuilder2.toString());
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("; p_uin=o");
    if (localBusinessConfig == null) {
      localObject2 = Integer.valueOf(0);
    } else {
      localObject2 = localBusinessConfig.e;
    }
    ((StringBuilder)localObject3).append(localObject2);
    localStringBuilder1.append(((StringBuilder)localObject3).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("; skey=");
    ((StringBuilder)localObject2).append("");
    localStringBuilder1.append(((StringBuilder)localObject2).toString());
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("; uin=o");
    if (localBusinessConfig == null) {
      localObject2 = Integer.valueOf(0);
    } else {
      localObject2 = localBusinessConfig.e;
    }
    ((StringBuilder)localObject3).append(localObject2);
    localStringBuilder1.append(((StringBuilder)localObject3).toString());
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("; appid=");
    if (localBusinessConfig == null) {
      localObject2 = Integer.valueOf(0);
    } else {
      localObject2 = localBusinessConfig.a;
    }
    ((StringBuilder)localObject3).append(localObject2);
    localStringBuilder1.append(((StringBuilder)localObject3).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("; deviceID=");
    ((StringBuilder)localObject2).append(str3);
    localStringBuilder1.append(((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("; imei=");
    ((StringBuilder)localObject2).append(str2);
    localStringBuilder1.append(((StringBuilder)localObject2).toString());
    localStringBuilder1.append("; installsrc=406");
    localStringBuilder1.append("; ip=");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("; networktype=");
    ((StringBuilder)localObject2).append(str1);
    localStringBuilder1.append(((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("; original_id=");
    ((StringBuilder)localObject2).append((String)localObject1);
    localStringBuilder1.append(((StringBuilder)localObject2).toString());
    localStringBuilder1.append("; original_id_type=1");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("; original_key=");
    ((StringBuilder)localObject1).append("");
    localStringBuilder1.append(((StringBuilder)localObject1).toString());
    localStringBuilder1.append("; original_key_type=37");
    localStringBuilder1.append("; versioncode=10001");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("; __client_type=");
    if (localBusinessConfig != null) {
      i = localBusinessConfig.d;
    }
    ((StringBuilder)localObject1).append(i);
    localStringBuilder1.append(((StringBuilder)localObject1).toString());
    localStringBuilder1.append("; __Yqemom=EQ_1598856754_1888751125");
    localStringBuilder1.append("; qq_route_id=0");
    localStringBuilder1.append("; qq_dt_seen_list_2807255571=%5B1900002394%5D");
    localStringBuilder1.append("; qq_dt_tab_id_2807255571=3");
    localStringBuilder1.append("; _supWebp=0");
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.now_live.NowWebCookieManager
 * JD-Core Version:    0.7.0.1
 */