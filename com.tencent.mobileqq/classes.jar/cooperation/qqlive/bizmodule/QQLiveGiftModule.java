package cooperation.qqlive.bizmodule;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.falco.base.libapi.activity.ActivityLifeCycleService;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilive.litepages.room.webmodule.event.SendChatInputEvent;
import com.tencent.ilive.litepages.room.webmodule.event.ShowKeyboardRoomEvent;
import com.tencent.ilive.pages.room.bizmodule.RoomBizModule.InflateComponentTime;
import com.tencent.ilivesdk.roomservice_interface.model.LiveAnchorInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import com.tencent.livesdk.liveengine.LiveEngine;
import com.tencent.livesdk.roomengine.RoomEnginLogic;
import com.tencent.livesdk.roomengine.RoomEngine;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.mvvm.business.anim.GiftAnimData;
import com.tencent.mobileqq.qqgift.mvvm.business.anim.IQQGiftAnimationEngine;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.lite.event.IliveLiteEventCenter;
import cooperation.ilive.lite.event.IliveLiteEventCenter.Observer;
import cooperation.ilive.lite.service.IliveActivityLifeCycleService;
import mqq.app.MobileQQ;

public class QQLiveGiftModule
  extends QQLiveBaseRoomBizModule
{
  private static DisplayMetrics f;
  private IQQGiftSDK a;
  private IQQGiftAnimationEngine b;
  private FrameLayout c;
  private FrameLayout d;
  private boolean e = false;
  private boolean g = false;
  private float h = 0.0F;
  private IliveLiteEventCenter.Observer i = new QQLiveGiftModule.3(this);
  
  public static int a(float paramFloat)
  {
    DisplayMetrics localDisplayMetrics = i();
    if (localDisplayMetrics == null) {
      return (int)paramFloat;
    }
    return (int)(paramFloat * localDisplayMetrics.density + 0.5F);
  }
  
  private void a(@NonNull GiftMessage paramGiftMessage)
  {
    b(paramGiftMessage);
  }
  
  private void b(float paramFloat)
  {
    Object localObject = this.d;
    if ((localObject != null) && (((FrameLayout)localObject).getVisibility() == 0) && (!this.g))
    {
      paramFloat = -paramFloat;
      localObject = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, paramFloat);
      ((TranslateAnimation)localObject).setDuration(100L);
      ((TranslateAnimation)localObject).setRepeatMode(2);
      ((TranslateAnimation)localObject).setFillAfter(true);
      FrameLayout localFrameLayout = this.d;
      if (localFrameLayout != null)
      {
        localFrameLayout.startAnimation((Animation)localObject);
        this.h = paramFloat;
        this.g = true;
      }
    }
  }
  
  private void b(@NonNull GiftMessage paramGiftMessage)
  {
    long l = r();
    if (l != paramGiftMessage.receiver)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addGiftAnimation receiverUin:");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append(",giftMessage.receiverUin:");
      ((StringBuilder)localObject).append(paramGiftMessage.receiver);
      QLog.e("QQLiveGiftModule", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (!this.e) {
      v();
    }
    Object localObject = new GiftAnimData();
    ((GiftAnimData)localObject).a = paramGiftMessage.giftID;
    ((GiftAnimData)localObject).c = paramGiftMessage.giftName;
    ((GiftAnimData)localObject).j = paramGiftMessage.receiverNick;
    ((GiftAnimData)localObject).i = l;
    ((GiftAnimData)localObject).l = paramGiftMessage.receiverHead;
    ((GiftAnimData)localObject).g = paramGiftMessage.sender;
    ((GiftAnimData)localObject).h = paramGiftMessage.senderNick;
    ((GiftAnimData)localObject).k = paramGiftMessage.senderHead;
    ((GiftAnimData)localObject).d = paramGiftMessage.materialID;
    ((GiftAnimData)localObject).m = paramGiftMessage.effectLevel;
    ((GiftAnimData)localObject).e = paramGiftMessage.giftNum;
    ((GiftAnimData)localObject).b = paramGiftMessage.giftType;
    ((GiftAnimData)localObject).o = paramGiftMessage.allComboCnt;
    ((GiftAnimData)localObject).n = paramGiftMessage.comboSeq;
    if (paramGiftMessage.sender == q()) {
      ((GiftAnimData)localObject).f = 100;
    }
    if (t() != null) {
      t().b((GiftAnimData)localObject);
    }
  }
  
  public static DisplayMetrics i()
  {
    if (f == null) {
      try
      {
        if (f == null)
        {
          Object localObject1 = (WindowManager)MobileQQ.sMobileQQ.getSystemService("window");
          if (localObject1 != null)
          {
            localObject1 = ((WindowManager)localObject1).getDefaultDisplay();
            f = new DisplayMetrics();
            ((Display)localObject1).getMetrics(f);
          }
        }
      }
      finally {}
    }
    return f;
  }
  
  private void j()
  {
    getEvent().observe(ShowKeyboardRoomEvent.class, new QQLiveGiftModule.1(this));
    k();
  }
  
  private void k()
  {
    getEvent().observe(SendChatInputEvent.class, new QQLiveGiftModule.2(this));
  }
  
  private void l()
  {
    FrameLayout localFrameLayout = this.c;
    if ((localFrameLayout != null) && (localFrameLayout.getVisibility() == 0)) {
      this.c.setVisibility(4);
    }
  }
  
  private void m()
  {
    FrameLayout localFrameLayout = this.d;
    if ((localFrameLayout != null) && (localFrameLayout.getVisibility() == 0)) {
      this.d.setVisibility(4);
    }
  }
  
  private void n()
  {
    FrameLayout localFrameLayout = this.c;
    if ((localFrameLayout != null) && (localFrameLayout.getVisibility() != 0)) {
      this.c.setVisibility(0);
    }
  }
  
  private void o()
  {
    FrameLayout localFrameLayout = this.d;
    if ((localFrameLayout != null) && (localFrameLayout.getVisibility() != 0)) {
      this.d.setVisibility(0);
    }
  }
  
  private void p()
  {
    this.c = ((FrameLayout)getRootView().findViewById(2131442593));
    this.d = ((FrameLayout)getRootView().findViewById(2131442592));
  }
  
  private long q()
  {
    Object localObject = ((IQQLiveSDKManager)QRoute.api(IQQLiveSDKManager.class)).getSDKImpl("1037");
    if (localObject != null)
    {
      localObject = ((IQQLiveSDK)localObject).getLoginModule();
      if (localObject != null)
      {
        localObject = ((IQQLiveModuleLogin)localObject).getUserInfo();
        if (localObject != null) {
          return ((LiveUserInfo)localObject).uid;
        }
      }
    }
    return 0L;
  }
  
  private long r()
  {
    LiveAnchorInfo localLiveAnchorInfo = s();
    if (localLiveAnchorInfo == null)
    {
      QLog.e("QQLiveGiftModule", 1, "getReceiverUin liveAnchorInfo is null");
      return 0L;
    }
    return localLiveAnchorInfo.uid;
  }
  
  private LiveAnchorInfo s()
  {
    Object localObject = getRoomEngine();
    if (localObject == null)
    {
      QLog.e("QQLiveGiftModule", 1, "getReceiverUin roomEngine is null");
      return null;
    }
    localObject = ((RoomEngine)localObject).getEnginLogic();
    if (localObject == null)
    {
      QLog.e("QQLiveGiftModule", 1, "getReceiverUin enginLogic is null");
      return null;
    }
    localObject = ((RoomEnginLogic)localObject).getLiveInfo();
    if (localObject == null)
    {
      QLog.e("QQLiveGiftModule", 1, "getReceiverUin liveInfo is null");
      return null;
    }
    return ((LiveInfo)localObject).anchorInfo;
  }
  
  private IQQGiftAnimationEngine t()
  {
    if (this.b == null)
    {
      ActivityLifeCycleService localActivityLifeCycleService = (ActivityLifeCycleService)BizEngineMgr.getInstance().getLiveEngine().getService(ActivityLifeCycleService.class);
      if ((localActivityLifeCycleService instanceof IliveActivityLifeCycleService)) {
        this.b = ((IliveActivityLifeCycleService)localActivityLifeCycleService).b();
      }
    }
    return this.b;
  }
  
  private void u()
  {
    try
    {
      FrameLayout localFrameLayout = (FrameLayout)getRootView().findViewById(2131442593);
      if (localFrameLayout != null)
      {
        localObject = localFrameLayout.findViewWithTag("TAG_ANIMATION_FULL_SCREEN_VIEW");
        if (localObject != null) {
          localFrameLayout.removeView((View)localObject);
        }
      }
      localFrameLayout = (FrameLayout)getRootView().findViewById(2131442592);
      if (localFrameLayout != null)
      {
        localObject = localFrameLayout.findViewWithTag("TAG_ANIMATION_BANNER_VIEW");
        if (localObject != null) {
          localFrameLayout.removeView((View)localObject);
        }
      }
      this.e = false;
      return;
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("removeGiftAnimationView throw exception e:");
      ((StringBuilder)localObject).append(localException.getMessage());
      QLog.e("QQLiveGiftModule", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private void v()
  {
    this.e = true;
    try
    {
      View localView;
      if (this.c != null)
      {
        localView = t().e();
        localView.setTag("TAG_ANIMATION_FULL_SCREEN_VIEW");
        this.c.addView(localView, new ViewGroup.LayoutParams(-1, -1));
      }
      if (this.d != null)
      {
        localView = t().f();
        localView.setTag("TAG_ANIMATION_BANNER_VIEW");
        this.d.addView(localView, new ViewGroup.LayoutParams(-1, -1));
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initGiftAnimation throw exception e:");
      localStringBuilder.append(localException.getMessage());
      QLog.e("QQLiveGiftModule", 1, localStringBuilder.toString());
    }
  }
  
  private void w()
  {
    Object localObject = this.d;
    if ((localObject != null) && (((FrameLayout)localObject).getVisibility() == 0) && (this.g))
    {
      localObject = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, this.h, 1, 0.0F);
      ((TranslateAnimation)localObject).setDuration(100L);
      ((TranslateAnimation)localObject).setRepeatMode(2);
      ((TranslateAnimation)localObject).setFillAfter(true);
      FrameLayout localFrameLayout = this.d;
      if (localFrameLayout != null)
      {
        localFrameLayout.startAnimation((Animation)localObject);
        this.h = 0.0F;
        this.g = false;
      }
    }
  }
  
  protected RoomBizModule.InflateComponentTime getInflateTime()
  {
    return RoomBizModule.InflateComponentTime.ENTERROOM_INFLATE;
  }
  
  public void onActivityDestroy(LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityDestroy(paramLifecycleOwner);
    this.a = null;
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    this.a = ((IQQGiftManager)QRoute.api(IQQGiftManager.class)).getSDKImpl(10001);
    this.context = paramContext;
    p();
    IliveLiteEventCenter.a().a(this.i);
    j();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    IliveLiteEventCenter.a().b(this.i);
    if (t() != null) {
      t().g();
    }
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onEnterRoom roomId:");
      localStringBuilder.append(a());
      localStringBuilder.append(", giftSDK:");
      localStringBuilder.append(this.a);
      QLog.d("QQLiveGiftModule", 2, localStringBuilder.toString());
    }
  }
  
  protected void onInitComponentEvent()
  {
    super.onInitComponentEvent();
    v();
  }
  
  public void onVisibleToUser(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("visibleToUser roomId:");
      localStringBuilder.append(a());
      localStringBuilder.append(", isVisibleToUser:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", giftSDK:");
      localStringBuilder.append(this.a);
      QLog.d("QQLiveGiftModule", 2, localStringBuilder.toString());
    }
    if (!paramBoolean)
    {
      t().g();
      u();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqlive.bizmodule.QQLiveGiftModule
 * JD-Core Version:    0.7.0.1
 */