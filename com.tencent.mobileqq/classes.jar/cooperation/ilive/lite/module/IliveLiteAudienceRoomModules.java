package cooperation.ilive.lite.module;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.ilive.litepages.room.bizmodule.LiteLuxuryGiftModule;
import com.tencent.mobileqq.litelivesdk.api.customized.BaseSDKPageBizBootModules;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.keyboard.CustomKeyboardModule;
import com.tencent.mobileqq.litelivesdk.framework.customizedmgr.SDKPageBizModuleType;

public class IliveLiteAudienceRoomModules
  extends BaseSDKPageBizBootModules
{
  public void a()
  {
    a(SDKPageBizModuleType.Normal, new IliveWebBizModule());
    a(SDKPageBizModuleType.Normal, new CustomKeyboardModule());
    a(SDKPageBizModuleType.Normal, new IliveCloseBtnModule());
    a(SDKPageBizModuleType.Normal, new IliveSwitchRoomModule());
    a(SDKPageBizModuleType.Normal, new IliveMiniAIOBtnModule());
    a(SDKPageBizModuleType.Normal, new IliveReportModule());
    a(SDKPageBizModuleType.Normal, new LiteLuxuryGiftModule());
  }
  
  public void a(Context paramContext)
  {
    a((ViewGroup)LayoutInflater.from(paramContext).inflate(2131559368, (ViewGroup)null));
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveLiteAudienceRoomModules
 * JD-Core Version:    0.7.0.1
 */