package com.tencent.timi.game.live.impl.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.timi.game.live.api.IGameLiveEventListener;
import com.tencent.timi.game.live.api.IGameLiveStatusListener;
import com.tencent.timi.game.live.api.IGameLiveView;
import com.tencent.timi.game.live.api.ILiveGestureListener;
import com.tencent.timi.game.live.api.IVideoPlayer;
import com.tencent.timi.game.live.api.LivePlayStatus;
import com.tencent.timi.game.live.impl.WifiOr4GStateHolder;
import com.tencent.timi.game.live.impl.danmuku.EsportsDanmakuView;
import com.tencent.timi.game.live.impl.danmuku.IEsportsDanmaku;
import com.tencent.timi.game.live.impl.danmuku.IEsportsDanmaku.DefaultImpls;
import com.tencent.timi.game.ui.widget.CommonButton;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.utils.NetEventManager;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/live/impl/video/GameLiveView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/timi/game/live/api/IGameLiveView;", "Landroidx/lifecycle/LifecycleOwner;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "curGestureStatus", "getCurGestureStatus", "()I", "setCurGestureStatus", "(I)V", "curLivePlayStatus", "curUrl", "", "curVolume", "danmakuView", "Lcom/tencent/timi/game/live/impl/danmuku/IEsportsDanmaku;", "eventListener", "Lcom/tencent/timi/game/live/api/IGameLiveEventListener;", "getEventListener", "()Lcom/tencent/timi/game/live/api/IGameLiveEventListener;", "setEventListener", "(Lcom/tencent/timi/game/live/api/IGameLiveEventListener;)V", "gameLiveStatusListener", "Lcom/tencent/timi/game/live/api/IGameLiveStatusListener;", "getGameLiveStatusListener", "()Lcom/tencent/timi/game/live/api/IGameLiveStatusListener;", "setGameLiveStatusListener", "(Lcom/tencent/timi/game/live/api/IGameLiveStatusListener;)V", "gestureDetector", "Landroid/view/GestureDetector;", "isMiniWindow", "", "isPlayerInited", "Ljava/util/concurrent/atomic/AtomicBoolean;", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "liveGestureListener", "Lcom/tencent/timi/game/live/api/ILiveGestureListener;", "getLiveGestureListener", "()Lcom/tencent/timi/game/live/api/ILiveGestureListener;", "setLiveGestureListener", "(Lcom/tencent/timi/game/live/api/ILiveGestureListener;)V", "maxVolume", "netInfoHandler", "Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;", "shouldHoldTouchEvent", "touchSlop", "bindWifiStatusTip", "", "checkNetWorkState", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "getPlayerStatus", "getView", "Landroid/view/View;", "hide4GTips", "initDanmakuView", "initTouchListener", "miniWindow", "mutePlay", "mute", "onAttachedToWindow", "onDanmakuStart", "onDanmakuStop", "onDanmukuDestroy", "onDetachedFromWindow", "pause", "url", "play", "pushBigDanmaku", "txt", "pushDanmaku", "pushKtvDanmaku", "pushSelfDanmaku", "release", "removeStatusListener", "liveStatusListener", "requestSizeChange", "resume", "setGameLiveEventListener", "gameLiveEventListener", "setGameLiveGestureListener", "setLiveVolume", "volume", "setPlayerShouldHoldTouchEvent", "holderByPlayer", "setStatus", "status", "setStatusListener", "setVideoPlayer", "player", "Lcom/tencent/timi/game/live/api/IVideoPlayer;", "setVideoRotation", "degree", "show4GTips", "showDanmaku", "show", "stop", "takeSnapshot", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract class GameLiveView
  extends FrameLayout
  implements LifecycleOwner, IGameLiveView
{
  public static final GameLiveView.Companion a = new GameLiveView.Companion(null);
  private int b;
  private GestureDetector c;
  private int d;
  private final LifecycleRegistry e = new LifecycleRegistry((LifecycleOwner)this);
  private final int f = 100;
  private int g = 50;
  private int h = LivePlayStatus.a;
  @Nullable
  private IGameLiveStatusListener i;
  @Nullable
  private IGameLiveEventListener j;
  @Nullable
  private ILiveGestureListener k;
  private boolean l = true;
  private boolean m;
  private AtomicBoolean n = new AtomicBoolean(false);
  private IEsportsDanmaku o;
  private INetInfoHandler p;
  private String q = "";
  private HashMap r;
  
  @JvmOverloads
  public GameLiveView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public GameLiveView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public GameLiveView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(getContext()).inflate(2131629459, (ViewGroup)this);
    paramContext = ViewConfiguration.get(getContext());
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "ViewConfiguration.get(getContext())");
    this.d = paramContext.getScaledTouchSlop();
    this.c = new GestureDetector(getContext(), (GestureDetector.OnGestureListener)new GameLiveView.1(this));
    this.p = ((INetInfoHandler)new GameLiveView.2(this));
    h();
    c();
    d();
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private final void c()
  {
    setOnTouchListener((View.OnTouchListener)new GameLiveView.initTouchListener.1(this));
  }
  
  private final void d()
  {
    if (this.m) {
      return;
    }
    if (this.o != null) {
      return;
    }
    Object localObject = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    localObject = new EsportsDanmakuView((Context)localObject, null, 0, 6, null);
    ((EsportsDanmakuView)localObject).a();
    addView((View)localObject, 0);
    this.o = ((IEsportsDanmaku)localObject);
  }
  
  private final void e()
  {
    LinearLayout localLinearLayout = (LinearLayout)a(2131431220);
    Intrinsics.checkExpressionValueIsNotNull(localLinearLayout, "confirmContainer");
    localLinearLayout.setVisibility(0);
  }
  
  private final void f()
  {
    LinearLayout localLinearLayout = (LinearLayout)a(2131431220);
    Intrinsics.checkExpressionValueIsNotNull(localLinearLayout, "confirmContainer");
    localLinearLayout.setVisibility(8);
  }
  
  private final void g()
  {
    WifiOr4GStateHolder localWifiOr4GStateHolder = WifiOr4GStateHolder.a;
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    if (!localWifiOr4GStateHolder.a(localContext))
    {
      Logger.a("GameLiveView", "don't play in 4G");
      d(this.q);
      postDelayed((Runnable)new GameLiveView.checkNetWorkState.1(this), 300L);
      return;
    }
    Logger.a("GameLiveView", "play in 4G");
    f();
  }
  
  private final void h()
  {
    ((CommonButton)a(2131447404)).setOnClickListener((View.OnClickListener)new GameLiveView.bindWifiStatusTip.1(this));
    ((TextView)a(2131446508)).setOnClickListener((View.OnClickListener)new GameLiveView.bindWifiStatusTip.2(this));
    ((LinearLayout)a(2131431220)).setOnClickListener((View.OnClickListener)GameLiveView.bindWifiStatusTip.3.a);
  }
  
  public View a(int paramInt)
  {
    if (this.r == null) {
      this.r = new HashMap();
    }
    View localView2 = (View)this.r.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.r.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public void a()
  {
    IEsportsDanmaku localIEsportsDanmaku = this.o;
    if (localIEsportsDanmaku != null) {
      localIEsportsDanmaku.c();
    }
  }
  
  public void a(@Nullable IGameLiveStatusListener paramIGameLiveStatusListener)
  {
    if (Intrinsics.areEqual(this.i, paramIGameLiveStatusListener)) {
      this.i = ((IGameLiveStatusListener)null);
    }
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "txt");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("push normal danmaku: ");
    ((StringBuilder)localObject).append(paramString);
    Logger.b("GameLiveView", ((StringBuilder)localObject).toString());
    localObject = this.o;
    if (localObject != null)
    {
      Context localContext = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      IEsportsDanmaku.DefaultImpls.a((IEsportsDanmaku)localObject, localContext, paramString, getResources().getColor(2131168464), 0, 8, null);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showDanmaku call ");
    ((StringBuilder)localObject).append(paramBoolean);
    Logger.a("GameLiveView", ((StringBuilder)localObject).toString());
    if (paramBoolean)
    {
      localObject = this.o;
      if (localObject != null) {
        ((IEsportsDanmaku)localObject).e();
      }
    }
    else
    {
      localObject = this.o;
      if (localObject != null) {
        ((IEsportsDanmaku)localObject).f();
      }
    }
  }
  
  public void b()
  {
    IEsportsDanmaku localIEsportsDanmaku = this.o;
    if (localIEsportsDanmaku != null) {
      localIEsportsDanmaku.d();
    }
  }
  
  public void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "txt");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("push self normal danmaku: ");
    ((StringBuilder)localObject).append(paramString);
    Logger.b("GameLiveView", ((StringBuilder)localObject).toString());
    localObject = this.o;
    if (localObject != null)
    {
      Context localContext = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      IEsportsDanmaku.DefaultImpls.b((IEsportsDanmaku)localObject, localContext, paramString, getResources().getColor(2131168464), 0, 8, null);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mutePlay call ");
    localStringBuilder.append(paramBoolean);
    Logger.a("GameLiveView", localStringBuilder.toString());
  }
  
  public void c(@Nullable String paramString)
  {
    Logger.a("GameLiveView", "play call ");
    this.q = paramString;
    WifiOr4GStateHolder localWifiOr4GStateHolder = WifiOr4GStateHolder.a;
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    if (!localWifiOr4GStateHolder.a(localContext))
    {
      f(paramString);
      e();
      return;
    }
    f();
    setStatus(LivePlayStatus.b);
  }
  
  public void c(boolean paramBoolean)
  {
    this.m = paramBoolean;
    if (this.m)
    {
      localLinearLayout = (LinearLayout)a(2131431223);
      Intrinsics.checkExpressionValueIsNotNull(localLinearLayout, "confirmTipContainer");
      localLinearLayout.setVisibility(8);
      localLinearLayout = (LinearLayout)a(2131431220);
      Intrinsics.checkExpressionValueIsNotNull(localLinearLayout, "confirmContainer");
      localLinearLayout.setClickable(false);
      return;
    }
    LinearLayout localLinearLayout = (LinearLayout)a(2131431223);
    Intrinsics.checkExpressionValueIsNotNull(localLinearLayout, "confirmTipContainer");
    localLinearLayout.setVisibility(0);
    localLinearLayout = (LinearLayout)a(2131431220);
    Intrinsics.checkExpressionValueIsNotNull(localLinearLayout, "confirmContainer");
    localLinearLayout.setClickable(false);
  }
  
  public void d(@Nullable String paramString)
  {
    setStatus(LivePlayStatus.c);
    Logger.a("GameLiveView", "pause call ");
  }
  
  public void e(@Nullable String paramString)
  {
    setStatus(LivePlayStatus.e);
    Logger.a("GameLiveView", "resume call ");
    WifiOr4GStateHolder localWifiOr4GStateHolder = WifiOr4GStateHolder.a;
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    if (!localWifiOr4GStateHolder.a(localContext))
    {
      f(paramString);
      e();
      return;
    }
    f();
  }
  
  public void f(@Nullable String paramString)
  {
    setStatus(LivePlayStatus.d);
    Logger.a("GameLiveView", "stop call ");
  }
  
  protected final int getCurGestureStatus()
  {
    return this.b;
  }
  
  @Nullable
  public final IGameLiveEventListener getEventListener()
  {
    return this.j;
  }
  
  @Nullable
  protected final IGameLiveStatusListener getGameLiveStatusListener()
  {
    return this.i;
  }
  
  @NotNull
  public Lifecycle getLifecycle()
  {
    return (Lifecycle)this.e;
  }
  
  @Nullable
  public final ILiveGestureListener getLiveGestureListener()
  {
    return this.k;
  }
  
  public int getPlayerStatus()
  {
    return this.h;
  }
  
  @NotNull
  public View getView()
  {
    return (View)this;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    setVideoRotation(-90);
    this.e.setCurrentState(Lifecycle.State.CREATED);
    NetEventManager.a().a(this.p);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.e.setCurrentState(Lifecycle.State.DESTROYED);
    Object localObject = this.o;
    if (localObject != null)
    {
      localObject = ((IEsportsDanmaku)localObject).getView();
      if (localObject != null) {
        removeView((View)localObject);
      }
    }
    this.o = ((IEsportsDanmaku)null);
    NetEventManager.a().b(this.p);
  }
  
  protected final void setCurGestureStatus(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final void setEventListener(@Nullable IGameLiveEventListener paramIGameLiveEventListener)
  {
    this.j = paramIGameLiveEventListener;
  }
  
  public void setGameLiveEventListener(@Nullable IGameLiveEventListener paramIGameLiveEventListener)
  {
    this.j = paramIGameLiveEventListener;
  }
  
  public void setGameLiveGestureListener(@Nullable ILiveGestureListener paramILiveGestureListener)
  {
    this.k = paramILiveGestureListener;
  }
  
  protected final void setGameLiveStatusListener(@Nullable IGameLiveStatusListener paramIGameLiveStatusListener)
  {
    this.i = paramIGameLiveStatusListener;
  }
  
  public final void setLiveGestureListener(@Nullable ILiveGestureListener paramILiveGestureListener)
  {
    this.k = paramILiveGestureListener;
  }
  
  public void setLiveVolume(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setPlayerShouldHoldTouchEvent(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void setStatus(int paramInt)
  {
    if (paramInt != this.h) {
      post((Runnable)new GameLiveView.setStatus.1(this, paramInt));
    }
  }
  
  public void setStatusListener(@Nullable IGameLiveStatusListener paramIGameLiveStatusListener)
  {
    this.i = paramIGameLiveStatusListener;
  }
  
  public void setVideoPlayer(@NotNull IVideoPlayer paramIVideoPlayer)
  {
    Intrinsics.checkParameterIsNotNull(paramIVideoPlayer, "player");
  }
  
  public void setVideoRotation(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.video.GameLiveView
 * JD-Core Version:    0.7.0.1
 */