package com.tencent.timi.game.liveroom.impl;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftServiceModule;
import com.tencent.mobileqq.qqgift.api.view.IQQGiftViewModule;
import com.tencent.mobileqq.qqgift.callback.IQQGiftResourceDownloadCallback;
import com.tencent.mobileqq.qqgift.data.service.GiftListData;
import com.tencent.mobileqq.qqgift.mvvm.business.anim.IQQGiftAnimationEngine;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorTRTCRoom;
import com.tencent.mobileqq.qqlive.api.end.IQQLiveEndView;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage;
import com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomConfig;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomGameInfo;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.realtime.LiveRealTimeInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomStatusInfo;
import com.tencent.timi.game.datareport.api.ILiveReportService;
import com.tencent.timi.game.liveroom.impl.floating.TGLiveFloatManager;
import com.tencent.timi.game.liveroom.impl.inscription.LivingInscriptionInterEntranceView;
import com.tencent.timi.game.liveroom.impl.inscription.LivingInscriptionSettingListener;
import com.tencent.timi.game.liveroom.impl.live.AnchorLivePrivacyStateHolder;
import com.tencent.timi.game.liveroom.impl.live.LiveEndViewUtil;
import com.tencent.timi.game.liveroom.impl.report.TGReportUtil;
import com.tencent.timi.game.liveroom.impl.view.AnchorCountDownView;
import com.tencent.timi.game.liveroom.impl.view.AnchorMessageLayout;
import com.tencent.timi.game.liveroom.impl.view.AnchorPrivateGuideView;
import com.tencent.timi.game.liveroom.impl.view.AnchorTopAreaView;
import com.tencent.timi.game.liveroom.impl.widget.AnchorInputBoxView;
import com.tencent.timi.game.liveroom.impl.widget.AnchorOperationBarView;
import com.tencent.timi.game.liveroom.impl.widget.LiveDialog;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.CommonExKt;
import com.tencent.timi.game.utils.FloatingPermission;
import com.tencent.timi.game.utils.Logger;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

public class TimiAnchorView
  extends FrameLayout
{
  private final IQQGiftResourceDownloadCallback a = new TimiAnchorView.1(this);
  private ITgLiveRoomService b;
  private IQQLiveAnchorRoom c;
  private TextView d;
  private AnchorTopAreaView e;
  private FrameLayout f;
  private AnchorCountDownView g;
  private AnchorPrivateGuideView h;
  private View i;
  private AnchorMessageLayout j;
  private AnchorInputBoxView k;
  private AnchorOperationBarView l;
  private LivingInscriptionInterEntranceView m;
  private final LivingInscriptionSettingListener n = new TimiAnchorView.2(this);
  private FrameLayout o;
  private FrameLayout p;
  private IQQGiftAnimationEngine q;
  private final ReceiveGiftMessageListener r = new TimiAnchorView.3(this);
  private boolean s = false;
  private boolean t = false;
  
  public TimiAnchorView(@NonNull @NotNull Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public TimiAnchorView(@NonNull @NotNull Context paramContext, @androidx.annotation.Nullable @org.jetbrains.annotations.Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public TimiAnchorView(@NonNull @NotNull Context paramContext, @androidx.annotation.Nullable @org.jetbrains.annotations.Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private void a(IQQGiftSDK paramIQQGiftSDK)
  {
    GiftListData localGiftListData = new GiftListData(2, String.valueOf(1037), String.valueOf(e()), String.valueOf(this.c.getAnchorRoomInfo().uid));
    paramIQQGiftSDK.d().a(localGiftListData, new TimiAnchorView.9(this, paramIQQGiftSDK));
  }
  
  private void a(QQLiveAnchorRoomInfo paramQQLiveAnchorRoomInfo, LiveRealTimeInfo paramLiveRealTimeInfo)
  {
    Logger.a("TimiAnchorView", "showLiveEndView");
    if ((paramQQLiveAnchorRoomInfo != null) && (paramLiveRealTimeInfo != null))
    {
      paramQQLiveAnchorRoomInfo = LiveEndViewUtil.a.a(getHostActivity(), this.b.d(), paramQQLiveAnchorRoomInfo, paramLiveRealTimeInfo, new TimiAnchorView.15(this));
      if ((paramQQLiveAnchorRoomInfo != null) && (paramQQLiveAnchorRoomInfo.getView() != null))
      {
        this.f.removeAllViews();
        this.f.addView(paramQQLiveAnchorRoomInfo.getView(), new FrameLayout.LayoutParams(-1, -1));
        this.f.setVisibility(0);
        return;
      }
      Logger.a("TimiAnchorView", "showLiveEndView: illegal params");
      paramQQLiveAnchorRoomInfo = getHostActivity();
      if (paramQQLiveAnchorRoomInfo != null) {
        paramQQLiveAnchorRoomInfo.finish();
      }
      return;
    }
    Logger.a("TimiAnchorView", "showLiveEndView: illegal params");
    paramQQLiveAnchorRoomInfo = getHostActivity();
    if (paramQQLiveAnchorRoomInfo != null) {
      paramQQLiveAnchorRoomInfo.finish();
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void c()
  {
    this.b = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class));
    this.c = this.b.c(0L);
    LayoutInflater.from(getContext()).inflate(2131629437, this);
    this.j = ((AnchorMessageLayout)findViewById(2131428311));
    this.k = ((AnchorInputBoxView)findViewById(2131428310));
    View localView = findViewById(2131430772);
    this.k.setClickDelegate(localView);
    this.m = ((LivingInscriptionInterEntranceView)findViewById(2131435848));
    this.f = ((FrameLayout)findViewById(2131437350));
    this.f.setOnTouchListener(new TimiAnchorView.4(this));
    this.l = ((AnchorOperationBarView)findViewById(2131428313));
    this.o = ((FrameLayout)findViewById(2131434234));
    this.p = ((FrameLayout)findViewById(2131434236));
    this.l.setAnchorOperationBarViewListener(new TimiAnchorView.5(this));
    h();
    this.e = ((AnchorTopAreaView)findViewById(2131447699));
    this.e.setListener(new TimiAnchorView.6(this));
    this.g = ((AnchorCountDownView)findViewById(2131437349));
    this.g.setCountDownTimerListener(new TimiAnchorView.7(this));
    this.h = ((AnchorPrivateGuideView)findViewById(2131434473));
    this.i = findViewById(2131434233);
    this.k.a(new TimiAnchorView.8(this));
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a(this.d, false, null, "em_qqlive_livingpic", new HashMap());
    VideoReport.setElementClickPolicy(this.d, ClickPolicy.REPORT_NONE);
    d();
  }
  
  private void d()
  {
    IQQGiftSDK localIQQGiftSDK = ((IQQGiftManager)QRoute.api(IQQGiftManager.class)).getSDKImpl(10001);
    if ((localIQQGiftSDK.a()) && (!localIQQGiftSDK.k()))
    {
      this.q = localIQQGiftSDK.e().a(getContext());
      this.q.a();
      View localView = this.q.f();
      this.o.addView(localView, new RelativeLayout.LayoutParams(-1, -2));
      this.p.addView(this.q.e(), new RelativeLayout.LayoutParams(-1, -2));
      a(localIQQGiftSDK);
    }
  }
  
  private int e()
  {
    IQQLiveAnchorRoom localIQQLiveAnchorRoom = this.c;
    if ((localIQQLiveAnchorRoom != null) && (localIQQLiveAnchorRoom.getAnchorRoomInfo() != null) && (this.c.getAnchorRoomInfo().roomData != null) && (this.c.getAnchorRoomInfo().roomData.gameInfo != null)) {
      return this.c.getAnchorRoomInfo().roomData.gameInfo.id;
    }
    return 0;
  }
  
  private void f()
  {
    Activity localActivity = getHostActivity();
    if (localActivity == null) {
      return;
    }
    new LiveDialog(localActivity).a("确定要结束直播吗？").a(new TimiAnchorView.10(this)).show();
  }
  
  private void g()
  {
    Logger.a("TimiAnchorView", "stopLive");
    Object localObject = this.c;
    if (localObject != null) {
      localObject = ((IQQLiveAnchorRoom)localObject).getAnchorRoomInfo();
    } else {
      localObject = null;
    }
    long l1 = getRoomId();
    TGLiveFloatManager.a.a(l1, false);
    ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).a(new TimiAnchorView.11(this, (QQLiveAnchorRoomInfo)localObject));
    TGReportUtil.a.a(0L);
  }
  
  @androidx.annotation.Nullable
  private Activity getHostActivity()
  {
    return CommonExKt.a(this);
  }
  
  private long getRoomId()
  {
    IQQLiveAnchorRoom localIQQLiveAnchorRoom = this.c;
    if ((localIQQLiveAnchorRoom != null) && (localIQQLiveAnchorRoom.getRoomInfo() != null)) {
      return this.c.getRoomInfo().getRoomId();
    }
    return 0L;
  }
  
  private void h()
  {
    this.d = ((TextView)findViewById(2131447423));
    if ((this.c instanceof IQQLiveAnchorTRTCRoom))
    {
      this.l.setPrivacyVisibility(true);
      this.l.setMicVisibility(true);
      this.l.setPrivacyOn(AnchorLivePrivacyStateHolder.a.a());
      this.l.setMicOn(((IQQLiveAnchorTRTCRoom)this.c).isMicEnable());
    }
    else
    {
      this.l.setPrivacyVisibility(false);
      this.l.setMicVisibility(false);
    }
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = ((IQQLiveAnchorRoom)localObject).getRoomConfig().streamRecordType;
      if (localObject == QQLiveAnchorStreamRecordType.SCREEN)
      {
        if (AnchorLivePrivacyStateHolder.a.a())
        {
          this.d.setText("直播画面已暂停\n尽快恢复别让观众等太久哦");
          return;
        }
        this.d.setText("直播开始啦，手机画面已同步到直播间");
        return;
      }
      if (localObject == QQLiveAnchorStreamRecordType.THIRD_PUSH) {
        this.d.setText("直播开始啦，推流正常");
      }
    }
  }
  
  private void i()
  {
    if ((this.t) && (TextUtils.isEmpty(SharePreferenceUtils.a(getContext(), "TIMI_ANCHOR_PRIVACY_GUIDE_SHOW_FLAG")))) {
      post(new TimiAnchorView.12(this));
    }
  }
  
  private void j()
  {
    if (this.t) {
      post(new TimiAnchorView.13(this));
    }
  }
  
  private void k()
  {
    Object localObject = TimiGameActivityManager.a();
    if (localObject != null)
    {
      localObject = new LiveDialog((Context)localObject).a("收起直播需开启悬浮球权限").b("去开启").a(new TimiAnchorView.14(this)).c("取消");
      ((LiveDialog)localObject).setCanceledOnTouchOutside(true);
      ((LiveDialog)localObject).show();
    }
  }
  
  private Bitmap l()
  {
    Bitmap localBitmap = Bitmap.createBitmap(this.d.getWidth(), this.d.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    this.d.draw(localCanvas);
    return localBitmap;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onEnterRoom ");
    ((StringBuilder)localObject).append(paramLong1);
    Logger.a("TimiAnchorView", ((StringBuilder)localObject).toString());
    this.e.a(paramLong1, true);
    this.e.setLiveRoomInfo(this.c);
    this.j.a(paramLong1, paramLong2);
    this.m.setLiveRoomInfo(paramLong2, paramLong1, e());
    this.l.a(paramLong1);
    this.k.a(paramLong1, null);
    j();
    localObject = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).j(paramLong1);
    if (localObject != null) {
      ((ILiveRoomMessage)localObject).registerReceiveGiftMessageListener(this.r);
    }
    if (this.t)
    {
      TGReportUtil.a.a(true, paramLong1, null);
      TGLiveFloatManager.a.a();
    }
  }
  
  public boolean a()
  {
    Logger.a("TimiAnchorView", "onBackPress ");
    if (findViewById(2131434473).getVisibility() == 0)
    {
      findViewById(2131434473).setVisibility(8);
      return true;
    }
    ITgLiveRoomStatusInfo localITgLiveRoomStatusInfo = this.b.e();
    int i1;
    if ((localITgLiveRoomStatusInfo != null) && (localITgLiveRoomStatusInfo.c())) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((!this.s) && (!FloatingPermission.a(getContext())) && (i1 != 0))
    {
      this.s = true;
      k();
      return true;
    }
    if ((!FloatingPermission.a(getContext())) && (i1 != 0))
    {
      f();
      return true;
    }
    return false;
  }
  
  public void b()
  {
    try
    {
      l1 = this.c.getAnchorRoomInfo().roomData.id;
    }
    catch (Exception localException)
    {
      long l1;
      label19:
      ILiveRoomMessage localILiveRoomMessage;
      break label19;
    }
    Logger.d("TimiAnchorView", "onDestroyView get roomid failed!");
    l1 = 0L;
    this.e.c(l1);
    localILiveRoomMessage = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).j(l1);
    if (localILiveRoomMessage != null) {
      localILiveRoomMessage.unRegisterReceiveGiftMessageListener(this.r);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Logger.a("TGLiveAnchorFloatingView", "TGLiveFloatManager  onAttachedToWindow hideFloatView");
    TGLiveFloatManager.a.b();
  }
  
  protected void onDetachedFromWindow()
  {
    Logger.a("TimiAnchorView", "onDetachedFromWindow ");
    super.onDetachedFromWindow();
    if (this.b.e().c()) {
      TGLiveFloatManager.a.a(true, null);
    } else {
      TGLiveFloatManager.a.a(getRoomId());
    }
    this.m.c(getRoomId());
  }
  
  public void setArgument(Bundle paramBundle)
  {
    if (paramBundle != null) {
      this.t = paramBundle.getBoolean("isStartLive", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.TimiAnchorView
 * JD-Core Version:    0.7.0.1
 */