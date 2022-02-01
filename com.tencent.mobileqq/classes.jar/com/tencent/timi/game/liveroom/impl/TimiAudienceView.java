package com.tencent.timi.game.liveroom.impl;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.NonNull;
import com.tencent.av.utils.UITools;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.api.view.IQQGiftViewModule;
import com.tencent.mobileqq.qqgift.mvvm.business.anim.IQQGiftAnimationEngine;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.end.IQQLiveEndView;
import com.tencent.mobileqq.qqlive.api.lottery.IQQLiveLotteryService;
import com.tencent.mobileqq.qqlive.api.room.IAudienceRoom;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage;
import com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener;
import com.tencent.mobileqq.qqlive.callback.lottery.IQQLiveHideLotteryCallback;
import com.tencent.mobileqq.qqlive.callback.room.audience.LiveRoomStatusListener;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveVideoStatus;
import com.tencent.mobileqq.qqlive.data.room.LiveWatchMediaInfo;
import com.tencent.mobileqq.qqlive.data.room.realtime.LiveRealTimeInfo;
import com.tencent.mobileqq.qqlive.listener.supervision.OnKickedOutOfRoomListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.timi.game.api.live.BaseGameLiveAudienceView;
import com.tencent.timi.game.api.live.BaseGameLiveAudienceView.LiveViewListener;
import com.tencent.timi.game.api.live.LiveRoomExtraInfo;
import com.tencent.timi.game.app.event.AudienceFloatCloseEvent;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.datareport.api.ILiveReportService;
import com.tencent.timi.game.gift.impl.timi.TimiGiftEvent;
import com.tencent.timi.game.liveroom.impl.floating.TGLiveFloatManager;
import com.tencent.timi.game.liveroom.impl.inscription.LivingInscriptionInterEntranceView;
import com.tencent.timi.game.liveroom.impl.live.LiveEndViewUtil;
import com.tencent.timi.game.liveroom.impl.live.widget.LiveRoomDisplayView;
import com.tencent.timi.game.liveroom.impl.observable.FollowStatusWrapper;
import com.tencent.timi.game.liveroom.impl.report.TGReportAudienceParamsManager;
import com.tencent.timi.game.liveroom.impl.report.TGReportAudienceParamsManager.Companion;
import com.tencent.timi.game.liveroom.impl.report.TGReportUtil;
import com.tencent.timi.game.liveroom.impl.util.GiftAnimDataUtilKt;
import com.tencent.timi.game.liveroom.impl.view.AnchorMessageLayout;
import com.tencent.timi.game.liveroom.impl.view.AnchorTopAreaView;
import com.tencent.timi.game.liveroom.impl.view.operation.AnchorOperationContainer;
import com.tencent.timi.game.liveroom.impl.widget.AudienceInputBoxView;
import com.tencent.timi.game.liveroom.impl.widget.AudienceOperationBarView;
import com.tencent.timi.game.liveroom.impl.widget.InputReportHelper;
import com.tencent.timi.game.liveroom.impl.widget.LiveDialog;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.CommonExKt;
import com.tencent.timi.game.utils.FloatingPermission;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public class TimiAudienceView
  extends BaseGameLiveAudienceView
  implements SimpleEventReceiver
{
  private IQQLiveEndView A;
  private final LiveRoomDisplayView B = new LiveRoomDisplayView(getContext());
  private IQQGiftAnimationEngine C;
  private final ReceiveGiftMessageListener D = new TimiAudienceView.1(this);
  private OnKickedOutOfRoomListener E = new TimiAudienceView.9(this);
  private ITgLiveRoomService b;
  private IAudienceRoom c;
  private LiveRoomStatusListener d;
  private IQQLiveHideLotteryCallback e;
  private AnchorTopAreaView f;
  private View g;
  private View h;
  private FrameLayout i;
  private FrameLayout j;
  private AnchorMessageLayout k;
  private AudienceOperationBarView l;
  private AudienceInputBoxView m;
  private LivingInscriptionInterEntranceView n;
  private AnchorOperationContainer o;
  private Intent p;
  private FrameLayout q;
  private FrameLayout r;
  private View s;
  private Context t;
  private boolean u = false;
  private String v = "";
  private boolean w = false;
  private long x;
  private LiveRoomExtraInfo y;
  private boolean z = false;
  
  public TimiAudienceView(@NonNull @NotNull Context paramContext)
  {
    super(paramContext);
    h();
  }
  
  public TimiAudienceView(@NonNull @NotNull Context paramContext, @androidx.annotation.Nullable @org.jetbrains.annotations.Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    h();
  }
  
  public TimiAudienceView(@NonNull @NotNull Context paramContext, @androidx.annotation.Nullable @org.jetbrains.annotations.Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    h();
  }
  
  private void a(long paramLong)
  {
    this.c = this.b.e(paramLong);
    IAudienceRoom localIAudienceRoom = this.c;
    if (localIAudienceRoom != null)
    {
      localIAudienceRoom.registerRoomStatusListener(this.d);
      k();
    }
    this.B.a(paramLong, false);
    this.k.a(paramLong, this.c.getRoomLiveInfo().anchorInfo.uid);
    this.m.a(paramLong);
    this.f.a(paramLong, false);
    this.l.a(paramLong, false);
    this.f.setLiveRoomInfo(this.c);
    this.n.a(paramLong, false);
    this.o.a(paramLong, this.y);
    this.n.setLiveRoomInfo(this.c, this.y);
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    SimpleEventBus.getInstance().registerReceiver(this);
    this.m.a(paramLong, this.y);
    this.l.a(paramLong, this.y);
    this.B.a(paramLong, this.y);
    this.l.a(this.y, this.c.getRoomLiveInfo().anchorInfo, paramLong);
    TGReportAudienceParamsManager.a.a().a(paramLong, this.y);
  }
  
  private void a(String paramString, LiveAnchorInfo paramLiveAnchorInfo, LiveRealTimeInfo paramLiveRealTimeInfo)
  {
    this.A = LiveEndViewUtil.a.a(getHostActivity(), this.x, paramString, this.b.d(), this.b.f(), paramLiveAnchorInfo, paramLiveRealTimeInfo, this.y, 2, new TimiAudienceView.13(this, paramLiveAnchorInfo));
    paramString = this.A;
    if ((paramString != null) && (paramString.getView() != null))
    {
      this.j.removeAllViews();
      this.j.addView(this.A.getView(), new FrameLayout.LayoutParams(-1, -1));
      this.j.setVisibility(0);
      LiveEndViewUtil.a.a(this.b.d(), paramLiveAnchorInfo.uid, new TimiAudienceView.14(this));
      return;
    }
    Logger.a("TimiAudienceView", "illegal state: liveEndView is null");
  }
  
  private boolean a(LiveInfo paramLiveInfo)
  {
    boolean bool = false;
    if (paramLiveInfo == null) {
      return false;
    }
    paramLiveInfo = paramLiveInfo.watchMediaInfo;
    if (paramLiveInfo == null) {
      return false;
    }
    if (paramLiveInfo.mVideoStatus == LiveVideoStatus.Stop) {
      bool = true;
    }
    return bool;
  }
  
  private void b(long paramLong)
  {
    this.B.c(paramLong);
    IAudienceRoom localIAudienceRoom = this.c;
    if (localIAudienceRoom != null) {
      localIAudienceRoom.unRegisterRoomStatusListener(this.d);
    }
    this.k.a(paramLong);
    this.m.b();
    this.f.c(paramLong);
    this.l.c(paramLong);
    this.n.c(paramLong);
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  private void b(boolean paramBoolean)
  {
    this.u = paramBoolean;
    if (this.a != null) {
      this.a.a(paramBoolean);
    }
  }
  
  @androidx.annotation.Nullable
  private Activity getHostActivity()
  {
    return CommonExKt.a(this);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void h()
  {
    this.b = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class));
    LayoutInflater.from(getContext()).inflate(2131629439, this);
    setBackgroundResource(2130852881);
    this.f = ((AnchorTopAreaView)findViewById(2131447699));
    this.g = findViewById(2131434233);
    this.h = findViewById(2131446331);
    this.i = ((FrameLayout)findViewById(2131437348));
    this.j = ((FrameLayout)findViewById(2131437350));
    this.l = ((AudienceOperationBarView)findViewById(2131428313));
    this.k = ((AnchorMessageLayout)findViewById(2131428311));
    this.n = ((LivingInscriptionInterEntranceView)findViewById(2131435848));
    this.o = ((AnchorOperationContainer)findViewById(2131428312));
    this.s = findViewById(2131430772);
    this.m = ((AudienceInputBoxView)findViewById(2131428310));
    this.q = ((FrameLayout)findViewById(2131434234));
    this.r = ((FrameLayout)findViewById(2131434236));
    this.m.setClickDelegate(this.s);
    this.l.setFollowStatusObservable(new FollowStatusWrapper());
    this.i.addView(this.B, new FrameLayout.LayoutParams(-1, -1));
    this.j.setOnTouchListener(new TimiAudienceView.2(this));
    this.B.setListener(new TimiAudienceView.3(this));
    this.d = new TimiAudienceView.4(this);
    this.e = new TimiAudienceView.5(this);
    this.l.setAnchorOperationViewListener(new TimiAudienceView.6(this));
    this.m.a(new TimiAudienceView.7(this));
    this.f.setListener(new TimiAudienceView.8(this));
    j();
    TimiAudienceKickOutHelper.a.a(this.E);
  }
  
  private void i()
  {
    TGReportUtil.a.a(0L);
    ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).a(this.x, null);
    Activity localActivity = getHostActivity();
    if (localActivity != null) {
      localActivity.finish();
    }
  }
  
  private void j()
  {
    Object localObject = ((IQQGiftManager)QRoute.api(IQQGiftManager.class)).getSDKImpl(10001);
    if ((((IQQGiftSDK)localObject).a()) && (!((IQQGiftSDK)localObject).k()))
    {
      this.C = ((IQQGiftSDK)localObject).e().a(getContext());
      this.C.a();
      localObject = this.C.f();
      this.q.addView((View)localObject, new RelativeLayout.LayoutParams(-1, -2));
      this.r.addView(this.C.e(), new RelativeLayout.LayoutParams(-1, -2));
    }
  }
  
  private void k()
  {
    IAudienceRoom localIAudienceRoom = this.c;
    if (localIAudienceRoom != null)
    {
      LiveRoomExtraInfo localLiveRoomExtraInfo = this.y;
      if (localLiveRoomExtraInfo != null) {
        localIAudienceRoom.setExtraData(localLiveRoomExtraInfo.g);
      }
    }
  }
  
  private void l()
  {
    b(this.x);
    Logger.a("TimiAudienceView", "onRoomClosed");
    if (this.u) {
      b(false);
    }
    Object localObject1 = this.c;
    BaseRoomInfo localBaseRoomInfo = null;
    if (localObject1 != null) {
      localObject1 = ((IAudienceRoom)localObject1).getRoomLiveInfo();
    } else {
      localObject1 = null;
    }
    if (localObject1 != null) {
      localObject1 = ((LiveInfo)localObject1).anchorInfo;
    } else {
      localObject1 = null;
    }
    Object localObject2 = this.c;
    if (localObject2 != null) {
      localBaseRoomInfo = ((IAudienceRoom)localObject2).getRoomInfo();
    }
    if (localBaseRoomInfo != null) {
      localObject2 = localBaseRoomInfo.getProgramId();
    } else {
      localObject2 = "";
    }
    if (localBaseRoomInfo != null) {
      TGLiveFloatManager.a.a(localBaseRoomInfo.getRoomId(), false);
    }
    this.b.a(this.x, new TimiAudienceView.12(this, (String)localObject2, (LiveAnchorInfo)localObject1));
  }
  
  private boolean m()
  {
    if ((!FloatingPermission.a(getContext())) && (this.B.c()))
    {
      Object localObject = this.t;
      if (localObject != null)
      {
        localObject = new LiveDialog((Context)localObject).a("收起直播需开启悬浮球权限，否则将退出直播").b("去开启").a(new TimiAudienceView.16(this)).c("退出").b(new TimiAudienceView.15(this));
        ((LiveDialog)localObject).setCanceledOnTouchOutside(true);
        ((LiveDialog)localObject).show();
        return true;
      }
      this.a.b(true);
      return true;
    }
    return false;
  }
  
  public void a(long paramLong, @androidx.annotation.Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPagePreLoad roomId: ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" url: ");
    localStringBuilder.append(paramString);
    Logger.a("TimiAudienceView", localStringBuilder.toString());
    this.x = paramLong;
    this.v = paramString;
    if (!this.b.g(paramLong))
    {
      this.b.a(paramLong, paramString);
      this.B.a(paramLong, paramString);
    }
    this.l.a(paramLong, paramString);
    this.f.a(paramLong, paramString);
    this.n.a(paramLong, paramString);
  }
  
  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPageOut ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(paramBoolean2);
    Logger.a("TimiAudienceView", ((StringBuilder)localObject).toString());
    this.B.b(paramLong);
    this.n.b(paramLong);
    this.f.b(paramLong);
    localObject = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).j(paramLong);
    if (localObject != null) {
      ((ILiveRoomMessage)localObject).unRegisterReceiveGiftMessageListener(this.D);
    }
    if ((paramBoolean2) && ((!paramBoolean1) || (!FloatingPermission.a(getContext()))))
    {
      TGLiveFloatManager.a.a(paramLong, false);
      TGReportUtil.a.a(0L);
      this.b.a(paramLong, new TimiAudienceView.11(this));
    }
    if (!paramBoolean1)
    {
      this.b.a(paramLong, this.v);
      this.B.a(paramLong, this.v);
    }
    localObject = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).d();
    if (localObject != null) {
      ((IQQLiveSDK)localObject).getLotteryService().unRegisterHideLottery(this.e);
    }
    b(paramLong);
    this.l.b(paramLong);
    VideoReport.pageLogicDestroy(this);
  }
  
  public void a(Context paramContext, long paramLong, LiveRoomExtraInfo paramLiveRoomExtraInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPageIn ");
    ((StringBuilder)localObject).append(paramLong);
    Logger.a("TimiAudienceView", ((StringBuilder)localObject).toString());
    this.x = paramLong;
    this.y = paramLiveRoomExtraInfo;
    this.m.setRoomId(paramLong);
    InputReportHelper.a.a(paramLong);
    this.B.a(paramLong);
    this.B.setLiveExtraInfo(paramLiveRoomExtraInfo);
    this.n.a(paramLong);
    this.f.a(paramLong);
    if (this.b.g(paramLong))
    {
      a(paramLong);
      ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a(paramContext, this, "pg_qqlive_audience", TGReportUtil.a.a(paramLong, paramLiveRoomExtraInfo));
      paramContext = new StringBuilder();
      paramContext.append("");
      paramContext.append(paramLong);
      VideoReport.setPageContentId(this, paramContext.toString());
    }
    else if (this.z)
    {
      this.c = this.b.e(paramLong);
      l();
    }
    else
    {
      localObject = this.b.h(0L);
      if (localObject != null) {
        TGLiveFloatManager.a.a(((BaseRoomInfo)localObject).getRoomId());
      }
      this.b.a(paramLong, this.w, new TimiAudienceView.10(this, paramLong, paramLiveRoomExtraInfo, paramContext));
    }
    paramContext = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).j(paramLong);
    if (paramContext != null) {
      paramContext.registerReceiveGiftMessageListener(this.D);
    }
    this.l.a(paramLong);
    TGLiveFloatManager.a.b();
    paramContext = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).d();
    if (paramContext != null) {
      paramContext.getLotteryService().registerHideLottery(this.e);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onOrientationChange: ");
    ((StringBuilder)localObject).append(paramBoolean);
    Logger.a("TimiAudienceView", ((StringBuilder)localObject).toString());
    this.m.a(paramBoolean);
    this.f.a(paramBoolean);
    this.n.a(paramBoolean);
    if (paramBoolean)
    {
      this.f.setVisibility(8);
      this.g.setVisibility(8);
      this.m.setVisibility(8);
      this.k.setVisibility(8);
      this.l.setVisibility(8);
      this.o.setVisibility(8);
      this.h.setVisibility(8);
      localObject = (RelativeLayout.LayoutParams)this.i.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = -1;
      ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
      this.i.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    else
    {
      this.m.setVisibility(8);
      this.f.setVisibility(0);
      this.g.setVisibility(0);
      this.k.setVisibility(0);
      this.l.setVisibility(0);
      this.o.setVisibility(0);
      this.h.setVisibility(0);
      localObject = (RelativeLayout.LayoutParams)this.i.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = ((int)UITools.a(getContext(), 210.0F));
      ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)UITools.a(getContext(), 26.0F));
      this.i.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.m.setForbidExpose(paramBoolean);
    this.B.setForbidExpose(paramBoolean ^ true);
    this.B.b(paramBoolean);
  }
  
  public boolean a()
  {
    if (this.B.i()) {
      return true;
    }
    if (this.u)
    {
      b(false);
      return true;
    }
    return m();
  }
  
  public void c()
  {
    super.c();
    this.B.g();
    this.B.a();
  }
  
  public void f()
  {
    super.f();
    this.B.f();
    this.B.b();
    if ((this.B.c()) && (FloatingPermission.a(getContext()))) {
      TGLiveFloatManager.a.a(false, this.p);
    }
  }
  
  public void g()
  {
    super.g();
    this.B.j();
    IQQGiftAnimationEngine localIQQGiftAnimationEngine = this.C;
    if (localIQQGiftAnimationEngine != null) {
      localIQQGiftAnimationEngine.c();
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(TimiGiftEvent.class);
    localArrayList.add(AudienceFloatCloseEvent.class);
    return localArrayList;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    IAudienceRoom localIAudienceRoom = this.c;
    if (localIAudienceRoom != null) {
      localIAudienceRoom.unRegisterRoomStatusListener(this.d);
    }
    TimiAudienceKickOutHelper.a.b(this.E);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof TimiGiftEvent))
    {
      paramSimpleBaseEvent = (TimiGiftEvent)paramSimpleBaseEvent;
      if (this.x != paramSimpleBaseEvent.getRoomId()) {
        return;
      }
      if (this.C != null)
      {
        GiftAnimDataUtilKt.a(paramSimpleBaseEvent.getGiftMsg()).f = 100;
        this.C.b(GiftAnimDataUtilKt.a(paramSimpleBaseEvent.getGiftMsg()));
      }
    }
    else if ((paramSimpleBaseEvent instanceof AudienceFloatCloseEvent))
    {
      paramSimpleBaseEvent = (AudienceFloatCloseEvent)paramSimpleBaseEvent;
      if (this.x != paramSimpleBaseEvent.getRoomId()) {
        return;
      }
      this.a.b(true);
    }
  }
  
  public void setActivityContext(Context paramContext)
  {
    this.t = paramContext;
  }
  
  public void setAutoPlay(boolean paramBoolean)
  {
    this.w = paramBoolean;
  }
  
  public void setResumeIntent(Intent paramIntent)
  {
    this.p = paramIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.TimiAudienceView
 * JD-Core Version:    0.7.0.1
 */