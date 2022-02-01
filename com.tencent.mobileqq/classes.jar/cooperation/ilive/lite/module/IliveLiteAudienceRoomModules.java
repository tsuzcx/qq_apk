package cooperation.ilive.lite.module;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.ilive.litepages.room.bizmodule.LiteLuxuryGiftModule;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.litelivesdk.api.customized.BaseSDKPageBizBootModules;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.litelivesdk.framework.customizedmgr.SDKPageBizModuleType;
import cooperation.ilive.lite.floatwindow.IliveFloatWindowHelper;

public class IliveLiteAudienceRoomModules
  extends BaseSDKPageBizBootModules
{
  public void a()
  {
    if (!BusinessManager.a.b().k) {
      a(SDKPageBizModuleType.Normal, new IliveSingleWebModule());
    } else {
      a(SDKPageBizModuleType.Normal, new IliveWebBizModule());
    }
    a(SDKPageBizModuleType.Normal, new IliveKeyboardModule());
    a(SDKPageBizModuleType.Normal, new IliveCloseBtnModule());
    a(SDKPageBizModuleType.Normal, new IliveSwitchRoomModule());
    a(SDKPageBizModuleType.Normal, new IliveReportModule());
    a(SDKPageBizModuleType.Normal, new IliveGuideModule());
    a(SDKPageBizModuleType.Normal, new LiteLuxuryGiftModule());
  }
  
  public void a(Context paramContext)
  {
    a((ViewGroup)LayoutInflater.from(paramContext).inflate(2131625163, (ViewGroup)null));
  }
  
  public void b() {}
  
  public void c()
  {
    if (IliveFloatWindowHelper.b()) {
      a(SDKPageBizModuleType.Bottom, new IliveFloatWindowModule());
    }
    a(SDKPageBizModuleType.Bottom, new IliveBottomModule());
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveLiteAudienceRoomModules
 * JD-Core Version:    0.7.0.1
 */