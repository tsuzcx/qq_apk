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
import com.tencent.mobileqq.danmaku.data.BaseDanmaku;
import com.tencent.mobileqq.danmaku.inject.DanmakuContext;
import com.tencent.mobileqq.danmaku.render.BaseDanmakuRender;
import com.tencent.mobileqq.danmaku.util.ContentSize;
import com.tencent.mobileqq.danmaku.util.DrawUtils;
import com.tencent.mobileqq.kandian.biz.video.danmaku.DanmakuDetail;
import com.tencent.mobileqq.kandian.biz.video.danmaku.DanmakuInfo;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/render/RIJDanmakuRender;", "Lcom/tencent/mobileqq/danmaku/render/BaseDanmakuRender;", "Lcom/tencent/mobileqq/danmaku/data/BaseDanmaku;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "clickStateBgPaint", "Landroid/graphics/Paint;", "clickStateReportPaint", "Landroid/text/TextPaint;", "clickStateReportTextWidth", "", "getContext", "()Landroid/content/Context;", "mineDanmukuPaint", "strokePaint", "textPaint", "accept", "", "danmaku", "getText", "", "measure", "Lcom/tencent/mobileqq/danmaku/util/ContentSize;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "danmakuContext", "Lcom/tencent/mobileqq/danmaku/inject/DanmakuContext;", "left", "top", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJDanmakuRender
  extends BaseDanmakuRender<BaseDanmaku<?, ?>>
{
  private final float jdField_a_of_type_Float;
  @NotNull
  private final Context jdField_a_of_type_AndroidContentContext;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint;
  private final TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private final Paint jdField_b_of_type_AndroidGraphicsPaint;
  private final TextPaint jdField_b_of_type_AndroidTextTextPaint;
  private final TextPaint c;
  
  public RIJDanmakuRender(@NotNull Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_b_of_type_AndroidTextTextPaint = new TextPaint();
    this.c = new TextPaint();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(Typeface.SANS_SERIF);
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidTextTextPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidTextTextPaint.setStrokeWidth(RIJDanmakuUIConfig.a.a());
    this.jdField_b_of_type_AndroidTextTextPaint.setTypeface(Typeface.SANS_SERIF);
    this.jdField_b_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(RIJDanmakuUIConfig.a.g());
    this.c.setTextSize(RIJDanmakuUIConfig.a.e());
    this.c.setColor(RIJDanmakuUIConfig.a.f());
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(RIJDanmakuUIConfig.a.c());
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(RIJDanmakuUIConfig.a.c());
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_Float = DrawUtils.a(RIJDanmakuUIConfig.a.e(), RIJDanmakuUIConfig.a.a());
  }
  
  private final String a(BaseDanmaku<?, ?> paramBaseDanmaku)
  {
    Object localObject = paramBaseDanmaku.a();
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
        paramBaseDanmaku = paramBaseDanmaku.b();
        if (paramBaseDanmaku != null) {
          return paramBaseDanmaku;
        }
      }
    }
    return "";
  }
  
  @NotNull
  public ContentSize a(@NotNull BaseDanmaku<?, ?> paramBaseDanmaku)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseDanmaku, "danmaku");
    Object localObject = paramBaseDanmaku.a();
    if (localObject != null)
    {
      localObject = (RIJDanmakuUIConfig)localObject;
      RIJBaseDanmaku localRIJBaseDanmaku = (RIJBaseDanmaku)paramBaseDanmaku;
      float f2 = DrawUtils.a(((RIJDanmakuUIConfig)localObject).a(), a(paramBaseDanmaku));
      float f1 = DrawUtils.a(((RIJDanmakuUIConfig)localObject).a());
      if (localRIJBaseDanmaku.a() != 18)
      {
        f3 = f1;
        f4 = f2;
        if (localRIJBaseDanmaku.a() != 20) {}
      }
      else
      {
        f4 = f2 + RIJDanmakuUIConfig.a.a() * 2;
        f3 = f1 + RIJDanmakuUIConfig.a.b() * 2;
      }
      if (localRIJBaseDanmaku.a() != 19)
      {
        f1 = f3;
        f2 = f4;
        if (localRIJBaseDanmaku.a() != 20) {}
      }
      else
      {
        f4 += RIJDanmakuUIConfig.a.d() + RIJDanmakuUIConfig.a.e();
        f1 = f3;
        f2 = f4;
        if (f3 < RIJDanmakuUIConfig.a.d())
        {
          f1 = RIJDanmakuUIConfig.a.d();
          f2 = f4;
        }
      }
      localRIJBaseDanmaku.j(f2);
      localRIJBaseDanmaku.k(f1);
      float f4 = f1;
      float f3 = f2;
      if (localRIJBaseDanmaku.a())
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
          if (paramBaseDanmaku.i() == true)
          {
            f3 = f2 + RIJDanmakuUIConfig.a.h() * 2;
            f4 = RIJDanmakuUIConfig.a.j() + RIJDanmakuUIConfig.a.l() + this.jdField_a_of_type_Float;
            localRIJBaseDanmaku.l(RIJDanmakuUIConfig.a.h() + f4 + RIJDanmakuUIConfig.a.k());
            f2 = f3;
            if (localRIJBaseDanmaku.a() != 18) {
              f2 = f3 + (f4 + RIJDanmakuUIConfig.a.k());
            }
            f3 = f1;
            if (f1 < RIJDanmakuUIConfig.a.g()) {
              f3 = RIJDanmakuUIConfig.a.g();
            }
            f4 = f3 + RIJDanmakuUIConfig.a.i() * 2;
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
  
  public boolean a(@Nullable BaseDanmaku<?, ?> paramBaseDanmaku)
  {
    return paramBaseDanmaku instanceof RIJBaseDanmaku;
  }
  
  public void b(@NotNull Canvas paramCanvas, @NotNull BaseDanmaku<?, ?> paramBaseDanmaku, @Nullable DanmakuContext paramDanmakuContext, float paramFloat1, float paramFloat2)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    Intrinsics.checkParameterIsNotNull(paramBaseDanmaku, "danmaku");
    paramDanmakuContext = paramBaseDanmaku.a();
    if (paramDanmakuContext != null)
    {
      paramDanmakuContext = (RIJDanmakuUIConfig)paramDanmakuContext;
      RIJBaseDanmaku localRIJBaseDanmaku = (RIJBaseDanmaku)paramBaseDanmaku;
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramDanmakuContext.a());
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(paramDanmakuContext.a());
      this.jdField_b_of_type_AndroidTextTextPaint.setTextSize(paramDanmakuContext.a());
      this.jdField_b_of_type_AndroidTextTextPaint.setColor(paramDanmakuContext.b());
      float f2 = paramFloat2 - this.jdField_a_of_type_AndroidTextTextPaint.ascent();
      float f4;
      float f5;
      if (localRIJBaseDanmaku.a())
      {
        if (!(paramBaseDanmaku instanceof RIJBaseDanmaku)) {
          paramDanmakuContext = null;
        } else {
          paramDanmakuContext = paramBaseDanmaku;
        }
        paramDanmakuContext = (RIJBaseDanmaku)paramDanmakuContext;
        if ((paramDanmakuContext != null) && (paramDanmakuContext.i() == true))
        {
          paramCanvas.drawRoundRect(new RectF(paramFloat1, paramFloat2, localRIJBaseDanmaku.b() + paramFloat1, localRIJBaseDanmaku.a() + paramFloat2), RIJDanmakuUIConfig.a.f(), RIJDanmakuUIConfig.a.f(), this.jdField_a_of_type_AndroidGraphicsPaint);
          if (localRIJBaseDanmaku.a() != 18)
          {
            f1 = localRIJBaseDanmaku.b() + paramFloat1 - RIJDanmakuUIConfig.a.h();
            f3 = (localRIJBaseDanmaku.a() - RIJDanmakuUIConfig.a.e()) / 2;
            f4 = this.c.ascent();
            paramCanvas.drawText(RIJDanmakuUIConfig.a.a(), f1 - this.jdField_a_of_type_Float, f3 + paramFloat2 - f4, (Paint)this.c);
          }
          else
          {
            f1 = paramFloat1;
          }
          paramDanmakuContext = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841799);
          f3 = this.jdField_a_of_type_Float;
          f4 = RIJDanmakuUIConfig.a.l();
          f5 = RIJDanmakuUIConfig.a.j();
          float f6 = (localRIJBaseDanmaku.a() - RIJDanmakuUIConfig.a.g()) / 2;
          int i = (int)(f1 - f3 - f4 - f5);
          int j = (int)(f6 + paramFloat2);
          paramDanmakuContext.setBounds(i, j, RIJDanmakuUIConfig.a.j() + i, (int)RIJDanmakuUIConfig.a.g() + j);
          paramDanmakuContext.draw(paramCanvas);
          f3 = RIJDanmakuUIConfig.a.h();
          f1 = f2 + RIJDanmakuUIConfig.a.i();
          f2 = RIJDanmakuUIConfig.a.h();
          f5 = RIJDanmakuUIConfig.a.i();
          f2 = paramFloat1 + f2;
          f4 = f3 + paramFloat1;
          f3 = paramFloat2 + f5;
          paramFloat1 = f1;
          f1 = f4;
          paramFloat2 = f2;
          break label467;
        }
      }
      float f3 = paramFloat2;
      paramFloat2 = paramFloat1;
      float f1 = paramFloat1;
      paramFloat1 = f2;
      label467:
      if (localRIJBaseDanmaku.a() != 18)
      {
        f5 = paramFloat1;
        f2 = f1;
        f4 = paramFloat2;
        if (localRIJBaseDanmaku.a() != 20) {}
      }
      else
      {
        paramCanvas.drawRoundRect(new RectF(paramFloat2, f3, localRIJBaseDanmaku.l() + paramFloat2, localRIJBaseDanmaku.m() + f3), RIJDanmakuUIConfig.a.b(), RIJDanmakuUIConfig.a.b(), this.jdField_b_of_type_AndroidGraphicsPaint);
        f2 = f1 + RIJDanmakuUIConfig.a.a();
        f5 = paramFloat1 + RIJDanmakuUIConfig.a.b();
        f4 = paramFloat2 + RIJDanmakuUIConfig.a.a();
      }
      if (localRIJBaseDanmaku.a() != 19)
      {
        paramFloat1 = f2;
        if (localRIJBaseDanmaku.a() != 20) {}
      }
      else
      {
        localRIJBaseDanmaku.m();
        RIJDanmakuUIConfig.a.d();
        paramDanmakuContext = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841798);
        paramFloat1 = f3 + (localRIJBaseDanmaku.m() - RIJDanmakuUIConfig.a.d()) / 2;
        paramDanmakuContext.setBounds((int)f4, (int)paramFloat1, (int)(f4 + RIJDanmakuUIConfig.a.d()), (int)(paramFloat1 + RIJDanmakuUIConfig.a.d()));
        paramDanmakuContext.draw(paramCanvas);
        paramFloat1 = f2 + (RIJDanmakuUIConfig.a.d() + RIJDanmakuUIConfig.a.e());
        RIJDanmakuUIConfig.a.d();
        RIJDanmakuUIConfig.a.e();
      }
      paramCanvas.drawText(a(paramBaseDanmaku), paramFloat1, f5, (Paint)this.jdField_b_of_type_AndroidTextTextPaint);
      paramCanvas.drawText(a(paramBaseDanmaku), paramFloat1, f5, (Paint)this.jdField_a_of_type_AndroidTextTextPaint);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.video.danmaku.render.RIJDanmakuUIConfig");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.render.RIJDanmakuRender
 * JD-Core Version:    0.7.0.1
 */