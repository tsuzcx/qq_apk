package com.tencent.timi.game.live.impl.danmuku;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.text.BoringLayout;
import android.text.BoringLayout.Metrics;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.TextPaint;
import com.tencent.common.danmaku.data.BaseDanmaku;
import com.tencent.common.danmaku.inject.DanmakuContext;
import com.tencent.common.danmaku.render.BaseDanmakuRender;
import com.tencent.common.danmaku.util.ContentSize;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.component.chat.util.EmotionCodecUtils;
import com.tencent.timi.game.ex.LayoutExKt;
import com.tencent.timi.game.live.impl.danmuku.danmaku.TimiDanmaku;
import com.tencent.timi.game.ui.utils.ResUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/live/impl/danmuku/DanmakuRender;", "Lcom/tencent/common/danmaku/render/BaseDanmakuRender;", "Lcom/tencent/timi/game/live/impl/danmuku/danmaku/TimiDanmaku;", "()V", "boringMetrics", "Landroid/text/BoringLayout$Metrics;", "cache", "com/tencent/timi/game/live/impl/danmuku/DanmakuRender$cache$1", "Lcom/tencent/timi/game/live/impl/danmuku/DanmakuRender$cache$1;", "selfDanmakuBgDrawable", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "textPaint", "Landroid/text/TextPaint;", "accept", "", "p0", "Lcom/tencent/common/danmaku/data/BaseDanmaku;", "generateTextLayout", "Landroid/text/Layout;", "text", "", "measure", "Lcom/tencent/common/danmaku/util/ContentSize;", "onDraw", "", "Landroid/graphics/Canvas;", "p1", "p2", "Lcom/tencent/common/danmaku/inject/DanmakuContext;", "p3", "", "p4", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class DanmakuRender
  extends BaseDanmakuRender<TimiDanmaku>
{
  public static final DanmakuRender.Companion a = new DanmakuRender.Companion(null);
  private final TextPaint b;
  private final BoringLayout.Metrics c;
  private final Drawable d;
  private final DanmakuRender.cache.1 e;
  
  public DanmakuRender()
  {
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setAntiAlias(true);
    localTextPaint.setDither(true);
    this.b = localTextPaint;
    this.c = new BoringLayout.Metrics();
    this.d = ResUtils.a(2130853046);
    this.e = new DanmakuRender.cache.1(5);
  }
  
  private final Layout a(String paramString, TextPaint paramTextPaint)
  {
    Object localObject = (Layout)this.e.get(paramString);
    if (localObject != null) {
      return localObject;
    }
    localObject = (CharSequence)new QQText((CharSequence)EmotionCodecUtils.c(paramString), 3, 20);
    float f = BoringLayout.getDesiredWidth((CharSequence)localObject, paramTextPaint);
    this.c.width = MathKt.roundToInt(f);
    this.c.leading = paramTextPaint.getFontMetricsInt().leading;
    this.c.top = paramTextPaint.getFontMetricsInt().top;
    this.c.ascent = paramTextPaint.getFontMetricsInt().ascent;
    this.c.descent = paramTextPaint.getFontMetricsInt().descent;
    this.c.bottom = paramTextPaint.getFontMetricsInt().bottom;
    paramTextPaint = BoringLayout.make((CharSequence)localObject, paramTextPaint, (int)f + 1, Layout.Alignment.ALIGN_NORMAL, 0.0F, 0.0F, this.c, false);
    localObject = (Map)this.e;
    Intrinsics.checkExpressionValueIsNotNull(paramTextPaint, "boringLayout");
    ((Map)localObject).put(paramString, paramTextPaint);
    return (Layout)paramTextPaint;
  }
  
  @NotNull
  public ContentSize a(@Nullable TimiDanmaku paramTimiDanmaku)
  {
    if (paramTimiDanmaku == null) {
      return new ContentSize(0.0F, 0.0F);
    }
    Object localObject = this.b;
    if ((paramTimiDanmaku.q() != 1) && (paramTimiDanmaku.q() != 2)) {
      f1 = 56.0F;
    } else {
      f1 = 12.0F;
    }
    BaseApplication localBaseApplication = BaseApplication.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localBaseApplication, "BaseApplication.getContext()");
    ((TextPaint)localObject).setTextSize(Utils.b(f1, localBaseApplication.getResources()));
    localObject = a(((DanmakuDataBean)paramTimiDanmaku.r()).a(), this.b);
    float f2 = ((Layout)localObject).getWidth();
    float f1 = f2;
    if (paramTimiDanmaku.q() == 2) {
      f1 = f2 + LayoutExKt.a(16);
    }
    float f3 = ((Layout)localObject).getHeight();
    f2 = f3;
    if (paramTimiDanmaku.q() == 2) {
      f2 = f3 + LayoutExKt.a(4);
    }
    f1 = (float)Math.ceil(f1);
    f2 = (float)Math.ceil(f2);
    paramTimiDanmaku.b(f1);
    paramTimiDanmaku.a(f2);
    return new ContentSize(f1, f2);
  }
  
  public void a(@Nullable Canvas paramCanvas, @Nullable TimiDanmaku paramTimiDanmaku, @Nullable DanmakuContext paramDanmakuContext, float paramFloat1, float paramFloat2)
  {
    if ((paramCanvas != null) && (paramTimiDanmaku != null))
    {
      paramDanmakuContext = this.b;
      float f;
      if ((paramTimiDanmaku.q() != 1) && (paramTimiDanmaku.q() != 2)) {
        f = 56.0F;
      } else {
        f = 12.0F;
      }
      BaseApplication localBaseApplication = BaseApplication.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localBaseApplication, "BaseApplication.getContext()");
      paramDanmakuContext.setTextSize(Utils.b(f, localBaseApplication.getResources()));
      int i = paramTimiDanmaku.q();
      if (i != 1)
      {
        if (i != 2)
        {
          paramCanvas.drawColor(-16711936);
          this.b.setStrokeWidth(5.0F);
          this.b.setStyle(Paint.Style.STROKE);
          this.b.setColor(-16777216);
          paramCanvas.drawText(((DanmakuDataBean)paramTimiDanmaku.r()).a(), paramFloat1, paramFloat2 - this.b.ascent(), (Paint)this.b);
          this.b.setStrokeWidth(3.0F);
          this.b.setStyle(Paint.Style.FILL_AND_STROKE);
          this.b.setColor(-1);
          paramCanvas.drawText(((DanmakuDataBean)paramTimiDanmaku.r()).a(), paramFloat1, paramFloat2 - this.b.ascent(), (Paint)this.b);
          return;
        }
        this.d.setBounds(LayoutExKt.b(3), LayoutExKt.b(3), (int)(paramTimiDanmaku.A() - LayoutExKt.a(3)), (int)(paramTimiDanmaku.B() - LayoutExKt.a(3)));
        this.d.draw(paramCanvas);
        this.b.setStyle(Paint.Style.FILL);
        this.b.setColor(-1);
        paramCanvas.save();
        paramCanvas.translate(paramFloat1 + LayoutExKt.a(8), paramFloat2 + LayoutExKt.a(2));
        a(((DanmakuDataBean)paramTimiDanmaku.r()).a(), this.b).draw(paramCanvas);
        paramCanvas.restore();
        return;
      }
      this.b.setStyle(Paint.Style.FILL);
      this.b.setColor(-1);
      paramCanvas.save();
      paramCanvas.translate(paramFloat1, paramFloat2);
      a(((DanmakuDataBean)paramTimiDanmaku.r()).a(), this.b).draw(paramCanvas);
      paramCanvas.restore();
    }
  }
  
  public boolean a(@Nullable BaseDanmaku<?, ?> paramBaseDanmaku)
  {
    return paramBaseDanmaku instanceof TimiDanmaku;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.danmuku.DanmakuRender
 * JD-Core Version:    0.7.0.1
 */