package com.tencent.mobileqq.litelivesdk.framework.customizedmgr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.ilive.audiencepages.room.bizmodule.AVPlayerModule;
import com.tencent.mobileqq.litelivesdk.api.customized.BaseSDKPageBizBootModules;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.closebtn.CustomCloseBtnModule;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.keyboard.CustomKeyboardModule;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.switchroom.CustomSwitchRoomModule;

public class DefaultAudienceRoomBizBootModules
  extends BaseSDKPageBizBootModules
{
  public void a()
  {
    a(SDKPageBizModuleType.Normal, new DefaultAudienceRoomBizBootModules.1(this));
    a(SDKPageBizModuleType.Normal, new CustomKeyboardModule());
    a(SDKPageBizModuleType.Normal, new CustomCloseBtnModule());
    a(SDKPageBizModuleType.Normal, new CustomSwitchRoomModule());
  }
  
  public void a(Context paramContext)
  {
    a((ViewGroup)LayoutInflater.from(paramContext).inflate(2131559365, (ViewGroup)null));
  }
  
  public void b() {}
  
  public void c()
  {
    a(SDKPageBizModuleType.Bottom, new AVPlayerModule());
  }
  
  public void d()
  {
    a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.framework.customizedmgr.DefaultAudienceRoomBizBootModules
 * JD-Core Version:    0.7.0.1
 */