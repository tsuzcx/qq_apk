package com.tencent.mobileqq.kandian.biz.video.danmaku.render;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import com.tencent.common.danmaku.data.BaseDanmaku;
import com.tencent.common.danmaku.inject.DanmakuContext;
import com.tencent.common.danmaku.render.BaseDanmakuRender;
import com.tencent.common.danmaku.util.ContentSize;
import com.tencent.common.danmaku.util.DrawUtils;
import com.tencent.mobileqq.kandian.biz.video.danmaku.DanmakuDetail;
import com.tencent.mobileqq.kandian.biz.video.danmaku.DanmakuInfo;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/render/RIJDanmakuRender;", "Lcom/tencent/common/danmaku/render/BaseDanmakuRender;", "Lcom/tencent/common/danmaku/data/BaseDanmaku;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "clickStateBgPaint", "Landroid/graphics/Paint;", "clickStateReportPaint", "Landroid/text/TextPaint;", "clickStateReportTextWidth", "", "getContext", "()Landroid/content/Context;", "mineDanmukuPaint", "strokePaint", "textPaint", "accept", "", "danmaku", "getText", "", "measure", "Lcom/tencent/common/danmaku/util/ContentSize;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "danmakuContext", "Lcom/tencent/common/danmaku/inject/DanmakuContext;", "left", "top", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJDanmakuRender
  extends BaseDanmakuRender<BaseDanmaku<?, ?>>
{
  private final TextPaint a;
  private final TextPaint b;
  private final TextPaint c;
  private final Paint d;
  private final Paint e;
  private final float f;
  @NotNull
  private final Context g;
  
  public RIJDanmakuRender(@NotNull Context paramContext)
  {
    this.g = paramContext;
    this.a = new TextPaint();
    this.b = new TextPaint();
    this.c = new TextPaint();
    this.d = new Paint();
    this.e = new Paint();
    this.a.setTypeface(Typeface.SANS_SERIF);
    this.a.setAntiAlias(true);
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setStrokeWidth(RIJDanmakuUIConfig.a.a());
    this.b.setTypeface(Typeface.SANS_SERIF);
    this.b.setAntiAlias(true);
    this.d.setStyle(Paint.Style.FILL);
    this.d.setColor(RIJDanmakuUIConfig.a.m());
    this.c.setTextSize(RIJDanmakuUIConfig.a.k());
    this.c.setColor(RIJDanmakuUIConfig.a.l());
    this.e.setColor(RIJDanmakuUIConfig.a.e());
    this.e.setStrokeWidth(RIJDanmakuUIConfig.a.f());
    this.e.setStyle(Paint.Style.STROKE);
    this.f = DrawUtils.a(RIJDanmakuUIConfig.a.k(), RIJDanmakuUIConfig.a.j());
  }
  
  private final String d(BaseDanmaku<?, ?> paramBaseDanmaku)
  {
    Object localObject = paramBaseDanmaku.r();
    paramBaseDanmaku = localObject;
    if (!(localObject instanceof DanmakuDetail)) {
      paramBaseDanmaku = null;
    }
    paramBaseDanmaku = (DanmakuDetail)paramBaseDanmaku;
    if (paramBaseDanmaku != null)
    {
      paramBaseDanmaku = paramBaseDanmaku.a();
      if (paramBaseDanmaku != null)
      {
        paramBaseDanmaku = paramBaseDanmaku.d();
        if (paramBaseDanmaku != null) {
          return paramBaseDanmaku;
        }
      }
    }
    return "";
  }
  
  public boolean a(@Nullable BaseDanmaku<?, ?> paramBaseDanmaku)
  {
    return paramBaseDanmaku instanceof RIJBaseDanmaku;
  }
  
  @NotNull
  public ContentSize b(@NotNull BaseDanmaku<?, ?> paramBaseDanmaku)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseDanmaku, "danmaku");
    Object localObject = paramBaseDanmaku.c();
    if (localObject != null)
    {
      localObject = (RIJDanmakuUIConfig)localObject;
      RIJBaseDanmaku localRIJBaseDanmaku = (RIJBaseDanmaku)paramBaseDanmaku;
      float f2 = DrawUtils.a(((RIJDanmakuUIConfig)localObject).a(), d(paramBaseDanmaku));
      float f1 = DrawUtils.a(((RIJDanmakuUIConfig)localObject).a());
      if (localRIJBaseDanmaku.q() != 18)
      {
        f3 = f1;
        f4 = f2;
        if (localRIJBaseDanmaku.q() != 20) {}
      }
      else
      {
        f4 = f2 + RIJDanmakuUIConfig.a.b() * 2;
        f3 = f1 + RIJDanmakuUIConfig.a.c() * 2;
      }
      if (localRIJBaseDanmaku.q() != 19)
      {
        f1 = f3;
        f2 = f4;
        if (localRIJBaseDanmaku.q() != 20) {}
      }
      else
      {
        f4 += RIJDanmakuUIConfig.a.g() + RIJDanmakuUIConfig.a.i();
        f1 = f3;
        f2 = f4;
        if (f3 < RIJDanmakuUIConfig.a.h())
        {
          f1 = RIJDanmakuUIConfig.a.h();
          f2 = f4;
        }
      }
      localRIJBaseDanmaku.j(f2);
      localRIJBaseDanmaku.k(f1);
      float f4 = f1;
      float f3 = f2;
      if (localRIJBaseDanmaku.g())
      {
        localObject = paramBaseDanmaku;
        if (!(paramBaseDanmaku instanceof RIJBaseDanmaku)) {
          localObject = null;
        }
        paramBaseDanmaku = (RIJBaseDanmaku)localObject;
        f4 = f1;
        f3 = f2;
        if (paramBaseDanmaku != null)
        {
          f4 = f1;
          f3 = f2;
          if (paramBaseDanmaku.U() == true)
          {
            f3 = f2 + RIJDanmakuUIConfig.a.o() * 2;
            f4 = RIJDanmakuUIConfig.a.q() + RIJDanmakuUIConfig.a.t() + this.f;
            localRIJBaseDanmaku.l(RIJDanmakuUIConfig.a.o() + f4 + RIJDanmakuUIConfig.a.s());
            f2 = f3;
            if (localRIJBaseDanmaku.q() != 18) {
              f2 = f3 + (f4 + RIJDanmakuUIConfig.a.s());
            }
            f3 = f1;
            if (f1 < RIJDanmakuUIConfig.a.r()) {
              f3 = RIJDanmakuUIConfig.a.r();
            }
            f4 = f3 + RIJDanmakuUIConfig.a.p() * 2;
            f3 = f2;
          }
        }
      }
      localRIJBaseDanmaku.a(f4);
      localRIJBaseDanmaku.b(f3);
      return new ContentSize(f3, f4);
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.video.danmaku.render.RIJDanmakuUIConfig");
  }
  
  public void b(@NotNull Canvas paramCanvas, @NotNull BaseDanmaku<?, ?> paramBaseDanmaku, @Nullable DanmakuContext paramDanmakuContext, float paramFloat1, float paramFloat2)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    Intrinsics.checkParameterIsNotNull(paramBaseDanmaku, "danmaku");
    paramDanmakuContext = paramBaseDanmaku.c();
    if (paramDanmakuContext != null)
    {
      paramDanmakuContext = (RIJDanmakuUIConfig)paramDanmakuContext;
      RIJBaseDanmaku localRIJBaseDanmaku = (RIJBaseDanmaku)paramBaseDanmaku;
      this.a.setTextSize(paramDanmakuContext.a());
      this.a.setColor(paramDanmakuContext.b());
      this.b.setTextSize(paramDanmakuContext.a());
      this.b.setColor(paramDanmakuContext.c());
      float f2 = paramFloat2 - this.a.ascent();
      float f4;
      float f5;
      if (localRIJBaseDanmaku.g())
      {
        if (!(paramBaseDanmaku instanceof RIJBaseDanmaku)) {
          paramDanmakuContext = null;
        } else {
          paramDanmakuContext = paramBaseDanmaku;
        }
        paramDanmakuContext = (RIJBaseDanmaku)paramDanmakuContext;
        if ((paramDanmakuContext != null) && (paramDanmakuContext.U() == true))
        {
          paramCanvas.drawRoundRect(new RectF(paramFloat1, paramFloat2, localRIJBaseDanmaku.e() + paramFloat1, localRIJBaseDanmaku.d() + paramFloat2), RIJDanmakuUIConfig.a.n(), RIJDanmakuUIConfig.a.n(), this.d);
          if (localRIJBaseDanmaku.q() != 18)
          {
            f1 = localRIJBaseDanmaku.e() + paramFloat1 - RIJDanmakuUIConfig.a.o();
            f3 = (localRIJBaseDanmaku.d() - RIJDanmakuUIConfig.a.k()) / 2;
            f4 = this.c.ascent();
            paramCanvas.drawText(RIJDanmakuUIConfig.a.j(), f1 - this.f, f3 + paramFloat2 - f4, (Paint)this.c);
          }
          else
          {
            f1 = paramFloat1;
          }
          paramDanmakuContext = this.g.getResources().getDrawable(2130842716);
          f3 = this.f;
          f4 = RIJDanmakuUIConfig.a.t();
          f5 = RIJDanmakuUIConfig.a.q();
          float f6 = (localRIJBaseDanmaku.d() - RIJDanmakuUIConfig.a.r()) / 2;
          int i = (int)(f1 - f3 - f4 - f5);
          int j = (int)(f6 + paramFloat2);
          paramDanmakuContext.setBounds(i, j, RIJDanmakuUIConfig.a.q() + i, (int)RIJDanmakuUIConfig.a.r() + j);
          paramDanmakuContext.draw(paramCanvas);
          f3 = RIJDanmakuUIConfig.a.o();
          f1 = f2 + RIJDanmakuUIConfig.a.p();
          f2 = RIJDanmakuUIConfig.a.o();
          f5 = RIJDanmakuUIConfig.a.p();
          f2 = paramFloat1 + f2;
          f4 = f3 + paramFloat1;
          f3 = paramFloat2 + f5;
          paramFloat1 = f1;
          f1 = f4;
          paramFloat2 = f2;
          break label468;
        }
      }
      float f3 = paramFloat2;
      paramFloat2 = paramFloat1;
      float f1 = paramFloat1;
      paramFloat1 = f2;
      label468:
      if (localRIJBaseDanmaku.q() != 18)
      {
        f5 = paramFloat1;
        f2 = f1;
        f4 = paramFloat2;
        if (localRIJBaseDanmaku.q() != 20) {}
      }
      else
      {
        paramCanvas.drawRoundRect(new RectF(paramFloat2, f3, localRIJBaseDanmaku.S() + paramFloat2, localRIJBaseDanmaku.T() + f3), RIJDanmakuUIConfig.a.d(), RIJDanmakuUIConfig.a.d(), this.e);
        f2 = f1 + RIJDanmakuUIConfig.a.b();
        f5 = paramFloat1 + RIJDanmakuUIConfig.a.c();
        f4 = paramFloat2 + RIJDanmakuUIConfig.a.b();
      }
      if (localRIJBaseDanmaku.q() != 19)
      {
        paramFloat1 = f2;
        if (localRIJBaseDanmaku.q() != 20) {}
      }
      else
      {
        localRIJBaseDanmaku.T();
        RIJDanmakuUIConfig.a.h();
        paramDanmakuContext = this.g.getResources().getDrawable(2130842715);
        paramFloat1 = f3 + (localRIJBaseDanmaku.T() - RIJDanmakuUIConfig.a.h()) / 2;
        paramDanmakuContext.setBounds((int)f4, (int)paramFloat1, (int)(f4 + RIJDanmakuUIConfig.a.g()), (int)(paramFloat1 + RIJDanmakuUIConfig.a.h()));
        paramDanmakuContext.draw(paramCanvas);
        paramFloat1 = f2 + (RIJDanmakuUIConfig.a.g() + RIJDanmakuUIConfig.a.i());
        RIJDanmakuUIConfig.a.g();
        RIJDanmakuUIConfig.a.i();
      }
      paramCanvas.drawText(d(paramBaseDanmaku), paramFloat1, f5, (Paint)this.b);
      paramCanvas.drawText(d(paramBaseDanmaku), paramFloat1, f5, (Paint)this.a);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.video.danmaku.render.RIJDanmakuUIConfig");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.render.RIJDanmakuRender
 * JD-Core Version:    0.7.0.1
 */