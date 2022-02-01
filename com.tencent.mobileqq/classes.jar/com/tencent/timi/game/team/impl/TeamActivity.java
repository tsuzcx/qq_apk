package com.tencent.timi.game.team.impl;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.base.TimiGameBaseActivity;
import com.tencent.timi.game.component.chat.at.FamilyAtFunction;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.float_window.impl.animate.WorldScaleLayout;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.SimpleYoloRoomCommonListener;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.room.api.wrapper.IRoomListenerService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.team.impl.chat.TeamChatView;
import com.tencent.timi.game.team.impl.event.ChooseLaneEvent;
import com.tencent.timi.game.team.impl.event.TeamExitEvent;
import com.tencent.timi.game.team.impl.floating.TeamFloatingView;
import com.tencent.timi.game.team.impl.floating.TeamFloatingView.Companion;
import com.tencent.timi.game.team.impl.main.TeamUtil;
import com.tencent.timi.game.team.impl.team.TeamContainerView;
import com.tencent.timi.game.test.api.ITimiGameTestService;
import com.tencent.timi.game.ui.pag.TimiPAGResourceLoader;
import com.tencent.timi.game.ui.utils.CommonAnimationUtil.SlideUpAnimation;
import com.tencent.timi.game.userinfo.api.IUserInfoService;
import com.tencent.timi.game.utils.FloatingPermission;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.utils.StatusBarUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosInfo;

public class TeamActivity
  extends TimiGameBaseActivity
  implements View.OnClickListener, SimpleEventReceiver, FamilyAtFunction
{
  private View a;
  private WorldScaleLayout b;
  private RelativeLayout c;
  private TeamContainerView d;
  private ValueAnimator e;
  private ValueAnimator f;
  private YoloRoomOuterClass.YoloRoomInfo g;
  private int h;
  private int i;
  private boolean j = false;
  private SimpleYoloRoomCommonListener k = new TeamActivity.10(this);
  
  public static void a(Context paramContext, YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startActivity - ");
    ((StringBuilder)localObject).append(paramInt);
    Logger.a("TeamActivity", ((StringBuilder)localObject).toString());
    localObject = new Intent(paramContext, TeamActivity.class);
    ((Intent)localObject).putExtra("room_info", paramYoloRoomInfo.toByteArray());
    ((Intent)localObject).putExtra("open_from", paramInt);
    if (!(paramContext instanceof Activity)) {
      ((Intent)localObject).addFlags(268435456);
    }
    paramContext.startActivity((Intent)localObject);
  }
  
  private void a(List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList)
  {
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      paramList = (YoloRoomOuterClass.YoloRoomSpeakingPosInfo)paramList.next();
      if (paramList.uid.get() == ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.g.room_id.get()).f()) {
        ((IUserInfoService)ServiceCenter.a(IUserInfoService.class)).a(paramList.uid.get(), new TeamActivity.11(this, paramList));
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (FloatingPermission.a(this))
    {
      if (paramBoolean)
      {
        this.b.a();
        return;
      }
      o();
      return;
    }
    TeamUtil.b(TimiGameActivityManager.a(), this.d.getRoomId());
  }
  
  private static void b(View paramView, float paramFloat)
  {
    if (paramView != null)
    {
      paramView = paramView.getBackground();
      if (paramView != null) {
        paramView.setAlpha((int)(paramFloat * 255.0F));
      }
    }
  }
  
  public static void e()
  {
    Logger.a("TeamActivity", "hideActivity");
    SimpleEventBus.getInstance().dispatchEvent(new TeamExitEvent());
  }
  
  private void f()
  {
    TimiPAGResourceLoader.a.a("https://cdn.yes.qq.com/client_business/tg_team_wave.pag", null);
    TimiPAGResourceLoader.a.a("https://cdn.yes.qq.com/client_business/tg_smoba_icon.pag", null);
  }
  
  private void g()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      this.h = ((Intent)localObject).getIntExtra("open_from", 0);
      int m = this.h;
      this.i = m;
      if (m == 5) {
        this.h = 4;
      }
      localObject = ((Intent)localObject).getByteArrayExtra("room_info");
      if ((localObject != null) && (localObject.length != 0))
      {
        YoloRoomOuterClass.YoloRoomInfo localYoloRoomInfo = new YoloRoomOuterClass.YoloRoomInfo();
        try
        {
          this.g = ((YoloRoomOuterClass.YoloRoomInfo)localYoloRoomInfo.mergeFrom((byte[])localObject));
          return;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
      }
    }
  }
  
  private void h()
  {
    this.a = findViewById(2131446864);
    this.c = ((RelativeLayout)findViewById(2131446911));
    j();
    this.b = ((WorldScaleLayout)findViewById(2131446959));
  }
  
  private void i()
  {
    this.a.setOnClickListener(this);
    this.b.setWorldScaleListener(new TeamActivity.2(this));
    ((IRoomService)ServiceCenter.a(IRoomService.class)).c(this.g.room_id.get()).a(this.k);
  }
  
  private void j()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(3, 2131446864);
    this.d = new TeamContainerView(this, this.g, this.h);
    if (DeviceInfoUtil.S()) {
      this.d.setLayerType(0, null);
    }
    this.d.setOnCollectClickListener(new TeamActivity.3(this));
    this.d.setOnDragChangeListener(new TeamActivity.4(this));
    this.c.addView(this.d, localLayoutParams);
  }
  
  private void k()
  {
    this.mActNeedImmersive = false;
    StatusBarUtil.b(getWindow());
  }
  
  private void l()
  {
    TeamContainerView localTeamContainerView = this.d;
    if ((localTeamContainerView != null) && (!this.j))
    {
      this.j = true;
      localTeamContainerView.e();
    }
    TeamFloatingView.a.a(false);
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    ((IRoomService)ServiceCenter.a(IRoomService.class)).c(this.g.room_id.get()).b(this.k);
    finish();
  }
  
  private void m()
  {
    RelativeLayout localRelativeLayout = this.c;
    if (localRelativeLayout != null) {
      localRelativeLayout.setVisibility(4);
    }
    this.d.setVisibility(4);
    this.e = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.e.setInterpolator(CommonAnimationUtil.SlideUpAnimation.a);
    this.e.setDuration(500L);
    this.e.addUpdateListener(new TeamActivity.5(this));
    this.e.addListener(new TeamActivity.6(this));
    this.d.post(new TeamActivity.7(this));
  }
  
  private void n()
  {
    RelativeLayout localRelativeLayout = this.c;
    if (localRelativeLayout != null) {
      localRelativeLayout.setVisibility(0);
    }
    this.d.setVisibility(0);
    this.d.setTranslationY(0.0F);
    this.d.setTranslationX(0.0F);
    b(this.c, 1.0F);
    this.d.d();
  }
  
  private void o()
  {
    if (this.d == null)
    {
      Logger.c("TeamActivity", "showHideAnimation error: mTeamContainerView == null");
      finish();
      return;
    }
    if (this.e != null)
    {
      Logger.c("TeamActivity", "showHideAnimation error: showAnim.cancel");
      this.e.cancel();
    }
    if (this.f != null)
    {
      Logger.c("TeamActivity", "showHideAnimation error: hideAnim != null");
      return;
    }
    this.f = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.f.setInterpolator(CommonAnimationUtil.SlideUpAnimation.b);
    float f1 = this.d.getHeight();
    this.f.setDuration(500L);
    this.f.addUpdateListener(new TeamActivity.8(this, f1));
    this.f.addListener(new TeamActivity.9(this, f1));
    this.f.start();
  }
  
  public EditText c()
  {
    TeamContainerView localTeamContainerView = this.d;
    if ((localTeamContainerView != null) && (localTeamContainerView.b != null)) {
      return this.d.b.c();
    }
    return null;
  }
  
  public TimiBaseInputView dJ_()
  {
    TeamContainerView localTeamContainerView = this.d;
    if ((localTeamContainerView != null) && (localTeamContainerView.b != null)) {
      return this.d.b.dJ_();
    }
    return null;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnBackPressed()
  {
    Logger.a("TeamActivity", "dismissWithPermission from back Pressed");
    a(true);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    Logger.a("TeamActivity", "doOnCreate");
    SimpleEventBus.getInstance().registerReceiver(this);
    k();
    boolean bool = super.doOnCreate(paramBundle);
    g();
    if (this.g == null)
    {
      Logger.c("TeamActivity", "start team Activity failed, room info is null");
      finish();
      return bool;
    }
    StatusBarUtil.b(getWindow());
    setContentView(2131629492);
    ((ITimiGameTestService)ServiceCenter.a(ITimiGameTestService.class)).a(findViewById(16908290));
    h();
    i();
    f();
    TeamFloatingView.a.b(false);
    TeamFloatingView.a.a(true);
    a(((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.g.room_id.get()).h());
    ((IReportService)ServiceCenter.a(IReportService.class)).a(this, "pg_yes_smoba_team");
    return bool;
  }
  
  protected void doOnDestroy()
  {
    Logger.a("TeamActivity", "TeamActivity has destroyed");
    super.doOnDestroy();
    l();
  }
  
  protected boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      TeamContainerView localTeamContainerView = this.d;
      if (localTeamContainerView == null) {
        return super.doOnKeyDown(paramInt, paramKeyEvent);
      }
      if (localTeamContainerView.b())
      {
        this.d.c();
        return true;
      }
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    if (this.c.getVisibility() == 4)
    {
      if (this.i == 4)
      {
        this.b.post(new TeamActivity.1(this));
        return;
      }
      ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.g.room_id.get(), this.d);
      m();
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(TeamExitEvent.class);
    localArrayList.add(ChooseLaneEvent.class);
    return localArrayList;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131446864)
    {
      TeamContainerView localTeamContainerView = this.d;
      if ((localTeamContainerView != null) && (localTeamContainerView.b()))
      {
        this.d.c();
      }
      else
      {
        a(true);
        Logger.a("TeamActivity", "dismissWithPermission from mask click");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof TeamExitEvent)) {
      o();
    }
    if ((paramSimpleBaseEvent instanceof ChooseLaneEvent)) {
      this.d.a((ChooseLaneEvent)paramSimpleBaseEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.TeamActivity
 * JD-Core Version:    0.7.0.1
 */