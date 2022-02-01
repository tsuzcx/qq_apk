package com.tencent.mobileqq.intervideo.now.dynamic.strategy;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
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
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class KanDianStrategy
  implements IEnterRoomStrategy
{
  private QQAppInterface a;
  
  public KanDianStrategy(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public BusinessConfig a(Bundle paramBundle, String paramString)
  {
    BusinessConfig localBusinessConfig = new BusinessConfig();
    localBusinessConfig.jdField_a_of_type_JavaLangString = paramString;
    localBusinessConfig.jdField_e_of_type_Int = 0;
    localBusinessConfig.jdField_b_of_type_JavaLangString = ApkUtils.a(BaseApplicationImpl.getContext());
    localBusinessConfig.jdField_a_of_type_Int = ApkUtils.a(BaseApplicationImpl.getContext());
    localBusinessConfig.jdField_d_of_type_Int = 16232;
    localBusinessConfig.jdField_b_of_type_Int = 0;
    localBusinessConfig.c = 0;
    localBusinessConfig.jdField_e_of_type_JavaLangString = this.a.getCurrentAccountUin();
    localBusinessConfig.jdField_d_of_type_JavaLangString = paramBundle.getString("fromid");
    localBusinessConfig.jdField_a_of_type_Boolean = true;
    return localBusinessConfig;
  }
  
  public String a(Bundle paramBundle)
  {
    return "1014";
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
      paramString = str.substring("share_msg_".length());
    }
    if ((paramString.startsWith("kandian_")) || ((paramString.compareTo("3000") >= 0) && (paramString.compareTo("5999") <= 0)))
    {
      paramString = KandianLiveConfProcessor.a();
      if ((paramString != null) && (paramString.a()))
      {
        QLog.i("KanDianStrategy", 1, "isUserLiteSDK-----will Use LiteSDK");
        return true;
      }
      QLog.i("KanDianStrategy", 1, "isUserLiteSDK-----will Not Use LiteSDK");
      return false;
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    return UserAction.onUserActionToTunnel(paramString1, paramString2, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2, paramBoolean3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.strategy.KanDianStrategy
 * JD-Core Version:    0.7.0.1
 */