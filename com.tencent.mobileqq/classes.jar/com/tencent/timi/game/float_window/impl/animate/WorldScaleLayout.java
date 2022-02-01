package com.tencent.timi.game.float_window.impl.animate;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Display;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.timi.game.ex.ViewExKt;
import com.tencent.timi.game.ui.utils.CommonAnimationUtil.SlideUpAnimation;
import com.tencent.timi.game.utils.DrawableUtil;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/float_window/impl/animate/WorldScaleLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "animating", "", "avatarDefaultListener", "Lcom/tencent/timi/game/float_window/impl/animate/WorldScaleLayout$AvatarListener;", "coverAlphaChangeRate", "", "coverColor", "", "cur3DPoint", "Lcom/tencent/timi/game/float_window/impl/animate/Vector3D;", "currentRectF", "Landroid/graphics/RectF;", "currentStatusInfo", "Lcom/tencent/timi/game/float_window/impl/animate/WorldScaleLayout$ScaleStatusInfo;", "h", "interpolator", "Landroid/view/animation/Interpolator;", "kotlin.jvm.PlatformType", "mScreenHeight", "mScreenWidth", "mWindowManager", "Landroid/view/WindowManager;", "maxWorldZ", "minWorldZ", "originAspectRatio", "paint", "Landroid/graphics/Paint;", "path", "Landroid/graphics/Path;", "preDrawBitmap", "Landroid/graphics/Bitmap;", "r2DPoint", "Lcom/tencent/timi/game/float_window/impl/animate/Vector2D;", "s3DPoint", "stage1CenterX", "stage1CenterY", "stage1Duration", "stage1MinScale", "stage1Progress", "stage1StartScale", "stage2CenterX", "stage2CenterY", "stage2Duration", "stage2MinScale", "stage2Progress", "stage2StartScale", "v3DPoint", "w", "world", "Lcom/tencent/timi/game/float_window/impl/animate/World;", "worldScaleListener", "Lcom/tencent/timi/game/float_window/impl/animate/WorldScaleLayout$WorldScaleListener;", "getWorldScaleListener", "()Lcom/tencent/timi/game/float_window/impl/animate/WorldScaleLayout$WorldScaleListener;", "setWorldScaleListener", "(Lcom/tencent/timi/game/float_window/impl/animate/WorldScaleLayout$WorldScaleListener;)V", "collapse", "", "draw", "canvas", "Landroid/graphics/Canvas;", "expand", "getStage1Animator", "Landroid/animation/ValueAnimator;", "from", "to", "getStage2Animator", "loadAvatarBitmap", "url", "listener", "loadPreDrawAvatar", "onLayoutFinish", "onSizeChanged", "oldw", "oldh", "refresh", "statusToRectF", "destRectF", "updateDestStatus", "destCenterX", "destCenterY", "destWidth", "updateStage1ScaleInfo", "progress", "updateStage2ScaleInfo", "AvatarListener", "ScaleStatusInfo", "WorldScaleListener", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class WorldScaleLayout
  extends FrameLayout
{
  private Vector3D A = new Vector3D();
  private Vector2D B = new Vector2D();
  private World C = new World();
  private float D = 100.0F;
  private float E;
  private long F = 4289111718L;
  private Bitmap G;
  private float H = 1.25F;
  @Nullable
  private WorldScaleLayout.WorldScaleListener I;
  private Paint J = new Paint();
  private WorldScaleLayout.AvatarListener K = (WorldScaleLayout.AvatarListener)new WorldScaleLayout.avatarDefaultListener.1();
  private final String a = "WorldScaleLayout";
  private WindowManager b;
  private int c;
  private int d;
  private long e = 300L;
  private long f = 400L;
  private Path g = new Path();
  private WorldScaleLayout.ScaleStatusInfo h = new WorldScaleLayout.ScaleStatusInfo(this);
  private RectF i = new RectF();
  private boolean j;
  private int k;
  private int l;
  private float m = 1.0F;
  private Interpolator n = CommonAnimationUtil.SlideUpAnimation.b;
  private int o;
  private int p;
  private float q = 1.0F;
  private float r = 0.7F;
  private float s = 1.0F;
  private int t;
  private int u;
  private float v = this.r;
  private float w = 0.25F;
  private float x = 1.0F;
  private Vector3D y = new Vector3D();
  private Vector3D z = new Vector3D();
  
  @JvmOverloads
  public WorldScaleLayout(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public WorldScaleLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public WorldScaleLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.g.setFillType(Path.FillType.EVEN_ODD);
    paramContext = paramContext.getSystemService("window");
    if (paramContext != null)
    {
      this.b = ((WindowManager)paramContext);
      paramContext = this.b;
      if (paramContext != null)
      {
        paramAttributeSet = paramContext.getDefaultDisplay();
        Intrinsics.checkExpressionValueIsNotNull(paramAttributeSet, "it.defaultDisplay");
        this.d = paramAttributeSet.getHeight();
        paramContext = paramContext.getDefaultDisplay();
        Intrinsics.checkExpressionValueIsNotNull(paramContext, "it.defaultDisplay");
        this.c = paramContext.getWidth();
      }
      setWillNotDraw(false);
      this.J.setColor(-65536);
      this.J.setAntiAlias(true);
      this.J.setStyle(Paint.Style.FILL);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
  }
  
  private final ValueAnimator a(float paramFloat1, float paramFloat2)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 });
    Intrinsics.checkExpressionValueIsNotNull(localValueAnimator, "ValueAnimator.ofFloat(from, to)");
    localValueAnimator.setDuration(this.e);
    localValueAnimator.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new WorldScaleLayout.getStage1Animator.1(this));
    localValueAnimator.addListener((Animator.AnimatorListener)new WorldScaleLayout.getStage1Animator.2(this, paramFloat1));
    return localValueAnimator;
  }
  
  private final void a(float paramFloat)
  {
    this.s = paramFloat;
    WorldScaleLayout.ScaleStatusInfo localScaleStatusInfo = this.h;
    float f1 = 1.0F - paramFloat;
    localScaleStatusInfo.b(RangesKt.coerceAtMost(this.H * f1, 1.0F));
    this.h.a(this.o);
    this.h.b(this.p);
    localScaleStatusInfo = this.h;
    float f2 = this.q;
    float f3 = this.r;
    localScaleStatusInfo.a((f2 - f3) * paramFloat + f3);
    this.h.d(f1);
    localScaleStatusInfo = this.h;
    paramFloat = this.m;
    localScaleStatusInfo.c((1.0F - paramFloat) * f1 + paramFloat);
    this.h.e(0.0F);
    c();
  }
  
  private final void a(int paramInt1, int paramInt2)
  {
    int i1 = ViewExKt.c(this);
    int i2 = ViewExKt.d(this);
    if (paramInt2 > 0) {
      this.m = (paramInt1 / paramInt2);
    }
    this.o = ((int)(i1 + paramInt1 * 0.5F));
    this.p = ((int)(i2 + paramInt2 * 0.5F));
    Vector3D localVector3D = this.y;
    paramInt1 = this.o;
    localVector3D.a = paramInt1;
    paramInt2 = this.p;
    localVector3D.b = paramInt2;
    localVector3D.c = this.E;
    localVector3D = this.z;
    localVector3D.a = paramInt1;
    localVector3D.b = paramInt2;
    localVector3D.c = this.D;
    this.C.a(localVector3D, this.w / this.v);
  }
  
  private final void a(WorldScaleLayout.ScaleStatusInfo paramScaleStatusInfo, RectF paramRectF)
  {
    float f1 = paramScaleStatusInfo.c() * this.k * 0.5F;
    float f2 = paramScaleStatusInfo.c() * this.k / paramScaleStatusInfo.e() * 0.5F;
    paramRectF.left = (paramScaleStatusInfo.a() - f1);
    paramRectF.right = (paramScaleStatusInfo.a() + f1);
    paramRectF.top = (paramScaleStatusInfo.b() - f2);
    paramRectF.bottom = (paramScaleStatusInfo.b() + f2);
  }
  
  private final void a(String paramString, WorldScaleLayout.AvatarListener paramAvatarListener)
  {
    paramString = URLDrawable.getDrawable(paramString, DrawableUtil.a.a(128, 2130853132));
    Intrinsics.checkExpressionValueIsNotNull(paramString, "drawable");
    Object localObject = paramString.getCurrDrawable();
    if ((localObject instanceof RegionDrawable))
    {
      localObject = ((RegionDrawable)localObject).getBitmap();
      if (localObject != null)
      {
        paramAvatarListener.a((Bitmap)localObject);
        return;
      }
    }
    paramString.setURLDrawableListener((URLDrawable.URLDrawableListener)new WorldScaleLayout.loadAvatarBitmap.1(paramString, paramAvatarListener));
    paramString.startDownload(true);
  }
  
  private final ValueAnimator b(float paramFloat1, float paramFloat2)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 });
    Intrinsics.checkExpressionValueIsNotNull(localValueAnimator, "ValueAnimator.ofFloat(from, to)");
    localValueAnimator.setDuration(this.f);
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new WorldScaleLayout.getStage2Animator.1(this));
    localValueAnimator.addListener((Animator.AnimatorListener)new WorldScaleLayout.getStage2Animator.2(this, paramFloat1));
    return localValueAnimator;
  }
  
  private final void b(float paramFloat)
  {
    this.x = paramFloat;
    Vector3D localVector3D = this.A;
    paramFloat = 1.0F - paramFloat;
    localVector3D.c = (this.D * paramFloat);
    localVector3D.b = ((this.z.b - this.y.b) * paramFloat + this.y.b);
    this.A.a = this.y.a;
    this.C.a(this.A, this.B);
    this.h.b(1.0F);
    this.h.a((int)this.B.a);
    this.h.b((int)this.B.b);
    this.h.a(this.v * this.B.c);
    this.h.e(paramFloat);
    this.h.d(1.0F);
    this.h.c(1.0F);
    c();
  }
  
  private final void c()
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      postInvalidateOnAnimation();
      return;
    }
    postInvalidate();
  }
  
  public final void a()
  {
    if (!this.j)
    {
      ValueAnimator localValueAnimator1 = a(1.0F, 0.0F);
      localValueAnimator1.setInterpolator((TimeInterpolator)new AccelerateInterpolator());
      ValueAnimator localValueAnimator2 = b(1.0F, 0.0F);
      localValueAnimator2.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playSequentially(new Animator[] { (Animator)localValueAnimator1, (Animator)localValueAnimator2 });
      localAnimatorSet.addListener((Animator.AnimatorListener)new WorldScaleLayout.collapse.1(this));
      localAnimatorSet.start();
    }
  }
  
  public final void a(float paramFloat1, float paramFloat2, float paramFloat3, @Nullable Bitmap paramBitmap)
  {
    this.t = ((int)paramFloat1);
    this.u = ((int)paramFloat2);
    this.w = (paramFloat3 / this.k);
    this.G = paramBitmap;
    paramBitmap = this.z;
    paramBitmap.a = this.t;
    paramBitmap.b = this.u;
    paramBitmap.c = this.D;
    this.C.a(paramBitmap, this.w / this.v);
  }
  
  public final void a(@Nullable String paramString)
  {
    if (!TextUtils.isEmpty((CharSequence)paramString)) {
      a(paramString, this.K);
    }
  }
  
  public final void b()
  {
    if (!this.j)
    {
      ValueAnimator localValueAnimator1 = b(0.0F, 1.0F);
      localValueAnimator1.setInterpolator((TimeInterpolator)new AccelerateInterpolator());
      ValueAnimator localValueAnimator2 = a(0.0F, 1.0F);
      localValueAnimator2.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.addListener((Animator.AnimatorListener)new WorldScaleLayout.expand.1(this));
      localAnimatorSet.playSequentially(new Animator[] { (Animator)localValueAnimator1, (Animator)localValueAnimator2 });
      localAnimatorSet.start();
    }
  }
  
  public void draw(@Nullable Canvas paramCanvas)
  {
    if (this.j)
    {
      a(this.h, this.i);
      float f1 = this.i.width() * 0.5F * this.h.f();
      this.g.reset();
      this.g.addRoundRect(this.i, f1, f1, Path.Direction.CW);
      if (paramCanvas != null) {
        paramCanvas.clipPath(this.g);
      }
      f1 = this.h.d();
      float f2 = 'ÿ';
      int i1 = Color.argb((int)(f1 * f2), 146, 146, 146);
      if (this.h.d() != 1.0F)
      {
        if (paramCanvas != null) {
          paramCanvas.scale(this.h.c(), this.h.c(), this.o, this.p);
        }
        super.draw(paramCanvas);
        if (paramCanvas != null) {
          paramCanvas.drawColor(i1);
        }
      }
      else
      {
        if (paramCanvas != null) {
          paramCanvas.drawColor(i1);
        }
        if (this.h.g() > 0.0F)
        {
          Bitmap localBitmap = this.G;
          if (localBitmap != null)
          {
            this.J.setAlpha((int)(this.h.g() * f2));
            if (paramCanvas != null) {
              paramCanvas.drawBitmap(localBitmap, null, this.i, this.J);
            }
          }
        }
      }
      if (paramCanvas != null) {
        paramCanvas.translate(this.h.a() - this.o, this.h.b() - this.p);
      }
    }
    else
    {
      super.draw(paramCanvas);
    }
  }
  
  @Nullable
  public final WorldScaleLayout.WorldScaleListener getWorldScaleListener()
  {
    return this.I;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.k = paramInt1;
    this.l = paramInt2;
    if (paramInt1 > 0) {
      a(paramInt1, paramInt2);
    }
  }
  
  public final void setWorldScaleListener(@Nullable WorldScaleLayout.WorldScaleListener paramWorldScaleListener)
  {
    this.I = paramWorldScaleListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.float_window.impl.animate.WorldScaleLayout
 * JD-Core Version:    0.7.0.1
 */