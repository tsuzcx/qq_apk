package com.tencent.mobileqq.intervideo.now.dynamic.strategy;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.ilivesdk.roomswitchservice_interface.RoomSwitchInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.intervideo.litelive_kandian.KandianAudienceRoomModules;
import com.tencent.mobileqq.intervideo.litelive_kandian.config.KandianLiveCfgBean;
import com.tencent.mobileqq.intervideo.litelive_kandian.config.KandianLiveConfProcessor;
import com.tencent.mobileqq.intervideo.litelive_kandian.customized.services.hostproxy.KandianHostProxyBuilder;
import com.tencent.mobileqq.intervideo.litelive_kandian.customized.services.rommswitch.KandianCustomSwitchRoomBuilder;
import com.tencent.mobileqq.litelivesdk.LiteLiveSDKFactory;
import com.tencent.mobileqq.litelivesdk.api.ILiveSDK;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.statistics.QQUserAction;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;

public class KanDianStrategy
  implements IEnterRoomStrategy, KanDianStrategyConstant
{
  private QQAppInterface a;
  
  public KanDianStrategy(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public BusinessConfig a(Bundle paramBundle, String paramString)
  {
    BusinessConfig localBusinessConfig = new BusinessConfig();
    localBusinessConfig.a = paramString;
    localBusinessConfig.h = 0;
    localBusinessConfig.b = ApkUtils.b(BaseApplicationImpl.getContext());
    localBusinessConfig.c = ApkUtils.a(BaseApplicationImpl.getContext());
    localBusinessConfig.f = 16232;
    localBusinessConfig.d = 0;
    localBusinessConfig.e = 0;
    localBusinessConfig.j = this.a.getCurrentAccountUin();
    localBusinessConfig.i = paramBundle.getString("fromid");
    localBusinessConfig.k = true;
    localBusinessConfig.n.clear();
    localBusinessConfig.n.add("https://now.qq.com/");
    return localBusinessConfig;
  }
  
  public void a(Bundle paramBundle, IDoneCallback paramIDoneCallback)
  {
    if (paramIDoneCallback != null) {
      paramIDoneCallback.a();
    }
  }
  
  public boolean a(Bundle paramBundle)
  {
    LiteLiveSDKFactory.a().a("1014", 7, KandianAudienceRoomModules.class);
    LiteLiveSDKFactory.a().a("1014", RoomSwitchInterface.class, KandianCustomSwitchRoomBuilder.class);
    LiteLiveSDKFactory.a().a("1014", HostProxyInterface.class, KandianHostProxyBuilder.class);
    return true;
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    String str = paramString.toLowerCase();
    paramString = str;
    if (str.startsWith("share_msg_")) {
      paramString = str.substring(10);
    }
    if ((!paramString.startsWith("kandian_")) && ((paramString.compareTo("3000") < 0) || (paramString.compareTo("5999") > 0))) {
      return false;
    }
    paramString = KandianLiveConfProcessor.a();
    if ((paramString != null) && (paramString.a()))
    {
      QLog.i("KanDianStrategy", 1, "isUserLiteSDK-----will Use LiteSDK");
      return true;
    }
    QLog.i("KanDianStrategy", 1, "isUserLiteSDK-----will Not Use LiteSDK");
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    return QQUserAction.a(paramString1, paramString2, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2, paramBoolean3);
  }
  
  public String b(Bundle paramBundle)
  {
    return "1014";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.strategy.KanDianStrategy
 * JD-Core Version:    0.7.0.1
 */