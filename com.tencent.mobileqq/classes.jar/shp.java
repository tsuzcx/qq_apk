import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.column.VideoColumnGuideManager.startGuideAnimate.1;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/video/column/VideoColumnGuideManager$startGuideAnimate$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class shp
  extends AnimatorListenerAdapter
{
  public void onAnimationEnd(@Nullable Animator paramAnimator)
  {
    if (shi.a(this.a.this$0)) {
      return;
    }
    if (shi.a(this.a.this$0) >= 1)
    {
      shi.a(this.a.this$0);
      return;
    }
    paramAnimator = this.a.this$0;
    shi.a(paramAnimator, shi.a(paramAnimator) + 1);
    shi.c(this.a.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     shp
 * JD-Core Version:    0.7.0.1
 */