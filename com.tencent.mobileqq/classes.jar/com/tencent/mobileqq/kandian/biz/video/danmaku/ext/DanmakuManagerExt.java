package com.tencent.mobileqq.kandian.biz.video.danmaku.ext;

import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.danmaku.core.AbsWindow;
import com.tencent.mobileqq.danmaku.core.DanmakuManager;
import com.tencent.mobileqq.danmaku.data.BaseDanmaku;
import com.tencent.mobileqq.danmaku.inject.DanmakuContext;
import com.tencent.mobileqq.danmaku.tool.DanmakuDrawTimer;
import com.tencent.mobileqq.danmaku.tool.TouchPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/ext/DanmakuManagerExt;", "Lcom/tencent/mobileqq/danmaku/core/DanmakuManager;", "danmakuView", "Landroid/view/View;", "danmakuContext", "Lcom/tencent/mobileqq/danmaku/inject/DanmakuContext;", "(Landroid/view/View;Lcom/tencent/mobileqq/danmaku/inject/DanmakuContext;)V", "CLICK", "", "drawTimerExt", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/ext/DanmakuDrawTimerExt;", "handleTouchEventSync", "", "getHandleTouchEventSync", "()Z", "setHandleTouchEventSync", "(Z)V", "<set-?>", "isPaused", "needPauseOnUpdate", "updatePlayerTimeImmediately", "forceDrawOneFrame", "", "forceMeasure", "danmaku", "Lcom/tencent/mobileqq/danmaku/data/BaseDanmaku;", "getPlayerTime", "", "handelUpdate", "handleRelease", "handleSeek", "msg", "Landroid/os/Message;", "onClickDanmakuView", "point", "Lcom/tencent/mobileqq/danmaku/tool/TouchPoint;", "onDanmakuViewCreated", "pause", "resume", "setPlayerSpeedRatio", "speedRatio", "", "start", "startTime", "updateFrame", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class DanmakuManagerExt
  extends DanmakuManager
{
  public static final DanmakuManagerExt.Companion a;
  private final int jdField_a_of_type_Int = 10;
  private final DanmakuDrawTimerExt jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuExtDanmakuDrawTimerExt = new DanmakuDrawTimerExt();
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuExtDanmakuManagerExt$Companion = new DanmakuManagerExt.Companion(null);
  }
  
  public DanmakuManagerExt(@Nullable View paramView, @Nullable DanmakuContext paramDanmakuContext)
  {
    super(paramView, paramDanmakuContext);
    this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawTimer = ((DanmakuDrawTimer)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuExtDanmakuDrawTimerExt);
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreAbsWindow.a((DanmakuDrawTimer)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuExtDanmakuDrawTimerExt);
  }
  
  @Nullable
  public final BaseDanmaku<?, ?> a(@NotNull TouchPoint paramTouchPoint)
  {
    Intrinsics.checkParameterIsNotNull(paramTouchPoint, "point");
    BaseDanmaku localBaseDanmaku = this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreAbsWindow.a(paramTouchPoint);
    if (localBaseDanmaku != null) {
      localBaseDanmaku.a(paramTouchPoint);
    }
    return localBaseDanmaku;
  }
  
  public final void a(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuExtDanmakuDrawTimerExt.a(paramFloat);
  }
  
  public void a(long paramLong)
  {
    super.a(paramLong);
    this.e = false;
    this.d = false;
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
      this.f = true;
    }
  }
  
  public void a(@Nullable BaseDanmaku<?, ?> paramBaseDanmaku)
  {
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreAbsWindow.b(paramBaseDanmaku);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public long b()
  {
    if (this.f)
    {
      DanmakuContext localDanmakuContext = this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext;
      Intrinsics.checkExpressionValueIsNotNull(localDanmakuContext, "mDanmakuContext");
      this.b = localDanmakuContext.a();
      this.f = false;
    }
    return super.b();
  }
  
  public void b()
  {
    super.b();
    this.e = false;
    this.d = false;
  }
  
  public void c()
  {
    super.c();
    this.d = true;
  }
  
  public final boolean e()
  {
    return this.d;
  }
  
  protected void i()
  {
    this.jdField_a_of_type_Boolean = false;
    super.i();
  }
  
  protected void j()
  {
    super.j();
    if (this.e) {
      c();
    }
  }
  
  protected void k()
  {
    super.k();
    p();
  }
  
  public void l()
  {
    super.l();
    if (this.d) {
      q();
    }
  }
  
  public final void q()
  {
    if (this.d)
    {
      super.b();
      this.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.ext.DanmakuManagerExt
 * JD-Core Version:    0.7.0.1
 */