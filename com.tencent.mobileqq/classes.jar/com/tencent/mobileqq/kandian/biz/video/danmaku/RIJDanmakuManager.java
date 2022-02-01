package com.tencent.mobileqq.kandian.biz.video.danmaku;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import com.tencent.common.danmaku.core.DanmakuManager.IDanmakuListener;
import com.tencent.common.danmaku.data.BaseDanmaku;
import com.tencent.common.danmaku.inject.DanmakuContext;
import com.tencent.common.danmaku.inject.DanmakuContext.Builder;
import com.tencent.common.danmaku.inject.IDanmakuCreator;
import com.tencent.common.danmaku.inject.IDanmakuExposureCallback;
import com.tencent.common.danmaku.inject.IDanmakuPlayTimeSupplier;
import com.tencent.common.danmaku.inject.IDanmakuUIConfig;
import com.tencent.common.danmaku.inject.IDanmakuUIConfigCreator;
import com.tencent.common.danmaku.inject.IDanmakuWindowCreator;
import com.tencent.common.danmaku.inject.VideoDanmakuConfig;
import com.tencent.common.danmaku.inject.WindowConfig;
import com.tencent.common.danmaku.render.BaseDanmakuRender;
import com.tencent.common.danmaku.tool.ClickResult;
import com.tencent.common.danmaku.tool.DanmakuDrawTimer;
import com.tencent.common.danmaku.tool.TouchPoint;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.video.danmaku.ext.DanmakuManagerExt;
import com.tencent.mobileqq.kandian.biz.video.danmaku.model.RIJDanmakuModel;
import com.tencent.mobileqq.kandian.biz.video.danmaku.model.RIJDanmakuModel.Callback;
import com.tencent.mobileqq.kandian.biz.video.danmaku.render.RIJBaseDanmaku;
import com.tencent.mobileqq.kandian.biz.video.danmaku.render.RIJDanmakuCreator;
import com.tencent.mobileqq.kandian.biz.video.danmaku.render.RIJDanmakuRender;
import com.tencent.mobileqq.kandian.biz.video.danmaku.render.RIJDanmakuUIConfigCreator;
import com.tencent.mobileqq.kandian.biz.video.danmaku.render.RIJDanmakuWindowCreator;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/RIJDanmakuManager;", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/IDanmakuManager;", "Lcom/tencent/common/danmaku/core/DanmakuManager$IDanmakuListener;", "Landroid/view/View$OnTouchListener;", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/model/RIJDanmakuModel$Callback;", "context", "Landroid/content/Context;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "useTextureView", "", "config", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/RIJDanmakuConfig;", "callback", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/DanmakuEventCallback;", "(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;ZLcom/tencent/mobileqq/kandian/biz/video/danmaku/RIJDanmakuConfig;Lcom/tencent/mobileqq/kandian/biz/video/danmaku/DanmakuEventCallback;)V", "getApp", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "getCallback", "()Lcom/tencent/mobileqq/kandian/biz/video/danmaku/DanmakuEventCallback;", "setCallback", "(Lcom/tencent/mobileqq/kandian/biz/video/danmaku/DanmakuEventCallback;)V", "cancelClickRunnable", "Ljava/lang/Runnable;", "clickEnable", "clickingDanmaku", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/render/RIJBaseDanmaku;", "getClickingDanmaku", "()Lcom/tencent/mobileqq/kandian/biz/video/danmaku/render/RIJBaseDanmaku;", "setClickingDanmaku", "(Lcom/tencent/mobileqq/kandian/biz/video/danmaku/render/RIJBaseDanmaku;)V", "container", "Landroid/view/ViewGroup;", "getContext", "()Landroid/content/Context;", "value", "", "currentAuthorUin", "getCurrentAuthorUin", "()Ljava/lang/String;", "setCurrentAuthorUin", "(Ljava/lang/String;)V", "danmaViewMarginTop", "", "danmakuContext", "Lcom/tencent/common/danmaku/inject/DanmakuContext;", "danmakuManager", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/ext/DanmakuManagerExt;", "danmakuUIConfigCreator", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/render/RIJDanmakuUIConfigCreator;", "danmakuView", "Landroid/view/View;", "handler", "Landroid/os/Handler;", "hasDanmaku", "lastGetPositionTime", "", "lastPlayPositon", "model", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/model/RIJDanmakuModel;", "needShowOpenText", "openGuideTask", "openText", "seeked", "touchRect", "Landroid/graphics/Rect;", "touchView", "videoHeight", "videoPlayer", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/IPlayer;", "addDanmakuNow", "", "data", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/DanmakuDetail;", "addDanmakus", "list", "", "attachContainer", "calculateTouchRect", "calculateViewHeight", "cancelClick", "changeConfig", "newConfig", "changeLayoutOrientaion", "isVertical", "clear", "clickDanmaku", "danmaku", "createDanmakuView", "destroy", "getDanmakuType", "info", "getVisibility", "hide", "innerSeek", "position", "isGuideDanmaku", "isInDanmakuRange", "event", "Landroid/view/MotionEvent;", "location", "", "isOpenGuideOutTime", "isSeeked", "curPosition", "loadData", "rowkey", "startPosition", "onClickEvent", "Lcom/tencent/common/danmaku/data/BaseDanmaku;", "touchPoint", "Lcom/tencent/common/danmaku/tool/TouchPoint;", "clickResult", "Lcom/tencent/common/danmaku/tool/ClickResult;", "onDanmakuClicked", "onDanmaku", "onDanmakuDrawFinish", "danmakuList", "", "", "Lcom/tencent/common/danmaku/inject/IDanmakuUIConfig;", "onDanmakuExposure", "onDanmakuMesureFinish", "onGetData", "reportInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/ReportInfo;", "Lkotlin/collections/ArrayList;", "sendDanmakuForbid", "clearData", "danmakuCount", "onGetPlayPosition", "onReportBtnClick", "onTouch", "v", "pause", "reloadConfig", "restart", "seekTo", "setDanmakuTouchArea", "marginTop", "setDanmakuViewMarginTop", "topMargin", "setDisableSync", "forceVsync", "(Ljava/lang/Boolean;)V", "setPlayer", "player", "setSpeedRatio", "speed", "", "setUseUiTime", "show", "showOpenGuide", "text", "start", "stop", "unclickDanmauku", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJDanmakuManager
  implements View.OnTouchListener, DanmakuManager.IDanmakuListener, IDanmakuManager, RIJDanmakuModel.Callback
{
  private static int D;
  public static final RIJDanmakuManager.Companion a = new RIJDanmakuManager.Companion(null);
  private final boolean A;
  private RIJDanmakuConfig B;
  @Nullable
  private DanmakuEventCallback C;
  private final DanmakuManagerExt b;
  private IPlayer c;
  private final View d;
  private final RIJDanmakuModel e;
  private final DanmakuContext f;
  private final RIJDanmakuUIConfigCreator g;
  private final View h;
  private boolean i;
  private long j;
  private long k;
  private Rect l;
  private int m;
  private int n;
  private Handler o;
  private boolean p;
  private boolean q;
  private ViewGroup r;
  private String s;
  private boolean t;
  private Runnable u;
  private Runnable v;
  @NotNull
  private String w;
  @Nullable
  private RIJBaseDanmaku x;
  @NotNull
  private final Context y;
  @NotNull
  private final QQAppInterface z;
  
  public RIJDanmakuManager(@NotNull Context paramContext, @NotNull QQAppInterface paramQQAppInterface, boolean paramBoolean, @NotNull RIJDanmakuConfig paramRIJDanmakuConfig, @Nullable DanmakuEventCallback paramDanmakuEventCallback)
  {
    this.y = paramContext;
    this.z = paramQQAppInterface;
    this.A = paramBoolean;
    this.B = paramRIJDanmakuConfig;
    this.C = paramDanmakuEventCallback;
    this.o = new Handler();
    this.p = true;
    this.s = "";
    this.t = true;
    this.v = ((Runnable)new RIJDanmakuManager.cancelClickRunnable.1(this));
    this.w = "";
    VideoDanmakuConfig.a(true);
    this.g = new RIJDanmakuUIConfigCreator(this.B);
    b(this.B);
    this.d = p();
    paramContext = DanmakuContext.k().a((IDanmakuPlayTimeSupplier)new RIJDanmakuManager.1(this)).a(-4).a((IDanmakuUIConfigCreator)this.g).a((BaseDanmakuRender)new RIJDanmakuRender(this.y)).a((IDanmakuCreator)new RIJDanmakuCreator(this.d)).a((IDanmakuExposureCallback)new RIJDanmakuManager.2(this)).a((IDanmakuWindowCreator)new RIJDanmakuWindowCreator()).b(Math.max(3, this.B.a())).a();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "DanmakuContext.newBuilde…nt))\n            .build()");
    this.f = paramContext;
    this.b = new DanmakuManagerExt(this.d, this.f);
    this.b.a((DanmakuManager.IDanmakuListener)this);
    this.b.b(true);
    this.b.a(false);
    paramContext = this.d;
    if ((paramContext instanceof SurfaceView)) {
      ((SurfaceView)paramContext).setZOrderOnTop(true);
    }
    this.d.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-1, -1));
    this.e = new RIJDanmakuModel(this.z, (RIJDanmakuModel.Callback)this);
    this.h = new View(this.y);
    this.h.setOnTouchListener((View.OnTouchListener)this);
    RIJDanmakuManager.Companion.a(a);
    D += 1;
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("config: ");
      paramContext.append(this.B);
      paramContext.append(", useTextureView=");
      paramContext.append(this.A);
      paramContext.append(", miniHeight=");
      paramContext.append(n());
      paramContext.append(", DANMAKU_COUNT=");
      paramContext.append(D);
      QLog.d("RIJDanmakuManager", 2, paramContext.toString());
    }
  }
  
  private final void a(BaseDanmaku<Object, IDanmakuUIConfig> paramBaseDanmaku)
  {
    Object localObject;
    if (!(paramBaseDanmaku instanceof RIJBaseDanmaku)) {
      localObject = null;
    } else {
      localObject = paramBaseDanmaku;
    }
    if ((RIJBaseDanmaku)localObject != null)
    {
      localObject = this.C;
      if (localObject != null)
      {
        paramBaseDanmaku = (DanmakuDetail)((RIJBaseDanmaku)paramBaseDanmaku).r();
        Intrinsics.checkExpressionValueIsNotNull(paramBaseDanmaku, "danmaku.data");
        ((DanmakuEventCallback)localObject).onDanmakuExposure(paramBaseDanmaku);
      }
    }
  }
  
  private final void a(RIJBaseDanmaku paramRIJBaseDanmaku)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReportBtnClick: danmaku=");
      ((StringBuilder)localObject).append(paramRIJBaseDanmaku);
      QLog.d("RIJDanmakuManager", 2, ((StringBuilder)localObject).toString());
    }
    this.p = false;
    this.o.removeCallbacks(this.v);
    Object localObject = this.C;
    if (localObject != null)
    {
      paramRIJBaseDanmaku = (DanmakuDetail)paramRIJBaseDanmaku.r();
      Intrinsics.checkExpressionValueIsNotNull(paramRIJBaseDanmaku, "danmaku.data");
      ((DanmakuEventCallback)localObject).onClickReport(paramRIJBaseDanmaku);
    }
  }
  
  private final void a(String paramString, List<DanmakuDetail> paramList)
  {
    this.u = ((Runnable)null);
    boolean bool = q();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showOpenGuide: out of time ");
      localStringBuilder.append(bool);
      QLog.d("RIJDanmakuManager", 2, localStringBuilder.toString());
    }
    if (bool)
    {
      b(paramList);
      return;
    }
    a(new DanmakuDetail(new DanmakuInfo("danmukaipin", 0, 0, paramString, this.B.i(), ""), new UserInfo("")));
    this.o.postDelayed((Runnable)new RIJDanmakuManager.showOpenGuide.1(this, paramList), this.B.j());
  }
  
  private final boolean a(long paramLong)
  {
    return Math.abs(paramLong - this.j) > 3;
  }
  
  private final boolean a(MotionEvent paramMotionEvent, int[] paramArrayOfInt)
  {
    float f1 = paramMotionEvent.getRawX();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (f1 > paramArrayOfInt[0])
    {
      bool1 = bool2;
      if (paramMotionEvent.getRawX() < paramArrayOfInt[0] + this.d.getWidth())
      {
        bool1 = bool2;
        if (paramMotionEvent.getRawY() > paramArrayOfInt[1])
        {
          bool1 = bool2;
          if (paramMotionEvent.getRawY() < paramArrayOfInt[1] + this.d.getHeight()) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private final int b(DanmakuDetail paramDanmakuDetail)
  {
    if ((Intrinsics.areEqual(paramDanmakuDetail.b().a(), this.w)) && (Intrinsics.areEqual(paramDanmakuDetail.b().a(), RIJQQAppInterfaceUtil.d()))) {
      return 20;
    }
    if (Intrinsics.areEqual(paramDanmakuDetail.b().a(), this.w)) {
      return 19;
    }
    if (Intrinsics.areEqual(paramDanmakuDetail.b().a(), RIJQQAppInterfaceUtil.d())) {
      return 18;
    }
    return 17;
  }
  
  private final void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("innerSeek: position=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("RIJDanmakuManager", 2, ((StringBuilder)localObject).toString());
    }
    this.b.b(paramInt * 1000);
    Object localObject = this.e;
    ((RIJDanmakuModel)localObject).a(((RIJDanmakuModel)localObject).a(), paramInt);
  }
  
  private final void b(RIJDanmakuConfig paramRIJDanmakuConfig)
  {
    this.B = paramRIJDanmakuConfig;
    WindowConfig localWindowConfig = DanmakuContext.a();
    Intrinsics.checkExpressionValueIsNotNull(localWindowConfig, "windowConfig");
    localWindowConfig.a(this.B.a());
    localWindowConfig.c((int)this.B.d());
    float f1 = 2;
    localWindowConfig.c(f1);
    localWindowConfig.b(f1);
    localWindowConfig.b(10);
    localWindowConfig.a(this.B.b() / f1);
    localWindowConfig.d((int)this.B.c() / 2);
    localWindowConfig.b(true);
    localWindowConfig.d(true);
    localWindowConfig.g(0.0F);
    localWindowConfig.f(0.0F);
    this.g.a(paramRIJDanmakuConfig);
  }
  
  private final void b(RIJBaseDanmaku paramRIJBaseDanmaku)
  {
    paramRIJBaseDanmaku.h();
    paramRIJBaseDanmaku.f(false);
    this.b.a((BaseDanmaku)paramRIJBaseDanmaku);
    if (this.b.y()) {
      this.b.z();
    }
    this.o.removeCallbacks(this.v);
  }
  
  private final void c(RIJBaseDanmaku paramRIJBaseDanmaku)
  {
    paramRIJBaseDanmaku.f();
    paramRIJBaseDanmaku.f(true);
    this.b.a((BaseDanmaku)paramRIJBaseDanmaku);
    if (this.b.y()) {
      this.b.z();
    }
    this.o.postDelayed(this.v, this.B.h() * 1000L);
    DanmakuEventCallback localDanmakuEventCallback = this.C;
    if (localDanmakuEventCallback != null)
    {
      paramRIJBaseDanmaku = (DanmakuDetail)paramRIJBaseDanmaku.r();
      Intrinsics.checkExpressionValueIsNotNull(paramRIJBaseDanmaku, "danmaku.data");
      localDanmakuEventCallback.onDanmakuClicked(paramRIJBaseDanmaku);
    }
  }
  
  private final boolean d(RIJBaseDanmaku paramRIJBaseDanmaku)
  {
    return Intrinsics.areEqual(((DanmakuDetail)paramRIJBaseDanmaku.r()).a().a(), "danmukaipin");
  }
  
  private final long m()
  {
    long l3 = System.currentTimeMillis();
    if (l3 - this.k > 'È')
    {
      IPlayer localIPlayer = this.c;
      long l1;
      if (localIPlayer != null) {
        l1 = localIPlayer.getCurrentPosition();
      } else {
        l1 = 0L;
      }
      localIPlayer = this.c;
      long l2;
      if (localIPlayer != null) {
        l2 = localIPlayer.getDuration();
      } else {
        l2 = 0L;
      }
      localIPlayer = this.c;
      if (localIPlayer != null)
      {
        long l4 = 2000;
        if ((l1 < l4) && (l2 > 0L) && (this.j > localIPlayer.getDuration() - l4))
        {
          this.b.w();
          b(0);
        }
      }
      if ((this.i) && (a(l1)))
      {
        this.i = false;
        b((int)(l1 / 1000));
      }
      this.e.a((int)(l1 / 1000));
      this.k = l3;
      this.j = l1;
    }
    return this.j;
  }
  
  private final int n()
  {
    return this.B.a() * this.f.c();
  }
  
  private final void o()
  {
    Object localObject = new int[2];
    this.d.getLocationOnScreen((int[])localObject);
    int i1 = localObject[0];
    int i2 = localObject[1] - this.m;
    this.l = new Rect(i1, i2, this.d.getWidth() + i1, this.n + i2);
    this.h.bringToFront();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("calculateTouchRect: touchRect=");
      ((StringBuilder)localObject).append(this.l);
      QLog.d("RIJDanmakuManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private final View p()
  {
    if (this.A) {
      return (View)new TextureView(this.y);
    }
    return (View)new SurfaceView(this.y);
  }
  
  private final boolean q()
  {
    IPlayer localIPlayer = this.c;
    long l1;
    if (localIPlayer != null) {
      l1 = localIPlayer.getCurrentPosition();
    } else {
      l1 = 0L - this.B.i();
    }
    return l1 > 1000;
  }
  
  public void a() {}
  
  public void a(float paramFloat)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSpeedRatio: ");
      localStringBuilder.append(paramFloat);
      QLog.d("RIJDanmakuManager", 2, localStringBuilder.toString());
    }
    if (paramFloat > 0) {
      this.b.a(paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("seekTo: ");
      localStringBuilder.append(paramInt);
      QLog.d("RIJDanmakuManager", 2, localStringBuilder.toString());
    }
    this.i = true;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.m = paramInt1;
    this.n = paramInt2;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setDanamkuTouchArea: marginTop=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", videoHeight=");
      localStringBuilder.append(paramInt2);
      QLog.d("RIJDanmakuManager", 2, localStringBuilder.toString());
    }
  }
  
  public void a(@NotNull ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "container");
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("attachContainer: ");
      ((StringBuilder)localObject).append(paramViewGroup);
      ((StringBuilder)localObject).append(", hasDanmaku: ");
      ((StringBuilder)localObject).append(this.q);
      QLog.d("RIJDanmakuManager", 2, ((StringBuilder)localObject).toString());
    }
    if (!this.q)
    {
      this.r = paramViewGroup;
      return;
    }
    if ((Intrinsics.areEqual(paramViewGroup, this.d.getParent()) ^ true))
    {
      ViewParent localViewParent = this.d.getParent();
      localObject = localViewParent;
      if (!(localViewParent instanceof ViewGroup)) {
        localObject = null;
      }
      localObject = (ViewGroup)localObject;
      if (localObject != null) {
        ((ViewGroup)localObject).removeView(this.d);
      }
      paramViewGroup.addView(this.d);
    }
    paramViewGroup.post((Runnable)new RIJDanmakuManager.attachContainer.1(this, paramViewGroup));
    this.r = ((ViewGroup)null);
  }
  
  public void a(@Nullable BaseDanmaku<?, ?> paramBaseDanmaku, @NotNull TouchPoint paramTouchPoint, @Nullable ClickResult paramClickResult)
  {
    Intrinsics.checkParameterIsNotNull(paramTouchPoint, "touchPoint");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClickEvent: danmaku=");
      localStringBuilder.append(paramBaseDanmaku);
      localStringBuilder.append(", TouchPoint=");
      localStringBuilder.append(paramTouchPoint);
      localStringBuilder.append(", clickResult=");
      localStringBuilder.append(paramClickResult);
      localStringBuilder.append(", clickEnable=");
      localStringBuilder.append(this.p);
      QLog.d("RIJDanmakuManager", 2, localStringBuilder.toString());
    }
    if (!this.p) {
      return;
    }
    o();
    if (!(paramBaseDanmaku instanceof RIJBaseDanmaku)) {
      paramClickResult = null;
    } else {
      paramClickResult = paramBaseDanmaku;
    }
    if ((RIJBaseDanmaku)paramClickResult != null) {
      if (Intrinsics.areEqual(this.x, paramBaseDanmaku))
      {
        paramClickResult = (RIJBaseDanmaku)paramBaseDanmaku;
        if (paramClickResult.b(paramTouchPoint))
        {
          a(paramClickResult);
          paramClickResult.f(false);
          this.b.a(paramBaseDanmaku);
          if (this.b.y()) {
            this.b.z();
          }
        }
      }
      else
      {
        paramBaseDanmaku = (RIJBaseDanmaku)paramBaseDanmaku;
        if (!d(paramBaseDanmaku))
        {
          paramTouchPoint = this.x;
          if (paramTouchPoint != null) {
            b(paramTouchPoint);
          }
          this.x = paramBaseDanmaku;
          c(paramBaseDanmaku);
        }
      }
    }
  }
  
  public void a(@NotNull DanmakuDetail paramDanmakuDetail)
  {
    Intrinsics.checkParameterIsNotNull(paramDanmakuDetail, "data");
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addDanmakuNow: ");
      ((StringBuilder)localObject).append(paramDanmakuDetail);
      QLog.d("RIJDanmakuManager", 2, ((StringBuilder)localObject).toString());
    }
    if (!this.q)
    {
      this.q = true;
      localObject = this.r;
      if (localObject != null) {
        a((ViewGroup)localObject);
      }
    }
    int i1 = b(paramDanmakuDetail);
    paramDanmakuDetail = this.b.a(i1, paramDanmakuDetail);
    Intrinsics.checkExpressionValueIsNotNull(paramDanmakuDetail, "baseDanmaku");
    paramDanmakuDetail.e(true);
    this.b.b(paramDanmakuDetail);
  }
  
  public void a(@Nullable IPlayer paramIPlayer)
  {
    this.c = paramIPlayer;
  }
  
  public void a(@NotNull RIJDanmakuConfig paramRIJDanmakuConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJDanmakuConfig, "newConfig");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("changeConfig: config=");
      localStringBuilder.append(this.B);
      localStringBuilder.append(", newConfig=");
      localStringBuilder.append(paramRIJDanmakuConfig);
      QLog.d("RIJDanmakuManager", 2, localStringBuilder.toString());
    }
    if ((Intrinsics.areEqual(this.B, paramRIJDanmakuConfig) ^ true))
    {
      this.B = paramRIJDanmakuConfig;
      b(paramRIJDanmakuConfig);
      this.b.h();
    }
  }
  
  public void a(@Nullable Boolean paramBoolean)
  {
    this.b.a(paramBoolean);
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    this.w = paramString;
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("setCurrentAuthorUin: ");
      paramString.append(this.w);
      QLog.d("RIJDanmakuManager", 2, paramString.toString());
    }
  }
  
  public void a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowkey");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start: rowkey=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", position=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(' ');
      QLog.d("RIJDanmakuManager", 2, localStringBuilder.toString());
    }
    this.b.a(paramInt * 1000);
    this.e.a(paramString, paramInt);
  }
  
  public void a(@Nullable List<BaseDanmaku<Object, IDanmakuUIConfig>> paramList) {}
  
  public void a(@NotNull List<DanmakuDetail> paramList, @NotNull ArrayList<ReportInfo> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, @NotNull String paramString, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "list");
    Intrinsics.checkParameterIsNotNull(paramArrayList, "reportInfoList");
    Intrinsics.checkParameterIsNotNull(paramString, "openText");
    if (paramBoolean2) {
      this.b.w();
    }
    paramBoolean2 = this.q;
    int i3 = 1;
    Object localObject;
    if ((!paramBoolean2) && ((((Collection)paramList).isEmpty() ^ true)))
    {
      this.q = true;
      localObject = this.r;
      if (localObject != null) {
        a((ViewGroup)localObject);
      }
    }
    int i2 = i3;
    if (this.t)
    {
      this.t = false;
      long l1 = 0L;
      i2 = i3;
      if (paramLong > 0L)
      {
        int i1;
        if (((CharSequence)paramString).length() > 0) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        i2 = i3;
        if (i1 != 0)
        {
          paramBoolean2 = q();
          localObject = this.c;
          paramLong = l1;
          if (localObject != null) {
            paramLong = ((IPlayer)localObject).getCurrentPosition();
          }
          l1 = this.B.i();
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onGetData: need show open text first, isOutTime ");
            ((StringBuilder)localObject).append(paramBoolean2);
            ((StringBuilder)localObject).append(", ");
            ((StringBuilder)localObject).append("guide time ");
            ((StringBuilder)localObject).append(this.B.i());
            ((StringBuilder)localObject).append(", curPosition ");
            ((StringBuilder)localObject).append(paramLong);
            ((StringBuilder)localObject).append(", player ");
            ((StringBuilder)localObject).append(this.c);
            QLog.d("RIJDanmakuManager", 2, ((StringBuilder)localObject).toString());
          }
          i2 = i3;
          if (!paramBoolean2)
          {
            this.u = ((Runnable)new RIJDanmakuManager.onGetData.2(this, paramString, paramList));
            this.o.postDelayed(this.u, l1 - paramLong);
            i2 = 0;
          }
        }
      }
    }
    if (i2 != 0) {
      b(paramList);
    }
    paramList = this.C;
    if (paramList != null) {
      paramList.onGetDanmakuData(paramBoolean1, paramArrayList);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDanmakuClicked: onDanmaku=");
      localStringBuilder.append(paramBoolean);
      QLog.d("RIJDanmakuManager", 2, localStringBuilder.toString());
    }
  }
  
  @NotNull
  public final String b()
  {
    return this.w;
  }
  
  public void b(@Nullable Boolean paramBoolean)
  {
    this.b.b(paramBoolean);
  }
  
  public void b(@NotNull List<DanmakuDetail> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "list");
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DanmakuDetail localDanmakuDetail = (DanmakuDetail)paramList.next();
      int i1 = b(localDanmakuDetail);
      BaseDanmaku localBaseDanmaku = this.b.a(i1, localDanmakuDetail);
      Intrinsics.checkExpressionValueIsNotNull(localBaseDanmaku, "baseDanmaku");
      localBaseDanmaku.g(localDanmakuDetail.a().e() * 1000);
      localArrayList.add(localBaseDanmaku);
    }
    this.b.a((List)localArrayList);
  }
  
  public void b(boolean paramBoolean)
  {
    WindowConfig localWindowConfig = DanmakuContext.a();
    Intrinsics.checkExpressionValueIsNotNull(localWindowConfig, "DanmakuContext.getWindowConfig()");
    localWindowConfig.d(paramBoolean);
  }
  
  @Nullable
  public final RIJBaseDanmaku c()
  {
    return this.x;
  }
  
  public void d()
  {
    try
    {
      if (this.d.getVisibility() == 0) {
        this.d.setVisibility(4);
      }
      this.h.setVisibility(8);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RIJDanmakuManager", 2, "hide: ", localThrowable);
      }
    }
  }
  
  public void e()
  {
    try
    {
      if (this.d.getVisibility() != 0) {
        this.d.setVisibility(0);
      }
      this.h.setVisibility(0);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RIJDanmakuManager", 2, "show: ", localThrowable);
      }
    }
  }
  
  public boolean f()
  {
    return this.d.getVisibility() == 0;
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RIJDanmakuManager", 2, "pause: ");
    }
    this.b.c();
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RIJDanmakuManager", 2, "restart: ");
    }
    this.b.b();
  }
  
  public void i()
  {
    k();
  }
  
  public void j()
  {
    D -= 1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("destroy: DANMAKU_COUNT=");
      ((StringBuilder)localObject).append(D);
      QLog.d("RIJDanmakuManager", 2, ((StringBuilder)localObject).toString());
    }
    this.b.g();
    this.e.b();
    ViewParent localViewParent = this.d.getParent();
    Object localObject = localViewParent;
    if (!(localViewParent instanceof ViewGroup)) {
      localObject = null;
    }
    localObject = (ViewGroup)localObject;
    if (localObject != null) {
      ((ViewGroup)localObject).removeView(this.d);
    }
    this.h.post((Runnable)new RIJDanmakuManager.destroy.1(this));
    this.o.removeCallbacksAndMessages(null);
  }
  
  public void k()
  {
    this.b.d();
    this.b.e();
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RIJDanmakuManager", 2, "cancelClick: ");
    }
    this.p = true;
    this.v.run();
  }
  
  public boolean onTouch(@Nullable View paramView, @NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
    if ((this.p) && (paramMotionEvent.getAction() == 0))
    {
      paramView = this.l;
      if ((paramView == null) || (paramView.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())))
      {
        paramView = new int[2];
        this.d.getLocationOnScreen(paramView);
        boolean bool3 = a(paramMotionEvent, paramView);
        boolean bool2 = true;
        boolean bool1 = true;
        if (bool3)
        {
          float f1 = paramMotionEvent.getRawX();
          float f2 = paramView[0];
          float f3 = paramMotionEvent.getRawY();
          float f4 = paramView[1];
          paramView = this.b.q();
          Intrinsics.checkExpressionValueIsNotNull(paramView, "danmakuManager.drawTimer");
          paramView = new TouchPoint(paramView.b(), new Point((int)(f1 - f2), (int)(f3 - f4)), 0);
          paramMotionEvent = this.b.a(paramView);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("onTouch: clickDanmakuView, candidateDanmaku=");
            localStringBuilder.append(paramMotionEvent);
            localStringBuilder.append(", clickedDanamku=");
            localStringBuilder.append(this.x);
            QLog.d("RIJDanmakuManager", 2, localStringBuilder.toString());
          }
          if (paramMotionEvent != null)
          {
            a(paramMotionEvent, paramView, null);
            return true;
          }
          if (this.x == null) {
            bool1 = false;
          }
          paramView = this.x;
          bool2 = bool1;
          if (paramView != null)
          {
            b(paramView);
            this.x = ((RIJBaseDanmaku)null);
            return bool1;
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            paramView = new StringBuilder();
            paramView.append("onTouch: clickVideoArea, clickedDanmaku=");
            paramView.append(this.x);
            QLog.d("RIJDanmakuManager", 2, paramView.toString());
          }
          if (this.x != null) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
          paramView = this.x;
          bool2 = bool1;
          if (paramView != null)
          {
            b(paramView);
            this.x = ((RIJBaseDanmaku)null);
            bool2 = bool1;
          }
        }
        return bool2;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.RIJDanmakuManager
 * JD-Core Version:    0.7.0.1
 */