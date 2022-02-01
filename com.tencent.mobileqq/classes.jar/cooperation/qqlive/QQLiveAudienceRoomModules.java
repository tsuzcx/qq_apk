package cooperation.qqlive;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.ilive.audiencepages.room.bizmodule.AVPreloadPlayerModule;
import com.tencent.ilive.litepages.room.bizmodule.LiteLuxuryGiftModule;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.litelivesdk.api.customized.BaseSDKPageBizBootModules;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.litelivesdk.framework.customizedmgr.SDKPageBizModuleType;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.api.ITimiGameApi;
import cooperation.ilive.lite.floatwindow.IliveFloatWindowHelper;
import cooperation.ilive.lite.module.IliveBottomModule;
import cooperation.ilive.lite.module.IliveCloseBtnModule;
import cooperation.ilive.lite.module.IliveFloatWindowModule;
import cooperation.ilive.lite.module.IliveGuideModule;
import cooperation.ilive.lite.module.IliveKeyboardModule;
import cooperation.ilive.lite.module.IliveReportModule;
import cooperation.ilive.lite.module.IliveSingleWebModule;
import cooperation.ilive.lite.module.IliveSwitchRoomModule;
import cooperation.ilive.lite.module.IliveWebBizModule;
import cooperation.qqlive.bizmodule.QQLiveGameRoomModule;
import cooperation.qqlive.bizmodule.QQLiveGiftModule;
import cooperation.qqlive.bizmodule.QQLiveGiftPreloadModule;

public class QQLiveAudienceRoomModules
  extends BaseSDKPageBizBootModules
{
  private ViewGroup b(Context paramContext)
  {
    return ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).getAudienceView(paramContext);
  }
  
  private ViewGroup c(Context paramContext)
  {
    return (ViewGroup)LayoutInflater.from(paramContext).inflate(2131625163, (ViewGroup)null);
  }
  
  private void j()
  {
    a(SDKPageBizModuleType.Normal, new QQLiveGameRoomModule());
  }
  
  private void k()
  {
    if (!BusinessManager.a.b().k) {
      a(SDKPageBizModuleType.Normal, new IliveSingleWebModule());
    } else {
      a(SDKPageBizModuleType.Normal, new IliveWebBizModule());
    }
    a(SDKPageBizModuleType.Normal, new IliveKeyboardModule());
    a(SDKPageBizModuleType.Normal, new IliveCloseBtnModule());
    a(SDKPageBizModuleType.Normal, new IliveSwitchRoomModule());
    a(SDKPageBizModuleType.Normal, new IliveGuideModule());
    a(SDKPageBizModuleType.Normal, new LiteLuxuryGiftModule());
  }
  
  private int l()
  {
    try
    {
      int i = ((Integer)a("ext_enter_room_room_type")).intValue();
      return i;
    }
    catch (Exception localException)
    {
      label15:
      break label15;
    }
    QLog.e("QQLiveAudienceRoomModules", 1, "getRoomType error!");
    return 0;
  }
  
  public void a()
  {
    if (l() == 1)
    {
      j();
    }
    else
    {
      k();
      a(SDKPageBizModuleType.Normal, new QQLiveGiftModule());
    }
    a(SDKPageBizModuleType.Normal, new IliveReportModule());
    a(SDKPageBizModuleType.Normal, new QQLiveGiftPreloadModule());
  }
  
  public void a(Context paramContext)
  {
    if (l() == 1) {
      paramContext = b(paramContext);
    } else {
      paramContext = c(paramContext);
    }
    a(paramContext);
  }
  
  public void b() {}
  
  public void c()
  {
    if (l() == 0)
    {
      if (IliveFloatWindowHelper.b()) {
        a(SDKPageBizModuleType.Bottom, new IliveFloatWindowModule());
      }
      a(SDKPageBizModuleType.Bottom, new IliveBottomModule());
      a(SDKPageBizModuleType.Bottom, new AVPreloadPlayerModule());
    }
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqlive.QQLiveAudienceRoomModules
 * JD-Core Version:    0.7.0.1
 */