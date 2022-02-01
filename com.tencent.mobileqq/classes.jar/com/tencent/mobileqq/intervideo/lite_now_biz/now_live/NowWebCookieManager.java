package com.tencent.mobileqq.intervideo.lite_now_biz.now_live;

import com.tencent.biz.pubaccount.readinjoy.gifvideo.utils.IPUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.litelivesdk.api.login.LoginResult;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.litelivesdk.framework.login.LoginManager;
import com.tencent.mobileqq.litelivesdk.utils.DeviceUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;

public class NowWebCookieManager
{
  public static String a()
  {
    BusinessConfig localBusinessConfig = BusinessManager.a.a();
    Object localObject3 = LoginManager.a.a();
    Object localObject1;
    StringBuilder localStringBuilder1;
    Object localObject2;
    label84:
    label123:
    long l;
    if (localObject3 == null)
    {
      localObject1 = "";
      IPUtils.a(BaseApplicationImpl.getContext());
      String str1 = NetworkUtils.getAPN(BaseApplicationImpl.getContext());
      String str2 = DeviceUtils.a(BaseApplicationImpl.getContext());
      String str3 = DeviceInfoUtil.a();
      localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = new StringBuilder().append("ilive_a2=");
      if (localObject3 != null) {
        break label648;
      }
      localObject2 = "";
      localStringBuilder1.append((String)localObject2);
      localStringBuilder2 = new StringBuilder().append("; ilive_tinyid=");
      if (localObject3 != null) {
        break label658;
      }
      localObject2 = "";
      localStringBuilder1.append((String)localObject2);
      localObject2 = new StringBuilder().append("; ilive_uin=");
      if (localObject3 != null) {
        break label668;
      }
      l = 0L;
      label160:
      localStringBuilder1.append(l);
      localStringBuilder2 = new StringBuilder().append("; p_skey=");
      if (localObject3 != null) {
        break label677;
      }
      localObject2 = Integer.valueOf(0);
      label200:
      localStringBuilder1.append(localObject2);
      localObject3 = new StringBuilder().append("; p_uin=o");
      if (localBusinessConfig != null) {
        break label684;
      }
      localObject2 = Integer.valueOf(0);
      label241:
      localStringBuilder1.append(localObject2);
      localObject3 = new StringBuilder().append("; skey=");
      if (0 == 0) {
        break label694;
      }
      localObject2 = new String(null);
      label285:
      localStringBuilder1.append((String)localObject2);
      localObject3 = new StringBuilder().append("; uin=o");
      if (localBusinessConfig != null) {
        break label701;
      }
      localObject2 = Integer.valueOf(0);
      label326:
      localStringBuilder1.append(localObject2);
      localObject3 = new StringBuilder().append("; appid=");
      if (localBusinessConfig != null) {
        break label711;
      }
      localObject2 = Integer.valueOf(0);
      label367:
      localStringBuilder1.append(localObject2);
      localStringBuilder1.append("; deviceID=" + str2);
      localStringBuilder1.append("; imei=" + str3);
      localStringBuilder1.append("; installsrc=406");
      localStringBuilder1.append("; ip=");
      localStringBuilder1.append("; networktype=" + str1);
      localStringBuilder1.append("; original_id=" + (String)localObject1);
      localStringBuilder1.append("; original_id_type=1");
      localStringBuilder1.append("; original_key=" + "");
      localStringBuilder1.append("; original_key_type=37");
      localStringBuilder1.append("; versioncode=10001");
      localObject1 = new StringBuilder().append("; __client_type=");
      if (localBusinessConfig != null) {
        break label721;
      }
    }
    label648:
    label658:
    label668:
    label677:
    label684:
    label694:
    label701:
    label711:
    label721:
    for (int i = 0;; i = localBusinessConfig.d)
    {
      localStringBuilder1.append(i);
      localStringBuilder1.append("; __Yqemom=EQ_1598856754_1888751125");
      localStringBuilder1.append("; qq_route_id=0");
      localStringBuilder1.append("; qq_dt_seen_list_2807255571=%5B1900002394%5D");
      localStringBuilder1.append("; qq_dt_tab_id_2807255571=3");
      localStringBuilder1.append("; _supWebp=0");
      return localStringBuilder1.toString();
      localObject1 = String.valueOf(LoginManager.a.a().a);
      break;
      localObject2 = ((LoginResult)localObject3).e;
      break label84;
      localObject2 = ((LoginResult)localObject3).f;
      break label123;
      l = ((LoginResult)localObject3).a;
      break label160;
      localObject2 = "jSuFWcbtxpNBUgKxUxyN86CMsbzKQ*WM9bGdSk2i73s_";
      break label200;
      localObject2 = localBusinessConfig.e;
      break label241;
      localObject2 = "";
      break label285;
      localObject2 = localBusinessConfig.e;
      break label326;
      localObject2 = localBusinessConfig.a;
      break label367;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.now_live.NowWebCookieManager
 * JD-Core Version:    0.7.0.1
 */