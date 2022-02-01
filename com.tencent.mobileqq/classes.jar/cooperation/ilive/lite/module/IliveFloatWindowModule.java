package cooperation.ilive.lite.module;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.IModule;
import com.tencent.avbiz.IModule.FocusChangeListener;
import com.tencent.falco.base.floatwindow.widget.LiveFloatWindowManager;
import com.tencent.falco.base.libapi.activity.ActivityLifeCycleService;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.falco.base.libapi.hostproxy.SdkInfoInterface;
import com.tencent.ilive.EnterRoomConfig;
import com.tencent.ilive.LiveAudience;
import com.tencent.ilive.audiencepages.room.events.FloatWindowStateEvent;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilive.interfaces.IAudienceRoomPager;
import com.tencent.ilive.litepages.room.bizmodule.AudLiteFloatWindowModule;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilive.uicomponent.floatwindowcomponent_interface.FloatWindowComponent;
import com.tencent.ilivesdk.avplayerbuilderservice_interface.AVPlayerBuilderServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;
import com.tencent.livesdk.liveengine.FloatRoomManager;
import com.tencent.livesdk.liveengine.FloatRoomManager.Room;
import com.tencent.livesdk.liveengine.LiveEngine;
import com.tencent.livesdk.roomengine.RoomEngine;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.litelivesdk.utils.UriUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.api.ITimiGameApi;
import com.tencent.timi.game.api.live.ILiveModuleStatusListener;
import cooperation.ilive.lite.event.IliveLiteEventCenter;
import cooperation.ilive.lite.event.IliveLiteEventCenter.Observer;
import cooperation.ilive.lite.report.IliveLiteDataReport;
import cooperation.ilive.lite.service.IliveActivityLifeCycleService;
import java.util.HashMap;

public class IliveFloatWindowModule
  extends AudLiteFloatWindowModule
{
  private long a;
  private boolean b = false;
  private boolean c = false;
  private IliveActivityLifeCycleService d;
  private boolean e = false;
  private SwitchRoomInfo f;
  private IModule.FocusChangeListener g = new IliveFloatWindowModule.2(this);
  private IliveLiteEventCenter.Observer h = new IliveFloatWindowModule.3(this);
  
  private void a()
  {
    QLog.e("IliveFloatWindowModule", 1, "onWindowShow");
    this.a = System.currentTimeMillis();
    IliveLiteDataReport.a().f(c());
    IModule localIModule = AVBizModuleFactory.getModuleByName("QQ直播");
    localIModule.requestAVFocus();
    localIModule.setListener(this.g);
  }
  
  private void a(int paramInt)
  {
    long l2 = this.a;
    long l1 = 0L;
    if (l2 > 0L) {
      l1 = System.currentTimeMillis() - this.a;
    }
    IliveLiteDataReport.a().d(c(), l1, b(paramInt));
    AVBizModuleFactory.getModuleByName("QQ直播").abandonAVFocus();
    AVBizModuleFactory.removeModuleByName("QQ直播");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onWindowHide closeReason = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" timelong = ");
    localStringBuilder.append(l1);
    QLog.e("IliveFloatWindowModule", 1, localStringBuilder.toString());
  }
  
  private int b(int paramInt)
  {
    if (paramInt == 9) {
      return 1;
    }
    if (paramInt == 8) {
      return 2;
    }
    return 4;
  }
  
  private long b()
  {
    EnterRoomConfig localEnterRoomConfig = BusinessManager.a.c();
    if ((localEnterRoomConfig != null) && (localEnterRoomConfig.extData != null))
    {
      String str = localEnterRoomConfig.extData.getString("mqqschema");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append("");
      str = UriUtil.b(str, "starttime", localStringBuilder.toString());
      localEnterRoomConfig.extData.putString("mqqschema", str);
    }
    return -1L;
  }
  
  private long c()
  {
    if ((this.roomBizContext != null) && (this.roomBizContext.getEnterRoomInfo() != null)) {
      return this.roomBizContext.getEnterRoomInfo().roomId;
    }
    return 0L;
  }
  
  public void changeRenderContainerAndPlay(int paramInt)
  {
    Object localObject = (AVPlayerBuilderServiceInterface)this.roomEngine.getService(AVPlayerBuilderServiceInterface.class);
    if (localObject == null) {
      return;
    }
    FrameLayout localFrameLayout = (FrameLayout)getRootView().findViewById(2131435353);
    if (localFrameLayout == null) {
      return;
    }
    ((AVPlayerBuilderServiceInterface)localObject).readyPlay(localFrameLayout, false);
    boolean bool = ((HostProxyInterface)BizEngineMgr.getInstance().getLiveEngine().getService(HostProxyInterface.class)).getSdkInfoInterface().isBackgroundPlay();
    if (((!this.e) || (!bool)) && (paramInt != 3) && (paramInt != 8)) {
      ((AVPlayerBuilderServiceInterface)localObject).pausePlay();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("changeRenderContainerAndPlay mIsAppInBackground = ");
    ((StringBuilder)localObject).append(this.e);
    ((StringBuilder)localObject).append(" isBackgroundPlayEnable = ");
    ((StringBuilder)localObject).append(bool);
    QLog.e("IliveFloatWindowModule", 1, ((StringBuilder)localObject).toString());
  }
  
  protected void jumpAudienceRoomActivity(Runnable paramRunnable)
  {
    if (this.context != null)
    {
      if (!(this.context instanceof Activity)) {
        return;
      }
      b();
      QLog.e("IliveFloatWindowModule", 1, "onWindow click jump");
      IliveLiteDataReport.a().g(c());
      paramRunnable = BusinessManager.a.b();
      if ((BusinessManager.a.e()) && (paramRunnable != null) && (paramRunnable.m != null))
      {
        HashMap localHashMap = paramRunnable.m;
        if (LiveFloatWindowManager.getInstance().appFloatIsShow("FloatWindowComponentImpl")) {
          paramRunnable = "1";
        } else {
          paramRunnable = "0";
        }
        localHashMap.put("is_float_window_in", paramRunnable);
      }
      if ((((Activity)this.context).isFinishing()) && (this.f != null))
      {
        this.context.startActivity(LiveAudience.switchToNewIntent(((Activity)this.context).getIntent(), this.f));
        return;
      }
      paramRunnable = getAudienceRoomPager().getIntent();
      paramRunnable.putExtra("open_from_float_window", true);
      this.context.startActivity(paramRunnable);
    }
  }
  
  public void onActivityStart(LifecycleOwner paramLifecycleOwner)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onActivityStart mIsActivityStart = ");
    localStringBuilder.append(this.c);
    QLog.i("IliveFloatWindowModule", 1, localStringBuilder.toString());
    ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).getLiveModuleStatusListener().a(c());
    if (!this.c) {
      return;
    }
    this.e = false;
    super.onActivityStart(paramLifecycleOwner);
  }
  
  public void onActivityStop(LifecycleOwner paramLifecycleOwner)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onActivityStop mIsActivityStop = ");
    localStringBuilder.append(this.b);
    QLog.i("IliveFloatWindowModule", 1, localStringBuilder.toString());
    ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).getLiveModuleStatusListener().b();
    if (!this.b) {
      return;
    }
    this.e = true;
    if (!LiveFloatWindowManager.getInstance().appFloatIsShow("FloatWindowComponentImpl")) {
      super.onActivityStop(paramLifecycleOwner);
    }
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    getEvent().observe(FloatWindowStateEvent.class, new IliveFloatWindowModule.1(this));
    this.d = ((IliveActivityLifeCycleService)BizEngineMgr.getInstance().getLiveEngine().getService(ActivityLifeCycleService.class));
    BizEngineMgr.getInstance().getLiveEngine().getFloatRoomManager().e();
    IliveLiteEventCenter.a().a(this.h);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.floatWindowComponent != null) && (this.floatWindowComponent.isReallyShow())) {
      a(7);
    }
    IliveLiteEventCenter.a().b(this.h);
  }
  
  public void onSwitchRoom(SwitchRoomInfo paramSwitchRoomInfo)
  {
    this.f = paramSwitchRoomInfo;
  }
  
  public void onVisibleToUser(boolean paramBoolean)
  {
    super.onVisibleToUser(paramBoolean);
    ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).getLiveModuleStatusListener().a(paramBoolean, c());
  }
  
  protected boolean outRoomFloatWindow()
  {
    Object localObject = this.d;
    if ((localObject != null) && (((IliveActivityLifeCycleService)localObject).a() != null))
    {
      localObject = (Activity)this.d.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("outRoomFloatWindow context = ");
      localStringBuilder.append(this.context.hashCode());
      localStringBuilder.append(" isFinish = ");
      localStringBuilder.append(((Activity)this.context).isFinishing());
      QLog.e("IliveFloatWindowModule", 1, localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("outRoomFloatWindow current = ");
      localStringBuilder.append(localObject.hashCode());
      localStringBuilder.append(" isFinish = ");
      localStringBuilder.append(((Activity)localObject).isFinishing());
      QLog.e("IliveFloatWindowModule", 1, localStringBuilder.toString());
      if ((((Activity)this.context).isFinishing()) && (!((Activity)localObject).isFinishing()) && (this.mLifecycleOwner != null)) {
        ((FloatRoomManager.Room)this.mLifecycleOwner).destroyRoomByHand();
      }
      return ((Activity)localObject).isFinishing();
    }
    return super.outRoomFloatWindow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveFloatWindowModule
 * JD-Core Version:    0.7.0.1
 */