package com.tencent.timi.game.team.impl.team;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.customview.widget.ViewDragHelper;
import com.tencent.aelight.camera.util.EaseCubicInterpolator;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.ex.LayoutExKt;
import com.tencent.timi.game.gift.impl.timi.GiftLayerBuilder;
import com.tencent.timi.game.gift.impl.timi.TimiGiftController;
import com.tencent.timi.game.image.api.IDrawableService;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.mic.api.IMicService;
import com.tencent.timi.game.room.api.IRoomPage;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomAudioListener;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomCommonListener;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomLifecycleListener;
import com.tencent.timi.game.room.api.wrapper.IRoomAudioService;
import com.tencent.timi.game.room.api.wrapper.IRoomDoOpService;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.room.api.wrapper.IRoomListenerService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.team.impl.chat.TeamChatView;
import com.tencent.timi.game.team.impl.event.ChooseLaneEvent;
import com.tencent.timi.game.team.impl.input.TeamOperateView;
import com.tencent.timi.game.team.impl.main.IWidgetListener;
import com.tencent.timi.game.team.impl.operate.ITeamActionBtn;
import com.tencent.timi.game.team.impl.operate.ITeamMicBtn;
import com.tencent.timi.game.team.impl.operate.ITeamSpeakerBtn;
import com.tencent.timi.game.team.impl.title.TeamTitleView;
import com.tencent.timi.game.userinfo.api.IUserInfoService;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.utils.ThreadPool;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.YoloBattleSmobaOuterClass.YoloSmobaOneSchema;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomConf;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomDataInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSmobaConf;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosInfo;
import trpc.yes.wuji.WujiYoloRoomOuterClass.WujiYoloSmobaRoomConf;

public class TeamContainerView
  extends FrameLayout
  implements IRoomPage
{
  public ImageView a;
  public TeamChatView b;
  private TeamTitleView c;
  private TeamPlayerListView d;
  private TeamOperateView e;
  private View f;
  private RelativeLayout g;
  private ImageView h;
  private FrameLayout i;
  private long j;
  private int k;
  private YoloRoomOuterClass.YoloRoomInfo l;
  private List<IWidgetListener> m = new ArrayList();
  private TeamContainerView.OnDragChangeListener n;
  private CommonOuterClass.QQUserId o;
  private Activity p;
  private ViewDragHelper q;
  private float r;
  private int s;
  private TimiGiftController t;
  private View.OnClickListener u;
  private YoloRoomInterface.YoloRoomCommonListener v = new TeamContainerView.6(this);
  private YoloRoomInterface.YoloRoomAudioListener w = new TeamContainerView.7(this);
  private YoloRoomInterface.YoloRoomLifecycleListener x = new TeamContainerView.8(this);
  
  public TeamContainerView(Context paramContext, YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo, int paramInt)
  {
    super(paramContext);
    if ((paramContext instanceof Activity)) {
      this.p = ((Activity)paramContext);
    }
    a(paramYoloRoomInfo, paramInt);
    f();
  }
  
  public static int a(long paramLong, List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList)
  {
    boolean bool = ((IRoomService)ServiceCenter.a(IRoomService.class)).d(paramLong).a();
    paramLong = ((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (YoloRoomOuterClass.YoloRoomSpeakingPosInfo)localIterator.next();
      if (paramList.uid.get() == paramLong) {
        break label81;
      }
    }
    paramList = null;
    label81:
    int i2 = 1;
    int i1;
    if (paramList != null) {
      i1 = paramList.voice_switch.get();
    } else {
      i1 = 1;
    }
    if (i1 == 3) {
      return i1;
    }
    if (!bool) {
      i2 = 2;
    }
    if (i2 != i1)
    {
      paramList = new StringBuilder();
      paramList.append("getFinalSelfVoiceSwitchType status is not equal! finalSwitchType = ");
      paramList.append(i2);
      paramList.append(", selfSwitchType = ");
      paramList.append(i1);
      Logger.c("GangupRoomMainPageLogic", paramList.toString());
    }
    return i2;
  }
  
  private void a(List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList)
  {
    long l1 = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.j).f();
    int i1 = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.j).i();
    YoloBattleSmobaOuterClass.YoloSmobaOneSchema localYoloSmobaOneSchema = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.j).k();
    this.e.getActionBtn().a(paramList, l1, i1, localYoloSmobaOneSchema, ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.j).j());
  }
  
  private void a(YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo, int paramInt)
  {
    this.k = paramInt;
    this.l = paramYoloRoomInfo;
    this.j = this.l.room_id.get();
    if (this.l.room_data_info.create_from.get() == 1)
    {
      this.o = ((IUserInfoService)ServiceCenter.a(IUserInfoService.class)).b(((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a());
      return;
    }
    if (this.l.room_data_info.create_from.get() == 2) {
      this.o = ((IUserInfoService)ServiceCenter.a(IUserInfoService.class)).a(((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a(), this.l.room_data_info.guild_id.get());
    }
  }
  
  private void b(List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList)
  {
    int i1 = a(this.j, paramList);
    this.e.getMicBtn().a(i1);
    this.e.getSpeakerBtn().a();
  }
  
  private void f()
  {
    ((IReportService)ServiceCenter.a(IReportService.class)).a(this, "pg_yes_smoba_team");
    h();
    i();
    m();
    j();
  }
  
  private void g()
  {
    this.q = ViewDragHelper.create(this, new TeamContainerView.1(this));
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    Activity localActivity = this.p;
    if (localActivity != null)
    {
      localActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      this.s = localDisplayMetrics.heightPixels;
      this.r = (localDisplayMetrics.heightPixels * 0.3F);
    }
  }
  
  private void h()
  {
    inflate(getContext(), 2131629487, this);
  }
  
  private void i()
  {
    this.b = ((TeamChatView)findViewById(2131446892));
    this.c = ((TeamTitleView)findViewById(2131446900));
    this.d = ((TeamPlayerListView)findViewById(2131446895));
    this.e = this.b.getOperateView();
    this.f = findViewById(2131434235);
    this.g = ((RelativeLayout)findViewById(2131446863));
    this.h = ((ImageView)findViewById(2131446893));
    this.i = ((FrameLayout)findViewById(2131446894));
    this.h.setOnClickListener(new TeamContainerView.2(this));
    setClipChildren(false);
    l();
  }
  
  private void j()
  {
    ((IRoomService)ServiceCenter.a(IRoomService.class)).c(getRoomId()).a(this.v);
    ((IRoomService)ServiceCenter.a(IRoomService.class)).c(getRoomId()).a(this.w);
    ((IRoomService)ServiceCenter.a(IRoomService.class)).c(getRoomId()).a(this.x);
  }
  
  private void k()
  {
    ((IRoomService)ServiceCenter.a(IRoomService.class)).c(getRoomId()).b(this.v);
    ((IRoomService)ServiceCenter.a(IRoomService.class)).c(getRoomId()).b(this.w);
    ((IRoomService)ServiceCenter.a(IRoomService.class)).c(getRoomId()).b(this.x);
  }
  
  private void l()
  {
    this.b.a(this.l, this.o, this.k);
    this.b.setMessageListener(new TeamContainerView.3(this));
  }
  
  private void m()
  {
    n();
    this.m.add(this.c);
    this.m.add(this.d);
    this.m.add(this.e);
    Object localObject = this.m.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IWidgetListener)((Iterator)localObject).next()).a(this.l);
    }
    a(((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.j).h());
    ((IRoomService)ServiceCenter.a(IRoomService.class)).c(this.j).a(new TeamContainerView.4(this));
    localObject = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.j).b(((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a());
    if ((localObject != null) && (((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)localObject).voice_switch.get() == 1))
    {
      TeamContainerView.5 local5 = new TeamContainerView.5(this);
      ((IMicService)ServiceCenter.a(IMicService.class)).a(local5);
    }
    if ((localObject != null) && (((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)localObject).leave_status.get() == 1)) {
      ((IRoomService)ServiceCenter.a(IRoomService.class)).b(this.j).a(false, null, null);
    }
  }
  
  private void n()
  {
    YoloRoomOuterClass.YoloRoomConf localYoloRoomConf = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.j).c();
    if (localYoloRoomConf == null) {
      return;
    }
    Object localObject1 = localYoloRoomConf.yolo_room_smoba_conf.yolo_smoba_room_conf.room_background_img_v2.get();
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("team chat view background url == ");
      ((StringBuilder)localObject2).append((String)localObject1);
      Logger.a("TeamContainerView", ((StringBuilder)localObject2).toString());
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = new ColorDrawable(-659729);
      localObject1 = ((IDrawableService)ServiceCenter.a(IDrawableService.class)).a((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
      this.b.setChatViewBackground((Drawable)localObject1);
    }
    else
    {
      this.b.setChatViewBackground(new ColorDrawable(-659729));
    }
    boolean bool = localYoloRoomConf.yolo_room_smoba_conf.yolo_smoba_room_conf.is_use_voice.get();
    this.e.setVoiceEnable(bool);
    this.d.setVoiceEnable(bool);
  }
  
  public void a()
  {
    ViewDragHelper localViewDragHelper = this.q;
    if (localViewDragHelper != null) {
      localViewDragHelper.settleCapturedViewAt(0, 0);
    }
  }
  
  public void a(ChooseLaneEvent paramChooseLaneEvent)
  {
    TeamLaneStateView localTeamLaneStateView = this.d.getHostLaneView();
    if (localTeamLaneStateView == null) {
      return;
    }
    if (this.a == null)
    {
      this.a = new ImageView(getContext());
      this.a.setAlpha(0.6F);
      localObject = new FrameLayout.LayoutParams(LayoutExKt.b(28), LayoutExKt.b(28));
      addView(this.a, (ViewGroup.LayoutParams)localObject);
    }
    Object localObject = new int[2];
    getLocationOnScreen((int[])localObject);
    this.a.setTranslationX(paramChooseLaneEvent.getX() - localObject[0]);
    this.a.setTranslationY(paramChooseLaneEvent.getY() - localObject[1]);
    this.a.setImageResource(paramChooseLaneEvent.getResId());
    float f1 = this.a.getTranslationX();
    float f2 = this.a.getTranslationY();
    int[] arrayOfInt = new int[2];
    localTeamLaneStateView.getLocationOnScreen(arrayOfInt);
    long l1 = paramChooseLaneEvent.getDuration();
    new ObjectAnimator();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.a, "translationX", new float[] { f1, arrayOfInt[0] - localObject[0] + (localTeamLaneStateView.getWidth() - LayoutExKt.b(28)) / 2 });
    localObjectAnimator.setInterpolator(new EaseCubicInterpolator(0.165F, 0.84F, 0.44F, 1.0F));
    localObjectAnimator.setDuration(l1).start();
    new ObjectAnimator();
    localObject = ObjectAnimator.ofFloat(this.a, "translationY", new float[] { f2, arrayOfInt[1] - localObject[1] + (localTeamLaneStateView.getHeight() - LayoutExKt.b(28)) / 2 });
    ((ObjectAnimator)localObject).setInterpolator(new EaseCubicInterpolator(0.165F, 0.84F, 0.44F, 1.0F));
    ((ObjectAnimator)localObject).setDuration(l1).start();
    this.a.setScaleX(1.0F);
    this.a.setScaleY(1.0F);
    new ObjectAnimator();
    localObject = ObjectAnimator.ofFloat(this.a, "scaleX", new float[] { 1.0F, 0.0F });
    ((ObjectAnimator)localObject).setInterpolator(new EaseCubicInterpolator(0.755F, 0.05F, 0.855F, 0.06F));
    long l2 = 'È';
    ((ObjectAnimator)localObject).setDuration(l2);
    long l3 = l1 - l2;
    ((ObjectAnimator)localObject).setStartDelay(l3);
    ((ObjectAnimator)localObject).start();
    new ObjectAnimator();
    localObject = ObjectAnimator.ofFloat(this.a, "scaleY", new float[] { 1.0F, 0.0F });
    ((ObjectAnimator)localObject).setInterpolator(new EaseCubicInterpolator(0.755F, 0.05F, 0.855F, 0.06F));
    ((ObjectAnimator)localObject).setDuration(l2);
    ((ObjectAnimator)localObject).setStartDelay(l3);
    ((ObjectAnimator)localObject).setDuration(l2).start();
    ThreadPool.a(new TeamContainerView.9(this, localTeamLaneStateView, paramChooseLaneEvent), l1);
  }
  
  public boolean b()
  {
    return this.b.a();
  }
  
  public void c()
  {
    this.b.b();
  }
  
  public void computeScroll()
  {
    ViewDragHelper localViewDragHelper = this.q;
    if ((localViewDragHelper != null) && (localViewDragHelper.continueSettling(true))) {
      invalidate();
    }
  }
  
  public void d()
  {
    g();
    this.b.e();
    if (!(getContext() instanceof QBaseActivity)) {
      return;
    }
    QBaseActivity localQBaseActivity = (QBaseActivity)getContext();
    TimiGiftController localTimiGiftController = this.t;
    if (localTimiGiftController != null) {
      localTimiGiftController.a(false);
    }
    this.t = new GiftLayerBuilder(localQBaseActivity).a(10003).a(this.j).a(this.o).b(2).a(localQBaseActivity).a(this.g);
    this.t.a(this.f);
    this.b.a(this.t);
    this.d.a(this.t);
  }
  
  public void e()
  {
    Logger.a("TeamContainerView", "onPageHide()");
    this.b.f();
    ((IRoomService)ServiceCenter.a(IRoomService.class)).b(this.j, this);
    k();
  }
  
  public String getPageName()
  {
    return TeamContainerView.class.getSimpleName();
  }
  
  public long getRoomId()
  {
    return this.j;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.q == null) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    ViewDragHelper localViewDragHelper = this.q;
    TeamTitleView localTeamTitleView = this.c;
    int i1 = (int)f1;
    int i2 = (int)f2;
    if ((!localViewDragHelper.isViewUnder(localTeamTitleView, i1, i2)) && (!this.q.isViewUnder(this.d, i1, i2)) && (!this.q.isViewUnder(this.i, i1, i2))) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if (i1 != 0) {
      return this.q.shouldInterceptTouchEvent(paramMotionEvent);
    }
    this.q.cancel();
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    ViewDragHelper localViewDragHelper = this.q;
    if (localViewDragHelper == null) {
      return super.onTouchEvent(paramMotionEvent);
    }
    localViewDragHelper.processTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setOnCollectClickListener(View.OnClickListener paramOnClickListener)
  {
    this.u = paramOnClickListener;
    this.c.setOnCollectClickListener(paramOnClickListener);
  }
  
  public void setOnDragChangeListener(TeamContainerView.OnDragChangeListener paramOnDragChangeListener)
  {
    this.n = paramOnDragChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.team.TeamContainerView
 * JD-Core Version:    0.7.0.1
 */