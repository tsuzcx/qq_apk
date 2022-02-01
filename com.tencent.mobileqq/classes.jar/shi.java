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
import com.tencent.biz.pubaccount.readinjoy.video.column.VideoColumnGuideManager.fetchGuideBgImg.1;
import com.tencent.biz.pubaccount.readinjoy.video.column.VideoColumnGuideManager.startGuideAnimate.1;
import com.tencent.biz.pubaccount.readinjoy.video.column.VideoColumnGuideManager.tryStartAnimate.1;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.mini.widget.media.danmu.DecelerateAccelerateInterpolator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/column/VideoColumnGuideManager;", "", "()V", "animateCount", "", "destroy", "", "edgeAnimator", "Landroid/animation/Animator;", "fullScreen", "getFullScreen", "()Z", "setFullScreen", "(Z)V", "guideBgImageBitmap", "Landroid/graphics/Bitmap;", "guideBgImgView", "Landroid/widget/ImageView;", "guideRootView", "Landroid/view/View;", "guideShowAnimator", "Landroid/view/ViewPropertyAnimator;", "imageReady", "lottieReady", "lottieView", "Lcom/tencent/mobileqq/dinifly/DiniFlyAnimationView;", "videoFeedsRootView", "dismissGuideRootView", "", "fetchGuideBgImg", "imageView", "initGuideBgImgView", "rootView", "initGuideRotView", "initLottieView", "needShowGuide", "onDestroy", "showGuide", "videoRootView", "showGuideRootView", "onAnimateEnd", "Lkotlin/Function0;", "startEdgeAnimate", "startGuideAnimate", "tryStartAnimate", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class shi
{
  public static final shj a;
  private int jdField_a_of_type_Int;
  private Animator jdField_a_of_type_AndroidAnimationAnimator;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private View jdField_a_of_type_AndroidViewView;
  private ViewPropertyAnimator jdField_a_of_type_AndroidViewViewPropertyAnimator;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
  static
  {
    jdField_a_of_type_Shj = new shj(null);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private final void a(View paramView)
  {
    paramView = (ViewStub)paramView.findViewById(2131380595);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = paramView.inflate();
    }
    paramView = this.jdField_a_of_type_AndroidViewView;
    if (paramView != null) {
      paramView.setOnTouchListener((View.OnTouchListener)new shm(this));
    }
  }
  
  private final void a(ImageView paramImageView)
  {
    paramImageView.post((Runnable)new VideoColumnGuideManager.fetchGuideBgImg.1(this));
  }
  
  private final void a(Function0<Unit> paramFunction0)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null)
    {
      localView.setAlpha(0.0F);
      localView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewViewPropertyAnimator = localView.animate().alpha(1.0F).setDuration(300L).setListener((Animator.AnimatorListener)new sho(this, paramFunction0));
      paramFunction0 = this.jdField_a_of_type_AndroidViewViewPropertyAnimator;
      if (paramFunction0 != null) {
        paramFunction0.start();
      }
    }
  }
  
  private final boolean a()
  {
    if (Aladdin.getConfig(326).getIntegerFromString("video_column_guide_open", 0) == 1) {}
    for (int i = 1;; i = 0)
    {
      int j = Aladdin.getConfig(326).getIntegerFromString("video_column_guide_day_interval", 1);
      if ((i == 0) || (!bmqa.a("video_column", j)) || (this.d)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private final void b()
  {
    if ((!this.jdField_b_of_type_Boolean) || (!this.c)) {
      return;
    }
    a((Function0)new VideoColumnGuideManager.tryStartAnimate.1(this));
  }
  
  private final void b(View paramView)
  {
    paramView = (ViewStub)paramView.findViewById(2131380593);
    if (this.jdField_a_of_type_AndroidWidgetImageView == null)
    {
      View localView = paramView.inflate();
      paramView = localView;
      if (!(localView instanceof ImageView)) {
        paramView = null;
      }
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView);
    }
  }
  
  private final void c()
  {
    Object localObject1 = this.jdField_b_of_type_AndroidViewView;
    if (localObject1 != null) {
      ((View)localObject1).clearAnimation();
    }
    Object localObject2 = this.jdField_b_of_type_AndroidViewView;
    if (localObject2 != null)
    {
      ((View)localObject2).setPivotY(((View)localObject2).getHeight() / 2.0F);
      ((View)localObject2).setPivotX(0.0F);
      localObject1 = ObjectAnimator.ofFloat(localObject2, "scaleX", new float[] { 1.0F, 0.96F, 1.0F });
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(localObject2, "scaleY", new float[] { 1.0F, 0.96F, 1.0F });
      localObject2 = ObjectAnimator.ofFloat(localObject2, "translationX", new float[] { 0.0F, -bggq.a(((View)localObject2).getContext(), 40.0F), 0.0F });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.setDuration(900L);
      localAnimatorSet.setInterpolator((TimeInterpolator)new DecelerateAccelerateInterpolator());
      localAnimatorSet.playTogether(new Animator[] { (Animator)localObject1, (Animator)localObjectAnimator, (Animator)localObject2 });
      localAnimatorSet.start();
      this.jdField_a_of_type_AndroidAnimationAnimator = ((Animator)localAnimatorSet);
    }
  }
  
  private final void c(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)paramView.findViewById(2131380594));
    paramView = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
    if (paramView != null)
    {
      paramView.setScaleXY(0.6F, 0.6F);
      paramView.setAnimationFromUrl("https://kd.qpic.cn/kamlin/assets/video_column_guide_lottie_1db0c59b.json");
      paramView.addAnimatorListener((Animator.AnimatorListener)new shn(this));
      paramView.playAnimation();
    }
  }
  
  private final void d()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 1.0F, 0.0F }).setDuration(300L);
      localObjectAnimator.addListener((Animator.AnimatorListener)new shk((View)localObject));
      localObjectAnimator.start();
    }
    localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setImageBitmap(null);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
    if ((localObject != null) && (((DiniFlyAnimationView)localObject).isAnimating() == true))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
      if (localObject != null) {
        ((DiniFlyAnimationView)localObject).cancelAnimation();
      }
    }
    localObject = this.jdField_a_of_type_AndroidAnimationAnimator;
    if ((localObject != null) && (((Animator)localObject).isRunning() == true))
    {
      localObject = this.jdField_a_of_type_AndroidAnimationAnimator;
      if (localObject != null) {
        ((Animator)localObject).cancel();
      }
    }
    localObject = this.jdField_b_of_type_AndroidViewView;
    if (localObject != null)
    {
      ((View)localObject).setTranslationX(0.0F);
      ((View)localObject).setScaleX(1.0F);
      ((View)localObject).setScaleY(1.0F);
    }
  }
  
  private final void e()
  {
    DiniFlyAnimationView localDiniFlyAnimationView = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
    if (localDiniFlyAnimationView != null) {
      localDiniFlyAnimationView.postDelayed((Runnable)new VideoColumnGuideManager.startGuideAnimate.1(this), 300L);
    }
  }
  
  public final void a()
  {
    this.jdField_a_of_type_Boolean = true;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
    if ((localObject != null) && (((DiniFlyAnimationView)localObject).isAnimating() == true))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
      if (localObject != null) {
        ((DiniFlyAnimationView)localObject).cancelAnimation();
      }
    }
    localObject = this.jdField_a_of_type_AndroidAnimationAnimator;
    if ((localObject != null) && (((Animator)localObject).isRunning() == true))
    {
      localObject = this.jdField_a_of_type_AndroidAnimationAnimator;
      if (localObject != null) {
        ((Animator)localObject).cancel();
      }
    }
    localObject = this.jdField_a_of_type_AndroidViewViewPropertyAnimator;
    if (localObject != null) {
      ((ViewPropertyAnimator)localObject).cancel();
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)null);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public final boolean a(@NotNull View paramView1, @NotNull View paramView2)
  {
    Intrinsics.checkParameterIsNotNull(paramView1, "rootView");
    Intrinsics.checkParameterIsNotNull(paramView2, "videoRootView");
    if (!a()) {
      return false;
    }
    this.jdField_b_of_type_AndroidViewView = paramView2;
    a(paramView1);
    b(paramView1);
    paramView1 = this.jdField_a_of_type_AndroidWidgetImageView;
    if (paramView1 != null) {
      a(paramView1);
    }
    paramView1 = this.jdField_a_of_type_AndroidViewView;
    if (paramView1 != null) {
      c(paramView1);
    }
    bmqa.l("video_column");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     shi
 * JD-Core Version:    0.7.0.1
 */