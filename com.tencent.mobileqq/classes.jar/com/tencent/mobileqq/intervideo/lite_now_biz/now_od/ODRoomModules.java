package com.tencent.mobileqq.intervideo.lite_now_biz.now_od;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.ilive.litepages.room.bizmodule.LiteLuxuryGiftModule;
import com.tencent.mobileqq.intervideo.lite_now_biz.module.AudioMediaModule;
import com.tencent.mobileqq.litelivesdk.api.customized.BaseSDKPageBizBootModules;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.closebtn.CustomCloseBtnModule;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.keyboard.CustomKeyboardModule;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.switchroom.CustomSwitchRoomModule;
import com.tencent.mobileqq.litelivesdk.framework.customizedmgr.SDKPageBizModuleType;

public class ODRoomModules
  extends BaseSDKPageBizBootModules
{
  public void a()
  {
    ODWebBizModule localODWebBizModule = new ODWebBizModule();
    a(SDKPageBizModuleType.Normal, localODWebBizModule);
    a(SDKPageBizModuleType.Normal, new CustomKeyboardModule());
    a(SDKPageBizModuleType.Normal, new CustomCloseBtnModule());
    a(SDKPageBizModuleType.Normal, new CustomSwitchRoomModule());
    a(SDKPageBizModuleType.Normal, new LiteLuxuryGiftModule());
    a(SDKPageBizModuleType.Normal, new AudioMediaModule());
  }
  
  public void a(Context paramContext)
  {
    a((ViewGroup)LayoutInflater.from(paramContext).inflate(2131559646, (ViewGroup)null));
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.now_od.ODRoomModules
 * JD-Core Version:    0.7.0.1
 */