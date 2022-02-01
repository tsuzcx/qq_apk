package com.tencent.mobileqq.kandian.biz.video.danmaku.ext;

import android.os.Message;
import android.view.View;
import com.tencent.common.danmaku.core.AbsWindow;
import com.tencent.common.danmaku.core.DanmakuManager;
import com.tencent.common.danmaku.data.BaseDanmaku;
import com.tencent.common.danmaku.inject.DanmakuContext;
import com.tencent.common.danmaku.render.IDanmakuView;
import com.tencent.common.danmaku.tool.DanmakuDrawTimer;
import com.tencent.common.danmaku.tool.TouchPoint;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/ext/DanmakuManagerExt;", "Lcom/tencent/common/danmaku/core/DanmakuManager;", "danmakuView", "Landroid/view/View;", "danmakuContext", "Lcom/tencent/common/danmaku/inject/DanmakuContext;", "(Landroid/view/View;Lcom/tencent/common/danmaku/inject/DanmakuContext;)V", "CLICK", "", "drawTimerExt", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/ext/DanmakuDrawTimerExt;", "handleTouchEventSync", "", "getHandleTouchEventSync", "()Z", "setHandleTouchEventSync", "(Z)V", "<set-?>", "isPaused", "needPauseOnUpdate", "updatePlayerTimeImmediately", "forceDrawOneFrame", "", "forceMeasure", "danmaku", "Lcom/tencent/common/danmaku/data/BaseDanmaku;", "getPlayerTime", "", "handelUpdate", "handleRelease", "handleSeek", "msg", "Landroid/os/Message;", "onClickDanmakuView", "point", "Lcom/tencent/common/danmaku/tool/TouchPoint;", "onDanmakuViewCreated", "pause", "resume", "setDisableSync", "forceVsync", "(Ljava/lang/Boolean;)V", "setPlayerSpeedRatio", "speedRatio", "", "setUseUiTime", "start", "startTime", "updateFrame", "uploadDanmaku", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class DanmakuManagerExt
  extends DanmakuManager
{
  public static final DanmakuManagerExt.Companion m = new DanmakuManagerExt.Companion(null);
  private final int n = 10;
  private final DanmakuDrawTimerExt o = new DanmakuDrawTimerExt();
  private boolean p;
  private boolean q;
  private boolean r;
  private boolean s;
  
  public DanmakuManagerExt(@Nullable View paramView, @Nullable DanmakuContext paramDanmakuContext)
  {
    super(paramView, paramDanmakuContext);
    this.b = ((DanmakuDrawTimer)this.o);
    this.j.a((DanmakuDrawTimer)this.o);
  }
  
  @Nullable
  public final BaseDanmaku<?, ?> a(@NotNull TouchPoint paramTouchPoint)
  {
    Intrinsics.checkParameterIsNotNull(paramTouchPoint, "point");
    BaseDanmaku localBaseDanmaku = this.j.a(paramTouchPoint);
    if (localBaseDanmaku != null) {
      localBaseDanmaku.a(paramTouchPoint);
    }
    return localBaseDanmaku;
  }
  
  public final void a(float paramFloat)
  {
    this.o.a(paramFloat);
  }
  
  public void a(long paramLong)
  {
    super.a(paramLong);
    this.r = false;
    this.q = false;
  }
  
  protected void a(@Nullable Message paramMessage)
  {
    super.a(paramMessage);
    if (paramMessage != null) {
      paramMessage = paramMessage.obj;
    } else {
      paramMessage = null;
    }
    if (paramMessage != null) {
      this.s = true;
    }
  }
  
  public void a(@Nullable BaseDanmaku<?, ?> paramBaseDanmaku)
  {
    this.j.b(paramBaseDanmaku);
  }
  
  public final void a(@Nullable Boolean paramBoolean)
  {
    if (paramBoolean != null)
    {
      paramBoolean.booleanValue();
      this.a.a(paramBoolean.booleanValue());
    }
  }
  
  public void b()
  {
    super.b();
    this.r = false;
    this.q = false;
  }
  
  public final void b(@Nullable Boolean paramBoolean)
  {
    if (paramBoolean != null)
    {
      paramBoolean.booleanValue();
      this.a.b(paramBoolean.booleanValue());
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public void c()
  {
    super.c();
    this.q = true;
  }
  
  protected void j()
  {
    this.c = false;
    super.j();
  }
  
  protected void k()
  {
    DanmakuContext localDanmakuContext = this.g;
    Intrinsics.checkExpressionValueIsNotNull(localDanmakuContext, "mDanmakuContext");
    int j = localDanmakuContext.l();
    localDanmakuContext = this.g;
    Intrinsics.checkExpressionValueIsNotNull(localDanmakuContext, "mDanmakuContext");
    int k = localDanmakuContext.l();
    int i = 0;
    while (i < j)
    {
      int i1 = this.i.size();
      super.k();
      i += k - (this.i.size() - i1);
    }
  }
  
  public long p()
  {
    if (this.s)
    {
      DanmakuContext localDanmakuContext = this.g;
      Intrinsics.checkExpressionValueIsNotNull(localDanmakuContext, "mDanmakuContext");
      this.f = localDanmakuContext.e();
      this.s = false;
    }
    return super.p();
  }
  
  protected void r()
  {
    super.r();
    if (this.r) {
      c();
    }
  }
  
  protected void s()
  {
    super.s();
    x();
  }
  
  public void t()
  {
    super.t();
    if (this.q) {
      z();
    }
  }
  
  public final boolean y()
  {
    return this.q;
  }
  
  public final void z()
  {
    if (this.q)
    {
      super.b();
      this.r = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.ext.DanmakuManagerExt
 * JD-Core Version:    0.7.0.1
 */