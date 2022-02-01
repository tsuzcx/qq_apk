package com.tencent.mobileqq.intervideo.now.dynamic.strategy;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.ilivesdk.roomswitchservice_interface.RoomSwitchInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.intervideo.lite_now_biz.VersionManager;
import com.tencent.mobileqq.intervideo.lite_now_biz.config.NowAppHelper;
import com.tencent.mobileqq.intervideo.lite_now_biz.config.NowBizConfigConst.NowLiteConfig;
import com.tencent.mobileqq.intervideo.lite_now_biz.config.NowBizConfigManager;
import com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice.MultiVoiceRoomModules;
import com.tencent.mobileqq.intervideo.lite_now_biz.now_live.NowHostProxyBuilder;
import com.tencent.mobileqq.intervideo.lite_now_biz.now_live.NowRoomAudienceModules;
import com.tencent.mobileqq.intervideo.lite_now_biz.now_live.services.NowSwitchRoomBuilder;
import com.tencent.mobileqq.intervideo.lite_now_biz.now_od.ODRoomModules;
import com.tencent.mobileqq.intervideo.lite_now_biz.now_od.services.ODSwitchRoomBuilder;
import com.tencent.mobileqq.intervideo.lite_now_biz.services.VoiceRoomServiceBuilder;
import com.tencent.mobileqq.litelivesdk.LiteLiveSDKFactory;
import com.tencent.mobileqq.litelivesdk.api.ILiveSDK;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import java.util.Map;

public class NowLiteStrategy
  implements IEnterRoomStrategy
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private VersionManager jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizVersionManager;
  
  public NowLiteStrategy(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private NowBizConfigManager a()
  {
    return NowBizConfigManager.a();
  }
  
  public BusinessConfig a(Bundle paramBundle, String paramString)
  {
    BusinessConfig localBusinessConfig = new BusinessConfig();
    localBusinessConfig.jdField_a_of_type_JavaLangString = paramString;
    localBusinessConfig.jdField_e_of_type_Int = 0;
    localBusinessConfig.jdField_b_of_type_JavaLangString = ApkUtils.a(BaseApplicationImpl.getContext());
    localBusinessConfig.jdField_a_of_type_Int = ApkUtils.a(BaseApplicationImpl.getContext());
    localBusinessConfig.jdField_d_of_type_Int = 406;
    localBusinessConfig.jdField_b_of_type_Int = NowBizConfigConst.NowLiteConfig.jdField_a_of_type_Int;
    localBusinessConfig.c = 0;
    localBusinessConfig.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localBusinessConfig.jdField_d_of_type_JavaLangString = paramBundle.getString("fromid");
    return localBusinessConfig;
  }
  
  public String a(Bundle paramBundle)
  {
    return a().a(paramBundle);
  }
  
  public void a(Bundle paramBundle, IDoneCallback paramIDoneCallback)
  {
    if (NowAppHelper.a(BaseApplicationImpl.getContext(), paramBundle))
    {
      NowAppHelper.a(BaseApplicationImpl.getContext(), paramBundle);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizVersionManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizVersionManager = new VersionManager();
    }
    a();
    String str = NowBizConfigManager.a(paramBundle, "fromid");
    if (a().a(str))
    {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizVersionManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 16205, new NowLiteStrategy.1(this, paramIDoneCallback, paramBundle));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizVersionManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new NowLiteStrategy.2(this, paramIDoneCallback, paramBundle));
  }
  
  public boolean a(Bundle paramBundle)
  {
    paramBundle = a(paramBundle);
    if ("live".equals(paramBundle))
    {
      LiteLiveSDKFactory.a().a(paramBundle, 7, NowRoomAudienceModules.class);
      LiteLiveSDKFactory.a().a(paramBundle, RoomSwitchInterface.class, NowSwitchRoomBuilder.class);
      LiteLiveSDKFactory.a().a(paramBundle, HostProxyInterface.class, NowHostProxyBuilder.class);
    }
    for (;;)
    {
      return true;
      if ("od".equals(paramBundle))
      {
        LiteLiveSDKFactory.a().a(paramBundle, 7, ODRoomModules.class);
        LiteLiveSDKFactory.a().a(paramBundle, RoomSwitchInterface.class, ODSwitchRoomBuilder.class);
        LiteLiveSDKFactory.a().a(paramBundle, HostProxyInterface.class, NowHostProxyBuilder.class);
        LiteLiveSDKFactory.a().a(paramBundle, RoomServiceInterface.class, VoiceRoomServiceBuilder.class);
      }
      else if ("multi_voice".equals(paramBundle))
      {
        LiteLiveSDKFactory.a().a(paramBundle, 7, MultiVoiceRoomModules.class);
        LiteLiveSDKFactory.a().a(paramBundle, RoomSwitchInterface.class, ODSwitchRoomBuilder.class);
        LiteLiveSDKFactory.a().a(paramBundle, HostProxyInterface.class, NowHostProxyBuilder.class);
        LiteLiveSDKFactory.a().a(paramBundle, RoomServiceInterface.class, VoiceRoomServiceBuilder.class);
      }
    }
  }
  
  public boolean a(String paramString)
  {
    return NowBizConfigManager.b(paramString);
  }
  
  public boolean a(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.strategy.NowLiteStrategy
 * JD-Core Version:    0.7.0.1
 */