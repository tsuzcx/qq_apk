package com.tencent.mobileqq.intervideo.litelive_kandian;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.ilive.litepages.room.bizmodule.LiteLuxuryGiftModule;
import com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.audiofocus.CustomAudioFocusListenerModule;
import com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.datareport.KandianCustomDataReportModule;
import com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.webmodule.KandianWebBizModule;
import com.tencent.mobileqq.litelivesdk.api.customized.BaseSDKPageBizBootModules;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.closebtn.CustomCloseBtnModule;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.keyboard.CustomKeyboardModule;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.switchroom.CustomSwitchRoomModule;
import com.tencent.mobileqq.litelivesdk.framework.customizedmgr.SDKPageBizModuleType;

public class KandianAudienceRoomModules
  extends BaseSDKPageBizBootModules
{
  public void a()
  {
    KandianWebBizModule localKandianWebBizModule = new KandianWebBizModule();
    a(SDKPageBizModuleType.Normal, localKandianWebBizModule);
    a(SDKPageBizModuleType.Normal, new CustomKeyboardModule());
    a(SDKPageBizModuleType.Normal, new CustomCloseBtnModule());
    a(SDKPageBizModuleType.Normal, new CustomSwitchRoomModule());
    a(SDKPageBizModuleType.Normal, new KandianCustomDataReportModule(localKandianWebBizModule));
    a(SDKPageBizModuleType.Normal, new LiteLuxuryGiftModule());
    a(SDKPageBizModuleType.Normal, new CustomAudioFocusListenerModule());
  }
  
  public void a(Context paramContext)
  {
    a((ViewGroup)LayoutInflater.from(paramContext).inflate(2131625150, (ViewGroup)null));
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d()
  {
    a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.litelive_kandian.KandianAudienceRoomModules
 * JD-Core Version:    0.7.0.1
 */