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
import java.util.List;
import java.util.Map;

public class NowLiteStrategy
  implements IEnterRoomStrategy
{
  private QQAppInterface a;
  private VersionManager b;
  
  public NowLiteStrategy(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private NowBizConfigManager a()
  {
    return NowBizConfigManager.a();
  }
  
  public BusinessConfig a(Bundle paramBundle, String paramString)
  {
    BusinessConfig localBusinessConfig = new BusinessConfig();
    localBusinessConfig.a = paramString;
    localBusinessConfig.h = 0;
    localBusinessConfig.b = ApkUtils.b(BaseApplicationImpl.getContext());
    localBusinessConfig.c = ApkUtils.a(BaseApplicationImpl.getContext());
    localBusinessConfig.f = 406;
    localBusinessConfig.d = NowBizConfigConst.NowLiteConfig.a;
    localBusinessConfig.e = 0;
    localBusinessConfig.j = this.a.getCurrentAccountUin();
    localBusinessConfig.i = paramBundle.getString("fromid");
    localBusinessConfig.n.clear();
    localBusinessConfig.n.add("https://now.qq.com/");
    return localBusinessConfig;
  }
  
  public void a(Bundle paramBundle, IDoneCallback paramIDoneCallback)
  {
    if (NowAppHelper.a(BaseApplicationImpl.getContext(), paramBundle))
    {
      NowAppHelper.b(BaseApplicationImpl.getContext(), paramBundle);
      return;
    }
    if (this.b == null) {
      this.b = new VersionManager();
    }
    a();
    String str = NowBizConfigManager.a(paramBundle, "fromid");
    if (a().a(str))
    {
      this.b.a(this.a, 16205, new NowLiteStrategy.1(this, paramIDoneCallback, paramBundle));
      return;
    }
    this.b.a(this.a, new NowLiteStrategy.2(this, paramIDoneCallback, paramBundle));
  }
  
  public boolean a(Bundle paramBundle)
  {
    paramBundle = b(paramBundle);
    if ("live".equals(paramBundle))
    {
      LiteLiveSDKFactory.a().a(paramBundle, 7, NowRoomAudienceModules.class);
      LiteLiveSDKFactory.a().a(paramBundle, RoomSwitchInterface.class, NowSwitchRoomBuilder.class);
      LiteLiveSDKFactory.a().a(paramBundle, HostProxyInterface.class, NowHostProxyBuilder.class);
    }
    else if ("od".equals(paramBundle))
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
    return true;
  }
  
  public boolean a(String paramString)
  {
    return NowBizConfigManager.b(paramString);
  }
  
  public boolean a(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    return false;
  }
  
  public String b(Bundle paramBundle)
  {
    return a().b(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.strategy.NowLiteStrategy
 * JD-Core Version:    0.7.0.1
 */