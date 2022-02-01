import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/video/column/VideoColumnGuideManager$dismissGuideRootView$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "isReverse", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ryo
  extends AnimatorListenerAdapter
{
  ryo(View paramView) {}
  
  public void onAnimationEnd(@Nullable Animator paramAnimator, boolean paramBoolean)
  {
    this.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ryo
 * JD-Core Version:    0.7.0.1
 */