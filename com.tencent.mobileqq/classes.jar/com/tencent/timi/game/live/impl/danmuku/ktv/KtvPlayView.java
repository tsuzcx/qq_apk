package com.tencent.timi.game.live.impl.danmuku.ktv;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.timi.game.ex.LayoutExKt;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/live/impl/danmuku/ktv/KtvPlayView;", "Landroid/view/View;", "ctx", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "accentColor", "accentRectF", "Landroid/graphics/RectF;", "animator", "Landroid/animation/ValueAnimator;", "animatorListenerAdapter", "Lcom/tencent/timi/game/live/impl/danmuku/ktv/KtvPlayView$AnimatorListener;", "animatorUpdateListener", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "fontSize", "", "fontWidth", "isAnimating", "", "ktvFontColor", "ktvPlayController", "Lcom/tencent/timi/game/live/impl/danmuku/ktv/KtvPlayController$IKtvPlayController;", "ktvStr", "", "outlineColor", "paint", "Landroid/graphics/Paint;", "progress", "srcInXfermode", "Landroid/graphics/PorterDuffXfermode;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "playKtv", "ktv", "release", "setKtvPlayController", "controller", "startKtvAnimation", "resetAccent", "resetBasic", "resetFont", "resetOutline", "AnimatorListener", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class KtvPlayView
  extends View
{
  public static final KtvPlayView.Companion a = new KtvPlayView.Companion(null);
  private static final Typeface q = Typeface.DEFAULT_BOLD;
  private KtvPlayController.IKtvPlayController b;
  private final PorterDuffXfermode c = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
  private String d = "";
  private float e = -1.0F;
  private int f = Color.parseColor("#33BBFA");
  private int g = -16777216;
  private int h = -1;
  private float i = LayoutExKt.a(12);
  private float j;
  private final RectF k = new RectF();
  private final Paint l;
  private final ValueAnimator m;
  private final ValueAnimator.AnimatorUpdateListener n;
  private final KtvPlayView.AnimatorListener o;
  private boolean p;
  
  @JvmOverloads
  public KtvPlayView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public KtvPlayView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public KtvPlayView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = new Paint();
    paramContext.setAntiAlias(true);
    paramContext.setDither(true);
    this.l = paramContext;
    this.m = new ValueAnimator();
    this.n = ((ValueAnimator.AnimatorUpdateListener)new KtvPlayView.animatorUpdateListener.1(this));
    this.o = new KtvPlayView.AnimatorListener(this);
  }
  
  private final void a()
  {
    this.m.removeAllListeners();
    this.m.removeAllUpdateListeners();
    this.m.cancel();
    this.m.setFloatValues(new float[] { 0.0F, 1.0F });
    this.m.setDuration(7000L);
    this.m.addUpdateListener(this.n);
    this.m.addListener((Animator.AnimatorListener)this.o);
    this.m.start();
  }
  
  private final void a(@NotNull Paint paramPaint)
  {
    paramPaint.setAntiAlias(true);
    paramPaint.setDither(true);
    paramPaint.setXfermode((Xfermode)null);
    paramPaint.setFakeBoldText(false);
    paramPaint.setTypeface(Typeface.DEFAULT);
  }
  
  private final void b(@NotNull Paint paramPaint)
  {
    a(paramPaint);
    paramPaint.setColor(this.h);
    paramPaint.setTextSize(this.i);
    paramPaint.setStyle(Paint.Style.FILL);
    paramPaint.setFakeBoldText(true);
    paramPaint.setTypeface(q);
  }
  
  private final void c(@NotNull Paint paramPaint)
  {
    a(paramPaint);
    paramPaint.setColor(this.g);
    paramPaint.setTextSize(this.i);
    paramPaint.setStrokeWidth(1.0F);
    paramPaint.setTypeface(q);
    paramPaint.setFakeBoldText(true);
    paramPaint.setStyle(Paint.Style.STROKE);
  }
  
  private final void d(@NotNull Paint paramPaint)
  {
    a(paramPaint);
    paramPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    paramPaint.setColor(this.f);
    paramPaint.setXfermode((Xfermode)this.c);
    paramPaint.setTypeface(q);
    paramPaint.setFakeBoldText(true);
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "ktv");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ktv: ");
    localStringBuilder.append(paramString);
    Logger.b("KtvPlayView", localStringBuilder.toString());
    this.d = paramString;
    b(this.l);
    this.j = this.l.measureText(paramString);
    a();
  }
  
  protected void onDraw(@Nullable Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (paramCanvas != null)
    {
      if (this.e == -1.0F) {
        return;
      }
      int i1 = paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null, 31);
      b(this.l);
      float f1 = (getWidth() - this.j) / 2.0F;
      Object localObject = this.l.getFontMetrics();
      float f2 = ((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).top;
      paramCanvas.translate(f1, (getHeight() - f2) / 2.0F);
      paramCanvas.drawText(this.d, 0.0F, -((Paint.FontMetrics)localObject).top, this.l);
      c(this.l);
      paramCanvas.drawText(this.d, 0.0F, -((Paint.FontMetrics)localObject).top, this.l);
      d(this.l);
      localObject = this.k;
      ((RectF)localObject).set(0.0F, 0.0F, this.j * this.e, f2);
      paramCanvas.drawRect((RectF)localObject, this.l);
      paramCanvas.restoreToCount(i1);
    }
  }
  
  public final void setKtvPlayController(@NotNull KtvPlayController.IKtvPlayController paramIKtvPlayController)
  {
    Intrinsics.checkParameterIsNotNull(paramIKtvPlayController, "controller");
    this.b = paramIKtvPlayController;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.danmuku.ktv.KtvPlayView
 * JD-Core Version:    0.7.0.1
 */