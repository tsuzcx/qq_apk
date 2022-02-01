import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.column.VideoColumnGuideManager.startGuideAnimate.1;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/video/column/VideoColumnGuideManager$startGuideAnimate$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ryt
  extends AnimatorListenerAdapter
{
  public void onAnimationEnd(@Nullable Animator paramAnimator)
  {
    if (rym.a(this.a.this$0)) {
      return;
    }
    if (rym.a(this.a.this$0) >= 1)
    {
      rym.a(this.a.this$0);
      return;
    }
    paramAnimator = this.a.this$0;
    rym.a(paramAnimator, rym.a(paramAnimator) + 1);
    rym.c(this.a.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ryt
 * JD-Core Version:    0.7.0.1
 */