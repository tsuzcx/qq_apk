import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/video/column/VideoColumnGuideManager$initLottieView$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationStart", "", "animation", "Landroid/animation/Animator;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ryr
  extends AnimatorListenerAdapter
{
  ryr(rym paramrym) {}
  
  public void onAnimationStart(@Nullable Animator paramAnimator)
  {
    rym.b(this.a, true);
    paramAnimator = rym.a(this.a);
    if (paramAnimator != null) {
      paramAnimator.pauseAnimation();
    }
    rym.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ryr
 * JD-Core Version:    0.7.0.1
 */