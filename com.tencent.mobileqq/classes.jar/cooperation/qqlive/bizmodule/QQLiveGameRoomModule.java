package cooperation.qqlive.bizmodule;

import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ilive.LiveAudience;
import com.tencent.ilive.interfaces.IAudienceRoomPager;
import com.tencent.ilive.interfaces.RoomPageActionInterface;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilive.pages.room.bizmodule.RoomBizModule.InflateComponentTime;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.api.ITimiGameApi;
import com.tencent.timi.game.api.live.BaseGameLiveAudienceView;
import com.tencent.timi.game.api.live.ILiveModuleStatusListener;
import com.tencent.timi.game.api.live.LiveRoomExtraInfo;
import cooperation.ilive.lite.event.IliveLiteEventCenter;
import cooperation.ilive.lite.event.IliveLiteEventCenter.Observer;

public class QQLiveGameRoomModule
  extends QQLiveBaseRoomBizModule
{
  private BaseGameLiveAudienceView a;
  private boolean b = true;
  private IliveLiteEventCenter.Observer c = new QQLiveGameRoomModule.2(this);
  
  private void a(boolean paramBoolean)
  {
    if ((getAudienceRoomPager() != null) && (getAudienceRoomPager().getRoomPageAction() != null))
    {
      getAudienceRoomPager().getRoomPageAction().setRequestedOrientation(paramBoolean);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("callSwitchScreen is null! getAudienceRoomPager():");
    localStringBuilder.append(getAudienceRoomPager());
    QLog.e("QQLiveGameRoomModule", 1, localStringBuilder.toString());
  }
  
  private String i()
  {
    if ((getRoomBizContext() != null) && (getRoomBizContext().getEnterRoomInfo() != null)) {
      return getRoomBizContext().getEnterRoomInfo().preVideoUrl;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getRoomId is null! getRoomBizContext():");
    localStringBuilder.append(getRoomBizContext());
    QLog.e("QQLiveGameRoomModule", 1, localStringBuilder.toString());
    return "";
  }
  
  private LiveRoomExtraInfo j()
  {
    LiveRoomExtraInfo localLiveRoomExtraInfo = new LiveRoomExtraInfo();
    localLiveRoomExtraInfo.b = c();
    localLiveRoomExtraInfo.c = d();
    localLiveRoomExtraInfo.a = e();
    localLiveRoomExtraInfo.d = b();
    localLiveRoomExtraInfo.e = f();
    localLiveRoomExtraInfo.f = g();
    localLiveRoomExtraInfo.g = h();
    return localLiveRoomExtraInfo;
  }
  
  protected RoomBizModule.InflateComponentTime getInflateTime()
  {
    return RoomBizModule.InflateComponentTime.ONCREATE_INFLATE;
  }
  
  public void onActivityCreate(LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityCreate(paramLifecycleOwner);
    ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).getLiveModuleStatusListener().b(a());
    paramLifecycleOwner = this.a;
    if (paramLifecycleOwner != null) {
      paramLifecycleOwner.b();
    }
  }
  
  public void onActivityDestroy(LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityDestroy(paramLifecycleOwner);
    paramLifecycleOwner = this.a;
    if (paramLifecycleOwner != null) {
      paramLifecycleOwner.g();
    }
  }
  
  public void onActivityPause(LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityPause(paramLifecycleOwner);
    paramLifecycleOwner = this.a;
    if (paramLifecycleOwner != null) {
      paramLifecycleOwner.d();
    }
  }
  
  public void onActivityResume(LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityResume(paramLifecycleOwner);
    paramLifecycleOwner = this.a;
    if (paramLifecycleOwner != null) {
      paramLifecycleOwner.e();
    }
  }
  
  public void onActivityStart(LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityStart(paramLifecycleOwner);
    ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).getLiveModuleStatusListener().a(a());
    paramLifecycleOwner = this.a;
    if (paramLifecycleOwner != null) {
      paramLifecycleOwner.c();
    }
  }
  
  public void onActivityStop(LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityStop(paramLifecycleOwner);
    paramLifecycleOwner = this.a;
    if (paramLifecycleOwner != null) {
      paramLifecycleOwner.f();
    }
  }
  
  public boolean onBackPressed()
  {
    return super.onBackPressed();
  }
  
  public void onCreate(Context paramContext)
  {
    this.b = true;
    if ((this.rootView instanceof BaseGameLiveAudienceView)) {
      this.a = ((BaseGameLiveAudienceView)this.rootView);
    }
    Object localObject = this.a;
    if (localObject != null)
    {
      ((BaseGameLiveAudienceView)localObject).setActivityContext(paramContext);
      this.a.setLiveViewListener(new QQLiveGameRoomModule.1(this, paramContext));
      localObject = getAudienceRoomPager();
      if (localObject != null) {
        this.a.setResumeIntent(((IAudienceRoomPager)localObject).getIntent());
      }
    }
    super.onCreate(paramContext);
    IliveLiteEventCenter.a().a(this.c);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    IliveLiteEventCenter.a().b(this.c);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).getLiveModuleStatusListener().a();
    BaseGameLiveAudienceView localBaseGameLiveAudienceView = this.a;
    if (localBaseGameLiveAudienceView != null) {
      localBaseGameLiveAudienceView.a(a(), true, this.b);
    }
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
  }
  
  public void onExitRoom(boolean paramBoolean)
  {
    super.onExitRoom(paramBoolean);
  }
  
  protected void onInitComponentEvent()
  {
    BaseGameLiveAudienceView localBaseGameLiveAudienceView = this.a;
    if (localBaseGameLiveAudienceView != null) {
      localBaseGameLiveAudienceView.a(a(), i());
    }
  }
  
  public void onSwitchRoom(SwitchRoomInfo paramSwitchRoomInfo)
  {
    super.onSwitchRoom(paramSwitchRoomInfo);
    BaseGameLiveAudienceView localBaseGameLiveAudienceView = this.a;
    if (localBaseGameLiveAudienceView != null) {
      localBaseGameLiveAudienceView.setResumeIntent(LiveAudience.switchToNewIntent(((Activity)this.context).getIntent(), paramSwitchRoomInfo));
    }
  }
  
  public void onSwitchScreen(boolean paramBoolean)
  {
    super.onSwitchScreen(paramBoolean);
    BaseGameLiveAudienceView localBaseGameLiveAudienceView = this.a;
    if (localBaseGameLiveAudienceView != null) {
      localBaseGameLiveAudienceView.a(paramBoolean);
    }
  }
  
  public void onVisibleToUser(boolean paramBoolean)
  {
    super.onVisibleToUser(paramBoolean);
    ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).getLiveModuleStatusListener().a(paramBoolean, a());
    BaseGameLiveAudienceView localBaseGameLiveAudienceView = this.a;
    if (localBaseGameLiveAudienceView != null)
    {
      if (paramBoolean)
      {
        localBaseGameLiveAudienceView.a(this.context, a(), j());
        return;
      }
      localBaseGameLiveAudienceView.a(a(), false, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqlive.bizmodule.QQLiveGameRoomModule
 * JD-Core Version:    0.7.0.1
 */