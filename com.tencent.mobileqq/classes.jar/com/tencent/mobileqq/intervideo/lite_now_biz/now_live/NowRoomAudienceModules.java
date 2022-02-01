package com.tencent.mobileqq.intervideo.lite_now_biz.now_live;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.ilive.audiencepages.room.bizmodule.AudioFocusListenerModule;
import com.tencent.ilive.litepages.room.bizmodule.LiteLuxuryGiftModule;
import com.tencent.mobileqq.litelivesdk.api.customized.BaseSDKPageBizBootModules;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.closebtn.CustomCloseBtnModule;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.keyboard.CustomKeyboardModule;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.switchroom.CustomSwitchRoomModule;
import com.tencent.mobileqq.litelivesdk.framework.customizedmgr.SDKPageBizModuleType;

public class NowRoomAudienceModules
  extends BaseSDKPageBizBootModules
{
  public void a()
  {
    NowWebBizModule localNowWebBizModule = new NowWebBizModule();
    a(SDKPageBizModuleType.Normal, localNowWebBizModule);
    a(SDKPageBizModuleType.Normal, new AudioFocusListenerModule());
    a(SDKPageBizModuleType.Normal, new CustomKeyboardModule());
    a(SDKPageBizModuleType.Normal, new CustomCloseBtnModule());
    a(SDKPageBizModuleType.Normal, new CustomSwitchRoomModule());
    a(SDKPageBizModuleType.Normal, new LiteLuxuryGiftModule());
  }
  
  public void a(Context paramContext)
  {
    a((ViewGroup)LayoutInflater.from(paramContext).inflate(2131559641, (ViewGroup)null));
  }
  
  public void b() {}
  
  public void c()
  {
    a(SDKPageBizModuleType.Bottom, new NowFloatWindowModule());
  }
  
  public void d()
  {
    a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.now_live.NowRoomAudienceModules
 * JD-Core Version:    0.7.0.1
 */