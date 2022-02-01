package com.tencent.timi.game.liveroom.impl.live.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.qqlive.api.room.IAudienceRoom;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage;
import com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView;
import com.tencent.mobileqq.qqlive.callback.message.IQQLiveReceiveMessageListener;
import com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData.SpeakerInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.timi.game.api.live.LiveRoomExtraInfo;
import com.tencent.timi.game.component.chat.input.KeyboardUtils;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.datareport.api.ILiveReportService;
import com.tencent.timi.game.live.api.DanmakuChooserView;
import com.tencent.timi.game.live.api.DanmakuChooserView.OnDanmakuTypeChooseListener;
import com.tencent.timi.game.live.api.IDanmaku;
import com.tencent.timi.game.live.api.IGameLiveStatusListener;
import com.tencent.timi.game.live.api.IGameLiveView;
import com.tencent.timi.game.live.api.ILiveGestureListener;
import com.tencent.timi.game.live.api.IVideoPlayer;
import com.tencent.timi.game.live.impl.video.minisdk.MiniSdkLiveView;
import com.tencent.timi.game.liveroom.api.IRoomWidget;
import com.tencent.timi.game.liveroom.api.message.ILiveMsg;
import com.tencent.timi.game.liveroom.impl.live.AnchorDanmakuViewModel;
import com.tencent.timi.game.liveroom.impl.live.MiniSdkVideoPlayer;
import com.tencent.timi.game.liveroom.impl.message.AnchorLiveMsg;
import com.tencent.timi.game.router.IService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.sp.TGSharedPreferenceUtil;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.CommonExKt;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.utils.SystemUiFlagUtil;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/live/widget/LiveRoomDisplayView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/timi/game/liveroom/api/IRoomWidget;", "Landroidx/lifecycle/LifecycleOwner;", "Lcom/tencent/timi/game/live/api/IDanmaku;", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQLiveReceiveMessageListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "activity", "Landroid/app/Activity;", "audienceRoomPlayerListener", "Lcom/tencent/mobileqq/qqlive/callback/room/audience/AudienceRoomPlayerListener;", "callDataLifecycle", "Landroidx/lifecycle/LifecycleRegistry;", "controllerShowing", "", "curVolumeValue", "doToggling", "extraInfo", "Lcom/tencent/timi/game/api/live/LiveRoomExtraInfo;", "gameLiveView", "Lcom/tencent/timi/game/live/api/IGameLiveView;", "iGameLiveStatusListener", "Lcom/tencent/timi/game/live/api/IGameLiveStatusListener;", "isActivityPaused", "isAnchor", "isDanmuOpen", "isDanmuVisible", "()Z", "isGameMute", "isLandscape", "isLiveMutePlay", "isLivePause", "isPageIn", "setPageIn", "(Z)V", "isPlaying", "isSpeakerMuteObserver", "Landroidx/lifecycle/Observer;", "liveRoomService", "Lcom/tencent/timi/game/component/qqlive/api/ITgLiveRoomService;", "liveViewListener", "Lcom/tencent/timi/game/liveroom/impl/live/widget/LiveRoomDisplayView$LiveViewListener;", "loadVideoTimeOutTask", "Ljava/lang/Runnable;", "mAnimListener", "com/tencent/timi/game/liveroom/impl/live/widget/LiveRoomDisplayView$mAnimListener$1", "Lcom/tencent/timi/game/liveroom/impl/live/widget/LiveRoomDisplayView$mAnimListener$1;", "mCollapseRunnable", "mHandler", "Landroid/os/Handler;", "needGestureVolumeControl", "roomId", "", "autoCollapse", "", "bindEvent", "bindReport", "collapse", "topAnimate", "Landroid/view/View;", "bottomAnimate", "collapseView", "containsView", "viewGroup", "Landroid/view/ViewGroup;", "view", "expand", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "hideSystemUI", "injectPlayerView", "it", "mutePlay", "onAttachedToWindow", "onBackPress", "onDanmaStatusChange", "onDanmakuStart", "onDanmakuStop", "onDanmukuDestroy", "onDetachedFromWindow", "onEnterRoom", "onExitRoom", "onLivePause", "onLiveResume", "onMessageReceive", "messageData", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData;", "onMuteStatueChange", "onNewMsg", "msg", "Lcom/tencent/timi/game/liveroom/api/message/ILiveMsg;", "onOrientationChange", "onPageIn", "onPageOut", "onPreload", "videoUrl", "", "onSystemUIChange", "show", "pause", "play", "pushBigDanmaku", "txt", "pushDanmaku", "pushKtvDanmaku", "pushSelfDanmaku", "refreshVolumeIcon", "release", "reportData", "reset", "resume", "setForbidExpose", "forbidExpose", "setListener", "setLiveExtraInfo", "showDanmaku", "showHorUI", "showVerUI", "showVideoController", "showVideoUI", "stop", "Companion", "LiveViewListener", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LiveRoomDisplayView
  extends FrameLayout
  implements LifecycleOwner, IQQLiveReceiveMessageListener, IDanmaku, IRoomWidget
{
  public static final LiveRoomDisplayView.Companion a = new LiveRoomDisplayView.Companion(null);
  private ITgLiveRoomService A;
  private LiveRoomDisplayView.mAnimListener.1 B;
  private HashMap C;
  private Activity b;
  private IGameLiveView c;
  private final LifecycleRegistry d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private Handler m;
  private Runnable n;
  private Runnable o;
  private long p;
  private boolean q;
  private boolean r;
  private boolean s;
  private int t;
  private boolean u;
  private LiveRoomDisplayView.LiveViewListener v;
  private IGameLiveStatusListener w;
  private Observer<Boolean> x;
  private AudienceRoomPlayerListener y;
  private LiveRoomExtraInfo z;
  
  @JvmOverloads
  public LiveRoomDisplayView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public LiveRoomDisplayView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public LiveRoomDisplayView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = (LifecycleOwner)this;
    this.d = new LifecycleRegistry(paramAttributeSet);
    this.e = true;
    this.h = true;
    this.m = new Handler();
    this.n = ((Runnable)new LiveRoomDisplayView.mCollapseRunnable.1(this));
    this.o = ((Runnable)new LiveRoomDisplayView.loadVideoTimeOutTask.1(this));
    this.t = 100;
    IService localIService = ServiceCenter.a(ITgLiveRoomService.class);
    Intrinsics.checkExpressionValueIsNotNull(localIService, "ServiceCenter.getService…eRoomService::class.java)");
    this.A = ((ITgLiveRoomService)localIService);
    this.B = new LiveRoomDisplayView.mAnimListener.1(this);
    this.g = TGSharedPreferenceUtil.b("mute_play_key", false);
    this.h = TGSharedPreferenceUtil.b("dan_mu_key", true);
    LayoutInflater.from(getContext()).inflate(2131629457, (ViewGroup)this);
    ((HorBottomControllerView)a(2131429626)).a(this.h);
    setBackgroundColor(-16777216);
    this.c = ((IGameLiveView)new MiniSdkLiveView(paramContext, null, 0, 6, null));
    this.c.c(false);
    this.c.a(k());
    this.c.setPlayerShouldHoldTouchEvent(true);
    this.c.setVideoPlayer((IVideoPlayer)new MiniSdkVideoPlayer());
    ((FrameLayout)a(2131437348)).addView(this.c.getView(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    if (this.u)
    {
      paramContext = (VolumeView)a(2131434165);
      if (paramContext != null) {
        paramContext.setVisibility(4);
      }
    }
    else
    {
      paramContext = (VolumeView)a(2131434165);
      if (paramContext != null) {
        paramContext.setVisibility(8);
      }
    }
    v();
    paramContext = getContext();
    if (paramContext != null)
    {
      paramContext = paramContext.getResources();
      if (paramContext != null)
      {
        paramContext = paramContext.getConfiguration();
        if (paramContext != null) {
          if (paramContext.orientation == 2)
          {
            this.i = true;
            r();
          }
          else
          {
            s();
            this.i = false;
          }
        }
      }
    }
    AnchorDanmakuViewModel.a.a().observe(paramAttributeSet, (Observer)new LiveRoomDisplayView.2(this));
    ((DanmakuChooserView)a(2131431566)).setOnDanmakuTypeChooseListener((DanmakuChooserView.OnDanmakuTypeChooseListener)new LiveRoomDisplayView.3());
    paramContext = (ImageView)a(2131431574);
    if (this.h) {
      paramInt = 2130852949;
    } else {
      paramInt = 2130852948;
    }
    paramContext.setImageResource(paramInt);
    this.x = ((Observer)new LiveRoomDisplayView.4(this));
    this.w = ((IGameLiveStatusListener)new LiveRoomDisplayView.5(this));
    this.y = ((AudienceRoomPlayerListener)new LiveRoomDisplayView.6(this));
    n();
  }
  
  private final void a(View paramView)
  {
    Object localObject2 = this.c.getView();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof ViewGroup)) {
      localObject1 = null;
    }
    if (!a((ViewGroup)localObject1, paramView))
    {
      paramView.setTag("video_view_tag");
      localObject2 = paramView.getParent();
      localObject1 = localObject2;
      if (!(localObject2 instanceof ViewGroup)) {
        localObject1 = null;
      }
      localObject1 = (ViewGroup)localObject1;
      if (localObject1 != null) {
        ((ViewGroup)localObject1).removeView(paramView);
      }
      localObject2 = this.c.getView();
      localObject1 = localObject2;
      if (!(localObject2 instanceof ViewGroup)) {
        localObject1 = null;
      }
      localObject1 = (ViewGroup)localObject1;
      if (localObject1 != null) {
        ((ViewGroup)localObject1).addView(paramView, 0, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
      }
    }
  }
  
  private final void a(View paramView1, View paramView2)
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    paramView1 = ObjectAnimator.ofFloat(paramView1, "translationY", new float[] { -paramView1.getHeight(), 0.0F });
    paramView2 = ObjectAnimator.ofFloat(paramView2, "translationY", new float[] { paramView2.getHeight(), 0.0F });
    localAnimatorSet.addListener((Animator.AnimatorListener)this.B);
    localAnimatorSet.setInterpolator((TimeInterpolator)new AccelerateInterpolator());
    localAnimatorSet.playTogether(new Animator[] { (Animator)paramView1, (Animator)paramView2 });
    localAnimatorSet.setDuration(150L).start();
  }
  
  private final void a(ILiveMsg paramILiveMsg)
  {
    long l1 = paramILiveMsg.b().mSpeakId;
    Object localObject = ServiceCenter.a(ITgLiveRoomService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…eRoomService::class.java)");
    localObject = ((ITgLiveRoomService)localObject).f();
    if ((localObject != null) && (((LiveUserInfo)localObject).uid == l1))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("msgId: ");
      ((StringBuilder)localObject).append(paramILiveMsg.a());
      Logger.c("LiveRoomDisplayView", ((StringBuilder)localObject).toString());
      this.c.b(paramILiveMsg.c());
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("msgId: ");
    ((StringBuilder)localObject).append(paramILiveMsg.a());
    Logger.c("LiveRoomDisplayView", ((StringBuilder)localObject).toString());
    this.c.a(paramILiveMsg.c());
  }
  
  private final boolean a(ViewGroup paramViewGroup, View paramView)
  {
    if (paramViewGroup != null)
    {
      if (paramView == null) {
        return false;
      }
      int i2 = paramViewGroup.getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        if (Intrinsics.areEqual(paramViewGroup.getChildAt(i1), paramView)) {
          return true;
        }
        i1 += 1;
      }
    }
    return false;
  }
  
  private final void b(View paramView1, View paramView2)
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    paramView1 = ObjectAnimator.ofFloat(paramView1, "translationY", new float[] { 0.0F, -paramView1.getHeight() });
    paramView2 = ObjectAnimator.ofFloat(paramView2, "translationY", new float[] { 0.0F, paramView2.getHeight() });
    localAnimatorSet.addListener((Animator.AnimatorListener)this.B);
    localAnimatorSet.setInterpolator((TimeInterpolator)new AccelerateInterpolator());
    localAnimatorSet.playTogether(new Animator[] { (Animator)paramView1, (Animator)paramView2 });
    localAnimatorSet.setDuration(150L).start();
  }
  
  private final void d(long paramLong)
  {
    if (NetworkUtil.isNetworkAvailable())
    {
      l();
      this.k = true;
      this.c.c(String.valueOf(paramLong));
      this.c.a(k());
      return;
    }
    CustomToastView.a("网络不可用");
    h();
    ((LiveTipsView)a(2131437351)).b();
    ((LiveTipsView)a(2131437351)).c();
  }
  
  private final boolean k()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isDanmakuOpen: ");
    localStringBuilder.append(this.h);
    localStringBuilder.append("; isPlaying: ");
    localStringBuilder.append(this.k);
    localStringBuilder.append("; isLandScape: ");
    localStringBuilder.append(this.i);
    Logger.c("LiveRoomDisplayView", localStringBuilder.toString());
    return (this.h) && (this.k) && (this.i);
  }
  
  private final void l()
  {
    this.m.removeCallbacks(this.n);
    this.m.postDelayed(this.n, 5000L);
  }
  
  private final void m()
  {
    if (this.i)
    {
      localObject = (BottomControllerView)a(2131429625);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "bottomControllerView");
      ((BottomControllerView)localObject).setVisibility(8);
      localObject = (HorBottomControllerView)a(2131429626);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "bottomControllerViewHor");
      ((HorBottomControllerView)localObject).setVisibility(0);
      localObject = (TopControllerView)a(2131447704);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "topControllerView");
      ((TopControllerView)localObject).setVisibility(0);
      return;
    }
    Object localObject = (BottomControllerView)a(2131429625);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "bottomControllerView");
    ((BottomControllerView)localObject).setVisibility(0);
    localObject = (HorBottomControllerView)a(2131429626);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "bottomControllerViewHor");
    ((HorBottomControllerView)localObject).setVisibility(8);
    localObject = (TopControllerView)a(2131447704);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "topControllerView");
    ((TopControllerView)localObject).setVisibility(8);
  }
  
  private final void n()
  {
    ((ImageView)a(2131431574)).setOnClickListener((View.OnClickListener)new LiveRoomDisplayView.bindEvent.1(this));
    ((HorBottomControllerView)a(2131429626)).setLiveMsgEven((ILiveMsgEven)new LiveRoomDisplayView.bindEvent.2(this));
    ((HorBottomControllerView)a(2131429626)).addOnLayoutChangeListener((View.OnLayoutChangeListener)new LiveRoomDisplayView.bindEvent.3(this));
    ((ImageView)a(2131449984)).setOnClickListener((View.OnClickListener)LiveRoomDisplayView.bindEvent.4.a);
    ((ImageView)a(2131430277)).setOnClickListener((View.OnClickListener)new LiveRoomDisplayView.bindEvent.5(this));
    ((ImageView)a(2131445754)).setOnClickListener((View.OnClickListener)new LiveRoomDisplayView.bindEvent.6(this));
    this.c.setVideoRotation(-90);
    this.c.setStatusListener(this.w);
    this.c.setGameLiveGestureListener((ILiveGestureListener)new LiveRoomDisplayView.bindEvent.7(this));
    ((ImageView)a(2131433897)).setOnClickListener((View.OnClickListener)new LiveRoomDisplayView.bindEvent.8(this));
    ((LiveTipsView)a(2131437351)).setListener((LiveTipsView.LiveEndViewListener)new LiveRoomDisplayView.bindEvent.9(this));
    ((ImageView)a(2131435125)).setOnClickListener((View.OnClickListener)new LiveRoomDisplayView.bindEvent.10(this));
  }
  
  private final void o()
  {
    Object localObject1 = (BottomControllerView)a(2131429625);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "bottomControllerView");
    Object localObject2;
    if (((BottomControllerView)localObject1).getVisibility() == 0)
    {
      localObject1 = (TopControllerView)a(2131447704);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "topControllerView");
      localObject1 = (View)localObject1;
      localObject2 = (BottomControllerView)a(2131429625);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "bottomControllerView");
      b((View)localObject1, (View)localObject2);
      localObject1 = (HorBottomControllerView)a(2131429626);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "bottomControllerViewHor");
      localObject2 = (HorBottomControllerView)a(2131429626);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "bottomControllerViewHor");
      ((HorBottomControllerView)localObject1).setTranslationY(((HorBottomControllerView)localObject2).getHeight());
      return;
    }
    localObject1 = (HorBottomControllerView)a(2131429626);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "bottomControllerViewHor");
    if (((HorBottomControllerView)localObject1).getVisibility() == 0)
    {
      localObject1 = (TopControllerView)a(2131447704);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "topControllerView");
      localObject1 = (View)localObject1;
      localObject2 = (HorBottomControllerView)a(2131429626);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "bottomControllerViewHor");
      b((View)localObject1, (View)localObject2);
      localObject1 = (BottomControllerView)a(2131429625);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "bottomControllerView");
      localObject2 = (BottomControllerView)a(2131429625);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "bottomControllerView");
      ((BottomControllerView)localObject1).setTranslationY(((BottomControllerView)localObject2).getHeight());
    }
  }
  
  private final void p()
  {
    Object localObject = CommonExKt.a((View)this);
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getWindow();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "it.window");
      SystemUiFlagUtil.a(((Window)localObject).getDecorView());
    }
  }
  
  private final void q()
  {
    if (this.j)
    {
      ((LiveTipsView)a(2131437351)).a("主播暂时离开一会，千万别走开马上回来");
      m();
      return;
    }
    ((LiveTipsView)a(2131437351)).e();
    m();
  }
  
  private final void r()
  {
    this.i = true;
    q();
    ((HorBottomControllerView)a(2131429626)).c();
    ((TopControllerView)a(2131447704)).setIsVerMode(false);
    this.c.a(k());
  }
  
  private final void s()
  {
    this.i = false;
    q();
    ((HorBottomControllerView)a(2131429626)).b();
    ((TopControllerView)a(2131447704)).setIsVerMode(true);
    this.c.a(k());
    ((DanmakuChooserView)a(2131431566)).a((LifecycleOwner)this, false);
    LiveRoomDisplayView.LiveViewListener localLiveViewListener = this.v;
    if (localLiveViewListener != null) {
      localLiveViewListener.b(true);
    }
  }
  
  private final void t()
  {
    this.h ^= true;
    ((HorBottomControllerView)a(2131429626)).a(this.h);
    TGSharedPreferenceUtil.a("dan_mu_key", this.h);
    this.c.a(k());
    ImageView localImageView = (ImageView)a(2131431574);
    int i1;
    if (this.h) {
      i1 = 2130852949;
    } else {
      i1 = 2130852948;
    }
    localImageView.setImageResource(i1);
  }
  
  private final void u()
  {
    if (!this.k) {
      return;
    }
    this.g ^= true;
    TGSharedPreferenceUtil.a("mute_play_key", this.g);
    this.c.b(this.g);
    v();
  }
  
  private final void v()
  {
    int i1;
    if (this.t <= 50) {
      i1 = 2130853140;
    } else {
      i1 = 2130853139;
    }
    ImageView localImageView = (ImageView)a(2131449984);
    if (this.g) {
      i1 = 2130853138;
    }
    localImageView.setImageResource(i1);
  }
  
  private final void w()
  {
    Object localObject2 = (Map)new HashMap();
    if (this.i) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    ((Map)localObject2).put("qqlive_screen_orientation", localObject1);
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a((View)this, false, null, "em_qqlive_livingpic", (Map)localObject2);
    VideoReport.setElementClickPolicy(this, ClickPolicy.REPORT_NONE);
    Object localObject1 = (Map)new HashMap();
    ((Map)localObject1).put("qqlive_ver_hori_location", "0");
    ((Map)localObject1).put("qqlive_screen_orientation", "1");
    localObject2 = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
    ImageView localImageView = (ImageView)a(2131435125);
    Intrinsics.checkExpressionValueIsNotNull(localImageView, "horBack");
    ((ILiveReportService)localObject2).a((View)localImageView, false, null, "em_qqlive_ver_to_hori", (Map)localObject1);
    localObject1 = (Map)new HashMap();
    ((Map)localObject1).put("zengzhi_moduleid", "em_qqlive_livingpic");
    localObject2 = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
    localImageView = (ImageView)a(2131433897);
    Intrinsics.checkExpressionValueIsNotNull(localImageView, "fullScreen");
    ((ILiveReportService)localObject2).a((View)localImageView, false, null, "em_qqlive_horizontal", (Map)localObject1);
  }
  
  public View a(int paramInt)
  {
    if (this.C == null) {
      this.C = new HashMap();
    }
    View localView2 = (View)this.C.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.C.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public void a()
  {
    this.c.a();
  }
  
  public void a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPageIn: ");
    localStringBuilder.append(paramLong);
    Logger.a("LiveRoomDisplayView", localStringBuilder.toString());
    this.p = paramLong;
    this.r = true;
    this.c.a();
  }
  
  public final void a(long paramLong, @Nullable LiveRoomExtraInfo paramLiveRoomExtraInfo)
  {
    ((HorBottomControllerView)a(2131429626)).a(paramLong, paramLiveRoomExtraInfo);
  }
  
  public void a(long paramLong, @Nullable String paramString)
  {
    paramString = new StringBuilder();
    paramString.append("onPreload: ");
    paramString.append(paramLong);
    Logger.a("LiveRoomDisplayView", paramString.toString());
    this.p = paramLong;
    paramString = this.A.a(paramLong);
    if (paramString != null) {
      paramString.unRegisterRoomPlayerListener(this.y);
    }
    paramString = this.A.a(paramLong);
    if (paramString != null) {
      paramString.registerRoomPlayerListener(this.y);
    }
    paramString = this.A.a(paramLong);
    if (paramString != null)
    {
      paramString = (ITPPlayerVideoView)paramString.getDisplayView();
      if (paramString != null)
      {
        paramString = paramString.getCurrentDisplayView();
        if (paramString != null) {
          a(paramString);
        }
      }
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onEnterRoom: ");
    ((StringBuilder)localObject).append(paramLong);
    Logger.a("LiveRoomDisplayView", ((StringBuilder)localObject).toString());
    this.p = paramLong;
    this.q = paramBoolean;
    ((TopControllerView)a(2131447704)).a(paramLong, paramBoolean);
    ((BottomControllerView)a(2131429625)).setIsAnchor(paramBoolean);
    ((HorBottomControllerView)a(2131429626)).setIsAnchor(paramBoolean);
    localObject = this.A.j(paramLong);
    if (localObject != null) {
      ((ILiveRoomMessage)localObject).unRegisterRoomChatMsgListener((IQQLiveReceiveMessageListener)this);
    }
    localObject = this.A.j(paramLong);
    if (localObject != null) {
      ((ILiveRoomMessage)localObject).registerRoomChatMsgListener((IQQLiveReceiveMessageListener)this);
    }
    localObject = this.A.a(paramLong);
    if (localObject != null) {
      ((IAudienceRoom)localObject).unRegisterRoomPlayerListener(this.y);
    }
    localObject = this.A.a(paramLong);
    if (localObject != null) {
      ((IAudienceRoom)localObject).registerRoomPlayerListener(this.y);
    }
    if (paramBoolean)
    {
      localObject = this.A.a();
      if (localObject != null)
      {
        Intrinsics.checkExpressionValueIsNotNull(localObject, "it");
        a((View)localObject);
      }
    }
    else
    {
      localObject = this.A.b();
      if (localObject != null)
      {
        localObject = ((ITPPlayerVideoView)localObject).getCurrentDisplayView();
        if (localObject != null) {
          a((View)localObject);
        }
      }
    }
    d(paramLong);
    q();
    w();
  }
  
  public void a(@Nullable LiveMessageData paramLiveMessageData)
  {
    if (paramLiveMessageData == null) {
      Logger.c("LiveRoomDisplayView", "onReceive null msg");
    }
    if (paramLiveMessageData != null) {
      a((ILiveMsg)new AnchorLiveMsg(paramLiveMessageData));
    }
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "txt");
    this.c.a(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    this.c.a(paramBoolean);
  }
  
  public void b()
  {
    this.c.b();
  }
  
  public void b(long paramLong)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onPageOut: ");
    ((StringBuilder)localObject1).append(paramLong);
    Logger.a("LiveRoomDisplayView", ((StringBuilder)localObject1).toString());
    h();
    int i1 = 0;
    this.r = false;
    ((LiveTipsView)a(2131437351)).b();
    ((LiveTipsView)a(2131437351)).d();
    ((LiveTipsView)a(2131437351)).e();
    Object localObject2 = this.c.getView();
    localObject1 = localObject2;
    if (!(localObject2 instanceof ViewGroup)) {
      localObject1 = null;
    }
    localObject2 = (ViewGroup)localObject1;
    if (localObject2 != null)
    {
      int i2 = ((ViewGroup)localObject2).getChildCount();
      while (i1 < i2)
      {
        View localView = ((ViewGroup)localObject2).getChildAt(i1);
        if (localView != null) {
          localObject1 = localView.getTag();
        } else {
          localObject1 = null;
        }
        if (Intrinsics.areEqual(localObject1, "video_view_tag")) {
          ((ViewGroup)localObject2).removeView(localView);
        }
        i1 += 1;
      }
    }
  }
  
  public void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "txt");
    this.c.b(paramString);
  }
  
  public final void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      r();
      return;
    }
    s();
  }
  
  public void c(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onExitRoom: ");
    ((StringBuilder)localObject).append(paramLong);
    Logger.a("LiveRoomDisplayView", ((StringBuilder)localObject).toString());
    ((TopControllerView)a(2131447704)).a(paramLong);
    localObject = this.A.a(paramLong);
    if (localObject != null) {
      ((IAudienceRoom)localObject).unRegisterRoomPlayerListener(this.y);
    }
    localObject = this.A.j(paramLong);
    if (localObject != null) {
      ((ILiveRoomMessage)localObject).unRegisterRoomChatMsgListener((IQQLiveReceiveMessageListener)this);
    }
  }
  
  public final boolean c()
  {
    return this.r;
  }
  
  public final void d()
  {
    this.j = true;
    q();
  }
  
  public final void e()
  {
    this.j = false;
    q();
  }
  
  public final void f()
  {
    this.l = true;
    if ((this.k) && (this.r)) {
      this.c.d(String.valueOf(this.p));
    }
  }
  
  public final void g()
  {
    this.l = false;
    if ((this.k) && (this.r))
    {
      Object localObject;
      if (this.q)
      {
        localObject = this.A.a();
        if (localObject != null)
        {
          Intrinsics.checkExpressionValueIsNotNull(localObject, "it");
          a((View)localObject);
        }
      }
      else
      {
        localObject = this.A.b();
        if (localObject != null)
        {
          localObject = ((ITPPlayerVideoView)localObject).getCurrentDisplayView();
          if (localObject != null) {
            a((View)localObject);
          }
        }
      }
      this.c.e(String.valueOf(this.p));
    }
    if ((((HorBottomControllerView)a(2131429626)).getInputState() == 1) && (SystemUiFlagUtil.a(getResources()))) {
      p();
    }
  }
  
  @NotNull
  public Lifecycle getLifecycle()
  {
    return (Lifecycle)this.d;
  }
  
  public final void h()
  {
    this.k = false;
    this.c.f(String.valueOf(this.p));
    this.c.a(k());
  }
  
  public final boolean i()
  {
    return false;
  }
  
  public void j() {}
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.d.setCurrentState(Lifecycle.State.STARTED);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.r = false;
    this.d.setCurrentState(Lifecycle.State.DESTROYED);
    Object localObject = this.b;
    if (localObject != null) {
      KeyboardUtils.a(((Activity)localObject).getWindow());
    }
    this.c.a(this.w);
    this.c.setGameLiveEventListener(null);
    this.c.setGameLiveGestureListener(null);
    ((FrameLayout)a(2131437348)).removeView(this.c.getView());
    localObject = this.A.a(this.p);
    if (localObject != null) {
      ((IAudienceRoom)localObject).unRegisterRoomPlayerListener(this.y);
    }
    localObject = this.A.j(this.p);
    if (localObject != null) {
      ((ILiveRoomMessage)localObject).unRegisterRoomChatMsgListener((IQQLiveReceiveMessageListener)this);
    }
    this.m.removeCallbacks(this.o);
    this.m.removeCallbacks(this.n);
    this.b = ((Activity)null);
  }
  
  public final void setForbidExpose(boolean paramBoolean)
  {
    ((HorBottomControllerView)a(2131429626)).setForbidExpose(paramBoolean);
  }
  
  public final void setListener(@NotNull LiveRoomDisplayView.LiveViewListener paramLiveViewListener)
  {
    Intrinsics.checkParameterIsNotNull(paramLiveViewListener, "liveViewListener");
    this.v = paramLiveViewListener;
  }
  
  public final void setLiveExtraInfo(@NotNull LiveRoomExtraInfo paramLiveRoomExtraInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramLiveRoomExtraInfo, "extraInfo");
    this.z = paramLiveRoomExtraInfo;
  }
  
  public final void setPageIn(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.live.widget.LiveRoomDisplayView
 * JD-Core Version:    0.7.0.1
 */