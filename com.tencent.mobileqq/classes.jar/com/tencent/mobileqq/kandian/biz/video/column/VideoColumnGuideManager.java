package com.tencent.mobileqq.kandian.biz.video.column;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.DecelerateAccelerateInterpolator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/column/VideoColumnGuideManager;", "", "()V", "animateCount", "", "destroy", "", "edgeAnimator", "Landroid/animation/Animator;", "fullScreen", "getFullScreen", "()Z", "setFullScreen", "(Z)V", "guideBgImageBitmap", "Landroid/graphics/Bitmap;", "guideBgImgView", "Landroid/widget/ImageView;", "guideRootView", "Landroid/view/View;", "guideShowAnimator", "Landroid/view/ViewPropertyAnimator;", "imageReady", "lottieReady", "lottieView", "Lcom/tencent/mobileqq/dinifly/DiniFlyAnimationView;", "videoFeedsRootView", "dismissGuideRootView", "", "fetchGuideBgImg", "imageView", "initGuideBgImgView", "rootView", "initGuideRotView", "initLottieView", "needShowGuide", "onDestroy", "showGuide", "videoRootView", "showGuideRootView", "onAnimateEnd", "Lkotlin/Function0;", "startEdgeAnimate", "startGuideAnimate", "tryStartAnimate", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoColumnGuideManager
{
  public static final VideoColumnGuideManager.Companion a = new VideoColumnGuideManager.Companion(null);
  private View b;
  private DiniFlyAnimationView c;
  private View d;
  private ImageView e;
  private Animator f;
  private ViewPropertyAnimator g;
  private Bitmap h;
  private int i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  
  @SuppressLint({"ClickableViewAccessibility"})
  private final void a(View paramView)
  {
    paramView = (ViewStub)paramView.findViewById(2131449508);
    if (this.b == null) {
      this.b = paramView.inflate();
    }
    paramView = this.b;
    if (paramView != null) {
      paramView.setOnTouchListener((View.OnTouchListener)new VideoColumnGuideManager.initGuideRotView.1(this));
    }
  }
  
  private final void a(ImageView paramImageView)
  {
    paramImageView.post((Runnable)new VideoColumnGuideManager.fetchGuideBgImg.1(this));
  }
  
  private final void a(Function0<Unit> paramFunction0)
  {
    View localView = this.b;
    if (localView != null)
    {
      localView.setAlpha(0.0F);
      localView.setVisibility(0);
      this.g = localView.animate().alpha(1.0F).setDuration(300L).setListener((Animator.AnimatorListener)new VideoColumnGuideManager.showGuideRootView..inlined.also.lambda.1(this, paramFunction0));
      paramFunction0 = this.g;
      if (paramFunction0 != null) {
        paramFunction0.start();
      }
    }
  }
  
  private final void b(View paramView)
  {
    paramView = (ViewStub)paramView.findViewById(2131449506);
    if (this.e == null)
    {
      View localView = paramView.inflate();
      paramView = localView;
      if (!(localView instanceof ImageView)) {
        paramView = null;
      }
      this.e = ((ImageView)paramView);
    }
  }
  
  private final boolean b()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(326);
    boolean bool2 = false;
    int n;
    if (localAladdinConfig.getIntegerFromString("video_column_guide_open", 0) == 1) {
      n = 1;
    } else {
      n = 0;
    }
    int i1 = Aladdin.getConfig(326).getIntegerFromString("video_column_guide_day_interval", 1);
    boolean bool1 = bool2;
    if (n != 0)
    {
      bool1 = bool2;
      if (ReadInJoyHelper.b("video_column", i1))
      {
        bool1 = bool2;
        if (!this.m) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private final void c()
  {
    if (this.k)
    {
      if (!this.l) {
        return;
      }
      a((Function0)new VideoColumnGuideManager.tryStartAnimate.1(this));
    }
  }
  
  private final void c(View paramView)
  {
    this.c = ((DiniFlyAnimationView)paramView.findViewById(2131449507));
    paramView = this.c;
    if (paramView != null)
    {
      paramView.setScaleXY(0.6F, 0.6F);
      paramView.setAnimationFromUrl("https://kd.qpic.cn/kamlin/assets/video_column_guide_lottie_1db0c59b.json");
      paramView.addAnimatorListener((Animator.AnimatorListener)new VideoColumnGuideManager.initLottieView..inlined.also.lambda.1(this));
      paramView.playAnimation();
    }
  }
  
  private final void d()
  {
    Object localObject1 = this.d;
    if (localObject1 != null) {
      ((View)localObject1).clearAnimation();
    }
    Object localObject2 = this.d;
    if (localObject2 != null)
    {
      ((View)localObject2).setPivotY(((View)localObject2).getHeight() / 2.0F);
      ((View)localObject2).setPivotX(0.0F);
      localObject1 = ObjectAnimator.ofFloat(localObject2, "scaleX", new float[] { 1.0F, 0.96F, 1.0F });
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(localObject2, "scaleY", new float[] { 1.0F, 0.96F, 1.0F });
      localObject2 = ObjectAnimator.ofFloat(localObject2, "translationX", new float[] { 0.0F, -DisplayUtil.a(((View)localObject2).getContext(), 40.0F), 0.0F });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.setDuration(900L);
      localAnimatorSet.setInterpolator((TimeInterpolator)new DecelerateAccelerateInterpolator());
      localAnimatorSet.playTogether(new Animator[] { (Animator)localObject1, (Animator)localObjectAnimator, (Animator)localObject2 });
      localAnimatorSet.start();
      this.f = ((Animator)localAnimatorSet);
    }
  }
  
  private final void e()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 1.0F, 0.0F }).setDuration(300L);
      localObjectAnimator.addListener((Animator.AnimatorListener)new VideoColumnGuideManager.dismissGuideRootView.1.1((View)localObject));
      localObjectAnimator.start();
    }
    localObject = this.e;
    if (localObject != null) {
      ((ImageView)localObject).setImageBitmap(null);
    }
    localObject = this.e;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.c;
    if ((localObject != null) && (((DiniFlyAnimationView)localObject).isAnimating() == true))
    {
      localObject = this.c;
      if (localObject != null) {
        ((DiniFlyAnimationView)localObject).cancelAnimation();
      }
    }
    localObject = this.f;
    if ((localObject != null) && (((Animator)localObject).isRunning() == true))
    {
      localObject = this.f;
      if (localObject != null) {
        ((Animator)localObject).cancel();
      }
    }
    localObject = this.d;
    if (localObject != null)
    {
      ((View)localObject).setTranslationX(0.0F);
      ((View)localObject).setScaleX(1.0F);
      ((View)localObject).setScaleY(1.0F);
    }
  }
  
  private final void f()
  {
    DiniFlyAnimationView localDiniFlyAnimationView = this.c;
    if (localDiniFlyAnimationView != null) {
      localDiniFlyAnimationView.postDelayed((Runnable)new VideoColumnGuideManager.startGuideAnimate.1(this), 300L);
    }
  }
  
  public final void a()
  {
    this.j = true;
    Object localObject = this.c;
    if ((localObject != null) && (((DiniFlyAnimationView)localObject).isAnimating() == true))
    {
      localObject = this.c;
      if (localObject != null) {
        ((DiniFlyAnimationView)localObject).cancelAnimation();
      }
    }
    localObject = this.f;
    if ((localObject != null) && (((Animator)localObject).isRunning() == true))
    {
      localObject = this.f;
      if (localObject != null) {
        ((Animator)localObject).cancel();
      }
    }
    localObject = this.g;
    if (localObject != null) {
      ((ViewPropertyAnimator)localObject).cancel();
    }
    this.h = ((Bitmap)null);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public final boolean a(@NotNull View paramView1, @NotNull View paramView2)
  {
    Intrinsics.checkParameterIsNotNull(paramView1, "rootView");
    Intrinsics.checkParameterIsNotNull(paramView2, "videoRootView");
    if (!b()) {
      return false;
    }
    this.d = paramView2;
    a(paramView1);
    b(paramView1);
    paramView1 = this.e;
    if (paramView1 != null) {
      a(paramView1);
    }
    paramView1 = this.b;
    if (paramView1 != null) {
      c(paramView1);
    }
    ReadInJoyHelper.k("video_column");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.column.VideoColumnGuideManager
 * JD-Core Version:    0.7.0.1
 */